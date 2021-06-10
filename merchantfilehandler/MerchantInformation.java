package merchantfilehandler;

public class MerchantInformation {

    private int iSequenceNumber;
    private String sAcquirerIIN;
    private String sMerchantID;
    private String sMerchantName;
    private String sMCC;
    private int iIsOnlineMerchant;
    private int iUnionPayQRCapability;
    private int iCountryRegionCode;
    private String sMerchantBusinessName;
    private String sMerchantLegalName;


    public int getiSequenceNumber() {
        return iSequenceNumber;
    }

    public void setiSequenceNumber(int iSequenceNumber) {
        this.iSequenceNumber = iSequenceNumber;
    }

    public String getsAcquirerIIN() {
        return sAcquirerIIN;
    }

    public void setsAcquirerIIN(String sAcquirerIIN) {
        this.sAcquirerIIN = sAcquirerIIN;
    }

    public String getsMerchantID() {
        return sMerchantID;
    }

    public void setsMerchantID(String sMerchantID) {
        this.sMerchantID = sMerchantID;
    }

    public String getsMerchantName() {
        return sMerchantName;
    }

    public void setsMerchantName(String sMerchantName) {
        this.sMerchantName = sMerchantName;
    }

    public String getsMCC() {
        return sMCC;
    }

    public void setsMCC(String sMCC) {
        this.sMCC = sMCC;
    }

    public int getiIsOnlineMerchant() {
        return iIsOnlineMerchant;
    }

    public void setiIsOnlineMerchant(int iIsOnlineMerchant) {
        this.iIsOnlineMerchant = iIsOnlineMerchant;
    }

    public int getiUnionPayQRCapability() {
        return iUnionPayQRCapability;
    }

    public void setiUnionPayQRCapability(int iUnionPayQRCapability) {
        this.iUnionPayQRCapability = iUnionPayQRCapability;
    }

    public int getiCountryRegionCode() {
        return iCountryRegionCode;
    }

    public void setiCountryRegionCode(int iCountryRegionCode) {
        this.iCountryRegionCode = iCountryRegionCode;
    }

    public String getsMerchantBusinessName() {
        return sMerchantBusinessName;
    }

    public void setsMerchantBusinessName(String sMerchantBusinessName) {
        this.sMerchantBusinessName = sMerchantBusinessName;
    }

    public String getsMerchantLegalName() {
        return sMerchantLegalName;
    }

    public void setsMerchantLegalName(String sMerchantLegalName) {
        this.sMerchantLegalName = sMerchantLegalName;
    }
}
