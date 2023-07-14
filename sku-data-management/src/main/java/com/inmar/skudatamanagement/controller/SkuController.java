package com.inmar.skudatamanagement.controller;

import com.inmar.skudatamanagement.model.AuthenticationRequest;
import com.inmar.skudatamanagement.model.AuthenticationResponse;
import com.inmar.skudatamanagement.service.CredUserDetailService;
import com.inmar.skudatamanagement.service.SkuService;
import com.inmar.skudatamanagement.model.LocationModel;
import com.inmar.skudatamanagement.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping("/location")
    public ResponseEntity<List<LocationModel>> getAllLocations() {
        List<LocationModel> locations = skuService.getAllLocations();

        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/location/{location_id}/department")
    public ResponseEntity<List<LocationModel>> getLocationsDepartment(@PathVariable(name = "location_id") String locationId) {
        List<LocationModel> locationDepartments = skuService.getLocationsDepartment(locationId);

        return new ResponseEntity<>(locationDepartments, HttpStatus.OK);

    }

    @GetMapping("/location/{location_id}/department/{department_id}/category")
    public ResponseEntity<List<LocationModel>> getLocationsDepartmentCategory(@PathVariable(name = "location_id") String locationId, @PathVariable("department_id") String departmentId) {
        List<LocationModel> locationsDepartmentCategory = skuService.getLocationsDepartmentCategory(locationId, departmentId);

        return new ResponseEntity<>(locationsDepartmentCategory, HttpStatus.OK);

    }

    @GetMapping("/location/{location_id}/department/{department_id}/category/{category_id}/subcategory")
    public ResponseEntity<List<LocationModel>> getLocationsDepartmentCategorySubcategory(@PathVariable(name = "location_id") String locationId, @PathVariable("department_id") String departmentId, @PathVariable("category_id")String category) {
        List<LocationModel> locationsDepartmentSubCategory = skuService.getLocationsDepartmentSubCategory(locationId, departmentId, category);

        return new ResponseEntity<>(locationsDepartmentSubCategory, HttpStatus.OK);
    }

    @GetMapping("/location/{location_id}/department/{department_id}/category/{category_id}/subcategory/{subcategory_id}")
    public ResponseEntity<List<LocationModel>> getLocationsDepartmentCategorySubcategoryId(@PathVariable(name = "location_id") String locationId, @PathVariable("department_id") String departmentId, @PathVariable("category_id")String category, @PathVariable("subcategory_id") String subCategory) {
        List<LocationModel> locationsDepartmentSubCategoryId = skuService.getLocationsDepartmentSubCategoryId(locationId, departmentId, category, subCategory);

        return new ResponseEntity<>(locationsDepartmentSubCategoryId, HttpStatus.OK);

    }

    @GetMapping("/matchSkuData")
    public ResponseEntity<List<LocationModel>> getMetaData(@RequestParam("metaData") String[] metaData) {
        List<LocationModel> matchedData = skuService.getMetaData(metaData);

        return new ResponseEntity<>(matchedData, HttpStatus.OK);
    }


}
