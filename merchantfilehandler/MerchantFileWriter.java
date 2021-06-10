package merchantfilehandler;

//PraneethPJ
public class MerchantFileWriter implements Runnable {
    MerchantFileHandler merchantFileHandler;


    public MerchantFileWriter(MerchantFileHandler merchantFileHandler) {
        this.merchantFileHandler = merchantFileHandler;
        Thread thread = new Thread(this, "MerchantFileWriter");
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (!merchantFileHandler.stop) {

            merchantFileHandler.csvFileWrite();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (merchantFileHandler.stop) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        if (merchantFileHandler.stop) {
            Thread.currentThread().interrupt();

        }
    }
}