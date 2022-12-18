package org.yhao3.jhipsterlearning.repository.search;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.util.List;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.yhao3.jhipsterlearning.domain.Member;
import org.yhao3.jhipsterlearning.repository.MemberRepository;

/**
 * Spring Data Elasticsearch repository for the {@link Member} entity.
 */
public interface MemberSearchRepository extends ElasticsearchRepository<Member, Long>, MemberSearchRepositoryInternal {}

interface MemberSearchRepositoryInternal {
    Page<Member> search(String query, Pageable pageable);

    Page<Member> search(Query query);

    void index(Member entity);
}

class MemberSearchRepositoryInternalImpl implements MemberSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final MemberRepository repository;

    MemberSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate, MemberRepository repository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.repository = repository;
    }

    @Override
    public Page<Member> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        return search(nativeSearchQuery.setPageable(pageable));
    }

    @Override
    public Page<Member> search(Query query) {
        SearchHits<Member> searchHits = elasticsearchTemplate.search(query, Member.class);
        List<Member> hits = searchHits.map(SearchHit::getContent).stream().collect(Collectors.toList());
        return new PageImpl<>(hits, query.getPageable(), searchHits.getTotalHits());
    }

    @Override
    public void index(Member entity) {
        repository.findById(entity.getId()).ifPresent(elasticsearchTemplate::save);
    }
}
