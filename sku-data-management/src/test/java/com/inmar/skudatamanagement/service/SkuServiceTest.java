package com.inmar.skudatamanagement.service;

import com.inmar.skudatamanagement.entity.LocationEntity;
import com.inmar.skudatamanagement.exceptions.DataNotFoundException;
import com.inmar.skudatamanagement.model.LocationModel;
import com.inmar.skudatamanagement.repository.SkuRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SkuServiceTest {
    @InjectMocks
    private SkuService skuService;

    @Mock
    private SkuRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.initMocks(skuService);
    }

    @Test
    public void getAllLocationsTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findAll()).thenReturn(locationModels);
        List<LocationModel> locationModel = skuService.getAllLocations();
        Assert.assertNotNull(locationModel);
    }

    @Test
    public void getAllLocationsWithNoDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findAll()).thenReturn(null);
        Assertions.assertThrows(DataNotFoundException.class, () ->{
            List<LocationModel> locationModel = skuService.getAllLocations();
            Assert.assertNotNull(locationModel);
        });

    }

    @Test
    public void getLocationsDepartmentTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContaining(Mockito.any())).thenReturn(locationModels);
        List<LocationModel> locationModel = skuService.getLocationsDepartment(Mockito.any());
        Assert.assertNotNull(locationModel);
    }

    @Test
    public void getLocationsDepartmentWithNoDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContaining(Mockito.any())).thenReturn(null);

        Assertions.assertThrows(DataNotFoundException.class, () ->{
            List<LocationModel> locationModel = skuService.getLocationsDepartment(Mockito.any());
            Assert.assertNotNull(locationModel);
        });
    }

    @Test
    public void getLocationsDepartmentCategoryTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContaining(Mockito.any(), Mockito.any())).thenReturn(locationModels);
        List<LocationModel> locationModel = skuService.getLocationsDepartmentCategory(Mockito.any(), Mockito.any());
        Assert.assertNotNull(locationModel);
    }

    @Test
    public void getLocationsDepartmentCategoryWithNoDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContaining(Mockito.any(), Mockito.any())).thenReturn(null);
        Assertions.assertThrows(DataNotFoundException.class, () ->{
            List<LocationModel> locationModel = skuService.getLocationsDepartmentCategory(Mockito.any(), Mockito.any());
            Assert.assertNotNull(locationModel);
        });

    }

    @Test
    public void getLocationsDepartmentSubCategoryTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContaining(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(locationModels);
        List<LocationModel> locationModel = skuService.getLocationsDepartmentSubCategory(Mockito.any(), Mockito.any(), Mockito.any());
        Assert.assertNotNull(locationModel);
    }

    @Test
    public void getLocationsDepartmentSubCategoryWithNoDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContaining(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);

        Assertions.assertThrows(DataNotFoundException.class, () -> {
            List<LocationModel> locationModel = skuService.getLocationsDepartmentSubCategory(Mockito.any(), Mockito.any(), Mockito.any());
            Assert.assertNotNull(locationModel);
        });

    }

    @Test
    public void getLocationsDepartmentSubCategoryIdTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(locationModels);
        List<LocationModel> locationModel = skuService.getLocationsDepartmentSubCategoryId(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
        Assert.assertNotNull(locationModel);
    }

    @Test
    public void getLocationsDepartmentSubCategoryIdWithNoDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);
        Assertions.assertThrows(DataNotFoundException.class, () -> {
            List<LocationModel> locationModel = skuService.getLocationsDepartmentSubCategoryId(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
            Assert.assertNotNull(locationModel);
        });

    }

    @Test
    public void getMetaDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(locationModels);
        String[] arr = {"Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers"};
        List<LocationModel> locationModel = skuService.getMetaData(arr);
        Assert.assertNotNull(locationModel);
    }

    @Test
    public void getMetaDataWithNoDataTest() {
        List<LocationEntity> locationModels = mockLocationModel();

        Mockito.when(repository.findByLocationIgnoreCaseContainingAndDepartmentIgnoreCaseContainingAndCategoryIgnoreCaseContainingAndSubCategoryIgnoreCaseContaining(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);
        String[] arr = {"Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers"};
        Assertions.assertThrows(DataNotFoundException.class, ()-> {
            List<LocationModel> locationModel = skuService.getMetaData(arr);
            Assert.assertNotNull(locationModel);
        });

    }

    private List<LocationEntity> mockLocationModel() {
        LocationEntity locationModel1 = new LocationEntity(1,"SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationEntity locationModel2 = new LocationEntity(2,"SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationEntity locationModel3 = new LocationEntity(3,"SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationEntity locationModel4 = new LocationEntity(4,"SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");

        return Arrays.asList(locationModel1, locationModel2, locationModel3, locationModel4);

    }

}
