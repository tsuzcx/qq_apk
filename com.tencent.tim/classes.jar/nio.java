import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nio
  implements View.OnClickListener
{
  public nio(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    if (RIJRedPacketManager.a().Dq()) {
      RIJRedPacketManager.a().a(this.this$0.a(), 1, 1, 0);
    }
    for (;;)
    {
      ReadinjoyTabFrame.a(this.this$0).b(1, false, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReadinjoyTabFrame.a(this.this$0).Q(1, 1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nio
 * JD-Core Version:    0.7.0.1
 */