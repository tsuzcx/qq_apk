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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tribe.async.async.JobContext;
import java.io.File;

public class rle
  extends rkz<rkm, rkm>
{
  private final EditVideoParams a;
  
  public rle(@NonNull EditVideoParams paramEditVideoParams)
  {
    this.a = paramEditVideoParams;
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    ram.i("Q.qqstory.publish.edit.PublishVideoSegment", "PublishVideoSegment.");
    PublishVideoEntry localPublishVideoEntry = paramrkm.g;
    localPublishVideoEntry.publishFrom = this.a.th();
    localPublishVideoEntry.businessId = this.a.asi;
    localPublishVideoEntry.fakeVid = StoryVideoItem.makeFakeVid();
    localPublishVideoEntry.mLocalDate = qvf.jf();
    localPublishVideoEntry.timeZoneOffset = (rpq.tP() * 1000);
    if (localPublishVideoEntry.createTime == 0L) {
      localPublishVideoEntry.createTime = NetConnInfoCenter.getServerTimeMillis();
    }
    ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish date:%s and time:%d", new Object[] { localPublishVideoEntry.mLocalDate, Long.valueOf(localPublishVideoEntry.createTime) });
    localPublishVideoEntry.publishState = 1;
    localPublishVideoEntry.videoUploadTempDir = paramrkm.aAU;
    if (localPublishVideoEntry.videoUploadTempDir != null) {
      rox.sG(localPublishVideoEntry.videoUploadTempDir);
    }
    localPublishVideoEntry.redBagType = this.a.getIntExtra("video_redbag_get", 0);
    if (localPublishVideoEntry.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
    {
      localPublishVideoEntry.putExtra("redBagType", Integer.valueOf(localPublishVideoEntry.redBagType));
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "VideoRedbag, publishVideoEntry take redbag flag");
    }
    localPublishVideoEntry.specialVideoType = this.a.getIntExtra("special_video_type", 0);
    if (localPublishVideoEntry.specialVideoType == 2)
    {
      localPublishVideoEntry.putExtra("special_video_type", Integer.valueOf(localPublishVideoEntry.specialVideoType));
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : specialVideoType = %d", new Object[] { Integer.valueOf(localPublishVideoEntry.specialVideoType) });
    }
    Object localObject2;
    Object localObject1;
    if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
    {
      localPublishVideoEntry.hwEncodeRecordVideo = true;
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = false;
      paramJobContext = (EditTakeVideoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.getSourcePath();
      localPublishVideoEntry.recordTime = paramJobContext.d.mDuration;
      localPublishVideoEntry.recordFrames = ((int)paramJobContext.d.mDuration * 30);
      localPublishVideoEntry.mAudioFilePath = paramJobContext.azv;
      if (rpv.getRotation(paramJobContext.getSourcePath()) % 180 > 0) {
        localPublishVideoEntry.videoWidth = paramJobContext.getHeight();
      }
      for (localPublishVideoEntry.videoHeight = paramJobContext.getWidth();; localPublishVideoEntry.videoHeight = paramJobContext.getHeight())
      {
        localPublishVideoEntry.videoDuration = paramJobContext.d.mDuration;
        if ((localPublishVideoEntry.getBooleanExtra("enable_flow_decode", true)) || (localPublishVideoEntry.saveMode != 5) || (rox.fileExistsAndNotEmpty(localPublishVideoEntry.mIFrameVideoPath))) {
          break;
        }
        super.notifyError(new ErrorMessage(-1, "back mode but iframe file is empty"));
        return;
        localPublishVideoEntry.videoWidth = paramJobContext.getWidth();
      }
      localPublishVideoEntry.videoCreateTime = paramJobContext.d.addedDate;
      ram.w("Q.qqstory.publish.edit.PublishVideoSegment", "publish : edit source = %s", new Object[] { paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
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
      if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir)) {
        super.notifyError(new ErrorMessage(-1, "mLocalRawVideoDir is empty"));
      }
    }
    else if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      localPublishVideoEntry.isPicture = false;
      localPublishVideoEntry.isLocalPublish = true;
      localObject2 = (EditLocalVideoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
      paramJobContext = ((EditLocalVideoSource)localObject2).getSourcePath();
      if (this.a.tg() == 1) {
        break label2182;
      }
      localObject1 = new File(paramJobContext);
      localObject1 = aasa.bea + localPublishVideoEntry.fakeVid + File.separator + ((File)localObject1).getName();
      if (!aqhq.copyFile(paramJobContext, (String)localObject1)) {
        break label2182;
      }
      paramJobContext = (JobContext)localObject1;
    }
    label2179:
    label2182:
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
        localPublishVideoEntry.videoDuration = ((EditLocalVideoSource)localObject2).d.mDuration;
        localPublishVideoEntry.videoCreateTime = ((EditLocalVideoSource)localObject2).d.addedDate;
        break;
        localPublishVideoEntry.videoWidth = ((EditLocalVideoSource)localObject2).getWidth();
      }
      if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
      {
        localPublishVideoEntry.isPicture = false;
        localPublishVideoEntry.isLocalPublish = false;
        paramJobContext = (EditRecordVideoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext.getSourcePath();
        localPublishVideoEntry.recordTime = paramJobContext.recordTime;
        localPublishVideoEntry.recordFrames = paramJobContext.bpF;
        localPublishVideoEntry.videoWidth = paramJobContext.getWidth();
        localPublishVideoEntry.videoHeight = paramJobContext.getHeight();
        if (paramrkm.g.saveMode == 1)
        {
          localPublishVideoEntry.videoDuration = (paramJobContext.recordTime / 2L);
          break;
        }
        if (paramrkm.g.saveMode == 2)
        {
          localPublishVideoEntry.videoDuration = (paramJobContext.recordTime * 2L);
          break;
        }
        localPublishVideoEntry.videoDuration = paramJobContext.recordTime;
        break;
      }
      if (((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)))
      {
        localPublishVideoEntry.isPicture = true;
        paramJobContext = paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.getSourcePath();
        if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
        {
          localObject1 = (EditLocalPhotoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
          localPublishVideoEntry.isLocalPublish = true;
          localPublishVideoEntry.videoCreateTime = ((EditLocalPhotoSource)localObject1).d.addedDate;
          label1276:
          if ((paramrkm.jdField_a_of_type_Rkq.aIF) || (!paramrkm.jdField_a_of_type_Rkq.result)) {
            break label2179;
          }
          paramJobContext = paramrkm.jdField_a_of_type_Rkq.aAZ;
        }
      }
      for (;;)
      {
        localPublishVideoEntry.mLocalRawVideoDir = paramJobContext;
        if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
          localPublishVideoEntry.mLocalRawPicPath = paramrkm.jdField_a_of_type_Rkq.aAY;
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
        break label1276;
        super.notifyError(new ErrorMessage(-1, "illegal argument " + paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource));
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
        QQStoryContext.a().getEntityManagerFactory().createEntityManager().persistOrReplace(localPublishVideoEntry);
        ram.i("Q.qqstory.publish.edit.PublishVideoSegment", "after persist or replace.");
        int i = 0;
        if (paramrkm.g.saveMode != 0) {
          i = 1;
        }
        if (paramrkm.aIB) {
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
        if (paramrkm.aIC) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            ras.so("0X80076BD");
          }
          boolean bool;
          label1892:
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
          label2007:
          int k;
          if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            if (i == 1)
            {
              bool = true;
              alwx.cAb = bool;
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
                break label2158;
              }
              j = 1;
              if (!paramrkm.aID) {
                break label2164;
              }
              k = 1;
              label2017:
              if (!localPublishVideoEntry.hwEncodeRecordVideo) {
                break label2170;
              }
            }
          }
          label2158:
          label2164:
          label2170:
          for (int m = 1;; m = 0)
          {
            paramrkm.b = new PublishParam(paramJobContext, (String)localObject1, (String)localObject2, str1, str2, str3, n, i1, l, i2, i3, i, i4, i5, str4, str5, j, k, m, localPublishVideoEntry.mLocalRawVideoDir, localPublishVideoEntry.mAudioFilePath, localPublishVideoEntry.mIFrameVideoPath, localPublishVideoEntry.mosaicPath, paramrkm.bsP, localPublishVideoEntry.isLocalPublish, localPublishVideoEntry.redBagType, localPublishVideoEntry.specialVideoType);
            super.notifyResult(paramrkm);
            return;
            bool = false;
            break;
            if (!(paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
              break label1892;
            }
            if (i == 1) {}
            for (bool = true;; bool = false)
            {
              alwx.cAc = bool;
              break;
            }
            j = 0;
            break label2007;
            k = 0;
            break label2017;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rle
 * JD-Core Version:    0.7.0.1
 */