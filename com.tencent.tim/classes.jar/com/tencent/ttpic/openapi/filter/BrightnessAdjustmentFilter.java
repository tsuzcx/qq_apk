package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.filter.GLSLRender;
import com.tencent.view.RendererUtils;

public class BrightnessAdjustmentFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float alpha;\nvoid main() {\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n  float r = texture2D(inputImageTexture2, vec2(color.r, 0.5)).r;\n  float g = texture2D(inputImageTexture2, vec2(color.g, 0.5)).r;\n  float b = texture2D(inputImageTexture2, vec2(color.b, 0.5)).r;\n  vec4 result = vec4(r, g, b, 1.0);\n  gl_FragColor = mix(color, result, alpha);\n}\n";
  private static final String VERTEX_SHADER = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
  private int counter = 5;
  private int[] lastCurve = new int[256];
  private boolean lastStable = true;
  private int paramTEXTRUEID = 0;
  
  public BrightnessAdjustmentFilter()
  {
    super("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float alpha;\nvoid main() {\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n  float r = texture2D(inputImageTexture2, vec2(color.r, 0.5)).r;\n  float g = texture2D(inputImageTexture2, vec2(color.g, 0.5)).r;\n  float b = texture2D(inputImageTexture2, vec2(color.b, 0.5)).r;\n  vec4 result = vec4(r, g, b, 1.0);\n  gl_FragColor = mix(color, result, alpha);\n}\n");
    initParams();
  }
  
  private void setTextureParam(int paramInt1, int paramInt2)
  {
    paramInt2 += 2;
    String str = "inputImageTexture" + paramInt2;
    int i = GLES20.glGetUniformLocation(getProgramIds(), str);
    if (i >= 0)
    {
      GLES20.glActiveTexture(33984 + paramInt2);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(i, paramInt2);
    }
  }
  
  public void ApplyGLSLFilter()
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    super.ApplyGLSLFilter();
  }
  
  public void clearGLSLSelf()
  {
    RendererUtils.clearTexture(this.paramTEXTRUEID);
    super.clearGLSLSelf();
  }
  
  public void initParams()
  {
    int i = 0;
    while (i < 256)
    {
      this.lastCurve[i] = i;
      i += 1;
    }
    addParam(new UniformParam.FloatParam("alpha", 1.0F));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    setTextureParam(this.paramTEXTRUEID, 0);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setBlendAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("alpha", paramFloat));
  }
  
  public void updateCurve(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (paramBoolean)
    {
      this.lastStable = true;
      while (i < 256)
      {
        this.lastCurve[i] = paramArrayOfInt[i];
        i += 1;
      }
    }
    if (paramArrayOfInt[''] == this.lastCurve['']) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((this.lastStable) && (!paramBoolean)) {
        this.counter = 5;
      }
      this.lastStable = paramBoolean;
      if (paramBoolean) {
        break;
      }
      this.counter = Math.max(1, this.counter - 1);
      int[] arrayOfInt = new int[256];
      i = j;
      while (i < 256)
      {
        arrayOfInt[i] = ((paramArrayOfInt[i] - this.lastCurve[i]) / this.counter + this.lastCurve[i]);
        this.lastCurve[i] = arrayOfInt[i];
        i += 1;
      }
    }
    GLSLRender.nativeTextCure(this.lastCurve, this.paramTEXTRUEID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.BrightnessAdjustmentFilter
 * JD-Core Version:    0.7.0.1
 */