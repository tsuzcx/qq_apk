import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class aeyf
  implements aeye, SurfaceHolder.Callback
{
  private aeye.a a;
  private volatile boolean bWX;
  private volatile boolean bWY;
  private volatile Object dw;
  private volatile Object dx;
  private SurfaceHolder mSurfaceHolder;
  private SurfaceView mSurfaceView;
  private volatile ReentrantLock o;
  
  public aeyf(SurfaceView paramSurfaceView)
  {
    this.mSurfaceView = paramSurfaceView;
    this.mSurfaceView.setWillNotCacheDrawing(true);
    this.mSurfaceView.setDrawingCacheEnabled(false);
    this.mSurfaceView.setWillNotDraw(true);
    this.mSurfaceView.setZOrderMediaOverlay(true);
    this.mSurfaceHolder = this.mSurfaceView.getHolder();
    this.mSurfaceHolder.addCallback(this);
    this.mSurfaceHolder.setFormat(-2);
  }
  
  private void aS(Canvas paramCanvas)
  {
    if (aewr.a().a().ais()) {
      this.mSurfaceHolder.unlockCanvasAndPost(paramCanvas);
    }
    do
    {
      return;
      this.mSurfaceHolder.getSurface().unlockCanvasAndPost(paramCanvas);
    } while (this.o == null);
    this.o.unlock();
  }
  
  private boolean aiB()
  {
    return (aexw.aiB()) && (((Build.VERSION.SDK_INT == 23) && (aiD())) || (aewr.a().a().ais()));
  }
  
  private boolean aiD()
  {
    cYa();
    return (this.o != null) && (this.dw != null) && (this.dx != null);
  }
  
  private void cYa()
  {
    cYb();
    cYc();
  }
  
  private void cYb()
  {
    Object localObject = aewr.a().a().getField(SurfaceView.class, "mSurfaceLock", this.mSurfaceView);
    if ((localObject instanceof ReentrantLock)) {
      this.o = ((ReentrantLock)localObject);
    }
  }
  
  private void cYc()
  {
    this.dw = aewr.a().a().getField(SurfaceView.class, "mDrawingStopped", this.mSurfaceView);
    this.dx = aewr.a().a().getField(SurfaceView.class, "mWindow", this.mSurfaceView);
    if ((this.dw instanceof Boolean)) {
      this.bWX = ((Boolean)this.dw).booleanValue();
    }
  }
  
  private Canvas lockHardwareCanvas()
  {
    Object localObject2;
    if (aewr.a().a().ais())
    {
      localObject2 = this.mSurfaceHolder.lockHardwareCanvas();
      return localObject2;
    }
    this.o.lock();
    cYc();
    if ((!this.bWX) && (this.dx != null)) {}
    for (;;)
    {
      try
      {
        Canvas localCanvas = this.mSurfaceHolder.getSurface().lockHardwareCanvas();
        localObject2 = localCanvas;
        if (localCanvas != null) {
          break;
        }
        this.o.unlock();
        return null;
      }
      catch (Exception localException)
      {
        aeyw.e("SurfaceDanmakuView", "Exception locking surface", localException);
      }
      Object localObject1 = null;
    }
  }
  
  public void a(aeye.a parama)
  {
    this.a = parama;
  }
  
  public float aZ()
  {
    return this.mSurfaceView.getY();
  }
  
  public void destroy() {}
  
  public Canvas lockCanvas()
  {
    if (this.bWY) {
      return lockHardwareCanvas();
    }
    return this.mSurfaceHolder.lockCanvas();
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mSurfaceView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a != null) {
      this.a.cXM();
    }
    aeyw.i("SurfaceDanmakuView", "surfaceChanged, width = " + paramInt2 + ", height = " + paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.a != null) {
      this.a.cXL();
    }
    this.bWY = aiB();
    aeyw.i("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = " + this.bWY);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.a != null) {
      this.a.cXN();
    }
    aeyw.i("SurfaceDanmakuView", "surfaceDestroyed");
  }
  
  public void unlock()
  {
    ReentrantLock localReentrantLock = (ReentrantLock)aewr.a().a().getField(SurfaceView.class, "mSurfaceLock", this.mSurfaceView);
    Surface localSurface = this.mSurfaceView.getHolder().getSurface();
    try
    {
      Method localMethod = Surface.class.getDeclaredMethod("nativeRelease", new Class[] { Long.TYPE });
      localMethod.setAccessible(true);
      Field localField = Surface.class.getDeclaredField("mLockedObject");
      localField.setAccessible(true);
      Long localLong = (Long)localField.get(localSurface);
      aeyw.i("surface_lock", "SurfaceDanmakuView unlock lockObjectValue = " + localLong);
      if (localLong.longValue() != 0L) {
        localMethod.invoke(null, new Object[] { localLong });
      }
      localField.setLong(localSurface, 0L);
      aeyw.d("surface_lock", "SurfaceDanmakuView unlock: release success");
      return;
    }
    catch (Exception localException)
    {
      aeyw.e("surface_lock", "SurfaceDanmakuView unlock:release failed", localException);
      return;
    }
    finally
    {
      aeyw.i("surface_lock", "SurfaceDanmakuView unlock surfaceLock = " + localReentrantLock);
      if ((localReentrantLock != null) && (localReentrantLock.isLocked()))
      {
        aeyw.i("surface_lock", "SurfaceDanmakuView unlock");
        localReentrantLock.unlock();
      }
    }
  }
  
  public void unlockCanvasAndPost(Canvas paramCanvas)
  {
    if (this.bWY)
    {
      aS(paramCanvas);
      return;
    }
    this.mSurfaceHolder.unlockCanvasAndPost(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyf
 * JD-Core Version:    0.7.0.1
 */