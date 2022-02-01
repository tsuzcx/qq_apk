import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kad
  implements View.OnClickListener
{
  kad(kac paramkac) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(paramView.getContext(), 2, 0, 0);
    PublicAccountBrowser.a(this.a.this$0).b(2, PublicAccountBrowser.a(this.a.this$0), this.a.Vw);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kad
 * JD-Core Version:    0.7.0.1
 */