package com.tencent.biz.qqstory.base.videoupload.task;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import plr;
import poe;
import pon;
import pop;
import poq;
import pox;
import poy;
import poz;
import ppa;
import ppb;
import ppc;
import ppd;
import ppf;
import ppv;
import pty;
import pzo;
import qem;
import ram;
import rar;
import rop;
import rox;
import rqj;

@TargetApi(14)
public class StoryVideoUploadTask
  extends BasePublishTask<pox>
{
  private AtomicInteger aj = new AtomicInteger(0);
  
  public StoryVideoUploadTask(pox parampox)
  {
    super(parampox);
    long l = SystemClock.elapsedRealtime();
    Object localObject1 = parampox.a();
    boolean bool;
    if ((!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodleRawPath)) && (TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))) {
      if (rop.fz(((PublishVideoEntry)localObject1).doodleRawPath))
      {
        parampox.aua = ((PublishVideoEntry)localObject1).doodleRawPath;
        ((PublishVideoEntry)localObject1).getBooleanExtra("is_hw_encode", false);
        bool = ((PublishVideoEntry)localObject1).isLocalPublish;
        if (((PublishVideoEntry)localObject1).businessId == 1) {}
        ((PublishVideoEntry)localObject1).getBooleanExtra("landscape_video", false);
        ((PublishVideoEntry)localObject1).getIntExtra("thumb_rotation", 0);
        ((PublishVideoEntry)localObject1).getBooleanExtra("has_rotate", false);
        if (!bool) {
          break label705;
        }
      }
    }
    for (;;)
    {
      ((PublishVideoEntry)localObject1).doodlePath = ((PublishVideoEntry)localObject1).doodleRawPath;
      Object localObject2 = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
      ((PublishVideoEntry)localObject1).setStatus(1000);
      ((EntityManager)localObject2).persistOrReplace((Entity)localObject1);
      ram.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "compress doodle png take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - l));
      try
      {
        for (;;)
        {
          if (ppf.getBoolean(2131099652).booleanValue()) {
            b(parampox);
          }
          localObject1 = parampox.a().videoUploadTempDir;
          if (localObject1 != null) {
            rox.sG((String)localObject1);
          }
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "detail info:%s", new Object[] { parampox.a() });
          if (!TextUtils.isEmpty(parampox.aug)) {
            ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local thumbnail file exist %b, %s", new Object[] { Boolean.valueOf(rox.checkFileExist(parampox.aug)), parampox.aug });
          }
          localObject1 = parampox.a().backgroundMusicPath;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "video local bg music file exist %b, %s", new Object[] { Boolean.valueOf(rox.checkFileExist((String)localObject1)), localObject1 });
          }
          parampox.Aj = SystemClock.elapsedRealtime();
          poe.a().qW(((pox)this.a).mp());
          if ((TextUtils.isEmpty(parampox.mPollThumbnailLocalPath)) || (!TextUtils.isEmpty(parampox.mPollThumbnailUrl))) {
            break label789;
          }
          localObject1 = new pon(true);
          ((pon)localObject1).path = parampox.mPollThumbnailLocalPath;
          ((pon)localObject1).a(new poy(this, parampox));
          parampox.ms.add(localObject1);
          if ((TextUtils.isEmpty(parampox.mInteractThumbnailLocalPath)) || (!TextUtils.isEmpty(parampox.mInteractThumbnailUrl))) {
            break label800;
          }
          localObject1 = new pon(true);
          ((pon)localObject1).path = parampox.mInteractThumbnailLocalPath;
          ((pon)localObject1).a(new poz(this, parampox));
          parampox.ms.add(localObject1);
          if (!TextUtils.isEmpty(((pox)this.a).vid)) {
            break label811;
          }
          localObject1 = new poq(((pox)this.a).mp(), ((pox)this.a).videoLocalPath);
          ((poq)localObject1).a(new ppa(this));
          parampox.ms.add(localObject1);
          if ((TextUtils.isEmpty(((pox)this.a).videoThumbnailUrl)) && (!TextUtils.isEmpty(((pox)this.a).aug)))
          {
            localObject1 = new pon(false);
            ((pon)localObject1).path = ((pox)this.a).aug;
            ((pon)localObject1).a(new ppb(this));
            parampox.ms.add(localObject1);
          }
          localObject1 = ((pox)this.a).mVideoLinkInfo;
          if ((localObject1 != null) && (((pty)localObject1).styleType == 1) && (((pty)localObject1).bkq != 2))
          {
            localObject2 = new pop(((pty)localObject1).linkUrl);
            ((pty)localObject1).bkq = 1;
            ((pop)localObject2).a(new ppc(this, (pty)localObject1, (pop)localObject2));
            parampox.ms.add(localObject2);
          }
          return;
          label705:
          break;
          if (!TextUtils.isEmpty(((PublishVideoEntry)localObject1).doodlePath))
          {
            ((PublishVideoEntry)localObject1).getBooleanExtra("is_hw_encode", false);
            bool = ((PublishVideoEntry)localObject1).isLocalPublish;
            if (((PublishVideoEntry)localObject1).businessId == 1) {}
            ((PublishVideoEntry)localObject1).getBooleanExtra("landscape_video", false);
            ((PublishVideoEntry)localObject1).getIntExtra("thumb_rotation", 0);
            ((PublishVideoEntry)localObject1).getBooleanExtra("has_rotate", false);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "save file to camera fail", localOutOfMemoryError);
          continue;
          label789:
          ram.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "poll image had uploaded or null");
          continue;
          label800:
          ram.d("Q.qqstory.publish.upload:StoryVideoUploadTask", "interact image had uploaded or null");
          continue;
          label811:
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "video had uploaded");
        }
      }
    }
  }
  
  private void b(pox parampox)
  {
    Object localObject4 = parampox.a();
    Object localObject2;
    if ((parampox.retryTimes == 0) && (((PublishVideoEntry)localObject4).isPicture) && (!((PublishVideoEntry)localObject4).isLocalPublish) && (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).mLocalRawPicPath)))
    {
      localObject2 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).mLocalRawPicPath);
      if (localObject2 == null) {
        ram.e("Q.qqstory.publish.upload:StoryVideoUploadTask", "create video thumb bitmap failed.");
      }
    }
    else
    {
      return;
    }
    Object localObject3;
    Object localObject1;
    if (!TextUtils.isEmpty(((PublishVideoEntry)localObject4).doodlePath))
    {
      localObject3 = SafeBitmapFactory.decodeFile(((PublishVideoEntry)localObject4).doodlePath);
      localObject1 = rop.c((Bitmap)localObject2, (Bitmap)localObject3);
      if (localObject1 != null)
      {
        ((Bitmap)localObject3).recycle();
        ((Bitmap)localObject2).recycle();
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      localObject1 = ((PublishVideoEntry)localObject4).getStringExtra("pl", null);
      if (localObject1 == null) {
        break;
      }
      localObject3 = StoryVideoItem.b.a((String)localObject1);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        Bitmap localBitmap = rqj.a((StoryVideoItem.b)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = rop.c((Bitmap)localObject2, localBitmap);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localBitmap.recycle();
          ((Bitmap)localObject2).recycle();
          localObject1 = localObject3;
        }
      }
      localObject2 = ((PublishVideoEntry)localObject4).getStringExtra("i_l", null);
      if (localObject2 == null) {
        break;
      }
      localObject3 = StoryVideoItem.a.a((String)localObject2);
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject4 = rqj.a((StoryVideoItem.a)localObject3, ((PublishVideoEntry)localObject4).videoWidth, ((PublishVideoEntry)localObject4).videoHeight);
        localObject3 = rop.c((Bitmap)localObject1, (Bitmap)localObject4);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          ((Bitmap)localObject4).recycle();
          ((Bitmap)localObject1).recycle();
          localObject2 = localObject3;
        }
      }
      parampox = qem.k(parampox.vid, true);
      rox.checkDirAndCreate(plr.atc);
      boolean bool = rop.a((Bitmap)localObject2, Bitmap.CompressFormat.PNG, 100, parampox);
      ((Bitmap)localObject2).recycle();
      if (bool)
      {
        ram.b("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera success, %s ", parampox);
        rar.a("video_edit", "pic_save_local", 0, 0, new String[0]);
        rox.broadcastCarmera(QQStoryContext.a().getApplication(), new File(parampox));
        return;
      }
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadTask", "create file to camera failed");
      return;
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
  
  protected void bmg()
  {
    int i = 1;
    poe.a().qY(((pox)this.a).mp());
    if (((pox)this.a).a().publishFrom == 14) {}
    for (boolean bool = true;; bool = false)
    {
      pzo localpzo = new pzo(bool);
      localpzo.vid = ((pox)this.a).vid;
      localpzo.videoUrl = ((pox)this.a).videoUrl;
      localpzo.videoThumbnailUrl = ((pox)this.a).videoThumbnailUrl;
      localpzo.avZ = ((pox)this.a).maskPicUrl;
      localpzo.AC = ((pox)this.a).videoDuration;
      localpzo.label = ((pox)this.a).a().videoLabel;
      localpzo.doodleText = ((pox)this.a).a().videoDoodleDescription;
      localpzo.avY = ((pox)this.a).a().getStringExtra("all_doodle_text", "");
      localpzo.mLocalDate = ((pox)this.a).a().mLocalDate;
      localpzo.timeZoneOffset = ((pox)this.a).a().timeZoneOffset;
      localpzo.createTime = ((pox)this.a).createTime;
      localpzo.videoWidth = ((pox)this.a).videoWidth;
      localpzo.videoHeight = ((pox)this.a).videoHeight;
      localpzo.videoBytes = ((pox)this.a).videoBytes;
      localpzo.awa = ((pox)this.a).a().videoLocationDescription;
      localpzo.awb = ((pox)this.a).a().gpsFilterDescription;
      localpzo.atJsonData = ((pox)this.a).a().atJsonData;
      localpzo.blx = ((pox)this.a).a().publishFrom;
      localpzo.localCreateTime = ((pox)this.a).a().videoCreateTime;
      localpzo.latitude = ((pox)this.a).a().videoLatitude;
      localpzo.longitude = ((pox)this.a).a().videoLongitude;
      localpzo.localCreateCity = ((pox)this.a).a().localCreateCity;
      if (((pox)this.a).a().isPicture) {}
      for (;;)
      {
        localpzo.isPicture = i;
        localpzo.videoType = ((pox)this.a).a().getIntExtra("video_type", 0);
        localpzo.readerConfBytes = ((pox)this.a).a().readerConfBytes;
        localpzo.bC = ((pox)this.a).a().spreadGroupBytes;
        localpzo.awc = ((pox)this.a).a().multiFragmentGroupId;
        localpzo.aCI = ((pox)this.a).a().getBooleanExtra("ignorePersonalPublish", false);
        localpzo.bly = ((pox)this.a).a().getIntExtra("add_video_source", 0);
        localpzo.d = ((pox)this.a).c;
        localpzo.tagInfoBytes = ((pox)this.a).a().tagInfoBytes;
        localpzo.awd = ((pox)this.a).a().getStringExtra("pl", null);
        localpzo.pollThumbnailUrl = ((pox)this.a).mPollThumbnailUrl;
        localpzo.awe = ((pox)this.a).a().getStringExtra("i_l", null);
        localpzo.interactThumbnailUrl = ((pox)this.a).mInteractThumbnailUrl;
        localpzo.aCJ = ((pox)this.a).a().getBooleanExtra("story_sync_qzone", false);
        localpzo.b = ((pox)this.a).mVideoLinkInfo;
        localpzo.awf = ((pox)this.a).a().getStringExtra("game", null);
        localpzo.awg = ((pox)this.a).a().getStringExtra("pk_vid", null);
        JSONObject localJSONObject = ((pox)this.a).a().getJSONExtra("follow_capture_param");
        if (localJSONObject != null)
        {
          localpzo.awh = localJSONObject.optString("vid");
          localpzo.comparedLevel = (localJSONObject.optInt("comparedLevel") + 1);
          localpzo.comparedActivityId = localJSONObject.optInt("comparedActivityId");
        }
        ppv.a().a(localpzo, new ppd(this));
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.task.StoryVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */