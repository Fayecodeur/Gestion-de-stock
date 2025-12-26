/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import dao.UserDAO;
import model.User;
import view.LoginForm;
import javax.swing.JOptionPane;

public class LoginController {

    private final LoginForm loginForm;
    private final UserDAO userDAO;

    public LoginController(LoginForm loginForm) {
        this.loginForm = loginForm;
        this.userDAO = new UserDAO();
        initController();
    }

    private void initController() {
        // On ajoute un listener sur le bouton
        loginForm.getBtnLogin().addActionListener(e -> seConnecter());
    }

    private void seConnecter() {
        String loginText = loginForm.getLogin().getText();
        String passwordText = new String(loginForm.getPassword().getPassword());

        User user = userDAO.login(loginText, passwordText);
        if (user != null) {
            // Login réussi → ouvrir Dashboard (simple message pour l’instant)
            JOptionPane.showMessageDialog(loginForm, "Welcome " + user.getFirstname() + "!");
            loginForm.dispose(); // fermer le login
        } else {
            // Login échoué
            JOptionPane.showMessageDialog(loginForm, "Login or password incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

