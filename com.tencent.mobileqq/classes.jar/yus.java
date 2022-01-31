import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class yus
{
  public int a;
  private BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private String jdField_a_of_type_JavaLangString;
  private URLConnection jdField_a_of_type_JavaNetURLConnection;
  private boolean jdField_a_of_type_Boolean;
  public int b = 15000;
  
  public yus(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 5000;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  private BufferedInputStream a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 30	yus:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   6: ifnonnull +54 -> 60
    //   9: aload_0
    //   10: getfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +45 -> 60
    //   18: aload_0
    //   19: getfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   22: invokevirtual 38	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore_1
    //   26: ldc 40
    //   28: aload_0
    //   29: getfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   32: invokevirtual 44	java/net/URLConnection:getContentEncoding	()Ljava/lang/String;
    //   35: invokevirtual 50	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   38: ifeq +31 -> 69
    //   41: aload_0
    //   42: new 52	java/io/BufferedInputStream
    //   45: dup
    //   46: new 54	java/util/zip/GZIPInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 57	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: invokespecial 58	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: putfield 30	yus:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   60: aload_0
    //   61: getfield 30	yus:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    //   69: aload_0
    //   70: new 52	java/io/BufferedInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 58	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: putfield 30	yus:jdField_a_of_type_JavaIoBufferedInputStream	Ljava/io/BufferedInputStream;
    //   81: goto -21 -> 60
    //   84: astore_1
    //   85: ldc 60
    //   87: iconst_2
    //   88: iconst_3
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: ldc 62
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: bipush 6
    //   101: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: dup
    //   106: iconst_2
    //   107: new 70	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   114: ldc 73
    //   116: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 80	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   123: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc 82
    //   128: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: aastore
    //   135: invokestatic 91	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   138: goto -78 -> 60
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	yus
    //   13	62	1	localObject1	Object
    //   84	36	1	localThrowable	Throwable
    //   141	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	60	84	java/lang/Throwable
    //   69	81	84	java/lang/Throwable
    //   2	14	141	finally
    //   18	60	141	finally
    //   60	65	141	finally
    //   69	81	141	finally
    //   85	138	141	finally
  }
  
  /* Error */
  private URLConnection a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: ldc 104
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 24	yus:jdField_a_of_type_Boolean	Z
    //   14: ifeq +76 -> 90
    //   17: aload_0
    //   18: getfield 22	yus:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokestatic 110	com/tencent/mobileqq/apollo/store/webview/ApolloClientUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_3
    //   25: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +32 -> 60
    //   31: ldc 60
    //   33: iconst_2
    //   34: new 70	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   41: ldc 116
    //   43: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokestatic 102	java/lang/System:currentTimeMillis	()J
    //   49: lload_1
    //   50: lsub
    //   51: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_3
    //   61: astore 4
    //   63: aload_3
    //   64: invokestatic 129	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +23 -> 90
    //   70: aload_3
    //   71: astore 4
    //   73: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +14 -> 90
    //   79: ldc 60
    //   81: iconst_2
    //   82: ldc 131
    //   84: invokestatic 134	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_3
    //   88: astore 4
    //   90: new 136	java/net/URL
    //   93: dup
    //   94: aload_0
    //   95: getfield 22	yus:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokespecial 139	java/net/URL:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 142	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 144	java/net/HttpURLConnection
    //   107: astore_3
    //   108: aload_3
    //   109: ifnonnull +23 -> 132
    //   112: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +11 -> 126
    //   118: ldc 60
    //   120: iconst_2
    //   121: ldc 146
    //   123: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aconst_null
    //   127: astore_3
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_3
    //   131: areturn
    //   132: aload_3
    //   133: aload_0
    //   134: getfield 18	yus:jdField_a_of_type_Int	I
    //   137: invokevirtual 150	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   140: aload_3
    //   141: aload_0
    //   142: getfield 20	yus:b	I
    //   145: invokevirtual 153	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   148: aload_3
    //   149: iconst_0
    //   150: invokevirtual 157	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   153: aload_3
    //   154: ldc 159
    //   156: aload 4
    //   158: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_3
    //   162: ldc 165
    //   164: ldc 40
    //   166: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_3
    //   170: ldc 167
    //   172: ldc 169
    //   174: invokestatic 173	com/tencent/mobileqq/webview/swift/utils/SwiftWebViewUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   177: ldc 104
    //   179: iconst_0
    //   180: invokestatic 176	com/tencent/mobileqq/webview/swift/utils/SwiftWebViewUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   183: invokevirtual 163	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: goto -58 -> 128
    //   189: astore 5
    //   191: aload_3
    //   192: astore 4
    //   194: ldc 60
    //   196: iconst_2
    //   197: ldc 178
    //   199: aload 5
    //   201: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload 4
    //   206: astore_3
    //   207: aload 4
    //   209: ifnull -81 -> 128
    //   212: aload 4
    //   214: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   217: aload 4
    //   219: astore_3
    //   220: goto -92 -> 128
    //   223: astore_3
    //   224: aload_0
    //   225: monitorexit
    //   226: aload_3
    //   227: athrow
    //   228: astore_3
    //   229: aconst_null
    //   230: astore 4
    //   232: ldc 60
    //   234: iconst_2
    //   235: ldc 178
    //   237: aload_3
    //   238: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload 4
    //   243: astore_3
    //   244: aload 4
    //   246: ifnull -118 -> 128
    //   249: aload 4
    //   251: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   254: aload 4
    //   256: astore_3
    //   257: goto -129 -> 128
    //   260: astore 5
    //   262: aload_3
    //   263: astore 4
    //   265: aload 5
    //   267: astore_3
    //   268: goto -36 -> 232
    //   271: astore 5
    //   273: aconst_null
    //   274: astore 4
    //   276: goto -82 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	yus
    //   5	45	1	l	long
    //   24	196	3	localObject1	Object
    //   223	4	3	localObject2	Object
    //   228	10	3	localException1	Exception
    //   243	25	3	localObject3	Object
    //   8	267	4	localObject4	Object
    //   189	11	5	localIOException1	java.io.IOException
    //   260	6	5	localException2	Exception
    //   271	1	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   112	126	189	java/io/IOException
    //   132	186	189	java/io/IOException
    //   2	6	223	finally
    //   10	60	223	finally
    //   63	70	223	finally
    //   73	87	223	finally
    //   90	108	223	finally
    //   112	126	223	finally
    //   132	186	223	finally
    //   194	204	223	finally
    //   212	217	223	finally
    //   232	241	223	finally
    //   249	254	223	finally
    //   2	6	228	java/lang/Exception
    //   10	60	228	java/lang/Exception
    //   63	70	228	java/lang/Exception
    //   73	87	228	java/lang/Exception
    //   90	108	228	java/lang/Exception
    //   112	126	260	java/lang/Exception
    //   132	186	260	java/lang/Exception
    //   2	6	271	java/io/IOException
    //   10	60	271	java/io/IOException
    //   63	70	271	java/io/IOException
    //   73	87	271	java/io/IOException
    //   90	108	271	java/io/IOException
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   6: ifnonnull +68 -> 74
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 187	yus:a	()Ljava/net/URLConnection;
    //   14: putfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   17: aload_0
    //   18: getfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   21: instanceof 144
    //   24: ifeq +50 -> 74
    //   27: aload_0
    //   28: getfield 32	yus:jdField_a_of_type_JavaNetURLConnection	Ljava/net/URLConnection;
    //   31: checkcast 144	java/net/HttpURLConnection
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 190	java/net/HttpURLConnection:connect	()V
    //   39: iconst_0
    //   40: istore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_1
    //   44: ireturn
    //   45: astore_2
    //   46: ldc 60
    //   48: iconst_2
    //   49: new 70	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   56: ldc 192
    //   58: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_2
    //   62: invokevirtual 80	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   65: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 194	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: iconst_m1
    //   75: istore_1
    //   76: goto -35 -> 41
    //   79: astore_2
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	yus
    //   40	36	1	i	int
    //   34	2	2	localHttpURLConnection	HttpURLConnection
    //   45	17	2	localThrowable	Throwable
    //   79	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	39	45	java/lang/Throwable
    //   2	35	79	finally
    //   35	39	79	finally
    //   46	74	79	finally
  }
  
  public Map a()
  {
    if (this.jdField_a_of_type_JavaNetURLConnection != null) {
      return this.jdField_a_of_type_JavaNetURLConnection.getHeaderFields();
    }
    return null;
  }
  
  public yuu a(AtomicBoolean paramAtomicBoolean, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    boolean bool = true;
    BufferedInputStream localBufferedInputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    int j;
    label136:
    try
    {
      localBufferedInputStream = a();
      if (localBufferedInputStream != null)
      {
        localByteArrayOutputStream = paramByteArrayOutputStream;
        if (paramByteArrayOutputStream == null) {
          localByteArrayOutputStream = new ByteArrayOutputStream();
        }
        paramByteArrayOutputStream = new byte[10240];
        int i = 0;
        for (;;)
        {
          j = i;
          try
          {
            if (paramAtomicBoolean.get()) {
              break label136;
            }
            i = localBufferedInputStream.read(paramByteArrayOutputStream);
            j = i;
            if (-1 == i) {
              break label136;
            }
            localByteArrayOutputStream.write(paramByteArrayOutputStream, 0, i);
          }
          catch (Throwable paramAtomicBoolean)
          {
            QLog.e("apollo_client_ApolloUrlInterceptor", 2, new Object[] { "SonicSdk_SonicSessionConnection", Integer.valueOf(6), "getResponseData error:" + paramAtomicBoolean.getMessage() + "." });
          }
        }
      }
      paramAtomicBoolean = null;
      return paramAtomicBoolean;
    }
    finally {}
    paramAtomicBoolean = new yuu();
    paramAtomicBoolean.jdField_a_of_type_JavaIoBufferedInputStream = localBufferedInputStream;
    paramAtomicBoolean.jdField_a_of_type_JavaIoByteArrayOutputStream = localByteArrayOutputStream;
    if (-1 == j) {}
    for (;;)
    {
      paramAtomicBoolean.jdField_a_of_type_Boolean = bool;
      break;
      bool = false;
    }
  }
  
  public void a()
  {
    HttpURLConnection localHttpURLConnection;
    if ((this.jdField_a_of_type_JavaNetURLConnection instanceof HttpURLConnection))
    {
      localHttpURLConnection = (HttpURLConnection)this.jdField_a_of_type_JavaNetURLConnection;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ThreadManager.executeOnSubThread(new yut(this, localHttpURLConnection));
      }
    }
    else
    {
      return;
    }
    try
    {
      localHttpURLConnection.disconnect();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_client_ApolloUrlInterceptor", 2, "disconnect error:" + localException.getMessage());
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaNetURLConnection instanceof HttpURLConnection)) {
      try
      {
        int i = ((HttpURLConnection)this.jdField_a_of_type_JavaNetURLConnection).getResponseCode();
        return i;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("apollo_client_ApolloUrlInterceptor", 2, "getResponseCode error:" + localThrowable.getMessage());
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yus
 * JD-Core Version:    0.7.0.1
 */