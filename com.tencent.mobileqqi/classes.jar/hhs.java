import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mobileqq.widget.ShaderAnimLayout;

public class hhs
  extends Animation
{
  public hhs(ShaderAnimLayout paramShaderAnimLayout) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    if (this.a.jdField_a_of_type_Boolean == true) {}
    for (this.a.jdField_a_of_type_Float = (1.0F - paramFloat);; this.a.jdField_a_of_type_Float = paramFloat)
    {
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhs
 * JD-Core Version:    0.7.0.1
 */