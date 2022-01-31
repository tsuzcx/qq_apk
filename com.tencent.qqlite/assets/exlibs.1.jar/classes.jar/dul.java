import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class dul
  extends TimerTask
{
  public dul(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewingOfflineFileViewBase<FileAssistant>", 4, "TimeoutTimer run");
    }
    PreviewingOfflineFileViewBase.g(this.a).runOnUiThread(new dum(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dul
 * JD-Core Version:    0.7.0.1
 */