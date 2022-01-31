import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class yzk
{
  private static String a(InputStream paramInputStream)
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
  public com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnData a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: aload 4
    //   18: areturn
    //   19: ldc 46
    //   21: new 48	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   28: ldc 51
    //   30: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 56
    //   39: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 58
    //   48: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 68	yxs:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: new 48	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   68: ldc 70
    //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 72
    //   79: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_1
    //   90: ldc 46
    //   92: new 48	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   99: ldc 74
    //   101: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 68	yxs:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: new 76	java/net/URL
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 79	java/net/URL:<init>	(Ljava/lang/String;)V
    //   122: invokevirtual 83	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   125: checkcast 85	java/net/HttpURLConnection
    //   128: astore_2
    //   129: aload_2
    //   130: ldc 87
    //   132: invokevirtual 90	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   135: aload_2
    //   136: ldc 92
    //   138: ldc 94
    //   140: invokevirtual 97	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_2
    //   144: ldc 99
    //   146: ldc 101
    //   148: invokevirtual 97	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ldc 103
    //   154: ldc 105
    //   156: invokevirtual 97	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload_2
    //   160: sipush 3000
    //   163: invokevirtual 109	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   166: aload_2
    //   167: sipush 3000
    //   170: invokevirtual 112	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   173: aload_2
    //   174: invokevirtual 116	java/net/HttpURLConnection:getResponseCode	()I
    //   177: sipush 200
    //   180: if_icmpne +81 -> 261
    //   183: aload_2
    //   184: invokevirtual 120	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   187: invokestatic 122	yzk:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   190: astore_1
    //   191: aload_1
    //   192: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   195: ifne +28 -> 223
    //   198: new 124	org/json/JSONObject
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 125	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   206: invokestatic 131	com/tencent/gdtad/views/canvas/components/appbutton/GdtAppBtnData:parseJson	(Lorg/json/JSONObject;)Lcom/tencent/gdtad/views/canvas/components/appbutton/GdtAppBtnData;
    //   209: astore_1
    //   210: aload_1
    //   211: astore 4
    //   213: aload_2
    //   214: ifnull -198 -> 16
    //   217: aload_2
    //   218: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   221: aload_1
    //   222: areturn
    //   223: ldc 46
    //   225: ldc 136
    //   227: invokestatic 139	yxs:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 6
    //   232: astore_1
    //   233: goto -23 -> 210
    //   236: astore 5
    //   238: aload_2
    //   239: astore_1
    //   240: aload 5
    //   242: astore_2
    //   243: ldc 46
    //   245: ldc 141
    //   247: aload_2
    //   248: invokestatic 144	yxs:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: ifnull -236 -> 16
    //   255: aload_1
    //   256: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   259: aconst_null
    //   260: areturn
    //   261: ldc 46
    //   263: ldc 146
    //   265: invokestatic 139	yxs:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 6
    //   270: astore_1
    //   271: goto -61 -> 210
    //   274: astore_1
    //   275: aload_2
    //   276: ifnull +7 -> 283
    //   279: aload_2
    //   280: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   283: aload_1
    //   284: athrow
    //   285: astore_1
    //   286: aload 5
    //   288: astore_2
    //   289: goto -14 -> 275
    //   292: astore 4
    //   294: aload_1
    //   295: astore_2
    //   296: aload 4
    //   298: astore_1
    //   299: goto -24 -> 275
    //   302: astore_2
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -62 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	yzk
    //   0	308	1	paramString1	String
    //   0	308	2	paramString2	String
    //   0	308	3	paramInt	int
    //   7	205	4	localObject1	Object
    //   292	5	4	localObject2	Object
    //   4	1	5	localObject3	Object
    //   236	51	5	localException	java.lang.Exception
    //   1	268	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   129	210	236	java/lang/Exception
    //   223	230	236	java/lang/Exception
    //   261	268	236	java/lang/Exception
    //   129	210	274	finally
    //   223	230	274	finally
    //   261	268	274	finally
    //   114	129	285	finally
    //   243	251	292	finally
    //   114	129	302	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yzk
 * JD-Core Version:    0.7.0.1
 */