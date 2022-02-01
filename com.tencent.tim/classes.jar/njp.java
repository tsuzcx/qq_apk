import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class njp
  implements View.OnClickListener
{
  njp(njo paramnjo) {}
  
  public void onClick(View paramView)
  {
    RIJRedPacketManager.a().a(this.a.this$0, 2, 0, 0);
    FastWebActivity.a(this.a.this$0).b(2, FastWebActivity.a(this.a.this$0), FastWebActivity.a(this.a.this$0).innerUniqueID);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njp
 * JD-Core Version:    0.7.0.1
 */