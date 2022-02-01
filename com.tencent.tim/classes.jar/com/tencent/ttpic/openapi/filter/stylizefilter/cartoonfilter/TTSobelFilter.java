package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class TTSobelFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n uniform sampler2D inputImageTexture;\n \n varying vec2 textureCoordinate;\n varying vec2 blurCoordinates[9];\n\n void main() {\n     vec3 src[9];\n     for(int i = 0;i < 9; i++) {\n         if(i == 4) {\n             continue;\n         }\n         \n         src[i] = texture2D(inputImageTexture, blurCoordinates[i]).rgb;\n     }\n    \n     vec3 sobelX = src[2] + 2.0 * src[5] + src[8] - src[0] - 2.0 * src[3] - src[6];\n     vec3 sobelY = src[6] + 2.0 * src[7] + src[8] - src[0] - 2.0 * src[1] - src[2];\n     float dxSquare = dot(sobelX, sobelX);\n     float dySquare = dot(sobelY, sobelY);\n     float dxdy = (dot(sobelX, sobelY) + 1.0) / 2.0;\n     gl_FragColor = vec4(dxSquare, dySquare, dxdy, 1.0);\n }";
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n varying vec2 blurCoordinates[9];\n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n    \n     blurCoordinates[0] = textureCoordinate + vec2(-texelWidthOffset, -texelHeightOffset);\n     blurCoordinates[1] = textureCoordinate + vec2(0., -texelHeightOffset);\n     blurCoordinates[2] = textureCoordinate + vec2(texelWidthOffset, -texelHeightOffset);\n     blurCoordinates[3] = textureCoordinate + vec2(-texelWidthOffset, 0.0);\n     blurCoordinates[4] = textureCoordinate;\n     blurCoordinates[5] = textureCoordinate + vec2(texelWidthOffset, 0.0);\n     blurCoordinates[6] = textureCoordinate + vec2(-texelWidthOffset, texelHeightOffset);\n     blurCoordinates[7] = textureCoordinate + vec2(0., texelHeightOffset);\n     blurCoordinates[8] = textureCoordinate + vec2(texelWidthOffset, texelHeightOffset);\n }";
  
  public TTSobelFilter()
  {
    super("precision highp float;\nattribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n varying vec2 blurCoordinates[9];\n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n void main(void) {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n    \n     blurCoordinates[0] = textureCoordinate + vec2(-texelWidthOffset, -texelHeightOffset);\n     blurCoordinates[1] = textureCoordinate + vec2(0., -texelHeightOffset);\n     blurCoordinates[2] = textureCoordinate + vec2(texelWidthOffset, -texelHeightOffset);\n     blurCoordinates[3] = textureCoordinate + vec2(-texelWidthOffset, 0.0);\n     blurCoordinates[4] = textureCoordinate;\n     blurCoordinates[5] = textureCoordinate + vec2(texelWidthOffset, 0.0);\n     blurCoordinates[6] = textureCoordinate + vec2(-texelWidthOffset, texelHeightOffset);\n     blurCoordinates[7] = textureCoordinate + vec2(0., texelHeightOffset);\n     blurCoordinates[8] = textureCoordinate + vec2(texelWidthOffset, texelHeightOffset);\n }", "precision highp float;\n uniform sampler2D inputImageTexture;\n \n varying vec2 textureCoordinate;\n varying vec2 blurCoordinates[9];\n\n void main() {\n     vec3 src[9];\n     for(int i = 0;i < 9; i++) {\n         if(i == 4) {\n             continue;\n         }\n         \n         src[i] = texture2D(inputImageTexture, blurCoordinates[i]).rgb;\n     }\n    \n     vec3 sobelX = src[2] + 2.0 * src[5] + src[8] - src[0] - 2.0 * src[3] - src[6];\n     vec3 sobelY = src[6] + 2.0 * src[7] + src[8] - src[0] - 2.0 * src[1] - src[2];\n     float dxSquare = dot(sobelX, sobelX);\n     float dySquare = dot(sobelY, sobelY);\n     float dxdy = (dot(sobelX, sobelY) + 1.0) / 2.0;\n     gl_FragColor = vec4(dxSquare, dySquare, dxdy, 1.0);\n }");
    updateWidthHeightParam(0.0F, 0.0F);
  }
  
  public Frame RenderProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    updateWidthHeightParam(1.0F / paramInt2, 1.0F / paramInt3);
    return super.RenderProcess(paramInt1, paramInt2, paramInt3);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    updateWidthHeightParam(1.0F / paramInt2, 1.0F / paramInt3);
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, Frame paramFrame)
  {
    updateWidthHeightParam(1.0F / paramInt4, 1.0F / paramInt5);
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDouble, paramFrame);
  }
  
  public void updateWidthHeightParam(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", paramFloat1));
    addParam(new UniformParam.FloatParam("texelHeightOffset", paramFloat2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTSobelFilter
 * JD-Core Version:    0.7.0.1
 */