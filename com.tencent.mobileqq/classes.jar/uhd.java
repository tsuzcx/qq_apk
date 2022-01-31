import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

public class uhd
  extends ugz
{
  private QCircleFollowView a;
  
  public uhd(int paramInt)
  {
    super(paramInt);
  }
  
  void b(Context paramContext, View paramView)
  {
    this.a = ((QCircleFollowView)paramView.findViewById(2131373166));
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (paramStNotice.operation.opUser.get() != null) {
      this.a.setUserData((FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */