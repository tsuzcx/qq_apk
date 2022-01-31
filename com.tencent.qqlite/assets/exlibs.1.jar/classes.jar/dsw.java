import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import java.util.TimerTask;

public class dsw
  extends TimerTask
{
  public dsw(LocalMusicFileView paramLocalMusicFileView) {}
  
  public void run()
  {
    LocalMusicFileView.a(this.a).runOnUiThread(new dsx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsw
 * JD-Core Version:    0.7.0.1
 */