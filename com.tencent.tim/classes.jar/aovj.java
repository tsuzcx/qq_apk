import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;

public class aovj
  extends ClickableSpan
{
  public aovj(TroopBarPublishActivity paramTroopBarPublishActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    TroopBarPublishUtils.g(this.this$0, 2002, this.this$0.dRR);
    if ((this.this$0.ZZ != null) && (this.this$0.ZZ.getVisibility() == 0)) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00899", "Grp_tribe", "", "post", "Clk_add_topic", i, 0, "", "", "", "");
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.dRU);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovj
 * JD-Core Version:    0.7.0.1
 */