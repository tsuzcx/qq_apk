import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class awcz
{
  private static Field z;
  
  public static final void h(Throwable paramThrowable, String paramString)
  {
    if (paramThrowable == null) {
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = Log.getStackTraceString(paramThrowable);
    }
    n(paramThrowable);
    QLog.d("QZoneExceptionReport", 2, "", paramThrowable);
    annt.e(paramThrowable, str);
  }
  
  private static void n(Throwable paramThrowable)
  {
    try
    {
      if (z == null) {
        z = Throwable.class.getDeclaredField("detailMessage");
      }
      z.setAccessible(true);
      z.set(paramThrowable, "QzoneCatchedException:" + paramThrowable.getMessage());
      return;
    }
    catch (Throwable paramThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZoneExceptionReport", 2, "addStackTag failed", paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awcz
 * JD-Core Version:    0.7.0.1
 */