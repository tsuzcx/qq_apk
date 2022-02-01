package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import android.os.Handler;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "handler", "Landroid/os/Handler;", "(Ljava/net/URL;Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;Landroid/os/Handler;)V", "reSend", "", "delay", "", "request", "run", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class JsonUploadRunnable
  extends QAPMUpload
  implements Runnable
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  public static final String TAG = "QAPM_base_JsonUploadRunnable";
  private final IReporter.ReportResultCallback callback;
  private final Handler handler;
  private final ResultObject resultObject;
  
  public JsonUploadRunnable(@NotNull URL paramURL, @NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback, @NotNull Handler paramHandler)
  {
    super(paramURL);
    this.resultObject = paramResultObject;
    this.callback = paramReportResultCallback;
    this.handler = paramHandler;
  }
  
  private final void reSend(long paramLong)
  {
    if (getRetry() > 0)
    {
      setRetry(getRetry() - 1);
      this.handler.postDelayed((Runnable)this, paramLong);
    }
  }
  
  public void request()
  {
    run();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 102	com/tencent/qapmsdk/base/reporter/authorization/Authorization:isAuthorize	Z
    //   3: ifeq +35 -> 38
    //   6: getstatic 107	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   9: checkcast 109	java/lang/CharSequence
    //   12: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +23 -> 38
    //   18: getstatic 121	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;
    //   21: invokevirtual 125	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:getAuthorization	()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;
    //   24: getstatic 129	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   27: getfield 134	com/tencent/qapmsdk/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   30: iconst_1
    //   31: invokevirtual 138	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getToken	(Ljava/lang/String;Z)Z
    //   34: ifne +4 -> 38
    //   37: return
    //   38: new 140	java/util/HashMap
    //   41: dup
    //   42: invokespecial 142	java/util/HashMap:<init>	()V
    //   45: astore_1
    //   46: aload_1
    //   47: checkcast 144	java/util/Map
    //   50: ldc 146
    //   52: ldc 148
    //   54: invokeinterface 152 3 0
    //   59: pop
    //   60: aload_1
    //   61: checkcast 144	java/util/Map
    //   64: ldc 154
    //   66: ldc 156
    //   68: invokeinterface 152 3 0
    //   73: pop
    //   74: aload_1
    //   75: checkcast 144	java/util/Map
    //   78: ldc 158
    //   80: getstatic 107	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   83: invokeinterface 152 3 0
    //   88: pop
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual 162	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   94: astore_3
    //   95: aload_3
    //   96: ifnull +323 -> 419
    //   99: new 164	java/util/zip/GZIPOutputStream
    //   102: dup
    //   103: new 166	java/io/DataOutputStream
    //   106: dup
    //   107: aload_3
    //   108: invokevirtual 172	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   111: invokespecial 175	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   114: checkcast 177	java/io/OutputStream
    //   117: invokespecial 178	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   120: checkcast 180	java/io/Closeable
    //   123: astore 4
    //   125: aconst_null
    //   126: checkcast 96	java/lang/Throwable
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: aload 4
    //   134: checkcast 164	java/util/zip/GZIPOutputStream
    //   137: astore 5
    //   139: aload_2
    //   140: astore_1
    //   141: aload_0
    //   142: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   145: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   148: invokevirtual 192	org/json/JSONObject:toString	()Ljava/lang/String;
    //   151: astore 6
    //   153: aload_2
    //   154: astore_1
    //   155: aload 6
    //   157: ldc 194
    //   159: invokestatic 197	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   162: aload_2
    //   163: astore_1
    //   164: ldc 199
    //   166: invokestatic 205	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   169: astore 7
    //   171: aload_2
    //   172: astore_1
    //   173: aload 7
    //   175: ldc 207
    //   177: invokestatic 197	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   180: aload 6
    //   182: ifnonnull +111 -> 293
    //   185: aload_2
    //   186: astore_1
    //   187: new 209	kotlin/TypeCastException
    //   190: dup
    //   191: ldc 211
    //   193: invokespecial 214	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   196: athrow
    //   197: astore_2
    //   198: aload_2
    //   199: astore_1
    //   200: aload_2
    //   201: athrow
    //   202: astore_2
    //   203: aload 4
    //   205: aload_1
    //   206: invokestatic 220	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_0
    //   213: iconst_0
    //   214: invokevirtual 82	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:setRetry	(I)V
    //   217: aload_0
    //   218: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +15 -> 238
    //   226: aload_2
    //   227: sipush 600
    //   230: ldc 222
    //   232: iconst_0
    //   233: invokeinterface 228 4 0
    //   238: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   241: ldc 43
    //   243: new 235	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   250: aload_1
    //   251: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: ldc 242
    //   256: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   263: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   266: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: ldc 247
    //   271: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: aload_1
    //   278: checkcast 96	java/lang/Throwable
    //   281: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload_3
    //   285: ifnull -248 -> 37
    //   288: aload_3
    //   289: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   292: return
    //   293: aload_2
    //   294: astore_1
    //   295: aload 6
    //   297: aload 7
    //   299: invokevirtual 261	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   302: astore 6
    //   304: aload_2
    //   305: astore_1
    //   306: aload 6
    //   308: ldc_w 263
    //   311: invokestatic 197	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   314: aload_2
    //   315: astore_1
    //   316: aload 5
    //   318: aload 6
    //   320: invokevirtual 267	java/util/zip/GZIPOutputStream:write	([B)V
    //   323: aload_2
    //   324: astore_1
    //   325: aload 5
    //   327: invokevirtual 270	java/util/zip/GZIPOutputStream:finish	()V
    //   330: aload_2
    //   331: astore_1
    //   332: getstatic 275	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   335: astore 5
    //   337: aload 4
    //   339: aload_2
    //   340: invokestatic 220	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   343: getstatic 280	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   346: new 282	java/io/BufferedInputStream
    //   349: dup
    //   350: aload_3
    //   351: invokevirtual 286	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   354: invokespecial 289	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   357: checkcast 291	java/io/InputStream
    //   360: sipush 8192
    //   363: invokevirtual 297	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   366: astore_1
    //   367: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   370: iconst_2
    //   371: anewarray 257	java/lang/String
    //   374: dup
    //   375: iconst_0
    //   376: ldc 43
    //   378: aastore
    //   379: dup
    //   380: iconst_1
    //   381: aload_1
    //   382: aastore
    //   383: invokevirtual 301	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   386: aload_0
    //   387: aload_1
    //   388: invokevirtual 305	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   391: ifeq +37 -> 428
    //   394: aload_0
    //   395: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   398: astore_1
    //   399: aload_1
    //   400: ifnull +19 -> 419
    //   403: aload_1
    //   404: sipush 200
    //   407: aload_0
    //   408: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   411: invokevirtual 308	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   414: invokeinterface 312 3 0
    //   419: aload_3
    //   420: ifnull -383 -> 37
    //   423: aload_3
    //   424: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   427: return
    //   428: aload_0
    //   429: invokevirtual 78	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:getRetry	()I
    //   432: ifle +88 -> 520
    //   435: aload_0
    //   436: invokestatic 318	java/lang/Math:random	()D
    //   439: iconst_5
    //   440: i2d
    //   441: dmul
    //   442: iconst_2
    //   443: i2d
    //   444: dadd
    //   445: d2l
    //   446: sipush 1000
    //   449: i2l
    //   450: lmul
    //   451: invokespecial 320	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:reSend	(J)V
    //   454: goto -35 -> 419
    //   457: astore_1
    //   458: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   461: ldc 43
    //   463: new 235	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   470: aload_1
    //   471: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: ldc 242
    //   476: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_0
    //   480: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   483: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   486: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   489: ldc 247
    //   491: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: aload_1
    //   498: checkcast 96	java/lang/Throwable
    //   501: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   504: aload_0
    //   505: ldc2_w 321
    //   508: invokespecial 320	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:reSend	(J)V
    //   511: aload_3
    //   512: ifnull -475 -> 37
    //   515: aload_3
    //   516: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   519: return
    //   520: aload_0
    //   521: aload_0
    //   522: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   525: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   528: ldc_w 324
    //   531: invokevirtual 328	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   534: aload_3
    //   535: invokevirtual 331	java/net/HttpURLConnection:getResponseCode	()I
    //   538: aload_1
    //   539: aload_0
    //   540: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   543: invokevirtual 334	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   546: invokevirtual 338	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   549: aload_0
    //   550: getfield 70	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   553: astore_2
    //   554: aload_2
    //   555: ifnull -136 -> 419
    //   558: aload_2
    //   559: sipush 700
    //   562: aload_1
    //   563: aload_0
    //   564: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   567: invokevirtual 308	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   570: invokeinterface 228 4 0
    //   575: goto -156 -> 419
    //   578: astore_1
    //   579: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   582: ldc 43
    //   584: new 235	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   591: aload_1
    //   592: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   595: ldc 242
    //   597: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_0
    //   601: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   604: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   607: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   610: ldc 247
    //   612: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: aload_1
    //   619: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   622: aload_0
    //   623: iconst_0
    //   624: invokevirtual 82	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:setRetry	(I)V
    //   627: aload_3
    //   628: ifnull -591 -> 37
    //   631: aload_3
    //   632: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   635: return
    //   636: astore_1
    //   637: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   640: ldc 43
    //   642: new 235	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   649: aload_1
    //   650: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   653: ldc 242
    //   655: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_0
    //   659: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   662: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   665: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   668: ldc 247
    //   670: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: aload_1
    //   677: checkcast 96	java/lang/Throwable
    //   680: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   683: goto -399 -> 284
    //   686: astore_1
    //   687: aload_3
    //   688: ifnull +7 -> 695
    //   691: aload_3
    //   692: invokevirtual 255	java/net/HttpURLConnection:disconnect	()V
    //   695: aload_1
    //   696: athrow
    //   697: astore_1
    //   698: getstatic 233	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   701: ldc 43
    //   703: new 235	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 236	java/lang/StringBuilder:<init>	()V
    //   710: aload_1
    //   711: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   714: ldc 242
    //   716: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_0
    //   720: getfield 68	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   723: invokevirtual 186	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   726: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   729: ldc 247
    //   731: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: aload_1
    //   738: checkcast 96	java/lang/Throwable
    //   741: invokevirtual 252	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   744: goto -460 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	this	JsonUploadRunnable
    //   45	161	1	localObject1	Object
    //   211	67	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   294	110	1	localObject2	Object
    //   457	106	1	localException1	java.lang.Exception
    //   578	41	1	localThrowable1	java.lang.Throwable
    //   636	41	1	localException2	java.lang.Exception
    //   686	10	1	localObject3	Object
    //   697	41	1	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   129	57	2	localThrowable2	java.lang.Throwable
    //   197	4	2	localThrowable3	java.lang.Throwable
    //   202	8	2	localObject4	Object
    //   221	338	2	localReportResultCallback	IReporter.ReportResultCallback
    //   94	598	3	localHttpURLConnection	java.net.HttpURLConnection
    //   123	215	4	localCloseable	java.io.Closeable
    //   137	199	5	localObject5	Object
    //   151	168	6	localObject6	Object
    //   169	129	7	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   132	139	197	java/lang/Throwable
    //   141	153	197	java/lang/Throwable
    //   155	162	197	java/lang/Throwable
    //   164	171	197	java/lang/Throwable
    //   173	180	197	java/lang/Throwable
    //   187	197	197	java/lang/Throwable
    //   295	304	197	java/lang/Throwable
    //   306	314	197	java/lang/Throwable
    //   316	323	197	java/lang/Throwable
    //   325	330	197	java/lang/Throwable
    //   332	337	197	java/lang/Throwable
    //   132	139	202	finally
    //   141	153	202	finally
    //   155	162	202	finally
    //   164	171	202	finally
    //   173	180	202	finally
    //   187	197	202	finally
    //   200	202	202	finally
    //   295	304	202	finally
    //   306	314	202	finally
    //   316	323	202	finally
    //   325	330	202	finally
    //   332	337	202	finally
    //   99	130	211	java/lang/OutOfMemoryError
    //   203	211	211	java/lang/OutOfMemoryError
    //   337	399	211	java/lang/OutOfMemoryError
    //   403	419	211	java/lang/OutOfMemoryError
    //   428	454	211	java/lang/OutOfMemoryError
    //   520	554	211	java/lang/OutOfMemoryError
    //   558	575	211	java/lang/OutOfMemoryError
    //   99	130	457	java/lang/Exception
    //   203	211	457	java/lang/Exception
    //   337	399	457	java/lang/Exception
    //   403	419	457	java/lang/Exception
    //   428	454	457	java/lang/Exception
    //   520	554	457	java/lang/Exception
    //   558	575	457	java/lang/Exception
    //   99	130	578	java/lang/Throwable
    //   203	211	578	java/lang/Throwable
    //   337	399	578	java/lang/Throwable
    //   403	419	578	java/lang/Throwable
    //   428	454	578	java/lang/Throwable
    //   520	554	578	java/lang/Throwable
    //   558	575	578	java/lang/Throwable
    //   217	222	636	java/lang/Exception
    //   226	238	636	java/lang/Exception
    //   238	284	636	java/lang/Exception
    //   99	130	686	finally
    //   203	211	686	finally
    //   212	217	686	finally
    //   217	222	686	finally
    //   226	238	686	finally
    //   238	284	686	finally
    //   337	399	686	finally
    //   403	419	686	finally
    //   428	454	686	finally
    //   458	511	686	finally
    //   520	554	686	finally
    //   558	575	686	finally
    //   579	627	686	finally
    //   637	683	686	finally
    //   698	744	686	finally
    //   217	222	697	java/lang/OutOfMemoryError
    //   226	238	697	java/lang/OutOfMemoryError
    //   238	284	697	java/lang/OutOfMemoryError
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/JsonUploadRunnable$Companion;", "", "()V", "TAG", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.JsonUploadRunnable
 * JD-Core Version:    0.7.0.1
 */