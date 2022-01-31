import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

public class tyd
  implements Runnable
{
  public tyd(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.a(this.a.getWindow())) {
      this.a.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tyd
 * JD-Core Version:    0.7.0.1
 */