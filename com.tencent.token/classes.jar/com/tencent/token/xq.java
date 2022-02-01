package com.tencent.token;

import android.os.Build;
import android.text.TextUtils;
import btmsdkobf.bw;
import com.tencent.token.global.RqdApplication;

public final class xq
{
  public static boolean a;
  
  public static void a()
  {
    if (a) {
      return;
    }
    long l = System.currentTimeMillis();
    String str = bw.ah().aj();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    a = true;
    StringBuilder localStringBuilder = new StringBuilder("init : ");
    localStringBuilder.append(str);
    localStringBuilder.append("  time=");
    localStringBuilder.append(System.currentTimeMillis() - l);
    afx.a(RqdApplication.p()).a(new adp()
    {
      public final String a()
      {
        return xk.c(RqdApplication.p());
      }
      
      public final String b()
      {
        return xk.a(RqdApplication.p());
      }
      
      public final String c()
      {
        return xk.b(RqdApplication.p());
      }
      
      public final String d()
      {
        return Build.BRAND;
      }
      
      public final String e()
      {
        return xk.a();
      }
      
      public final String f()
      {
        return xq.c();
      }
    }).a().a(str).c("6.9.23").b("C1D4CD9B6187E99C").a(xf.d()).b().a();
  }
  
  public static String b()
  {
    
    if (!a) {
      return "";
    }
    long l = System.currentTimeMillis();
    Object localObject2 = afw.a(RqdApplication.p());
    Object localObject1 = "";
    if (((ado)localObject2).a() == 0)
    {
      localObject2 = ((ado)localObject2).b();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
    }
    localObject2 = new StringBuilder("getOpenIdTicket : ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("  time=");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
    return localObject1;
  }
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: new 120	java/io/FileInputStream
    //   3: dup
    //   4: ldc 122
    //   6: invokespecial 123	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_0
    //   10: new 125	java/io/BufferedReader
    //   13: dup
    //   14: new 127	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 130	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 133	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_2
    //   29: new 35	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 104
    //   35: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 136	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +12 -> 57
    //   48: aload_1
    //   49: aload_3
    //   50: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: goto -15 -> 39
    //   57: aload_2
    //   58: invokevirtual 139	java/io/BufferedReader:close	()V
    //   61: goto +8 -> 69
    //   64: astore_2
    //   65: aload_2
    //   66: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   69: aload_0
    //   70: invokevirtual 147	java/io/InputStream:close	()V
    //   73: goto +8 -> 81
    //   76: astore_0
    //   77: aload_0
    //   78: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   81: aload_1
    //   82: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: areturn
    //   86: astore_1
    //   87: goto +31 -> 118
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   95: aload_2
    //   96: invokevirtual 139	java/io/BufferedReader:close	()V
    //   99: goto +8 -> 107
    //   102: astore_2
    //   103: aload_2
    //   104: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   107: aload_0
    //   108: invokevirtual 147	java/io/InputStream:close	()V
    //   111: goto -30 -> 81
    //   114: astore_0
    //   115: goto -38 -> 77
    //   118: aload_2
    //   119: invokevirtual 139	java/io/BufferedReader:close	()V
    //   122: goto +8 -> 130
    //   125: astore_2
    //   126: aload_2
    //   127: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   130: aload_0
    //   131: invokevirtual 147	java/io/InputStream:close	()V
    //   134: goto +8 -> 142
    //   137: astore_0
    //   138: aload_0
    //   139: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   142: aload_1
    //   143: athrow
    //   144: astore_0
    //   145: aload_0
    //   146: invokestatic 144	com/tencent/token/auq:a	(Ljava/lang/Object;)V
    //   149: ldc 104
    //   151: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	61	0	localFileInputStream	java.io.FileInputStream
    //   76	32	0	localThrowable1	java.lang.Throwable
    //   114	17	0	localThrowable2	java.lang.Throwable
    //   137	2	0	localThrowable3	java.lang.Throwable
    //   144	2	0	localThrowable4	java.lang.Throwable
    //   38	44	1	localStringBuilder	StringBuilder
    //   86	57	1	localObject	Object
    //   28	30	2	localBufferedReader	java.io.BufferedReader
    //   64	32	2	localThrowable5	java.lang.Throwable
    //   102	17	2	localThrowable6	java.lang.Throwable
    //   125	2	2	localThrowable7	java.lang.Throwable
    //   43	7	3	str	String
    //   90	2	3	localThrowable8	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   57	61	64	java/lang/Throwable
    //   69	73	76	java/lang/Throwable
    //   39	44	86	finally
    //   48	54	86	finally
    //   91	95	86	finally
    //   39	44	90	java/lang/Throwable
    //   48	54	90	java/lang/Throwable
    //   95	99	102	java/lang/Throwable
    //   107	111	114	java/lang/Throwable
    //   118	122	125	java/lang/Throwable
    //   130	134	137	java/lang/Throwable
    //   0	10	144	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.xq
 * JD-Core Version:    0.7.0.1
 */