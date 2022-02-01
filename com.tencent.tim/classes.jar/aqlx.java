import android.content.Context;
import android.net.Proxy;
import android.net.Uri;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;

public class aqlx
{
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  
  /* Error */
  private static aqlx.a a(Context paramContext)
  {
    // Byte code:
    //   0: new 6	aqlx$a
    //   3: dup
    //   4: invokespecial 28	aqlx$a:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: invokevirtual 34	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 21	aqlx:PREFERRED_APN_URI	Landroid/net/Uri;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokestatic 40	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokeinterface 46 1 0
    //   32: pop
    //   33: aload_1
    //   34: astore_0
    //   35: aload_1
    //   36: aload_1
    //   37: ldc 48
    //   39: invokeinterface 52 2 0
    //   44: invokeinterface 56 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +286 -> 337
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 62	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   60: astore_2
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: aload_1
    //   65: ldc 64
    //   67: invokeinterface 52 2 0
    //   72: invokeinterface 56 2 0
    //   77: astore 6
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_1
    //   83: ldc 66
    //   85: invokeinterface 52 2 0
    //   90: invokeinterface 56 2 0
    //   95: astore 4
    //   97: aload 4
    //   99: astore_3
    //   100: aload 4
    //   102: ifnull +11 -> 113
    //   105: aload_1
    //   106: astore_0
    //   107: aload 4
    //   109: invokevirtual 62	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   112: astore_3
    //   113: aload_1
    //   114: astore_0
    //   115: aload_1
    //   116: invokeinterface 69 1 0
    //   121: aload_2
    //   122: ifnull +61 -> 183
    //   125: aload_1
    //   126: astore_0
    //   127: aload_2
    //   128: invokevirtual 73	java/lang/String:length	()I
    //   131: ifle +52 -> 183
    //   134: aload_1
    //   135: astore_0
    //   136: aload 6
    //   138: invokestatic 79	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   141: invokevirtual 82	java/lang/Integer:intValue	()I
    //   144: ifle +39 -> 183
    //   147: aload_1
    //   148: astore_0
    //   149: aload 5
    //   151: aload_2
    //   152: putfield 86	aqlx$a:address	Ljava/lang/String;
    //   155: aload_1
    //   156: astore_0
    //   157: aload 5
    //   159: aload 6
    //   161: invokestatic 79	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   164: invokevirtual 82	java/lang/Integer:intValue	()I
    //   167: putfield 89	aqlx$a:port	I
    //   170: aload_1
    //   171: ifnull +9 -> 180
    //   174: aload_1
    //   175: invokeinterface 69 1 0
    //   180: aload 5
    //   182: areturn
    //   183: aload_3
    //   184: ifnull +55 -> 239
    //   187: aload_1
    //   188: astore_0
    //   189: aload_3
    //   190: ldc 91
    //   192: invokevirtual 95	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   195: ifeq +44 -> 239
    //   198: aload_1
    //   199: astore_0
    //   200: aload 5
    //   202: ldc 97
    //   204: putfield 86	aqlx$a:address	Ljava/lang/String;
    //   207: aload_1
    //   208: astore_0
    //   209: aload 5
    //   211: bipush 80
    //   213: putfield 89	aqlx$a:port	I
    //   216: goto -46 -> 170
    //   219: astore_2
    //   220: aload_1
    //   221: astore_0
    //   222: aload_2
    //   223: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   226: aload_1
    //   227: ifnull +9 -> 236
    //   230: aload_1
    //   231: invokeinterface 69 1 0
    //   236: aload 5
    //   238: areturn
    //   239: aload_3
    //   240: ifnull +49 -> 289
    //   243: aload_1
    //   244: astore_0
    //   245: aload_3
    //   246: ldc 102
    //   248: invokevirtual 95	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   251: ifeq +38 -> 289
    //   254: aload_1
    //   255: astore_0
    //   256: aload 5
    //   258: ldc 104
    //   260: putfield 86	aqlx$a:address	Ljava/lang/String;
    //   263: aload_1
    //   264: astore_0
    //   265: aload 5
    //   267: bipush 80
    //   269: putfield 89	aqlx$a:port	I
    //   272: goto -102 -> 170
    //   275: astore_1
    //   276: aload_0
    //   277: ifnull +9 -> 286
    //   280: aload_0
    //   281: invokeinterface 69 1 0
    //   286: aload 5
    //   288: areturn
    //   289: aload_3
    //   290: ifnull -120 -> 170
    //   293: aload_1
    //   294: astore_0
    //   295: aload_3
    //   296: ldc 106
    //   298: invokevirtual 95	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   301: ifeq -131 -> 170
    //   304: aload_1
    //   305: astore_0
    //   306: aload 5
    //   308: ldc 104
    //   310: putfield 86	aqlx$a:address	Ljava/lang/String;
    //   313: aload_1
    //   314: astore_0
    //   315: aload 5
    //   317: bipush 80
    //   319: putfield 89	aqlx$a:port	I
    //   322: goto -152 -> 170
    //   325: astore_0
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -52 -> 276
    //   331: astore_2
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -114 -> 220
    //   337: goto -276 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramContext	Context
    //   23	241	1	localCursor	android.database.Cursor
    //   275	39	1	localObject1	Object
    //   333	1	1	localObject2	Object
    //   49	103	2	str1	String
    //   219	4	2	localException1	java.lang.Exception
    //   331	1	2	localException2	java.lang.Exception
    //   99	197	3	str2	String
    //   95	13	4	str3	String
    //   7	309	5	locala	aqlx.a
    //   77	83	6	str4	String
    // Exception table:
    //   from	to	target	type
    //   26	33	219	java/lang/Exception
    //   35	50	219	java/lang/Exception
    //   56	61	219	java/lang/Exception
    //   63	79	219	java/lang/Exception
    //   81	97	219	java/lang/Exception
    //   107	113	219	java/lang/Exception
    //   115	121	219	java/lang/Exception
    //   127	134	219	java/lang/Exception
    //   136	147	219	java/lang/Exception
    //   149	155	219	java/lang/Exception
    //   157	170	219	java/lang/Exception
    //   189	198	219	java/lang/Exception
    //   200	207	219	java/lang/Exception
    //   209	216	219	java/lang/Exception
    //   245	254	219	java/lang/Exception
    //   256	263	219	java/lang/Exception
    //   265	272	219	java/lang/Exception
    //   295	304	219	java/lang/Exception
    //   306	313	219	java/lang/Exception
    //   315	322	219	java/lang/Exception
    //   26	33	275	finally
    //   35	50	275	finally
    //   56	61	275	finally
    //   63	79	275	finally
    //   81	97	275	finally
    //   107	113	275	finally
    //   115	121	275	finally
    //   127	134	275	finally
    //   136	147	275	finally
    //   149	155	275	finally
    //   157	170	275	finally
    //   189	198	275	finally
    //   200	207	275	finally
    //   209	216	275	finally
    //   222	226	275	finally
    //   245	254	275	finally
    //   256	263	275	finally
    //   265	272	275	finally
    //   295	304	275	finally
    //   306	313	275	finally
    //   315	322	275	finally
    //   9	24	325	finally
    //   9	24	331	java/lang/Exception
  }
  
  /* Error */
  public static String a(Context paramContext, double paramDouble1, double paramDouble2, int paramInt, HttpClient paramHttpClient)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 113	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   10: ldc 116
    //   12: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: dload_1
    //   16: invokevirtual 123	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   19: ldc 125
    //   21: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: dload_3
    //   25: invokevirtual 123	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   28: ldc 127
    //   30: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 6
    //   38: new 132	org/apache/http/params/BasicHttpParams
    //   41: dup
    //   42: invokespecial 133	org/apache/http/params/BasicHttpParams:<init>	()V
    //   45: astore 7
    //   47: aload 7
    //   49: ldc2_w 134
    //   52: invokestatic 141	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   55: aload 7
    //   57: new 143	org/apache/http/conn/params/ConnPerRouteBean
    //   60: dup
    //   61: bipush 10
    //   63: invokespecial 146	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   66: invokestatic 150	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   69: aload 7
    //   71: bipush 10
    //   73: invokestatic 154	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   76: aload 7
    //   78: sipush 10000
    //   81: invokestatic 159	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   84: aload 7
    //   86: sipush 20000
    //   89: invokestatic 162	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   92: aload 7
    //   94: iconst_1
    //   95: invokestatic 166	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   98: aload 7
    //   100: sipush 8192
    //   103: invokestatic 169	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   106: aload 7
    //   108: getstatic 175	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   111: invokestatic 181	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   114: aload 7
    //   116: ldc 183
    //   118: invokestatic 187	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   121: new 189	org/apache/http/impl/client/DefaultHttpClient
    //   124: dup
    //   125: aload 7
    //   127: invokespecial 192	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   130: astore 7
    //   132: aload_0
    //   133: aload 7
    //   135: invokestatic 195	aqlx:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   138: new 197	java/io/InputStreamReader
    //   141: dup
    //   142: aload 7
    //   144: new 199	org/apache/http/client/methods/HttpGet
    //   147: dup
    //   148: aload 6
    //   150: invokespecial 202	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   153: invokeinterface 208 2 0
    //   158: invokeinterface 214 1 0
    //   163: invokeinterface 220 1 0
    //   168: invokespecial 223	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   171: astore 6
    //   173: new 225	java/io/BufferedReader
    //   176: dup
    //   177: aload 6
    //   179: invokespecial 228	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   182: astore 11
    //   184: ldc 230
    //   186: astore_0
    //   187: aload 6
    //   189: astore 7
    //   191: aload 11
    //   193: astore 8
    //   195: aload 11
    //   197: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   200: astore 9
    //   202: aload 9
    //   204: ifnull +38 -> 242
    //   207: aload 6
    //   209: astore 7
    //   211: aload 11
    //   213: astore 8
    //   215: new 113	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   222: aload_0
    //   223: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 9
    //   228: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: astore 9
    //   236: aload 9
    //   238: astore_0
    //   239: goto -52 -> 187
    //   242: aload 6
    //   244: ifnull +8 -> 252
    //   247: aload 6
    //   249: invokevirtual 234	java/io/InputStreamReader:close	()V
    //   252: aload_0
    //   253: astore 7
    //   255: aload 11
    //   257: ifnull +11 -> 268
    //   260: aload 11
    //   262: invokevirtual 235	java/io/BufferedReader:close	()V
    //   265: aload_0
    //   266: astore 7
    //   268: new 237	org/json/JSONObject
    //   271: dup
    //   272: aload 7
    //   274: invokespecial 238	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   277: ldc 240
    //   279: invokevirtual 244	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   282: astore_0
    //   283: aload_0
    //   284: iconst_0
    //   285: invokevirtual 250	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   288: astore 7
    //   290: ldc 230
    //   292: astore 6
    //   294: aload 6
    //   296: astore_0
    //   297: aload 7
    //   299: ifnull +11 -> 310
    //   302: aload 7
    //   304: ldc 252
    //   306: invokevirtual 255	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   309: astore_0
    //   310: aload_0
    //   311: ldc_w 256
    //   314: invokestatic 261	acfp:m	(I)Ljava/lang/String;
    //   317: invokevirtual 264	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   320: istore 5
    //   322: aload_0
    //   323: astore 6
    //   325: iload 5
    //   327: iflt +15 -> 342
    //   330: aload_0
    //   331: iconst_0
    //   332: iload 5
    //   334: invokevirtual 268	java/lang/String:substring	(II)Ljava/lang/String;
    //   337: invokevirtual 271	java/lang/String:trim	()Ljava/lang/String;
    //   340: astore 6
    //   342: aload 6
    //   344: areturn
    //   345: astore 6
    //   347: aload 6
    //   349: invokevirtual 272	java/io/IOException:printStackTrace	()V
    //   352: aload_0
    //   353: astore 7
    //   355: goto -87 -> 268
    //   358: astore 9
    //   360: aconst_null
    //   361: astore 10
    //   363: aconst_null
    //   364: astore 6
    //   366: ldc 230
    //   368: astore_0
    //   369: aload 10
    //   371: astore 7
    //   373: aload 6
    //   375: astore 8
    //   377: aload 9
    //   379: invokevirtual 272	java/io/IOException:printStackTrace	()V
    //   382: aload 10
    //   384: ifnull +8 -> 392
    //   387: aload 10
    //   389: invokevirtual 234	java/io/InputStreamReader:close	()V
    //   392: aload_0
    //   393: astore 7
    //   395: aload 6
    //   397: ifnull -129 -> 268
    //   400: aload 6
    //   402: invokevirtual 235	java/io/BufferedReader:close	()V
    //   405: aload_0
    //   406: astore 7
    //   408: goto -140 -> 268
    //   411: astore 6
    //   413: aload 6
    //   415: invokevirtual 272	java/io/IOException:printStackTrace	()V
    //   418: aload_0
    //   419: astore 7
    //   421: goto -153 -> 268
    //   424: astore_0
    //   425: aconst_null
    //   426: astore 6
    //   428: aload 6
    //   430: ifnull +8 -> 438
    //   433: aload 6
    //   435: invokevirtual 234	java/io/InputStreamReader:close	()V
    //   438: aload 8
    //   440: ifnull +8 -> 448
    //   443: aload 8
    //   445: invokevirtual 235	java/io/BufferedReader:close	()V
    //   448: aload_0
    //   449: athrow
    //   450: astore 6
    //   452: aload 6
    //   454: invokevirtual 272	java/io/IOException:printStackTrace	()V
    //   457: goto -9 -> 448
    //   460: astore_0
    //   461: ldc 230
    //   463: areturn
    //   464: astore_0
    //   465: aload_0
    //   466: invokevirtual 273	org/json/JSONException:printStackTrace	()V
    //   469: aload 6
    //   471: astore_0
    //   472: goto -162 -> 310
    //   475: astore_0
    //   476: goto -48 -> 428
    //   479: astore_0
    //   480: aload 7
    //   482: astore 6
    //   484: goto -56 -> 428
    //   487: astore 9
    //   489: aconst_null
    //   490: astore 7
    //   492: ldc 230
    //   494: astore_0
    //   495: aload 6
    //   497: astore 10
    //   499: aload 7
    //   501: astore 6
    //   503: goto -134 -> 369
    //   506: astore 9
    //   508: aload 6
    //   510: astore 10
    //   512: aload 11
    //   514: astore 6
    //   516: goto -147 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramContext	Context
    //   0	519	1	paramDouble1	double
    //   0	519	3	paramDouble2	double
    //   0	519	5	paramInt	int
    //   0	519	6	paramHttpClient	HttpClient
    //   45	455	7	localObject1	Object
    //   1	443	8	localObject2	Object
    //   200	37	9	str	String
    //   358	20	9	localIOException1	java.io.IOException
    //   487	1	9	localIOException2	java.io.IOException
    //   506	1	9	localIOException3	java.io.IOException
    //   361	150	10	localHttpClient	HttpClient
    //   182	331	11	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   247	252	345	java/io/IOException
    //   260	265	345	java/io/IOException
    //   138	173	358	java/io/IOException
    //   387	392	411	java/io/IOException
    //   400	405	411	java/io/IOException
    //   138	173	424	finally
    //   433	438	450	java/io/IOException
    //   443	448	450	java/io/IOException
    //   268	283	460	org/json/JSONException
    //   302	310	464	org/json/JSONException
    //   173	184	475	finally
    //   195	202	479	finally
    //   215	236	479	finally
    //   377	382	479	finally
    //   173	184	487	java/io/IOException
    //   195	202	506	java/io/IOException
    //   215	236	506	java/io/IOException
  }
  
  public static void a(Context paramContext, HttpClient paramHttpClient)
  {
    paramHttpClient.getParams().removeParameter("http.route.default-proxy");
    paramContext = bi(paramContext);
    if ((paramContext != null) && (paramContext.length() > 0))
    {
      paramContext = paramContext.split(":");
      if ((paramContext != null) && (paramContext.length == 2))
      {
        paramContext = new HttpHost(paramContext[0], Integer.valueOf(paramContext[1]).intValue());
        paramHttpClient.getParams().setParameter("http.route.default-proxy", paramContext);
      }
    }
  }
  
  private static String bi(Context paramContext)
  {
    String str2 = "";
    String str1;
    int i;
    if (paramContext == null)
    {
      str1 = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    for (;;)
    {
      paramContext = str2;
      if (str1 != null)
      {
        paramContext = str2;
        if (str1.trim().length() > 0) {
          paramContext = str1 + ":" + i;
        }
      }
      return paramContext;
      if (!AppNetConnInfo.isMobileConn()) {
        break;
      }
      str1 = Proxy.getHost(paramContext);
      int j = Proxy.getPort(paramContext);
      if ((str1 != null) && (str1.trim().length() != 0))
      {
        i = j;
        if (j > 0) {}
      }
      else
      {
        str1 = Proxy.getDefaultHost();
        j = Proxy.getDefaultPort();
        if ((str1 != null) && (str1.trim().length() != 0))
        {
          i = j;
          if (j > 0) {}
        }
        else
        {
          paramContext = a(paramContext);
          str1 = paramContext.address;
          i = paramContext.port;
        }
      }
    }
    return null;
  }
  
  static class a
  {
    public String address = "";
    public int port = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlx
 * JD-Core Version:    0.7.0.1
 */