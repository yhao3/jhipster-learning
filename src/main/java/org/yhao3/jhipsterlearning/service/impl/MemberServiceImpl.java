package org.yhao3.jhipsterlearning.service.impl;

import static org.elasticsearch.index.query.QueryBuilders.*;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yhao3.jhipsterlearning.domain.Member;
import org.yhao3.jhipsterlearning.repository.MemberRepository;
import org.yhao3.jhipsterlearning.repository.search.MemberSearchRepository;
import org.yhao3.jhipsterlearning.service.MemberService;

/**
 * Service Implementation for managing {@link Member}.
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

    private final MemberRepository memberRepository;

    private final MemberSearchRepository memberSearchRepository;

    public MemberServiceImpl(MemberRepository memberRepository, MemberSearchRepository memberSearchRepository) {
        this.memberRepository = memberRepository;
        this.memberSearchRepository = memberSearchRepository;
    }

    @Override
    public Member save(Member member) {
        log.debug("Request to save Member : {}", member);
        Member result = memberRepository.save(member);
        memberSearchRepository.index(result);
        return result;
    }

    @Override
    public Member update(Member member) {
        log.debug("Request to update Member : {}", member);
        Member result = memberRepository.save(member);
        memberSearchRepository.index(result);
        return result;
    }

    @Override
    public Optional<Member> partialUpdate(Member member) {
        log.debug("Request to partially update Member : {}", member);

        return memberRepository
            .findById(member.getId())
            .map(existingMember -> {
                if (member.getMemberName() != null) {
                    existingMember.setMemberName(member.getMemberName());
                }
                if (member.getSex() != null) {
                    existingMember.setSex(member.getSex());
                }

                return existingMember;
            })
            .map(memberRepository::save)
            .map(savedMember -> {
                memberSearchRepository.save(savedMember);

                return savedMember;
            });
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> findAll(Pageable pageable) {
        log.debug("Request to get all Members");
        return memberRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Member> findOne(Long id) {
        log.debug("Request to get Member : {}", id);
        return memberRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Member : {}", id);
        memberRepository.deleteById(id);
        memberSearchRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Member> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Members for query {}", query);
        return memberSearchRepository.search(query, pageable);
    }
}
