import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.a;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kjr
  implements View.OnClickListener
{
  public kjr(ReadinjoySubscriptManagerActivity.a parama, ReadinjoySubscriptManagerActivity.b paramb) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.b.this$0, ReadinjoySubscriptManagerActivity.b.c(this.a));
    kbp.a(null, "CliOper", "", ReadinjoySubscriptManagerActivity.b.c(this.a), "0X80078A8", "0X80078A8", 0, 0, "", "", "", kxm.iQ(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjr
 * JD-Core Version:    0.7.0.1
 */