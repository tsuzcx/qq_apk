import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class ypq
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private ypr jdField_a_of_type_Ypr;
  private String b;
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ypr != null) {
      this.jdField_a_of_type_Ypr.a(this.jdField_a_of_type_JavaLangString, this.b);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.jdField_a_of_type_Int != -2147483648)
    {
      paramTextPaint.setColor(this.jdField_a_of_type_Int);
      return;
    }
    super.updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ypq
 * JD-Core Version:    0.7.0.1
 */