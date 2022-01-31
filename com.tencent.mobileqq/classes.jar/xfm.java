import android.view.View;

public class xfm
  implements xfq
{
  private float jdField_a_of_type_Float = 0.8F;
  private xfk jdField_a_of_type_Xfk = xfk.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private xfk jdField_b_of_type_Xfk = xfk.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Xfk.a(paramView);
    this.jdField_b_of_type_Xfk.a(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.jdField_a_of_type_Float;
    paramFloat = (1.0F - paramFloat) * this.jdField_b_of_type_Float + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfm
 * JD-Core Version:    0.7.0.1
 */