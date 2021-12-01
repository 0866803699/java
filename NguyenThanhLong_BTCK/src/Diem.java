public class Diem
{
    private String maSinhVien ; 
    private String maMonHoc ;
    private double diem ; 

    public Diem()
    {
        this.maSinhVien = "" ;
        this.maMonHoc = "" ;
        this.diem = 0.0 ;
    }

    public Diem(String maSinhVien, String maMonHoc, double diem)
    {
        this.maSinhVien = maSinhVien ;
        this.maMonHoc = maMonHoc ;
        this.diem = diem ;
    }

    // GETTER & SETTER
    public String getMaSinhVien()
    {
        return this.maSinhVien ;
    }

    public String getMaMonHoc()
    {
        return this.maMonHoc ;
    }

    public double getDiem()
    {
        return this.diem ;
    }

    public void setMaSinhVien(String maSinhVien)
    {
        this.maSinhVien = maSinhVien ;
    }

    public void setMaMonHoc(String maMonHoc)
    {
        this.maMonHoc = maMonHoc ;
    }

    public void setDiem(double diem)
    {
        this.diem = diem ;
    }
}