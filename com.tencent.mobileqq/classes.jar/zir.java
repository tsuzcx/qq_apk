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

public class zir
  extends ziu<zih, zih>
  implements wnt
{
  public final int a;
  public final String a;
  public final WeakReference<yuy> a;
  public final WeakReference<yuz> b;
  
  public zir(yuy paramyuy)
  {
    this(paramyuy, null, 0);
  }
  
  public zir(yuy paramyuy, yuz paramyuz, int paramInt)
  {
    this(paramyuy, paramyuz, null, paramInt);
  }
  
  public zir(yuy paramyuy, yuz paramyuz, String paramString, int paramInt)
  {
    if (paramyuy == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramyuy);
    this.b = new WeakReference(paramyuz);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, zih paramzih)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramzih.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      yup.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    yuy localyuy = (yuy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    yuz localyuz = (yuz)this.b.get();
    int i = paramzih.jdField_a_of_type_Zin.c;
    Object localObject;
    if ((localyuy != null) && ((!localyuy.a(this.jdField_a_of_type_Int)) || ((localyuz != null) && (localyuz.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localyuy.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramzih.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramzih.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramzih.jdField_a_of_type_Zin.c;
          paramJobContext = zps.a((Bitmap)localObject, 360 - i);
          yuk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        zoc.a(paramJobContext, (String)localObject, null);
        paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        yuk.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localyuy.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localyuz != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = zoc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localyuz.a(this.jdField_a_of_type_Int)) {
            localyuz.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bhmq.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = zoc.c(localBitmap, i, j, true, false);
            i = paramzih.c;
            if ((i == 0) || (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = zps.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramzih.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = zix.a(paramzih.jdField_a_of_type_Int, paramzih.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            yuk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            zoc.a((Bitmap)localObject, str, null);
            paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = zoc.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localyuy.a(localBitmap);
          if (localObject != localBitmap) {
            zoc.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          yuk.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          yup.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          yup.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramzih);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localyuy.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        yuk.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      yup.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      yup.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      yuk.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramzih.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramzih);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zir
 * JD-Core Version:    0.7.0.1
 */