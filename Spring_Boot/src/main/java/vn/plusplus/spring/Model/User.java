package vn.plusplus.spring.Model;

import vn.plusplus.spring.Model.Interface.ValidInput;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class User implements ValidInput {
    private String numberPhone;
    private String password;
    private String email;

    @Override
    public boolean checkPhoneNumber(String numberPhone) {
        if(numberPhone.length()!=10)
        return false;
        else return true;
    }

    @Override
    public boolean checkPassword(String Password) {
        if(Password.length()<8)
        return false;
        else return true;
    }

    @Override
    public boolean checkEmail(String email) {
        if (email.endsWith("@gmail.com")==false)
        return false;
        else return true;
    }



}
