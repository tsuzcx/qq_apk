import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.model.CameraProxy.1;
import com.tencent.mobileqq.ar.model.CameraProxy.2;
import com.tencent.mobileqq.ar.model.CameraProxy.3;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class adkt
  implements adgw.b, Camera.PreviewCallback
{
  public static HandlerThread l;
  private int Fe = 17;
  private long Us;
  private adgw a;
  private int bzx;
  private Handler cG;
  private volatile int cIg = 0;
  private int cIh = 1;
  private int cIi = 10;
  private volatile byte[] dp;
  private WeakReference<adkt.c> gr;
  private int mImageHeight;
  private int mImageWidth;
  private boolean mIsCameraPreviewing;
  private ArrayList<WeakReference<adkt.c>> mListeners = new ArrayList();
  private ArrayList<WeakReference<adgw.b>> uy = new ArrayList();
  private ArrayList<WeakReference<adkt.a>> uz = new ArrayList();
  
  private adkt()
  {
    if (l == null)
    {
      l = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      l.start();
      this.cG = new Handler(l.getLooper());
    }
    this.a = new adgw();
    if (Build.MODEL.equalsIgnoreCase("Redmi Note 3")) {}
    for (this.Us = 500L;; this.Us = 300L)
    {
      this.cIi = 0;
      return;
    }
  }
  
  public static adkt a()
  {
    return adkt.b.b();
  }
  
  private void n(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (this.uz)
      {
        i = this.uz.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.uz.get(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null)) {
            break label102;
          }
          if (paramBoolean) {
            ((adkt.a)localWeakReference.get()).cSj();
          } else {
            ((adkt.a)localWeakReference.get()).hz(paramInt1, paramInt2);
          }
        }
      }
      return;
      label102:
      i -= 1;
    }
  }
  
  public void Gc(boolean paramBoolean)
  {
    Iterator localIterator = this.uy.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((adgw.b)localWeakReference.get()).Gc(paramBoolean);
      }
    }
  }
  
  public void Le(int paramInt)
  {
    if (this.cIg == 2)
    {
      QLog.i("CameraProxy", 2, "openCamera mCurCameraState = " + this.cIg);
      return;
    }
    this.cIg = 1;
    this.cIi = 0;
    ab(new CameraProxy.1(this, paramInt));
  }
  
  public void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null) {
      this.a.N(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(adgw.b paramb)
  {
    Iterator localIterator = this.uy.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramb) {
        return;
      }
    }
    this.uy.add(new WeakReference(paramb));
  }
  
  public void a(adkt.a parama)
  {
    synchronized (this.uz)
    {
      Iterator localIterator = this.uz.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == parama) {
          return;
        }
      }
      this.uz.add(new WeakReference(parama));
      return;
    }
  }
  
  public void a(adkt.c paramc)
  {
    if (paramc == null)
    {
      this.gr = null;
      return;
    }
    this.gr = new WeakReference(paramc);
  }
  
  public boolean a(float paramFloat, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.a(paramFloat, paramBoolean);
    }
    return false;
  }
  
  public void ab(Runnable paramRunnable)
  {
    synchronized (l)
    {
      if (this.cG != null) {
        this.cG.post(paramRunnable);
      }
      return;
    }
  }
  
  public boolean aeN()
  {
    return (this.cIg == 2) && (this.mIsCameraPreviewing);
  }
  
  public void b(adgw.b paramb)
  {
    int j = this.uy.size();
    int i = 0;
    if (i < j) {
      if (((WeakReference)this.uy.get(i)).get() != paramb) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.uy.remove(i);
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void b(adkt.a parama)
  {
    for (;;)
    {
      synchronized (this.uz)
      {
        int j = this.uz.size();
        i = 0;
        if (i < j)
        {
          if (((WeakReference)this.uz.get(i)).get() != parama) {
            break label71;
          }
          if (i != -1) {
            this.uz.remove(i);
          }
          return;
        }
      }
      int i = -1;
      continue;
      label71:
      i += 1;
    }
  }
  
  public void b(adkt.c paramc)
  {
    synchronized (this.mListeners)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramc) {
          return;
        }
      }
      this.mListeners.add(new WeakReference(paramc));
      return;
    }
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    if ((this.cIg == 2) && (this.mIsCameraPreviewing))
    {
      QLog.i("CameraProxy", 2, "startCameraPreview return now");
      return;
    }
    ab(new CameraProxy.2(this, paramSurfaceTexture));
  }
  
  public boolean ba(boolean paramBoolean)
  {
    return this.a.ba(paramBoolean);
  }
  
  public void c(adkt.c paramc)
  {
    for (;;)
    {
      synchronized (this.mListeners)
      {
        int j = this.mListeners.size();
        i = 0;
        if (i < j)
        {
          if (((WeakReference)this.mListeners.get(i)).get() != paramc) {
            break label71;
          }
          if (i != -1) {
            this.mListeners.remove(i);
          }
          return;
        }
      }
      int i = -1;
      continue;
      label71:
      i += 1;
    }
  }
  
  public void cRA()
  {
    if (this.a != null) {
      this.a.cRA();
    }
  }
  
  public void cRB()
  {
    if (this.a != null) {
      this.a.cRB();
    }
  }
  
  public void cRC()
  {
    if (this.a != null) {
      this.a.cRC();
    }
  }
  
  public void cRD()
  {
    if (this.a != null) {
      this.a.cRD();
    }
  }
  
  public void closeCamera()
  {
    if (this.cIg == 0)
    {
      QLog.i("CameraProxy", 2, "closeCamera mCurCameraState = " + this.cIg);
      return;
    }
    this.cIg = 3;
    ab(new CameraProxy.3(this));
  }
  
  public void doDestroy()
  {
    synchronized (this.mListeners)
    {
      this.mListeners.clear();
    }
    synchronized (this.uz)
    {
      this.uz.clear();
      this.uy.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public int fk()
  {
    return this.mImageWidth;
  }
  
  public int fl()
  {
    return this.mImageHeight;
  }
  
  public int getPreviewFormat()
  {
    return this.Fe;
  }
  
  public void ho(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.ho(paramInt1, paramInt2);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    ArrayList localArrayList = this.mListeners;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        int i = this.mListeners.size() - 1;
        if (i < 0) {
          break label172;
        }
        WeakReference localWeakReference = (WeakReference)this.mListeners.get(i);
        if (localWeakReference.get() != null)
        {
          bool2 = ((adkt.c)localWeakReference.get()).l(paramArrayOfByte);
          bool1 = bool2;
          if (bool2)
          {
            if ((!bool2) && (this.gr != null) && (this.gr.get() != null)) {
              ((adkt.c)this.gr.get()).l(paramArrayOfByte);
            }
            if (this.cIg != 2) {
              break label164;
            }
            this.dp = paramArrayOfByte;
            if (this.a != null) {
              this.bzx = this.a.BG();
            }
            paramCamera.addCallbackBuffer(paramArrayOfByte);
            return;
          }
        }
        i -= 1;
        continue;
        this.dp = null;
      }
      finally {}
      label164:
      continue;
      label172:
      boolean bool2 = bool1;
    }
  }
  
  public String sF()
  {
    String str = null;
    int i = this.bzx;
    if (Build.MODEL.equalsIgnoreCase("M1 E")) {
      i = 90;
    }
    if (this.dp != null) {
      str = akng.a(this.dp, this.mImageWidth, this.mImageHeight, this.Fe, i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("CameraProxy", 2, String.format("getLastPreviewFrame, path: %s, rotation: %s", new Object[] { str, Integer.valueOf(i) }));
    }
    return str;
  }
  
  public boolean tT()
  {
    return this.cIg == 2;
  }
  
  public static abstract interface a
  {
    public abstract void cSj();
    
    public abstract void hz(int paramInt1, int paramInt2);
  }
  
  static class b
  {
    private static final adkt a = new adkt(null);
  }
  
  public static abstract interface c
  {
    public abstract boolean l(byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkt
 * JD-Core Version:    0.7.0.1
 */