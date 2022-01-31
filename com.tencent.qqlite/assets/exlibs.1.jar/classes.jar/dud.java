import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import java.util.TimerTask;

public class dud
  extends TimerTask
{
  public dud(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.e(this.a).runOnUiThread(new due(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dud
 * JD-Core Version:    0.7.0.1
 */