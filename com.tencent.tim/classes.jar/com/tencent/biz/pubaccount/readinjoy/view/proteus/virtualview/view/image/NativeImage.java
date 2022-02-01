package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;

public class NativeImage
  extends ImageBase
{
  private static final String TAG = "NativeImage_TMTEST";
  protected NativeImageImp mNative;
  
  public NativeImage(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new NativeImageImp(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.mNative.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mNative.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  public boolean isContainer()
  {
    return true;
  }
  
  public void loadImage(String paramString)
  {
    LogUtil.QLog.d("NativeImage_TMTEST", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1"))) {
      this.mNative.setImageDrawable(DrawableUtil.getDrawable(this.mNative.getContext(), paramString, null, null));
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mNative.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mNative.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.mNative.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
    this.mNative.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    loadImage(this.mSrc);
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.mNative.setImageSrc(null);
    this.mSrc = null;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.mNative.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean)
  {
    this.mNative.setImageDrawable(paramDrawable);
  }
  
  public static class Builder
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new NativeImage(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImage
 * JD-Core Version:    0.7.0.1
 */