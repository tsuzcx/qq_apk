import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.av.redpacket.AVRedPacketManager;

public class itd
{
  public isd[] a = new isd[8];
  
  public itd(Context paramContext)
  {
    this.a[0] = new isv();
    this.a[1] = new ist(paramContext);
    this.a[2] = new isi();
    this.a[3] = new isy();
    this.a[4] = new isg();
    this.a[5] = new isf();
    this.a[6] = new ise();
    this.a[7] = new isr();
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    if (paramBoolean) {}
    for (this.a[3].b = null;; this.a[3].b = null)
    {
      ((ist)this.a[1]).a(paramBoolean, paramAVRedPacketManager);
      return;
    }
  }
  
  public boolean ax(long paramLong)
  {
    boolean bool2 = false;
    isd[] arrayOfisd = this.a;
    int j = arrayOfisd.length;
    int i = 0;
    while (i < j)
    {
      arrayOfisd[i].update(paramLong);
      i += 1;
    }
    boolean bool1 = bool2;
    if (this.a[7].mStartTime != 0L)
    {
      bool1 = bool2;
      if (paramLong - this.a[7].mStartTime > 5564L) {
        bool1 = true;
      }
    }
    if (bool1) {
      this.a[7].mStartTime = 0L;
    }
    return bool1;
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.a[0].b = new itc(paramAVRedPacketManager.o("qav_redpacket_light_bg.png"));
    this.a[2].b = new itc(paramAVRedPacketManager.o("qav_redpacket_cd.png"));
    this.a[4].b = new itc(paramAVRedPacketManager.o("qav_redpacket_3.png"));
    this.a[5].b = new itc(paramAVRedPacketManager.o("qav_redpacket_2.png"));
    this.a[6].b = new itc(paramAVRedPacketManager.o("qav_redpacket_1.png"));
    this.a[7].b = new itc(paramAVRedPacketManager.o("qav_redpacket_go.png"));
  }
  
  public void cw(long paramLong)
  {
    this.a[0].mStartTime = paramLong;
    this.a[1].mStartTime = paramLong;
    this.a[2].mStartTime = paramLong;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    isd[] arrayOfisd = this.a;
    int j = arrayOfisd.length;
    int i = 0;
    while (i < j)
    {
      arrayOfisd[i].draw(paramCanvas, paramPaint);
      i += 1;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    isd[] arrayOfisd = this.a;
    int j = arrayOfisd.length;
    int i = 0;
    while (i < j)
    {
      arrayOfisd[i].onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  public void recycle()
  {
    isd[] arrayOfisd = this.a;
    int j = arrayOfisd.length;
    int i = 0;
    while (i < j)
    {
      arrayOfisd[i].recycle();
      i += 1;
    }
    this.a = null;
  }
  
  public long v(long paramLong)
  {
    long l2;
    if (paramLong < this.a[0].mStartTime)
    {
      l2 = this.a[0].mStartTime;
      l1 = this.a[0].mStartTime;
      l2 -= paramLong;
      paramLong = l1;
    }
    for (long l1 = l2;; l1 = 0L)
    {
      isd[] arrayOfisd = this.a;
      int j = arrayOfisd.length;
      int i = 0;
      while (i < j)
      {
        arrayOfisd[i].mStartTime = paramLong;
        i += 1;
      }
      ((isv)this.a[0]).mIsReady = true;
      ((ist)this.a[1]).mIsReady = true;
      ((isi)this.a[2]).mIsReady = true;
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itd
 * JD-Core Version:    0.7.0.1
 */