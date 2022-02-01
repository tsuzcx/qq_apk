package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.StickerItem;
import java.io.File;

public class TransitionBlendFilter
  extends BaseFilter
  implements ITransitionFilter
{
  public static final String FRAGMENT_SHADER = " precision mediump float;\n   precision mediump int; \n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform int maskType;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n     \n     if (maskType == 0) { \n         gl_FragColor = mix(last, current, mask.a); \n     } else if (maskType == 2) { \n         gl_FragColor = mask; \n     } else { \n         gl_FragColor = mix(last, current, mask.r); \n     } \n }";
  private String dataPath;
  private int easeCurve;
  private StickerItem item;
  private UniformParam.TextureBitmapParam mMaskParam = new UniformParam.TextureBitmapParam("inputImageTexture3", null, 33987, false);
  private long transitionDuration;
  private long transitionStartTime = -1L;
  
  public TransitionBlendFilter()
  {
    super(" precision mediump float;\n   precision mediump int; \n varying mediump vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform int maskType;\n \n void main(void) {\n     vec4 current = texture2D(inputImageTexture, textureCoordinate);\n     vec4 last = texture2D(inputImageTexture2, textureCoordinate);\n     vec4 mask = texture2D(inputImageTexture3, textureCoordinate);\n     \n     if (maskType == 0) { \n         gl_FragColor = mix(last, current, mask.a); \n     } else if (maskType == 2) { \n         gl_FragColor = mask; \n     } else { \n         gl_FragColor = mix(last, current, mask.r); \n     } \n }");
    initParams();
  }
  
  private double getDuration(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    paramDouble3 = (paramDouble3 - paramDouble1) / (paramDouble2 - paramDouble1);
    switch (this.easeCurve)
    {
    default: 
      return paramDouble3 * (paramDouble2 - paramDouble1) + paramDouble1;
    case 1: 
      paramDouble1 = -(paramDouble2 - paramDouble1);
      return Math.cos(paramDouble3 * 1.570796326794897D) * paramDouble1 + paramDouble2;
    case 2: 
      return Math.sin(paramDouble3 * 1.570796326794897D) * (paramDouble2 - paramDouble1) + paramDouble1;
    }
    paramDouble2 = -(paramDouble2 - paramDouble1) / 2.0D;
    return (Math.cos(paramDouble3 * 3.141592653589793D) - 1.0D) * paramDouble2 + paramDouble1;
  }
  
  private Bitmap getNextFrame(int paramInt)
  {
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    return localObject;
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(this.mMaskParam);
    addParam(new UniformParam.IntParam("maskType", 0));
  }
  
  private void updateTextureParam(long paramLong)
  {
    if ((this.item.frames <= 0) || (this.item.frameDuration <= 0.0D))
    {
      clearTextureParam();
      return;
    }
    Bitmap localBitmap = getNextFrame((int)((getDuration(this.transitionStartTime, this.transitionStartTime + this.transitionDuration, paramLong) - this.transitionStartTime) / Math.max(this.item.frameDuration, 1.0D)) % this.item.frames);
    if (!BitmapUtils.isLegal(localBitmap))
    {
      clearTextureParam();
      return;
    }
    this.mMaskParam.swapTextureBitmap(localBitmap);
    VideoMemoryManager.getInstance().recycleBitmap(this.item.id, localBitmap);
  }
  
  protected void clearTextureParam()
  {
    setPositions(GlUtil.EMPTY_POSITIONS);
    this.transitionStartTime = -1L;
  }
  
  public void reset()
  {
    this.transitionStartTime = -1L;
    setPositions(GlUtil.ORIGIN_POSITION_COORDS);
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setDuration(long paramLong)
  {
    this.transitionDuration = paramLong;
  }
  
  public void setEaseCurve(int paramInt)
  {
    this.easeCurve = paramInt;
  }
  
  public void setItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  public void setLastTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void setMaskType(int paramInt)
  {
    addParam(new UniformParam.IntParam("maskType", paramInt));
  }
  
  public void updatePreview(long paramLong)
  {
    if (this.transitionStartTime < 0L) {
      this.transitionStartTime = paramLong;
    }
    updateTextureParam(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransitionBlendFilter
 * JD-Core Version:    0.7.0.1
 */