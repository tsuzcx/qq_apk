package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ScrollerCompat
{
  static final ScrollerCompatImpl IMPL = new ScrollerCompatImplBase();
  Object mScroller;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 14)
    {
      IMPL = new ScrollerCompatImplIcs();
      return;
    }
    if (i >= 9)
    {
      IMPL = new ScrollerCompatImplGingerbread();
      return;
    }
  }
  
  ScrollerCompat(Context paramContext, Interpolator paramInterpolator)
  {
    this.mScroller = IMPL.createScroller(paramContext, paramInterpolator);
  }
  
  public static ScrollerCompat create(Context paramContext)
  {
    return create(paramContext, null);
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(paramContext, paramInterpolator);
  }
  
  public void abortAnimation()
  {
    IMPL.abortAnimation(this.mScroller);
  }
  
  public boolean computeScrollOffset()
  {
    return IMPL.computeScrollOffset(this.mScroller);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    IMPL.fling(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    IMPL.fling(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public float getCurrVelocity()
  {
    return IMPL.getCurrVelocity(this.mScroller);
  }
  
  public int getCurrX()
  {
    return IMPL.getCurrX(this.mScroller);
  }
  
  public int getCurrY()
  {
    return IMPL.getCurrY(this.mScroller);
  }
  
  public int getFinalX()
  {
    return IMPL.getFinalX(this.mScroller);
  }
  
  public int getFinalY()
  {
    return IMPL.getFinalY(this.mScroller);
  }
  
  public boolean isFinished()
  {
    return IMPL.isFinished(this.mScroller);
  }
  
  public boolean isOverScrolled()
  {
    return IMPL.isOverScrolled(this.mScroller);
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.notifyHorizontalEdgeReached(this.mScroller, paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    IMPL.notifyVerticalEdgeReached(this.mScroller, paramInt1, paramInt2, paramInt3);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.startScroll(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    IMPL.startScroll(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  static abstract interface ScrollerCompatImpl
  {
    public abstract void abortAnimation(Object paramObject);
    
    public abstract boolean computeScrollOffset(Object paramObject);
    
    public abstract Object createScroller(Context paramContext, Interpolator paramInterpolator);
    
    public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
    
    public abstract void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
    
    public abstract float getCurrVelocity(Object paramObject);
    
    public abstract int getCurrX(Object paramObject);
    
    public abstract int getCurrY(Object paramObject);
    
    public abstract int getFinalX(Object paramObject);
    
    public abstract int getFinalY(Object paramObject);
    
    public abstract boolean isFinished(Object paramObject);
    
    public abstract boolean isOverScrolled(Object paramObject);
    
    public abstract void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
  
  static class ScrollerCompatImplBase
    implements ScrollerCompat.ScrollerCompatImpl
  {
    public void abortAnimation(Object paramObject)
    {
      ((Scroller)paramObject).abortAnimation();
    }
    
    public boolean computeScrollOffset(Object paramObject)
    {
      return ((Scroller)paramObject).computeScrollOffset();
    }
    
    public Object createScroller(Context paramContext, Interpolator paramInterpolator)
    {
      if (paramInterpolator != null) {
        return new Scroller(paramContext, paramInterpolator);
      }
      return new Scroller(paramContext);
    }
    
    public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ((Scroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      ((Scroller)paramObject).fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public float getCurrVelocity(Object paramObject)
    {
      return 0.0F;
    }
    
    public int getCurrX(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrX();
    }
    
    public int getCurrY(Object paramObject)
    {
      return ((Scroller)paramObject).getCurrY();
    }
    
    public int getFinalX(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalX();
    }
    
    public int getFinalY(Object paramObject)
    {
      return ((Scroller)paramObject).getFinalY();
    }
    
    public boolean isFinished(Object paramObject)
    {
      return ((Scroller)paramObject).isFinished();
    }
    
    public boolean isOverScrolled(Object paramObject)
    {
      return false;
    }
    
    public void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ((Scroller)paramObject).startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  static class ScrollerCompatImplGingerbread
    implements ScrollerCompat.ScrollerCompatImpl
  {
    public void abortAnimation(Object paramObject)
    {
      ScrollerCompatGingerbread.abortAnimation(paramObject);
    }
    
    public boolean computeScrollOffset(Object paramObject)
    {
      return ScrollerCompatGingerbread.computeScrollOffset(paramObject);
    }
    
    public Object createScroller(Context paramContext, Interpolator paramInterpolator)
    {
      return ScrollerCompatGingerbread.createScroller(paramContext, paramInterpolator);
    }
    
    public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      ScrollerCompatGingerbread.fling(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }
    
    public void fling(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
    {
      ScrollerCompatGingerbread.fling(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
    }
    
    public float getCurrVelocity(Object paramObject)
    {
      return 0.0F;
    }
    
    public int getCurrX(Object paramObject)
    {
      return ScrollerCompatGingerbread.getCurrX(paramObject);
    }
    
    public int getCurrY(Object paramObject)
    {
      return ScrollerCompatGingerbread.getCurrY(paramObject);
    }
    
    public int getFinalX(Object paramObject)
    {
      return ScrollerCompatGingerbread.getFinalX(paramObject);
    }
    
    public int getFinalY(Object paramObject)
    {
      return ScrollerCompatGingerbread.getFinalY(paramObject);
    }
    
    public boolean isFinished(Object paramObject)
    {
      return ScrollerCompatGingerbread.isFinished(paramObject);
    }
    
    public boolean isOverScrolled(Object paramObject)
    {
      return ScrollerCompatGingerbread.isOverScrolled(paramObject);
    }
    
    public void notifyHorizontalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      ScrollerCompatGingerbread.notifyHorizontalEdgeReached(paramObject, paramInt1, paramInt2, paramInt3);
    }
    
    public void notifyVerticalEdgeReached(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      ScrollerCompatGingerbread.notifyVerticalEdgeReached(paramObject, paramInt1, paramInt2, paramInt3);
    }
    
    public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ScrollerCompatGingerbread.startScroll(paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void startScroll(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      ScrollerCompatGingerbread.startScroll(paramObject, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
  }
  
  static class ScrollerCompatImplIcs
    extends ScrollerCompat.ScrollerCompatImplGingerbread
  {
    public float getCurrVelocity(Object paramObject)
    {
      return ScrollerCompatIcs.getCurrVelocity(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v4.widget.ScrollerCompat
 * JD-Core Version:    0.7.0.1
 */