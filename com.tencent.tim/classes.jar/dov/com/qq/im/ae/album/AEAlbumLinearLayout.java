package dov.com.qq.im.ae.album;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import atau.a;
import awuj;
import awuk;
import axiy;

public class AEAlbumLinearLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private View Bj;
  private View LU;
  private a a;
  private ValueAnimator aU;
  private boolean dsF;
  private int eCX;
  private int eCY;
  private int eCZ;
  private int eDa = 0;
  private int eDb = 0;
  private Interpolator mInterpolator;
  
  public AEAlbumLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pv);
    try
    {
      this.eCX = paramContext.getDimensionPixelSize(0, 0);
    }
    catch (Exception paramAttributeSet)
    {
      for (;;)
      {
        axiy.e("AEAlbumLinearLayout", "constructor, error=", paramAttributeSet);
        paramContext.recycle();
      }
    }
    finally
    {
      paramContext.recycle();
    }
    setOrientation(1);
    this.mInterpolator = new AccelerateDecelerateInterpolator();
  }
  
  private float bW()
  {
    return 1.0F * getScrollY() / this.eCZ;
  }
  
  private void eGt()
  {
    int i = this.eCZ / 2;
    if ((getScrollY() > 0) && (getScrollY() < i)) {
      eGs();
    }
    while ((i > getScrollY()) || (getScrollY() >= this.eCZ)) {
      return;
    }
    eGr();
  }
  
  private void eGu()
  {
    if (this.aU == null)
    {
      this.aU = new ValueAnimator();
      this.aU.setInterpolator(this.mInterpolator);
      this.aU.addUpdateListener(new awuj(this));
      this.aU.addListener(new awuk(this));
      return;
    }
    this.aU.cancel();
  }
  
  private boolean nY(int paramInt)
  {
    if (paramInt == 1) {
      return aNJ();
    }
    if (paramInt == 2) {
      return aNI();
    }
    return false;
  }
  
  public boolean aNI()
  {
    return getScrollY() == 0;
  }
  
  public boolean aNJ()
  {
    return getScrollY() == this.eCZ;
  }
  
  public void eGr()
  {
    axiy.d("AEAlbumLinearLayout", "[collapsePreviewContainer]");
    if (getScrollY() >= this.eCZ)
    {
      axiy.d("AEAlbumLinearLayout", "[collapsePreviewContainer], already collapsed");
      return;
    }
    this.eDb = 1;
    int i = this.eCZ - getScrollY();
    int j = (int)(1.0F * i / this.eCZ * 275.0F);
    axiy.d("AEAlbumLinearLayout", "[collapsePreviewContainer], dy=" + i + ", duration=" + j);
    eGu();
    this.aU.setIntValues(new int[] { getScrollY(), this.eCZ });
    this.aU.setDuration(j);
    this.aU.start();
  }
  
  public void eGs()
  {
    axiy.d("AEAlbumLinearLayout", "[expandPreviewContainer]");
    if (getScrollY() <= 0)
    {
      axiy.d("AEAlbumLinearLayout", "[expandPreviewContainer], already expanded");
      return;
    }
    this.eDb = 2;
    int i = -getScrollY();
    int j = (int)(1.0F * getScrollY() / this.eCZ * 275.0F);
    axiy.d("AEAlbumLinearLayout", "[expandPreviewContainer], dy=" + i + ", duration=" + j);
    eGu();
    this.aU.setIntValues(new int[] { getScrollY(), 0 });
    this.aU.setDuration(j);
    this.aU.start();
  }
  
  public int getNestedScrollAxes()
  {
    axiy.d("AEAlbumLinearLayout", "[getNestedScrollAxes]");
    return 2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.Bj = getChildAt(0);
    this.LU = getChildAt(1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.eCY = this.Bj.getMeasuredHeight();
    if ((this.eCY < this.eCX) || (this.eCX == 0)) {
      this.eCX = (this.eCY / 3);
    }
    this.eCZ = (this.eCY - this.eCX);
    this.LU.getLayoutParams().height = (getMeasuredHeight() - this.eCX);
    setMeasuredDimension(getMeasuredWidth(), this.Bj.getMeasuredHeight() + this.LU.getMeasuredHeight());
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    axiy.d("AEAlbumLinearLayout", "[onNestedFling], velocityX=" + paramFloat1 + ", velocityY=" + paramFloat2 + ", consumed=" + paramBoolean);
    return super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    axiy.d("AEAlbumLinearLayout", "[onNestedPreFling], velocityX=" + paramFloat1 + ", velocityY=" + paramFloat2);
    if ((paramFloat2 > 0.0F) && (getScrollY() < this.eCZ))
    {
      eGr();
      this.dsF = true;
    }
    return this.dsF;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    axiy.d("AEAlbumLinearLayout", "[onNestedPreScroll], dy=" + paramInt2 + ", scrollY=" + getScrollY());
    int i;
    if ((paramInt2 > 0) && (getScrollY() < this.eCZ))
    {
      paramInt1 = 1;
      if ((paramInt2 >= 0) || (getScrollY() <= 0) || (ViewCompat.canScrollVertically(paramView, -1))) {
        break label165;
      }
      i = 1;
      label77:
      if ((paramInt1 != 0) || (i != 0))
      {
        if (paramInt1 == 0) {
          break label171;
        }
        paramInt2 = Math.min(paramInt2, this.eCZ - getScrollY());
        label104:
        scrollBy(0, paramInt2);
        paramArrayOfInt[1] = paramInt2;
        if (paramInt1 == 0) {
          break label184;
        }
      }
    }
    label165:
    label171:
    label184:
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      this.eDa = paramInt1;
      if (this.a != null)
      {
        this.a.onScrollStart(this.eDa);
        this.a.bq(bW());
      }
      return;
      paramInt1 = 0;
      break;
      i = 0;
      break label77;
      paramInt2 = Math.max(paramInt2, -getScrollY());
      break label104;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    axiy.d("AEAlbumLinearLayout", "[onNestedScroll], dxConsumed=" + paramInt1 + ", dyConsumed=" + paramInt2 + ", dxUnconsumed=" + paramInt3 + ", dyUnconsumed=" + paramInt4);
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.bq(bW());
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    axiy.d("AEAlbumLinearLayout", "[onNestedScrollAccepted], axes=" + paramInt);
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    axiy.d("AEAlbumLinearLayout", "[onStartNestedScroll], nestedScrollAxes=" + paramInt);
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    axiy.d("AEAlbumLinearLayout", "[onStopNestedScroll], scrollY=" + getScrollY());
    super.onStopNestedScroll(paramView);
    if (!this.dsF) {
      eGt();
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.cw(this.eDa, nY(this.eDa));
      }
      this.eDa = 0;
      return;
      this.dsF = false;
    }
  }
  
  public void setScrollListener(@Nullable a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bq(float paramFloat);
    
    public abstract void cw(int paramInt, boolean paramBoolean);
    
    public abstract void onScrollStart(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.AEAlbumLinearLayout
 * JD-Core Version:    0.7.0.1
 */