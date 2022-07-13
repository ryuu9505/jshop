package com.example.jshop.domain;

import com.example.jshop.domain.item.Item;
import com.example.jshop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item SavedItem = itemRepository.save(item);

        //then
        Item foundItem = itemRepository.findById(item.getId());
        Assertions.assertThat(foundItem).isEqualTo(SavedItem);
    }

    @Test
    void findById() {
        //given
        Item item = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item);

        //when
        Item foundItem = itemRepository.findById(item.getId());

        //then
        Assertions.assertThat(foundItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);
        Item SavedItem1 = itemRepository.save(item1);
        Item SavedItem2 = itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        Assertions.assertThat(items.size()).isEqualTo(2);
        Assertions.assertThat(items).contains(item1, item2);

    }

    @Test
    void update() {
        //given
        Item item = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Item newItem = new Item("itemNew", 77777, 77);

        //when
        itemRepository.update(item.getId(), newItem);

        //then
        Item foundItem = itemRepository.findById(savedItem.getId());
        Assertions.assertThat(foundItem.getName()).isEqualTo(newItem.getName());
        Assertions.assertThat(foundItem.getPrice()).isEqualTo(newItem.getPrice());
        Assertions.assertThat(foundItem.getQuantity()).isEqualTo(newItem.getQuantity());

    }
}