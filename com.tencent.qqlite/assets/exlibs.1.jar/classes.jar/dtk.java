import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;

class dtk
  implements Runnable
{
  dtk(dtj paramdtj) {}
  
  public void run()
  {
    LocalVideoFileView.a(this.a.a).post(new dtl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtk
 * JD-Core Version:    0.7.0.1
 */