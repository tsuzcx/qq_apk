import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aovk
  extends ClickableSpan
{
  public aovk(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.b != null)
    {
      if (!this.this$0.b.isShow()) {
        break label42;
      }
      this.this$0.b.hide();
    }
    for (;;)
    {
      this.this$0.Rm(true);
      return;
      label42:
      this.this$0.b.show();
      anot.a(null, "dc00899", "Grp_tribe", "", "pub_page", "clk_prefixchoose", 0, 0, this.this$0.mBid, "", "", "");
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-16777216);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aovk
 * JD-Core Version:    0.7.0.1
 */