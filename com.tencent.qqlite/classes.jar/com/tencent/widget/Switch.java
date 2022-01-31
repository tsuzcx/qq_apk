package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CompoundButton;
import com.tencent.qqlite.R.styleable;
import flb;

public class Switch
  extends CompoundButton
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842912 };
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private float jdField_a_of_type_Float;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Layout jdField_a_of_type_AndroidTextLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
  private TransformationMethod2 jdField_a_of_type_ComTencentWidgetTransformationMethod2;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private float jdField_b_of_type_Float;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Layout jdField_b_of_type_AndroidTextLayout;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private float jdField_c_of_type_Float;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  
  public Switch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772082);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidTextTextPaint.density = localResources.getDisplayMetrics().density;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.t, paramInt, 2131624032);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(0);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(1);
    this.jdField_a_of_type_JavaLangCharSequence = paramAttributeSet.getText(2);
    this.jdField_b_of_type_JavaLangCharSequence = paramAttributeSet.getText(3);
    this.g = paramAttributeSet.getDimensionPixelSize(4, 0);
    this.h = paramAttributeSet.getDimensionPixelSize(6, 0);
    this.i = paramAttributeSet.getDimensionPixelSize(7, 0);
    paramInt = paramAttributeSet.getResourceId(5, 0);
    if (paramInt != 0) {
      setSwitchTextAppearance(paramContext, paramInt);
    }
    paramAttributeSet.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.k = paramContext.getScaledTouchSlop();
    this.l = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
    setOnClickListener(new flb(this));
  }
  
  private Layout a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentWidgetTransformationMethod2 != null) {
      paramCharSequence = this.jdField_a_of_type_ComTencentWidgetTransformationMethod2.getTransformation(paramCharSequence, this);
    }
    for (;;)
    {
      return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, (int)FloatMath.ceil(Layout.getDesiredWidth(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Typeface localTypeface = null;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      setSwitchTypeface(localTypeface, paramInt2);
      return;
      localTypeface = Typeface.SANS_SERIF;
      continue;
      localTypeface = Typeface.SERIF;
      continue;
      localTypeface = Typeface.MONOSPACE;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private void a(boolean paramBoolean)
  {
    setChecked(paramBoolean);
  }
  
  private boolean a()
  {
    return this.c >= d() / 2;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    int i1 = this.q;
    int i2 = this.k;
    int i3 = this.p + (int)(this.c + 0.5F) - this.k;
    int i4 = this.o;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i6 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int i7 = this.k;
    int i8 = this.s;
    int i9 = this.k;
    return (paramFloat1 > i3) && (paramFloat1 < i4 + i3 + i5 + i6 + i7) && (paramFloat2 > i1 - i2) && (paramFloat2 < i8 + i9);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    this.j = 0;
    int i1;
    if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
    {
      i1 = 1;
      a(paramMotionEvent);
      if (i1 == 0) {
        break label98;
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
      if (Math.abs(f1) <= this.l) {
        break label89;
      }
      if (f1 <= 0.0F) {
        break label83;
      }
    }
    for (;;)
    {
      a(bool);
      return;
      i1 = 0;
      break;
      label83:
      bool = false;
      continue;
      label89:
      bool = a();
    }
    label98:
    a(isChecked());
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = d();; f1 = 0.0F)
    {
      this.c = f1;
      return;
    }
  }
  
  private int d()
  {
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      return 0;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    return this.m - this.o - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public Drawable a()
  {
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public Drawable b()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public CharSequence b()
  {
    return this.jdField_b_of_type_JavaLangCharSequence;
  }
  
  public int c()
  {
    return this.g;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getCompoundPaddingRight()
  {
    int i2 = super.getCompoundPaddingRight() + this.m;
    int i1 = i2;
    if (!TextUtils.isEmpty(getText())) {
      i1 = i2 + this.i;
    }
    return i1;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, jdField_a_of_type_ArrayOfInt);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3 = this.p;
    int i1 = this.q;
    int i6 = this.r;
    int i2 = this.s;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(i3, i1, i6, i2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    int i5 = i3 + this.jdField_a_of_type_AndroidGraphicsRect.left;
    i3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i7 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    paramCanvas.clipRect(i5, i1, i6 - i7, i2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    i7 = (int)this.c;
    i6 = i5 - this.jdField_a_of_type_AndroidGraphicsRect.left + i7;
    int i8 = this.o;
    i5 = this.jdField_a_of_type_AndroidGraphicsRect.right + (i5 + i7 + i8);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i6, i1, i5, i2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(getDrawableState(), this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor()));
    }
    this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
    if (a()) {}
    for (Layout localLayout = this.jdField_a_of_type_AndroidTextLayout;; localLayout = this.jdField_b_of_type_AndroidTextLayout)
    {
      if (localLayout != null)
      {
        paramCanvas.translate((i6 + i5) / 2 - localLayout.getWidth() / 2, (i3 + i1 + (i2 - i4)) / 2 - localLayout.getHeight() / 2);
        localLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b(isChecked());
    paramInt3 = getWidth() - getPaddingRight();
    paramInt4 = this.m;
    switch (getGravity() & 0x70)
    {
    default: 
      paramInt2 = getPaddingTop();
      paramInt1 = this.n + paramInt2;
    }
    for (;;)
    {
      this.p = (paramInt3 - paramInt4);
      this.q = paramInt2;
      this.s = paramInt1;
      this.r = paramInt3;
      return;
      paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - this.n / 2;
      paramInt1 = this.n + paramInt2;
      continue;
      paramInt1 = getHeight() - getPaddingBottom();
      paramInt2 = paramInt1 - this.n;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidTextLayout == null) {
      this.jdField_a_of_type_AndroidTextLayout = a(this.jdField_a_of_type_JavaLangCharSequence);
    }
    if (this.jdField_b_of_type_AndroidTextLayout == null) {
      this.jdField_b_of_type_AndroidTextLayout = a(this.jdField_b_of_type_JavaLangCharSequence);
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
    int i1 = Math.max(Math.max(this.jdField_a_of_type_AndroidTextLayout.getWidth(), this.jdField_b_of_type_AndroidTextLayout.getWidth()), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth());
    int i2 = Math.max(Math.max(this.h, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth()), this.g * 4 + i1 + this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.right);
    int i3 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    this.o = (i1 + this.g * 2);
    this.m = i2;
    this.n = i3;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i3) {
      setMeasuredDimension(getMeasuredWidth(), i3);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      float f1;
      float f2;
      do
      {
        return bool;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        if ((!isEnabled()) || (!a(f1, f2))) {
          break;
        }
        this.j = 1;
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        break;
        switch (this.j)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.jdField_a_of_type_Float) <= this.k) && (Math.abs(f2 - this.jdField_b_of_type_Float) <= this.k)) {
            break;
          }
          this.j = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          return true;
        case 2: 
          f1 = paramMotionEvent.getX();
          f2 = Math.max(0.0F, Math.min(f1 - this.jdField_a_of_type_Float + this.c, d()));
        }
      } while (f2 == this.c);
      this.c = f2;
      this.jdField_a_of_type_Float = f1;
      invalidate();
      return true;
      if (this.j == 2)
      {
        b(paramMotionEvent);
        return true;
      }
      this.j = 0;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    b(isChecked());
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.w);
    ColorStateList localColorStateList = paramContext.getColorStateList(0);
    if (localColorStateList != null)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = localColorStateList;
      paramInt = paramContext.getDimensionPixelSize(1, 0);
      if ((paramInt != 0) && (paramInt != this.jdField_a_of_type_AndroidTextTextPaint.getTextSize()))
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
        requestLayout();
      }
      a(paramContext.getInt(3, -1), paramContext.getInt(2, -1));
      if (!paramContext.getBoolean(8, false)) {
        break label128;
      }
      this.jdField_a_of_type_ComTencentWidgetTransformationMethod2 = new AllCapsTransformationMethod(getContext());
      this.jdField_a_of_type_ComTencentWidgetTransformationMethod2.a(true);
    }
    for (;;)
    {
      paramContext.recycle();
      return;
      this.jdField_a_of_type_AndroidContentResColorStateList = getTextColors();
      break;
      label128:
      this.jdField_a_of_type_ComTencentWidgetTransformationMethod2 = null;
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_AndroidTextTextPaint.getTypeface() != paramTypeface)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    if (paramInt > 0)
    {
      int i1;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setSwitchTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label88;
        }
        i1 = paramTypeface.getStyle();
        label31:
        paramInt = (i1 ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.jdField_a_of_type_AndroidTextTextPaint;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.jdField_a_of_type_AndroidTextTextPaint;
        if ((paramInt & 0x2) == 0) {
          break label94;
        }
      }
      label88:
      label94:
      for (float f1 = -0.25F;; f1 = 0.0F)
      {
        paramTypeface.setTextSkewX(f1);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i1 = 0;
        break label31;
      }
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(false);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(0.0F);
    setSwitchTypeface(paramTypeface);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.g = paramInt;
    requestLayout();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (paramDrawable == this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.Switch
 * JD-Core Version:    0.7.0.1
 */