import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05493.1;
import com.tencent.qphone.base.util.QLog;

public class tzq
{
  private static void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    uab.a().a().post(new QCircleLpReportDc05493.1(paramString1, paramLong4, paramLong1, paramLong2, paramLong3, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    i = 0;
    j = 0;
    l2 = 0L;
    try
    {
      int k = Integer.parseInt(paramString2);
      j = k;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        l1 = Long.parseLong(paramString3);
        switch (j)
        {
        default: 
          QLog.e("QCircleReportHelper_QCircleLpReportDc05493", 1, "QCircle launch report invalid input fromStr:!" + paramString2);
          a(paramString1, i, j, l1, paramLong, "", "", "", "", "", "", paramInt);
          return;
          localNumberFormatException = localNumberFormatException;
          QLog.e("QCircleReportHelper_QCircleLpReportDc05493", 1, "QCircle launch report invalid input fromStr:" + paramString2);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QCircleReportHelper_QCircleLpReportDc05493", 1, "QCircle launch report invalid input pushId:" + paramString3);
          long l1 = l2;
          continue;
          i = 1;
          continue;
          i = 2;
          continue;
          i = 2;
          l1 = 1L;
          continue;
          i = 3;
        }
      }
    }
    l1 = l2;
    if (!TextUtils.isEmpty(paramString3))
    {
      l1 = l2;
      if (!TextUtils.isDigitsOnly(paramString3)) {}
    }
  }
  
  private static int b()
  {
    return 5493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzq
 * JD-Core Version:    0.7.0.1
 */