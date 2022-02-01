import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class upi
  extends ClickableSpan
{
  upi(upg paramupg, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_Upg != null) {
      this.jdField_a_of_type_Upg.a(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upi
 * JD-Core Version:    0.7.0.1
 */