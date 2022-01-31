import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ttl
  implements Runnable
{
  public ttl(SplashActivity paramSplashActivity) {}
  
  public void run()
  {
    if (ImmersiveUtils.a(this.a.getWindow())) {
      this.a.recreate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ttl
 * JD-Core Version:    0.7.0.1
 */