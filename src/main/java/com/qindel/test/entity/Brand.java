package com.qindel.test.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brand", schema = "QINDEL")
public class Brand {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Price> products;

}
