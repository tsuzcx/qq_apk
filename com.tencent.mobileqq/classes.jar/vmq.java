import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vmq
  extends vmk
{
  protected LinearLayout a;
  protected RelativeLayout a;
  protected ImageView b;
  protected QCircleAsyncTextView b;
  protected QCircleAvatarView b;
  protected FeedCloudMeta.StNotice b;
  protected ImageView c;
  protected QCircleAvatarView c;
  protected ImageView d;
  protected QCircleAvatarView d;
  
  public vmq(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(FeedCloudMeta.StNotice paramStNotice)
  {
    int i = 3;
    if ((paramStNotice == null) || (TextUtils.isEmpty(paramStNotice.subMessage.get()))) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    do
    {
      return;
      this.jdField_b_of_type_FeedcloudFeedCloudMeta$StNotice = paramStNotice;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStNotice.subMessage.get());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(8);
      paramStNotice = paramStNotice.vecUser.get();
    } while ((paramStNotice == null) || (paramStNotice.size() <= 0));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramStNotice.size() > 3) {
      switch (i)
      {
      default: 
        return;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, (FeedCloudMeta.StUser)paramStNotice.get(0));
      return;
      i = paramStNotice.size();
      break;
      this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
      this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, (FeedCloudMeta.StUser)paramStNotice.get(2));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setVisibility(0);
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, (FeedCloudMeta.StUser)paramStNotice.get(1));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected void a(uxk paramuxk, boolean paramBoolean)
  {
    super.a(paramuxk, paramBoolean);
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData;
    if (this.jdField_a_of_type_Int == 13) {
      localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    }
    try
    {
      localStLikeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.like.busiData.get().toByteArray());
      paramuxk.a((QQCircleFeedBase.StPolyLike)localStLikeBusiData.curPolyLikeInfo.get());
      QLog.d("QCircleLikeMessagePresenter", 1, "fullscreen url" + localStLikeBusiData.curPolyLikeInfo.fullScreenURLAND.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  protected void c(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378000));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131379919));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363104));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369038));
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369039));
    this.jdField_d_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369041));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369040));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369042));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369023));
    paramContext = new vmr(this);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramContext);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmq
 * JD-Core Version:    0.7.0.1
 */