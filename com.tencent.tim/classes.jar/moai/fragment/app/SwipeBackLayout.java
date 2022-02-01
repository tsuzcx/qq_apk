package moai.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.tencent.androidqqmail.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwipeBackLayout
  extends NoSaveStateFrameLayout
{
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  private static final float DEFAULT_SCROLL_THRESHOLD = 0.3F;
  public static final int EDGE_ALL = 11;
  public static final int EDGE_BOTTOM = 8;
  private static final int[] EDGE_FLAGS = { 1, 2, 8, 11 };
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  private static final int FULL_ALPHA = 255;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int OVERSCROLL_DISTANCE = 10;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private Activity mActivity;
  private int mContentLeft;
  private int mContentTop;
  private View mContentView;
  private ViewDragHelper mDragHelper = ViewDragHelper.create(this, new ViewDragCallback(null));
  private int mEdgeFlag;
  private boolean mEnable = true;
  private boolean mInLayout;
  private List<SwipeListener> mListeners;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private float mScrollPercent;
  private float mScrollThreshold = 0.3F;
  private Drawable mShadowBottom;
  private Drawable mShadowLeft;
  private Drawable mShadowRight;
  private Rect mTmpRect = new Rect();
  private int mTrackingEdge;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2131034116);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwipeBackLayout, paramInt, 2131755606);
    paramInt = paramContext.getDimensionPixelSize(R.styleable.SwipeBackLayout_edge_size, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(EDGE_FLAGS[paramContext.getInt(R.styleable.SwipeBackLayout_edge_flag, 0)]);
    paramInt = paramContext.getResourceId(R.styleable.SwipeBackLayout_shadow_left, 2130850685);
    int i = paramContext.getResourceId(R.styleable.SwipeBackLayout_shadow_right, 2130850686);
    int j = paramContext.getResourceId(R.styleable.SwipeBackLayout_shadow_bottom, 2130850684);
    setShadow(paramInt, 1);
    setShadow(i, 2);
    setShadow(j, 8);
    paramContext.recycle();
    float f = getResources().getDisplayMetrics().density * 400.0F;
    this.mDragHelper.setMinVelocity(f);
    this.mDragHelper.setMaxVelocity(f * 2.0F);
  }
  
  private void drawScrim(Canvas paramCanvas, View paramView)
  {
    int i = (int)(((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
    int j = this.mScrimColor;
    if ((this.mTrackingEdge & 0x1) != 0) {
      paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
    }
    for (;;)
    {
      paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
      return;
      if ((this.mTrackingEdge & 0x2) != 0) {
        paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
      } else if ((this.mTrackingEdge & 0x8) != 0) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
      }
    }
  }
  
  private void drawShadow(Canvas paramCanvas, View paramView)
  {
    Rect localRect = this.mTmpRect;
    paramView.getHitRect(localRect);
    if ((this.mEdgeFlag & 0x1) != 0)
    {
      this.mShadowLeft.setBounds(localRect.left - this.mShadowLeft.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
      this.mShadowLeft.setAlpha((int)(this.mScrimOpacity * 255.0F));
      this.mShadowLeft.draw(paramCanvas);
    }
    if ((this.mEdgeFlag & 0x2) != 0)
    {
      this.mShadowRight.setBounds(localRect.right, localRect.top, localRect.right + this.mShadowRight.getIntrinsicWidth(), localRect.bottom);
      this.mShadowRight.setAlpha((int)(this.mScrimOpacity * 255.0F));
      this.mShadowRight.draw(paramCanvas);
    }
    if ((this.mEdgeFlag & 0x8) != 0)
    {
      this.mShadowBottom.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.mShadowBottom.getIntrinsicHeight());
      this.mShadowBottom.setAlpha((int)(this.mScrimOpacity * 255.0F));
      this.mShadowBottom.draw(paramCanvas);
    }
  }
  
  private void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  static SwipeBackLayout wrap(View paramView)
  {
    SwipeBackLayout localSwipeBackLayout = new SwipeBackLayout(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null) {
      localSwipeBackLayout.setLayoutParams(localLayoutParams);
    }
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localSwipeBackLayout.addView(paramView);
    localSwipeBackLayout.setContentView(paramView);
    return localSwipeBackLayout;
  }
  
  public void addSwipeListener(SwipeListener paramSwipeListener)
  {
    if (this.mListeners == null) {
      this.mListeners = new ArrayList();
    }
    if (!this.mListeners.contains(paramSwipeListener)) {
      this.mListeners.add(paramSwipeListener);
    }
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    Object localObject = paramActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
    int i = ((TypedArray)localObject).getResourceId(0, 0);
    ((TypedArray)localObject).recycle();
    paramActivity = (ViewGroup)paramActivity.getWindow().getDecorView();
    localObject = (ViewGroup)paramActivity.getChildAt(0);
    ((ViewGroup)localObject).setBackgroundResource(i);
    paramActivity.removeView((View)localObject);
    addView((View)localObject);
    setContentView((View)localObject);
    paramActivity.addView(this);
  }
  
  public void computeScroll()
  {
    this.mScrimOpacity = (1.0F - this.mScrollPercent);
    if (this.mDragHelper.continueSettling(true)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (paramView == this.mContentView) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.mScrimOpacity > 0.0F) && (i != 0) && (this.mDragHelper.getViewDragState() != 0))
      {
        drawShadow(paramCanvas, paramView);
        drawScrim(paramCanvas, paramView);
      }
      return bool;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return false;
    }
    try
    {
      boolean bool = this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.mContentLeft, this.mContentTop, this.mContentLeft + this.mContentView.getMeasuredWidth(), this.mContentTop + this.mContentView.getMeasuredHeight());
    }
    this.mInLayout = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mEnable) {
      return false;
    }
    this.mDragHelper.processTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void removeSwipeListener(SwipeListener paramSwipeListener)
  {
    if (this.mListeners == null) {
      return;
    }
    this.mListeners.remove(paramSwipeListener);
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  public void scrollToFinishActivity()
  {
    int j = 0;
    int i = this.mContentView.getWidth();
    int k = this.mContentView.getHeight();
    if ((this.mEdgeFlag & 0x1) != 0)
    {
      i = i + this.mShadowLeft.getIntrinsicWidth() + 10;
      this.mTrackingEdge = 1;
    }
    for (;;)
    {
      this.mDragHelper.smoothSlideViewTo(this.mContentView, i, j);
      invalidate();
      return;
      if ((this.mEdgeFlag & 0x2) != 0)
      {
        i = -i - this.mShadowRight.getIntrinsicWidth() - 10;
        this.mTrackingEdge = 2;
      }
      else if ((this.mEdgeFlag & 0x8) != 0)
      {
        j = -k;
        k = this.mShadowBottom.getIntrinsicHeight();
        this.mTrackingEdge = 8;
        i = 0;
        j = j - k - 10;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void setEdgeSize(int paramInt)
  {
    this.mDragHelper.setEdgeSize(paramInt);
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.mEdgeFlag = paramInt;
    this.mDragHelper.setEdgeTrackingEnabled(this.mEdgeFlag);
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setScrimColor(int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }
  
  public void setScrollThresHold(float paramFloat)
  {
    if ((paramFloat >= 1.0F) || (paramFloat <= 0.0F)) {
      throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
    }
    this.mScrollThreshold = paramFloat;
  }
  
  public void setSensitivity(Context paramContext, float paramFloat)
  {
    this.mDragHelper.setSensitivity(paramContext, paramFloat);
  }
  
  public void setShadow(int paramInt1, int paramInt2)
  {
    setShadow(getResources().getDrawable(paramInt1), paramInt2);
  }
  
  public void setShadow(Drawable paramDrawable, int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      this.mShadowLeft = paramDrawable;
    }
    for (;;)
    {
      invalidate();
      return;
      if ((paramInt & 0x2) != 0) {
        this.mShadowRight = paramDrawable;
      } else if ((paramInt & 0x8) != 0) {
        this.mShadowBottom = paramDrawable;
      }
    }
  }
  
  @Deprecated
  public void setSwipeListener(SwipeListener paramSwipeListener)
  {
    addSwipeListener(paramSwipeListener);
  }
  
  public static abstract interface SwipeListener
  {
    public abstract void onDragBack();
    
    public abstract void onEdgeTouch(int paramInt);
    
    public abstract void onScrollOverThreshold();
    
    public abstract void onScrollStateChange(int paramInt, float paramFloat);
  }
  
  class ViewDragCallback
    extends ViewDragHelper.Callback
  {
    private boolean mIsScrollOverValid;
    
    private ViewDragCallback() {}
    
    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      paramInt2 = 0;
      if ((SwipeBackLayout.this.mTrackingEdge & 0x1) != 0) {
        paramInt2 = Math.min(paramView.getWidth(), Math.max(paramInt1, 0));
      }
      while ((SwipeBackLayout.this.mTrackingEdge & 0x2) == 0) {
        return paramInt2;
      }
      return Math.min(0, Math.max(paramInt1, -paramView.getWidth()));
    }
    
    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      paramInt2 = 0;
      if ((SwipeBackLayout.this.mTrackingEdge & 0x8) != 0) {
        paramInt2 = Math.min(0, Math.max(paramInt1, -paramView.getHeight()));
      }
      return paramInt2;
    }
    
    public int getViewHorizontalDragRange(View paramView)
    {
      return SwipeBackLayout.this.mEdgeFlag & 0x3;
    }
    
    public int getViewVerticalDragRange(View paramView)
    {
      return SwipeBackLayout.this.mEdgeFlag & 0x8;
    }
    
    public void onViewDragStateChanged(int paramInt)
    {
      super.onViewDragStateChanged(paramInt);
      if ((SwipeBackLayout.this.mListeners != null) && (!SwipeBackLayout.this.mListeners.isEmpty()))
      {
        Iterator localIterator = SwipeBackLayout.this.mListeners.iterator();
        while (localIterator.hasNext()) {
          ((SwipeBackLayout.SwipeListener)localIterator.next()).onScrollStateChange(paramInt, SwipeBackLayout.this.mScrollPercent);
        }
      }
    }
    
    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onViewPositionChanged(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((SwipeBackLayout.this.mTrackingEdge & 0x1) != 0) {
        SwipeBackLayout.access$502(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.this.mContentView.getWidth() + SwipeBackLayout.this.mShadowLeft.getIntrinsicWidth())));
      }
      for (;;)
      {
        SwipeBackLayout.access$1002(SwipeBackLayout.this, paramInt1);
        SwipeBackLayout.access$1102(SwipeBackLayout.this, paramInt2);
        SwipeBackLayout.this.invalidate();
        if ((SwipeBackLayout.this.mScrollPercent < SwipeBackLayout.this.mScrollThreshold) && (!this.mIsScrollOverValid)) {
          this.mIsScrollOverValid = true;
        }
        if ((SwipeBackLayout.this.mListeners == null) || (SwipeBackLayout.this.mListeners.isEmpty()) || (SwipeBackLayout.this.mDragHelper.getViewDragState() != 1) || (SwipeBackLayout.this.mScrollPercent < SwipeBackLayout.this.mScrollThreshold) || (!this.mIsScrollOverValid)) {
          break;
        }
        this.mIsScrollOverValid = false;
        paramView = SwipeBackLayout.this.mListeners.iterator();
        while (paramView.hasNext()) {
          ((SwipeBackLayout.SwipeListener)paramView.next()).onScrollOverThreshold();
        }
        if ((SwipeBackLayout.this.mTrackingEdge & 0x2) != 0) {
          SwipeBackLayout.access$502(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.this.mContentView.getWidth() + SwipeBackLayout.this.mShadowRight.getIntrinsicWidth())));
        } else if ((SwipeBackLayout.this.mTrackingEdge & 0x8) != 0) {
          SwipeBackLayout.access$502(SwipeBackLayout.this, Math.abs(paramInt2 / (SwipeBackLayout.this.mContentView.getHeight() + SwipeBackLayout.this.mShadowBottom.getIntrinsicHeight())));
        }
      }
      if (SwipeBackLayout.this.mScrollPercent >= 1.0F) {
        SwipeBackLayout.access$502(SwipeBackLayout.this, 1.0F);
      }
    }
    
    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      int j = 0;
      int i = paramView.getWidth();
      int k = paramView.getHeight();
      if ((SwipeBackLayout.this.mTrackingEdge & 0x1) != 0) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.this.mScrollPercent > SwipeBackLayout.this.mScrollThreshold))) {
          i = i + SwipeBackLayout.this.mShadowLeft.getIntrinsicWidth() + 10;
        }
      }
      for (;;)
      {
        SwipeBackLayout.this.mDragHelper.settleCapturedViewAt(i, j);
        if ((i != 0) && (SwipeBackLayout.this.mListeners != null) && (!SwipeBackLayout.this.mListeners.isEmpty()))
        {
          paramView = SwipeBackLayout.this.mListeners.iterator();
          for (;;)
          {
            if (paramView.hasNext())
            {
              ((SwipeBackLayout.SwipeListener)paramView.next()).onDragBack();
              continue;
              i = 0;
              break;
              if ((SwipeBackLayout.this.mTrackingEdge & 0x2) != 0)
              {
                if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.this.mScrollPercent > SwipeBackLayout.this.mScrollThreshold)))
                {
                  i = -(i + SwipeBackLayout.this.mShadowLeft.getIntrinsicWidth() + 10);
                  break;
                }
                i = 0;
                break;
              }
              if ((SwipeBackLayout.this.mTrackingEdge & 0x8) == 0) {
                break label325;
              }
              if ((paramFloat2 < 0.0F) || ((paramFloat2 == 0.0F) && (SwipeBackLayout.this.mScrollPercent > SwipeBackLayout.this.mScrollThreshold))) {}
              for (i = -(SwipeBackLayout.this.mShadowBottom.getIntrinsicHeight() + k + 10);; i = 0)
              {
                k = 0;
                j = i;
                i = k;
                break;
              }
            }
          }
        }
        SwipeBackLayout.this.invalidate();
        return;
        label325:
        i = 0;
      }
    }
    
    public boolean tryCaptureView(View paramView, int paramInt)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      if ((SwipeBackLayout.this.mEdgeFlag == 1) || (SwipeBackLayout.this.mEdgeFlag == 2)) {
        if (!SwipeBackLayout.this.mDragHelper.checkTouchSlop(2, paramInt)) {
          bool1 = true;
        }
      }
      for (;;)
      {
        boolean bool3 = SwipeBackLayout.this.mDragHelper.isEdgeTouched(SwipeBackLayout.this.mEdgeFlag, paramInt);
        if (bool3)
        {
          if (SwipeBackLayout.this.mDragHelper.isEdgeTouched(1, paramInt)) {
            SwipeBackLayout.access$302(SwipeBackLayout.this, 1);
          }
          for (;;)
          {
            if ((SwipeBackLayout.this.mListeners == null) || (SwipeBackLayout.this.mListeners.isEmpty()) || (!bool1)) {
              break label276;
            }
            paramView = SwipeBackLayout.this.mListeners.iterator();
            while (paramView.hasNext()) {
              ((SwipeBackLayout.SwipeListener)paramView.next()).onEdgeTouch(SwipeBackLayout.this.mTrackingEdge);
            }
            if (SwipeBackLayout.this.mEdgeFlag == 8)
            {
              bool1 = bool2;
              if (!SwipeBackLayout.this.mDragHelper.checkTouchSlop(1, paramInt)) {
                bool1 = true;
              }
              break;
            }
            if (SwipeBackLayout.this.mEdgeFlag != 11) {
              break label286;
            }
            bool1 = true;
            break;
            if (SwipeBackLayout.this.mDragHelper.isEdgeTouched(2, paramInt)) {
              SwipeBackLayout.access$302(SwipeBackLayout.this, 2);
            } else if (SwipeBackLayout.this.mDragHelper.isEdgeTouched(8, paramInt)) {
              SwipeBackLayout.access$302(SwipeBackLayout.this, 8);
            }
          }
          label276:
          this.mIsScrollOverValid = true;
        }
        return bool3 & bool1;
        label286:
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */