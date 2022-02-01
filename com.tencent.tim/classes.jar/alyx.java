import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.Matrix;
import com.tencent.ttpic.video.AEEncoder;

@TargetApi(17)
public class alyx
  implements amal, AEEncoder
{
  private amae a;
  private aman b = new aman();
  private boolean cBv;
  private final Object lock = new Object();
  private float[] matrix = new float[16];
  
  public alyx(String paramString, int paramInt1, int paramInt2)
  {
    this.a = new amae(paramString, paramInt1, paramInt2, 5242880, 1, false, 0);
    Matrix.setIdentityM(this.matrix, 0);
    Matrix.setRotateM(this.matrix, 0, 180.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void a(int paramInt, Throwable paramThrowable) {}
  
  public void auv() {}
  
  public void btD() {}
  
  public void kf(String arg1)
  {
    this.b.release();
    this.cBv = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      return;
    }
  }
  
  public void release()
  {
    this.b.stopRecording();
    try
    {
      synchronized (this.lock)
      {
        this.lock.wait();
        label21:
        return;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label21;
    }
  }
  
  public int writeFrame(int paramInt, long paramLong)
  {
    if (!this.cBv)
    {
      this.a.a(EGL14.eglGetCurrentContext());
      this.b.a(this.a, this);
      this.cBv = true;
    }
    this.b.f(3553, paramInt, null, this.matrix, 1000000L * paramLong);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyx
 * JD-Core Version:    0.7.0.1
 */