package aitsi.store.service;

import aitsi.store.entity.Order;

public interface OrderService {
    boolean amountIsAvailableInShop(Order order);

    void saveOrder(Order order);
}
