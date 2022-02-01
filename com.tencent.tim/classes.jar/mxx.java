import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.VideoInfo.a;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mxx
  implements View.OnClickListener
{
  public mxx(VideoFeedsUGView paramVideoFeedsUGView) {}
  
  public void onClick(View paramView)
  {
    aqmj.bn("ug_prefix_ug_1get3_ug_close_time", System.currentTimeMillis());
    this.this$0.setVisibility(8);
    kfq.ma(kfq.p(this.this$0.c.XH, "101", this.this$0.akH));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mxx
 * JD-Core Version:    0.7.0.1
 */