import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.lang.ref.WeakReference;

public abstract class ipb
  extends ipf
{
  protected Handler mHandler;
  
  public ipb()
  {
    HandlerThread localHandlerThread = new HandlerThread("OffscreenGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new ipb.a(localHandlerThread.getLooper(), this);
  }
  
  protected abstract void ai(Message paramMessage);
  
  protected void init()
  {
    super.init();
    Process.setThreadPriority(0);
    igd.aJ("GLContextThread", "init: ");
  }
  
  protected void terminate()
  {
    super.release();
    this.mHandler.getLooper().quit();
  }
  
  static class a
    extends Handler
  {
    WeakReference<ipb> mContextRef;
    
    a(Looper paramLooper, ipb paramipb)
    {
      super();
      this.mContextRef = new WeakReference(paramipb);
    }
    
    public void handleMessage(Message paramMessage)
    {
      ipb localipb = (ipb)this.mContextRef.get();
      if (localipb != null) {
        localipb.ai(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipb
 * JD-Core Version:    0.7.0.1
 */