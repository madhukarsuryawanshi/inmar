package com.inmar.skudatamanagement.controller;

import com.inmar.skudatamanagement.model.LocationModel;
import com.inmar.skudatamanagement.service.SkuService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SkuControllerTest {
    @InjectMocks
    private SkuController skuController;

    @Mock
    private SkuService skuService;

    private MockMvc mockMvc;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        MockitoAnnotations.initMocks(skuController);
        mockMvc = MockMvcBuilders.standaloneSetup(skuController).build();
    }

    @Test
    public void getAllLocationsTest() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getAllLocations()).thenReturn(locationModels);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*@Test
    public void getAllLocationsTestWithNoContent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    @Test
    public void getLocationsDepartmentTest() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartment(Mockito.any())).thenReturn(locationModels);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*@Test
    public void getLocationsDepartmentTestWithNoContent() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartment(Mockito.any())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    @Test
    public void getLocationsDepartmentCategoryTest() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartmentCategory(Mockito.any(), Mockito.any())).thenReturn(locationModels);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department/Floral/category"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*@Test
    public void getLocationsDepartmentCategoryTestWithNoData() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartmentCategory(Mockito.any(), Mockito.any())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department/Floral/category"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    @Test
    public void getLocationsDepartmentCategorySubcategoryTest() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartmentSubCategory(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(locationModels);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department/Floral/category/Bouquets and Cut Flowers/subcategory"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*@Test
    public void getLocationsDepartmentCategorySubcategoryTestWithNoData() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartmentSubCategory(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department/Floral/category/Bouquets and Cut Flowers/subcategory"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    @Test
    public void ggetLocationsDepartmentCategorySubcategoryIdTest() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartmentSubCategoryId(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(locationModels);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department/Floral/category/Bouquets and Cut Flowers/subcategory/Bouquets and Cut Flowers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*@Test
    public void ggetLocationsDepartmentCategorySubcategoryIdTestWithNoData() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getLocationsDepartmentSubCategoryId(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/location/Permiter/department/Floral/category/Bouquets and Cut Flowers/subcategory/Bouquets and Cut Flowers"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    @Test
    public void metaDataTest() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getMetaData(Mockito.any())).thenReturn(locationModels);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/matchSkuData?metaData=Permiter,Floral,Bouquets and Cut Flowers,Bouquets and Cut Flowers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*@Test
    public void metaDataTestWithNoData() throws Exception {
        List<LocationModel> locationModels = mockLocationModel();

        Mockito.when(skuService.getMetaData(Mockito.any())).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/matchSkuData?metaData=Permiter,Floral,Bouquets and Cut Flowers,Bouquets and Cut Flowers"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }*/

    private List<LocationModel> mockLocationModel() {
        LocationModel locationModel1 = new LocationModel("SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationModel locationModel2 = new LocationModel("SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationModel locationModel3 = new LocationModel("SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationModel locationModel4 = new LocationModel("SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");

        return Arrays.asList(locationModel1, locationModel2, locationModel3, locationModel4);

    }


}
