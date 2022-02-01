import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

public class aixy
{
  private static final short[] f = { 0, 1, 2, 2, 3, 0 };
  private ShortBuffer b;
  private boolean cmG;
  private int dgA = -1;
  private int dgB = -1;
  private int dgC;
  private int dgD;
  private int dgE;
  private int dgF = -1;
  private int dgG = -1;
  private int dgH = -1;
  private int dgs;
  private int dgt;
  private int dgu;
  private int dgv;
  private int dgw;
  private int dgx;
  private int dgy;
  private int dgz = -1;
  private int dstHeight;
  private int dstWidth;
  private byte[] eA;
  private byte[] eB;
  private byte[] eC;
  private byte[] eD;
  private byte[] eE;
  private byte[] ez;
  private FloatBuffer j;
  private FloatBuffer k;
  private HashMap<String, ByteBuffer> lq = new HashMap();
  private int srcHeight;
  private int srcWidth;
  private int viewHeight;
  private int viewWidth;
  private float xc = -1.0F;
  
  public aixy()
  {
    dvq();
    dub();
  }
  
  private void LD(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = this.viewWidth / this.dstWidth * this.dstHeight / this.viewHeight)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceGLDisplayer", 2, "func updateRenderParam, [yCord]=" + f1);
      }
      float f2 = (this.srcWidth - this.dstWidth) / this.srcWidth / 2.0F;
      float f3 = (this.srcHeight - this.dstHeight) / this.srcHeight / 2.0F;
      Object localObject = new float[12];
      localObject[0] = 1.0F;
      localObject[1] = (-f1);
      localObject[2] = 0.0F;
      localObject[3] = 1.0F;
      localObject[4] = f1;
      localObject[5] = 0.0F;
      localObject[6] = -1.0F;
      localObject[7] = f1;
      localObject[8] = 0.0F;
      localObject[9] = -1.0F;
      localObject[10] = (-f1);
      localObject[11] = 0.0F;
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = (1.0F - f2);
      arrayOfFloat[1] = (1.0F - f3);
      arrayOfFloat[2] = (1.0F - f2);
      arrayOfFloat[3] = f3;
      arrayOfFloat[4] = f2;
      arrayOfFloat[5] = f3;
      arrayOfFloat[6] = f2;
      arrayOfFloat[7] = (1.0F - f3);
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.j = localByteBuffer.asFloatBuffer();
      this.j.put((float[])localObject);
      this.j.position(0);
      localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      this.k = ((ByteBuffer)localObject).asFloatBuffer();
      this.k.put(arrayOfFloat);
      this.k.position(0);
      return;
    }
  }
  
  private void aS(float paramFloat)
  {
    float f1 = 3.14159F * paramFloat / 180.0F;
    paramFloat = (float)Math.sin(f1);
    f1 = (float)Math.cos(f1);
    float[] arrayOfFloat = new float[16];
    arrayOfFloat[0] = f1;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = (-paramFloat);
    arrayOfFloat[5] = f1;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 0.0F;
    arrayOfFloat[9] = 0.0F;
    arrayOfFloat[10] = 1.0F;
    arrayOfFloat[11] = 0.0F;
    arrayOfFloat[12] = 0.0F;
    arrayOfFloat[13] = 0.0F;
    arrayOfFloat[14] = 0.0F;
    arrayOfFloat[15] = 1.0F;
    Object localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(arrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    GLES20.glUniformMatrix4fv(this.dgy, 1, false, (FloatBuffer)localObject);
  }
  
  private void dvq()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(f.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.b = localByteBuffer.asShortBuffer();
    this.b.put(f);
    this.b.position(0);
  }
  
  private int i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = IntBuffer.allocate(1);
    GLES20.glGenTextures(1, (IntBuffer)localObject);
    int i = ((IntBuffer)localObject).get();
    GLES20.glBindTexture(3553, i);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    localObject = (ByteBuffer)this.lq.get(paramArrayOfByte.length + "");
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.allocateDirect(paramArrayOfByte.length);
        this.lq.put(paramArrayOfByte.length + "", localObject);
        ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
        ((ByteBuffer)localObject).put(paramArrayOfByte);
        ((ByteBuffer)localObject).position(0);
        GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, (Buffer)localObject);
        return i;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -2015;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLDisplayer", 2, "func draw begins, _srcwidth:" + paramInt1 + ",_srcheight:" + paramInt2 + ",_dstWidth:" + paramInt3 + ",_dstHeight:" + paramInt4 + ",isFull:" + paramBoolean);
    }
    if ((paramInt1 > 700) || (paramInt2 > 900)) {
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceGLDisplayer", 2, "func draw ends, video size is too big. something must be wrong");
      }
    }
    label280:
    label304:
    label328:
    label350:
    label374:
    do
    {
      return;
      GLES20.glClear(16640);
      this.viewWidth = paramInt3;
      this.viewHeight = paramInt4;
      this.srcWidth = paramInt1;
      this.srcHeight = paramInt2;
      this.dstWidth = paramInt1;
      this.dstHeight = paramInt2;
      if (this.xc == -1.0F)
      {
        this.xc = paramFloat;
        this.cmG = paramBoolean;
        LD(this.cmG);
        aS(this.xc);
      }
      if (this.xc != paramFloat)
      {
        this.xc = paramFloat;
        aS(this.xc);
      }
      if (this.cmG != paramBoolean)
      {
        this.cmG = paramBoolean;
        LD(this.cmG);
      }
      if ((this.srcWidth != this.dstWidth) || (this.srcHeight != this.dstHeight)) {
        LD(this.cmG);
      }
      if (this.ez == null)
      {
        this.ez = new byte[this.srcWidth * this.srcHeight];
        if (this.eA != null) {
          break label1140;
        }
        this.eA = new byte[this.srcWidth * this.srcHeight / 4];
        if (this.eB != null) {
          break label1179;
        }
        this.eB = new byte[this.srcWidth * this.srcHeight / 4];
        if (this.eC != null) {
          break label1218;
        }
        this.eC = new byte[this.srcWidth * this.srcHeight];
        if (this.eD != null) {
          break label1253;
        }
        this.eD = new byte[this.srcWidth * this.srcHeight / 4];
        if (this.eE != null) {
          break label1292;
        }
        this.eE = new byte[this.srcWidth * this.srcHeight / 4];
      }
      for (;;)
      {
        try
        {
          System.arraycopy(paramArrayOfByte1, 0, this.ez, 0, this.srcWidth * this.srcHeight);
          System.arraycopy(paramArrayOfByte1, this.srcWidth * this.srcHeight, this.eA, 0, this.srcWidth * this.srcHeight / 4);
          System.arraycopy(paramArrayOfByte1, this.srcWidth * this.srcHeight * 5 / 4, this.eB, 0, this.srcWidth * this.srcHeight / 4);
          System.arraycopy(paramArrayOfByte2, 0, this.eC, 0, this.srcWidth * this.srcHeight);
          System.arraycopy(paramArrayOfByte2, this.srcWidth * this.srcHeight, this.eD, 0, this.srcWidth * this.srcHeight / 4);
          System.arraycopy(paramArrayOfByte2, this.srcWidth * this.srcHeight * 5 / 4, this.eE, 0, this.srcWidth * this.srcHeight / 4);
          if (this.dgz != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.dgz }, 0);
          }
          if (this.dgA != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.dgA }, 0);
          }
          if (this.dgB != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.dgB }, 0);
          }
          if (this.dgF != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.dgF }, 0);
          }
          if (this.dgG != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.dgG }, 0);
          }
          if (this.dgH != -1) {
            GLES20.glDeleteTextures(1, new int[] { this.dgH }, 0);
          }
          this.dgz = i(this.ez, this.srcWidth, this.srcHeight);
          this.dgA = i(this.eA, this.srcWidth / 2, this.srcHeight / 2);
          this.dgB = i(this.eB, this.srcWidth / 2, this.srcHeight / 2);
          this.dgF = i(this.eC, this.srcWidth, this.srcHeight);
          this.dgG = i(this.eD, this.srcWidth / 2, this.srcHeight / 2);
          this.dgH = i(this.eE, this.srcWidth / 2, this.srcHeight / 2);
          if ((this.dgz == -2015) || (this.dgA == -2015) || (this.dgB == -2015) || (this.dgF == -2015) || (this.dgG == -2015) || (this.dgH == -2015)) {
            break;
          }
          GLES20.glVertexAttribPointer(this.dgt, 3, 5126, false, 12, this.j);
          GLES20.glVertexAttribPointer(this.dgu, 2, 5126, false, 8, this.k);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(3553, this.dgF);
          GLES20.glUniform1i(this.dgC, 0);
          GLES20.glActiveTexture(33985);
          GLES20.glBindTexture(3553, this.dgG);
          GLES20.glUniform1i(this.dgD, 1);
          GLES20.glActiveTexture(33986);
          GLES20.glBindTexture(3553, this.dgH);
          GLES20.glUniform1i(this.dgE, 2);
          GLES20.glActiveTexture(33987);
          GLES20.glBindTexture(3553, this.dgz);
          GLES20.glUniform1i(this.dgv, 3);
          GLES20.glActiveTexture(33988);
          GLES20.glBindTexture(3553, this.dgA);
          GLES20.glUniform1i(this.dgw, 4);
          GLES20.glActiveTexture(33989);
          GLES20.glBindTexture(3553, this.dgB);
          GLES20.glUniform1i(this.dgx, 5);
          GLES20.glDrawElements(4, f.length, 5123, this.b);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MagicFaceGLDisplayer", 2, "func draw ends");
          return;
        }
        catch (OutOfMemoryError paramArrayOfByte1) {}
        if (this.ez.length == this.srcWidth * this.srcHeight) {
          break label280;
        }
        this.ez = new byte[this.srcWidth * this.srcHeight];
        break label280;
        if (this.eA.length == this.srcWidth * this.srcHeight / 4) {
          break label304;
        }
        this.eA = new byte[this.srcWidth * this.srcHeight / 4];
        break label304;
        if (this.eB.length == this.srcWidth * this.srcHeight / 4) {
          break label328;
        }
        this.eB = new byte[this.srcWidth * this.srcHeight / 4];
        break label328;
        if (this.eC.length == this.srcWidth * this.srcHeight) {
          break label350;
        }
        this.eC = new byte[this.srcWidth * this.srcHeight];
        break label350;
        if (this.eD.length == this.srcWidth * this.srcHeight / 4) {
          break label374;
        }
        this.eD = new byte[this.srcWidth * this.srcHeight / 4];
        break label374;
        if (this.eE.length != this.srcWidth * this.srcHeight / 4) {
          this.eE = new byte[this.srcWidth * this.srcHeight / 4];
        }
      }
    } while (!QLog.isColorLevel());
    label1140:
    QLog.w("MagicFaceGLDisplayer", 2, "ooooom happens.");
    label1179:
    label1218:
    label1253:
    return;
  }
  
  public void dub()
  {
    this.dgs = aurm.createProgram("attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n", "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n");
    GLES20.glUseProgram(this.dgs);
    this.dgt = GLES20.glGetAttribLocation(this.dgs, "position");
    this.dgu = GLES20.glGetAttribLocation(this.dgs, "textureCoordinate");
    this.dgv = GLES20.glGetUniformLocation(this.dgs, "SamplerY");
    this.dgw = GLES20.glGetUniformLocation(this.dgs, "SamplerU");
    this.dgx = GLES20.glGetUniformLocation(this.dgs, "SamplerV");
    this.dgC = GLES20.glGetUniformLocation(this.dgs, "SamplerY_Alpha");
    this.dgD = GLES20.glGetUniformLocation(this.dgs, "SamplerU_Alpha");
    this.dgE = GLES20.glGetUniformLocation(this.dgs, "SamplerV_Alpha");
    this.dgy = GLES20.glGetUniformLocation(this.dgs, "transformMatrix");
    GLES20.glEnableVertexAttribArray(this.dgt);
    GLES20.glEnableVertexAttribArray(this.dgu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixy
 * JD-Core Version:    0.7.0.1
 */