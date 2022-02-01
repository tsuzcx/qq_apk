import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class iso
  extends isq
{
  public isk a;
  public itc[] g = new itc[6];
  public itc[] h = new itc[10];
  public int mHeight;
  public boolean mIsBig;
  public int mWidth;
  
  public iso(isk paramisk)
  {
    this.a = paramisk;
    this.c = this.g;
    this.mDuration = 900L;
  }
  
  public void aqk()
  {
    Rect localRect = this.a.getBounds();
    int i = (localRect.left + localRect.right - this.mWidth) / 2;
    int j = (localRect.top + localRect.bottom - this.mHeight) / 2;
    int k = (localRect.left + localRect.right + this.mWidth) / 2;
    int m = localRect.top;
    setBounds(i, j, k, (localRect.bottom + m + this.mHeight) / 2);
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.g.length) {
        break;
      }
      this.g[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_focus_detected_" + (i * 3 + 3) + ".png"));
      i += 1;
    }
    while (j < this.h.length)
    {
      this.h[j] = new itc(paramAVRedPacketManager.o("qav_redpacket_focus_detected_big_" + j * 3 + ".png"));
      j += 1;
    }
  }
  
  public void iP(boolean paramBoolean)
  {
    if (this.mIsBig != paramBoolean)
    {
      this.mIsBig = paramBoolean;
      if (!this.mIsBig) {
        break label45;
      }
    }
    label45:
    for (itc[] arrayOfitc = this.h;; arrayOfitc = this.g)
    {
      this.c = arrayOfitc;
      this.mDuration = (this.c.length * 150);
      return;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = (paramInt1 * 500 / 750);
    this.mHeight = (paramInt1 * 500 / 750);
  }
  
  public void recycle()
  {
    int j = 0;
    super.recycle();
    itc[] arrayOfitc = this.g;
    int k = arrayOfitc.length;
    int i = 0;
    itc localitc;
    while (i < k)
    {
      localitc = arrayOfitc[i];
      if (localitc != null) {
        localitc.recycle();
      }
      i += 1;
    }
    arrayOfitc = this.h;
    k = arrayOfitc.length;
    i = j;
    while (i < k)
    {
      localitc = arrayOfitc[i];
      if (localitc != null) {
        localitc.recycle();
      }
      i += 1;
    }
    this.a = null;
    this.g = null;
    this.h = null;
  }
  
  public void update(long paramLong)
  {
    super.update(paramLong);
    long l = this.mStartTime;
    int i = 0;
    if (paramLong - l <= this.mDuration) {
      i = 255;
    }
    setAlpha(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iso
 * JD-Core Version:    0.7.0.1
 */