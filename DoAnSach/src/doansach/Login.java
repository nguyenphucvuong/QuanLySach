/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doansach;

/**
 *
 * @author abcde
 */
public class Login {
    private String username;
    private String password;
    private String ten;
    private String mail;

    public Login(String username, String password, String ten, String mail) {
        this.username = username;
        this.password = password;
        this.ten = ten;
        this.mail = mail;
    }

    

    public Login() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    
}
