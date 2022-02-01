package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.Iterator;
import java.util.List;

public class NativeLayoutImpl
  extends ViewGroup
  implements IContainer, IView
{
  private static final String TAG = "NativeLayoutImpl";
  private int mBackgroundColor = 0;
  private Paint mBackgroundPaint;
  private int mBorderBottomLeftRadius = 0;
  private int mBorderBottomRightRadius = 0;
  private int mBorderColor = -16777216;
  private Paint mBorderPaint;
  private int mBorderTopLeftRadius = 0;
  private int mBorderTopRightRadius = 0;
  private int mBorderWidth = 0;
  protected ViewBase mView;
  
  public NativeLayoutImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public void attachViews()
  {
    attachViews(this.mView);
  }
  
  protected void attachViews(ViewBase paramViewBase)
  {
    if (LogUtils.shouldLog()) {
      LogUtils.d("NativeLayoutImpl", "[attachViews] for [" + this.mView.getClass().getSimpleName() + ", " + this.mView.getName() + "]");
    }
    if (paramViewBase == null) {
      if (LogUtils.shouldLog()) {
        LogUtils.d("NativeLayoutImpl", "[attachViews] did not attach since view is null");
      }
    }
    for (;;)
    {
      return;
      if (LogUtils.shouldLog()) {
        LogUtils.d("NativeLayoutImpl", "[attachViews] try to attach [" + paramViewBase.getClass().getSimpleName() + ", " + paramViewBase.getName() + "]");
      }
      View localView;
      if ((paramViewBase instanceof Layout)) {
        if (paramViewBase.getNativeView() != null)
        {
          localView = paramViewBase.getNativeView();
          if (localView != null)
          {
            if (LogUtils.shouldLog()) {
              LogUtils.d("NativeLayoutImpl", "[attachViews] try to add native view of [" + paramViewBase.getClass().getSimpleName() + ", " + paramViewBase.getName() + "]");
            }
            addView(localView, new ViewGroup.LayoutParams(paramViewBase.getComLayoutParams().mLayoutWidth, paramViewBase.getComLayoutParams().mLayoutHeight));
            if (LogUtils.shouldLog()) {
              LogUtils.d("NativeLayoutImpl", "[attachViews] child count after add native view: " + getChildCount());
            }
          }
        }
      }
      while (LogUtils.shouldLog())
      {
        LogUtils.d("NativeLayoutImpl", "[attachViews] childCount after [" + this.mView.getClass().getSimpleName() + ", " + this.mView.getName() + "] attach children: " + getChildCount());
        return;
        if (LogUtils.shouldLog())
        {
          LogUtils.d("NativeLayoutImpl", "[attachViews] child native view is null");
          continue;
          if (LogUtils.shouldLog()) {
            LogUtils.d("NativeLayoutImpl", "[attachViews] native view is null, attach subviews");
          }
          paramViewBase = ((Layout)paramViewBase).getSubViews();
          if (paramViewBase != null)
          {
            paramViewBase = paramViewBase.iterator();
            while (paramViewBase.hasNext()) {
              attachViews((ViewBase)paramViewBase.next());
            }
          }
          else if (LogUtils.shouldLog())
          {
            LogUtils.d("NativeLayoutImpl", "[attachViews] subViews is null");
            continue;
            localView = paramViewBase.getNativeView();
            if (localView != null)
            {
              if (LogUtils.shouldLog()) {
                LogUtils.d("NativeLayoutImpl", "[attachViews] try to add native view of [" + paramViewBase.getClass().getSimpleName() + ", " + paramViewBase.getName() + "]");
              }
              addView(localView, new ViewGroup.LayoutParams(paramViewBase.getComLayoutParams().mLayoutWidth, paramViewBase.getComLayoutParams().mLayoutHeight));
              if (LogUtils.shouldLog()) {
                LogUtils.d("NativeLayoutImpl", "[attachViews] child count after add native view: " + getChildCount());
              }
            }
            else if (LogUtils.shouldLog())
            {
              LogUtils.d("NativeLayoutImpl", "[attachViews] " + paramViewBase.getName() + " native view is null");
            }
          }
        }
      }
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mView != null) {
      layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void destroy()
  {
    this.mView.destroy();
    this.mView = null;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (paramLayoutParams == null) {
      localLayoutParams = generateDefaultLayoutParams();
    }
    return localLayoutParams;
  }
  
  public int getBackgroundColor()
  {
    return this.mBackgroundColor;
  }
  
  public int getComMeasuredHeight()
  {
    if (this.mView != null) {
      return this.mView.getComMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (this.mView != null) {
      return this.mView.getComMeasuredWidth();
    }
    return 0;
  }
  
  public View getHolderView()
  {
    return this;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public ViewBase getVirtualView()
  {
    return this.mView;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    if (this.mView != null) {
      setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.mView != null) {
      setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mBackgroundColor != 0)
    {
      if (this.mBackgroundPaint == null)
      {
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setAntiAlias(true);
      }
      this.mBackgroundPaint.setColor(this.mBackgroundColor);
      VirtualViewUtils.drawBackground(paramCanvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
    super.onDraw(paramCanvas);
    if (this.mBorderWidth > 0)
    {
      if (this.mBorderPaint == null)
      {
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
      }
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
      this.mBorderPaint.setColor(this.mBorderColor);
      VirtualViewUtils.drawBorder(paramCanvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2) {}
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public void setBorderBottomLeftRadius(int paramInt)
  {
    this.mBorderBottomLeftRadius = paramInt;
  }
  
  public void setBorderBottomRightRadius(int paramInt)
  {
    this.mBorderBottomRightRadius = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
  }
  
  public void setBorderTopLeftRadius(int paramInt)
  {
    this.mBorderTopLeftRadius = paramInt;
  }
  
  public void setBorderTopRightRadius(int paramInt)
  {
    this.mBorderTopRightRadius = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
  }
  
  public void setVirtualView(ViewBase paramViewBase)
  {
    if (paramViewBase != null)
    {
      this.mView = paramViewBase;
      this.mView.setHoldView(this);
      if (this.mView.shouldDraw()) {
        setWillNotDraw(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl
 * JD-Core Version:    0.7.0.1
 */