import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class wdz
  extends Drawable
{
  public float a;
  public int a;
  public Bitmap a;
  public BitmapShader a;
  public Paint a;
  public Path a;
  public RectF a;
  public boolean a;
  public float b;
  public int b;
  public float c;
  public int c;
  public float d;
  
  public wdz()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  }
  
  private void a()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(null);
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    localMatrix.postScale(getIntrinsicWidth() / i, getIntrinsicHeight() / j);
    localMatrix.postTranslate(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsBitmapShader.setLocalMatrix(localMatrix);
  }
  
  private void a(int paramInt, Path paramPath)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(this.jdField_a_of_type_AndroidGraphicsRectF, paramPath);
      return;
    case 1: 
      c(this.jdField_a_of_type_AndroidGraphicsRectF, paramPath);
      return;
    case 2: 
      b(this.jdField_a_of_type_AndroidGraphicsRectF, paramPath);
      return;
    }
    d(this.jdField_a_of_type_AndroidGraphicsRectF, paramPath);
  }
  
  private void a(Canvas paramCanvas)
  {
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPath);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      do
      {
        return;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
        break;
      } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
      if (this.jdField_a_of_type_AndroidGraphicsBitmapShader == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmapShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsBitmapShader);
      a();
    }
  }
  
  private void a(RectF paramRectF, Path paramPath)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.d = ((paramRectF.bottom - paramRectF.top) / 2.0F - this.jdField_a_of_type_Float / 2.0F);
    }
    paramPath.moveTo(this.jdField_a_of_type_Float + paramRectF.left + this.jdField_b_of_type_Float, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.jdField_b_of_type_Float, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.top, paramRectF.right, this.jdField_b_of_type_Float + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.bottom - this.jdField_b_of_type_Float, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float + this.jdField_b_of_type_Float, paramRectF.bottom);
    paramPath.arcTo(new RectF(paramRectF.left + this.jdField_a_of_type_Float, paramRectF.bottom - this.jdField_b_of_type_Float, this.jdField_b_of_type_Float + paramRectF.left + this.jdField_a_of_type_Float, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float, this.jdField_c_of_type_Float + this.d);
    paramPath.lineTo(paramRectF.left, this.d + this.jdField_c_of_type_Float / 2.0F);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float, this.d);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float, paramRectF.top + this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.left + this.jdField_a_of_type_Float, paramRectF.top, this.jdField_b_of_type_Float + paramRectF.left + this.jdField_a_of_type_Float, this.jdField_b_of_type_Float + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void b(RectF paramRectF, Path paramPath)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.d = ((paramRectF.right - paramRectF.left) / 2.0F - this.jdField_a_of_type_Float / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + Math.min(this.d, this.jdField_b_of_type_Float), paramRectF.top + this.jdField_c_of_type_Float);
    paramPath.lineTo(paramRectF.left + this.d, paramRectF.top + this.jdField_c_of_type_Float);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float / 2.0F + this.d, paramRectF.top);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float + this.d, paramRectF.top + this.jdField_c_of_type_Float);
    paramPath.lineTo(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.top + this.jdField_c_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.top + this.jdField_c_of_type_Float, paramRectF.right, this.jdField_b_of_type_Float + paramRectF.top + this.jdField_c_of_type_Float), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.bottom - this.jdField_b_of_type_Float, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.jdField_b_of_type_Float, paramRectF.bottom);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.bottom - this.jdField_b_of_type_Float, this.jdField_b_of_type_Float + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.jdField_c_of_type_Float + this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top + this.jdField_c_of_type_Float, this.jdField_b_of_type_Float + paramRectF.left, this.jdField_b_of_type_Float + paramRectF.top + this.jdField_c_of_type_Float), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void c(RectF paramRectF, Path paramPath)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.d = ((paramRectF.bottom - paramRectF.top) / 2.0F - this.jdField_a_of_type_Float / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + this.jdField_b_of_type_Float, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.jdField_b_of_type_Float - this.jdField_a_of_type_Float, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float - this.jdField_a_of_type_Float, paramRectF.top, paramRectF.right - this.jdField_a_of_type_Float, this.jdField_b_of_type_Float + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right - this.jdField_a_of_type_Float, this.d);
    paramPath.lineTo(paramRectF.right, this.d + this.jdField_c_of_type_Float / 2.0F);
    paramPath.lineTo(paramRectF.right - this.jdField_a_of_type_Float, this.d + this.jdField_c_of_type_Float);
    paramPath.lineTo(paramRectF.right - this.jdField_a_of_type_Float, paramRectF.bottom - this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float - this.jdField_a_of_type_Float, paramRectF.bottom - this.jdField_b_of_type_Float, paramRectF.right - this.jdField_a_of_type_Float, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float, paramRectF.bottom);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.bottom - this.jdField_b_of_type_Float, this.jdField_b_of_type_Float + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.jdField_b_of_type_Float + paramRectF.left, this.jdField_b_of_type_Float + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void d(RectF paramRectF, Path paramPath)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.d = ((paramRectF.right - paramRectF.left) / 2.0F - this.jdField_a_of_type_Float / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + this.jdField_b_of_type_Float, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.jdField_b_of_type_Float, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.top, paramRectF.right, this.jdField_b_of_type_Float + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.jdField_c_of_type_Float - this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.right - this.jdField_b_of_type_Float, paramRectF.bottom - this.jdField_b_of_type_Float - this.jdField_c_of_type_Float, paramRectF.right, paramRectF.bottom - this.jdField_c_of_type_Float), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.jdField_a_of_type_Float + this.d, paramRectF.bottom - this.jdField_c_of_type_Float);
    paramPath.lineTo(paramRectF.left + this.d + this.jdField_a_of_type_Float / 2.0F, paramRectF.bottom);
    paramPath.lineTo(paramRectF.left + this.d, paramRectF.bottom - this.jdField_c_of_type_Float);
    paramPath.lineTo(paramRectF.left + Math.min(this.jdField_b_of_type_Float, this.d), paramRectF.bottom - this.jdField_c_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.bottom - this.jdField_b_of_type_Float - this.jdField_c_of_type_Float, this.jdField_b_of_type_Float + paramRectF.left, paramRectF.bottom - this.jdField_c_of_type_Float), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.jdField_b_of_type_Float);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.jdField_b_of_type_Float + paramRectF.left, this.jdField_b_of_type_Float + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  public void draw(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.jdField_a_of_type_AndroidGraphicsRectF.height();
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.jdField_a_of_type_AndroidGraphicsRectF.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wdz
 * JD-Core Version:    0.7.0.1
 */