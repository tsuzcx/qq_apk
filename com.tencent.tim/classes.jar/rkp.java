import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class rkp
  extends rkz<rkm, rkm>
{
  private final String aAX;
  public WeakReference<rba> dh;
  
  public rkp()
  {
    this(null);
  }
  
  public rkp(String paramString)
  {
    this.aAX = paramString;
  }
  
  private Bitmap b(rkm paramrkm, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    amat localamat = new amat();
    localamat.init(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramrkm = (rkm)localObject;
    if (this.dh != null)
    {
      paramrkm = (rkm)localObject;
      if (this.dh.get() == null) {}
    }
    try
    {
      paramrkm = ((rba)this.dh.get()).a().h(0);
      localObject = paramBitmap;
      if (paramrkm != null)
      {
        localObject = (amax)amas.a(106);
        ((amax)localObject).ae(paramrkm);
        ((amax)localObject).init();
        paramrkm = localamat.a(paramBitmap, (GPUBaseFilter)localObject);
        ram.b("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramrkm);
        if (paramrkm != null) {
          paramBitmap = paramrkm;
        }
        ((amax)localObject).destroy();
        localObject = paramBitmap;
      }
      localamat.destory();
      return localObject;
    }
    catch (Exception paramrkm)
    {
      for (;;)
      {
        ram.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramrkm.toString());
        paramrkm = (rkm)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, rkm paramrkm)
  {
    String str1;
    if (((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str1 = this.aAX;
      if (str1 != null) {
        break label483;
      }
      str1 = rlc.f(paramrkm.businessId, paramrkm.aAU, ".jpg");
    }
    label407:
    label414:
    label430:
    label475:
    label480:
    label483:
    for (;;)
    {
      long l2 = 0L;
      if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).startTime;
      }
      String str2 = paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.getSourcePath();
      paramJobContext = null;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(str2);
          if (!paramrkm.jdField_a_of_type_Rks.aIH) {
            continue;
          }
          l1 = 0L;
          if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).endTime;
            l1 = i;
          }
        }
        catch (IllegalArgumentException paramJobContext)
        {
          long l1;
          Object localObject;
          boolean bool;
          ram.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + str2, paramJobContext);
          if (localMediaMetadataRetriever == null) {
            break label475;
          }
          localMediaMetadataRetriever.release();
          paramJobContext = null;
          continue;
        }
        finally
        {
          if (localMediaMetadataRetriever == null) {
            continue;
          }
          localMediaMetadataRetriever.release();
        }
        try
        {
          paramJobContext = localMediaMetadataRetriever.getFrameAtTime(l1 * 1000L);
          if (localMediaMetadataRetriever == null) {
            break label480;
          }
          localMediaMetadataRetriever.release();
          localObject = paramJobContext;
          if (paramJobContext != null)
          {
            localObject = paramJobContext;
            if (paramrkm.g.videoNeedRotate) {
              localObject = rpq.rotateBitmap(paramJobContext, 90.0F);
            }
          }
          paramJobContext = (JobContext)localObject;
          if ((paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            paramJobContext = b(paramrkm, (Bitmap)localObject);
          }
          if (paramJobContext == null) {
            break label430;
          }
          bool = rop.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str1);
          paramJobContext.recycle();
          if (!bool) {
            break label407;
          }
          paramJobContext = new File(str1);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
            break label414;
          }
          ram.b("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str1);
          paramrkm.aAT = str1;
          super.notifyResult(paramrkm);
          return;
          paramJobContext = localMediaMetadataRetriever.extractMetadata(9);
          if (paramJobContext == null) {
            continue;
          }
          l1 = Long.valueOf(paramJobContext).longValue();
          continue;
        }
        catch (OutOfMemoryError paramJobContext)
        {
          ram.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
          paramJobContext = null;
          continue;
        }
        try
        {
          localObject = localMediaMetadataRetriever.getFrameAtTime(1000L * l2);
          paramJobContext = (JobContext)localObject;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ram.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", localOutOfMemoryError);
        }
        continue;
        ram.w("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
        for (;;)
        {
          notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
          return;
          ram.w("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
          continue;
          ram.w("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
        }
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rkp
 * JD-Core Version:    0.7.0.1
 */