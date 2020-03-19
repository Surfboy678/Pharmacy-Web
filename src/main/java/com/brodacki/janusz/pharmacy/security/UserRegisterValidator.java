package com.brodacki.janusz.pharmacy.security;

import com.brodacki.janusz.pharmacy.user.model.User;
import com.brodacki.janusz.pharmacy.utils.AppUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserRegisterValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if(!user.getEmail().equals(null)){
            boolean isMatch = AppUtils.checkEmailOrPassword(AppConstants.emailPattern, user.getEmail());
            if(!isMatch){
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }
        if(!user.getPassword().equals(null)){
            boolean isMatch = AppUtils.checkEmailOrPassword(AppConstants.passwordPattern, user.getPassword());
            if (!isMatch){
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        }

    }

}