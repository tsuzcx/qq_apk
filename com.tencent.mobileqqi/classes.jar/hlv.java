import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class hlv
  extends Animation
{
  private float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  private float b;
  
  public hlv(View paramView, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.b;
    float f3 = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb((int)((f1 + (f2 - f3) * paramFloat) * 255.0F), 255, 255, 255));
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hlv
 * JD-Core Version:    0.7.0.1
 */