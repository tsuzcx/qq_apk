package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class FileJsPlugin$2$1
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$2$1(FileJsPlugin.2 param2) {}
  
  private void reportDownloadFileResult(long paramLong, int paramInt)
  {
    if (FileJsPlugin.access$500(this.this$1.this$0)) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(FileJsPlugin.access$600(this.this$1.this$0), 640, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.d("FileJsPlugin", "download failed! [minigame timecost:" + (System.currentTimeMillis() - this.this$1.val$startMS) + "ms]");
    try
    {
      FileJsPlugin.access$000(this.this$1.this$0).remove(this.this$1.val$downloadId);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.this$1.val$downloadId);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed." + paramString);
      this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      reportDownloadFileResult(System.currentTimeMillis() - this.this$1.val$startMS, paramInt);
      MiniProgramLpReportDC05115.reportDownloadResult(FileJsPlugin.access$100(this.this$1.this$0), 0, System.currentTimeMillis() - this.this$1.val$startMS, true);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(FileJsPlugin.access$200(this.this$1.this$0), this.this$1.val$downloadUrl, System.currentTimeMillis() - this.this$1.val$startMS, paramInt, 0);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QMLog.e("FileJsPlugin", "download onDownloadFailed failed." + paramString);
      }
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    new JSONObject();
    try
    {
      paramMap = JSONUtil.headerToJson(paramMap);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.this$1.val$downloadId);
      localJSONObject.put("statusCode", 200);
      localJSONObject.put("header", paramMap);
      localJSONObject.put("state", "headersReceived");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      QMLog.e("FileJsPlugin", "onDownloadSucceed headerJson error." + paramMap);
    }
  }
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.this$1.val$downloadId);
      localJSONObject.put("progress", (int)(100.0F * paramFloat));
      localJSONObject.put("totalBytesWritten", paramLong1);
      localJSONObject.put("totalBytesExpectedToWrite", paramLong2);
      localJSONObject.put("state", "progressUpdate");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("FileJsPlugin", "download onDownloadProgress failed." + localThrowable);
    }
  }
  
  /* Error */
  public void onDownloadSucceed(int paramInt, String paramString, com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    // Byte code:
    //   0: ldc 50
    //   2: new 52	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   9: ldc 210
    //   11: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_0
    //   15: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   18: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   21: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 212
    //   26: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   32: aload_0
    //   33: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   36: getfield 69	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$startMS	J
    //   39: lsub
    //   40: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: ldc 214
    //   45: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   52: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 84	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   68: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   71: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne +708 -> 782
    //   77: new 225	java/io/File
    //   80: dup
    //   81: aload_0
    //   82: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   85: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   88: invokespecial 228	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 5
    //   93: aload 5
    //   95: invokevirtual 232	java/io/File:exists	()Z
    //   98: ifne +1225 -> 1323
    //   101: aload_2
    //   102: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: istore 4
    //   107: iload 4
    //   109: ifne +1214 -> 1323
    //   112: new 225	java/io/File
    //   115: dup
    //   116: aload_2
    //   117: invokespecial 228	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: astore 7
    //   122: aload 5
    //   124: astore 6
    //   126: aload 7
    //   128: invokevirtual 232	java/io/File:exists	()Z
    //   131: ifeq +164 -> 295
    //   134: aload 5
    //   136: astore 6
    //   138: aload 7
    //   140: invokevirtual 235	java/io/File:isFile	()Z
    //   143: ifeq +152 -> 295
    //   146: aload 5
    //   148: astore 6
    //   150: aload 7
    //   152: invokevirtual 238	java/io/File:length	()J
    //   155: lconst_0
    //   156: lcmp
    //   157: ifle +138 -> 295
    //   160: ldc 50
    //   162: new 52	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   169: ldc 240
    //   171: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_2
    //   175: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 242
    //   180: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 7
    //   185: invokevirtual 238	java/io/File:length	()J
    //   188: invokevirtual 72	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   191: ldc 244
    //   193: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_0
    //   197: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   200: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   203: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 247	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: aload_0
    //   213: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   216: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   219: invokestatic 253	com/tencent/qqmini/sdk/core/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   222: astore 6
    //   224: aload 6
    //   226: astore 5
    //   228: aload 7
    //   230: aload 5
    //   232: invokestatic 257	com/tencent/qqmini/sdk/core/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   235: ifeq +624 -> 859
    //   238: aload 5
    //   240: invokevirtual 232	java/io/File:exists	()Z
    //   243: ifeq +616 -> 859
    //   246: aload 5
    //   248: invokevirtual 238	java/io/File:length	()J
    //   251: aload 7
    //   253: invokevirtual 238	java/io/File:length	()J
    //   256: lcmp
    //   257: ifne +602 -> 859
    //   260: ldc 50
    //   262: new 52	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 259
    //   272: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_2
    //   276: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc_w 261
    //   282: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 264	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload 5
    //   293: astore 6
    //   295: aload 6
    //   297: astore 5
    //   299: aload 5
    //   301: invokevirtual 232	java/io/File:exists	()Z
    //   304: ifeq +884 -> 1188
    //   307: aload 5
    //   309: invokevirtual 267	java/io/File:canRead	()Z
    //   312: ifeq +876 -> 1188
    //   315: aload_0
    //   316: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   319: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   322: astore 6
    //   324: aload 6
    //   326: invokestatic 273	android/webkit/MimeTypeMap:getFileExtensionFromUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   329: astore 7
    //   331: aload 7
    //   333: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifeq +975 -> 1311
    //   339: aload_3
    //   340: getfield 279	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult:headers	Ljava/util/Map;
    //   343: ldc_w 281
    //   346: invokeinterface 286 2 0
    //   351: checkcast 288	java/util/List
    //   354: astore_2
    //   355: aload_2
    //   356: ifnull +560 -> 916
    //   359: aload_2
    //   360: invokeinterface 292 1 0
    //   365: ifle +551 -> 916
    //   368: aload_2
    //   369: iconst_0
    //   370: invokeinterface 295 2 0
    //   375: checkcast 297	java/lang/String
    //   378: astore_2
    //   379: aload_2
    //   380: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   383: ifne +928 -> 1311
    //   386: aload_2
    //   387: invokevirtual 300	java/lang/String:trim	()Ljava/lang/String;
    //   390: ldc_w 302
    //   393: invokevirtual 306	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   396: astore_2
    //   397: aload_2
    //   398: arraylength
    //   399: iconst_1
    //   400: if_icmple +911 -> 1311
    //   403: ldc_w 308
    //   406: aload_2
    //   407: iconst_0
    //   408: aaload
    //   409: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   412: ifeq +899 -> 1311
    //   415: aload_2
    //   416: iconst_1
    //   417: aaload
    //   418: astore_2
    //   419: ldc_w 314
    //   422: aload_2
    //   423: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   426: ifeq +497 -> 923
    //   429: ldc_w 316
    //   432: astore_2
    //   433: aload_2
    //   434: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   437: ifne +874 -> 1311
    //   440: new 52	java/lang/StringBuilder
    //   443: dup
    //   444: aload 6
    //   446: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: ldc_w 319
    //   452: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_2
    //   456: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: astore_2
    //   463: aload_0
    //   464: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   467: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   470: aload_2
    //   471: invokestatic 322	com/tencent/qqmini/sdk/core/utils/FileUtils:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   474: ifeq +837 -> 1311
    //   477: aload_0
    //   478: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   481: getfield 217	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$filePath	Ljava/lang/String;
    //   484: invokestatic 325	com/tencent/qqmini/sdk/core/utils/FileUtils:deleteFile	(Ljava/lang/String;)Z
    //   487: pop
    //   488: aload_0
    //   489: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   492: getfield 329	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$miniAppFileManager	Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;
    //   495: aload_0
    //   496: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   499: getfield 333	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$fileType	I
    //   502: aload 5
    //   504: invokevirtual 238	java/io/File:length	()J
    //   507: invokevirtual 339	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:updateFolderSize	(IJ)V
    //   510: new 100	org/json/JSONObject
    //   513: dup
    //   514: invokespecial 101	org/json/JSONObject:<init>	()V
    //   517: astore 6
    //   519: aload 6
    //   521: ldc 103
    //   523: aload_0
    //   524: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   527: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   530: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   533: pop
    //   534: aload 6
    //   536: ldc 192
    //   538: bipush 100
    //   540: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   543: pop
    //   544: aload 6
    //   546: ldc 195
    //   548: aload 5
    //   550: invokevirtual 238	java/io/File:length	()J
    //   553: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload 6
    //   559: ldc 200
    //   561: aload 5
    //   563: invokevirtual 238	java/io/File:length	()J
    //   566: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   569: pop
    //   570: aload 6
    //   572: ldc 109
    //   574: ldc 202
    //   576: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   579: pop
    //   580: aload_0
    //   581: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   584: getfield 119	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   587: getfield 125	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   590: ldc 127
    //   592: aload 6
    //   594: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   597: iconst_0
    //   598: invokeinterface 134 4 0
    //   603: ldc 50
    //   605: ldc_w 341
    //   608: invokestatic 84	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   611: new 100	org/json/JSONObject
    //   614: dup
    //   615: invokespecial 101	org/json/JSONObject:<init>	()V
    //   618: astore 5
    //   620: aload_3
    //   621: getfield 279	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener$DownloadResult:headers	Ljava/util/Map;
    //   624: invokestatic 173	com/tencent/qqmini/sdk/core/utils/JSONUtil:headerToJson	(Ljava/util/Map;)Lorg/json/JSONObject;
    //   627: astore_3
    //   628: aload_0
    //   629: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   632: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   635: invokestatic 88	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Ljava/util/concurrent/ConcurrentHashMap;
    //   638: aload_0
    //   639: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   642: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   645: invokevirtual 98	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   648: pop
    //   649: new 100	org/json/JSONObject
    //   652: dup
    //   653: invokespecial 101	org/json/JSONObject:<init>	()V
    //   656: astore 5
    //   658: aload 5
    //   660: ldc 175
    //   662: sipush 200
    //   665: invokevirtual 178	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   668: pop
    //   669: aload 5
    //   671: ldc 103
    //   673: aload_0
    //   674: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   677: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   680: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   683: pop
    //   684: aload_0
    //   685: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   688: getfield 345	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$reqParamObj	Lorg/json/JSONObject;
    //   691: ldc_w 347
    //   694: invokevirtual 350	org/json/JSONObject:isNull	(Ljava/lang/String;)Z
    //   697: ifne +22 -> 719
    //   700: aload_0
    //   701: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   704: getfield 345	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$reqParamObj	Lorg/json/JSONObject;
    //   707: ldc_w 347
    //   710: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   713: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   716: ifeq +338 -> 1054
    //   719: aload 5
    //   721: ldc_w 355
    //   724: aload_0
    //   725: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   728: getfield 329	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$miniAppFileManager	Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;
    //   731: aload_2
    //   732: invokevirtual 358	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   735: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   738: pop
    //   739: aload 5
    //   741: ldc 180
    //   743: aload_3
    //   744: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   747: pop
    //   748: aload 5
    //   750: ldc 109
    //   752: ldc_w 360
    //   755: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   758: pop
    //   759: aload_0
    //   760: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   763: getfield 119	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   766: getfield 125	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   769: ldc 127
    //   771: aload 5
    //   773: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   776: iconst_0
    //   777: invokeinterface 134 4 0
    //   782: aload_0
    //   783: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   786: aload_0
    //   787: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   790: getfield 69	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$startMS	J
    //   793: lsub
    //   794: iload_1
    //   795: invokespecial 136	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:reportDownloadFileResult	(JI)V
    //   798: aload_0
    //   799: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   802: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   805: invokestatic 363	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$300	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   808: iconst_0
    //   809: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   812: aload_0
    //   813: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   816: getfield 69	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$startMS	J
    //   819: lsub
    //   820: iconst_0
    //   821: invokestatic 145	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115:reportDownloadResult	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;IJZ)V
    //   824: aload_0
    //   825: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   828: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   831: invokestatic 366	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$400	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;
    //   834: aload_0
    //   835: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   838: getfield 151	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadUrl	Ljava/lang/String;
    //   841: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   844: aload_0
    //   845: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   848: getfield 69	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$startMS	J
    //   851: lsub
    //   852: iload_1
    //   853: i2l
    //   854: iconst_0
    //   855: invokestatic 157	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05116:reportOneHttpOrDownloadRequest	(Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;Ljava/lang/String;JJI)V
    //   858: return
    //   859: aload 5
    //   861: astore 6
    //   863: aload 5
    //   865: invokevirtual 232	java/io/File:exists	()Z
    //   868: ifeq -573 -> 295
    //   871: aload 5
    //   873: invokevirtual 369	java/io/File:delete	()Z
    //   876: pop
    //   877: aload 5
    //   879: astore 6
    //   881: goto -586 -> 295
    //   884: astore 6
    //   886: ldc 50
    //   888: new 52	java/lang/StringBuilder
    //   891: dup
    //   892: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   895: ldc_w 371
    //   898: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload_2
    //   902: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: aload 6
    //   910: invokestatic 374	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   913: goto -614 -> 299
    //   916: ldc_w 376
    //   919: astore_2
    //   920: goto -541 -> 379
    //   923: ldc_w 378
    //   926: aload_2
    //   927: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   930: ifeq +10 -> 940
    //   933: ldc_w 378
    //   936: astore_2
    //   937: goto -504 -> 433
    //   940: ldc_w 380
    //   943: aload_2
    //   944: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   947: ifeq +10 -> 957
    //   950: ldc_w 380
    //   953: astore_2
    //   954: goto -521 -> 433
    //   957: ldc_w 382
    //   960: aload_2
    //   961: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   964: ifeq +10 -> 974
    //   967: ldc_w 384
    //   970: astore_2
    //   971: goto -538 -> 433
    //   974: ldc_w 386
    //   977: aload_2
    //   978: invokevirtual 312	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   981: ifeq +336 -> 1317
    //   984: ldc_w 386
    //   987: astore_2
    //   988: goto -555 -> 433
    //   991: astore_2
    //   992: ldc 50
    //   994: new 52	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1001: ldc_w 388
    //   1004: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: aload_2
    //   1008: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1011: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1014: invokestatic 165	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1017: aload 6
    //   1019: astore_2
    //   1020: goto -532 -> 488
    //   1023: astore_3
    //   1024: ldc 50
    //   1026: new 52	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1033: ldc 184
    //   1035: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: aload_3
    //   1039: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokestatic 165	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1048: aload 5
    //   1050: astore_3
    //   1051: goto -423 -> 628
    //   1054: aload 5
    //   1056: ldc_w 347
    //   1059: aload_0
    //   1060: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1063: getfield 345	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$reqParamObj	Lorg/json/JSONObject;
    //   1066: ldc_w 347
    //   1069: invokevirtual 353	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1072: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1075: pop
    //   1076: goto -337 -> 739
    //   1079: astore_2
    //   1080: ldc 50
    //   1082: ldc_w 390
    //   1085: aload_2
    //   1086: invokestatic 374	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1089: new 100	org/json/JSONObject
    //   1092: dup
    //   1093: invokespecial 101	org/json/JSONObject:<init>	()V
    //   1096: astore_3
    //   1097: aload_0
    //   1098: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1101: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   1104: invokestatic 88	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1107: aload_0
    //   1108: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1111: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   1114: invokevirtual 98	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1117: pop
    //   1118: aload_3
    //   1119: ldc 103
    //   1121: aload_0
    //   1122: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1125: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   1128: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1131: pop
    //   1132: aload_3
    //   1133: ldc 109
    //   1135: ldc 111
    //   1137: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1140: pop
    //   1141: aload_3
    //   1142: ldc 113
    //   1144: ldc 115
    //   1146: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1149: pop
    //   1150: aload_0
    //   1151: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1154: getfield 119	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   1157: getfield 125	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   1160: ldc 127
    //   1162: aload_3
    //   1163: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1166: iconst_0
    //   1167: invokeinterface 134 4 0
    //   1172: goto -390 -> 782
    //   1175: astore_3
    //   1176: ldc 50
    //   1178: ldc_w 392
    //   1181: aload_2
    //   1182: invokestatic 374	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1185: goto -403 -> 782
    //   1188: ldc 50
    //   1190: new 52	java/lang/StringBuilder
    //   1193: dup
    //   1194: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   1197: ldc_w 394
    //   1200: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: aload_0
    //   1204: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1207: getfield 397	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$tmpFilePath	Ljava/lang/String;
    //   1210: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1216: invokestatic 84	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1219: aload_0
    //   1220: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1223: getfield 24	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;
    //   1226: invokestatic 88	com/tencent/qqmini/sdk/plugins/FileJsPlugin:access$000	(Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1229: aload_0
    //   1230: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1233: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   1236: invokevirtual 98	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1239: pop
    //   1240: new 100	org/json/JSONObject
    //   1243: dup
    //   1244: invokespecial 101	org/json/JSONObject:<init>	()V
    //   1247: astore_2
    //   1248: aload_2
    //   1249: ldc 103
    //   1251: aload_0
    //   1252: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1255: getfield 92	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$downloadId	Ljava/lang/String;
    //   1258: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1261: pop
    //   1262: aload_2
    //   1263: ldc 109
    //   1265: ldc 111
    //   1267: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1270: pop
    //   1271: aload_2
    //   1272: ldc 113
    //   1274: ldc_w 399
    //   1277: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1280: pop
    //   1281: aload_0
    //   1282: getfield 12	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2$1:this$1	Lcom/tencent/qqmini/sdk/plugins/FileJsPlugin$2;
    //   1285: getfield 119	com/tencent/qqmini/sdk/plugins/FileJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   1288: getfield 125	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   1291: ldc 127
    //   1293: aload_2
    //   1294: invokevirtual 128	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1297: iconst_0
    //   1298: invokeinterface 134 4 0
    //   1303: goto -521 -> 782
    //   1306: astore 6
    //   1308: goto -422 -> 886
    //   1311: aload 6
    //   1313: astore_2
    //   1314: goto -826 -> 488
    //   1317: aload 7
    //   1319: astore_2
    //   1320: goto -887 -> 433
    //   1323: goto -1024 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1326	0	this	1
    //   0	1326	1	paramInt	int
    //   0	1326	2	paramString	String
    //   0	1326	3	paramDownloadResult	com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult
    //   105	3	4	bool	boolean
    //   91	964	5	localObject1	Object
    //   124	756	6	localObject2	Object
    //   884	134	6	localThrowable1	Throwable
    //   1306	6	6	localThrowable2	Throwable
    //   120	1198	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   228	291	884	java/lang/Throwable
    //   863	877	884	java/lang/Throwable
    //   324	355	991	java/lang/Throwable
    //   359	379	991	java/lang/Throwable
    //   379	415	991	java/lang/Throwable
    //   419	429	991	java/lang/Throwable
    //   433	488	991	java/lang/Throwable
    //   923	933	991	java/lang/Throwable
    //   940	950	991	java/lang/Throwable
    //   957	967	991	java/lang/Throwable
    //   974	984	991	java/lang/Throwable
    //   620	628	1023	java/lang/Exception
    //   64	107	1079	java/lang/Exception
    //   112	122	1079	java/lang/Exception
    //   126	134	1079	java/lang/Exception
    //   138	146	1079	java/lang/Exception
    //   150	224	1079	java/lang/Exception
    //   228	291	1079	java/lang/Exception
    //   299	324	1079	java/lang/Exception
    //   324	355	1079	java/lang/Exception
    //   359	379	1079	java/lang/Exception
    //   379	415	1079	java/lang/Exception
    //   419	429	1079	java/lang/Exception
    //   433	488	1079	java/lang/Exception
    //   488	620	1079	java/lang/Exception
    //   628	719	1079	java/lang/Exception
    //   719	739	1079	java/lang/Exception
    //   739	782	1079	java/lang/Exception
    //   863	877	1079	java/lang/Exception
    //   886	913	1079	java/lang/Exception
    //   923	933	1079	java/lang/Exception
    //   940	950	1079	java/lang/Exception
    //   957	967	1079	java/lang/Exception
    //   974	984	1079	java/lang/Exception
    //   992	1017	1079	java/lang/Exception
    //   1024	1048	1079	java/lang/Exception
    //   1054	1076	1079	java/lang/Exception
    //   1188	1303	1079	java/lang/Exception
    //   1097	1172	1175	org/json/JSONException
    //   112	122	1306	java/lang/Throwable
    //   126	134	1306	java/lang/Throwable
    //   138	146	1306	java/lang/Throwable
    //   150	224	1306	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */