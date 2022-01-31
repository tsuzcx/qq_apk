import android.os.Handler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.theme.ThemeUtil;

public class zdt
  implements Runnable
{
  public zdt(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void run()
  {
    if ((!ThemeUtil.isNowThemeIsDIY()) && (!ThemeUtil.isNowThemeIsAnimate())) {}
    for (boolean bool = true;; bool = false)
    {
      this.a.a.removeMessages(16);
      this.a.a.sendMessage(this.a.a.obtainMessage(16, Boolean.valueOf(bool)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdt
 * JD-Core Version:    0.7.0.1
 */