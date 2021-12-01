import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachSinhVien extends SinhVien
{
    public static ArrayList<SinhVien> ThemSinhVien(ArrayList<SinhVien> sv)
    {
        Scanner sc = new Scanner(System.in) ;
        String line ; 

        System.out.println("Nhap thong tin sinh vien theo dinh dang") ; 
        System.out.println("[ho va ten];[ngay sinh(dd/MM/yyyy)];[gioi tinh(Nam/Nu)]") ;
        System.out.println("Vi du:Nguyen Van A;14/06/1996;Nam") ; 
        
        do
        {
            System.out.println("Nhap exit de quay lai") ; 
            System.out.println("Nhap:") ; 

            line = sc.nextLine() ;
        
            if(line.equals("exit"))
                return sv ;

            String[] items = line.split(";") ; 
            String fullName = items[0] ; 
            String ngaySinh = items[1] ; 
            String gioiTinh = items[2] ; 

            int index_lastSpace = fullName.lastIndexOf(" ") ;
            String hoDem = fullName.substring(0,index_lastSpace) ;
            String ten = fullName.substring(index_lastSpace+1) ;
        
            String maSinhVien_last = (sv.get(sv.size()-1)).getMaSinhVien() ; 
            int bonSoCuoi = Integer.parseInt(maSinhVien_last.substring(3)) ; 
            bonSoCuoi++ ; 

            String maSinhVien = "SV0"+String.valueOf(bonSoCuoi) ;

            sv.add(new SinhVien(maSinhVien, hoDem, ten, ngaySinh, gioiTinh)) ;
            System.out.println("Them thanh cong:") ;
            System.out.println(new SinhVien(maSinhVien, hoDem, ten, ngaySinh, gioiTinh)) ;

        }while(!line.equals("exit")) ; 

        return sv ;
    }

    public static void SuaSinhVien(ArrayList<SinhVien> sv)
    {
        Scanner sc = new Scanner(System.in) ; 

        System.out.println("Nhap ma sinh vien muon sua") ; 
        System.out.println("Nhap:") ; 
        String line = sc.nextLine() ;
        
        for(SinhVien i:sv)
            if(line.equals(i.getMaSinhVien()))
            {
                System.out.println("Tim thay sinh vien:") ;
                System.out.println(i) ; 
                System.out.println() ;
                System.out.println("Nhap lai thong tin sinh vien theo dinh dang") ;
                System.out.println("[ho va ten];[ngay sinh(dd/MM/yyyy)];[gioi tinh(Nam/Nu)]") ;
                System.out.println("Neu khong muon sua muc nao thi bo trong muc do") ; 
                System.out.println("Vi du:Nguyen Van A;;Nam") ; 
                System.out.println("Nhap:") ; 

                String line2 = sc.nextLine() ; 
                String[] items = line2.split(";") ;

                String fullName = items[0] ; 
                String ngaySinh = items[1] ; 
                String gioiTinh = items[2] ; 
                
                if(!fullName.equals(""))
                {
                    int index_lastSpace = fullName.lastIndexOf(" ") ;
                    String hoDem = fullName.substring(0,index_lastSpace) ;
                    String ten = fullName.substring(index_lastSpace+1) ;

                    i.setHoDem(hoDem) ;
                    i.setTen(ten) ;
                }

                if(!gioiTinh.equals(""))
                    i.setGioiTinh(gioiTinh) ;
                    
                if(!ngaySinh.equals(""))
                    i.setNgaySinh(ngaySinh);
                    
                System.out.println("Sua thanh cong:") ;
                System.out.println(i) ;
                    
                return ;
            }
            
        System.out.println("Khong tim thay sinh vien") ; 
    }

    public static ArrayList<SinhVien> XoaSinhVien(ArrayList<SinhVien> sv, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ;

        System.out.println("Nhap ma sinh vien muon xoa:") ; 
        System.out.println("Nhap:") ; 
        String line = sc.nextLine() ;

        int i, check=0 ;  // check kt xem ma sv co ton tai khong

        for(i=0;i<sv.size();i++)
            if(line.equals((sv.get(i)).getMaSinhVien()))
            {
                check=1 ;
                break ; 
            }
        
        if(check==0)
        {
            System.out.println("Khong tim thay sinh vien") ; // khong tim thay sv hoac sinh vien da co diem nen khong xoa duoc
            return sv ;
        }
            
        for(Diem k:d)
            if(line.equals(k.getMaSinhVien()))
            {
                System.out.println("Sinh vien nay da co diem, khong the xoa") ;
                return sv ;  // sv da co diem -> ko dc xoa
            }
        System.out.println("Tim thay:") ; 
        System.out.println(sv.get(i)) ; 
        System.out.println() ;
        System.out.println("Ban co chac chan muon xoa(c/k)?") ;
        String delete = sc.nextLine() ; 

        if(delete.equals("c"))
        {
            sv.remove(i) ;
            System.out.println("Xoa thanh cong!") ; 
            return sv ; 
        }
                     
        return sv ;
    }

    public static void HienThiDanhSachSinhVien(ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, ArrayList<Diem> d)
    {
        Scanner sc = new Scanner(System.in) ; 
        QuanLyBangDiem QLBD = new QuanLyBangDiem() ; 
        ArrayList<String> maSv = new ArrayList<>() ; 

        // Sap xep theo ten sinh vien truoc khi hien thi
        Collections.sort(sv, new Comparator<SinhVien>()
		{
			public int compare(SinhVien a, SinhVien b)
			{
				return a.getTen().compareTo(b.getTen()) ; 
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
    
        int count = 0, count2, chon ; 

        for(int k=0;k<tongSoTrang;k++)
        {
            System.out.println("-----------------DANH SACH SINH VIEN-----------------------") ; 
            System.out.println("----------------------trang "+(k+1)+"/"+tongSoTrang+"------------------") ; 
            System.out.println("---------------------------------------------------------------------------------") ;
            System.out.println("|   Ma    |   Ho dem                  |   Ten          |  ngay sinh   |Gioi tinh|") ;
            System.out.println("---------------------------------------------------------------------------------") ;

            count2 = 0 ; 
            for(int i=count;i<soPhanTu*(k+1);i++)
            {
                if(i==sv.size())
                    break ; 

                maSv.add(sv.get(i).getMaSinhVien()) ;
                System.out.println(sv.get(i).InThongTin()) ;
                count++ ; 
                count2++ ; 
            }

            System.out.println("---------------------------------------------------------------------------------") ;
            System.out.println() ; 
            System.out.println("----------------------trang "+(k+1)+"/"+tongSoTrang+"------------------") ; 
            System.out.println() ; 

            System.out.println("1. Xem trang tiep theo") ; 
            System.out.println("2. Xem chi tiet bang diem") ; 
            System.out.println("0. Tro ve menu truoc") ; 
            System.out.println() ;
            System.out.println("Chon:") ; 
            chon = sc.nextInt() ; 

            if(chon==1)
            {
                maSv.clear() ;
                if(count!=sv.size())
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
