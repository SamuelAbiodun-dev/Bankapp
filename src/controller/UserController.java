package controller;

import dtos.requests.LoginRequestDTO;
import dtos.requests.RegisterRequestDTO;
import dtos.requests.ResetPasswordRequestDTO;
import dtos.requests.UpdateUserRequestDTO;
import dtos.responses.UserDTO;
import exception.SignupSignInException;
import services.AppUserService;
import services.UserAppServiceImpl;
public class UserController {
        private final AppUserService userService = new UserAppServiceImpl();

        public UserDTO register(RegisterRequestDTO registerRequestDTO){
            return userService.createUser(registerRequestDTO);
        }

        public UserDTO login(LoginRequestDTO loginRequestDTO) throws SignupSignInException {
            return userService.loginUser(loginRequestDTO);
        }

        public String delete(String email, String password){
            userService.deleteUser(email, password);
            return "Successful";
        }

        public UserDTO update(UpdateUserRequestDTO updateUserRequestDTO){
            return userService.updateUser(updateUserRequestDTO);
        }

        public String resetPassword(ResetPasswordRequestDTO resetPasswordRequestDTO) throws SignupSignInException {
            userService.resetPassword(resetPasswordRequestDTO);
            return "Successful";
        }
    }

