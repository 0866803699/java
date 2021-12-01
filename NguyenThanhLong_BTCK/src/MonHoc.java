public class MonHoc
{
    private String maMonHoc ; 
    private String tenMonHoc ;
    private double heSoMonHoc ; 

    public MonHoc()
    {
        this.maMonHoc = "" ;
        this.tenMonHoc = "" ;
        this.heSoMonHoc = 0.0 ;
    }

    public MonHoc(String maMonHoc, String tenMonHoc, double heSoMonHoc)
    {
        this.maMonHoc = maMonHoc ;
        this.tenMonHoc = tenMonHoc ;
        this.heSoMonHoc = heSoMonHoc ;
    }

    // GETTER & SETTER
    public String getMaMonHoc()
    {
        return this.maMonHoc ;
    }

    public String getTenMonHoc()
    {
        return this.tenMonHoc ;
    }

    public double getHeSoMonHoc()
    {
        return this.heSoMonHoc ;
    }

    public void setMaMonHoc(String maMonHoc)
    {
        this.maMonHoc = maMonHoc ;
    }

    public void setTenMonHoc(String tenMonHoc)
    {
        this.tenMonHoc = tenMonHoc ;
    }

    public void setHeSoMonHoc(double heSoMonHoc)
    {
        this.heSoMonHoc = heSoMonHoc ;
    }

    public String toString()
    {        
        String cot1 = "| "+this.maMonHoc ; 
        
        String cot2 = "  "+this.tenMonHoc ;
        for(int k=cot2.length();k<34;k++)
            cot2 += " " ;
        
        String cot3 = String.valueOf(this.heSoMonHoc) ;
        for(int k=cot3.length();k<4;k++)
            cot3 += " " ;
        cot3 += "|" ;

        return "--------------------------------------------"+"\n"+cot1+cot2+cot3+"\n"+"--------------------------------------------" ;
    }
}
