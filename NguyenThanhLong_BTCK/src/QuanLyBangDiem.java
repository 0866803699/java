import java.util.ArrayList;

public class QuanLyBangDiem extends Diem
{
	public static double TimHeSoMonHoc(ArrayList<MonHoc> mh, String maMonHoc)
    {
        for(MonHoc i:mh)
            if(maMonHoc.equals(i.getMaMonHoc()))
                return i.getHeSoMonHoc() ; 
        
        return 0.0 ; 
    }

    public static String TimTenMonHoc(ArrayList<MonHoc> mh, String maMonHoc)
    {
        for(MonHoc i:mh)
            if(maMonHoc.equals(i.getMaMonHoc()))
                return i.getTenMonHoc() ; 
        
        return "" ; 
    }

    public static void HienThiBangDiemTheoTen(ArrayList<Diem> d, ArrayList<SinhVien> sv, ArrayList<MonHoc> mh, String maSv)
    {
        String hoDem = "" ;
        String ten = "" ; 
        String ngaySinh = "" ; 
        double DTK = 0.0 ; 
        double tongHeSo = 0.0 ; 
        ArrayList<String>  maMonHoc = new ArrayList<>() ; 
        ArrayList<Double> diem = new ArrayList<>() ; 
        ArrayList<String>  tenMonHoc = new ArrayList<>() ;

        for(SinhVien i:sv)
            if(maSv.equals(i.getMaSinhVien()))
            {
                hoDem += i.getHoDem() ; 
                ten += i.getTen() ; 
                ngaySinh += i.getNgaySinh() ; 
                break ;
            }

        for(Diem i:d)
            if(maSv.equals(i.getMaSinhVien()))
            {
                DTK = DTK + (i.getDiem()*TimHeSoMonHoc(mh, i.getMaMonHoc())) ;
                tongHeSo += TimHeSoMonHoc(mh, i.getMaMonHoc()) ;  

                maMonHoc.add(i.getMaMonHoc()) ; 
                diem.add(i.getDiem()) ; 
                tenMonHoc.add(TimTenMonHoc(mh,i.getMaMonHoc())) ; 
            }
        
        DTK = DTK/tongHeSo ; 
        DTK = (double) Math.round(DTK*100)/100 ; 

        System.out.println("----------------------------------------------------------------------") ; 
        
        String cot1 = "| Ma: "+maSv ; 
        for(int k=cot1.length();k<21;k++)
            cot1 += " " ;
        cot1 += "|" ; 

        String cot2 = " "+hoDem+" "+ten ; 
        for(int k=cot2.length();k<34;k++)
            cot2 += " " ; 
        cot2 += "|" ; 

        String cot3 = " "+ngaySinh ; 
        for(int k=cot3.length();k<12;k++)
            cot3 += " " ; 
        cot3 += "|" ;

        System.out.println(cot1+cot2+cot3) ; 

        System.out.println("----------------------------------------------------------------------") ;
        
        String cot4 = "| Diem tong ket" ; 
        for(int k=cot4.length();k<58;k++)
            cot4 += " " ; 
        cot4 += String.valueOf(DTK) ; 
        for(int k=cot4.length();k<69;k++)
            cot4 += " " ;
        cot4 += "|" ; 

        System.out.println(cot4) ; 

        System.out.println("----------------------------------------------------------------------") ;

        if(DTK != 0)    
        {
            for(int i=0;i<maMonHoc.size();i++)
            {
                String cot5 = "| "+maMonHoc.get(i)+"  " ;
                
                String cot6 = tenMonHoc.get(i) ; 
                for(int k=cot6.length();k<51;k++)
                    cot6 += " " ; 
                cot6 += String.valueOf(diem.get(i)) ; 
                for(int k=cot6.length();k<62;k++)
                    cot6 += " " ;
                cot6 += "|" ; 
                
                System.out.println(cot5+cot6) ; 
            }
        }
        else   // IN BANG DUOI
            System.out.println("| Sinh vien chua co diem mon nao                                     |") ;
        
        System.out.println("----------------------------------------------------------------------") ;  
    }
}
