public class SinhVien
{
    private String maSinhVien ; 
    private String hoDem ;
    private String ten ; 
    private String ngaySinh ;   // dd//mm/yyyy
    private String gioiTinh ;   // Nam/Nu

    public SinhVien()
    {
        this.maSinhVien = "" ;
        this.hoDem = "" ;
        this.ten = "" ;
        this.ngaySinh = "" ;
        this.gioiTinh = "" ;
    }

    public SinhVien(String maSinhVien, String hoDem, String ten, String ngaySinh, String gioiTinh)
    {
        this.maSinhVien = maSinhVien ;
        this.hoDem = hoDem ;
        this.ten = ten ;
        this.ngaySinh = ngaySinh ;
        this.gioiTinh = gioiTinh ;
    }

    // GETTER & SETTER
    public String getMaSinhVien()
    {
        return this.maSinhVien ;
    }

    public String getHoDem()
    {
        return this.hoDem ;
    }

    public String getTen()
    {
        return this.ten ;
    }

    public String getNgaySinh()
    {
        return this.ngaySinh ;
    }

    public String getGioiTinh()
    {
        return this.gioiTinh ;
    }

    public void setMaSinhVien(String maSinhVien)
    {
        this.maSinhVien = maSinhVien ;
    }

    public void setHoDem(String hoDem)
    {
        this.hoDem = hoDem ;
    }

    public void setTen(String ten)
    {
        this.ten = ten ;
    }

    public void setNgaySinh(String ngaySinh)
    {
        this.ngaySinh = ngaySinh ;
    }

    public void setGioiTinh(String gioiTinh)
    {
        this.gioiTinh = gioiTinh ;
    }

    public String toString()
    {
        return "[  "+this.maSinhVien+"  "+this.hoDem+"  "+this.ten+"  "+this.ngaySinh+"  "+this.gioiTinh+"  ]" ; 
    }

    public String InThongTin()
    {
        String cot1 = "|"+this.maSinhVien+"  |" ;

        String cot2 = " "+this.hoDem ;
        for(int k=cot2.length();k<27;k++)
            cot2 += " " ; 
        cot2 += "|" ; 

        String cot3 = " "+this.ten ; 
        for(int k=cot3.length();k<16;k++)
            cot3 += " " ; 
        cot3 += "|" ;

        String cot4 = "  "+this.ngaySinh ; 
        for(int k=cot4.length();k<14;k++)
            cot4 += " " ; 
        cot4 += "|" ;

        String cot5 = " "+this.gioiTinh ;
        for(int k=cot5.length();k<9;k++)
            cot5 += " " ; 
        cot5 += "|" ; 

        return cot1+cot2+cot3+cot4+cot5 ; 
    }
}