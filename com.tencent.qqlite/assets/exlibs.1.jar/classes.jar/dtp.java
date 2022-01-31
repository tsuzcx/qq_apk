import android.app.Activity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import java.util.TimerTask;

public class dtp
  extends TimerTask
{
  public dtp(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void run()
  {
    LocalVideoFileView.e(this.a).runOnUiThread(new dtq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtp
 * JD-Core Version:    0.7.0.1
 */