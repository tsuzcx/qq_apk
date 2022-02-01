import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

@TargetApi(9)
public class ayvy
{
  public static final float[] aT = { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  public static final float[] aU = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  public static boolean bAn;
  private static final int ckY = aT.length * 4 + aU.length * 4;
  public static boolean initSuccess;
  private static final FloatBuffer vertexBuffer = ByteBuffer.allocateDirect(ckY * 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
  public akzt a;
  public int arF;
  public boolean bAm;
  public boolean bAo;
  private int ckZ;
  private int cla;
  private int clb;
  private int clc;
  private int cld;
  int cle;
  private int[] jI = new int[3];
  private int[] jJ = new int[1];
  private Context mContext;
  public ByteBuffer n;
  public ByteBuffer o;
  public ByteBuffer p;
  
  static
  {
    int i = vertexBuffer.capacity();
    vertexBuffer.limit(i);
    vertexBuffer.position(0);
    vertexBuffer.put(aT);
    vertexBuffer.put(aU);
  }
  
  public static void GLLogMsg(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLSurfaceUtil", 2, paramString);
    }
  }
  
  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    vertexBuffer.position(0);
    GLES20.glGenBuffers(1, paramArrayOfInt, 0);
    GLES20.glBindBuffer(34962, paramArrayOfInt[0]);
    GLES20.glBufferData(34962, ckY, vertexBuffer, 35044);
    GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 0, aT.length * 4);
    GLES20.glEnableVertexAttribArray(paramInt2);
  }
  
  public static String cX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknow error";
    case 0: 
      return "GL_NO_ERROR";
    case 1280: 
      return "GL_INVALID_ENUM";
    case 1281: 
      return "GL_INVALID_VALUE";
    case 1282: 
      return "GL_INVALID_OPERATION";
    case 1285: 
      return "GL_OUT_OF_MEMORY";
    }
    return "GL_INVALID_FRAMEBUFFER_OPERATION";
  }
  
  private void czh()
  {
    GLES20.glUseProgram(this.arF);
    this.ckZ = GLES20.glGetUniformLocation(this.arF, "SamplerY");
    this.cla = GLES20.glGetUniformLocation(this.arF, "SamplerU");
    this.clb = GLES20.glGetUniformLocation(this.arF, "SamplerV");
    this.clc = GLES20.glGetAttribLocation(this.arF, "position");
    this.cld = GLES20.glGetAttribLocation(this.arF, "textureCoordinateIn");
    Object localObject1;
    if (this.bAm)
    {
      this.a.mk.put("percent1", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent1")));
      this.a.mk.put("percent2", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent2")));
      this.a.mk.put("percent3", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent3")));
      this.a.mk.put("percent4", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent4")));
      this.a.mk.put("percent5", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent5")));
      this.a.mk.put("percent6", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent6")));
      this.a.mk.put("percent7", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "percent7")));
      this.a.mk.put("quality", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "quality")));
      this.a.mk.put("add_red", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "add_red")));
      this.a.mk.put("red_m", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "red_m")));
      this.a.mk.put("green_m", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "green_m")));
      this.a.mk.put("blue_m", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "blue_m")));
      this.a.mk.put("inputImageTexture2", Integer.valueOf(GLES20.glGetUniformLocation(this.arF, "inputImageTexture2")));
      localObject1 = null;
    }
    try
    {
      localObject2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130846175);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2;
        QLog.i("GLSurfaceUtil", 2, "decode hongbao filter mask oom!");
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new int[1];
      GLES20.glGenTextures(1, (int[])localObject2, 0);
      GLES20.glBindTexture(3553, localObject2[0]);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glTexParameteri(3553, 10241, 9729);
      GLES20.glTexParameteri(3553, 10240, 9729);
      GLUtils.texImage2D(3553, 0, localObject1, 0);
      this.cle = localObject2[0];
      GLES20.glBindTexture(3553, 0);
    }
  }
  
  private void czi()
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jI[0]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.jI[1]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.jI[2]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        int i = k(paramInt1, paramInt4, paramInt5);
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= i)) {
          break label332;
        }
        bool1 = true;
        boolean bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (paramArrayOfByte.length == ao(paramInt4, paramInt5)) {
            bool2 = false;
          }
        }
        if (bool2)
        {
          GLLogMsg("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + bool2 + " mPreviewWidth=" + paramInt4 + " mPreviewWidth" + paramInt4 + " mVideoFormat=" + paramInt1);
          GLLogMsg("handleMessage:byteBufferProcessFrame:[data length error]dataLenErr=" + bool2 + " totalSize=" + i + " data.length=" + paramArrayOfByte.length);
          return -1;
        }
        if ((this.n == null) || (!this.bAo)) {
          initSuccess = false;
        }
      }
      catch (UnsatisfiedLinkError paramArrayOfByte)
      {
        paramInt1 = 0;
        continue;
        GLLogMsg("handleMessage:byteBufferProcessFrame:panelY=" + this.n);
        return paramInt1;
      }
      try
      {
        CameraGLSurfaceView.initTotalBufferSize(paramInt4, paramInt5, paramInt1);
        initSuccess = true;
        this.n = null;
        this.o = null;
        this.p = null;
        gx(paramInt2, paramInt3);
        this.bAo = true;
        paramInt1 = CameraGLSurfaceView.processVideoFrame(paramArrayOfByte, paramInt4, paramInt5, paramInt1, paramInt6, false, this.n, this.o, this.p, bAn);
        if (this.n != null)
        {
          this.n.position(0);
          this.o.position(0);
          this.p.position(0);
          return paramInt1;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        initSuccess = false;
        continue;
      }
      label332:
      boolean bool1 = false;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3)
  {
    GLES20.glActiveTexture(33984);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1, paramInt2, 6409, 5121, paramByteBuffer1);
    GLES20.glUniform1i(this.ckZ, 0);
    GLES20.glActiveTexture(33985);
    if (!paramBoolean) {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1 / 2, paramInt2 / 2, 6409, 5121, paramByteBuffer2);
    GLES20.glUniform1i(this.cla, 1);
    GLES20.glActiveTexture(33986);
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      GLES20.glTexImage2D(3553, 0, 6409, paramInt1 / 2, paramInt2 / 2, 0, 6409, 5121, null);
      bool = true;
    }
    GLES20.glTexSubImage2D(3553, 0, 0, 0, paramInt1 / 2, paramInt2 / 2, 6409, 5121, paramByteBuffer3);
    GLES20.glUniform1i(this.clb, 2);
    if (this.bAm)
    {
      this.a.Sx(akzt.FBPFQ_HIGH);
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.cle);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(this.arF, "inputImageTexture2"), 3);
    }
    GLES20.glDrawArrays(6, 0, 4);
    paramInt1 = GLES20.glGetError();
    if (paramInt1 != 0) {
      GLLogMsg("glError:err=" + paramInt1 + " errname=" + cX(paramInt1));
    }
    return bool;
  }
  
  public boolean aT(Context paramContext)
  {
    this.mContext = paramContext;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    if (this.bAm) {
      this.a = new akzt();
    }
    for (this.arF = ayvy.b.x("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;\nvarying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform float percent1;\nuniform float percent2;\nuniform float percent3;\nuniform float percent4;\nuniform float percent5;\nuniform float percent6;\nuniform float percent7;\nuniform sampler2D inputImageTexture2;\nuniform float quality;\nuniform float add_red;\nuniform float red_m;\nuniform float green_m;\nuniform float blue_m;\nfloat percent_value(float min_percent, float percent)\n{\nfloat result_percent = 0.0;\nif(percent > 0.0)\nresult_percent = min(min_percent, percent);\nelse\nresult_percent = max(min_percent - 1.0, percent);\nreturn result_percent;\n}\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfloat r = rgb.r;\nfloat g = rgb.g;\nfloat b = rgb.b;\nfloat max_c = max(r, max(g, b));\nfloat min_c = min(r, min(g, b));\nfloat median = r + g + b - max_c - min_c;\nfloat amount = max_c - median;\nfloat amount2 = median - min_c;\nfloat min_percent_r = 1.0 - r;\nfloat min_percent_g = 1.0 - g;\nfloat min_percent_b = 1.0 - b;\nfloat p;\nfloat gray = dot(rgb, vec3(0.299, 0.587, 0.114));\nfloat tmp_r = r;\nfloat tmp_g = g;\nfloat tmp_b = b;\nif(tmp_r == max_c) //red\n{\nfloat tmp_percent7 = percent7 * (1.0 - gray);\np = percent_value(min_percent_r, percent1 + tmp_percent7);\nr = r + amount * p;\np = percent_value(min_percent_g, percent4 + tmp_percent7);\ng = g + amount * p;\np = percent_value(min_percent_b, percent6 + tmp_percent7);\nb = b + amount * p;\n}\nif(tmp_b == max_c) //blue\n{\np = percent_value(min_percent_r, percent3);\nr = r + amount * p;\n}\nif(tmp_b == min_c) //yellow\n{\np = percent_value(min_percent_b, percent2);\nb = b + amount2 * p;\np = percent_value(min_percent_g, percent5);\ng = g + amount2 * p;\n}\nlowp vec4 color;\ncolor = vec4(r, g, b, 1.0);\ncolor *= quality;\nlowp vec4 newColor;\nnewColor = color;\nif(newColor.r > newColor.g && newColor.r > newColor.b)\n{\nnewColor.r *= 1.0 - red_m * add_red;\nnewColor.g *= 1.0 - green_m * add_red;\nnewColor.b *= 1.0 - blue_m * add_red;\n}\nnewColor.r = texture2D(inputImageTexture2, vec2(newColor.r,0.5)).r;\nnewColor.g = texture2D(inputImageTexture2, vec2(newColor.g,0.5)).g;\nnewColor.b = texture2D(inputImageTexture2, vec2(newColor.b,0.5)).b;\nnewColor.a = 1.0;\ngl_FragColor = newColor;\n}\n"); this.arF == 0; this.arF = ayvy.b.zl())
    {
      CameraGLSurfaceView.GLLogMsg("GLVideoHelper.createShaderProgram: mGLProgram=" + this.arF);
      return false;
    }
    czh();
    a(this.jJ, this.clc, this.cld);
    GLES20.glGenTextures(this.jI.length, this.jI, 0);
    czi();
    return true;
  }
  
  public int ao(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 * 3 / 2;
  }
  
  public void gx(int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    if ((this.n == null) || (this.n.capacity() < i)) {
      this.n = ayvy.a.a(0, i);
    }
    i = 0 + i;
    paramInt1 = paramInt1 / 2 * (paramInt2 / 2);
    if ((this.o == null) || (this.o.capacity() < paramInt1)) {
      this.o = ayvy.a.a(i, paramInt1);
    }
    if ((this.p == null) || (this.p.capacity() < paramInt1)) {
      this.p = ayvy.a.a(i + paramInt1, paramInt1);
    }
  }
  
  public int k(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = ImageFormat.getBitsPerPixel(paramInt1);
    float f = paramInt1 * 1.0F / 8.0F;
    GLLogMsg("handleMessage:byteBufferProcessFrame:[getBufferSize]bitpixel=" + paramInt1 + " byteNum=" + f);
    return (int)(paramInt2 * paramInt3 * f);
  }
  
  public static class a
  {
    public static ByteBuffer a(int paramInt1, int paramInt2)
    {
      try
      {
        if (ayvy.initSuccess)
        {
          ByteBuffer localByteBuffer1 = CameraGLSurfaceView.allocate(paramInt1, paramInt2);
          ayvy.bAn = true;
          ByteBuffer localByteBuffer2 = localByteBuffer1;
          if (localByteBuffer1 == null)
          {
            localByteBuffer2 = ByteBuffer.allocateDirect(paramInt2);
            ayvy.bAn = false;
          }
          return localByteBuffer2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          Object localObject = null;
          continue;
          localObject = null;
        }
      }
    }
  }
  
  public static class b
  {
    private static int[] jK = new int[1];
    
    private static String cY(int paramInt)
    {
      if (paramInt == 35633) {
        return "GL_VERTEX_SHADER";
      }
      if (paramInt == 35632) {
        return "GL_FRAGMENT_SHADER";
      }
      return "unKnown";
    }
    
    private static int compileShader(int paramInt, String paramString)
    {
      int i = GLES20.glCreateShader(paramInt);
      if (i == 0)
      {
        ayvy.GLLogMsg("glCreateShader:shader==0 type=" + cY(paramInt));
        return 0;
      }
      GLES20.glShaderSource(i, paramString);
      GLES20.glCompileShader(i);
      GLES20.glGetShaderiv(i, 35713, jK, 0);
      if (jK[0] == 0)
      {
        paramString = GLES20.glGetShaderInfoLog(i);
        GLES20.glDeleteShader(i);
        ayvy.GLLogMsg("glGetShaderiv:GL_COMPILE_STATUS error  loginfo=" + paramString);
        return 0;
      }
      return i;
    }
    
    private static int linkProgram(int paramInt1, int paramInt2)
    {
      int i = GLES20.glCreateProgram();
      if (i == 0)
      {
        ayvy.GLLogMsg("glCreateProgram:program == 0");
        return 0;
      }
      GLES20.glAttachShader(i, paramInt1);
      GLES20.glAttachShader(i, paramInt2);
      GLES20.glLinkProgram(i);
      GLES20.glGetProgramiv(i, 35714, jK, 0);
      if (jK[0] == 0)
      {
        String str = GLES20.glGetProgramInfoLog(i);
        GLES20.glDeleteProgram(i);
        ayvy.GLLogMsg("linkProgram:GL_COMPILE_STATUS errorinfo =" + str);
        return 0;
      }
      return i;
    }
    
    public static int x(String paramString1, String paramString2)
    {
      int i = compileShader(35633, paramString1);
      int j = compileShader(35632, paramString2);
      if ((i == 0) || (j == 0))
      {
        ayvy.GLLogMsg("compileShader:vertext or fragment == 0");
        return 0;
      }
      int k = linkProgram(i, j);
      if (k == 0)
      {
        GLES20.glDeleteShader(i);
        GLES20.glDeleteShader(j);
        return 0;
      }
      return k;
    }
    
    public static int zl()
    {
      return x("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvy
 * JD-Core Version:    0.7.0.1
 */