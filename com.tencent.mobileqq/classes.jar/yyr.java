import android.view.View;

public class yyr
  implements yyv
{
  private float jdField_a_of_type_Float = 0.8F;
  private yyp jdField_a_of_type_Yyp = yyp.a(1);
  private float jdField_b_of_type_Float = 0.2F;
  private yyp jdField_b_of_type_Yyp = yyp.b(1);
  
  public void a(View paramView, float paramFloat)
  {
    this.jdField_a_of_type_Yyp.a(paramView);
    this.jdField_b_of_type_Yyp.a(paramView);
    paramFloat = Math.abs(paramFloat);
    float f = this.jdField_a_of_type_Float;
    paramFloat = (1.0F - paramFloat) * this.jdField_b_of_type_Float + f;
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyr
 * JD-Core Version:    0.7.0.1
 */