package moai.patch.log;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import moai.patch.MoaiApplication;
import moai.patch.exception.MoaiExceptionHandler;
import moai.patch.handle.PatchHandler;

public class PatchLog
{
  private static Context context;
  private static Log logger;
  private static List<PendingLog> pendingLogs = new ArrayList();
  private static int processId = -1;
  private static String processName = "";
  
  private static void callbackSend(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
  {
    Log localLog = PatchHandler.getLogger();
    if (localLog != null)
    {
      localLog.log(paramInt2, paramInt1, paramString1, paramLong, paramString2, paramInt3);
      return;
    }
    android.util.Log.w("patch", "logId:" + paramInt1 + ",msg:" + paramString1 + ",cost:" + paramLong);
  }
  
  private static boolean checkPeerReady()
  {
    return ((!MoaiApplication.isPatchProcess(context)) && (MoaiApplication.isStartUpEnd())) || (MoaiApplication.isPatchProcess(context));
  }
  
  public static void cost(int paramInt, long paramLong)
  {
    log(6, paramInt, "", paramLong);
  }
  
  public static void d(String paramString)
  {
    log(3, 2, paramString);
  }
  
  public static void e(int paramInt, String paramString)
  {
    log(6, paramInt, paramString);
  }
  
  public static void e(int paramInt, String paramString, Throwable paramThrowable)
  {
    e(paramInt, paramString + "\n" + android.util.Log.getStackTraceString(paramThrowable));
  }
  
  public static void flushPendingLogs()
  {
    Log localLog = PatchHandler.getLogger();
    int i;
    int j;
    label12:
    PendingLog localPendingLog;
    if (localLog == null)
    {
      i = 1;
      j = 0;
      if (j >= pendingLogs.size()) {
        return;
      }
      localPendingLog = (PendingLog)pendingLogs.get(j);
      if (i == 0) {
        break label105;
      }
      android.util.Log.w("patch", "logId:" + localPendingLog.getLogId() + ",msg:" + localPendingLog.getLog() + ",cost:" + localPendingLog.getCost());
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = 0;
      break;
      label105:
      localLog.log(localPendingLog.getLevel(), localPendingLog.getLogId(), localPendingLog.getLog(), localPendingLog.getCost(), localPendingLog.getProcessName(), localPendingLog.getProcessId());
    }
  }
  
  public static void i(int paramInt, String paramString)
  {
    log(4, paramInt, paramString);
  }
  
  public static void i(int paramInt, String paramString, long paramLong)
  {
    log(4, paramInt, paramString, paramLong);
  }
  
  public static void init(Context paramContext, File paramFile, String paramString, int paramInt)
  {
    context = paramContext;
    logger = new Log.LogPrinter(paramFile);
    processName = paramString;
    processId = paramInt;
    d("init, sdk: " + Build.VERSION.SDK_INT);
  }
  
  private static void log(int paramInt1, int paramInt2, String paramString)
  {
    log(paramInt1, paramInt2, paramString, 0L);
  }
  
  private static void log(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    if (checkPeerReady()) {
      if (MoaiApplication.isPatchProcess(context)) {
        serviceSend(paramInt2, paramInt1, paramString, paramLong, processName, processId);
      }
    }
    for (;;)
    {
      logger.log(paramInt1, paramInt2, paramString, paramLong, processName, processId);
      return;
      callbackSend(paramInt2, paramInt1, paramString, paramLong, processName, processId);
      continue;
      pendingLogs.add(new PendingLog(paramInt1, paramInt2, paramString, paramLong, processName, processId));
    }
  }
  
  public static void reportCrashedFile(Context paramContext)
  {
    paramContext = MoaiExceptionHandler.getCrashStackFiles(paramContext);
    if ((paramContext != null) && (paramContext.length >= 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramContext[i].getAbsolutePath()).append("\n");
        i += 1;
      }
      log(6, 10004, localStringBuilder.toString());
    }
  }
  
  private static void serviceSend(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
  {
    Intent localIntent = new Intent(context, PatchEventService.class);
    localIntent.putExtra("logId", paramInt1);
    localIntent.putExtra("level", paramInt2);
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("cost", paramLong);
    localIntent.putExtra("processName", paramString2);
    localIntent.putExtra("processId", paramInt3);
    try
    {
      context.startService(localIntent);
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void v(String paramString)
  {
    log(2, 1, paramString);
  }
  
  public static void w(int paramInt, String paramString)
  {
    w(paramInt, paramString, 0L);
  }
  
  public static void w(int paramInt, String paramString, long paramLong)
  {
    log(5, paramInt, paramString, paramLong);
  }
  
  public static void w(int paramInt, String paramString, Throwable paramThrowable)
  {
    w(paramInt, paramString + "\n" + android.util.Log.getStackTraceString(paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.patch.log.PatchLog
 * JD-Core Version:    0.7.0.1
 */