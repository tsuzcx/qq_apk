package com.tencent.qapmsdk.common.logger;

import android.os.Handler;
import android.util.Log;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/Logger;", "Lcom/tencent/qapmsdk/common/logger/ILoger;", "()V", "DEFAULT_PROXY", "Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "TAG", "", "debug", "", "intLevel", "", "getIntLevel", "()I", "setIntLevel", "(I)V", "level", "Lcom/tencent/qapmsdk/common/logger/LogState;", "logLevel", "getLogLevel", "()Lcom/tencent/qapmsdk/common/logger/LogState;", "setLogLevel", "(Lcom/tencent/qapmsdk/common/logger/LogState;)V", "value", "logProxy", "getLogProxy", "()Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "setLogProxy", "(Lcom/tencent/qapmsdk/common/logger/ILogProxy;)V", "logTimeFormatter", "Ljava/text/SimpleDateFormat;", "d", "", "args", "", "([Ljava/lang/String;)V", "e", "exception", "tag", "msg", "throwable", "", "getThrowableMessage", "i", "resetLogLevel", "v", "w", "DefaultLogProxy", "common_release"}, k=1, mv={1, 1, 15})
public final class Logger
  implements ILoger
{
  private static final ILogProxy DEFAULT_PROXY;
  public static final Logger INSTANCE = new Logger();
  private static final String TAG = "QAPM_common_Logger";
  @JvmField
  public static boolean debug;
  private static int intLevel = LogState.OFF.getValue();
  @NotNull
  private static LogState logLevel = LogState.OFF;
  @Nullable
  private static ILogProxy logProxy = DEFAULT_PROXY;
  private static SimpleDateFormat logTimeFormatter;
  
  static
  {
    DEFAULT_PROXY = (ILogProxy)new DefaultLogProxy();
    logTimeFormatter = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
  }
  
  public void d(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.DEBUG, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void e(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.ERROR, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public final void exception(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    if ((paramString1 == null) || (paramThrowable == null)) {}
    while (logLevel.compareTo((Enum)LogState.ERROR) < 0) {
      return;
    }
    if (paramString2 != null) {}
    for (;;)
    {
      e(new String[] { paramString1, paramString2, getThrowableMessage(paramThrowable) });
      return;
      paramString2 = "";
    }
  }
  
  public final void exception(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    if ((paramString == null) || (paramThrowable == null)) {}
    while (logLevel.compareTo((Enum)LogState.ERROR) < 0) {
      return;
    }
    e(new String[] { paramString, getThrowableMessage(paramThrowable) });
  }
  
  public final int getIntLevel()
  {
    return intLevel;
  }
  
  @NotNull
  public final LogState getLogLevel()
  {
    return logLevel;
  }
  
  @Nullable
  public final ILogProxy getLogProxy()
  {
    ILogProxy localILogProxy = logProxy;
    if (localILogProxy != null) {
      return localILogProxy;
    }
    return DEFAULT_PROXY;
  }
  
  @NotNull
  public final String getThrowableMessage(@Nullable Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter((Writer)localStringWriter));
    paramThrowable = localStringWriter.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramThrowable, "sw.toString()");
    return paramThrowable;
  }
  
  public void i(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.INFO, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public final void resetLogLevel(int paramInt)
  {
    LogState localLogState = LogState.Companion.getByValue(paramInt);
    if (localLogState != null) {}
    for (;;)
    {
      setLogLevel(localLogState);
      return;
      localLogState = LogState.OFF;
    }
  }
  
  public final void setIntLevel(int paramInt)
  {
    intLevel = paramInt;
  }
  
  public final void setLogLevel(@NotNull LogState paramLogState)
  {
    Intrinsics.checkParameterIsNotNull(paramLogState, "level");
    if (paramLogState == LogState.DEBUG) {}
    for (boolean bool = true;; bool = false)
    {
      debug = bool;
      logLevel = paramLogState;
      intLevel = logLevel.getValue();
      return;
    }
  }
  
  public final void setLogProxy(@Nullable ILogProxy paramILogProxy)
  {
    synchronized (INSTANCE.getClass())
    {
      logProxy = paramILogProxy;
      paramILogProxy = Unit.INSTANCE;
      return;
    }
  }
  
  public void v(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.VERBOS, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  public void w(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    ILogProxy localILogProxy = getLogProxy();
    if (localILogProxy != null) {
      localILogProxy.doLog(LogState.WARN, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy;", "Lcom/tencent/qapmsdk/common/logger/ILogProxy;", "()V", "flushing", "", "lastTimeMillis", "", "logFile", "Ljava/io/File;", "logQueueSize", "", "readQueue", "Ljava/util/concurrent/BlockingQueue;", "", "sb", "Ljava/lang/StringBuffer;", "workQueue1", "workQueue2", "writerQueue", "doLog", "", "state", "Lcom/tencent/qapmsdk/common/logger/LogState;", "args", "", "(Lcom/tencent/qapmsdk/common/logger/LogState;[Ljava/lang/String;)V", "flush", "logInfo", "swapQueue", "writeLogFile", "common_release"}, k=1, mv={1, 1, 15})
  public static final class DefaultLogProxy
    implements ILogProxy
  {
    private volatile boolean flushing;
    private long lastTimeMillis;
    private File logFile;
    private final int logQueueSize = 1024;
    private BlockingQueue<String> readQueue = this.workQueue1;
    private final StringBuffer sb = new StringBuffer(2048);
    private final BlockingQueue<String> workQueue1 = (BlockingQueue)new LinkedBlockingQueue(this.logQueueSize);
    private final BlockingQueue<String> workQueue2 = (BlockingQueue)new LinkedBlockingQueue(this.logQueueSize);
    private BlockingQueue<String> writerQueue = this.workQueue2;
    
    /* Error */
    private final void swapQueue()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 69	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue1	Ljava/util/concurrent/BlockingQueue;
      //   6: aload_0
      //   7: getfield 75	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:writerQueue	Ljava/util/concurrent/BlockingQueue;
      //   10: if_acmpne +26 -> 36
      //   13: aload_0
      //   14: aload_0
      //   15: getfield 71	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue2	Ljava/util/concurrent/BlockingQueue;
      //   18: putfield 75	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:writerQueue	Ljava/util/concurrent/BlockingQueue;
      //   21: aload_0
      //   22: aload_0
      //   23: getfield 69	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue1	Ljava/util/concurrent/BlockingQueue;
      //   26: putfield 73	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:readQueue	Ljava/util/concurrent/BlockingQueue;
      //   29: getstatic 106	kotlin/Unit:INSTANCE	Lkotlin/Unit;
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: return
      //   36: aload_0
      //   37: aload_0
      //   38: getfield 69	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue1	Ljava/util/concurrent/BlockingQueue;
      //   41: putfield 75	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:writerQueue	Ljava/util/concurrent/BlockingQueue;
      //   44: aload_0
      //   45: aload_0
      //   46: getfield 71	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:workQueue2	Ljava/util/concurrent/BlockingQueue;
      //   49: putfield 73	com/tencent/qapmsdk/common/logger/Logger$DefaultLogProxy:readQueue	Ljava/util/concurrent/BlockingQueue;
      //   52: goto -23 -> 29
      //   55: astore_1
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_1
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	DefaultLogProxy
      //   32	1	1	localUnit	Unit
      //   55	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	29	55	finally
      //   29	33	55	finally
      //   36	52	55	finally
    }
    
    private final void writeLogFile()
    {
      new Handler(ThreadManager.Companion.getLogThreadLooper()).post((Runnable)new Logger.DefaultLogProxy.writeLogFile.1(this));
    }
    
    public void doLog(@NotNull LogState paramLogState, @NotNull String... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramLogState, "state");
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
      if (Logger.INSTANCE.getLogLevel().compareTo((Enum)paramLogState) >= 0)
      {
        if (paramVarArgs.length != 0) {
          break label40;
        }
        i = 1;
        if (i == 0) {
          break label45;
        }
      }
      label40:
      label45:
      String str1;
      do
      {
        return;
        i = 0;
        break;
        str1 = paramVarArgs[0];
      } while ((str1 == null) || (paramVarArgs.length <= 1));
      StringBuilder localStringBuilder = new StringBuilder(256);
      int j = paramVarArgs.length;
      int i = 1;
      while (i < j)
      {
        localStringBuilder.append(paramVarArgs[i]);
        i += 1;
      }
      String str2 = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(str2, "logS.toString()");
      paramVarArgs = "";
      switch (Logger.DefaultLogProxy.WhenMappings.$EnumSwitchMapping$0[paramLogState.ordinal()])
      {
      default: 
        paramLogState = paramVarArgs;
      }
      for (;;)
      {
        localStringBuilder.delete(0, localStringBuilder.length());
        localStringBuilder.append(Logger.access$getLogTimeFormatter$p(Logger.INSTANCE).format(Long.valueOf(System.currentTimeMillis()))).append(paramLogState).append(str1).append(":    ").append(str2);
        try
        {
          paramLogState = localStringBuilder.toString();
          Intrinsics.checkExpressionValueIsNotNull(paramLogState, "logS.toString()");
          flush(paramLogState);
          return;
        }
        catch (Throwable paramLogState)
        {
          paramLogState.printStackTrace();
          return;
        }
        Log.v(str1, str2);
        paramLogState = "    VERBOS/";
        continue;
        Log.d(str1, str2);
        paramLogState = "    DEBUG/";
        continue;
        Log.i(str1, str2);
        paramLogState = "    INFO/";
        continue;
        Log.w(str1, str2);
        paramLogState = "    WARN/";
        continue;
        Log.e(str1, str2);
        paramLogState = "    ERROR/";
      }
    }
    
    public void flush(@NotNull String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "logInfo");
      if (!this.readQueue.offer(paramString))
      {
        swapQueue();
        this.readQueue.offer(paramString);
      }
      try
      {
        writeLogFile();
        paramString = Unit.INSTANCE;
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.Logger
 * JD-Core Version:    0.7.0.1
 */