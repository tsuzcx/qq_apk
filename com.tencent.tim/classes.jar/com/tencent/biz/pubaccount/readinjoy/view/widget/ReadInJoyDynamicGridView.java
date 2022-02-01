package com.tencent.biz.pubaccount.readinjoy.view.widget;

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
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import aqnm;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import nrf;
import nrg;
import nrh;
import nri;
import nrj;
import nrk;

public class ReadInJoyDynamicGridView
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
  private f jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$f;
  private g jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$g;
  private h jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$h;
  private i jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$i;
  private Rect aa;
  private Rect ab;
  private int ajt;
  private int aju;
  private int ajv = -1;
  private int ajw = -1;
  private int ajx;
  private int ajy;
  private boolean aul;
  private AdapterView.c b;
  private int bbt;
  private AbsListView.e jdField_c_of_type_ComTencentWidgetAbsListView$e = new nrk(this);
  private AdapterView.c jdField_c_of_type_ComTencentWidgetAdapterView$c = new nrf(this);
  private List<Long> eS = new ArrayList();
  private AbsListView.e g;
  private View hy;
  private long ko = -1L;
  private int mActivePointerId = -1;
  private int mDownX = -1;
  private int mDownY = -1;
  private int mScrollState = 0;
  
  public ReadInJoyDynamicGridView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ReadInJoyDynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ReadInJoyDynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private c a()
  {
    return (c)getAdapter();
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
        break label620;
      }
      Point localPoint2 = a(localView);
      if (((!d(localPoint2, localPoint1)) || (k >= localView.getBottom()) || (m <= localView.getLeft())) && ((!c(localPoint2, localPoint1)) || (k >= localView.getBottom()) || (m >= localView.getRight())) && ((!b(localPoint2, localPoint1)) || (k <= localView.getTop()) || (m <= localView.getLeft())) && ((!a(localPoint2, localPoint1)) || (k <= localView.getTop()) || (m >= localView.getRight())) && ((!e(localPoint2, localPoint1)) || (k >= localView.getBottom() - this.ajx)) && ((!f(localPoint2, localPoint1)) || (k <= localView.getTop() + this.ajx)) && ((!g(localPoint2, localPoint1)) || (m <= localView.getLeft() + this.ajx)) && ((!h(localPoint2, localPoint1)) || (m >= localView.getRight() - this.ajx))) {
        break label620;
      }
      float f4 = Math.abs(a(localView) - a(this.hy));
      f3 = Math.abs(b(localView) - b(this.hy));
      if ((f4 < f1) || (f3 < f2)) {
        break label620;
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
        if ((m == -1) || (!((c)localObject).bU(k)) || (!((c)localObject).bU(m)) || (m < this.bbt)) {
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
        localObject = new d(j, i);
      }
      for (;;)
      {
        bt(this.ko);
        ((k)localObject).bn(k, m);
        return;
        if (FX()) {
          localObject = new j(j, i);
        } else {
          localObject = new e(j, i);
        }
      }
      label620:
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
  
  public static void b(List paramList, int paramInt1, int paramInt2)
  {
    paramList.add(paramInt2, paramList.remove(paramInt1));
  }
  
  private boolean b(Point paramPoint1, Point paramPoint2)
  {
    return (paramPoint1.y > paramPoint2.y) && (paramPoint1.x > paramPoint2.x);
  }
  
  @TargetApi(11)
  private void bE(View paramView)
  {
    Object localObject = new nrg(this);
    localObject = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable, "bounds", (TypeEvaluator)localObject, new Object[] { this.aa });
    ((ObjectAnimator)localObject).addUpdateListener(new nrh(this));
    ((ObjectAnimator)localObject).addListener(new nri(this, paramView));
    ((ObjectAnimator)localObject).start();
  }
  
  private void bk(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$f != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$f.aY(paramInt1, paramInt2);
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
        break label139;
      }
      i = Math.min(paramInt1, paramInt2);
      label26:
      if (i >= Math.max(paramInt1, paramInt2)) {
        break label257;
      }
      localObject = a(v(i));
      if (localObject != null) {
        break label63;
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      i = 0;
      break;
      label63:
      if ((i + 1) % getColumnCount() == 0) {
        localLinkedList.add(a((View)localObject, -((View)localObject).getWidth() * (getColumnCount() - 1), 0.0F, ((View)localObject).getHeight(), 0.0F));
      } else {
        localLinkedList.add(a((View)localObject, ((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
      }
    }
    label139:
    int i = Math.max(paramInt1, paramInt2);
    if (i > Math.min(paramInt1, paramInt2))
    {
      localObject = a(v(i));
      if (localObject == null) {}
      for (;;)
      {
        i -= 1;
        break;
        if ((getColumnCount() + i) % getColumnCount() == 0) {
          localLinkedList.add(a((View)localObject, ((View)localObject).getWidth() * (getColumnCount() - 1), 0.0F, -((View)localObject).getHeight(), 0.0F));
        } else {
          localLinkedList.add(a((View)localObject, -((View)localObject).getWidth(), 0.0F, 0.0F, 0.0F));
        }
      }
    }
    label257:
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).playTogether(localLinkedList);
    ((AnimatorSet)localObject).setDuration(300L);
    ((AnimatorSet)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    ((AnimatorSet)localObject).addListener(new nrj(this));
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$i != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$i.a(localView, paramInt, this.ko);
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = a(localView);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$i != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$i.b(localView, paramInt, this.ko);
      }
      if (rT()) {
        localView.setVisibility(4);
      }
      this.Nv = true;
      bt(this.ko);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$f != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$f.qM(paramInt);
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
  
  public void aa(Object paramObject)
  {
    if ((getAdapter() instanceof b)) {
      ((b)getAdapter()).add(paramObject);
    }
  }
  
  public boolean ag(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.bbt) {
      return false;
    }
    Object localObject;
    if ((rT()) && (FX())) {
      localObject = new d(0, 0);
    }
    for (;;)
    {
      a().df(paramInt1);
      ((k)localObject).bn(paramInt1, paramInt2);
      return true;
      if (FX()) {
        localObject = new j(0, 0);
      } else {
        localObject = new e(0, 0);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject;
    if ((rT()) && (FX())) {
      localObject = new d(0, 0);
    }
    for (;;)
    {
      if ((getAdapter() instanceof b)) {
        ((b)getAdapter()).add(0, paramObject);
      }
      ((k)localObject).bn(paramInt1 + 1, paramInt2);
      return;
      if (FX()) {
        localObject = new j(0, 0);
      } else {
        localObject = new e(0, 0);
      }
    }
  }
  
  public void bap()
  {
    this.Ny = false;
    requestDisallowInterceptTouchEvent(false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$h != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$h.db(false);
    }
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
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 2) {
      return (this.Ny) && (super.dispatchTouchEvent(paramMotionEvent));
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void init(Context paramContext)
  {
    super.setOnScrollListener(this.jdField_c_of_type_ComTencentWidgetAbsListView$e);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.ajy = ((int)(8.0F * paramContext.density + 0.5F));
    this.ajx = ((int)(paramContext.density * 16.0F + 0.5F));
    setNumColumns(4);
    setHorizontalSpacing(aqnm.dip2px(0.0F));
    setVerticalSpacing(aqnm.dip2px(0.0F));
    setSelector(17170445);
    setClipChildren(false);
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
            if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$g != null))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$g.aKK();
              continue;
              akv();
              if ((this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$g != null))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$g.aKK();
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
  
  public void setLockCount(int paramInt)
  {
    this.bbt = paramInt;
  }
  
  public void setOnDragListener(f paramf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$f = paramf;
  }
  
  public void setOnDropListener(g paramg)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$g = paramg;
  }
  
  public void setOnEditModeChangeListener(h paramh)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$h = paramh;
  }
  
  public void setOnItemClickListener(AdapterView.c paramc)
  {
    this.b = paramc;
    super.setOnItemClickListener(this.jdField_c_of_type_ComTencentWidgetAdapterView$c);
  }
  
  public void setOnScrollListener(AbsListView.e parame)
  {
    this.g = parame;
  }
  
  public void setOnSelectedItemBitmapCreationListener(i parami)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$i = parami;
  }
  
  public void tU(int paramInt)
  {
    if (!this.NB) {}
    do
    {
      return;
      this.Ny = true;
      requestDisallowInterceptTouchEvent(true);
      if (paramInt != -1) {
        tV(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$h == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView$h.db(true);
  }
  
  public int u(long paramLong)
  {
    View localView = a(paramLong);
    if (localView == null) {
      return -1;
    }
    return getPositionForView(localView);
  }
  
  public static abstract class a<T>
    extends BaseAdapter
    implements ReadInJoyDynamicGridView.c
  {
    private int ajo;
    private HashMap<T, Integer> cq = new HashMap();
    
    protected void G(T paramT)
    {
      HashMap localHashMap = this.cq;
      int i = this.ajo;
      this.ajo = (i + 1);
      localHashMap.put(paramT, Integer.valueOf(i));
    }
    
    protected void akp()
    {
      this.cq.clear();
    }
    
    protected void by(List<T> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        G(paramList.next());
      }
    }
    
    public T getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.cq.size())) {
        return -1L;
      }
      Object localObject = getItem(paramInt);
      if (this.cq.get(localObject) != null) {
        return ((Integer)this.cq.get(localObject)).intValue();
      }
      return paramInt;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
  
  public static abstract class b<T>
    extends ReadInJoyDynamicGridView.a<T>
  {
    protected int mColumnCount;
    protected Context mContext;
    protected List<T> mItems = new ArrayList();
    
    protected b(Context paramContext, int paramInt)
    {
      this.mContext = paramContext;
      this.mColumnCount = paramInt;
    }
    
    private void init(List<T> paramList)
    {
      by(paramList);
      this.mItems.addAll(paramList);
    }
    
    public void add(int paramInt, T paramT)
    {
      G(paramT);
      this.mItems.add(paramInt, paramT);
      notifyDataSetChanged();
    }
    
    public void add(T paramT)
    {
      G(paramT);
      this.mItems.add(paramT);
      notifyDataSetChanged();
    }
    
    public boolean bU(int paramInt)
    {
      return true;
    }
    
    public void bh(int paramInt1, int paramInt2)
    {
      if (paramInt2 < getCount())
      {
        ReadInJoyDynamicGridView.b(this.mItems, paramInt1, paramInt2);
        notifyDataSetChanged();
      }
    }
    
    public void clear()
    {
      akp();
      this.mItems.clear();
      notifyDataSetChanged();
    }
    
    public void df(int paramInt)
    {
      if (paramInt < getCount())
      {
        this.mItems.remove(paramInt);
        notifyDataSetChanged();
      }
    }
    
    public int getColumnCount()
    {
      return this.mColumnCount;
    }
    
    public Context getContext()
    {
      return this.mContext;
    }
    
    public int getCount()
    {
      return this.mItems.size();
    }
    
    public T getItem(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.mItems.size())) {
        return null;
      }
      return this.mItems.get(paramInt);
    }
    
    public List<T> getItems()
    {
      return this.mItems;
    }
    
    public void set(List<T> paramList)
    {
      clear();
      init(paramList);
      notifyDataSetChanged();
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean bU(int paramInt);
    
    public abstract void bh(int paramInt1, int paramInt2);
    
    public abstract void df(int paramInt);
    
    public abstract int getColumnCount();
  }
  
  class d
    implements ReadInJoyDynamicGridView.k
  {
    private int mDeltaX;
    private int mDeltaY;
    
    public d(int paramInt1, int paramInt2)
    {
      this.mDeltaX = paramInt1;
      this.mDeltaY = paramInt2;
    }
    
    public void bn(int paramInt1, int paramInt2)
    {
      ReadInJoyDynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this), paramInt1, paramInt2));
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
        ReadInJoyDynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this) + ReadInJoyDynamicGridView.d.a(ReadInJoyDynamicGridView.d.this));
        ReadInJoyDynamicGridView.b(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.b(ReadInJoyDynamicGridView.this) + ReadInJoyDynamicGridView.d.b(ReadInJoyDynamicGridView.d.this));
        if (this.hC != null) {
          this.hC.setVisibility(0);
        }
        ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.this.a(ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this)));
        if (ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this) != null) {
          ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this).setVisibility(4);
        }
        ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, this.ajI, this.mTargetPosition);
        return true;
      }
    }
  }
  
  class e
    implements ReadInJoyDynamicGridView.k
  {
    private int mDeltaX;
    private int mDeltaY;
    
    public e(int paramInt1, int paramInt2)
    {
      this.mDeltaX = paramInt1;
      this.mDeltaY = paramInt2;
    }
    
    public void bn(int paramInt1, int paramInt2)
    {
      ReadInJoyDynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
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
        ReadInJoyDynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this) + ReadInJoyDynamicGridView.e.a(ReadInJoyDynamicGridView.e.this));
        ReadInJoyDynamicGridView.b(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.b(ReadInJoyDynamicGridView.this) + ReadInJoyDynamicGridView.e.b(ReadInJoyDynamicGridView.e.this));
        if (ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this) != null) {
          ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this).setVisibility(0);
        }
        ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.this.a(ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this)));
        if (ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this) != null) {
          ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this).setVisibility(4);
        }
        ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, this.ajI, this.mTargetPosition);
        return true;
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void aY(int paramInt1, int paramInt2);
    
    public abstract void qM(int paramInt);
  }
  
  public static abstract interface g
  {
    public abstract void aKK();
  }
  
  public static abstract interface h
  {
    public abstract void db(boolean paramBoolean);
  }
  
  public static abstract interface i
  {
    public abstract void a(View paramView, int paramInt, long paramLong);
    
    public abstract void b(View paramView, int paramInt, long paramLong);
  }
  
  class j
    implements ReadInJoyDynamicGridView.k
  {
    private int mDeltaX;
    private int mDeltaY;
    
    public j(int paramInt1, int paramInt2)
    {
      this.mDeltaX = paramInt1;
      this.mDeltaY = paramInt2;
    }
    
    public void bn(int paramInt1, int paramInt2)
    {
      ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.a(ReadInJoyDynamicGridView.this) + this.mDeltaY);
      ReadInJoyDynamicGridView.b(ReadInJoyDynamicGridView.this, ReadInJoyDynamicGridView.b(ReadInJoyDynamicGridView.this) + this.mDeltaX);
    }
  }
  
  static abstract interface k
  {
    public abstract void bn(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView
 * JD-Core Version:    0.7.0.1
 */