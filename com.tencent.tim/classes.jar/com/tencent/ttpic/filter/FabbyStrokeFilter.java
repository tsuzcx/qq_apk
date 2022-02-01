package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.Float4fParam;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.AEFilterI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTDetectInfo;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.StickerItem;

public class FabbyStrokeFilter
  extends BaseFilter
  implements AEFilterI
{
  public static String FRAGMENT_SHADER = "precision mediump float; \nvarying mediump vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3; \nuniform float stepX; \nuniform float stepY; \nuniform float strokeGapInPixel; \nuniform float strokeWidthInPixel; \nuniform vec4 strokeColor; \nuniform int useBg; \nuniform vec4 bgColor; \nfloat alphaForStep(float step_x, float step_y, float weight) { \n   float step_x45 = step_x * 0.7071; \n   float step_y45 = step_y * 0.7071; \n   vec4 v3_10 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y+step_y)); \n   vec4 v3_11 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y+step_y45)); \n   vec4 v3_12 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x, textureCoordinate.y)); \n   vec4 v3_13 = texture2D(inputImageTexture2, vec2(textureCoordinate.x+step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_14 = texture2D(inputImageTexture2, vec2(textureCoordinate.x, textureCoordinate.y-step_y)); \n   vec4 v3_15 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y-step_y45)); \n   vec4 v3_16 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x, textureCoordinate.y)); \n   vec4 v3_17 = texture2D(inputImageTexture2, vec2(textureCoordinate.x-step_x45, textureCoordinate.y+step_y45)); \n   float temp = step(0.3, v3_10.r); \n   temp = step(0.3, v3_11.r + temp); \n   temp = step(0.3, v3_12.r + temp); \n   temp = step(0.3, v3_13.r + temp); \n   temp = step(0.3, v3_14.r + temp); \n   temp = step(0.3, v3_15.r + temp); \n   temp = step(0.3, v3_16.r + temp); \n   float alpha = step(0.3, v3_17.r + temp); \n   return alpha * weight; \n} \nvoid main() \n{ \n   vec4 v1 = texture2D(inputImageTexture, textureCoordinate); \n   vec4 v2 = texture2D(inputImageTexture2, textureCoordinate); \n   vec4 bg = bgColor; \n   float mask = v2.r; \n   if (mask < 0.3) { \n       float x = stepX * strokeGapInPixel; \n       float y = stepY * strokeGapInPixel; \n       float innerAlpha = alphaForStep(x, y, 1.0); \n       if (innerAlpha > 0.3) { \n           gl_FragColor = bg; \n       } else { \n           x += stepX * strokeWidthInPixel; \n           y += stepY * strokeWidthInPixel; \n           float outterAlpha = alphaForStep(x, y, 1.0); \n           if (outterAlpha > 0.3) { \n               if (useBg == 0) {\n                   gl_FragColor = strokeColor; \n               } else { \n                   gl_FragColor = texture2D(inputImageTexture3, textureCoordinate); \n               } \n           } else { \n               gl_FragColor = bg; \n           } \n       } \n   } else { \n       gl_FragColor = v1; \n   } \n }";
  protected int frameIndex = -1;
  protected StickerItem item;
  private int lastIndex = -1;
  private int[] texture = new int[1];
  
  public FabbyStrokeFilter()
  {
    super(FRAGMENT_SHADER);
    initParam();
  }
  
  public FabbyStrokeFilter(StickerItem paramStickerItem)
  {
    super(FRAGMENT_SHADER);
    this.item = paramStickerItem;
    initParam();
  }
  
  private int getNextFrame(int paramInt)
  {
    if (this.item == null) {
      return -1;
    }
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      return this.texture[0];
    }
    VideoMemoryManager.getInstance().recycleBitmap(this.item.id, localBitmap);
    return -1;
  }
  
  private void initParam()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.IntParam("useBg", 0));
    addParam(new UniformParam.FloatParam("stepX", 0.0F));
    addParam(new UniformParam.FloatParam("stepY", 0.0F));
    addParam(new UniformParam.FloatParam("strokeGapInPixel", 0.0F));
    addParam(new UniformParam.FloatParam("strokeWidthInPixel", 0.0F));
    addParam(new UniformParam.Float4fParam("strokeColor", 0.0F, 0.0F, 0.0F, 0.0F));
    addParam(new UniformParam.Float4fParam("bgColor", 0.0F, 0.0F, 0.0F, 0.0F));
  }
  
  public Frame RenderProcess(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public void apply()
  {
    super.apply();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
  }
  
  public void setBgColor(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float4fParam("bgColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.frameIndex = paramInt;
  }
  
  public void setStepX(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("stepX", paramFloat));
  }
  
  public void setStepY(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("stepY", paramFloat));
  }
  
  public void setStrokeColor(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float4fParam("strokeColor", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]));
  }
  
  public void setStrokeGapInPixel(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("strokeGapInPixel", paramFloat));
  }
  
  public void setStrokeWidthInPixel(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("strokeWidthInPixel", paramFloat));
  }
  
  public void setmMaskTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void updatePreview(Object paramObject)
  {
    if ((paramObject instanceof PTDetectInfo))
    {
      updateTextureParam((PTDetectInfo)paramObject);
      return;
    }
    updateTextureParam(null);
  }
  
  protected int updateStrokeBitmap(PTDetectInfo paramPTDetectInfo)
  {
    int i = this.frameIndex;
    if (i == this.lastIndex) {
      return this.texture[0];
    }
    int j = getNextFrame(i);
    if (j <= 0) {
      return this.texture[0];
    }
    addParam(new UniformParam.TextureParam("inputImageTexture3", j, 33987));
    this.lastIndex = i;
    return this.texture[0];
  }
  
  public void updateTextureParam(PTDetectInfo paramPTDetectInfo)
  {
    if ((this.item == null) || (paramPTDetectInfo == null))
    {
      addParam(new UniformParam.IntParam("useBg", 0));
      return;
    }
    addParam(new UniformParam.IntParam("useBg", 1));
    updateStrokeBitmap(paramPTDetectInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyStrokeFilter
 * JD-Core Version:    0.7.0.1
 */