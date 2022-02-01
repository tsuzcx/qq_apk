package tmsdk.QQPIM;

public final class FBIReportType
{
  public static final FBIReportType FBI_FEEDBACK = new FBIReportType(1, 1, "FBI_FEEDBACK");
  public static final FBIReportType FBI_REPORT;
  public static final int _FBI_FEEDBACK = 1;
  public static final int _FBI_REPORT = 0;
  private static FBIReportType[] ey = new FBIReportType[2];
  private int eb;
  private String ec = new String();
  
  static
  {
    FBI_REPORT = new FBIReportType(0, 0, "FBI_REPORT");
  }
  
  private FBIReportType(int paramInt1, int paramInt2, String paramString)
  {
    this.ec = paramString;
    this.eb = paramInt2;
    ey[paramInt1] = this;
  }
  
  public static FBIReportType convert(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      FBIReportType[] arrayOfFBIReportType = ey;
      if (i >= arrayOfFBIReportType.length) {
        break;
      }
      if (arrayOfFBIReportType[i].value() == paramInt) {
        return ey[i];
      }
      i += 1;
    }
    return null;
  }
  
  public static FBIReportType convert(String paramString)
  {
    int i = 0;
    for (;;)
    {
      FBIReportType[] arrayOfFBIReportType = ey;
      if (i >= arrayOfFBIReportType.length) {
        break;
      }
      if (arrayOfFBIReportType[i].toString().equals(paramString)) {
        return ey[i];
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
 * Qualified Name:     tmsdk.QQPIM.FBIReportType
 * JD-Core Version:    0.7.0.1
 */