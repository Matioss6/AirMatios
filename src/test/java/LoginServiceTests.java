import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import com.AirMatios.Service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTests {

@Mock
UserDataRepository userDataRepository;

@InjectMocks
LoginService loginService;

    @Test
    public void logInTestHappyFlow(){


        UserData user = new UserData("Matios","123","Mateusz","P");


        when(userDataRepository.existsById(user.getLogin())).thenReturn(true);
        when(userDataRepository.findById(user.getLogin())).thenReturn(Optional.of(user));

        String result = loginService.logIn(user.getLogin(),user.getPassword());
        System.out.println(result);
        Assertions.assertEquals(result, "You are now logged in");
    }

    @Test
    public void logInTestNoUserFound(){


        UserData user = new UserData("Matios","123","Mateusz","P");


        when(userDataRepository.existsById(user.getLogin())).thenReturn(false);

        String result = loginService.logIn(user.getLogin(),user.getPassword());
        System.out.println(result);
        Assertions.assertEquals(result, "No such user exists");
    }

    @Test
    public void logInTestWrongPassword(){


        UserData user = new UserData("Matios","123","Mateusz","P");


        when(userDataRepository.existsById(user.getLogin())).thenReturn(true);
        when(userDataRepository.findById(user.getLogin())).thenReturn(Optional.of(user));

        String result = loginService.logIn(user.getLogin(),"inne haslo");
        System.out.println(result);
        Assertions.assertEquals(result, "Wrong Password");
    }

}
