import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;

class dtd
  implements Runnable
{
  dtd(dtc paramdtc) {}
  
  public void run()
  {
    LocalMusicFileView.a(this.a.a).post(new dte(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtd
 * JD-Core Version:    0.7.0.1
 */