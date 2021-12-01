import java.util.* ;
import java.io.* ; 

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in) ; 
        int chon ; 
        
        DocFile reader = new DocFile() ; 
        ArrayList<SinhVien> sv = reader.ReadSinhVienFromFile() ; 
        ArrayList<MonHoc> mh = reader.ReadMonHocFromFile() ;
        ArrayList<Diem> d = reader.ReadDiemFromFile() ;
        
        GiaoDien giaodien = new GiaoDien() ; 
        System.out.println("               ---------------------------------") ; 
        System.out.println("               |       QUAN LY SINH VIEN       |") ; 
        System.out.println("               ---------------------------------") ; 
        System.out.println() ; 
        System.out.println() ;

        do
        {
            System.out.println("--------------------------------") ; 
            System.out.println("|             MENU             |") ;
            System.out.println("--------------------------------") ; 
            System.out.println("| 1. Cap nhat danh sach        |") ;
            System.out.println("| 2. Hien thi bang diem        |") ;
            System.out.println("| 3. Tim kiem                  |") ; 
            System.out.println("| 0. Thoat                     |") ;
            System.out.println("--------------------------------") ; 
            System.out.println() ; 
            System.out.println("Chon:") ; 
            chon = sc.nextInt() ; 

            switch(chon)
            {
                case 1:
                	giaodien.GiaoDien_CapNhatDanhSach(sv, mh, d) ;
                    break ; 
                
                case 2:
                	giaodien.GiaoDien_BangDiem(sv, mh, d) ;
                    break ; 
                
                case 3:
                	giaodien.GiaoDien_TimKiem(sv, mh, d) ;
                    break ; 
                
                default:
                    break ; 
            }
    
        }while(chon!=0) ; 
        
        GhiFile writer = new GhiFile() ; 
        writer.WriteSinhVien(sv) ;
    }   
}
