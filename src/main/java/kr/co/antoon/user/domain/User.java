package kr.co.antoon.user.domain;

import kr.co.antoon.common.domain.BaseEntity;
import kr.co.antoon.user.domain.vo.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String email, String imageUrl, Role role) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.role = role;
    }

    public User update(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        return this;
    }
}