package moai.log;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"InlinedApi"})
public class MLogManager
{
  public static final String SHARED_PREFERENCES_NAME = "mlog";
  private static HashMap<String, MLog> loggers = new HashMap();
  private static int sPid;
  private static String sSimpleProcessName;
  
  private static void fetchProcessInfo(Context paramContext)
  {
    Object localObject2 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int i = Process.myPid();
    paramContext = "M";
    Object localObject1 = paramContext;
    int j;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      localObject1 = paramContext;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        if (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i) {
          break label110;
        }
        paramContext = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        j = paramContext.indexOf(':');
        if (j < 0) {
          paramContext = "M";
        }
      }
    }
    label110:
    for (;;)
    {
      break;
      paramContext = paramContext.substring(j + 1);
      continue;
      sPid = i;
      sSimpleProcessName = (String)localObject1;
      return;
    }
  }
  
  public static MLog getAnonymousLogger()
  {
    try
    {
      MLog localMLog = (MLog)loggers.get("");
      Object localObject1 = localMLog;
      if (localMLog == null)
      {
        localObject1 = new MLogImpl();
        loggers.put("", localObject1);
      }
      return localObject1;
    }
    finally {}
  }
  
  /* Error */
  public static MLog getLogger(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 112	java/lang/String:length	()I
    //   11: ifne +19 -> 30
    //   14: new 114	java/lang/IllegalArgumentException
    //   17: dup
    //   18: ldc 116
    //   20: invokespecial 119	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    //   30: getstatic 26	moai/log/MLogManager:loggers	Ljava/util/HashMap;
    //   33: aload_0
    //   34: invokevirtual 98	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 100	moai/log/MLog
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: ifnonnull +20 -> 64
    //   47: new 102	moai/log/MLogImpl
    //   50: dup
    //   51: invokespecial 103	moai/log/MLogImpl:<init>	()V
    //   54: astore_1
    //   55: getstatic 26	moai/log/MLogManager:loggers	Ljava/util/HashMap;
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 107	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramString	String
    //   42	26	1	localObject	Object
    //   40	4	2	localMLog	MLog
    // Exception table:
    //   from	to	target	type
    //   7	14	24	finally
    //   14	24	24	finally
    //   30	41	24	finally
    //   47	64	24	finally
  }
  
  public static void init(Context paramContext)
  {
    fetchProcessInfo(paramContext);
  }
  
  public static void init(String paramString)
  {
    sSimpleProcessName = paramString;
  }
  
  static int myPid()
  {
    if (sPid == 0) {
      sPid = Process.myPid();
    }
    return sPid;
  }
  
  static String mySimpleProcessName()
  {
    return sSimpleProcessName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.MLogManager
 * JD-Core Version:    0.7.0.1
 */