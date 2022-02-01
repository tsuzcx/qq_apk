import android.view.View;

public class zwk
  implements zwo
{
  private float jdField_a_of_type_Float = 0.8F;
  private zwi jdField_a_of_type_Zwi = zwi.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private zwi jdField_b_of_type_Zwi = zwi.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Zwi.a(paramView);
    this.jdField_b_of_type_Zwi.a(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.jdField_a_of_type_Float;
    paramFloat = (1.0F - paramFloat) * this.jdField_b_of_type_Float + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwk
 * JD-Core Version:    0.7.0.1
 */