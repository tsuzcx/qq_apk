import android.content.Context;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class addj
{
  private static final String TAG = addj.class.getSimpleName();
  private final String FRAGMENT_SHADER = "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}";
  private final String VERTEX_SHADER = "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}";
  public final float[] bD = { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F };
  public final float[] bE = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private boolean bLS;
  private int cCV;
  private int cCW;
  private int cCX;
  private int cCY;
  private FloatBuffer e;
  private FloatBuffer f;
  private FloatBuffer g;
  private int mTextureId = -1;
  private int mTextureTarget = 36197;
  
  public void L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.bLS) {
      return;
    }
    this.bLS = true;
    float f1 = paramInt1 / paramInt2;
    float f2 = paramInt3 / paramInt4;
    Object localObject;
    if (f1 < f2)
    {
      f1 = f2 / f1;
      localObject = this.bD;
      localObject[1] *= f1;
      localObject = this.bD;
      localObject[3] *= f1;
      localObject = this.bD;
      localObject[5] *= f1;
      localObject = this.bD;
      localObject[7] = (f1 * localObject[7]);
    }
    for (;;)
    {
      localObject = ByteBuffer.allocateDirect(this.bD.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.e = ((ByteBuffer)localObject).asFloatBuffer();
      this.e.put(this.bD);
      this.e.position(0);
      localObject = ByteBuffer.allocateDirect(32);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.f = ((ByteBuffer)localObject).asFloatBuffer();
      this.f.put(this.bE);
      this.f.position(0);
      return;
      f1 /= f2;
      localObject = this.bD;
      localObject[0] *= f1;
      localObject = this.bD;
      localObject[2] *= f1;
      localObject = this.bD;
      localObject[4] *= f1;
      localObject = this.bD;
      localObject[6] = (f1 * localObject[6]);
    }
  }
  
  public void a(FloatBuffer paramFloatBuffer)
  {
    adlc.fp(TAG, "before draw");
    this.g = paramFloatBuffer;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glColorMask(true, true, true, true);
    GLES20.glClear(16640);
    GLES20.glDepthMask(false);
    GLES20.glDisable(2929);
    GLES20.glDisable(3042);
    GLES20.glUseProgram(this.cCV);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.mTextureId);
    GLES20.glUniform1i(this.cCY, 0);
    GLES20.glVertexAttribPointer(this.cCW, 2, 5126, false, 0, this.e);
    GLES20.glVertexAttribPointer(this.cCX, 2, 5126, false, 0, this.g);
    GLES20.glEnableVertexAttribArray(this.cCW);
    GLES20.glEnableVertexAttribArray(this.cCX);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.cCW);
    GLES20.glDisableVertexAttribArray(this.cCX);
    GLES20.glEnable(2929);
    adlc.fp(TAG, "after draw");
  }
  
  public void dY(Context paramContext)
  {
    Object localObject = new int[1];
    GLES20.glGenTextures(1, (int[])localObject, 0);
    this.mTextureId = localObject[0];
    GLES20.glBindTexture(this.mTextureTarget, this.mTextureId);
    GLES20.glTexParameteri(this.mTextureTarget, 10242, 33071);
    GLES20.glTexParameteri(this.mTextureTarget, 10243, 33071);
    GLES20.glTexParameteri(this.mTextureTarget, 10241, 9728);
    GLES20.glTexParameteri(this.mTextureTarget, 10240, 9728);
    if (4 != this.bD.length / 2) {
      throw new RuntimeException("Unexpected number of vertices in BackgroundRenderer.");
    }
    localObject = ByteBuffer.allocateDirect(32);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.g = ((ByteBuffer)localObject).asFloatBuffer();
    int i = adlc.a(TAG, paramContext, 35633, "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\n\nvarying vec2 v_TexCoord;\n\nvoid main() {\n   gl_Position = a_Position;\n   v_TexCoord = a_TexCoord;\n}");
    int j = adlc.a(TAG, paramContext, 35632, "\n#extension GL_OES_EGL_image_external : require\n\nprecision mediump float;\nvarying vec2 v_TexCoord;\nuniform samplerExternalOES sTexture;\n\n\nvoid main() {\n    gl_FragColor = texture2D(sTexture, v_TexCoord);\n}");
    this.cCV = GLES20.glCreateProgram();
    GLES20.glAttachShader(this.cCV, i);
    GLES20.glAttachShader(this.cCV, j);
    GLES20.glLinkProgram(this.cCV);
    GLES20.glUseProgram(this.cCV);
    adlc.fp(TAG, "program creation");
    this.cCW = GLES20.glGetAttribLocation(this.cCV, "a_Position");
    this.cCX = GLES20.glGetAttribLocation(this.cCV, "a_TexCoord");
    this.cCY = GLES20.glGetAttribLocation(this.cCV, "sTexture");
    adlc.fp(TAG, "program parameters");
  }
  
  public int getTextureId()
  {
    return this.mTextureId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addj
 * JD-Core Version:    0.7.0.1
 */