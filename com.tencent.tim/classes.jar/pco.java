import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.1;

public class pco
{
  public static void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    a(paramString1, paramInt, paramLong1, paramLong2, "", "", "", "", paramString2);
  }
  
  public static void a(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int i = pcr.a().getPageId();
    int j = pcr.a().sb();
    pcu.a().getReportHandler().post(new QCircleLpReportDc05504.1(paramString1, paramInt, paramLong1, paramLong2, i, j, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void b(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    a(paramString, paramInt, paramLong1, paramLong2, "", "", "", "", "");
  }
  
  public static void h(String paramString, int paramInt, long paramLong)
  {
    a(paramString, paramInt, paramLong, 0L, "", "", "", "", "");
  }
  
  private static int sa()
  {
    return 5504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pco
 * JD-Core Version:    0.7.0.1
 */