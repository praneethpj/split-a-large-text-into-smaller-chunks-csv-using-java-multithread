package merchantfilehandler;


import java.io.BufferedOutputStream;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

//PraneethPJ
public  class MerchantFileChecker implements  Runnable{
    MerchantFileHandler merchantFileHandler;

    final double FILE_SIZE = 999900;//chnage file size
    final String OFO="OFFLINE";
    final String MIF="MMFILE";

    private DateTimeFormatter formatter ;
    private String today;
    private String name="";
    private BufferedOutputStream bufferedWriter;
    private String fileName = "";
    private String path ="";
    private Vector<MerchantInformation> merchantInformations;



    public MerchantFileChecker(MerchantFileHandler merchantFileHandler,Vector<MerchantInformation> merchantInformations){
        this.merchantFileHandler=merchantFileHandler;
        this.bufferedWriter=merchantFileHandler.bufferedWriter;
        this.formatter = DateTimeFormatter.ofPattern("yyMMdd");
        this.today= LocalDate.now().format(formatter);
        this.merchantInformations=merchantInformations;
        this.name=OFO+today+"";
        this.path="C:\\Users\\Pubudu Praneeth\\Desktop\\";
        Thread thread=new Thread(this,"Producer");
        thread.start();
    }
    @Override
    public void run() {
        int i=0;
        int fileBatchId=0;
   
        for (MerchantInformation tmerchantInformation:merchantInformations){

            File file = new File(fileName);
            if(!file.exists()){
                fileName=path+name+String.format("%02d",fileBatchId)+MIF+".csv";
            }
            if(file.exists()) {
                System.out.println("SIZE : " + file.length());
            }
            if (file.length() > FILE_SIZE) {

                System.out.println("len "+file.length());
                fileName=path+name+String.format("%02d",fileBatchId)+MIF+".csv";
                System.out.println("create new file :"+fileName);
                fileBatchId++;
            }

            merchantFileHandler.csvFileCheck(i++,fileName,tmerchantInformation);
            try {
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        merchantFileHandler.stop=true;



    }
}
