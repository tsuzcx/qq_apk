import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import java.util.TimerTask;

public class dtc
  extends TimerTask
{
  public dtc(LocalMusicFileView paramLocalMusicFileView) {}
  
  public void run()
  {
    LocalMusicFileView.a(this.a).runOnUiThread(new dtd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtc
 * JD-Core Version:    0.7.0.1
 */