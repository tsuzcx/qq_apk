import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;

class pid
  implements View.OnClickListener
{
  pid(pib.a.a parama) {}
  
  public void onClick(View paramView)
  {
    this.a.b.b.vC(16);
    oux.ce(this.a.tagInfo.tagId.get(), this.a.tagInfo.tagName.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pid
 * JD-Core Version:    0.7.0.1
 */