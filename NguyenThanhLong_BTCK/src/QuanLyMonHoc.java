import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyMonHoc extends MonHoc
{
    public static void HienThiDanhSachMonHoc(ArrayList<MonHoc> mh)
    {
        Scanner sc = new Scanner(System.in) ; 
        // Sap xep theo ten mon hoc truoc khi hien thi
        Collections.sort(mh, new Comparator<MonHoc>()
		{
			public int compare(MonHoc a, MonHoc b)
			{
				return a.getTenMonHoc().compareTo(b.getTenMonHoc()) ; 
			}
		}) ;

        int tongSoTrang ;
        if(mh.size()%30==0)
            tongSoTrang = mh.size()/30 ; 
        else
            tongSoTrang = mh.size()/30 + 1 ; 

        int soPhanTu ;
        if(mh.size()>=30)
            soPhanTu = 30 ; 
        else
            soPhanTu = mh.size() ;     
    
        int count = 0 ; 
        int chon ;  

        for(int j=0;j<tongSoTrang;j++)
        {
            System.out.println("---------------------DANH SACH MON HOC---------------------") ;
            System.out.println("--------------------------trang "+(j+1)+"/"+tongSoTrang+"-----------------") ; 
            System.out.println("-------------------------------------------------") ; 
            System.out.println("|  Ma  |         Ten mon hoc          |  he so  |") ; 
            System.out.println("-------------------------------------------------") ; 

            for(int i=count;i<soPhanTu*(j+1);i++)
            {
                if(i==mh.size())
                {
                    System.out.println("-------------------------------------------------") ; 
                    System.out.println() ; 
                    System.out.println("--------------------------trang "+(j+1)+"/"+tongSoTrang+"-----------------") ; 
                    System.out.println() ; 
                    System.out.println("Nhan phim 0 de tro ve menu truoc") ;
                    do
                    {
                        chon = sc.nextInt() ; 
                    }while(chon!=0) ; 
                    return ; 
                }

                String cot1 = "|  "+mh.get(i).getMaMonHoc()+" |" ; 

                String cot2 = " "+mh.get(i).getTenMonHoc() ; 
                for(int k=cot2.length();k<30;k++)
                    cot2 += " " ; 
                cot2 += "|" ; 

                String cot3 = "   "+mh.get(i).getHeSoMonHoc() ; 
                for(int k=cot3.length();k<9;k++)
                    cot3 += " " ; 
                cot3 += "|" ; 

                System.out.println(cot1+cot2+cot3) ; 
                count++ ; 
            }

            System.out.println("-------------------------------------------------") ; 
            System.out.println() ; 
            System.out.println("--------------------------trang "+(j+1)+"/"+tongSoTrang+"-----------------") ; 
            System.out.println() ; 
            System.out.println("1. Xem trang tiep theo") ; 
            System.out.println("0. Tro ve menu truoc") ; 
            chon = sc.nextInt() ; 

            if(chon==1)
                continue ; 
            else
                return ;
        }
    }
}
