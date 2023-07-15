package com.inmar.skudatamanagement.config;

import com.inmar.skudatamanagement.entity.LocationEntity;
import com.inmar.skudatamanagement.repository.SkuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class BulkStore implements CommandLineRunner {
    @Autowired
    private SkuRepository repository;

    @Override
    public void run(String... args) throws Exception {
        if(repository.count() <= 18) {
            Long count= buildObject().stream().map(e -> repository.save(e)).count();
            log.info("Total Count: {} ", count);
        }




    }

    private List<LocationEntity> buildObject() {

        LocationEntity l1 = new LocationEntity(1,"SKUDESC1","Permiter","Bakery","Bakery Bread","Bagels");
        LocationEntity l2 = new LocationEntity(2,"SKUDESC2","Permiter","Deli and Foodservice","Self Service Deli Cold","Beverages");
        LocationEntity l3 = new LocationEntity(3,"SKUDESC3","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationEntity l4= new LocationEntity(4,"SKUDESC4","Permiter","Deli and Foodservice","Service Deli","All Other");
        LocationEntity l5= new LocationEntity(5,"SKUDESC5","Center","Frozen","Frozen Bake","Bread or Dough Products Frozen");
        LocationEntity l6= new LocationEntity(6,"SKUDESC6","Center","Grocery","Crackers","Rice Cakes");
        LocationEntity l7= new LocationEntity(7,"SKUDESC7","Center","GM","Audio Video","Audio");
        LocationEntity l8= new LocationEntity(8,"SKUDESC8","Center","GM","Audio Video","Video DVD");
        LocationEntity l9= new LocationEntity(9,"SKUDESC9","Permiter","GM","Housewares","Beeding");
        LocationEntity l10= new LocationEntity(10,"SKUDESC10","Permiter","Seafood","Frozen Shellfish","Frozen Shellfish");
        LocationEntity l11= new LocationEntity(11,"SKUDESC11","Permiter","Seafood","Other Seafood","All Other Seafood");
        LocationEntity l12= new LocationEntity(12,"SKUDESC12","Permiter","Seafood","Other Seafood","Prepared Seafood Entrees");
        LocationEntity l13= new LocationEntity(13,"SKUDESC13","Permiter","Seafood","Other Seafood","Salads");
        LocationEntity l14= new LocationEntity(14,"SKUDESC14","Permiter","Bakery","Bakery Bread","Bagels");
        LocationEntity l15= new LocationEntity(15,"SKUDESC15","Permiter","Deli and Foodservice","Self Service Deli Cold","Beverages");
        LocationEntity l16= new LocationEntity(16,"SKUDESC16","Permiter","Floral","Bouquets and Cut Flowers","Bouquets and Cut Flowers");
        LocationEntity l17= new LocationEntity(17,"SKUDESC17","Permiter","Deli and Foodservice","Service Deli","All Other");
        LocationEntity l18= new LocationEntity(18, "SKUDESC18", "Center", "Frozen", "Frozen Bake", "Bread or Dough Products Frozen");

        List<LocationEntity> locationEntities = Arrays.asList(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18);
        return locationEntities;
    }
}
