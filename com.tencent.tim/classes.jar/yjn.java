import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yjn
  implements View.OnClickListener
{
  yjn(yjm paramyjm) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (this.this$0.isShowing())
    {
      aizp.a().al(yjm.a(this.this$0), yjm.a(this.this$0).aTl);
      yjm.a(this.this$0).ciA();
      localQQAppInterface = yjm.a(this.this$0);
      str2 = yjm.a(this.this$0).aTl;
      if (yjm.a(this.this$0).cs(yjm.a(this.this$0).aTl) != 3) {
        break label121;
      }
    }
    label121:
    for (String str1 = "1";; str1 = "0")
    {
      anot.a(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjn
 * JD-Core Version:    0.7.0.1
 */