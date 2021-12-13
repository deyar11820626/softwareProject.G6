/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hwsoft;

import javafx.scene.image.ImageView;

public class classprod {
    
 
    
   public String book , auther   ,description , type , Pdf; 
    public int hard , rate, Ph , Ps  ; 
    private String cover;
   private int Bid;
    
    
  
    public classprod ( int bid ,String book ,String auther ,String desc ,  String type, String cover , String pdf , int hard , int rate , int ph , int ps )
    {
        this.Bid= bid ;
        this.book= book ;
         this.auther = auther;       
        this.description = desc ;
        this.type = type ; 
        this.cover = cover; 
        this.hard = hard;
        this.rate = rate;
        this.Ph = ph;
        this.Ps = ps;
        this.Pdf = pdf;
                
    }

    /**
     *
     * @param bid
     * @param bname
     * @param aname
     * @param desc
     * @param typ
     * @param photo_path
     * @param pdf
     * @param hardc
     * @param rate
     * @param ph
     * @param ps
     */
 
 public int getBid() {
        return Bid;
    }
    public String getBook() {
        return book;
    }

    public String getAuther() {
        return auther;
    }

    public String getDesc() {
        return description;
    }

    public String getType() {
        return type;
    }
  public String getCover() {
        return cover;
    }
    
  
    public String getPdf() {
        return Pdf;
    }

    public int getHard() {
        return hard;
    }

    public int getRate() {
        return rate;
    }

    public int getPh() {
        return Ph;
    }

    public int getPs() {
        return Ps;
    }

  
 
       
  
}
