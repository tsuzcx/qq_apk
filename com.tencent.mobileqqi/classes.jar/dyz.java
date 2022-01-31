import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class dyz
  extends ClickableSpan
{
  public dyz(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    String str;
    if ((GrayTipsItemBuilder.j(this.a) instanceof Activity))
    {
      if (GrayTipsItemBuilder.g(this.a).jdField_a_of_type_Int != 1006) {
        break label154;
      }
      str = GrayTipsItemBuilder.h(this.a).jdField_a_of_type_JavaLangString;
      paramView = null;
    }
    for (;;)
    {
      ChatActivityUtils.a(GrayTipsItemBuilder.e(this.a), (Activity)GrayTipsItemBuilder.k(this.a), GrayTipsItemBuilder.j(this.a).jdField_a_of_type_Int, paramView, GrayTipsItemBuilder.k(this.a).d, str, true, GrayTipsItemBuilder.l(this.a).b, true, true, null, "");
      str = ChatActivityUtils.a(GrayTipsItemBuilder.m(this.a).jdField_a_of_type_Int);
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      ReportController.b(GrayTipsItemBuilder.f(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "13", paramView, "", "");
      return;
      label154:
      paramView = GrayTipsItemBuilder.i(this.a).jdField_a_of_type_JavaLangString;
      str = null;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dyz
 * JD-Core Version:    0.7.0.1
 */