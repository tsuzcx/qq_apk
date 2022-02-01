import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class aypn
{
  private float[] mMVPMatrix = new float[16];
  private int mProgram;
  private float[] mSTMatrix = new float[16];
  private int mTextureID = -12345;
  private FloatBuffer mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final float[] mTriangleVerticesData = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int maPositionHandle;
  private int maTextureHandle;
  private int muMVPMatrixHandle;
  private int muSTMatrixHandle;
  
  public aypn()
  {
    this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
    Matrix.setIdentityM(this.mSTMatrix, 0);
  }
  
  public static void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      throw new RuntimeException("Unable to locate '" + paramString + "' in program");
    }
  }
  
  private int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = loadShader(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    if (k == 0) {
      Log.e("STextureRender", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    checkGlError("glAttachShader");
    GLES20.glAttachShader(k, j);
    checkGlError("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("STextureRender", "Could not link program: ");
      Log.e("STextureRender", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    checkGlError("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("STextureRender", "Could not compile shader " + paramInt + ":");
      Log.e("STextureRender", " " + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  public void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      Log.e("STextureRender", paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
  
  public void drawFrame(SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    checkGlError("onDrawFrame start");
    Log.e("STextureRender", Arrays.toString(this.mSTMatrix));
    Log.e("STextureRender", String.valueOf(paramBoolean));
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.mProgram);
    checkGlError("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.mTextureID);
    this.mTriangleVertices.position(0);
    GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mTriangleVertices);
    checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.maPositionHandle);
    checkGlError("glEnableVertexAttribArray maPositionHandle");
    this.mTriangleVertices.position(3);
    GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, this.mTriangleVertices);
    checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.maTextureHandle);
    checkGlError("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
    GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
    GLES20.glDrawArrays(5, 0, 4);
    checkGlError("glDrawArrays");
    GLES20.glBindTexture(36197, 0);
  }
  
  public int getTextureId()
  {
    return this.mTextureID;
  }
  
  public void surfaceCreated()
  {
    this.mProgram = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    if (this.mProgram == 0) {
      throw new RuntimeException("failed creating program");
    }
    this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
    checkLocation(this.maPositionHandle, "aPosition");
    this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
    checkLocation(this.maTextureHandle, "aTextureCoord");
    this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
    checkLocation(this.muMVPMatrixHandle, "uMVPMatrix");
    this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
    checkLocation(this.muSTMatrixHandle, "uSTMatrix");
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.mTextureID = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.mTextureID);
    checkGlError("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9728.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    checkGlError("glTexParameter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypn
 * JD-Core Version:    0.7.0.1
 */