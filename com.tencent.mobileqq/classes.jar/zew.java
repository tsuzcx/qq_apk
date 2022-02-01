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

public class zew
  extends zez<zem, zem>
  implements wjy
{
  public final int a;
  public final String a;
  public final WeakReference<yrd> a;
  public final WeakReference<yre> b;
  
  public zew(yrd paramyrd)
  {
    this(paramyrd, null, 0);
  }
  
  public zew(yrd paramyrd, yre paramyre, int paramInt)
  {
    this(paramyrd, paramyre, null, paramInt);
  }
  
  public zew(yrd paramyrd, yre paramyre, String paramString, int paramInt)
  {
    if (paramyrd == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyrd);
    this.b = new WeakReference(paramyre);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, zem paramzem)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramzem.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      yqu.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    yrd localyrd = (yrd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    yre localyre = (yre)this.b.get();
    int i = paramzem.jdField_a_of_type_Zes.c;
    Object localObject;
    if ((localyrd != null) && ((!localyrd.a(this.jdField_a_of_type_Int)) || ((localyre != null) && (localyre.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localyrd.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramzem.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramzem.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramzem.jdField_a_of_type_Zes.c;
          paramJobContext = zlx.a((Bitmap)localObject, 360 - i);
          yqp.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = zfc.a(paramzem.jdField_a_of_type_Int, paramzem.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        zkh.a(paramJobContext, (String)localObject, null);
        paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        yqp.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localyrd.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = zfc.a(paramzem.jdField_a_of_type_Int, paramzem.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localyre != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = zkh.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localyre.a(this.jdField_a_of_type_Int)) {
            localyre.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bgmo.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = zkh.c(localBitmap, i, j, true, false);
            i = paramzem.c;
            if ((i == 0) || (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = zlx.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramzem.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = zfc.a(paramzem.jdField_a_of_type_Int, paramzem.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            yqp.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            zkh.a((Bitmap)localObject, str, null);
            paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            yqp.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = zkh.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localyrd.a(localBitmap);
          if (localObject != localBitmap) {
            zkh.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          yqp.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          yqu.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          yqu.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramzem);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localyrd.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        yqp.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        yqp.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      yqu.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      yqu.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      yqp.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramzem.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramzem);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zew
 * JD-Core Version:    0.7.0.1
 */