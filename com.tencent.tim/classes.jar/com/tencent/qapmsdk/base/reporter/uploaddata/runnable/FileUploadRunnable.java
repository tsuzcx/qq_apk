package com.tencent.qapmsdk.base.reporter.uploaddata.runnable;

import android.os.Handler;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.common.util.FileUtil.Companion;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "Ljava/lang/Runnable;", "url", "Ljava/net/URL;", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "handler", "Landroid/os/Handler;", "originalPath", "", "(Ljava/net/URL;Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;Landroid/os/Handler;Ljava/lang/String;)V", "buffer", "Ljava/lang/StringBuffer;", "getBuffer", "()Ljava/lang/StringBuffer;", "generateAfterStream", "generateBeforeStream", "disposition", "generateDisposition", "fileName", "generateReqBackup", "getUploadFilePath", "reSend", "", "request", "run", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class FileUploadRunnable
  extends QAPMUpload
  implements Runnable
{
  private static final String BOUNDARY = "27182818284590452353602874713526";
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "QAPM_base_FileUploadRunnable";
  @NotNull
  private final StringBuffer buffer;
  private final IReporter.ReportResultCallback callback;
  private final Handler handler;
  private final String originalPath;
  private final ResultObject resultObject;
  
  public FileUploadRunnable(@NotNull URL paramURL, @NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback, @NotNull Handler paramHandler, @NotNull String paramString)
  {
    super(paramURL);
    this.resultObject = paramResultObject;
    this.callback = paramReportResultCallback;
    this.handler = paramHandler;
    this.originalPath = paramString;
    this.buffer = new StringBuffer(512);
  }
  
  private final String generateAfterStream()
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("\r\n--").append("27182818284590452353602874713526").append("\r\n");
    String str = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "buffer.toString()");
    return str;
  }
  
  private final String generateBeforeStream(String paramString)
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("--").append("27182818284590452353602874713526").append("\r\n").append(paramString).append("\r\n\r\n");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateDisposition(String paramString)
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"").append(paramString).append("\"");
    paramString = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "buffer.toString()");
    return paramString;
  }
  
  private final String generateReqBackup()
  {
    this.buffer.delete(0, this.buffer.length());
    this.buffer.append("Content-Disposition: form-data; name=\"_json\"\r\n\r\n").append(this.resultObject.getParams().toString()).append("\r\n--").append("27182818284590452353602874713526").append("--\r\n");
    String str = this.buffer.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "buffer.toString()");
    return str;
  }
  
  private final String getUploadFilePath()
  {
    int i;
    Object localObject;
    if (((CharSequence)this.originalPath).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label31;
      }
      localObject = "";
    }
    label31:
    String str1;
    FileUtil.Companion localCompanion;
    String str2;
    do
    {
      return localObject;
      i = 0;
      break;
      localObject = new File(this.originalPath);
      if ((((File)localObject).isFile()) && (((File)localObject).canRead())) {
        return this.originalPath;
      }
      if ((!((File)localObject).isDirectory()) || (!((File)localObject).canRead())) {
        break label150;
      }
      str1 = new File(((File)localObject).getParent(), "out_" + System.currentTimeMillis() + ".zip").getAbsolutePath();
      localCompanion = FileUtil.Companion;
      str2 = this.originalPath;
      Intrinsics.checkExpressionValueIsNotNull(str1, "zipFilePath");
      localObject = str1;
    } while (localCompanion.zipFiles(str2, str1));
    return "";
    label150:
    return "";
  }
  
  private final void reSend()
  {
    if (getRetry() > 0)
    {
      setRetry(getRetry() - 1);
      this.handler.postDelayed((Runnable)this, 1800000L);
    }
  }
  
  @NotNull
  public final StringBuffer getBuffer()
  {
    return this.buffer;
  }
  
  public void request()
  {
    run();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: getstatic 236	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   3: checkcast 146	java/lang/CharSequence
    //   6: invokestatic 242	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +23 -> 32
    //   12: getstatic 248	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;
    //   15: invokevirtual 252	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:getAuthorization	()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;
    //   18: getstatic 256	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   21: getfield 261	com/tencent/qapmsdk/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   24: iconst_1
    //   25: invokevirtual 267	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getToken	(Ljava/lang/String;Z)Z
    //   28: ifne +4 -> 32
    //   31: return
    //   32: aload_0
    //   33: invokespecial 269	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getUploadFilePath	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: checkcast 146	java/lang/CharSequence
    //   41: invokeinterface 147 1 0
    //   46: ifne +38 -> 84
    //   49: iconst_1
    //   50: istore_1
    //   51: iload_1
    //   52: ifeq +37 -> 89
    //   55: aload_0
    //   56: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   59: astore_2
    //   60: aload_2
    //   61: ifnull -30 -> 31
    //   64: aload_2
    //   65: sipush 601
    //   68: ldc_w 271
    //   71: aload_0
    //   72: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   75: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   78: invokeinterface 280 4 0
    //   83: return
    //   84: iconst_0
    //   85: istore_1
    //   86: goto -35 -> 51
    //   89: new 150	java/io/File
    //   92: dup
    //   93: aload_2
    //   94: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 7
    //   99: new 282	java/util/HashMap
    //   102: dup
    //   103: invokespecial 283	java/util/HashMap:<init>	()V
    //   106: astore_2
    //   107: aload_2
    //   108: checkcast 285	java/util/Map
    //   111: ldc_w 287
    //   114: ldc_w 289
    //   117: invokeinterface 293 3 0
    //   122: pop
    //   123: aload_2
    //   124: checkcast 285	java/util/Map
    //   127: ldc_w 295
    //   130: getstatic 236	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   133: invokeinterface 293 3 0
    //   138: pop
    //   139: aload_0
    //   140: aload_2
    //   141: invokevirtual 299	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   144: astore 6
    //   146: aload 6
    //   148: ifnull +283 -> 431
    //   151: new 301	java/io/DataOutputStream
    //   154: dup
    //   155: aload 6
    //   157: invokevirtual 307	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   160: invokespecial 310	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: checkcast 312	java/io/Closeable
    //   166: astore 8
    //   168: aconst_null
    //   169: checkcast 231	java/lang/Throwable
    //   172: astore 5
    //   174: aload 5
    //   176: astore_2
    //   177: aload 8
    //   179: checkcast 301	java/io/DataOutputStream
    //   182: astore_3
    //   183: aload 5
    //   185: astore_2
    //   186: aload 7
    //   188: invokevirtual 315	java/io/File:getName	()Ljava/lang/String;
    //   191: astore 4
    //   193: aload 5
    //   195: astore_2
    //   196: aload 4
    //   198: ldc_w 317
    //   201: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   204: aload 5
    //   206: astore_2
    //   207: aload_3
    //   208: aload_0
    //   209: aload_0
    //   210: aload 4
    //   212: invokespecial 319	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateDisposition	(Ljava/lang/String;)Ljava/lang/String;
    //   215: invokespecial 321	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateBeforeStream	(Ljava/lang/String;)Ljava/lang/String;
    //   218: invokevirtual 324	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   221: aload 5
    //   223: astore_2
    //   224: new 326	java/io/FileInputStream
    //   227: dup
    //   228: aload 7
    //   230: invokespecial 329	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   233: checkcast 312	java/io/Closeable
    //   236: astore 9
    //   238: aload 5
    //   240: astore_2
    //   241: aconst_null
    //   242: checkcast 231	java/lang/Throwable
    //   245: astore 4
    //   247: aload 9
    //   249: checkcast 326	java/io/FileInputStream
    //   252: astore_2
    //   253: aload_2
    //   254: checkcast 331	java/io/InputStream
    //   257: aload_3
    //   258: checkcast 333	java/io/OutputStream
    //   261: aload_2
    //   262: invokevirtual 336	java/io/FileInputStream:available	()I
    //   265: ldc_w 337
    //   268: invokestatic 343	java/lang/Math:min	(II)I
    //   271: invokestatic 349	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   274: pop2
    //   275: aload 5
    //   277: astore_2
    //   278: aload 9
    //   280: aload 4
    //   282: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   285: aload 5
    //   287: astore_2
    //   288: aload_3
    //   289: aload_0
    //   290: invokespecial 357	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateAfterStream	()Ljava/lang/String;
    //   293: invokevirtual 324	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   296: aload 5
    //   298: astore_2
    //   299: aload_3
    //   300: aload_0
    //   301: invokespecial 359	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:generateReqBackup	()Ljava/lang/String;
    //   304: invokevirtual 324	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   307: aload 5
    //   309: astore_2
    //   310: getstatic 364	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   313: astore_3
    //   314: aload 8
    //   316: aload 5
    //   318: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   321: new 366	java/io/BufferedInputStream
    //   324: dup
    //   325: aload 6
    //   327: invokevirtual 370	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   330: invokespecial 373	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   333: checkcast 312	java/io/Closeable
    //   336: astore 4
    //   338: aconst_null
    //   339: checkcast 231	java/lang/Throwable
    //   342: astore_3
    //   343: aload_3
    //   344: astore_2
    //   345: aload 4
    //   347: checkcast 366	java/io/BufferedInputStream
    //   350: astore 5
    //   352: aload_3
    //   353: astore_2
    //   354: getstatic 198	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   357: aload 5
    //   359: checkcast 331	java/io/InputStream
    //   362: sipush 8192
    //   365: invokevirtual 377	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   368: astore 5
    //   370: aload_3
    //   371: astore_2
    //   372: getstatic 364	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   375: astore 8
    //   377: aload 4
    //   379: aload_3
    //   380: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   383: aload_0
    //   384: aload 5
    //   386: invokevirtual 381	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   389: ifeq +250 -> 639
    //   392: aload_0
    //   393: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   396: astore_2
    //   397: aload_2
    //   398: ifnull +19 -> 417
    //   401: aload_2
    //   402: sipush 200
    //   405: aload_0
    //   406: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   409: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   412: invokeinterface 385 3 0
    //   417: aload 7
    //   419: invokevirtual 157	java/io/File:isFile	()Z
    //   422: ifeq +214 -> 636
    //   425: aload 7
    //   427: invokevirtual 387	java/io/File:delete	()Z
    //   430: pop
    //   431: aload 6
    //   433: ifnull -402 -> 31
    //   436: aload 6
    //   438: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   441: return
    //   442: astore 4
    //   444: aload 4
    //   446: athrow
    //   447: astore_3
    //   448: aload 5
    //   450: astore_2
    //   451: aload 9
    //   453: aload 4
    //   455: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   458: aload 5
    //   460: astore_2
    //   461: aload_3
    //   462: athrow
    //   463: astore_3
    //   464: aload_3
    //   465: astore_2
    //   466: aload_3
    //   467: athrow
    //   468: astore_3
    //   469: aload 8
    //   471: aload_2
    //   472: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   475: aload_3
    //   476: athrow
    //   477: astore_2
    //   478: aload_0
    //   479: iconst_0
    //   480: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   483: aload_0
    //   484: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   487: astore_2
    //   488: aload_2
    //   489: ifnull +16 -> 505
    //   492: aload_2
    //   493: sipush 600
    //   496: ldc_w 392
    //   499: iconst_0
    //   500: invokeinterface 280 4 0
    //   505: aload 6
    //   507: ifnull -476 -> 31
    //   510: aload 6
    //   512: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   515: return
    //   516: astore_3
    //   517: aload_3
    //   518: astore_2
    //   519: aload_3
    //   520: athrow
    //   521: astore_3
    //   522: aload 4
    //   524: aload_2
    //   525: invokestatic 355	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   528: aload_3
    //   529: athrow
    //   530: astore_2
    //   531: getstatic 397	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   534: iconst_2
    //   535: anewarray 399	java/lang/String
    //   538: dup
    //   539: iconst_0
    //   540: ldc 57
    //   542: aastore
    //   543: dup
    //   544: iconst_1
    //   545: new 168	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   552: aload_2
    //   553: invokevirtual 402	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: ldc_w 404
    //   559: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 7
    //   564: invokevirtual 407	java/io/File:getPath	()Ljava/lang/String;
    //   567: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 409
    //   573: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: aastore
    //   580: invokevirtual 413	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   583: aload 7
    //   585: invokevirtual 157	java/io/File:isFile	()Z
    //   588: ifeq +9 -> 597
    //   591: aload 7
    //   593: invokevirtual 387	java/io/File:delete	()Z
    //   596: pop
    //   597: aload_0
    //   598: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   601: astore_2
    //   602: aload_2
    //   603: ifnull +22 -> 625
    //   606: aload_2
    //   607: sipush 601
    //   610: ldc_w 415
    //   613: aload_0
    //   614: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   617: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   620: invokeinterface 280 4 0
    //   625: aload 6
    //   627: ifnull -596 -> 31
    //   630: aload 6
    //   632: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   635: return
    //   636: goto -205 -> 431
    //   639: aload_0
    //   640: invokevirtual 209	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:getRetry	()I
    //   643: ifle +34 -> 677
    //   646: aload_0
    //   647: invokespecial 417	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:reSend	()V
    //   650: goto -219 -> 431
    //   653: astore_2
    //   654: getstatic 397	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   657: ldc 57
    //   659: aload_2
    //   660: checkcast 231	java/lang/Throwable
    //   663: invokevirtual 421	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   666: aload 6
    //   668: ifnull -637 -> 31
    //   671: aload 6
    //   673: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   676: return
    //   677: aload_0
    //   678: aload_0
    //   679: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   682: invokevirtual 139	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getParams	()Lorg/json/JSONObject;
    //   685: ldc_w 423
    //   688: invokevirtual 427	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   691: aload 6
    //   693: invokevirtual 430	java/net/HttpURLConnection:getResponseCode	()I
    //   696: aload 5
    //   698: aload_0
    //   699: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   702: invokevirtual 433	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getEventName	()Ljava/lang/String;
    //   705: invokevirtual 437	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:addLost	(IILjava/lang/String;Ljava/lang/String;)V
    //   708: aload_0
    //   709: getfield 85	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:callback	Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;
    //   712: astore_2
    //   713: aload_2
    //   714: ifnull -283 -> 431
    //   717: aload_2
    //   718: sipush 700
    //   721: aload 5
    //   723: aload_0
    //   724: getfield 83	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:resultObject	Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   727: invokevirtual 274	com/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject:getDbId	()I
    //   730: invokeinterface 280 4 0
    //   735: goto -304 -> 431
    //   738: astore_2
    //   739: aload_0
    //   740: iconst_0
    //   741: invokevirtual 212	com/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable:setRetry	(I)V
    //   744: getstatic 397	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   747: ldc 57
    //   749: aload_2
    //   750: invokevirtual 421	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   753: aload 6
    //   755: ifnull -724 -> 31
    //   758: aload 6
    //   760: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   763: return
    //   764: astore_2
    //   765: aload 6
    //   767: ifnull +8 -> 775
    //   770: aload 6
    //   772: invokevirtual 390	java/net/HttpURLConnection:disconnect	()V
    //   775: aload_2
    //   776: athrow
    //   777: astore_3
    //   778: goto -330 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	FileUploadRunnable
    //   50	36	1	i	int
    //   36	436	2	localObject1	Object
    //   477	1	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   487	38	2	localObject2	Object
    //   530	23	2	localFileNotFoundException	java.io.FileNotFoundException
    //   601	6	2	localReportResultCallback1	IReporter.ReportResultCallback
    //   653	7	2	localException	java.lang.Exception
    //   712	6	2	localReportResultCallback2	IReporter.ReportResultCallback
    //   738	12	2	localThrowable1	java.lang.Throwable
    //   764	12	2	localObject3	Object
    //   182	198	3	localObject4	Object
    //   447	15	3	localObject5	Object
    //   463	4	3	localThrowable2	java.lang.Throwable
    //   468	8	3	localObject6	Object
    //   516	4	3	localThrowable3	java.lang.Throwable
    //   521	8	3	localObject7	Object
    //   777	1	3	localObject8	Object
    //   191	187	4	localObject9	Object
    //   442	81	4	localThrowable4	java.lang.Throwable
    //   172	550	5	localObject10	Object
    //   144	627	6	localHttpURLConnection	java.net.HttpURLConnection
    //   97	495	7	localFile	File
    //   166	304	8	localObject11	Object
    //   236	216	9	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   247	275	442	java/lang/Throwable
    //   444	447	447	finally
    //   177	183	463	java/lang/Throwable
    //   186	193	463	java/lang/Throwable
    //   196	204	463	java/lang/Throwable
    //   207	221	463	java/lang/Throwable
    //   224	238	463	java/lang/Throwable
    //   241	247	463	java/lang/Throwable
    //   278	285	463	java/lang/Throwable
    //   288	296	463	java/lang/Throwable
    //   299	307	463	java/lang/Throwable
    //   310	314	463	java/lang/Throwable
    //   451	458	463	java/lang/Throwable
    //   461	463	463	java/lang/Throwable
    //   177	183	468	finally
    //   186	193	468	finally
    //   196	204	468	finally
    //   207	221	468	finally
    //   224	238	468	finally
    //   241	247	468	finally
    //   278	285	468	finally
    //   288	296	468	finally
    //   299	307	468	finally
    //   310	314	468	finally
    //   451	458	468	finally
    //   461	463	468	finally
    //   466	468	468	finally
    //   151	174	477	java/lang/OutOfMemoryError
    //   314	343	477	java/lang/OutOfMemoryError
    //   377	397	477	java/lang/OutOfMemoryError
    //   401	417	477	java/lang/OutOfMemoryError
    //   417	431	477	java/lang/OutOfMemoryError
    //   469	477	477	java/lang/OutOfMemoryError
    //   522	530	477	java/lang/OutOfMemoryError
    //   639	650	477	java/lang/OutOfMemoryError
    //   677	713	477	java/lang/OutOfMemoryError
    //   717	735	477	java/lang/OutOfMemoryError
    //   345	352	516	java/lang/Throwable
    //   354	370	516	java/lang/Throwable
    //   372	377	516	java/lang/Throwable
    //   345	352	521	finally
    //   354	370	521	finally
    //   372	377	521	finally
    //   519	521	521	finally
    //   151	174	530	java/io/FileNotFoundException
    //   314	343	530	java/io/FileNotFoundException
    //   377	397	530	java/io/FileNotFoundException
    //   401	417	530	java/io/FileNotFoundException
    //   417	431	530	java/io/FileNotFoundException
    //   469	477	530	java/io/FileNotFoundException
    //   522	530	530	java/io/FileNotFoundException
    //   639	650	530	java/io/FileNotFoundException
    //   677	713	530	java/io/FileNotFoundException
    //   717	735	530	java/io/FileNotFoundException
    //   151	174	653	java/lang/Exception
    //   314	343	653	java/lang/Exception
    //   377	397	653	java/lang/Exception
    //   401	417	653	java/lang/Exception
    //   417	431	653	java/lang/Exception
    //   469	477	653	java/lang/Exception
    //   522	530	653	java/lang/Exception
    //   639	650	653	java/lang/Exception
    //   677	713	653	java/lang/Exception
    //   717	735	653	java/lang/Exception
    //   151	174	738	java/lang/Throwable
    //   314	343	738	java/lang/Throwable
    //   377	397	738	java/lang/Throwable
    //   401	417	738	java/lang/Throwable
    //   417	431	738	java/lang/Throwable
    //   469	477	738	java/lang/Throwable
    //   522	530	738	java/lang/Throwable
    //   639	650	738	java/lang/Throwable
    //   677	713	738	java/lang/Throwable
    //   717	735	738	java/lang/Throwable
    //   151	174	764	finally
    //   314	343	764	finally
    //   377	397	764	finally
    //   401	417	764	finally
    //   417	431	764	finally
    //   469	477	764	finally
    //   478	488	764	finally
    //   492	505	764	finally
    //   522	530	764	finally
    //   531	597	764	finally
    //   597	602	764	finally
    //   606	625	764	finally
    //   639	650	764	finally
    //   654	666	764	finally
    //   677	713	764	finally
    //   717	735	764	finally
    //   739	753	764	finally
    //   247	275	777	finally
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/uploaddata/runnable/FileUploadRunnable$Companion;", "", "()V", "BOUNDARY", "", "TAG", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.uploaddata.runnable.FileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */