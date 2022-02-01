package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.widget.media.live.TXLivePusherJSAdapter;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class LivePusherEmbeddedWidgetClient
  implements IExtendedEmbeddedWidgetClient
{
  private static final String TAG = "miniapp-embedded-live-pusher";
  public static volatile boolean mIsInited = false;
  private IJsService callBackWebview;
  private IJsService curAppBrandRuntime;
  private int curPageWebviewId;
  private ConcurrentHashMap<String, String> downloadMap = new ConcurrentHashMap();
  private AtomicInteger downloadTaskId = new AtomicInteger(0);
  private Handler handler = new Handler(Looper.getMainLooper());
  private int height = -1;
  private TXLivePusherJSAdapter livePusherJSAdapter;
  private Map<String, String> mAttributes;
  private Surface mSurface = null;
  private String mTagName;
  private IEmbeddedWidget mWidget;
  private boolean needToStopDownloadBGM = false;
  private Runnable stopDumpRunnable = new LivePusherEmbeddedWidgetClient.1(this);
  private String tempAudioFilePath = null;
  private int viewId = -1;
  private int width = -1;
  
  public LivePusherEmbeddedWidgetClient(String paramString, Map<String, String> paramMap, IEmbeddedWidget paramIEmbeddedWidget)
  {
    this.mTagName = paramString;
    this.mAttributes = paramMap;
    this.mWidget = paramIEmbeddedWidget;
  }
  
  private void evaluateCallbackJs(int paramInt, String paramString)
  {
    if (this.callBackWebview != null) {
      this.callBackWebview.evaluateCallbackJs(paramInt, paramString);
    }
    if (this.curAppBrandRuntime != null) {
      this.curAppBrandRuntime.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  private void evaluateSubscribeJS(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    IJsService localIJsService;
    if (this.callBackWebview != null)
    {
      localIJsService = this.callBackWebview;
      if (paramString2 == null)
      {
        paramString1 = null;
        localIJsService.evaluateSubscribeJS("onXWebLivePusherError", paramString1, this.curPageWebviewId);
      }
    }
    else if (this.curAppBrandRuntime != null)
    {
      localIJsService = this.curAppBrandRuntime;
      if (paramString2 != null) {
        break label79;
      }
    }
    label79:
    for (paramString1 = localObject;; paramString1 = paramString2.toString())
    {
      localIJsService.evaluateSubscribeJS("onXWebLivePusherError", paramString1, this.curPageWebviewId);
      return;
      paramString1 = paramString2.toString();
      break;
    }
  }
  
  /* Error */
  private static void saveJpeg(android.graphics.Bitmap paramBitmap, java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 155	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 157	java/io/FileOutputStream
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 160	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 163	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   15: astore_1
    //   16: aload_0
    //   17: getstatic 169	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   20: bipush 100
    //   22: bipush 100
    //   24: invokestatic 175	java/lang/Math:min	(II)I
    //   27: aload_1
    //   28: invokevirtual 181	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_1
    //   33: invokevirtual 184	java/io/BufferedOutputStream:flush	()V
    //   36: aload_1
    //   37: ifnull +7 -> 44
    //   40: aload_1
    //   41: invokevirtual 187	java/io/BufferedOutputStream:close	()V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 187	java/io/BufferedOutputStream:close	()V
    //   56: aload_0
    //   57: athrow
    //   58: astore_0
    //   59: return
    //   60: astore_1
    //   61: goto -5 -> 56
    //   64: astore_0
    //   65: goto -17 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramBitmap	android.graphics.Bitmap
    //   0	68	1	paramFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   0	16	45	finally
    //   40	44	58	java/lang/Exception
    //   52	56	60	java/lang/Exception
    //   16	36	64	finally
  }
  
  public boolean enterBackground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "enterBackground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterBackground(false);
    }
    return true;
  }
  
  public boolean enterForeground()
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("miniapp-embedded-live-pusher", "enterForeground");
    }
    if (this.livePusherJSAdapter != null) {
      this.livePusherJSAdapter.enterForeground();
    }
    return true;
  }
  
  public void handleInsertXWebLivePusher(JSONObject paramJSONObject, IJsService paramIJsService1, IJsService paramIJsService2)
  {
    this.callBackWebview = paramIJsService1;
    this.curAppBrandRuntime = paramIJsService2;
    if ((paramIJsService1 instanceof BrandPageWebview)) {
      this.curPageWebviewId = ((BrandPageWebview)paramIJsService1).getWebViewId();
    }
    for (;;)
    {
      if (paramJSONObject != null)
      {
        QMLog.d("miniapp-embedded-live-pusher", "handleInsertXWebLivePusher : " + paramJSONObject.toString());
        this.viewId = paramJSONObject.optInt("viewId");
        if (paramJSONObject.has("position"))
        {
          paramIJsService1 = paramJSONObject.optJSONObject("position");
          this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * paramIJsService1.optInt("width", -1) + 0.5F));
          float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
          this.height = ((int)(paramIJsService1.optInt("height", -1) * f + 0.5F));
        }
        this.livePusherJSAdapter = new TXLivePusherJSAdapter(AppLoaderFactory.g().getContext());
        this.livePusherJSAdapter.setSurface(this.mSurface);
        this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
        this.livePusherJSAdapter.initEmbeddedLivePusher(paramJSONObject);
        this.livePusherJSAdapter.setBGMNotifyListener(new LivePusherEmbeddedWidgetClient.2(this));
        this.livePusherJSAdapter.setPushListener(new LivePusherEmbeddedWidgetClient.3(this));
      }
      return;
      QMLog.e("miniapp-embedded-live-pusher", "cant get webviewId from " + paramIJsService1);
    }
  }
  
  /* Error */
  public void handleOperateXWebLivePusher(com.tencent.qqmini.sdk.launcher.core.IMiniAppContext paramIMiniAppContext, JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: ldc 10
    //   2: new 219	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 310
    //   12: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_2
    //   16: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   19: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_2
    //   29: ldc 231
    //   31: iconst_m1
    //   32: invokevirtual 265	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   35: istore 4
    //   37: iload 4
    //   39: aload_0
    //   40: getfield 58	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:viewId	I
    //   43: if_icmpne +145 -> 188
    //   46: aload_2
    //   47: ldc_w 312
    //   50: invokevirtual 241	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   53: ifeq +135 -> 188
    //   56: aload_2
    //   57: ldc_w 312
    //   60: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 106	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:livePusherJSAdapter	Lcom/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter;
    //   68: ifnull +120 -> 188
    //   71: ldc_w 318
    //   74: aload_1
    //   75: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +111 -> 189
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 94	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:needToStopDownloadBGM	Z
    //   86: aload_0
    //   87: getfield 87	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:downloadTaskId	Ljava/util/concurrent/atomic/AtomicInteger;
    //   90: invokevirtual 325	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   93: invokestatic 329	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: astore 9
    //   98: aload_2
    //   99: ldc_w 331
    //   102: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 10
    //   107: aload_0
    //   108: getfield 92	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:downloadMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   111: aload 9
    //   113: aload 10
    //   115: invokevirtual 335	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   118: pop
    //   119: invokestatic 341	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getInstance	()Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;
    //   122: aload 10
    //   124: invokevirtual 344	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPathByUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 11
    //   129: ldc_w 346
    //   132: invokestatic 352	com/tencent/qqmini/sdk/core/proxy/ProxyManager:get	(Ljava/lang/Class;)Ljava/lang/Object;
    //   135: checkcast 346	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy
    //   138: astore 12
    //   140: aload 12
    //   142: aload 10
    //   144: aconst_null
    //   145: aload 11
    //   147: bipush 60
    //   149: new 354	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient$4
    //   152: dup
    //   153: aload_0
    //   154: aload 9
    //   156: aload 10
    //   158: iload 4
    //   160: aload 11
    //   162: aload_2
    //   163: aload_1
    //   164: aload 12
    //   166: invokespecial 357	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient$4:<init>	(Lcom/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy;)V
    //   169: invokevirtual 361	com/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy:download	(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ILcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$DownloadListener;)Z
    //   172: pop
    //   173: aload_0
    //   174: iload_3
    //   175: ldc_w 363
    //   178: aconst_null
    //   179: invokestatic 369	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   182: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   185: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   188: return
    //   189: ldc_w 371
    //   192: aload_1
    //   193: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +34 -> 230
    //   199: aload_0
    //   200: iconst_1
    //   201: putfield 94	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:needToStopDownloadBGM	Z
    //   204: aload_0
    //   205: getfield 106	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:livePusherJSAdapter	Lcom/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter;
    //   208: aload_1
    //   209: aload_2
    //   210: invokevirtual 375	com/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter:operateLivePusher	(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/tencent/qqmini/miniapp/widget/media/live/TXJSAdapterError;
    //   213: pop
    //   214: aload_0
    //   215: iload_3
    //   216: ldc_w 363
    //   219: aconst_null
    //   220: invokestatic 369	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   223: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   226: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   229: return
    //   230: ldc_w 377
    //   233: aload_1
    //   234: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +76 -> 313
    //   240: aload_2
    //   241: ldc_w 379
    //   244: aload_2
    //   245: ldc 237
    //   247: invokevirtual 382	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   250: sipush 1000
    //   253: imul
    //   254: invokevirtual 385	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload_0
    //   259: getfield 106	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:livePusherJSAdapter	Lcom/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter;
    //   262: aload_1
    //   263: aload_2
    //   264: invokevirtual 375	com/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter:operateLivePusher	(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/tencent/qqmini/miniapp/widget/media/live/TXJSAdapterError;
    //   267: pop
    //   268: aload_0
    //   269: iload_3
    //   270: ldc_w 363
    //   273: aconst_null
    //   274: invokestatic 369	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   277: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   280: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   283: return
    //   284: astore_1
    //   285: ldc 10
    //   287: new 219	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 387
    //   297: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload_1
    //   301: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 304	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: goto -42 -> 268
    //   313: ldc_w 389
    //   316: aload_1
    //   317: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   320: ifeq +62 -> 382
    //   323: iconst_0
    //   324: istore 6
    //   326: iload 6
    //   328: istore 5
    //   330: aload_2
    //   331: ifnull +36 -> 367
    //   334: aload_2
    //   335: ldc_w 391
    //   338: invokevirtual 316	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: astore_1
    //   342: iload 6
    //   344: istore 5
    //   346: aload_1
    //   347: ifnull +20 -> 367
    //   350: iload 6
    //   352: istore 5
    //   354: aload_1
    //   355: ldc_w 393
    //   358: invokevirtual 396	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   361: ifeq +6 -> 367
    //   364: iconst_1
    //   365: istore 5
    //   367: aload_0
    //   368: aload_0
    //   369: getfield 142	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:curAppBrandRuntime	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   372: ldc_w 363
    //   375: iload 5
    //   377: iload_3
    //   378: invokevirtual 400	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:takePhoto	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;Ljava/lang/String;ZI)V
    //   381: return
    //   382: aload_1
    //   383: ldc_w 402
    //   386: invokevirtual 396	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   389: ifeq +314 -> 703
    //   392: invokestatic 341	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getInstance	()Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;
    //   395: ldc_w 404
    //   398: invokevirtual 407	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   401: astore_1
    //   402: aload_2
    //   403: ldc_w 409
    //   406: invokevirtual 413	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   409: lstore 7
    //   411: ldc 10
    //   413: new 219	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   420: ldc_w 415
    //   423: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_1
    //   427: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: aload_0
    //   437: getfield 106	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:livePusherJSAdapter	Lcom/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter;
    //   440: aload_1
    //   441: invokevirtual 418	com/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter:startDumpAudioData	(Ljava/lang/String;)I
    //   444: istore 4
    //   446: ldc 10
    //   448: new 219	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 420
    //   458: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: iload 4
    //   463: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: iload 4
    //   474: ifne +127 -> 601
    //   477: new 228	org/json/JSONObject
    //   480: dup
    //   481: invokespecial 424	org/json/JSONObject:<init>	()V
    //   484: astore 9
    //   486: invokestatic 341	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getInstance	()Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;
    //   489: aload_1
    //   490: invokevirtual 427	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   493: astore_2
    //   494: aload_2
    //   495: astore_1
    //   496: ldc 10
    //   498: new 219	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 429
    //   508: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 9
    //   523: ldc_w 431
    //   526: aload_1
    //   527: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   530: pop
    //   531: aload_0
    //   532: aload_1
    //   533: putfield 73	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:tempAudioFilePath	Ljava/lang/String;
    //   536: aload_0
    //   537: iload_3
    //   538: ldc_w 363
    //   541: aload 9
    //   543: invokestatic 369	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   546: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   549: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   552: aload_0
    //   553: getfield 71	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:handler	Landroid/os/Handler;
    //   556: aload_0
    //   557: getfield 80	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:stopDumpRunnable	Ljava/lang/Runnable;
    //   560: lload 7
    //   562: invokevirtual 438	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   565: pop
    //   566: ldc 10
    //   568: new 219	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 420
    //   578: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: iload 4
    //   583: invokevirtual 423	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: return
    //   593: astore_2
    //   594: aload_2
    //   595: invokevirtual 441	org/json/JSONException:printStackTrace	()V
    //   598: goto -67 -> 531
    //   601: iload 4
    //   603: iconst_m1
    //   604: if_icmpne +22 -> 626
    //   607: aload_0
    //   608: iload_3
    //   609: ldc_w 363
    //   612: aconst_null
    //   613: ldc_w 443
    //   616: invokestatic 447	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   619: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   622: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   625: return
    //   626: iload 4
    //   628: bipush 254
    //   630: if_icmpne +24 -> 654
    //   633: aload_0
    //   634: iload_3
    //   635: ldc_w 363
    //   638: aconst_null
    //   639: ldc_w 449
    //   642: invokestatic 447	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   645: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   648: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   651: goto -85 -> 566
    //   654: iload 4
    //   656: bipush 253
    //   658: if_icmpne +24 -> 682
    //   661: aload_0
    //   662: iload_3
    //   663: ldc_w 363
    //   666: aconst_null
    //   667: ldc_w 451
    //   670: invokestatic 447	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   673: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   676: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   679: goto -113 -> 566
    //   682: aload_0
    //   683: iload_3
    //   684: ldc_w 363
    //   687: aconst_null
    //   688: ldc_w 453
    //   691: invokestatic 447	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   694: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   697: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   700: goto -134 -> 566
    //   703: aload_1
    //   704: ldc_w 455
    //   707: invokevirtual 396	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   710: ifeq +102 -> 812
    //   713: ldc 10
    //   715: ldc_w 457
    //   718: invokestatic 199	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: aload_0
    //   722: getfield 71	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:handler	Landroid/os/Handler;
    //   725: aload_0
    //   726: getfield 80	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:stopDumpRunnable	Ljava/lang/Runnable;
    //   729: invokevirtual 461	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   732: aload_0
    //   733: getfield 106	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:livePusherJSAdapter	Lcom/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter;
    //   736: invokevirtual 463	com/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter:stopDumpAudioData	()V
    //   739: new 228	org/json/JSONObject
    //   742: dup
    //   743: invokespecial 424	org/json/JSONObject:<init>	()V
    //   746: astore_1
    //   747: aload_0
    //   748: getfield 73	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:tempAudioFilePath	Ljava/lang/String;
    //   751: invokestatic 468	com/tencent/qqmini/sdk/core/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   754: ifne +36 -> 790
    //   757: aload_1
    //   758: ldc_w 431
    //   761: aload_0
    //   762: getfield 73	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:tempAudioFilePath	Ljava/lang/String;
    //   765: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   768: pop
    //   769: aload_0
    //   770: aconst_null
    //   771: putfield 73	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:tempAudioFilePath	Ljava/lang/String;
    //   774: aload_0
    //   775: iload_3
    //   776: ldc_w 363
    //   779: aload_1
    //   780: invokestatic 369	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   783: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   786: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   789: return
    //   790: aload_1
    //   791: ldc_w 431
    //   794: ldc_w 470
    //   797: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   800: pop
    //   801: goto -27 -> 774
    //   804: astore_2
    //   805: aload_2
    //   806: invokevirtual 441	org/json/JSONException:printStackTrace	()V
    //   809: goto -35 -> 774
    //   812: aload_0
    //   813: getfield 106	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:livePusherJSAdapter	Lcom/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter;
    //   816: aload_1
    //   817: aload_2
    //   818: invokevirtual 375	com/tencent/qqmini/miniapp/widget/media/live/TXLivePusherJSAdapter:operateLivePusher	(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/tencent/qqmini/miniapp/widget/media/live/TXJSAdapterError;
    //   821: pop
    //   822: aload_0
    //   823: iload_3
    //   824: ldc_w 363
    //   827: aconst_null
    //   828: invokestatic 369	com/tencent/qqmini/sdk/launcher/core/utils/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   831: invokevirtual 229	org/json/JSONObject:toString	()Ljava/lang/String;
    //   834: invokespecial 135	com/tencent/qqmini/miniapp/plugin/LivePusherEmbeddedWidgetClient:evaluateCallbackJs	(ILjava/lang/String;)V
    //   837: return
    //   838: astore_2
    //   839: goto -245 -> 594
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	LivePusherEmbeddedWidgetClient
    //   0	842	1	paramIMiniAppContext	com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    //   0	842	2	paramJSONObject	JSONObject
    //   0	842	3	paramInt	int
    //   35	624	4	i	int
    //   328	48	5	bool1	boolean
    //   324	27	6	bool2	boolean
    //   409	152	7	l	long
    //   96	446	9	localObject	Object
    //   105	52	10	str1	String
    //   127	34	11	str2	String
    //   138	27	12	localDownloaderProxy	com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy
    // Exception table:
    //   from	to	target	type
    //   240	268	284	org/json/JSONException
    //   486	494	593	org/json/JSONException
    //   747	774	804	org/json/JSONException
    //   790	801	804	org/json/JSONException
    //   496	531	838	org/json/JSONException
  }
  
  public void handleRemoveXWebLivePusher()
  {
    release();
  }
  
  public void handleUpdateXWebLivePusher(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      QMLog.d("miniapp-embedded-live-pusher", "handleUpdateXWebLivePusher : " + paramJSONObject.toString());
      if (paramJSONObject.has("position"))
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
        this.width = ((int)(DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * localJSONObject.optInt("width", -1) + 0.5F));
        float f = DisplayUtil.getDensity(AppLoaderFactory.g().getContext());
        this.height = ((int)(localJSONObject.optInt("height", -1) * f + 0.5F));
        this.livePusherJSAdapter.setSurfaceSize(this.width, this.height);
      }
      if (this.livePusherJSAdapter != null) {
        this.livePusherJSAdapter.updateLivePusher(paramJSONObject);
      }
    }
  }
  
  public void nativeDestroy()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.nativeDestroy " + this);
    release();
  }
  
  public void nativePause()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.nativePause " + this);
    enterBackground();
  }
  
  public void nativeResume()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.nativeResume " + this);
    enterForeground();
  }
  
  public void onActive()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onActive");
  }
  
  public void onDeactive()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onDeactive");
  }
  
  public void onDestroy()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onDestroy");
  }
  
  public void onRectChanged(Rect paramRect)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onRectChanged, rect:" + paramRect.toString() + "； size : " + (paramRect.right - paramRect.left) + "," + (paramRect.bottom - paramRect.top));
  }
  
  public void onRequestRedraw()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onRequestRedraw");
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-live-pusher", "onSurfaceCreated: " + paramSurface);
    if ((paramSurface == null) || (!paramSurface.isValid()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onSurfaceCreated isValid() : ");
      if (paramSurface != null) {}
      for (paramSurface = Boolean.valueOf(paramSurface.isValid());; paramSurface = null)
      {
        QMLog.e("miniapp-embedded-live-pusher", paramSurface);
        return;
      }
    }
    this.mSurface = paramSurface;
  }
  
  public void onSurfaceDestroyed(Surface paramSurface)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onSurfaceDestroyed");
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onTouchEvent, rect:" + paramMotionEvent.toString());
    return false;
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.onVisibilityChanged ： " + paramBoolean);
  }
  
  public void release()
  {
    this.handler.removeCallbacks(this.stopDumpRunnable);
    if (this.livePusherJSAdapter != null)
    {
      this.livePusherJSAdapter.unInitLivePusher();
      this.livePusherJSAdapter.setSurface(null);
    }
  }
  
  public void takePhoto(IJsService paramIJsService, String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.livePusherJSAdapter == null) {
      return;
    }
    this.livePusherJSAdapter.takePhoto(paramBoolean, new LivePusherEmbeddedWidgetClient.5(this, paramString, paramInt));
  }
  
  public void webViewDestory()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.webviewDestory " + this);
    release();
  }
  
  public void webViewPause()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.webviewPause " + this);
    enterBackground();
  }
  
  public void webViewResume()
  {
    QMLog.d("miniapp-embedded-live-pusher", "LivePusherEmbeddedWidgetClient.webviewResume " + this);
    enterForeground();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient
 * JD-Core Version:    0.7.0.1
 */