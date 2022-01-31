import android.app.Activity;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.StrangerManageActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;

public class eea
  extends ClickableSpan
{
  public eea(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(GrayTipsItemBuilder.d(this.a), "CliOper", "", GrayTipsItemBuilder.e(this.a).a, "Manage_stranger", "Manage_str_aio_clk", 0, 0, "", "", "", "");
    StrangerManageActivity.a((Activity)GrayTipsItemBuilder.i(this.a), GrayTipsItemBuilder.f(this.a).a);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eea
 * JD-Core Version:    0.7.0.1
 */