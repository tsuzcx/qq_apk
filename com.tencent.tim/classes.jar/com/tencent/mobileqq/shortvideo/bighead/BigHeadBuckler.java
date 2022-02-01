package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class BigHeadBuckler
{
  public static final int FLOAT_SIZE_BYTES = 4;
  public static final String NO_FILTER_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureMaskCoord;\nuniform sampler2D uTexture;\nuniform sampler2D uTextureMask;\n\nvoid main() {\n    vec4 color;\n    vec4 frame = texture2D(uTexture, vTextureCoord);\n    vec4 mask  = texture2D(uTextureMask, vTextureMaskCoord);\n    if(mask.r == 1.0){\n       color = vec4(frame.rgb,mask.a);\n    }else{\n       color = vec4(0,0,0,0);\n    }\n    gl_FragColor = color;\n}\n";
  public static final String NO_FILTER_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nuniform mat4 uTextureMaskMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureMaskCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    vTextureMaskCoord = (uTextureMaskMatrix * aTextureCoord).xy;\n}\n";
  private static final FloatBuffer TEXTURE_BUF;
  public static final float[] TEXUTURE_COORDS;
  private static final FloatBuffer VERTEXT_BUF;
  public static final float[] VERTEXT_COORDS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] sGIdentity;
  private final String mFragmentShader;
  private boolean mIsInitialized;
  private int mProgram;
  public int mTextureType = 3553;
  private final String mVertexShader;
  
  static
  {
    TEXUTURE_COORDS = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
    TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
    sGIdentity = new float[16];
    Matrix.setIdentityM(sGIdentity, 0);
  }
  
  public BigHeadBuckler()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nuniform mat4 uTextureMaskMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureMaskCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    vTextureMaskCoord = (uTextureMaskMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureMaskCoord;\nuniform sampler2D uTexture;\nuniform sampler2D uTextureMask;\n\nvoid main() {\n    vec4 color;\n    vec4 frame = texture2D(uTexture, vTextureCoord);\n    vec4 mask  = texture2D(uTextureMask, vTextureMaskCoord);\n    if(mask.r == 1.0){\n       color = vec4(frame.rgb,mask.a);\n    }else{\n       color = vec4(0,0,0,0);\n    }\n    gl_FragColor = color;\n}\n");
  }
  
  public BigHeadBuckler(String paramString1, String paramString2)
  {
    this.mVertexShader = paramString1;
    this.mFragmentShader = paramString2;
    this.mTextureType = 3553;
  }
  
  public void destroy()
  {
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mProgram);
    this.mProgram = 0;
  }
  
  public void drawTexture(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    int i = this.mProgram;
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null) {
      arrayOfFloat = sGIdentity;
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null) {
      paramArrayOfFloat1 = sGIdentity;
    }
    paramArrayOfFloat2 = paramArrayOfFloat3;
    if (paramArrayOfFloat3 == null) {
      paramArrayOfFloat2 = sGIdentity;
    }
    GLES20.glUseProgram(i);
    int j = GLES20.glGetAttribLocation(i, "aPosition");
    int k = GLES20.glGetAttribLocation(i, "aTextureCoord");
    int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    int n = GLES20.glGetUniformLocation(i, "uTextureMatrix");
    int i1 = GLES20.glGetUniformLocation(i, "uTextureMaskMatrix");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, VERTEXT_BUF);
    GLES20.glEnableVertexAttribArray(j);
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, TEXTURE_BUF);
    GLES20.glEnableVertexAttribArray(k);
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat2, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(i1, 1, false, paramArrayOfFloat1, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt1);
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "uTexture"), 0);
    paramInt1 = GLES20.glGetUniformLocation(i, "uTextureMask");
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, paramInt2);
    GLES20.glUniform1i(paramInt1, 1);
    GLES20.glDrawArrays(5, 0, 4);
    paramInt1 = GLES20.glGetError();
    if (paramInt1 != 0) {
      throw new RuntimeException("error =" + paramInt1);
    }
  }
  
  public void init()
  {
    if (this.mIsInitialized) {
      return;
    }
    this.mProgram = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
    if (this.mProgram == 0) {
      new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
    }
    this.mIsInitialized = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.BigHeadBuckler
 * JD-Core Version:    0.7.0.1
 */