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
public class xgv
  extends xhf<xgs, xgs>
{
  private final String a;
  public WeakReference<wtj> a;
  
  public xgv()
  {
    this(null);
  }
  
  public xgv(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(xgs paramxgs, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    axrw localaxrw = new axrw();
    localaxrw.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramxgs = (xgs)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramxgs = (xgs)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      paramxgs = ((wtj)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (paramxgs != null)
      {
        localObject = (axsa)axrv.a(106);
        ((axsa)localObject).a(paramxgs);
        ((axsa)localObject).init();
        paramxgs = localaxrw.a(paramBitmap, (GPUBaseFilter)localObject);
        wsv.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramxgs);
        if (paramxgs != null) {
          paramBitmap = paramxgs;
        }
        ((axsa)localObject).destroy();
        localObject = paramBitmap;
      }
      localaxrw.a();
      return localObject;
    }
    catch (Exception paramxgs)
    {
      for (;;)
      {
        wsv.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramxgs.toString());
        paramxgs = (xgs)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, xgs paramxgs)
  {
    String str1;
    if (((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str1 = this.jdField_a_of_type_JavaLangString;
      if (str1 != null) {
        break label481;
      }
      str1 = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.b, ".jpg");
    }
    label407:
    label414:
    label429:
    label473:
    label478:
    label481:
    for (;;)
    {
      long l2 = 0L;
      if ((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      String str2 = paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      paramJobContext = null;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(str2);
          if (!paramxgs.jdField_a_of_type_Xgy.a) {
            continue;
          }
          l1 = 0L;
          if ((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
            l1 = i;
          }
        }
        catch (IllegalArgumentException paramJobContext)
        {
          long l1;
          Object localObject;
          boolean bool;
          wsv.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + str2, paramJobContext);
          if (localMediaMetadataRetriever == null) {
            break label473;
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
            break label478;
          }
          localMediaMetadataRetriever.release();
          localObject = paramJobContext;
          if (paramJobContext != null)
          {
            localObject = paramJobContext;
            if (paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate) {
              localObject = xod.a(paramJobContext, 90.0F);
            }
          }
          paramJobContext = (JobContext)localObject;
          if ((paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            paramJobContext = a(paramxgs, (Bitmap)localObject);
          }
          if (paramJobContext == null) {
            break label429;
          }
          bool = xmn.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str1);
          paramJobContext.recycle();
          if (!bool) {
            break label407;
          }
          paramJobContext = new File(str1);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
            break label414;
          }
          wsv.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str1);
          paramxgs.jdField_a_of_type_JavaLangString = str1;
          super.notifyResult(paramxgs);
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
          wsv.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
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
          wsv.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", localOutOfMemoryError);
        }
        continue;
        wsv.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
        for (;;)
        {
          notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
          return;
          wsv.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
          continue;
          wsv.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
        }
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xgv
 * JD-Core Version:    0.7.0.1
 */