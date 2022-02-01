package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class RealTimeProcessVarianceFilterAndDenoiseV3
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform lowp float blurAlpha; \nuniform highp float widthOffset; \nuniform highp float heightOffset;\nuniform highp float sharpenFactor; \n\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nlowp vec3 rgb2hsv(lowp vec3 c) {\n  lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n  highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n  highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n  highp float d = q.x - min(q.w, q.y);\n  highp float e = 1.0e-10;\n  lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n  return hsv;\n}\n\nlowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, textureCoordinate);\n     highp float curLuminance = dot(curColor.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, textureCoordinate);\n     highp float lastLuminance = dot(lastColor.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n}\n\nlowp vec3 sharpenColor(lowp vec3 mixColor, lowp vec3 iColor, highp float sharpen) {\n  highp float sum = 0.25*iColor.g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(-widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(0.0,-heightOffset)).g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(0.0,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(-widthOffset,-heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(-widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(widthOffset,-heightOffset)).g;\n     \n  highp float hPass = iColor.g-sum;\n  highp vec3 sColor = clamp((mixColor + hPass * 2.0), vec3(0.0), vec3(1.0));\n  sColor = mix(mixColor, sColor, sharpen);\n  return sColor;\n}\n \nvoid main() \n{ \n  lowp vec4 iColor = denoiseColor(inputImageTexture, inputImageTexture4); \n  lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n  lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate);\n  mediump float diffFactor = (1.0 - varColor.r / (varColor.r + 0.1));\n  lowp vec3 hsv = rgb2hsv(iColor.rgb);\n  mediump float p1 = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n  mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n  mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n  mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n  mediump float p2 = min(max(p2_left, p2_right), p2_value);\n  mediump float p = max(p1, p2);\n  mediump float kMin = diffFactor * p * varColor.b;\n  lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, kMin * blurAlpha);\n  lowp vec3 resultColor = sharpenColor(smoothColor, iColor.rgb, sharpenFactor);\n  gl_FragColor = vec4(resultColor.rgb, iColor.a);\n}\n";
  private float blendAlpha = 0.0F;
  
  public RealTimeProcessVarianceFilterAndDenoiseV3()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2; \nuniform sampler2D inputImageTexture3;\nuniform sampler2D inputImageTexture4;\nuniform lowp float blurAlpha; \nuniform highp float widthOffset; \nuniform highp float heightOffset;\nuniform highp float sharpenFactor; \n\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nlowp vec3 rgb2hsv(lowp vec3 c) {\n  lowp vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n  highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n  highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n  highp float d = q.x - min(q.w, q.y);\n  highp float e = 1.0e-10;\n  lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n  return hsv;\n}\n\nlowp vec4 denoiseColor(sampler2D curFrameTex, sampler2D lastFrameTex) {\n     lowp vec4 curColor = texture2D(curFrameTex, textureCoordinate);\n     highp float curLuminance = dot(curColor.rgb, luminanceWeighting);\n     \n     lowp vec4 lastColor = texture2D(lastFrameTex, textureCoordinate);\n     highp float lastLuminance = dot(lastColor.rgb, luminanceWeighting);\n     \n     highp float lumDelta = abs(curLuminance - lastLuminance);\n     highp float lumWeight = 1.0 + 0.02 * lumDelta * lumDelta * 255.0 * 255.0;\n     highp float mixAlpha = lumWeight / (lumWeight + 1.5);\n     lowp vec4 resultColor = mix(lastColor, curColor, mixAlpha);\n     return resultColor;\n}\n\nlowp vec3 sharpenColor(lowp vec3 mixColor, lowp vec3 iColor, highp float sharpen) {\n  highp float sum = 0.25*iColor.g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(-widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(widthOffset,0.0)).g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(0.0,-heightOffset)).g;\n  sum += 0.125*texture2D(inputImageTexture,textureCoordinate+vec2(0.0,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(-widthOffset,-heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(-widthOffset,heightOffset)).g;\n  sum += 0.0625*texture2D(inputImageTexture,textureCoordinate+vec2(widthOffset,-heightOffset)).g;\n     \n  highp float hPass = iColor.g-sum;\n  highp vec3 sColor = clamp((mixColor + hPass * 2.0), vec3(0.0), vec3(1.0));\n  sColor = mix(mixColor, sColor, sharpen);\n  return sColor;\n}\n \nvoid main() \n{ \n  lowp vec4 iColor = denoiseColor(inputImageTexture, inputImageTexture4); \n  lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n  lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate);\n  mediump float diffFactor = (1.0 - varColor.r / (varColor.r + 0.1));\n  lowp vec3 hsv = rgb2hsv(iColor.rgb);\n  mediump float p1 = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n  mediump float p2_left = (0.18 - clamp(hsv.x, 0.16, 0.18)) / 0.02;\n  mediump float p2_right = 1.0 - (0.91 - clamp(hsv.x, 0.89, 0.91)) / 0.02;\n  mediump float p2_value = 1.0 - (0.3 - clamp(hsv.z, 0.2, 0.3)) / 0.1;\n  mediump float p2 = min(max(p2_left, p2_right), p2_value);\n  mediump float p = max(p1, p2);\n  mediump float kMin = diffFactor * p * varColor.b;\n  lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, kMin * blurAlpha);\n  lowp vec3 resultColor = sharpenColor(smoothColor, iColor.rgb, sharpenFactor);\n  gl_FragColor = vec4(resultColor.rgb, iColor.a);\n}\n");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("inputImageTexture4", 0, 33988));
    addParam(new UniformParam.FloatParam("blurAlpha", 0.0F));
    addParam(new UniformParam.FloatParam("widthOffset", 0.0F));
    addParam(new UniformParam.FloatParam("heightOffset", 0.0F));
    addParam(new UniformParam.FloatParam("sharpenFactor", 0.0F));
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
      addParam(new UniformParam.FloatParam("sharpenFactor", 0.7F));
      return;
    }
    addParam(new UniformParam.FloatParam("sharpenFactor", Math.max(0.0F, this.blendAlpha / 0.2F) * 0.7F));
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
 * Qualified Name:     com.tencent.ttpic.filter.RealTimeProcessVarianceFilterAndDenoiseV3
 * JD-Core Version:    0.7.0.1
 */