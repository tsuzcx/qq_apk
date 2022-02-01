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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tribe.async.async.JobContext;
import java.io.File;

public class yys
  extends yyn<yya, yya>
{
  private final EditVideoParams a;
  
  public yys(@NonNull EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    ykq.c("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
    PublishVideoEntry localPublishVideoEntry = paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    localPublishVideoEntry.publishFrom = this.a.getEntranceType();
    localPublishVideoEntry.businessId = this.a.mBusinessId;
    localPublishVideoEntry.fakeVid = StoryVideoItem.makeFakeVid();
    localPublishVideoEntry.mLocalDate = yck.a();
    localPublishVideoEntry.timeZoneOffset = (UIUtils.getTimeZoneOffset() * 1000);
    if (localPublishVideoEntry.createTime == 0L) {
      localPublishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d", new Object[] { localPublishVideoEntry.mLocalDate, Long.valueOf(localPublishVideoEntry.createTime) });
    localPublishVideoEntry.publishState = 1;
    localPublishVideoEntry.videoUploadTempDir = paramyya.jdField_b_of_type_JavaLangString;
    if (localPublishVideoEntry.videoUploadTempDir != null) {
      zeb.a(localPublishVideoEntry.videoUploadTempDir);
    }
    localPublishVideoEntry.redBagType = this.a.getIntExtra("video_redbag_get", 0);
    if (localPublishVideoEntry.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
    {
      localPublishVideoEntry.putExtra("redBagType", Integer.valueOf(localPublishVideoEntry.redBagType));
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "VideoRedbag, publishVideoEntry take redbag flag");
    }
    localPublishVideoEntry.specialVideoType = this.a.getIntExtra("special_video_type", 0);
    if (localPublishVideoEntry.specialVideoType == 2)
    {
      localPublishVideoEntry.putExtra("special_video_type", Integer.valueOf(localPublishVideoEntry.specialVideoType));
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : specialVideoType = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.specialVideoType) });
    }
    Object localObject2;
    Object localObject1;
    if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localPublishVideoEntry.hwEncodeRecordVideo = true;
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = false;
      paramJobContext = (EditTakeVideoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.getSourcePath();
      localPublishVideoEntry.recordTime = paramJobContext.a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)paramJobContext.a.mDuration * 30);
      localPublishVideoEntry.mAudioFilePath = paramJobContext.jdField_b_of_type_JavaLangString;
      if (zfl.b(paramJobContext.getSourcePath()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = paramJobContext.getHeight();
      }
      for (localPublishVideoEntry.videoHeight = paramJobContext.getWidth();; localPublishVideoEntry.videoHeight = paramJobContext.getHeight())
      {
        localPublishVideoEntry.videoDuration = paramJobContext.a.mDuration;
        if ((localPublishVideoEntry.getBooleanExtra("enable_flow_decode", true)) || (localPublishVideoEntry.saveMode != 5) || (zeb.c(localPublishVideoEntry.mIFrameVideoPath))) {
          break;
        }
        super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
        return;
        localPublishVideoEntry.videoWidth = paramJobContext.getWidth();
      }
      localPublishVideoEntry.videoCreateTime = paramJobContext.a.addedDate;
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", new Object[] { paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", new Object[] { localPublishVideoEntry.fakeVid });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", new Object[] { localPublishVideoEntry.mLocalRawVideoDir });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.videoWidth), Integer.valueOf(localPublishVideoEntry.videoHeight) });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", new Object[] { Integer.valueOf((int)localPublishVideoEntry.videoDuration), Integer.valueOf((int)localPublishVideoEntry.recordTime) });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.businessId) });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", new Object[] { localPublishVideoEntry.thumbPath });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", new Object[] { localPublishVideoEntry.doodlePath });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", new Object[] { localPublishVideoEntry.doodleRawPath });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", new Object[] { localPublishVideoEntry.atDoodlePath });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", new Object[] { localPublishVideoEntry.multiFragmentGroupId });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.isLocalPublish) });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : hasFragments = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.hasFragments) });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragments = %s", new Object[] { localPublishVideoEntry.fragments });
      ykq.d("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.publishFrom) });
      if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir)) {
        super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
      }
    }
    else if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = true;
      localObject2 = (EditLocalVideoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      paramJobContext = ((EditLocalVideoSource)localObject2).getSourcePath();
      if (this.a.getBussinessId() == 1) {
        break label2179;
      }
      localObject1 = new File(paramJobContext);
      localObject1 = alrs.c + localPublishVideoEntry.fakeVid + File.separator + ((File)localObject1).getName();
      if (!FileUtils.copyFile(paramJobContext, (String)localObject1)) {
        break label2179;
      }
      paramJobContext = (JobContext)localObject1;
    }
    label2176:
    label2179:
    for (;;)
    {
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
      localPublishVideoEntry.recordTime = ((EditLocalVideoSource)localObject2).a.mDuration;
      localPublishVideoEntry.recordFrames = ((int)((EditLocalVideoSource)localObject2).a.mDuration * 30);
      if (zfl.b(((EditLocalVideoSource)localObject2).getSourcePath()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).getHeight();
      }
      for (localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).getWidth();; localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).getHeight())
      {
        localPublishVideoEntry.videoDuration = ((EditLocalVideoSource)localObject2).a.mDuration;
        localPublishVideoEntry.videoCreateTime = ((EditLocalVideoSource)localObject2).a.addedDate;
        break;
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).getWidth();
      }
      if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
      {
        localPublishVideoEntry.isPicture = false;
        localPublishVideoEntry.isLocalPublish = false;
        paramJobContext = (EditRecordVideoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.getSourcePath();
        localPublishVideoEntry.recordTime = paramJobContext.jdField_a_of_type_Long;
        localPublishVideoEntry.recordFrames = paramJobContext.jdField_a_of_type_Int;
        localPublishVideoEntry.videoWidth = paramJobContext.getWidth();
        localPublishVideoEntry.videoHeight = paramJobContext.getHeight();
        if (paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 1)
        {
          localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long / 2L);
          break;
        }
        if (paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode == 2)
        {
          localPublishVideoEntry.videoDuration = (paramJobContext.jdField_a_of_type_Long * 2L);
          break;
        }
        localPublishVideoEntry.videoDuration = paramJobContext.jdField_a_of_type_Long;
        break;
      }
      if (((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)))
      {
        localPublishVideoEntry.isPicture = true;
        paramJobContext = paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.getSourcePath();
        if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
        {
          localObject1 = (EditLocalPhotoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          localPublishVideoEntry.isLocalPublish = true;
          localPublishVideoEntry.videoCreateTime = ((EditLocalPhotoSource)localObject1).a.addedDate;
          label1273:
          if ((paramyya.jdField_a_of_type_Yye.jdField_b_of_type_Boolean) || (!paramyya.jdField_a_of_type_Yye.jdField_a_of_type_Boolean)) {
            break label2176;
          }
          paramJobContext = paramyya.jdField_a_of_type_Yye.jdField_b_of_type_JavaLangString;
        }
      }
      for (;;)
      {
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
        if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
          localPublishVideoEntry.mLocalRawPicPath = paramyya.jdField_a_of_type_Yye.jdField_a_of_type_JavaLangString;
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
        break label1273;
        super.notifyError(new ErrorMessage(-1, "illegal argument " + paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource));
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
        QQStoryContext.a().a().createEntityManager().persistOrReplace(localPublishVideoEntry);
        ykq.c("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
        int i = 0;
        if (paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.saveMode != 0) {
          i = 1;
        }
        if (paramyya.jdField_b_of_type_Boolean) {
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
        if (paramyya.c) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            ykw.a("0X80076BD");
          }
          boolean bool;
          label1889:
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
          label2004:
          int k;
          if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            if (i == 1)
            {
              bool = true;
              bbhl.c = bool;
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
                break label2155;
              }
              j = 1;
              if (!paramyya.d) {
                break label2161;
              }
              k = 1;
              label2014:
              if (!localPublishVideoEntry.hwEncodeRecordVideo) {
                break label2167;
              }
            }
          }
          label2155:
          label2161:
          label2167:
          for (int m = 1;; m = 0)
          {
            paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam = new PublishParam(paramJobContext, (String)localObject1, (String)localObject2, str1, str2, str3, n, i1, l, i2, i3, i, i4, i5, str4, str5, j, k, m, localPublishVideoEntry.mLocalRawVideoDir, localPublishVideoEntry.mAudioFilePath, localPublishVideoEntry.mIFrameVideoPath, localPublishVideoEntry.mosaicPath, paramyya.jdField_b_of_type_Int, localPublishVideoEntry.isLocalPublish, localPublishVideoEntry.redBagType, localPublishVideoEntry.specialVideoType);
            super.notifyResult(paramyya);
            return;
            bool = false;
            break;
            if (!(paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
              break label1889;
            }
            if (i == 1) {}
            for (bool = true;; bool = false)
            {
              bbhl.d = bool;
              break;
            }
            j = 0;
            break label2004;
            k = 0;
            break label2014;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yys
 * JD-Core Version:    0.7.0.1
 */