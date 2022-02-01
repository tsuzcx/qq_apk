package com.tencent.mobileqq.activity.recent.cur;

import aalh;
import aalh.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

@TargetApi(19)
public class DragTextView
  extends TextView
  implements aalh
{
  private static int chD;
  private static int chE;
  private static int chF;
  private aalh.a b;
  private Rect bu;
  private int chG = -1;
  private View mContainer;
  private boolean mIsShadow;
  
  public DragTextView(Context paramContext)
  {
    super(paramContext);
    dw(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    dw(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    dw(paramContext);
  }
  
  private void a(View paramView, Rect paramRect)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    super.getGlobalVisibleRect(paramRect);
    if (this.chG == 2)
    {
      paramRect.top = (paramRect.top - localRect.top - chD);
      paramRect.left = (paramRect.left - localRect.left - chF);
      paramRect.bottom = (paramRect.bottom - localRect.top + chF);
      paramRect.right = (paramRect.right - localRect.left + chD);
      return;
    }
    paramRect.top = (paramRect.top - localRect.top - chE);
    paramRect.left = (paramRect.left - localRect.left - chE);
    paramRect.bottom = (paramRect.bottom - localRect.top + chD);
    paramRect.right = (paramRect.right - localRect.left + chD);
  }
  
  private static void dw(Context paramContext)
  {
    if (chD == 0)
    {
      float f = 16.0F * paramContext.getResources().getDisplayMetrics().density;
      chD = (int)f;
      chE = (int)(1.5F * f);
      chF = (int)(f * 0.5F);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.bu != null) && (paramBoolean)) {
      a(this.mContainer, this.bu);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.chG != -1) && (!this.mIsShadow) && (paramMotionEvent.getAction() == 0))
    {
      if (this.b != null)
      {
        this.mIsShadow = true;
        this.b.aa(this, this.chG);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragViewType(int paramInt)
  {
    setDragViewType(paramInt, null);
  }
  
  public void setDragViewType(int paramInt, View paramView)
  {
    this.chG = paramInt;
    this.mContainer = paramView;
    if (this.mContainer == null) {
      this.mContainer = ((ViewGroup)getParent());
    }
    if ((this.b != null) && (this.mContainer != null) && (this.bu == null))
    {
      this.bu = new Rect();
      this.mContainer.setTouchDelegate(new a(this.bu, this));
    }
  }
  
  public void setOnModeChangeListener(aalh.a parama)
  {
    this.b = parama;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setOnModeChangeListener:" + parama);
    }
    if ((this.b != null) && (this.mContainer != null) && (this.bu == null))
    {
      this.bu = new Rect();
      this.mContainer.setTouchDelegate(new a(this.bu, this));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.mIsShadow) && (paramInt == 0)) {
      this.mIsShadow = false;
    }
  }
  
  public int yK()
  {
    return this.chG;
  }
  
  class a
    extends TouchDelegate
  {
    public a(Rect paramRect, View paramView)
    {
      super(paramView);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (DragTextView.this.getVisibility() != 0) {
        return false;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      paramMotionEvent.setLocation(f1, f2);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragTextView
 * JD-Core Version:    0.7.0.1
 */