package dov.com.tencent.mobileqq.activity.richmedia.view;

import aaqh;
import android.annotation.TargetApi;
import android.content.Intent;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import anii;
import anij;
import anij.b;
import ayvy;
import ayvy.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class GLVideoClipUtil
{
  private static long MI;
  private static long MJ;
  private static final float[] aT;
  private static float[] aU;
  public static String bew = "precision mediump float;varying vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerUV;\nuniform float blackField;\nuniform float whiteField;\nuniform float nightMode;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nfloat fieldWidth;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.zy= texture2D(SamplerUV,texturecoordinateOut).ra-vec2(0.5, 0.5);\nrgb = mat3(      1,       1,      1,\n0,         -.34414, 1.772,\n1.402,     -.71414, 0) * yuv;\nfieldWidth = whiteField - blackField;\nif (nightMode > 0.0) {\nrgb.r *= 255.0;\nrgb.r -= blackField;\nrgb.r /= fieldWidth;\nrgb.g *= 255.0;\nrgb.g -= blackField;\nrgb.g /= fieldWidth;\nrgb.b *= 255.0;\nrgb.b -= blackField;\nrgb.b /= fieldWidth;\nrgb.r = min(1.0, max(0.0, rgb.r));\nrgb.g = min(1.0, max(0.0, rgb.g));\nrgb.b = min(1.0, max(0.0, rgb.b));\n}\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
  private static final int ckY;
  private static int clp = -1;
  private static final FloatBuffer vertexBuffer;
  private a a = new a(null);
  public int arF;
  private AtomicBoolean cd = new AtomicBoolean(false);
  private int ckZ;
  private int clc;
  private int cld;
  private int clf;
  private int clg;
  private int clh = 125;
  private final int clj = 256;
  private int clk;
  private int cll;
  private int clm;
  private int cln;
  private int clo;
  private int clr;
  private int cls;
  private ByteBuffer[] d = new ByteBuffer[2];
  private int[] jI = new int[2];
  private int[] jJ = new int[1];
  private final int[] jL = new int[256];
  public int mFrameCount;
  private int mPreviewHeight;
  private int mPreviewWidth;
  private float[] mSTMatrix = new float[16];
  private int muSTMatrixHandle;
  
  static
  {
    aT = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
    aU = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
    ckY = aT.length * 4 + aU.length * 4;
    vertexBuffer = ByteBuffer.allocateDirect(ckY).order(ByteOrder.nativeOrder()).asFloatBuffer();
  }
  
  private boolean Xx()
  {
    if ((this.mPreviewWidth > 0) && (this.mPreviewHeight > 0)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GLVideoClipUtil", 2, "checkPreviewSize: mPreviewWidth=" + this.mPreviewWidth + " mPreviewHeight=" + this.mPreviewHeight);
    }
    return false;
  }
  
  public static boolean aRj()
  {
    return clp > 0;
  }
  
  private native int allocNativeMemory(int paramInt1, int paramInt2, int paramInt3, ByteBuffer[] paramArrayOfByteBuffer);
  
  private void czh()
  {
    GLES20.glUseProgram(this.arF);
    this.ckZ = GLES20.glGetUniformLocation(this.arF, "SamplerY");
    this.clf = GLES20.glGetUniformLocation(this.arF, "SamplerUV");
    this.clc = GLES20.glGetAttribLocation(this.arF, "position");
    this.cld = GLES20.glGetAttribLocation(this.arF, "textureCoordinateIn");
    this.clk = GLES20.glGetUniformLocation(this.arF, "blackField");
    this.cll = GLES20.glGetUniformLocation(this.arF, "whiteField");
    this.clm = GLES20.glGetUniformLocation(this.arF, "nightMode");
    this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.arF, "uSTMatrix");
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
    czj();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.jI[1]);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glPixelStorei(3317, 1);
    czj();
  }
  
  private void czj()
  {
    int i = GLES20.glGetError();
    if ((i != 0) && (i != 0) && (QLog.isColorLevel())) {
      QLog.d("GLVideoClipUtil", 2, "glError error = " + i);
    }
  }
  
  private void czl()
  {
    int i = this.mPreviewWidth * this.mPreviewHeight;
    int j = i / 2;
    try
    {
      i = allocNativeMemory(i + j, i, j, this.d);
      if (i != 0) {
        throw new GLClipOldLibException("allocNativeMemory:err=" + i);
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        i = -200;
      }
    }
  }
  
  private native int getNativeSize();
  
  private boolean hH(int paramInt)
  {
    boolean bool = false;
    if ((this.mPreviewWidth <= 0) || (this.mPreviewHeight <= 0))
    {
      if (this.cd.get()) {
        throw new GLClipOldLibException("checkDataLength: mPreviewWidth=" + this.mPreviewWidth + " mPreviewHeight=" + this.mPreviewHeight);
      }
    }
    else
    {
      long l = this.mPreviewWidth * this.mPreviewHeight * 3 / 2;
      if (l != paramInt)
      {
        a locala = this.a;
        locala.clt += 1;
        bool = true;
        if (this.a.clt >= 3) {
          throw new GLClipOldLibException("checkDataLength: dataSize=" + l + " length=" + paramInt + "prev*preh=" + this.mPreviewWidth + " * " + this.mPreviewHeight);
        }
      }
      else
      {
        this.a.clt = 0;
      }
    }
    return bool;
  }
  
  private native int initClipSpec(int paramInt1, int paramInt2);
  
  private int s(byte[] paramArrayOfByte)
  {
    try
    {
      int i = memoryCopy(paramArrayOfByte);
      return i;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -200;
  }
  
  private void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    float[] arrayOfFloat = new float[16];
    float[] tmp8_6 = arrayOfFloat;
    tmp8_6[0] = 0.0F;
    float[] tmp12_8 = tmp8_6;
    tmp12_8[1] = 1.0F;
    float[] tmp16_12 = tmp12_8;
    tmp16_12[2] = 0.0F;
    float[] tmp20_16 = tmp16_12;
    tmp20_16[3] = 0.0F;
    float[] tmp24_20 = tmp20_16;
    tmp24_20[4] = 1.0F;
    float[] tmp28_24 = tmp24_20;
    tmp28_24[5] = 0.0F;
    float[] tmp32_28 = tmp28_24;
    tmp32_28[6] = 0.0F;
    float[] tmp37_32 = tmp32_28;
    tmp37_32[7] = 0.0F;
    float[] tmp42_37 = tmp37_32;
    tmp42_37[8] = 0.0F;
    float[] tmp47_42 = tmp42_37;
    tmp47_42[9] = 0.0F;
    float[] tmp52_47 = tmp47_42;
    tmp52_47[10] = 1.0F;
    float[] tmp57_52 = tmp52_47;
    tmp57_52[11] = 0.0F;
    float[] tmp62_57 = tmp57_52;
    tmp62_57[12] = 0.0F;
    float[] tmp67_62 = tmp62_57;
    tmp67_62[13] = 0.0F;
    float[] tmp72_67 = tmp67_62;
    tmp72_67[14] = 0.0F;
    float[] tmp77_72 = tmp72_67;
    tmp77_72[15] = 1.0F;
    tmp77_72;
    boolean bool1 = anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL);
    boolean bool2 = anii.isFoundProductFeatureRom(anii.KEY_PREVIEW_ORIENTATION_270_OF_FRONT_MODEL_2);
    if ((paramBoolean) && ((bool1) || (bool2)) && (aaqh.cix == 1)) {
      System.arraycopy(arrayOfFloat, 0, this.mSTMatrix, 0, arrayOfFloat.length);
    }
    for (;;)
    {
      float f1 = (1.0F - paramInt1 * 1.0F / this.mPreviewHeight) / 2.0F;
      float f2 = (paramInt1 * 1.0F / this.mPreviewHeight + 1.0F) / 2.0F;
      float f3 = (1.0F - paramInt2 * 1.0F / this.mPreviewWidth) / 2.0F;
      float f4 = (paramInt2 * 1.0F / this.mPreviewWidth + 1.0F) / 2.0F;
      arrayOfFloat = aU;
      paramInt1 = aU.length;
      System.arraycopy(new float[] { f1, f4, f2, f4, f2, f3, f1, f3 }, 0, arrayOfFloat, 0, paramInt1);
      return;
      bool1 = anii.isFoundProduct(anii.KEY_PREVIEW_ORIENTATION_270_OF_BACK_MODEL);
      if (bool1) {
        paramBoolean = false;
      }
      if ((bool1) && (aaqh.cix == 2)) {
        Matrix.multiplyMM(this.mSTMatrix, 0, new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F }, 0, arrayOfFloat, 0);
      } else if (paramBoolean) {
        Matrix.multiplyMM(this.mSTMatrix, 0, new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F }, 0, arrayOfFloat, 0);
      } else {
        Matrix.multiplyMM(this.mSTMatrix, 0, new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F }, 0, arrayOfFloat, 0);
      }
    }
  }
  
  private int zm()
  {
    return 6410;
  }
  
  private int zn()
  {
    try
    {
      int i = getNativeSize();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return -200;
  }
  
  public boolean Xw()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glEnable(2884);
    GLES20.glFrontFace(2305);
    GLES20.glCullFace(1029);
    czj();
    this.arF = ayvy.b.x("precision highp float;\nattribute vec4 position;\nattribute vec4 textureCoordinateIn;\nuniform   mat4 uSTMatrix;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = (uSTMatrix * textureCoordinateIn).xy;\ngl_Position = position;\n}\n", bew);
    if (this.arF == 0)
    {
      CameraGLSurfaceView.GLLogMsg("GLVideoHelper.createShaderProgram: mGLProgram=" + this.arF);
      return false;
    }
    czh();
    czj();
    a(this.jJ, this.clc, this.cld);
    GLES20.glGenTextures(this.jI.length, this.jI, 0);
    czi();
    GLES20.glViewport(0, 0, this.clr, this.cls);
    return true;
  }
  
  @TargetApi(9)
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = vertexBuffer.capacity();
    vertexBuffer.limit(i);
    vertexBuffer.position(0);
    vertexBuffer.put(aT);
    vertexBuffer.put(aU);
    vertexBuffer.position(0);
    GLES20.glGenBuffers(1, paramArrayOfInt, 0);
    GLES20.glBindBuffer(34962, paramArrayOfInt[0]);
    GLES20.glBufferData(34962, ckY, vertexBuffer, 35044);
    GLES20.glVertexAttribPointer(paramInt1, 2, 5126, false, 0, 0);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 0, aT.length * 4);
    GLES20.glEnableVertexAttribArray(paramInt2);
    czj();
  }
  
  public boolean aK(boolean paramBoolean)
  {
    if (!this.cd.get()) {}
    int i;
    boolean bool;
    do
    {
      return paramBoolean;
      czj();
      GLES20.glActiveTexture(33984);
      if (!paramBoolean)
      {
        GLES20.glTexImage2D(3553, 0, 6409, this.mPreviewWidth, this.mPreviewHeight, 0, 6409, 5121, null);
        czj();
      }
      GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mPreviewWidth, this.mPreviewHeight, 6409, 5121, this.d[0]);
      czj();
      GLES20.glUniform1i(this.ckZ, 0);
      i = zm();
      GLES20.glActiveTexture(33985);
      bool = paramBoolean;
      if (!paramBoolean)
      {
        GLES20.glTexImage2D(3553, 0, i, this.mPreviewWidth / 2, this.mPreviewHeight / 2, 0, i, 5121, null);
        czj();
        bool = true;
      }
      GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mPreviewWidth / 2, this.mPreviewHeight / 2, i, 5121, this.d[1]);
      czj();
      GLES20.glUniform1i(this.clf, 1);
      GLES20.glUniform1f(this.clk, this.cln);
      GLES20.glUniform1f(this.cll, this.clo);
      GLES20.glUniform1f(this.clm, -1.0F);
      GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
      GLES20.glDrawArrays(6, 0, 4);
      i = GLES20.glGetError();
      paramBoolean = bool;
    } while (i == 0);
    ayvy.GLLogMsg("glError:err=" + i + " errname=" + ayvy.cX(i));
    return bool;
  }
  
  public void ar(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      i = paramArrayOfByte.length;
      if (i > 0) {
        break label49;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GLVideoClipUtil", 2, "checkDataLength[invalid source data]: dataLength=" + i);
      }
    }
    label49:
    label97:
    label123:
    int[] arrayOfInt;
    do
    {
      do
      {
        boolean bool;
        do
        {
          return;
          i = -1;
          break;
          bool = Xx();
          if (!hH(i)) {
            break label97;
          }
        } while (!QLog.isColorLevel());
        QLog.d("GLVideoClipUtil", 2, "checkPreviewSize[copyDataToByteBuffer]:sizeError=true res=" + bool);
        return;
        if (this.cd.get()) {
          break label123;
        }
      } while (!QLog.isColorLevel());
      QLog.d("GLVideoClipUtil", 2, "checkPreviewSize[copyDataToByteBuffer]: mInitedPreviewSize=false");
      return;
      k = s(paramArrayOfByte);
      j = k;
      if (k == -4)
      {
        czl();
        j = s(paramArrayOfByte);
      }
      if (j != 0) {
        throw new GLClipOldLibException("memoryCopy[Afterfix]:err=" + j + "  length=" + i + " NativeSize=" + zn());
      }
      this.d[0].position(0);
      this.d[1].position(0);
      arrayOfInt = ShortVideoUtils.Y();
      if (arrayOfInt[0] != 1) {
        break label668;
      }
      this.mFrameCount += 1;
    } while (this.mFrameCount % 8 != 0);
    long l = SystemClock.uptimeMillis();
    this.clg = (this.mPreviewWidth * this.mPreviewHeight * (100 - arrayOfInt[1]) / 100);
    this.clh = arrayOfInt[2];
    Arrays.fill(this.jL, 0);
    int i = 1;
    while (i < this.mPreviewHeight)
    {
      j = 1;
      while (j < this.mPreviewWidth)
      {
        arrayOfInt = this.jL;
        k = paramArrayOfByte[(this.mPreviewWidth * i + j)] & 0xFF;
        arrayOfInt[k] += 64;
        j += 8;
      }
      i += 8;
    }
    int j = 255;
    i = 255;
    int k = 0;
    if (i >= 51)
    {
      k += this.jL[i];
      if (k < this.clg) {}
    }
    for (;;)
    {
      this.cln = 0;
      this.clo = i;
      if (this.clo <= this.clh)
      {
        MJ = 0L;
        if (MI == 0L) {
          MI = System.currentTimeMillis();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label666;
        }
        QLog.d("GLVideoClipUtil", 2, "blackField = " + 0 + ", whiteField = " + i + ", cost = " + (SystemClock.uptimeMillis() - l));
        return;
        j = i;
        i -= 1;
        break;
        if ((MI > 0L) && (System.currentTimeMillis() - MI >= 1500L))
        {
          paramArrayOfByte = new Intent("tencent.video.q2v.nightMode");
          paramArrayOfByte.putExtra("dark_mode_value", true);
          BaseApplicationImpl.getApplication().sendBroadcast(paramArrayOfByte);
          MI = -1L;
          MJ = 0L;
          continue;
          if (MI > 0L) {
            MI = 0L;
          }
          if (MJ == 0L)
          {
            MJ = System.currentTimeMillis();
          }
          else if ((MJ > 0L) && (System.currentTimeMillis() - MJ >= 2000L))
          {
            paramArrayOfByte = new Intent("tencent.video.q2v.nightMode");
            paramArrayOfByte.putExtra("dark_mode_value", false);
            BaseApplicationImpl.getApplication().sendBroadcast(paramArrayOfByte);
            MJ = -1L;
          }
        }
      }
      label666:
      break;
      label668:
      clp = -1;
      return;
      i = j;
    }
  }
  
  public void czk() {}
  
  public void f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    anij.b localb = anij.a().c();
    int m = paramInt1;
    int k = paramInt2;
    int j = paramInt3;
    int i = paramInt4;
    if (localb != null)
    {
      QLog.d("GLVideoClipUtil", 2, "allocateNativeBuffer[CameraControl-]: Width=" + localb.width + " Height=" + localb.height + " width1" + paramInt1 + " height1" + paramInt2);
      m = paramInt1;
      k = paramInt2;
      j = paramInt3;
      i = paramInt4;
      if (localb.width > 0)
      {
        m = paramInt1;
        k = paramInt2;
        j = paramInt3;
        i = paramInt4;
        if (localb.height > 0) {
          if (localb.width == paramInt1)
          {
            m = paramInt1;
            k = paramInt2;
            j = paramInt3;
            i = paramInt4;
            if (localb.height == paramInt2) {}
          }
          else
          {
            if ((paramInt1 != paramInt4) || (paramInt2 != paramInt3)) {
              break label283;
            }
            paramInt2 = localb.height;
            paramInt1 = localb.width;
          }
        }
      }
    }
    for (;;)
    {
      m = localb.width;
      k = localb.height;
      QLog.d("GLVideoClipUtil", 2, "allocateNativeBuffer[Adjust]: clipwidth=" + paramInt2 + " clipheight=" + paramInt1);
      i = paramInt1;
      j = paramInt2;
      try
      {
        paramInt1 = initClipSpec(m, k);
        if (paramInt1 != 0)
        {
          throw new GLClipOldLibException("initClipSpec:err=" + paramInt1);
          label283:
          if (paramInt4 * 1.0F / paramInt3 > localb.width * 1.0F / localb.height)
          {
            paramInt1 = (int)(localb.width * paramInt3 * 1.0F / paramInt4);
            paramInt2 = paramInt1 - paramInt1 % 16;
            paramInt1 = localb.width;
            continue;
          }
          paramInt2 = localb.height;
          paramInt1 = (int)(localb.height * paramInt4 * 1.0F / paramInt3);
          paramInt1 -= paramInt1 % 16;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          localUnsatisfiedLinkError.printStackTrace();
          paramInt1 = -200;
        }
        this.mPreviewWidth = m;
        this.mPreviewHeight = k;
        this.clr = j;
        this.cls = i;
        Xx();
        this.cd.getAndSet(true);
        czl();
        t(j, i, paramBoolean);
      }
    }
  }
  
  public native int memoryCopy(byte[] paramArrayOfByte);
  
  public static class GLClipOldLibException
    extends RuntimeException
  {
    private static final long serialVersionUID = -7034897190745766929L;
    
    public GLClipOldLibException(String paramString)
    {
      super();
    }
  }
  
  class a
  {
    public int clt;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil
 * JD-Core Version:    0.7.0.1
 */