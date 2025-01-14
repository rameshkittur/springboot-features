package com.rameshkittur.Spring.Boot.Features.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class PostEntity extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
}
