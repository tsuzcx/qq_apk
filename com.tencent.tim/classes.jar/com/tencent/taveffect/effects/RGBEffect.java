package com.tencent.taveffect.effects;

import android.opengl.GLES20;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;

public class RGBEffect
  extends BaseEffect
{
  private static final String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float progress;\nuniform vec2 maxOffset;\nvoid main()\n{\n    float updateProgress = clamp(progress, 0.0, 1.0);\n    vec2 offset = mix(vec2(0.0, 0.0), maxOffset, updateProgress);\n    vec4 shadowG = texture2D(sTexture, vTextureCoord);\n    vec4 shadowGColor = vec4(0.0, shadowG.y, 0.0, 1.0);\n    vec4 shadowR = texture2D(sTexture, vTextureCoord + offset);\n    vec4 shadowRColor = vec4(shadowR.x, 0.0, 0.0, 1.0);\n    vec4 shadowB = texture2D(sTexture, vTextureCoord - offset);\n    vec4 shadowBColor = vec4(0.0, 0.0, shadowB.z, 1.0);\n    gl_FragColor = (shadowRColor + shadowGColor + shadowBColor);\n}";
  private float delayTime;
  private int maxOffsetHandle;
  private float progress;
  private int progressHandle;
  
  protected void beforeDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    if (this.progress <= 1.01F) {
      this.progress += 0.03F;
    }
    for (;;)
    {
      GLES20.glUniform2f(this.maxOffsetHandle, 0.05F, 0.0F);
      TAVGLUtils.checkEglError("glUniform2f maxOffsetHandle");
      GLES20.glUniform1f(this.progressHandle, this.progress);
      TAVGLUtils.checkEglError("glUniform1f progressHandle");
      return;
      this.delayTime += 0.03F;
      if (this.delayTime > 0.3F)
      {
        this.progress = 0.0F;
        this.delayTime = 0.0F;
      }
    }
  }
  
  public RGBEffect clone()
  {
    return (RGBEffect)cloneFilter(new RGBEffect());
  }
  
  protected String getFragmentShaderCode(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float progress;\nuniform vec2 maxOffset;\nvoid main()\n{\n    float updateProgress = clamp(progress, 0.0, 1.0);\n    vec2 offset = mix(vec2(0.0, 0.0), maxOffset, updateProgress);\n    vec4 shadowG = texture2D(sTexture, vTextureCoord);\n    vec4 shadowGColor = vec4(0.0, shadowG.y, 0.0, 1.0);\n    vec4 shadowR = texture2D(sTexture, vTextureCoord + offset);\n    vec4 shadowRColor = vec4(shadowR.x, 0.0, 0.0, 1.0);\n    vec4 shadowB = texture2D(sTexture, vTextureCoord - offset);\n    vec4 shadowBColor = vec4(0.0, 0.0, shadowB.z, 1.0);\n    gl_FragColor = (shadowRColor + shadowGColor + shadowBColor);\n}";
    }
    return "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform float progress;\nuniform vec2 maxOffset;\nvoid main()\n{\n    float updateProgress = clamp(progress, 0.0, 1.0);\n    vec2 offset = mix(vec2(0.0, 0.0), maxOffset, updateProgress);\n    vec4 shadowG = texture2D(sTexture, vTextureCoord);\n    vec4 shadowGColor = vec4(0.0, shadowG.y, 0.0, 1.0);\n    vec4 shadowR = texture2D(sTexture, vTextureCoord + offset);\n    vec4 shadowRColor = vec4(shadowR.x, 0.0, 0.0, 1.0);\n    vec4 shadowB = texture2D(sTexture, vTextureCoord - offset);\n    vec4 shadowBColor = vec4(0.0, 0.0, shadowB.z, 1.0);\n    gl_FragColor = (shadowRColor + shadowGColor + shadowBColor);\n}";
  }
  
  protected void initShader(TAVTextureInfo paramTAVTextureInfo)
  {
    super.initShader(paramTAVTextureInfo);
    this.maxOffsetHandle = GLES20.glGetUniformLocation(this.program, "maxOffset");
    TAVGLUtils.checkEglError("glGetAttribLocation maxOffset");
    this.progressHandle = GLES20.glGetUniformLocation(this.program, "progress");
    TAVGLUtils.checkEglError("glGetAttribLocation progress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.taveffect.effects.RGBEffect
 * JD-Core Version:    0.7.0.1
 */