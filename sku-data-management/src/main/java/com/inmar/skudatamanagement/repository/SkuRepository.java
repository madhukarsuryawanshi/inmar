package com.inmar.skudatamanagement.repository;

import com.inmar.skudatamanagement.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface SkuRepository extends JpaRepository<LocationEntity, Integer> {
    List<LocationEntity> findByLocationIgnoreCaseContaining(String locationId);

    List<LocationEntity> findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContaining(String locationId, String departmentId);

    List<LocationEntity> findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContaining(String locationId, String departmentId, String categoryId);

    List<LocationEntity> findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(String locationId, String departmentId, String categoryId, String subCategoryId);
//    SkuModel findBySkuId(Integer id);
}
