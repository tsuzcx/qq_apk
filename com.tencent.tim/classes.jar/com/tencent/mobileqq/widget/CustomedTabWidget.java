package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import arfh;
import arfi;
import java.lang.ref.WeakReference;

@SuppressLint({"ResourceAsColor"})
public class CustomedTabWidget
  extends LinearLayout
{
  private ImageView Fv;
  a jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$a;
  private b jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$b;
  Rect cQ = new Rect();
  Rect cR = new Rect();
  public boolean cZU = false;
  private int efA;
  public int efz;
  private Drawable fY;
  private Drawable fZ;
  private Drawable ga;
  float mDelta;
  private float mDensity;
  private Paint mPaint = new Paint();
  
  public CustomedTabWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Fv = ((ImageView)inflate(paramContext, 2131563087, null));
    this.fY = this.Fv.getBackground();
    this.fZ = paramContext.getResources().getDrawable(2130851377);
    this.ga = paramContext.getResources().getDrawable(2130851376);
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$a = new a(this);
  }
  
  private void Ym(int paramInt)
  {
    if (paramInt == this.efA) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$b != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$b.Yn(paramInt);
      }
      getChildAt(this.efA).setSelected(false);
      this.efA = paramInt;
      getChildAt(this.efA).setSelected(true);
      getChildAt(this.efA).getHitRect(this.cQ);
    } while ((this.cQ.left == this.cR.left) && (this.cQ.right == this.cR.right));
    this.mDelta = ((this.cQ.left - this.cR.left) / 4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$a.sendEmptyMessage(0);
  }
  
  private void iA(View paramView)
  {
    paramView.setOnClickListener(new arfh(this));
    paramView.setOnTouchListener(new arfi(this));
    if (getChildCount() == 1) {
      paramView.setSelected(true);
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    iA(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    iA(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(paramView, paramInt1, paramInt2);
    iA(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    iA(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
    iA(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.ga.setBounds(0, getHeight() - 6, getWidth(), getHeight());
    this.ga.draw(paramCanvas);
    int i = getWidth() / getChildCount();
    int j = this.cR.centerX() - i / 2;
    this.fZ.setBounds(j, this.cR.bottom - (int)(4.0F * this.mDensity), i + j, this.cR.bottom);
    this.fZ.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getChildAt(this.efA).getHitRect(this.cQ);
    this.cR.set(this.cQ.left, this.cQ.top, this.cQ.right, this.cQ.bottom);
    setCurrentTab(this.efA);
  }
  
  public void setCurrentTab(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getChildCount())) {
      Ym(paramInt);
    }
  }
  
  public void setOnSwitchTabListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$a.removeMessages(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$b = paramb;
  }
  
  static class a
    extends Handler
  {
    private WeakReference<CustomedTabWidget> iF;
    
    public a(CustomedTabWidget paramCustomedTabWidget)
    {
      this.iF = new WeakReference(paramCustomedTabWidget);
    }
    
    public void handleMessage(Message arg1)
    {
      CustomedTabWidget localCustomedTabWidget = (CustomedTabWidget)this.iF.get();
      if (localCustomedTabWidget == null) {
        return;
      }
      if (localCustomedTabWidget.mDelta < 0.0F) {
        localCustomedTabWidget.invalidate((int)(localCustomedTabWidget.cR.left + localCustomedTabWidget.mDelta), localCustomedTabWidget.cR.top, localCustomedTabWidget.cR.right, localCustomedTabWidget.cR.bottom);
      }
      synchronized (localCustomedTabWidget.a)
      {
        Rect localRect = localCustomedTabWidget.cR;
        localRect.left = ((int)(localRect.left + localCustomedTabWidget.mDelta));
        localRect = localCustomedTabWidget.cR;
        localRect.right = ((int)(localRect.right + localCustomedTabWidget.mDelta));
        if ((localCustomedTabWidget.cQ.left - localCustomedTabWidget.cR.left) / localCustomedTabWidget.mDelta >= 1.0F)
        {
          sendEmptyMessage(0);
          return;
          localCustomedTabWidget.invalidate(localCustomedTabWidget.cR.left, localCustomedTabWidget.cR.top, (int)(localCustomedTabWidget.cR.right + localCustomedTabWidget.mDelta), localCustomedTabWidget.cR.bottom);
        }
      }
      localObject.cR.set(localObject.cQ.left, localObject.cQ.top, localObject.cQ.right, localObject.cQ.bottom);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Yn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget
 * JD-Core Version:    0.7.0.1
 */