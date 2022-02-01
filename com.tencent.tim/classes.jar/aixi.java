import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class aixi
  extends Drawable
  implements aixh
{
  private aixi.a jdField_a_of_type_Aixi$a;
  private aixp jdField_a_of_type_Aixp;
  private Bitmap ft;
  private int mTargetDensity;
  
  private aixi(aixi.a parama, Resources paramResources)
  {
    this.jdField_a_of_type_Aixi$a = parama;
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = parama.mTargetDensity)
    {
      dvi();
      return;
    }
  }
  
  public aixi(aixq paramaixq, Resources paramResources)
  {
    this(new aixi.a(paramaixq), paramResources);
  }
  
  private void dvi()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func initGifEngine");
    }
    aixp.a locala = new aixp.a();
    locala.a = this;
    locala.cBJ = this.jdField_a_of_type_Aixi$a.cBJ;
    locala.mDuration = this.jdField_a_of_type_Aixi$a.mDuration;
    if (!this.jdField_a_of_type_Aixi$a.cmw) {}
    for (locala.fo = null;; locala.fo = this.jdField_a_of_type_Aixi$a.fo)
    {
      this.jdField_a_of_type_Aixp = new aixp();
      this.jdField_a_of_type_Aixp.a(locala);
      return;
    }
  }
  
  public void P(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func onBitmapReady,bitmap:" + paramBitmap);
    }
    if (paramBitmap == null) {
      return;
    }
    if ((this.ft != null) && (!this.ft.isRecycled())) {
      this.ft.recycle();
    }
    this.ft = paramBitmap;
    invalidateSelf();
  }
  
  public void Qr(int paramInt)
  {
    if (this.jdField_a_of_type_Aixp == null) {
      return;
    }
    if ((this.jdField_a_of_type_Aixi$a.fp != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_Aixi$a.fp.length)) {
      this.jdField_a_of_type_Aixp.Mb(this.jdField_a_of_type_Aixi$a.fp[paramInt]);
    }
    this.jdField_a_of_type_Aixp.start();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func draw,bitmap:" + this.ft);
    }
    if ((this.ft != null) && (!this.ft.isRecycled())) {
      paramCanvas.drawBitmap(this.ft, null, getBounds(), this.jdField_a_of_type_Aixi$a.mPaint);
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.ft;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.jdField_a_of_type_Aixi$a;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isValid()
  {
    return (this.ft != null) && (!this.ft.isRecycled());
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Aixi$a.mPaint.getAlpha())
    {
      this.jdField_a_of_type_Aixi$a.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Aixi$a.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  static final class a
    extends Drawable.ConstantState
  {
    int cBJ;
    boolean cmw;
    String[] fo;
    String[] fp;
    int mDuration;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    Shader.TileMode mTileModeX = null;
    Shader.TileMode mTileModeY = null;
    
    public a(aixq paramaixq)
    {
      if (paramaixq == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PngFrameDrawable", 2, "【ramdom magic】 png frame param is null.");
        }
        throw new IllegalArgumentException("【ramdom magic】 png frame param is null.");
      }
      this.fo = paramaixq.fq;
      this.fp = paramaixq.fr;
      this.mDuration = paramaixq.mDuration;
      this.cBJ = paramaixq.cBJ;
      this.cmw = paramaixq.cmw;
    }
    
    public int getChangingConfigurations()
    {
      return 0;
    }
    
    public Drawable newDrawable()
    {
      return new aixi(this, null, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameDrawable", 2, "func newDrawable");
      }
      return new aixi(this, paramResources, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aixi
 * JD-Core Version:    0.7.0.1
 */