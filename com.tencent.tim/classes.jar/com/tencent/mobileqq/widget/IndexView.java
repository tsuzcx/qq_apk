package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.qphone.base.util.QLog;

public class IndexView
  extends View
{
  private a jdField_a_of_type_ComTencentMobileqqWidgetIndexView$a;
  private b jdField_a_of_type_ComTencentMobileqqWidgetIndexView$b;
  private boolean bRZ;
  private Rect cU;
  private Rect cV;
  private boolean dak;
  private boolean dal;
  private boolean dam;
  private Drawable gf;
  private Drawable gg;
  private String[] k;
  private TextPaint mTextPaint = new TextPaint();
  private int[] pk;
  private int[] pl;
  
  public IndexView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IndexView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int aX(int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    int i = 100;
    int j = 50;
    int m = getPaddingTop();
    int n = getPaddingBottom();
    while (paramInt1 < i)
    {
      j = (paramInt1 + i) / 2;
      if (kx(j) <= paramInt2 - (m + n)) {
        paramInt1 = j + 1;
      } else {
        i = j - 1;
      }
    }
    return ky(j) + getPaddingLeft() + getPaddingRight();
  }
  
  private void eic()
  {
    int j = this.k.length;
    Rect localRect = new Rect();
    int i = 0;
    while (i < j)
    {
      this.mTextPaint.getTextBounds(this.k[i], 0, this.k[i].length(), localRect);
      this.pl[i] = (localRect.right - localRect.left);
      this.pk[i] = (localRect.bottom - localRect.top);
      i += 1;
    }
  }
  
  private static int h(int[] paramArrayOfInt)
  {
    int m = 0;
    int i = 0;
    if (paramArrayOfInt != null)
    {
      int n = paramArrayOfInt.length;
      int j = 0;
      for (;;)
      {
        m = i;
        if (j >= n) {
          break;
        }
        m = paramArrayOfInt[j];
        j += 1;
        i = m + i;
      }
    }
    return m;
  }
  
  private int kw(int paramInt)
  {
    return View.MeasureSpec.getSize(paramInt);
  }
  
  private int kx(int paramInt)
  {
    int j = this.k.length;
    TextPaint localTextPaint = this.mTextPaint;
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      localTextPaint.getTextBounds(this.k[paramInt], 0, this.k[paramInt].length(), localRect);
      int m = localRect.bottom - localRect.top;
      i = i + m + (int)(m * 0.8F);
      paramInt += 1;
    }
    return i;
  }
  
  private int ky(int paramInt)
  {
    int j = this.k.length;
    TextPaint localTextPaint = this.mTextPaint;
    localTextPaint.setTextSize(paramInt);
    localTextPaint.setAntiAlias(true);
    Rect localRect = new Rect();
    paramInt = 0;
    int i = 0;
    while (paramInt < j)
    {
      localTextPaint.getTextBounds(this.k[paramInt], 0, this.k[paramInt].length(), localRect);
      i = Math.max(i, localRect.right - localRect.left);
      paramInt += 1;
    }
    return i;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int n = 1;
    super.onDraw(paramCanvas);
    TextPaint localTextPaint = this.mTextPaint;
    int j = getWidth() - getPaddingLeft() - getPaddingRight();
    int i1 = getPaddingLeft();
    int i3 = getPaddingTop();
    int i = getPaddingBottom();
    i = getHeight() - i3 - i;
    int m = h(this.pk);
    if (i > m) {}
    for (float f2 = (i - m) * 1.0F / (this.k.length - 1);; f2 = 0.0F)
    {
      float f3 = i3;
      int i2 = this.k.length;
      float f1;
      float f4;
      if (!this.bRZ)
      {
        localTextPaint.setColor(Color.rgb(119, 119, 119));
        f1 = f3;
        if (this.dak)
        {
          f1 = this.pk[0];
          f4 = this.gf.getIntrinsicWidth() * 1.0F / this.gf.getIntrinsicHeight();
          if (f4 < j * 1.0F / this.pk[0]) {
            break label406;
          }
          i = (int)(j / f4);
          m = j;
          label198:
          this.cU.left = ((j - m) / 2 + i1);
          this.cU.top = (i3 + (this.pk[0] - i) / 2);
          this.cU.right = (m + this.cU.left);
          this.cU.bottom = (i + this.cU.top);
          this.gf.setBounds(this.cU);
          this.gf.draw(paramCanvas);
          f1 = f3 + f1 + f2;
        }
        if (!this.dal) {
          break label683;
        }
        if (!this.dam) {
          break label771;
        }
      }
      label771:
      for (m = i2 - 2;; m = i2 - 1)
      {
        if (this.dak) {
          i = 1;
        }
        String str;
        for (;;)
        {
          if (i >= m) {
            break label432;
          }
          f1 += this.pk[i];
          str = this.k[i];
          paramCanvas.drawText(str, 0, str.length(), (j - this.pl[i]) / 2 + i1, f1, localTextPaint);
          f1 += f2;
          i += 1;
          continue;
          localTextPaint.setColor(-1);
          break;
          label406:
          i = this.pk[0];
          m = (int)(f4 * i);
          break label198;
          i = 0;
        }
        label432:
        i2 = (int)f1;
        f3 = this.pk[m];
        f4 = this.gg.getIntrinsicWidth() * 1.0F / this.gg.getIntrinsicHeight();
        if (f4 >= j * 1.0F / this.pk[m])
        {
          i = (int)(j / f4);
          n = j;
          this.cV.left = ((j - n) / 2 + i1);
          this.cV.top = (i2 + (this.pk[m] - i) / 2);
          this.cV.right = (n + this.cV.left);
          this.cV.bottom = (i + this.cV.top);
          this.gg.setBounds(this.cV);
          this.gg.draw(paramCanvas);
          if (this.dam)
          {
            f1 = f1 + f3 + f2 + this.pk[(m + 1)];
            str = this.k[(m + 1)];
            paramCanvas.drawText(str, 0, str.length(), (j - this.pl[(m + 1)]) / 2 + i1, f1, localTextPaint);
          }
        }
        for (;;)
        {
          return;
          i = this.pk[m];
          n = (int)(f4 * i);
          break;
          label683:
          if (this.dak) {
            i = n;
          }
          while (i < i2)
          {
            f1 += this.pk[i];
            str = this.k[i];
            paramCanvas.drawText(str, 0, str.length(), (j - this.pl[i]) / 2 + i1, f1, localTextPaint);
            f1 += f2;
            i += 1;
            continue;
            i = 0;
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    eic();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = kw(paramInt2);
    paramInt2 = aX(paramInt1, i);
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (j == -2147483648) {
      paramInt1 = Math.min(paramInt2, paramInt1);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, i);
      return;
      if (j != 1073741824) {
        paramInt1 = paramInt2;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int m = paramMotionEvent.getAction();
    int[] arrayOfInt;
    Drawable localDrawable;
    float f2;
    int i;
    int j;
    if (m == 0)
    {
      this.bRZ = true;
      arrayOfInt = new int[1];
      arrayOfInt[0] = 16842919;
      if (this.gf != null)
      {
        this.gf.setState(arrayOfInt);
        this.gf.invalidateSelf();
      }
      if (this.gg != null)
      {
        this.gg.setState(arrayOfInt);
        this.gg.invalidateSelf();
      }
      localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        localDrawable.invalidateSelf();
        if ((m != 0) && (m != 2) && (m != 1)) {
          break label425;
        }
        f2 = paramMotionEvent.getY();
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$a == null) || (f2 < 0.0F)) {
          break label419;
        }
        i = getHeight() - getPaddingTop() - getPaddingBottom();
        j = h(this.pk);
        if (i <= j) {
          break label433;
        }
      }
    }
    label419:
    label425:
    label433:
    for (float f1 = (i - j) * 1.0F / (this.k.length - 1);; f1 = 0.0F)
    {
      j = -1;
      for (;;)
      {
        i = j;
        if (f2 < 0.0F) {
          break;
        }
        j += 1;
        i = j;
        if (j >= this.pk.length) {
          break;
        }
        f2 -= this.pk[j] + f1;
      }
      QLog.e("IndexView", 1, "getBackground: failed. ");
      break;
      if ((m != 3) && (m != 1)) {
        break;
      }
      this.bRZ = false;
      arrayOfInt = new int[0];
      if (this.gf != null)
      {
        this.gf.setState(arrayOfInt);
        this.gf.invalidateSelf();
      }
      if (this.gg != null)
      {
        this.gg.setState(arrayOfInt);
        this.gg.invalidateSelf();
      }
      localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setState(arrayOfInt);
        localDrawable.invalidateSelf();
        break;
      }
      QLog.e("IndexView", 1, "getBackground: failed. ");
      break;
      j = i;
      if (i >= this.pk.length) {
        j = this.pk.length - 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$a.O(this.k[j]);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$b.cs(this.k[j], m);
      }
      bool = true;
      do
      {
        return bool;
      } while (m != 3);
      return true;
    }
  }
  
  public void setIndex(String[] paramArrayOfString)
  {
    if ("$".equals(paramArrayOfString[0]))
    {
      this.dak = true;
      this.gf = getResources().getDrawable(2130841160);
      this.cU = new Rect();
    }
    if (this.dal)
    {
      this.gg = getResources().getDrawable(2130841159);
      this.cV = new Rect();
    }
    this.k = paramArrayOfString;
    this.pk = new int[paramArrayOfString.length];
    this.pl = new int[paramArrayOfString.length];
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = 0;
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean)
    {
      arrayOfString = new String[paramArrayOfString.length + 1];
      arrayOfString[0] = "$";
      while (i < paramArrayOfString.length)
      {
        arrayOfString[(i + 1)] = paramArrayOfString[i];
        i += 1;
      }
    }
    setIndex(arrayOfString);
  }
  
  public void setIndex(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = 0;
    int m = 0;
    int i = 0;
    String[] arrayOfString = paramArrayOfString;
    if (paramBoolean1)
    {
      this.dal = paramBoolean2;
      this.dam = paramBoolean3;
      if ((!paramBoolean2) || (!paramBoolean3)) {
        break label105;
      }
      arrayOfString = new String[paramArrayOfString.length + 3];
      arrayOfString[0] = "$";
      while (i < paramArrayOfString.length)
      {
        arrayOfString[(i + 1)] = paramArrayOfString[i];
        i += 1;
      }
      arrayOfString[(i + 1)] = "&";
      arrayOfString[(i + 2)] = "+";
    }
    for (;;)
    {
      setIndex(arrayOfString);
      return;
      label105:
      if ((paramBoolean2) || (paramBoolean3))
      {
        arrayOfString = new String[paramArrayOfString.length + 2];
        arrayOfString[0] = "$";
        i = j;
        while (i < paramArrayOfString.length)
        {
          arrayOfString[(i + 1)] = paramArrayOfString[i];
          i += 1;
        }
        if (paramBoolean2) {
          arrayOfString[(i + 1)] = "&";
        }
        for (;;)
        {
          break;
          arrayOfString[(i + 1)] = "+";
        }
      }
      arrayOfString = new String[paramArrayOfString.length + 1];
      arrayOfString[0] = "$";
      i = m;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[(i + 1)] = paramArrayOfString[i];
        i += 1;
      }
    }
  }
  
  public void setOnIndexChangedListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$a = parama;
  }
  
  public void setOnIndexChangedListener2(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView$b = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void O(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void cs(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IndexView
 * JD-Core Version:    0.7.0.1
 */