package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

public class NativeImageImp
  extends ImageView
  implements IView
{
  private static final String TAG = "NativeImageImp_TMTEST";
  private int mBorderBottomLeftRadius;
  private int mBorderBottomRightRadius;
  private int mBorderTopLeftRadius;
  private int mBorderTopRightRadius;
  private Drawable mPlaceHolder;
  
  public NativeImageImp(Context paramContext)
  {
    super(paramContext);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.mBorderBottomLeftRadius > 0) || (this.mBorderBottomRightRadius > 0) || (this.mBorderTopLeftRadius > 0) || (this.mBorderTopRightRadius > 0)) {
      VirtualViewUtils.clipCanvas(paramCanvas, getWidth(), getHeight(), 0, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setCorner(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mBorderTopLeftRadius = paramInt1;
    this.mBorderTopRightRadius = paramInt2;
    this.mBorderBottomRightRadius = paramInt4;
    this.mBorderBottomLeftRadius = paramInt3;
  }
  
  public void setImageSrc(String paramString)
  {
    try
    {
      setImageDrawable(DrawableUtil.getDrawable(getContext(), paramString, null, null));
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImageImp
 * JD-Core Version:    0.7.0.1
 */