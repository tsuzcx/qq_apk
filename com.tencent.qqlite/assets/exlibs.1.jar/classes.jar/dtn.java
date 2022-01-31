import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.IGetVideoCallback;

class dtn
  implements FileManagerUtil.IGetVideoCallback
{
  dtn(dtm paramdtm) {}
  
  public void a(Bitmap paramBitmap)
  {
    LocalVideoFileView.d(this.a.a).runOnUiThread(new dto(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtn
 * JD-Core Version:    0.7.0.1
 */