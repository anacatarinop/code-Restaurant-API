package com.AnaArturgroup.RestaurantApplication;

 public class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(Long id) {
            super("Item not found with id: " + id);
        }
    }