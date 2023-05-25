package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); //하이버네이트가 감싸기 떄문에 초기화 이후에 가급적 건드리지 않는다. 즉 컬렉션은 필드에서 바로 초기화하는게 베스트
}
