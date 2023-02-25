package com.AirMatios.Service;

import com.AirMatios.Exceptions.NotEnoughMoneyException;
import com.AirMatios.Repository.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Payment", url = "${name.service.url}")
public interface PaymentProxy {

    @GetMapping("payment")
    String payment(Iterable<Orders> orders) throws NotEnoughMoneyException;

}
