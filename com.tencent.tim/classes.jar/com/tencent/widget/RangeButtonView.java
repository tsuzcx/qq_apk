package com.tencent.widget;

import acfp;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import atau.a;
import com.tencent.common.config.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangeButtonView
  extends View
{
  private List<e> Lk;
  private List<String> Ll;
  b jdField_a_of_type_ComTencentWidgetRangeButtonView$b = new b();
  private c jdField_a_of_type_ComTencentWidgetRangeButtonView$c;
  private d jdField_a_of_type_ComTencentWidgetRangeButtonView$d;
  private f jdField_a_of_type_ComTencentWidgetRangeButtonView$f;
  private g jdField_a_of_type_ComTencentWidgetRangeButtonView$g;
  private int currentPosition;
  private a d;
  private TextPaint e;
  private Bitmap ha;
  
  public RangeButtonView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RangeButtonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public RangeButtonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rB, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CW = paramContext.getDimension(0, dp2px(26.0F));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CX = paramContext.getDimension(1, dp2px(26.0F));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.Da = paramContext.getDimension(8, dp2px(8.0F));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.titleColor = paramContext.getColor(7, 17170446);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CY = paramContext.getDimension(4, dp2px(24.0F));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.euo = paramContext.getColor(2, 17170446);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.lineHeight = paramContext.getDimension(3, dp2px(8.0F));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CZ = paramContext.getDimension(5, dp2px(1.0F));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.euq = paramContext.getResourceId(6, 2130846111);
    paramContext.recycle();
    this.e = new TextPaint();
    this.e.setAntiAlias(true);
    this.ha = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.euq);
    if (AppSetting.enableTalkBack)
    {
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$c = new c(this);
      ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComTencentWidgetRangeButtonView$c);
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  private float bQ()
  {
    int i;
    if (this.Lk != null)
    {
      TextPaint localTextPaint = new TextPaint();
      i = 0;
      Iterator localIterator = this.Lk.iterator();
      if (localIterator.hasNext())
      {
        localTextPaint.setTextSize(((e)localIterator.next()).textSize);
        Paint.FontMetrics localFontMetrics = localTextPaint.getFontMetrics();
        if (i - Math.abs(localFontMetrics.top) >= 0.0F) {
          break label97;
        }
        i = (int)Math.abs(localFontMetrics.top);
      }
    }
    label97:
    for (;;)
    {
      break;
      return i;
      return dp2px(120.0F);
    }
  }
  
  private float bR()
  {
    float f2 = bQ();
    float f3 = this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CY;
    float f4 = this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.lineHeight;
    if (this.ha != null) {}
    for (float f1 = this.ha.getHeight();; f1 = 0.0F) {
      return Math.max(f4, f1) + (f3 + f2);
    }
  }
  
  public static float c(String paramString, float paramFloat)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(paramFloat);
    return localTextPaint.measureText(paramString);
  }
  
  private int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.ew();
    int i = 0;
    while (i < localArrayList.size())
    {
      Point localPoint = (Point)localArrayList.get(i);
      int j = localPoint.y;
      int k = localPoint.y;
      if ((paramInt2 < j - paramInt4) || (paramInt2 > k + paramInt4)) {
        paramInt1 = -1;
      }
      do
      {
        return paramInt1;
        j = localPoint.x;
        k = localPoint.x;
        if ((paramInt1 <= j - paramInt3) || (paramInt1 >= k + paramInt3)) {
          break;
        }
        paramInt1 = i;
      } while (!paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$d.lc(localPoint.x, localPoint.y);
      return i;
      i += 1;
    }
    return -1;
  }
  
  private float dp2px(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  @TargetApi(14)
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.enableTalkBack) && (this.jdField_a_of_type_ComTencentWidgetRangeButtonView$c.dispatchHoverEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentWidgetRangeButtonView$f == null)
    {
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.eup = this.Lk.size();
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g = new g((int)(getPaddingLeft() + this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CW), (int)(getWidth() - this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CX - getPaddingRight()), (int)(this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.Da + this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.CY + bQ()), this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.eup);
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.setHeight(this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.lineHeight);
      Object localObject2 = this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.ew();
      Object localObject1 = new ArrayList(((ArrayList)localObject2).size());
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(((Point)((Iterator)localObject2).next()).x));
      }
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$f = new f(this.Lk);
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$f.I((ArrayList)localObject1, (int)(this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.Da + bQ()));
      localObject1 = (Point)this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.ew().get(this.currentPosition);
      this.jdField_a_of_type_ComTencentWidgetRangeButtonView$d = new d(((Point)localObject1).x, ((Point)localObject1).y, this.ha);
    }
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$f.a(paramCanvas, this.e);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.b(paramCanvas, this.e, this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$d.draw(paramCanvas, this.e);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = (int)bR();
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == -2147483648)
    {
      paramInt2 = i;
      if (k != -2147483648) {
        break label76;
      }
      paramInt1 = Math.min(j, paramInt1);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = i;
      if (m == 1073741824) {
        break;
      }
      paramInt2 = 0;
      break;
      label76:
      if (k != 1073741824) {
        paramInt1 = (int)(getPaddingTop() + j + this.jdField_a_of_type_ComTencentWidgetRangeButtonView$b.Da);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    do
    {
      return true;
      if ((this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g == null) || (this.jdField_a_of_type_ComTencentWidgetRangeButtonView$d == null)) {
        return false;
      }
      i = c((int)f1, (int)f2, this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.OV() / 2, this.jdField_a_of_type_ComTencentWidgetRangeButtonView$d.OU() / 2, true);
    } while ((i == this.currentPosition) || (i == -1));
    if (this.d != null) {
      this.d.dy(this.currentPosition, i);
    }
    this.currentPosition = i;
    invalidate();
    return true;
  }
  
  public void setContentDescList(List<String> paramList)
  {
    this.Ll = paramList;
  }
  
  public void setOnChangerListener(a parama)
  {
    this.d = parama;
  }
  
  public void setThumbPosition(int paramInt)
  {
    this.currentPosition = paramInt;
    if (this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g == null) {
      return;
    }
    Point localPoint = (Point)this.jdField_a_of_type_ComTencentWidgetRangeButtonView$g.ew().get(paramInt);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView$d.lc(localPoint.x, localPoint.y);
    invalidate();
  }
  
  public void setTitleData(List<e> paramList)
  {
    this.Lk = paramList;
  }
  
  public static abstract interface a
  {
    public abstract void dy(int paramInt1, int paramInt2);
  }
  
  class b
  {
    public float CW;
    public float CX;
    public float CY;
    public float CZ;
    public float Da;
    public int euo;
    public int eup;
    public int euq;
    public float lineHeight;
    public int titleColor;
    
    b() {}
  }
  
  class c
    extends ExploreByTouchHelper
  {
    public c(View paramView)
    {
      super();
    }
    
    public Rect getBoundsForIndex(int paramInt)
    {
      Point localPoint = (Point)RangeButtonView.a(RangeButtonView.this).ew().get(paramInt);
      paramInt = RangeButtonView.a(RangeButtonView.this).OU() / 2;
      return new Rect(localPoint.x - paramInt, localPoint.y - paramInt, localPoint.x + paramInt, localPoint.y + paramInt);
    }
    
    public int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      return RangeButtonView.a(RangeButtonView.this, (int)paramFloat1, (int)paramFloat2, RangeButtonView.a(RangeButtonView.this).OV() / 2, RangeButtonView.a(RangeButtonView.this).OU() / 2, false);
    }
    
    public void getVisibleVirtualViews(List<Integer> paramList)
    {
      int i = 0;
      while (i < RangeButtonView.a(RangeButtonView.this).size())
      {
        paramList.add(Integer.valueOf(i));
        i += 1;
      }
    }
    
    public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      switch (paramInt2)
      {
      }
      do
      {
        return false;
      } while ((RangeButtonView.a(RangeButtonView.this) == null) || (RangeButtonView.a(RangeButtonView.this) == null));
      if ((paramInt1 != RangeButtonView.a(RangeButtonView.this)) && (paramInt1 != -1))
      {
        if (RangeButtonView.a(RangeButtonView.this) != null) {
          RangeButtonView.a(RangeButtonView.this).dy(RangeButtonView.a(RangeButtonView.this), paramInt1);
        }
        RangeButtonView.a(RangeButtonView.this, paramInt1);
        RangeButtonView.this.invalidate();
      }
      return true;
    }
    
    public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((RangeButtonView.b(RangeButtonView.this) != null) && (RangeButtonView.b(RangeButtonView.this).size() > paramInt)) {
        paramAccessibilityEvent.setContentDescription((CharSequence)RangeButtonView.b(RangeButtonView.this).get(paramInt));
      }
    }
    
    public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if ((RangeButtonView.b(RangeButtonView.this) != null) && (RangeButtonView.b(RangeButtonView.this).size() > paramInt))
      {
        String str2 = (String)RangeButtonView.b(RangeButtonView.this).get(paramInt);
        String str1 = str2;
        if (paramInt == RangeButtonView.a(RangeButtonView.this)) {
          str1 = str2 + acfp.m(2131713608);
        }
        paramAccessibilityNodeInfoCompat.setContentDescription(str1);
      }
      paramAccessibilityNodeInfoCompat.addAction(16);
      paramAccessibilityNodeInfoCompat.setBoundsInParent(getBoundsForIndex(paramInt));
    }
  }
  
  static class d
  {
    public Bitmap bitmap;
    public int left;
    public int top;
    
    public d(int paramInt1, int paramInt2, Bitmap paramBitmap)
    {
      this.bitmap = paramBitmap;
      lc(paramInt1, paramInt2);
    }
    
    public int OU()
    {
      if (this.bitmap == null) {
        return 0;
      }
      return this.bitmap.getHeight();
    }
    
    public void draw(Canvas paramCanvas, Paint paramPaint)
    {
      paramCanvas.drawBitmap(this.bitmap, this.left, this.top, paramPaint);
    }
    
    public void lc(int paramInt1, int paramInt2)
    {
      int i = this.bitmap.getWidth();
      int j = this.bitmap.getHeight();
      this.left = (paramInt1 - i / 2);
      this.top = (paramInt2 - j / 2);
    }
  }
  
  public static class e
  {
    Point point;
    String text;
    float textSize;
    
    public e(String paramString, float paramFloat)
    {
      this(paramString, paramFloat, null);
    }
    
    public e(String paramString, float paramFloat, Point paramPoint)
    {
      this.text = paramString;
      this.textSize = paramFloat;
      this.point = paramPoint;
    }
    
    public void a(Canvas paramCanvas, Paint paramPaint, RangeButtonView.b paramb)
    {
      if (this.point == null) {
        return;
      }
      paramPaint.setTextSize(this.textSize);
      int i = paramPaint.getColor();
      paramPaint.setColor(paramb.titleColor);
      paramCanvas.drawText(this.text, this.point.x, this.point.y, paramPaint);
      paramPaint.setColor(i);
    }
    
    public float getTextSize()
    {
      return this.textSize;
    }
    
    public int getTextWidth()
    {
      return (int)RangeButtonView.c(this.text, this.textSize);
    }
  }
  
  class f
  {
    private List<RangeButtonView.e> Lk;
    
    public f()
    {
      Object localObject;
      this.Lk = localObject;
    }
    
    public void I(ArrayList<Integer> paramArrayList, int paramInt)
    {
      if (this.Lk == null) {}
      for (;;)
      {
        return;
        int i = 0;
        while (i < paramArrayList.size())
        {
          RangeButtonView.e locale = (RangeButtonView.e)this.Lk.get(i);
          locale.point = new Point(((Integer)paramArrayList.get(i)).intValue() - (locale.getTextWidth() >> 1), paramInt);
          i += 1;
        }
      }
    }
    
    public void a(Canvas paramCanvas, Paint paramPaint)
    {
      if (this.Lk == null) {}
      for (;;)
      {
        return;
        Iterator localIterator = this.Lk.iterator();
        while (localIterator.hasNext()) {
          ((RangeButtonView.e)localIterator.next()).a(paramCanvas, paramPaint, RangeButtonView.this.a);
        }
      }
    }
  }
  
  static class g
  {
    private ArrayList<Point> EF = new ArrayList();
    private int centerY;
    private int endX;
    private int eur;
    private float height;
    private int startX;
    
    public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.startX = paramInt1;
      this.endX = paramInt2;
      this.centerY = paramInt3;
      this.eur = paramInt4;
      this.EF = a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public int OV()
    {
      return (int)((this.endX - this.startX) / (this.eur - 1.0F));
    }
    
    public ArrayList<Point> a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      ArrayList localArrayList = new ArrayList(paramInt4);
      int j = (int)((paramInt2 - paramInt1) / (paramInt4 - 1.0F));
      int i = 0;
      paramInt2 = paramInt1;
      paramInt1 = i;
      if (paramInt1 < paramInt4)
      {
        if (paramInt1 == 0) {}
        for (i = 0;; i = j)
        {
          Point localPoint = new Point(i + paramInt2, paramInt3);
          localArrayList.add(localPoint);
          paramInt2 = localPoint.x;
          paramInt1 += 1;
          break;
        }
      }
      return localArrayList;
    }
    
    public void b(Canvas paramCanvas, Paint paramPaint, RangeButtonView.b paramb)
    {
      int i = paramPaint.getColor();
      float f1 = paramPaint.getStrokeWidth();
      paramPaint.setColor(paramb.euo);
      paramPaint.setStrokeWidth(paramb.CZ);
      paramCanvas.drawLine(this.startX, this.centerY, this.endX, this.centerY, paramPaint);
      paramb = this.EF.iterator();
      while (paramb.hasNext())
      {
        Point localPoint = (Point)paramb.next();
        float f2 = localPoint.x;
        float f3 = localPoint.y;
        float f4 = this.height / 2.0F;
        float f5 = localPoint.x;
        float f6 = localPoint.y;
        paramCanvas.drawLine(f2, f3 - f4, f5, this.height / 2.0F + f6, paramPaint);
      }
      paramPaint.setColor(i);
      paramPaint.setStrokeWidth(f1);
    }
    
    public ArrayList<Point> ew()
    {
      return this.EF;
    }
    
    public void setHeight(float paramFloat)
    {
      this.height = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView
 * JD-Core Version:    0.7.0.1
 */