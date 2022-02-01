import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;

public class uux
  implements ausj.a
{
  public uux(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((this.c != null) && (this.c.isShowing()) && (!this.this$0.isFinishing()))
      {
        this.c.dismiss();
        this.c.cancel();
      }
      return;
      this.this$0.aAL();
      continue;
      paramView = this.this$0.a.uin;
      Bundle localBundle = stj.b(DiscussionInfoCardActivity.a(this.this$0), 3000);
      stj.a(this.this$0, DiscussionInfoCardActivity.a(this.this$0), "", "", paramView, this.this$0.app.getCurrentAccountUin(), 22001, null, localBundle);
      aqfr.b("Grp_Dis_set", "Dis_info", "clk_report", 0, 0, new String[] { DiscussionInfoCardActivity.a(this.this$0), aqfr.a(this.this$0.app, this.this$0.a) });
      continue;
      DiscussionInfoCardActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uux
 * JD-Core Version:    0.7.0.1
 */