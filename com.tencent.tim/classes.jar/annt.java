import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.statistics.CaughtException;
import com.tencent.mobileqq.statistics.CaughtExceptionReport.1;
import com.tencent.mobileqq.statistics.CaughtExceptionReport.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;

public final class annt
{
  private static final Set<String> cZ = new CaughtExceptionReport.1(20);
  private static final Set<Class> da = new CaughtExceptionReport.2(5);
  
  private static boolean d(Throwable paramThrowable)
  {
    if (da.contains(paramThrowable.getClass())) {
      return true;
    }
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable == null) || (paramThrowable.length < 1)) {
      return false;
    }
    paramThrowable = paramThrowable[0].getClassName();
    Iterator localIterator = cZ.iterator();
    while (localIterator.hasNext()) {
      if (paramThrowable.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static void e(@NonNull Throwable paramThrowable)
  {
    e(paramThrowable, "This is CaughtException");
  }
  
  public static void e(@NonNull Throwable paramThrowable, @NonNull String paramString)
  {
    if ((paramThrowable == null) || (paramString == null)) {
      return;
    }
    if (!d(paramThrowable))
    {
      Log.e("CaughtExceptionReport", "this report is not permitted. ", paramThrowable);
      return;
    }
    Object localObject = paramThrowable;
    if (!(paramThrowable instanceof CaughtException)) {
      localObject = new CaughtException("Caught: " + paramThrowable.getMessage(), paramThrowable);
    }
    if (QLog.isColorLevel()) {
      QLog.e("CaughtExceptionReport-eup", 2, "rqd将上报信息到rdm网站，上报不会导致客户端闪退，仅用作数据统计");
    }
    CrashReport.handleCatchException(Thread.currentThread(), (Throwable)localObject, "ExtraMessage: " + paramString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     annt
 * JD-Core Version:    0.7.0.1
 */