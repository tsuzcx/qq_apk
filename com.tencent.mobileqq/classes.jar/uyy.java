import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;

public class uyy
  extends ClickableSpan
{
  public uyy(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramView = ActionSheet.a(this.a.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131433829);
      paramView.c(2131433015);
      paramView.a(new uyz(this));
      paramView.a(new uza(this, paramView));
      paramView.show();
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */