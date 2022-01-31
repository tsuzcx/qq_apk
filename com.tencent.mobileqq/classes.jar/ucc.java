import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;

public class ucc
  extends ClickableSpan
{
  public ucc(QCircleAsyncTextView paramQCircleAsyncTextView, ucd paramucd) {}
  
  public void onClick(@NonNull View paramView)
  {
    QCircleAsyncTextView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView, true);
    if (this.jdField_a_of_type_Ucd != null) {
      this.jdField_a_of_type_Ucd.a();
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucc
 * JD-Core Version:    0.7.0.1
 */