package dov.com.tencent.biz.qqstory.takevideo.sendpanel;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import ayrd;
import ayrn;
import ayro;
import ayrp;
import ayrq;
import ayrr;
import com.tencent.mobileqq.mini.util.DisplayUtil;

public class SlideBottomPanel
  extends FrameLayout
{
  protected static float Gc = 5.0F;
  protected float Gd;
  protected float Ge;
  protected float Gf;
  protected float Gg;
  protected float Gh;
  protected float Gi;
  public float Gj;
  protected float Gk;
  public ayrd a;
  protected int aDH;
  protected long aDf;
  private int aXn;
  public int bSn;
  protected int csM;
  public boolean dAy;
  protected boolean dAz;
  protected float downY;
  protected int eMC;
  protected int eMD;
  protected Interpolator f = new AccelerateInterpolator();
  protected Interpolator g = new AccelerateInterpolator();
  public boolean isAnimating;
  public boolean isAtBottom;
  protected boolean isDragging;
  protected int mAnimationDuration;
  private Context mContext;
  private float mDensity;
  protected float mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private int pW;
  private int screenHeight;
  
  public SlideBottomPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideBottomPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mDensity = getResources().getDisplayMetrics().density;
    paramContext = ViewConfiguration.get(this.mContext);
    this.aXn = paramContext.getScaledMaximumFlingVelocity();
    this.csM = paramContext.getScaledMinimumFlingVelocity();
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    paramContext = (WindowManager)this.mContext.getSystemService("window");
    paramAttributeSet = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(paramAttributeSet);
    this.screenHeight = paramAttributeSet.heightPixels;
    this.Gi = (this.screenHeight - kH(60));
    float f1 = kH(84);
    this.Gj = f1;
    Gc = f1;
    this.Gk = kH(30);
    this.mAnimationDuration = 250;
    this.bSn = this.screenHeight;
    if ((DisplayUtil.hasNavBar(this.mContext)) && (DisplayUtil.isNavigationBarShow((Activity)this.mContext))) {}
    for (this.aDH = kH(30);; this.aDH = kH(51))
    {
      this.eMC = ((int)(this.Gj - this.aDH));
      this.eMD = kH(5);
      return;
    }
  }
  
  private void an(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private int kH(int paramInt)
  {
    return (int)(paramInt * this.mDensity + 0.5F);
  }
  
  private void releaseVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  protected int FY()
  {
    if (this.isAtBottom) {
      return this.bSn - this.aDH;
    }
    return (int)(this.bSn - this.Gj);
  }
  
  public boolean aQY()
  {
    return this.isAtBottom;
  }
  
  public boolean aQZ()
  {
    return this.dAy;
  }
  
  protected boolean aj(MotionEvent paramMotionEvent)
  {
    this.aDf = System.currentTimeMillis();
    this.Gf = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    this.downY = f1;
    this.Gg = f1;
    if ((!this.dAy) && (this.downY > FY()))
    {
      this.dAz = true;
      return true;
    }
    if ((!this.dAy) && (this.downY <= FY()))
    {
      this.dAz = false;
      return false;
    }
    if ((this.dAy) && (this.downY > this.bSn - this.Gi) && (this.downY <= this.bSn - this.Gi + this.Gj))
    {
      this.dAz = true;
      return false;
    }
    if ((this.dAy) && (this.downY < this.bSn - this.Gi))
    {
      hidePanel();
      this.dAz = false;
    }
    return false;
  }
  
  protected double c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  protected void caU()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000, this.aXn);
    this.Gd = this.mVelocityTracker.getXVelocity();
    this.Ge = this.mVelocityTracker.getYVelocity();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    an(paramMotionEvent);
    if (this.a != null) {
      this.a.cancelAnimator();
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool1 = false;
      for (;;)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (!super.dispatchTouchEvent(paramMotionEvent)) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        bool1 = aj(paramMotionEvent);
        continue;
        handleActionMove(paramMotionEvent);
        bool1 = false;
      }
      handleActionUp(paramMotionEvent);
      releaseVelocityTracker();
    }
  }
  
  public void displayPanel()
  {
    if ((this.dAy) || (this.isAnimating)) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.bSn - this.Gi }).setDuration(this.mAnimationDuration);
      localValueAnimator.setTarget(localView);
      localValueAnimator.setInterpolator(this.f);
      localValueAnimator.addUpdateListener(new ayrq(this, localView));
      localValueAnimator.addListener(new ayrr(this));
      localValueAnimator.start();
      this.dAy = true;
      this.isAtBottom = false;
    } while (this.a == null);
    this.a.displayPanel();
  }
  
  public void eTr()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    ObjectAnimator.ofFloat(localView, "y", new float[] { localView.getY(), this.bSn - this.aDH }).setDuration(this.mAnimationDuration).start();
    this.isAtBottom = true;
  }
  
  public void eTs()
  {
    View localView = findViewWithTag(Integer.valueOf(1));
    ObjectAnimator.ofFloat(localView, "y", new float[] { localView.getY(), this.bSn - this.Gj }).setDuration(this.mAnimationDuration).start();
    this.isAtBottom = false;
  }
  
  protected void handleActionMove(MotionEvent paramMotionEvent)
  {
    if (!this.dAz) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          caU();
        } while (Math.abs(this.Gd) > Math.abs(this.Ge));
        localView = findViewWithTag(Integer.valueOf(1));
        if ((!this.isDragging) && (Math.abs(paramMotionEvent.getY() - this.Gg) > this.mTouchSlop))
        {
          this.isDragging = true;
          this.downY = paramMotionEvent.getY();
          localView.addOnLayoutChangeListener(new ayrn(this));
        }
      } while (!this.isDragging);
      this.Gh = (paramMotionEvent.getY() - this.downY);
      this.downY = paramMotionEvent.getY();
      float f1 = localView.getY();
      if ((this.a != null) && (f1 > this.bSn - this.Gi) && (f1 < this.bSn - this.Gj)) {
        this.a.fadeBackground(1.0F - f1 / (this.bSn - this.Gj));
      }
      if (this.Gh + f1 <= this.bSn - this.Gi)
      {
        localView.offsetTopAndBottom((int)(this.bSn - this.Gi - f1));
        return;
      }
      if (f1 + this.Gh < FY()) {
        break;
      }
    } while (this.isAtBottom);
    if (this.Gh > this.eMC) {
      this.Gh = this.eMC;
    }
    localView.offsetTopAndBottom((int)this.Gh);
    return;
    localView.offsetTopAndBottom((int)this.Gh);
  }
  
  protected void handleActionUp(MotionEvent paramMotionEvent)
  {
    if (!this.dAz) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.aDf;
    caU();
    float f1;
    if (((!this.dAy) && (paramMotionEvent.getY() - this.Gg < 0.0F) && (Math.abs(paramMotionEvent.getY() - this.Gg) > this.Gk)) || ((this.Ge < 0.0F) && (Math.abs(this.Ge) > Math.abs(this.Gd)) && (Math.abs(this.Ge) > this.csM)))
    {
      displayPanel();
      if (this.dAy)
      {
        paramMotionEvent = findViewWithTag(Integer.valueOf(1));
        f1 = paramMotionEvent.getY();
        if ((f1 >= this.bSn - this.Gi) && (f1 >= this.bSn - this.Gi + this.Gk)) {
          break label434;
        }
        ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { f1, this.bSn - this.Gi }).setDuration(this.mAnimationDuration).start();
      }
    }
    for (;;)
    {
      this.dAz = false;
      this.isDragging = false;
      this.Gh = 0.0F;
      return;
      if ((!this.dAy) && (l1 - l2 < 300L) && (paramMotionEvent.getY() - this.Gg < 0.0F) && (c(this.Gf, this.Gg, paramMotionEvent.getX(), paramMotionEvent.getY()) < Gc))
      {
        displayPanel();
        break;
      }
      if ((this.dAy) || (!this.isDragging)) {
        break;
      }
      int i = (int)(paramMotionEvent.getY() - this.Gg);
      if (((!this.isAtBottom) && (i > this.eMD)) || ((this.isAtBottom) && (i < 0) && (Math.abs(i) < this.Gk))) {
        eTr();
      }
      if ((this.isAtBottom) || (i >= 0) || (Math.abs(i) >= this.Gk)) {
        break;
      }
      paramMotionEvent = findViewWithTag(Integer.valueOf(1));
      ObjectAnimator.ofFloat(paramMotionEvent, "y", new float[] { paramMotionEvent.getY(), this.bSn - this.Gj }).setDuration(this.mAnimationDuration).start();
      break;
      label434:
      if (f1 > this.bSn - this.Gi + this.Gk) {
        hidePanel();
      }
    }
  }
  
  public void hide()
  {
    if (!this.dAy) {
      return;
    }
    hidePanel();
  }
  
  protected void hidePanel()
  {
    if (this.isAnimating) {}
    do
    {
      return;
      View localView = findViewWithTag(Integer.valueOf(1));
      int i = (int)(this.bSn - this.Gj);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { localView.getY(), this.bSn - this.Gj });
      localValueAnimator.setInterpolator(this.g);
      localValueAnimator.setTarget(localView);
      localValueAnimator.addUpdateListener(new ayro(this, localView, i));
      localValueAnimator.addListener(new ayrp(this));
      localValueAnimator.start();
    } while (this.a == null);
    this.a.hidePanel();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.isDragging;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pW = getChildCount();
    paramInt2 = (int)(this.bSn - this.Gj);
    paramInt1 = 0;
    while (paramInt1 < this.pW)
    {
      View localView = getChildAt(paramInt1);
      localView.layout(0, paramInt2, localView.getMeasuredWidth(), localView.getMeasuredHeight() + paramInt2);
      localView.setTag(Integer.valueOf(1));
      paramInt1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.isDragging) || (this.dAy);
  }
  
  public void setSlidePanelListener(ayrd paramayrd)
  {
    this.a = paramayrd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel
 * JD-Core Version:    0.7.0.1
 */