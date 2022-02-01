import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class vxm
  implements vxd
{
  public vxm(QCircleLightInteractPushWidget paramQCircleLightInteractPushWidget) {}
  
  public void a(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    vrr localvrr;
    vrt localvrt;
    if (paramBoolean)
    {
      vrc.a(87, 4, this.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, this.a.d());
      localvrr = vrr.a();
      localvrt = new vrt().a("followbutton");
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (String str = "follow";; str = "unfollow")
    {
      localvrr.a(localvrt.b(str).a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(this.a.a()).a(this.a.jdField_a_of_type_Int).c(paramStUser.id.get()));
      return;
      vrc.a(87, 5, this.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, this.a.d());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxm
 * JD-Core Version:    0.7.0.1
 */