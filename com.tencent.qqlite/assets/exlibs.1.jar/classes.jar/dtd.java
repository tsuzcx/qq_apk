import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;

class dtd
  implements Runnable
{
  dtd(dtc paramdtc) {}
  
  public void run()
  {
    LocalVideoFileView.a(this.a.a).setVisibility(8);
    if ((LocalVideoFileView.a(this.a.a) != null) && (LocalVideoFileView.b(this.a.a) != null))
    {
      LocalVideoFileView.a(this.a.a).setVisibility(8);
      LocalVideoFileView.b(this.a.a).setVisibility(8);
    }
    if (LocalVideoFileView.a(this.a.a) != null) {
      LocalVideoFileView.b(this.a.a).c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtd
 * JD-Core Version:    0.7.0.1
 */