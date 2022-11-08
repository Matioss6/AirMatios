package com.AirMatios.Service;

import com.AirMatios.Repository.Orders;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Payment", url = "${name.service.url}")
public interface PaymentProxy {

    public String payment(Iterable<Orders> orders);

}
