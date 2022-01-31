import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;

class duc
  implements Runnable
{
  duc(dua paramdua) {}
  
  public void run()
  {
    PreviewingOfflineFileViewBase.a(this.a.a).removeCallbacksAndMessages(null);
    String str = (String)PreviewingOfflineFileViewBase.a(this.a.a).getText();
    if ((str == null) || (str.length() == 0)) {
      return;
    }
    PreviewingOfflineFileViewBase.a(this.a.a).clearAnimation();
    PreviewingOfflineFileViewBase.a(this.a.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     duc
 * JD-Core Version:    0.7.0.1
 */