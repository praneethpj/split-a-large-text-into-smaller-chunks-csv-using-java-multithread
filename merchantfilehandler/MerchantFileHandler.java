package merchantfilehandler;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

//PraneethPJ
public class MerchantFileHandler {
    int num;
    boolean valueSet =false;
    String oldName="";
    public static BufferedOutputStream bufferedWriter ;
    public   MerchantInformation vector;
    String header="SequenceNumber,MerchantID,MerchantName,MCC"+"\n";
    String fileName="";
    boolean firstTime=true;
    boolean stop=false;

    public synchronized  void csvFileCheck (int num,String fileName,MerchantInformation merchantInformations){

        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("CsvFileCheck : "+num);
        this.num = num;
        this.fileName=fileName;
        this.vector=merchantInformations;
        File file=new File(fileName);

        if(!file.exists()){
            try {
                System.out.println(file);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        valueSet = true;
        notify();

    }
    public synchronized void  csvFileWrite(){
        while (!valueSet){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        System.out.println("csvFileWrite File :"+fileName);

        try {
            if(oldName!=fileName) {

                bufferedWriter = new BufferedOutputStream(new FileOutputStream(fileName, true));
                System.out.println("new");
            }
            if(bufferedWriter!=null) {
                String mechant="num"+num+",";
                if(firstTime){
                    // for (int col=0;col<4;col++) {


                    bufferedWriter.write(header.getBytes());
                    bufferedWriter.write(vector.getsMerchantID().getBytes());
                    bufferedWriter.write(vector.getsMerchantName().getBytes());

                    firstTime = false;
                    // }
                }else{
                    bufferedWriter.write(vector.getsMerchantID().getBytes());
                    bufferedWriter.write(vector.getsMerchantName().getBytes());

                }

                System.out.println("a num " + num);
                bufferedWriter.flush();
                oldName=fileName;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        valueSet=false;
        notify();
    }

}