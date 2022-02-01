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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tribe.async.async.JobContext;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class yjr
  extends yju<yjh, yjh>
  implements vpk
{
  public final int a;
  public final String a;
  public final WeakReference<xwj> a;
  public final WeakReference<xwk> b;
  
  public yjr(xwj paramxwj)
  {
    this(paramxwj, null, 0);
  }
  
  public yjr(xwj paramxwj, xwk paramxwk, int paramInt)
  {
    this(paramxwj, paramxwk, null, paramInt);
  }
  
  public yjr(xwj paramxwj, xwk paramxwk, String paramString, int paramInt)
  {
    if (paramxwj == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxwj);
    this.b = new WeakReference(paramxwk);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, yjh paramyjh)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramyjh.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      xwa.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    xwj localxwj = (xwj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    xwk localxwk = (xwk)this.b.get();
    int i = paramyjh.jdField_a_of_type_Yjn.c;
    Object localObject;
    if ((localxwj != null) && ((!localxwj.a(this.jdField_a_of_type_Int)) || ((localxwk != null) && (localxwk.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localxwj.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramyjh.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramyjh.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramyjh.jdField_a_of_type_Yjn.c;
          paramJobContext = UIUtils.rotateBitmap((Bitmap)localObject, 360 - i);
          xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, "mosaic.png");
      }
    }
    label783:
    label925:
    label931:
    for (;;)
    {
      try
      {
        yoy.a(paramJobContext, (String)localObject, null);
        paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        xvv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localxwj.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, ".png");
        }
        if (localBitmap == null) {
          break label857;
        }
        if (localxwk != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = yoy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localxwk.a(this.jdField_a_of_type_Int)) {
            localxwk.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bfvo.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = yoy.c(localBitmap, i, j, true, false);
            i = paramyjh.c;
            if ((i == 0) || (paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 10) || (i == 0) || (paramyjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 12)) {
              break label931;
            }
            localObject = UIUtils.rotateBitmap((Bitmap)localObject, i);
            if (localObject == null) {
              break label925;
            }
            if (paramyjh.jdField_a_of_type_Int != 1) {
              break label783;
            }
            str = yjx.a(paramyjh.jdField_a_of_type_Int, paramyjh.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            yoy.a((Bitmap)localObject, str, null);
            paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = yoy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localxwj.a(localBitmap);
          if (localObject != localBitmap) {
            yoy.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label811;
          }
          xvv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          xwa.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          xwa.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramyjh);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localxwj.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        xvv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label811:
      xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label857:
      xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      xwa.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      xvv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramyjh);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjr
 * JD-Core Version:    0.7.0.1
 */