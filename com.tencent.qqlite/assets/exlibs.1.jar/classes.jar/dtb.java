import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class dtb
  implements SeekBar.OnSeekBarChangeListener
{
  public dtb(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    LocalVideoFileView.a(this.a, paramInt);
    if (paramBoolean)
    {
      paramSeekBar = LocalVideoFileView.a(this.a, paramInt);
      LocalVideoFileView.a(this.a).setText(paramSeekBar);
      if ((LocalVideoFileView.a(this.a) != null) && (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {}
    }
    else
    {
      return;
    }
    LocalVideoFileView.a(this.a).a(paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalVideoFileView.a(this.a) == null) || (!LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {
      return;
    }
    LocalVideoFileView.a(this.a).d();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((LocalVideoFileView.a(this.a) == null) || (!LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))) {
      return;
    }
    LocalVideoFileView.a(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtb
 * JD-Core Version:    0.7.0.1
 */