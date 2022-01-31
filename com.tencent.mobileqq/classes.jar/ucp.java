import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemInfo;

public class ucp
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private Object jdField_a_of_type_JavaLangObject;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ucp(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373183));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373187));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373185));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373186));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new ucq(this));
    paramView.setOnClickListener(new ucr(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      if (!TextUtils.isEmpty(localStItemInfo.id.get()))
      {
        tyg.a(localStItemInfo.id.get(), 3, 1, 3, 2, this.jdField_b_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), "", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null);
        tqs.a(localStItemInfo.id.get());
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(paramString);
    localStUser.followState.set(tra.a(paramBoolean));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(localStUser);
  }
  
  private boolean a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if ((paramStItemInfo != null) && (paramStItemInfo.busiInfo.get() != null)) {
      return tra.a(paramStItemInfo.busiInfo.get(), "IsVerified").equals("1");
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QQCircleDitto.StItemInfo a()
  {
    return (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
  }
  
  void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(((BaseActivity)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getContext()).app, paramObject.id.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setIsAuth(a(paramObject));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.name.get());
      if ((paramObject.des.get() == null) || (paramObject.des.size() <= 0)) {
        break label161;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramObject.des.get().get(0));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramObject.buttonInfo.buttonValue.get() != 1) {
        break label172;
      }
    }
    label161:
    label172:
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramObject.id.get());
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucp
 * JD-Core Version:    0.7.0.1
 */