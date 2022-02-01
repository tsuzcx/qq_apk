package com.tencent.mobileqq.loginwelcome;

import aivs;
import aivs.a;

public class GateWayVerifyManager$3
  implements Runnable
{
  public GateWayVerifyManager$3(aivs paramaivs, String paramString, aivs.a parama) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 29
    //   2: iconst_1
    //   3: ldc 31
    //   5: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_2
    //   13: astore_1
    //   14: new 39	java/net/URL
    //   17: dup
    //   18: aload_0
    //   19: getfield 18	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:bPI	Ljava/lang/String;
    //   22: invokespecial 42	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload_2
    //   28: astore_1
    //   29: aload 4
    //   31: invokevirtual 46	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   34: checkcast 48	java/net/HttpURLConnection
    //   37: astore_2
    //   38: aload_0
    //   39: getfield 16	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:this$0	Laivs;
    //   42: aload_2
    //   43: aload 4
    //   45: aload_0
    //   46: getfield 20	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:a	Laivs$a;
    //   49: invokestatic 53	aivs:a	(Laivs;Ljava/net/HttpURLConnection;Ljava/net/URL;Laivs$a;)V
    //   52: aload_2
    //   53: ifnull +7 -> 60
    //   56: aload_2
    //   57: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   60: return
    //   61: astore_1
    //   62: aload_3
    //   63: astore_2
    //   64: aload_1
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: ldc 29
    //   70: iconst_1
    //   71: iconst_2
    //   72: anewarray 4	java/lang/Object
    //   75: dup
    //   76: iconst_0
    //   77: ldc 58
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_3
    //   83: invokevirtual 62	java/io/IOException:getMessage	()Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: astore_1
    //   92: aload_0
    //   93: getfield 20	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$3:a	Laivs$a;
    //   96: iconst_m1
    //   97: aload_3
    //   98: invokeinterface 71 3 0
    //   103: aload_2
    //   104: ifnull -44 -> 60
    //   107: aload_2
    //   108: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   111: return
    //   112: astore_3
    //   113: aload_1
    //   114: astore_2
    //   115: aload_3
    //   116: astore_1
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 56	java/net/HttpURLConnection:disconnect	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: goto -11 -> 117
    //   131: astore_3
    //   132: goto -66 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	3
    //   13	16	1	localObject1	Object
    //   61	4	1	localIOException1	java.io.IOException
    //   67	59	1	localObject2	Object
    //   127	1	1	localObject3	Object
    //   9	113	2	localObject4	Object
    //   11	87	3	localObject5	Object
    //   112	4	3	localObject6	Object
    //   131	1	3	localIOException2	java.io.IOException
    //   25	19	4	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   14	27	61	java/io/IOException
    //   29	38	61	java/io/IOException
    //   14	27	112	finally
    //   29	38	112	finally
    //   68	90	112	finally
    //   92	103	112	finally
    //   38	52	127	finally
    //   38	52	131	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.3
 * JD-Core Version:    0.7.0.1
 */