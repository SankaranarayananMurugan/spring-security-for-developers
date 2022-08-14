package com.facadecode.spring.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.facadecode.spring.security.enums.PermissionEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "app_permission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AppPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private PermissionEnum name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
    @JsonIgnore
    private Set<AppRole> assignedRoles;
}
