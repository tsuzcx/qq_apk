import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tja
{
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
  public com.tencent.gdtad.api.motivevideo.GdtMvAppBtnData a(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 5
    //   11: astore 4
    //   13: aload_1
    //   14: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +14 -> 31
    //   20: aload_2
    //   21: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +10 -> 34
    //   27: aload 5
    //   29: astore 4
    //   31: aload 4
    //   33: areturn
    //   34: ldc 50
    //   36: new 52	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   43: ldc 55
    //   45: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_3
    //   49: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 68	tkw:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 52	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   65: aload_1
    //   66: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore_1
    //   77: ldc 50
    //   79: new 52	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   86: ldc 70
    //   88: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 68	tkw:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: new 72	java/net/URL
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 75	java/net/URL:<init>	(Ljava/lang/String;)V
    //   109: invokevirtual 79	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   112: checkcast 81	java/net/HttpURLConnection
    //   115: astore_2
    //   116: aload_2
    //   117: ldc 83
    //   119: invokevirtual 86	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   122: aload_2
    //   123: ldc 88
    //   125: ldc 90
    //   127: invokevirtual 93	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_2
    //   131: ldc 95
    //   133: ldc 97
    //   135: invokevirtual 93	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: aload_2
    //   139: sipush 3000
    //   142: invokevirtual 101	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   145: aload_2
    //   146: sipush 3000
    //   149: invokevirtual 104	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   152: aload_2
    //   153: invokevirtual 108	java/net/HttpURLConnection:getResponseCode	()I
    //   156: sipush 200
    //   159: if_icmpne +85 -> 244
    //   162: aload_2
    //   163: invokevirtual 112	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   166: invokestatic 114	tja:converStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +28 -> 202
    //   177: new 116	org/json/JSONObject
    //   180: dup
    //   181: aload_1
    //   182: invokespecial 117	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   185: invokestatic 123	com/tencent/gdtad/api/motivevideo/GdtMvAppBtnData:parseJsonForMv	(Lorg/json/JSONObject;)Lcom/tencent/gdtad/api/motivevideo/GdtMvAppBtnData;
    //   188: astore_1
    //   189: aload_1
    //   190: astore 4
    //   192: aload_2
    //   193: ifnull -162 -> 31
    //   196: aload_2
    //   197: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   200: aload_1
    //   201: areturn
    //   202: ldc 50
    //   204: ldc 128
    //   206: invokestatic 131	tkw:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload 7
    //   211: astore_1
    //   212: goto -23 -> 189
    //   215: astore 4
    //   217: aload_2
    //   218: astore_1
    //   219: aload 4
    //   221: astore_2
    //   222: ldc 50
    //   224: ldc 133
    //   226: aload_2
    //   227: invokestatic 136	tkw:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload 5
    //   232: astore 4
    //   234: aload_1
    //   235: ifnull -204 -> 31
    //   238: aload_1
    //   239: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   242: aconst_null
    //   243: areturn
    //   244: ldc 50
    //   246: ldc 138
    //   248: invokestatic 131	tkw:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload 7
    //   253: astore_1
    //   254: goto -65 -> 189
    //   257: astore_1
    //   258: aload_2
    //   259: ifnull +7 -> 266
    //   262: aload_2
    //   263: invokevirtual 126	java/net/HttpURLConnection:disconnect	()V
    //   266: aload_1
    //   267: athrow
    //   268: astore_1
    //   269: aload 6
    //   271: astore_2
    //   272: goto -14 -> 258
    //   275: astore 4
    //   277: aload_1
    //   278: astore_2
    //   279: aload 4
    //   281: astore_1
    //   282: goto -24 -> 258
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_1
    //   288: goto -66 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	tja
    //   0	291	1	paramString1	String
    //   0	291	2	paramString2	String
    //   0	291	3	paramInt	int
    //   11	180	4	localObject1	Object
    //   215	5	4	localException	java.lang.Exception
    //   232	1	4	localObject2	Object
    //   275	5	4	localObject3	Object
    //   7	224	5	localObject4	Object
    //   4	266	6	localObject5	Object
    //   1	251	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   116	189	215	java/lang/Exception
    //   202	209	215	java/lang/Exception
    //   244	251	215	java/lang/Exception
    //   116	189	257	finally
    //   202	209	257	finally
    //   244	251	257	finally
    //   101	116	268	finally
    //   222	230	275	finally
    //   101	116	285	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tja
 * JD-Core Version:    0.7.0.1
 */