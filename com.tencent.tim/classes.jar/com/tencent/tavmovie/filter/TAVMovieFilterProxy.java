package com.tencent.tavmovie.filter;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.CanyingEffect;
import com.tencent.taveffect.effects.ChongdieEffect;
import com.tencent.taveffect.effects.GanraoEffect;
import com.tencent.taveffect.effects.HuanjueEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.taveffect.effects.LvdongEffect;
import com.tencent.taveffect.effects.RGBEffect;
import com.tencent.taveffect.effects.ShanbaiEffect;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;

public class TAVMovieFilterProxy
  implements TAVVideoEffect
{
  private static final String TAG = "TAVMovieFilterProxy";
  public static final int TYPE_CAN_YING = 2;
  public static final int TYPE_CHONG_DIE = 3;
  public static final int TYPE_GAN_RAO = 4;
  public static final int TYPE_HUAN_JUE = 5;
  public static final int TYPE_LOOK_UP = 0;
  public static final int TYPE_LV_DONG = 6;
  public static final int TYPE_RGB = 1;
  public static final int TYPE_SHAN_BAI = 7;
  private Bitmap bitmap;
  private int effectID;
  
  public TAVMovieFilterProxy(int paramInt)
  {
    this.effectID = paramInt;
  }
  
  public TAVMovieFilterProxy(int paramInt, Bitmap paramBitmap)
  {
    this.effectID = paramInt;
    this.bitmap = paramBitmap;
  }
  
  @NonNull
  private BaseEffect createEffect()
  {
    switch (this.effectID)
    {
    default: 
      return new RGBEffect();
    case 0: 
      if (this.bitmap == null) {
        return null;
      }
      return new LookupFilter(this.bitmap);
    case 1: 
      return new RGBEffect();
    case 2: 
      return new CanyingEffect();
    case 3: 
      return new ChongdieEffect();
    case 4: 
      return new GanraoEffect();
    case 5: 
      return new HuanjueEffect();
    case 6: 
      return new LvdongEffect();
    }
    return new ShanbaiEffect();
  }
  
  @NonNull
  private TextureInfo getOutputTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  @NonNull
  private TAVTextureInfo getTavTextureInfo(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new TAVMovieFilterEffect();
  }
  
  public String effectId()
  {
    return "TAVMovieFilterProxy";
  }
  
  public void release()
  {
    if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
    {
      this.bitmap.recycle();
      this.bitmap = null;
    }
  }
  
  class TAVMovieFilterEffect
    implements TAVVideoEffect.Filter
  {
    private TextureInfo cacheTextureInfo;
    private BaseEffect mEffect = TAVMovieFilterProxy.this.createEffect();
    
    public TAVMovieFilterEffect() {}
    
    public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
    {
      paramTAVVideoEffect = paramRenderInfo.getCiContext();
      int i = (int)paramCIImage.getSize().width;
      int j = (int)paramCIImage.getSize().height;
      if (this.mEffect == null)
      {
        this.mEffect = TAVMovieFilterProxy.this.createEffect();
        if (this.mEffect == null) {
          return paramCIImage;
        }
      }
      this.mEffect.setRendererWidth(i);
      this.mEffect.setRendererHeight(j);
      if (this.cacheTextureInfo == null)
      {
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
      }
      if ((this.cacheTextureInfo.width != i) || (this.cacheTextureInfo.height != j))
      {
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        this.cacheTextureInfo.release();
        this.cacheTextureInfo = CIContext.newTextureInfo(i, j);
      }
      paramTAVVideoEffect.convertImageToTexture(paramCIImage, this.cacheTextureInfo);
      paramTAVVideoEffect = TAVMovieFilterProxy.this.getTavTextureInfo(this.cacheTextureInfo);
      paramTAVVideoEffect = this.mEffect.applyFilter(paramTAVVideoEffect);
      paramTAVVideoEffect = TAVMovieFilterProxy.this.getOutputTextureInfo(paramTAVVideoEffect);
      paramTAVVideoEffect.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
      return new CIImage(paramTAVVideoEffect);
    }
    
    public void release()
    {
      if (this.mEffect != null)
      {
        this.mEffect.release();
        this.mEffect = null;
      }
      if ((this.cacheTextureInfo != null) && (!this.cacheTextureInfo.isReleased())) {
        this.cacheTextureInfo.release();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVMovieFilterProxy
 * JD-Core Version:    0.7.0.1
 */