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
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
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
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.a;
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
public class pog
{
  public static String TAG = "Q.qqstory.publish.upload.VideoCompositeHelper";
  private boolean aAW;
  
  static
  {
    try
    {
      ram.d(TAG, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.Jq());
      int i = VideoEnvironment.a("AVCodec", null, true);
      ram.d(TAG, "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry)
  {
    sqo.b localb = new sqo.b(940006, "");
    String str = paramPublishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
    if ((str.isEmpty()) || (!rox.fileExistsAndNotEmpty(str))) {
      return localb.getCode();
    }
    rox.deleteFile(paramPublishVideoEntry.mLocalRawVideoDir);
    int n = paramPublishVideoEntry.backgroundMusicDuration / 1000;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    aqcu.decodeFile(str, localOptions);
    int i = ankt.SCREEN_WIDTH;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = alwy.iN(i);
    int m = alwy.iN((int)(k / f));
    int j = k;
    i = m;
    if (m > ayyh.eNn)
    {
      j = alwy.iN((int)(k * ayyh.eNn / m));
      i = ayyh.eNn;
    }
    sqo.a().a(str, paramPublishVideoEntry.mLocalRawVideoDir, String.valueOf(n), j, i, false, 0, new poh(this, localb, paramPublishVideoEntry));
    rb("convertImageToVideo ");
    return localb.getCode();
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    aniq.bQi = (int)paramPublishVideoEntry.recordTime;
    aniq.dHk = paramPublishVideoEntry.recordFrames;
    aniq.bsT = paramPublishVideoEntry.saveMode;
    aniq.dFO = 0;
    aniq.dHo = 0;
    aniq.dFI = paramPublishVideoEntry.videoMaxrate;
    aniq.dFJ = paramPublishVideoEntry.videoMinrate;
    aniq.dHt = 0;
    if (paramPublishVideoEntry.businessId == 2) {}
    for (i = 0;; i = 1)
    {
      aniq.dHn = i;
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
        label286:
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
        ram.w(TAG, "version = %d", new Object[] { Integer.valueOf(k) });
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
        ram.b(TAG, "this is part video encode start %d end %d, audio start %d end %d", Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l2));
        l4 = l6;
        l6 = l2;
        if ((paramPublishVideoEntry.hwEncodeRecordVideo) || (TextUtils.isEmpty(paramPublishVideoEntry.mIFrameVideoPath)) || (!rox.rename(paramPublishVideoEntry.mIFrameVideoPath, paramString))) {
          break label686;
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
        break label286;
      }
      if (j == 0) {
        i = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
      }
      localObject = new File(paramString);
      localObject = paramPublishVideoEntry.videoUploadTempDir + "rotate_" + ((File)localObject).getName();
      if (n(paramString, (String)localObject) == 0)
      {
        ram.w(TAG, "EncodeLocalVideo: Change need rotation. inputVideoPath = " + paramString + " rotateFilePath = " + (String)localObject);
        rox.moveFile((String)localObject, paramString);
      }
      k = VideoEnvironment.Jr();
      if (k <= 28) {
        break label633;
      }
      ram.w(TAG, "version is %d", new Object[] { Integer.valueOf(k) });
      l2 = rox.getFileSizes(paramString);
      ram.d(TAG, "file size %d, file %s", Long.valueOf(l2), paramString);
      k = i;
      if (l2 > 2097152L)
      {
        k = i;
        if (j == 0)
        {
          k = i;
          if (rox.fB(paramString))
          {
            aniq.dHt = 1;
            i = aniq.dFI;
            aniq.dFI = 1677720;
            k = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
            l1 = rox.getFileSizes(paramString);
            ram.w(TAG, "fix bitrate file size %d, orig bitrate:%d, file %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), paramString });
            aniq.dHt = 0;
            aniq.dFI = i;
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
      paramInt2 = n(paramString3, paramPublishVideoEntry);
      if (paramInt2 == 0)
      {
        ram.w(TAG, "EncodeLocalVideo: Change need rotation. inputVideoPath=%s  rotateFilePath=%s", new Object[] { paramString1, paramPublishVideoEntry });
        rox.moveFile(paramPublishVideoEntry, paramString3);
      }
    }
    else
    {
      return paramInt1;
    }
    ram.e(TAG, "EncodeLocalVideo: not rotate retcode =" + paramInt2);
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
        rox.fB(paramString);
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
      i = e(paramString, str, i);
      if (axvu.dwO) {
        axvu.g.ay(2, System.currentTimeMillis() - l);
      }
      if (i != 0) {
        break;
      }
      ram.w(TAG, "set moov in front of file success. targetMergedTempMp4 = " + str);
      rox.moveFile(str, paramString);
      j = i;
    } while (!AudioHelper.aCi());
    long l = System.currentTimeMillis();
    if (!paramPublishVideoEntry.isCancel) {
      i = poj.bc(paramString);
    }
    if (paramPublishVideoEntry.isCancel) {
      i = -22;
    }
    if (i == 0) {
      ram.w(TAG, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
    }
    for (;;)
    {
      j = i;
      if (!axvu.dwO) {
        break;
      }
      axvu.g.ay(3, System.currentTimeMillis() - l);
      return i;
      ram.w(TAG, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
      ram.d(TAG, "set moov in front of file failed targetFile = " + paramString);
      i = j;
      break label182;
      ram.e(TAG, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
    }
  }
  
  private static int a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    psr localpsr = (psr)psx.a(10);
    int m = ((Integer)localpsr.c("key_encode_crf", Integer.valueOf(23))).intValue();
    int i = aniq.dFK;
    int j = aniq.dFL;
    int k = aniq.dFM;
    int n = ((Integer)localpsr.c("key_encode_qmax", Integer.valueOf(aniq.dFK))).intValue();
    int i1 = ((Integer)localpsr.c("key_encode_qmin", Integer.valueOf(aniq.dFL))).intValue();
    int i2 = ((Integer)localpsr.c("key_encode_qdiff", Integer.valueOf(aniq.dFM))).intValue();
    aniq.dHm = m;
    aniq.dFK = 35;
    aniq.dFL = i1;
    aniq.dFM = i2;
    ram.w(TAG, "story encode param crf=%d, qmax=%d->%d, qmin=%d->%d, qdiff=>%d->%d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2) });
    try
    {
      paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
      paramString1.PW(false);
      paramString1.CN(false);
      paramString1.PY(paramBoolean);
      paramString1.d(paramLong1, paramLong2, paramLong3, paramLong4);
      if (paramArrayOfByte != null) {
        paramString1.q(paramArrayOfByte, paramInt);
      }
      paramString1.run();
      paramInt = paramString1.errorCode;
      return paramInt;
    }
    finally
    {
      aniq.dHm = 23;
      aniq.dFK = i;
      aniq.dFL = j;
      aniq.dFM = k;
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    ram.w(TAG, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    Object localObject = new ayyh.a(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    ((ayyh.a)localObject).TV(paramPublishVideoEntry.hwBitrateMode);
    if (paramBoolean) {
      ((ayyh.a)localObject).eUt();
    }
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      ((ayyh.a)localObject).afP(8);
      ram.d(TAG, "codec high profile is enable when story video encode");
    }
    if (psr.IM())
    {
      ram.w(TAG, "story debug mode is enable");
      localObject = (psr)psx.a(10);
      i = ((Integer)((psr)localObject).c("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
      int j = ((Integer)((psr)localObject).c("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
      paramBoolean = ((Boolean)((psr)localObject).c("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
      ayyh.a locala = new ayyh.a(i * 1000, paramPublishVideoEntry);
      locala.eUt();
      locala.TV(j);
      localObject = locala;
      if (paramBoolean)
      {
        locala.afP(8);
        localObject = locala;
      }
    }
    int i = new ayyh().a(paramString1, paramString2, (ayyh.a)localObject, paramPublishVideoEntry);
    l = SystemClock.elapsedRealtime() - l;
    ram.w(TAG, "[videoSynthesis]generate files|first step cost:" + l / 1000.0D);
    if (axvu.dwO) {
      axvu.g.ay(0, l);
    }
    return i;
  }
  
  @NonNull
  public static PublishVideoEntry a(String paramString)
  {
    Object localObject1 = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((QQStoryEntityManagerFactory)localObject1).verifyAuthentication();
    Object localObject2 = ((QQStoryEntityManagerFactory)localObject1).createEntityManager();
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
  
  private pog.d a(PublishVideoEntry paramPublishVideoEntry)
  {
    pog.d locald = new pog.d(-1, "");
    String str1 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
    String str2 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
    if (aqmr.isEmpty(str1))
    {
      locald.setCode(0);
      locald.setMessage("don't need to download Music");
      return locald;
    }
    str2 = atao.m.cGy + str2 + rqj.gr(str1);
    paramPublishVideoEntry.backgroundMusicPath = str2;
    if (FileUtil.checkFileExist(str2))
    {
      locald.setCode(0);
      locald.setMessage("needDownloadMusic and the file exist");
      return locald;
    }
    axro localaxro = (axro)axov.a().c(8);
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.setPath(str2);
    localMusicItemInfo.mUrl = str1;
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_song_name", "unknown name");
    if (!localaxro.a(localMusicItemInfo, new poi(this, paramPublishVideoEntry, locald, str1)))
    {
      locald.setCode(-1);
      locald.setMessage("needDownloadMusic cant startDownload maybe path is null or the music has downloaded");
      return locald;
    }
    rb("needAndStartDownloadMusic");
    return locald;
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString1, String paramString2)
  {
    if (aazd.a(paramString1, paramString2, paramPublishVideoEntry) != 0)
    {
      ram.w(TAG, "adjustBitrate: errcode" + paramInt);
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        localFile.delete();
      }
      rox.copyFile(paramString1, paramString2);
      paramPublishVideoEntry.useSrcFile = true;
    }
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = false; bool; bool = ((Boolean)((psr)psx.a(10)).c("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true))).booleanValue())
    {
      int j = new ankn().W(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
      int i = j;
      if (j != 0)
      {
        i = j;
        if (j != 942014)
        {
          ram.w(TAG, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
          i = o(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
        }
      }
      return i;
    }
    return o(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, int paramInt4)
  {
    if (!rox.fileExistsAndNotEmpty(paramString1)) {
      return 940007;
    }
    File localFile = new File(paramString1);
    paramString2 = paramString2 + "compressed_" + localFile.getName();
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("HUAWEI NXT-AL10")) && (!Build.MODEL.equalsIgnoreCase("HUAWEI MT7-TL00")))
    {
      bool = true;
      if (!bool) {
        ram.e(TAG, "encode local video incompatible: model = " + Build.MODEL + " compatible = " + bool);
      }
      paramPublishVideoEntry = new pog.b(paramPublishVideoEntry, paramString2, paramInt3, paramInt1, paramInt2, paramBoolean, true, paramInt4);
      anli localanli = new anli();
      if ((!bool) || (!localanli.a(localFile, paramPublishVideoEntry, true)) || (paramPublishVideoEntry.e != null)) {
        break label214;
      }
      if (m(paramString2, paramString3) != 0) {
        break label203;
      }
      rox.fB(paramString2);
    }
    for (;;)
    {
      return 0;
      bool = false;
      break;
      label203:
      rox.moveFile(paramString2, paramString3);
    }
    label214:
    paramPublishVideoEntry = new Object();
    paramString2 = new AtomicInteger(942009);
    try
    {
      rqj.a(BaseApplicationImpl.getApplication(), paramString1, paramInt1, paramInt2 - paramInt1, paramInt3, paramBoolean, paramString3, new pog.a(paramPublishVideoEntry, paramString2, 1));
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
      ram.w(TAG, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943001;
    }
    catch (FFmpegCommandAlreadyRunningException paramPublishVideoEntry)
    {
      ram.w(TAG, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943002;
    }
    catch (InterruptedException paramPublishVideoEntry)
    {
      ram.w(TAG, "Wait encode video exception:" + paramPublishVideoEntry);
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
    if (!rox.fileExistsAndNotEmpty(str1)) {
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
        if (this.aAW)
        {
          a(paramPublishVideoEntry, i, str1, str2);
          i = 0;
        }
      }
    }
    for (;;)
    {
      ram.w(TAG, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
      long l2 = getDurationOfVideo(paramPublishVideoEntry.mLocalRawVideoDir);
      l1 = SystemClock.elapsedRealtime();
      int j;
      if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (rox.fileExistsAndNotEmpty(paramPublishVideoEntry.backgroundMusicPath))) {
        j = 1;
      }
      AudioEncoder.a locala;
      for (;;)
      {
        if ((!paramPublishVideoEntry.isMuteRecordVoice) && ((j == 0) || (paramPublishVideoEntry.isMixOriginal)) && (!TextUtils.isEmpty(paramPublishVideoEntry.mAudioFilePath)) && (!paramPublishVideoEntry.isLocalPublish))
        {
          if (!rox.fileExistsAndNotEmpty(paramPublishVideoEntry.mAudioFilePath))
          {
            ram.w(TAG, "audio not exist");
            rox.moveFile(str2, paramString);
            return 0;
            rox.copyFile(str1, str2);
            paramPublishVideoEntry.useSrcFile = true;
            break;
            return i;
            j = 0;
            continue;
          }
          ram.w(TAG, "trim audio");
          localObject = paramPublishVideoEntry.videoUploadTempDir + l1 + "_segment_mc_audio";
          if (!paramPublishVideoEntry.isCancel) {
            i = ambc.a(paramPublishVideoEntry.mAudioFilePath, (String)localObject, paramPublishVideoEntry.videoRangeStart * 1.0F / (float)l2, paramPublishVideoEntry.videoRangeEnd * 1.0F / (float)l2);
          }
          if (paramPublishVideoEntry.isCancel) {
            return -17;
          }
          if (i != 0)
          {
            ram.w(TAG, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            rar.b("publish_story", "clip_audio", 1, i, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            rox.moveFile(str2, paramString);
            return 0;
          }
          j = AudioEncoder.el((String)localObject);
          if (j != 0)
          {
            ram.w(TAG, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            rar.b("publish_story", "clip_audio", 1, j, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            rox.moveFile(str2, paramString);
            return 0;
          }
          ram.w(TAG, "audio to mp4");
          str1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          if (paramPublishVideoEntry.saveMode <= 5)
          {
            i = paramPublishVideoEntry.saveMode;
            locala = AudioEncoder.a(null, null, i);
            locala.cez = str1;
            locala.cey = ((String)localObject);
            if (paramPublishVideoEntry.isCancel) {
              break label1045;
            }
          }
        }
      }
      label1045:
      for (i = AudioEncoder.a(locala);; i = j)
      {
        if (paramPublishVideoEntry.isCancel) {
          i = -21;
        }
        if (i != 0)
        {
          rox.fB(str1);
          ram.w(TAG, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
          i = 0;
          break;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        ram.w(TAG, "video audio mp4");
        l2 = SystemClock.elapsedRealtime();
        rox.fB(str3);
        if (!paramPublishVideoEntry.isCancel) {
          i = ankf.c(str2, str1, str3, 0);
        }
        if (paramPublishVideoEntry.isCancel)
        {
          rox.fB(str1);
          rox.fB(str3);
          return -18;
        }
        ram.w(TAG, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        if (i != 0)
        {
          ram.w(TAG, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
        }
        l1 = SystemClock.elapsedRealtime() - l1;
        ram.b(TAG, "mediacodec encode audio time cost=%s", Long.valueOf(l1));
        if (axvu.dwO) {
          axvu.g.ay(1, l1);
        }
        for (paramPublishVideoEntry = str3;; paramPublishVideoEntry = str2)
        {
          rox.moveFile(paramPublishVideoEntry, paramString);
          return i;
        }
      }
    }
  }
  
  public static void b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry.businessId == 2)
    {
      ram.d(TAG, "deleteVideoCache ignore because business id is qq");
      return;
    }
    if ((!paramPublishVideoEntry.isLocalPublish) && (!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      if (paramPublishVideoEntry.hasFragments) {
        break label139;
      }
      c(paramPublishVideoEntry);
    }
    for (;;)
    {
      if (paramPublishVideoEntry.isPicture) {
        QQStoryContext.a().getApplication().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
      }
      rox.fA(paramPublishVideoEntry.videoUploadTempDir);
      ram.w(TAG, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
      return;
      label139:
      p(paramPublishVideoEntry.fakeVid, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC);
      if (q(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        ram.w(TAG, "groupId=%s all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
        c(paramPublishVideoEntry);
      }
      else
      {
        ram.w(TAG, "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
      }
    }
  }
  
  private static void c(PublishVideoEntry paramPublishVideoEntry)
  {
    if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
    {
      rox.fA(paramPublishVideoEntry.mLocalRawVideoDir);
      ram.w(TAG, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    rox.fA(paramPublishVideoEntry);
    ram.w(TAG, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
  }
  
  private static int e(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(953005);
    long l = System.currentTimeMillis();
    ram.d(TAG, "setMoovAndTimeStamp start!");
    try
    {
      rqj.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramInt, new pog.a(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        ram.b(TAG, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - l));
        paramInt = localAtomicInteger.get();
        return paramInt;
      }
      finally {}
      return 953004;
    }
    catch (IOException paramString1)
    {
      ram.w(TAG, "Wait encode video exception:" + paramString1);
      return 945002;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      ram.w(TAG, "Wait encode video exception:" + paramString1);
      return 953003;
    }
    catch (InterruptedException paramString1)
    {
      ram.w(TAG, "Wait encode video exception:" + paramString1);
    }
  }
  
  /* Error */
  private boolean eZ(String paramString)
  {
    // Byte code:
    //   0: new 15	pog$d
    //   3: dup
    //   4: iconst_m1
    //   5: ldc_w 1004
    //   8: invokespecial 613	pog$d:<init>	(ILjava/lang/String;)V
    //   11: astore 4
    //   13: getstatic 34	pog:TAG	Ljava/lang/String;
    //   16: ldc_w 1006
    //   19: invokestatic 1009	ram:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 720	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 16
    //   27: if_icmpge +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 1010	pog$d:getCode	()I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: iconst_0
    //   41: ireturn
    //   42: new 1012	android/media/MediaExtractor
    //   45: dup
    //   46: invokespecial 1013	android/media/MediaExtractor:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 1016	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 1019	android/media/MediaExtractor:getTrackCount	()I
    //   62: if_icmpge +29 -> 91
    //   65: aload_3
    //   66: iload_2
    //   67: invokevirtual 1023	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   70: ldc_w 1025
    //   73: invokevirtual 1030	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc_w 1032
    //   79: invokevirtual 1035	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +23 -> 105
    //   85: aload 4
    //   87: iconst_0
    //   88: invokevirtual 624	pog$d:setCode	(I)V
    //   91: aload_3
    //   92: invokevirtual 1038	android/media/MediaExtractor:release	()V
    //   95: aload 4
    //   97: invokevirtual 1010	pog$d:getCode	()I
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
    //   114: invokevirtual 1039	java/io/IOException:printStackTrace	()V
    //   117: aload_3
    //   118: invokevirtual 1038	android/media/MediaExtractor:release	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 1038	android/media/MediaExtractor:release	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	pog
    //   0	130	1	paramString	String
    //   56	53	2	i	int
    //   49	76	3	localMediaExtractor	android.media.MediaExtractor
    //   11	85	4	locald	pog.d
    // Exception table:
    //   from	to	target	type
    //   50	55	112	java/io/IOException
    //   57	91	112	java/io/IOException
    //   50	55	123	finally
    //   57	91	123	finally
    //   113	117	123	finally
  }
  
  private int f(String paramString1, String paramString2, int paramInt)
  {
    ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] encode video file is too big, so need to compress to:" + paramInt);
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    long l1 = 0L;
    str = paramString2 + ".temp.mp4";
    for (;;)
    {
      try
      {
        ram.i(TAG, "compressVideoWithBitrate!");
        rqj.b(paramString2, str, paramInt, new pog.a(localObject1, localAtomicInteger, 1));
      }
      catch (IOException localIOException)
      {
        ram.w(TAG, "Wait encode video exception:" + localIOException);
        paramInt = 943001;
        continue;
      }
      catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
      {
        ram.w(TAG, "Wait encode video exception:" + localFFmpegCommandAlreadyRunningException);
        paramInt = 943002;
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        ram.w(TAG, "Wait encode video exception:" + localInterruptedException);
        paramInt = 943003;
        continue;
        aqhq.deleteFile(str);
        int i = 0;
        continue;
      }
      try
      {
        localObject1.wait(180000L);
        paramInt = localAtomicInteger.get();
        ram.i(TAG, "compressVideoWithBitrate end!");
        if (paramInt == 0)
        {
          aqhq.deleteFile(paramString2);
          aqhq.rename(str, paramString2);
          l1 = rox.getFileSize(paramString2);
          i = rpv.bl(paramString2);
          ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] ffmpeg compress encode video file size to:" + l1 + " video bitrate to:" + i);
          l2 = System.currentTimeMillis() - l2;
          ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramString1 + " compressVideoByFFMPEG end errorCode:" + paramInt + " cost time=" + l2);
          rar.b("video_improve", "compress_video_2", 0, paramInt, new String[] { String.valueOf(i), String.valueOf(l2), String.valueOf(l1) });
          return paramInt;
        }
      }
      finally {}
    }
  }
  
  public static long getDurationOfVideo(String paramString)
  {
    if (!rox.checkFileExist(paramString)) {}
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
  
  private static int m(String paramString1, String paramString2)
  {
    return e(paramString1, paramString2, -1);
  }
  
  /* Error */
  private int n(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 75	java/lang/Object:<init>	()V
    //   12: astore 6
    //   14: new 779	java/util/concurrent/atomic/AtomicInteger
    //   17: dup
    //   18: iconst_m1
    //   19: invokespecial 782	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   22: astore 7
    //   24: aload_1
    //   25: invokestatic 1100	rpv:bk	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: iload_3
    //   30: iconst_m1
    //   31: if_icmpne +7 -> 38
    //   34: ldc_w 1101
    //   37: ireturn
    //   38: getstatic 34	pog:TAG	Ljava/lang/String;
    //   41: ldc_w 1103
    //   44: invokestatic 63	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 564	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: invokevirtual 1107	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   53: aload_1
    //   54: iload_3
    //   55: invokestatic 160	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: aload_2
    //   59: new 6	pog$a
    //   62: dup
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_4
    //   68: invokespecial 785	pog$a:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   71: invokestatic 1110	rqj:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lrqi;)V
    //   74: aload 6
    //   76: monitorenter
    //   77: aload 6
    //   79: ldc2_w 789
    //   82: invokevirtual 794	java/lang/Object:wait	(J)V
    //   85: getstatic 34	pog:TAG	Ljava/lang/String;
    //   88: new 36	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 1112
    //   98: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   104: lload 4
    //   106: lsub
    //   107: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 63	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 7
    //   118: invokevirtual 796	java/util/concurrent/atomic/AtomicInteger:get	()I
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
    //   134: getstatic 34	pog:TAG	Ljava/lang/String;
    //   137: new 36	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 1114
    //   147: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 801	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 309	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 1115
    //   163: ireturn
    //   164: astore_1
    //   165: getstatic 34	pog:TAG	Ljava/lang/String;
    //   168: new 36	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 1117
    //   178: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 801	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 309	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: monitorexit
    //   194: ldc_w 1118
    //   197: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	pog
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
  
  private int o(String paramString1, String paramString2)
  {
    int i = 0;
    ram.w(TAG, "encodePicToVideoWithFFmpeg");
    if (!rox.fileExistsAndNotEmpty(paramString1)) {
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
        rqj.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, new pog.a(localObject, localAtomicInteger, 2));
        try
        {
          localObject.wait(300000L);
          int j = localAtomicInteger.get();
          if (j == 0) {
            continue;
          }
          ram.w(TAG, "Compress pic to video failed, trying to compress small pic. encodeRequest.get() = %d", new Object[] { Integer.valueOf(localAtomicInteger.get()) });
          str = paramString1 + ".small.jpeg";
          i = p(paramString1, str);
          if (i != 0)
          {
            ram.e(TAG, "resizeToSmallBitmap failed. nRetCode = " + i);
            return i;
          }
        }
        finally {}
        localAtomicInteger.set(942010);
      }
      catch (IOException paramString1)
      {
        ram.w(TAG, "Wait convert pic exception:" + paramString1);
        return 942001;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        ram.w(TAG, "Wait convert pic exception:" + paramString1);
        return 942002;
      }
      catch (InterruptedException paramString1)
      {
        ram.w(TAG, "Wait convert pic exception:" + paramString1);
        return 942003;
      }
    }
    try
    {
      rqj.a(BaseApplicationImpl.getApplication(), str, paramString2, new pog.a(localObject, localAtomicInteger, 2));
      try
      {
        localObject.wait(300000L);
        ram.w(TAG, "convertPicToVideo end");
        i = localAtomicInteger.get();
        return i;
      }
      finally {}
      return 942003;
    }
    catch (IOException paramString1)
    {
      ram.w(TAG, "Wait convert pic exception:" + paramString1);
      return 942001;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      ram.w(TAG, "Wait convert pic exception:" + paramString1);
      return 942002;
    }
    catch (InterruptedException paramString1)
    {
      ram.w(TAG, "Wait convert pic exception:" + paramString1);
    }
  }
  
  private int p(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = aqcu.decodeFile(paramString1);
    int i;
    if (paramString1 == null)
    {
      ram.e(TAG, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
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
          ram.e(TAG, "No need resize. srcWidth < destWidth, srcWidth = " + m + " destWidth = " + 540);
          return 942006;
        }
        Bitmap localBitmap = rop.b(paramString1, 540, i, false, false);
        if (localBitmap == null)
        {
          ram.e(TAG, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
          return 942005;
        }
        if (!rop.d(localBitmap, paramString2))
        {
          ram.e(TAG, "compressToFile in resizeToSmallBitmap failed");
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
  
  public static boolean p(String paramString, int paramInt)
  {
    EntityManager localEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    paramString = a(paramString);
    paramString.videoProcessState = paramInt;
    return localEntityManager.update(paramString);
  }
  
  public static boolean q(String paramString, int paramInt)
  {
    paramString = a(QQStoryContext.a().getEntityManagerFactory().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
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
  
  private void ra(String paramString)
  {
    try
    {
      notifyAll();
      ram.i(TAG, "[vs_publish_flow]  | " + paramString + " notifyAll() ");
      return;
    }
    finally {}
  }
  
  private void rb(String paramString)
  {
    try
    {
      ram.i(TAG, "[vs_publish_flow]  | " + paramString + " wait() ");
      wait(340000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ram.i(TAG, "[vs_publish_flow]  | " + paramString + " wait InterruptedException");
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, pog.e parame)
  {
    boolean bool = false;
    ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " start mergeMusic");
    if ((TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) || (ayyh.a(paramPublishVideoEntry)) || ((paramPublishVideoEntry.useSrcFile) && (!paramPublishVideoEntry.isMuteRecordVoice) && (!paramPublishVideoEntry.isMixOriginal))) {}
    for (int i = 1; i != 0; i = 0)
    {
      rox.moveFile(paramString1, paramString2);
      ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " noMerge end");
      parame.g(0, "", paramString2);
      return;
    }
    pog.d locald = a(paramPublishVideoEntry);
    if ((locald.getCode() != 0) || (!rox.checkFileExist(paramPublishVideoEntry.backgroundMusicPath)))
    {
      ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " needAndStartDownloadMusic failed code:" + locald.getCode() + ",msg:" + locald.getMessage());
      parame.g(941000, locald.getMessage(), "");
      return;
    }
    long l = getDurationOfVideo(paramString1);
    if (l > 0L)
    {
      ram.d(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " duration > 0 need to modify video duration from %d to %d", Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
      paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
    }
    if ((!paramPublishVideoEntry.isLocalPublish) || (eZ(paramString1))) {
      bool = true;
    }
    ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " detect mp4 whether has original Audio:" + bool);
    try
    {
      if ((paramPublishVideoEntry.isMixOriginal) && (bool))
      {
        ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " mixOriginalAndBackgroundMusic start");
        rqj.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramPublishVideoEntry, paramBoolean, new pog.c(paramString1, paramString2, parame));
        return;
      }
    }
    catch (Exception paramString2)
    {
      ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " combine audio throw exception:", paramString2);
      rox.fB(paramString1);
      parame.g(941000, "combine audio exception", "");
      return;
    }
    if ((paramPublishVideoEntry.isLocalPublish) && (paramPublishVideoEntry.isPicture))
    {
      rqj.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, new pog.c(paramString1, paramString2, parame));
      return;
    }
    ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "  recordVideo combinBackgroundMusic start");
    rqj.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new pog.c(paramString1, paramString2, parame));
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull pog.e parame)
  {
    rom.checkNotNull(paramPublishVideoEntry);
    rom.checkNotNull(paramString);
    rom.checkNotNull(parame);
    ram.w(TAG, "composite create thread");
    ThreadManager.newFreeThread(new VideoCompositeHelper.1(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, parame), "StoryVideoComposite", 5).start();
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, pog.e parame)
  {
    ram.i(TAG, "[vs_publish_flow]  doComposite from:" + paramPublishVideoEntry.businessId + "| fakeid:" + paramPublishVideoEntry.fakeVid + " doComposite start");
    paramPublishVideoEntry.isMixOriginal = paramPublishVideoEntry.getBooleanExtra("isMixOriginal", false);
    Object localObject = new File(plr.ate);
    ((File)localObject).mkdirs();
    String str = localObject + File.separator + rox.gl(paramPublishVideoEntry.mLocalRawVideoDir) + ".mp4";
    int i;
    if ((paramPublishVideoEntry.isPicture) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
    {
      ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodePicToVideo start");
      i = b(paramPublishVideoEntry, str);
      if ((i != 942014) && (i != 942007)) {
        break label1071;
      }
      localObject = "outOfMemory file info:" + rop.gk(paramPublishVideoEntry.mLocalRawVideoDir);
      ram.w(TAG, "memory info:%s", new Object[] { MagnifierSDK.a().a().oE() });
    }
    for (;;)
    {
      long l1;
      int j;
      if (i != 0)
      {
        ram.e(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "[improve_video_clear] mediaCodec encode video failed:" + i);
        parame.g(i, (String)localObject, paramString);
        return;
        if (QLog.isColorLevel()) {
          ram.a(TAG, "[improve_video_clear] record video (local file is %s)size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(rox.getFileSize(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(rpv.bl(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
        }
        if ((paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
        {
          ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeLocalVideo start");
          i = a(paramPublishVideoEntry, paramPublishVideoEntry.mLocalRawVideoDir, paramPublishVideoEntry.videoRangeStart, paramPublishVideoEntry.videoRangeEnd, paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry.videoUploadTempDir, str, paramPublishVideoEntry.isMuteRecordVoice, paramPublishVideoEntry.businessId);
          l1 = rox.getFileSize(str);
          int k = rpv.bl(str);
          ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " encode video info file size:" + l1 + " bitrate=" + k + " and upload limit=" + psr.sx());
          if (paramPublishVideoEntry.businessId == 1)
          {
            if (psr.IK())
            {
              j = 1;
              label533:
              rar.b("video_improve", "encode_video", j, i, new String[] { String.valueOf(k), String.valueOf(paramPublishVideoEntry.videoDuration), String.valueOf(l1) });
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
                if (l1 > psr.sx() / 10000 * paramPublishVideoEntry.videoDuration)
                {
                  i = psr.sy();
                  j = f(paramPublishVideoEntry.fakeVid, str, i);
                  if (paramPublishVideoEntry.isCancel)
                  {
                    rox.fB(str);
                    j = -20;
                  }
                }
              }
            }
            if (axvu.dwO) {
              axvu.g.ay(4, System.currentTimeMillis() - l2);
            }
            i = j;
            localObject = "";
          }
        }
        else if (paramPublishVideoEntry.hwEncodeRecordVideo)
        {
          if ((!paramPublishVideoEntry.isLocalPublish) || (!paramPublishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false)) || (aqmr.isEmpty(paramPublishVideoEntry.backgroundMusicPath))) {
            break label1065;
          }
          l1 = System.currentTimeMillis();
          ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo start");
          j = a(paramPublishVideoEntry);
          ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo end errorCode:" + j + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        }
      }
      for (;;)
      {
        i = j;
        if (j != 0) {
          break;
        }
        ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo start");
        l1 = System.currentTimeMillis();
        if (!paramPublishVideoEntry.isCancel) {
          j = a(paramPublishVideoEntry, str, paramBoolean1);
        }
        i = j;
        if (paramPublishVideoEntry.isCancel)
        {
          rox.fB(str);
          i = -14;
        }
        ram.i(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo end errorCode:" + i + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        break;
        ram.w(TAG, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeRecordVideoForAFVF start");
        j = a(paramPublishVideoEntry, str);
        i = j;
        if (j == 0) {
          break;
        }
        i = -13;
        break;
        j = 0;
        break label533;
        a(paramPublishVideoEntry, str, paramString, paramBoolean2, parame);
        return;
        label1065:
        j = 0;
      }
      label1071:
      localObject = "";
    }
  }
  
  public void rZ(boolean paramBoolean)
  {
    this.aAW = paramBoolean;
  }
  
  static class a
    implements rqi
  {
    private final AtomicInteger ah;
    private final Object mLock;
    private final int mTaskType;
    
    public a(Object paramObject, AtomicInteger paramAtomicInteger, int paramInt)
    {
      this.mLock = paramObject;
      this.ah = paramAtomicInteger;
      this.mTaskType = paramInt;
    }
    
    public void onFailure(String paramString)
    {
      ram.w(pog.TAG, "FFMPEGResponseCallback onFailure() mTaskType = " + this.mTaskType + " message = " + paramString);
    }
    
    public void onFinish(boolean paramBoolean)
    {
      int j = 0;
      int k = 0;
      int m = 0;
      int i = 0;
      ram.w(pog.TAG, "FFMPEGResponseCallback onFinish() mTaskType = " + this.mTaskType + " isSuccess = " + paramBoolean);
      synchronized (this.mLock)
      {
        this.mLock.notify();
        switch (this.mTaskType)
        {
        case 1: 
          ram.e(pog.TAG, "Undefined task type mTaskType = " + this.mTaskType);
          throw new RuntimeException("Undefined task in FFMPEGResponseCallback");
        }
      }
      AtomicInteger localAtomicInteger = this.ah;
      if (paramBoolean)
      {
        label152:
        localAtomicInteger.set(i);
        for (;;)
        {
          label158:
          return;
          localAtomicInteger = this.ah;
          if (!paramBoolean) {
            break;
          }
          i = j;
          label174:
          localAtomicInteger.set(i);
        }
        localAtomicInteger = this.ah;
        if (!paramBoolean) {
          break label248;
        }
      }
      label248:
      for (i = k;; i = 945001)
      {
        localAtomicInteger.set(i);
        break label158;
        localAtomicInteger = this.ah;
        if (paramBoolean) {}
        for (i = m;; i = 944004)
        {
          localAtomicInteger.set(i);
          break;
        }
        break;
        i = 943004;
        break label152;
        i = 942004;
        break label174;
      }
    }
    
    public void onProgress(String paramString) {}
    
    public void onStart()
    {
      ram.i(pog.TAG, "onStart() mTaskType = " + this.mTaskType);
    }
    
    public void onSuccess(String paramString)
    {
      ram.i(pog.TAG, "FFMPEGResponseCallback onSuccess() mTaskType = " + this.mTaskType + " message = " + paramString);
    }
  }
  
  public static class b
    implements anli.a
  {
    final String JV;
    boolean aAY;
    int asi;
    int bjA = 1024000;
    int bjB = 25;
    int bjC;
    int bjD;
    int bjE;
    int bjF;
    PublishVideoEntry d;
    public Throwable e;
    boolean isCanceled;
    final long mEndTime;
    boolean mIsMute;
    final long mStartTime;
    
    public b(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
    {
      this.JV = paramString;
      this.bjA = paramInt1;
      this.mStartTime = paramLong1;
      this.mEndTime = paramLong2;
      this.mIsMute = paramBoolean1;
      this.aAY = paramBoolean2;
      this.asi = paramInt2;
      this.d = paramPublishVideoEntry;
    }
    
    public anli.b a(int paramInt1, int paramInt2)
    {
      anli.b localb = new anli.b();
      if (paramInt1 <= paramInt2)
      {
        Object localObject = new File(this.JV);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        localb.as = ((File)localObject);
        localb.videoBitRate = this.bjA;
        localb.scaleRate = (960.0F / paramInt2);
        localb.videoFrameRate = this.bjB;
        localb.cHX = rk();
        localb.beginTime = this.mStartTime;
        localb.endTime = this.mEndTime;
        localb.isMute = this.mIsMute;
        localb.cHY = this.aAY;
        localb.bjC = this.bjC;
        localb.bjD = this.bjD;
        localb.bjE = this.bjE;
        localb.bjF = this.bjF;
        localb.dzA = this.d.hwBitrateMode;
        if (this.d.isNeedHighProfile)
        {
          localb.cHW = true;
          localb.profile = 8;
          localb.level = 512;
        }
        if (psr.IM())
        {
          ram.w(pog.TAG, "story debug mode is enable");
          localObject = (psr)psx.a(10);
          paramInt1 = ((Integer)((psr)localObject).c("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
          paramInt2 = ((Integer)((psr)localObject).c("int_story_debug_bitrate_mode", Integer.valueOf(localb.dzA))).intValue();
          boolean bool = ((Boolean)((psr)localObject).c("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
          localb.dzA = paramInt2;
          localb.videoBitRate = (paramInt1 * 1000);
          if (!bool) {
            break label571;
          }
          localb.cHW = true;
          localb.profile = 8;
        }
      }
      for (localb.level = 512;; localb.level = 512)
      {
        ram.b(pog.TAG, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localb.cHX + ", scaleRate=" + localb.scaleRate + ", videoBitRate=" + localb.videoBitRate + ", videoFrameRate=" + localb.videoFrameRate + ", beginTime=" + localb.beginTime + ", endTime=" + localb.endTime, ", isMute=" + this.mIsMute, ", accurateSeek=" + this.aAY + ", cropX=" + this.bjC + ", cropY=" + this.bjD + ", cropWidth=" + this.bjE + ", cropHeight=" + this.bjF + ",bitrateMode=" + localb.dzA + ",setProfileLevel=" + localb.cHW + ",profile=" + localb.profile + ", level=" + localb.level);
        return localb;
        paramInt2 = paramInt1;
        break;
        label571:
        localb.cHW = false;
        localb.profile = 1;
      }
    }
    
    public void ahK()
    {
      ram.e(pog.TAG, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
    }
    
    public void f(Throwable paramThrowable)
    {
      ram.e(pog.TAG, "HWCompressProcessor, step: HWCompressProcessor onFailed");
      this.e = paramThrowable;
    }
    
    public void onCanceled()
    {
      ram.i(pog.TAG, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
      this.isCanceled = true;
    }
    
    public void onProgress(int paramInt)
    {
      ram.d(pog.TAG, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
    }
    
    public boolean rk()
    {
      boolean bool = false;
      if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
        bool = true;
      }
      while (Build.VERSION.SDK_INT <= 19) {
        return bool;
      }
      return false;
    }
  }
  
  @TargetApi(14)
  public static class c
    extends rpz
  {
    private String atX;
    private String atY;
    private pog.e b;
    private int mErrorCode = 941000;
    private long mStartTime = SystemClock.elapsedRealtime();
    
    public c(String paramString1, String paramString2, pog.e parame)
    {
      this.atX = paramString1;
      this.atY = paramString2;
      this.b = parame;
    }
    
    public void onFailure(String paramString)
    {
      if (paramString.equals(String.valueOf(941001))) {
        this.b.g(941001, paramString, "");
      }
      for (;;)
      {
        ram.w(pog.TAG, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.mErrorCode) });
        rox.fB(this.atX);
        return;
        if (paramString.equals(String.valueOf(941002))) {
          this.b.g(941002, paramString, "");
        } else {
          this.b.g(this.mErrorCode, paramString, "");
        }
      }
    }
    
    public void onSuccess(String paramString)
    {
      ram.b(pog.TAG, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.mStartTime));
      this.b.g(0, "", this.atY);
      rox.fB(this.atX);
    }
    
    public void setErrorCode(int paramInt)
    {
      this.mErrorCode = paramInt;
    }
  }
  
  public static class d
  {
    int code;
    String message;
    
    public d(int paramInt, String paramString)
    {
      this.code = paramInt;
      this.message = paramString;
    }
    
    public int getCode()
    {
      return this.code;
    }
    
    public String getMessage()
    {
      return this.message;
    }
    
    public void setCode(int paramInt)
    {
      this.code = paramInt;
    }
    
    public void setMessage(String paramString)
    {
      this.message = paramString;
    }
  }
  
  public static abstract interface e
  {
    public abstract void g(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pog
 * JD-Core Version:    0.7.0.1
 */