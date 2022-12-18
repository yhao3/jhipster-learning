package org.yhao3.jhipsterlearning.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.yhao3.jhipsterlearning.domain.enumeration.Sex;

/**
 * The Member entity.\n@author yhao3
 */
@Schema(description = "The Member entity.\n@author yhao3")
@Entity
@Table(name = "member")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "member")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    /**
     * member name
     */
    @Schema(description = "member name", required = true)
    @NotNull
    @Column(name = "member_name", nullable = false)
    private String memberName;

    /**
     * member sex
     */
    @Schema(description = "member sex", required = true)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "sex", nullable = false)
    private Sex sex;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Member id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public Member memberName(String memberName) {
        this.setMemberName(memberName);
        return this;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Sex getSex() {
        return this.sex;
    }

    public Member sex(Sex sex) {
        this.setSex(sex);
        return this;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Member)) {
            return false;
        }
        return id != null && id.equals(((Member) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Member{" +
            "id=" + getId() +
            ", memberName='" + getMemberName() + "'" +
            ", sex='" + getSex() + "'" +
            "}";
    }
}
