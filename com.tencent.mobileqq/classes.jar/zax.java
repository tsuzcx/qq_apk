import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;

public class zax
  extends zfw
{
  public final RectF a;
  public final Drawable a;
  public final String d;
  public final String e;
  
  public zax(zat paramzat, @NonNull Drawable paramDrawable, @NonNull zbb paramzbb, String paramString1, String paramString2)
  {
    super(paramzbb.jdField_a_of_type_AndroidGraphicsPointF, paramzbb.jdField_a_of_type_Float, paramzbb.jdField_b_of_type_Float, paramzbb.c, paramzbb.d, paramzbb.jdField_a_of_type_Int, paramzbb.jdField_b_of_type_Int, true);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_d_of_type_JavaLangString = paramString1;
    this.e = paramString2;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramDrawable.getBounds());
  }
  
  public void a(Canvas paramCanvas)
  {
    float f2 = this.n;
    float f1 = this.o;
    if (f2 * this.j < 200.0F) {
      f2 = 200.0F / this.j;
    }
    if (this.j * f1 < 200.0F) {
      f1 = 200.0F / this.j;
    }
    paramCanvas.save();
    paramCanvas.concat(this.b.a.a(this));
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    if (this.jdField_d_of_type_Boolean) {
      zft.a(paramCanvas, this.b.a, this, 0, 2130844636, 2130844643);
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    float f2 = this.n;
    float f1 = this.o;
    if (f2 * this.j < 200.0F) {
      f2 = 200.0F / this.j;
    }
    if (this.j * f1 < 200.0F) {
      f1 = 200.0F / this.j;
    }
    paramCanvas.save();
    paramCanvas.translate(-this.n / 2.0F, -this.o / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zay(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new zaz(this));
    }
    if (!this.c) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.c)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zax
 * JD-Core Version:    0.7.0.1
 */