import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05503.1;

public class pcn
{
  public static void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    pcu.a().getReportHandler().post(new QCircleLpReportDc05503.1(paramLong1, paramLong2, paramLong3, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt));
  }
  
  public static void c(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    a(paramLong1, paramLong2, paramLong3, "", "", "", "", "", "", paramInt);
  }
  
  private static int sa()
  {
    return 5503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcn
 * JD-Core Version:    0.7.0.1
 */