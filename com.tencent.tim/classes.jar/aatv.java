import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class aatv
{
  private static final FloatBuffer TEXTURE_BUF;
  public static final float[] TEXUTURE_COORDS;
  private static final FloatBuffer VERTEXT_BUF;
  public static final float[] VERTEXT_COORDS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static AtomicInteger aM = new AtomicInteger(0);
  private static int mProgram;
  private long My;
  private boolean bzu;
  private float mHeight;
  private long mID;
  private float mSpeed;
  private float mSpeedRate = 1.0F;
  private float mWidth;
  private float pd;
  private float pe;
  private float rQ = 1.0F;
  
  static
  {
    TEXUTURE_COORDS = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
    TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
    mProgram = -1;
  }
  
  public aatv(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.mID = paramLong1;
    this.My = paramLong2;
    this.bzu = paramBoolean;
    if (this.bzu) {
      cyy();
    }
  }
  
  public static Bitmap a(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
      return null;
    }
    int i = (int)paramFloat1;
    int j = (int)paramFloat2;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i + 1, j + 1, Bitmap.Config.ARGB_8888);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      new Canvas(localBitmap).drawPaint(localPaint);
      return localBitmap;
    }
    catch (Exception localException)
    {
      QLog.e("ItemBase", 2, "createcache exception:" + localException);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ItemBase", 2, "createcache OOM:");
    }
    return null;
  }
  
  public static void a(RenderBuffer paramRenderBuffer, int paramInt, float paramFloat1, float paramFloat2, RectF paramRectF, float paramFloat3, float paramFloat4)
  {
    if ((paramRenderBuffer == null) || (paramInt <= 0)) {}
    int j;
    int k;
    do
    {
      return;
      j = paramRenderBuffer.getWidth();
      k = paramRenderBuffer.getHeight();
    } while ((k <= 0) || (j <= 0));
    checkGlError("onDrawFrame start");
    int i = getProgram();
    float f2;
    float f1;
    if (paramRectF != null)
    {
      f2 = paramRectF.width();
      f1 = paramRectF.height();
    }
    for (;;)
    {
      paramRenderBuffer = new float[16];
      Matrix.setIdentityM(paramRenderBuffer, 0);
      if (paramRectF != null)
      {
        Matrix.translateM(paramRenderBuffer, 0, paramRectF.left / paramFloat1, paramRectF.top / paramFloat2, 0.0F);
        Matrix.scaleM(paramRenderBuffer, 0, f2 / paramFloat1, f1 / paramFloat2, 0.0F);
      }
      paramRectF = new float[16];
      Matrix.setIdentityM(paramRectF, 0);
      Matrix.translateM(paramRectF, 0, (2.0F * paramFloat3 + f2) / j - 1.0F, (2.0F * paramFloat4 + f1) / k - 1.0F, 0.0F);
      Matrix.scaleM(paramRectF, 0, f2 / j, f1 / k, 1.0F);
      GLES20.glUseProgram(i);
      checkGlError("glUseProgram");
      j = GLES20.glGetAttribLocation(i, "aPosition");
      k = GLES20.glGetAttribLocation(i, "aTextureCoord");
      int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
      i = GLES20.glGetUniformLocation(i, "uTextureMatrix");
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, VERTEXT_BUF);
      checkGlError("glVertexAttribPointer aPosition");
      GLES20.glEnableVertexAttribArray(j);
      checkGlError("glEnableVertexAttribArray mPositionHandle");
      GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, TEXTURE_BUF);
      checkGlError("glVertexAttribPointer mTextureHandle");
      GLES20.glEnableVertexAttribArray(k);
      checkGlError("glEnableVertexAttribArray mTextureHandle");
      GLES20.glUniformMatrix4fv(m, 1, false, paramRectF, 0);
      GLES20.glUniformMatrix4fv(i, 1, false, paramRenderBuffer, 0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      GLES20.glDrawArrays(5, 0, 4);
      checkGlError("glDrawArrays");
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, 0);
      return;
      f1 = paramFloat2;
      f2 = paramFloat1;
    }
  }
  
  public static void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      QLog.e("ItemBase", 2, paramString + ": glError " + i);
    }
  }
  
  public static void cyy()
  {
    try
    {
      if (mProgram > 0) {
        break label59;
      }
      mProgram = GlUtil.createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
      if (mProgram == 0) {
        throw new RuntimeException("ItemBase: failed to creating program ");
      }
    }
    finally {}
    if (QLog.isColorLevel()) {
      QLog.d("ItemBase", 2, "initOpenGL, program OK");
    }
    label59:
    int i = 0;
    if (mProgram > 0) {
      i = aM.addAndGet(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ItemBase", 2, "supportOpenGL, current refcount: " + i);
    }
  }
  
  public static void cyz()
  {
    try
    {
      int i = aM.decrementAndGet();
      if ((i <= 0) && (mProgram > 0))
      {
        GLES20.glDeleteProgram(mProgram);
        mProgram = -1;
        if (QLog.isColorLevel()) {
          QLog.d("ItemBase", 2, "program deleted. ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ItemBase", 2, "unInitOpenGL, current refcount: " + i);
      }
      return;
    }
    finally {}
  }
  
  public static int getProgram()
  {
    return mProgram;
  }
  
  public boolean Xn()
  {
    return this.bzu;
  }
  
  public void a(RenderBuffer paramRenderBuffer) {}
  
  public void cbf() {}
  
  public void cyv()
  {
    this.pd -= this.mSpeed;
  }
  
  public void cyx()
  {
    this.bzu = true;
    cyy();
  }
  
  public void p(int paramInt, float paramFloat)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      this.pd = paramFloat;
      return;
    case 7: 
      this.pe = paramFloat;
      return;
    case 4: 
      this.mHeight = paramFloat;
      return;
    case 3: 
      this.mWidth = paramFloat;
      return;
    case 5: 
      this.mSpeed = paramFloat;
      return;
    case 8: 
      this.rQ = paramFloat;
      return;
    }
    this.mSpeedRate = paramFloat;
  }
  
  public float q(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException();
    case 6: 
      return this.pd;
    case 7: 
      return this.pe;
    case 4: 
      return this.mHeight;
    case 3: 
      return this.mWidth;
    case 5: 
      return this.mSpeed;
    case 8: 
      return this.rQ;
    }
    return this.mSpeedRate;
  }
  
  public void unInit()
  {
    if (this.bzu) {
      cyz();
    }
    cbf();
  }
  
  public long z(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException();
    case 2: 
      return this.My;
    }
    return this.mID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatv
 * JD-Core Version:    0.7.0.1
 */