import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nkf
  implements View.OnClickListener
{
  public nkf(FastWebActivity paramFastWebActivity, RIJRedPacketPopupView paramRIJRedPacketPopupView) {}
  
  public void onClick(View paramView)
  {
    FastWebActivity.a(this.this$0, this.c, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkf
 * JD-Core Version:    0.7.0.1
 */