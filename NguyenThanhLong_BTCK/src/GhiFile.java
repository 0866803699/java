import java.io.FileWriter;
import java.util.ArrayList;

public class GhiFile extends SinhVien
{
	public void WriteSinhVien(ArrayList<SinhVien> sv)
    {
        try
        {
            FileWriter writer = new FileWriter("data/sinhvien_en.txt") ; 

            writer.write("#Ma - Ho dem - Ten - Ngay sinh - Gioi tinh"+"\n") ;
            for(SinhVien i:sv)
                writer.write(i.getMaSinhVien()+";"+i.getHoDem()+";"+i.getTen()+";"+i.getNgaySinh()+";"+i.getGioiTinh()+"\n") ;
            
            writer.close() ;
        }catch(Exception e){
            System.out.println("Loi khi cap nhat file sinh vien") ; 
        }
    }
}
