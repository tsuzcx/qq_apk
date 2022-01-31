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
public class vsd
  extends vsn<vsa, vsa>
{
  private final String a;
  public WeakReference<ver> a;
  
  public vsd()
  {
    this(null);
  }
  
  public vsd(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(vsa paramvsa, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    avzx localavzx = new avzx();
    localavzx.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramvsa = (vsa)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramvsa = (vsa)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      paramvsa = ((ver)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (paramvsa != null)
      {
        localObject = (awab)avzw.a(106);
        ((awab)localObject).a(paramvsa);
        ((awab)localObject).init();
        paramvsa = localavzx.a(paramBitmap, (GPUBaseFilter)localObject);
        ved.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramvsa);
        if (paramvsa != null) {
          paramBitmap = paramvsa;
        }
        ((awab)localObject).destroy();
        localObject = paramBitmap;
      }
      localavzx.a();
      return localObject;
    }
    catch (Exception paramvsa)
    {
      for (;;)
      {
        ved.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramvsa.toString());
        paramvsa = (vsa)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    String str1;
    if (((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str1 = this.jdField_a_of_type_JavaLangString;
      if (str1 != null) {
        break label481;
      }
      str1 = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.b, ".jpg");
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
      if ((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      String str2 = paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      paramJobContext = null;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(str2);
          if (!paramvsa.jdField_a_of_type_Vsg.a) {
            continue;
          }
          l1 = 0L;
          if ((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
            l1 = i;
          }
        }
        catch (IllegalArgumentException paramJobContext)
        {
          long l1;
          Object localObject;
          boolean bool;
          ved.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + str2, paramJobContext);
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
            if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate) {
              localObject = vzl.a(paramJobContext, 90.0F);
            }
          }
          paramJobContext = (JobContext)localObject;
          if ((paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            paramJobContext = a(paramvsa, (Bitmap)localObject);
          }
          if (paramJobContext == null) {
            break label429;
          }
          bool = vxv.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str1);
          paramJobContext.recycle();
          if (!bool) {
            break label407;
          }
          paramJobContext = new File(str1);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
            break label414;
          }
          ved.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str1);
          paramvsa.jdField_a_of_type_JavaLangString = str1;
          super.notifyResult(paramvsa);
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
          ved.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
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
          ved.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", localOutOfMemoryError);
        }
        continue;
        ved.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
        for (;;)
        {
          notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
          return;
          ved.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
          continue;
          ved.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
        }
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsd
 * JD-Core Version:    0.7.0.1
 */