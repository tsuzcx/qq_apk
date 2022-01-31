import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.qphone.base.util.QLog;

class dum
  implements Runnable
{
  dum(dul paramdul) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewingOfflineFileViewBase<FileAssistant>", 4, "TimeoutTimer run in ui thread");
    }
    this.a.a.b(9037L, "Time out", PreviewingOfflineFileViewBase.f(this.a.a).getString(2131363570));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dum
 * JD-Core Version:    0.7.0.1
 */