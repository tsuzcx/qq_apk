package tmsdk.QQPIM;

public final class EImageLocation
{
  public static final EImageLocation EILOC_End = new EImageLocation(9, 4302, "EILOC_End");
  public static final EImageLocation EILOC_None;
  public static final EImageLocation EILOC_PB_Android_CloudSms_Top;
  public static final EImageLocation EILOC_PB_Android_Sms_Background;
  public static final EImageLocation EILOC_PB_Iphone_CloudSms_Top;
  public static final EImageLocation EILOC_PB_SymbianV3_CloudSms_Top;
  public static final EImageLocation EILOC_PB_SymbianV5_CloudSms_Top;
  public static final EImageLocation EILOC_SEC_Android_Ads_Entry_TopRight;
  public static final EImageLocation EILOC_SEC_Android_Main;
  public static final EImageLocation EILOC_SEC_Iphone_Ads_Top;
  public static final int _EILOC_End = 4302;
  public static final int _EILOC_None = 0;
  public static final int _EILOC_PB_Android_CloudSms_Top = 4202;
  public static final int _EILOC_PB_Android_Sms_Background = 4201;
  public static final int _EILOC_PB_Iphone_CloudSms_Top = 4301;
  public static final int _EILOC_PB_SymbianV3_CloudSms_Top = 4101;
  public static final int _EILOC_PB_SymbianV5_CloudSms_Top = 4150;
  public static final int _EILOC_SEC_Android_Ads_Entry_TopRight = 1202;
  public static final int _EILOC_SEC_Android_Main = 1201;
  public static final int _EILOC_SEC_Iphone_Ads_Top = 1301;
  private static EImageLocation[] em = new EImageLocation[10];
  private int eb;
  private String ec = new String();
  
  static
  {
    EILOC_None = new EImageLocation(0, 0, "EILOC_None");
    EILOC_SEC_Android_Main = new EImageLocation(1, 1201, "EILOC_SEC_Android_Main");
    EILOC_SEC_Android_Ads_Entry_TopRight = new EImageLocation(2, 1202, "EILOC_SEC_Android_Ads_Entry_TopRight");
    EILOC_SEC_Iphone_Ads_Top = new EImageLocation(3, 1301, "EILOC_SEC_Iphone_Ads_Top");
    EILOC_PB_SymbianV3_CloudSms_Top = new EImageLocation(4, 4101, "EILOC_PB_SymbianV3_CloudSms_Top");
    EILOC_PB_SymbianV5_CloudSms_Top = new EImageLocation(5, 4150, "EILOC_PB_SymbianV5_CloudSms_Top");
    EILOC_PB_Android_Sms_Background = new EImageLocation(6, 4201, "EILOC_PB_Android_Sms_Background");
    EILOC_PB_Android_CloudSms_Top = new EImageLocation(7, 4202, "EILOC_PB_Android_CloudSms_Top");
    EILOC_PB_Iphone_CloudSms_Top = new EImageLocation(8, 4301, "EILOC_PB_Iphone_CloudSms_Top");
  }
  
  private EImageLocation(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    em[paramInt1] = this;
  }
  
  public static EImageLocation convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      EImageLocation[] arrayOfEImageLocation = em;
      if (i >= arrayOfEImageLocation.length) {
        break;
      }
      if (arrayOfEImageLocation[i].value() == paramInt) {
        return em[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static EImageLocation convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      EImageLocation[] arrayOfEImageLocation = em;
      if (i >= arrayOfEImageLocation.length) {
        break;
      }
      if (arrayOfEImageLocation[i].toString().equals(paramString)) {
        return em[i];
      }
      i += 1;
    }
    return null;
  }
  
  public String toString()
  {
    return this.ec;
  }
  
  public int value()
  {
    return this.eb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.EImageLocation
 * JD-Core Version:    0.7.0.1
 */