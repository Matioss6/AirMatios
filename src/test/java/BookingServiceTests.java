import com.AirMatios.Repository.Orders;
import com.AirMatios.Repository.OrdersRepository;
import com.AirMatios.Service.BookingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookingServiceTests {


    @Test
    @DisplayName("Test for Booking service")
    public void bookingHappyFlow(){

        OrdersRepository ordersRepository = mock(OrdersRepository.class);
        BookingService bookingService = new BookingService(ordersRepository);

        int flight_ID =1;
        String user_login = "Matios";

        Orders order = new Orders();
        order.setOrder_ID(1);
        order.setFlight_ID(flight_ID);
        order.setUser_Login(user_login);

        List<Orders> list = new ArrayList<>();
        list.add(order);



        when(ordersRepository.findOrderByUser(user_login)).thenReturn(list);

        System.out.println(ordersRepository.findOrderByUser(user_login));


    }

}
