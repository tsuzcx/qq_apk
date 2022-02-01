package com.tencent.filter.art;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import java.util.Map;

public class BaibianFilter
  extends BaseFilter
{
  private float blurSize;
  private int fragmentShaderId;
  private float inputH;
  private float inputS;
  private float inputV;
  private float intensity;
  private String resName = null;
  
  public BaibianFilter(int paramInt, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    super(BaseFilter.getFragmentShader(paramInt));
    this.resName = paramString;
    this.fragmentShaderId = paramInt;
    this.blurSize = paramFloat1;
    this.intensity = paramFloat2;
    this.inputH = paramFloat3;
    this.inputS = paramFloat4;
    this.inputV = paramFloat5;
    if ((this.resName != null) || (this.fragmentShaderId != 0))
    {
      addParam(new TextureResParam("inputImageTexture2", this.resName, 33986));
      addParam(new UniformParam.FloatParam("inputH", paramFloat3));
      addParam(new UniformParam.FloatParam("inputS", paramFloat4));
      addParam(new UniformParam.FloatParam("inputV", paramFloat5));
    }
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (isValid())
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    if (paramBoolean) {
      if ((this.resName != null) || (this.fragmentShaderId != 0))
      {
        this.glslProgramShader = BaseFilter.getFragmentShader(this.fragmentShaderId);
        addParam(new TextureResParam("inputImageTexture2", this.resName, 33986));
        addParam(new UniformParam.FloatParam("inputH", this.inputH));
        addParam(new UniformParam.FloatParam("inputS", this.inputS));
        addParam(new UniformParam.FloatParam("inputV", this.inputV));
      }
    }
    for (;;)
    {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
      BaseFilter localBaseFilter2 = getmNextFilter();
      Object localObject = new BaseFilter(BaseFilter.getFragmentShader(68));
      ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("blurSize", this.blurSize));
      setNextFilter((BaseFilter)localObject, null);
      BaseFilter localBaseFilter1 = new BaseFilter(BaseFilter.getFragmentShader(69));
      localBaseFilter1.addParam(new UniformParam.FloatParam("blurSize", this.blurSize));
      localBaseFilter1.addParam(new UniformParam.FloatParam("intensity", this.intensity * 3.5F));
      ((BaseFilter)localObject).setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 1 });
      if (this.resName == null)
      {
        localObject = localBaseFilter1;
        if (this.fragmentShaderId == 0) {}
      }
      else
      {
        localObject = new BaseFilter(BaseFilter.getFragmentShader(this.fragmentShaderId));
        ((BaseFilter)localObject).addParam(new TextureResParam("inputImageTexture2", this.resName, 33986));
        ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("inputH", this.inputH));
        ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("inputS", this.inputS));
        ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("inputV", this.inputV));
        localBaseFilter1.setNextFilter((BaseFilter)localObject, null);
      }
      ((BaseFilter)localObject).getLastFilter().setNextFilter(localBaseFilter2, null);
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("intensity")) {
      this.intensity = ((Float)paramMap.get("intensity")).floatValue();
    }
    if ((getmNextFilter() != null) && (getmNextFilter().getmNextFilter() != null)) {
      getmNextFilter().getmNextFilter().addParam(new UniformParam.FloatParam("intensity", this.intensity * 3.5F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.filter.art.BaibianFilter
 * JD-Core Version:    0.7.0.1
 */