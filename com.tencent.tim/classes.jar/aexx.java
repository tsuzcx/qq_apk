import android.content.res.Resources;
import android.util.DisplayMetrics;

public class aexx
{
  private static boolean sGlobalDrawCacheEnable = true;
  private boolean aJq;
  private float mBorderWidth;
  private boolean mClickEnable = true;
  private boolean mDrawCacheEnable;
  private int mDuration;
  private int mMarginHorizontal;
  private int mMarginVertical;
  private float mPaddingHorizontal;
  private float mPaddingVertical;
  private int mRowCount;
  private int mScreenHeight;
  private int mScreenWidth;
  private float mTextSize;
  private int mWindowMarginTop;
  private float vT;
  private float vU;
  
  public aexx()
  {
    DisplayMetrics localDisplayMetrics = aewr.a().a().d().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    if (this.aJq) {
      this.mScreenHeight = Math.max(i, j);
    }
    for (this.mScreenWidth = Math.min(i, j);; this.mScreenWidth = Math.max(i, j))
    {
      setDuration(8000);
      Mn(12);
      setRowCount(3);
      aI(1.5F);
      setMarginHorizontal(1);
      aJ(5.0F);
      aF(5.0F);
      setClickEnable(true);
      setDrawCacheEnable(true);
      setTextSize(16.0F);
      setBorderWidth(0.0F);
      setPaddingVertical(5.0F);
      setPaddingHorizontal(4.0F);
      return;
      this.mScreenHeight = Math.min(i, j);
    }
  }
  
  public static void HC(boolean paramBoolean)
  {
    sGlobalDrawCacheEnable = paramBoolean;
  }
  
  public static boolean isGlobalDrawCacheEnable()
  {
    return sGlobalDrawCacheEnable;
  }
  
  public int CO()
  {
    return this.mWindowMarginTop;
  }
  
  public void HD(boolean paramBoolean)
  {
    if (this.aJq != paramBoolean)
    {
      int i = this.mScreenWidth;
      this.mScreenWidth = this.mScreenHeight;
      this.mScreenHeight = i;
    }
    this.aJq = paramBoolean;
  }
  
  public void Mn(int paramInt)
  {
    this.mWindowMarginTop = aeyu.dip2px(paramInt);
  }
  
  public void aF(float paramFloat)
  {
    this.vT = aeyu.dip2px(paramFloat);
  }
  
  public void aI(float paramFloat)
  {
    this.mMarginVertical = aeyu.dip2px(paramFloat);
  }
  
  public void aJ(float paramFloat)
  {
    this.vU = aeyu.dip2px(paramFloat);
  }
  
  public float aX()
  {
    return this.vT;
  }
  
  public float aY()
  {
    return this.vU;
  }
  
  public float getBorderWidth()
  {
    return this.mBorderWidth;
  }
  
  public int getDuration()
  {
    return this.mDuration;
  }
  
  public int getMarginHorizontal()
  {
    return this.mMarginHorizontal;
  }
  
  public int getMarginVertical()
  {
    return this.mMarginVertical;
  }
  
  public float getPaddingHorizontal()
  {
    return this.mPaddingHorizontal;
  }
  
  public float getPaddingVertical()
  {
    return this.mPaddingVertical;
  }
  
  public int getRowCount()
  {
    return this.mRowCount;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeight;
  }
  
  public int getScreenWidth()
  {
    return this.mScreenWidth;
  }
  
  public float getTextSize()
  {
    return this.mTextSize;
  }
  
  public boolean isClickEnable()
  {
    return this.mClickEnable;
  }
  
  public boolean isDrawCacheEnable()
  {
    return this.mDrawCacheEnable;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.mBorderWidth = paramFloat;
  }
  
  public void setClickEnable(boolean paramBoolean)
  {
    this.mClickEnable = paramBoolean;
  }
  
  public void setDrawCacheEnable(boolean paramBoolean)
  {
    this.mDrawCacheEnable = paramBoolean;
  }
  
  public void setDuration(int paramInt)
  {
    this.mDuration = paramInt;
  }
  
  public void setMarginHorizontal(int paramInt)
  {
    this.mMarginHorizontal = aeyu.dip2px(paramInt);
  }
  
  public void setPaddingHorizontal(float paramFloat)
  {
    this.mPaddingHorizontal = aeyu.dip2px(paramFloat);
  }
  
  public void setPaddingVertical(float paramFloat)
  {
    this.mPaddingVertical = aeyu.dip2px(paramFloat);
  }
  
  public void setRowCount(int paramInt)
  {
    this.mRowCount = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.mTextSize = aeyu.dip2px(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexx
 * JD-Core Version:    0.7.0.1
 */