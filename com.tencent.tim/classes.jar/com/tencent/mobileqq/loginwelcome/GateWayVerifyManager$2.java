package com.tencent.mobileqq.loginwelcome;

import aivs;
import aivs.a;
import android.net.Network;

public class GateWayVerifyManager$2
  implements Runnable
{
  public GateWayVerifyManager$2(aivs paramaivs, String paramString, Network paramNetwork, aivs.a parama) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: new 32	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: getfield 19	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:bPI	Ljava/lang/String;
    //   14: invokespecial 35	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 21	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_AndroidNetNetwork	Landroid/net/Network;
    //   25: aload 4
    //   27: invokevirtual 41	android/net/Network:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   30: checkcast 43	java/net/HttpURLConnection
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 17	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:this$0	Laivs;
    //   38: aload_2
    //   39: aload 4
    //   41: aload_0
    //   42: getfield 23	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_Aivs$a	Laivs$a;
    //   45: invokestatic 48	aivs:a	(Laivs;Ljava/net/HttpURLConnection;Ljava/net/URL;Laivs$a;)V
    //   48: aload_2
    //   49: ifnull +7 -> 56
    //   52: aload_2
    //   53: invokevirtual 51	java/net/HttpURLConnection:disconnect	()V
    //   56: return
    //   57: astore_1
    //   58: aload_3
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload_2
    //   63: astore_1
    //   64: ldc 53
    //   66: iconst_1
    //   67: iconst_2
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: ldc 55
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload_3
    //   79: invokevirtual 59	java/io/IOException:getMessage	()Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   86: aload_2
    //   87: astore_1
    //   88: aload_0
    //   89: getfield 23	com/tencent/mobileqq/loginwelcome/GateWayVerifyManager$2:jdField_a_of_type_Aivs$a	Laivs$a;
    //   92: iconst_m1
    //   93: aload_3
    //   94: invokeinterface 70 3 0
    //   99: aload_2
    //   100: ifnull -44 -> 56
    //   103: aload_2
    //   104: invokevirtual 51	java/net/HttpURLConnection:disconnect	()V
    //   107: return
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload_3
    //   112: astore_1
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 51	java/net/HttpURLConnection:disconnect	()V
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: goto -11 -> 113
    //   127: astore_3
    //   128: goto -66 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	2
    //   5	16	1	localObject1	Object
    //   57	4	1	localIOException1	java.io.IOException
    //   63	59	1	localObject2	Object
    //   123	1	1	localObject3	Object
    //   1	117	2	localObject4	Object
    //   3	91	3	localObject5	Object
    //   108	4	3	localObject6	Object
    //   127	1	3	localIOException2	java.io.IOException
    //   17	23	4	localURL	java.net.URL
    // Exception table:
    //   from	to	target	type
    //   6	19	57	java/io/IOException
    //   21	34	57	java/io/IOException
    //   6	19	108	finally
    //   21	34	108	finally
    //   64	86	108	finally
    //   88	99	108	finally
    //   34	48	123	finally
    //   34	48	127	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.2
 * JD-Core Version:    0.7.0.1
 */