import android.content.Context;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import java.lang.ref.WeakReference;

public abstract class jhf
  extends jhd
{
  public jhf(Context paramContext, WeakReference<ZimuView> paramWeakReference, int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramContext, paramWeakReference, paramInt1, paramInt2, paramFloat);
  }
  
  protected abstract int cF(int paramInt);
  
  protected int getOffset(long paramLong)
  {
    return (int)(cF(this.a.l.length()) * paramLong / 1000L);
  }
  
  public boolean isValidate()
  {
    return this.mCurrentX + getWidth() > 0;
  }
  
  public boolean isVisible()
  {
    return (this.mCurrentX + getWidth() > 0) && (this.mCurrentX < this.azH) && (this.mCurrentY + getHeight() > 0) && (this.mCurrentY < this.azI);
  }
  
  public void recycle()
  {
    if ((this.mLoop) && (this.mCurrentX + getWidth() < 0)) {
      this.mCurrentX = this.azH;
    }
  }
  
  public void start(long paramLong)
  {
    super.start(paramLong);
    this.mCurrentX = (getOffset(paramLong) + this.mCurrentX);
  }
  
  public int x(long paramLong)
  {
    int i = 0;
    if (isValidate())
    {
      i = getOffset(paramLong);
      this.mCurrentX -= i;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhf
 * JD-Core Version:    0.7.0.1
 */