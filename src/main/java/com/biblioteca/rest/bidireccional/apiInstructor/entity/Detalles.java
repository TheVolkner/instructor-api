package com.biblioteca.rest.bidireccional.apiInstructor.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "detalles")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Detalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String canalYoutube;


    private String pasatiempo;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Detalles detalles = (Detalles) o;
        return id != null && Objects.equals(id, detalles.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
