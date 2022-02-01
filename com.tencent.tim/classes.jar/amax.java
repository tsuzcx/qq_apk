import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.io.IOException;

public class amax
  extends amau
{
  private static String fragmentShaderCode = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230769);
  private boolean aHz;
  private boolean cBQ;
  private int dBr;
  private int dBs = -1;
  private int dBt;
  private Bitmap gf;
  private int mImageHeightFactorLocation;
  private int mImageWidthFactorLocation;
  private float zm = 30.0F;
  private float zn;
  private float zo;
  
  public amax()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", fragmentShaderCode);
    this.mTextureType = 3553;
    this.mFilterType = 106;
  }
  
  public void Pv(String paramString)
  {
    this.cBQ = true;
    this.aHz = true;
    try
    {
      this.gf = rop.a(paramString, null);
      return;
    }
    catch (IOException paramString)
    {
      ram.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "setMosaicPath OutOfMemoryError", paramString);
    }
  }
  
  public void ae(Bitmap paramBitmap)
  {
    i(paramBitmap, 0);
  }
  
  public void bc(float paramFloat)
  {
    this.zm = paramFloat;
  }
  
  public void i(@NonNull Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 180))
    {
      this.cBQ = true;
      this.gf = paramBitmap;
      return;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(360 - paramInt);
    if (this.gf == null) {
      this.gf = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, false);
    }
    for (;;)
    {
      this.cBQ = true;
      return;
      Canvas localCanvas = new Canvas(this.gf);
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF1 = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF2 = new RectF();
      localMatrix.mapRect(localRectF2, localRectF1);
      localCanvas.translate(-localRectF2.left, -localRectF2.top);
      localCanvas.concat(localMatrix);
      localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF1, new Paint());
      localCanvas.setBitmap(null);
    }
  }
  
  public void onDestroy()
  {
    if ((this.aHz) && (this.gf != null) && (!this.gf.isRecycled()))
    {
      this.gf.recycle();
      this.gf = null;
      ram.d("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap recycle");
    }
    if (this.dBs != -1) {
      GlUtil.deleteTexture(this.dBs);
    }
  }
  
  public void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glUniform1f(this.mImageWidthFactorLocation, this.zn);
    GLES20.glUniform1f(this.mImageHeightFactorLocation, this.zo);
    GLES20.glUniform1f(this.dBr, this.zm);
    if (this.gf == null)
    {
      ram.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap can't be null");
      return;
    }
    GLES20.glActiveTexture(33985);
    if ((this.dBs == -1) || (this.cBQ))
    {
      if (this.gf.isRecycled())
      {
        ram.e("Q.qqstory.publish.edit GPUImagePixelationFilter", "mosaic bitmap is recycled");
        return;
      }
      if (this.dBs != -1) {
        GlUtil.deleteTexture(this.dBs);
      }
      this.dBs = GlUtil.createTexture(3553, this.gf);
      this.cBQ = false;
      if (this.aHz) {
        this.gf.recycle();
      }
    }
    GLES20.glBindTexture(3553, this.dBs);
    GLES20.glUniform1i(this.dBt, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.mImageWidthFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidthFactor");
    checkLocation(this.mImageWidthFactorLocation, "imageWidthFactor");
    this.mImageHeightFactorLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeightFactor");
    checkLocation(this.mImageHeightFactorLocation, "imageHeightFactor");
    this.dBr = GLES20.glGetUniformLocation(getProgram(), "pixel");
    checkLocation(this.dBr, "mPixelLocation");
    this.dBt = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
    bc(this.zm);
  }
  
  public void onOutputSizeChanged(int paramInt1, int paramInt2)
  {
    super.onOutputSizeChanged(paramInt1, paramInt2);
    ram.b("Q.qqstory.publish.edit GPUImagePixelationFilter", "onOutputSizeChanged width=%s, height=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.zn = 0.0009259259F;
    this.zo = 0.0005208334F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amax
 * JD-Core Version:    0.7.0.1
 */