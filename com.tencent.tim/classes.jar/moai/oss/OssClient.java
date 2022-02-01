package moai.oss;

public abstract interface OssClient
{
  public abstract void log(String paramString);
  
  public abstract void reportKv(int paramInt, String paramString1, double paramDouble, ReportType paramReportType, String paramString2);
  
  public abstract void reportOss(int paramInt, ReportType paramReportType, String paramString1, String paramString2);
  
  public abstract void reportXMailIdKey(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void reportXMailLog(int paramInt1, int paramInt2, String paramString1, ReportType paramReportType, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.OssClient
 * JD-Core Version:    0.7.0.1
 */