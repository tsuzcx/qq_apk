package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public abstract class ImageBase
  extends ViewBase
{
  public static SparseArray<ImageView.ScaleType> IMAGE_SCALE_TYPE = new SparseArray();
  private static final String TAG = "ImageBase_TMTEST";
  double[] mDynamicRate = new double[1];
  public int mScaleType = 2;
  private int mSizeChangeAccord = 0;
  public String mSrc;
  
  static
  {
    IMAGE_SCALE_TYPE.put(1, ImageView.ScaleType.FIT_XY);
    IMAGE_SCALE_TYPE.put(2, ImageView.ScaleType.CENTER_CROP);
  }
  
  public ImageBase(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  public String getSrc()
  {
    return this.mSrc;
  }
  
  public void loadImage(String paramString) {}
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if ((this.mDynamicRate[0] > 0.0D) && (this.mParams != null))
    {
      if ((this.mSizeChangeAccord != 1) || (this.mParams.mLayoutWidth <= 0)) {
        break label64;
      }
      this.mParams.mLayoutHeight = ((int)(this.mParams.mLayoutWidth / this.mDynamicRate[0]));
    }
    label64:
    while ((this.mSizeChangeAccord != 2) || (this.mParams.mLayoutHeight <= 0)) {
      return;
    }
    this.mParams.mLayoutWidth = ((int)(this.mParams.mLayoutHeight * this.mDynamicRate[0]));
  }
  
  public void reset()
  {
    super.reset();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = super.setAttribute(paramInt, paramObject);
    boolean bool1 = bool2;
    if (!bool2) {}
    switch (paramInt)
    {
    default: 
      bool1 = false;
      return bool1;
    case 23: 
      this.mSrc = JsonUtils.getStringValue(paramObject, 0);
      return true;
    }
    this.mSizeChangeAccord = JsonUtils.getDynamicRateSize(this.mDynamicRate, paramObject);
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = super.setAttribute(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = true;
      switch (paramInt)
      {
      default: 
        bool1 = false;
      }
    }
    do
    {
      return bool1;
      this.mSrc = paramString;
      return true;
      this.mSrc = paramString;
      return true;
      paramString = Utils.toInteger(paramString);
    } while (paramString == null);
    this.mScaleType = paramString.intValue();
    return true;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    setBitmap(paramBitmap, true);
  }
  
  public abstract void setBitmap(Bitmap paramBitmap, boolean paramBoolean);
  
  public void setImageDrawable(Drawable paramDrawable, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase
 * JD-Core Version:    0.7.0.1
 */