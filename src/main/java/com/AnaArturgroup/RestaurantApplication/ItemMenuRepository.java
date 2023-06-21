package com.AnaArturgroup.RestaurantApplication;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemMenuRepository extends CrudRepository<ItemMenu, Long> {
    List<ItemMenu> findAll();

    void deleteById(Long id);
}
