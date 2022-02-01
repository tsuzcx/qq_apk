package com.facebook.stetho.dumpapp.plugins;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class CrashDumperPlugin
  implements DumperPlugin
{
  private static final String NAME = "crash";
  private static final String OPTION_EXIT_DEFAULT = "0";
  private static final String OPTION_KILL_DEFAULT = "9";
  private static final String OPTION_THROW_DEFAULT = "java.lang.Error";
  
  /* Error */
  private void doKill(DumperContext paramDumperContext, Iterator<String> paramIterator)
    throws DumpException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 19
    //   3: invokestatic 39	com/facebook/stetho/dumpapp/ArgsHelper:nextOptionalArg	(Ljava/util/Iterator;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: new 41	java/lang/ProcessBuilder
    //   10: dup
    //   11: iconst_0
    //   12: anewarray 43	java/lang/String
    //   15: invokespecial 46	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   18: iconst_3
    //   19: anewarray 43	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 48
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: new 50	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   36: ldc 53
    //   38: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: invokestatic 67	android/os/Process:myPid	()I
    //   54: invokestatic 71	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   57: aastore
    //   58: invokevirtual 75	java/lang/ProcessBuilder:command	([Ljava/lang/String;)Ljava/lang/ProcessBuilder;
    //   61: iconst_1
    //   62: invokevirtual 79	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   65: invokevirtual 83	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   68: astore_2
    //   69: aload_2
    //   70: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   73: aload_1
    //   74: invokevirtual 95	com/facebook/stetho/dumpapp/DumperContext:getStdout	()Ljava/io/PrintStream;
    //   77: sipush 1024
    //   80: newarray byte
    //   82: invokestatic 101	com/facebook/stetho/common/Util:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)V
    //   85: aload_2
    //   86: invokevirtual 104	java/lang/Process:destroy	()V
    //   89: return
    //   90: astore_1
    //   91: aload_2
    //   92: invokevirtual 104	java/lang/Process:destroy	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_1
    //   98: new 31	com/facebook/stetho/dumpapp/DumpException
    //   101: dup
    //   102: new 50	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   109: ldc 106
    //   111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	CrashDumperPlugin
    //   0	125	1	paramDumperContext	DumperContext
    //   0	125	2	paramIterator	Iterator<String>
    // Exception table:
    //   from	to	target	type
    //   69	85	90	finally
    //   7	69	97	java/io/IOException
    //   85	89	97	java/io/IOException
    //   91	97	97	java/io/IOException
  }
  
  private void doSystemExit(Iterator<String> paramIterator)
  {
    System.exit(Integer.parseInt(ArgsHelper.nextOptionalArg(paramIterator, "0")));
  }
  
  /* Error */
  private void doUncaughtException(Iterator<String> paramIterator)
    throws DumpException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 22
    //   3: invokestatic 39	com/facebook/stetho/dumpapp/ArgsHelper:nextOptionalArg	(Ljava/util/Iterator;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: invokestatic 149	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   11: astore_1
    //   12: aload_1
    //   13: iconst_1
    //   14: anewarray 145	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: ldc 43
    //   21: aastore
    //   22: invokestatic 153	com/facebook/stetho/dumpapp/plugins/CrashDumperPlugin:tryGetDeclaredConstructor	(Ljava/lang/Class;[Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   25: astore_2
    //   26: aload_2
    //   27: ifnull +45 -> 72
    //   30: aload_2
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc 155
    //   39: aastore
    //   40: invokevirtual 161	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 163	java/lang/Throwable
    //   46: astore_1
    //   47: new 165	java/lang/Thread
    //   50: dup
    //   51: new 8	com/facebook/stetho/dumpapp/plugins/CrashDumperPlugin$ThrowRunnable
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 168	com/facebook/stetho/dumpapp/plugins/CrashDumperPlugin$ThrowRunnable:<init>	(Ljava/lang/Throwable;)V
    //   59: invokespecial 171	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 173	java/lang/Thread:start	()V
    //   67: aload_1
    //   68: invokestatic 177	com/facebook/stetho/common/Util:joinUninterruptibly	(Ljava/lang/Thread;)V
    //   71: return
    //   72: aload_1
    //   73: iconst_0
    //   74: anewarray 145	java/lang/Class
    //   77: invokevirtual 181	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokevirtual 161	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 163	java/lang/Throwable
    //   90: astore_1
    //   91: goto -44 -> 47
    //   94: astore_1
    //   95: new 31	com/facebook/stetho/dumpapp/DumpException
    //   98: dup
    //   99: new 50	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   106: ldc 183
    //   108: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 112	com/facebook/stetho/dumpapp/DumpException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 187	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   127: invokestatic 193	com/facebook/stetho/common/ExceptionUtil:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   130: athrow
    //   131: astore_1
    //   132: goto -37 -> 95
    //   135: astore_1
    //   136: goto -41 -> 95
    //   139: astore_1
    //   140: goto -45 -> 95
    //   143: astore_1
    //   144: goto -49 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	CrashDumperPlugin
    //   0	147	1	paramIterator	Iterator<String>
    //   25	6	2	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   7	26	94	java/lang/ClassNotFoundException
    //   30	47	94	java/lang/ClassNotFoundException
    //   47	71	94	java/lang/ClassNotFoundException
    //   72	91	94	java/lang/ClassNotFoundException
    //   7	26	122	java/lang/reflect/InvocationTargetException
    //   30	47	122	java/lang/reflect/InvocationTargetException
    //   47	71	122	java/lang/reflect/InvocationTargetException
    //   72	91	122	java/lang/reflect/InvocationTargetException
    //   7	26	131	java/lang/InstantiationException
    //   30	47	131	java/lang/InstantiationException
    //   47	71	131	java/lang/InstantiationException
    //   72	91	131	java/lang/InstantiationException
    //   7	26	135	java/lang/ClassCastException
    //   30	47	135	java/lang/ClassCastException
    //   47	71	135	java/lang/ClassCastException
    //   72	91	135	java/lang/ClassCastException
    //   7	26	139	java/lang/IllegalAccessException
    //   30	47	139	java/lang/IllegalAccessException
    //   47	71	139	java/lang/IllegalAccessException
    //   72	91	139	java/lang/IllegalAccessException
    //   7	26	143	java/lang/NoSuchMethodException
    //   30	47	143	java/lang/NoSuchMethodException
    //   47	71	143	java/lang/NoSuchMethodException
    //   72	91	143	java/lang/NoSuchMethodException
  }
  
  private void doUsage(PrintStream paramPrintStream)
  {
    paramPrintStream.println("Usage: dumpapp crash " + "<command> [command-options]");
    paramPrintStream.println("Usage: dumpapp crash " + "throw");
    paramPrintStream.println("       dumpapp crash " + "kill");
    paramPrintStream.println("       dumpapp crash " + "exit");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash throw: Throw an uncaught exception (simulates a program crash)");
    paramPrintStream.println("    <Throwable>: Throwable class to use (default: java.lang.Error)");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash kill: Send a signal to this process (simulates the low memory killer)");
    paramPrintStream.println("    <SIGNAL>: Either signal name or number to send (default: 9)");
    paramPrintStream.println("              See `adb shell kill -l` for more information");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash exit: Invoke System.exit (simulates an abnormal Android exit strategy)");
    paramPrintStream.println("    <code>: Exit code (default: 0)");
  }
  
  @Nullable
  private static <T> Constructor<? extends T> tryGetDeclaredConstructor(Class<T> paramClass, Class<?>... paramVarArgs)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(paramVarArgs);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return null;
  }
  
  public void dump(DumperContext paramDumperContext)
    throws DumpException
  {
    Iterator localIterator = paramDumperContext.getArgsAsList().iterator();
    String str = ArgsHelper.nextOptionalArg(localIterator, null);
    if ("throw".equals(str)) {
      doUncaughtException(localIterator);
    }
    do
    {
      return;
      if ("kill".equals(str))
      {
        doKill(paramDumperContext, localIterator);
        return;
      }
      if ("exit".equals(str))
      {
        doSystemExit(localIterator);
        return;
      }
      doUsage(paramDumperContext.getStdout());
    } while (str == null);
    throw new DumpUsageException("Unsupported command: " + str);
  }
  
  public String getName()
  {
    return "crash";
  }
  
  static class ThrowRunnable
    implements Runnable
  {
    private final Throwable mThrowable;
    
    public ThrowRunnable(Throwable paramThrowable)
    {
      this.mThrowable = paramThrowable;
    }
    
    public void run()
    {
      ExceptionUtil.sneakyThrow(this.mThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin
 * JD-Core Version:    0.7.0.1
 */