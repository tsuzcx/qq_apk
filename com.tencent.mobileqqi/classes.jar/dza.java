import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class dza
  extends ClickableSpan
{
  public dza(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    String str;
    if ((GrayTipsItemBuilder.l(this.a) instanceof Activity))
    {
      if (GrayTipsItemBuilder.n(this.a).jdField_a_of_type_Int != 1006) {
        break label153;
      }
      str = GrayTipsItemBuilder.o(this.a).jdField_a_of_type_JavaLangString;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(GrayTipsItemBuilder.g(this.a), (Activity)GrayTipsItemBuilder.m(this.a), GrayTipsItemBuilder.q(this.a).jdField_a_of_type_Int, paramView, GrayTipsItemBuilder.r(this.a).d, str, true, GrayTipsItemBuilder.s(this.a).b, true, true, null, null);
      str = ChatActivityUtils.a(GrayTipsItemBuilder.t(this.a).jdField_a_of_type_Int);
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      ReportController.b(GrayTipsItemBuilder.h(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "12", paramView, "", "");
      return;
      label153:
      paramView = GrayTipsItemBuilder.p(this.a).jdField_a_of_type_JavaLangString;
      str = null;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dza
 * JD-Core Version:    0.7.0.1
 */