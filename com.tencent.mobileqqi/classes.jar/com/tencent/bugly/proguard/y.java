package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class y
{
  public static boolean a;
  private static SimpleDateFormat b = null;
  private static int c;
  private static StringBuilder d;
  private static StringBuilder e;
  private static boolean f;
  private static a g;
  private static String h;
  private static String i;
  private static Context j;
  private static String k;
  private static boolean l;
  private static boolean m;
  private static int n;
  private static final Object o;
  
  static
  {
    a = true;
    c = 5120;
    m = false;
    o = new Object();
    try
    {
      b = new SimpleDateFormat("MM-dd HH:mm:ss");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(int paramInt)
  {
    synchronized (o)
    {
      c = paramInt;
      if (paramInt < 0) {
        c = 0;
      }
      while (paramInt <= 10240) {
        return;
      }
      c = 10240;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 63	com/tencent/bugly/proguard/y:l	Z
    //   6: ifne +15 -> 21
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: getstatic 39	com/tencent/bugly/proguard/y:a	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +7 -> 25
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 65	java/lang/StringBuilder
    //   28: dup
    //   29: iconst_0
    //   30: invokespecial 67	java/lang/StringBuilder:<init>	(I)V
    //   33: putstatic 69	com/tencent/bugly/proguard/y:e	Ljava/lang/StringBuilder;
    //   36: new 65	java/lang/StringBuilder
    //   39: dup
    //   40: iconst_0
    //   41: invokespecial 67	java/lang/StringBuilder:<init>	(I)V
    //   44: putstatic 71	com/tencent/bugly/proguard/y:d	Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: putstatic 73	com/tencent/bugly/proguard/y:j	Landroid/content/Context;
    //   51: aload_0
    //   52: invokestatic 78	com/tencent/bugly/crashreport/common/info/a:a	(Landroid/content/Context;)Lcom/tencent/bugly/crashreport/common/info/a;
    //   55: astore_0
    //   56: aload_0
    //   57: getfield 80	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   60: putstatic 82	com/tencent/bugly/proguard/y:h	Ljava/lang/String;
    //   63: aload_0
    //   64: invokevirtual 86	java/lang/Object:getClass	()Ljava/lang/Class;
    //   67: pop
    //   68: ldc 88
    //   70: putstatic 90	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   73: new 65	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 73	com/tencent/bugly/proguard/y:j	Landroid/content/Context;
    //   83: invokevirtual 97	android/content/Context:getFilesDir	()Ljava/io/File;
    //   86: invokevirtual 103	java/io/File:getPath	()Ljava/lang/String;
    //   89: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 109
    //   94: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: getstatic 82	com/tencent/bugly/proguard/y:h	Ljava/lang/String;
    //   100: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 111
    //   105: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 90	com/tencent/bugly/proguard/y:i	Ljava/lang/String;
    //   111: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 113
    //   116: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: putstatic 118	com/tencent/bugly/proguard/y:k	Ljava/lang/String;
    //   125: invokestatic 124	android/os/Process:myPid	()I
    //   128: putstatic 126	com/tencent/bugly/proguard/y:n	I
    //   131: iconst_1
    //   132: putstatic 63	com/tencent/bugly/proguard/y:l	Z
    //   135: goto -114 -> 21
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    //   144: astore_0
    //   145: goto -14 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramContext	Context
    //   16	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	9	138	finally
    //   13	17	138	finally
    //   25	131	138	finally
    //   131	135	138	finally
    //   25	131	144	java/lang/Throwable
  }
  
  public static void a(String arg0, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (l)
        {
          boolean bool = a;
          if (bool) {}
        }
        else
        {
          return;
        }
        if ((m) && (b(???, paramString2, paramString3))) {
          continue;
        }
        long l1 = Process.myTid();
        d.setLength(0);
        String str = paramString3;
        if (paramString3.length() > 30720) {
          str = paramString3.substring(paramString3.length() - 30720, paramString3.length() - 1);
        }
        paramString3 = new Date();
        if (b != null)
        {
          paramString3 = b.format(paramString3);
          d.append(paramString3).append(" ").append(n).append(" ").append(l1).append(" ").append(???).append(" ").append(paramString2).append(": ").append(str).append("\001\r\n");
          paramString2 = d.toString();
          synchronized (o)
          {
            e.append(paramString2);
            if (e.length() > c) {
              break label223;
            }
          }
        }
        paramString3 = paramString3.toString();
      }
      finally {}
      continue;
      label223:
      if (f) {}
      f = true;
      w.a().a(new Runnable()
      {
        public final void run()
        {
          synchronized ()
          {
            label53:
            do
            {
              try
              {
                if (y.c() != null) {
                  continue;
                }
                y.a(new y.a(y.d()));
                if (y.c().a(y.e().toString()))
                {
                  y.e().setLength(0);
                  y.b(false);
                }
              }
              catch (Throwable localThrowable)
              {
                break label53;
              }
              return;
            } while ((y.a.a(y.c()) != null) && (y.a.a(y.c()).length() + y.e().length() <= y.a.b(y.c())));
            y.a.c(y.c());
          }
        }
      });
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    String str2 = paramThrowable.getMessage();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    a(paramString1, paramString2, str1 + '\n' + z.b(paramThrowable));
  }
  
  public static void a(boolean paramBoolean)
  {
    x.a("[LogUtil] Whether can record user log into native: " + paramBoolean, new Object[0]);
    m = paramBoolean;
  }
  
  public static byte[] a()
  {
    if (!a) {
      return null;
    }
    if (m)
    {
      x.a("[LogUtil] Get user log from native.", new Object[0]);
      ??? = f();
      if (??? != null)
      {
        x.a("[LogUtil] Got user log from native: %d bytes", new Object[] { Integer.valueOf(((String)???).length()) });
        return z.a(null, (String)???, "BuglyNativeLog.txt");
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    synchronized (o)
    {
      if ((g != null) && (a.d(g)) && (a.a(g) != null) && (a.a(g).length() > 0L)) {
        localStringBuilder.append(z.a(a.a(g), 30720, true));
      }
      if ((e != null) && (e.length() > 0)) {
        localStringBuilder.append(e.toString());
      }
      return z.a(null, localStringBuilder.toString(), "BuglyLog.txt");
    }
  }
  
  private static boolean b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
      if ((locala != null) && (locala.E != null))
      {
        boolean bool = locala.E.appendLogToNative(paramString1, paramString2, paramString3);
        return bool;
      }
    }
    catch (Throwable paramString1)
    {
      if (!x.a(paramString1)) {
        paramString1.printStackTrace();
      }
    }
    return false;
  }
  
  private static String f()
  {
    try
    {
      Object localObject = com.tencent.bugly.crashreport.common.info.a.b();
      if ((localObject != null) && (((com.tencent.bugly.crashreport.common.info.a)localObject).E != null))
      {
        localObject = ((com.tencent.bugly.crashreport.common.info.a)localObject).E.getLogFromNative();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  public static final class a
  {
    private boolean a;
    private File b;
    private String c;
    private long d;
    private long e = 30720L;
    
    public a(String paramString)
    {
      if ((paramString == null) || (paramString.equals(""))) {
        return;
      }
      this.c = paramString;
      this.a = a();
    }
    
    private boolean a()
    {
      try
      {
        this.b = new File(this.c);
        if ((this.b.exists()) && (!this.b.delete()))
        {
          this.a = false;
          return false;
        }
        if (!this.b.createNewFile())
        {
          this.a = false;
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        x.a(localThrowable);
        this.a = false;
        return false;
      }
      return true;
    }
    
    /* Error */
    public final boolean a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 39	com/tencent/bugly/proguard/y$a:a	Z
      //   4: ifne +5 -> 9
      //   7: iconst_0
      //   8: ireturn
      //   9: new 70	java/io/FileOutputStream
      //   12: dup
      //   13: aload_0
      //   14: getfield 43	com/tencent/bugly/proguard/y$a:b	Ljava/io/File;
      //   17: iconst_1
      //   18: invokespecial 73	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   21: astore_3
      //   22: aload_3
      //   23: astore_2
      //   24: aload_1
      //   25: ldc 75
      //   27: invokevirtual 79	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   30: astore_1
      //   31: aload_3
      //   32: astore_2
      //   33: aload_3
      //   34: aload_1
      //   35: invokevirtual 83	java/io/FileOutputStream:write	([B)V
      //   38: aload_3
      //   39: astore_2
      //   40: aload_3
      //   41: invokevirtual 86	java/io/FileOutputStream:flush	()V
      //   44: aload_3
      //   45: astore_2
      //   46: aload_3
      //   47: invokevirtual 89	java/io/FileOutputStream:close	()V
      //   50: aload_3
      //   51: astore_2
      //   52: aload_0
      //   53: aload_0
      //   54: getfield 91	com/tencent/bugly/proguard/y$a:d	J
      //   57: aload_1
      //   58: arraylength
      //   59: i2l
      //   60: ladd
      //   61: putfield 91	com/tencent/bugly/proguard/y$a:d	J
      //   64: aload_3
      //   65: astore_2
      //   66: aload_0
      //   67: iconst_1
      //   68: putfield 39	com/tencent/bugly/proguard/y$a:a	Z
      //   71: aload_3
      //   72: invokevirtual 89	java/io/FileOutputStream:close	()V
      //   75: iconst_1
      //   76: ireturn
      //   77: astore 4
      //   79: aconst_null
      //   80: astore_1
      //   81: aload_1
      //   82: astore_2
      //   83: aload 4
      //   85: invokestatic 63	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
      //   88: pop
      //   89: aload_1
      //   90: astore_2
      //   91: aload_0
      //   92: iconst_0
      //   93: putfield 39	com/tencent/bugly/proguard/y$a:a	Z
      //   96: aload_1
      //   97: ifnull -90 -> 7
      //   100: aload_1
      //   101: invokevirtual 89	java/io/FileOutputStream:close	()V
      //   104: iconst_0
      //   105: ireturn
      //   106: astore_1
      //   107: iconst_0
      //   108: ireturn
      //   109: astore_1
      //   110: aconst_null
      //   111: astore_2
      //   112: aload_2
      //   113: ifnull +7 -> 120
      //   116: aload_2
      //   117: invokevirtual 89	java/io/FileOutputStream:close	()V
      //   120: aload_1
      //   121: athrow
      //   122: astore_1
      //   123: goto -48 -> 75
      //   126: astore_2
      //   127: goto -7 -> 120
      //   130: astore_1
      //   131: goto -19 -> 112
      //   134: astore 4
      //   136: aload_3
      //   137: astore_1
      //   138: goto -57 -> 81
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	this	a
      //   0	141	1	paramString	String
      //   23	94	2	localObject	Object
      //   126	1	2	localIOException	java.io.IOException
      //   21	116	3	localFileOutputStream	java.io.FileOutputStream
      //   77	7	4	localThrowable1	Throwable
      //   134	1	4	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   9	22	77	java/lang/Throwable
      //   100	104	106	java/io/IOException
      //   9	22	109	finally
      //   71	75	122	java/io/IOException
      //   116	120	126	java/io/IOException
      //   24	31	130	finally
      //   33	38	130	finally
      //   40	44	130	finally
      //   46	50	130	finally
      //   52	64	130	finally
      //   66	71	130	finally
      //   83	89	130	finally
      //   91	96	130	finally
      //   24	31	134	java/lang/Throwable
      //   33	38	134	java/lang/Throwable
      //   40	44	134	java/lang/Throwable
      //   46	50	134	java/lang/Throwable
      //   52	64	134	java/lang/Throwable
      //   66	71	134	java/lang/Throwable
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.y
 * JD-Core Version:    0.7.0.1
 */