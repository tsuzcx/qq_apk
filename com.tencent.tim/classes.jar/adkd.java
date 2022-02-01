import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class adkd
{
  public static final float[] IDENTITY_MATRIX = new float[16];
  public adjz a;
  public adka a;
  public adki a;
  public int aPositionHandle;
  public adkd.a b;
  public float[] bX;
  public String btA = "//抠像算法相关定义片段\n";
  public String btB = "//用户自己定义变量及方法相关片段\n";
  public String btC = "void main() {\n    vec2 position = vTextureCoord;\n";
  public String btD = "    //用户定义片段，用于在获取颜色值前处理, 如纹理坐标改变\n";
  public String btE = "    gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);\n    #if defined(TEXTURE_TYPE_OES)\n        gl_FragColor = texture2D(samplerOES, position);\n        gl_FragColor.r = max(0.0, min(gl_FragColor.r, 1.0));\n        gl_FragColor.g = max(0.0, min(gl_FragColor.g, 1.0));\n        gl_FragColor.b = max(0.0, min(gl_FragColor.b, 1.0));\n    #endif\n    #if defined(TEXTURE_TYPE_SAMPLER2D)\n        gl_FragColor = texture2D(sampler2d1, position);\n    #endif\n    #if defined(TEXTURE_TYPE_Y_U_V)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        yuv.y = texture2D(sampler2d2, position).r-0.5;\n        yuv.z = texture2D(sampler2d3, position).r-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;\n        gl_FragColor.a = 1.0;\n    #endif\n    #if defined(TEXTURE_TYPE_Y_UV)\n        vec4 yuv;\n        yuv.x = texture2D(sampler2d1, position).r;\n        vec2 uv = texture2D(sampler2d2, position).ra;\n        yuv.y = uv.x-0.5;\n        yuv.z = uv.y-0.5;\n        yuv.w = 1.0;\n        gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb\n        gl_FragColor.a = 1.0;\n    #endif\n";
  public String btF = adkg.btJ;
  public String btG = adkg.btK;
  public String btH = adkg.btL;
  public String bty = adkg.btI;
  public String btz = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES samplerOES;\nuniform sampler2D sampler2d1;\nuniform sampler2D sampler2d2;\nuniform sampler2D sampler2d3;\nuniform vec4 u_screenColor;\nvarying vec2 vTextureCoord;\n";
  public int cCH = -1;
  public int cHQ;
  public int cHR;
  public int cHS;
  public int cHT;
  public int cHU;
  public int cHV;
  public int cHW;
  public short[] d;
  private boolean inited;
  public String mFragmentShader;
  public int mProgramId;
  public int mTextureType = 0;
  public String mVertexShader = "precision mediump float;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n   gl_Position = uMVPMatrix * aPosition;\n   vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}";
  public int uMVPMatrixHandle;
  public float uS;
  public float uT;
  public float uU;
  
  static
  {
    Matrix.setIdentityM(IDENTITY_MATRIX, 0);
  }
  
  public adkd(int paramInt)
  {
    this.mTextureType = paramInt;
  }
  
  private final int a(adkf paramadkf, boolean paramBoolean)
  {
    int i = 0;
    a(paramadkf);
    if (this.b != null) {
      this.b.update();
    }
    if (this.cCH == 1) {
      this.jdField_a_of_type_Adjz.hx(this.aPositionHandle, this.cHQ);
    }
    for (;;)
    {
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      adkg.checkGlError("keyingHandleAfter");
      if (paramBoolean) {
        i = this.jdField_a_of_type_Adka.getFrameBufferTextureId();
      }
      return i;
      this.jdField_a_of_type_Adki.draw();
    }
  }
  
  private final void a(adkf paramadkf, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (!this.inited) {
      b(-1, 0.0F, 0.0F, 0.0F);
    }
    GLES20.glUseProgram(this.mProgramId);
    adkg.checkGlError("glUseProgram");
    if (paramBoolean)
    {
      this.jdField_a_of_type_Adka.bind(paramInt1, paramInt2);
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
    }
    if (this.cCH == 1) {}
    for (;;)
    {
      GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, paramArrayOfFloat1, 0);
      GLES20.glUniformMatrix4fv(this.cHR, 1, false, paramArrayOfFloat2, 0);
      if (this.cHW != -1) {
        GLES20.glUniform4f(this.cHW, paramadkf.uV, paramadkf.uW, paramadkf.uX, 1.0F);
      }
      adkg.checkGlError("keyingHandleBefore");
      return;
      this.jdField_a_of_type_Adki.hy(this.aPositionHandle, this.cHQ);
    }
  }
  
  public final int a(int[] paramArrayOfInt, adkf paramadkf, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return a(paramArrayOfInt, paramadkf, paramArrayOfFloat1, paramArrayOfFloat2, false, 0, 0);
  }
  
  public final int a(int[] paramArrayOfInt, adkf paramadkf, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramArrayOfInt == null) {
      throw new IllegalArgumentException("textureIds can not be null!");
    }
    a(paramadkf, paramArrayOfFloat1, paramArrayOfFloat2, paramBoolean, paramInt1, paramInt2);
    switch (this.mTextureType)
    {
    }
    for (;;)
    {
      adkg.checkGlError("keyingTexture");
      return a(paramadkf, paramBoolean);
      if (paramArrayOfInt.length < 1) {
        throw new IllegalArgumentException("textureIds.size should >= 1!");
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramArrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.cHS, 0);
      continue;
      if (paramArrayOfInt.length < 1) {
        throw new IllegalArgumentException("textureIds.size should >= 1!");
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramArrayOfInt[0]);
      GLES20.glTexParameterf(36197, 10241, 9728.0F);
      GLES20.glTexParameterf(36197, 10240, 9729.0F);
      GLES20.glTexParameteri(36197, 10242, 33071);
      GLES20.glTexParameteri(36197, 10243, 33071);
      GLES20.glUniform1i(this.cHV, 0);
      continue;
      if (paramArrayOfInt.length < 2) {
        throw new IllegalArgumentException("textureIds.size should >= 2!");
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramArrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.cHS, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramArrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.cHT, 1);
      if (this.mTextureType == 3)
      {
        if (paramArrayOfInt.length < 3) {
          throw new IllegalArgumentException("textureIds.size should >= 3!");
        }
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, paramArrayOfInt[2]);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10241, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        GLES20.glUniform1i(this.cHU, 2);
      }
    }
  }
  
  protected abstract void a(adkf paramadkf);
  
  public void a(String paramString1, String paramString2, String paramString3, adkd.a parama)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.btB = paramString1;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.btD = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      this.btG = paramString3;
    }
    this.b = parama;
  }
  
  public void a(float[] paramArrayOfFloat, short[] paramArrayOfShort)
  {
    this.bX = paramArrayOfFloat;
    this.d = paramArrayOfShort;
  }
  
  public final void b(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.mVertexShader)) {
      throw new IllegalArgumentException("mVertexShader can not be empty!");
    }
    if (this.inited) {
      return;
    }
    this.inited = true;
    this.cCH = paramInt;
    this.uS = paramFloat1;
    this.uT = paramFloat2;
    this.uU = paramFloat3;
    this.mFragmentShader = nw();
    if (QLog.isDevelopLevel()) {
      QLog.d("KeyingBase", 4, "init. markerType = " + this.cCH + ", markerWidth = " + this.uS + ", markerHeight = " + this.uT + ", mFragmentShader = \n" + this.mFragmentShader);
    }
    if (this.cCH == 1) {
      this.jdField_a_of_type_Adjz = new adjz(1.0F, this.uS, this.uT, this.uU);
    }
    for (;;)
    {
      this.jdField_a_of_type_Adka = new adka();
      this.mProgramId = adkg.createProgram(this.mVertexShader, this.mFragmentShader);
      adkg.checkGlError("createProgram");
      if (this.mProgramId == 0) {
        break;
      }
      this.aPositionHandle = GLES20.glGetAttribLocation(this.mProgramId, "aPosition");
      adkg.checkGlError("glGetAttribLocation aPosition");
      if (this.aPositionHandle != -1) {
        break label303;
      }
      throw new RuntimeException("Could not get attrib location for aPosition");
      if ((this.bX != null) && (this.d != null)) {
        this.jdField_a_of_type_Adki = new adki(this.bX, this.d);
      } else {
        this.jdField_a_of_type_Adki = new adki();
      }
    }
    label303:
    this.cHQ = GLES20.glGetAttribLocation(this.mProgramId, "aTextureCoord");
    adkg.checkGlError("glGetAttribLocation aTextureCoord");
    if (this.cHQ == -1) {
      throw new RuntimeException("Could not get attrib location for aTextureCoord");
    }
    this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgramId, "uMVPMatrix");
    adkg.checkGlError("glGetUniformLocation uMVPMatrix");
    this.cHR = GLES20.glGetUniformLocation(this.mProgramId, "uSTMatrix");
    adkg.checkGlError("glGetUniformLocation uSTMatrix");
    this.cHV = GLES20.glGetUniformLocation(this.mProgramId, "samplerOES");
    adkg.checkGlError("glGetUniformLocation samplerOES");
    this.cHS = GLES20.glGetUniformLocation(this.mProgramId, "sampler2d1");
    adkg.checkGlError("glGetUniformLocation sampler2d1");
    this.cHT = GLES20.glGetUniformLocation(this.mProgramId, "sampler2d2");
    adkg.checkGlError("glGetUniformLocation sampler2d2");
    this.cHU = GLES20.glGetUniformLocation(this.mProgramId, "sampler2d3");
    adkg.checkGlError("glGetUniformLocation sampler2d3");
    this.cHW = GLES20.glGetUniformLocation(this.mProgramId, "u_screenColor");
    adkg.checkGlError("glGetUniformLocation u_screenColor");
    cSi();
    if (this.b != null) {
      this.b.init(this.mProgramId);
    }
    QLog.i("KeyingBase", 2, " init need " + (System.currentTimeMillis() - l) + "ms");
  }
  
  protected abstract void cSi();
  
  protected String nw()
  {
    this.bty = adkg.dI(this.mTextureType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.bty).append(this.btz).append(this.btA).append(this.btB).append(this.btC).append(this.btD).append(this.btE).append(this.btF).append(this.btG).append(this.btH);
    return localStringBuilder.toString();
  }
  
  public void onDestroy()
  {
    if (!this.inited) {}
    do
    {
      return;
      GLES20.glDeleteProgram(this.mProgramId);
    } while (this.jdField_a_of_type_Adka == null);
    this.jdField_a_of_type_Adka.destroy();
    this.jdField_a_of_type_Adka = null;
  }
  
  public static abstract interface a
  {
    public abstract void init(int paramInt);
    
    public abstract void update();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkd
 * JD-Core Version:    0.7.0.1
 */