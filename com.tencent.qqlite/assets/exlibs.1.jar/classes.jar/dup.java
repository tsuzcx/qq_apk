import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;

class dup
  implements FileManagerUtil.IGetVideoCallback
{
  dup(duo paramduo) {}
  
  public void a(Bitmap paramBitmap)
  {
    LocalVideoFileView.d(this.a.a).runOnUiThread(new duq(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dup
 * JD-Core Version:    0.7.0.1
 */