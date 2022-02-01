import android.graphics.Rect;

public class isp
  extends isq
{
  public isl a;
  public int mHeight;
  public int mWidth;
  
  public isp(isl paramisl)
  {
    this.mDuration = 1800L;
    this.a = paramisl;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mWidth = (paramInt1 * 152 / 160);
    this.mHeight = (paramInt1 * 152 / 160);
  }
  
  public void recycle()
  {
    super.recycle();
    this.a = null;
  }
  
  public void update(long paramLong)
  {
    super.update(paramLong);
    Rect localRect = this.a.getBounds();
    int i = (localRect.left + localRect.right - this.mWidth) / 2;
    int j = (localRect.top + localRect.bottom - this.mHeight) / 2;
    int k = (localRect.left + localRect.right + this.mWidth) / 2;
    int m = localRect.top;
    setBounds(i, j, k, (localRect.bottom + m + this.mHeight) / 2);
    if (this.a.b != null) {
      setAlpha(this.a.getAlpha());
    }
    for (;;)
    {
      setScale(this.a.getScale());
      return;
      setAlpha(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     isp
 * JD-Core Version:    0.7.0.1
 */