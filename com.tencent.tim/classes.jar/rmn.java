import android.app.Activity;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.c;
import com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1;
import com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.MusicProviderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rmn
  extends rmm
{
  long Cm;
  private boolean aIQ;
  private MediaFormat b;
  
  private ayby a(int paramInt1, int paramInt2)
  {
    boolean bool1;
    switch (paramInt1)
    {
    default: 
      if (paramInt2 != 102)
      {
        bool1 = true;
        if (paramInt2 == 102) {
          break label161;
        }
      }
      break;
    }
    label161:
    for (boolean bool2 = true;; bool2 = false)
    {
      return new ayby.a().a(false).e(bool1).f(bool2).g(true).h(true).j(true).b(false).k(true).d(false).c(2).b();
      return new ayby.a().a(true).f(false).g(true).h(true).j(true).b(true).k(false).d(false).c(2).b();
      bool1 = false;
      break;
    }
  }
  
  public void a(rmn.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoMerger", 2, "start combine");
    }
    if (parama.mItemList == null) {}
    for (;;)
    {
      return;
      Object localObject2 = new rqt();
      Object localObject1 = new ArrayList(parama.mItemList.size());
      Object localObject5 = new ArrayList(parama.mItemList.size());
      Object localObject3 = (rmf)QQStoryContext.c().getBusinessHandler(1);
      Object localObject6 = new ArrayList();
      Object localObject4 = parama.mItemList.iterator();
      Object localObject7;
      Object localObject8;
      for (boolean bool1 = false; ((Iterator)localObject4).hasNext(); bool1 = bool2)
      {
        localObject7 = (SlideItemInfo)((Iterator)localObject4).next();
        localObject8 = ((rmf)localObject3).b(((SlideItemInfo)localObject7).mSrcPath);
        bool2 = bool1;
        if (localObject8 != null)
        {
          ((List)localObject1).add(((LocalMediaInfo)localObject8).path);
          ((List)localObject6).add(((LocalMediaInfo)localObject8).mAudioPath);
          ((SlideItemInfo)localObject7).aBo = ((LocalMediaInfo)localObject8).path;
          ((SlideItemInfo)localObject7).aBp = ((LocalMediaInfo)localObject8).mAudioPath;
          ((SlideItemInfo)localObject7).hasAudioTrack = ((LocalMediaInfo)localObject8).mHasAudioTrack;
          ((SlideItemInfo)localObject7).mSampleRate = ((LocalMediaInfo)localObject8).mSampleRate;
          ((List)localObject5).add(localObject7);
          bool2 = bool1;
          if (((SlideItemInfo)localObject7).mediaType == 1)
          {
            if (((SlideItemInfo)localObject7).hasAudioTrack) {
              bool1 = true;
            }
            QLog.i("VideoMerger", 1, "mergeRunnable hasAudioTrack=" + ((SlideItemInfo)localObject7).hasAudioTrack + " mSampleRate:" + ((SlideItemInfo)localObject7).mSampleRate);
            bool2 = bool1;
          }
        }
      }
      if (a(parama))
      {
        a(9, "", null, null, null, parama);
        return;
      }
      if (this.b == null) {
        if (((rmf)localObject3).getMediaFormat() != null)
        {
          this.b = ((rmf)localObject3).getMediaFormat();
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "transHandler.getMediaFormat");
          }
        }
      }
      boolean bool3;
      for (;;)
      {
        if (parama.a != null) {
          parama.a.tU(bool1);
        }
        localObject4 = rmc.nc();
        localObject3 = (String)localObject4 + ".dat";
        if (!bool1) {
          break label770;
        }
        bool3 = rqu.S((List)localObject5);
        QLog.i("VideoMerger", 1, "clip audio success=" + bool3);
        bool2 = bool3;
        if (!bool3) {
          break label627;
        }
        ((List)localObject6).clear();
        localObject7 = ((List)localObject5).iterator();
        while (((Iterator)localObject7).hasNext()) {
          ((List)localObject6).add(((SlideItemInfo)((Iterator)localObject7).next()).aBp);
        }
        if (((List)localObject1).size() > 0)
        {
          this.b = rmi.a((String)((List)localObject1).get(0));
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatFromVideo, videoPath : " + (String)((List)localObject1).get(0));
          }
        }
        if (this.b == null)
        {
          this.b = rmi.a();
          if (QLog.isColorLevel())
          {
            QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatDefault");
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("VideoMerger", 2, "mVideoFormat not null");
            }
          }
        }
      }
      label770:
      for (boolean bool2 = ((rqt)localObject2).c((List)localObject6, (String)localObject3);; bool2 = true)
      {
        label627:
        QLog.i("VideoMerger", 1, "merge audio success " + bool2);
        if (!bool2) {
          break;
        }
        bool3 = rqu.R((List)localObject5);
        QLog.i("VideoMerger", 1, "clip video success=" + bool3);
        ((List)localObject1).clear();
        localObject5 = ((List)localObject5).iterator();
        for (;;)
        {
          bool2 = bool3;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject6 = (SlideItemInfo)((Iterator)localObject5).next();
          if (((SlideItemInfo)localObject6).mediaType == 0) {
            ((List)localObject1).add(((SlideItemInfo)localObject6).aBo);
          }
          ((List)localObject1).add(((SlideItemInfo)localObject6).aBo);
        }
      }
      localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        QLog.i("VideoMerger", 1, "merge print video begin:  path: " + (String)localObject6);
      }
      long l1;
      long l2;
      if (bool2)
      {
        l1 = System.currentTimeMillis();
        bool2 = ((rqt)localObject2).a((List)localObject1, (String)localObject4, 720, 1280, this.b);
        l2 = System.currentTimeMillis();
        QLog.i("VideoMerger", 1, "merge video result " + bool2 + " cost: " + (l2 - l1) + " ms");
        label919:
        QLog.i("VideoMerger", 1, "merge video result " + bool2);
        localObject5 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject5).path = ((String)localObject4);
        ((LocalMediaInfo)localObject5).mMimeType = "video";
        if (!AudioHelper.aCA()) {
          break label1937;
        }
        ((LocalMediaInfo)localObject5).mTransferPosList = ((rqt)localObject2).b((List)localObject1, (String)localObject4);
        localObject2 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      }
      try
      {
        ((MediaScanner)localObject2).buildAndUpdateVideo((LocalMediaInfo)localObject5);
        if (bool2)
        {
          l1 = System.currentTimeMillis();
          l2 = this.Cm;
          rar.g("actAlbumTime", new String[] { l1 - l2 + "", parama.mItemList.size() + "" });
          localObject6 = new CameraCaptureView.VideoCaptureResult();
          ((CameraCaptureView.VideoCaptureResult)localObject6).videoFrameCount = ((List)localObject1).size();
          if (bool1)
          {
            ((CameraCaptureView.VideoCaptureResult)localObject6).audioDataFilePath = ((String)localObject3);
            ((CameraCaptureView.VideoCaptureResult)localObject6).videoMp4FilePath = ((String)localObject4);
            localObject1 = null;
            localObject2 = parama.mContext.getIntent();
            if (localObject2 != null) {
              localObject1 = axom.e((Intent)localObject2);
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Bundle();
            }
            localObject3 = parama.mContext.getIntent().getExtras();
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = new Bundle();
            }
            localObject3 = parama.mContext.getIntent();
            i = ((Intent)localObject3).getIntExtra("entrance_type", 99);
            j = ((Intent)localObject3).getIntExtra("shareGroupType", 0);
            localObject7 = ((Intent)localObject3).getStringExtra("shareGroupId");
            localObject8 = ((Intent)localObject3).getStringExtra("shareGroupName");
            bool1 = ((Intent)localObject3).getBooleanExtra("ignorePersonalPublish", false);
            bool3 = ((Intent)localObject3).getBooleanExtra("PhotoConst.IS_FROM_EDIT", false);
            ((Bundle)localObject1).putBoolean("ignorePersonalPublish", bool1);
            ((Bundle)localObject1).putInt("shareGroupType", j);
            ((Bundle)localObject1).putString("shareGroupId", (String)localObject7);
            ((Bundle)localObject1).putString("shareGroupName", (String)localObject8);
            localObject7 = a(rma.a().tF(), i);
            j = ((Bundle)localObject1).getInt("qq_sub_business_id", 1);
            localObject3 = new aybv(((Bundle)localObject1).getInt("edit_video_type", 10002), i, j);
            ((aybv)localObject3).a((ayby)localObject7);
            ((aybv)localObject3).aeY(2);
            ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
            ((Bundle)localObject1).putString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", (String)localObject4);
            ((Bundle)localObject1).putInt("extra_transiton_src_from", 1);
            ((Bundle)localObject1).putInt("extra_slide_entrance", parama.btp);
            ((Bundle)localObject1).putInt("extra_slide_sticker_id", parama.texId);
            ((Bundle)localObject1).putString("extra_slide_sticker_str", parama.aBq);
            if (parama.mItemList.size() > 0)
            {
              ((Bundle)localObject1).putString("extra_transiton_default", ((SlideItemInfo)parama.mItemList.get(0)).mTransId);
              if (QLog.isColorLevel()) {
                QLog.d("VideoMerger", 2, "doMerge mTransId=" + ((SlideItemInfo)parama.mItemList.get(0)).mTransId);
              }
              if (((SlideItemInfo)parama.mItemList.get(0)).f != null)
              {
                ((Bundle)localObject1).putInt("extra_ablum_type", ((SlideItemInfo)parama.mItemList.get(0)).f.mAlbumType);
                if (QLog.isColorLevel()) {
                  QLog.d("VideoMerger", 2, "doMerge mAlbumType=" + ((SlideItemInfo)parama.mItemList.get(0)).f.mAlbumType);
                }
              }
              localObject7 = rly.a(parama.mContext).S(((SlideItemInfo)parama.mItemList.get(0)).mTransId);
              if ((localObject7 != null) && (((List)localObject7).size() > 0))
              {
                localObject7 = ((QIMMusicConfigManager)axov.a(2)).a(((rly.a)((List)localObject7).get(0)).tagId, ((rly.a)((List)localObject7).get(0)).itemId);
                if (localObject7 != null)
                {
                  localObject8 = new Bundle();
                  Bundle localBundle = new Bundle();
                  localBundle.putParcelable("select_music", (Parcelable)localObject7);
                  localBundle.putString("select_music_local_path", ((MusicItemInfo)localObject7).getLocalPath());
                  localBundle.putInt("capture_mode", 2);
                  ((Bundle)localObject8).putBundle(MusicProviderView.class.getSimpleName(), localBundle);
                  ((Bundle)localObject2).putBundle("container", (Bundle)localObject8);
                  if (QLog.isColorLevel()) {
                    QLog.d("VideoMerger", 2, "doMerge musicItemInfo=" + ((MusicItemInfo)localObject7).mTagName + " " + ((MusicItemInfo)localObject7).mItemId);
                  }
                }
              }
            }
            ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_EDIT", bool3);
            if (rma.a().tF() == 13) {
              ((axro)axov.a().c(8)).eOq();
            }
            parama.mHandler.post(new VideoMerger.1(this, parama, (CameraCaptureView.VideoCaptureResult)localObject6, (LocalMediaInfo)localObject5, (aybv)localObject3, (Bundle)localObject2, (Bundle)localObject1));
            localObject1 = parama.mItemList.iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              if (((SlideItemInfo)((Iterator)localObject1).next()).mediaType != 1) {
                break label2288;
              }
              i += 1;
            }
            bool2 = false;
            break label919;
            label1937:
            ((LocalMediaInfo)localObject5).mTransferPosList = ((rqt)localObject2).r((List)localObject1);
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        label2288:
        for (;;)
        {
          int i;
          int j;
          localThrowable2.printStackTrace();
          QLog.e("VideoMerger", 1, "pic2video err", localThrowable2);
          continue;
          ((CameraCaptureView.VideoCaptureResult)localObject6).audioDataFilePath = Image2Video.na();
          continue;
          int k = parama.mItemList.size();
          if (this.aIQ)
          {
            j = 0;
            rar.a("video_edit_slides", "suc_compose", j, 0, new String[] { "", parama.mItemList.size() + "", k - i + "", i + "" });
            rar.g("actAlbumResult", new String[] { "0" });
            if (!awsy.dso)
            {
              awsy.dso = true;
              i = 0;
              if (awsy.Mp != -1L) {
                i = (int)(System.currentTimeMillis() - awsy.Mp);
              }
            }
          }
          for (;;)
          {
            try
            {
              l1 = ambd.at((String)localObject4);
              rar.a("time_shoot", 10002, i, new String[] { String.valueOf(2), String.valueOf(l1), "", "" });
              if (parama.a != null) {
                parama.a.blB();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.i("VideoMerger", 2, "combine video result =" + bool2);
              return;
              j = 1;
            }
            catch (Throwable localThrowable1)
            {
              QLog.d("VideoMerger", 1, "MediaUtil.getVideoDuration error, ", localThrowable1);
              l1 = 0L;
              continue;
            }
            parama.mHandler.post(new VideoMerger.2(this, parama));
          }
        }
      }
    }
  }
  
  public static class a
    extends SlideShowProcessor.c
  {
    public rmn.b a;
    public String aBq;
    public int btp;
    public Activity mContext;
    public Handler mHandler;
    public List<SlideItemInfo> mItemList;
    public int texId;
  }
  
  public static abstract interface b
  {
    public abstract void blB();
    
    public abstract void tU(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmn
 * JD-Core Version:    0.7.0.1
 */