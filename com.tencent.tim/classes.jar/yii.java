import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yii
  implements View.OnClickListener
{
  yii(yih paramyih) {}
  
  public void onClick(View paramView)
  {
    anot.a(yih.a(this.b), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    yih.u(yih.a(this.b), yih.a(this.b).aTl);
    yih.a(this.b).ciA();
    String str1 = null;
    String str2 = null;
    if (yih.a(this.b).cZ == 1006) {
      str2 = yih.a(this.b).aTl;
    }
    for (;;)
    {
      ChatActivityUtils.a(yih.a(this.b), yih.a(this.b), yih.a(this.b).cZ, str1, yih.a(this.b).aTn, str2, true, yih.a(this.b).troopUin, true, true, null, "from_internal");
      anot.a(yih.a(this.b), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = yih.a(this.b).aTl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yii
 * JD-Core Version:    0.7.0.1
 */