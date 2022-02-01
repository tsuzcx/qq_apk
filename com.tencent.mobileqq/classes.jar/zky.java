import android.app.Activity;
import android.content.Intent;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
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

public class zky
  extends zkx
{
  long jdField_a_of_type_Long;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private boolean jdField_a_of_type_Boolean;
  
  private bqae a(int paramInt1, int paramInt2)
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
      return new bqag().a(false).e(bool1).f(bool2).g(true).h(true).j(true).b(false).k(true).d(false).c(2).a();
      return new bqag().a(true).f(false).g(true).h(true).j(true).b(true).k(false).d(false).c(2).a();
      bool1 = false;
      break;
    }
  }
  
  public void a(zkz paramzkz)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoMerger", 2, "start combine");
    }
    if (paramzkz.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Object localObject2 = new zrc();
      Object localObject1 = new ArrayList(paramzkz.jdField_a_of_type_JavaUtilList.size());
      Object localObject5 = new ArrayList(paramzkz.jdField_a_of_type_JavaUtilList.size());
      Object localObject3 = (zkn)QQStoryContext.a().getBusinessHandler(1);
      Object localObject6 = new ArrayList();
      Object localObject4 = paramzkz.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject7;
      Object localObject8;
      for (boolean bool1 = false; ((Iterator)localObject4).hasNext(); bool1 = bool2)
      {
        localObject7 = (SlideItemInfo)((Iterator)localObject4).next();
        localObject8 = ((zkn)localObject3).a(((SlideItemInfo)localObject7).jdField_b_of_type_JavaLangString);
        bool2 = bool1;
        if (localObject8 != null)
        {
          ((List)localObject1).add(((LocalMediaInfo)localObject8).path);
          ((List)localObject6).add(((LocalMediaInfo)localObject8).mAudioPath);
          ((SlideItemInfo)localObject7).jdField_c_of_type_JavaLangString = ((LocalMediaInfo)localObject8).path;
          ((SlideItemInfo)localObject7).d = ((LocalMediaInfo)localObject8).mAudioPath;
          ((SlideItemInfo)localObject7).jdField_a_of_type_Boolean = ((LocalMediaInfo)localObject8).mHasAudioTrack;
          ((SlideItemInfo)localObject7).jdField_c_of_type_Int = ((LocalMediaInfo)localObject8).mSampleRate;
          ((List)localObject5).add(localObject7);
          bool2 = bool1;
          if (((SlideItemInfo)localObject7).jdField_b_of_type_Int == 1)
          {
            if (((SlideItemInfo)localObject7).jdField_a_of_type_Boolean) {
              bool1 = true;
            }
            QLog.i("VideoMerger", 1, "mergeRunnable hasAudioTrack=" + ((SlideItemInfo)localObject7).jdField_a_of_type_Boolean + " mSampleRate:" + ((SlideItemInfo)localObject7).jdField_c_of_type_Int);
            bool2 = bool1;
          }
        }
      }
      if (a(paramzkz))
      {
        a(9, "", null, null, null, paramzkz);
        return;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {
        if (((zkn)localObject3).a() != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = ((zkn)localObject3).a();
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "transHandler.getMediaFormat");
          }
        }
      }
      boolean bool3;
      for (;;)
      {
        if (paramzkz.jdField_a_of_type_Zla != null) {
          paramzkz.jdField_a_of_type_Zla.a(bool1);
        }
        localObject4 = zkj.a();
        localObject3 = (String)localObject4 + ".dat";
        if (!bool1) {
          break label770;
        }
        bool3 = zrd.b((List)localObject5);
        QLog.i("VideoMerger", 1, "clip audio success=" + bool3);
        bool2 = bool3;
        if (!bool3) {
          break label627;
        }
        ((List)localObject6).clear();
        localObject7 = ((List)localObject5).iterator();
        while (((Iterator)localObject7).hasNext()) {
          ((List)localObject6).add(((SlideItemInfo)((Iterator)localObject7).next()).d);
        }
        if (((List)localObject1).size() > 0)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = zkq.a((String)((List)localObject1).get(0));
          if (QLog.isColorLevel()) {
            QLog.d("VideoMerger", 2, "ImageToVideo.getVideoFormatFromVideo, videoPath : " + (String)((List)localObject1).get(0));
          }
        }
        if (this.jdField_a_of_type_AndroidMediaMediaFormat == null)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = zkq.a();
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
      for (boolean bool2 = ((zrc)localObject2).a((List)localObject6, (String)localObject3);; bool2 = true)
      {
        label627:
        QLog.i("VideoMerger", 1, "merge audio success " + bool2);
        if (!bool2) {
          break;
        }
        bool3 = zrd.a((List)localObject5);
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
          if (((SlideItemInfo)localObject6).jdField_b_of_type_Int == 0) {
            ((List)localObject1).add(((SlideItemInfo)localObject6).jdField_c_of_type_JavaLangString);
          }
          ((List)localObject1).add(((SlideItemInfo)localObject6).jdField_c_of_type_JavaLangString);
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
        bool2 = ((zrc)localObject2).a((List)localObject1, (String)localObject4, 720, 1280, this.jdField_a_of_type_AndroidMediaMediaFormat);
        l2 = System.currentTimeMillis();
        QLog.i("VideoMerger", 1, "merge video result " + bool2 + " cost: " + (l2 - l1) + " ms");
        label917:
        QLog.i("VideoMerger", 1, "merge video result " + bool2);
        localObject5 = new LocalMediaInfo();
        ((LocalMediaInfo)localObject5).path = ((String)localObject4);
        ((LocalMediaInfo)localObject5).mMimeType = "video";
        if (!AudioHelper.g()) {
          break label1934;
        }
        ((LocalMediaInfo)localObject5).mTransferPosList = ((zrc)localObject2).b((List)localObject1, (String)localObject4);
        localObject2 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      }
      try
      {
        ((MediaScanner)localObject2).buildAndUpdateVideo((LocalMediaInfo)localObject5);
        if (bool2)
        {
          l1 = System.currentTimeMillis();
          l2 = this.jdField_a_of_type_Long;
          yup.a("actAlbumTime", new String[] { l1 - l2 + "", paramzkz.jdField_a_of_type_JavaUtilList.size() + "" });
          localObject6 = new CameraCaptureView.VideoCaptureResult();
          ((CameraCaptureView.VideoCaptureResult)localObject6).videoFrameCount = ((List)localObject1).size();
          if (bool1)
          {
            ((CameraCaptureView.VideoCaptureResult)localObject6).audioDataFilePath = ((String)localObject3);
            ((CameraCaptureView.VideoCaptureResult)localObject6).videoMp4FilePath = ((String)localObject4);
            localObject1 = null;
            localObject2 = paramzkz.jdField_a_of_type_AndroidAppActivity.getIntent();
            if (localObject2 != null) {
              localObject1 = bplh.a((Intent)localObject2);
            }
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Bundle();
            }
            localObject3 = paramzkz.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
            localObject1 = localObject3;
            if (localObject3 == null) {
              localObject1 = new Bundle();
            }
            localObject3 = paramzkz.jdField_a_of_type_AndroidAppActivity.getIntent();
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
            localObject7 = a(zkg.a().a(), i);
            j = ((Bundle)localObject1).getInt("qq_sub_business_id", 1);
            localObject3 = new bqaa(((Bundle)localObject1).getInt("edit_video_type", 10002), i, j);
            ((bqaa)localObject3).a((bqae)localObject7);
            ((bqaa)localObject3).a(2);
            ((Bundle)localObject1).putBoolean("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
            ((Bundle)localObject1).putString("PhotoConst.FROM_QQSTORY_SLIDESHOW_DATA", (String)localObject4);
            ((Bundle)localObject1).putInt("extra_transiton_src_from", 1);
            ((Bundle)localObject1).putInt("extra_slide_entrance", paramzkz.jdField_a_of_type_Int);
            ((Bundle)localObject1).putInt("extra_slide_sticker_id", paramzkz.jdField_b_of_type_Int);
            ((Bundle)localObject1).putString("extra_slide_sticker_str", paramzkz.jdField_a_of_type_JavaLangString);
            if (paramzkz.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              ((Bundle)localObject1).putString("extra_transiton_default", ((SlideItemInfo)paramzkz.jdField_a_of_type_JavaUtilList.get(0)).e);
              if (QLog.isColorLevel()) {
                QLog.d("VideoMerger", 2, "doMerge mTransId=" + ((SlideItemInfo)paramzkz.jdField_a_of_type_JavaUtilList.get(0)).e);
              }
              if (((SlideItemInfo)paramzkz.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Wgg != null)
              {
                ((Bundle)localObject1).putInt("extra_ablum_type", ((SlideItemInfo)paramzkz.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Wgg.jdField_a_of_type_Int);
                if (QLog.isColorLevel()) {
                  QLog.d("VideoMerger", 2, "doMerge mAlbumType=" + ((SlideItemInfo)paramzkz.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Wgg.jdField_a_of_type_Int);
                }
              }
              localObject7 = zkd.a(paramzkz.jdField_a_of_type_AndroidAppActivity).a(((SlideItemInfo)paramzkz.jdField_a_of_type_JavaUtilList.get(0)).e);
              if ((localObject7 != null) && (((List)localObject7).size() > 0))
              {
                localObject7 = ((QIMMusicConfigManager)bplq.a(2)).a(((zke)((List)localObject7).get(0)).jdField_a_of_type_Int, ((zke)((List)localObject7).get(0)).jdField_b_of_type_Int);
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
            if (zkg.a().a() == 13) {
              ((bpoz)bplq.a().c(8)).e();
            }
            paramzkz.jdField_a_of_type_AndroidOsHandler.post(new VideoMerger.1(this, paramzkz, (CameraCaptureView.VideoCaptureResult)localObject6, (LocalMediaInfo)localObject5, (bqaa)localObject3, (Bundle)localObject2, (Bundle)localObject1));
            localObject1 = paramzkz.jdField_a_of_type_JavaUtilList.iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              if (((SlideItemInfo)((Iterator)localObject1).next()).jdField_b_of_type_Int != 1) {
                break label2285;
              }
              i += 1;
            }
            bool2 = false;
            break label917;
            label1934:
            ((LocalMediaInfo)localObject5).mTransferPosList = ((zrc)localObject2).b((List)localObject1);
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        label2285:
        for (;;)
        {
          int i;
          int j;
          localThrowable2.printStackTrace();
          QLog.e("VideoMerger", 1, "pic2video err", localThrowable2);
          continue;
          ((CameraCaptureView.VideoCaptureResult)localObject6).audioDataFilePath = Image2Video.a();
          continue;
          int k = paramzkz.jdField_a_of_type_JavaUtilList.size();
          if (this.jdField_a_of_type_Boolean)
          {
            j = 0;
            yup.a("video_edit_slides", "suc_compose", j, 0, new String[] { "", paramzkz.jdField_a_of_type_JavaUtilList.size() + "", k - i + "", i + "" });
            yup.a("actAlbumResult", new String[] { "0" });
            if (!bodv.z)
            {
              bodv.z = true;
              i = 0;
              if (bodv.jdField_a_of_type_Long != -1L) {
                i = (int)(System.currentTimeMillis() - bodv.jdField_a_of_type_Long);
              }
            }
          }
          for (;;)
          {
            try
            {
              l1 = bbnj.a((String)localObject4);
              yup.a("time_shoot", 10002, i, new String[] { String.valueOf(2), String.valueOf(l1), "", "" });
              if (paramzkz.jdField_a_of_type_Zla != null) {
                paramzkz.jdField_a_of_type_Zla.j();
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
            paramzkz.jdField_a_of_type_AndroidOsHandler.post(new VideoMerger.2(this, paramzkz));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zky
 * JD-Core Version:    0.7.0.1
 */