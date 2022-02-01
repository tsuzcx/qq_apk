import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class vnw
  implements ThreadExcutor.IThreadListener
{
  vnw(vns paramvns, vpd paramvpd) {}
  
  public void onAdded() {}
  
  public void onPostRun() {}
  
  public void onPreRun()
  {
    boolean bool1;
    int i;
    int j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Vpd.b))
    {
      bool1 = this.jdField_a_of_type_Vpd.a().getBooleanExtra("landscape_video", false);
      boolean bool2 = this.jdField_a_of_type_Vpd.a().isLocalPublish;
      boolean bool3 = this.jdField_a_of_type_Vpd.a().getBooleanExtra("is_hw_encode", false);
      if (this.jdField_a_of_type_Vpd.a().businessId != 1) {
        break label240;
      }
      i = 1;
      j = this.jdField_a_of_type_Vpd.a().getIntExtra("thumb_rotation", 0);
      if (!bool2) {
        break label245;
      }
      j = 0;
      label91:
      if ((i == 0) || (!bool3) || ((bool2) && (!bool1)) || (j == 0)) {}
    }
    for (;;)
    {
      try
      {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.jdField_a_of_type_Vpd.b));
        if (localBufferedInputStream != null)
        {
          Bitmap localBitmap1 = BitmapFactory.decodeStream(localBufferedInputStream);
          Bitmap localBitmap2 = yoy.a(localBitmap1, j);
          bool1 = yoy.a(localBitmap2, this.jdField_a_of_type_Vpd.b);
          if (localBitmap2 != null) {
            localBitmap2.recycle();
          }
          localBitmap1.recycle();
          localBufferedInputStream.close();
          if (bool1) {
            continue;
          }
          xvv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "compress file fail, %s", new Object[] { this.jdField_a_of_type_Vpd.b });
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "FileNotFoundException =", localFileNotFoundException);
        continue;
      }
      catch (IOException localIOException)
      {
        xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "IOException =", localIOException);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label240:
        label245:
        xvv.b("Q.qqstory.publish.upload:StoryVideoUploadManager", "OutOfMemoryError = ", localOutOfMemoryError);
        continue;
      }
      vns.a(this.jdField_a_of_type_Vns);
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.jdField_a_of_type_Vpd });
      return;
      i = 0;
      break;
      j = 360 - j;
      break label91;
      xvv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "video local file exist %b, %s", new Object[] { Boolean.valueOf(ypi.b(this.jdField_a_of_type_Vpd.b)), this.jdField_a_of_type_Vpd.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */