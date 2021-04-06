package aitsi.store.service.impl;

import aitsi.store.entity.Order;
import aitsi.store.entity.OrderProduct;
import aitsi.store.entity.Product;
import aitsi.store.repository.OrderRepository;
import aitsi.store.repository.ProductRepository;
import aitsi.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public boolean amountIsAvailableInShop(Order order) throws RuntimeException {
        for(OrderProduct orderProduct : order.getOrderProducts()) {
            Product product = orderProduct.getProduct();

            if(product.getAvailableAmount() < orderProduct.getAmount())
                return false;

            orderProduct.setOrder(order);
        }
        return true;
    }

    @Override
    public void saveOrder(Order order) {
        for(OrderProduct orderProduct : order.getOrderProducts()) {
            Product product = orderProduct.getProduct();

            product.subtractAmountOfProduct(orderProduct.getAmount());

            productRepository.save(product);
        }
        orderRepository.save(order);

    }
}
