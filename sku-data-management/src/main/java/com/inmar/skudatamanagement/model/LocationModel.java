package com.inmar.skudatamanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationModel {
    private String id;
    private String location;
    private String department;
    private String category;
    private String subCategory;
}
