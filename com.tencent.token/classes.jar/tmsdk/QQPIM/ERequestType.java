package tmsdk.QQPIM;

public final class ERequestType
{
  public static final ERequestType ERT_CloudCheck;
  public static final ERequestType ERT_GetSoftInfo;
  public static final ERequestType ERT_GetSoftInfoNoDesc = new ERequestType(4, 4, "ERT_GetSoftInfoNoDesc");
  public static final ERequestType ERT_ReportAllSoft = new ERequestType(5, 5, "ERT_ReportAllSoft");
  public static final ERequestType ERT_ReportFeature;
  public static final ERequestType ERT_Report_Cloud_Get;
  public static final int _ERT_CloudCheck = 1;
  public static final int _ERT_GetSoftInfo = 2;
  public static final int _ERT_GetSoftInfoNoDesc = 4;
  public static final int _ERT_ReportAllSoft = 5;
  public static final int _ERT_ReportFeature = 0;
  public static final int _ERT_Report_Cloud_Get = 3;
  private static ERequestType[] et = new ERequestType[6];
  private int eb;
  private String ec = new String();
  
  static
  {
    ERT_ReportFeature = new ERequestType(0, 0, "ERT_ReportFeature");
    ERT_CloudCheck = new ERequestType(1, 1, "ERT_CloudCheck");
    ERT_GetSoftInfo = new ERequestType(2, 2, "ERT_GetSoftInfo");
    ERT_Report_Cloud_Get = new ERequestType(3, 3, "ERT_Report_Cloud_Get");
  }
  
  private ERequestType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    et[paramInt1] = this;
  }
  
  public static ERequestType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ERequestType[] arrayOfERequestType = et;
      if (i >= arrayOfERequestType.length) {
        break;
      }
      if (arrayOfERequestType[i].value() == paramInt) {
        return et[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static ERequestType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      ERequestType[] arrayOfERequestType = et;
      if (i >= arrayOfERequestType.length) {
        break;
      }
      if (arrayOfERequestType[i].toString().equals(paramString)) {
        return et[i];
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
 * Qualified Name:     tmsdk.QQPIM.ERequestType
 * JD-Core Version:    0.7.0.1
 */