import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class upx
  extends ClickableSpan
{
  upx(upy paramupy, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Upy.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.getColor());
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upx
 * JD-Core Version:    0.7.0.1
 */