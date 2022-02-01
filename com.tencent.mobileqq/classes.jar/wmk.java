import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class wmk
{
  public static String a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoCompositeHelper";
    try
    {
      yuk.b(jdField_a_of_type_JavaLangString, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.a());
      int i = VideoEnvironment.a("AVCodec", null, true);
      yuk.b(jdField_a_of_type_JavaLangString, "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry)
  {
    abbi localabbi = new abbi(940006, "");
    String str = paramPublishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
    if ((str.isEmpty()) || (!zom.c(str))) {
      return localabbi.a();
    }
    zom.f(paramPublishVideoEntry.mLocalRawVideoDir);
    int n = paramPublishVideoEntry.backgroundMusicDuration / 1000;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bhgm.a(str, localOptions);
    int i = bdep.a;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = bbgg.a(i);
    int m = bbgg.a((int)(k / f));
    int j = k;
    i = m;
    if (m > brfv.a)
    {
      j = bbgg.a((int)(k * brfv.a / m));
      i = brfv.a;
    }
    abbf.a().a(str, paramPublishVideoEntry.mLocalRawVideoDir, String.valueOf(n), j, i, false, 0, new wml(this, localabbi, paramPublishVideoEntry));
    b("convertImageToVideo ");
    return localabbi.a();
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    bdbt.y = (int)paramPublishVideoEntry.recordTime;
    bdbt.z = paramPublishVideoEntry.recordFrames;
    bdbt.J = paramPublishVideoEntry.saveMode;
    bdbt.x = 0;
    bdbt.E = 0;
    bdbt.r = paramPublishVideoEntry.videoMaxrate;
    bdbt.s = paramPublishVideoEntry.videoMinrate;
    bdbt.K = 0;
    if (paramPublishVideoEntry.businessId == 2) {}
    for (i = 0;; i = 1)
    {
      bdbt.D = i;
      l8 = -1L;
      l7 = -1L;
      l3 = -1L;
      l2 = -1L;
      l1 = l8;
      l4 = l7;
      l5 = l3;
      l6 = l2;
      if (paramPublishVideoEntry.hasFragments)
      {
        l1 = l8;
        l4 = l7;
        l5 = l3;
        l6 = l2;
        if (TextUtils.isEmpty(paramPublishVideoEntry.fragments)) {}
      }
      try
      {
        localObject = new JSONObject(paramPublishVideoEntry.fragments);
        l1 = ((JSONObject)localObject).optLong("vfFrameIndexStart", -1L);
      }
      catch (JSONException localJSONException1)
      {
        label285:
        int k;
        for (;;)
        {
          Object localObject;
          l6 = l3;
          l5 = l7;
          l1 = l8;
          localJSONException1.printStackTrace();
          l4 = l5;
          l5 = l6;
          l6 = l2;
        }
        yuk.d(jdField_a_of_type_JavaLangString, "version = %d", new Object[] { Integer.valueOf(k) });
        return i;
      }
      try
      {
        l6 = ((JSONObject)localObject).optLong("vfFrameIndexEnd", -1L);
        l4 = l3;
        l3 = l2;
      }
      catch (JSONException localJSONException2)
      {
        l5 = l7;
        l6 = l3;
        break;
      }
      try
      {
        l5 = ((JSONObject)localObject).optLong("afTimeStart", -1L);
        l4 = l5;
        l3 = l2;
        l2 = ((JSONObject)localObject).optLong("afTimeEnd", -1L);
        l4 = l5;
        l3 = l2;
        yuk.b(jdField_a_of_type_JavaLangString, "this is part video encode start %d end %d, audio start %d end %d", Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l2));
        l4 = l6;
        l6 = l2;
        if ((paramPublishVideoEntry.hwEncodeRecordVideo) || (TextUtils.isEmpty(paramPublishVideoEntry.mIFrameVideoPath)) || (!zom.a(paramPublishVideoEntry.mIFrameVideoPath, paramString))) {
          break label685;
        }
        j = 1;
        i = 0;
      }
      catch (JSONException localJSONException3)
      {
        l5 = l6;
        l6 = l4;
        l2 = l3;
        break;
        i = -1;
        j = 0;
        break label285;
      }
      if (j == 0) {
        i = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
      }
      localObject = new File(paramString);
      localObject = paramPublishVideoEntry.videoUploadTempDir + "rotate_" + ((File)localObject).getName();
      if (b(paramString, (String)localObject) == 0)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: Change need rotation. inputVideoPath = " + paramString + " rotateFilePath = " + (String)localObject);
        zom.b((String)localObject, paramString);
      }
      k = VideoEnvironment.b();
      if (k <= 28) {
        break label632;
      }
      yuk.d(jdField_a_of_type_JavaLangString, "version is %d", new Object[] { Integer.valueOf(k) });
      l2 = zom.c(paramString);
      yuk.b(jdField_a_of_type_JavaLangString, "file size %d, file %s", Long.valueOf(l2), paramString);
      k = i;
      if (l2 > 2097152L)
      {
        k = i;
        if (j == 0)
        {
          k = i;
          if (zom.g(paramString))
          {
            bdbt.K = 1;
            i = bdbt.r;
            bdbt.r = 1677720;
            k = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
            l1 = zom.c(paramString);
            yuk.d(jdField_a_of_type_JavaLangString, "fix bitrate file size %d, orig bitrate:%d, file %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), paramString });
            bdbt.K = 0;
            bdbt.r = i;
          }
        }
      }
      return k;
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, int paramInt4)
  {
    paramInt1 = b(paramPublishVideoEntry, paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramBoolean, paramInt4);
    if ((paramInt1 == 0) && (paramPublishVideoEntry.videoNeedRotate))
    {
      paramString2 = new File(paramString3);
      paramPublishVideoEntry = paramPublishVideoEntry.videoUploadTempDir + "rotate_" + paramString2.getName();
      paramInt2 = b(paramString3, paramPublishVideoEntry);
      if (paramInt2 == 0)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: Change need rotation. inputVideoPath=%s  rotateFilePath=%s", new Object[] { paramString1, paramPublishVideoEntry });
        zom.b(paramPublishVideoEntry, paramString3);
      }
    }
    else
    {
      return paramInt1;
    }
    yuk.e(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: not rotate retcode =" + paramInt2);
    return paramInt1;
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    int j = 0;
    String str = paramPublishVideoEntry.videoUploadTempDir + "hwtemp.mp4";
    int i = b(paramPublishVideoEntry, paramString, paramBoolean);
    if (i != 0) {
      j = i;
    }
    label182:
    do
    {
      return j;
      if (paramPublishVideoEntry.isCancel)
      {
        zom.g(paramString);
        return -19;
      }
      l = System.currentTimeMillis();
      int k = -1;
      i = k;
      if (paramPublishVideoEntry.isLocalPublish)
      {
        i = k;
        if (paramPublishVideoEntry.businessId == 14)
        {
          i = k;
          if (paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) {
            i = 0;
          }
        }
      }
      i = a(paramString, str, i);
      if (bpty.c) {
        bpty.g.a(2, System.currentTimeMillis() - l);
      }
      if (i != 0) {
        break;
      }
      yuk.d(jdField_a_of_type_JavaLangString, "set moov in front of file success. targetMergedTempMp4 = " + str);
      zom.b(str, paramString);
      j = i;
    } while (!AudioHelper.a());
    long l = System.currentTimeMillis();
    if (!paramPublishVideoEntry.isCancel) {
      i = wms.a(paramString);
    }
    if (paramPublishVideoEntry.isCancel) {
      i = -22;
    }
    if (i == 0) {
      yuk.d(jdField_a_of_type_JavaLangString, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
    }
    for (;;)
    {
      j = i;
      if (!bpty.c) {
        break;
      }
      bpty.g.a(3, System.currentTimeMillis() - l);
      return i;
      yuk.d(jdField_a_of_type_JavaLangString, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
      yuk.b(jdField_a_of_type_JavaLangString, "set moov in front of file failed targetFile = " + paramString);
      i = j;
      break label182;
      yuk.e(jdField_a_of_type_JavaLangString, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
    }
  }
  
  private static int a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    wta localwta = (wta)wth.a(10);
    int m = ((Integer)localwta.b("key_encode_crf", Integer.valueOf(23))).intValue();
    int i = bdbt.t;
    int j = bdbt.u;
    int k = bdbt.v;
    int n = ((Integer)localwta.b("key_encode_qmax", Integer.valueOf(bdbt.t))).intValue();
    int i1 = ((Integer)localwta.b("key_encode_qmin", Integer.valueOf(bdbt.u))).intValue();
    int i2 = ((Integer)localwta.b("key_encode_qdiff", Integer.valueOf(bdbt.v))).intValue();
    bdbt.C = m;
    bdbt.t = 35;
    bdbt.u = i1;
    bdbt.v = i2;
    yuk.d(jdField_a_of_type_JavaLangString, "story encode param crf=%d, qmax=%d->%d, qmin=%d->%d, qdiff=>%d->%d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2) });
    try
    {
      paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
      paramString1.a(false);
      paramString1.b(false);
      paramString1.d(paramBoolean);
      paramString1.a(paramLong1, paramLong2, paramLong3, paramLong4);
      if (paramArrayOfByte != null) {
        paramString1.a(paramArrayOfByte, paramInt);
      }
      paramString1.run();
      paramInt = paramString1.a;
      return paramInt;
    }
    finally
    {
      bdbt.C = 23;
      bdbt.t = i;
      bdbt.u = j;
      bdbt.v = k;
    }
  }
  
  private static int a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, -1);
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(953005);
    long l = System.currentTimeMillis();
    yuk.b(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp start!");
    try
    {
      zqr.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramInt, new wmn(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        yuk.a(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - l));
        paramInt = localAtomicInteger.get();
        return paramInt;
      }
      finally {}
      return 953004;
    }
    catch (IOException paramString1)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
      return 945002;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
      return 953003;
    }
    catch (InterruptedException paramString1)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    yuk.d(jdField_a_of_type_JavaLangString, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    Object localObject = new brfx(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    ((brfx)localObject).b(paramPublishVideoEntry.hwBitrateMode);
    if (paramBoolean) {
      ((brfx)localObject).a();
    }
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      ((brfx)localObject).c(8);
      yuk.b(jdField_a_of_type_JavaLangString, "codec high profile is enable when story video encode");
    }
    if (wta.e())
    {
      yuk.d(jdField_a_of_type_JavaLangString, "story debug mode is enable");
      localObject = (wta)wth.a(10);
      i = ((Integer)((wta)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
      int j = ((Integer)((wta)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
      paramBoolean = ((Boolean)((wta)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
      brfx localbrfx = new brfx(i * 1000, paramPublishVideoEntry);
      localbrfx.a();
      localbrfx.b(j);
      localObject = localbrfx;
      if (paramBoolean)
      {
        localbrfx.c(8);
        localObject = localbrfx;
      }
    }
    int i = new brfv().a(paramString1, paramString2, (brfx)localObject, paramPublishVideoEntry);
    l = SystemClock.elapsedRealtime() - l;
    yuk.d(jdField_a_of_type_JavaLangString, "[videoSynthesis]generate files|first step cost:" + l / 1000.0D);
    if (bpty.c) {
      bpty.g.a(0, l);
    }
    return i;
  }
  
  public static long a(String paramString)
  {
    if (!zom.b(paramString)) {}
    while (Build.VERSION.SDK_INT < 10) {
      return 0L;
    }
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  @NonNull
  public static PublishVideoEntry a(String paramString)
  {
    Object localObject1 = new wrx(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((wrx)localObject1).verifyAuthentication();
    Object localObject2 = ((wrx)localObject1).createEntityManager();
    localObject1 = new PublishVideoEntry();
    localObject2 = a((EntityManager)localObject2, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((List)localObject2).size() > 0) {
        paramString = (PublishVideoEntry)((List)localObject2).get(0);
      }
    }
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = new PublishVideoEntry();
    }
    return localObject1;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private wmq a(PublishVideoEntry paramPublishVideoEntry)
  {
    wmq localwmq = new wmq(-1, "");
    String str1 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
    String str2 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
    if (bhsr.a(str1))
    {
      localwmq.a(0);
      localwmq.a("don't need to download Music");
      return localwmq;
    }
    str2 = blgc.jdField_a_of_type_JavaLangString + str2 + zqr.a(str1);
    paramPublishVideoEntry.backgroundMusicPath = str2;
    if (FileUtil.checkFileExist(str2))
    {
      localwmq.a(0);
      localwmq.a("needDownloadMusic and the file exist");
      return localwmq;
    }
    bpoz localbpoz = (bpoz)bplq.a().c(8);
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.setPath(str2);
    localMusicItemInfo.mUrl = str1;
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_song_name", "unknown name");
    if (!localbpoz.a(localMusicItemInfo, new wmm(this, paramPublishVideoEntry, localwmq, str1)))
    {
      localwmq.a(-1);
      localwmq.a("needDownloadMusic cant startDownload maybe path is null or the music has downloaded");
      return localwmq;
    }
    b("needAndStartDownloadMusic");
    return localwmq;
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry.businessId == 2)
    {
      yuk.b(jdField_a_of_type_JavaLangString, "deleteVideoCache ignore because business id is qq");
      return;
    }
    if ((!paramPublishVideoEntry.isLocalPublish) && (!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      if (paramPublishVideoEntry.hasFragments) {
        break label139;
      }
      b(paramPublishVideoEntry);
    }
    for (;;)
    {
      if (paramPublishVideoEntry.isPicture) {
        QQStoryContext.a().a().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
      }
      zom.d(paramPublishVideoEntry.videoUploadTempDir);
      yuk.d(jdField_a_of_type_JavaLangString, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
      return;
      label139:
      a(paramPublishVideoEntry.fakeVid, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC);
      if (b(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        yuk.d(jdField_a_of_type_JavaLangString, "groupId=%s all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
        b(paramPublishVideoEntry);
      }
      else
      {
        yuk.d(jdField_a_of_type_JavaLangString, "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
      }
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString1, String paramString2)
  {
    if (amhf.a(paramString1, paramString2, paramPublishVideoEntry) != 0)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "adjustBitrate: errcode" + paramInt);
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        localFile.delete();
      }
      zom.c(paramString1, paramString2);
      paramPublishVideoEntry.useSrcFile = true;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      notifyAll();
      yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " notifyAll() ");
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 641	wmq
    //   3: dup
    //   4: iconst_m1
    //   5: ldc_w 813
    //   8: invokespecial 642	wmq:<init>	(ILjava/lang/String;)V
    //   11: astore 4
    //   13: getstatic 18	wmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: ldc_w 815
    //   19: invokestatic 809	yuk:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 570	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 16
    //   27: if_icmpge +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 816	wmq:a	()I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: iconst_0
    //   41: ireturn
    //   42: new 818	android/media/MediaExtractor
    //   45: dup
    //   46: invokespecial 819	android/media/MediaExtractor:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 820	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 823	android/media/MediaExtractor:getTrackCount	()I
    //   62: if_icmpge +29 -> 91
    //   65: aload_3
    //   66: iload_2
    //   67: invokevirtual 827	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   70: ldc_w 829
    //   73: invokevirtual 834	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc_w 836
    //   79: invokevirtual 839	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +23 -> 105
    //   85: aload 4
    //   87: iconst_0
    //   88: invokevirtual 652	wmq:a	(I)V
    //   91: aload_3
    //   92: invokevirtual 840	android/media/MediaExtractor:release	()V
    //   95: aload 4
    //   97: invokevirtual 816	wmq:a	()I
    //   100: ifeq -62 -> 38
    //   103: iconst_0
    //   104: ireturn
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -52 -> 57
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 841	java/io/IOException:printStackTrace	()V
    //   117: aload_3
    //   118: invokevirtual 840	android/media/MediaExtractor:release	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 840	android/media/MediaExtractor:release	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	wmk
    //   0	130	1	paramString	String
    //   56	53	2	i	int
    //   49	76	3	localMediaExtractor	android.media.MediaExtractor
    //   11	85	4	localwmq	wmq
    // Exception table:
    //   from	to	target	type
    //   50	55	112	java/io/IOException
    //   57	91	112	java/io/IOException
    //   50	55	123	finally
    //   57	91	123	finally
    //   113	117	123	finally
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramString = a(paramString);
    paramString.videoProcessState = paramInt;
    return localEntityManager.update(paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = false; bool; bool = ((Boolean)((wta)wth.a(10)).b("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true))).booleanValue())
    {
      int j = new bdeh().a(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
      int i = j;
      if (j != 0)
      {
        i = j;
        if (j != 942014)
        {
          yuk.d(jdField_a_of_type_JavaLangString, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
          i = c(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
        }
      }
      return i;
    }
    return c(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, int paramInt4)
  {
    if (!zom.c(paramString1)) {
      return 940007;
    }
    File localFile = new File(paramString1);
    paramString2 = paramString2 + "compressed_" + localFile.getName();
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("HUAWEI NXT-AL10")) && (!Build.MODEL.equalsIgnoreCase("HUAWEI MT7-TL00")))
    {
      bool = true;
      if (!bool) {
        yuk.e(jdField_a_of_type_JavaLangString, "encode local video incompatible: model = " + Build.MODEL + " compatible = " + bool);
      }
      paramPublishVideoEntry = new wmo(paramPublishVideoEntry, paramString2, paramInt3, paramInt1, paramInt2, paramBoolean, true, paramInt4);
      bdfk localbdfk = new bdfk();
      if ((!bool) || (!localbdfk.a(localFile, paramPublishVideoEntry, true)) || (paramPublishVideoEntry.a != null)) {
        break label214;
      }
      if (a(paramString2, paramString3) != 0) {
        break label203;
      }
      zom.g(paramString2);
    }
    for (;;)
    {
      return 0;
      bool = false;
      break;
      label203:
      zom.b(paramString2, paramString3);
    }
    label214:
    paramPublishVideoEntry = new Object();
    paramString2 = new AtomicInteger(942009);
    try
    {
      zqr.a(BaseApplicationImpl.getApplication(), paramString1, paramInt1, paramInt2 - paramInt1, paramInt3, paramBoolean, paramString3, new wmn(paramPublishVideoEntry, paramString2, 1));
      try
      {
        paramPublishVideoEntry.wait(180000L);
        paramInt1 = paramString2.get();
        return paramInt1;
      }
      finally {}
      return 943003;
    }
    catch (IOException paramPublishVideoEntry)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943001;
    }
    catch (FFmpegCommandAlreadyRunningException paramPublishVideoEntry)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943002;
    }
    catch (InterruptedException paramPublishVideoEntry)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
    }
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    String str2 = paramPublishVideoEntry.mLocalRawVideoDir;
    boolean bool = paramPublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    String str1;
    if (paramPublishVideoEntry.businessId != 1)
    {
      str1 = str2;
      if (bool) {}
    }
    else
    {
      str1 = str2;
      if (paramPublishVideoEntry.saveMode == 5) {
        str1 = paramPublishVideoEntry.mIFrameVideoPath;
      }
    }
    if (!zom.c(str1)) {
      return 940007;
    }
    str2 = paramPublishVideoEntry.videoUploadTempDir + "_merge_video_x.mp4";
    String str3 = paramPublishVideoEntry.videoUploadTempDir + "_merged_video_x.mp4";
    long l1 = SystemClock.elapsedRealtime();
    int i = 0;
    if (!paramPublishVideoEntry.isCancel) {
      i = a(str1, str2, paramPublishVideoEntry, paramBoolean);
    }
    if (paramPublishVideoEntry.isCancel) {
      i = -15;
    }
    Object localObject;
    if (i != 0) {
      if (i == -1)
      {
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (this.jdField_a_of_type_Boolean)
        {
          a(paramPublishVideoEntry, i, str1, str2);
          i = 0;
        }
      }
    }
    for (;;)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
      long l2 = a(paramPublishVideoEntry.mLocalRawVideoDir);
      l1 = SystemClock.elapsedRealtime();
      int j;
      if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (zom.c(paramPublishVideoEntry.backgroundMusicPath))) {
        j = 1;
      }
      bddn localbddn;
      for (;;)
      {
        if ((!paramPublishVideoEntry.isMuteRecordVoice) && ((j == 0) || (paramPublishVideoEntry.isMixOriginal)) && (!TextUtils.isEmpty(paramPublishVideoEntry.mAudioFilePath)) && (!paramPublishVideoEntry.isLocalPublish))
        {
          if (!zom.c(paramPublishVideoEntry.mAudioFilePath))
          {
            yuk.d(jdField_a_of_type_JavaLangString, "audio not exist");
            zom.b(str2, paramString);
            return 0;
            zom.c(str1, str2);
            paramPublishVideoEntry.useSrcFile = true;
            break;
            return i;
            j = 0;
            continue;
          }
          yuk.d(jdField_a_of_type_JavaLangString, "trim audio");
          localObject = paramPublishVideoEntry.videoUploadTempDir + l1 + "_segment_mc_audio";
          if (!paramPublishVideoEntry.isCancel) {
            i = bbni.a(paramPublishVideoEntry.mAudioFilePath, (String)localObject, paramPublishVideoEntry.videoRangeStart * 1.0F / (float)l2, paramPublishVideoEntry.videoRangeEnd * 1.0F / (float)l2);
          }
          if (paramPublishVideoEntry.isCancel) {
            return -17;
          }
          if (i != 0)
          {
            yuk.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            yup.b("publish_story", "clip_audio", 1, i, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            zom.b(str2, paramString);
            return 0;
          }
          j = AudioEncoder.a((String)localObject);
          if (j != 0)
          {
            yuk.d(jdField_a_of_type_JavaLangString, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            yup.b("publish_story", "clip_audio", 1, j, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            zom.b(str2, paramString);
            return 0;
          }
          yuk.d(jdField_a_of_type_JavaLangString, "audio to mp4");
          str1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          if (paramPublishVideoEntry.saveMode <= 5)
          {
            i = paramPublishVideoEntry.saveMode;
            localbddn = AudioEncoder.a(null, null, i);
            localbddn.b = str1;
            localbddn.jdField_a_of_type_JavaLangString = ((String)localObject);
            if (paramPublishVideoEntry.isCancel) {
              break label1045;
            }
          }
        }
      }
      label1045:
      for (i = AudioEncoder.a(localbddn);; i = j)
      {
        if (paramPublishVideoEntry.isCancel) {
          i = -21;
        }
        if (i != 0)
        {
          zom.g(str1);
          yuk.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
          i = 0;
          break;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        yuk.d(jdField_a_of_type_JavaLangString, "video audio mp4");
        l2 = SystemClock.elapsedRealtime();
        zom.g(str3);
        if (!paramPublishVideoEntry.isCancel) {
          i = bddu.a(str2, str1, str3, 0);
        }
        if (paramPublishVideoEntry.isCancel)
        {
          zom.g(str1);
          zom.g(str3);
          return -18;
        }
        yuk.d(jdField_a_of_type_JavaLangString, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        if (i != 0)
        {
          yuk.d(jdField_a_of_type_JavaLangString, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
        }
        l1 = SystemClock.elapsedRealtime() - l1;
        yuk.a(jdField_a_of_type_JavaLangString, "mediacodec encode audio time cost=%s", Long.valueOf(l1));
        if (bpty.c) {
          bpty.g.a(1, l1);
        }
        for (paramPublishVideoEntry = str3;; paramPublishVideoEntry = str2)
        {
          zom.b(paramPublishVideoEntry, paramString);
          return i;
        }
      }
    }
  }
  
  /* Error */
  private int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 342	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 59	java/lang/Object:<init>	()V
    //   12: astore 6
    //   14: new 461	java/util/concurrent/atomic/AtomicInteger
    //   17: dup
    //   18: iconst_m1
    //   19: invokespecial 465	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   22: astore 7
    //   24: aload_1
    //   25: invokestatic 1009	zqb:a	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: iload_3
    //   30: iconst_m1
    //   31: if_icmpne +7 -> 38
    //   34: ldc_w 1010
    //   37: ireturn
    //   38: getstatic 18	wmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: ldc_w 1012
    //   44: invokestatic 47	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 473	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: invokevirtual 1016	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   53: aload_1
    //   54: iload_3
    //   55: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: aload_2
    //   59: new 475	wmn
    //   62: dup
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_4
    //   68: invokespecial 478	wmn:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   71: invokestatic 1019	zqr:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzqq;)V
    //   74: aload 6
    //   76: monitorenter
    //   77: aload 6
    //   79: ldc2_w 484
    //   82: invokevirtual 489	java/lang/Object:wait	(J)V
    //   85: getstatic 18	wmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: new 20	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 1021
    //   98: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokestatic 342	java/lang/System:currentTimeMillis	()J
    //   104: lload 4
    //   106: lsub
    //   107: invokevirtual 941	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 47	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 7
    //   118: invokevirtual 497	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   121: istore_3
    //   122: aload 6
    //   124: monitorexit
    //   125: iload_3
    //   126: ireturn
    //   127: astore_1
    //   128: aload 6
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: getstatic 18	wmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   137: new 20	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 1023
    //   147: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 282	yuk:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 1024
    //   163: ireturn
    //   164: astore_1
    //   165: getstatic 18	wmk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: new 20	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 1026
    //   178: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 282	yuk:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: monitorexit
    //   194: ldc_w 1027
    //   197: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	wmk
    //   0	198	1	paramString1	String
    //   0	198	2	paramString2	String
    //   28	98	3	i	int
    //   3	102	4	l	long
    //   12	180	6	localObject	Object
    //   22	95	7	localAtomicInteger	AtomicInteger
    // Exception table:
    //   from	to	target	type
    //   77	85	127	finally
    //   85	125	127	finally
    //   128	131	127	finally
    //   165	194	127	finally
    //   47	74	133	java/lang/Exception
    //   77	85	164	java/lang/InterruptedException
  }
  
  private int b(String paramString1, String paramString2, int paramInt)
  {
    yuk.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] encode video file is too big, so need to compress to:" + paramInt);
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    long l1 = 0L;
    str = paramString2 + ".temp.mp4";
    for (;;)
    {
      try
      {
        yuk.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate!");
        zqr.a(paramString2, str, paramInt, new wmn(localObject1, localAtomicInteger, 1));
      }
      catch (IOException localIOException)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localIOException);
        paramInt = 943001;
        continue;
      }
      catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localFFmpegCommandAlreadyRunningException);
        paramInt = 943002;
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localInterruptedException);
        paramInt = 943003;
        continue;
        bhmi.d(str);
        int i = 0;
        continue;
      }
      try
      {
        localObject1.wait(180000L);
        paramInt = localAtomicInteger.get();
        yuk.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate end!");
        if (paramInt == 0)
        {
          bhmi.d(paramString2);
          bhmi.c(str, paramString2);
          l1 = zom.a(paramString2);
          i = zqb.c(paramString2);
          yuk.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] ffmpeg compress encode video file size to:" + l1 + " video bitrate to:" + i);
          l2 = System.currentTimeMillis() - l2;
          yuk.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " compressVideoByFFMPEG end errorCode:" + paramInt + " cost time=" + l2);
          yup.b("video_improve", "compress_video_2", 0, paramInt, new String[] { String.valueOf(i), String.valueOf(l2), String.valueOf(l1) });
          return paramInt;
        }
      }
      finally {}
    }
  }
  
  private static void b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
    {
      zom.d(paramPublishVideoEntry.mLocalRawVideoDir);
      yuk.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    zom.d(paramPublishVideoEntry);
    yuk.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
  }
  
  private void b(String paramString)
  {
    try
    {
      yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " wait() ");
      wait(340000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " wait InterruptedException");
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    paramString = a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (paramString == null) {
      return false;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      if (((PublishVideoEntry)paramString.next()).videoProcessState < paramInt) {
        return false;
      }
    }
    return true;
  }
  
  private int c(String paramString1, String paramString2)
  {
    int i = 0;
    yuk.d(jdField_a_of_type_JavaLangString, "encodePicToVideoWithFFmpeg");
    if (!zom.c(paramString1)) {
      i = 940007;
    }
    Object localObject;
    AtomicInteger localAtomicInteger;
    String str;
    for (;;)
    {
      return i;
      localObject = new Object();
      localAtomicInteger = new AtomicInteger(942010);
      try
      {
        zqr.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, new wmn(localObject, localAtomicInteger, 2));
        try
        {
          localObject.wait(300000L);
          int j = localAtomicInteger.get();
          if (j == 0) {
            continue;
          }
          yuk.d(jdField_a_of_type_JavaLangString, "Compress pic to video failed, trying to compress small pic. encodeRequest.get() = %d", new Object[] { Integer.valueOf(localAtomicInteger.get()) });
          str = paramString1 + ".small.jpeg";
          i = d(paramString1, str);
          if (i != 0)
          {
            yuk.e(jdField_a_of_type_JavaLangString, "resizeToSmallBitmap failed. nRetCode = " + i);
            return i;
          }
        }
        finally {}
        localAtomicInteger.set(942010);
      }
      catch (IOException paramString1)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942001;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942002;
      }
      catch (InterruptedException paramString1)
      {
        yuk.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942003;
      }
    }
    try
    {
      zqr.a(BaseApplicationImpl.getApplication(), str, paramString2, new wmn(localObject, localAtomicInteger, 2));
      try
      {
        localObject.wait(300000L);
        yuk.d(jdField_a_of_type_JavaLangString, "convertPicToVideo end");
        i = localAtomicInteger.get();
        return i;
      }
      finally {}
      return 942003;
    }
    catch (IOException paramString1)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
      return 942001;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
      return 942002;
    }
    catch (InterruptedException paramString1)
    {
      yuk.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
    }
  }
  
  private int d(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = bhgm.a(paramString1);
    int i;
    if (paramString1 == null)
    {
      yuk.e(jdField_a_of_type_JavaLangString, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
      i = 942007;
    }
    do
    {
      do
      {
        return i;
        i = paramString1.getHeight();
        int m = paramString1.getWidth();
        int k = i * 540 / m;
        i = k;
        if (k % 2 != 0) {
          i = k + 1;
        }
        if (m <= 540)
        {
          yuk.e(jdField_a_of_type_JavaLangString, "No need resize. srcWidth < destWidth, srcWidth = " + m + " destWidth = " + 540);
          return 942006;
        }
        Bitmap localBitmap = zoc.b(paramString1, 540, i, false, false);
        if (localBitmap == null)
        {
          yuk.e(jdField_a_of_type_JavaLangString, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
          return 942005;
        }
        if (!zoc.a(localBitmap, paramString2))
        {
          yuk.e(jdField_a_of_type_JavaLangString, "compressToFile in resizeToSmallBitmap failed");
          return 942008;
        }
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        i = j;
      } while (paramString1 == null);
      i = j;
    } while (paramString1.isRecycled());
    paramString1.recycle();
    return 0;
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, wmr paramwmr)
  {
    boolean bool = false;
    yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " start mergeMusic");
    if ((TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) || (brfv.a(paramPublishVideoEntry)) || ((paramPublishVideoEntry.useSrcFile) && (!paramPublishVideoEntry.isMuteRecordVoice) && (!paramPublishVideoEntry.isMixOriginal))) {}
    for (int i = 1; i != 0; i = 0)
    {
      zom.b(paramString1, paramString2);
      yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " noMerge end");
      paramwmr.a(0, "", paramString2);
      return;
    }
    wmq localwmq = a(paramPublishVideoEntry);
    if ((localwmq.a() != 0) || (!zom.b(paramPublishVideoEntry.backgroundMusicPath)))
    {
      yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " needAndStartDownloadMusic failed code:" + localwmq.a() + ",msg:" + localwmq.a());
      paramwmr.a(941000, localwmq.a(), "");
      return;
    }
    long l = a(paramString1);
    if (l > 0L)
    {
      yuk.b(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " duration > 0 need to modify video duration from %d to %d", Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
      paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
    }
    if ((!paramPublishVideoEntry.isLocalPublish) || (a(paramString1))) {
      bool = true;
    }
    yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " detect mp4 whether has original Audio:" + bool);
    try
    {
      if ((paramPublishVideoEntry.isMixOriginal) && (bool))
      {
        yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " mixOriginalAndBackgroundMusic start");
        zqr.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramPublishVideoEntry, paramBoolean, new wmp(paramString1, paramString2, paramwmr));
        return;
      }
    }
    catch (Exception paramString2)
    {
      yuk.b(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " combine audio throw exception:", paramString2);
      zom.g(paramString1);
      paramwmr.a(941000, "combine audio exception", "");
      return;
    }
    if ((paramPublishVideoEntry.isLocalPublish) && (paramPublishVideoEntry.isPicture))
    {
      zqr.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, new wmp(paramString1, paramString2, paramwmr));
      return;
    }
    yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "  recordVideo combinBackgroundMusic start");
    zqr.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new wmp(paramString1, paramString2, paramwmr));
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull wmr paramwmr)
  {
    znw.a(paramPublishVideoEntry);
    znw.a(paramString);
    znw.a(paramwmr);
    yuk.d(jdField_a_of_type_JavaLangString, "composite create thread");
    ThreadManager.newFreeThread(new VideoCompositeHelper.1(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, paramwmr), "StoryVideoComposite", 5).start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, wmr paramwmr)
  {
    yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  doComposite from:" + paramPublishVideoEntry.businessId + "| fakeid:" + paramPublishVideoEntry.fakeVid + " doComposite start");
    paramPublishVideoEntry.isMixOriginal = paramPublishVideoEntry.getBooleanExtra("isMixOriginal", false);
    Object localObject = new File(win.g);
    ((File)localObject).mkdirs();
    String str = localObject + File.separator + zom.a(paramPublishVideoEntry.mLocalRawVideoDir) + ".mp4";
    int i;
    if ((paramPublishVideoEntry.isPicture) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
    {
      yuk.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodePicToVideo start");
      i = b(paramPublishVideoEntry, str);
      if ((i != 942014) && (i != 942007)) {
        break label1071;
      }
      localObject = "outOfMemory file info:" + zoc.a(paramPublishVideoEntry.mLocalRawVideoDir);
      yuk.d(jdField_a_of_type_JavaLangString, "memory info:%s", new Object[] { MagnifierSDK.a().a().b() });
    }
    for (;;)
    {
      long l1;
      int j;
      if (i != 0)
      {
        yuk.e(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "[improve_video_clear] mediaCodec encode video failed:" + i);
        paramwmr.a(i, (String)localObject, paramString);
        return;
        if (QLog.isColorLevel()) {
          yuk.a(jdField_a_of_type_JavaLangString, "[improve_video_clear] record video (local file is %s)size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(zom.a(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(zqb.c(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
        }
        if ((paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
        {
          yuk.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeLocalVideo start");
          i = a(paramPublishVideoEntry, paramPublishVideoEntry.mLocalRawVideoDir, paramPublishVideoEntry.videoRangeStart, paramPublishVideoEntry.videoRangeEnd, paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry.videoUploadTempDir, str, paramPublishVideoEntry.isMuteRecordVoice, paramPublishVideoEntry.businessId);
          l1 = zom.a(str);
          int k = zqb.c(str);
          yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " encode video info file size:" + l1 + " bitrate=" + k + " and upload limit=" + wta.c());
          if (paramPublishVideoEntry.businessId == 1)
          {
            if (wta.c())
            {
              j = 1;
              label533:
              yup.b("video_improve", "encode_video", j, i, new String[] { String.valueOf(k), String.valueOf(paramPublishVideoEntry.videoDuration), String.valueOf(l1) });
            }
          }
          else
          {
            long l2 = System.currentTimeMillis();
            j = i;
            if (i == 0)
            {
              j = i;
              if (paramPublishVideoEntry.videoDuration > 0L)
              {
                j = i;
                if (l1 > wta.c() / 10000 * paramPublishVideoEntry.videoDuration)
                {
                  i = wta.d();
                  j = b(paramPublishVideoEntry.fakeVid, str, i);
                  if (paramPublishVideoEntry.isCancel)
                  {
                    zom.g(str);
                    j = -20;
                  }
                }
              }
            }
            if (bpty.c) {
              bpty.g.a(4, System.currentTimeMillis() - l2);
            }
            i = j;
            localObject = "";
          }
        }
        else if (paramPublishVideoEntry.hwEncodeRecordVideo)
        {
          if ((!paramPublishVideoEntry.isLocalPublish) || (!paramPublishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false)) || (bhsr.a(paramPublishVideoEntry.backgroundMusicPath))) {
            break label1065;
          }
          l1 = System.currentTimeMillis();
          yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo start");
          j = a(paramPublishVideoEntry);
          yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo end errorCode:" + j + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        }
      }
      for (;;)
      {
        i = j;
        if (j != 0) {
          break;
        }
        yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo start");
        l1 = System.currentTimeMillis();
        if (!paramPublishVideoEntry.isCancel) {
          j = a(paramPublishVideoEntry, str, paramBoolean1);
        }
        i = j;
        if (paramPublishVideoEntry.isCancel)
        {
          zom.g(str);
          i = -14;
        }
        yuk.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo end errorCode:" + i + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        break;
        yuk.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeRecordVideoForAFVF start");
        j = a(paramPublishVideoEntry, str);
        i = j;
        if (j == 0) {
          break;
        }
        i = -13;
        break;
        j = 0;
        break label533;
        a(paramPublishVideoEntry, str, paramString, paramBoolean2, paramwmr);
        return;
        label1065:
        j = 0;
      }
      label1071:
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmk
 * JD-Core Version:    0.7.0.1
 */