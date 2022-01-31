import android.content.res.ColorStateList;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;

public class ylf
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private String jdField_a_of_type_JavaLangString;
  private ylg jdField_a_of_type_Ylg;
  
  public ylf(String paramString, int paramInt, ylg paramylg)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ylg = paramylg;
  }
  
  public ylf(String paramString, ColorStateList paramColorStateList, ylg paramylg)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_a_of_type_Ylg = paramylg;
  }
  
  public void onClick(View paramView)
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Ylg != null)) {
      this.jdField_a_of_type_Ylg.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.jdField_a_of_type_Int > 0) {
      paramTextPaint.setColor(this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidContentResColorStateList != null) {
      paramTextPaint.setColor(this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(paramTextPaint.drawableState, 0));
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylf
 * JD-Core Version:    0.7.0.1
 */