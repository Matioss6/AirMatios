import com.AirMatios.Repository.UserData;
import com.AirMatios.Repository.UserDataRepository;
import com.AirMatios.Service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;

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

        System.out.println(loginService.logIn(user.getLogin(),user.getPassword()));

    }

    @Test
    public void logInTestNoUserFound(){


        UserData user = new UserData("Matios","123","Mateusz","P");


        when(userDataRepository.existsById(user.getLogin())).thenReturn(false);

        System.out.println(loginService.logIn(user.getLogin(),user.getPassword()));

    }

    @Test
    public void logInTestWrongPassword(){


        UserData user = new UserData("Matios","123","Mateusz","P");


        when(userDataRepository.existsById(user.getLogin())).thenReturn(true);
        when(userDataRepository.findById(user.getLogin())).thenReturn(Optional.of(user));

        System.out.println(loginService.logIn(user.getLogin(),"inne haslo"));

    }

}
