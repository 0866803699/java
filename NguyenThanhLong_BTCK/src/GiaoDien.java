import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GiaoDien extends DanhSachSinhVien
{
	public static void GiaoDien_DanhSachSinhVien(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        int chon ; 

        do
        {
            System.out.println("-------------------------------") ; 
            System.out.println("|     DANH SACH SINH VIEN     |") ; 
            System.out.println("-------------------------------") ; 
            System.out.println("| 1. Them sinh vien           |") ;
            System.out.println("| 2. Sua thong tin sinh vien  |") ; 
            System.out.println("| 3. Xoa sinh vien            |") ;
            System.out.println("| 4. Hien thi danh sach       |") ; 
            System.out.println("| 0. Tro ve menu truoc        |") ;
            System.out.println("-------------------------------") ; 
            System.out.println() ; 
            System.out.println("Chon:") ;
            chon = sc.nextInt() ; 
            sc.nextLine() ; 
            
            switch(chon)
            {
                case 1:
                    sv = ThemSinhVien(sv) ; 
                    break ;

                case 2:
                    SuaSinhVien(sv);
                    break ; 

                case 3:
                    sv = XoaSinhVien(sv,d) ; 
                    break ; 
                
                case 4:
                    HienThiDanhSachSinhVien(sv,mh,d);
                    break ; 
                
                default:
                    break ;
            }

        }while(chon != 0) ; 
    }
    
	public static void GiaoDien_DanhSachMonHoc(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        QuanLyMonHoc QLMH = new QuanLyMonHoc() ;  
        int chon ; 

        do
        {
            System.out.println("-----------------------------") ; 
            System.out.println("|     DANH SACH MON HOC     |") ; 
            System.out.println("-----------------------------") ; 
            System.out.println("| 1. Hien thi danh sach     |") ;
            System.out.println("| 0. Tro ve menu truoc      |") ; 
            System.out.println("-----------------------------") ; 
            System.out.println() ; 
            System.out.println("Chon:") ;
            chon = sc.nextInt() ; 

            switch(chon)
            {
                case 1:
                	QLMH.HienThiDanhSachMonHoc(mh);
                    break ;
                
                default:
                    break ; 
            }
        
        }while(chon != 0) ; 
    }

	public static void GiaoDien_CapNhatDanhSach(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        int chon ; 

        do
        {
            System.out.println("-------------------------------------") ; 
            System.out.println("|   Cap nhat danh sach              |") ; 
            System.out.println("-------------------------------------") ; 
            System.out.println("| 1. Cap nhat danh sach sinh vien   |") ; 
            System.out.println("| 2. Cap nhat danh sach mon hoc     |") ; 
            System.out.println("| 0. Tro ve menu truoc              |") ; 
            System.out.println("-------------------------------------") ;
            System.out.println() ; 
            System.out.println("Chon:") ; 
            chon = sc.nextInt() ; 

            switch(chon)
            {
                case 1:
                    GiaoDien_DanhSachSinhVien(sv, mh, d) ;
                    break ; 
                case 2:
                    GiaoDien_DanhSachMonHoc(sv, mh, d) ;
                    break ;

                default:
                    break ;
            }

        }while(chon != 0) ;
    }

	public static void GiaoDien_BangDiem(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        int chon ; 
        QuanLyBangDiem QLBD = new QuanLyBangDiem() ; 

        do
        {
            System.out.println("------------------------------------------") ; 
            System.out.println("|               BANG DIEM                |") ; 
            System.out.println("------------------------------------------") ; 
            System.out.println("| 1. Bang diem theo danh sach sinh vien  |") ;
            System.out.println("| 0. Tro ve menu truoc                   |") ;
            System.out.println("------------------------------------------") ; 
            System.out.println() ; 
            System.out.println("Chon:") ; 
            chon = sc.nextInt() ; 

            switch(chon)
            {
                case 1:
                    // Sap xep theo ma sinh vien truoc khi hien thi
                    Collections.sort(sv, new Comparator<SinhVien>()
		            {
			            public int compare(SinhVien a, SinhVien b)
			            {
				            return a.getMaSinhVien().compareTo(b.getMaSinhVien()) ; 
			            }
		            }) ;

                    int tongSoTrang ;
                    if(sv.size()%30==0)
                        tongSoTrang = sv.size()/30 ; 
                    else
                        tongSoTrang = sv.size()/30 + 1 ; 

                    int soPhanTu ;
                    if(sv.size()>=30)
                        soPhanTu = 30 ; 
                    else
                        soPhanTu = sv.size() ;     
    
                    int count = 0 ; 
                    int chon2, check=0 ; 

                    for(int k=0;k<tongSoTrang;k++)
                    {
                        System.out.println("-----------------DANH SACH SINH VIEN-------------------") ;
                        System.out.println("--------------------trang "+(k+1)+"/"+tongSoTrang+"---------") ; 
                        System.out.println() ; 
                        
                        for(int i=count;i<soPhanTu*(k+1);i++)
                        {
                            if(i==sv.size())
                            {
                                System.out.println("--------------------trang "+(k+1)+"/"+tongSoTrang+"---------") ; 
                                System.out.println() ; 
                                System.out.println("Nhan phim 0 de tro ve menu truoc") ;
                                do
                                {
                                    chon2 = sc.nextInt() ; 
                                }while(chon2!=0) ; 
                                check = 1 ;
                                break ; 
                            }      

                            QLBD.HienThiBangDiemTheoTen(d, sv, mh, sv.get(i).getMaSinhVien());
                            System.out.println() ; 
                            System.out.println() ;
                            count++ ; 
                        }
                        
                        if(check==1) 
                        {
                            System.out.println() ;
                            System.out.println() ; 
                            break ; 
                        }

                        System.out.println("--------------------trang "+(k+1)+"/"+tongSoTrang+"---------") ;
                        System.out.println() ; 
                        System.out.println("1. Xem trang tiep theo") ; 
                        System.out.println("0. Tro ve menu truoc") ; 
                        chon2 = sc.nextInt() ; 

                        if(chon2==1)
                            continue ; 
                        else
                            break ;
                    }
                    break ; 
                
                default:
                    break ; 
            }
        
        }while(chon != 0) ; 
    }

	public static void GiaoDien_TimKiem(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        TimKiem tk = new TimKiem() ;
        int chon ;

        do
        {   
            System.out.println("---------------------------------------") ; 
            System.out.println("|             TIM KIEM                |") ; 
            System.out.println("---------------------------------------") ;
            System.out.println("| 1. Tim kiem theo ma sinh vien       |") ; 
            System.out.println("| 2. Tim kiem theo ten sinh vien      |") ; 
            System.out.println("| 0. Tro ve menu truoc                |") ;
            System.out.println("---------------------------------------") ;
            System.out.println() ;
            System.out.println("Chon:") ; 
            chon = sc.nextInt() ; 
            sc.nextLine() ; 

            switch(chon)
            {
                case 1:
                	tk.TimKiemTheoMaSinhVien(sv, mh, d) ;
                    break ; 
                
                case 2:
                	tk.TimKiemTheoTenSinhVien(sv,mh,d) ;
                    break ; 

                default:
                    break ;
            }

        }while(chon != 0) ;
    }    
}
