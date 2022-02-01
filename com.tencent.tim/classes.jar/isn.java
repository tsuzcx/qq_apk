import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class isn
  extends isq
{
  public isj a;
  public int atm;
  public int atn;
  public itc[] e = new itc[6];
  public itc[] f = new itc[6];
  public int mHeight;
  public boolean mIsBig;
  public int mWidth;
  
  public isn(isj paramisj)
  {
    this.a = paramisj;
    this.c = this.e;
    this.mDuration = 1800L;
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.e.length) {
        break;
      }
      this.e[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_focus_" + i * 6 + ".png"));
      i += 1;
    }
    while (j < this.f.length)
    {
      this.f[j] = new itc(paramAVRedPacketManager.o("qav_redpacket_focus_big_" + j * 6 + ".png"));
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
    for (itc[] arrayOfitc = this.f;; arrayOfitc = this.e)
    {
      this.c = arrayOfitc;
      this.mDuration = (this.c.length * 300);
      return;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = (paramInt1 * 380 / 750);
    this.mHeight = (paramInt1 * 380 / 750);
    this.atm = (paramInt1 * 500 / 750);
    this.atn = (paramInt1 * 500 / 750);
  }
  
  public void recycle()
  {
    int j = 0;
    super.recycle();
    itc[] arrayOfitc = this.e;
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
    arrayOfitc = this.f;
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
    this.e = null;
    this.f = null;
  }
  
  public void update(long paramLong)
  {
    super.update(paramLong);
    Rect localRect = this.a.getBounds();
    int i;
    int j;
    int k;
    int m;
    if (this.mIsBig)
    {
      i = (localRect.left + localRect.right - this.atm) / 2;
      j = (localRect.top + localRect.bottom - this.atn) / 2;
      k = (localRect.left + localRect.right + this.atm) / 2;
      m = localRect.top;
      setBounds(i, j, k, (localRect.bottom + m + this.atn) / 2);
      if (this.a.b == null) {
        break label237;
      }
      setAlpha(this.a.getAlpha());
    }
    for (;;)
    {
      setScale(this.a.getScale());
      return;
      i = (localRect.left + localRect.right - this.mWidth) / 2;
      j = (localRect.top + localRect.bottom - this.mHeight) / 2;
      k = (localRect.left + localRect.right + this.mWidth) / 2;
      m = localRect.top;
      setBounds(i, j, k, (localRect.bottom + m + this.mHeight) / 2);
      break;
      label237:
      setAlpha(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isn
 * JD-Core Version:    0.7.0.1
 */