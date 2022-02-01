import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class pob
  implements ThreadExcutor.IThreadListener
{
  pob(pnx parampnx, pox parampox) {}
  
  public void onAdded() {}
  
  public void onPostRun() {}
  
  public void onPreRun()
  {
    boolean bool1;
    int i;
    int j;
    if (!TextUtils.isEmpty(this.a.aug))
    {
      bool1 = this.a.a().getBooleanExtra("landscape_video", false);
      boolean bool2 = this.a.a().isLocalPublish;
      boolean bool3 = this.a.a().getBooleanExtra("is_hw_encode", false);
      if (this.a.a().businessId != 1) {
        break label240;
      }
      i = 1;
      j = this.a.a().getIntExtra("thumb_rotation", 0);
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
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.a.aug));
        if (localBufferedInputStream != null)
        {
          Bitmap localBitmap1 = BitmapFactory.decodeStream(localBufferedInputStream);
          Bitmap localBitmap2 = rop.rotateBitmap(localBitmap1, j);
          bool1 = rop.d(localBitmap2, this.a.aug);
          if (localBitmap2 != null) {
            localBitmap2.recycle();
          }
          localBitmap1.recycle();
          localBufferedInputStream.close();
          if (bool1) {
            continue;
          }
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "compress file fail, %s", new Object[] { this.a.aug });
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "FileNotFoundException =", localFileNotFoundException);
        continue;
      }
      catch (IOException localIOException)
      {
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "IOException =", localIOException);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label240:
        label245:
        ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "OutOfMemoryError = ", localOutOfMemoryError);
        continue;
      }
      pnx.a(this.this$0);
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "create story %s", new Object[] { this.a });
      return;
      i = 0;
      break;
      j = 360 - j;
      break label91;
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "video local file exist %b, %s", new Object[] { Boolean.valueOf(rox.checkFileExist(this.a.aug)), this.a.aug });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pob
 * JD-Core Version:    0.7.0.1
 */