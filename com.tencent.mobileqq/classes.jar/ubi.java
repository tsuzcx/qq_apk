import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.qqcircle.requests.QCircleRecomForwardRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StUser;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;

public class ubi
  extends tzr
  implements tzy
{
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private ImageButton b;
  
  public ubi(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected int a()
  {
    return 2131560571;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)
    {
      wsv.c("QCircleBaseInputPopupWindow", "QCircleForwardRequest feed == null, return");
      return;
    }
    Object localObject = new FeedCloudMeta.StRecomForward();
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    localStUser.id.set(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStUser.nick.set(BaseApplicationImpl.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    ((FeedCloudMeta.StRecomForward)localObject).poster.set(localStUser);
    FeedCloudMeta.StComment localStComment = new FeedCloudMeta.StComment();
    if (!TextUtils.isEmpty(a()))
    {
      ((FeedCloudMeta.StRecomForward)localObject).title.set(a());
      if ((this.b != null) && (this.b.isSelected()))
      {
        localStComment.id.set("fakeId_" + System.currentTimeMillis());
        localStComment.content.set(a());
        localStComment.createTime.set((int)(System.currentTimeMillis() / 1000L));
        localStComment.postUser.set(localStUser);
      }
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.recomForward.set((MessageMicro)localObject);
    localObject = new QCircleRecomForwardRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, localStComment);
    VSNetworkHelper.a().a((VSBaseRequest)localObject, new ubj(this));
    a("");
    b(null);
    dismiss();
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131363651));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378964));
    this.b = ((ImageButton)paramView.findViewById(2131363729));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.b.setSelected(true);
    a(this);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363651: 
      dismiss();
      return;
    }
    if (this.b.isSelected())
    {
      this.b.setSelected(false);
      return;
    }
    this.b.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubi
 * JD-Core Version:    0.7.0.1
 */