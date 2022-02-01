package com.tencent.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.weseevideo.model.effect.LutModel;

public class WSLutEffectNode
  implements TAVVideoEffect
{
  private Bitmap mLutBitmap;
  private LutModel mLutModel;
  protected String reportKey = "WSLutEffectNode";
  private final String sEffectId = "WSLutEffectNode" + Integer.toHexString(hashCode());
  
  public TAVVideoEffect.Filter createFilter()
  {
    return new WSLutEffectFilter();
  }
  
  @Nullable
  public String effectId()
  {
    if (this.mLutModel == null) {
      return "";
    }
    return this.sEffectId;
  }
  
  public void setLutMode(LutModel paramLutModel)
  {
    if ((!TextUtils.isEmpty(paramLutModel.getLutBitmap())) && ((this.mLutModel == null) || (!paramLutModel.getLutBitmap().equals(this.mLutModel.getLutBitmap())))) {
      this.mLutBitmap = BitmapFactory.decodeFile(paramLutModel.getLutBitmap());
    }
    this.mLutModel = paramLutModel;
  }
  
  public void setReportKey(String paramString)
  {
    this.reportKey = paramString;
  }
  
  public class LUTFilter
    extends BaseEffect
  {
    private static final String FRAGMENT_SHADER = "sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
    private static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D  ";
    private static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
    private float intensity = 1.0F;
    private int intensityHandle;
    private Bitmap lutBitmap;
    private int lutTextureHandle;
    private int lutTextureID = -1;
    
    public LUTFilter() {}
    
    public void afterDraw(TAVTextureInfo paramTAVTextureInfo)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, 0);
    }
    
    public void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.lutTextureID);
      GLES20.glUniform1i(this.lutTextureHandle, 1);
      GLES20.glUniform1f(this.intensityHandle, this.intensity);
    }
    
    public LookupFilter clone()
    {
      return (LookupFilter)cloneFilter(new LookupFilter(this.lutBitmap, this.intensity));
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      if (this.intensity != ((LUTFilter)paramObject).intensity) {
        return false;
      }
      if (this.lutBitmap != ((LUTFilter)paramObject).lutBitmap) {
        return false;
      }
      return super.equals(paramObject);
    }
    
    public String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
    {
      if (paramTAVTextureInfo.textureType == 36197) {
        return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
      }
      return "uniform sampler2D  sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = newColor;\n}";
    }
    
    public void initShader(TAVTextureInfo paramTAVTextureInfo)
    {
      super.initShader(paramTAVTextureInfo);
      this.lutTextureHandle = GLES20.glGetUniformLocation(this.program, "sLookupTexture");
      com.tencent.taveffect.utils.TAVGLUtils.checkEglError("glGetUniformLocation sLookupTexture");
      this.intensityHandle = GLES20.glGetUniformLocation(this.program, "intensity");
      com.tencent.taveffect.utils.TAVGLUtils.checkEglError("glGetUniformLocation intensity");
      if (this.lutTextureID == -1)
      {
        paramTAVTextureInfo = new int[1];
        GLES20.glGenTextures(1, paramTAVTextureInfo, 0);
        int i = paramTAVTextureInfo[0];
        GLES20.glBindTexture(3553, i);
        com.tencent.taveffect.utils.TAVGLUtils.checkEglError("glBindTexture mTextureID");
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        com.tencent.taveffect.utils.TAVGLUtils.checkEglError("glTexParameter");
        GLES20.glTexImage2D(3553, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, 5121, null);
        GLUtils.texImage2D(3553, 0, this.lutBitmap, 0);
        GLES20.glBindTexture(3553, 0);
        this.lutTextureID = i;
      }
    }
    
    public void release()
    {
      if (this.lutTextureID != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.lutTextureID }, 0);
        this.lutTextureID = -1;
      }
      super.release();
    }
    
    public void setIntensity(float paramFloat)
    {
      this.intensity = paramFloat;
    }
    
    public void setLUTBitmap(Bitmap paramBitmap)
    {
      this.lutBitmap = paramBitmap;
      GLES20.glBindTexture(3553, this.lutTextureID);
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      GLES20.glBindTexture(3553, 0);
    }
  }
  
  class WSLutEffectFilter
    implements TAVVideoEffect.Filter, IReportable
  {
    private TextureInfo cacheTextureInfo;
    private WSLutEffectNode.LUTFilter mEffect = new WSLutEffectNode.LUTFilter(WSLutEffectNode.this);
    
    public WSLutEffectFilter() {}
    
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
    
    public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
    {
      if (this.mEffect == null) {}
      long l;
      do
      {
        do
        {
          return paramCIImage;
          paramTAVVideoEffect = paramRenderInfo.getCiContext();
        } while ((paramTAVVideoEffect == null) || (paramTAVVideoEffect.getRenderContext() == null));
        TextureInfo localTextureInfo = CIContext.newTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height);
        paramTAVVideoEffect.convertImageToTexture(paramCIImage, localTextureInfo);
        com.tencent.tavkit.ciimage.TAVGLUtils.saveBitmap(localTextureInfo);
        l = paramRenderInfo.getTime().getTimeUs() / 1000L;
      } while (((WSLutEffectNode.this.mLutModel != null) && ((l < WSLutEffectNode.this.mLutModel.getLutStartTime()) || (l > WSLutEffectNode.this.mLutModel.getLutStartTime() + WSLutEffectNode.this.mLutModel.getLutDuration()))) || (!BitmapUtil.isValidBitmap(WSLutEffectNode.this.mLutBitmap)));
      this.mEffect.setLUTBitmap(WSLutEffectNode.this.mLutBitmap);
      if (WSLutEffectNode.this.mLutModel != null) {
        this.mEffect.setIntensity(WSLutEffectNode.this.mLutModel.getLutAlpha());
      }
      int i = (int)paramCIImage.getSize().width;
      int j = (int)paramCIImage.getSize().height;
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
      paramTAVVideoEffect = getTavTextureInfo(this.cacheTextureInfo);
      paramTAVVideoEffect = getOutputTextureInfo(this.mEffect.applyFilter(paramTAVVideoEffect));
      paramTAVVideoEffect.setTextureMatrix(this.cacheTextureInfo.getTextureMatrix());
      return new CIImage(paramTAVVideoEffect);
    }
    
    public String getReportKey()
    {
      return WSLutEffectNode.this.reportKey;
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
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSLutEffectNode
 * JD-Core Version:    0.7.0.1
 */