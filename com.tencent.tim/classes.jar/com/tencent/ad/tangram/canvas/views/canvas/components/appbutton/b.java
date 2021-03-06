package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class b
{
  private static final String APP_DATA_INFO_DOMAIN = "https://h5.gdt.qq.com/player/openapp/";
  private static final String APP_DATA_INFO_DOMAIN_ROOT = "https://h5.gdt.qq.com";
  
  private static String converStreamToString(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  AdAppBtnData loadGdtAppBtnData(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: aload 4
    //   18: areturn
    //   19: ldc 57
    //   21: new 59	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   28: ldc 62
    //   30: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 67
    //   39: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 69
    //   48: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 79	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 59	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   68: ldc 8
    //   70: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 81
    //   79: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 83
    //   88: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_1
    //   95: ldc 57
    //   97: new 59	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   104: ldc 85
    //   106: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 79	com/tencent/ad/tangram/log/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: new 87	java/net/URL
    //   122: dup
    //   123: aload_1
    //   124: invokespecial 90	java/net/URL:<init>	(Ljava/lang/String;)V
    //   127: invokevirtual 94	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   130: checkcast 96	java/net/HttpURLConnection
    //   133: astore_2
    //   134: aload_2
    //   135: ldc 98
    //   137: invokevirtual 101	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   140: aload_2
    //   141: ldc 103
    //   143: ldc 105
    //   145: invokevirtual 108	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_2
    //   149: ldc 110
    //   151: ldc 112
    //   153: invokevirtual 108	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_2
    //   157: ldc 114
    //   159: ldc 11
    //   161: invokevirtual 108	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_2
    //   165: sipush 3000
    //   168: invokevirtual 118	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   171: aload_2
    //   172: sipush 3000
    //   175: invokevirtual 121	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   178: aload_2
    //   179: invokevirtual 125	java/net/HttpURLConnection:getResponseCode	()I
    //   182: sipush 200
    //   185: if_icmpne +81 -> 266
    //   188: aload_2
    //   189: invokevirtual 129	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   192: invokestatic 131	com/tencent/ad/tangram/canvas/views/canvas/components/appbutton/b:converStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   195: astore_1
    //   196: aload_1
    //   197: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: ifne +28 -> 228
    //   203: new 133	org/json/JSONObject
    //   206: dup
    //   207: aload_1
    //   208: invokespecial 134	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   211: invokestatic 140	com/tencent/ad/tangram/canvas/views/canvas/components/appbutton/AdAppBtnData:parseJson	(Lorg/json/JSONObject;)Lcom/tencent/ad/tangram/canvas/views/canvas/components/appbutton/AdAppBtnData;
    //   214: astore_1
    //   215: aload_1
    //   216: astore 4
    //   218: aload_2
    //   219: ifnull -203 -> 16
    //   222: aload_2
    //   223: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   226: aload_1
    //   227: areturn
    //   228: ldc 57
    //   230: ldc 145
    //   232: invokestatic 148	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 6
    //   237: astore_1
    //   238: goto -23 -> 215
    //   241: astore 5
    //   243: aload_2
    //   244: astore_1
    //   245: aload 5
    //   247: astore_2
    //   248: ldc 57
    //   250: ldc 150
    //   252: aload_2
    //   253: invokestatic 153	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload_1
    //   257: ifnull -241 -> 16
    //   260: aload_1
    //   261: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   264: aconst_null
    //   265: areturn
    //   266: ldc 57
    //   268: ldc 155
    //   270: invokestatic 148	com/tencent/ad/tangram/log/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload 6
    //   275: astore_1
    //   276: goto -61 -> 215
    //   279: astore_1
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 143	java/net/HttpURLConnection:disconnect	()V
    //   288: aload_1
    //   289: athrow
    //   290: astore_1
    //   291: aload 5
    //   293: astore_2
    //   294: goto -14 -> 280
    //   297: astore 4
    //   299: aload_1
    //   300: astore_2
    //   301: aload 4
    //   303: astore_1
    //   304: goto -24 -> 280
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_1
    //   310: goto -62 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	b
    //   0	313	1	paramString1	String
    //   0	313	2	paramString2	String
    //   0	313	3	paramInt	int
    //   7	210	4	localObject1	Object
    //   297	5	4	localObject2	Object
    //   4	1	5	localObject3	Object
    //   241	51	5	localException	java.lang.Exception
    //   1	273	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   134	215	241	java/lang/Exception
    //   228	235	241	java/lang/Exception
    //   266	273	241	java/lang/Exception
    //   134	215	279	finally
    //   228	235	279	finally
    //   266	273	279	finally
    //   119	134	290	finally
    //   248	256	297	finally
    //   119	134	307	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.b
 * JD-Core Version:    0.7.0.1
 */