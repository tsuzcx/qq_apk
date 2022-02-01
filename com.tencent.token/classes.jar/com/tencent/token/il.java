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

public class il
{
  final TextView a;
  public final in b;
  int c = 0;
  Typeface d;
  boolean e;
  private jc f;
  private jc g;
  private jc h;
  private jc i;
  
  public il(TextView paramTextView)
  {
    this.a = paramTextView;
    this.b = new in(this.a);
  }
  
  public static il a(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new im(paramTextView);
    }
    return new il(paramTextView);
  }
  
  protected static jc a(Context paramContext, ig paramig, int paramInt)
  {
    paramContext = paramig.b(paramContext, paramInt);
    if (paramContext != null)
    {
      paramig = new jc();
      paramig.d = true;
      paramig.a = paramContext;
      return paramig;
    }
    return null;
  }
  
  private void a(Context paramContext, je paramje)
  {
    this.c = paramje.a(go.j.TextAppearance_android_textStyle, this.c);
    boolean bool2 = paramje.f(go.j.TextAppearance_android_fontFamily);
    bool1 = true;
    if ((!bool2) && (!paramje.f(go.j.TextAppearance_fontFamily)))
    {
      if (paramje.f(go.j.TextAppearance_android_typeface))
      {
        this.e = false;
        switch (paramje.a(go.j.TextAppearance_android_typeface, 1))
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
    if (paramje.f(go.j.TextAppearance_fontFamily)) {
      j = go.j.TextAppearance_fontFamily;
    } else {
      j = go.j.TextAppearance_android_fontFamily;
    }
    if (!paramContext.isRestricted()) {
      paramContext = new cw.a()
      {
        public final void a(Typeface paramAnonymousTypeface)
        {
          il localil = il.this;
          Object localObject = this.a;
          if (localil.e)
          {
            localil.d = paramAnonymousTypeface;
            localObject = (TextView)((WeakReference)localObject).get();
            if (localObject != null) {
              ((TextView)localObject).setTypeface(paramAnonymousTypeface, localil.c);
            }
          }
        }
      };
    }
    try
    {
      this.d = paramje.a(j, this.c, paramContext);
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
      paramContext = paramje.d(j);
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
    if ((!fl.a) && (!this.b.d())) {
      b(paramInt, paramFloat);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void a(Context paramContext, int paramInt)
  {
    je localje = je.a(paramContext, paramInt, go.j.TextAppearance);
    if (localje.f(go.j.TextAppearance_textAllCaps)) {
      a(localje.a(go.j.TextAppearance_textAllCaps, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localje.f(go.j.TextAppearance_android_textColor)))
    {
      ColorStateList localColorStateList = localje.e(go.j.TextAppearance_android_textColor);
      if (localColorStateList != null) {
        this.a.setTextColor(localColorStateList);
      }
    }
    a(paramContext, localje);
    localje.a.recycle();
    paramContext = this.d;
    if (paramContext != null) {
      this.a.setTypeface(paramContext, this.c);
    }
  }
  
  final void a(Drawable paramDrawable, jc paramjc)
  {
    if ((paramDrawable != null) && (paramjc != null)) {
      ig.a(paramDrawable, paramjc, this.a.getDrawableState());
    }
  }
  
  @SuppressLint({"NewApi"})
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.a.getContext();
    Object localObject1 = ig.a();
    Object localObject2 = je.a(localContext, paramAttributeSet, go.j.AppCompatTextHelper, paramInt, 0);
    int j = ((je)localObject2).g(go.j.AppCompatTextHelper_android_textAppearance, -1);
    if (((je)localObject2).f(go.j.AppCompatTextHelper_android_drawableLeft)) {
      this.f = a(localContext, (ig)localObject1, ((je)localObject2).g(go.j.AppCompatTextHelper_android_drawableLeft, 0));
    }
    if (((je)localObject2).f(go.j.AppCompatTextHelper_android_drawableTop)) {
      this.g = a(localContext, (ig)localObject1, ((je)localObject2).g(go.j.AppCompatTextHelper_android_drawableTop, 0));
    }
    if (((je)localObject2).f(go.j.AppCompatTextHelper_android_drawableRight)) {
      this.h = a(localContext, (ig)localObject1, ((je)localObject2).g(go.j.AppCompatTextHelper_android_drawableRight, 0));
    }
    if (((je)localObject2).f(go.j.AppCompatTextHelper_android_drawableBottom)) {
      this.i = a(localContext, (ig)localObject1, ((je)localObject2).g(go.j.AppCompatTextHelper_android_drawableBottom, 0));
    }
    ((je)localObject2).a.recycle();
    boolean bool3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
    Object localObject4 = null;
    localObject2 = null;
    boolean bool1;
    Object localObject3;
    if (j != -1)
    {
      localObject5 = je.a(localContext, j, go.j.TextAppearance);
      if ((!bool3) && (((je)localObject5).f(go.j.TextAppearance_textAllCaps)))
      {
        bool1 = ((je)localObject5).a(go.j.TextAppearance_textAllCaps, false);
        j = 1;
      }
      else
      {
        j = 0;
        bool1 = false;
      }
      a(localContext, (je)localObject5);
      if (Build.VERSION.SDK_INT < 23)
      {
        if (((je)localObject5).f(go.j.TextAppearance_android_textColor)) {
          localObject1 = ((je)localObject5).e(go.j.TextAppearance_android_textColor);
        } else {
          localObject1 = null;
        }
        if (((je)localObject5).f(go.j.TextAppearance_android_textColorHint)) {
          localObject3 = ((je)localObject5).e(go.j.TextAppearance_android_textColorHint);
        } else {
          localObject3 = null;
        }
        if (((je)localObject5).f(go.j.TextAppearance_android_textColorLink))
        {
          localObject4 = ((je)localObject5).e(go.j.TextAppearance_android_textColorLink);
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
      ((je)localObject5).a.recycle();
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
    je localje = je.a(localContext, paramAttributeSet, go.j.TextAppearance, paramInt, 0);
    int k = j;
    boolean bool2 = bool1;
    if (!bool3)
    {
      k = j;
      bool2 = bool1;
      if (localje.f(go.j.TextAppearance_textAllCaps))
      {
        bool2 = localje.a(go.j.TextAppearance_textAllCaps, false);
        k = 1;
      }
    }
    Object localObject5 = localObject2;
    Object localObject6 = localObject3;
    localObject4 = localObject1;
    if (Build.VERSION.SDK_INT < 23)
    {
      if (localje.f(go.j.TextAppearance_android_textColor)) {
        localObject2 = localje.e(go.j.TextAppearance_android_textColor);
      }
      if (localje.f(go.j.TextAppearance_android_textColorHint)) {
        localObject1 = localje.e(go.j.TextAppearance_android_textColorHint);
      }
      localObject5 = localObject2;
      localObject6 = localObject3;
      localObject4 = localObject1;
      if (localje.f(go.j.TextAppearance_android_textColorLink))
      {
        localObject6 = localje.e(go.j.TextAppearance_android_textColorLink);
        localObject4 = localObject1;
        localObject5 = localObject2;
      }
    }
    a(localContext, localje);
    localje.a.recycle();
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
    paramAttributeSet = ((in)localObject1).g.obtainStyledAttributes(paramAttributeSet, go.j.AppCompatTextView, paramInt, 0);
    if (paramAttributeSet.hasValue(go.j.AppCompatTextView_autoSizeTextType)) {
      ((in)localObject1).a = paramAttributeSet.getInt(go.j.AppCompatTextView_autoSizeTextType, 0);
    }
    float f1;
    if (paramAttributeSet.hasValue(go.j.AppCompatTextView_autoSizeStepGranularity)) {
      f1 = paramAttributeSet.getDimension(go.j.AppCompatTextView_autoSizeStepGranularity, -1.0F);
    } else {
      f1 = -1.0F;
    }
    float f2;
    if (paramAttributeSet.hasValue(go.j.AppCompatTextView_autoSizeMinTextSize)) {
      f2 = paramAttributeSet.getDimension(go.j.AppCompatTextView_autoSizeMinTextSize, -1.0F);
    } else {
      f2 = -1.0F;
    }
    float f3;
    if (paramAttributeSet.hasValue(go.j.AppCompatTextView_autoSizeMaxTextSize)) {
      f3 = paramAttributeSet.getDimension(go.j.AppCompatTextView_autoSizeMaxTextSize, -1.0F);
    } else {
      f3 = -1.0F;
    }
    if (paramAttributeSet.hasValue(go.j.AppCompatTextView_autoSizePresetSizes))
    {
      paramInt = paramAttributeSet.getResourceId(go.j.AppCompatTextView_autoSizePresetSizes, 0);
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
          ((in)localObject1).e = in.a((int[])localObject3);
          ((in)localObject1).a();
        }
        ((TypedArray)localObject2).recycle();
      }
    }
    paramAttributeSet.recycle();
    if (((in)localObject1).e())
    {
      if (((in)localObject1).a == 1)
      {
        if (!((in)localObject1).f)
        {
          paramAttributeSet = ((in)localObject1).g.getResources().getDisplayMetrics();
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
          ((in)localObject1).a(f4, f2, f3);
        }
        ((in)localObject1).b();
      }
    }
    else {
      ((in)localObject1).a = 0;
    }
    if ((fl.a) && (this.b.a != 0))
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
    if (!fl.a) {
      this.b.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.il
 * JD-Core Version:    0.7.0.1
 */