import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yjo
  implements View.OnClickListener
{
  yjo(yjm paramyjm) {}
  
  public void onClick(View paramView)
  {
    yjm.a(this.this$0).b(yjm.a(this.this$0).aTl, Integer.valueOf(4));
    yjm.a(this.this$0).ciA();
    aizp.a().l(yjm.a(this.this$0).aTl, yjm.a(this.this$0));
    aizp.a().an(yjm.a(this.this$0), yjm.a(this.this$0).aTl);
    anot.a(yjm.a(this.this$0), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, yjm.a(this.this$0).aTl, "", "", "");
    QQAppInterface localQQAppInterface = yjm.a(this.this$0);
    String str2 = yjm.a(this.this$0).aTl;
    if (yjm.a(this.this$0).cs(yjm.a(this.this$0).aTl) == 3) {}
    for (String str1 = "1";; str1 = "0")
    {
      anot.a(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjo
 * JD-Core Version:    0.7.0.1
 */