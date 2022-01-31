import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class dzb
  extends ClickableSpan
{
  public dzb(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((GrayTipsItemBuilder.n(this.a) instanceof Activity))
    {
      ChatActivityUtils.a(GrayTipsItemBuilder.i(this.a), (Activity)GrayTipsItemBuilder.o(this.a), GrayTipsItemBuilder.u(this.a).a, true, true, null);
      ReportController.b(GrayTipsItemBuilder.j(this.a), "CliOper", "", "", "0X8003F02", "0X8003F02", 0, 0, "", "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dzb
 * JD-Core Version:    0.7.0.1
 */