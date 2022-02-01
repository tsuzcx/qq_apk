package com.b.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class u
{
  public static boolean a = Log.isLoggable("Volley", 2);
  private static String b = "Volley";
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (a) {
      Log.v(b, d(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(b, d(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    Log.d(b, d(paramString, paramVarArgs));
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    Log.e(b, d(paramString, paramVarArgs));
  }
  
  private static String d(String paramString, Object... paramVarArgs)
  {
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label154;
      }
      if (paramVarArgs[i].getClass().equals(u.class)) {
        break label147;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label147:
    label154:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i += 1;
      break label20;
    }
  }
  
  static final class a
  {
    public static final boolean a = u.a;
    private final List<a> b = new ArrayList();
    private boolean c = false;
    
    /* Error */
    public final void a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield 30	com/b/a/u$a:c	Z
      //   7: aload_0
      //   8: getfield 28	com/b/a/u$a:b	Ljava/util/List;
      //   11: invokeinterface 37 1 0
      //   16: istore_2
      //   17: iload_2
      //   18: ifne +14 -> 32
      //   21: lconst_0
      //   22: lstore_3
      //   23: lload_3
      //   24: lconst_0
      //   25: lcmp
      //   26: ifgt +55 -> 81
      //   29: aload_0
      //   30: monitorexit
      //   31: return
      //   32: aload_0
      //   33: getfield 28	com/b/a/u$a:b	Ljava/util/List;
      //   36: iconst_0
      //   37: invokeinterface 41 2 0
      //   42: checkcast 9	com/b/a/u$a$a
      //   45: getfield 44	com/b/a/u$a$a:c	J
      //   48: lstore_3
      //   49: aload_0
      //   50: getfield 28	com/b/a/u$a:b	Ljava/util/List;
      //   53: aload_0
      //   54: getfield 28	com/b/a/u$a:b	Ljava/util/List;
      //   57: invokeinterface 37 1 0
      //   62: iconst_1
      //   63: isub
      //   64: invokeinterface 41 2 0
      //   69: checkcast 9	com/b/a/u$a$a
      //   72: getfield 44	com/b/a/u$a$a:c	J
      //   75: lload_3
      //   76: lsub
      //   77: lstore_3
      //   78: goto -55 -> 23
      //   81: aload_0
      //   82: getfield 28	com/b/a/u$a:b	Ljava/util/List;
      //   85: iconst_0
      //   86: invokeinterface 41 2 0
      //   91: checkcast 9	com/b/a/u$a$a
      //   94: getfield 44	com/b/a/u$a$a:c	J
      //   97: lstore 5
      //   99: ldc 46
      //   101: iconst_2
      //   102: anewarray 4	java/lang/Object
      //   105: dup
      //   106: iconst_0
      //   107: lload_3
      //   108: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   111: aastore
      //   112: dup
      //   113: iconst_1
      //   114: aload_1
      //   115: aastore
      //   116: invokestatic 55	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   119: aload_0
      //   120: getfield 28	com/b/a/u$a:b	Ljava/util/List;
      //   123: invokeinterface 59 1 0
      //   128: astore_1
      //   129: lload 5
      //   131: lstore_3
      //   132: aload_1
      //   133: invokeinterface 65 1 0
      //   138: ifeq -109 -> 29
      //   141: aload_1
      //   142: invokeinterface 69 1 0
      //   147: checkcast 9	com/b/a/u$a$a
      //   150: astore 7
      //   152: aload 7
      //   154: getfield 44	com/b/a/u$a$a:c	J
      //   157: lstore 5
      //   159: ldc 71
      //   161: iconst_3
      //   162: anewarray 4	java/lang/Object
      //   165: dup
      //   166: iconst_0
      //   167: lload 5
      //   169: lload_3
      //   170: lsub
      //   171: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   174: aastore
      //   175: dup
      //   176: iconst_1
      //   177: aload 7
      //   179: getfield 73	com/b/a/u$a$a:b	J
      //   182: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   185: aastore
      //   186: dup
      //   187: iconst_2
      //   188: aload 7
      //   190: getfield 76	com/b/a/u$a$a:a	Ljava/lang/String;
      //   193: aastore
      //   194: invokestatic 55	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   197: lload 5
      //   199: lstore_3
      //   200: goto -68 -> 132
      //   203: astore_1
      //   204: aload_0
      //   205: monitorexit
      //   206: aload_1
      //   207: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	208	0	this	a
      //   0	208	1	paramString	String
      //   16	2	2	i	int
      //   22	178	3	l1	long
      //   97	101	5	l2	long
      //   150	39	7	locala	a
      // Exception table:
      //   from	to	target	type
      //   2	17	203	finally
      //   32	78	203	finally
      //   81	129	203	finally
      //   132	197	203	finally
    }
    
    public final void a(String paramString, long paramLong)
    {
      try
      {
        if (this.c) {
          throw new IllegalStateException("Marker added to finished log");
        }
      }
      finally {}
      this.b.add(new a(paramString, paramLong, SystemClock.elapsedRealtime()));
    }
    
    protected final void finalize()
      throws Throwable
    {
      if (!this.c)
      {
        a("Request on the loose");
        u.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    static final class a
    {
      public final String a;
      public final long b;
      public final long c;
      
      public a(String paramString, long paramLong1, long paramLong2)
      {
        this.a = paramString;
        this.b = paramLong1;
        this.c = paramLong2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.u
 * JD-Core Version:    0.7.0.1
 */