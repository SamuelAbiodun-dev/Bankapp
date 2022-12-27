package services;

import dtos.requests.LoginRequestDTO;
import dtos.requests.RegisterRequestDTO;
import dtos.requests.ResetPasswordRequestDTO;
import dtos.requests.UpdateUserRequestDTO;
import dtos.responses.UserDTO;
import exception.SignupSignInException;

public interface AppUserService {
    UserDTO createUser(RegisterRequestDTO registerRequestDTO);

    UserDTO loginUser(LoginRequestDTO loginRequestDTO) throws SignupSignInException;

    void deleteUser(String email, String password);

    UserDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO);

    void resetPassword(ResetPasswordRequestDTO resetPasswordRequestDTO) throws SignupSignInException;
}
