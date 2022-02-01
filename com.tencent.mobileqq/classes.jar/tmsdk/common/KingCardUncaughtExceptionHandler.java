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
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = SDK_PACKAGES;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      localObject = paramThread.getName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uncaughtException thread:");
      localStringBuilder.append(paramThread.getName());
      localStringBuilder.append(", e:");
      localStringBuilder.append(paramThrowable);
      Log.d("KingCardUEH", localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label310;
      }
      if (!((String)localObject).equals(Looper.getMainLooper().getThread().getName())) {
        break label120;
      }
      localObject = paramThrowable.getStackTrace();
      j = localObject.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        int j;
        label120:
        long l;
        label310:
        continue;
        i += 1;
        continue;
        label343:
        int i = 1;
        continue;
        label348:
        i = 0;
      }
    }
    if (i < j) {
      if (checkClazzFromSdk(localObject[i].getClassName()))
      {
        break label343;
        if (!((String)localObject).startsWith("kingcardsdk_")) {
          break label348;
        }
        break label343;
        if (i != 0)
        {
          i = this.mDao.getInt("ks_e_ts", 0);
          l = this.mDao.getLong("ks_e_f_t", 0L);
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
        localObject = this.ueh;
        if (localObject != null) {
          ((Thread.UncaughtExceptionHandler)localObject).uncaughtException(paramThread, paramThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmsdk.common.KingCardUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */