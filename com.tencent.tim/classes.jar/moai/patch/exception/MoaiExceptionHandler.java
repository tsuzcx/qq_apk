package moai.patch.exception;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import moai.patch.extra.ExceptionHandler;
import moai.patch.log.PatchLog;
import moai.patch.sharedpref.SharedPrefUtil;
import moai.patch.util.ManifestUtil;

@SuppressLint({"CommitPrefEdits"})
public class MoaiExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String CRASH_STACK_FILE_PREFIX = "moai.crash.";
  private static final String FAST_FAIL_COUNT = "fast_fail_count";
  private static boolean sDone;
  private Context context;
  private Thread.UncaughtExceptionHandler defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
  private String processName;
  
  public MoaiExceptionHandler(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.processName = paramString;
  }
  
  public static void done()
  {
    sDone = true;
  }
  
  public static File getCrashStackDir(Context paramContext)
  {
    return paramContext.getCacheDir();
  }
  
  public static File[] getCrashStackFiles(Context paramContext)
  {
    return paramContext.getCacheDir().listFiles(new MoaiExceptionHandler.1());
  }
  
  public static boolean handle(Context paramContext, Thread paramThread, String paramString, Throwable paramThrowable)
  {
    boolean bool = SharedPrefUtil.isAppPatched(paramContext);
    SharedPreferences localSharedPreferences;
    int i;
    if (bool)
    {
      localSharedPreferences = FastFail.getFastFailSp(paramContext);
      i = localSharedPreferences.getInt("fast_fail_count", 0);
      if (i < 2) {
        break label223;
      }
      FastFail.fastFailHappen(paramContext, i, paramString);
    }
    for (;;)
    {
      paramString = "Process:" + paramString + "\nPatched:" + bool + "\nThread name:" + paramThread.getName() + "\nThread id:" + paramThread.getId();
      paramThread = paramString + "\n" + Log.getStackTraceString(paramThrowable);
      PatchLog.e(1038, paramString + ",err:" + paramThrowable.getMessage());
      paramString = "moai.crash." + System.currentTimeMillis() + ".log";
      paramContext = new File(getCrashStackDir(paramContext), paramString);
      label223:
      try
      {
        paramContext = new FileOutputStream(paramContext, true);
        paramContext.write(paramThread.getBytes());
        paramContext.flush();
        paramContext.close();
        return true;
      }
      catch (Exception paramContext) {}
      localSharedPreferences.edit().putInt("fast_fail_count", i + 1).commit();
    }
    return false;
  }
  
  private static boolean implement(Class paramClass)
  {
    boolean bool2 = false;
    paramClass = paramClass.getInterfaces();
    int j = paramClass.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramClass[i].equals(ExceptionHandler.class)) {
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
    Object localObject;
    if (!sDone)
    {
      handle(this.context, paramThread, this.processName, paramThrowable);
      String str = ManifestUtil.exceptionHandlerClassName(this.context);
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (str.startsWith(".")) {
          localObject = this.context.getPackageName() + str;
        }
      }
    }
    try
    {
      localObject = Class.forName((String)localObject, true, this.context.getClassLoader());
      if (implement((Class)localObject)) {
        ((ExceptionHandler)((Class)localObject).newInstance()).handle(this.context, paramThread, paramThrowable);
      }
      this.defaultHandler.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        PatchLog.w(-1, "call app exception handler failed", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.exception.MoaiExceptionHandler
 * JD-Core Version:    0.7.0.1
 */