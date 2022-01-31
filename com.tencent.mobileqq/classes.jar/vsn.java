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

public class vsn
  extends vsq<vsd, vsd>
  implements sxo
{
  public final int a;
  public final String a;
  public final WeakReference<veu> a;
  public final WeakReference<vev> b;
  
  public vsn(veu paramveu)
  {
    this(paramveu, null, 0);
  }
  
  public vsn(veu paramveu, vev paramvev, int paramInt)
  {
    this(paramveu, paramvev, null, paramInt);
  }
  
  public vsn(veu paramveu, vev paramvev, String paramString, int paramInt)
  {
    if (paramveu == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramveu);
    this.b = new WeakReference(paramvev);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, vsd paramvsd)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramvsd.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      vel.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    veu localveu = (veu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    vev localvev = (vev)this.b.get();
    int i = paramvsd.jdField_a_of_type_Vsj.c;
    Object localObject;
    if ((localveu != null) && ((!localveu.a(this.jdField_a_of_type_Int)) || ((localvev != null) && (localvev.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localveu.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramvsd.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramvsd.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramvsd.jdField_a_of_type_Vsj.c;
          paramJobContext = vzo.a((Bitmap)localObject, 360 - i);
          veg.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = vst.a(paramvsd.jdField_a_of_type_Int, paramvsd.b, "mosaic.png");
      }
    }
    label782:
    label924:
    label930:
    for (;;)
    {
      try
      {
        vxy.a(paramJobContext, (String)localObject, null);
        paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        veg.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localveu.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = vst.a(paramvsd.jdField_a_of_type_Int, paramvsd.b, ".png");
        }
        if (localBitmap == null) {
          break label856;
        }
        if (localvev != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = vxy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localvev.a(this.jdField_a_of_type_Int)) {
            localvev.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bbdr.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = vxy.c(localBitmap, i, j, true, false);
            i = paramvsd.c;
            if ((i == 0) || (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (i == 0) || (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)) {
              break label930;
            }
            localObject = vzo.a((Bitmap)localObject, i);
            if (localObject == null) {
              break label924;
            }
            if (paramvsd.jdField_a_of_type_Int != 1) {
              break label782;
            }
            str = vst.a(paramvsd.jdField_a_of_type_Int, paramvsd.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            veg.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            vxy.a((Bitmap)localObject, str, null);
            paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            veg.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = vxy.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localveu.a(localBitmap);
          if (localObject != localBitmap) {
            vxy.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label810;
          }
          veg.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          vel.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          vel.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramvsd);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localveu.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        veg.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        veg.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label810:
      veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      vel.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label856:
      veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      vel.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      veg.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramvsd.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramvsd);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */