import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import java.util.TimerTask;

public class dur
  extends TimerTask
{
  public dur(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void run()
  {
    LocalVideoFileView.e(this.a).runOnUiThread(new dus(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dur
 * JD-Core Version:    0.7.0.1
 */