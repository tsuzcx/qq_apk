import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;

class dsx
  implements Runnable
{
  dsx(dsw paramdsw) {}
  
  public void run()
  {
    LocalMusicFileView.a(this.a.a).post(new dsy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsx
 * JD-Core Version:    0.7.0.1
 */