package com.tencent.taveffect.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.taveffect.utils.TAVGLUtils;
import com.tencent.taveffect.utils.TAVMatrixUtils;
import com.tencent.taveffect.utils.TVTGLProgramUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class TAVRendererFilter
  extends TAVBaseFilter
  implements Cloneable
{
  protected static final int FLOAT_SIZE_BYTES = 4;
  protected static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  protected static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
  protected static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  protected static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
  protected static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
  protected int aPositionHandle;
  protected FloatBuffer triangleVertices;
  private int uAlphaHandle;
  protected int uScreenSizeHandle;
  protected int uTextureSizeHandle;
  
  public TAVRendererFilter()
  {
    this(0, 0);
  }
  
  public TAVRendererFilter(int paramInt1, int paramInt2)
  {
    this.rendererWidth = paramInt1;
    this.rendererHeight = paramInt2;
  }
  
  public TAVTextureInfo applyNewTexture(TAVTextureInfo paramTAVTextureInfo)
  {
    if ((paramTAVTextureInfo.textureType != this.textureType) || (this.program == 0)) {
      initShaderForTextureInfo(paramTAVTextureInfo);
    }
    if (this.cropRect == null) {
      this.cropRect = new TAVRectangle(0.0F, 0.0F, paramTAVTextureInfo.width, paramTAVTextureInfo.height);
    }
    float f1 = this.cropRect.x;
    float f2 = this.cropRect.y;
    float f3 = this.cropRect.height;
    float f4 = this.cropRect.x;
    float f5 = this.cropRect.y;
    float f6 = this.cropRect.x;
    float f7 = this.cropRect.width;
    float f8 = this.cropRect.y;
    float f9 = this.cropRect.height;
    float f10 = this.cropRect.x;
    float f11 = this.cropRect.width;
    float f12 = this.cropRect.y;
    this.triangleVertices.rewind();
    this.triangleVertices.put(new float[] { f1, f2 + f3, f4, f5, f6 + f7, f8 + f9, f10 + f11, f12 });
    GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
    GLES20.glUseProgram(this.program);
    TAVGLUtils.checkEglError("glUseProgram");
    GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.stMatrix), 0);
    GLES20.glUniform1f(this.uAlphaHandle, this.alpha);
    prepareDraw(paramTAVTextureInfo, TAVMatrixUtils.toOpenGL2DMatrix(this.xyMatrix));
    GLES20.glDrawArrays(5, 0, 4);
    TAVGLUtils.checkEglError("glDrawArrays");
    finishDraw(paramTAVTextureInfo);
    return paramTAVTextureInfo;
  }
  
  public TAVRendererFilter clone()
  {
    return (TAVRendererFilter)cloneFilter(new TAVRendererFilter());
  }
  
  protected void finishDraw(TAVTextureInfo paramTAVTextureInfo)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.textureType, 0);
    GLES20.glViewport(this.defaultViewport[0], this.defaultViewport[1], this.defaultViewport[2], this.defaultViewport[3]);
  }
  
  public int hashCode()
  {
    return (((((((this.program + 0) * 31 + this.uScreenSizeHandle) * 31 + this.uTextureSizeHandle) * 31 + this.xyMatrixHandle) * 31 + this.uAlphaHandle) * 31 + this.stMatrixHandle) * 31 + this.aPositionHandle) * 31 + Arrays.hashCode(this.defaultViewport);
  }
  
  protected void initShaderForTextureInfo(TAVTextureInfo paramTAVTextureInfo)
  {
    if (paramTAVTextureInfo.textureType == 36197) {
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
    }
    for (;;)
    {
      this.textureType = paramTAVTextureInfo.textureType;
      return;
      initShaders("uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n");
    }
  }
  
  protected void initShaders(String paramString1, String paramString2)
  {
    this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.vertexShaderCode = paramString1;
    this.fragmentShaderCode = paramString2;
    this.program = TVTGLProgramUtils.createProgram(paramString1, paramString2);
    if (this.program == 0)
    {
      new RuntimeException("failed creating program").printStackTrace();
      return;
    }
    this.aPositionHandle = GLES20.glGetAttribLocation(this.program, "aPosition");
    TAVGLUtils.checkEglError("glGetAttribLocation aPosition");
    this.xyMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation uMatrix");
    this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
    TAVGLUtils.checkEglError("glGetUniformLocation uAlpha");
    this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
    TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
    this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
    TAVGLUtils.checkEglError("glGetUniformLocation uScreenSize");
    this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
    TAVGLUtils.checkEglError("glGetUniformLocation uTextureSize");
  }
  
  protected void prepareDraw(TAVTextureInfo paramTAVTextureInfo, float[] paramArrayOfFloat)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(paramTAVTextureInfo.textureType, paramTAVTextureInfo.textureID);
    this.triangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, this.triangleVertices);
    TAVGLUtils.checkEglError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.aPositionHandle);
    TAVGLUtils.checkEglError("glEnableVertexAttribArray aPositionHandle");
    GLES20.glUniformMatrix3fv(this.xyMatrixHandle, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform2f(this.uTextureSizeHandle, paramTAVTextureInfo.width, paramTAVTextureInfo.height);
    GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
  }
  
  public void release()
  {
    GLES20.glDeleteProgram(this.program);
    this.program = 0;
  }
  
  public void setParams(Matrix paramMatrix1, Matrix paramMatrix2, TAVRectangle paramTAVRectangle, float paramFloat)
  {
    this.alpha = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.taveffect.core.TAVRendererFilter
 * JD-Core Version:    0.7.0.1
 */