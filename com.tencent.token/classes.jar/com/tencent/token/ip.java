package com.tencent.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class ip
{
  final TextView a;
  public final ir b;
  int c = 0;
  Typeface d;
  boolean e;
  private jg f;
  private jg g;
  private jg h;
  private jg i;
  
  public ip(TextView paramTextView)
  {
    this.a = paramTextView;
    this.b = new ir(this.a);
  }
  
  public static ip a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new iq(paramTextView);
    }
    return new ip(paramTextView);
  }
  
  protected static jg a(Context paramContext, ik paramik, int paramInt)
  {
    paramContext = paramik.b(paramContext, paramInt);
    if (paramContext != null)
    {
      paramik = new jg();
      paramik.d = true;
      paramik.a = paramContext;
      return paramik;
    }
    return null;
  }
  
  private void a(Context paramContext, ji paramji)
  {
    this.c = paramji.a(gs.j.TextAppearance_android_textStyle, this.c);
    boolean bool2 = paramji.f(gs.j.TextAppearance_android_fontFamily);
    bool1 = true;
    if ((!bool2) && (!paramji.f(gs.j.TextAppearance_fontFamily)))
    {
      if (paramji.f(gs.j.TextAppearance_android_typeface))
      {
        this.e = false;
        switch (paramji.a(gs.j.TextAppearance_android_typeface, 1))
        {
        default: 
          return;
        case 3: 
          this.d = Typeface.MONOSPACE;
          return;
        case 2: 
          this.d = Typeface.SERIF;
          return;
        }
        this.d = Typeface.SANS_SERIF;
        return;
      }
      return;
    }
    this.d = null;
    int j;
    if (paramji.f(gs.j.TextAppearance_fontFamily)) {
      j = gs.j.TextAppearance_fontFamily;
    } else {
      j = gs.j.TextAppearance_android_fontFamily;
    }
    if (!paramContext.isRestricted()) {
      paramContext = new da.a()
      {
        public final void a(Typeface paramAnonymousTypeface)
        {
          ip localip = ip.this;
          Object localObject = this.a;
          if (localip.e)
          {
            localip.d = paramAnonymousTypeface;
            localObject = (TextView)((WeakReference)localObject).get();
            if (localObject != null) {
              ((TextView)localObject).setTypeface(paramAnonymousTypeface, localip.c);
            }
          }
        }
      };
    }
    try
    {
      this.d = paramji.a(j, this.c, paramContext);
      if (this.d != null) {
        break label242;
      }
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        continue;
        bool1 = false;
      }
    }
    this.e = bool1;
    if (this.d == null)
    {
      paramContext = paramji.d(j);
      if (paramContext != null) {
        this.d = Typeface.create(paramContext, this.c);
      }
    }
  }
  
  private void b(int paramInt, float paramFloat)
  {
    this.b.a(paramInt, paramFloat);
  }
  
  public void a()
  {
    if ((this.f != null) || (this.g != null) || (this.h != null) || (this.i != null))
    {
      Drawable[] arrayOfDrawable = this.a.getCompoundDrawables();
      a(arrayOfDrawable[0], this.f);
      a(arrayOfDrawable[1], this.g);
      a(arrayOfDrawable[2], this.h);
      a(arrayOfDrawable[3], this.i);
    }
  }
  
  public final void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    if ((!fp.a) && (!this.b.d())) {
      b(paramInt, paramFloat);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    ji localji = ji.a(paramContext, paramInt, gs.j.TextAppearance);
    if (localji.f(gs.j.TextAppearance_textAllCaps)) {
      a(localji.a(gs.j.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localji.f(gs.j.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localji.e(gs.j.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.a.setTextColor(localColorStateList);
      }
    }
    a(paramContext, localji);
    localji.a.recycle();
    paramContext = this.d;
    if (paramContext != null) {
      this.a.setTypeface(paramContext, this.c);
    }
  }
  
  final void a(Drawable paramDrawable, jg paramjg)
  {
    if ((paramDrawable != null) && (paramjg != null)) {
      ik.a(paramDrawable, paramjg, this.a.getDrawableState());
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.a.getContext();
    Object localObject1 = ik.a();
    Object localObject2 = ji.a(localContext, paramAttributeSet, gs.j.AppCompatTextHelper, paramInt, 0);
    int j = ((ji)localObject2).g(gs.j.AppCompatTextHelper_android_textAppearance, -1);
    if (((ji)localObject2).f(gs.j.AppCompatTextHelper_android_drawableLeft)) {
      this.f = a(localContext, (ik)localObject1, ((ji)localObject2).g(gs.j.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((ji)localObject2).f(gs.j.AppCompatTextHelper_android_drawableTop)) {
      this.g = a(localContext, (ik)localObject1, ((ji)localObject2).g(gs.j.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((ji)localObject2).f(gs.j.AppCompatTextHelper_android_drawableRight)) {
      this.h = a(localContext, (ik)localObject1, ((ji)localObject2).g(gs.j.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((ji)localObject2).f(gs.j.AppCompatTextHelper_android_drawableBottom)) {
      this.i = a(localContext, (ik)localObject1, ((ji)localObject2).g(gs.j.AppCompatTextHelper_android_drawableBottom, 0));
    }
    ((ji)localObject2).a.recycle();
    boolean bool3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject4 = null;
    localObject2 = null;
    boolean bool1;
    Object localObject3;
    if (j != -1)
    {
      localObject5 = ji.a(localContext, j, gs.j.TextAppearance);
      if ((!bool3) && (((ji)localObject5).f(gs.j.TextAppearance_textAllCaps)))
      {
        bool1 = ((ji)localObject5).a(gs.j.TextAppearance_textAllCaps, false);
        j = 1;
      }
      else
      {
        j = 0;
        bool1 = false;
      }
      a(localContext, (ji)localObject5);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((ji)localObject5).f(gs.j.TextAppearance_android_textColor)) {
          localObject1 = ((ji)localObject5).e(gs.j.TextAppearance_android_textColor);
        } else {
          localObject1 = null;
        }
        if (((ji)localObject5).f(gs.j.TextAppearance_android_textColorHint)) {
          localObject3 = ((ji)localObject5).e(gs.j.TextAppearance_android_textColorHint);
        } else {
          localObject3 = null;
        }
        if (((ji)localObject5).f(gs.j.TextAppearance_android_textColorLink))
        {
          localObject4 = ((ji)localObject5).e(gs.j.TextAppearance_android_textColorLink);
          localObject2 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject3;
        }
        else
        {
          localObject4 = null;
          localObject2 = localObject1;
          localObject1 = localObject4;
          localObject4 = localObject3;
        }
      }
      else
      {
        localObject1 = null;
        localObject4 = localObject1;
      }
      ((ji)localObject5).a.recycle();
      localObject3 = localObject1;
      localObject1 = localObject4;
    }
    else
    {
      localObject3 = null;
      localObject1 = localObject3;
      j = 0;
      bool1 = false;
      localObject2 = localObject4;
    }
    ji localji = ji.a(localContext, paramAttributeSet, gs.j.TextAppearance, paramInt, 0);
    int k = j;
    boolean bool2 = bool1;
    if (!bool3)
    {
      k = j;
      bool2 = bool1;
      if (localji.f(gs.j.TextAppearance_textAllCaps))
      {
        bool2 = localji.a(gs.j.TextAppearance_textAllCaps, false);
        k = 1;
      }
    }
    Object localObject5 = localObject2;
    Object localObject6 = localObject3;
    localObject4 = localObject1;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localji.f(gs.j.TextAppearance_android_textColor)) {
        localObject2 = localji.e(gs.j.TextAppearance_android_textColor);
      }
      if (localji.f(gs.j.TextAppearance_android_textColorHint)) {
        localObject1 = localji.e(gs.j.TextAppearance_android_textColorHint);
      }
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject4 = localObject1;
      if (localji.f(gs.j.TextAppearance_android_textColorLink))
      {
        localObject6 = localji.e(gs.j.TextAppearance_android_textColorLink);
        localObject4 = localObject1;
        localObject5 = localObject2;
      }
    }
    a(localContext, localji);
    localji.a.recycle();
    if (localObject5 != null) {
      this.a.setTextColor((ColorStateList)localObject5);
    }
    if (localObject4 != null) {
      this.a.setHintTextColor((ColorStateList)localObject4);
    }
    if (localObject6 != null) {
      this.a.setLinkTextColor((ColorStateList)localObject6);
    }
    if ((!bool3) && (k != 0)) {
      a(bool2);
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      this.a.setTypeface((Typeface)localObject1, this.c);
    }
    localObject1 = this.b;
    paramAttributeSet = ((ir)localObject1).g.obtainStyledAttributes(paramAttributeSet, gs.j.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextView_autoSizeTextType)) {
      ((ir)localObject1).a = paramAttributeSet.getInt(gs.j.AppCompatTextView_autoSizeTextType, 0);
    }
    float f1;
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = paramAttributeSet.getDimension(gs.j.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    }
    float f2;
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = paramAttributeSet.getDimension(gs.j.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    }
    float f3;
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = paramAttributeSet.getDimension(gs.j.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    }
    if (paramAttributeSet.hasValue(gs.j.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = paramAttributeSet.getResourceId(gs.j.AppCompatTextView_autoSizePresetSizes, 0);
      if (paramInt > 0)
      {
        localObject2 = paramAttributeSet.getResources().obtainTypedArray(paramInt);
        j = ((TypedArray)localObject2).length();
        localObject3 = new int[j];
        if (j > 0)
        {
          paramInt = 0;
          while (paramInt < j)
          {
            localObject3[paramInt] = ((TypedArray)localObject2).getDimensionPixelSize(paramInt, -1);
            paramInt += 1;
          }
          ((ir)localObject1).e = ir.a((int[])localObject3);
          ((ir)localObject1).a();
        }
        ((TypedArray)localObject2).recycle();
      }
    }
    paramAttributeSet.recycle();
    if (((ir)localObject1).e())
    {
      if (((ir)localObject1).a == 1)
      {
        if (!((ir)localObject1).f)
        {
          paramAttributeSet = ((ir)localObject1).g.getResources().getDisplayMetrics();
          float f4 = f2;
          if (f2 == -1.0F) {
            f4 = TypedValue.applyDimension(2, 12.0F, paramAttributeSet);
          }
          f2 = f3;
          if (f3 == -1.0F) {
            f2 = TypedValue.applyDimension(2, 112.0F, paramAttributeSet);
          }
          f3 = f1;
          if (f1 == -1.0F) {
            f3 = 1.0F;
          }
          ((ir)localObject1).a(f4, f2, f3);
        }
        ((ir)localObject1).b();
      }
    }
    else {
      ((ir)localObject1).a = 0;
    }
    if ((fp.a) && (this.b.a != 0))
    {
      paramAttributeSet = this.b.e;
      if (paramAttributeSet.length > 0)
      {
        if (this.a.getAutoSizeStepGranularity() != -1.0F)
        {
          this.a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.b.c), Math.round(this.b.d), Math.round(this.b.b), 0);
          return;
        }
        this.a.setAutoSizeTextTypeUniformWithPresetSizes(paramAttributeSet, 0);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setAllCaps(paramBoolean);
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt)
  {
    this.b.a(paramArrayOfInt, paramInt);
  }
  
  public final void b()
  {
    if (!fp.a) {
      this.b.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ip
 * JD-Core Version:    0.7.0.1
 */