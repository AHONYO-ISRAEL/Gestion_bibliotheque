/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author HP
 */
public class Ouvrage {
    private String code, titre, resume;
    private int nbPage;

    public Ouvrage(String code) {
        this.code = code;
    }
    
    
    public Ouvrage(String code, String titre, String resume, int nbPage) {
        this.code = code;
        this.titre = titre;
        this.resume = resume;
        this.nbPage = nbPage;
    }
    
    public Ouvrage(){
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getNbPage() {
        return nbPage;
    }

    public void setNbPage(int nbPage) {
        this.nbPage = nbPage;
    }


    
    
}
