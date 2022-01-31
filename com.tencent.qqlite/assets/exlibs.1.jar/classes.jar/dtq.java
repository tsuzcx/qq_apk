import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;

class dtq
  implements Runnable
{
  dtq(dtp paramdtp) {}
  
  public void run()
  {
    LocalVideoFileView.a(this.a.a).post(new dtr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtq
 * JD-Core Version:    0.7.0.1
 */