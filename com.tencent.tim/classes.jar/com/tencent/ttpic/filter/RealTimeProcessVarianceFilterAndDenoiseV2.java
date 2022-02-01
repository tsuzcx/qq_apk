package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class RealTimeProcessVarianceFilterAndDenoiseV2
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 canvasCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3; \nuniform sampler2D inputImageTexture4; \nuniform lowp float blurAlpha; \nuniform highp float widthOffset; \nuniform highp float heightOffset; \nuniform highp float sharpen;\nuniform highp float skinAlpha;\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\nlowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, canvasCoordinate);\n     highp float curLuminance = dot(curColor.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, canvasCoordinate);\n     highp float lastLuminance = dot(lastColor.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n}\n\nvoid main() \n{ \n  lowp vec4 iColor = denoiseColor(inputImageTexture, inputImageTexture4); \n  lowp vec4 meanColor = texture2D(inputImageTexture2, canvasCoordinate); \n  lowp vec4 varColor = texture2D(inputImageTexture3, canvasCoordinate); \n  lowp float theta = 0.1; \n  mediump float p = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0); \n  mediump float meanVar = (varColor.r + varColor.g + varColor.b) / 3.0; \n  mediump float kMin; \n  lowp vec3 resultColor; \n  kMin = (1.0 - meanVar / (meanVar + theta)) * p * blurAlpha * skinAlpha; \n  resultColor = mix(iColor.rgb, meanColor.rgb, kMin); \n   \n  highp float sum = 0.25*iColor.g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(-widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(0.0,-heightOffset)).g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(0.0,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(-widthOffset,-heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(-widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(widthOffset,-heightOffset)).g;\n\n\n  float hPass = iColor.g-sum+0.5;\n  highp vec3 color = max(vec3(0.0), min(vec3(1.0), (resultColor + 2.0*hPass - 1.0)));\n  color = mix(resultColor.rgb, color.rgb, sharpen);\n\n  lowp vec2 centerPos = vec2(0.5, 0.5);\n  highp float centerDis = distance(textureCoordinate, centerPos);\n  highp float centerFactor = (clamp(0.7071 - centerDis, 0.0, 0.3071)) / 0.3071;// 0.7071=length(vec2(0.5)) \n\n  gl_FragColor = vec4(mix(iColor.rgb, color, centerFactor), 1.0);\n}\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n";
  private float blendAlpha = 0.0F;
  
  public RealTimeProcessVarianceFilterAndDenoiseV2()
  {
    super("attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    canvasCoordinate = vec2(position.x * 0.5 + 0.5, position.y * 0.5 + 0.5);\n    textureCoordinate = inputTextureCoordinate;\n}\n", "precision highp float;\nvarying highp vec2 canvasCoordinate;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3; \nuniform sampler2D inputImageTexture4; \nuniform lowp float blurAlpha; \nuniform highp float widthOffset; \nuniform highp float heightOffset; \nuniform highp float sharpen;\nuniform highp float skinAlpha;\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\nlowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, canvasCoordinate);\n     highp float curLuminance = dot(curColor.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, canvasCoordinate);\n     highp float lastLuminance = dot(lastColor.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n}\n\nvoid main() \n{ \n  lowp vec4 iColor = denoiseColor(inputImageTexture, inputImageTexture4); \n  lowp vec4 meanColor = texture2D(inputImageTexture2, canvasCoordinate); \n  lowp vec4 varColor = texture2D(inputImageTexture3, canvasCoordinate); \n  lowp float theta = 0.1; \n  mediump float p = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0); \n  mediump float meanVar = (varColor.r + varColor.g + varColor.b) / 3.0; \n  mediump float kMin; \n  lowp vec3 resultColor; \n  kMin = (1.0 - meanVar / (meanVar + theta)) * p * blurAlpha * skinAlpha; \n  resultColor = mix(iColor.rgb, meanColor.rgb, kMin); \n   \n  highp float sum = 0.25*iColor.g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(-widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(0.0,-heightOffset)).g;\n  sum += 0.125*texture2D(inputImageTexture,canvasCoordinate+vec2(0.0,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(-widthOffset,-heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(-widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,canvasCoordinate+vec2(widthOffset,-heightOffset)).g;\n\n\n  float hPass = iColor.g-sum+0.5;\n  highp vec3 color = max(vec3(0.0), min(vec3(1.0), (resultColor + 2.0*hPass - 1.0)));\n  color = mix(resultColor.rgb, color.rgb, sharpen);\n\n  lowp vec2 centerPos = vec2(0.5, 0.5);\n  highp float centerDis = distance(textureCoordinate, centerPos);\n  highp float centerFactor = (clamp(0.7071 - centerDis, 0.0, 0.3071)) / 0.3071;// 0.7071=length(vec2(0.5)) \n\n  gl_FragColor = vec4(mix(iColor.rgb, color, centerFactor), 1.0);\n}\n");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
    addParam(new UniformParam.FloatParam("blurAlpha", 0.0F));
    addParam(new UniformParam.FloatParam("widthOffset", 0.0F));
    addParam(new UniformParam.FloatParam("heightOffset", 0.0F));
    addParam(new UniformParam.FloatParam("sharpen", 0.7F));
    addParam(new UniformParam.FloatParam("skinAlpha", 1.0F));
  }
  
  public float getBlurAlpha()
  {
    return this.blendAlpha;
  }
  
  public void setBlendAlpha(float paramFloat)
  {
    this.blendAlpha = paramFloat;
    addParam(new UniformParam.FloatParam("blurAlpha", paramFloat));
    if (this.blendAlpha >= 0.2F)
    {
      addParam(new UniformParam.FloatParam("sharpen", 0.7F));
      return;
    }
    addParam(new UniformParam.FloatParam("sharpen", Math.max(0.0F, this.blendAlpha / 0.2F) * 0.7F));
  }
  
  public void setDenoiseTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture4", paramInt, 33988));
  }
  
  public void setSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("widthOffset", 1.0F / paramFloat1));
    addParam(new UniformParam.FloatParam("heightOffset", 1.0F / paramFloat2));
  }
  
  public void setSkinAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("skinAlpha", paramFloat));
  }
  
  public void setTexture2(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
  
  public void setTexture3(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.RealTimeProcessVarianceFilterAndDenoiseV2
 * JD-Core Version:    0.7.0.1
 */