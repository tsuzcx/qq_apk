import com.dataline.util.HttpDownload;
import com.dataline.util.HttpDownload.HttpTar;
import com.dataline.util.HttpUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;

public class dm
  implements Runnable
{
  private static final String jdField_a_of_type_JavaLangString = "dlFileTransfer.download";
  private long jdField_a_of_type_Long = 0L;
  public HttpDownload.HttpTar a;
  public HttpDownload a;
  private long b;
  private long c;
  private long d = 0L;
  
  public dm()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private HttpResponse a(HttpDownload.HttpTar paramHttpTar, HttpClient paramHttpClient, HttpGet paramHttpGet)
  {
    Object localObject = null;
    try
    {
      paramHttpClient = paramHttpClient.execute(paramHttpGet);
      return paramHttpClient;
    }
    catch (IOException paramHttpClient)
    {
      do
      {
        paramHttpTar.jdField_a_of_type_Int = 2;
        paramHttpClient.printStackTrace();
        QLog.d("dlFileTransfer.download", 1, "downloader: io error. session =" + paramHttpTar.jdField_a_of_type_Long + ",offset=" + paramHttpTar.jdField_b_of_type_Long + ",length=" + paramHttpTar.jdField_c_of_type_Long);
        paramHttpClient = localObject;
      } while (!paramHttpTar.jdField_b_of_type_Boolean);
      paramHttpTar.jdField_a_of_type_Int = 8;
    }
    return null;
  }
  
  /* Error */
  private HttpGet a(HttpDownload.HttpTar arg1)
  {
    // Byte code:
    //   0: new 80	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   8: getfield 84	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   11: invokespecial 87	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 91	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 94	java/io/File:createNewFile	()Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   31: aload_1
    //   32: invokevirtual 98	java/io/File:length	()J
    //   35: putfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   38: new 100	org/apache/http/client/methods/HttpGet
    //   41: dup
    //   42: ldc 102
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   54: getfield 104	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: aload_0
    //   61: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   64: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   67: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokespecial 117	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   77: astore_2
    //   78: aload_0
    //   79: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   82: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   85: lconst_0
    //   86: lcmp
    //   87: ifeq +46 -> 133
    //   90: aload_2
    //   91: ldc 119
    //   93: ldc 121
    //   95: iconst_2
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   105: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   108: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload_0
    //   115: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   118: getfield 65	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Long	J
    //   121: lconst_1
    //   122: lsub
    //   123: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aastore
    //   127: invokestatic 116	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokevirtual 125	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_0
    //   134: getfield 127	dm:jdField_a_of_type_ComDatalineUtilHttpDownload	Lcom/dataline/util/HttpDownload;
    //   137: getfield 132	com/dataline/util/HttpDownload:a	Ljava/util/Map;
    //   140: astore_1
    //   141: aload_1
    //   142: monitorenter
    //   143: aload_0
    //   144: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   147: aload_2
    //   148: putfield 135	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_OrgApacheHttpClientMethodsHttpGet	Lorg/apache/http/client/methods/HttpGet;
    //   151: aload_1
    //   152: monitorexit
    //   153: invokestatic 141	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   156: invokestatic 147	com/tencent/mobileqq/utils/NetworkUtil:g	(Landroid/content/Context;)Z
    //   159: ifeq +90 -> 249
    //   162: aload_2
    //   163: ldc 149
    //   165: ldc 151
    //   167: invokevirtual 125	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: ldc 10
    //   172: iconst_1
    //   173: new 48	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   180: ldc 153
    //   182: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   189: getfield 56	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Long	J
    //   192: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc 61
    //   197: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_0
    //   201: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   204: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   207: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: ldc 64
    //   212: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_0
    //   216: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   219: getfield 65	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Long	J
    //   222: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: aload_2
    //   232: areturn
    //   233: astore_1
    //   234: aload_0
    //   235: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   238: iconst_3
    //   239: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   242: aconst_null
    //   243: areturn
    //   244: astore_2
    //   245: aload_1
    //   246: monitorexit
    //   247: aload_2
    //   248: athrow
    //   249: aload_2
    //   250: ldc 149
    //   252: ldc 155
    //   254: invokevirtual 125	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: ldc 10
    //   259: iconst_1
    //   260: new 48	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   267: ldc 157
    //   269: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   276: getfield 56	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Long	J
    //   279: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: ldc 61
    //   284: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   291: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   294: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   297: ldc 64
    //   299: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_0
    //   303: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   306: getfield 65	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Long	J
    //   309: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   312: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload_2
    //   319: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	dm
    //   77	155	2	localHttpGet1	HttpGet
    //   244	75	2	localHttpGet2	HttpGet
    // Exception table:
    //   from	to	target	type
    //   22	27	233	java/io/IOException
    //   143	153	244	finally
    //   245	247	244	finally
  }
  
  private boolean a()
  {
    boolean bool2;
    boolean bool1;
    boolean bool3;
    if (HttpUtil.a() != null)
    {
      bool2 = true;
      bool1 = false;
      localObject = a(this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar);
      if (localObject != null) {
        break label34;
      }
      bool3 = bool1;
    }
    label27:
    label34:
    do
    {
      return bool3;
      bool2 = false;
      break;
      bool3 = bool1;
    } while (this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean);
    HttpClient localHttpClient = HttpUtil.a(false, bool2, this.jdField_a_of_type_ComDatalineUtilHttpDownload.f, this.jdField_a_of_type_ComDatalineUtilHttpDownload.g);
    if (this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean)
    {
      localHttpClient.getConnectionManager().shutdown();
      return bool1;
    }
    Object localObject = a(this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar, localHttpClient, (HttpGet)localObject);
    if (this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean)
    {
      localHttpClient.getConnectionManager().shutdown();
      return bool1;
    }
    if (localObject == null) {
      localHttpClient.getConnectionManager().shutdown();
    }
    do
    {
      bool3 = bool1;
      if (!bool2) {
        break label27;
      }
      bool2 = false;
      break;
      bool3 = a(this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar, (HttpResponse)localObject);
      localHttpClient.getConnectionManager().shutdown();
      bool1 = bool3;
    } while (!this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean);
    return bool3;
  }
  
  /* Error */
  private boolean a(HttpDownload.HttpTar paramHttpTar, HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 196 1 0
    //   6: astore 11
    //   8: ldc 198
    //   10: astore_1
    //   11: aload_2
    //   12: ldc 200
    //   14: invokeinterface 204 2 0
    //   19: ifeq +19 -> 38
    //   22: aload_2
    //   23: ldc 200
    //   25: invokeinterface 208 2 0
    //   30: iconst_0
    //   31: aaload
    //   32: invokeinterface 213 1 0
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   42: aload 11
    //   44: invokeinterface 219 1 0
    //   49: putfield 221	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   56: aload_1
    //   57: invokestatic 227	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: putfield 229	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Int	I
    //   63: aload 11
    //   65: invokeinterface 219 1 0
    //   70: sipush 200
    //   73: if_icmpeq +16 -> 89
    //   76: aload 11
    //   78: invokeinterface 219 1 0
    //   83: sipush 206
    //   86: if_icmpne +375 -> 461
    //   89: aload_0
    //   90: aload_0
    //   91: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   94: iconst_1
    //   95: lconst_0
    //   96: invokespecial 232	dm:a	(Lcom/dataline/util/HttpDownload$HttpTar;ZJ)Z
    //   99: pop
    //   100: new 234	java/io/FileOutputStream
    //   103: dup
    //   104: aload_0
    //   105: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   108: getfield 84	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   111: iconst_1
    //   112: invokespecial 237	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   115: astore_1
    //   116: aload_2
    //   117: invokeinterface 241 1 0
    //   122: invokeinterface 247 1 0
    //   127: astore_2
    //   128: sipush 2048
    //   131: newarray byte
    //   133: astore 11
    //   135: iconst_0
    //   136: istore 4
    //   138: aload_2
    //   139: aload 11
    //   141: invokevirtual 253	java/io/InputStream:read	([B)I
    //   144: istore 5
    //   146: iload 5
    //   148: istore 4
    //   150: iload 4
    //   152: ifgt +197 -> 349
    //   155: aload_1
    //   156: invokevirtual 258	java/io/OutputStream:close	()V
    //   159: aload_0
    //   160: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   163: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   166: aload_0
    //   167: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   170: getfield 65	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Long	J
    //   173: lcmp
    //   174: ifne +410 -> 584
    //   177: iconst_1
    //   178: istore 6
    //   180: iload 6
    //   182: ifeq +127 -> 309
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   190: iconst_0
    //   191: lconst_0
    //   192: invokespecial 232	dm:a	(Lcom/dataline/util/HttpDownload$HttpTar;ZJ)Z
    //   195: pop
    //   196: invokestatic 263	java/lang/System:currentTimeMillis	()J
    //   199: ldc2_w 264
    //   202: ldiv
    //   203: lstore 9
    //   205: lload 9
    //   207: lstore 7
    //   209: lload 9
    //   211: aload_0
    //   212: getfield 22	dm:jdField_a_of_type_Long	J
    //   215: lcmp
    //   216: ifne +11 -> 227
    //   219: aload_0
    //   220: getfield 22	dm:jdField_a_of_type_Long	J
    //   223: lconst_1
    //   224: ladd
    //   225: lstore 7
    //   227: aload_0
    //   228: getfield 26	dm:jdField_c_of_type_Long	J
    //   231: l2f
    //   232: lload 7
    //   234: aload_0
    //   235: getfield 22	dm:jdField_a_of_type_Long	J
    //   238: lsub
    //   239: l2f
    //   240: fdiv
    //   241: ldc_w 266
    //   244: fdiv
    //   245: fstore_3
    //   246: ldc 10
    //   248: iconst_1
    //   249: new 48	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 268
    //   259: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_0
    //   263: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   266: getfield 56	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Long	J
    //   269: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: ldc 64
    //   274: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   281: getfield 65	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Long	J
    //   284: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: ldc_w 270
    //   290: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: fload_3
    //   294: invokevirtual 273	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   297: ldc_w 275
    //   300: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: iload 6
    //   311: ireturn
    //   312: astore_1
    //   313: aload_0
    //   314: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   317: iconst_3
    //   318: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   321: goto -162 -> 159
    //   324: astore_1
    //   325: aload_0
    //   326: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   329: iconst_4
    //   330: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   333: goto -174 -> 159
    //   336: astore 12
    //   338: aload_0
    //   339: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   342: iconst_4
    //   343: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   346: goto -196 -> 150
    //   349: aload_0
    //   350: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   353: astore 12
    //   355: aload 12
    //   357: aload 12
    //   359: getfield 276	com/dataline/util/HttpDownload$HttpTar:d	J
    //   362: iload 4
    //   364: i2l
    //   365: ladd
    //   366: putfield 276	com/dataline/util/HttpDownload$HttpTar:d	J
    //   369: aload_1
    //   370: aload 11
    //   372: iconst_0
    //   373: iload 4
    //   375: invokevirtual 280	java/io/OutputStream:write	([BII)V
    //   378: aload_1
    //   379: invokevirtual 283	java/io/OutputStream:flush	()V
    //   382: aload_0
    //   383: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   386: astore 12
    //   388: aload 12
    //   390: aload 12
    //   392: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   395: iload 4
    //   397: i2l
    //   398: ladd
    //   399: putfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   402: aload_0
    //   403: aload_0
    //   404: getfield 26	dm:jdField_c_of_type_Long	J
    //   407: iload 4
    //   409: i2l
    //   410: ladd
    //   411: putfield 26	dm:jdField_c_of_type_Long	J
    //   414: aload_0
    //   415: aload_0
    //   416: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   419: iconst_0
    //   420: iload 4
    //   422: i2l
    //   423: invokespecial 232	dm:a	(Lcom/dataline/util/HttpDownload$HttpTar;ZJ)Z
    //   426: pop
    //   427: aload_0
    //   428: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   431: getfield 77	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Boolean	Z
    //   434: ifeq -299 -> 135
    //   437: aload_0
    //   438: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   441: bipush 8
    //   443: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   446: goto -291 -> 155
    //   449: astore_2
    //   450: aload_0
    //   451: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   454: iconst_3
    //   455: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   458: goto -303 -> 155
    //   461: aload_0
    //   462: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   465: iconst_2
    //   466: putfield 43	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Int	I
    //   469: ldc 10
    //   471: iconst_1
    //   472: new 48	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 285
    //   482: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 11
    //   487: invokeinterface 219 1 0
    //   492: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   495: ldc_w 290
    //   498: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 11
    //   503: invokeinterface 293 1 0
    //   508: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc_w 295
    //   514: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_0
    //   518: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   521: getfield 56	com/dataline/util/HttpDownload$HttpTar:jdField_a_of_type_Long	J
    //   524: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   527: ldc 61
    //   529: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_0
    //   533: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   536: getfield 62	com/dataline/util/HttpDownload$HttpTar:jdField_b_of_type_Long	J
    //   539: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   542: ldc 64
    //   544: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_0
    //   548: getfield 82	dm:jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar	Lcom/dataline/util/HttpDownload$HttpTar;
    //   551: getfield 65	com/dataline/util/HttpDownload$HttpTar:jdField_c_of_type_Long	J
    //   554: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   557: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aload_2
    //   564: invokeinterface 241 1 0
    //   569: invokeinterface 247 1 0
    //   574: invokevirtual 296	java/io/InputStream:close	()V
    //   577: goto -418 -> 159
    //   580: astore_1
    //   581: goto -422 -> 159
    //   584: iconst_0
    //   585: istore 6
    //   587: goto -407 -> 180
    //   590: astore_1
    //   591: goto -432 -> 159
    //   594: astore_1
    //   595: goto -532 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	this	dm
    //   0	598	1	paramHttpTar	HttpDownload.HttpTar
    //   0	598	2	paramHttpResponse	HttpResponse
    //   245	49	3	f	float
    //   136	285	4	i	int
    //   144	3	5	j	int
    //   178	408	6	bool	boolean
    //   207	26	7	l1	long
    //   203	7	9	l2	long
    //   6	496	11	localObject	Object
    //   336	1	12	localIOException	IOException
    //   353	38	12	localHttpTar	HttpDownload.HttpTar
    // Exception table:
    //   from	to	target	type
    //   100	116	312	java/io/FileNotFoundException
    //   116	128	324	java/io/IOException
    //   138	146	336	java/io/IOException
    //   369	382	449	java/io/IOException
    //   563	577	580	java/io/IOException
    //   155	159	590	java/io/IOException
    //   38	63	594	java/lang/Exception
  }
  
  private boolean a(HttpDownload.HttpTar paramHttpTar, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (this.d == 0L)
      {
        this.jdField_a_of_type_ComDatalineUtilHttpDownload.a(paramHttpTar);
        this.d += 1L;
      }
      paramHttpTar.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      return false;
      paramLong = System.currentTimeMillis() / 500L;
      if ((paramLong != this.jdField_b_of_type_Long) || (paramHttpTar.jdField_b_of_type_Long == paramHttpTar.jdField_c_of_type_Long))
      {
        this.jdField_b_of_type_Long = paramLong;
        paramLong = System.currentTimeMillis() / 1000L;
        if (paramLong != this.jdField_a_of_type_Long)
        {
          float f = (float)this.jdField_c_of_type_Long / (float)(paramLong - this.jdField_a_of_type_Long) / 1024.0F;
          QLog.d("dlFileTransfer.download", 2, "downloader: onProgress[RT], filename = " + paramHttpTar.jdField_b_of_type_JavaLangString + " Speed = " + f + "KB/s");
        }
        this.jdField_a_of_type_ComDatalineUtilHttpDownload.b(paramHttpTar);
      }
    }
  }
  
  public void run()
  {
    boolean bool1 = false;
    boolean bool3 = NetworkUtil.g(BaseApplication.getContext());
    this.jdField_a_of_type_Long = (System.currentTimeMillis() / 1000L);
    this.jdField_b_of_type_Long = (System.currentTimeMillis() / 500L);
    this.jdField_c_of_type_Long = 0L;
    int i = this.jdField_a_of_type_ComDatalineUtilHttpDownload.e;
    if (!this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean)
    {
      bool1 = a();
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (i > 0) {
          if (!this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean) {
            break label119;
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = bool1)
    {
      for (;;)
      {
        HttpDownload localHttpDownload = this.jdField_a_of_type_ComDatalineUtilHttpDownload;
        HttpDownload.HttpTar localHttpTar = this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar;
        this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar = null;
        this.jdField_a_of_type_ComDatalineUtilHttpDownload = null;
        localHttpDownload.a(localHttpTar, bool2);
        return;
        label119:
        int j = 3;
        try
        {
          for (;;)
          {
            Thread.sleep(1000L);
            bool2 = this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean;
            if (bool2) {}
            do
            {
              do
              {
                if (!this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Boolean) {
                  break label219;
                }
                this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_a_of_type_Int = 8;
                bool2 = bool1;
                break;
              } while (j <= 0);
              if ((!NetworkUtil.f(BaseApplication.getContext())) && (!bool3)) {
                break label202;
              }
              bool2 = NetworkUtil.g(BaseApplication.getContext());
            } while ((bool2) || (!bool3));
            label202:
            j -= 1;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          label219:
          if ((bool3) && (!NetworkUtil.g(BaseApplication.getContext())))
          {
            this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_a_of_type_Int = 9;
            QLog.d("dlFileTransfer.download", 1, "downloader: network changed: wifi -> 3G. session =" + this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_a_of_type_Long + ",offset=" + this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_b_of_type_Long + ",length=" + this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpTar.jdField_c_of_type_Long);
            bool2 = bool1;
          }
          else
          {
            i -= 1;
          }
        }
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dm
 * JD-Core Version:    0.7.0.1
 */