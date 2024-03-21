package ru.spring.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.spring.shoppinglist.persist.ShoppingItem;
import ru.spring.shoppinglist.persist.ShoppingItemRepository;

@Controller
public class ShoppingListController {
    private final ShoppingItemRepository repository;

    @Autowired
    public ShoppingListController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("items",repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PutMapping
    public String newShoppingItem(ShoppingItem item){
        repository.save(item);
        return "redirect:/";
    }
}
