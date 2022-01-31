import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class uku
{
  public static String a;
  private boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoCompositeHelper";
    try
    {
      wsv.b(jdField_a_of_type_JavaLangString, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.a());
      int i = VideoEnvironment.a("AVCodec", null, true);
      wsv.b(jdField_a_of_type_JavaLangString, "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry)
  {
    yvy localyvy = new yvy(940006, "");
    String str = paramPublishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
    if ((str.isEmpty()) || (!xmx.c(str))) {
      return localyvy.a();
    }
    xmx.f(paramPublishVideoEntry.mLocalRawVideoDir);
    int n = paramPublishVideoEntry.backgroundMusicDuration / 1000;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bcwc.a(str, localOptions);
    int i = azgq.a;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = axld.a(i);
    int m = axld.a((int)(k / f));
    int j = k;
    i = m;
    if (m > bnje.a)
    {
      j = axld.a((int)(k * bnje.a / m));
      i = bnje.a;
    }
    yvv.a().a(str, paramPublishVideoEntry.mLocalRawVideoDir, String.valueOf(n), j, i, false, 0, new ukv(this, localyvy, paramPublishVideoEntry));
    b("convertImageToVideo ");
    return localyvy.a();
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    azds.y = (int)paramPublishVideoEntry.recordTime;
    azds.z = paramPublishVideoEntry.recordFrames;
    azds.J = paramPublishVideoEntry.saveMode;
    azds.x = 0;
    azds.E = 0;
    azds.r = paramPublishVideoEntry.videoMaxrate;
    azds.s = paramPublishVideoEntry.videoMinrate;
    azds.K = 0;
    if (paramPublishVideoEntry.businessId == 2) {}
    for (i = 0;; i = 1)
    {
      azds.D = i;
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
        wsv.d(jdField_a_of_type_JavaLangString, "version = %d", new Object[] { Integer.valueOf(k) });
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
        wsv.b(jdField_a_of_type_JavaLangString, "this is part video encode start %d end %d, audio start %d end %d", Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l2));
        l4 = l6;
        l6 = l2;
        if ((paramPublishVideoEntry.hwEncodeRecordVideo) || (TextUtils.isEmpty(paramPublishVideoEntry.mIFrameVideoPath)) || (!xmx.a(paramPublishVideoEntry.mIFrameVideoPath, paramString))) {
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
        wsv.d(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: Change need rotation. inputVideoPath = " + paramString + " rotateFilePath = " + (String)localObject);
        xmx.b((String)localObject, paramString);
      }
      k = VideoEnvironment.b();
      if (k <= 28) {
        break label632;
      }
      wsv.d(jdField_a_of_type_JavaLangString, "version is %d", new Object[] { Integer.valueOf(k) });
      l2 = xmx.c(paramString);
      wsv.b(jdField_a_of_type_JavaLangString, "file size %d, file %s", Long.valueOf(l2), paramString);
      k = i;
      if (l2 > 2097152L)
      {
        k = i;
        if (j == 0)
        {
          k = i;
          if (xmx.g(paramString))
          {
            azds.K = 1;
            i = azds.r;
            azds.r = 1677720;
            k = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
            l1 = xmx.c(paramString);
            wsv.d(jdField_a_of_type_JavaLangString, "fix bitrate file size %d, orig bitrate:%d, file %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), paramString });
            azds.K = 0;
            azds.r = i;
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
        wsv.d(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: Change need rotation. inputVideoPath=%s  rotateFilePath=%s", new Object[] { paramString1, paramPublishVideoEntry });
        xmx.b(paramPublishVideoEntry, paramString3);
      }
    }
    else
    {
      return paramInt1;
    }
    wsv.e(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: not rotate retcode =" + paramInt2);
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
        xmx.g(paramString);
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
      if (blun.c) {
        blun.g.a(2, System.currentTimeMillis() - l);
      }
      if (i != 0) {
        break;
      }
      wsv.d(jdField_a_of_type_JavaLangString, "set moov in front of file success. targetMergedTempMp4 = " + str);
      xmx.b(str, paramString);
      j = i;
    } while (!AudioHelper.a());
    long l = System.currentTimeMillis();
    if (!paramPublishVideoEntry.isCancel) {
      i = ulc.a(paramString);
    }
    if (paramPublishVideoEntry.isCancel) {
      i = -22;
    }
    if (i == 0) {
      wsv.d(jdField_a_of_type_JavaLangString, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
    }
    for (;;)
    {
      j = i;
      if (!blun.c) {
        break;
      }
      blun.g.a(3, System.currentTimeMillis() - l);
      return i;
      wsv.d(jdField_a_of_type_JavaLangString, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
      wsv.b(jdField_a_of_type_JavaLangString, "set moov in front of file failed targetFile = " + paramString);
      i = j;
      break label182;
      wsv.e(jdField_a_of_type_JavaLangString, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
    }
  }
  
  private static int a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    urk localurk = (urk)urr.a(10);
    int m = ((Integer)localurk.b("key_encode_crf", Integer.valueOf(23))).intValue();
    int i = azds.t;
    int j = azds.u;
    int k = azds.v;
    int n = ((Integer)localurk.b("key_encode_qmax", Integer.valueOf(azds.t))).intValue();
    int i1 = ((Integer)localurk.b("key_encode_qmin", Integer.valueOf(azds.u))).intValue();
    int i2 = ((Integer)localurk.b("key_encode_qdiff", Integer.valueOf(azds.v))).intValue();
    azds.C = m;
    azds.t = 35;
    azds.u = i1;
    azds.v = i2;
    wsv.d(jdField_a_of_type_JavaLangString, "story encode param crf=%d, qmax=%d->%d, qmin=%d->%d, qdiff=>%d->%d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2) });
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
      azds.C = 23;
      azds.t = i;
      azds.u = j;
      azds.v = k;
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
    wsv.b(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp start!");
    try
    {
      xpc.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramInt, new ukx(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        wsv.a(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - l));
        paramInt = localAtomicInteger.get();
        return paramInt;
      }
      finally {}
      return 953004;
    }
    catch (IOException paramString1)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
      return 945002;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
      return 953003;
    }
    catch (InterruptedException paramString1)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    wsv.d(jdField_a_of_type_JavaLangString, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    Object localObject = new bnjg(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    ((bnjg)localObject).b(paramPublishVideoEntry.hwBitrateMode);
    if (paramBoolean) {
      ((bnjg)localObject).a();
    }
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      ((bnjg)localObject).c(8);
      wsv.b(jdField_a_of_type_JavaLangString, "codec high profile is enable when story video encode");
    }
    if (urk.e())
    {
      wsv.d(jdField_a_of_type_JavaLangString, "story debug mode is enable");
      localObject = (urk)urr.a(10);
      i = ((Integer)((urk)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
      int j = ((Integer)((urk)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
      paramBoolean = ((Boolean)((urk)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
      bnjg localbnjg = new bnjg(i * 1000, paramPublishVideoEntry);
      localbnjg.a();
      localbnjg.b(j);
      localObject = localbnjg;
      if (paramBoolean)
      {
        localbnjg.c(8);
        localObject = localbnjg;
      }
    }
    int i = new bnje().a(paramString1, paramString2, (bnjg)localObject, paramPublishVideoEntry);
    l = SystemClock.elapsedRealtime() - l;
    wsv.d(jdField_a_of_type_JavaLangString, "[videoSynthesis]generate files|first step cost:" + l / 1000.0D);
    if (blun.c) {
      blun.g.a(0, l);
    }
    return i;
  }
  
  public static long a(String paramString)
  {
    if (!xmx.b(paramString)) {}
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
    Object localObject1 = new uqh(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((uqh)localObject1).verifyAuthentication();
    Object localObject2 = ((uqh)localObject1).createEntityManager();
    localObject1 = new PublishVideoEntry();
    localObject2 = a((awbw)localObject2, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
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
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("RAM Info:all=");
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = bdcb.d() / 1024L / 1024L;
      long l2 = bdcb.e() / 1024L / 1024L;
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      float f2 = -1.0F;
      float f1 = f2;
      if (arrayOfMemoryInfo != null)
      {
        f1 = f2;
        if (arrayOfMemoryInfo.length > 0) {
          f1 = arrayOfMemoryInfo[0].getTotalPss() / 1024.0F;
        }
      }
      f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
      float f3 = (float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F;
      float f4 = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      localStringBuilder.append(l1).append("M,avaiable:").append(l2).append("M used:").append(((DecimalFormat)localObject).format(f1)).append("M freeMemory:").append(f2).append("M,appTotalMemory:").append(f3).append("M,maxMemory:").append(f4).append("M, ImgCache:").append(BaseApplicationImpl.sImageCache.size() / 1024 / 1024).append("M,SkinCache:").append(SkinEngine.dumpDrawableCacheMemSize() / 1024L / 1024L).append("M,LeakMonitor=").append(amfn.a().jdField_a_of_type_Boolean);
      localObject = (ArrayList)amfn.jdField_a_of_type_JavaUtilArrayList.clone();
      if (((ArrayList)localObject).size() > 0)
      {
        localStringBuilder.append(",Leaked=[");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append(",");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable) {}
    for (;;)
    {
      localStringBuilder.append("]");
    }
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private ula a(PublishVideoEntry paramPublishVideoEntry)
  {
    ula localula = new ula(-1, "");
    String str1 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
    String str2 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
    if (bdje.a(str1))
    {
      localula.a(0);
      localula.a("don't need to download Music");
      return localula;
    }
    str2 = bhnh.jdField_a_of_type_JavaLangString + str2 + xpc.a(str1);
    paramPublishVideoEntry.backgroundMusicPath = str2;
    if (FileUtil.checkFileExist(str2))
    {
      localula.a(0);
      localula.a("needDownloadMusic and the file exist");
      return localula;
    }
    blpo localblpo = (blpo)blmf.a().c(8);
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.setPath(str2);
    localMusicItemInfo.mUrl = str1;
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_song_name", "unknown name");
    if (!localblpo.a(localMusicItemInfo, new ukw(this, paramPublishVideoEntry, localula, str1)))
    {
      localula.a(-1);
      localula.a("needDownloadMusic cant startDownload maybe path is null or the music has downloaded");
      return localula;
    }
    b("needAndStartDownloadMusic");
    return localula;
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry.businessId == 2)
    {
      wsv.b(jdField_a_of_type_JavaLangString, "deleteVideoCache ignore because business id is qq");
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
      xmx.d(paramPublishVideoEntry.videoUploadTempDir);
      wsv.d(jdField_a_of_type_JavaLangString, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
      return;
      label139:
      a(paramPublishVideoEntry.fakeVid, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC);
      if (b(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        wsv.d(jdField_a_of_type_JavaLangString, "groupId=%s all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
        b(paramPublishVideoEntry);
      }
      else
      {
        wsv.d(jdField_a_of_type_JavaLangString, "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
      }
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString1, String paramString2)
  {
    if (ajyb.a(paramString1, paramString2, paramPublishVideoEntry) != 0)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "adjustBitrate: errcode" + paramInt);
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        localFile.delete();
      }
      xmx.c(paramString1, paramString2);
      paramPublishVideoEntry.useSrcFile = true;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      notifyAll();
      wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " notifyAll() ");
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 779	ula
    //   3: dup
    //   4: iconst_m1
    //   5: ldc_w 951
    //   8: invokespecial 780	ula:<init>	(ILjava/lang/String;)V
    //   11: astore 4
    //   13: getstatic 18	uku:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: ldc_w 953
    //   19: invokestatic 947	wsv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 570	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 16
    //   27: if_icmpge +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 954	ula:a	()I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: iconst_0
    //   41: ireturn
    //   42: new 956	android/media/MediaExtractor
    //   45: dup
    //   46: invokespecial 957	android/media/MediaExtractor:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 958	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 961	android/media/MediaExtractor:getTrackCount	()I
    //   62: if_icmpge +29 -> 91
    //   65: aload_3
    //   66: iload_2
    //   67: invokevirtual 965	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   70: ldc_w 967
    //   73: invokevirtual 972	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc_w 974
    //   79: invokevirtual 977	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +23 -> 105
    //   85: aload 4
    //   87: iconst_0
    //   88: invokevirtual 790	ula:a	(I)V
    //   91: aload_3
    //   92: invokevirtual 978	android/media/MediaExtractor:release	()V
    //   95: aload 4
    //   97: invokevirtual 954	ula:a	()I
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
    //   114: invokevirtual 979	java/io/IOException:printStackTrace	()V
    //   117: aload_3
    //   118: invokevirtual 978	android/media/MediaExtractor:release	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 978	android/media/MediaExtractor:release	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	uku
    //   0	130	1	paramString	String
    //   56	53	2	i	int
    //   49	76	3	localMediaExtractor	android.media.MediaExtractor
    //   11	85	4	localula	ula
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
    awbw localawbw = QQStoryContext.a().a().createEntityManager();
    paramString = a(paramString);
    paramString.videoProcessState = paramInt;
    return localawbw.a(paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = false; bool; bool = ((Boolean)((urk)urr.a(10)).b("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true))).booleanValue())
    {
      int j = new azgh().a(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
      int i = j;
      if (j != 0)
      {
        i = j;
        if (j != 942014)
        {
          wsv.d(jdField_a_of_type_JavaLangString, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
          i = c(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
        }
      }
      return i;
    }
    return c(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, int paramInt4)
  {
    if (!xmx.c(paramString1)) {
      return 940007;
    }
    File localFile = new File(paramString1);
    paramString2 = paramString2 + "compressed_" + localFile.getName();
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("HUAWEI NXT-AL10")) && (!Build.MODEL.equalsIgnoreCase("HUAWEI MT7-TL00")))
    {
      bool = true;
      if (!bool) {
        wsv.e(jdField_a_of_type_JavaLangString, "encode local video incompatible: model = " + Build.MODEL + " compatible = " + bool);
      }
      paramPublishVideoEntry = new uky(paramPublishVideoEntry, paramString2, paramInt3, paramInt1, paramInt2, paramBoolean, true, paramInt4);
      azhl localazhl = new azhl();
      if ((!bool) || (!localazhl.a(localFile, paramPublishVideoEntry, true)) || (paramPublishVideoEntry.a != null)) {
        break label214;
      }
      if (a(paramString2, paramString3) != 0) {
        break label203;
      }
      xmx.g(paramString2);
    }
    for (;;)
    {
      return 0;
      bool = false;
      break;
      label203:
      xmx.b(paramString2, paramString3);
    }
    label214:
    paramPublishVideoEntry = new Object();
    paramString2 = new AtomicInteger(942009);
    try
    {
      xpc.a(BaseApplicationImpl.getApplication(), paramString1, paramInt1, paramInt2 - paramInt1, paramInt3, paramBoolean, paramString3, new ukx(paramPublishVideoEntry, paramString2, 1));
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
      wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943001;
    }
    catch (FFmpegCommandAlreadyRunningException paramPublishVideoEntry)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943002;
    }
    catch (InterruptedException paramPublishVideoEntry)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
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
    if (!xmx.c(str1)) {
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
      wsv.d(jdField_a_of_type_JavaLangString, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
      long l2 = a(paramPublishVideoEntry.mLocalRawVideoDir);
      l1 = SystemClock.elapsedRealtime();
      int j;
      if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (xmx.c(paramPublishVideoEntry.backgroundMusicPath))) {
        j = 1;
      }
      azfn localazfn;
      for (;;)
      {
        if ((!paramPublishVideoEntry.isMuteRecordVoice) && ((j == 0) || (paramPublishVideoEntry.isMixOriginal)) && (!TextUtils.isEmpty(paramPublishVideoEntry.mAudioFilePath)) && (!paramPublishVideoEntry.isLocalPublish))
        {
          if (!xmx.c(paramPublishVideoEntry.mAudioFilePath))
          {
            wsv.d(jdField_a_of_type_JavaLangString, "audio not exist");
            xmx.b(str2, paramString);
            return 0;
            xmx.c(str1, str2);
            paramPublishVideoEntry.useSrcFile = true;
            break;
            return i;
            j = 0;
            continue;
          }
          wsv.d(jdField_a_of_type_JavaLangString, "trim audio");
          localObject = paramPublishVideoEntry.videoUploadTempDir + l1 + "_segment_mc_audio";
          if (!paramPublishVideoEntry.isCancel) {
            i = axsf.a(paramPublishVideoEntry.mAudioFilePath, (String)localObject, paramPublishVideoEntry.videoRangeStart * 1.0F / (float)l2, paramPublishVideoEntry.videoRangeEnd * 1.0F / (float)l2);
          }
          if (paramPublishVideoEntry.isCancel) {
            return -17;
          }
          if (i != 0)
          {
            wsv.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            wta.b("publish_story", "clip_audio", 1, i, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            xmx.b(str2, paramString);
            return 0;
          }
          j = AudioEncoder.a((String)localObject);
          if (j != 0)
          {
            wsv.d(jdField_a_of_type_JavaLangString, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            wta.b("publish_story", "clip_audio", 1, j, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            xmx.b(str2, paramString);
            return 0;
          }
          wsv.d(jdField_a_of_type_JavaLangString, "audio to mp4");
          str1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          if (paramPublishVideoEntry.saveMode <= 5)
          {
            i = paramPublishVideoEntry.saveMode;
            localazfn = AudioEncoder.a(null, null, i);
            localazfn.b = str1;
            localazfn.jdField_a_of_type_JavaLangString = ((String)localObject);
            if (paramPublishVideoEntry.isCancel) {
              break label1045;
            }
          }
        }
      }
      label1045:
      for (i = AudioEncoder.a(localazfn);; i = j)
      {
        if (paramPublishVideoEntry.isCancel) {
          i = -21;
        }
        if (i != 0)
        {
          xmx.g(str1);
          wsv.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
          i = 0;
          break;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        wsv.d(jdField_a_of_type_JavaLangString, "video audio mp4");
        l2 = SystemClock.elapsedRealtime();
        xmx.g(str3);
        if (!paramPublishVideoEntry.isCancel) {
          i = azfu.a(str2, str1, str3, 0);
        }
        if (paramPublishVideoEntry.isCancel)
        {
          xmx.g(str1);
          xmx.g(str3);
          return -18;
        }
        wsv.d(jdField_a_of_type_JavaLangString, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        if (i != 0)
        {
          wsv.d(jdField_a_of_type_JavaLangString, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
        }
        l1 = SystemClock.elapsedRealtime() - l1;
        wsv.a(jdField_a_of_type_JavaLangString, "mediacodec encode audio time cost=%s", Long.valueOf(l1));
        if (blun.c) {
          blun.g.a(1, l1);
        }
        for (paramPublishVideoEntry = str3;; paramPublishVideoEntry = str2)
        {
          xmx.b(paramPublishVideoEntry, paramString);
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
    //   25: invokestatic 1139	xom:a	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: iload_3
    //   30: iconst_m1
    //   31: if_icmpne +7 -> 38
    //   34: ldc_w 1140
    //   37: ireturn
    //   38: getstatic 18	uku:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: ldc_w 1142
    //   44: invokestatic 47	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 473	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: invokevirtual 1146	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   53: aload_1
    //   54: iload_3
    //   55: invokestatic 137	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: aload_2
    //   59: new 475	ukx
    //   62: dup
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_4
    //   68: invokespecial 478	ukx:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   71: invokestatic 1149	xpc:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lxpb;)V
    //   74: aload 6
    //   76: monitorenter
    //   77: aload 6
    //   79: ldc2_w 484
    //   82: invokevirtual 489	java/lang/Object:wait	(J)V
    //   85: getstatic 18	uku:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: new 20	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 1151
    //   98: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokestatic 342	java/lang/System:currentTimeMillis	()J
    //   104: lload 4
    //   106: lsub
    //   107: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 47	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   134: getstatic 18	uku:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   137: new 20	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 1153
    //   147: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 282	wsv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 1154
    //   163: ireturn
    //   164: astore_1
    //   165: getstatic 18	uku:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: new 20	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 1156
    //   178: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 282	wsv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: monitorexit
    //   194: ldc_w 1157
    //   197: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	uku
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
    wsv.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] encode video file is too big, so need to compress to:" + paramInt);
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    long l1 = 0L;
    str = paramString2 + ".temp.mp4";
    for (;;)
    {
      try
      {
        wsv.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate!");
        xpc.a(paramString2, str, paramInt, new ukx(localObject1, localAtomicInteger, 1));
      }
      catch (IOException localIOException)
      {
        wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localIOException);
        paramInt = 943001;
        continue;
      }
      catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
      {
        wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localFFmpegCommandAlreadyRunningException);
        paramInt = 943002;
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        wsv.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localInterruptedException);
        paramInt = 943003;
        continue;
        bdcs.d(str);
        int i = 0;
        continue;
      }
      try
      {
        localObject1.wait(180000L);
        paramInt = localAtomicInteger.get();
        wsv.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate end!");
        if (paramInt == 0)
        {
          bdcs.d(paramString2);
          bdcs.c(str, paramString2);
          l1 = xmx.a(paramString2);
          i = xom.c(paramString2);
          wsv.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] ffmpeg compress encode video file size to:" + l1 + " video bitrate to:" + i);
          l2 = System.currentTimeMillis() - l2;
          wsv.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " compressVideoByFFMPEG end errorCode:" + paramInt + " cost time=" + l2);
          wta.b("video_improve", "compress_video_2", 0, paramInt, new String[] { String.valueOf(i), String.valueOf(l2), String.valueOf(l1) });
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
      xmx.d(paramPublishVideoEntry.mLocalRawVideoDir);
      wsv.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    xmx.d(paramPublishVideoEntry);
    wsv.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
  }
  
  private void b(String paramString)
  {
    try
    {
      wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " wait() ");
      wait(340000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " wait InterruptedException");
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
    wsv.d(jdField_a_of_type_JavaLangString, "encodePicToVideoWithFFmpeg");
    if (!xmx.c(paramString1)) {
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
        xpc.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, new ukx(localObject, localAtomicInteger, 2));
        try
        {
          localObject.wait(300000L);
          int j = localAtomicInteger.get();
          if (j == 0) {
            continue;
          }
          wsv.d(jdField_a_of_type_JavaLangString, "Compress pic to video failed, trying to compress small pic. encodeRequest.get() = %d", new Object[] { Integer.valueOf(localAtomicInteger.get()) });
          str = paramString1 + ".small.jpeg";
          i = d(paramString1, str);
          if (i != 0)
          {
            wsv.e(jdField_a_of_type_JavaLangString, "resizeToSmallBitmap failed. nRetCode = " + i);
            return i;
          }
        }
        finally {}
        localAtomicInteger.set(942010);
      }
      catch (IOException paramString1)
      {
        wsv.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942001;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        wsv.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942002;
      }
      catch (InterruptedException paramString1)
      {
        wsv.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942003;
      }
    }
    try
    {
      xpc.a(BaseApplicationImpl.getApplication(), str, paramString2, new ukx(localObject, localAtomicInteger, 2));
      try
      {
        localObject.wait(300000L);
        wsv.d(jdField_a_of_type_JavaLangString, "convertPicToVideo end");
        i = localAtomicInteger.get();
        return i;
      }
      finally {}
      return 942003;
    }
    catch (IOException paramString1)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
      return 942001;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
      return 942002;
    }
    catch (InterruptedException paramString1)
    {
      wsv.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
    }
  }
  
  private int d(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = bcwc.a(paramString1);
    int i;
    if (paramString1 == null)
    {
      wsv.e(jdField_a_of_type_JavaLangString, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
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
          wsv.e(jdField_a_of_type_JavaLangString, "No need resize. srcWidth < destWidth, srcWidth = " + m + " destWidth = " + 540);
          return 942006;
        }
        Bitmap localBitmap = xmn.b(paramString1, 540, i, false, false);
        if (localBitmap == null)
        {
          wsv.e(jdField_a_of_type_JavaLangString, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
          return 942005;
        }
        if (!xmn.a(localBitmap, paramString2))
        {
          wsv.e(jdField_a_of_type_JavaLangString, "compressToFile in resizeToSmallBitmap failed");
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
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, ulb paramulb)
  {
    boolean bool = false;
    wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " start mergeMusic");
    if ((TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) || (bnje.a(paramPublishVideoEntry)) || ((paramPublishVideoEntry.useSrcFile) && (!paramPublishVideoEntry.isMuteRecordVoice) && (!paramPublishVideoEntry.isMixOriginal))) {}
    for (int i = 1; i != 0; i = 0)
    {
      xmx.b(paramString1, paramString2);
      wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " noMerge end");
      paramulb.a(0, "", paramString2);
      return;
    }
    ula localula = a(paramPublishVideoEntry);
    if ((localula.a() != 0) || (!xmx.b(paramPublishVideoEntry.backgroundMusicPath)))
    {
      wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " needAndStartDownloadMusic failed code:" + localula.a() + ",msg:" + localula.a());
      paramulb.a(941000, localula.a(), "");
      return;
    }
    long l = a(paramString1);
    if (l > 0L)
    {
      wsv.b(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " duration > 0 need to modify video duration from %d to %d", Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
      paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
    }
    if ((!paramPublishVideoEntry.isLocalPublish) || (a(paramString1))) {
      bool = true;
    }
    wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " detect mp4 whether has original Audio:" + bool);
    try
    {
      if ((paramPublishVideoEntry.isMixOriginal) && (bool))
      {
        wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " mixOriginalAndBackgroundMusic start");
        xpc.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramPublishVideoEntry, paramBoolean, new ukz(paramString1, paramString2, paramulb));
        return;
      }
    }
    catch (Exception paramString2)
    {
      wsv.b(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " combine audio throw exception:", paramString2);
      xmx.g(paramString1);
      paramulb.a(941000, "combine audio exception", "");
      return;
    }
    if ((paramPublishVideoEntry.isLocalPublish) && (paramPublishVideoEntry.isPicture))
    {
      xpc.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, new ukz(paramString1, paramString2, paramulb));
      return;
    }
    wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "  recordVideo combinBackgroundMusic start");
    xpc.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new ukz(paramString1, paramString2, paramulb));
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull ulb paramulb)
  {
    xmh.a(paramPublishVideoEntry);
    xmh.a(paramString);
    xmh.a(paramulb);
    wsv.d(jdField_a_of_type_JavaLangString, "composite create thread");
    ThreadManager.newFreeThread(new VideoCompositeHelper.1(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, paramulb), "StoryVideoComposite", 5).start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, ulb paramulb)
  {
    wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  doComposite from:" + paramPublishVideoEntry.businessId + "| fakeid:" + paramPublishVideoEntry.fakeVid + " doComposite start");
    paramPublishVideoEntry.isMixOriginal = paramPublishVideoEntry.getBooleanExtra("isMixOriginal", false);
    Object localObject = new File(ugx.g);
    ((File)localObject).mkdirs();
    String str = localObject + File.separator + xmx.a(paramPublishVideoEntry.mLocalRawVideoDir) + ".mp4";
    int i;
    if ((paramPublishVideoEntry.isPicture) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
    {
      wsv.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodePicToVideo start");
      i = b(paramPublishVideoEntry, str);
      if ((i != 942014) && (i != 942007)) {
        break label1063;
      }
      localObject = "outOfMemory file info:" + xmn.a(paramPublishVideoEntry.mLocalRawVideoDir);
      wsv.d(jdField_a_of_type_JavaLangString, "memory info:%s", new Object[] { a() });
    }
    for (;;)
    {
      long l1;
      int j;
      if (i != 0)
      {
        wsv.e(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "[improve_video_clear] mediaCodec encode video failed:" + i);
        paramulb.a(i, (String)localObject, paramString);
        return;
        if (QLog.isColorLevel()) {
          wsv.a(jdField_a_of_type_JavaLangString, "[improve_video_clear] record video (local file is %s)size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(xmx.a(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(xom.c(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
        }
        if ((paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
        {
          wsv.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeLocalVideo start");
          i = a(paramPublishVideoEntry, paramPublishVideoEntry.mLocalRawVideoDir, paramPublishVideoEntry.videoRangeStart, paramPublishVideoEntry.videoRangeEnd, paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry.videoUploadTempDir, str, paramPublishVideoEntry.isMuteRecordVoice, paramPublishVideoEntry.businessId);
          l1 = xmx.a(str);
          int k = xom.c(str);
          wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " encode video info file size:" + l1 + " bitrate=" + k + " and upload limit=" + urk.c());
          if (paramPublishVideoEntry.businessId == 1)
          {
            if (urk.c())
            {
              j = 1;
              label525:
              wta.b("video_improve", "encode_video", j, i, new String[] { String.valueOf(k), String.valueOf(paramPublishVideoEntry.videoDuration), String.valueOf(l1) });
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
                if (l1 > urk.c() / 10000 * paramPublishVideoEntry.videoDuration)
                {
                  i = urk.d();
                  j = b(paramPublishVideoEntry.fakeVid, str, i);
                  if (paramPublishVideoEntry.isCancel)
                  {
                    xmx.g(str);
                    j = -20;
                  }
                }
              }
            }
            if (blun.c) {
              blun.g.a(4, System.currentTimeMillis() - l2);
            }
            i = j;
            localObject = "";
          }
        }
        else if (paramPublishVideoEntry.hwEncodeRecordVideo)
        {
          if ((!paramPublishVideoEntry.isLocalPublish) || (!paramPublishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false)) || (bdje.a(paramPublishVideoEntry.backgroundMusicPath))) {
            break label1057;
          }
          l1 = System.currentTimeMillis();
          wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo start");
          j = a(paramPublishVideoEntry);
          wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo end errorCode:" + j + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        }
      }
      for (;;)
      {
        i = j;
        if (j != 0) {
          break;
        }
        wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo start");
        l1 = System.currentTimeMillis();
        if (!paramPublishVideoEntry.isCancel) {
          j = a(paramPublishVideoEntry, str, paramBoolean1);
        }
        i = j;
        if (paramPublishVideoEntry.isCancel)
        {
          xmx.g(str);
          i = -14;
        }
        wsv.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo end errorCode:" + i + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        break;
        wsv.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeRecordVideoForAFVF start");
        j = a(paramPublishVideoEntry, str);
        i = j;
        if (j == 0) {
          break;
        }
        i = -13;
        break;
        j = 0;
        break label525;
        a(paramPublishVideoEntry, str, paramString, paramBoolean2, paramulb);
        return;
        label1057:
        j = 0;
      }
      label1063:
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uku
 * JD-Core Version:    0.7.0.1
 */