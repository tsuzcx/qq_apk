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

public class xll
  extends xlo<xlb, xlb>
  implements uqm
{
  public final int a;
  public final String a;
  public final WeakReference<wxs> a;
  public final WeakReference<wxt> b;
  
  public xll(wxs paramwxs)
  {
    this(paramwxs, null, 0);
  }
  
  public xll(wxs paramwxs, wxt paramwxt, int paramInt)
  {
    this(paramwxs, paramwxt, null, paramInt);
  }
  
  public xll(wxs paramwxs, wxt paramwxt, String paramString, int paramInt)
  {
    if (paramwxs == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwxs);
    this.b = new WeakReference(paramwxt);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, xlb paramxlb)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramxlb.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      wxj.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    wxs localwxs = (wxs)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    wxt localwxt = (wxt)this.b.get();
    int i = paramxlb.jdField_a_of_type_Xlh.c;
    Object localObject;
    if ((localwxs != null) && ((!localwxs.a(this.jdField_a_of_type_Int)) || ((localwxt != null) && (localwxt.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localwxs.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramxlb.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramxlb.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramxlb.jdField_a_of_type_Xlh.c;
          paramJobContext = xsm.a((Bitmap)localObject, 360 - i);
          wxe.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = xlr.a(paramxlb.jdField_a_of_type_Int, paramxlb.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        xqw.a(paramJobContext, (String)localObject, null);
        paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        wxe.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localwxs.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = xlr.a(paramxlb.jdField_a_of_type_Int, paramxlb.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localwxt != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = xqw.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localwxt.a(this.jdField_a_of_type_Int)) {
            localwxt.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bdhj.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = xqw.c(localBitmap, i, j, true, false);
            i = paramxlb.c;
            if ((i == 0) || (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = xsm.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramxlb.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = xlr.a(paramxlb.jdField_a_of_type_Int, paramxlb.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            wxe.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            xqw.a((Bitmap)localObject, str, null);
            paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            wxe.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = xqw.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localwxs.a(localBitmap);
          if (localObject != localBitmap) {
            xqw.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          wxe.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          wxj.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          wxj.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramxlb);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localwxs.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        wxe.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        wxe.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      wxj.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      wxj.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      wxe.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramxlb.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramxlb);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xll
 * JD-Core Version:    0.7.0.1
 */