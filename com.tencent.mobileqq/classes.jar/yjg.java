import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobContext;
import java.io.IOException;

public class yjg
  extends yju<yjh, yjh>
{
  protected void a(JobContext paramJobContext, yjh paramyjh)
  {
    paramJobContext = null;
    if (paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath == null)
    {
      super.notifyError(new ErrorMessage(-1, "DoodleRotateSegment error, you must merger everything first"));
      return;
    }
    String str2 = paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodleRawPath;
    String str1 = paramyjh.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath;
    if ((str1 == null) && (str2 == null))
    {
      super.notifyResult(paramyjh);
      return;
    }
    int i = paramyjh.jdField_a_of_type_Yjn.c;
    int j = paramyjh.jdField_a_of_type_Int;
    if ((j == 2) || (j == 3) || (j == 5) || (j == 104) || (j == 6)) {
      if (str2 == null) {}
    }
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        Bitmap localBitmap = yoy.a(str2, null);
        paramJobContext = localBitmap;
        j = 1;
        if ((paramJobContext != null) || (str1 == null)) {
          break label262;
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
            break label309;
          }
          if (i == 270)
          {
            i = 90;
            paramJobContext = yji.a(paramJobContext, i);
            if (paramJobContext == null) {
              break label331;
            }
            if (j == 0) {
              break label288;
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          xvv.c("Q.qqstory.publish.edit.DoodleRotateSegment", "decodeFile failed", localOutOfMemoryError);
        }
        try
        {
          yoy.a(paramJobContext, str2, null);
          bool1 = true;
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (str1 != null) {
              bool2 = yoy.a(paramJobContext, Bitmap.CompressFormat.PNG, 60, str1);
            }
          }
          paramJobContext.recycle();
          if ((paramJobContext != null) && (!bool2)) {
            break label294;
          }
          super.notifyResult(paramyjh);
          return;
        }
        catch (IOException localIOException)
        {
          xvv.c("Q.qqstory.publish.edit.DoodleRotateSegment", "serializeBitmapToFile failed", localIOException);
        }
        localThrowable = localThrowable;
        xvv.c("Q.qqstory.publish.edit.DoodleRotateSegment", "unSerializeBitmapFromFile failed", localThrowable);
      }
      continue;
      label262:
      continue;
      if (i == 90)
      {
        i = -90;
        continue;
        label288:
        bool1 = false;
        continue;
        label294:
        super.notifyError(new ErrorMessage(-1, "bitmap compress failed"));
        return;
        label309:
        super.notifyError(new BitmapError("Q.qqstory.publish.edit.DoodleRotateSegment", 6));
        return;
        super.notifyResult(paramyjh);
        return;
        label331:
        bool2 = false;
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjg
 * JD-Core Version:    0.7.0.1
 */