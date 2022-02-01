import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.1;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.2;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.4;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.5;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=VideoJsProxy.class)
public class asxf
  extends VideoJsProxy
{
  private static final ExecutorService copyExecutor = Executors.newFixedThreadPool(5);
  private static final ExecutorService executor;
  private static AtomicBoolean isDownloadFFmpeg = new AtomicBoolean(false);
  private static volatile boolean isFFmpegReady;
  private static final Pattern timePattern = Pattern.compile("(?<=time=)[\\d:.]*");
  private String FFMPEG_ADDITIONAL_PARAM = QzoneConfig.getInstance().getConfig("qqminiapp", "miniFfmpegVideoCompressParam", "-profile:v main -crf 29");
  private long chooseVideoMaxDuration = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxDuration", 600000L);
  private long chooseVideoMaxSize = QzoneConfig.getInstance().getConfig("qqminiapp", "miniAppChooseVideoMaxSize", 1610612736L);
  private rqa ffmpeg;
  private Activity mActivity;
  private BroadcastReceiver mAvatarReceiver = new asxj(this);
  private boolean mAvatarReceiverRegistered;
  private int mCallBackId = -1;
  private IMiniAppContext miniAppContext;
  private String sourceTypeAlbum = "album";
  private String sourceTypeCamera = "camera";
  private boolean waitForResult;
  
  static
  {
    executor = Executors.newSingleThreadExecutor();
  }
  
  public asxf()
  {
    loadFFmpeg();
  }
  
  private File createVideoFile(Context paramContext)
  {
    try
    {
      paramContext = File.createTempFile("MP4_" + System.currentTimeMillis() + "_", ".mp4", paramContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VideoJsPlugin", 1, "createVideoFile: ", paramContext);
    }
    return null;
  }
  
  private void execCommand(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if (this.ffmpeg == null) {
      this.ffmpeg = rqa.a(BaseApplicationImpl.getApplication());
    }
    showLoading(acfp.m(2131716414));
    long l1 = System.currentTimeMillis();
    long l2 = paramLocalMediaInfo.mDuration;
    QLog.i("VideoJsPlugin", 2, "execCommand: " + paramString1 + " " + l1);
    try
    {
      String[] arrayOfString = paramString1.split(" ");
      this.ffmpeg.a(arrayOfString, new asxk(this, l1, paramString1, paramLocalMediaInfo, paramInt, paramString2, l2));
      return;
    }
    catch (Exception paramString2)
    {
      QLog.w("VideoJsPlugin", 1, "execCommand: failed " + paramString1, paramString2);
      hideLoading();
    }
  }
  
  public static int getAndSelectVideoTrackIndex(MediaExtractor paramMediaExtractor)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int i = 0;
        while (i < paramMediaExtractor.getTrackCount())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoJsPlugin", 2, "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
          }
          if (paramMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/"))
          {
            paramMediaExtractor.selectTrack(i);
            return i;
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception paramMediaExtractor) {}
  }
  
  private String getSaveVideoFilePath()
  {
    return ShortVideoUtils.getCameraPath() + "QQMiniApp" + System.currentTimeMillis() + "_.mp4";
  }
  
  private Bitmap getThumbnailBitmap(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ShortVideoUtils.getVideoThumbnail(null, ((IMiniAppFileManager)this.miniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(paramString));
    }
    return null;
  }
  
  private void goToCamera(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    goToNativeCamera(paramActivity, paramInt, paramBoolean1, paramBoolean2);
  }
  
  private void goToNativeCamera(Activity paramActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    Intent localIntent;
    File localFile;
    do
    {
      do
      {
        return;
        localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
      } while (localIntent.resolveActivity(paramActivity.getPackageManager()) == null);
      localFile = createVideoFile(paramActivity);
    } while (localFile == null);
    AppLoaderFactory.g().getActivityResultManager().addActivityResultListener(new asxl(this, localFile, paramBoolean1));
    localIntent.putExtra("output", FileProvider7Helper.getUriForFile(paramActivity, localFile));
    int i;
    if (paramInt >= 1)
    {
      i = paramInt;
      if (paramInt <= 60000) {}
    }
    else
    {
      i = 60000;
    }
    localIntent.putExtra("android.intent.extra.durationLimit", i);
    if (paramBoolean2) {
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
    localIntent.putExtra("big_brother_source_key", "biz_src_miniapp");
    paramActivity.startActivityForResult(localIntent, 2);
  }
  
  private void goToPic(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    this.waitForResult = true;
    Intent localIntent = new Intent(paramActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 4);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    localIntent.putExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME", "get_video_info");
    localIntent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_DURATION", this.chooseVideoMaxDuration);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", this.chooseVideoMaxSize);
    if (paramBoolean) {
      localIntent.putExtra("PhotoConst.DEST_OTHER_FLAG", "compress");
    }
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    paramActivity.startActivity(localIntent);
    aqfy.anim(paramActivity, false, true);
  }
  
  private void handleJsCallBack(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempFilePath", paramString);
      localJSONObject.put("thumbTempFilePath", paramLocalMediaInfo.thumbnailPath);
      localJSONObject.put("duration", Math.round((float)(paramLocalMediaInfo.mDuration / 1000L)));
      localJSONObject.put("size", paramLong);
      localJSONObject.put("height", paramLocalMediaInfo.mediaHeight);
      localJSONObject.put("width", paramLocalMediaInfo.mediaWidth);
      localJSONObject.put("__plugin_ready__", new File(ankc.am(MobileQQ.getContext())).exists());
      handleNativeResponseOk(paramInt, "chooseVideo", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      handleNativeResponseFail(paramInt, "chooseVideo", null, "");
    }
  }
  
  private void handleNativeResponseCancel(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseCancel(paramInt, paramString, paramJSONObject);
    }
  }
  
  private void handleNativeResponseFail(int paramInt, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (this.mBridge != null) {
      this.mBridge.responseFail(paramInt, paramString1, paramJSONObject, paramString2);
    }
  }
  
  private void handleNativeResponseOk(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (this.mBridge != null) {
      this.mBridge.responseOk(paramInt, paramString, paramJSONObject);
    }
  }
  
  /* Error */
  private void handleVideoResult(File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 314	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: new 602	java/io/FileInputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 605	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore 6
    //   19: new 316	android/media/MediaExtractor
    //   22: dup
    //   23: invokespecial 606	android/media/MediaExtractor:<init>	()V
    //   26: astore 5
    //   28: aload 6
    //   30: astore 8
    //   32: aload 5
    //   34: astore 7
    //   36: aload 5
    //   38: aload 6
    //   40: invokevirtual 610	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   43: invokevirtual 614	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   46: aload 6
    //   48: astore 8
    //   50: aload 5
    //   52: astore 7
    //   54: aload 5
    //   56: invokestatic 616	asxf:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   59: istore_3
    //   60: iload_3
    //   61: iconst_m1
    //   62: if_icmple +472 -> 534
    //   65: aload 6
    //   67: astore 8
    //   69: aload 5
    //   71: astore 7
    //   73: aload 5
    //   75: iload_3
    //   76: invokevirtual 335	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   79: astore 9
    //   81: aload 6
    //   83: astore 8
    //   85: aload 5
    //   87: astore 7
    //   89: new 277	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   92: dup
    //   93: invokespecial 617	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   96: astore 4
    //   98: iconst_0
    //   99: istore_3
    //   100: aload 6
    //   102: astore 8
    //   104: aload 5
    //   106: astore 7
    //   108: aload 9
    //   110: ldc_w 619
    //   113: invokevirtual 622	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   116: ifeq +423 -> 539
    //   119: aload 6
    //   121: astore 8
    //   123: aload 5
    //   125: astore 7
    //   127: aload 9
    //   129: ldc_w 619
    //   132: invokevirtual 626	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   135: istore_3
    //   136: goto +403 -> 539
    //   139: aload 6
    //   141: astore 8
    //   143: aload 5
    //   145: astore 7
    //   147: aload 4
    //   149: aload 9
    //   151: ldc_w 540
    //   154: invokevirtual 626	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   157: putfield 548	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   160: aload 6
    //   162: astore 8
    //   164: aload 5
    //   166: astore 7
    //   168: aload 4
    //   170: aload 9
    //   172: ldc_w 545
    //   175: invokevirtual 626	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   178: putfield 543	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   181: aload 6
    //   183: astore 8
    //   185: aload 5
    //   187: astore 7
    //   189: aload 4
    //   191: aload 9
    //   193: ldc_w 628
    //   196: invokevirtual 632	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   199: l2d
    //   200: ldc2_w 633
    //   203: ddiv
    //   204: invokestatic 637	java/lang/Math:round	(D)J
    //   207: putfield 280	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mDuration	J
    //   210: aload 6
    //   212: astore 8
    //   214: aload 5
    //   216: astore 7
    //   218: aload 4
    //   220: aload_1
    //   221: invokevirtual 639	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   224: putfield 642	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   227: aload 6
    //   229: astore 8
    //   231: aload 5
    //   233: astore 7
    //   235: aload 4
    //   237: aload_1
    //   238: invokevirtual 645	java/io/File:length	()J
    //   241: putfield 648	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   244: aload 4
    //   246: astore_1
    //   247: aload 6
    //   249: ifnull +8 -> 257
    //   252: aload 6
    //   254: invokevirtual 651	java/io/FileInputStream:close	()V
    //   257: aload_1
    //   258: astore 4
    //   260: aload 5
    //   262: ifnull +11 -> 273
    //   265: aload 5
    //   267: invokevirtual 654	android/media/MediaExtractor:release	()V
    //   270: aload_1
    //   271: astore 4
    //   273: aload 4
    //   275: ifnonnull +150 -> 425
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 74	asxf:mCallBackId	I
    //   283: ldc_w 571
    //   286: aconst_null
    //   287: ldc_w 579
    //   290: invokespecial 583	asxf:handleNativeResponseFail	(ILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   293: return
    //   294: aload 6
    //   296: astore 8
    //   298: aload 5
    //   300: astore 7
    //   302: aload 4
    //   304: aload 9
    //   306: ldc_w 545
    //   309: invokevirtual 626	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   312: putfield 548	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   315: aload 6
    //   317: astore 8
    //   319: aload 5
    //   321: astore 7
    //   323: aload 4
    //   325: aload 9
    //   327: ldc_w 540
    //   330: invokevirtual 626	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   333: putfield 543	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   336: goto -155 -> 181
    //   339: astore 7
    //   341: aload 4
    //   343: astore_1
    //   344: aload 7
    //   346: astore 4
    //   348: aload 6
    //   350: astore 8
    //   352: aload 5
    //   354: astore 7
    //   356: ldc 243
    //   358: iconst_1
    //   359: ldc_w 656
    //   362: aload 4
    //   364: invokestatic 307	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload 6
    //   369: ifnull +8 -> 377
    //   372: aload 6
    //   374: invokevirtual 651	java/io/FileInputStream:close	()V
    //   377: aload_1
    //   378: astore 4
    //   380: aload 5
    //   382: ifnull -109 -> 273
    //   385: aload 5
    //   387: invokevirtual 654	android/media/MediaExtractor:release	()V
    //   390: aload_1
    //   391: astore 4
    //   393: goto -120 -> 273
    //   396: astore_1
    //   397: aconst_null
    //   398: astore 6
    //   400: aconst_null
    //   401: astore 7
    //   403: aload 6
    //   405: ifnull +8 -> 413
    //   408: aload 6
    //   410: invokevirtual 651	java/io/FileInputStream:close	()V
    //   413: aload 7
    //   415: ifnull +8 -> 423
    //   418: aload 7
    //   420: invokevirtual 654	android/media/MediaExtractor:release	()V
    //   423: aload_1
    //   424: athrow
    //   425: iload_2
    //   426: ifeq +11 -> 437
    //   429: aload_0
    //   430: aload 4
    //   432: iconst_1
    //   433: invokespecial 159	asxf:startCompress	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Z)V
    //   436: return
    //   437: aload_0
    //   438: aload_0
    //   439: getfield 135	asxf:miniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   442: ldc_w 374
    //   445: invokeinterface 380 2 0
    //   450: checkcast 374	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   453: aload 4
    //   455: getfield 642	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   458: invokeinterface 659 2 0
    //   463: aload 4
    //   465: getfield 648	com/tencent/mobileqq/activity/photo/LocalMediaInfo:fileSize	J
    //   468: aload 4
    //   470: invokespecial 174	asxf:respGetVideo	(Ljava/lang/String;JLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   473: return
    //   474: astore 4
    //   476: goto -219 -> 257
    //   479: astore 4
    //   481: goto -104 -> 377
    //   484: astore 4
    //   486: goto -73 -> 413
    //   489: astore_1
    //   490: aconst_null
    //   491: astore 7
    //   493: goto -90 -> 403
    //   496: astore_1
    //   497: aload 8
    //   499: astore 6
    //   501: goto -98 -> 403
    //   504: astore 4
    //   506: aconst_null
    //   507: astore 6
    //   509: aconst_null
    //   510: astore 5
    //   512: aconst_null
    //   513: astore_1
    //   514: goto -166 -> 348
    //   517: astore 4
    //   519: aconst_null
    //   520: astore 5
    //   522: aconst_null
    //   523: astore_1
    //   524: goto -176 -> 348
    //   527: astore 4
    //   529: aconst_null
    //   530: astore_1
    //   531: goto -183 -> 348
    //   534: aconst_null
    //   535: astore_1
    //   536: goto -289 -> 247
    //   539: iload_3
    //   540: bipush 90
    //   542: if_icmpeq -403 -> 139
    //   545: iload_3
    //   546: sipush 270
    //   549: if_icmpne -255 -> 294
    //   552: goto -413 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	asxf
    //   0	555	1	paramFile	File
    //   0	555	2	paramBoolean	boolean
    //   59	491	3	i	int
    //   96	373	4	localObject1	Object
    //   474	1	4	localIOException1	java.io.IOException
    //   479	1	4	localIOException2	java.io.IOException
    //   484	1	4	localIOException3	java.io.IOException
    //   504	1	4	localIOException4	java.io.IOException
    //   517	1	4	localIOException5	java.io.IOException
    //   527	1	4	localIOException6	java.io.IOException
    //   26	495	5	localMediaExtractor1	MediaExtractor
    //   17	491	6	localObject2	Object
    //   34	288	7	localMediaExtractor2	MediaExtractor
    //   339	6	7	localIOException7	java.io.IOException
    //   354	138	7	localMediaExtractor3	MediaExtractor
    //   30	468	8	localObject3	Object
    //   79	247	9	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   108	119	339	java/io/IOException
    //   127	136	339	java/io/IOException
    //   147	160	339	java/io/IOException
    //   168	181	339	java/io/IOException
    //   189	210	339	java/io/IOException
    //   218	227	339	java/io/IOException
    //   235	244	339	java/io/IOException
    //   302	315	339	java/io/IOException
    //   323	336	339	java/io/IOException
    //   9	19	396	finally
    //   252	257	474	java/io/IOException
    //   372	377	479	java/io/IOException
    //   408	413	484	java/io/IOException
    //   19	28	489	finally
    //   36	46	496	finally
    //   54	60	496	finally
    //   73	81	496	finally
    //   89	98	496	finally
    //   108	119	496	finally
    //   127	136	496	finally
    //   147	160	496	finally
    //   168	181	496	finally
    //   189	210	496	finally
    //   218	227	496	finally
    //   235	244	496	finally
    //   302	315	496	finally
    //   323	336	496	finally
    //   356	367	496	finally
    //   9	19	504	java/io/IOException
    //   19	28	517	java/io/IOException
    //   36	46	527	java/io/IOException
    //   54	60	527	java/io/IOException
    //   73	81	527	java/io/IOException
    //   89	98	527	java/io/IOException
  }
  
  private void hideLoading()
  {
    QLog.i("VideoJsPlugin", 1, "hideLoading");
    if (this.mBridge != null) {
      this.mBridge.hideLoading();
    }
  }
  
  private static void loadFFmpeg()
  {
    if (isFFmpegReady) {
      return;
    }
    int i = VideoEnvironment.d("AVCodec", MobileQQ.sMobileQQ.getApplicationContext());
    QLog.i("VideoJsPlugin", 1, "loadFFmpeg: " + i);
    if (i == 0)
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is already load");
      isFFmpegReady = true;
      return;
    }
    if (!isDownloadFFmpeg.compareAndSet(false, true))
    {
      QLog.i("VideoJsPlugin", 1, "loadFFmpeg: is downloading already");
      return;
    }
    executor.execute(new VideoJsProxyImpl.1());
  }
  
  private void registerAvatarReceiver(Activity paramActivity)
  {
    if (!this.mAvatarReceiverRegistered)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoJsPlugin", 2, "registerAvatarReceiver");
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("get_video_info");
      paramActivity.registerReceiver(this.mAvatarReceiver, localIntentFilter);
      this.mAvatarReceiverRegistered = true;
    }
  }
  
  private void respGetVideo(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo == null)
    {
      handleNativeResponseCancel(this.mCallBackId, "chooseVideo", null);
      return;
    }
    if (!TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      handleJsCallBack(paramString, paramLong, paramLocalMediaInfo, this.mCallBackId);
      return;
    }
    int i = this.mCallBackId;
    ThreadManager.getFileThreadHandler().post(new VideoJsProxyImpl.4(this, paramString, paramLocalMediaInfo, paramLong, i));
  }
  
  /* Error */
  private boolean saveThumbnail(Bitmap paramBitmap, LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: ifnonnull +18 -> 24
    //   9: ldc 243
    //   11: iconst_2
    //   12: ldc_w 729
    //   15: invokestatic 731	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iload_3
    //   19: istore 4
    //   21: iload 4
    //   23: ireturn
    //   24: aload_2
    //   25: ifnonnull +14 -> 39
    //   28: ldc 243
    //   30: iconst_2
    //   31: ldc_w 733
    //   34: invokestatic 731	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 135	asxf:miniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   43: ldc_w 374
    //   46: invokeinterface 380 2 0
    //   51: checkcast 374	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   54: ldc_w 735
    //   57: invokeinterface 738 2 0
    //   62: astore 5
    //   64: new 237	java/io/File
    //   67: dup
    //   68: aload 5
    //   70: invokespecial 563	java/io/File:<init>	(Ljava/lang/String;)V
    //   73: astore 10
    //   75: aload 10
    //   77: invokevirtual 566	java/io/File:exists	()Z
    //   80: ifeq +9 -> 89
    //   83: aload 10
    //   85: invokevirtual 741	java/io/File:delete	()Z
    //   88: pop
    //   89: new 743	java/io/FileOutputStream
    //   92: dup
    //   93: aload 10
    //   95: invokespecial 744	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: astore 6
    //   100: new 746	java/io/BufferedOutputStream
    //   103: dup
    //   104: aload 6
    //   106: sipush 4096
    //   109: invokespecial 749	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   112: astore 9
    //   114: aload 9
    //   116: astore 8
    //   118: aload 6
    //   120: astore 7
    //   122: aload_1
    //   123: getstatic 755	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: bipush 100
    //   128: aload 9
    //   130: invokevirtual 760	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   133: istore_3
    //   134: aload 9
    //   136: astore 8
    //   138: aload 6
    //   140: astore 7
    //   142: aload 9
    //   144: invokevirtual 763	java/io/BufferedOutputStream:flush	()V
    //   147: aload 9
    //   149: astore 8
    //   151: aload 6
    //   153: astore 7
    //   155: aload 10
    //   157: invokevirtual 639	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   160: astore_1
    //   161: aload 9
    //   163: astore 8
    //   165: aload 6
    //   167: astore 7
    //   169: aload_2
    //   170: aload_0
    //   171: getfield 135	asxf:miniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   174: ldc_w 374
    //   177: invokeinterface 380 2 0
    //   182: checkcast 374	com/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager
    //   185: aload_1
    //   186: invokeinterface 659 2 0
    //   191: putfield 520	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   194: aload 6
    //   196: ifnull +8 -> 204
    //   199: aload 6
    //   201: invokevirtual 764	java/io/FileOutputStream:close	()V
    //   204: aload 9
    //   206: ifnull +275 -> 481
    //   209: aload 9
    //   211: invokevirtual 765	java/io/BufferedOutputStream:close	()V
    //   214: aload_1
    //   215: astore_2
    //   216: iload_3
    //   217: istore 4
    //   219: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -201 -> 21
    //   225: ldc 243
    //   227: iconst_2
    //   228: new 200	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 767
    //   238: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_2
    //   242: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: iload_3
    //   252: ireturn
    //   253: astore_2
    //   254: aload_2
    //   255: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   258: goto -54 -> 204
    //   261: astore_2
    //   262: aload_2
    //   263: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   266: aload_1
    //   267: astore_2
    //   268: goto -52 -> 216
    //   271: astore_2
    //   272: aconst_null
    //   273: astore 7
    //   275: aconst_null
    //   276: astore 6
    //   278: aload 5
    //   280: astore_1
    //   281: aload 7
    //   283: astore 5
    //   285: aload 5
    //   287: astore 8
    //   289: aload 6
    //   291: astore 7
    //   293: invokestatic 324	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +21 -> 317
    //   299: aload 5
    //   301: astore 8
    //   303: aload 6
    //   305: astore 7
    //   307: ldc 243
    //   309: iconst_2
    //   310: ldc_w 770
    //   313: aload_2
    //   314: invokestatic 307	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: aload 6
    //   319: ifnull +8 -> 327
    //   322: aload 6
    //   324: invokevirtual 764	java/io/FileOutputStream:close	()V
    //   327: aload_1
    //   328: astore_2
    //   329: iload 4
    //   331: istore_3
    //   332: aload 5
    //   334: ifnull -118 -> 216
    //   337: aload 5
    //   339: invokevirtual 765	java/io/BufferedOutputStream:close	()V
    //   342: aload_1
    //   343: astore_2
    //   344: iload 4
    //   346: istore_3
    //   347: goto -131 -> 216
    //   350: astore_2
    //   351: aload_2
    //   352: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   355: aload_1
    //   356: astore_2
    //   357: iload 4
    //   359: istore_3
    //   360: goto -144 -> 216
    //   363: astore_2
    //   364: aload_2
    //   365: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   368: goto -41 -> 327
    //   371: astore_1
    //   372: aconst_null
    //   373: astore 8
    //   375: aconst_null
    //   376: astore 6
    //   378: aload 6
    //   380: ifnull +8 -> 388
    //   383: aload 6
    //   385: invokevirtual 764	java/io/FileOutputStream:close	()V
    //   388: aload 8
    //   390: ifnull +8 -> 398
    //   393: aload 8
    //   395: invokevirtual 765	java/io/BufferedOutputStream:close	()V
    //   398: aload_1
    //   399: athrow
    //   400: astore_2
    //   401: aload_2
    //   402: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   405: goto -17 -> 388
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   413: goto -15 -> 398
    //   416: astore_1
    //   417: aconst_null
    //   418: astore 8
    //   420: goto -42 -> 378
    //   423: astore_1
    //   424: aload 7
    //   426: astore 6
    //   428: goto -50 -> 378
    //   431: astore_2
    //   432: aconst_null
    //   433: astore 7
    //   435: aload 5
    //   437: astore_1
    //   438: aload 7
    //   440: astore 5
    //   442: goto -157 -> 285
    //   445: astore_2
    //   446: aload 5
    //   448: astore_1
    //   449: aload 9
    //   451: astore 5
    //   453: goto -168 -> 285
    //   456: astore_2
    //   457: aload 5
    //   459: astore_1
    //   460: iload_3
    //   461: istore 4
    //   463: aload 9
    //   465: astore 5
    //   467: goto -182 -> 285
    //   470: astore_2
    //   471: iload_3
    //   472: istore 4
    //   474: aload 9
    //   476: astore 5
    //   478: goto -193 -> 285
    //   481: aload_1
    //   482: astore_2
    //   483: goto -267 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	asxf
    //   0	486	1	paramBitmap	Bitmap
    //   0	486	2	paramLocalMediaInfo	LocalMediaInfo
    //   4	468	3	bool1	boolean
    //   1	472	4	bool2	boolean
    //   62	415	5	localObject1	Object
    //   98	329	6	localObject2	Object
    //   120	319	7	localObject3	Object
    //   116	303	8	localObject4	Object
    //   112	363	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   73	83	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   199	204	253	java/io/IOException
    //   209	214	261	java/io/IOException
    //   89	100	271	java/lang/Exception
    //   337	342	350	java/io/IOException
    //   322	327	363	java/io/IOException
    //   89	100	371	finally
    //   383	388	400	java/io/IOException
    //   393	398	408	java/io/IOException
    //   100	114	416	finally
    //   122	134	423	finally
    //   142	147	423	finally
    //   155	161	423	finally
    //   169	194	423	finally
    //   293	299	423	finally
    //   307	317	423	finally
    //   100	114	431	java/lang/Exception
    //   122	134	445	java/lang/Exception
    //   142	147	456	java/lang/Exception
    //   155	161	456	java/lang/Exception
    //   169	194	470	java/lang/Exception
  }
  
  private void showLoading(String paramString)
  {
    QLog.i("VideoJsPlugin", 1, "showLoading " + paramString);
    if (this.mBridge != null) {
      this.mBridge.showLoading(paramString);
    }
  }
  
  private void startCompress(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    for (int i = 2;; i = 4) {
      for (;;)
      {
        String str;
        try
        {
          int j = paramLocalMediaInfo.path.lastIndexOf(".");
          if (j < 0)
          {
            localObject = "";
            if (paramLocalMediaInfo.path.contains(" ")) {
              copyExecutor.execute(new VideoJsProxyImpl.5(this, paramLocalMediaInfo, (String)localObject, paramBoolean));
            }
          }
          else
          {
            localObject = paramLocalMediaInfo.path.substring(j + 1);
            continue;
          }
          str = ((IMiniAppFileManager)this.miniAppContext.getManager(IMiniAppFileManager.class)).getTmpPath((String)localObject);
          localObject = new File(str);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
          QLog.i("VideoJsPlugin", 2, "startCompress: " + paramLocalMediaInfo.orientation);
          if ((paramLocalMediaInfo.mediaWidth > 3000) || (paramLocalMediaInfo.mediaHeight > 3000)) {
            break;
          }
          j = paramLocalMediaInfo.mediaHeight / i;
          if (paramBoolean)
          {
            localObject = "-i " + paramLocalMediaInfo.path + " -r 20 -y -vf scale=-1:" + j + " " + this.FFMPEG_ADDITIONAL_PARAM + " " + str;
            execCommand((String)localObject, str, paramLocalMediaInfo, i);
            return;
          }
        }
        catch (Exception paramLocalMediaInfo)
        {
          QLog.e("VideoJsPlugin", 1, "startCompress=e=" + paramLocalMediaInfo.getMessage());
          return;
        }
        Object localObject = "-i " + paramLocalMediaInfo.path + " -r 20 -y -c:v libx264 -preset ultrafast " + str;
      }
    }
  }
  
  private void unregisterAvatarReceiver()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoJsPlugin", 2, "unregisterAvatarReceiver");
    }
    try
    {
      if (this.mActivity != null) {
        this.mActivity.unregisterReceiver(this.mAvatarReceiver);
      }
      this.mAvatarReceiverRegistered = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("VideoJsPlugin", 1, "unregisterReceiver exception.", localThrowable);
      }
    }
  }
  
  public String a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    i = 0;
    QLog.d("VideoJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    loadFFmpeg();
    this.mCallBackId = paramInt;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (!"chooseVideo".equals(paramString1)) {
        break label374;
      }
      registerAvatarReceiver(paramActivity);
      localJSONArray = paramString2.optJSONArray("sourceType");
      bool1 = paramString2.optBoolean("compressed");
      bool2 = paramString2.optString("camera").equals("front");
      if (localJSONArray.length() == 0)
      {
        handleNativeResponseFail(paramInt, paramString1, null, "fail sourceType error");
        return "";
      }
    }
    catch (JSONException paramActivity)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        boolean bool1;
        boolean bool2;
        Object localObject;
        paramActivity.printStackTrace();
        handleNativeResponseFail(paramInt, paramString1, null, "");
        continue;
        goToPic(paramActivity, i, bool1);
        continue;
        if ("saveVideoToPhotosAlbum".equals(paramString1))
        {
          paramString2 = paramString2.optString("filePath");
          if (aqmr.isEmpty(paramString2))
          {
            handleNativeResponseFail(paramInt, paramString1, null, "fail file not exists");
          }
          else if (rox.saveVideoToAlbum(paramActivity, ((IMiniAppFileManager)this.miniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(paramString2), getSaveVideoFilePath()))
          {
            handleNativeResponseOk(paramInt, paramString1, null);
          }
          else
          {
            handleNativeResponseFail(paramInt, paramString1, null, "fail filePath invalid");
            continue;
            i += 1;
          }
        }
      }
    }
    if (i < localJSONArray.length())
    {
      localObject = localJSONArray.opt(i);
      if ((!localObject.equals(this.sourceTypeAlbum)) && (!localObject.equals(this.sourceTypeCamera)))
      {
        QLog.e("VideoJsPlugin", 1, "API_CHOOSE_VIDEO sourceType error. " + localJSONArray.opt(i));
        handleNativeResponseFail(paramInt, paramString1, null, "fail sourceType error");
        return "";
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoJsPlugin", 2, "sourceType: " + localJSONArray + " length: " + localJSONArray.length());
      }
      i = paramString2.optInt("maxDuration");
      if (localJSONArray.length() == 2) {
        AppBrandTask.runTaskOnUiThread(new VideoJsProxyImpl.2(this, paramActivity, i, bool1, bool2));
      }
      for (;;)
      {
        return "";
        if (!"camera".equals(localJSONArray.optString(0))) {
          break;
        }
        goToCamera(paramActivity, i, bool1, bool2);
      }
    }
  }
  
  public void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    this.miniAppContext = paramIMiniAppContext;
  }
  
  public void destroy()
  {
    unregisterAvatarReceiver();
    super.destroy();
  }
  
  public void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    a(paramActivity, paramString1, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxf
 * JD-Core Version:    0.7.0.1
 */