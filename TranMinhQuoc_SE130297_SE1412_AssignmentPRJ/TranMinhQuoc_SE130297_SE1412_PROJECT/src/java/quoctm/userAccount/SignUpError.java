/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quoctm.userAccount;

import java.io.Serializable;

/**
 *
 * @author SE130297
 */
public class SignUpError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmPasswordNoMatch;
    private String lastnameLengthErr;
    private String usernameIsExisted;

    public SignUpError() {
    }

    public SignUpError(String usernameLengthErr, String passwordLengthErr, String confirmPasswordNoMatch, String lastnameLengthErr, String usernameIsExisted) {
        this.usernameLengthErr = usernameLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.confirmPasswordNoMatch = confirmPasswordNoMatch;
        this.lastnameLengthErr = lastnameLengthErr;
        this.usernameIsExisted = usernameIsExisted;
    }

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmPasswordNoMatch() {
        return confirmPasswordNoMatch;
    }

    public void setConfirmPasswordNoMatch(String confirmPasswordNoMatch) {
        this.confirmPasswordNoMatch = confirmPasswordNoMatch;
    }

    public String getLastnameLengthErr() {
        return lastnameLengthErr;
    }

    public void setLastnameLengthErr(String lastnameLengthErr) {
        this.lastnameLengthErr = lastnameLengthErr;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
}
