import java.util.ArrayList;
import java.util.Scanner;

public class TimKiem extends SinhVien
{
	public static void TimKiemTheoMaSinhVien(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ;
        QuanLyBangDiem QLBD = new QuanLyBangDiem() ; 

        System.out.println("Nhap ma sinh vien:") ; 
        String line = sc.nextLine() ;

        for(SinhVien i:sv)
            if(line.equals(i.getMaSinhVien()))
            {    
            	QLBD.HienThiBangDiemTheoTen(d, sv, mh, line);
                System.out.println() ; 
                return ; 
            }
        
        System.out.println("Khong tim thay sinh vien ["+line+"]") ; 
    }

    public static void TimKiemTheoTenSinhVien(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        QuanLyBangDiem QLBD = new QuanLyBangDiem() ; 
        int check=0, chon ; 
        ArrayList<String> maSv = new ArrayList<>() ; 
        ArrayList<SinhVien> sv2 = new ArrayList<>() ;

        System.out.println("Nhap ten sinh vien:") ; 
        String line = sc.nextLine() ;

        for(SinhVien i:sv)
            if(line.equals(i.getTen()))
            {
                check = 1;
                sv2.add(i) ; 
            }
        
        if(check==0)
        {
            System.out.println("Khong tim thay sinh vien ["+line+"]") ; 
            return ;
        }

        int tongSoTrang ;
        if(sv2.size()%30==0)
            tongSoTrang = sv2.size()/30 ; 
        else
            tongSoTrang = sv2.size()/30 + 1 ; 

        int soPhanTu ;
        if(sv2.size()>=30)
            soPhanTu = 30 ; 
        else
            soPhanTu = sv2.size() ;     
    
        int count = 0, count2 ;

        for(int k=0;k<tongSoTrang;k++)
        {
            System.out.println("-----------------KET QUA TIM KIEM-------------------") ; 
            System.out.println("--------------------trang "+(k+1)+"/"+tongSoTrang+"------------------") ; 
            System.out.println("---------------------------------------------------------------------------------") ;
            System.out.println("|   Ma    |   Ho dem                  |   Ten          |  ngay sinh   |Gioi tinh|") ;
            System.out.println("---------------------------------------------------------------------------------") ;
            
            count2 = 0 ; 
            for(int i=count;i<soPhanTu*(k+1);i++)
            {
                if(i==sv2.size())
                    break ; 
                
                maSv.add(sv2.get(i).getMaSinhVien()) ; 
                System.out.println(sv2.get(i).InThongTin()) ;
                count++ ; 
                count2++ ;   
            }

            System.out.println("---------------------------------------------------------------------------------") ;
            System.out.println() ; 
            System.out.println("----------------------trang "+(k+1)+"/"+tongSoTrang+"------------------") ; 
            System.out.println() ;

            System.out.println("1. Xem trang tiep theo") ;
            System.out.println("2. Xem chi tiet bang diem") ; 
            System.out.println("0. tro ve menu truoc") ; 
            System.out.println() ;
            System.out.println("Chon:") ; 
            chon = sc.nextInt() ;

            if(chon==1)
            {
                maSv.clear() ;
                if(count!=sv2.size())
                    continue ; 
                else
                    k-- ;
                    count -= count2 ; 
            }
            else if(chon==2)
            {
                int check_maSV = 0 ; 
                sc.nextLine() ; 
                System.out.println("Nhap ma sinh vien:") ; 
                String line2 = sc.nextLine() ; 

                for(String i:maSv)
                    if(line2.equals(i))
                    {
                        QLBD.HienThiBangDiemTheoTen(d, sv, mh, line2) ;
                        check_maSV = 1 ;
                    }
                
                if(check_maSV == 0)
                    System.out.println("Khong tim thay sinh vien ["+line2+"]") ; 
                
                String line3 ; 
                do
                {
                    System.out.println("Nhap ... de quay lai") ; 
                    line3 = sc.nextLine() ; 

                }while(!line3.equals("...")) ; 
                k-- ;
                count -= count2 ; 
                maSv.clear() ;
            }
            else
                return ; 
        } 
    }
}
