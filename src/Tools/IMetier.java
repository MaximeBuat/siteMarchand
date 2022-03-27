/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Login;
import Entity.stock;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public interface IMetier {
    public Login VerifierIdentifiants(String login, String mdp);
    public Login addLogin(String unLogin, String unMdp);
    public Login VerifierLogin(String login);
    public ArrayList<stock> GetAllStock();
    public stock SetAchat(Object genre,Object typVet ,Object taille ,Object couleur, Object quantite);
    public stock VerifierAchat(Object genre,Object typVet ,Object taille ,Object couleur, Object quantite);
}
