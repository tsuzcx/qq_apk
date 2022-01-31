import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;

public class dvq
  implements Runnable
{
  public dvq(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    ((ProgressBar)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298047)).setVisibility(8);
    ((TextView)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298048)).setText(2131363581);
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      PreviewingOfflineFileViewBase.a(this.a, (LinearLayout)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298046));
    }
    PreviewingOfflineFileViewBase.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dvq
 * JD-Core Version:    0.7.0.1
 */