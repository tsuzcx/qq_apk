import android.os.Build;
import com.tencent.qphone.base.util.QLog;

public class j
{
  public static final String aP = Build.MANUFACTURER;
  public static final String aQ = Build.MODEL;
  
  public static void b(String paramString1, long paramLong, String paramString2)
  {
    if (!i.isDebug) {
      return;
    }
    float f = (float)(System.nanoTime() - paramLong) / 1000000.0F;
    i(paramString1, paramString2 + "  绘制耗时：" + f + "ms\n  手机型号：" + aP + "  " + aQ);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    QLog.e(paramString1, 1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     j
 * JD-Core Version:    0.7.0.1
 */