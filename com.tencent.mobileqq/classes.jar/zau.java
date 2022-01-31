import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class zau
{
  private int jdField_a_of_type_Int;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private final float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int jdField_b_of_type_Int = -12345;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private int jdField_c_of_type_Int;
  private float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private int d;
  private int e;
  private int f;
  
  public zau()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat).position(0);
    Matrix.setIdentityM(this.jdField_c_of_type_ArrayOfFloat, 0);
  }
  
  private int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      Log.e("OESTextureRender", "Could not compile shader " + paramInt + ":");
      Log.e("OESTextureRender", " " + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  private int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = a(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    a("glCreateProgram");
    if (k == 0) {
      Log.e("OESTextureRender", "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    a("glAttachShader");
    GLES20.glAttachShader(k, j);
    a("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      Log.e("OESTextureRender", "Could not link program: ");
      Log.e("OESTextureRender", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    if (this.jdField_a_of_type_Int == 0) {
      throw new RuntimeException("failed creating program");
    }
    this.e = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "aPosition");
    a("glGetAttribLocation aPosition");
    if (this.e == -1) {
      throw new RuntimeException("Could not get attrib location for aPosition");
    }
    this.f = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "aTextureCoord");
    a("glGetAttribLocation aTextureCoord");
    if (this.f == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.jdField_c_of_type_Int = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "uMVPMatrix");
    a("glGetUniformLocation uMVPMatrix");
    if (this.jdField_c_of_type_Int == -1) {
      throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    }
    this.d = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "uSTMatrix");
    a("glGetUniformLocation uSTMatrix");
    if (this.d == -1) {
      throw new RuntimeException("Could not get attrib location for uSTMatrix");
    }
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    this.jdField_b_of_type_Int = arrayOfInt[0];
    GLES20.glBindTexture(36197, this.jdField_b_of_type_Int);
    a("glBindTexture mTextureID");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    a("glTexParameter");
    GLES20.glGenFramebuffers(1, this.jdField_a_of_type_ArrayOfInt, 0);
    a("glGenFramebuffers");
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    a("onDrawFrame start");
    paramSurfaceTexture.getTransformMatrix(this.jdField_c_of_type_ArrayOfFloat);
    GLES20.glClearColor(0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    GLES20.glBindFramebuffer(36160, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    a("glUseProgram");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(this.e, 3, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(this.e);
    a("glEnableVertexAttribArray maPositionHandle");
    this.jdField_a_of_type_JavaNioFloatBuffer.position(3);
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 20, this.jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.f);
    a("glEnableVertexAttribArray maTextureHandle");
    Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(this.jdField_c_of_type_Int, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(this.d, 1, false, this.jdField_c_of_type_ArrayOfFloat, 0);
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glFinish();
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      Log.e("OESTextureRender", paramString + ": glError " + i);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaNioFloatBuffer.clear();
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(this.jdField_a_of_type_ArrayOfFloat).position(0);
      return;
    }
    this.jdField_a_of_type_JavaNioFloatBuffer.put(new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 1.0F - this.jdField_a_of_type_ArrayOfFloat[4], 1.0F, -1.0F, 0.0F, 1.0F, 1.0F - this.jdField_a_of_type_ArrayOfFloat[9], -1.0F, 1.0F, 0.0F, 0.0F, 1.0F - this.jdField_a_of_type_ArrayOfFloat[14], 1.0F, 1.0F, 0.0F, 1.0F, 1.0F - this.jdField_a_of_type_ArrayOfFloat[19] }).position(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zau
 * JD-Core Version:    0.7.0.1
 */