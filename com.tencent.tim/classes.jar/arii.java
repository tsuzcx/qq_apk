import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class arii
  extends Animation
{
  public float BV = 800.0F;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private arii.a jdField_a_of_type_Arii$a;
  private final float centerX;
  private final float centerY;
  private final boolean dbr;
  
  public arii(float paramFloat1, float paramFloat2, boolean paramBoolean, int paramInt)
  {
    this.centerX = paramFloat1;
    this.centerY = paramFloat2;
    this.dbr = paramBoolean;
    this.BV = paramInt;
    setDuration(800L);
  }
  
  public void a(arii.a parama)
  {
    this.jdField_a_of_type_Arii$a = parama;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int i = 1;
    if (this.jdField_a_of_type_Arii$a != null) {
      this.jdField_a_of_type_Arii$a.interpolatedTime(paramFloat);
    }
    float f1;
    float f2;
    if (this.dbr == true)
    {
      f1 = 180.0F;
      f2 = 0.0F;
    }
    for (;;)
    {
      f2 = (f1 - f2) * paramFloat + f2;
      if (paramFloat > 0.5F) {}
      for (;;)
      {
        f1 = f2;
        if (i != 0) {
          f1 = f2 - 180.0F;
        }
        paramFloat = Math.abs(paramFloat - 0.5F);
        f2 = this.BV;
        paramTransformation = paramTransformation.getMatrix();
        this.jdField_a_of_type_AndroidGraphicsCamera.save();
        this.jdField_a_of_type_AndroidGraphicsCamera.translate(0.0F, 0.0F, (0.5F - paramFloat) * f2);
        this.jdField_a_of_type_AndroidGraphicsCamera.rotateY(f1);
        this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(paramTransformation);
        this.jdField_a_of_type_AndroidGraphicsCamera.restore();
        paramTransformation.preTranslate(-this.centerX, -this.centerY);
        paramTransformation.postTranslate(this.centerX, this.centerY);
        return;
        if (this.dbr) {
          break label183;
        }
        f2 = 360.0F;
        f1 = 180.0F;
        break;
        i = 0;
      }
      label183:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  }
  
  public static abstract interface a
  {
    public abstract void interpolatedTime(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arii
 * JD-Core Version:    0.7.0.1
 */