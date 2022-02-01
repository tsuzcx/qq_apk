package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;

public class GuideFilterRefine2
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nvoid main() {\n   float step_x = 1.0 / width;\n   float step_y = 1.0 / height;\n   vec4 srcValue = vec4(0.0, 0.0, 0.0, 0.0);\n   vec2 fIdx = textureCoordinate;\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   gl_FragColor = srcValue / 9.0;\n}";
  
  public GuideFilterRefine2()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform float width;\nuniform float height;\nvoid main() {\n   float step_x = 1.0 / width;\n   float step_y = 1.0 / height;\n   vec4 srcValue = vec4(0.0, 0.0, 0.0, 0.0);\n   vec2 fIdx = textureCoordinate;\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y - step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x - step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   fIdx = vec2(textureCoordinate.x + step_x, textureCoordinate.y + step_y);\n   srcValue += texture2D(inputImageTexture, fIdx);\n   gl_FragColor = srcValue / 9.0;\n}");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("width", 0.0F));
    addParam(new UniformParam.FloatParam("height", 0.0F));
  }
  
  public void updateParams(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.FloatParam("width", paramInt1));
    addParam(new UniformParam.FloatParam("height", paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.GuideFilterRefine2
 * JD-Core Version:    0.7.0.1
 */