package com.example.Dukaan.shop.Controller;

import com.example.Dukaan.shop.Entity.ShopEntity;
import com.example.Dukaan.shop.Service.ShopService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<ShopEntity> createShopInfo(@Valid @RequestBody ShopEntity shopEntity){

        return ResponseEntity.ok(shopService.createdShopInfo(shopEntity, shopEntity.getGstNumber()));
    }

    @PutMapping("{id}")
    public ResponseEntity<ShopEntity> updateShopInfo( @RequestBody ShopEntity shopEntity, @PathVariable Long id){
        Optional<ShopEntity> shopEntity1 = shopService.updateShopInfo(shopEntity,id);
        if(shopEntity1.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(shopEntity1.get());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ShopEntity> getByid(@PathVariable Long id){
        Optional<ShopEntity> shopEntity = shopService.getById(id);
        if(shopEntity.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(shopEntity.get());
    }
    @GetMapping("get-all")
    public ResponseEntity<List<ShopEntity>> getAll(){
        List<ShopEntity> shopEntity = shopService.getAll();
        return ResponseEntity.ok(shopEntity);
    }

    @PatchMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
         if(shopService.deleteById(id)){
             return "Deleted Successfully";
         }

         return "No Found";
    }
}

