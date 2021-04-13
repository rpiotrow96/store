package aitsi.store.service;

import aitsi.store.entity.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {
    boolean amountIsAvailableInShop(Order order);

    void saveOrder(Order order);

    List<Order> getAllOrders();
}
