import android.os.Build;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.QQAnimationListener;
import com.tencent.qphone.base.util.QLog;

public class bkt
  extends QQAnimationListener
{
  public bkt(VideoControlUI paramVideoControlUI) {}
  
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    if (!this.a.h) {
      this.a.u();
    }
    if ("GT-I9100G".equals(Build.MODEL))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoControlUI", 2, "Model is 9100G, don't do animation");
      }
      return;
    }
    this.a.U();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bkt
 * JD-Core Version:    0.7.0.1
 */