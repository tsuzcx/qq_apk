import com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class waw
  implements wak
{
  public waw(QCircleLightInteractPushWidget paramQCircleLightInteractPushWidget) {}
  
  public void a(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    vud localvud;
    vuf localvuf;
    if (paramBoolean)
    {
      vtn.a(87, 4, this.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, this.a.d());
      localvud = vud.a();
      localvuf = new vuf().a("followbutton");
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (String str = "follow";; str = "unfollow")
    {
      localvud.a(localvuf.b(str).a(this.a.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(this.a.a()).a(this.a.jdField_a_of_type_Int).c(paramStUser.id.get()));
      return;
      vtn.a(87, 5, this.a.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, this.a.d());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waw
 * JD-Core Version:    0.7.0.1
 */