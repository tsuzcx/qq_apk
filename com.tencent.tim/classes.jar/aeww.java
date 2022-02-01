import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.HandlerThread;

public class aeww
{
  private HandlerThread L;
  private final aeyi a = new aeyi();
  
  public int CF()
  {
    return this.a.CF();
  }
  
  public int CG()
  {
    return this.a.CG();
  }
  
  public int CH()
  {
    return this.a.CH();
  }
  
  public Bitmap a(aexe paramaexe, aexj paramaexj)
  {
    if (paramaexe == null) {
      throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
    }
    try
    {
      if (paramaexe.isDrawCacheDirty())
      {
        Object localObject2 = paramaexe.getDrawCache();
        Object localObject1;
        if (localObject2 == null) {
          localObject1 = this.a.getBitmap((int)paramaexe.getPaintWidth(), (int)paramaexe.getPaintHeight());
        }
        for (;;)
        {
          paramaexe.setDrawCache((Bitmap)localObject1);
          if (localObject1 != null) {
            break;
          }
          return null;
          if (((Bitmap)localObject2).getWidth() >= (int)paramaexe.getPaintWidth())
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getHeight() >= (int)paramaexe.getPaintHeight()) {}
          }
          else
          {
            this.a.f((Bitmap)localObject2);
            localObject1 = this.a.getBitmap((int)paramaexe.getPaintWidth(), (int)paramaexe.getPaintHeight());
          }
        }
        localObject2 = paramaexe.getDrawCacheCanvas();
        if (localObject2 == null)
        {
          localObject2 = new Canvas((Bitmap)localObject1);
          paramaexe.setDrawCacheCanvas((Canvas)localObject2);
        }
        for (;;)
        {
          ((Bitmap)localObject1).eraseColor(0);
          paramaexe.setDrawCacheDirty(false);
          paramaexj.a(paramaexe).a((Canvas)localObject2, paramaexe, paramaexj, aexj.a().getMarginHorizontal(), aexj.a().getMarginVertical());
          return localObject1;
          ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
        }
      }
      paramaexe = paramaexe.getDrawCache();
    }
    finally {}
    return paramaexe;
  }
  
  public void a(aexe paramaexe, aexj paramaexj) {}
  
  public void cXB()
  {
    if ((this.L == null) || (!this.L.isAlive())) {
      return;
    }
    if (aeyu.aiE())
    {
      this.L.quitSafely();
      return;
    }
    this.L.quit();
  }
  
  public void clear()
  {
    this.a.clear();
  }
  
  public void f(Bitmap paramBitmap)
  {
    this.a.f(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeww
 * JD-Core Version:    0.7.0.1
 */