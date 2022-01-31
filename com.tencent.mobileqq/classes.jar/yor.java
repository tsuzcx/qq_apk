import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class yor
{
  private static AppInterface a;
  
  private static void a(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (bbfj.b(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      a(paramString, arrayOfString, paramLong);
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public static void a(String paramString, long paramLong, short paramShort)
  {
    if (paramShort == 0) {
      a(paramString, paramLong);
    }
    while (paramShort != 1) {
      return;
    }
    b(paramString, paramLong);
  }
  
  private static void a(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if ((a == null) || (paramArrayOfString == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TrafficStatistics", 2, "application or tags is null, return.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str = a.getCurrentAccountUin();
        a.sendAppDataIncerment(str, paramArrayOfString, paramLong);
        if (QLog.isColorLevel())
        {
          QLog.d("TrafficStatistics", 2, paramString + " fileSize: " + paramLong);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static void b(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (bbfj.b(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterUploadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      a(paramString, arrayOfString, paramLong);
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterUploadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yor
 * JD-Core Version:    0.7.0.1
 */