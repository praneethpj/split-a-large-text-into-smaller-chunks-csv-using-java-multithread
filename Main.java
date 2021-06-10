

import merchantfilehandler.MerchantFileWriter;
import merchantfilehandler.MerchantFileHandler;
import merchantfilehandler.MerchantFileChecker;
import merchantfilehandler.MerchantInformation;

import java.util.Vector;


public  class Main {
    public static void main(String[] args) {
        MerchantFileHandler q=new MerchantFileHandler();

        //Inputs
        Vector<MerchantInformation> v=new Vector<>();
        MerchantInformation m1=new MerchantInformation();
        m1.setsMerchantID("001");
        m1.setsMerchantName("ABC");

        MerchantInformation m2=new MerchantInformation();
        m2.setsMerchantID("002");
        m2.setsMerchantName("DEF");

        MerchantInformation m3=new MerchantInformation();
        m3.setsMerchantID("003");
        m3.setsMerchantName("GHI");

        v.add(m1);
        v.add(m2);
        v.add(m3);


        MerchantFileChecker m= new MerchantFileChecker(q,v);
        MerchantFileWriter k= new MerchantFileWriter(q);

    }
}