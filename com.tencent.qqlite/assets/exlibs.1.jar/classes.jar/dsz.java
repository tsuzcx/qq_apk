import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalMusicFileView;

public class dsz
  implements View.OnClickListener
{
  public dsz(LocalMusicFileView paramLocalMusicFileView) {}
  
  public void onClick(View paramView)
  {
    if (LocalMusicFileView.a(this.a))
    {
      LocalMusicFileView.a(this.a);
      return;
    }
    LocalMusicFileView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dsz
 * JD-Core Version:    0.7.0.1
 */