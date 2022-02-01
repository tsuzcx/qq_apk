import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xzh
  implements View.OnClickListener
{
  xzh(xys paramxys) {}
  
  public void onClick(View paramView)
  {
    if (xys.a(this.this$0).getVisibility() == 0) {
      ThreadManager.post(new FriendChatPie.6.1(this), 5, null, false);
    }
    wja.bcO = true;
    anot.a(this.this$0.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    wmj.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, true, null, this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzh
 * JD-Core Version:    0.7.0.1
 */