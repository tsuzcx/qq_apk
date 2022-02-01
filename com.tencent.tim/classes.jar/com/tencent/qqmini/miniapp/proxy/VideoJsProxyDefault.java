package com.tencent.qqmini.miniapp.proxy;

import alld;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.miniapp.util.VideoCompress.Option;
import com.tencent.qqmini.miniapp.util.VideoCompress.TargetEncoding;
import com.tencent.qqmini.miniapp.util.VideoCompressProxy;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.LocalMediaInfo;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ProxyService(proxy=VideoJsProxy.class)
public class VideoJsProxyDefault
  extends VideoJsProxy
{
  public static final String API_CHOOSE_VIDEO = "chooseVideo";
  private static final String SOURCE_TYPE_ALBUM = "album";
  private static final String SOURCE_TYPE_CAMERA = "camera";
  public static final String TAG = "VideoJsProxyImpl";
  private static final ExecutorService copyExecutor = Executors.newFixedThreadPool(5);
  private IMiniAppContext mMiniAppContext;
  private VideoCompressProxy mVideoCompressService;
  
  public VideoJsProxyDefault()
  {
    Log.i("VideoJsProxyImpl", "construct");
    this.mVideoCompressService = new VideoCompressProxyDefault();
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
      QMLog.e("VideoJsProxyImpl", "createVideoFile: ", paramContext);
    }
    return null;
  }
  
  private void execVideoCompress(LocalMediaInfo paramLocalMediaInfo, String paramString, VideoCompress.Option paramOption, BridgeInfo paramBridgeInfo)
  {
    showLoading("正在压缩");
    long l = System.currentTimeMillis();
    this.mVideoCompressService.setMedia(paramLocalMediaInfo).setOption(paramOption).setOutputPath(paramString).listen(new VideoJsProxyDefault.5(this, l, paramOption, paramLocalMediaInfo, paramString, paramBridgeInfo)).execute();
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
          if (QMLog.isColorLevel()) {
            QMLog.d("VideoJsProxyImpl", "format for track " + i + " is " + paramMediaExtractor.getTrackFormat(i).getString("mime"));
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
    return ShortVideoUtil.getCameraPath() + "QQMiniApp" + System.currentTimeMillis() + "_.mp4";
  }
  
  private Bitmap getThumbnailBitmap(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ShortVideoUtil.getVideoThumbnail(null, ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString));
    }
    return null;
  }
  
  private void goToCamera(Activity paramActivity, long paramLong, boolean paramBoolean1, boolean paramBoolean2, BridgeInfo paramBridgeInfo)
  {
    boolean bool = hasFrontCamera(paramActivity);
    if ((paramBoolean2) && (!bool))
    {
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, "front camera not supported");
      return;
    }
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    if (localIntent.resolveActivity(paramActivity.getPackageManager()) == null)
    {
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, "当前系统不支持");
      return;
    }
    File localFile = createVideoFile(paramActivity.getApplicationContext());
    if (localFile == null)
    {
      this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, "createVideoFile error");
      return;
    }
    QMLog.i("VideoJsProxyImpl", "videoFile=" + localFile.getAbsolutePath());
    Uri localUri = FileUtils.getUriForFile(paramActivity, localFile);
    QMLog.i("VideoJsProxyImpl", "videoUri=" + localUri);
    localIntent.putExtra("output", localUri);
    long l;
    if (paramLong >= 1L)
    {
      l = paramLong;
      if (paramLong <= 60000L) {}
    }
    else
    {
      l = 60000L;
    }
    localIntent.putExtra("android.intent.extra.durationLimit", l);
    if (paramBoolean2) {
      localIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }
    ActivityResultManager.g().addActivityResultListener(new VideoJsProxyDefault.3(this, paramBridgeInfo, localFile, paramBoolean1));
    paramActivity.startActivityForResult(localIntent, 4);
  }
  
  private void goToPic(Activity paramActivity, int paramInt, boolean paramBoolean, BridgeInfo paramBridgeInfo)
  {
    Intent localIntent = new Intent("android.intent.action.PICK");
    localIntent.setDataAndType(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "video/*");
    ActivityResultManager.g().addActivityResultListener(new VideoJsProxyDefault.2(this, paramBridgeInfo, paramActivity, paramBoolean));
    paramActivity.startActivityForResult(localIntent, 2);
  }
  
  private void handleJsCallBack(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, BridgeInfo paramBridgeInfo)
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
      this.mBridge.responseOk(paramBridgeInfo.callbackId, "chooseVideo", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      this.mBridge.responseFail(paramBridgeInfo.callbackId, "chooseVideo", null, "");
    }
  }
  
  /* Error */
  private void handleVideoResult(File paramFile, boolean paramBoolean, BridgeInfo paramBridgeInfo)
  {
    // Byte code:
    //   0: getstatic 219	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmpge +4 -> 9
    //   8: return
    //   9: ldc 23
    //   11: new 130	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 475
    //   21: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 343	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 345	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 477	java/io/FileInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 480	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 7
    //   47: new 221	android/media/MediaExtractor
    //   50: dup
    //   51: invokespecial 481	android/media/MediaExtractor:<init>	()V
    //   54: astore 6
    //   56: aload 7
    //   58: astore 9
    //   60: aload 6
    //   62: astore 8
    //   64: aload 6
    //   66: aload 7
    //   68: invokevirtual 485	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   71: invokevirtual 489	android/media/MediaExtractor:setDataSource	(Ljava/io/FileDescriptor;)V
    //   74: aload 7
    //   76: astore 9
    //   78: aload 6
    //   80: astore 8
    //   82: aload 6
    //   84: invokestatic 491	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:getAndSelectVideoTrackIndex	(Landroid/media/MediaExtractor;)I
    //   87: istore 4
    //   89: iload 4
    //   91: iconst_m1
    //   92: if_icmple +477 -> 569
    //   95: aload 7
    //   97: astore 9
    //   99: aload 6
    //   101: astore 8
    //   103: aload 6
    //   105: iload 4
    //   107: invokevirtual 240	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   110: astore 10
    //   112: aload 7
    //   114: astore 9
    //   116: aload 6
    //   118: astore 8
    //   120: new 427	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo
    //   123: dup
    //   124: invokespecial 492	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:<init>	()V
    //   127: astore 5
    //   129: iconst_0
    //   130: istore 4
    //   132: aload 7
    //   134: astore 9
    //   136: aload 6
    //   138: astore 8
    //   140: aload 10
    //   142: ldc_w 494
    //   145: invokevirtual 497	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   148: ifeq +426 -> 574
    //   151: aload 7
    //   153: astore 9
    //   155: aload 6
    //   157: astore 8
    //   159: aload 10
    //   161: ldc_w 494
    //   164: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   167: istore 4
    //   169: goto +405 -> 574
    //   172: aload 7
    //   174: astore 9
    //   176: aload 6
    //   178: astore 8
    //   180: aload 5
    //   182: aload 10
    //   184: ldc_w 454
    //   187: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   190: putfield 462	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaWidth	I
    //   193: aload 7
    //   195: astore 9
    //   197: aload 6
    //   199: astore 8
    //   201: aload 5
    //   203: aload 10
    //   205: ldc_w 459
    //   208: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   211: putfield 457	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaHeight	I
    //   214: aload 7
    //   216: astore 9
    //   218: aload 6
    //   220: astore 8
    //   222: aload 5
    //   224: aload 10
    //   226: ldc_w 503
    //   229: invokevirtual 507	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   232: l2d
    //   233: ldc2_w 508
    //   236: ddiv
    //   237: invokestatic 512	java/lang/Math:round	(D)J
    //   240: putfield 436	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mDuration	J
    //   243: aload 7
    //   245: astore 9
    //   247: aload 6
    //   249: astore 8
    //   251: aload 5
    //   253: aload_1
    //   254: invokevirtual 343	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   257: putfield 515	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:path	Ljava/lang/String;
    //   260: aload 7
    //   262: astore 9
    //   264: aload 6
    //   266: astore 8
    //   268: aload 5
    //   270: aload_1
    //   271: invokevirtual 518	java/io/File:length	()J
    //   274: putfield 521	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:fileSize	J
    //   277: aload 5
    //   279: astore_1
    //   280: aload 7
    //   282: ifnull +8 -> 290
    //   285: aload 7
    //   287: invokevirtual 524	java/io/FileInputStream:close	()V
    //   290: aload_1
    //   291: astore 5
    //   293: aload 6
    //   295: ifnull +11 -> 306
    //   298: aload 6
    //   300: invokevirtual 527	android/media/MediaExtractor:release	()V
    //   303: aload_1
    //   304: astore 5
    //   306: aload 5
    //   308: ifnonnull +153 -> 461
    //   311: aload_0
    //   312: getfield 91	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mBridge	Lcom/tencent/qqmini/sdk/launcher/core/proxy/VideoJsProxy$Bridge;
    //   315: aload_3
    //   316: getfield 302	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault$BridgeInfo:callbackId	I
    //   319: ldc 14
    //   321: aconst_null
    //   322: ldc_w 471
    //   325: invokeinterface 313 5 0
    //   330: return
    //   331: aload 7
    //   333: astore 9
    //   335: aload 6
    //   337: astore 8
    //   339: aload 5
    //   341: aload 10
    //   343: ldc_w 459
    //   346: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   349: putfield 462	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaWidth	I
    //   352: aload 7
    //   354: astore 9
    //   356: aload 6
    //   358: astore 8
    //   360: aload 5
    //   362: aload 10
    //   364: ldc_w 454
    //   367: invokevirtual 501	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   370: putfield 457	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:mediaHeight	I
    //   373: goto -159 -> 214
    //   376: astore 8
    //   378: aload 5
    //   380: astore_1
    //   381: aload 8
    //   383: astore 5
    //   385: aload 7
    //   387: astore 9
    //   389: aload 6
    //   391: astore 8
    //   393: ldc 23
    //   395: ldc_w 529
    //   398: aload 5
    //   400: invokestatic 532	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   403: aload 7
    //   405: ifnull +8 -> 413
    //   408: aload 7
    //   410: invokevirtual 524	java/io/FileInputStream:close	()V
    //   413: aload_1
    //   414: astore 5
    //   416: aload 6
    //   418: ifnull -112 -> 306
    //   421: aload 6
    //   423: invokevirtual 527	android/media/MediaExtractor:release	()V
    //   426: aload_1
    //   427: astore 5
    //   429: goto -123 -> 306
    //   432: astore_1
    //   433: aconst_null
    //   434: astore 7
    //   436: aconst_null
    //   437: astore 8
    //   439: aload 7
    //   441: ifnull +8 -> 449
    //   444: aload 7
    //   446: invokevirtual 524	java/io/FileInputStream:close	()V
    //   449: aload 8
    //   451: ifnull +8 -> 459
    //   454: aload 8
    //   456: invokevirtual 527	android/media/MediaExtractor:release	()V
    //   459: aload_1
    //   460: athrow
    //   461: iload_2
    //   462: ifeq +12 -> 474
    //   465: aload_0
    //   466: aload 5
    //   468: iconst_1
    //   469: aload_3
    //   470: invokespecial 112	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:startCompress	(Lcom/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo;ZLcom/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault$BridgeInfo;)V
    //   473: return
    //   474: aload_0
    //   475: aload_0
    //   476: getfield 102	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   479: ldc_w 282
    //   482: invokeinterface 288 2 0
    //   487: checkcast 282	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   490: aload 5
    //   492: getfield 515	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:path	Ljava/lang/String;
    //   495: invokevirtual 535	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   498: aload 5
    //   500: getfield 521	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:fileSize	J
    //   503: aload 5
    //   505: aload_3
    //   506: invokespecial 106	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:respGetVideo	(Ljava/lang/String;JLcom/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo;Lcom/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault$BridgeInfo;)V
    //   509: return
    //   510: astore 5
    //   512: goto -222 -> 290
    //   515: astore 5
    //   517: goto -104 -> 413
    //   520: astore_3
    //   521: goto -72 -> 449
    //   524: astore_1
    //   525: aconst_null
    //   526: astore 8
    //   528: goto -89 -> 439
    //   531: astore_1
    //   532: aload 9
    //   534: astore 7
    //   536: goto -97 -> 439
    //   539: astore 5
    //   541: aconst_null
    //   542: astore 7
    //   544: aconst_null
    //   545: astore 6
    //   547: aconst_null
    //   548: astore_1
    //   549: goto -164 -> 385
    //   552: astore 5
    //   554: aconst_null
    //   555: astore 6
    //   557: aconst_null
    //   558: astore_1
    //   559: goto -174 -> 385
    //   562: astore 5
    //   564: aconst_null
    //   565: astore_1
    //   566: goto -181 -> 385
    //   569: aconst_null
    //   570: astore_1
    //   571: goto -291 -> 280
    //   574: iload 4
    //   576: bipush 90
    //   578: if_icmpeq -406 -> 172
    //   581: iload 4
    //   583: sipush 270
    //   586: if_icmpne -255 -> 331
    //   589: goto -417 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	this	VideoJsProxyDefault
    //   0	592	1	paramFile	File
    //   0	592	2	paramBoolean	boolean
    //   0	592	3	paramBridgeInfo	BridgeInfo
    //   87	500	4	i	int
    //   127	377	5	localObject1	Object
    //   510	1	5	localIOException1	java.io.IOException
    //   515	1	5	localIOException2	java.io.IOException
    //   539	1	5	localIOException3	java.io.IOException
    //   552	1	5	localIOException4	java.io.IOException
    //   562	1	5	localIOException5	java.io.IOException
    //   54	502	6	localMediaExtractor1	MediaExtractor
    //   45	498	7	localObject2	Object
    //   62	297	8	localMediaExtractor2	MediaExtractor
    //   376	6	8	localIOException6	java.io.IOException
    //   391	136	8	localMediaExtractor3	MediaExtractor
    //   58	475	9	localObject3	Object
    //   110	253	10	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   140	151	376	java/io/IOException
    //   159	169	376	java/io/IOException
    //   180	193	376	java/io/IOException
    //   201	214	376	java/io/IOException
    //   222	243	376	java/io/IOException
    //   251	260	376	java/io/IOException
    //   268	277	376	java/io/IOException
    //   339	352	376	java/io/IOException
    //   360	373	376	java/io/IOException
    //   37	47	432	finally
    //   285	290	510	java/io/IOException
    //   408	413	515	java/io/IOException
    //   444	449	520	java/io/IOException
    //   47	56	524	finally
    //   64	74	531	finally
    //   82	89	531	finally
    //   103	112	531	finally
    //   120	129	531	finally
    //   140	151	531	finally
    //   159	169	531	finally
    //   180	193	531	finally
    //   201	214	531	finally
    //   222	243	531	finally
    //   251	260	531	finally
    //   268	277	531	finally
    //   339	352	531	finally
    //   360	373	531	finally
    //   393	403	531	finally
    //   37	47	539	java/io/IOException
    //   47	56	552	java/io/IOException
    //   64	74	562	java/io/IOException
    //   82	89	562	java/io/IOException
    //   103	112	562	java/io/IOException
    //   120	129	562	java/io/IOException
  }
  
  private boolean hasFrontCamera(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
  }
  
  private void hideLoading()
  {
    this.mBridge.hideLoading();
  }
  
  private void respGetVideo(String paramString, long paramLong, LocalMediaInfo paramLocalMediaInfo, BridgeInfo paramBridgeInfo)
  {
    if (paramLocalMediaInfo == null)
    {
      this.mBridge.responseCancel(paramBridgeInfo.callbackId, "chooseVideo", null);
      return;
    }
    if (!TextUtils.isEmpty(paramLocalMediaInfo.thumbnailPath))
    {
      handleJsCallBack(paramString, paramLong, paramLocalMediaInfo, paramBridgeInfo);
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new VideoJsProxyDefault.6(this, paramString, paramLocalMediaInfo, paramLong, paramBridgeInfo));
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
    //   6: ifnonnull +17 -> 23
    //   9: ldc 23
    //   11: ldc_w 560
    //   14: invokestatic 562	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: iload_3
    //   18: istore 4
    //   20: iload 4
    //   22: ireturn
    //   23: aload_2
    //   24: ifnonnull +13 -> 37
    //   27: ldc 23
    //   29: ldc_w 564
    //   32: invokestatic 562	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_0
    //   38: getfield 102	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   41: ldc_w 282
    //   44: invokeinterface 288 2 0
    //   49: checkcast 282	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   52: ldc_w 566
    //   55: invokevirtual 569	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getTmpPath	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 5
    //   60: new 167	java/io/File
    //   63: dup
    //   64: aload 5
    //   66: invokespecial 570	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: astore 10
    //   71: aload 10
    //   73: invokevirtual 573	java/io/File:exists	()Z
    //   76: ifeq +9 -> 85
    //   79: aload 10
    //   81: invokevirtual 576	java/io/File:delete	()Z
    //   84: pop
    //   85: new 578	java/io/FileOutputStream
    //   88: dup
    //   89: aload 10
    //   91: invokespecial 579	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore 6
    //   96: new 581	java/io/BufferedOutputStream
    //   99: dup
    //   100: aload 6
    //   102: sipush 4096
    //   105: invokespecial 584	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   108: astore 9
    //   110: aload 9
    //   112: astore 8
    //   114: aload 6
    //   116: astore 7
    //   118: aload_1
    //   119: getstatic 590	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   122: bipush 100
    //   124: aload 9
    //   126: invokevirtual 596	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   129: istore_3
    //   130: aload 9
    //   132: astore 8
    //   134: aload 6
    //   136: astore 7
    //   138: aload 9
    //   140: invokevirtual 599	java/io/BufferedOutputStream:flush	()V
    //   143: aload 9
    //   145: astore 8
    //   147: aload 6
    //   149: astore 7
    //   151: aload 10
    //   153: invokevirtual 343	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: astore_1
    //   157: aload 9
    //   159: astore 8
    //   161: aload 6
    //   163: astore 7
    //   165: aload_2
    //   166: aload_0
    //   167: getfield 102	com/tencent/qqmini/miniapp/proxy/VideoJsProxyDefault:mMiniAppContext	Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   170: ldc_w 282
    //   173: invokeinterface 288 2 0
    //   178: checkcast 282	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   181: aload_1
    //   182: invokevirtual 535	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getWxFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   185: putfield 430	com/tencent/qqmini/sdk/launcher/utils/LocalMediaInfo:thumbnailPath	Ljava/lang/String;
    //   188: aload 6
    //   190: ifnull +8 -> 198
    //   193: aload 6
    //   195: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   198: aload 9
    //   200: ifnull +273 -> 473
    //   203: aload 9
    //   205: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   208: aload_1
    //   209: astore_2
    //   210: iload_3
    //   211: istore 4
    //   213: invokestatic 229	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   216: ifeq -196 -> 20
    //   219: ldc 23
    //   221: new 130	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 603
    //   231: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_2
    //   235: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 345	com/tencent/qqmini/sdk/launcher/log/QMLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: iload_3
    //   245: ireturn
    //   246: astore_2
    //   247: aload_2
    //   248: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   251: goto -53 -> 198
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   259: aload_1
    //   260: astore_2
    //   261: goto -51 -> 210
    //   264: astore_2
    //   265: aconst_null
    //   266: astore 7
    //   268: aconst_null
    //   269: astore 6
    //   271: aload 5
    //   273: astore_1
    //   274: aload 7
    //   276: astore 5
    //   278: aload 5
    //   280: astore 8
    //   282: aload 6
    //   284: astore 7
    //   286: invokestatic 229	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   289: ifeq +20 -> 309
    //   292: aload 5
    //   294: astore 8
    //   296: aload 6
    //   298: astore 7
    //   300: ldc 23
    //   302: ldc_w 606
    //   305: aload_2
    //   306: invokestatic 532	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   309: aload 6
    //   311: ifnull +8 -> 319
    //   314: aload 6
    //   316: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   319: aload_1
    //   320: astore_2
    //   321: iload 4
    //   323: istore_3
    //   324: aload 5
    //   326: ifnull -116 -> 210
    //   329: aload 5
    //   331: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   334: aload_1
    //   335: astore_2
    //   336: iload 4
    //   338: istore_3
    //   339: goto -129 -> 210
    //   342: astore_2
    //   343: aload_2
    //   344: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   347: aload_1
    //   348: astore_2
    //   349: iload 4
    //   351: istore_3
    //   352: goto -142 -> 210
    //   355: astore_2
    //   356: aload_2
    //   357: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   360: goto -41 -> 319
    //   363: astore_1
    //   364: aconst_null
    //   365: astore 8
    //   367: aconst_null
    //   368: astore 6
    //   370: aload 6
    //   372: ifnull +8 -> 380
    //   375: aload 6
    //   377: invokevirtual 600	java/io/FileOutputStream:close	()V
    //   380: aload 8
    //   382: ifnull +8 -> 390
    //   385: aload 8
    //   387: invokevirtual 601	java/io/BufferedOutputStream:close	()V
    //   390: aload_1
    //   391: athrow
    //   392: astore_2
    //   393: aload_2
    //   394: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   397: goto -17 -> 380
    //   400: astore_2
    //   401: aload_2
    //   402: invokevirtual 604	java/io/IOException:printStackTrace	()V
    //   405: goto -15 -> 390
    //   408: astore_1
    //   409: aconst_null
    //   410: astore 8
    //   412: goto -42 -> 370
    //   415: astore_1
    //   416: aload 7
    //   418: astore 6
    //   420: goto -50 -> 370
    //   423: astore_2
    //   424: aconst_null
    //   425: astore 7
    //   427: aload 5
    //   429: astore_1
    //   430: aload 7
    //   432: astore 5
    //   434: goto -156 -> 278
    //   437: astore_2
    //   438: aload 5
    //   440: astore_1
    //   441: aload 9
    //   443: astore 5
    //   445: goto -167 -> 278
    //   448: astore_2
    //   449: aload 5
    //   451: astore_1
    //   452: iload_3
    //   453: istore 4
    //   455: aload 9
    //   457: astore 5
    //   459: goto -181 -> 278
    //   462: astore_2
    //   463: iload_3
    //   464: istore 4
    //   466: aload 9
    //   468: astore 5
    //   470: goto -192 -> 278
    //   473: aload_1
    //   474: astore_2
    //   475: goto -265 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	VideoJsProxyDefault
    //   0	478	1	paramBitmap	Bitmap
    //   0	478	2	paramLocalMediaInfo	LocalMediaInfo
    //   4	460	3	bool1	boolean
    //   1	464	4	bool2	boolean
    //   58	411	5	localObject1	Object
    //   94	325	6	localObject2	Object
    //   116	315	7	localObject3	Object
    //   112	299	8	localObject4	Object
    //   108	359	9	localBufferedOutputStream	java.io.BufferedOutputStream
    //   69	83	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   193	198	246	java/io/IOException
    //   203	208	254	java/io/IOException
    //   85	96	264	java/lang/Exception
    //   329	334	342	java/io/IOException
    //   314	319	355	java/io/IOException
    //   85	96	363	finally
    //   375	380	392	java/io/IOException
    //   385	390	400	java/io/IOException
    //   96	110	408	finally
    //   118	130	415	finally
    //   138	143	415	finally
    //   151	157	415	finally
    //   165	188	415	finally
    //   286	292	415	finally
    //   300	309	415	finally
    //   96	110	423	java/lang/Exception
    //   118	130	437	java/lang/Exception
    //   138	143	448	java/lang/Exception
    //   151	157	448	java/lang/Exception
    //   165	188	462	java/lang/Exception
  }
  
  private void showLoading(String paramString)
  {
    this.mBridge.showLoading(paramString);
  }
  
  private void startCompress(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean, BridgeInfo paramBridgeInfo)
  {
    for (;;)
    {
      try
      {
        i = paramLocalMediaInfo.path.lastIndexOf(".");
        if (i < 0)
        {
          str = "";
          if (paramLocalMediaInfo.path.contains(" ")) {
            copyExecutor.execute(new VideoJsProxyDefault.4(this, paramLocalMediaInfo, str, paramBridgeInfo, paramBoolean));
          }
        }
        else
        {
          str = paramLocalMediaInfo.path.substring(i + 1);
          continue;
        }
        str = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath(str);
        localObject = new File(str);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (paramLocalMediaInfo.mediaWidth > 3000) {
          break label254;
        }
        if (paramLocalMediaInfo.mediaHeight <= 3000) {
          break label248;
        }
      }
      catch (Exception paramLocalMediaInfo)
      {
        String str;
        Object localObject;
        QMLog.e("VideoJsProxyImpl", "startCompress=e=" + paramLocalMediaInfo.getMessage());
        this.mBridge.responseFail(paramBridgeInfo.callbackId, paramBridgeInfo.eventName, null, paramLocalMediaInfo.getMessage());
        return;
      }
      localObject = new VideoCompress.Option();
      ((VideoCompress.Option)localObject).crf = 29;
      ((VideoCompress.Option)localObject).targetEncoding = VideoCompress.TargetEncoding.x264;
      ((VideoCompress.Option)localObject).targetFrameRate = 20;
      if (paramBoolean) {
        ((VideoCompress.Option)localObject).scale = i;
      }
      execVideoCompress(paramLocalMediaInfo, str, (VideoCompress.Option)localObject, paramBridgeInfo);
      return;
      label248:
      int i = 2;
      continue;
      label254:
      i = 4;
    }
  }
  
  private void updateLoading(String paramString)
  {
    this.mBridge.updateLoading(paramString);
  }
  
  public void chooseVideo(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    Log.i("VideoJsProxyImpl", "chooseVideo");
    for (;;)
    {
      JSONArray localJSONArray;
      boolean bool1;
      boolean bool2;
      BridgeInfo localBridgeInfo;
      try
      {
        paramString2 = new JSONObject(paramString2);
        localJSONArray = paramString2.optJSONArray("sourceType");
        bool1 = paramString2.optBoolean("compressed");
        bool2 = paramString2.optString("camera").equals("front");
        localBridgeInfo = new BridgeInfo();
        localBridgeInfo.callbackId = paramInt;
        localBridgeInfo.eventName = paramString1;
        if (localJSONArray.length() == 0)
        {
          this.mBridge.responseFail(paramInt, paramString1, null, "fail sourceType error");
          return;
        }
        if (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.opt(i);
          if ((localObject.equals("album")) || (localObject.equals("camera"))) {
            break label330;
          }
          QMLog.e("VideoJsProxyImpl", "API_CHOOSE_VIDEO sourceType error. " + localJSONArray.opt(i));
          this.mBridge.responseFail(paramInt, paramString1, null, "fail sourceType error");
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        paramActivity.printStackTrace();
        this.mBridge.responseFail(paramInt, paramString1, null, paramActivity.getMessage());
        return;
      }
      QMLog.d("VideoJsPlugin", "sourceType: " + localJSONArray + " length: " + localJSONArray.length());
      i = paramString2.optInt("maxDuration");
      if (localJSONArray.length() == 2)
      {
        AppBrandTask.runTaskOnUiThread(new VideoJsProxyDefault.1(this, paramActivity, i, bool1, bool2, localBridgeInfo));
        return;
      }
      if ("camera".equals(localJSONArray.optString(0)))
      {
        goToCamera(paramActivity, i, bool1, bool2, localBridgeInfo);
        return;
      }
      goToPic(paramActivity, i, bool1, localBridgeInfo);
      return;
      label330:
      i += 1;
    }
  }
  
  public void create(IMiniAppContext paramIMiniAppContext)
  {
    Log.i("VideoJsProxyImpl", "create");
  }
  
  public void destroy()
  {
    Log.i("VideoJsProxyImpl", "destroy");
    super.destroy();
  }
  
  public String getPath(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    paramUri = alld.query(paramContext.getContentResolver(), paramUri, new String[] { "_data" }, null, null, null);
    paramContext = localObject;
    if (paramUri != null)
    {
      int i = paramUri.getColumnIndexOrThrow("_data");
      paramUri.moveToFirst();
      paramContext = paramUri.getString(i);
    }
    return paramContext;
  }
  
  public void saveVideoToPhotosAlbum(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Log.i("VideoJsProxyImpl", "saveVideoToPhotosAlbum");
    try
    {
      paramString2 = new JSONObject(paramString2).optString("filePath");
      if (StringUtil.isEmpty(paramString2))
      {
        this.mBridge.responseFail(paramInt, paramString1, null, "fail file not exists");
        return;
      }
      if (FileUtils.saveVideoToAlbum(paramActivity, ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(paramString2), getSaveVideoFilePath()))
      {
        this.mBridge.responseOk(paramInt, paramString1, null);
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
      this.mBridge.responseFail(paramInt, paramString1, null, paramActivity.getMessage());
      return;
    }
    this.mBridge.responseFail(paramInt, paramString1, null, "fail filePath invalid");
  }
  
  public static class BridgeInfo
  {
    int callbackId;
    String eventName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault
 * JD-Core Version:    0.7.0.1
 */