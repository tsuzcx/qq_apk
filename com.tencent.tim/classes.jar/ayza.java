import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilter;
import com.tencent.ttpic.openapi.filter.GaussianBlurFilterCompose;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ayza
{
  private ayyx jdField_a_of_type_Ayyx;
  private GaussianBlurFilter jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter;
  private GaussianBlurFilterCompose b;
  private String cYl;
  private int eNr;
  private int eNu = -1;
  private float[] ej;
  private float[] em;
  private float[] en;
  private float[] eo;
  private RenderBuffer m;
  private Context mContext;
  private RenderBuffer mRenderBuffer;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private TextureRender mTextureRender;
  private int mVideoHeight;
  private int mVideoWidth;
  private RenderBuffer n;
  
  public ayza(Context paramContext, String paramString)
  {
    this(paramContext, paramString, 0);
  }
  
  public ayza(Context paramContext, String paramString, int paramInt)
  {
    this.cYl = paramString;
    this.mContext = paramContext;
    this.eNr = paramInt;
  }
  
  private void ab(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mTextureRender = new TextureRender();
    this.b = new GaussianBlurFilterCompose();
    this.b.init(paramInt1 / 4, paramInt2 / 4);
    this.jdField_a_of_type_Ayyx = new ayyx();
    this.jdField_a_of_type_Ayyx.init(paramInt1, paramInt2, (int)(20.0F * paramInt1 / 550.0F));
    this.n = new RenderBuffer(paramInt1, paramInt2, 33984);
    ayyu localayyu = new ayyu();
    localayyu.init();
    localayyu.b(0.0F, 0.0F, 0.0F, 0.25F);
    localayyu.am(0.05454546F, 0.03061225F);
    this.n.bind();
    localayyu.h(null, null);
    this.n.unbind();
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter = this.b.getFilter();
    this.mRenderBuffer = new RenderBuffer(paramInt3, paramInt4, 33984);
    this.m = new RenderBuffer(paramInt1, paramInt2, 33984);
    eUu();
    this.ej = GPUBaseFilter.caculateCenterCropMvpMatrix(paramInt1, paramInt2, paramInt3, paramInt4);
    this.em = b(paramInt1, paramInt2, paramInt3, paramInt4);
    this.en = new float[16];
    System.arraycopy(this.em, 0, this.en, 0, 16);
    Matrix.translateM(this.en, 0, 0.02181818F, 0.0122449F, 0.0F);
    Matrix.scaleM(this.en, 0, 1.109091F, 1.061225F, 1.0F);
  }
  
  private static float[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 0.734F;
    float f1 = paramInt3 / paramInt4;
    float f3 = paramInt1 / paramInt2;
    if (f1 > f3) {
      f1 = f3 / f1 * 0.734F;
    }
    for (;;)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.translateM(arrayOfFloat, 0, 0.0F, -0.091F, 0.0F);
      Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
      return arrayOfFloat;
      if (f1 < f3)
      {
        f2 = f1 / f3;
        f1 = 0.734F;
        f2 *= 0.734F;
      }
      else
      {
        f1 = 0.734F;
      }
    }
  }
  
  @NonNull
  private void eUu()
  {
    Object localObject = new TextPaint();
    ((TextPaint)localObject).setAntiAlias(true);
    ((TextPaint)localObject).setStyle(Paint.Style.FILL_AND_STROKE);
    ((TextPaint)localObject).setTextSize(22.0F);
    ((TextPaint)localObject).setColor(-1);
    ((TextPaint)localObject).setFakeBoldText(true);
    ((TextPaint)localObject).setStrokeWidth(0.5F);
    ((TextPaint)localObject).setShadowLayer(4.0F, 0.0F, 0.0F, 1073741824);
    Paint.FontMetrics localFontMetrics = ((TextPaint)localObject).getFontMetrics();
    float f1 = localFontMetrics.bottom - localFontMetrics.top;
    float f2 = localFontMetrics.descent - localFontMetrics.ascent;
    float f3 = ((TextPaint)localObject).measureText(this.cYl) + 2.0F;
    ram.d("StoryVideoForwardFilter", "createWaterMarkTextureAndCalculateMvpMatrix textHeight=" + f1);
    Bitmap localBitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), 2130847706);
    Bitmap localBitmap1 = Bitmap.createBitmap((int)f3 + 6 + (int)f2, (int)f1 + 1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap1);
    localCanvas.drawBitmap(localBitmap2, null, new Rect((int)f3 + 5, (int)(f1 - f2) / 2 + 1, (int)f3 + 5 + (int)f2, (int)(f2 + f1) / 2), (Paint)localObject);
    localBitmap2.recycle();
    localCanvas.drawText(this.cYl, 2.0F, f1 - localFontMetrics.bottom, (Paint)localObject);
    this.eNu = GlUtil.createTexture(3553, localBitmap1);
    GLES20.glBindTexture(3553, 0);
    this.eo = new float[16];
    Matrix.setIdentityM(this.eo, 0);
    localObject = m();
    f3 = this.mSurfaceWidth / 750.0F;
    f2 = localBitmap1.getWidth() * f3;
    f1 = localBitmap1.getHeight() * f3;
    float f6 = localObject[0];
    float f7 = f2 / 2.0F;
    float f4 = localObject[1];
    float f5 = f1 / 2.0F;
    f6 = (f6 + f7 + 20.0F * f3) / (this.mSurfaceWidth / 2);
    f3 = (f4 + f5 + f3 * 18.0F) / (this.mSurfaceHeight / 2);
    Matrix.translateM(this.eo, 0, f6, f3, 0.0F);
    f2 /= this.mSurfaceWidth;
    f1 /= this.mSurfaceHeight;
    Matrix.scaleM(this.eo, 0, f2, f1, 1.0F);
    if (localBitmap1 != null) {
      localBitmap1.recycle();
    }
  }
  
  private float[] m()
  {
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (-this.mSurfaceWidth * 0.734F * 0.5F);
    arrayOfFloat[1] = (-this.mSurfaceHeight * 0.734F * 0.5F);
    float f1 = this.mSurfaceWidth / this.mSurfaceHeight;
    float f2 = this.mVideoWidth / this.mVideoHeight;
    float f3;
    if (f1 > f2)
    {
      f3 = arrayOfFloat[0];
      arrayOfFloat[0] = (f2 / f1 * f3);
    }
    for (;;)
    {
      arrayOfFloat[1] += -0.091F * this.mSurfaceHeight / 2.0F;
      return arrayOfFloat;
      if (f1 < f2)
      {
        f3 = arrayOfFloat[1];
        arrayOfFloat[1] = (f1 / f2 * f3);
      }
    }
  }
  
  public void ac(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSurfaceWidth = paramInt3;
    this.mSurfaceHeight = paramInt4;
    if (this.eNr % 180 != 0) {
      this.mVideoWidth = paramInt2;
    }
    for (this.mVideoHeight = paramInt1;; this.mVideoHeight = paramInt2)
    {
      ab(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
      return;
      this.mVideoWidth = paramInt1;
    }
  }
  
  public int mh(int paramInt)
  {
    int i = paramInt;
    if (this.eNr != 0)
    {
      float[] arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
      Matrix.rotateM(arrayOfFloat, 0, this.eNr, 0.0F, 0.0F, 1.0F);
      this.m.bind();
      this.mTextureRender.drawTexture(3553, paramInt, null, arrayOfFloat);
      this.m.unbind();
      i = this.m.getTexId();
    }
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter.isInitSucc())) {
      this.b.drawTexture(i);
    }
    this.mRenderBuffer.bind();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter != null) && (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter.isInitSucc()))
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.75F);
      this.mTextureRender.drawTexture(3553, this.b.getTextureId(), null, this.ej);
      GLES20.glDisable(3042);
    }
    for (;;)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      this.mTextureRender.drawTexture(3553, this.n.getTexId(), null, this.en);
      GLES20.glDisable(3042);
      this.jdField_a_of_type_Ayyx.drawTexture(i, null, this.em);
      if (this.eNu != -1)
      {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        this.mTextureRender.drawTexture(3553, this.eNu, null, this.eo);
        GLES20.glDisable(3042);
      }
      this.mRenderBuffer.unbind();
      return this.mRenderBuffer.getTexId();
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(32771, 771);
      GLES20.glBlendColor(0.0F, 0.0F, 0.0F, 0.1F);
      this.mTextureRender.drawTexture(3553, i, null, this.ej);
      GLES20.glDisable(3042);
    }
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if ((this.mSurfaceWidth != paramInt1) || (this.mSurfaceHeight != paramInt2))
    {
      this.mSurfaceWidth = paramInt1;
      this.mSurfaceHeight = paramInt2;
      ab(this.mVideoWidth, this.mVideoHeight, this.mSurfaceWidth, this.mSurfaceHeight);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterGaussianBlurFilter.destroy();
    }
    if (this.b != null) {
      this.b.destroy();
    }
    if (this.mTextureRender != null) {
      this.mTextureRender.release();
    }
    if (this.mRenderBuffer != null) {
      this.mRenderBuffer.destroy();
    }
    if (this.eNu != -1) {
      GlUtil.deleteTexture(this.eNu);
    }
    if (this.n != null) {
      this.n.destroy();
    }
    if (this.jdField_a_of_type_Ayyx != null) {
      this.jdField_a_of_type_Ayyx.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayza
 * JD-Core Version:    0.7.0.1
 */