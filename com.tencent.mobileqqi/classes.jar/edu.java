import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class edu
  extends ClickableSpan
{
  public edu(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    String str;
    if ((GrayTipsItemBuilder.v(this.a) instanceof Activity))
    {
      if (GrayTipsItemBuilder.E(this.a).jdField_a_of_type_Int != 1006) {
        break label132;
      }
      str = GrayTipsItemBuilder.F(this.a).jdField_a_of_type_JavaLangString;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(GrayTipsItemBuilder.r(this.a), (Activity)GrayTipsItemBuilder.w(this.a), GrayTipsItemBuilder.H(this.a).jdField_a_of_type_Int, paramView, GrayTipsItemBuilder.I(this.a).d, str, true, GrayTipsItemBuilder.J(this.a).b, true, true, null, "from_internal");
      ReportController.b(GrayTipsItemBuilder.s(this.a), "CliOper", "", "", "Two_call", "Clk_addfrd_tips", 0, 0, "", "", "", "");
      return;
      label132:
      paramView = GrayTipsItemBuilder.G(this.a).jdField_a_of_type_JavaLangString;
      str = null;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     edu
 * JD-Core Version:    0.7.0.1
 */