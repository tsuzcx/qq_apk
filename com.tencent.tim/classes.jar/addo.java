import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class addo
{
  static float[] bJ = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  static float[] bK = { -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F };
  static float[] bL = { 0.0F, -1.0F, 1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] bM = { -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F };
  static float[] bN = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  public static float[] bO = { -1.0F, 1.0F, 1.0F, 1.0F, -1.0F, -1.0F, 1.0F, -1.0F };
  private static float[] bP = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private float[] bI;
  private boolean bLX;
  private int cDA = -1;
  private int cDB = -1;
  private int cDC = -1;
  private int cDD = -1;
  private int cDE = -1;
  private int cDF = -1;
  private int cDG = -1;
  private int cDH = -1;
  private int cDI = -1;
  private int cDJ = -1;
  private int cDs;
  public final int cDt;
  private int cDu;
  private int cDv;
  private int cDw;
  private int cDx;
  private int cDy;
  private int cDz;
  private ByteBuffer s;
  private ByteBuffer t;
  
  public addo(int paramInt)
  {
    if (((paramInt < 0) || (paramInt > 4)) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Index can only be 0 to 4");
    }
    this.cDt = paramInt;
    setup(this.cDt);
  }
  
  private void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      QLog.i("GreetingYUVProgram", 1, paramString + ": glError 0x" + Integer.toHexString(i));
    }
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt != 0)
    {
      GLES20.glShaderSource(paramInt, paramString);
      GLES20.glCompileShader(paramInt);
      paramString = new int[1];
      GLES20.glGetShaderiv(paramInt, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        GLES20.glDeleteShader(paramInt);
        return 0;
      }
    }
    return paramInt;
  }
  
  public void a(Buffer paramBuffer1, Buffer paramBuffer2, Buffer paramBuffer3, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.cDI) || (paramInt2 != this.cDJ)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.cDI = paramInt1;
        this.cDJ = paramInt2;
      }
      if ((this.cDF < 0) || (i != 0))
      {
        if (this.cDF >= 0)
        {
          GLES20.glDeleteTextures(1, new int[] { this.cDF }, 0);
          checkGlError("glDeleteTextures");
        }
        int[] arrayOfInt = new int[1];
        GLES20.glGenTextures(1, arrayOfInt, 0);
        checkGlError("glGenTextures");
        this.cDF = arrayOfInt[0];
      }
      GLES20.glBindTexture(3553, this.cDF);
      checkGlError("glBindTexture");
      GLES20.glTexImage2D(3553, 0, 6409, this.cDI, this.cDJ, 0, 6409, 5121, paramBuffer1);
      checkGlError("glTexImage2D");
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      if ((this.cDG < 0) || (i != 0))
      {
        if (this.cDG >= 0)
        {
          GLES20.glDeleteTextures(1, new int[] { this.cDG }, 0);
          checkGlError("glDeleteTextures");
        }
        paramBuffer1 = new int[1];
        GLES20.glGenTextures(1, paramBuffer1, 0);
        checkGlError("glGenTextures");
        this.cDG = paramBuffer1[0];
      }
      GLES20.glBindTexture(3553, this.cDG);
      GLES20.glTexImage2D(3553, 0, 6409, this.cDI / 2, this.cDJ / 2, 0, 6409, 5121, paramBuffer2);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      if ((this.cDH < 0) || (i != 0))
      {
        if (this.cDH >= 0)
        {
          GLES20.glDeleteTextures(1, new int[] { this.cDH }, 0);
          checkGlError("glDeleteTextures");
        }
        paramBuffer1 = new int[1];
        GLES20.glGenTextures(1, paramBuffer1, 0);
        checkGlError("glGenTextures");
        this.cDH = paramBuffer1[0];
      }
      GLES20.glBindTexture(3553, this.cDH);
      GLES20.glTexImage2D(3553, 0, 6409, this.cDI / 2, this.cDJ / 2, 0, 6409, 5121, paramBuffer3);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      return;
    }
  }
  
  public boolean adI()
  {
    return this.bLX;
  }
  
  public void cQF()
  {
    if (this.cDs <= 0) {
      this.cDs = createProgram("attribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 tc;\nvoid main() {\ngl_Position = vPosition;\ntc = a_texCoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_y;\nuniform sampler2D tex_u;\nuniform sampler2D tex_v;\nvarying vec2 tc;\nvoid main() {\nvec4 c = vec4((texture2D(tex_y, tc).r - 16./255.) * 1.164);\nvec4 U = vec4(texture2D(tex_u, tc).r - 128./255.);\nvec4 V = vec4(texture2D(tex_v, tc).r - 128./255.);\nc += V * vec4(1.596, -0.813, 0, 0);\nc += U * vec4(0, -0.392, 2.017, 0);\nc.a = 1.0;\ngl_FragColor = c;\n}\n");
    }
    this.cDA = GLES20.glGetAttribLocation(this.cDs, "vPosition");
    checkGlError("glGetAttribLocation vPosition");
    if ((this.cDA == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for vPosition");
    }
    this.cDB = GLES20.glGetAttribLocation(this.cDs, "a_texCoord");
    checkGlError("glGetAttribLocation a_texCoord");
    if ((this.cDB == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for a_texCoord");
    }
    this.cDC = GLES20.glGetUniformLocation(this.cDs, "tex_y");
    checkGlError("glGetUniformLocation tex_y");
    if ((this.cDC == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_y");
    }
    this.cDD = GLES20.glGetUniformLocation(this.cDs, "tex_u");
    checkGlError("glGetUniformLocation tex_u");
    if ((this.cDD == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_u");
    }
    this.cDE = GLES20.glGetUniformLocation(this.cDs, "tex_v");
    checkGlError("glGetUniformLocation tex_v");
    if ((this.cDE == -1) && (QLog.isColorLevel())) {
      QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_v");
    }
    this.bLX = true;
  }
  
  public void cQG()
  {
    if (this.cDF != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.cDF }, 0);
      checkGlError("glDeleteTextures");
      this.cDF = -1;
    }
    if (this.cDG != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.cDG }, 0);
      checkGlError("glDeleteTextures");
      this.cDG = -1;
    }
    if (this.cDH != -1)
    {
      GLES20.glDeleteTextures(1, new int[] { this.cDH }, 0);
      checkGlError("glDeleteTextures");
      this.cDH = -1;
    }
    if (this.cDs > 0)
    {
      this.bLX = false;
      GLES20.glDeleteProgram(this.cDs);
      checkGlError("glDeleteProgram");
      this.cDs = 0;
    }
  }
  
  public int createProgram(String paramString1, String paramString2)
  {
    int i = loadShader(35633, paramString1);
    int j = loadShader(35632, paramString2);
    int k = GLES20.glCreateProgram();
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      checkGlError("glAttachShader");
      GLES20.glAttachShader(k, j);
      checkGlError("glAttachShader");
      GLES20.glLinkProgram(k);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(k, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        GLES20.glDeleteProgram(k);
        return 0;
      }
    }
    return k;
  }
  
  public void d(float[] paramArrayOfFloat)
  {
    this.s = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    this.s.order(ByteOrder.nativeOrder());
    this.s.asFloatBuffer().put(paramArrayOfFloat);
    this.s.position(0);
    if (this.t == null)
    {
      this.t = ByteBuffer.allocateDirect(bP.length * 4);
      this.t.order(ByteOrder.nativeOrder());
      this.t.asFloatBuffer().put(bP);
      this.t.position(0);
    }
  }
  
  public void drawFrame()
  {
    GLES20.glUseProgram(this.cDs);
    checkGlError("glUseProgram");
    GLES20.glVertexAttribPointer(this.cDA, 2, 5126, false, 8, this.s);
    checkGlError("glVertexAttribPointer mPositionHandle");
    GLES20.glEnableVertexAttribArray(this.cDA);
    GLES20.glVertexAttribPointer(this.cDB, 2, 5126, false, 8, this.t);
    checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(this.cDB);
    GLES20.glActiveTexture(this.cDu);
    GLES20.glBindTexture(3553, this.cDF);
    GLES20.glUniform1i(this.cDC, this.cDx);
    GLES20.glActiveTexture(this.cDv);
    GLES20.glBindTexture(3553, this.cDG);
    GLES20.glUniform1i(this.cDD, this.cDy);
    GLES20.glActiveTexture(this.cDw);
    GLES20.glBindTexture(3553, this.cDH);
    GLES20.glUniform1i(this.cDE, this.cDz);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glFinish();
    GLES20.glDisableVertexAttribArray(this.cDA);
    GLES20.glDisableVertexAttribArray(this.cDB);
    GLES20.glUseProgram(0);
  }
  
  public void setup(int paramInt)
  {
    switch (this.cDt)
    {
    default: 
      this.bI = bJ;
      this.cDu = 33984;
      this.cDv = 33985;
      this.cDw = 33986;
      this.cDx = 0;
      this.cDy = 1;
      this.cDz = 2;
      return;
    case 1: 
      this.bI = bK;
      this.cDu = 33984;
      this.cDv = 33985;
      this.cDw = 33986;
      this.cDx = 0;
      this.cDy = 1;
      this.cDz = 2;
      return;
    case 2: 
      this.bI = bL;
      this.cDu = 33987;
      this.cDv = 33988;
      this.cDw = 33989;
      this.cDx = 3;
      this.cDy = 4;
      this.cDz = 5;
      return;
    case 3: 
      this.bI = bM;
      this.cDu = 33990;
      this.cDv = 33991;
      this.cDw = 33992;
      this.cDx = 6;
      this.cDy = 7;
      this.cDz = 8;
      return;
    }
    this.bI = bN;
    this.cDu = 33993;
    this.cDv = 33994;
    this.cDw = 33995;
    this.cDx = 9;
    this.cDy = 10;
    this.cDz = 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addo
 * JD-Core Version:    0.7.0.1
 */