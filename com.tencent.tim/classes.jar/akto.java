import mqq.app.AppRuntime.Status;

public class akto
{
  public AppRuntime.Status f = AppRuntime.Status.online;
  public int iconId;
  public String iconUrl;
  public long id;
  public int itemType = 1;
  public String title;
  
  public akto(long paramLong, String paramString1, String paramString2)
  {
    this.id = paramLong;
    this.title = paramString1;
    this.iconUrl = paramString2;
  }
  
  public akto(AppRuntime.Status paramStatus)
  {
    this.itemType = 2;
    this.f = paramStatus;
    this.id = 0L;
    this.iconId = aktk.a(paramStatus);
    this.title = aktk.a(paramStatus);
  }
  
  public static String a(AppRuntime.Status paramStatus, long paramLong)
  {
    return paramStatus.getValue() + "" + paramLong + "";
  }
  
  public static boolean cw(long paramLong)
  {
    return paramLong == 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akto
 * JD-Core Version:    0.7.0.1
 */