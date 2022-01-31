package com.tencent.token;

import com.tencent.halley.common.h;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class av
{
  public static boolean a = true;
  private static final Lock b = new ReentrantLock();
  private static ap c = null;
  
  public static ap a()
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (h.a() != null) {
        c = a(h.a(), h.b(), h.g(), h.e());
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
  public static ap a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: ldc 46
    //   2: new 48	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 50
    //   8: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15: ldc 59
    //   17: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 64
    //   26: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 66
    //   35: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 74	com/tencent/halley/common/c:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: ifnull +10 -> 59
    //   52: aload_1
    //   53: invokestatic 79	com/tencent/token/cc:a	(Ljava/lang/String;)Z
    //   56: ifeq +41 -> 97
    //   59: new 81	com/tencent/halley/common/HalleyInitException
    //   62: dup
    //   63: new 48	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 83
    //   69: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 85
    //   78: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: ldc 87
    //   87: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 88	com/tencent/halley/common/HalleyInitException:<init>	(Ljava/lang/String;)V
    //   96: athrow
    //   97: getstatic 21	com/tencent/token/av:b	Ljava/util/concurrent/locks/Lock;
    //   100: invokeinterface 93 1 0
    //   105: getstatic 23	com/tencent/token/av:c	Lcom/tencent/token/ap;
    //   108: ifnonnull +173 -> 281
    //   111: aload_3
    //   112: invokestatic 79	com/tencent/token/cc:a	(Ljava/lang/String;)Z
    //   115: ifne +18 -> 133
    //   118: aload_3
    //   119: astore 4
    //   121: aload_3
    //   122: invokevirtual 98	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   125: ldc 100
    //   127: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +95 -> 225
    //   133: aload_0
    //   134: ldc 106
    //   136: iconst_0
    //   137: invokevirtual 112	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   140: astore 5
    //   142: aload_3
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +78 -> 225
    //   150: aload 5
    //   152: ldc 114
    //   154: ldc 116
    //   156: invokeinterface 122 3 0
    //   161: astore_3
    //   162: aload_3
    //   163: astore 4
    //   165: aload_3
    //   166: invokestatic 79	com/tencent/token/cc:a	(Ljava/lang/String;)Z
    //   169: ifeq +56 -> 225
    //   172: new 48	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   179: aload_0
    //   180: invokestatic 126	com/tencent/token/cc:a	(Landroid/content/Context;)Ljava/lang/String;
    //   183: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: ldc 128
    //   188: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_0
    //   192: invokestatic 130	com/tencent/token/cc:b	(Landroid/content/Context;)Ljava/lang/String;
    //   195: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 4
    //   203: aload 5
    //   205: invokeinterface 134 1 0
    //   210: ldc 114
    //   212: aload 4
    //   214: invokeinterface 140 3 0
    //   219: invokeinterface 144 1 0
    //   224: pop
    //   225: aload_2
    //   226: astore_3
    //   227: aload_2
    //   228: invokestatic 79	com/tencent/token/cc:a	(Ljava/lang/String;)Z
    //   231: ifeq +6 -> 237
    //   234: ldc 146
    //   236: astore_3
    //   237: aload_0
    //   238: aload_1
    //   239: aload_3
    //   240: aload 4
    //   242: invokestatic 149	com/tencent/halley/common/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: invokestatic 154	com/tencent/token/cb:a	(Landroid/content/Context;)V
    //   249: new 156	com/tencent/token/as
    //   252: dup
    //   253: aload_1
    //   254: aload_3
    //   255: aload 4
    //   257: invokespecial 159	com/tencent/token/as:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   260: putstatic 23	com/tencent/token/av:c	Lcom/tencent/token/ap;
    //   263: new 161	java/lang/Thread
    //   266: dup
    //   267: getstatic 23	com/tencent/token/av:c	Lcom/tencent/token/ap;
    //   270: checkcast 163	java/lang/Runnable
    //   273: ldc 165
    //   275: invokespecial 168	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   278: invokevirtual 171	java/lang/Thread:start	()V
    //   281: getstatic 21	com/tencent/token/av:b	Ljava/util/concurrent/locks/Lock;
    //   284: invokeinterface 174 1 0
    //   289: getstatic 23	com/tencent/token/av:c	Lcom/tencent/token/ap;
    //   292: areturn
    //   293: astore_0
    //   294: getstatic 21	com/tencent/token/av:b	Ljava/util/concurrent/locks/Lock;
    //   297: invokeinterface 174 1 0
    //   302: aload_0
    //   303: athrow
    //   304: astore_0
    //   305: goto -24 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramContext	android.content.Context
    //   0	308	1	paramString1	java.lang.String
    //   0	308	2	paramString2	java.lang.String
    //   0	308	3	paramString3	java.lang.String
    //   119	137	4	str	java.lang.String
    //   140	64	5	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   105	118	293	finally
    //   121	133	293	finally
    //   133	142	293	finally
    //   150	162	293	finally
    //   165	225	293	finally
    //   227	234	293	finally
    //   237	281	293	finally
    //   237	281	304	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.av
 * JD-Core Version:    0.7.0.1
 */