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
public class ErrorUpdate implements Serializable{
    private String passwordLengthErr;
    private String lastnameLengthErr;

    public ErrorUpdate() {
    }

    public ErrorUpdate(String passwordLengthErr, String lastnameLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
        this.lastnameLengthErr = lastnameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getLastnameLengthErr() {
        return lastnameLengthErr;
    }

    public void setLastnameLengthErr(String lastnameLengthErr) {
        this.lastnameLengthErr = lastnameLengthErr;
    }
     
}
