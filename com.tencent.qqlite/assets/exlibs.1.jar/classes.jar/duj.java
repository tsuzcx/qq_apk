import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import java.util.TimerTask;

public class duj
  extends TimerTask
{
  public duj(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.e(this.a).runOnUiThread(new duk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     duj
 * JD-Core Version:    0.7.0.1
 */