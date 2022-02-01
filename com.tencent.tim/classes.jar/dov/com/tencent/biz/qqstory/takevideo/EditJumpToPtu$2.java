package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import aqhq;
import aydm;
import ayva;

public class EditJumpToPtu$2
  implements Runnable
{
  public EditJumpToPtu$2(aydm paramaydm, String paramString) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.U(this.val$newPath);
    if (localBitmap != null) {
      ayva.a().as(localBitmap);
    }
    aqhq.deleteFile(this.val$newPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditJumpToPtu.2
 * JD-Core Version:    0.7.0.1
 */