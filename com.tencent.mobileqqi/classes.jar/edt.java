import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class edt
  extends ClickableSpan
{
  public edt(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((GrayTipsItemBuilder.t(this.a) instanceof Activity))
    {
      ChatActivityUtils.a(GrayTipsItemBuilder.p(this.a), (Activity)GrayTipsItemBuilder.u(this.a), GrayTipsItemBuilder.D(this.a).a, true, true, null);
      ReportController.b(GrayTipsItemBuilder.q(this.a), "CliOper", "", "", "Multi_call", "Clk_discuss_tips", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     edt
 * JD-Core Version:    0.7.0.1
 */