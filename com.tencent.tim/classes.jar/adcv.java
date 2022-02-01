import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;
import java.nio.FloatBuffer;

public class adcv
{
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  public static final float[] TEXUTURE_COORDS;
  private static final FloatBuffer VERTEXT_BUF;
  public static float[] VERTEXT_COORDS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  protected int mFilterType = 101;
  private final String mFragmentShader;
  private boolean mIsInitialized;
  protected int mOutputHeight;
  protected int mOutputWidth;
  private int mProgram;
  public int mTextureType = 3553;
  private final String mVertexShader;
  
  static
  {
    TEXUTURE_COORDS = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  }
  
  public adcv()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public adcv(String paramString1, String paramString2)
  {
    this.mVertexShader = paramString1;
    this.mFragmentShader = paramString2;
    this.mTextureType = 3553;
    this.mFilterType = 101;
  }
  
  public static void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      SLog.e("GPUBaseFilter", new RuntimeException(paramString + ": glError " + i));
    }
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      SLog.e("GPUBaseFilter", new RuntimeException("Unable to locate '" + paramString + "' in program"));
    }
  }
  
  public void destroy()
  {
    SLog.d("GPUBaseFilter", "destroy");
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mProgram);
    this.mProgram = 0;
    onDestroy();
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    checkGlError("onDrawFrame start");
    int m = getProgram();
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
    GLES20.glUseProgram(m);
    checkGlError("glUseProgram");
    int i = GLES20.glGetAttribLocation(m, "aPosition");
    checkLocation(i, "aPosition");
    int j = GLES20.glGetAttribLocation(m, "aTextureCoord");
    checkLocation(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(m, "uMVPMatrix");
    checkLocation(k, "uMVPMatrix");
    m = GLES20.glGetUniformLocation(m, "uTextureMatrix");
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
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    onDrawTexture();
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, 0);
  }
  
  public int getProgram()
  {
    return this.mProgram;
  }
  
  public void init()
  {
    if (this.mIsInitialized) {
      return;
    }
    this.mProgram = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
    if (this.mProgram == 0) {
      SLog.e("GPUBaseFilter", new RuntimeException("failed creating program " + getClass().getSimpleName()));
    }
    this.mIsInitialized = true;
    onInitialized();
  }
  
  protected void onDestroy() {}
  
  protected void onDrawTexture() {}
  
  protected void onInitialized() {}
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcv
 * JD-Core Version:    0.7.0.1
 */