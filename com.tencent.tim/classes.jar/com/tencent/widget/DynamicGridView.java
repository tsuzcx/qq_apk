package com.tencent.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import autf;
import autg;
import auth;
import auti;
import autj;
import autk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DynamicGridView
  extends GridView
{
  private boolean NA;
  private boolean NB = true;
  private boolean Nv;
  private boolean Nw;
  private boolean Nx;
  private boolean Ny;
  private boolean Nz;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private AbsListView.OnScrollListener jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener;
  private d jdField_a_of_type_ComTencentWidgetDynamicGridView$d;
  private e jdField_a_of_type_ComTencentWidgetDynamicGridView$e;
  private f jdField_a_of_type_ComTencentWidgetDynamicGridView$f;
  private g jdField_a_of_type_ComTencentWidgetDynamicGridView$g;
  private Rect aa;
  private Rect ab;
  private int ajt;
  private int aju;
  private int ajv = -1;
  private int ajw = -1;
  private int ajx;
  private int ajy;
  private boolean aul;
  private AbsListView.OnScrollListener b = new autk(this);
  private AdapterView.OnItemClickListener c;
  private AdapterView.OnItemClickListener d = new autf(this);
  private List<Long> eS = new ArrayList();
  private View hy;
  private long ko = -1L;
  private int mActivePointerId = -1;
  private int mDownX = -1;
  private int mDownY = -1;
  private int mScrollState = 0;
  
  public DynamicGridView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public static boolean FX()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  public static float a(View paramView)
  {
    return Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
  }
  
  @TargetApi(11)
  private AnimatorSet a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat3, paramFloat4 });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
  
  private Bitmap a(View paramView, float paramFloat, int paramInt)
  {
    int i = (int)(paramView.getWidth() * paramFloat);
    int j = (int)(paramView.getHeight() * paramFloat);
    Bitmap localBitmap = b(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap == null) {}
    do
    {
      return null;
      paramView.draw(new Canvas(localBitmap));
      paramView = b(i + paramInt, j + paramInt, Bitmap.Config.ARGB_8888);
    } while (paramView == null);
    Canvas localCanvas = new Canvas(paramView);
    Paint localPaint = new Paint();
    localPaint.setDither(true);
    localPaint.setFilterBitmap(true);
    localCanvas.drawBitmap(localBitmap, null, new Rect(paramInt, paramInt, paramView.getWidth() - paramInt, paramView.getHeight() - paramInt), localPaint);
    return paramView;
  }
  
  private Point a(View paramView)
  {
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    return new Point(i % j, i / j);
  }
  
  private BitmapDrawable a(View paramView)
  {
    int i = ((int)(paramView.getWidth() * 1.1F) + 0) / 2;
    int j = ((int)(paramView.getHeight() * 1.1F) + 0) / 2;
    int k = (paramView.getRight() + paramView.getLeft()) / 2;
    int m = (paramView.getBottom() + paramView.getTop()) / 2;
    paramView = a(paramView, 1.1F, 0);
    paramView = new BitmapDrawable(getResources(), paramView);
    this.ab = new Rect(k - i, m - j, i + k, j + m);
    this.aa = new Rect(this.ab);
    paramView.setBounds(this.aa);
    return paramView;
  }
  
  private a a()
  {
    return (a)getAdapter();
  }
  
  private boolean a(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  private void akr()
  {
    this.Nw = c(this.aa);
  }
  
  private void aks()
  {
    View localView = a(this.ko);
    if ((localView != null) && ((this.Nv) || (this.Nx)))
    {
      this.Nv = false;
      this.Nx = false;
      this.Nw = false;
      this.mActivePointerId = -1;
      if (this.mScrollState != 0)
      {
        this.Nx = true;
        return;
      }
      this.aa.offsetTo(localView.getLeft(), localView.getTop());
      if (Build.VERSION.SDK_INT > 11)
      {
        bE(localView);
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(this.aa);
      invalidate();
      reset(localView);
      return;
    }
    akv();
  }
  
  private void aku()
  {
    if ((!this.Nz) && (!this.NA)) {}
    for (boolean bool = true;; bool = false)
    {
      setEnabled(bool);
      return;
    }
  }
  
  private void akv()
  {
    View localView = a(this.ko);
    if (this.Nv) {
      reset(localView);
    }
    this.Nv = false;
    this.Nw = false;
    this.mActivePointerId = -1;
  }
  
  private void akw()
  {
    float f2 = 0.0F;
    int i = this.ajv - this.mDownY;
    int j = this.ajw - this.mDownX;
    int k = this.ab.centerY() + this.ajt + i;
    int m = this.ab.centerX() + this.aju + j;
    this.hy = a(this.ko);
    Object localObject = null;
    Point localPoint1 = a(this.hy);
    Iterator localIterator = this.eS.iterator();
    float f1 = 0.0F;
    float f3;
    if (localIterator.hasNext())
    {
      View localView = a(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label611;
      }
      Point localPoint2 = a(localView);
      if (((!d(localPoint2, localPoint1)) || (k >= localView.getBottom()) || (m <= localView.getLeft())) && ((!c(localPoint2, localPoint1)) || (k >= localView.getBottom()) || (m >= localView.getRight())) && ((!b(localPoint2, localPoint1)) || (k <= localView.getTop()) || (m <= localView.getLeft())) && ((!a(localPoint2, localPoint1)) || (k <= localView.getTop()) || (m >= localView.getRight())) && ((!e(localPoint2, localPoint1)) || (k >= localView.getBottom() - this.ajx)) && ((!f(localPoint2, localPoint1)) || (k <= localView.getTop() + this.ajx)) && ((!g(localPoint2, localPoint1)) || (m <= localView.getLeft() + this.ajx)) && ((!h(localPoint2, localPoint1)) || (m >= localView.getRight() - this.ajx))) {
        break label611;
      }
      float f4 = Math.abs(a(localView) - a(this.hy));
      f3 = Math.abs(b(localView) - b(this.hy));
      if ((f4 < f1) || (f3 < f2)) {
        break label611;
      }
      f2 = f4;
      localObject = localView;
      f1 = f3;
    }
    for (;;)
    {
      f3 = f2;
      f2 = f1;
      f1 = f3;
      break;
      if (localObject != null)
      {
        k = getPositionForView(this.hy);
        m = getPositionForView((View)localObject);
        localObject = a();
        if ((m == -1) || (!((a)localObject).bU(k)) || (!((a)localObject).bU(m))) {
          bt(this.ko);
        }
      }
      else
      {
        return;
      }
      bk(k, m);
      this.mDownY = this.ajv;
      this.mDownX = this.ajw;
      if ((rT()) && (FX())) {
        localObject = new b(j, i);
      }
      for (;;)
      {
        bt(this.ko);
        ((i)localObject).bn(k, m);
        return;
        if (FX()) {
          localObject = new h(j, i);
        } else {
          localObject = new c(j, i);
        }
      }
      label611:
      f3 = f1;
      f1 = f2;
      f2 = f3;
    }
  }
  
  public static float b(View paramView)
  {
    return Math.abs((paramView.getBottom() - paramView.getTop()) / 2);
  }
  
  private Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      if (paramConfig == Bitmap.Config.ARGB_8888) {
        return b(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      }
    }
    return null;
  }
  
  private boolean b(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  @TargetApi(11)
  private void bE(View paramView)
  {
    Object localObject = new autg(this);
    localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, "bounds", (TypeEvaluator)localObject, new Object[] { this.aa });
    ((ObjectAnimator)localObject).addUpdateListener(new auth(this));
    ((ObjectAnimator)localObject).addListener(new auti(this, paramView));
    ((ObjectAnimator)localObject).start();
  }
  
  private void bk(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetDynamicGridView$d != null) {
      this.jdField_a_of_type_ComTencentWidgetDynamicGridView$d.aY(paramInt1, paramInt2);
    }
    a().bh(paramInt1, paramInt2);
  }
  
  @TargetApi(11)
  private void bm(int paramInt1, int paramInt2)
  {
    LinkedList localLinkedList;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localLinkedList = new LinkedList();
      if (i == 0) {
        break label131;
      }
      i = Math.min(paramInt1, paramInt2);
      label26:
      if (i >= Math.max(paramInt1, paramInt2)) {
        break label241;
      }
      localObject = a(v(i));
      if ((i + 1) % getColumnCount() != 0) {
        break label105;
      }
      localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (getColumnCount() - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
    }
    for (;;)
    {
      i += 1;
      break label26;
      i = 0;
      break;
      label105:
      localLinkedList.add(a((View)localObject, ((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
    }
    label131:
    int i = Math.max(paramInt1, paramInt2);
    if (i > Math.min(paramInt1, paramInt2))
    {
      localObject = a(v(i));
      if ((getColumnCount() + i) % getColumnCount() == 0) {
        localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (getColumnCount() - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
      }
      for (;;)
      {
        i -= 1;
        break;
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
      }
    }
    label241:
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localLinkedList);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject).addListener(new autj(this));
    ((AnimatorSet)localObject).start();
  }
  
  private void bt(long paramLong)
  {
    this.eS.clear();
    int j = u(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (a().bU(i))) {
        this.eS.add(Long.valueOf(v(i)));
      }
      i += 1;
    }
  }
  
  private boolean c(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  private boolean d(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private boolean e(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y < paramPoint2.y) && (paramPoint1.x == paramPoint2.x);
  }
  
  private boolean f(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x == paramPoint2.x);
  }
  
  private boolean g(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y == paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  private int getColumnCount()
  {
    return a().getColumnCount();
  }
  
  private boolean h(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y == paramPoint2.y) && (paramPoint1.x < paramPoint2.x);
  }
  
  private boolean rT()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private void reset(View paramView)
  {
    this.eS.clear();
    this.ko = -1L;
    paramView.setVisibility(0);
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    int i = 0;
    while (i < getLastVisiblePosition() - getFirstVisiblePosition())
    {
      paramView = getChildAt(i);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      i += 1;
    }
    invalidate();
  }
  
  private void tV(int paramInt)
  {
    this.ajt = 0;
    this.aju = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.ko = getAdapter().getItemId(paramInt);
      if (this.jdField_a_of_type_ComTencentWidgetDynamicGridView$g != null) {
        this.jdField_a_of_type_ComTencentWidgetDynamicGridView$g.a(localView, paramInt, this.ko);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a(localView);
      if (this.jdField_a_of_type_ComTencentWidgetDynamicGridView$g != null) {
        this.jdField_a_of_type_ComTencentWidgetDynamicGridView$g.b(localView, paramInt, this.ko);
      }
      if (rT()) {
        localView.setVisibility(4);
      }
      this.Nv = true;
      bt(this.ko);
      if (this.jdField_a_of_type_ComTencentWidgetDynamicGridView$d != null) {
        this.jdField_a_of_type_ComTencentWidgetDynamicGridView$d.qM(paramInt);
      }
    }
  }
  
  private long v(int paramInt)
  {
    return getAdapter().getItemId(paramInt);
  }
  
  public View a(long paramLong)
  {
    int j = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localListAdapter.getItemId(j + i) == paramLong) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean c(Rect paramRect)
  {
    int i = computeVerticalScrollOffset();
    int j = getHeight();
    int k = computeVerticalScrollExtent();
    int m = computeVerticalScrollRange();
    int n = paramRect.top;
    int i1 = paramRect.height();
    if ((n <= 0) && (i > 0))
    {
      smoothScrollBy(-this.ajy, 0);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.ajy, 0);
      return true;
    }
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public void init(Context paramContext)
  {
    super.setOnScrollListener(this.b);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.ajy = ((int)(8.0F * paramContext.density + 0.5F));
    this.ajx = ((int)(paramContext.density * 16.0F + 0.5F));
  }
  
  public boolean isEditMode()
  {
    return this.Ny;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.aul)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(16777215, -2147483648));
      getLayoutParams().height = getMeasuredHeight();
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mDownX = ((int)paramMotionEvent.getX());
      this.mDownY = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.Ny) && (isEnabled()))
      {
        layoutChildren();
        tV(pointToPosition(this.mDownX, this.mDownY));
      }
      else if (!isEnabled())
      {
        return false;
        if (this.mActivePointerId != -1)
        {
          int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          this.ajv = ((int)paramMotionEvent.getY(i));
          this.ajw = ((int)paramMotionEvent.getX(i));
          i = this.ajv;
          int j = this.mDownY;
          int k = this.ajw;
          int m = this.mDownX;
          if (this.Nv)
          {
            this.aa.offsetTo(k - m + this.ab.left + this.aju, i - j + this.ab.top + this.ajt);
            this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(this.aa);
            invalidate();
            akw();
            this.Nw = false;
            akr();
            return false;
            aks();
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_ComTencentWidgetDynamicGridView$e != null))
            {
              this.jdField_a_of_type_ComTencentWidgetDynamicGridView$e.aKK();
              continue;
              akv();
              if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_ComTencentWidgetDynamicGridView$e != null))
              {
                this.jdField_a_of_type_ComTencentWidgetDynamicGridView$e.aKK();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  aks();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.NB = paramBoolean;
  }
  
  public void setExpendable(boolean paramBoolean)
  {
    this.aul = paramBoolean;
  }
  
  public void setOnDragListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView$d = paramd;
  }
  
  public void setOnDropListener(e parame)
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView$e = parame;
  }
  
  public void setOnEditModeChangeListener(f paramf)
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView$f = paramf;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.c = paramOnItemClickListener;
    super.setOnItemClickListener(this.d);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_AndroidWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(g paramg)
  {
    this.jdField_a_of_type_ComTencentWidgetDynamicGridView$g = paramg;
  }
  
  public int u(long paramLong)
  {
    View localView = a(paramLong);
    if (localView == null) {
      return -1;
    }
    return getPositionForView(localView);
  }
  
  public static abstract interface a
  {
    public abstract boolean bU(int paramInt);
    
    public abstract void bh(int paramInt1, int paramInt2);
    
    public abstract int getColumnCount();
  }
  
  class b
    implements DynamicGridView.i
  {
    private int mDeltaX;
    private int mDeltaY;
    
    public b(int paramInt1, int paramInt2)
    {
      this.mDeltaX = paramInt1;
      this.mDeltaY = paramInt2;
    }
    
    public void bn(int paramInt1, int paramInt2)
    {
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.a(DynamicGridView.this), paramInt1, paramInt2));
    }
    
    class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int ajI;
      private final View hC;
      private final int mTargetPosition;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.hC = paramView;
        this.ajI = paramInt1;
        this.mTargetPosition = paramInt2;
      }
      
      public boolean onPreDraw()
      {
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.a(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.b(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        if (this.hC != null) {
          this.hC.setVisibility(0);
        }
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.this.a(DynamicGridView.a(DynamicGridView.this)));
        if (DynamicGridView.a(DynamicGridView.this) != null) {
          DynamicGridView.a(DynamicGridView.this).setVisibility(4);
        }
        DynamicGridView.a(DynamicGridView.this, this.ajI, this.mTargetPosition);
        return true;
      }
    }
  }
  
  class c
    implements DynamicGridView.i
  {
    private int mDeltaX;
    private int mDeltaY;
    
    public c(int paramInt1, int paramInt2)
    {
      this.mDeltaX = paramInt1;
      this.mDeltaY = paramInt2;
    }
    
    public void bn(int paramInt1, int paramInt2)
    {
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
    }
    
    class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int ajI;
      private final int mTargetPosition;
      
      a(int paramInt1, int paramInt2)
      {
        this.ajI = paramInt1;
        this.mTargetPosition = paramInt2;
      }
      
      public boolean onPreDraw()
      {
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.a(DynamicGridView.this) + DynamicGridView.c.a(DynamicGridView.c.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.b(DynamicGridView.this) + DynamicGridView.c.b(DynamicGridView.c.this));
        if (DynamicGridView.a(DynamicGridView.this) != null) {
          DynamicGridView.a(DynamicGridView.this).setVisibility(0);
        }
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.this.a(DynamicGridView.a(DynamicGridView.this)));
        if (DynamicGridView.a(DynamicGridView.this) != null) {
          DynamicGridView.a(DynamicGridView.this).setVisibility(4);
        }
        DynamicGridView.a(DynamicGridView.this, this.ajI, this.mTargetPosition);
        return true;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void aY(int paramInt1, int paramInt2);
    
    public abstract void qM(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void aKK();
  }
  
  public static abstract interface f {}
  
  public static abstract interface g
  {
    public abstract void a(View paramView, int paramInt, long paramLong);
    
    public abstract void b(View paramView, int paramInt, long paramLong);
  }
  
  class h
    implements DynamicGridView.i
  {
    private int mDeltaX;
    private int mDeltaY;
    
    public h(int paramInt1, int paramInt2)
    {
      this.mDeltaX = paramInt1;
      this.mDeltaY = paramInt2;
    }
    
    public void bn(int paramInt1, int paramInt2)
    {
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.a(DynamicGridView.this) + this.mDeltaY);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.b(DynamicGridView.this) + this.mDeltaX);
    }
  }
  
  static abstract interface i
  {
    public abstract void bn(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */