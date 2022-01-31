import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tribe.async.async.JobContext;
import java.io.File;

public class xlt
  extends xlo<xlb, xlb>
{
  private final EditVideoParams a;
  
  public xlt(@NonNull EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
  }
  
  protected void a(JobContext paramJobContext, xlb paramxlb)
  {
    wxe.c("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
    PublishVideoEntry localPublishVideoEntry = paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    localPublishVideoEntry.publishFrom = this.a.b();
    localPublishVideoEntry.businessId = this.a.jdField_a_of_type_Int;
    localPublishVideoEntry.fakeVid = StoryVideoItem.makeFakeVid();
    localPublishVideoEntry.mLocalDate = woy.a();
    localPublishVideoEntry.timeZoneOffset = (xsm.a() * 1000);
    if (localPublishVideoEntry.createTime == 0L) {
      localPublishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d", new Object[] { localPublishVideoEntry.mLocalDate, Long.valueOf(localPublishVideoEntry.createTime) });
    localPublishVideoEntry.publishState = 1;
    localPublishVideoEntry.videoUploadTempDir = paramxlb.jdField_b_of_type_JavaLangString;
    if (localPublishVideoEntry.videoUploadTempDir != null) {
      xrg.a(localPublishVideoEntry.videoUploadTempDir);
    }
    localPublishVideoEntry.redBagType = this.a.a("video_redbag_get", 0);
    if (localPublishVideoEntry.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
    {
      localPublishVideoEntry.putExtra("redBagType", Integer.valueOf(localPublishVideoEntry.redBagType));
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "VideoRedbag, publishVideoEntry take redbag flag");
    }
    localPublishVideoEntry.specialVideoType = this.a.a("special_video_type", 0);
    if (localPublishVideoEntry.specialVideoType == 2)
    {
      localPublishVideoEntry.putExtra("special_video_type", Integer.valueOf(localPublishVideoEntry.specialVideoType));
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : specialVideoType = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.specialVideoType) });
    }
    Object localObject2;
    Object localObject1;
    if ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localPublishVideoEntry.hwEncodeRecordVideo = true;
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = false;
      paramJobContext = (EditTakeVideoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.a();
      localPublishVideoEntry.recordTime = paramJobContext.a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)paramJobContext.a.mDuration * 30);
      localPublishVideoEntry.mAudioFilePath = paramJobContext.jdField_b_of_type_JavaLangString;
      if (xsv.b(paramJobContext.a()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = paramJobContext.b();
      }
      for (localPublishVideoEntry.videoHeight = paramJobContext.a();; localPublishVideoEntry.videoHeight = paramJobContext.b())
      {
        localPublishVideoEntry.videoDuration = paramJobContext.a.mDuration;
        if ((localPublishVideoEntry.getBooleanExtra("enable_flow_decode", true)) || (localPublishVideoEntry.saveMode != 5) || (xrg.c(localPublishVideoEntry.mIFrameVideoPath))) {
          break;
        }
        super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
        return;
        localPublishVideoEntry.videoWidth = paramJobContext.a();
      }
      localPublishVideoEntry.videoCreateTime = paramJobContext.a.addedDate;
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", new Object[] { paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", new Object[] { localPublishVideoEntry.fakeVid });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", new Object[] { localPublishVideoEntry.mLocalRawVideoDir });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.videoWidth), Integer.valueOf(localPublishVideoEntry.videoHeight) });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", new Object[] { Integer.valueOf((int)localPublishVideoEntry.videoDuration), Integer.valueOf((int)localPublishVideoEntry.recordTime) });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.businessId) });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", new Object[] { localPublishVideoEntry.thumbPath });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", new Object[] { localPublishVideoEntry.doodlePath });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", new Object[] { localPublishVideoEntry.doodleRawPath });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", new Object[] { localPublishVideoEntry.atDoodlePath });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", new Object[] { localPublishVideoEntry.multiFragmentGroupId });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.isLocalPublish) });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : hasFragments = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.hasFragments) });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragments = %s", new Object[] { localPublishVideoEntry.fragments });
      wxe.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.publishFrom) });
      if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir)) {
        super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
      }
    }
    else if ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = true;
      localObject2 = (EditLocalVideoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      paramJobContext = ((EditLocalVideoSource)localObject2).a();
      if (this.a.a() == 1) {
        break label2177;
      }
      localObject1 = new File(paramJobContext);
      localObject1 = ajrx.c + localPublishVideoEntry.fakeVid + File.separator + ((File)localObject1).getName();
      if (!bdhb.d(paramJobContext, (String)localObject1)) {
        break label2177;
      }
      paramJobContext = (JobContext)localObject1;
    }
    label2002:
    label2012:
    for (;;)
    {
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
      localPublishVideoEntry.recordTime = ((EditLocalVideoSource)localObject2).a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)((EditLocalVideoSource)localObject2).a.mDuration * 30);
      if (xsv.b(((EditLocalVideoSource)localObject2).a()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).b();
      }
      for (localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).a();; localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).b())
      {
        localPublishVideoEntry.videoDuration = ((EditLocalVideoSource)localObject2).a.mDuration;
        localPublishVideoEntry.videoCreateTime = ((EditLocalVideoSource)localObject2).a.addedDate;
        break;
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).a();
      }
      if ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
      {
        localPublishVideoEntry.isPicture = false;
        localPublishVideoEntry.isLocalPublish = false;
        paramJobContext = (EditRecordVideoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.a();
        localPublishVideoEntry.recordTime = paramJobContext.jdField_a_of_type_Long;
        localPublishVideoEntry.recordFrames = paramJobContext.jdField_a_of_type_Int;
        localPublishVideoEntry.videoWidth = paramJobContext.a();
        localPublishVideoEntry.videoHeight = paramJobContext.b();
        if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 1)
        {
          localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long / 2L);
          break;
        }
        if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 2)
        {
          localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long * 2L);
          break;
        }
        localPublishVideoEntry.videoDuration = paramJobContext.jdField_a_of_type_Long;
        break;
      }
      if (((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)))
      {
        localPublishVideoEntry.isPicture = true;
        paramJobContext = paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
        if ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
        {
          localObject1 = (EditLocalPhotoSource)paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          localPublishVideoEntry.isLocalPublish = true;
          localPublishVideoEntry.videoCreateTime = ((EditLocalPhotoSource)localObject1).a.addedDate;
          label1271:
          if ((paramxlb.jdField_a_of_type_Xlf.jdField_b_of_type_Boolean) || (!paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_Boolean)) {
            break label2174;
          }
          paramJobContext = paramxlb.jdField_a_of_type_Xlf.jdField_b_of_type_JavaLangString;
        }
      }
      label1887:
      label2153:
      label2159:
      label2165:
      label2174:
      for (;;)
      {
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
        if ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
          localPublishVideoEntry.mLocalRawPicPath = paramxlb.jdField_a_of_type_Xlf.jdField_a_of_type_JavaLangString;
        }
        localPublishVideoEntry.recordTime = 5000.0D;
        localPublishVideoEntry.recordFrames = 150000;
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramJobContext, (BitmapFactory.Options)localObject1);
        localPublishVideoEntry.videoWidth = ((BitmapFactory.Options)localObject1).outWidth;
        localPublishVideoEntry.videoHeight = ((BitmapFactory.Options)localObject1).outHeight;
        localPublishVideoEntry.videoDuration = 5000L;
        break;
        localPublishVideoEntry.isLocalPublish = false;
        break label1271;
        super.notifyError(new ErrorMessage(-1, "illegal argument " + paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource));
        return;
        paramJobContext = new File(localPublishVideoEntry.thumbPath);
        if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
        {
          super.notifyError(new ErrorMessage(-1, "thumbFile is invalid : " + paramJobContext));
          return;
        }
        if (localPublishVideoEntry.doodlePath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.doodlePath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "doodleFile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.mosaicPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.mosaicPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "mosaicfile is invalid : " + paramJobContext));
            return;
          }
        }
        if (localPublishVideoEntry.doodleRawPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.doodleRawPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "doodleRawFile is invalid : " + paramJobContext));
            return;
          }
        }
        QQStoryContext.a().a().createEntityManager().b(localPublishVideoEntry);
        wxe.c("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
        int i = 0;
        if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0) {
          i = 1;
        }
        if (paramxlb.jdField_b_of_type_Boolean) {
          i = 1;
        }
        if (localPublishVideoEntry.isMuteRecordVoice) {
          i = 1;
        }
        if (localPublishVideoEntry.backgroundMusicPath != null) {
          i = 1;
        }
        if (localPublishVideoEntry.doodlePath != null) {
          i = 1;
        }
        if (localPublishVideoEntry.doodleRawPath != null) {
          i = 1;
        }
        if (!TextUtils.isEmpty(localPublishVideoEntry.getStringExtra("subtitleData", ""))) {
          i = 1;
        }
        if (paramxlb.c) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            wxk.a("0X80076BD");
          }
          boolean bool;
          String str1;
          String str2;
          String str3;
          int n;
          int i1;
          long l;
          int i2;
          int i3;
          int i4;
          int i5;
          String str4;
          String str5;
          int j;
          int k;
          if ((paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            if (i == 1)
            {
              bool = true;
              axpl.c = bool;
              paramJobContext = localPublishVideoEntry.fakeVid;
              localObject1 = localPublishVideoEntry.thumbPath;
              localObject2 = localPublishVideoEntry.doodlePath;
              str1 = localPublishVideoEntry.videoLabel;
              str2 = localPublishVideoEntry.videoDoodleDescription;
              str3 = localPublishVideoEntry.videoAddress;
              n = localPublishVideoEntry.videoWidth;
              i1 = localPublishVideoEntry.videoHeight;
              l = localPublishVideoEntry.videoDuration;
              i2 = localPublishVideoEntry.videoMaxrate;
              i3 = localPublishVideoEntry.videoMinrate;
              i4 = localPublishVideoEntry.saveMode;
              i5 = localPublishVideoEntry.recordFrames;
              str4 = localPublishVideoEntry.atDoodlePath;
              str5 = localPublishVideoEntry.atJsonData;
              if (!localPublishVideoEntry.isPicture) {
                break label2153;
              }
              j = 1;
              if (!paramxlb.d) {
                break label2159;
              }
              k = 1;
              if (!localPublishVideoEntry.hwEncodeRecordVideo) {
                break label2165;
              }
            }
          }
          for (int m = 1;; m = 0)
          {
            paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam = new PublishParam(paramJobContext, (String)localObject1, (String)localObject2, str1, str2, str3, n, i1, l, i2, i3, i, i4, i5, str4, str5, j, k, m, localPublishVideoEntry.mLocalRawVideoDir, localPublishVideoEntry.mAudioFilePath, localPublishVideoEntry.mIFrameVideoPath, localPublishVideoEntry.mosaicPath, paramxlb.jdField_b_of_type_Int, localPublishVideoEntry.isLocalPublish, localPublishVideoEntry.redBagType, localPublishVideoEntry.specialVideoType);
            super.notifyResult(paramxlb);
            return;
            bool = false;
            break;
            if (!(paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
              break label1887;
            }
            if (i == 1) {}
            for (bool = true;; bool = false)
            {
              axpl.d = bool;
              break;
            }
            j = 0;
            break label2002;
            k = 0;
            break label2012;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xlt
 * JD-Core Version:    0.7.0.1
 */