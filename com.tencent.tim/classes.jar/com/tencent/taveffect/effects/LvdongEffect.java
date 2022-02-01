package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

public class LvdongEffect
  extends BaseEffect
{
  private static String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nuniform float myProgress;\nvarying vec2 vTextureCoord;\nfloat blurDistance = 0.3;\nfloat maxScale = 1.25;\nfloat maxBlurStrength = 20.0;\nvoid main()\n{\n    float progress = clamp(myProgress, 0.0, 1.0);\n\n    float currScale = 1.0 / mix(1.0, maxScale, progress);\n    vec2 originTexCoord = vTextureCoord;\n    vec2 dir = vec2(0.5, 0.5) - vTextureCoord;\n    float dist = length(dir);\n    vec2 scaleTexCoord = -dir * 2.0 * currScale;\n    scaleTexCoord = scaleTexCoord / 2.0 + vec2(0.5, 0.5);\n\n    vec2 sampleDir = dir * blurDistance;\n    vec4 sum = texture2D(sTexture, originTexCoord - sampleDir * 0.01);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.02);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.03);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.04);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.05);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.06);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.08);\n    sum += texture2D(sTexture, originTexCoord - sampleDir * 0.1);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.01);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.02);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.03);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.04);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.05);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.06);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.08);\n    sum += texture2D(sTexture, originTexCoord + sampleDir * 0.1);\n    sum /= 16.0;\n\n    vec4 scaleColor = texture2D(sTexture, scaleTexCoord);\n\n    vec4 col = texture2D(sTexture, originTexCoord);\n\n    float blurProgress = 2.0 * progress - 1.0;\n    float flag = clamp(blurProgress * 1e08, 0.0, 1.0);\n    blurProgress = abs(blurProgress);\n    float blurStrengthUp = mix(maxBlurStrength, 0.0, blurProgress);\n    float blurStrengthDown = mix(maxBlurStrength, 0.0, blurProgress);\n\n    float currBlurStrength = blurStrengthUp * (1.0 - flag) + flag * blurStrengthDown;\n\n    float strength = clamp(dist * currBlurStrength, 0.0, 1.0);\n    gl_FragColor = progress * mix(col, sum, strength) + (1.0 - progress) * scaleColor;\n}";
  private float delayTime;
  private int myProgressHandle;
  private float progress;
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.progress < 1.01F) {
      this.progress += 0.15F;
    }
    for (;;)
    {
      GLES20.glUniform1f(this.myProgressHandle, this.progress);
      TAVGLUtils.checkEglError("glUniform1f myProgressHandle");
      return;
      this.delayTime += 0.05F;
      if (this.delayTime > 0.1F)
      {
        this.delayTime = 0.0F;
        this.progress = 0.0F;
      }
    }
  }
  
  public LvdongEffect clone()
  {
    return (LvdongEffect)cloneFilter(new LvdongEffect());
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + FRAGMENT_SHADER_CODE;
    }
    return "uniform sampler2D " + FRAGMENT_SHADER_CODE;
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.myProgressHandle = GLES20.glGetUniformLocation(this.program, "myProgress");
    TAVGLUtils.checkEglError("glGetAttribLocation myProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.taveffect.effects.LvdongEffect
 * JD-Core Version:    0.7.0.1
 */