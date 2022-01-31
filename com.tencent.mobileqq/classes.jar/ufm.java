import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

class ufm
  implements View.OnClickListener
{
  ufm(ufk paramufk) {}
  
  public void onClick(View paramView)
  {
    paramView = ufk.a(this.a);
    if ((paramView != null) && ((ufk.a(this.a) instanceof QQCircleDitto.StItemInfo)))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)ufk.a(this.a);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(tzy.a("ext3", String.valueOf(paramView.createTime)));
      tzs.a(String.valueOf(localStItemInfo.id.get()), 65, 1, ufk.b(this.a), paramView, localArrayList);
      if (ufk.a(this.a) != null)
      {
        ufk.a(this.a).a(ufk.a(this.a));
        if (ufk.a(this.a).getItemCount() <= 0) {
          yiw.a().a(new QCircleFeedEvent(paramView.id.get(), 3));
        }
      }
      QQToast.a(ufk.a(this.a).getContext(), 2, 2131698289, 0).a();
      return;
    }
    QLog.e("QCircleRecommendWidget", 2, "report hide item error! mParentFeed or itemInfo is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufm
 * JD-Core Version:    0.7.0.1
 */