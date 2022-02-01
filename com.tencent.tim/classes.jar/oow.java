import android.os.Build.VERSION;
import android.os.HandlerThread;

public class oow
{
  private HandlerThread mHandlerThread;
  
  public void bfW()
  {
    if (this.mHandlerThread != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label29;
      }
      this.mHandlerThread.quitSafely();
    }
    for (;;)
    {
      this.mHandlerThread = null;
      return;
      label29:
      this.mHandlerThread.quit();
    }
  }
  
  public HandlerThread d()
  {
    if (this.mHandlerThread == null) {
      this.mHandlerThread = new HandlerThread("WeishiHandlerThread");
    }
    return this.mHandlerThread;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oow
 * JD-Core Version:    0.7.0.1
 */