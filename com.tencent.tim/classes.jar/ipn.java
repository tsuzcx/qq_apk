import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import com.tencent.av.opengl.program.DrawProgram;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

@TargetApi(8)
public class ipn
  implements ipm
{
  private static final float[] BOX_COORDINATES = { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  private static final ipp jdField_a_of_type_Ipp = new ipo();
  private float[] W = new float[16];
  private float[] X = new float[16];
  private float[] Y;
  private DrawProgram jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram;
  private irb jdField_a_of_type_Irb = new irb();
  private float[][] jdField_a_of_type_Array2dOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 10, 16 });
  private int arP = -1;
  private final irb b = new irb();
  private final irb c = new irb();
  private ByteBuffer g = ByteBuffer.allocateDirect(12);
  private float gN = 3.0F;
  private float gO = 180.0F;
  private float gP;
  private float[] mAlphas = new float[8];
  private int mBoxCoordinates;
  private int mCountDrawLine;
  private int mCountFillRect;
  private int mCountTextureRect;
  private int mCurrentAlphaIndex;
  private int mCurrentMatrixIndex;
  private volatile int mHeight;
  float[] mMVPMatrix = new float[16];
  private final float[] mTempColor = new float[4];
  private final int[] mTempIntArray = new int[1];
  private final float[] mTempMatrix = new float[32];
  private final RectF mTempSourceRect = new RectF();
  private final RectF mTempTargetRect = new RectF();
  private final float[] mTempTextureMatrix = new float[16];
  private volatile int mWidth;
  
  public ipn()
  {
    Matrix.setIdentityM(this.mTempTextureMatrix, 0);
    this.mAlphas[this.mCurrentAlphaIndex] = 1.0F;
    this.mBoxCoordinates = uploadBuffer(createBuffer(BOX_COORDINATES));
    this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram = new DrawProgram();
    GLES20.glBlendFunc(1, 771);
    irc.lx();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix.frustumM(this.W, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ipq paramipq)
  {
    draw(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramipq.getColor(), paramipq.getLineWidth());
  }
  
  private static void a(RectF paramRectF, iqk paramiqk)
  {
    int i = paramiqk.getTextureWidth();
    int j = paramiqk.getTextureHeight();
    paramRectF.left /= i;
    paramRectF.right /= i;
    paramRectF.top /= j;
    paramRectF.bottom /= j;
  }
  
  private void a(iqk paramiqk, RectF paramRectF1, RectF paramRectF2)
  {
    setTextureMatrix(paramRectF1);
    a(paramiqk, this.mTempTextureMatrix, paramRectF2);
  }
  
  private void a(iqk paramiqk, float[] paramArrayOfFloat, RectF paramRectF)
  {
    iqi[] arrayOfiqi = paramiqk.a(this);
    a(arrayOfiqi, 0);
    GLES20.glUniformMatrix4fv(arrayOfiqi[3].handle, 1, false, paramArrayOfFloat, 0);
    irc.lx();
    if (paramiqk.isFlippedVertically())
    {
      save(2);
      translate(0.0F, paramRectF.centerY());
      scale(1.0F, -1.0F, 1.0F);
      translate(0.0F, -paramRectF.centerY());
    }
    a(arrayOfiqi, 5, 4, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
    if (paramiqk.isFlippedVertically()) {
      restore();
    }
    this.mCountTextureRect += 1;
  }
  
  private void a(iqi[] paramArrayOfiqi, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    pushMatrix();
    translate(paramFloat1, paramFloat2, 0.0F);
    scale(paramFloat3, paramFloat4, 1.0F);
    GLES20.glUniformMatrix4fv(paramArrayOfiqi[1].handle, 1, false, getFinalMatrix(), 0);
    popMatrix();
    irc.lx();
  }
  
  private void a(iqi[] paramArrayOfiqi, int paramInt)
  {
    GLES20.glBindBuffer(34962, this.mBoxCoordinates);
    irc.lx();
    GLES20.glVertexAttribPointer(paramArrayOfiqi[0].handle, 2, 5126, false, 8, paramInt * 8);
    irc.lx();
    GLES20.glBindBuffer(34962, 0);
    irc.lx();
  }
  
  private void a(iqi[] paramArrayOfiqi, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramArrayOfiqi, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    int i = paramArrayOfiqi[0].handle;
    GLES20.glEnableVertexAttribArray(i);
    irc.lx();
    GLES20.glDrawArrays(paramInt1, 0, paramInt2);
    irc.lx();
    GLES20.glDisableVertexAttribArray(i);
    irc.lx();
  }
  
  private static FloatBuffer createBuffer(float[] paramArrayOfFloat)
  {
    FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat, 0, paramArrayOfFloat.length).position(0);
    return localFloatBuffer;
  }
  
  private void draw(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt4, float paramFloat5)
  {
    prepareDraw(paramInt2, paramInt4, paramFloat5);
    a(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a(), paramInt1, paramInt3, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public static void enableBlending(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      irc.lx();
      return;
    }
    GLES20.glDisable(3042);
    irc.lx();
  }
  
  private float[] getColor(int paramInt)
  {
    float f1 = (paramInt >>> 24 & 0xFF) / 255.0F * getAlpha();
    float f2 = (paramInt >>> 16 & 0xFF) / 255.0F;
    float f3 = (paramInt >>> 8 & 0xFF) / 255.0F;
    float f4 = (paramInt & 0xFF) / 255.0F;
    this.mTempColor[0] = (f2 * f1);
    this.mTempColor[1] = (f3 * f1);
    this.mTempColor[2] = (f4 * f1);
    this.mTempColor[3] = f1;
    return this.mTempColor;
  }
  
  private float[] getFinalMatrix()
  {
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.X, 0, this.Y, 0);
    Matrix.multiplyMM(this.mMVPMatrix, 0, this.W, 0, this.mMVPMatrix, 0);
    return this.mMVPMatrix;
  }
  
  private void prepareDraw(int paramInt1, int paramInt2, float paramFloat)
  {
    GLES20.glUseProgram(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.getId());
    irc.lx();
    if (paramFloat > 0.0F)
    {
      GLES20.glLineWidth(paramFloat);
      irc.lx();
    }
    float[] arrayOfFloat = getColor(paramInt2);
    if (arrayOfFloat[3] < 1.0F) {}
    for (boolean bool = true;; bool = false)
    {
      enableBlending(bool);
      if (bool)
      {
        GLES20.glBlendColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
        irc.lx();
      }
      GLES20.glUniform4fv(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a()[2].handle, 1, arrayOfFloat, 0);
      a(this.jdField_a_of_type_ComTencentAvOpenglProgramDrawProgram.a(), paramInt1);
      irc.lx();
      return;
    }
  }
  
  private void setTextureMatrix(RectF paramRectF)
  {
    this.mTempTextureMatrix[0] = paramRectF.width();
    this.mTempTextureMatrix[5] = paramRectF.height();
    this.mTempTextureMatrix[12] = paramRectF.left;
    this.mTempTextureMatrix[13] = paramRectF.top;
  }
  
  private int uploadBuffer(Buffer paramBuffer, int paramInt)
  {
    jdField_a_of_type_Ipp.glGenBuffers(1, this.mTempIntArray, 0);
    irc.lx();
    int i = this.mTempIntArray[0];
    GLES20.glBindBuffer(34962, i);
    irc.lx();
    GLES20.glBufferData(34962, paramBuffer.capacity() * paramInt, paramBuffer, 35044);
    irc.lx();
    return i;
  }
  
  public ipp a()
  {
    return jdField_a_of_type_Ipp;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, ipq paramipq)
  {
    a(3, 4, 2, paramFloat1, paramFloat2, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2, paramipq);
    this.mCountDrawLine += 1;
  }
  
  public void a(iqk paramiqk)
  {
    int j = paramiqk.getTarget();
    int[] arrayOfInt = paramiqk.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramiqk.getId()[i]);
      i += 1;
    }
    irc.lx();
    GLES20.glTexParameteri(j, 10242, 33071);
    GLES20.glTexParameteri(j, 10243, 33071);
    GLES20.glTexParameterf(j, 10241, 9729.0F);
    GLES20.glTexParameterf(j, 10240, 9729.0F);
  }
  
  public void a(iqk paramiqk, int paramInt1, int paramInt2)
  {
    int j = paramiqk.getTarget();
    int[] arrayOfInt = paramiqk.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramiqk.getId()[i]);
      i += 1;
    }
    irc.lx();
    GLES20.glTexImage2D(j, 0, paramInt1, paramiqk.getTextureWidth(), paramiqk.getTextureHeight(), 0, paramInt1, paramInt2, null);
  }
  
  public void a(iqk paramiqk, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 <= 0) || (paramInt4 <= 0)) {
      return;
    }
    Rect localRect = paramiqk.getSourceBounds();
    this.mTempSourceRect.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.mTempTargetRect.set(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    a(this.mTempSourceRect, paramiqk);
    a(paramiqk, this.mTempSourceRect, this.mTempTargetRect);
  }
  
  public void a(iqk paramiqk, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    int j = paramiqk.getTarget();
    int[] arrayOfInt = paramiqk.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramiqk.getId()[i]);
      i += 1;
    }
    irc.lx();
    GLUtils.texSubImage2D(j, 0, paramInt1, paramInt2, paramBitmap, paramInt3, paramInt4);
  }
  
  public void a(iqk paramiqk, Bitmap paramBitmap)
  {
    int j = paramiqk.getTarget();
    int[] arrayOfInt = paramiqk.getId();
    int i = 0;
    while (i < arrayOfInt.length)
    {
      GLES20.glBindTexture(j, paramiqk.getId()[i]);
      i += 1;
    }
    irc.lx();
    GLUtils.texImage2D(j, 0, paramBitmap, 0);
  }
  
  public boolean a(iqk paramiqk)
  {
    boolean bool = paramiqk.isLoaded();
    if (bool) {}
    for (;;)
    {
      synchronized (this.b)
      {
        paramiqk = paramiqk.getId();
        if (paramiqk != null) {
          break label68;
        }
        return bool;
        if (i < paramiqk.length)
        {
          this.b.add(paramiqk[i]);
          i += 1;
          continue;
        }
        return bool;
      }
      return bool;
      label68:
      int i = 0;
    }
  }
  
  public void app()
  {
    this.Y = new float[16];
    Matrix.setRotateM(this.Y, 0, 0.0F, 1.0F, 0.0F, 0.0F);
  }
  
  public void bH(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    a(-paramInt1 / 4, paramInt1 / 4, -paramInt2 / 4, paramInt2 / 4, paramInt2, 1000000.0F);
    setCamera(0.0F, 0.0F, paramInt2 * 2, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    irc.lx();
  }
  
  public void clearBuffer()
  {
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    irc.lx();
    GLES20.glClear(16384);
    irc.lx();
  }
  
  public void deleteRecycledResources()
  {
    synchronized (this.b)
    {
      irb localirb2 = this.b;
      if (this.b.size() > 0)
      {
        jdField_a_of_type_Ipp.glDeleteTextures(null, localirb2.size(), localirb2.getInternalArray(), 0);
        localirb2.clear();
      }
      localirb2 = this.c;
      if (localirb2.size() > 0)
      {
        jdField_a_of_type_Ipp.glDeleteBuffers(null, localirb2.size(), localirb2.getInternalArray(), 0);
        localirb2.clear();
      }
      return;
    }
  }
  
  public Bitmap f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    IntBuffer localIntBuffer = IntBuffer.allocate(paramInt1 * paramInt2);
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localIntBuffer);
    paramBitmap.copyPixelsFromBuffer(IntBuffer.wrap(localIntBuffer.array()));
    return paramBitmap;
  }
  
  public void fillRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    draw(5, 0, 4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 0.0F);
    this.mCountFillRect += 1;
  }
  
  public float getAlpha()
  {
    return this.mAlphas[this.mCurrentAlphaIndex];
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int lq()
  {
    return this.mWidth;
  }
  
  public int lr()
  {
    return this.mHeight;
  }
  
  public void popMatrix()
  {
    int i = 0;
    while (i < 16)
    {
      this.Y[i] = this.jdField_a_of_type_Array2dOfFloat[this.arP][i];
      i += 1;
    }
    this.arP -= 1;
  }
  
  public void pushMatrix()
  {
    this.arP += 1;
    int i = 0;
    while (i < 16)
    {
      this.jdField_a_of_type_Array2dOfFloat[this.arP][i] = this.Y[i];
      i += 1;
    }
  }
  
  public void restore()
  {
    int j = 1;
    int k = this.jdField_a_of_type_Irb.removeLast();
    if ((k & 0x1) == 1)
    {
      i = 1;
      if (i != 0) {
        this.mCurrentAlphaIndex -= 1;
      }
      if ((k & 0x2) != 2) {
        break label67;
      }
    }
    label67:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        this.mCurrentMatrixIndex -= 16;
        popMatrix();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix.rotateM(this.Y, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void save()
  {
    save(-1);
  }
  
  @TargetApi(9)
  public void save(int paramInt)
  {
    int j = 0;
    int i;
    float f;
    if ((paramInt & 0x1) == 1)
    {
      i = 1;
      if (i != 0)
      {
        f = getAlpha();
        this.mCurrentAlphaIndex += 1;
        if (this.mAlphas.length <= this.mCurrentAlphaIndex) {
          if (Build.VERSION.SDK_INT < 9) {
            break label113;
          }
        }
      }
    }
    label113:
    float[] arrayOfFloat;
    for (this.mAlphas = Arrays.copyOf(this.mAlphas, this.mAlphas.length * 2);; this.mAlphas = arrayOfFloat)
    {
      this.mAlphas[this.mCurrentAlphaIndex] = f;
      i = j;
      if ((paramInt & 0x2) == 2) {
        i = 1;
      }
      if (i != 0) {
        pushMatrix();
      }
      this.jdField_a_of_type_Irb.add(paramInt);
      return;
      i = 0;
      break;
      arrayOfFloat = new float[this.mAlphas.length * 2];
      i = 0;
      while (i < this.mAlphas.length)
      {
        arrayOfFloat[i] = this.mAlphas[i];
        i += 1;
      }
    }
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.scaleM(this.Y, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setAlpha(float paramFloat)
  {
    this.mAlphas[this.mCurrentAlphaIndex] = paramFloat;
  }
  
  public void setCamera(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.gP = paramFloat3;
    Matrix.setLookAtM(this.X, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    app();
    a(-paramInt1 / 4, paramInt1 / 4, -paramInt2 / 4, paramInt2 / 4, paramInt2, 1000000.0F);
    setCamera(0.0F, 0.0F, paramInt2 * 2, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    translate(0.0F, paramInt2 / 2, 0.0F);
    scale(1.0F, -1.0F, 1.0F);
    translate(-paramInt1 / 2, 0.0F, 0.0F);
    irc.lx();
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    translate(paramFloat1, paramFloat2, 0.0F);
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix.translateM(this.Y, 0, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public int uploadBuffer(FloatBuffer paramFloatBuffer)
  {
    return uploadBuffer(paramFloatBuffer, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipn
 * JD-Core Version:    0.7.0.1
 */