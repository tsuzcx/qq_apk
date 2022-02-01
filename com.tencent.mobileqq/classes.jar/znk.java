import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class znk
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private znl jdField_a_of_type_Znl;
  private String b;
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Znl != null) {
      this.jdField_a_of_type_Znl.a(this.jdField_a_of_type_JavaLangString, this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     znk
 * JD-Core Version:    0.7.0.1
 */