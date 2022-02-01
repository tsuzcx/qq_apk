import com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleDitto.StItemContainer;

public class vxt
  implements vxd
{
  public vxt(QCirclePushRankItemView paramQCirclePushRankItemView, QQCircleDitto.StItemContainer paramStItemContainer) {}
  
  public void a(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    vrr localvrr = vrr.a();
    vrt localvrt = new vrt().a("followbutton");
    if (paramBoolean) {}
    for (String str = "follow";; str = "unfollow")
    {
      localvrr.a(localvrt.b(str).a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankItemView.a()).c(paramStUser.id.get()).d(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.containerType.get() + ""));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxt
 * JD-Core Version:    0.7.0.1
 */