import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.LinkedList;

public class aeyi
{
  private final int aab;
  private int aad;
  private int aae;
  private int mTotalSize;
  private final LinkedList<Bitmap> s = new LinkedList();
  
  public aeyi()
  {
    DisplayMetrics localDisplayMetrics = aewr.a().a().d().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    this.aab = (localDisplayMetrics.heightPixels * i * 8);
  }
  
  private void g(Bitmap paramBitmap)
  {
    this.s.remove(paramBitmap);
    if (paramBitmap != null)
    {
      this.mTotalSize -= paramBitmap.getRowBytes() * paramBitmap.getHeight();
      if ((!paramBitmap.isRecycled()) && (!aewr.a().a().hasHoneycomb())) {
        paramBitmap.recycle();
      }
    }
  }
  
  public int CF()
  {
    return this.mTotalSize;
  }
  
  public int CG()
  {
    return this.aae;
  }
  
  public int CH()
  {
    return this.aad;
  }
  
  public void clear()
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap != null) && (!localBitmap.isRecycled()) && (!aewr.a().a().hasHoneycomb())) {
        localBitmap.recycle();
      }
    }
    this.s.clear();
    this.mTotalSize = 0;
    this.aad = 0;
    this.aae = 0;
  }
  
  public void f(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {}
    for (;;)
    {
      return;
      this.mTotalSize += paramBitmap.getRowBytes() * paramBitmap.getHeight();
      this.s.addLast(paramBitmap);
      while (this.mTotalSize > this.aab)
      {
        paramBitmap = null;
        Iterator localIterator = this.s.iterator();
        if (localIterator.hasNext())
        {
          Bitmap localBitmap2 = (Bitmap)localIterator.next();
          Bitmap localBitmap1;
          if (paramBitmap == null) {
            localBitmap1 = localBitmap2;
          }
          for (;;)
          {
            paramBitmap = localBitmap1;
            break;
            localBitmap1 = localBitmap2;
            if (paramBitmap.getHeight() * paramBitmap.getWidth() < localBitmap2.getHeight() * localBitmap2.getWidth()) {
              localBitmap1 = paramBitmap;
            }
          }
        }
        if (paramBitmap != null) {
          g(paramBitmap);
        }
      }
    }
  }
  
  public Bitmap getBitmap(int paramInt1, int paramInt2)
  {
    this.aad += 1;
    Object localObject1 = null;
    Iterator localIterator = this.s.iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if ((localBitmap.getWidth() >= paramInt1) && (localBitmap.getHeight() >= paramInt2)) {
        if (localObject1 == null) {
          localObject2 = localBitmap;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        break;
        localObject2 = localBitmap;
        if (localObject1.getHeight() * localObject1.getWidth() < localBitmap.getHeight() * localBitmap.getWidth()) {
          localObject2 = localObject1;
        }
      }
    }
    if (localObject1 != null)
    {
      this.s.remove(localObject1);
      this.mTotalSize -= localObject1.getRowBytes() * localObject1.getHeight();
      return localObject1;
    }
    try
    {
      this.aae += 1;
      localObject2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      return localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      aeyw.e("BitmapCacheManager", "create bitmap out of memory", localOutOfMemoryError);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyi
 * JD-Core Version:    0.7.0.1
 */