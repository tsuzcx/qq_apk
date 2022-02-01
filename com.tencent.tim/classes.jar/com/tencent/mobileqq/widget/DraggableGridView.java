package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import aqcx;
import arep;
import arfk;
import arfl;
import auqy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;

public class DraggableGridView
  extends FrameLayout
{
  private static int efD;
  private ImageView Fx;
  private Point H = new Point();
  private Point I = new Point();
  private arep jdField_a_of_type_Arep;
  private ScrollThread jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread;
  private c jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$c;
  private f jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$f;
  private g jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$g;
  private ListView b;
  private boolean cZX;
  private Handler dN = new arfl(this, Looper.getMainLooper());
  private int efE = -1;
  private int efF = -1;
  private boolean hi;
  private float iq;
  private float is;
  private boolean mCanDrag;
  private int mColumnCount = 2;
  private boolean mIsDragging;
  private int mScrollY;
  private float mTouchX;
  private float mTouchY;
  
  public DraggableGridView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public DraggableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private MeasureGridView a(int paramInt)
  {
    int i = 0;
    if (i < this.b.getChildCount())
    {
      View localView = this.b.getChildAt(i);
      if ((localView.getTag() == null) || (!(localView.getTag() instanceof Integer))) {}
      while ((((Integer)localView.getTag()).intValue() != paramInt) || (!(localView instanceof GridView)))
      {
        i += 1;
        break;
      }
      return (MeasureGridView)localView;
    }
    return null;
  }
  
  private void a(View paramView, Point paramPoint1, Point paramPoint2, e parame)
  {
    if (paramPoint2 == null) {}
    do
    {
      return;
      paramPoint1 = b(paramPoint1.y, paramPoint1.x);
      paramPoint2 = b(paramPoint2.y, paramPoint2.x);
    } while ((paramPoint1 == null) || (paramPoint2 == null));
    int i = paramPoint2.getLeft();
    int j = paramPoint1.getLeft();
    int k = ((View)paramPoint2.getParent()).getLeft();
    int m = ((View)paramPoint1.getParent()).getLeft();
    int n = paramPoint2.getTop();
    int i1 = paramPoint1.getTop();
    int i2 = ((View)paramPoint2.getParent()).getTop();
    int i3 = ((View)paramPoint1.getParent()).getTop();
    paramPoint1 = new TranslateAnimation(0, 0.0F, 0, i - j + k - m, 0, 0.0F, 0, n - i1 + i2 - i3);
    paramPoint1.setDuration(300L);
    paramPoint1.setAnimationListener(parame);
    e.a(parame);
    paramView.startAnimation(paramPoint1);
  }
  
  private Point b(Point paramPoint)
  {
    if ((paramPoint.x == 0) && (paramPoint.y == 0)) {
      return null;
    }
    if (paramPoint.x == 0) {
      return new Point(this.jdField_a_of_type_Arep.jF(paramPoint.y - 1) - 1, paramPoint.y - 1);
    }
    return new Point(paramPoint.x - 1, paramPoint.y);
  }
  
  private void b(Point paramPoint, boolean paramBoolean)
  {
    MeasureGridView localMeasureGridView = a(paramPoint.y);
    if ((localMeasureGridView == null) || (localMeasureGridView.getChildAt(paramPoint.x) == null)) {}
    e locale;
    View localView;
    Point localPoint;
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.hi);
        locale = new e(this.I, paramPoint, paramBoolean);
        if (paramPoint.y == this.I.y)
        {
          if (paramPoint.x > this.I.x)
          {
            i = this.I.x + 1;
            while (i <= paramPoint.x)
            {
              localView = localMeasureGridView.getChildAt(i);
              localPoint = new Point(i, paramPoint.y);
              a(localView, localPoint, b(localPoint), locale);
              i += 1;
            }
          }
          i = this.I.x - 1;
          while (i >= paramPoint.x)
          {
            localView = localMeasureGridView.getChildAt(i);
            localPoint = new Point(i, paramPoint.y);
            a(localView, localPoint, c(localPoint), locale);
            i -= 1;
          }
        }
        if (paramPoint.y <= this.I.y) {
          break;
        }
        localMeasureGridView = a(this.I.y);
      } while (localMeasureGridView == null);
      i = this.I.x + 1;
      while (i < this.jdField_a_of_type_Arep.jF(this.I.y))
      {
        localView = localMeasureGridView.getChildAt(i);
        localPoint = new Point(i, this.I.y);
        a(localView, localPoint, b(localPoint), locale);
        i += 1;
      }
      i = this.I.y + 1;
      while (i <= paramPoint.y)
      {
        localMeasureGridView = a(i);
        if (localMeasureGridView != null)
        {
          if (i == paramPoint.y) {}
          for (j = paramPoint.x + 1;; j = localMeasureGridView.getAdapter().getCount())
          {
            k = 0;
            while (k < j)
            {
              localView = localMeasureGridView.getChildAt(k);
              localPoint = new Point(k, i);
              a(localView, localPoint, b(localPoint), locale);
              k += 1;
            }
          }
        }
        i += 1;
      }
      localMeasureGridView = a(this.I.y);
    } while (localMeasureGridView == null);
    int i = this.I.x - 1;
    while (i >= 0)
    {
      localView = localMeasureGridView.getChildAt(i);
      localPoint = new Point(i, this.I.y);
      a(localView, localPoint, c(localPoint), locale);
      i -= 1;
    }
    i = this.I.y - 1;
    while (i >= paramPoint.y)
    {
      localMeasureGridView = a(i);
      if (localMeasureGridView != null)
      {
        if (i == paramPoint.y) {}
        for (j = paramPoint.x;; j = 0)
        {
          k = localMeasureGridView.getAdapter().getCount() - 1;
          while (k >= j)
          {
            localView = localMeasureGridView.getChildAt(k);
            localPoint = new Point(k, paramPoint.y);
            a(localView, localPoint, c(localPoint), locale);
            k -= 1;
          }
        }
      }
      i -= 1;
    }
    this.I.set(paramPoint.x, paramPoint.y);
  }
  
  private Point c(Point paramPoint)
  {
    if ((paramPoint.x == this.jdField_a_of_type_Arep.jF(paramPoint.y) - 1) && (paramPoint.y == this.jdField_a_of_type_Arep.getGroupCount() - 1)) {
      return null;
    }
    if (paramPoint.x == this.jdField_a_of_type_Arep.jF(paramPoint.y) - 1) {
      return new Point(0, paramPoint.y + 1);
    }
    return new Point(paramPoint.x + 1, paramPoint.y);
  }
  
  private void init()
  {
    this.b = new DraggableGridView.2(this, getContext());
    this.b.setDivider(null);
    this.b.setVerticalFadingEdgeEnabled(false);
    this.b.setScrollbarFadingEnabled(false);
    addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread = new ScrollThread(this);
  }
  
  private void kx(int paramInt1, int paramInt2)
  {
    Object localObject = a(this.b.pointToPosition(paramInt1, paramInt2) / 2);
    if ((localObject instanceof MeasureGridView))
    {
      localObject = (GridView)localObject;
      int i = ((GridView)localObject).getLeft();
      int j = ((GridView)localObject).getTop();
      localObject = new Point((paramInt1 - i) / (((GridView)localObject).getWidth() / this.mColumnCount) + (paramInt2 - j) / (((GridView)localObject).getHeight() / (int)Math.ceil(((GridView)localObject).getCount() / this.mColumnCount)) * this.mColumnCount, ((Integer)((GridView)localObject).getTag()).intValue());
      if (!this.I.equals(localObject)) {
        b((Point)localObject, false);
      }
    }
  }
  
  public Adapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$c;
  }
  
  public View b(int paramInt1, int paramInt2)
  {
    MeasureGridView localMeasureGridView = a(paramInt1);
    if (localMeasureGridView != null) {
      return localMeasureGridView.getChildAt(paramInt2);
    }
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 255) {
      return false;
    }
    this.mTouchX = paramMotionEvent.getX();
    this.mTouchY = paramMotionEvent.getY();
    if (i == 2)
    {
      if (this.mCanDrag)
      {
        if (!this.mIsDragging)
        {
          this.mIsDragging = true;
          this.cZX = true;
          this.is = this.mTouchX;
          this.iq = this.mTouchY;
          this.mScrollY = 0;
        }
        paramMotionEvent = (FrameLayout.LayoutParams)this.Fx.getLayoutParams();
        paramMotionEvent.leftMargin = ((int)(this.mTouchX - this.is + this.H.x));
        paramMotionEvent.topMargin = ((int)(this.mTouchY - this.iq + this.H.y));
        if (paramMotionEvent.leftMargin + this.Fx.getWidth() < 1)
        {
          paramMotionEvent.leftMargin = (1 - this.Fx.getWidth());
          if (paramMotionEvent.topMargin + this.Fx.getHeight() >= 1) {
            break label282;
          }
          paramMotionEvent.topMargin = (1 - this.Fx.getHeight());
          label195:
          this.Fx.setLayoutParams(paramMotionEvent);
          kx((int)this.mTouchX, (int)this.mTouchY);
          i = this.b.getHeight();
          if (this.mTouchY <= i - aqcx.dip2px(getContext(), 30.0F)) {
            break label308;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread.Yo(1);
        }
        for (;;)
        {
          return true;
          if (paramMotionEvent.leftMargin <= getWidth() - 1) {
            break;
          }
          paramMotionEvent.leftMargin = (getWidth() - 1);
          break;
          label282:
          if (paramMotionEvent.topMargin <= getHeight() - 1) {
            break label195;
          }
          paramMotionEvent.topMargin = (getHeight() - 1);
          break label195;
          label308:
          if (this.mTouchY < aqcx.dip2px(getContext(), 30.0F)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread.Yo(2);
          } else if (this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread != null) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread.isStop = true;
          }
        }
      }
    }
    else if ((i == 1) || (i == 3))
    {
      if ((this.Fx != null) && (this.mIsDragging))
      {
        Object localObject = b(this.I.y, this.I.x);
        if (localObject != null)
        {
          View localView = (View)((View)localObject).getParent();
          i = localView.getLeft();
          int j = ((View)localObject).getLeft();
          int k = localView.getTop();
          int m = ((View)localObject).getTop();
          int n = this.b.getScrollY();
          localObject = (FrameLayout.LayoutParams)this.Fx.getLayoutParams();
          localObject = new TranslateAnimation(0, 0.0F, 0, i + j - ((FrameLayout.LayoutParams)localObject).leftMargin, 0, 0.0F, 0, k + m - n - ((FrameLayout.LayoutParams)localObject).topMargin);
          ((TranslateAnimation)localObject).setDuration(300L);
          ((TranslateAnimation)localObject).setAnimationListener(new a(null));
          this.Fx.startAnimation((Animation)localObject);
        }
      }
      this.mCanDrag = false;
      this.cZX = false;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$ScrollThread.isStop = true;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void ehQ()
  {
    if (this.Fx != null)
    {
      removeView(this.Fx);
      this.Fx = null;
    }
  }
  
  public boolean isDragging()
  {
    return this.mIsDragging;
  }
  
  public void kw(int paramInt1, int paramInt2)
  {
    this.I.set(paramInt2, paramInt1);
    int j = this.b.getLastVisiblePosition() / 2;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$c.getItemViewType(this.b.getLastVisiblePosition()) > 0) {
      if (j <= 0) {
        break label132;
      }
    }
    Point localPoint;
    label132:
    for (i = j - 1;; i = 0)
    {
      localPoint = new Point(this.jdField_a_of_type_Arep.jF(i) - 1, i);
      View localView = b(paramInt1, paramInt2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(300L);
      localView.startAnimation(localAlphaAnimation);
      if (!localPoint.equals(this.I)) {
        break;
      }
      localAlphaAnimation.setAnimationListener(new arfk(this, paramInt1, paramInt2));
      return;
    }
    b(localPoint, true);
  }
  
  @SuppressLint({"RtlHardcoded"})
  public void p(View paramView1, View paramView2)
  {
    int i = paramView1.getLeft() + paramView2.getLeft();
    int j = paramView1.getTop() + paramView2.getTop() - this.b.getScrollY();
    paramView1 = auqy.e(paramView2);
    if (paramView1 != null)
    {
      int k = aqcx.dip2px(getContext(), 15.0F);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramView1.getWidth() + k, paramView1.getHeight() + k);
      localLayoutParams.topMargin = (j - k / 2);
      localLayoutParams.leftMargin = (i - k / 2);
      localLayoutParams.gravity = 51;
      if (this.Fx == null)
      {
        this.Fx = new ImageView(paramView2.getContext());
        addView(this.Fx, localLayoutParams);
      }
      this.H.set(i - k / 2, j - k / 2);
      this.Fx.setLayoutParams(localLayoutParams);
      this.Fx.setImageBitmap(paramView1);
      this.Fx.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void setAdapter(arep paramarep)
  {
    this.jdField_a_of_type_Arep = paramarep;
    this.jdField_a_of_type_Arep.b = this;
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$c = new c();
    this.b.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$c);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.mCanDrag = paramBoolean;
  }
  
  public void setOnGridItemClickListener(f paramf)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$f = paramf;
  }
  
  public void setOnGridItemLongClickListener(g paramg)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView$g = paramg;
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.b.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  static class ScrollThread
    implements Runnable
  {
    private DraggableGridView d;
    boolean isStop = true;
    private int mDirection;
    
    public ScrollThread(DraggableGridView paramDraggableGridView)
    {
      this.d = paramDraggableGridView;
    }
    
    public void Yo(int paramInt)
    {
      if (paramInt != this.mDirection) {
        DraggableGridView.c(this.d, 0);
      }
      this.mDirection = paramInt;
      if (this.isStop)
      {
        this.isStop = false;
        ThreadManager.post(this, 8, null, true);
      }
    }
    
    public void run()
    {
      if (!this.isStop)
      {
        int i = 0;
        if (this.mDirection == 1) {
          i = aqcx.dip2px(this.d.getContext(), 10.0F);
        }
        for (;;)
        {
          for (;;)
          {
            Message localMessage = new Message();
            localMessage.arg1 = i;
            DraggableGridView.a(this.d).sendMessage(localMessage);
            try
            {
              Thread.sleep(16L);
            }
            catch (InterruptedException localInterruptedException) {}
          }
          break;
          if (this.mDirection == 2) {
            i = -aqcx.dip2px(this.d.getContext(), 10.0F);
          }
        }
      }
    }
  }
  
  class a
    implements Animation.AnimationListener
  {
    private a() {}
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      int i = 0;
      while (i < DraggableGridView.a(DraggableGridView.this).getChildCount())
      {
        paramAnimation = DraggableGridView.a(DraggableGridView.this).getChildAt(i);
        if ((paramAnimation instanceof GridView))
        {
          paramAnimation = (GridView)paramAnimation;
          int j = 0;
          while (j < paramAnimation.getChildCount())
          {
            paramAnimation.getChildAt(j).clearAnimation();
            paramAnimation.getChildAt(j).setPressed(false);
            paramAnimation.getChildAt(j).setVisibility(0);
            j += 1;
          }
        }
        i += 1;
      }
      DraggableGridView.this.ehQ();
      DraggableGridView.b(DraggableGridView.this, false);
      DraggableGridView.c(DraggableGridView.this, false);
      DraggableGridView.a(DraggableGridView.this).notifyDataSetChanged();
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  class b
    implements View.OnClickListener, View.OnLongClickListener
  {
    private int mGroupIndex;
    private int mPosition;
    
    public b(int paramInt1, int paramInt2)
    {
      this.mGroupIndex = paramInt1;
      this.mPosition = paramInt2;
    }
    
    public void onClick(View paramView)
    {
      if (DraggableGridView.a(DraggableGridView.this) != null) {
        DraggableGridView.a(DraggableGridView.this).E(paramView, this.mGroupIndex, this.mPosition);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public boolean onLongClick(View paramView)
    {
      if (DraggableGridView.a(DraggableGridView.this) != null) {
        DraggableGridView.a(DraggableGridView.this).jN(this.mGroupIndex, this.mPosition);
      }
      if ((DraggableGridView.c(DraggableGridView.this)) && (!DraggableGridView.a(DraggableGridView.this)))
      {
        DraggableGridView.this.p((View)paramView.getParent(), paramView);
        paramView.setVisibility(4);
        paramView.setPressed(false);
        DraggableGridView.a(DraggableGridView.this, this.mGroupIndex);
        DraggableGridView.b(DraggableGridView.this, this.mPosition);
        DraggableGridView.a(DraggableGridView.this).x = DraggableGridView.b(DraggableGridView.this);
        DraggableGridView.a(DraggableGridView.this).y = DraggableGridView.c(DraggableGridView.this);
        DraggableGridView.a(DraggableGridView.this, true);
      }
      return true;
    }
  }
  
  public class c
    extends BaseAdapter
  {
    c() {}
    
    public int getCount()
    {
      if (DraggableGridView.a(DraggableGridView.this) != null) {
        return DraggableGridView.a(DraggableGridView.this).getGroupCount() * 2;
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if ((DraggableGridView.a(DraggableGridView.this) != null) && (paramInt % 2 == 0)) {
        return DraggableGridView.a(DraggableGridView.this).p(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (paramInt % 2 == 0) {
        return DraggableGridView.a(DraggableGridView.this).ku(paramInt / 2) + 1;
      }
      return DraggableGridView.efD;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (getItemViewType(paramInt) == DraggableGridView.efD)
      {
        if (paramView == null)
        {
          localObject = (MeasureGridView)LayoutInflater.from(DraggableGridView.this.getContext()).inflate(2131560766, paramViewGroup, false);
          ((MeasureGridView)localObject).setClickable(false);
          ((MeasureGridView)localObject).setNumColumns(DraggableGridView.a(DraggableGridView.this));
          ((MeasureGridView)localObject).setAdapter(new DraggableGridView.d(DraggableGridView.this, paramInt / 2));
          paramView = (View)localObject;
        }
        for (;;)
        {
          ((MeasureGridView)localObject).setTag(Integer.valueOf(paramInt / 2));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          localObject = (MeasureGridView)paramView;
          ((DraggableGridView.d)((MeasureGridView)localObject).getAdapter()).refresh(paramInt / 2);
        }
      }
      if (paramView == null) {
        paramView = DraggableGridView.a(DraggableGridView.this).c(LayoutInflater.from(DraggableGridView.this.getContext()), paramInt / 2, paramViewGroup);
      }
      for (Object localObject = paramView;; localObject = paramView)
      {
        if (DraggableGridView.a(DraggableGridView.this) != null) {
          DraggableGridView.a(DraggableGridView.this).at(paramView, paramInt / 2);
        }
        paramView = (View)localObject;
        break;
      }
    }
    
    public int getViewTypeCount()
    {
      return DraggableGridView.a(DraggableGridView.this).ME() + 1;
    }
  }
  
  class d
    extends BaseAdapter
  {
    private int mGroupIndex;
    
    public d(int paramInt)
    {
      this.mGroupIndex = paramInt;
    }
    
    public int getCount()
    {
      return DraggableGridView.a(DraggableGridView.this).jF(this.mGroupIndex);
    }
    
    public Object getItem(int paramInt)
    {
      return DraggableGridView.a(DraggableGridView.this).c(this.mGroupIndex, paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = DraggableGridView.a(DraggableGridView.this).a(LayoutInflater.from(DraggableGridView.this.getContext()), this.mGroupIndex, paramInt, paramViewGroup);
      }
      for (;;)
      {
        DraggableGridView.a(DraggableGridView.this).C(paramView, this.mGroupIndex, paramInt);
        DraggableGridView.b localb = new DraggableGridView.b(DraggableGridView.this, this.mGroupIndex, paramInt);
        paramView.setOnClickListener(localb);
        paramView.setOnLongClickListener(localb);
        if ((!DraggableGridView.a(DraggableGridView.this)) && ((DraggableGridView.a(DraggableGridView.this).y != this.mGroupIndex) || (DraggableGridView.a(DraggableGridView.this).x != paramInt) || (!DraggableGridView.b(DraggableGridView.this)))) {
          paramView.setVisibility(0);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
    
    public void refresh(int paramInt)
    {
      this.mGroupIndex = paramInt;
      notifyDataSetChanged();
    }
  }
  
  class e
    implements Animation.AnimationListener
  {
    private Point J;
    private Point K;
    private boolean cZY;
    private int efH;
    
    public e(Point paramPoint1, Point paramPoint2, boolean paramBoolean)
    {
      this.J = new Point(paramPoint1);
      this.K = new Point(paramPoint2);
      this.cZY = paramBoolean;
      this.efH = 0;
      DraggableGridView.b(DraggableGridView.this, true);
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      int i = this.efH - 1;
      this.efH = i;
      if (i <= 0)
      {
        i = 0;
        while (i < DraggableGridView.a(DraggableGridView.this).getChildCount())
        {
          paramAnimation = DraggableGridView.a(DraggableGridView.this).getChildAt(i);
          if ((paramAnimation instanceof MeasureGridView))
          {
            paramAnimation = (GridView)paramAnimation;
            int j = 0;
            if (j < paramAnimation.getChildCount())
            {
              paramAnimation.getChildAt(j).clearAnimation();
              if ((((Integer)paramAnimation.getTag()).intValue() == DraggableGridView.a(DraggableGridView.this).y) && (j == DraggableGridView.a(DraggableGridView.this).x) && (!this.cZY)) {
                paramAnimation.getChildAt(j).setVisibility(4);
              }
              for (;;)
              {
                j += 1;
                break;
                paramAnimation.getChildAt(j).setVisibility(0);
              }
            }
          }
          i += 1;
        }
        if (!this.cZY) {
          break label216;
        }
        DraggableGridView.a(DraggableGridView.this).jO(this.J.y, this.J.x);
        DraggableGridView.a(DraggableGridView.this).set(-1, -1);
      }
      for (;;)
      {
        DraggableGridView.a(DraggableGridView.this).notifyDataSetChanged();
        DraggableGridView.b(DraggableGridView.this, false);
        return;
        label216:
        DraggableGridView.a(DraggableGridView.this).U(this.J.y, this.J.x, this.K.y, this.K.x);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public static abstract interface f
  {
    public abstract void E(View paramView, int paramInt1, int paramInt2);
  }
  
  public static abstract interface g
  {
    public abstract void jN(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView
 * JD-Core Version:    0.7.0.1
 */