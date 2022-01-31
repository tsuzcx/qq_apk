import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;

public class ebn
  extends BitmapDrawable
{
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static int h;
  private static int i;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private AccelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator = new AccelerateInterpolator(1.5F);
  private float jdField_b_of_type_Float = 0.5F;
  private int jdField_b_of_type_Int = 50;
  private int g = 0;
  
  public ebn(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static ebn[] a(int paramInt, Resources paramResources, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramResources != null))
    {
      ebn[] arrayOfebn2 = new ebn[paramInt];
      i = paramBitmap.getWidth() / 2;
      h = paramBitmap.getHeight() / 2;
      int j = 0;
      for (;;)
      {
        arrayOfebn1 = arrayOfebn2;
        if (j >= paramInt) {
          break;
        }
        arrayOfebn2[j] = new ebn(paramResources, paramBitmap);
        j += 1;
      }
    }
    ebn[] arrayOfebn1 = null;
    return arrayOfebn1;
  }
  
  public void a() {}
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Float = ((float)paramLong);
    this.jdField_a_of_type_Int = paramInt;
    this.g = 1;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int j = k;
    switch (this.g)
    {
    default: 
      j = k;
    }
    float f2;
    for (;;)
    {
      if (j == 0) {
        invalidateSelf();
      }
      return;
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.g = 2;
      j = 0;
      continue;
      f2 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
      if (f2 <= 1.0F) {
        break;
      }
      this.g = 3;
      j = k;
    }
    paramCanvas.save();
    float f3 = this.jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator.getInterpolation(f2);
    if (f3 > 0.5F) {}
    for (float f1 = -f3 * this.jdField_b_of_type_Int;; f1 = -(1.0F - f3) * this.jdField_b_of_type_Int)
    {
      paramCanvas.translate(f1, this.jdField_a_of_type_Int - f3 * this.jdField_a_of_type_Int);
      paramCanvas.scale(this.jdField_b_of_type_Float * f2, this.jdField_b_of_type_Float * f2, i, h);
      setAlpha((int)(255.0F - f2 * 255.0F));
      super.draw(paramCanvas);
      paramCanvas.restore();
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebn
 * JD-Core Version:    0.7.0.1
 */