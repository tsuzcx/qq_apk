package dualsim.common;

public abstract interface IPhoneInfoBridge
{
  public static final String KEY_IMEI_STRING = "imei";
  public static final String KEY_IMSI_STRING = "imsi";
  public static final String KEY_OAID_STRING = "oaid";
  public static final String KEY_PHONENUMBER_STRING = "phonenumber";
  
  public abstract Object getInfo(String paramString);
  
  public abstract boolean isAllow(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dualsim.common.IPhoneInfoBridge
 * JD-Core Version:    0.7.0.1
 */