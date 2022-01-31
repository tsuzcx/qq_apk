package cooperation.qzone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.qzone.component.util.SecurityUtil;
import ibq;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashGuard
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = 0L;
  private static final int b = 15;
  private static final int c = 3;
  private Handler jdField_a_of_type_AndroidOsHandler;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public static int a()
  {
    return QzoneConfig.a().a("SafeModeSetting", "StartDuration", 15) * 1000;
  }
  
  public static CrashGuard a()
  {
    return CrashGuard.H.a;
  }
  
  public static int b()
  {
    return QzoneConfig.a().a("SafeModeSetting", "CrashMax", 3);
  }
  
  public void a(Handler paramHandler, long paramLong)
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler = localHandler;
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ibq(this, paramLong);
    }
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = a();
    }
    localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, jdField_a_of_type_Int);
  }
  
  public void a(Throwable paramThrowable, long paramLong)
  {
    int j = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    int i = QZoneHelper.LocalConfig.a("key_crash_count", 0, paramLong);
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = a();
    }
    if (System.currentTimeMillis() - jdField_a_of_type_Long <= jdField_a_of_type_Int)
    {
      i += 1;
      paramThrowable = String.valueOf(paramLong);
      if (i < b()) {
        break label165;
      }
      i = j;
      if (!TextUtils.isEmpty(paramThrowable))
      {
        String str = SecurityUtil.a(paramThrowable);
        BaseApplication.getContext().deleteDatabase(str);
        QLog.i("QZLog", 1, "crash in a row, delete db for " + paramThrowable);
        i = j;
      }
    }
    label165:
    for (;;)
    {
      QZoneHelper.LocalConfig.a("key_crash_count", i, paramLong);
      return;
      QLog.i("QZLog", 1, "clear crash count with overtime");
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.CrashGuard
 * JD-Core Version:    0.7.0.1
 */