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

public class vfr
  extends vfu<vfh, vfh>
  implements sks
{
  public final int a;
  public final String a;
  public final WeakReference<ury> a;
  public final WeakReference<urz> b;
  
  public vfr(ury paramury)
  {
    this(paramury, null, 0);
  }
  
  public vfr(ury paramury, urz paramurz, int paramInt)
  {
    this(paramury, paramurz, null, paramInt);
  }
  
  public vfr(ury paramury, urz paramurz, String paramString, int paramInt)
  {
    if (paramury == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramury);
    this.b = new WeakReference(paramurz);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, vfh paramvfh)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramvfh.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      urp.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    ury localury = (ury)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    urz localurz = (urz)this.b.get();
    int i = paramvfh.jdField_a_of_type_Vfn.c;
    Object localObject;
    if ((localury != null) && ((!localury.a(this.jdField_a_of_type_Int)) || ((localurz != null) && (localurz.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localury.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramvfh.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramvfh.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramvfh.jdField_a_of_type_Vfn.c;
          paramJobContext = vms.a((Bitmap)localObject, 360 - i);
          urk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = vfx.a(paramvfh.jdField_a_of_type_Int, paramvfh.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        vlc.a(paramJobContext, (String)localObject, null);
        paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        urk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localury.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = vfx.a(paramvfh.jdField_a_of_type_Int, paramvfh.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localurz != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = vlc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localurz.a(this.jdField_a_of_type_Int)) {
            localurz.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bacm.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = vlc.c(localBitmap, i, j, true, false);
            i = paramvfh.c;
            if ((i == 0) || (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = vms.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramvfh.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = vfx.a(paramvfh.jdField_a_of_type_Int, paramvfh.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            urk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            vlc.a((Bitmap)localObject, str, null);
            paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            urk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = vlc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localury.a(localBitmap);
          if (localObject != localBitmap) {
            vlc.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          urk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          urp.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          urp.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramvfh);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localury.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        urk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        urk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      urp.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      urp.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      urk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramvfh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramvfh);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfr
 * JD-Core Version:    0.7.0.1
 */