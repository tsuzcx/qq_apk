package com.tencent.ttpic.filter;

import android.graphics.RectF;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.ttpic.openapi.filter.StaticStickerFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.WMGroup;

public class WatermarkStaticFilter
  extends StaticStickerFilter
{
  private WMGroup wmGroup;
  private WatermarkFilter.WMPositionCallback wmPosCallback;
  private RectF wmPosRect;
  
  public WatermarkStaticFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
    this.wmGroup = new WMGroup(paramStickerItem.wmGroupConfig);
    this.wmPosRect = new RectF();
  }
  
  public static boolean compareRect(RectF paramRectF1, RectF paramRectF2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramRectF1 == null) || (paramRectF2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramRectF1 == paramRectF2);
      if ((Float.compare(paramRectF1.left, paramRectF2.left) != 0) || (Float.compare(paramRectF1.top, paramRectF2.top) != 0) || (Float.compare(paramRectF1.right, paramRectF2.right) != 0)) {
        break;
      }
      bool1 = bool2;
    } while (Float.compare(paramRectF1.bottom, paramRectF2.bottom) == 0);
    return false;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    if (this.wmGroup != null) {
      this.wmGroup.init();
    }
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    if (this.wmGroup != null) {
      this.wmGroup.clear();
    }
  }
  
  public void reset()
  {
    this.wmGroup.reset();
    super.reset();
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    if (this.wmPosCallback != null)
    {
      RectF localRectF = new RectF();
      localRectF.left = ((paramArrayOfFloat[0] + 1.0F) / 2.0F);
      localRectF.top = ((paramArrayOfFloat[1] + 1.0F) / 2.0F);
      localRectF.right = ((paramArrayOfFloat[4] + 1.0F) / 2.0F);
      localRectF.bottom = ((paramArrayOfFloat[3] + 1.0F) / 2.0F);
      if (!compareRect(this.wmPosRect, localRectF))
      {
        this.wmPosCallback.onWMPositionUpdate(localRectF);
        this.wmPosRect.set(localRectF);
      }
    }
    return super.setPositions(paramArrayOfFloat);
  }
  
  public void setWMPositionCallback(WatermarkFilter.WMPositionCallback paramWMPositionCallback)
  {
    this.wmPosCallback = paramWMPositionCallback;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (this.wmGroup != null)
    {
      this.wmGroup.updateTexture(paramLong);
      addParam(new UniformParam.TextureParam("inputImageTexture2", this.wmGroup.getTexture(), 33986));
      this.isImageReady = true;
      return;
    }
    this.isImageReady = false;
    clearTextureParam();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.WatermarkStaticFilter
 * JD-Core Version:    0.7.0.1
 */