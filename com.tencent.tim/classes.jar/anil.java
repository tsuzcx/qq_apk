import android.os.Handler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.1;

public class anil
{
  public anil.a a;
  public Handler mMainHandler;
  
  public anil(Handler paramHandler, anil.a parama)
  {
    this.mMainHandler = paramHandler;
    this.a = parama;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.mMainHandler.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
  
  public static abstract interface a
  {
    public abstract void a(RuntimeException paramRuntimeException);
    
    public abstract void d(Exception paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anil
 * JD-Core Version:    0.7.0.1
 */