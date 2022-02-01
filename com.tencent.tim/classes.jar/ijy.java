import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.2;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.3;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.4;
import com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class ijy
{
  public volatile boolean RS = false;
  public ijz a;
  Handler aO = new Handler(Looper.getMainLooper());
  public WeakReference<ijy.a> bm;
  WeakReference<ijy.b> bn;
  String videoPath;
  
  public ijy()
  {
    init();
  }
  
  protected void W(String paramString, boolean paramBoolean)
  {
    if (this.bm != null) {
      this.aO.post(new MagicfaceBaseDecoder.4(this, paramString, paramBoolean));
    }
  }
  
  public void a(ijy.a parama)
  {
    this.bm = new WeakReference(parama);
  }
  
  public void a(ijy.b paramb)
  {
    if (paramb != null)
    {
      this.bn = new WeakReference(paramb);
      return;
    }
    this.bn = null;
  }
  
  public void a(ijz paramijz)
  {
    this.a = paramijz;
  }
  
  public void af(String paramString, int paramInt)
  {
    if (this.bm != null) {
      this.aO.post(new MagicfaceBaseDecoder.3(this, paramString, paramInt));
    }
  }
  
  public void ank()
  {
    this.RS = false;
    this.a.stop();
  }
  
  public void iV(String paramString)
  {
    if (this.bm != null) {
      this.aO.post(new MagicfaceBaseDecoder.2(this, paramString));
    }
  }
  
  protected void iW(String paramString)
  {
    if (this.bm != null) {
      this.aO.post(new MagicfaceBaseDecoder.5(this, paramString));
    }
  }
  
  protected void init() {}
  
  public abstract int kT();
  
  protected void reSet() {}
  
  public void setVideoPath(String paramString)
  {
    this.videoPath = paramString;
  }
  
  public void startDecoder()
  {
    reSet();
    if (!this.RS) {
      this.a.start();
    }
    try
    {
      new Thread(new MagicfaceBaseDecoder.1(this)).start();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MagicfaceBaseDecoder", 1, "startDecoder err:" + localOutOfMemoryError.getMessage());
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(long paramLong, String paramString, boolean paramBoolean);
    
    public abstract void f(long paramLong, String paramString, int paramInt);
    
    public abstract void m(long paramLong, String paramString);
    
    public abstract void n(long paramLong, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Rect paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijy
 * JD-Core Version:    0.7.0.1
 */