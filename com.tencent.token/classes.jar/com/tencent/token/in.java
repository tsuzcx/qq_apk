package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatEditText;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class in
{
  private static final RectF h = new RectF();
  private static ConcurrentHashMap<String, Method> i = new ConcurrentHashMap();
  public int a = 0;
  public float b = -1.0F;
  public float c = -1.0F;
  public float d = -1.0F;
  public int[] e = new int[0];
  boolean f = false;
  final Context g;
  private boolean j = false;
  private TextPaint k;
  private final TextView l;
  
  in(TextView paramTextView)
  {
    this.l = paramTextView;
    this.g = this.l.getContext();
  }
  
  private int a(RectF paramRectF)
  {
    int m = this.e.length;
    if (m != 0)
    {
      int i1 = m - 1;
      m = 1;
      int n = 0;
      while (m <= i1)
      {
        int i2 = (m + i1) / 2;
        if (a(this.e[i2], paramRectF))
        {
          n = m;
          m = i2 + 1;
        }
        else
        {
          n = i2 - 1;
          i1 = n;
        }
      }
      return this.e[n];
    }
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt)
  {
    float f1;
    float f2;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16)
    {
      f1 = this.l.getLineSpacingMultiplier();
      f2 = this.l.getLineSpacingExtra();
      bool = this.l.getIncludeFontPadding();
    }
    else
    {
      f1 = ((Float)a(this.l, "getLineSpacingMultiplier", Float.valueOf(1.0F))).floatValue();
      f2 = ((Float)a(this.l, "getLineSpacingExtra", Float.valueOf(0.0F))).floatValue();
      bool = ((Boolean)a(this.l, "getIncludeFontPadding", Boolean.TRUE)).booleanValue();
    }
    return new StaticLayout(paramCharSequence, this.k, paramInt, paramAlignment, f1, f2, bool);
  }
  
  private StaticLayout a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, int paramInt1, int paramInt2)
  {
    TextDirectionHeuristic localTextDirectionHeuristic = (TextDirectionHeuristic)a(this.l, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
    paramCharSequence = StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), this.k, paramInt1).setAlignment(paramAlignment).setLineSpacing(this.l.getLineSpacingExtra(), this.l.getLineSpacingMultiplier()).setIncludePad(this.l.getIncludeFontPadding()).setBreakStrategy(this.l.getBreakStrategy()).setHyphenationFrequency(this.l.getHyphenationFrequency());
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = 2147483647;
    }
    return paramCharSequence.setMaxLines(paramInt1).setTextDirection(localTextDirectionHeuristic).build();
  }
  
  /* Error */
  private static <T> T a(Object paramObject, String paramString, T paramT)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 192	com/tencent/token/in:a	(Ljava/lang/String;)Ljava/lang/reflect/Method;
    //   4: aload_0
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokevirtual 198	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: astore_0
    //   16: goto +28 -> 44
    //   19: new 200	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 202
    //   25: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_0
    //   36: ldc 209
    //   38: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: areturn
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: goto -28 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramObject	Object
    //   0	50	1	paramString	String
    //   0	50	2	paramT	T
    // Exception table:
    //   from	to	target	type
    //   0	13	15	finally
    //   19	42	15	finally
    //   0	13	46	java/lang/Exception
  }
  
  private static Method a(String paramString)
  {
    try
    {
      Method localMethod = (Method)i.get(paramString);
      localObject = localMethod;
      if (localMethod == null)
      {
        localMethod = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject = localMethod;
        if (localMethod != null)
        {
          localMethod.setAccessible(true);
          i.put(paramString, localMethod);
          localObject = localMethod;
        }
      }
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label52:
      break label52;
    }
    localObject = new StringBuilder("Failed to retrieve TextView#");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("() method");
    return null;
  }
  
  private void a(float paramFloat)
  {
    boolean bool;
    if (paramFloat != this.l.getPaint().getTextSize())
    {
      this.l.getPaint().setTextSize(paramFloat);
      if (Build.VERSION.SDK_INT >= 18) {
        bool = this.l.isInLayout();
      } else {
        bool = false;
      }
      if (this.l.getLayout() != null) {
        this.j = false;
      }
    }
    try
    {
      Method localMethod = a("nullLayouts");
      if (localMethod != null) {
        localMethod.invoke(this.l, new Object[0]);
      }
    }
    catch (Exception localException)
    {
      label85:
      break label85;
    }
    if (!bool) {
      this.l.requestLayout();
    } else {
      this.l.forceLayout();
    }
    this.l.invalidate();
  }
  
  private boolean a(int paramInt, RectF paramRectF)
  {
    Object localObject2 = this.l.getText();
    Object localObject3 = this.l.getTransformationMethod();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject2, this.l);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = localObject3;
      }
    }
    int m;
    if (Build.VERSION.SDK_INT >= 16) {
      m = this.l.getMaxLines();
    } else {
      m = -1;
    }
    localObject2 = this.k;
    if (localObject2 == null) {
      this.k = new TextPaint();
    } else {
      ((TextPaint)localObject2).reset();
    }
    this.k.set(this.l.getPaint());
    this.k.setTextSize(paramInt);
    localObject2 = (Layout.Alignment)a(this.l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right), m);
    } else {
      localObject2 = a(localObject1, (Layout.Alignment)localObject2, Math.round(paramRectF.right));
    }
    if ((m != -1) && ((((StaticLayout)localObject2).getLineCount() > m) || (((StaticLayout)localObject2).getLineEnd(((StaticLayout)localObject2).getLineCount() - 1) != localObject1.length()))) {
      return false;
    }
    return ((StaticLayout)localObject2).getHeight() <= paramRectF.bottom;
  }
  
  static int[] a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt.length;
    if (i1 == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    int m = 0;
    while (m < i1)
    {
      int i2 = paramArrayOfInt[m];
      if ((i2 > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(i2)) < 0)) {
        localArrayList.add(Integer.valueOf(i2));
      }
      m += 1;
    }
    if (i1 == localArrayList.size()) {
      return paramArrayOfInt;
    }
    i1 = localArrayList.size();
    paramArrayOfInt = new int[i1];
    m = n;
    while (m < i1)
    {
      paramArrayOfInt[m] = ((Integer)localArrayList.get(m)).intValue();
      m += 1;
    }
    return paramArrayOfInt;
  }
  
  private void f()
  {
    this.a = 0;
    this.c = -1.0F;
    this.d = -1.0F;
    this.b = -1.0F;
    this.e = new int[0];
    this.j = false;
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          this.a = 1;
          this.c = paramFloat1;
          this.d = paramFloat2;
          this.b = paramFloat3;
          this.f = false;
          return;
        }
        localStringBuilder = new StringBuilder("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  final void a(int paramInt)
  {
    if (e()) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Unknown auto-size text type: ".concat(String.valueOf(paramInt)));
      case 1: 
        DisplayMetrics localDisplayMetrics = this.g.getResources().getDisplayMetrics();
        a(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
        if (b())
        {
          c();
          return;
        }
        break;
      case 0: 
        f();
        return;
      }
    }
  }
  
  final void a(int paramInt, float paramFloat)
  {
    Object localObject = this.g;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    a(TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics()));
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (e())
    {
      DisplayMetrics localDisplayMetrics = this.g.getResources().getDisplayMetrics();
      a(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (b()) {
        c();
      }
    }
  }
  
  final void a(int[] paramArrayOfInt, int paramInt)
  {
    if (e())
    {
      int n = paramArrayOfInt.length;
      int m = 0;
      if (n > 0)
      {
        int[] arrayOfInt = new int[n];
        Object localObject;
        if (paramInt == 0)
        {
          localObject = Arrays.copyOf(paramArrayOfInt, n);
        }
        else
        {
          DisplayMetrics localDisplayMetrics = this.g.getResources().getDisplayMetrics();
          for (;;)
          {
            localObject = arrayOfInt;
            if (m >= n) {
              break;
            }
            arrayOfInt[m] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[m], localDisplayMetrics));
            m += 1;
          }
        }
        this.e = a((int[])localObject);
        if (!a())
        {
          localObject = new StringBuilder("None of the preset sizes is valid: ");
          ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.f = false;
      }
      if (b()) {
        c();
      }
    }
  }
  
  final boolean a()
  {
    int m = this.e.length;
    boolean bool;
    if (m > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if (this.f)
    {
      this.a = 1;
      int[] arrayOfInt = this.e;
      this.c = arrayOfInt[0];
      this.d = arrayOfInt[(m - 1)];
      this.b = -1.0F;
    }
    return this.f;
  }
  
  final boolean b()
  {
    boolean bool = e();
    int n = 0;
    if ((bool) && (this.a == 1))
    {
      if ((!this.f) || (this.e.length == 0))
      {
        float f1 = Math.round(this.c);
        int m = 1;
        while (Math.round(this.b + f1) <= Math.round(this.d))
        {
          m += 1;
          f1 += this.b;
        }
        int[] arrayOfInt = new int[m];
        f1 = this.c;
        while (n < m)
        {
          arrayOfInt[n] = Math.round(f1);
          f1 += this.b;
          n += 1;
        }
        this.e = a(arrayOfInt);
      }
      this.j = true;
    }
    else
    {
      this.j = false;
    }
    return this.j;
  }
  
  public final void c()
  {
    if (!d()) {
      return;
    }
    if (this.j)
    {
      if (this.l.getMeasuredHeight() > 0)
      {
        if (this.l.getMeasuredWidth() <= 0) {
          return;
        }
        int m;
        if (((Boolean)a(this.l, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue()) {
          m = 1048576;
        } else {
          m = this.l.getMeasuredWidth() - this.l.getTotalPaddingLeft() - this.l.getTotalPaddingRight();
        }
        int n = this.l.getHeight() - this.l.getCompoundPaddingBottom() - this.l.getCompoundPaddingTop();
        if (m > 0)
        {
          if (n <= 0) {
            return;
          }
          synchronized (h)
          {
            h.setEmpty();
            h.right = m;
            h.bottom = n;
            float f1 = a(h);
            if (f1 != this.l.getTextSize()) {
              a(0, f1);
            }
          }
        }
        return;
      }
      return;
    }
    this.j = true;
  }
  
  public final boolean d()
  {
    return (e()) && (this.a != 0);
  }
  
  final boolean e()
  {
    return !(this.l instanceof AppCompatEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.in
 * JD-Core Version:    0.7.0.1
 */