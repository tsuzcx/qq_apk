package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;

public class Curve2D
  extends BaseFilter
{
  private float[] transMat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  
  public Curve2D()
  {
    super(BaseFilter.getFragmentShader(7));
    addParam(new UniformParam.FloatsParam("colorMat", this.transMat));
    addParam(new UniformParam.FloatsParam("transMat", new float[] { 1.0F, 1.0F, 0.0F, 0.0F }));
  }
  
  public Curve2D(int paramInt, String paramString)
  {
    super(BaseFilter.getFragmentShader(paramInt));
    addParam(new UniformParam.FloatsParam("colorMat", this.transMat));
    addParam(new TextureResParam("inputImageTexture2", paramString, 33986));
  }
  
  public Curve2D(String paramString)
  {
    this();
    addParam(new TextureResParam("inputImageTexture2", paramString, 33986));
  }
  
  public void setMatrix(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.FloatsParam("colorMat", paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.filter.Curve2D
 * JD-Core Version:    0.7.0.1
 */