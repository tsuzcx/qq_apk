import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aowd
  implements View.OnClickListener
{
  public aowd(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((wmi.a)paramView.getTag()).actionId)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      TroopBarReplyActivity.b(this.this$0);
      continue;
      TroopBarReplyActivity.c(this.this$0);
      continue;
      TroopBarReplyActivity.d(this.this$0);
      continue;
      if (this.this$0.cPd)
      {
        aprv.d(this.this$0.cmV, this.this$0.mOpType, "Clk_music", this.this$0.mBid, "", "", "");
        aprv.l("reply_page_new", "Clk_music", this.this$0.mBid, "", "", "");
      }
      if (!this.this$0.lS(4)) {
        if ((this.this$0.b.getCurType() != 0) && (this.this$0.b.getCurType() != 3))
        {
          this.this$0.Wn(3);
        }
        else
        {
          this.this$0.Wo(4);
          continue;
          if (this.this$0.cPd)
          {
            aprv.d(this.this$0.cmV, this.this$0.mOpType, "Clk_video", this.this$0.mBid, "", "", "");
            aprv.l("reply_page_new", "Clk_video", this.this$0.mBid, "", "", "");
          }
          if (!this.this$0.lS(8)) {
            if ((this.this$0.b.getCurType() != 0) && (this.this$0.b.getCurType() != 4)) {
              this.this$0.Wn(7);
            } else {
              this.this$0.Wo(3);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aowd
 * JD-Core Version:    0.7.0.1
 */