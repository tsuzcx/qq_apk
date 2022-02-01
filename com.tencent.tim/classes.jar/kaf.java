import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kaf
  implements View.OnClickListener
{
  kaf(kae paramkae) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.this$0, 5, PublicAccountBrowser.a(this.a.this$0), this.a.Vw, new kag(this), false, null);
    kxm.b localb1 = new kxm.b();
    kxm.b localb2 = localb1.a("rowkey", this.a.Vw).a("content_type", Integer.valueOf(2));
    if (aqiw.isWifiConnected(BaseApplicationImpl.getContext())) {}
    for (int i = 2;; i = 1)
    {
      localb2.a("network_type", Integer.valueOf(i)).a("os", Integer.valueOf(1)).a("imei", kxm.iT());
      kbp.bp("0X800ABBA", localb1.build());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kaf
 * JD-Core Version:    0.7.0.1
 */