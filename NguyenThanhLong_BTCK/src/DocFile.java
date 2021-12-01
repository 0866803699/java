import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DocFile
{
    public ArrayList<SinhVien> ReadSinhVienFromFile()
    {
        ArrayList<SinhVien> sv = new ArrayList<>() ;
        
        try
        {
            File reader = new File("data/sinhvien_en.txt") ; 
            Scanner sc = new Scanner(reader) ; 

            sc.nextLine() ; // bo dong gioi thieu
            while(sc.hasNextLine())
            {
                String line = sc.nextLine() ; 
                String[] items = line.split(";") ;

                sv.add(new SinhVien(items[0],items[1],items[2],items[3],items[4])) ; 
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Doc file sinhvien_en.txt that bai !!") ;
        }
        return sv ;
    }

    public ArrayList<MonHoc> ReadMonHocFromFile()
    {
        ArrayList<MonHoc> mh = new ArrayList<>() ;
        
        try
        {
            File reader = new File("data/monhoc_en.txt") ; 
            Scanner sc = new Scanner(reader) ; 

            sc.nextLine() ; // bo dong gioi thieu
            while(sc.hasNextLine())
            {
                String line = sc.nextLine() ; 
                String[] items = line.split(";") ;

                mh.add(new MonHoc(items[0],items[1],Double.parseDouble(items[2]))) ; 
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Doc file monhoc_en.txt that bai !!") ;
        }
        return mh ;
    }

    public ArrayList<Diem> ReadDiemFromFile()
    {
        ArrayList<Diem> d = new ArrayList<>() ;
        
        try
        {
            File reader = new File("data/diem.txt") ; 
            Scanner sc = new Scanner(reader) ; 

            sc.nextLine() ; // bo dong gioi thieu
            while(sc.hasNextLine())
            {
                String line = sc.nextLine() ; 
                String[] items = line.split(";") ;

                d.add(new Diem(items[0],items[1],Double.parseDouble(items[2]))) ; 
            }
            sc.close();
        }catch(Exception e){
            System.out.println("Doc file diem.txt that bai !!") ;
        }
        return d ;
    }
}