package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class PuddingEffectBlendFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvarying vec2 textureCoordinate;\nuniform float alpha;\nuniform float filterAdjustParam;\n    \nfloat blendScreen(float base, float blend) {\n    return 1.0-((1.0-base)*(1.0-blend));\n}\n\nvec4 blendScreen(vec4 base, vec4 blend) {\n    return vec4(blendScreen(base.r,blend.r),blendScreen(base.g,blend.g),blendScreen(base.b,blend.b),base.a);\n}\n\n\nvoid main( void ) {\n    vec4 tempColor;\n    vec2 uv = textureCoordinate; \n    vec4 originColor = texture2D(inputImageTexture3,uv);\n    vec4 centerColor = texture2D(inputImageTexture2,uv);\n    vec4 blurColor = texture2D(inputImageTexture,uv);\n    float maskVal = blurColor.a * 0.457;\n    blurColor.a =1.0;\n    vec4 result = mix(centerColor,blurColor,1.0 - maskVal);\n    vec4 blendColor = result;\n    vec4 baseColor = centerColor;\n    result = mix(blendScreen(baseColor,blendColor),result,0.10);\n    result = mix(result,centerColor,0.05);\n    result = mix(centerColor, result, alpha);\n    tempColor = result;\n\n    gl_FragColor = mix (tempColor, originColor, filterAdjustParam);\n}";
  
  public PuddingEffectBlendFilter()
  {
    super("precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvarying vec2 textureCoordinate;\nuniform float alpha;\nuniform float filterAdjustParam;\n    \nfloat blendScreen(float base, float blend) {\n    return 1.0-((1.0-base)*(1.0-blend));\n}\n\nvec4 blendScreen(vec4 base, vec4 blend) {\n    return vec4(blendScreen(base.r,blend.r),blendScreen(base.g,blend.g),blendScreen(base.b,blend.b),base.a);\n}\n\n\nvoid main( void ) {\n    vec4 tempColor;\n    vec2 uv = textureCoordinate; \n    vec4 originColor = texture2D(inputImageTexture3,uv);\n    vec4 centerColor = texture2D(inputImageTexture2,uv);\n    vec4 blurColor = texture2D(inputImageTexture,uv);\n    float maskVal = blurColor.a * 0.457;\n    blurColor.a =1.0;\n    vec4 result = mix(centerColor,blurColor,1.0 - maskVal);\n    vec4 blendColor = result;\n    vec4 baseColor = centerColor;\n    result = mix(blendScreen(baseColor,blendColor),result,0.10);\n    result = mix(result,centerColor,0.05);\n    result = mix(centerColor, result, alpha);\n    tempColor = result;\n\n    gl_FragColor = mix (tempColor, originColor, filterAdjustParam);\n}");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
    addParam(new UniformParam.FloatParam("filterAdjustParam", 0.0F));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
  }
  
  public void setAdjustParam(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("filterAdjustParam", paramFloat));
  }
  
  public void setOriginTex(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
  }
  
  public void updateAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void updateTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.PuddingEffectBlendFilter
 * JD-Core Version:    0.7.0.1
 */