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

public class xhc
  extends xhf<xgs, xgs>
  implements umd
{
  public final int a;
  public final String a;
  public final WeakReference<wtj> a;
  public final WeakReference<wtk> b;
  
  public xhc(wtj paramwtj)
  {
    this(paramwtj, null, 0);
  }
  
  public xhc(wtj paramwtj, wtk paramwtk, int paramInt)
  {
    this(paramwtj, paramwtk, null, paramInt);
  }
  
  public xhc(wtj paramwtj, wtk paramwtk, String paramString, int paramInt)
  {
    if (paramwtj == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwtj);
    this.b = new WeakReference(paramwtk);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, xgs paramxgs)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramxgs.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      wta.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    wtj localwtj = (wtj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    wtk localwtk = (wtk)this.b.get();
    int i = paramxgs.jdField_a_of_type_Xgy.c;
    Object localObject;
    if ((localwtj != null) && ((!localwtj.a(this.jdField_a_of_type_Int)) || ((localwtk != null) && (localwtk.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localwtj.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramxgs.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramxgs.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramxgs.jdField_a_of_type_Xgy.c;
          paramJobContext = xod.a((Bitmap)localObject, 360 - i);
          wsv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        xmn.a(paramJobContext, (String)localObject, null);
        paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        wsv.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localwtj.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localwtk != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = xmn.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localwtk.a(this.jdField_a_of_type_Int)) {
            localwtk.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bdda.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = xmn.c(localBitmap, i, j, true, false);
            i = paramxgs.c;
            if ((i == 0) || (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = xod.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramxgs.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = xhi.a(paramxgs.jdField_a_of_type_Int, paramxgs.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            wsv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            xmn.a((Bitmap)localObject, str, null);
            paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            wsv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = xmn.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localwtj.a(localBitmap);
          if (localObject != localBitmap) {
            xmn.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          wsv.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          wta.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          wta.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramxgs);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localwtj.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        wsv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        wsv.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      wta.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      wta.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      wsv.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramxgs.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramxgs);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhc
 * JD-Core Version:    0.7.0.1
 */