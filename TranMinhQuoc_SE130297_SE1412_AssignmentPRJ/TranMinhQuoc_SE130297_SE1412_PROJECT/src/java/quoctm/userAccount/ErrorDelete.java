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
public class ErrorDelete implements Serializable{
    private String UsernameNotDelete;

    public ErrorDelete() {
    }

    public ErrorDelete(String UsernameNotDelete) {
        this.UsernameNotDelete = UsernameNotDelete;
    }

    public String getUsernameNotDelete() {
        return UsernameNotDelete;
    }

    public void setUsernameNotDelete(String UsernameNotDelete) {
        this.UsernameNotDelete = UsernameNotDelete;
    }
    
    
}
