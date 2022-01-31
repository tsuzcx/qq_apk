import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class tku
  extends ClickableSpan
{
  tku(tkr paramtkr, String paramString) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_Tkr != null) {
      this.jdField_a_of_type_Tkr.b(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */