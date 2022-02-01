import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

class pij
  implements View.OnClickListener
{
  pij(pii parampii) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.a != null) && (!TextUtils.isEmpty(this.b.a.operation.opUser.id.get())))
    {
      if (paramView.getId() != 2131369668) {
        break label101;
      }
      pco.h(this.b.a.operation.opUser.id.get(), 17, 8L);
    }
    for (;;)
    {
      oux.qm(this.b.a.operation.opUser.id.get());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      if (paramView.getId() == 2131380818) {
        pco.h(this.b.a.operation.opUser.id.get(), 17, 9L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pij
 * JD-Core Version:    0.7.0.1
 */