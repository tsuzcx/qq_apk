import android.os.Build.VERSION;
import android.os.HandlerThread;

public class uxw
{
  private HandlerThread a;
  
  public HandlerThread a()
  {
    if (this.a == null) {
      this.a = new HandlerThread("WeishiHandlerThread");
    }
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label29;
      }
      this.a.quitSafely();
    }
    for (;;)
    {
      this.a = null;
      return;
      label29:
      this.a.quit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxw
 * JD-Core Version:    0.7.0.1
 */