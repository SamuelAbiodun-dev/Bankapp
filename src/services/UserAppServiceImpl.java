package services;

import data.model.ATMCard;
import data.model.AppUser;
import data.repository.UserRepository;
import dtos.requests.LoginRequestDTO;
import dtos.requests.RegisterRequestDTO;
import dtos.requests.ResetPasswordRequestDTO;
import dtos.requests.UpdateUserRequestDTO;
import dtos.responses.UserDTO;
import exception.SignupSignInException;

public class UserAppServiceImpl implements AppUserService {
    private final UserRepository userRepository = new UserRepository();
    @Override
    public UserDTO createUser(RegisterRequestDTO registerRequestDTO) {
        AppUser appUser = new AppUser();
        if (appUser.getAge() < 18) {
            throw new IllegalArgumentException("Dear user, you are not up to 18 years");
        } else {
            if (userRepository.findByKey(registerRequestDTO.getEmail()) != null) throw new IllegalArgumentException("");
            AppUser user = new AppUser(
                    registerRequestDTO.getFirstName(),
                    registerRequestDTO.getLastName(),
                    registerRequestDTO.getEmail(),
                    registerRequestDTO.getPassword(),
                    registerRequestDTO.getPhoneNumber(),
                    registerRequestDTO.getAccount(),
                    registerRequestDTO.getAtmCard()
            );
            AppUser savedUser = userRepository.save(user);
            UserDTO res = new UserDTO();
            res.setFirstName(savedUser.getFirstName());
            //res.setLastName(savedUser.getLastName());
            res.setEmail(savedUser.getEmail());
            return res;
        }
    }
    @Override
    public UserDTO loginUser(LoginRequestDTO loginRequestDTO) throws SignupSignInException {
            if(!loginRequestDTO.getPassword().equals(loginRequestDTO.getConfirmPassword()))
                throw new SignupSignInException("Password not matching");

            AppUser user = validateUser(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

            if (user == null) throw new IllegalArgumentException("Incorrect old password");

            UserDTO res = new UserDTO();
            res.setFirstName(user.getFirstName());
           // res.setLastName(user.getLastName());
            res.setEmail(user.getEmail());
            return res;
    }

    private AppUser validateUser(String email, String password) {
        AppUser user = userRepository.findByKey(email);
            if (user != null && user.getPassword().equals(password)) return user;
            return null;
        }


    @Override
    public void deleteUser(String email, String password) {
        AppUser user = validateUser(email, password);
        if(user != null) userRepository.delete(email);
    }

    @Override
    public UserDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO) {

        AppUser user = userRepository.findByKey(updateUserRequestDTO.getEmail());
        if (updateUserRequestDTO.getFirstName() != null) user.setFirstName(updateUserRequestDTO.getFirstName());
        //if (updateUserRequestDTO.getLastName() != null) user.setLastName(updateUserRequestDTO.getLastName());
        if (updateUserRequestDTO.getPhoneNumber() != null) user.setPhoneNumber(updateUserRequestDTO.getPhoneNumber());
        AppUser savedUser = userRepository.save(user);

        UserDTO res = new UserDTO();
        res.setFirstName(savedUser.getFirstName());
        //res.setLastName(savedUser.getLastName());
        res.setEmail(savedUser.getEmail());
        return res;
    }
    @Override
    public void resetPassword(ResetPasswordRequestDTO resetPasswordRequestDTO) throws SignupSignInException {
        AppUser user = validateUser(resetPasswordRequestDTO.getEmail(), resetPasswordRequestDTO.getOldPassword());
        if (user == null) throw new SignupSignInException("Incorrect old password");
        user.setPassword(resetPasswordRequestDTO.getNewPassword());
        userRepository.save(user);

    }

}
