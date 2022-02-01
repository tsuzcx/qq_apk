import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.3.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aafl
  implements View.OnClickListener
{
  public aafl(SpecifyRedPacketAnimMsg.3.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.a.this$0.onDestroy();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafl
 * JD-Core Version:    0.7.0.1
 */