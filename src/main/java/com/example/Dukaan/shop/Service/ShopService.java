package com.example.Dukaan.shop.Service;

import com.example.Dukaan.exception.UserAlreadyExistsException;
import com.example.Dukaan.shop.Entity.ShopEntity;
import com.example.Dukaan.shop.Repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    private ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public ShopEntity createdShopInfo(ShopEntity shopEntity,String gstNumber){
       if(shopRepository.existsByGstNumber(gstNumber)){
          throw new UserAlreadyExistsException("GST number already exists");
       }

;               shopEntity.setSoftDelete(false);
        return shopRepository.save(shopEntity);
    }

    public Optional<ShopEntity> updateShopInfo(ShopEntity shopEntity , Long id){
        Optional<ShopEntity> shopEntityNew = shopRepository.findByIdAndSoftDeleteFalse(id);
        if (shopEntityNew.isEmpty()) {
            return Optional.empty();
        }

        ShopEntity shopEntityToSave = shopEntityNew.get();
        shopEntityToSave.setOwnerName(shopEntity.getOwnerName());
        shopEntityToSave.setShopName(shopEntity.getShopName());
        shopEntityToSave.setGstNumber(shopEntity.getGstNumber());
        shopEntityToSave.setPhoneNumber(shopEntity.getPhoneNumber());
        shopEntityToSave.setShopAddress(shopEntity.getShopAddress());
        shopEntityToSave.setCity(shopEntity.getCity());
        shopEntityToSave.setState(shopEntity.getState());
        shopEntityToSave.setPincode(shopEntity.getPincode());
        shopEntityToSave.setEmail(shopEntity.getEmail());



        ShopEntity savedShop = shopRepository.save(shopEntityToSave);

        return Optional.of(savedShop);
    }

    public Optional<ShopEntity> getById(Long id){
        return shopRepository.findByIdAndSoftDeleteFalse(id);
    }

    public Boolean deleteById(Long id){
        Optional<ShopEntity> shopEntity =
                shopRepository.findByIdAndSoftDeleteFalse(id);;
       if(shopEntity.isEmpty()) return false;
       ShopEntity shopEntity1 = shopEntity.get();
       shopEntity1.setSoftDelete(true);
        shopRepository.save(shopEntity1);
       return true;
    }

    public List<ShopEntity> getAll(){
        return shopRepository.findAllBySoftDeleteFalse();
    }

}
