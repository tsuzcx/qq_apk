package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

public class BoringView
  extends ViewBase
{
  private BoringViewImpl mNative;
  
  public BoringView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new BoringViewImpl(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.mNative.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mNative.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mNative.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mNative.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setBorderColor(this.mBorderColor);
    this.mNative.setBorderWidth(this.mBorderWidth);
    this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
    this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
    this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
    this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
    this.mNative.setBackgroundColor(this.mBackground);
  }
  
  static class BoringViewImpl
    extends View
  {
    private int mBackgroundColor = 0;
    private Paint mBackgroundPaint;
    private int mBorderBottomLeftRadius = 0;
    private int mBorderBottomRightRadius = 0;
    private int mBorderColor = -16777216;
    private Paint mBorderPaint;
    private int mBorderTopLeftRadius = 0;
    private int mBorderTopRightRadius = 0;
    private int mBorderWidth = 0;
    
    public BoringViewImpl(Context paramContext)
    {
      super();
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
  }
  
  public static class Builder
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new BoringView(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView
 * JD-Core Version:    0.7.0.1
 */