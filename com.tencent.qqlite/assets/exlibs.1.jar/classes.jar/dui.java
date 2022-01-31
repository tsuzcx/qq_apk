import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;

public class dui
  implements Runnable
{
  public dui(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    ((ProgressBar)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298079)).setVisibility(8);
    ((TextView)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298080)).setText(2131363576);
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      PreviewingOfflineFileViewBase.a(this.a, (LinearLayout)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298078));
    }
    PreviewingOfflineFileViewBase.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dui
 * JD-Core Version:    0.7.0.1
 */