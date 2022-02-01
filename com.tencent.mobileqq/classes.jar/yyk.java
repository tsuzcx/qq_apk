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

public class yyk
  extends yyn<yya, yya>
  implements wef
{
  public final int a;
  public final String a;
  public final WeakReference<ylc> a;
  public final WeakReference<yld> b;
  
  public yyk(ylc paramylc)
  {
    this(paramylc, null, 0);
  }
  
  public yyk(ylc paramylc, yld paramyld, int paramInt)
  {
    this(paramylc, paramyld, null, paramInt);
  }
  
  public yyk(ylc paramylc, yld paramyld, String paramString, int paramInt)
  {
    if (paramylc == null) {
      throw new NullPointerException("doodleLayout should not be null");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramylc);
    this.b = new WeakReference(paramyld);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void a(JobContext paramJobContext, yya paramyya)
  {
    long l1 = SystemClock.uptimeMillis();
    String str = paramyya.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
      ykv.b("take_video", "create_doodle_result", 0, -1, new String[0]);
      return;
    }
    ylc localylc = (ylc)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    yld localyld = (yld)this.b.get();
    int i = paramyya.jdField_a_of_type_Yyg.c;
    Object localObject;
    if ((localylc != null) && ((!localylc.a(this.jdField_a_of_type_Int)) || ((localyld != null) && (localyld.a(this.jdField_a_of_type_Int)))))
    {
      localObject = localylc.a().a(this.jdField_a_of_type_Int);
      if (localObject != null)
      {
        if (paramyya.jdField_a_of_type_Int != 10)
        {
          paramJobContext = (JobContext)localObject;
          if (paramyya.jdField_a_of_type_Int != 12) {}
        }
        else
        {
          i = paramyya.jdField_a_of_type_Yyg.c;
          paramJobContext = UIUtils.rotateBitmap((Bitmap)localObject, 360 - i);
          ykq.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "rotate mosaic bitmap for tribe, orientation=" + i);
        }
        localObject = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, "mosaic.png");
      }
    }
    label783:
    label925:
    label931:
    for (;;)
    {
      try
      {
        zdr.a(paramJobContext, (String)localObject, null);
        paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mosaicPath = ((String)localObject);
        ykq.a("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "generateMosaicBitmap success %s", localObject);
        localBitmap = localylc.a(this.jdField_a_of_type_Int);
        localObject = this.jdField_a_of_type_JavaLangString;
        paramJobContext = (JobContext)localObject;
        if (localObject == null) {
          paramJobContext = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".png");
        }
        if (localBitmap == null) {
          break label857;
        }
        if (localyld != null) {}
        int k;
        int m;
        int j;
        long l2;
        bool = zdr.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
      }
      catch (IOException paramJobContext)
      {
        try
        {
          if (localyld.a(this.jdField_a_of_type_Int)) {
            localyld.a(this.jdField_a_of_type_Int, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight());
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          try
          {
            bheg.a(str, (BitmapFactory.Options)localObject);
            k = ((BitmapFactory.Options)localObject).outWidth;
            m = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            i = k;
            if (k > m)
            {
              j = m;
              i = k;
              if (paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 10)
              {
                j = m;
                i = k;
                if (k > m)
                {
                  j = m;
                  i = k;
                  if (paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId != 12)
                  {
                    i = ((BitmapFactory.Options)localObject).outHeight;
                    j = ((BitmapFactory.Options)localObject).outWidth;
                  }
                }
              }
            }
            localObject = zdr.c(localBitmap, i, j, true, false);
            i = paramyya.c;
            if ((i == 0) || (paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 10) || (i == 0) || (paramyya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mBusinessId == 12)) {
              break label931;
            }
            localObject = UIUtils.rotateBitmap((Bitmap)localObject, i);
            if (localObject == null) {
              break label925;
            }
            if (paramyya.jdField_a_of_type_Int != 1) {
              break label783;
            }
            str = yyq.a(paramyya.jdField_a_of_type_Int, paramyya.b, ".png");
          }
          catch (OutOfMemoryError paramJobContext)
          {
            ykq.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "decode video thumb failed %s", paramJobContext);
            super.notifyError(new BitmapError("Q.qqstory.publish.edit.GenerateDoodleImageSegment", 6));
            return;
          }
          try
          {
            zdr.a((Bitmap)localObject, str, null);
            paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath = str;
            bool = true;
            paramJobContext = null;
          }
          catch (Throwable localThrowable)
          {
            ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", localThrowable);
            bool = zdr.a((Bitmap)localObject, Bitmap.CompressFormat.PNG, 60, paramJobContext);
            continue;
          }
          localylc.a(localBitmap);
          if (localObject != localBitmap) {
            zdr.a((Bitmap)localObject);
          }
          if ((localObject == null) || (!bool)) {
            break label811;
          }
          ykq.b("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and crop original doodle image success");
          l2 = SystemClock.uptimeMillis();
          ykv.b("take_video", "create_doodle_time", 0, 0, new String[] { "" + (l2 - l1) });
          ykv.b("take_video", "create_doodle_result", 0, 0, new String[0]);
          paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = paramJobContext;
          super.notifyResult(paramyya);
          return;
        }
        finally
        {
          Bitmap localBitmap;
          localylc.a(localBitmap);
        }
        paramJobContext = paramJobContext;
        ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "serializeBitmapToFile failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "should generate video thumb first !"));
        return;
      }
      catch (UnsupportedOperationException paramJobContext)
      {
        ykq.c("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "updateExif failed", paramJobContext);
        super.notifyError(new ErrorMessage(-1, "updateExif failed."));
        return;
      }
      continue;
      label811:
      ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "resize and save doodle image failed");
      ykv.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "Resize or store doodle failed"));
      return;
      label857:
      ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "get doodle bitmap failed");
      ykv.b("take_video", "create_doodle_result", 0, -2, new String[0]);
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyError(new ErrorMessage(-1, "DoodleLayout get bitmap failed"));
      return;
      ykq.d("Q.qqstory.publish.edit.GenerateDoodleImageSegment", "do not generate doodle image because doodle is empty");
      paramyya.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath = null;
      super.notifyResult(paramyya);
      return;
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyk
 * JD-Core Version:    0.7.0.1
 */