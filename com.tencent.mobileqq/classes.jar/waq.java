import android.os.Looper;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;

public class waq
  implements Runnable
{
  public waq(ZhituManager paramZhituManager) {}
  
  public void run()
  {
    ZhituManager.a(this.a, ZhituManager.a(this.a));
    ZhituManager.a(this.a, false);
    Looper.myLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */