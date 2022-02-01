import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;

public class vuu
  extends ClickableSpan
{
  public vuu(QCircleAsyncTextView paramQCircleAsyncTextView, vux paramvux) {}
  
  public void onClick(@NonNull View paramView)
  {
    QCircleAsyncTextView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView, true);
    if (this.jdField_a_of_type_Vux != null) {
      this.jdField_a_of_type_Vux.a();
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.a);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuu
 * JD-Core Version:    0.7.0.1
 */