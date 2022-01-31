import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLightInteractInfo;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.LightInteractionBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

class ttb
  extends RecyclerView.ViewHolder
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StLightInteractInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo;
  private int jdField_b_of_type_Int;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  
  public ttb(tsw paramtsw, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373212));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373213));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373220));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373218));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373219));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373214));
  }
  
  private void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo)
  {
    QQCircleFeedBase.LightInteractionBusiData localLightInteractionBusiData = new QQCircleFeedBase.LightInteractionBusiData();
    try
    {
      localLightInteractionBusiData.mergeFrom(paramStLightInteractInfo.busiData.get().toByteArray());
      tql.a(localLightInteractionBusiData.polyInfo.polyIconUrl.get(), this.jdField_b_of_type_ComTencentImageURLImageView);
      tql.a(localLightInteractionBusiData.polyInfo.polyUnderPicUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStLightInteractInfo)
    {
      for (;;)
      {
        paramStLightInteractInfo.printStackTrace();
      }
    }
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(paramStUser);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new ttc(this));
  }
  
  private void b(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_Tsw.a, paramStUser);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
    if (paramStUser.id.get().equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843653);
    }
    for (;;)
    {
      paramStUser = new ttd(this, paramStUser);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(paramStUser);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramStUser);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(FeedCloudMeta.StLightInteractInfo paramStLightInteractInfo, FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StLightInteractInfo = paramStLightInteractInfo;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    b(paramStLightInteractInfo.user);
    a(paramStLightInteractInfo);
    a(paramStLightInteractInfo.user);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttb
 * JD-Core Version:    0.7.0.1
 */