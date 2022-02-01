package com.tencent.biz.qqstory.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class OverScrollRecyclerView
  extends RecyclerView
{
  protected final i a = new i(this);
  
  public OverScrollRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OverScrollRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.a.init();
  }
  
  public void bwo()
  {
    this.a.detach();
  }
  
  public void bwp()
  {
    this.a.attach();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.detach();
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    super.setLayoutManager(paramLayoutManager);
    this.a.a(paramLayoutManager);
  }
  
  public void setTouchDragRatio(float paramFloat1, float paramFloat2)
  {
    if (this.a.a != null)
    {
      this.a.a.mTouchDragRatioFwd = paramFloat1;
      this.a.a.mTouchDragRatioBck = paramFloat2;
    }
  }
  
  public static class a
  {
    public float mAbsOffset;
    public float mMaxOffset;
    public Property<View, Float> mProperty;
  }
  
  public static class b
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, OverScrollRecyclerView.c
  {
    protected final OverScrollRecyclerView.a a;
    protected final OverScrollRecyclerView.i b;
    protected final Interpolator mBounceBackInterpolator = new DecelerateInterpolator();
    protected final float mDecelerateFactor;
    protected final float mDoubleDecelerateFactor;
    
    public b(OverScrollRecyclerView.i parami, float paramFloat)
    {
      this.b = parami;
      this.mDecelerateFactor = paramFloat;
      this.mDoubleDecelerateFactor = (2.0F * paramFloat);
      this.a = new OverScrollRecyclerView.a();
    }
    
    public void a(OverScrollRecyclerView.c paramc)
    {
      paramc = createAnimator();
      paramc.addListener(this);
      paramc.start();
    }
    
    protected Animator createAnimator()
    {
      float f1 = 0.0F;
      Object localObject1 = this.b.getView();
      Object localObject2 = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$d;
      Object localObject3 = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$h;
      float f3 = this.b.mVelocity;
      ((OverScrollRecyclerView.d)localObject2).a((View)localObject1, this.a);
      if ((f3 == 0.0F) || ((f3 < 0.0F) && (((OverScrollRecyclerView.h)localObject3).mDir)) || ((f3 > 0.0F) && (!((OverScrollRecyclerView.h)localObject3).mDir))) {
        return createBounceBackAnimator(this.a.mAbsOffset);
      }
      float f2 = -f3 / this.mDecelerateFactor;
      if (f2 < 0.0F) {}
      for (;;)
      {
        f2 = -f3 * f3 / this.mDoubleDecelerateFactor + this.a.mAbsOffset;
        localObject1 = createSlowdownAnimator((View)localObject1, (int)f1, f2);
        localObject2 = createBounceBackAnimator(f2);
        localObject3 = new AnimatorSet();
        ((AnimatorSet)localObject3).playSequentially(new Animator[] { localObject1, localObject2 });
        return localObject3;
        f1 = f2;
      }
    }
    
    protected ObjectAnimator createBounceBackAnimator(float paramFloat)
    {
      Object localObject = this.b.getView();
      OverScrollRecyclerView.h localh = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$h;
      paramFloat = Math.abs(paramFloat) / this.a.mMaxOffset;
      localObject = ObjectAnimator.ofFloat(localObject, this.a.mProperty, new float[] { localh.mAbsOffset });
      ((ObjectAnimator)localObject).setDuration(Math.max((int)(paramFloat * 800.0F), 200));
      ((ObjectAnimator)localObject).setInterpolator(this.mBounceBackInterpolator);
      ((ObjectAnimator)localObject).addUpdateListener(this);
      return localObject;
    }
    
    protected ObjectAnimator createSlowdownAnimator(View paramView, int paramInt, float paramFloat)
    {
      paramView = ObjectAnimator.ofFloat(paramView, this.a.mProperty, new float[] { paramFloat });
      paramView.setDuration(paramInt);
      paramView.setInterpolator(this.mBounceBackInterpolator);
      paramView.addUpdateListener(this);
      return paramView;
    }
    
    public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.b.b(this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$e);
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator) {}
  }
  
  public static abstract interface c
  {
    public abstract void a(c paramc);
    
    public abstract boolean handleMoveTouchEvent(MotionEvent paramMotionEvent);
    
    public abstract boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface d
  {
    public abstract boolean H(View paramView);
    
    public abstract boolean I(View paramView);
    
    public abstract void a(View paramView, OverScrollRecyclerView.a parama);
    
    public abstract boolean a(View paramView, OverScrollRecyclerView.g paramg, MotionEvent paramMotionEvent);
    
    public abstract void setOrientation(int paramInt);
    
    public abstract void translateView(View paramView, float paramFloat);
    
    public abstract void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent);
  }
  
  public static class e
    implements OverScrollRecyclerView.c
  {
    protected final OverScrollRecyclerView.g a = new OverScrollRecyclerView.g();
    protected final OverScrollRecyclerView.i b;
    
    public e(OverScrollRecyclerView.i parami)
    {
      this.b = parami;
    }
    
    public void a(OverScrollRecyclerView.c paramc) {}
    
    public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
    {
      View localView = this.b.getView();
      OverScrollRecyclerView.d locald = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$d;
      if (!locald.a(localView, this.a, paramMotionEvent)) {}
      OverScrollRecyclerView.h localh;
      do
      {
        return false;
        localh = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$h;
      } while (((!locald.H(localView)) || (!this.a.mDir)) && ((!locald.I(localView)) || (this.a.mDir)));
      localh.mPointerId = paramMotionEvent.getPointerId(0);
      localh.mAbsOffset = this.a.mAbsOffset;
      localh.mDir = this.a.mDir;
      this.b.b(this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$j);
      return this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$j.handleMoveTouchEvent(paramMotionEvent);
    }
    
    public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  public static class f
    implements OverScrollRecyclerView.d
  {
    protected int mOrientation = 1;
    
    public boolean H(View paramView)
    {
      if (this.mOrientation == 1) {
        if (paramView.canScrollVertically(-1)) {}
      }
      while (!paramView.canScrollHorizontally(-1))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public boolean I(View paramView)
    {
      if (this.mOrientation == 1) {
        if (paramView.canScrollVertically(1)) {}
      }
      while (!paramView.canScrollHorizontally(1))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public void a(View paramView, OverScrollRecyclerView.a parama)
    {
      if (this.mOrientation == 1)
      {
        parama.mProperty = View.TRANSLATION_Y;
        parama.mAbsOffset = paramView.getTranslationY();
        parama.mMaxOffset = paramView.getHeight();
        return;
      }
      parama.mProperty = View.TRANSLATION_X;
      parama.mAbsOffset = paramView.getTranslationX();
      parama.mMaxOffset = paramView.getWidth();
    }
    
    public boolean a(View paramView, OverScrollRecyclerView.g paramg, MotionEvent paramMotionEvent)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      if (paramMotionEvent.getHistorySize() == 0) {}
      float f1;
      float f2;
      do
      {
        return false;
        f1 = paramMotionEvent.getY(0) - paramMotionEvent.getHistoricalY(0, 0);
        f2 = paramMotionEvent.getX(0) - paramMotionEvent.getHistoricalX(0, 0);
        if (this.mOrientation != 1) {
          break;
        }
      } while (Math.abs(f1) < Math.abs(f2));
      paramg.mAbsOffset = paramView.getTranslationY();
      paramg.mDeltaOffset = f1;
      if (paramg.mDeltaOffset > 0.0F) {
        bool1 = true;
      }
      for (paramg.mDir = bool1;; paramg.mDir = bool1)
      {
        return true;
        if (Math.abs(f2) < Math.abs(f1)) {
          break;
        }
        paramg.mAbsOffset = paramView.getTranslationX();
        paramg.mDeltaOffset = f2;
        bool1 = bool2;
        if (paramg.mDeltaOffset > 0.0F) {
          bool1 = true;
        }
      }
    }
    
    public void setOrientation(int paramInt)
    {
      this.mOrientation = paramInt;
    }
    
    public void translateView(View paramView, float paramFloat)
    {
      if (this.mOrientation == 1)
      {
        paramView.setTranslationY(paramFloat);
        return;
      }
      paramView.setTranslationX(paramFloat);
    }
    
    public void translateViewAndEvent(View paramView, float paramFloat, MotionEvent paramMotionEvent)
    {
      if (this.mOrientation == 1)
      {
        paramView.setTranslationY(paramFloat);
        paramMotionEvent.offsetLocation(0.0F, paramFloat - paramMotionEvent.getY(0));
        return;
      }
      paramView.setTranslationX(paramFloat);
      paramMotionEvent.offsetLocation(paramFloat - paramMotionEvent.getX(0), 0.0F);
    }
  }
  
  public static class g
  {
    public float mAbsOffset;
    public float mDeltaOffset;
    public boolean mDir;
  }
  
  public static class h
  {
    protected float mAbsOffset;
    protected boolean mDir;
    protected int mPointerId;
  }
  
  public static class i
    implements View.OnTouchListener
  {
    protected OverScrollRecyclerView.b a;
    protected OverScrollRecyclerView.c a;
    protected OverScrollRecyclerView.d a;
    protected OverScrollRecyclerView.e a;
    protected final OverScrollRecyclerView.h a;
    protected OverScrollRecyclerView.j a;
    protected final RecyclerView mRecyclerView;
    protected float mVelocity;
    
    public i(RecyclerView paramRecyclerView)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$d = new OverScrollRecyclerView.f();
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$h = new OverScrollRecyclerView.h();
      this.mRecyclerView = paramRecyclerView;
    }
    
    public void a(RecyclerView.LayoutManager paramLayoutManager)
    {
      if ((paramLayoutManager instanceof LinearLayoutManager))
      {
        paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$d.setOrientation(paramLayoutManager.getOrientation());
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$d.setOrientation(1);
    }
    
    public void attach()
    {
      this.mRecyclerView.setOnTouchListener(this);
      this.mRecyclerView.setOverScrollMode(2);
    }
    
    protected void b(OverScrollRecyclerView.c paramc)
    {
      OverScrollRecyclerView.c localc = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$c;
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$c = paramc;
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$c.a(localc);
    }
    
    public void detach()
    {
      this.mRecyclerView.setOnTouchListener(null);
      this.mRecyclerView.setOverScrollMode(0);
    }
    
    public View getView()
    {
      return this.mRecyclerView;
    }
    
    public void init()
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$b = new OverScrollRecyclerView.b(this, -2.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$j = new OverScrollRecyclerView.j(this, 3.0F, 1.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$e = new OverScrollRecyclerView.e(this);
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$c = this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$e;
      attach();
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      case 2: 
        return this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$c.handleMoveTouchEvent(paramMotionEvent);
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$c.handleUpOrCancelTouchEvent(paramMotionEvent);
    }
  }
  
  public static class j
    implements OverScrollRecyclerView.c
  {
    protected final OverScrollRecyclerView.g a;
    protected final OverScrollRecyclerView.i b;
    protected int mCurrDragState;
    protected float mTouchDragRatioBck;
    protected float mTouchDragRatioFwd;
    
    public j(OverScrollRecyclerView.i parami, float paramFloat1, float paramFloat2)
    {
      this.b = parami;
      this.a = new OverScrollRecyclerView.g();
      this.mTouchDragRatioFwd = paramFloat1;
      this.mTouchDragRatioBck = paramFloat2;
    }
    
    public void a(OverScrollRecyclerView.c paramc)
    {
      if (this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$h.mDir) {}
      for (int i = 1;; i = 2)
      {
        this.mCurrDragState = i;
        return;
      }
    }
    
    public boolean handleMoveTouchEvent(MotionEvent paramMotionEvent)
    {
      OverScrollRecyclerView.h localh = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$h;
      if (localh.mPointerId != paramMotionEvent.getPointerId(0)) {
        this.b.b(this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$b);
      }
      View localView;
      OverScrollRecyclerView.d locald;
      do
      {
        return true;
        localView = this.b.getView();
        locald = this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$d;
      } while (!locald.a(localView, this.a, paramMotionEvent));
      float f2 = this.a.mDeltaOffset;
      if (this.a.mDir == localh.mDir) {}
      for (float f1 = this.mTouchDragRatioFwd;; f1 = this.mTouchDragRatioBck)
      {
        f1 = f2 / f1;
        f2 = this.a.mAbsOffset + f1;
        if (((!localh.mDir) || (this.a.mDir) || (f2 > localh.mAbsOffset)) && ((localh.mDir) || (!this.a.mDir) || (f2 < localh.mAbsOffset))) {
          break;
        }
        locald.translateViewAndEvent(localView, localh.mAbsOffset, paramMotionEvent);
        this.b.b(this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$e);
        return true;
      }
      if (localView.getParent() != null) {
        localView.getParent().requestDisallowInterceptTouchEvent(true);
      }
      long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
      if (l > 0L) {
        this.b.mVelocity = (f1 / (float)l);
      }
      locald.translateView(localView, f2);
      return true;
    }
    
    public boolean handleUpOrCancelTouchEvent(MotionEvent paramMotionEvent)
    {
      this.b.b(this.b.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView$b);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.OverScrollRecyclerView
 * JD-Core Version:    0.7.0.1
 */