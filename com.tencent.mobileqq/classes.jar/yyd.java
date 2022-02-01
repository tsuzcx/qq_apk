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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tribe.async.async.JobContext;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class yyd
  extends yyn<yya, yya>
{
  private final String a;
  public WeakReference<ylc> a;
  
  public yyd()
  {
    this(null);
  }
  
  public yyd(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(yya paramyya, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    bbnj localbbnj = new bbnj();
    localbbnj.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramyya = (yya)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramyya = (yya)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      paramyya = ((ylc)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (paramyya != null)
      {
        localObject = (bbnn)bbni.a(106);
        ((bbnn)localObject).a(paramyya);
        ((bbnn)localObject).init();
        paramyya = localbbnj.a(paramBitmap, (GPUBaseFilter)localObject);
        ykq.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramyya);
        if (paramyya != null) {
          paramBitmap = paramyya;
        }
        ((bbnn)localObject).destroy();
        localObject = paramBitmap;
      }
      localbbnj.a();
      return localObject;
    }
    catch (Exception paramyya)
    {
      for (;;)
      {
        ykq.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramyya.toString());
        paramyya = (yya)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    String str1;
    if (((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str1 = this.jdField_a_of_type_JavaLangString;
      if (str1 != null) {
        break label481;
      }
      str1 = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".jpg");
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
      if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      String str2 = paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.getSourcePath();
      paramJobContext = null;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(str2);
          if (!paramyya.jdField_a_of_type_Yyg.a) {
            continue;
          }
          l1 = 0L;
          if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
            l1 = i;
          }
        }
        catch (IllegalArgumentException paramJobContext)
        {
          long l1;
          Object localObject;
          boolean bool;
          ykq.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + str2, paramJobContext);
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
            if (paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate) {
              localObject = UIUtils.rotateBitmap(paramJobContext, 90.0F);
            }
          }
          paramJobContext = (JobContext)localObject;
          if ((paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
            paramJobContext = a(paramyya, (Bitmap)localObject);
          }
          if (paramJobContext == null) {
            break label429;
          }
          bool = zdr.a(paramJobContext, Bitmap.CompressFormat.JPEG, 80, str1);
          paramJobContext.recycle();
          if (!bool) {
            break label407;
          }
          paramJobContext = new File(str1);
          if ((!paramJobContext.exists()) || (!paramJobContext.isFile())) {
            break label414;
          }
          ykq.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "success : %s", str1);
          paramyya.jdField_a_of_type_JavaLangString = str1;
          super.notifyResult(paramyya);
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
          ykq.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime endTime * 1000L oom", paramJobContext);
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
          ykq.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", localOutOfMemoryError);
        }
        continue;
        ykq.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
        for (;;)
        {
          notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
          return;
          ykq.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
          continue;
          ykq.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
        }
        paramJobContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyd
 * JD-Core Version:    0.7.0.1
 */