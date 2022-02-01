import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemInfo;

public class waz
  extends vaf
  implements View.OnClickListener
{
  public static final int d = bdep.a(220.0F);
  public static final int e = bdep.a(288.0F);
  public static final int f = bdep.a(165.0F);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public waz(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131374045));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131374041));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374050));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374047));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131374049));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131374043));
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = (RoundCorneredRelativeLayout)paramView.findViewById(2131374046);
    if (localRoundCorneredRelativeLayout != null)
    {
      int i = bhtq.a(10.0F);
      localRoundCorneredRelativeLayout.setRadius(i, i, i, i);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new wba(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wbb(this));
    paramView.setOnClickListener(new wbc(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      if (!TextUtils.isEmpty(localStItemInfo.id.get()))
      {
        vtn.a(localStItemInfo.id.get(), 3, 1, 3, 2, this.jdField_b_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null, this.c, -1);
        QCircleInitBean localQCircleInitBean = new QCircleInitBean();
        localQCircleInitBean.setUin(localStItemInfo.id.get());
        localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("card"));
        uyx.b(paramContext, localQCircleInitBean);
        vud.a().a(new vuf().a("card").b("click").a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(this.jdField_b_of_type_Int).c(localStItemInfo.id.get()));
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
    localStUser.id.set(paramString);
    localStUser.followState.set(uzg.a(paramBoolean));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(localStUser);
  }
  
  private boolean a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if ((paramStItemInfo != null) && (paramStItemInfo.busiInfo.get() != null)) {
      return uzg.a(paramStItemInfo.busiInfo.get(), "IsVerified").equals("1");
    }
    return false;
  }
  
  public void a()
  {
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.opMask2.get();
      if ((localObject == null) || (!((List)localObject).contains(Integer.valueOf(6))) || (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get()))) {}
    }
    for (int i = 1;; i = 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (i != 0) {}
      for (i = j;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        return;
      }
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt1;
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      a(paramObject);
      QLog.d("QCircleRecommendWidget", 4, "style:" + paramInt2);
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      a();
      return;
      if ((paramObject.images.get() != null) && (paramObject.images.get().size() > 0) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
      {
        a(((FeedCloudMeta.StImage)paramObject.images.get().get(0)).picUrl.get(), 2130844043, this.jdField_a_of_type_ComTencentImageURLImageView);
        continue;
        if ((paramObject.images.get() != null) && (paramObject.images.get().size() > 0) && (this.jdField_a_of_type_ComTencentImageURLImageView != null)) {
          a(((FeedCloudMeta.StImage)paramObject.images.get().get(0)).picUrl.get(), 2130844041, this.jdField_a_of_type_ComTencentImageURLImageView);
        }
      }
    }
  }
  
  public void a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(((BaseActivity)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getContext()).app, paramStItemInfo.id.get());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setIsAuth(a(paramStItemInfo));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStItemInfo.name.get());
    if ((paramStItemInfo.des.get() != null) && (paramStItemInfo.des.size() > 0))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramStItemInfo.des.get().get(0));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramStItemInfo.buttonInfo.buttonValue.get() != 1) {
        break label144;
      }
    }
    label144:
    for (boolean bool = true;; bool = false)
    {
      a(bool, paramStItemInfo.id.get());
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(paramView.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waz
 * JD-Core Version:    0.7.0.1
 */