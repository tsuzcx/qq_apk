import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaiu
  implements View.OnClickListener
{
  aaiu(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if (aahb.a(this.this$0).app != null)
    {
      ((CardHandler)aahb.a(this.this$0).app.getBusinessHandler(2)).E(0, "", "not_disturb_from_conversation");
      anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaiu
 * JD-Core Version:    0.7.0.1
 */