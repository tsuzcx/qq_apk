import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aaze
{
  public static String[] ax = { "MI 3", "Coolpad 8675", "OPPO R7", "Redmi Note 2", "MX4", "vivo X5L", "m3 note", "PRO 6" };
  public static AtomicBoolean ce = new AtomicBoolean(false);
  
  public static void bj(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        if (Integer.valueOf(paramString).intValue() == 0)
        {
          ce.set(false);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideo.ProgressiveUtils", 2, "parseConfig(): config = " + paramString + ", sProgressiveEnable = " + ce.get());
          }
          return;
        }
        ce.set(true);
        continue;
      }
      catch (Exception localException)
      {
        ce.set(false);
        continue;
      }
      ce.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaze
 * JD-Core Version:    0.7.0.1
 */