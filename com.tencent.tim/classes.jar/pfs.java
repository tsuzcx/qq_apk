import com.tencent.biz.qqcircle.events.QCircleTopTagEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleWrite.DoFollowTagRsp;

public class pfs
  implements rxc.a<QQCircleWrite.DoFollowTagRsp>
{
  public pfs(QCircleFollowTagListItemView paramQCircleFollowTagListItemView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleWrite.DoFollowTagRsp paramDoFollowTagRsp)
  {
    int j = 3;
    if ((paramBoolean) && (paramLong == 0L)) {
      return;
    }
    if (paramLong == 110002L)
    {
      QQToast.a(this.a.getContext(), 2131700116, 0).show();
      if (QCircleFollowTagListItemView.a(this.a) != null)
      {
        paramString = ((FeedCloudMeta.StTagInfo)QCircleFollowTagListItemView.a(this.a).get()).followState;
        if (!this.azP) {
          break label203;
        }
        i = 3;
        label77:
        paramString.set(i);
        paramString = ((FeedCloudMeta.StTagInfo)QCircleFollowTagListItemView.a(this.a).get()).isTop;
        if (!this.azP) {
          break label209;
        }
        i = 0;
        label112:
        paramString.set(i);
      }
      paramString = rwv.a();
      paramDoFollowTagRsp = QCircleFollowTagListItemView.a(this.a);
      if (!this.azP) {
        break label215;
      }
    }
    label203:
    label209:
    label215:
    for (int i = j;; i = 2)
    {
      paramString.a(new QCircleTopTagEvent(paramDoFollowTagRsp, i));
      return;
      paramString = this.a.getContext();
      if (this.azP) {}
      for (i = 2131700178;; i = 2131700068)
      {
        QQToast.a(paramString, i, 0).show();
        break;
      }
      i = 2;
      break label77;
      i = 1;
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfs
 * JD-Core Version:    0.7.0.1
 */