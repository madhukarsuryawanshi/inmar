package com.inmar.skudatamanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SKU_TABLE")
public class LocationEntity implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer skuId;

    @Column
    private String skuName;
    @Column
    private String location;
    @Column
    private String department;
    @Column
    private String category;
    @Column
    private String subCategory;

}
