import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;

public class dti
  implements View.OnClickListener
{
  public dti(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void onClick(View paramView)
  {
    if (LocalVideoFileView.a(this.a))
    {
      LocalVideoFileView.a(this.a);
      return;
    }
    LocalVideoFileView.b(this.a);
    new Handler().postDelayed(new dtj(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dti
 * JD-Core Version:    0.7.0.1
 */