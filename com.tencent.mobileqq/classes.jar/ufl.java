import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/util/RIJAdUrlChangeUtil;", "", "()V", "TAG", "", "convertStreamToString", "inputStream", "Ljava/io/InputStream;", "getApkDownloadUrl", "clickUrl", "parseApkDownloadUrl", "jsonObject", "Lorg/json/JSONObject;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ufl
{
  public static final ufl a = new ufl();
  
  private final String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader((Reader)new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    String str = (String)null;
    for (;;)
    {
      str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  @Nullable
  public final String a(@Nullable String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: checkcast 73	java/lang/CharSequence
    //   7: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: ldc 81
    //   17: new 83	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   24: ldc 86
    //   26: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 91
    //   35: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   41: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 106	ukq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aconst_null
    //   51: checkcast 56	java/lang/String
    //   54: astore_3
    //   55: aload_1
    //   56: ifnull +158 -> 214
    //   59: aload_1
    //   60: astore_2
    //   61: aconst_null
    //   62: checkcast 108	java/net/HttpURLConnection
    //   65: astore 4
    //   67: aload 4
    //   69: astore_1
    //   70: new 110	java/net/URL
    //   73: dup
    //   74: aload_2
    //   75: invokespecial 113	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 117	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   81: astore_2
    //   82: aload 4
    //   84: astore_1
    //   85: aload_2
    //   86: instanceof 108
    //   89: ifne +257 -> 346
    //   92: aload 5
    //   94: astore_2
    //   95: aload 4
    //   97: astore_1
    //   98: aload_2
    //   99: checkcast 108	java/net/HttpURLConnection
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +47 -> 151
    //   107: aload_2
    //   108: ldc 119
    //   110: invokevirtual 122	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   113: aload_2
    //   114: ldc 124
    //   116: ldc 126
    //   118: invokevirtual 129	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_2
    //   122: ldc 131
    //   124: ldc 133
    //   126: invokevirtual 129	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_2
    //   130: ldc 135
    //   132: ldc 137
    //   134: invokevirtual 129	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_2
    //   138: sipush 3000
    //   141: invokevirtual 141	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   144: aload_2
    //   145: sipush 3000
    //   148: invokevirtual 144	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   151: aload_2
    //   152: ifnull +126 -> 278
    //   155: aload_2
    //   156: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   159: sipush 200
    //   162: if_icmpne +116 -> 278
    //   165: aload_0
    //   166: aload_2
    //   167: invokevirtual 152	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   170: invokespecial 154	ufl:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   173: astore_1
    //   174: aload_1
    //   175: checkcast 73	java/lang/CharSequence
    //   178: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +39 -> 220
    //   184: aload_0
    //   185: new 156	org/json/JSONObject
    //   188: dup
    //   189: aload_1
    //   190: invokespecial 157	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   193: invokevirtual 160	ufl:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   196: astore_1
    //   197: aload_1
    //   198: astore 4
    //   200: aload_2
    //   201: ifnull +10 -> 211
    //   204: aload_2
    //   205: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   208: aload_1
    //   209: astore 4
    //   211: aload 4
    //   213: areturn
    //   214: ldc 164
    //   216: astore_2
    //   217: goto -156 -> 61
    //   220: ldc 81
    //   222: ldc 166
    //   224: invokestatic 106	ukq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_3
    //   228: astore_1
    //   229: goto -32 -> 197
    //   232: astore 5
    //   234: aload_2
    //   235: astore_1
    //   236: ldc 81
    //   238: new 83	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   245: ldc 168
    //   247: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 5
    //   252: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 106	ukq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_3
    //   262: astore 4
    //   264: aload_2
    //   265: ifnull -54 -> 211
    //   268: aload_2
    //   269: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   272: aload_3
    //   273: astore 4
    //   275: goto -64 -> 211
    //   278: new 83	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   285: ldc 173
    //   287: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: astore_1
    //   291: aload_2
    //   292: ifnonnull +6 -> 298
    //   295: invokestatic 178	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   298: ldc 81
    //   300: aload_1
    //   301: aload_2
    //   302: invokevirtual 148	java/net/HttpURLConnection:getResponseCode	()I
    //   305: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 106	ukq:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_3
    //   315: astore_1
    //   316: goto -119 -> 197
    //   319: astore_1
    //   320: aload_2
    //   321: ifnull +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   328: aload_1
    //   329: athrow
    //   330: astore_3
    //   331: aload_1
    //   332: astore_2
    //   333: aload_3
    //   334: astore_1
    //   335: goto -15 -> 320
    //   338: astore 5
    //   340: aload 4
    //   342: astore_2
    //   343: goto -109 -> 234
    //   346: goto -251 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	ufl
    //   0	349	1	paramString	String
    //   60	283	2	localObject1	Object
    //   54	261	3	str	String
    //   330	4	3	localObject2	Object
    //   65	276	4	localObject3	Object
    //   1	92	5	localObject4	Object
    //   232	19	5	localException1	java.lang.Exception
    //   338	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   107	151	232	java/lang/Exception
    //   155	197	232	java/lang/Exception
    //   220	227	232	java/lang/Exception
    //   278	291	232	java/lang/Exception
    //   295	298	232	java/lang/Exception
    //   298	314	232	java/lang/Exception
    //   107	151	319	finally
    //   155	197	319	finally
    //   220	227	319	finally
    //   278	291	319	finally
    //   295	298	319	finally
    //   298	314	319	finally
    //   70	82	330	finally
    //   85	92	330	finally
    //   98	103	330	finally
    //   236	261	330	finally
    //   70	82	338	java/lang/Exception
    //   85	92	338	java/lang/Exception
    //   98	103	338	java/lang/Exception
  }
  
  @Nullable
  public final String a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    try
    {
      String str2 = paramJSONObject.optString("apkUrl");
      Intrinsics.checkExpressionValueIsNotNull(str2, "jsonObject.optString(\"apkUrl\")");
      String str1 = str2;
      return str2;
    }
    catch (Throwable paramJSONObject)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)str2))
        {
          str1 = paramJSONObject.optJSONObject("data").optString("dstlink");
          Intrinsics.checkExpressionValueIsNotNull(str1, "jsonObject.optJSONObject…ta\").optString(\"dstlink\")");
        }
        return str1;
      }
      catch (Throwable paramJSONObject) {}
      paramJSONObject = paramJSONObject;
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufl
 * JD-Core Version:    0.7.0.1
 */