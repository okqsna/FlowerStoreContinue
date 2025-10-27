package com.store.flower.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.flower.payment.CreditCardPaymentStrategy;
import com.store.flower.payment.PayPalPaymentStrategy;
import com.store.flower.Flower;
import com.store.flower.FlowerBucket;
import com.store.flower.FlowerPack;
import com.store.flower.FlowerType;
import com.store.flower.FlowerColor;
import com.store.flower.Item;
import com.store.flower.Order;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final Order order = new Order();

    public PaymentController() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(new FlowerPack(new Flower(10, FlowerColor.RED, 50.0, FlowerType.ROSE), 3));

        Item item = new Item();
        item.setOrderBucket(bucket);

        order.addItem(item);
    }

    @GetMapping("/creditcard")
    public String setCreditCard() {
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        double price = order.getPaymentStrategy().pay(order.getTotalPrice());
        return "Payment set to Credit Card. Price now is " + price;
    }

    @GetMapping("/paypal")
    public String setPayPal() {
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        double price = order.getPaymentStrategy().pay(order.getTotalPrice());
        return "Payment set to PayPal. Price now is " + price;
    }
}
