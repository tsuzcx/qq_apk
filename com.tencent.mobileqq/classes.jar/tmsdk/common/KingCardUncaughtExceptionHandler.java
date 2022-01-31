package tmsdk.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;

public class KingCardUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final int MAX_EXCEPTION_TIMES = 5;
  private static final String SDK_EXCEPTION_FIRST_TIME = "ks_e_f_t";
  private static final String SDK_EXCEPTION_TIMES = "ks_e_ts";
  private static final String[] SDK_PACKAGES = { "tmsdk.common", "dualsim.common", "kcsdkext", "kcsdkint", "com.qq.taf.jce", "com.tencent.patchcore.imp", "com.tencent.tmsdual.roach", "com.tencent.tmsdualcore", "tmsdk.common.gourd" };
  private static final String TAG = "KingCardUEH";
  private IKingCardExceptionCallback mCallback;
  private SharedPreferences mDao;
  private final Thread.UncaughtExceptionHandler ueh = Thread.getDefaultUncaughtExceptionHandler();
  
  KingCardUncaughtExceptionHandler(Context paramContext, IKingCardExceptionCallback paramIKingCardExceptionCallback)
  {
    this.mDao = paramContext.getSharedPreferences("kc_ueh", 0);
    this.mCallback = paramIKingCardExceptionCallback;
  }
  
  private boolean checkClazzFromSdk(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      arrayOfString = SDK_PACKAGES;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString.startsWith(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    int j = 1;
    for (;;)
    {
      try
      {
        localObject = paramThread.getName();
        Log.d("KingCardUEH", "uncaughtException thread:" + paramThread.getName() + ", e:" + paramThrowable);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (!((String)localObject).equals(Looper.getMainLooper().getThread().getName())) {
            continue;
          }
          localObject = paramThrowable.getStackTrace();
          int k = localObject.length;
          i = 0;
          if (i >= k) {
            continue;
          }
          if (!checkClazzFromSdk(localObject[i].getClassName())) {
            continue;
          }
          i = j;
          if (i != 0)
          {
            i = this.mDao.getInt("ks_e_ts", 0);
            long l = this.mDao.getLong("ks_e_f_t", 0L);
            if (l == 0L) {
              this.mDao.edit().putLong("ks_e_f_t", System.currentTimeMillis()).commit();
            }
            localObject = this.mDao.edit();
            i += 1;
            ((SharedPreferences.Editor)localObject).putInt("ks_e_ts", i).commit();
            if (i >= 5)
            {
              if ((System.currentTimeMillis() - l < TimeUnit.DAYS.toMillis(1L)) && (this.mCallback != null)) {
                this.mCallback.onException();
              }
              this.mDao.edit().putInt("ks_e_ts", 0).apply();
              this.mDao.edit().putLong("ks_e_f_t", 0L).commit();
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i;
        boolean bool;
        continue;
      }
      if (this.ueh != null) {
        this.ueh.uncaughtException(paramThread, paramThrowable);
      }
      return;
      i += 1;
      continue;
      bool = ((String)localObject).startsWith("kingcardsdk_");
      i = j;
      if (!bool) {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdk.common.KingCardUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */