import android.text.format.Time;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

class dte
  implements Runnable
{
  dte(dtd paramdtd) {}
  
  public void run()
  {
    if ((LocalMusicFileView.a(this.a.a.a) == null) || (!LocalMusicFileView.a(this.a.a.a).b(LocalMusicFileView.a(this.a.a.a)))) {
      return;
    }
    int i = LocalMusicFileView.a(this.a.a.a).b();
    LocalMusicFileView.a(this.a.a.a).setProgress(i);
    Object localObject = new Time();
    ((Time)localObject).set(i);
    localObject = ((Time)localObject).format("%M:%S");
    LocalMusicFileView.a(this.a.a.a).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dte
 * JD-Core Version:    0.7.0.1
 */