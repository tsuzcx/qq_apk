import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public class ayyx
  extends GPUBaseFilter
{
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  private static final FloatBuffer VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  private float Hc = 0.0327F;
  private float Hd;
  private int eNp = -1;
  private int eNq = -1;
  private int mHeight;
  private int mWidth;
  
  public ayyx()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nuniform sampler2D alphaTexture;\n\nvoid main() {\n      gl_FragColor = texture2D(uTexture, vTextureCoord);\n      gl_FragColor.a = texture2D(alphaTexture, vTextureCoord).a;\n}\n");
  }
  
  private void b(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
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
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glUseProgram(paramInt);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(paramInt, "aPosition");
    checkLocation(i, "aPosition");
    int j = GLES20.glGetAttribLocation(paramInt, "aTextureCoord");
    checkLocation(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(paramInt, "uMVPMatrix");
    checkLocation(k, "uMVPMatrix");
    int m = GLES20.glGetUniformLocation(paramInt, "uTextureMatrix");
    checkLocation(m, "uTextureMatrix");
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
    GLES20.glUniform1f(GLES20.glGetUniformLocation(paramInt, "radius"), this.Hc);
    GLES20.glUniform1f(GLES20.glGetUniformLocation(paramInt, "heightWidthRatio"), this.Hd);
    GLES20.glUniform1f(GLES20.glGetUniformLocation(paramInt, "unitPx"), 1.0F / this.mWidth);
    checkGlError("unitPxLocation");
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glDisable(3042);
  }
  
  private void lF(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(33984);
    this.eNp = GlUtil.createTexture(3553);
    checkGlError("GlUtil.createTexture(GLES20.GL_TEXTURE_2D)");
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, (Buffer)null);
    checkGlError("GLES20.glTexImage2D");
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.eNq = arrayOfInt[0];
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    GLES20.glBindFramebuffer(36160, this.eNq);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.eNp, 0);
    checkGlError("glFramebufferTexture2D");
    paramInt1 = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform float radius;\nuniform float heightWidthRatio;\nuniform float unitPx;\nvoid main() {\n    float x = abs(vTextureCoord.x-0.5)-(0.5-radius);\n    float y = vTextureCoord.y*heightWidthRatio;\n    y = abs(y-heightWidthRatio/2.0)-(heightWidthRatio/2.0-radius);\n    float distance = sqrt(x*x + y*y);\n    float alpha = 1.0 - step(0.0, x)*step(0.0, y)*step(radius-1.5*unitPx, distance)*((distance-(radius-1.5*unitPx))/(unitPx*1.5));\n      gl_FragColor.a = alpha;\n}\n");
    b(paramInt1, null, null);
    GLES20.glDeleteProgram(paramInt1);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void destroy()
  {
    super.destroy();
    GLES20.glDeleteFramebuffers(1, new int[] { this.eNq }, 0);
    GlUtil.deleteTexture(this.eNp);
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int i = getProgram();
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
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(770, 771);
    GLES20.glUseProgram(i);
    checkGlError("glUseProgram");
    int j = GLES20.glGetAttribLocation(i, "aPosition");
    checkLocation(j, "aPosition");
    int k = GLES20.glGetAttribLocation(i, "aTextureCoord");
    checkLocation(k, "aTextureCoord");
    int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    checkLocation(m, "uMVPMatrix");
    int n = GLES20.glGetUniformLocation(i, "uTextureMatrix");
    checkLocation(n, "uTextureMatrix");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, VERTEXT_BUF);
    checkGlError("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(j);
    checkGlError("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, TEXTURE_BUF);
    checkGlError("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(k);
    checkGlError("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "uTexture"), 0);
    checkGlError("uTextureLoc");
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "alphaTexture"), 1);
    checkGlError("alphaTextureLoc");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    checkGlError("glBindTexture GL_TEXTURE0");
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, this.eNp);
    checkGlError("glBindTexture GL_TEXTURE1");
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(this.mTextureType, 0);
    GLES20.glDisable(3042);
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    super.init();
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.Hd = (this.mHeight / this.mWidth);
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3)
  {
    init(paramInt1, paramInt2);
    this.Hc = (paramInt3 / this.mWidth);
    lF(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayyx
 * JD-Core Version:    0.7.0.1
 */