package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class GPUImageTwoInputHighPassFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n void main() {\n     lowp vec3 color_0 = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 color_1 = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     color_0 = max(color_0, color_1);\n     gl_FragColor = vec4(color_0, 1.0);\n }\n";
  
  public GPUImageTwoInputHighPassFilter()
  {
    super(" varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n void main() {\n     lowp vec3 color_0 = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 color_1 = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     color_0 = max(color_0, color_1);\n     gl_FragColor = vec4(color_0, 1.0);\n }\n");
    initParams();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
  }
  
  public void updateTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GPUImageTwoInputHighPassFilter
 * JD-Core Version:    0.7.0.1
 */