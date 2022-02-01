package com.tencent.token;

import com.tencent.halley.common.f;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class ar
{
  public static boolean a = true;
  private static final Lock b = new ReentrantLock();
  private static al c = null;
  
  public static al a()
  {
    al localal = c;
    if (localal != null) {
      return localal;
    }
    try
    {
      if (f.a() != null) {
        c = a(f.a(), f.b(), f.g(), f.e());
      }
      label34:
      return c;
    }
    catch (Exception localException)
    {
      break label34;
    }
  }
  
  /* Error */
  public static al a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: new 45	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 47
    //   6: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 4
    //   20: ldc 56
    //   22: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 4
    //   28: aload_1
    //   29: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 4
    //   35: ldc 61
    //   37: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 4
    //   43: aload_2
    //   44: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: ldc 63
    //   52: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 4
    //   58: aload_3
    //   59: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: ldc 65
    //   65: aload 4
    //   67: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 73	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: ifnull +225 -> 299
    //   77: aload_1
    //   78: invokestatic 78	com/tencent/token/br:a	(Ljava/lang/String;)Z
    //   81: ifne +218 -> 299
    //   84: getstatic 20	com/tencent/token/ar:b	Ljava/util/concurrent/locks/Lock;
    //   87: invokeinterface 83 1 0
    //   92: getstatic 22	com/tencent/token/ar:c	Lcom/tencent/token/al;
    //   95: ifnonnull +181 -> 276
    //   98: aload_3
    //   99: invokestatic 78	com/tencent/token/br:a	(Ljava/lang/String;)Z
    //   102: ifne +18 -> 120
    //   105: aload_3
    //   106: astore 4
    //   108: aload_3
    //   109: invokevirtual 88	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: ldc 90
    //   114: invokevirtual 94	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   117: ifeq +103 -> 220
    //   120: aload_0
    //   121: ldc 96
    //   123: iconst_0
    //   124: invokevirtual 102	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   127: astore 5
    //   129: aload_3
    //   130: astore 4
    //   132: aload 5
    //   134: ifnull +86 -> 220
    //   137: aload 5
    //   139: ldc 104
    //   141: ldc 106
    //   143: invokeinterface 112 3 0
    //   148: astore_3
    //   149: aload_3
    //   150: astore 4
    //   152: aload_3
    //   153: invokestatic 78	com/tencent/token/br:a	(Ljava/lang/String;)Z
    //   156: ifeq +64 -> 220
    //   159: new 45	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   166: astore_3
    //   167: aload_3
    //   168: aload_0
    //   169: invokestatic 116	com/tencent/token/br:a	(Landroid/content/Context;)Ljava/lang/String;
    //   172: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: ldc 118
    //   179: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_3
    //   184: aload_0
    //   185: invokestatic 120	com/tencent/token/br:b	(Landroid/content/Context;)Ljava/lang/String;
    //   188: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 4
    //   198: aload 5
    //   200: invokeinterface 124 1 0
    //   205: ldc 104
    //   207: aload 4
    //   209: invokeinterface 130 3 0
    //   214: invokeinterface 134 1 0
    //   219: pop
    //   220: aload_2
    //   221: astore_3
    //   222: aload_2
    //   223: invokestatic 78	com/tencent/token/br:a	(Ljava/lang/String;)Z
    //   226: ifeq +6 -> 232
    //   229: ldc 136
    //   231: astore_3
    //   232: aload_0
    //   233: aload_1
    //   234: aload_3
    //   235: aload 4
    //   237: invokestatic 139	com/tencent/halley/common/f:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_0
    //   241: invokestatic 144	com/tencent/token/bq:a	(Landroid/content/Context;)V
    //   244: new 146	com/tencent/token/ao
    //   247: dup
    //   248: aload_1
    //   249: aload_3
    //   250: aload 4
    //   252: invokespecial 149	com/tencent/token/ao:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   255: putstatic 22	com/tencent/token/ar:c	Lcom/tencent/token/al;
    //   258: new 151	java/lang/Thread
    //   261: dup
    //   262: getstatic 22	com/tencent/token/ar:c	Lcom/tencent/token/al;
    //   265: checkcast 153	java/lang/Runnable
    //   268: ldc 155
    //   270: invokespecial 158	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   273: invokevirtual 161	java/lang/Thread:start	()V
    //   276: getstatic 20	com/tencent/token/ar:b	Ljava/util/concurrent/locks/Lock;
    //   279: invokeinterface 164 1 0
    //   284: getstatic 22	com/tencent/token/ar:c	Lcom/tencent/token/al;
    //   287: areturn
    //   288: astore_0
    //   289: getstatic 20	com/tencent/token/ar:b	Ljava/util/concurrent/locks/Lock;
    //   292: invokeinterface 164 1 0
    //   297: aload_0
    //   298: athrow
    //   299: new 45	java/lang/StringBuilder
    //   302: dup
    //   303: ldc 166
    //   305: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: astore_2
    //   309: aload_2
    //   310: aload_1
    //   311: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc 168
    //   318: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_2
    //   323: aload_0
    //   324: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_2
    //   329: ldc 170
    //   331: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: new 172	com/tencent/halley/common/HalleyInitException
    //   338: dup
    //   339: aload_2
    //   340: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokespecial 173	com/tencent/halley/common/HalleyInitException:<init>	(Ljava/lang/String;)V
    //   346: athrow
    //   347: astore_0
    //   348: goto -72 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramContext	android.content.Context
    //   0	351	1	paramString1	java.lang.String
    //   0	351	2	paramString2	java.lang.String
    //   0	351	3	paramString3	java.lang.String
    //   9	242	4	localObject	Object
    //   127	72	5	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   92	105	288	finally
    //   108	120	288	finally
    //   120	129	288	finally
    //   137	149	288	finally
    //   152	220	288	finally
    //   222	229	288	finally
    //   232	276	288	finally
    //   232	276	347	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ar
 * JD-Core Version:    0.7.0.1
 */