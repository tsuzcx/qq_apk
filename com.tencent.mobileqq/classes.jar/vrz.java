import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.io.IOException;

public class vrz
  extends vsn<vsa, vsa>
{
  protected void a(JobContext paramJobContext, vsa paramvsa)
  {
    paramJobContext = null;
    if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath == null)
    {
      super.notifyError(new ErrorMessage(-1, "DoodleRotateSegment error, you must merger everything first"));
      return;
    }
    String str2 = paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str1 = paramvsa.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    if ((str1 == null) && (str2 == null))
    {
      super.notifyResult(paramvsa);
      return;
    }
    int i = paramvsa.jdField_a_of_type_Vsg.c;
    int j = paramvsa.jdField_a_of_type_Int;
    if ((j == 2) || (j == 3) || (j == 5) || (j == 101) || (j == 104) || (j == 6)) {
      if (str2 == null) {}
    }
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        Bitmap localBitmap = vxv.a(str2, null);
        paramJobContext = localBitmap;
        j = 1;
        if ((paramJobContext != null) || (str1 == null)) {
          break label269;
        }
        j = 0;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          localBitmap = BitmapFactory.decodeFile(str1);
          paramJobContext = localBitmap;
          if (paramJobContext == null) {
            break label316;
          }
          if (i == 270)
          {
            i = 90;
            paramJobContext = vsb.a(paramJobContext, i);
            if (paramJobContext == null) {
              break label338;
            }
            if (j == 0) {
              break label295;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          ved.c("Q.qqstory.publish.edit.DoodleRotateSegment", "decodeFile failed", localOutOfMemoryError);
        }
        try
        {
          vxv.a(paramJobContext, str2, null);
          bool1 = true;
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (str1 != null) {
              bool2 = vxv.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str1);
            }
          }
          paramJobContext.recycle();
          if ((paramJobContext != null) && (!bool2)) {
            break label301;
          }
          super.notifyResult(paramvsa);
          return;
        }
        catch (IOException localIOException)
        {
          ved.c("Q.qqstory.publish.edit.DoodleRotateSegment", "serializeBitmapToFile failed", localIOException);
        }
        localThrowable = localThrowable;
        ved.c("Q.qqstory.publish.edit.DoodleRotateSegment", "unSerializeBitmapFromFile failed", localThrowable);
      }
      continue;
      label269:
      continue;
      if (i == 90)
      {
        i = -90;
        continue;
        label295:
        bool1 = false;
        continue;
        label301:
        super.notifyError(new ErrorMessage(-1, "bitmap compress failed"));
        return;
        label316:
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.DoodleRotateSegment", 6));
        return;
        super.notifyResult(paramvsa);
        return;
        label338:
        bool2 = false;
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vrz
 * JD-Core Version:    0.7.0.1
 */