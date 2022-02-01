import com.tencent.mobileqq.activity.QQBrowserActivity;

public class dbp
  extends Thread
{
  public dbp(QQBrowserActivity paramQQBrowserActivity, String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/mobileqq/activity/QQBrowserActivity:a	()[B
    //   3: ifnonnull +14 -> 17
    //   6: ldc 31
    //   8: ldc 33
    //   10: invokevirtual 39	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   13: invokestatic 42	com/tencent/mobileqq/activity/QQBrowserActivity:a	([B)[B
    //   16: pop
    //   17: invokestatic 29	com/tencent/mobileqq/activity/QQBrowserActivity:a	()[B
    //   20: ifnonnull +4 -> 24
    //   23: return
    //   24: new 44	java/net/URL
    //   27: dup
    //   28: ldc 46
    //   30: invokespecial 47	java/net/URL:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 51	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   36: checkcast 53	java/net/HttpURLConnection
    //   39: astore 4
    //   41: aload 4
    //   43: ldc 55
    //   45: invokevirtual 58	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   48: aload 4
    //   50: iconst_1
    //   51: invokevirtual 62	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   54: aload 4
    //   56: iconst_1
    //   57: invokevirtual 65	java/net/HttpURLConnection:setDoInput	(Z)V
    //   60: aload 4
    //   62: iconst_0
    //   63: invokevirtual 68	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   66: aload 4
    //   68: sipush 20000
    //   71: invokevirtual 72	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   74: getstatic 78	android/os/Build$VERSION:SDK_INT	I
    //   77: bipush 13
    //   79: if_icmple +12 -> 91
    //   82: aload 4
    //   84: ldc 80
    //   86: ldc 82
    //   88: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aconst_null
    //   92: astore_2
    //   93: ldc 88
    //   95: ldc 33
    //   97: invokevirtual 39	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   100: astore_3
    //   101: aload_3
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull -81 -> 23
    //   107: invokestatic 29	com/tencent/mobileqq/activity/QQBrowserActivity:a	()[B
    //   110: aload_2
    //   111: iconst_1
    //   112: invokestatic 94	com/tencent/smtt/sdk/stat/DesUtils:DesEncrypt	([B[BI)[B
    //   115: astore_2
    //   116: aload 4
    //   118: ldc 96
    //   120: ldc 98
    //   122: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload 4
    //   127: ldc 100
    //   129: aload_2
    //   130: arraylength
    //   131: invokestatic 104	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   134: invokevirtual 86	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload 4
    //   139: invokevirtual 108	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   142: astore_3
    //   143: aload_3
    //   144: aload_2
    //   145: invokevirtual 114	java/io/OutputStream:write	([B)V
    //   148: aload_3
    //   149: invokevirtual 117	java/io/OutputStream:flush	()V
    //   152: aload 4
    //   154: invokevirtual 121	java/net/HttpURLConnection:getResponseCode	()I
    //   157: istore_1
    //   158: iload_1
    //   159: sipush 200
    //   162: if_icmpne -139 -> 23
    //   165: return
    //   166: astore_2
    //   167: return
    //   168: astore_3
    //   169: goto -66 -> 103
    //   172: astore_2
    //   173: return
    //   174: astore_2
    //   175: goto -158 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	dbp
    //   157	6	1	i	int
    //   92	53	2	localObject1	java.lang.Object
    //   166	1	2	localThrowable	java.lang.Throwable
    //   172	1	2	localIOException	java.io.IOException
    //   174	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   100	49	3	localObject2	java.lang.Object
    //   168	1	3	localException	java.lang.Exception
    //   39	114	4	localHttpURLConnection	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   137	158	166	java/lang/Throwable
    //   93	101	168	java/lang/Exception
    //   24	48	172	java/io/IOException
    //   6	17	174	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dbp
 * JD-Core Version:    0.7.0.1
 */