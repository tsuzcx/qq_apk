import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sbj
  implements View.OnClickListener
{
  sbj(sbf.b paramb, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.itemView instanceof RelativeFeedItemView)) && (sbf.a(this.a.c) != null)) {
      sbf.a(this.a.c).a(this.a.itemView, this.e);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbj
 * JD-Core Version:    0.7.0.1
 */