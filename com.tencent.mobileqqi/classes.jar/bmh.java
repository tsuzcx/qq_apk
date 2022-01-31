import android.widget.ProgressBar;
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class bmh
  implements Runnable
{
  public bmh(TipsManager paramTipsManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "tipsRunnable");
    }
    this.a.b();
    if (this.a.a != null) {
      this.a.a.setVisibility(8);
    }
    if (this.a.b) {
      this.a.a();
    }
    if (this.a.e)
    {
      this.a.a(this.a.c, true);
      this.a.e = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmh
 * JD-Core Version:    0.7.0.1
 */