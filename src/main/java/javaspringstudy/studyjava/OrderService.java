package javaspringstudy.studyjava;

import javaspringstudy.studyjava.dto.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}

