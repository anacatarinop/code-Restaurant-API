package com.AnaArturgroup.RestaurantApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final ItemMenuRepository itemMenuRepository;

    public MenuController(ItemMenuRepository itemMenuRepository) {
        this.itemMenuRepository = itemMenuRepository;
    }

    @GetMapping
    public List<ItemMenu> getAllItems() {
        return itemMenuRepository.findAll();
    }

    @GetMapping("/{id}")
    public ItemMenu getItem(@PathVariable Long id) {
        return itemMenuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
    }

    @PostMapping
    public ItemMenu addItem(@RequestBody ItemMenu item) {
        return itemMenuRepository.save(item);
    }

    @PutMapping("/{id}")
    public ItemMenu updateItem(@PathVariable Long id, @RequestBody ItemMenu updatedItem) {
        ItemMenu item = itemMenuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));

        item.setNome(updatedItem.getNome());
        item.setDescricao(updatedItem.getDescricao());
        item.setPreco(updatedItem.getPreco());

        return itemMenuRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemMenuRepository.deleteById(id);
    }
}