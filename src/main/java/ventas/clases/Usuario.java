/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.clases;

import java.io.Serializable;

/**
 *
 * @author near
 */
public class Usuario implements Serializable{
    
    private String user;
    private String psw;
    

        public String getUser() {
           return user;
       }

       public void setUser(String user) {
           this.user = user;
       }

       public String getPsw() {
           return psw;
       }

       public void setPsw(String psw) {
           this.psw = psw;
       }
    
}
