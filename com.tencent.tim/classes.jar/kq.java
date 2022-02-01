import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import java.util.ArrayList;
import java.util.Iterator;

public class kq
{
  private int iA;
  private ArrayList<km> mFragments = new ArrayList(4);
  private int mHeight;
  private int mLeft;
  private int mTop;
  private int mWidth;
  
  public km a(int paramInt)
  {
    int j = this.mLeft;
    Iterator localIterator = this.mFragments.iterator();
    int i = j;
    while (localIterator.hasNext())
    {
      km localkm = (km)localIterator.next();
      i += localkm.getWidth();
      if ((j <= paramInt) && (paramInt < i)) {
        return localkm;
      }
      j = i;
    }
    return null;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.mFragments.iterator();
    while (localIterator.hasNext())
    {
      km localkm = (km)localIterator.next();
      localkm.a(paramCanvas, paramInt1, paramInt2, this.mHeight);
      paramInt1 += localkm.getWidth();
    }
  }
  
  public void a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mLeft = paramInt1;
    this.mTop = paramInt2;
    this.mWidth = 0;
    this.mHeight = paramInt3;
    Iterator localIterator = this.mFragments.iterator();
    while (localIterator.hasNext())
    {
      km localkm = (km)localIterator.next();
      if (localkm.getHeight() > this.mHeight) {
        this.mHeight = localkm.getHeight();
      }
      paramInt1 = this.mWidth;
      this.mWidth = (localkm.getWidth() + paramInt1);
    }
    this.iA = 0;
    localIterator = this.mFragments.iterator();
    while (localIterator.hasNext())
    {
      paramInt1 = ((km)localIterator.next()).a(paramETEngine);
      if (paramInt1 > this.iA) {
        this.iA = paramInt1;
      }
    }
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.mFragments.iterator();
    while (localIterator.hasNext())
    {
      km localkm = (km)localIterator.next();
      localkm.a(paramETEngine, paramBitmap, paramETDecoration, paramInt1, this.mHeight - localkm.getHeight() + paramInt2 - (this.iA - localkm.a(paramETEngine)));
      paramInt1 += localkm.getWidth();
    }
  }
  
  public void a(km paramkm)
  {
    this.mFragments.add(paramkm);
  }
  
  public int az()
  {
    return this.iA;
  }
  
  public void c(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.mFragments.iterator();
    while (localIterator.hasNext())
    {
      km localkm = (km)localIterator.next();
      localkm.b(paramCanvas, paramInt1, paramInt2, this.mHeight);
      paramInt1 += localkm.getWidth();
    }
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getLeft()
  {
    return this.mLeft;
  }
  
  public int getTop()
  {
    return this.mTop;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public ArrayList<km> i()
  {
    return this.mFragments;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kq
 * JD-Core Version:    0.7.0.1
 */