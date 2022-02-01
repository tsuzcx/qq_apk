import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class anks
{
  private HandlerThread X;
  private anks.a c = new anks.a(0);
  private anks.a d = new anks.a(1);
  private Handler mQueueHandler;
  
  public anks.a a()
  {
    if (anks.a.a(this.c).getAndSet(1) == 0) {
      return this.c;
    }
    if (anks.a.a(this.d).getAndSet(1) == 0) {
      return this.d;
    }
    return null;
  }
  
  public void aj(Runnable paramRunnable)
  {
    if (this.mQueueHandler != null) {
      this.mQueueHandler.post(paramRunnable);
    }
  }
  
  public boolean ayh()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (anks.a.a(this.c).getAndAdd(0) == 0)
    {
      bool1 = bool2;
      if (anks.a.a(this.d).getAndAdd(0) == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void dQZ()
  {
    if (this.X == null)
    {
      this.X = new HandlerThread("SharedMemoryCacheProcessor");
      this.X.start();
      this.mQueueHandler = new Handler(this.X.getLooper());
    }
  }
  
  public void dRb()
  {
    if (this.X != null)
    {
      PtvFilterUtils.a(this.X);
      this.X = null;
      this.mQueueHandler = null;
    }
  }
  
  public void dRl()
  {
    anks.a.a(this.c).getAndSet(0);
    anks.a.a(this.d).getAndSet(0);
  }
  
  public void dRm()
  {
    if (this.mQueueHandler != null) {
      this.mQueueHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public static class a
  {
    public CameraFilterGLView.SharedMemWriteFile a;
    private AtomicInteger bR = new AtomicInteger(0);
    private boolean cHP;
    public int dJi;
    private int dJj;
    private long mNativePtr;
    public ByteBuffer w;
    
    public a(int paramInt)
    {
      this.dJi = paramInt;
      this.cHP = false;
      this.dJj = 0;
    }
    
    public void dRn()
    {
      this.bR.getAndSet(0);
    }
    
    public boolean p(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt1 * paramInt2 * paramInt3;
      if ((this.cHP) && (this.dJj == i) && (this.w != null)) {
        return true;
      }
      this.mNativePtr = 0L;
      this.w = null;
      try
      {
        this.mNativePtr = PtvFilterUtils.getNativePtrIndex(paramInt1, paramInt2, paramInt3, this.dJi);
        if (this.mNativePtr == 0L) {
          return false;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        for (;;)
        {
          this.mNativePtr = 0L;
        }
        try
        {
          this.w = PtvFilterUtils.allocateSharedMem(this.mNativePtr);
          if (this.w == null) {
            return false;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          for (;;)
          {
            this.w = null;
          }
          this.cHP = true;
          this.dJj = i;
        }
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anks
 * JD-Core Version:    0.7.0.1
 */