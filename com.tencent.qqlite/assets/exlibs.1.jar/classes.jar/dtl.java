import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

class dtl
  implements Runnable
{
  dtl(dtk paramdtk) {}
  
  public void run()
  {
    if ((LocalVideoFileView.a(this.a.a.a) == null) || (!LocalVideoFileView.a(this.a.a.a).b(LocalVideoFileView.a(this.a.a.a)))) {
      return;
    }
    int i = LocalVideoFileView.a(this.a.a.a).b();
    String str = LocalVideoFileView.a(this.a.a.a, i);
    LocalVideoFileView.a(this.a.a.a).setProgress(i);
    LocalVideoFileView.a(this.a.a.a).setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtl
 * JD-Core Version:    0.7.0.1
 */