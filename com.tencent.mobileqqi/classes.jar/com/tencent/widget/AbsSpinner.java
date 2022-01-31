package com.tencent.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import hvj;

public abstract class AbsSpinner
  extends AdapterView
{
  private static final int g = a("AbsSpinner_entries");
  int jdField_a_of_type_Int;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  SpinnerAdapter jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  final hvj jdField_a_of_type_Hvj = new hvj(this);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  int c = 0;
  int d = 0;
  int e = 0;
  int f;
  
  public AbsSpinner(Context paramContext)
  {
    super(paramContext);
    this.jdField_f_of_type_Int = 0;
    d();
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AbsSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_f_of_type_Int = 0;
    d();
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, a("AbsSpinner"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.a(g);
    if (arrayOfCharSequence != null)
    {
      paramContext = new ArrayAdapter(paramContext, 17367048, arrayOfCharSequence);
      paramContext.setDropDownViewResource(17367049);
      setAdapter(paramContext);
    }
    paramAttributeSet.a();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      return 0xFF000000 & paramInt3 | paramInt2;
      paramInt2 = paramInt1;
      if (i < paramInt1)
      {
        paramInt2 = i | 0x1000000;
        continue;
        paramInt2 = i;
      }
    }
  }
  
  private void d()
  {
    setFocusable(true);
    setWillNotDraw(false);
  }
  
  public int a()
  {
    return this.aB;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.jdField_b_of_type_AndroidGraphicsRect;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
      localObject1 = this.jdField_b_of_type_AndroidGraphicsRect;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if (((View)localObject2).getVisibility() == 0)
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.ap + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public View a()
  {
    if ((this.aB > 0) && (this.aA >= 0)) {
      return getChildAt(this.aA - this.ap);
    }
    return null;
  }
  
  public SpinnerAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetSpinnerAdapter;
  }
  
  protected AdapterView.AdapterDataSetObserver a()
  {
    return new AdapterView.AdapterDataSetObserver(this);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != this.aE)
    {
      this.jdField_a_of_type_Boolean = true;
      int i = this.aA;
      f(paramInt);
      b(paramInt - i, paramBoolean);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  int b(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  void b()
  {
    this.p = false;
    this.n = false;
    removeAllViewsInLayout();
    this.aE = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    e(-1);
    f(-1);
    invalidate();
  }
  
  abstract void b(int paramInt, boolean paramBoolean);
  
  void c()
  {
    int j = getChildCount();
    hvj localhvj = this.jdField_a_of_type_Hvj;
    int k = this.ap;
    int i = 0;
    while (i < j)
    {
      localhvj.a(k + i, getChildAt(i));
      i += 1;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.LayoutParams(-1, -2);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    int i;
    label56:
    label84:
    label112:
    int j;
    int k;
    if (this.mPaddingLeft > this.c)
    {
      i = this.mPaddingLeft;
      ((Rect)localObject).left = i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingTop <= this.d) {
        break label415;
      }
      i = this.mPaddingTop;
      ((Rect)localObject).top = i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingRight <= this.e) {
        break label423;
      }
      i = this.mPaddingRight;
      ((Rect)localObject).right = i;
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      if (this.mPaddingBottom <= this.jdField_f_of_type_Int) {
        break label431;
      }
      i = this.mPaddingBottom;
      ((Rect)localObject).bottom = i;
      if (this.p) {
        p();
      }
      i = p();
      if ((i < 0) || (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter == null) || (i >= this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount())) {
        break label439;
      }
      View localView = this.jdField_a_of_type_Hvj.a(i);
      localObject = localView;
      if (localView == null) {
        localObject = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(i, null, this);
      }
      if (localObject != null) {
        this.jdField_a_of_type_Hvj.a(i, (View)localObject);
      }
      if (localObject == null) {
        break label439;
      }
      if (((View)localObject).getLayoutParams() == null)
      {
        this.jdField_a_of_type_Boolean = true;
        ((View)localObject).setLayoutParams(generateDefaultLayoutParams());
        this.jdField_a_of_type_Boolean = false;
      }
      measureChild((View)localObject, paramInt1, paramInt2);
      j = a((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      i = b((View)localObject) + this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
      k = 0;
    }
    for (;;)
    {
      int m = i;
      if (k != 0)
      {
        k = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom;
        m = i;
        j = k;
        if (n == 0)
        {
          m = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right;
          j = k;
        }
      }
      i = Math.max(j, getSuggestedMinimumHeight());
      j = Math.max(m, getSuggestedMinimumWidth());
      i = a(i, paramInt2, 0);
      setMeasuredDimension(a(j, paramInt1, 0), i);
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_b_of_type_Int = paramInt1;
      return;
      i = this.c;
      break;
      label415:
      i = this.d;
      break label56;
      label423:
      i = this.e;
      break label84;
      label431:
      i = this.jdField_f_of_type_Int;
      break label112;
      label439:
      k = 1;
      i = 0;
      j = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsSpinner.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.jdField_a_of_type_Long >= 0L)
    {
      this.p = true;
      this.n = true;
      this.jdField_a_of_type_Long = paramParcelable.jdField_a_of_type_Long;
      this.as = paramParcelable.jdField_a_of_type_Int;
      this.at = 0;
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    AbsSpinner.SavedState localSavedState = new AbsSpinner.SavedState(super.onSaveInstanceState());
    localSavedState.jdField_a_of_type_Long = a();
    if (localSavedState.jdField_a_of_type_Long >= 0L)
    {
      localSavedState.jdField_a_of_type_Int = p();
      return localSavedState;
    }
    localSavedState.jdField_a_of_type_Int = -1;
    return localSavedState;
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    int i = -1;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      b();
    }
    this.jdField_a_of_type_AndroidWidgetSpinnerAdapter = paramSpinnerAdapter;
    this.aE = -1;
    this.jdField_f_of_type_Long = -9223372036854775808L;
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      this.aC = this.aB;
      this.aB = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getCount();
      w();
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = a();
      this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if (this.aB > 0) {
        i = 0;
      }
      e(i);
      f(i);
      if (this.aB == 0) {
        x();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      w();
      b();
      x();
    }
  }
  
  public void setSelection(int paramInt)
  {
    f(paramInt);
    requestLayout();
    invalidate();
  }
  
  public void setSelection(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ap <= paramInt) && (paramInt <= this.ap + getChildCount() - 1)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramInt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner
 * JD-Core Version:    0.7.0.1
 */