package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.SectionIndexer;
import com.tencent.util.VersionUtils;
import iau;

public class FastScroller
{
  private static final int A = 180;
  private static final String jdField_a_of_type_JavaLangString = "FastScroller";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private static final int[] jdField_b_of_type_ArrayOfInt = new int[0];
  private static final int[] jdField_c_of_type_ArrayOfInt = { 16843609, 16843574, 16843577, 16843575, 16843576, 16843578 };
  private static int jdField_d_of_type_Int = 4;
  private static final int jdField_e_of_type_Int = 0;
  private static final int jdField_f_of_type_Int = 1;
  private static final int jdField_g_of_type_Int = 2;
  private static final int h = 3;
  private static final int i = 4;
  private static final int j = 0;
  private static final int k = 1;
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static final int p = 0;
  private static final int q = 1;
  private static final int z = 1500;
  public float a;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private SectionIndexer jdField_a_of_type_AndroidWidgetSectionIndexer;
  public AbsListView a;
  private FastScroller.ScrollFade jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new iau(this);
  boolean jdField_a_of_type_Boolean;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  public int c;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_c_of_type_Boolean;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  private boolean jdField_g_of_type_Boolean;
  private int r;
  private int s;
  private int t;
  private int u = -1;
  private int v;
  private int w;
  private int x;
  private int y;
  
  public FastScroller(Context paramContext, AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    a(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_AndroidWidgetSectionIndexer == null) || (this.jdField_a_of_type_AndroidWidgetBaseAdapter == null)) {
      b();
    }
    if ((this.jdField_a_of_type_AndroidWidgetSectionIndexer == null) || (!this.g)) {
      paramInt1 = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_a_of_type_Int) * paramInt1 / (paramInt3 - paramInt2);
    }
    int i2;
    do
    {
      return paramInt1;
      i2 = paramInt1 - this.t;
      paramInt1 = i1;
    } while (i2 < 0);
    int i3 = this.t;
    int i4 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_a_of_type_Int;
    paramInt1 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSectionForPosition(i2);
    i1 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(paramInt1);
    int i5 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(paramInt1 + 1);
    int i6 = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    View localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
    if (localView == null) {}
    for (float f1 = 0.0F;; f1 = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingTop() - localView.getTop()) / localView.getHeight() + f1)
    {
      i1 = (int)(((f1 - i1) / (i5 - i1) + paramInt1) / i6 * i4);
      paramInt1 = i1;
      if (i2 <= 0) {
        break;
      }
      paramInt1 = i1;
      if (i2 + paramInt2 != paramInt3 - i3) {
        break;
      }
      localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(paramInt2 - 1);
      f1 = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingBottom() - localView.getTop()) / localView.getHeight();
      float f2 = i1;
      return (int)((i4 - i1) * f1 + f2);
      f1 = i2;
    }
  }
  
  @TargetApi(11)
  private void a(Context paramContext)
  {
    boolean bool = true;
    int i1 = 0;
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(jdField_c_of_type_ArrayOfInt);
    a(paramContext, localTypedArray.getDrawable(1));
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localTypedArray.getDrawable(2);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = localTypedArray.getDrawable(3);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = localTypedArray.getDrawable(4);
    this.x = localTypedArray.getInt(5, 0);
    this.jdField_a_of_type_Boolean = true;
    b();
    this.r = paramContext.getResources().getDimensionPixelSize(2131427367);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade = new FastScroller.ScrollFade(this);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.r / 2);
    int i2 = localTypedArray.getColorStateList(0).getDefaultColor();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth() > 0) && (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() > 0)) {
      a(this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight(), 0, 0);
    }
    this.v = 0;
    g();
    localTypedArray.recycle();
    this.y = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    if (paramContext.getApplicationInfo().targetSdkVersion >= 11) {}
    for (;;)
    {
      this.g = bool;
      if (VersionUtils.e()) {
        i1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getVerticalScrollbarPosition();
      }
      a(i1);
      return;
      bool = false;
    }
  }
  
  private void a(Context paramContext, Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((paramDrawable instanceof NinePatchDrawable)) {
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131427368);
    }
    for (this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131427369);; this.jdField_a_of_type_Int = paramDrawable.getIntrinsicHeight())
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      this.jdField_b_of_type_Int = paramDrawable.getIntrinsicWidth();
    }
  }
  
  private void g()
  {
    if (this.v == 3) {}
    for (int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;; arrayOfInt = jdField_b_of_type_ArrayOfInt)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      return;
    }
  }
  
  private void h()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth();
    switch (this.w)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(208);
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1 - this.jdField_b_of_type_Int, 0, i1, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  private void i()
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  SectionIndexer a()
  {
    return this.jdField_a_of_type_AndroidWidgetSectionIndexer;
  }
  
  void a()
  {
    b(0);
  }
  
  public void a(float paramFloat)
  {
    int i8 = this.jdField_a_of_type_ComTencentWidgetAbsListView.a();
    this.jdField_a_of_type_Boolean = false;
    float f1 = 1.0F / i8 / 8.0F;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i9;
    int i2;
    int i1;
    int i3;
    int i6;
    if ((arrayOfObject != null) && (arrayOfObject.length > 1))
    {
      i9 = arrayOfObject.length;
      i2 = (int)(i9 * paramFloat);
      i1 = i2;
      if (i2 >= i9) {
        i1 = i9 - 1;
      }
      i3 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i1);
      i6 = i1 + 1;
      if (i1 >= i9 - 1) {
        break label622;
      }
    }
    label587:
    label590:
    label593:
    label622:
    for (int i5 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i1 + 1);; i5 = i8)
    {
      int i4;
      if (i5 == i3)
      {
        i2 = i3;
        i4 = i1;
        if (i4 > 0)
        {
          i4 -= 1;
          i2 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i4);
          if (i2 != i3)
          {
            i3 = i2;
            i2 = i4;
          }
        }
      }
      for (;;)
      {
        int i7 = i6 + 1;
        for (;;)
        {
          if ((i7 < i9) && (this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i7) == i5))
          {
            i7 += 1;
            i6 += 1;
            continue;
            if (i4 != 0) {
              break label593;
            }
            i7 = 0;
            i4 = i1;
            i3 = i2;
            i2 = i7;
            break;
          }
        }
        float f2 = i4 / i9;
        float f3 = i6 / i9;
        if ((i4 == i1) && (paramFloat - f2 < f1))
        {
          i1 = i3;
          if (i1 <= i8 - 1) {
            break label590;
          }
          i1 = i8 - 1;
        }
        for (;;)
        {
          Object localObject;
          if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ExpandableListView))
          {
            localObject = (ExpandableListView)this.jdField_a_of_type_ComTencentWidgetAbsListView;
            ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).a(ExpandableListView.c(i1 + this.t)), 0);
          }
          boolean bool;
          for (;;)
          {
            if (i2 >= 0)
            {
              localObject = arrayOfObject[i2].toString();
              this.jdField_b_of_type_JavaLangString = ((String)localObject);
              if (((((String)localObject).length() != 1) || (((String)localObject).charAt(0) != ' ')) && (i2 < arrayOfObject.length))
              {
                bool = true;
                label379:
                this.jdField_d_of_type_Boolean = bool;
                return;
                i1 = (int)((i5 - i3) * (paramFloat - f2) / (f3 - f2)) + i3;
                break;
                if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ListView))
                {
                  ((ListView)this.jdField_a_of_type_ComTencentWidgetAbsListView).setSelectionFromTop(i1 + this.t, 0);
                  continue;
                }
                this.jdField_a_of_type_ComTencentWidgetAbsListView.setSelection(i1 + this.t);
                continue;
                i1 = (int)(i8 * paramFloat);
                if (i1 <= i8 - 1) {
                  break label587;
                }
                i1 = i8 - 1;
              }
            }
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ExpandableListView))
            {
              localObject = (ExpandableListView)this.jdField_a_of_type_ComTencentWidgetAbsListView;
              ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).a(ExpandableListView.c(i1 + this.t)), 0);
            }
            for (;;)
            {
              i2 = -1;
              break;
              if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ListView)) {
                ((ListView)this.jdField_a_of_type_ComTencentWidgetAbsListView).setSelectionFromTop(i1 + this.t, 0);
              } else {
                this.jdField_a_of_type_ComTencentWidgetAbsListView.setSelection(i1 + this.t);
              }
            }
            bool = false;
            break label379;
            this.jdField_d_of_type_Boolean = false;
            return;
          }
        }
        break;
        i3 = i2;
        i2 = i1;
        i4 = i1;
        continue;
        i4 = i1;
        i2 = i1;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.w = paramInt;
    switch (paramInt)
    {
    default: 
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f) {
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      switch (this.w)
      {
      default: 
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramInt1 - this.jdField_b_of_type_Int, 0, paramInt1, this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      if (this.x == 0)
      {
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        localRectF.left = ((paramInt1 - this.r) / 2);
        localRectF.right = (localRectF.left + this.r);
        localRectF.top = (paramInt2 / 10);
        localRectF.bottom = (localRectF.top + this.r);
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
        }
      }
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.v == 0) {}
    int i3;
    int i4;
    int i1;
    do
    {
      return;
      i3 = this.jdField_c_of_type_Int;
      i4 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth();
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade;
      i1 = -1;
      int i2;
      if (this.v == 4)
      {
        i2 = ((FastScroller.ScrollFade)localObject1).a();
        if (i2 < 104) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(i2 * 2);
        }
      }
      switch (this.w)
      {
      default: 
        i1 = 0;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i1, 0, this.jdField_b_of_type_Int + i1, this.jdField_a_of_type_Int);
        this.jdField_e_of_type_Boolean = true;
        i1 = i2;
        if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
          int i6 = ((Rect)localObject1).left;
          i2 = (((Rect)localObject1).bottom - ((Rect)localObject1).top) / 2;
          int i5 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          i6 = i6 + this.jdField_b_of_type_Int / 2 - i5 / 2;
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(i6, i2, i5 + i6, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - i2);
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        paramCanvas.translate(0.0F, i3);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.translate(0.0F, -i3);
        if ((this.v != 3) || (!this.jdField_d_of_type_Boolean)) {
          continue;
        }
        if (this.x == 1) {
          switch (this.w)
          {
          }
        }
        break;
      }
      for (i1 = Math.max(0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().left - this.jdField_b_of_type_Int - this.r);; i1 = Math.min(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().right + this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth() - this.r))
      {
        i2 = Math.max(0, Math.min((this.jdField_a_of_type_Int - this.r) / 2 + i3, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.r));
        localObject1 = this.jdField_a_of_type_AndroidGraphicsRectF;
        ((RectF)localObject1).left = i1;
        ((RectF)localObject1).right = (((RectF)localObject1).left + this.r);
        ((RectF)localObject1).top = i2;
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.r);
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
        }
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint;
        float f1 = ((Paint)localObject1).descent();
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding((Rect)localObject2);
        i1 = (((Rect)localObject2).right - ((Rect)localObject2).left) / 2;
        i2 = (((Rect)localObject2).bottom - ((Rect)localObject2).top) / 2;
        localObject2 = this.jdField_b_of_type_JavaLangString;
        float f2 = (int)(localRectF.left + localRectF.right) / 2 - i1;
        float f3 = localRectF.bottom;
        paramCanvas.drawText((String)localObject2, f2, (int)(localRectF.top + f3) / 2 + this.r / 4 - f1 - i2, (Paint)localObject1);
        return;
        i1 = i4 - this.jdField_b_of_type_Int * i2 / 208;
        break;
        i1 = -this.jdField_b_of_type_Int + this.jdField_b_of_type_Int * i2 / 208;
        break;
      }
    } while (this.v != 4);
    if (i1 == 0)
    {
      b(0);
      return;
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate(i4 - this.jdField_b_of_type_Int, 0, i4, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate(i4 - this.jdField_b_of_type_Int, i3, i4, this.jdField_a_of_type_Int + i3);
  }
  
  void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.u != paramInt3) && (paramInt2 > 0))
    {
      this.u = paramInt3;
      if (this.u / paramInt2 >= jdField_d_of_type_Int)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
      }
    }
    else
    {
      if (this.f) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (this.jdField_c_of_type_Boolean) {
        break label78;
      }
      if (this.v != 0) {
        b(0);
      }
    }
    label78:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if ((paramInt3 - paramInt2 > 0) && (this.v != 3))
          {
            this.jdField_c_of_type_Int = a(paramInt1, paramInt2, paramInt3);
            if (this.jdField_e_of_type_Boolean)
            {
              h();
              this.jdField_e_of_type_Boolean = false;
            }
          }
          this.jdField_a_of_type_Boolean = true;
        } while (paramInt1 == this.s);
        this.s = paramInt1;
      } while (this.v == 3);
      b(2);
    } while (this.f);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      b(2);
    }
    while (this.v != 2) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1500L);
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    int i1;
    switch (this.w)
    {
    default: 
      if (paramFloat1 > this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth() - this.jdField_b_of_type_Int) {
        i1 = 1;
      }
      break;
    }
    while ((i1 != 0) && ((this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) || ((paramFloat2 >= this.jdField_c_of_type_Int) && (paramFloat2 <= this.jdField_c_of_type_Int + this.jdField_a_of_type_Int))))
    {
      return true;
      i1 = 0;
      continue;
      if (paramFloat1 < this.jdField_b_of_type_Int) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    return false;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if ((this.v > 0) && (a(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.n())
        {
          f();
          return true;
        }
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        e();
        continue;
        d();
      }
    }
  }
  
  Object[] a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)) {
      b();
    }
    return this.jdField_a_of_type_ArrayOfJavaLangObject;
  }
  
  public int b()
  {
    return this.v;
  }
  
  void b()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetAbsListView.a();
    this.jdField_a_of_type_AndroidWidgetSectionIndexer = null;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof HeaderViewListAdapter))
    {
      this.t = ((HeaderViewListAdapter)localObject2).getHeadersCount();
      localObject1 = ((HeaderViewListAdapter)localObject2).getWrappedAdapter();
    }
    if ((localObject1 instanceof ExpandableListConnector))
    {
      localObject2 = ((ExpandableListConnector)localObject1).a();
      if ((localObject2 instanceof SectionIndexer))
      {
        this.jdField_a_of_type_AndroidWidgetSectionIndexer = ((SectionIndexer)localObject2);
        this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
        this.jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSections();
      }
    }
    do
    {
      return;
      if (!(localObject1 instanceof SectionIndexer)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetSectionIndexer = ((SectionIndexer)localObject1);
      this.jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSections();
    } while (this.jdField_a_of_type_ArrayOfJavaLangObject != null);
    this.jdField_a_of_type_ArrayOfJavaLangObject = new String[] { " " };
    return;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
    this.jdField_a_of_type_ArrayOfJavaLangObject = new String[] { " " };
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.v = paramInt;
      g();
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      continue;
      if (this.v != 2) {
        h();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      continue;
      int i1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate(i1 - this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, i1, this.jdField_c_of_type_Int + this.jdField_a_of_type_Int);
    }
  }
  
  boolean b()
  {
    return this.v != 0;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    if (this.v == 0) {}
    label214:
    do
    {
      do
      {
        return false;
        i2 = paramMotionEvent.getAction();
        if (i2 != 0) {
          break;
        }
      } while (!a(paramMotionEvent.getX(), paramMotionEvent.getY()));
      if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.n())
      {
        f();
        return true;
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      e();
      return false;
      if (i2 == 1)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          f();
          i3 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
          i2 = (int)paramMotionEvent.getY() - this.jdField_a_of_type_Int + 10;
          if (i2 >= 0) {
            break label214;
          }
          i1 = 0;
        }
        for (;;)
        {
          this.jdField_c_of_type_Int = i1;
          a(this.jdField_c_of_type_Int / (i3 - this.jdField_a_of_type_Int));
          d();
          if (this.v != 3) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
          {
            this.jdField_a_of_type_ComTencentWidgetAbsListView.requestDisallowInterceptTouchEvent(false);
            this.jdField_a_of_type_ComTencentWidgetAbsListView.a(0);
          }
          b(2);
          paramMotionEvent = this.jdField_a_of_type_AndroidOsHandler;
          paramMotionEvent.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
          if (!this.f) {
            paramMotionEvent.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1000L);
          }
          this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
          return true;
          i1 = i2;
          if (this.jdField_a_of_type_Int + i2 > i3) {
            i1 = i3 - this.jdField_a_of_type_Int;
          }
        }
      }
      if (i2 != 2) {
        break;
      }
      if ((this.jdField_b_of_type_Boolean) && (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) > this.y))
      {
        b(3);
        if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)) {
          b();
        }
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.requestDisallowInterceptTouchEvent(true);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.a(1);
        }
        i();
        d();
      }
    } while (this.v != 3);
    int i3 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
    int i2 = (int)paramMotionEvent.getY() - this.jdField_a_of_type_Int + 10;
    if (i2 < 0) {}
    for (;;)
    {
      if (Math.abs(this.jdField_c_of_type_Int - i1) < 2)
      {
        return true;
        if (this.jdField_a_of_type_Int + i2 > i3) {
          i1 = i3 - this.jdField_a_of_type_Int;
        }
      }
      else
      {
        this.jdField_c_of_type_Int = i1;
        if (this.jdField_a_of_type_Boolean) {
          a(this.jdField_c_of_type_Int / (i3 - this.jdField_a_of_type_Int));
        }
        return true;
        if (i2 != 3) {
          break;
        }
        d();
        return false;
      }
      i1 = i2;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = null;
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_Boolean = false;
  }
  
  void e()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 180L);
  }
  
  public void f()
  {
    b(3);
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)) {
      b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.a(1);
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller
 * JD-Core Version:    0.7.0.1
 */