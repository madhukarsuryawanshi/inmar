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
import java.util.Optional;
import java.util.Random;
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

    public LocationEntity addLocation(LocationModel locationModel) {
        LocationEntity locationEntity = transformLocationEntity(locationModel);

        LocationEntity saveLocationEntity = repository.save(locationEntity);
        return saveLocationEntity;
    }

    public LocationEntity updateLocation(LocationModel locationModel, Integer id) {
        return repository.findById(id).map(locationEntity-> {
            locationEntity = transformLocationEntity(locationModel);
            locationEntity.setSkuId(id);
            LocationEntity save = repository.save(locationEntity);
            return save;

        }).orElseThrow(() -> new DataNotFoundException("Id: " + id +" not available"));
    }

    public String deleteLocation(Integer id) {
        Optional<LocationEntity> locationEntity = repository.findById(id);

        if(locationEntity.isPresent()) {
            repository.delete(repository.findById(id).get());
            return "Record delete Successfully..";
        } else {
            log.info("ID: {} is not doesn't exist ", id);
            throw new DataNotFoundException("ID: "+ id + " doesn't exist");
        }
    }

    private LocationEntity transformLocationEntity(LocationModel locationModel) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setSkuName(locationModel.getId());
        locationEntity.setLocation(locationModel.getLocation());
        locationEntity.setDepartment(locationModel.getDepartment());
        locationEntity.setCategory(locationModel.getCategory());
        locationEntity.setSubCategory(locationModel.getSubCategory());
        return locationEntity;
    }




}
