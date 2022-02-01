package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.FloatBuffer;

public class GPUTextureMergeFilter
  extends GPUBaseFilter
{
  private static final String MERGE_FRAG_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D oriTexture;\nuniform sampler2D filterTexture;\nuniform sampler2D maskTexture;\n\nvoid main() {\n    float maskFactor = texture2D(maskTexture, vTextureCoord).a;\n    gl_FragColor = texture2D(oriTexture, vTextureCoord) * (1.0 - maskFactor) + texture2D(filterTexture, vTextureCoord) * maskFactor;\n}\n";
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  
  public GPUTextureMergeFilter()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D oriTexture;\nuniform sampler2D filterTexture;\nuniform sampler2D maskTexture;\n\nvoid main() {\n    float maskFactor = texture2D(maskTexture, vTextureCoord).a;\n    gl_FragColor = texture2D(oriTexture, vTextureCoord) * (1.0 - maskFactor) + texture2D(filterTexture, vTextureCoord) * maskFactor;\n}\n");
  }
  
  public void drawTexture(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int i2 = getProgram();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(i2);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(i2, "aPosition");
    checkLocation(i, "aPosition");
    int j = GLES20.glGetAttribLocation(i2, "aTextureCoord");
    checkLocation(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(i2, "uMVPMatrix");
    checkLocation(k, "uMVPMatrix");
    int m = GLES20.glGetUniformLocation(i2, "uTextureMatrix");
    checkLocation(m, "uTextureMatrix");
    int n = GLES20.glGetUniformLocation(i2, "oriTexture");
    int i1 = GLES20.glGetUniformLocation(i2, "filterTexture");
    i2 = GLES20.glGetUniformLocation(i2, "maskTexture");
    checkLocation(i2, "maskTexture");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, VERTEXT_BUF);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, TEXTURE_BUF);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glUniform1i(n, 0);
    GLES20.glUniform1i(i1, 1);
    GLES20.glUniform1i(i2, 2);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt1);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, paramInt2);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(this.mTextureType, paramInt3);
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(this.mTextureType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUTextureMergeFilter
 * JD-Core Version:    0.7.0.1
 */