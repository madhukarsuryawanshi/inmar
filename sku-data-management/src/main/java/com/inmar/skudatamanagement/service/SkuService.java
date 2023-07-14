package com.inmar.skudatamanagement.service;

import com.inmar.skudatamanagement.entity.LocationEntity;
import com.inmar.skudatamanagement.exceptions.DataNotFoundException;
import com.inmar.skudatamanagement.model.LocationModel;
import com.inmar.skudatamanagement.repository.SkuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SkuService {

    @Autowired
    private SkuRepository repository;

    public List<LocationModel> getAllLocations() {
        List<LocationEntity> locationEntities = repository.findAll();
        if(!CollectionUtils.isEmpty(locationEntities)) {
            return locationEntities
                    .stream()
                    .map(this::tranfofrmLocationModel)
                    .collect(Collectors.toList());
        } else {
            log.info("Data not found..");
            throw new DataNotFoundException("Data doesn't exist");
        }

    }
    public List<LocationModel> getLocationsDepartment(String locationId) {
        List<LocationEntity> locationsDepartments = repository.findByLocationIgnoreCaseContaining(locationId);
        if(!CollectionUtils.isEmpty(locationsDepartments)) {
            return locationsDepartments
                    .stream()
                    .map(this::tranfofrmLocationModel)
                    .collect(Collectors.toList());
        } else {
            log.info("Data not found for - {} ", locationId);
            throw new DataNotFoundException("Data Not found for id " + locationId);
        }


    }

    public List<LocationModel> getLocationsDepartmentCategory(String locationId, String departmentId) {
        List<LocationEntity> locationsDepartmentCategory = repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContaining(locationId, departmentId);
        if(!CollectionUtils.isEmpty(locationsDepartmentCategory)) {
            return locationsDepartmentCategory
                    .stream()
                    .map(this::tranfofrmLocationModel)
                    .collect(Collectors.toList());
        } else {
            log.info("Data not found for {} {} id ", locationId, departmentId);
            throw new DataNotFoundException("Data Not found for locationId: " + locationId + " departmentId: " + departmentId);
        }


    }

    public List<LocationModel> getLocationsDepartmentSubCategory(String locationId, String departmentId, String categoryId) {

        List<LocationEntity> matchedData = repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContaining(locationId, departmentId, categoryId);
        if(!CollectionUtils.isEmpty(matchedData)) {
            return matchedData
                .stream()
                    .map(this::tranfofrmLocationModel)
                    .collect(Collectors.toList());
        } else {
            log.info("Data not found for {}-, {}-, {}- id ", locationId, departmentId, categoryId);
            throw new DataNotFoundException("Data Not found for locationId: " + locationId + " departmentId: " + departmentId + " Category: " + categoryId );
        }



    }

    public List<LocationModel> getLocationsDepartmentSubCategoryId(String locationId, String departmentId, String categoryId, String subCategoryId) {
        List<LocationEntity> locationsDepartmentSubCategoryId = repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(locationId, departmentId, categoryId, subCategoryId);
        if(!CollectionUtils.isEmpty(locationsDepartmentSubCategoryId)) {
            return locationsDepartmentSubCategoryId
                    .stream()
                    .map(this::tranfofrmLocationModel)
                    .collect(Collectors.toList());
        } else {
            log.info("Data not found for {}, {}, {}, {} id ", locationId, departmentId, categoryId, subCategoryId);
            throw new DataNotFoundException("Data Not found for locationId: " + locationId + " departmentId: " + departmentId + " Category: " + categoryId + "Subcategory: " + subCategoryId);
        }


    }

    public List<LocationModel> getMetaData(String[] metaData) {
        String locationId = metaData[0];
        String departmentId = metaData[1];
        String categoryId = metaData[2];
        String subCategoryId = metaData[3];

        List<LocationEntity> matchedData = repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(locationId, departmentId, categoryId, subCategoryId);
        if(!CollectionUtils.isEmpty(matchedData)) {
            return matchedData
                .stream()
                    .map(this::tranfofrmLocationModel)
                    .collect(Collectors.toList());
        } else {
            log.info("Data not found for {}, {}, {}, {} id ", locationId, departmentId, categoryId, subCategoryId);
            throw new DataNotFoundException("Data Not found for locationId: " + locationId + " departmentId: " + departmentId + " Category: " + categoryId + "Subcategory: " + subCategoryId);
        }


    }

    private LocationModel tranfofrmLocationModel(LocationEntity locationEntity) {
        return new LocationModel(locationEntity.getSkuName(), locationEntity.getLocation(),locationEntity.getDepartment(),locationEntity.getCategory(), locationEntity.getSubCategory());
    }
}
