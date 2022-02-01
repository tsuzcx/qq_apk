package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.Float3fParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.BaseFilter;

public class AWBFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform vec3 rgbGain; \n\nvoid main() {\n  vec3 color = texture2D(inputImageTexture, textureCoordinate).rgb;\n  float gray = dot(color, vec3(0.299, 0.587, 0.114)); \n  if (gray < 0.98) color = clamp(color * rgbGain, vec3(0.0), vec3(1.0)); \n  gl_FragColor = vec4(color, 1.0); \n}\n";
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  
  public AWBFilter()
  {
    super(BaseFilter.nativeDecrypt("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}"), BaseFilter.nativeDecrypt("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform vec3 rgbGain; \n\nvoid main() {\n  vec3 color = texture2D(inputImageTexture, textureCoordinate).rgb;\n  float gray = dot(color, vec3(0.299, 0.587, 0.114)); \n  if (gray < 0.98) color = clamp(color * rgbGain, vec3(0.0), vec3(1.0)); \n  gl_FragColor = vec4(color, 1.0); \n}\n"));
    initParams();
  }
  
  public void initParams()
  {
    addParam(new UniformParam.Float3fParam("rgbGain", 1.0F, 1.0F, 1.0F));
  }
  
  public void setRGBGain(float[] paramArrayOfFloat)
  {
    addParam(new UniformParam.Float3fParam("rgbGain", paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.AWBFilter
 * JD-Core Version:    0.7.0.1
 */