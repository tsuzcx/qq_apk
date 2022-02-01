import android.graphics.Rect;
import com.tencent.av.redpacket.AVRedPacketManager;

public class iss
  extends isq
{
  public isk a;
  public int ato;
  public int mHeight;
  public int mTopOffset;
  public int mWidth;
  
  public iss(isk paramisk)
  {
    this.a = paramisk;
    this.mDuration = 750L;
  }
  
  public void aqk()
  {
    Rect localRect = this.a.getBounds();
    int i = localRect.left - this.ato;
    int j = localRect.top - this.mTopOffset;
    setBounds(i, j, this.mWidth + i, this.mHeight + j);
  }
  
  public void b(AVRedPacketManager paramAVRedPacketManager)
  {
    this.c = new itc[5];
    int i = 0;
    while (i < this.c.length)
    {
      this.c[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_gold_" + i * 2 + ".png"));
      i += 1;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = (paramInt1 * 399 / 750);
    this.mHeight = (paramInt1 * 279 / 750);
    this.ato = (paramInt1 * 155 / 750);
    this.mTopOffset = (paramInt1 * 252 / 750);
  }
  
  public void recycle()
  {
    super.recycle();
    this.a = null;
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
 * Qualified Name:     iss
 * JD-Core Version:    0.7.0.1
 */