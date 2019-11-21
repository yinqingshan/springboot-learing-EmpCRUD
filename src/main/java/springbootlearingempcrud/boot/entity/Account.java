package springbootlearingempcrud.boot.entity;

import java.io.Serializable;

/**
 * ClassName: Account
 * Description:  账户信息
 * Author: 殷青山
 * Date: 2019/11/22 0:12
 * Version: V1.0
 **/
public class Account implements Serializable {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
