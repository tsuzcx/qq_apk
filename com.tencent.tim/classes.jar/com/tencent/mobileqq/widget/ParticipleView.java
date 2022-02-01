package com.tencent.mobileqq.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import anot;
import aofk;
import aofk.a;
import argq;
import argr;
import args;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import wja;

public class ParticipleView
  extends View
{
  private static final int egY = Color.parseColor("#00CAFC");
  private static final int egZ = Color.parseColor("#FFFFFF");
  private static final int eha = Color.parseColor("#FFFFFF");
  private static final int ehb = Color.parseColor("#03081A");
  private float BL;
  private List<b> Jm = new ArrayList();
  private final List<b> Jn = new ArrayList();
  private Point L = new Point(0, 0);
  private a jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$a;
  private b jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b;
  private c jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$c;
  private ValueAnimator aP;
  private long aQ;
  private byte aY = 0;
  private RectF bj;
  private RectF bk;
  private Paint cE;
  private Paint cF;
  private boolean daA;
  private boolean dax;
  private boolean day;
  private boolean daz;
  private int dfU;
  private float downX;
  private float downY;
  private int dyf;
  private int egX;
  private int ehc;
  private int ehd;
  private int ehe;
  private int ehf;
  private int ehg;
  private int ehh;
  private int ehi;
  private int ehj;
  private int ehk;
  private int ehl = 0;
  private int ehm = 0;
  private ScrollView i;
  private int mMeasuredWidth;
  private Paint mTextPaint;
  private int mTextSize;
  private int mTouchSlop;
  
  public ParticipleView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ParticipleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public ParticipleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private int MH()
  {
    bx(null);
    return this.dfU;
  }
  
  public static boolean X(String paramString)
  {
    boolean bool2 = false;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < paramString.length())
      {
        int k = paramString.charAt(j);
        if ((19968 <= k) && (k < 40869)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      j += 1;
    }
  }
  
  private int a(aofk paramaofk)
  {
    int k = 0;
    int i2 = paramaofk.mSpanCount;
    String str = paramaofk.toString();
    int n;
    int j;
    int m;
    if (i2 > 0)
    {
      paramaofk = paramaofk.ac();
      n = 0;
      j = 0;
      m = 0;
      if (n < i2) {
        if (k <= 0) {
          break label169;
        }
      }
    }
    for (;;)
    {
      m = paramaofk[(n * 3)];
      int i1 = paramaofk[(n * 3 + 1)];
      float f;
      if (m > k)
      {
        f = j;
        j = (int)(this.mTextPaint.measureText(str.substring(k, m)) + f);
      }
      for (;;)
      {
        j = this.mTextSize + j;
        n += 1;
        m = k;
        k = i1;
        break;
        m = j;
        if (k < str.length())
        {
          f = j;
          m = (int)(this.mTextPaint.measureText(str.substring(k)) + f);
        }
        return m;
        return (int)this.mTextPaint.measureText(str);
      }
      label169:
      k = m;
    }
  }
  
  private void a(int paramInt1, int paramInt2, aofk paramaofk, b paramb, Canvas paramCanvas)
  {
    int k = a(paramaofk);
    if (getWidth() <= 0)
    {
      j = this.mMeasuredWidth;
      if (k + paramInt1 + this.ehd * 2 + getPaddingRight() <= j) {
        break label193;
      }
      if (getPaddingLeft() + getPaddingRight() + k + this.ehd * 2 > j) {
        break label175;
      }
    }
    label175:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        break label181;
      }
      paramInt1 = getPaddingLeft();
      j = this.mTextSize;
      int m = this.ehe;
      c(paramInt1, this.ehc * 2 + (j + paramInt2 + m), paramaofk, paramb, paramCanvas);
      this.L.x = (getPaddingLeft() + k + this.ehd * 2 + this.ehf);
      this.L.y = (this.mTextSize + paramInt2 + this.ehe + this.ehc * 2);
      return;
      j = getWidth();
      break;
    }
    label181:
    b(paramInt1, paramInt2, paramaofk, paramb, paramCanvas);
    return;
    label193:
    c(paramInt1, paramInt2, paramaofk, paramb, paramCanvas);
    this.L.x = (paramInt1 + k + this.ehf + this.ehd * 2);
  }
  
  private void a(Canvas paramCanvas, b paramb)
  {
    if (b.a(paramb).isEmpty()) {
      a(this.L.x, this.L.y, paramb.c, paramb, paramCanvas);
    }
    for (;;)
    {
      return;
      int k = b.a(paramb).size();
      int j = 0;
      while (j < k)
      {
        RectF localRectF = (RectF)b.a(paramb).get(j);
        a(localRectF, (aofk)b.b(paramb).get(j), paramb, paramCanvas);
        this.L.x = ((int)localRectF.right + this.ehf);
        this.L.y = ((int)localRectF.top);
        j += 1;
      }
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2)
  {
    boolean bool2 = true;
    if ((paramRectF1 == null) || (paramRectF2 == null) || (paramRectF1 == paramRectF2)) {}
    while ((this.Jm == null) || (this.Jm.size() <= 0)) {
      return;
    }
    int j;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    label103:
    label124:
    boolean bool1;
    if (a(paramRectF1, paramRectF2))
    {
      j = 2;
      localObject1 = paramRectF2;
      localObject2 = paramRectF1;
      if ((!a((RectF)localObject2, this.bk)) || (!a(this.bk, (RectF)localObject1))) {
        break label196;
      }
      if (j != 2) {
        break label174;
      }
      localObject4 = this.bk;
      localObject3 = this.bk;
      paramRectF1 = (RectF)localObject1;
      localObject1 = localObject4;
      this.dax = b.b(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b);
      localObject4 = paramRectF1;
      paramRectF1 = (RectF)localObject2;
      localObject2 = localObject4;
      this.ehm = j;
      if (!paramRectF2.equals(this.bk)) {
        break label301;
      }
      if (j == 1) {
        break label295;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      a(paramRectF1, (RectF)localObject1, (RectF)localObject3, (RectF)localObject2, bool1);
      return;
      j = 1;
      localObject1 = paramRectF1;
      localObject2 = paramRectF2;
      break;
      label174:
      localObject4 = this.bk;
      paramRectF1 = this.bk;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break label103;
      label196:
      if (paramRectF1.equals(this.bk))
      {
        this.dax = b.b(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b);
        paramRectF1 = null;
        localObject4 = localObject1;
        localObject1 = null;
        localObject3 = localObject2;
        localObject2 = localObject4;
        break label124;
      }
      if ((this.ehm != 0) && (this.ehm != j)) {
        if (this.dax) {
          break label289;
        }
      }
      label289:
      for (bool1 = true;; bool1 = false)
      {
        this.dax = bool1;
        paramRectF1 = null;
        localObject4 = localObject1;
        localObject1 = null;
        localObject3 = localObject2;
        localObject2 = localObject4;
        break;
      }
      label295:
      bool1 = false;
      continue;
      label301:
      bool1 = bool2;
      if (a(this.bk, paramRectF2)) {
        bool1 = false;
      }
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramRectF4, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int k = this.Jm.size();
    int j = 0;
    while (j < k)
    {
      b localb = (b)this.Jm.get(j);
      Iterator localIterator = b.a(localb).iterator();
      while (localIterator.hasNext())
      {
        RectF localRectF = (RectF)localIterator.next();
        if ((paramRectF1 != null) && (paramRectF2 != null) && (!localRectF.equals(paramRectF3)) && (!localRectF.equals(paramRectF4)) && (((a(paramRectF1, localRectF)) && (a(localRectF, paramRectF2))) || (localRectF.equals(paramRectF2)) || (localRectF.equals(paramRectF1))))
        {
          if (this.daz)
          {
            if (b.b(localb)) {
              b.a(localb, false);
            }
          }
          else
          {
            if (!this.dax) {}
            for (boolean bool = true;; bool = false)
            {
              b.a(localb, bool);
              break;
            }
          }
        }
        else
        {
          if (paramRectF3.top >= localRectF.top)
          {
            if (paramRectF3.top != localRectF.top) {
              continue;
            }
            if (paramBoolean) {
              if (paramRectF3.left > localRectF.left) {
                continue;
              }
            }
          }
          else
          {
            label241:
            if (localRectF.top >= paramRectF4.top)
            {
              if (localRectF.top != paramRectF4.top) {
                continue;
              }
              if (!paramBoolean) {
                break label329;
              }
              if (localRectF.left >= paramRectF4.left) {
                continue;
              }
            }
          }
          for (;;)
          {
            if (!this.daz) {
              break label346;
            }
            if (!b.b(localb)) {
              break;
            }
            b.a(localb, false);
            break;
            if (paramRectF3.left >= localRectF.left) {
              break;
            }
            break label241;
            label329:
            if (localRectF.left > paramRectF4.left) {
              break;
            }
          }
          label346:
          if (this.dax)
          {
            if (!b.b(localb))
            {
              b.a(localb, true);
              b.a(localb, System.currentTimeMillis());
              localArrayList.add(localb);
            }
          }
          else if (b.b(localb)) {
            b.a(localb, false);
          }
        }
      }
      j += 1;
    }
    ng(localArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$a.eih();
    }
  }
  
  private void a(RectF paramRectF, aofk paramaofk, b paramb, Canvas paramCanvas)
  {
    int k = (int)paramRectF.bottom;
    int m = (int)paramRectF.left;
    int n = (int)paramRectF.top;
    int j = (int)paramRectF.right;
    float f1;
    float f2;
    float f3;
    if (paramCanvas != null)
    {
      j = j - m - this.ehd * 2;
      f1 = 0.0F;
      f2 = 0.0F;
      if (!b.b(paramb)) {
        break label271;
      }
      if (b.a(paramb) >= 0.0F) {
        f2 = b.a(paramb);
      }
      f1 = 1.0F;
      if (f2 < 1.0F)
      {
        f3 = m;
        int i1 = (int)(f1 * (this.ehd * 2 + j) + f3);
        paramCanvas.drawRoundRect(new RectF(m, n, i1, k), this.ehg, this.ehg, this.cE);
      }
      if (f2 > 0.0F)
      {
        if (this.ehl != 4) {
          break label300;
        }
        f1 = m;
        j = (int)(f2 * (j + this.ehd * 2) + f1);
        paramCanvas.drawRoundRect(new RectF(m, n, j, k), this.ehg, this.ehg, this.cF);
      }
      label224:
      paramRectF = this.mTextPaint;
      if (!b.b(paramb)) {
        break label373;
      }
    }
    label271:
    label300:
    label373:
    for (j = this.dyf;; j = this.ehj)
    {
      paramRectF.setColor(j);
      a(paramaofk, paramCanvas, this.ehd + m, n);
      this.dfU = k;
      return;
      f3 = 0.0F;
      f2 = f3;
      if (this.BL < 0.0F) {
        break;
      }
      f1 = this.BL;
      f2 = f3;
      break;
      f1 = m;
      paramCanvas.drawRoundRect(new RectF((int)((1.0F - f2) * (this.ehd * 2 + j) + f1), n, j + m + this.ehd * 2, k), this.ehg, this.ehg, this.cF);
      break label224;
    }
  }
  
  private void a(aofk paramaofk, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = 0;
    String str = paramaofk.toString();
    int[] arrayOfInt;
    Object[] arrayOfObject;
    int m;
    int k;
    if (paramaofk.mSpanCount > 0)
    {
      arrayOfInt = paramaofk.ac();
      arrayOfObject = paramaofk.mSpans;
      m = 0;
      k = 0;
      if (m < paramaofk.mSpanCount)
      {
        if (k <= 0) {
          break label285;
        }
        j = k;
      }
    }
    label285:
    for (;;)
    {
      int i1 = arrayOfInt[(m * 3)];
      int n = arrayOfInt[(m * 3 + 1)];
      k = paramInt1;
      if (i1 > j)
      {
        localObject = str.substring(j, i1);
        paramCanvas.drawText((String)localObject, paramInt1, this.mTextSize + paramInt2, this.mTextPaint);
        float f = paramInt1;
        k = (int)(this.mTextPaint.measureText((String)localObject) + f);
      }
      Object localObject = arrayOfObject[m];
      paramInt1 = k;
      if ((localObject instanceof aofk.a))
      {
        localObject = ((aofk.a)localObject).getDrawable();
        paramInt1 = k;
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(k, this.ehc + paramInt2, this.mTextSize + k, this.ehc + paramInt2 + this.mTextSize);
          ((Drawable)localObject).draw(paramCanvas);
          paramInt1 = k + this.mTextSize;
        }
      }
      m += 1;
      k = n;
      break;
      if (k < str.length()) {
        paramCanvas.drawText(str.substring(k), paramInt1, this.mTextSize + paramInt2, this.mTextPaint);
      }
      return;
      paramCanvas.drawText(str, paramInt1, this.mTextSize + paramInt2, this.mTextPaint);
      return;
    }
  }
  
  private void a(b paramb)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramb);
    nh(localArrayList);
  }
  
  private boolean a(RectF paramRectF1, RectF paramRectF2)
  {
    return (paramRectF1.top < paramRectF2.top) || ((paramRectF1.top == paramRectF2.top) && (paramRectF1.left < paramRectF2.left));
  }
  
  private boolean a(b paramb)
  {
    if ((this.day) && (!b.a(paramb).isEmpty()))
    {
      iB(this);
      if (this.i != null)
      {
        paramb = b.a(paramb).iterator();
        while (paramb.hasNext())
        {
          int j = (int)((RectF)paramb.next()).top;
          if ((this.mTextSize + j + this.ehc * 2 - this.i.getScrollY() > 0) && (j - this.i.getScrollY() < this.i.getHeight())) {}
          for (j = 1; j != 0; j = 0) {
            return true;
          }
        }
        return false;
      }
    }
    return true;
  }
  
  private void addItem(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new aofk(paramString, 3);
      this.Jm.add(new b(paramString, null));
    }
  }
  
  private void ae(MotionEvent paramMotionEvent)
  {
    int k = (int)paramMotionEvent.getX();
    int m = (int)paramMotionEvent.getY();
    if ((this.Jm != null) && (this.Jm.size() > 0))
    {
      int n = this.Jm.size();
      int j = 0;
      while (j < n)
      {
        b localb = (b)this.Jm.get(j);
        Iterator localIterator = b.a(localb).iterator();
        while (localIterator.hasNext())
        {
          RectF localRectF2 = (RectF)localIterator.next();
          RectF localRectF1 = null;
          if (localRectF2.contains(k, m)) {
            localRectF1 = localRectF2;
          }
          if (localRectF1 != null) {
            if (paramMotionEvent.getAction() == 0)
            {
              this.bj = localRectF2;
              this.bk = localRectF2;
              this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b = localb;
            }
            else if (paramMotionEvent.getAction() == 2)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b == null)
              {
                this.bj = localRectF2;
                this.bk = localRectF2;
                this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b = localb;
                eil();
              }
              else if (!localRectF1.equals(this.bj))
              {
                a(this.bj, localRectF1);
                this.bj = localRectF1;
              }
            }
          }
        }
        j += 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, aofk paramaofk, b paramb, Canvas paramCanvas)
  {
    int m;
    int j;
    String str3;
    int i6;
    int i2;
    label79:
    String str1;
    if (getWidth() <= 0)
    {
      m = this.mMeasuredWidth;
      int i5 = paramaofk.mSpanCount;
      int[] arrayOfInt = paramaofk.ac();
      int n = 0;
      j = 0;
      int k = 0;
      if (i5 > 0)
      {
        j = arrayOfInt[0];
        k = arrayOfInt[1];
      }
      str3 = paramaofk.toString();
      i6 = str3.length();
      i2 = 0;
      int i1 = k;
      k = j;
      j = i2;
      if (j >= i6) {
        break label407;
      }
      if ((i5 <= 0) || (n >= i5) || (k != j)) {
        break label304;
      }
      String str2 = str3.substring(0, i1);
      int i3 = i1 - 1;
      int i4 = n + 1;
      str1 = str2;
      i2 = i3;
      n = i4;
      if (i4 < i5)
      {
        k = arrayOfInt[(i4 * 3)];
        i1 = arrayOfInt[(i4 * 3 + 1)];
        n = i4;
        i2 = i3;
        str1 = str2;
      }
      label178:
      if (a(new aofk(str1, 3)) + paramInt1 + this.ehd * 2 + getPaddingRight() <= m) {
        break label398;
      }
      this.L.x = getPaddingLeft();
      this.L.y = (this.mTextSize + paramInt2 + this.ehe + this.ehc * 2);
      if (j > 0) {
        break label323;
      }
      a(this.L.x, this.L.y, paramaofk, paramb, paramCanvas);
      j = 1;
    }
    for (;;)
    {
      if (j == 0) {
        a(paramInt1, paramInt2, paramaofk, paramb, paramCanvas);
      }
      return;
      m = getWidth();
      break;
      label304:
      str1 = str3.substring(0, j + 1);
      i2 = j;
      break label178;
      label323:
      c(paramInt1, paramInt2, new aofk(str3.substring(0, j), 3), paramb, paramCanvas);
      str1 = str3.substring(j, i6);
      a(this.L.x, this.L.y, new aofk(str1, 3), paramb, paramCanvas);
      j = 1;
      continue;
      label398:
      j = i2 + 1;
      break label79;
      label407:
      j = 0;
    }
  }
  
  private void bx(Canvas paramCanvas)
  {
    this.L.x = getPaddingLeft();
    this.L.y = getPaddingTop();
    if ((this.Jm != null) && (this.Jm.size() > 0))
    {
      int k = this.Jm.size();
      int j = 0;
      while (j < k)
      {
        b localb = (b)this.Jm.get(j);
        if ((paramCanvas == null) || (a(localb))) {
          a(paramCanvas, localb);
        }
        j += 1;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, aofk paramaofk, b paramb, Canvas paramCanvas)
  {
    int j = this.mTextSize;
    int k = this.ehc;
    int m = a(paramaofk);
    int n = this.ehd;
    RectF localRectF = new RectF(paramInt1, paramInt2, m + n * 2 + paramInt1, j + paramInt2 + k * 2);
    b.a(paramb, localRectF, paramaofk);
    a(localRectF, paramaofk, paramb, paramCanvas);
  }
  
  private void eii()
  {
    anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A359", "0X800A359", 0, 0, "", "", "", "");
  }
  
  private void eij()
  {
    eil();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b != null) && (b.b(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b))) {
      anot.a(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A358", "0X800A358", 0, 0, "", "", "", "");
    }
  }
  
  private void eik()
  {
    eil();
  }
  
  private void eil()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b != null)
    {
      this.daz = b.b(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b);
      if (!b.b(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b)) {
        break label63;
      }
      b.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b, false);
      this.dax = false;
      invalidate();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$a.eih();
      }
      return;
      label63:
      b.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b, true);
      this.dax = true;
      b.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b, System.currentTimeMillis());
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b);
    }
  }
  
  private int g(float paramFloat1, float paramFloat2)
  {
    if ((this.Jm != null) && (this.Jm.size() > 0))
    {
      int j = 0;
      int k = this.Jm.size();
      while (j < k)
      {
        Iterator localIterator = b.a((b)this.Jm.get(j)).iterator();
        while (localIterator.hasNext()) {
          if (((RectF)localIterator.next()).contains(paramFloat1, paramFloat2)) {
            return j;
          }
        }
        j += 1;
      }
    }
    return -1;
  }
  
  private void iB(View paramView)
  {
    if (this.i != null) {}
    while (paramView == null) {
      return;
    }
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ScrollView))
    {
      this.i = ((ScrollView)paramView);
      return;
    }
    iB(paramView);
  }
  
  private void init()
  {
    init(null, null);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rk);
      this.ehh = paramAttributeSet.getColor(9, egY);
      this.ehi = paramAttributeSet.getColor(10, egZ);
      this.ehg = paramAttributeSet.getDimensionPixelSize(3, wja.dp2px(3.0F, getResources()));
      this.dyf = paramAttributeSet.getColor(4, eha);
      this.ehj = paramAttributeSet.getColor(8, ehb);
      this.mTextSize = paramAttributeSet.getDimensionPixelSize(6, wja.dp2px(27.0F, getResources()));
      this.ehc = paramAttributeSet.getDimensionPixelSize(7, wja.dp2px(4.0F, getResources()));
      this.ehd = paramAttributeSet.getDimensionPixelSize(5, wja.dp2px(6.0F, getResources()));
      this.ehe = paramAttributeSet.getDimensionPixelSize(11, wja.dp2px(12.0F, getResources()));
      this.ehf = paramAttributeSet.getDimensionPixelSize(2, wja.dp2px(8.0F, getResources()));
      this.egX = paramAttributeSet.getInteger(0, 200);
      this.ehk = paramAttributeSet.getInteger(1, 200);
      paramAttributeSet.recycle();
    }
    this.mTextPaint = new Paint(1);
    this.mTextPaint.setTextSize(this.mTextSize);
    this.cE = new Paint(1);
    this.cE.setColor(this.ehi);
    this.cF = new Paint(1);
    this.cF.setColor(this.ehh);
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$c = new c(this, null);
    ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$c);
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void ng(List<b> paramList)
  {
    if (paramList.size() > 0)
    {
      nh(paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "doAnimationAfterSelectAmong invalidate()");
    }
    invalidate();
  }
  
  private void nh(List<b> paramList)
  {
    this.Jn.addAll(paramList);
    if (this.aP == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "selectedAnimation create");
      }
      this.aP = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.aP.setDuration(this.ehk);
      this.aP.setRepeatCount(-1);
      this.aP.addUpdateListener(new argq(this));
      this.aP.start();
    }
  }
  
  public String CS()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.Jm != null) && (this.Jm.size() > 0))
    {
      int k = this.Jm.size();
      int j = 0;
      while (j < k)
      {
        Object localObject = (b)this.Jm.get(j);
        if (b.b((b)localObject))
        {
          localObject = ((b)localObject).c.toString();
          boolean bool = X((String)localObject);
          if ((localStringBuilder.length() > 0) && ((this.daA != bool) || (!this.daA))) {
            localStringBuilder.append(" ");
          }
          this.daA = X((String)localObject);
          localStringBuilder.append((String)localObject);
        }
        j += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.enableTalkBack) && (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$c != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$c.dispatchHoverEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public void eim()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "translateAppearAnimation invalidate()");
    }
    setAlpha(0.0F);
    setVisibility(0);
    this.BL = 0.0F;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(this.egX);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new argr(this));
    localValueAnimator.setDuration(this.ehk);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new args(this));
    localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator, localValueAnimator });
    localAnimatorSet.start();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    bx(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    this.mMeasuredWidth = k;
    int j = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      if (paramInt1 <= 0) {
        break label60;
      }
    }
    for (;;)
    {
      setMeasuredDimension(k, paramInt1);
      return;
      paramInt1 = MH();
      break;
      label60:
      paramInt1 = j;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return super.onTouchEvent(paramMotionEvent);
        this.aY = 0;
        this.aQ = System.currentTimeMillis();
        this.day = false;
        this.downX = paramMotionEvent.getX();
        this.downY = paramMotionEvent.getY();
        if (QLog.isColorLevel()) {
          QLog.d("ParticipleView", 2, "onTouchEvent ACTION_DOWN  downX -> " + this.downX + ", downY -> " + this.downY);
        }
        ae(paramMotionEvent);
        return true;
        float f1 = (int)paramMotionEvent.getX();
        float f3 = (int)paramMotionEvent.getY();
        if (this.aY == 0)
        {
          float f2 = Math.abs(f1 - this.downX);
          f3 = Math.abs(f3 - this.downY);
          if ((f2 > this.mTouchSlop) || (f3 > this.mTouchSlop))
          {
            if (f3 <= f2) {
              break label217;
            }
            this.aY = 2;
          }
        }
        if (this.aY == 0)
        {
          return true;
          this.aY = 1;
          eii();
          eil();
          if (f1 - this.downX > 0.0F) {}
          for (int j = 4;; j = 3)
          {
            this.ehl = j;
            break;
          }
        }
        this.day = true;
      } while (this.aY != 1);
      getParent().requestDisallowInterceptTouchEvent(true);
      ae(paramMotionEvent);
      return true;
    case 1: 
      label217:
      if (!this.day)
      {
        if (System.currentTimeMillis() - this.aQ < 500L) {
          break label368;
        }
        eik();
      }
      break;
    }
    for (;;)
    {
      this.aY = 0;
      this.bj = null;
      this.bk = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$b = null;
      this.ehm = 0;
      this.day = false;
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "ACTION_UP invalidate()");
      }
      invalidate();
      break;
      label368:
      eij();
    }
  }
  
  public void resetState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "resetState invalidate()");
    }
    if ((this.Jm != null) && (this.Jm.size() > 0))
    {
      int k = this.Jm.size();
      int j = 0;
      while (j < k)
      {
        b.a((b)this.Jm.get(j), false);
        iB(this);
        if (this.i != null) {
          this.i.scrollTo(0, 0);
        }
        j += 1;
      }
    }
    invalidate();
  }
  
  public void setOnParticipleSelectChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleView$a = parama;
  }
  
  public void setParticipleItems(List<String> paramList)
  {
    int j;
    if ((paramList == null) || (paramList.size() != this.Jm.size())) {
      j = 0;
    }
    for (;;)
    {
      if (j == 0)
      {
        if ((paramList != null) && (paramList.size() > 0))
        {
          this.Jm.clear();
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            addItem((String)paramList.next());
          }
          int k = paramList.size();
          j = 0;
          for (;;)
          {
            if (j >= k) {
              break label148;
            }
            if (!TextUtils.equals((CharSequence)paramList.get(j), ((b)this.Jm.get(j)).c.toString()))
            {
              j = 0;
              break;
            }
            j += 1;
          }
        }
      }
      else {
        resetState();
      }
      return;
      label148:
      j = 1;
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextPaint.setColor(paramInt);
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void eih();
  }
  
  public static final class b
  {
    private float BM;
    private List<RectF> Jo = new ArrayList();
    private List<aofk> Jp = new ArrayList();
    private long avE;
    aofk c;
    private boolean isSelected;
    
    private b(aofk paramaofk)
    {
      this.c = paramaofk;
    }
    
    private void a(RectF paramRectF, aofk paramaofk)
    {
      if (this.Jo.size() > 0)
      {
        Iterator localIterator = this.Jo.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!paramRectF.equals((RectF)localIterator.next()));
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.Jo.add(paramRectF);
          this.Jp.add(paramaofk);
        }
        return;
      }
    }
  }
  
  static final class c
    extends ExploreByTouchHelper
  {
    private WeakReference<View> mView;
    
    private c(View paramView)
    {
      super();
      this.mView = new WeakReference(paramView);
    }
    
    public int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      View localView = (View)this.mView.get();
      if ((localView instanceof ParticipleView))
      {
        int i = ParticipleView.a((ParticipleView)localView, paramFloat1, paramFloat2);
        if (i >= 0) {
          return i;
        }
      }
      return -2147483648;
    }
    
    public void getVisibleVirtualViews(List<Integer> paramList)
    {
      Object localObject = (View)this.mView.get();
      if ((localObject instanceof ParticipleView))
      {
        localObject = ParticipleView.b((ParticipleView)localObject);
        int i = 0;
        int j = ((List)localObject).size();
        while (i < j)
        {
          paramList.add(Integer.valueOf(i));
          i += 1;
        }
      }
    }
    
    public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (paramInt2 == 16)
      {
        paramBundle = (View)this.mView.get();
        if ((paramBundle instanceof ParticipleView))
        {
          paramBundle = ParticipleView.a((ParticipleView)paramBundle);
          if (paramBundle != null)
          {
            paramBundle.invalidateVirtualView(paramInt1);
            paramBundle.sendEventForVirtualView(paramInt1, 1);
          }
        }
        return true;
      }
      return false;
    }
    
    public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
    {
      Object localObject = (View)this.mView.get();
      if ((localObject instanceof ParticipleView))
      {
        localObject = ParticipleView.b((ParticipleView)localObject);
        if (paramInt < ((List)localObject).size()) {
          paramAccessibilityEvent.setContentDescription(((ParticipleView.b)((List)localObject).get(paramInt)).c.AE());
        }
      }
    }
    
    public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      Object localObject = (View)this.mView.get();
      if ((localObject instanceof ParticipleView))
      {
        localObject = ParticipleView.b((ParticipleView)localObject);
        if ((paramInt < ((List)localObject).size()) && (paramInt != -2147483648))
        {
          localObject = (ParticipleView.b)((List)localObject).get(paramInt);
          if (ParticipleView.b.a((ParticipleView.b)localObject).size() > 0)
          {
            RectF localRectF = (RectF)ParticipleView.b.a((ParticipleView.b)localObject).get(0);
            paramAccessibilityNodeInfoCompat.setContentDescription(((ParticipleView.b)localObject).c.AE());
            paramAccessibilityNodeInfoCompat.addAction(16);
            paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleView
 * JD-Core Version:    0.7.0.1
 */