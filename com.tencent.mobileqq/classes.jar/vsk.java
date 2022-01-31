import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class vsk
  extends vsn<vsa, vsa>
  implements sxl
{
  public final int a;
  public final String a;
  public final WeakReference<ver> a;
  public final WeakReference<ves> b;
  
  public vsk(ver paramver)
  {
    this(paramver, null, 0);
  }
  
  public vsk(ver paramver, ves paramves, int paramInt)
  {
    this(paramver, paramves, null, paramInt);
  }
  
  public vsk(ver paramver, ves paramves, String paramString, int paramInt)
  {
    if (paramver == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramver);
    this.b = new WeakReference(paramves);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramvsa.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      vei.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    ver localver = (ver)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ves localves = (ves)this.b.get();
    int i = paramvsa.jdField_a_of_type_Vsg.c;
    Object localObject;
    if ((localver != null) && ((!localver.a(this.jdField_a_of_type_Int)) || ((localves != null) && (localves.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localver.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramvsa.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramvsa.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramvsa.jdField_a_of_type_Vsg.c;
          paramJobContext = vzl.a((Bitmap)localObject, 360 - i);
          ved.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        vxv.a(paramJobContext, (String)localObject, null);
        paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        ved.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localver.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localves != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = vxv.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localves.a(this.jdField_a_of_type_Int)) {
            localves.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bbef.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = vxv.c(localBitmap, i, j, true, false);
            i = paramvsa.c;
            if ((i == 0) || (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = vzl.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramvsa.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = vsq.a(paramvsa.jdField_a_of_type_Int, paramvsa.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            ved.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            vxv.a((Bitmap)localObject, str, null);
            paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            ved.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = vxv.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localver.a(localBitmap);
          if (localObject != localBitmap) {
            vxv.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          ved.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          vei.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          vei.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramvsa);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localver.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        ved.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        ved.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      vei.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      vei.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      ved.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramvsa);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsk
 * JD-Core Version:    0.7.0.1
 */