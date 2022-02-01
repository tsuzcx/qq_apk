import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import java.io.File;
import java.util.TimeZone;

public class ayqw
  extends ayqr<ayqb, ayqb>
{
  private final EditVideoParams a;
  
  public ayqw(@NonNull EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
  }
  
  public static long f(int paramInt, long paramLong)
  {
    long l;
    if (paramInt == 1) {
      l = paramLong / 2L;
    }
    do
    {
      return l;
      if (paramInt == 2) {
        return paramLong * 2L;
      }
      if (paramInt == 4) {
        return paramLong * 4L;
      }
      l = paramLong;
    } while (paramInt != 3);
    return ((float)paramLong / 1.5F);
  }
  
  protected void a(JobContext paramJobContext, ayqb paramayqb)
  {
    ram.i("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
    PublishVideoEntry localPublishVideoEntry = paramayqb.g;
    localPublishVideoEntry.publishFrom = this.a.th();
    localPublishVideoEntry.businessId = this.a.asi;
    localPublishVideoEntry.fakeVid = StoryVideoItem.makeFakeVid();
    localPublishVideoEntry.mLocalDate = qvf.jf();
    localPublishVideoEntry.timeZoneOffset = TimeZone.getDefault().getRawOffset();
    if (localPublishVideoEntry.createTime == 0L) {
      localPublishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d,", new Object[] { localPublishVideoEntry.mLocalDate, Long.valueOf(localPublishVideoEntry.createTime) });
    localPublishVideoEntry.publishState = 1;
    localPublishVideoEntry.videoUploadTempDir = paramayqb.aAU;
    localPublishVideoEntry.putExtra("extra_capture_mode", Integer.valueOf(this.a.mMode));
    localPublishVideoEntry.redBagType = this.a.getIntExtra("video_redbag_get", 0);
    if (localPublishVideoEntry.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "VideoRedbag, publishVideoEntry take redbag flag");
    }
    localPublishVideoEntry.specialVideoType = this.a.getIntExtra("special_video_type", 0);
    int i;
    label898:
    Object localObject2;
    Object localObject1;
    if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localPublishVideoEntry.hwEncodeRecordVideo = true;
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = false;
      paramJobContext = (EditTakeVideoSource)paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.getSourcePath();
      localPublishVideoEntry.recordTime = paramJobContext.d.mDuration;
      localPublishVideoEntry.recordFrames = ((int)paramJobContext.d.mDuration * 30);
      localPublishVideoEntry.mAudioFilePath = paramJobContext.azv;
      localPublishVideoEntry.mbgmAudioFilePath = paramJobContext.cWQ;
      if (this.a.mMode == 5) {
        localPublishVideoEntry.putExtra("video_type", Integer.valueOf(3));
      }
      if (rpv.getRotation(paramJobContext.getSourcePath()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = paramJobContext.getHeight();
      }
      for (localPublishVideoEntry.videoHeight = paramJobContext.getWidth();; localPublishVideoEntry.videoHeight = paramJobContext.getHeight())
      {
        localPublishVideoEntry.videoDuration = f(localPublishVideoEntry.saveMode, paramJobContext.d.mDuration);
        if ((localPublishVideoEntry.saveMode != 5) || (rox.fileExistsAndNotEmpty(localPublishVideoEntry.mIFrameVideoPath))) {
          break;
        }
        super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
        return;
        localPublishVideoEntry.videoWidth = paramJobContext.getWidth();
      }
      localPublishVideoEntry.videoCreateTime = paramJobContext.d.addedDate;
      i = 1;
      if (i != 0) {
        ayva.a().e(localPublishVideoEntry);
      }
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", new Object[] { paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fake vid = %s", new Object[] { localPublishVideoEntry.fakeVid });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : mLocalRawVideoDir = %s", new Object[] { localPublishVideoEntry.mLocalRawVideoDir });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : width = %d, height = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.videoWidth), Integer.valueOf(localPublishVideoEntry.videoHeight) });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : duration = %d, recordTime = %d", new Object[] { Integer.valueOf((int)localPublishVideoEntry.videoDuration), Integer.valueOf((int)localPublishVideoEntry.recordTime) });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : businessId = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.businessId) });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : thumbPath = %s", new Object[] { localPublishVideoEntry.thumbPath });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleImagePath = %s", new Object[] { localPublishVideoEntry.doodlePath });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : doodleRawImagePath = %s", new Object[] { localPublishVideoEntry.doodleRawPath });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : atDoodleImagePath = %s", new Object[] { localPublishVideoEntry.atDoodlePath });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragmentGroupId = %s", new Object[] { localPublishVideoEntry.multiFragmentGroupId });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : isLocalPublish = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.isLocalPublish) });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : hasFragments = %s", new Object[] { Boolean.valueOf(localPublishVideoEntry.hasFragments) });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : fragments = %s", new Object[] { localPublishVideoEntry.fragments });
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : publishFrom = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.publishFrom) });
      localPublishVideoEntry.putExtra("composite_key_merge_thumb_cost", Long.valueOf(System.currentTimeMillis() - paramayqb.aDe));
      if (this.a.tg() == 14) {
        localPublishVideoEntry.putExtra("VIDEO_STORY_JUMP_TO_TYPE", Integer.valueOf(this.a.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0)));
      }
      if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir)) {
        super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
      }
    }
    else if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localPublishVideoEntry.isPicture = false;
      if (this.a.getBooleanExtra("extra_is_slide_show_video", false))
      {
        i = 2;
        localPublishVideoEntry.putExtra("video_type", Integer.valueOf(i));
        localPublishVideoEntry.isLocalPublish = true;
        localObject2 = (EditLocalVideoSource)paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        paramJobContext = ((EditLocalVideoSource)localObject2).getSourcePath();
        if ((this.a.tg() == 1) || (this.a.tg() == 11) || (this.a.tg() == 12)) {
          break label2233;
        }
        localObject1 = new File(paramJobContext);
        localObject1 = aasa.bea + localPublishVideoEntry.fakeVid + File.separator + ((File)localObject1).getName();
        if (!aqhq.copyFile(paramJobContext, (String)localObject1)) {
          break label2233;
        }
        paramJobContext = (JobContext)localObject1;
      }
    }
    label2091:
    label2221:
    label2230:
    label2233:
    for (;;)
    {
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
      localPublishVideoEntry.recordTime = ((EditLocalVideoSource)localObject2).d.mDuration;
      localPublishVideoEntry.recordFrames = ((int)((EditLocalVideoSource)localObject2).d.mDuration * 30);
      if (rpv.getRotation(((EditLocalVideoSource)localObject2).getSourcePath()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).getHeight();
      }
      for (localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).getWidth();; localPublishVideoEntry.videoHeight = ((EditLocalVideoSource)localObject2).getHeight())
      {
        localPublishVideoEntry.videoDuration = f(localPublishVideoEntry.saveMode, ((EditLocalVideoSource)localObject2).d.mDuration);
        localPublishVideoEntry.videoCreateTime = ((EditLocalVideoSource)localObject2).d.addedDate;
        i = 1;
        break;
        i = 0;
        break label898;
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).getWidth();
      }
      if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
      {
        localPublishVideoEntry.isPicture = false;
        localPublishVideoEntry.isLocalPublish = false;
        paramJobContext = (EditRecordVideoSource)paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.getSourcePath();
        localPublishVideoEntry.recordTime = paramJobContext.recordTime;
        localPublishVideoEntry.recordFrames = paramJobContext.bpF;
        localPublishVideoEntry.videoWidth = paramJobContext.getWidth();
        localPublishVideoEntry.videoHeight = paramJobContext.getHeight();
        localPublishVideoEntry.videoDuration = f(localPublishVideoEntry.saveMode, paramJobContext.recordTime);
        i = 1;
        break;
      }
      if (((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)))
      {
        localPublishVideoEntry.isPicture = true;
        paramJobContext = paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.getSourcePath();
        if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
        {
          localObject1 = (EditLocalPhotoSource)paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          localPublishVideoEntry.isLocalPublish = true;
          localPublishVideoEntry.videoCreateTime = ((EditLocalPhotoSource)localObject1).d.addedDate;
        }
        for (;;)
        {
          if (this.a.mMode == 5) {
            localPublishVideoEntry.putExtra("video_type", Integer.valueOf(3));
          }
          if (localPublishVideoEntry.thumbPath == null) {
            break label1481;
          }
          localPublishVideoEntry.mLocalRawVideoDir = localPublishVideoEntry.thumbPath;
          if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
            localPublishVideoEntry.mLocalRawPicPath = paramayqb.jdField_a_of_type_Ayqh.aAY;
          }
          localPublishVideoEntry.recordTime = 5000.0D;
          localPublishVideoEntry.recordFrames = 150000;
          paramJobContext = new BitmapFactory.Options();
          paramJobContext.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(localPublishVideoEntry.mLocalRawVideoDir, paramJobContext);
          localPublishVideoEntry.videoWidth = paramJobContext.outWidth;
          localPublishVideoEntry.videoHeight = paramJobContext.outHeight;
          localPublishVideoEntry.videoDuration = 5000L;
          i = 0;
          break;
          localPublishVideoEntry.isLocalPublish = false;
        }
        label1481:
        if ((paramayqb.jdField_a_of_type_Ayqh.aIF) || (!paramayqb.jdField_a_of_type_Ayqh.result)) {
          break label2230;
        }
        paramJobContext = paramayqb.jdField_a_of_type_Ayqh.aAZ;
      }
      for (;;)
      {
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
        break;
        super.notifyError(new ErrorMessage(-1, "illegal argument " + paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource));
        return;
        if (localPublishVideoEntry.thumbPath != null)
        {
          paramJobContext = new File(localPublishVideoEntry.thumbPath);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile()) || (paramJobContext.length() <= 0L))
          {
            super.notifyError(new ErrorMessage(-1, "thumbFile is invalid : " + paramJobContext));
            return;
          }
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
        QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(localPublishVideoEntry);
        ram.i("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
        i = 0;
        if (paramayqb.g.saveMode != 0) {
          i = 1;
        }
        if (paramayqb.aIB) {
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
        if (paramayqb.aIC) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            ras.so("0X80076BD");
          }
          paramJobContext = localPublishVideoEntry.fakeVid;
          localObject1 = localPublishVideoEntry.thumbPath;
          localObject2 = localPublishVideoEntry.doodlePath;
          String str1 = localPublishVideoEntry.videoLabel;
          String str2 = localPublishVideoEntry.videoDoodleDescription;
          String str3 = localPublishVideoEntry.videoAddress;
          int n = localPublishVideoEntry.videoWidth;
          int i1 = localPublishVideoEntry.videoHeight;
          long l = localPublishVideoEntry.videoDuration;
          int i2 = localPublishVideoEntry.videoMaxrate;
          int i3 = localPublishVideoEntry.videoMinrate;
          int i4 = localPublishVideoEntry.saveMode;
          int i5 = localPublishVideoEntry.recordFrames;
          String str4 = localPublishVideoEntry.atDoodlePath;
          String str5 = localPublishVideoEntry.atJsonData;
          int j;
          int k;
          if (localPublishVideoEntry.isPicture)
          {
            j = 1;
            if (!paramayqb.aID) {
              break label2215;
            }
            k = 1;
            if (!localPublishVideoEntry.hwEncodeRecordVideo) {
              break label2221;
            }
          }
          for (int m = 1;; m = 0)
          {
            paramayqb.b = new PublishParam(paramJobContext, (String)localObject1, (String)localObject2, str1, str2, str3, n, i1, l, i2, i3, i, i4, i5, str4, str5, j, k, m, localPublishVideoEntry.mLocalRawVideoDir, localPublishVideoEntry.mAudioFilePath, localPublishVideoEntry.mIFrameVideoPath, localPublishVideoEntry.mosaicPath, paramayqb.bsP, localPublishVideoEntry.isLocalPublish, localPublishVideoEntry.videoLocationDescription, localPublishVideoEntry.videoLongitude, localPublishVideoEntry.videoLatitude, localPublishVideoEntry.redBagType, localPublishVideoEntry.specialVideoType);
            super.notifyResult(paramayqb);
            return;
            j = 0;
            break;
            k = 0;
            break label2091;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqw
 * JD-Core Version:    0.7.0.1
 */