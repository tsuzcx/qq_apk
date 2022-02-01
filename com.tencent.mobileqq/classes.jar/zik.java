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
public class zik
  extends ziu<zih, zih>
{
  private final String a;
  public WeakReference<yuy> a;
  
  public zik()
  {
    this(null);
  }
  
  public zik(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(zih paramzih, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    bbmz localbbmz = new bbmz();
    localbbmz.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramzih = (zih)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramzih = (zih)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      paramzih = ((yuy)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (paramzih != null)
      {
        localObject = (bbnd)bbmy.a(106);
        ((bbnd)localObject).a(paramzih);
        ((bbnd)localObject).init();
        paramzih = localbbmz.a(paramBitmap, (GPUBaseFilter)localObject);
        yuk.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramzih);
        if (paramzih != null) {
          paramBitmap = paramzih;
        }
        ((bbnd)localObject).destroy();
        localObject = paramBitmap;
      }
      localbbmz.a();
      return localObject;
    }
    catch (Exception paramzih)
    {
      for (;;)
      {
        yuk.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramzih.toString());
        paramzih = (zih)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    String str1;
    if (((paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str1 = this.jdField_a_of_type_JavaLangString;
      if (str1 != null) {
        break label481;
      }
      str1 = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".jpg");
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
      if ((paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      String str2 = paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      paramJobContext = null;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(str2);
          if (!paramzih.jdField_a_of_type_Zin.a) {
            continue;
          }
          l1 = 0L;
          if ((paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
            l1 = i;
          }
        }
        catch (IllegalArgumentException paramJobContext)
        {
          long l1;
          Object localObject;
          boolean bool;
          yuk.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + str2, paramJobContext);
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
            if (paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate) {
              localObject = zps.a(paramJobContext, 90.0F);
            }
          }
          paramJobContext = (JobContext)localObject;
          if ((paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            paramJobContext = a(paramzih, (Bitmap)localObject);
          }
          if (paramJobContext == null) {
            break label429;
          }
          bool = zoc.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str1);
          paramJobContext.recycle();
          if (!bool) {
            break label407;
          }
          paramJobContext = new File(str1);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
            break label414;
          }
          yuk.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str1);
          paramzih.jdField_a_of_type_JavaLangString = str1;
          super.notifyResult(paramzih);
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
          yuk.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
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
          yuk.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", localOutOfMemoryError);
        }
        continue;
        yuk.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
        for (;;)
        {
          notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
          return;
          yuk.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
          continue;
          yuk.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
        }
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zik
 * JD-Core Version:    0.7.0.1
 */