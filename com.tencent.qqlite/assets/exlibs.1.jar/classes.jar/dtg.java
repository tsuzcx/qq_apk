import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalVideoFileView;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class dtg
  implements Runnable
{
  public dtg(LocalVideoFileView paramLocalVideoFileView) {}
  
  public void run()
  {
    if (LocalVideoFileView.a(this.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoFileView", 2, "initVarView delay run, but musicService is null");
      }
      return;
    }
    int j = LocalVideoFileView.a(this.a).a(LocalVideoFileView.a(this.a));
    Object localObject = "/" + LocalVideoFileView.a(this.a, j);
    LocalVideoFileView.b(this.a).setText((CharSequence)localObject);
    if (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a))) {}
    for (int i = LocalVideoFileView.a(this.a).b();; i = LocalVideoFileView.a(this.a))
    {
      if (LocalVideoFileView.a(this.a).getBackground() == null)
      {
        localObject = new DisplayMetrics();
        LocalVideoFileView.c(this.a).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        int k = ((DisplayMetrics)localObject).widthPixels;
        int m = ((DisplayMetrics)localObject).heightPixels;
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!LocalVideoFileView.a(this.a).a())
        {
          bool1 = bool2;
          if (LocalVideoFileView.a(this.a).b(LocalVideoFileView.a(this.a)))
          {
            bool1 = bool2;
            if (LocalVideoFileView.a(this.a) != 0) {
              bool1 = false;
            }
          }
        }
        FileManagerUtil.a(LocalVideoFileView.a(this.a), bool1, k, m, LocalVideoFileView.a(this.a) * 1000, new dth(this));
      }
      localObject = LocalVideoFileView.a(this.a, i);
      LocalVideoFileView.a(this.a).setText((CharSequence)localObject);
      LocalVideoFileView.a(this.a).setMax(j);
      LocalVideoFileView.a(this.a).setProgress(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dtg
 * JD-Core Version:    0.7.0.1
 */