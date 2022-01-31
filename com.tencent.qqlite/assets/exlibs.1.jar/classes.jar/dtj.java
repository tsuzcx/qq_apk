import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import java.util.TimerTask;

public class dtj
  extends TimerTask
{
  public dtj(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void run()
  {
    LocalVideoFileView.e(this.a).runOnUiThread(new dtk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtj
 * JD-Core Version:    0.7.0.1
 */