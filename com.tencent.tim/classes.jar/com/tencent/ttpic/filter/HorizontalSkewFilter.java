package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE;
import java.util.Map;

public class HorizontalSkewFilter
  extends ShakaFilterBase
{
  private static final String[] PARAM_KEYS = { "adjust" };
  
  public HorizontalSkewFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.SHAKA_HORIZONTAL_SKEW);
  }
  
  private void setParams(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("adjust", paramFloat));
  }
  
  protected float getDefaultParamValue()
  {
    return 0.0F;
  }
  
  protected String[] getParamKeys()
  {
    return PARAM_KEYS;
  }
  
  public void initParams()
  {
    setParams(1.0F);
  }
  
  public void setParameterDic(Map<String, Float> paramMap)
  {
    setParams(((Float)paramMap.get("adjust")).floatValue());
  }
  
  static enum PARAM_KEY
  {
    ADJUST("adjust");
    
    public final String value;
    
    private PARAM_KEY(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.HorizontalSkewFilter
 * JD-Core Version:    0.7.0.1
 */