import com.tencent.biz.qqcircle.events.QCircleTopTagEvent;
import com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StTagInfo;
import qqcircle.QQCircleWrite.DoFollowTagRsp;

public class udp
  implements zac<QQCircleWrite.DoFollowTagRsp>
{
  public udp(QCircleFollowTagListItemView paramQCircleFollowTagListItemView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleWrite.DoFollowTagRsp paramDoFollowTagRsp)
  {
    int j = 3;
    if ((paramBoolean) && (paramLong == 0L)) {
      return;
    }
    if (paramLong == 110002L)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagListItemView.getContext(), 2131698326, 0).a();
      if (QCircleFollowTagListItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagListItemView) != null)
      {
        paramString = ((FeedCloudMeta.StTagInfo)QCircleFollowTagListItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagListItemView).get()).followState;
        if (!this.jdField_a_of_type_Boolean) {
          break label203;
        }
        i = 3;
        label77:
        paramString.set(i);
        paramString = ((FeedCloudMeta.StTagInfo)QCircleFollowTagListItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagListItemView).get()).isTop;
        if (!this.jdField_a_of_type_Boolean) {
          break label209;
        }
        i = 0;
        label112:
        paramString.set(i);
      }
      paramString = yiw.a();
      paramDoFollowTagRsp = QCircleFollowTagListItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagListItemView);
      if (!this.jdField_a_of_type_Boolean) {
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
      paramString = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagListItemView.getContext();
      if (this.jdField_a_of_type_Boolean) {}
      for (i = 2131698387;; i = 2131698278)
      {
        QQToast.a(paramString, i, 0).a();
        break;
      }
      i = 2;
      break label77;
      i = 1;
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udp
 * JD-Core Version:    0.7.0.1
 */