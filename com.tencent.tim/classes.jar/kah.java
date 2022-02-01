import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kah
  implements View.OnClickListener
{
  public kah(PublicAccountBrowser paramPublicAccountBrowser, RIJRedPacketPopupView paramRIJRedPacketPopupView) {}
  
  public void onClick(View paramView)
  {
    PublicAccountBrowser.a(this.this$0, this.c, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kah
 * JD-Core Version:    0.7.0.1
 */