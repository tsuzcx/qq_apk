import android.view.View;

public class yuc
  implements yug
{
  private float jdField_a_of_type_Float = 0.8F;
  private yua jdField_a_of_type_Yua = yua.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private yua jdField_b_of_type_Yua = yua.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Yua.a(paramView);
    this.jdField_b_of_type_Yua.a(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.jdField_a_of_type_Float;
    paramFloat = (1.0F - paramFloat) * this.jdField_b_of_type_Float + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yuc
 * JD-Core Version:    0.7.0.1
 */