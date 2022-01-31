import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import java.util.TimerTask;

public class dvl
  extends TimerTask
{
  public dvl(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.e(this.a).runOnUiThread(new dvm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dvl
 * JD-Core Version:    0.7.0.1
 */