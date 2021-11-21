/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import javafx.scene.image.ImageView;

public class classprod {
    
 
    
   public String book , auther   ,desc , type , pdf; 
    public int hard , rate, ph , ps   ; 
    private String cover;
    
    
    public classprod()
    {
        
    }
    
    public classprod ( String book ,String auther ,String desc ,  String type, String cover , int hard , int rate , int ph , int ps , String pdf )
    {

        this.book= book ;
         this.auther = auther;       
        this.desc = desc ;
        this.type = type ; 
        this.cover = cover; 
        this.hard = hard;
        this.rate = rate;
        this.ph = ph;
        this.ps = ps;
        this.pdf = pdf;
                
    }

    public String getBook() {
        return book;
    }

    public String getAuther() {
        return auther;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public String getPdf() {
        return pdf;
    }

    public int getHard() {
        return hard;
    }

    public int getRate() {
        return rate;
    }

    public int getPh() {
        return ph;
    }

    public int getPs() {
        return ps;
    }

    public String getCover() {
        return cover;
    }
    
 
       
    
}
