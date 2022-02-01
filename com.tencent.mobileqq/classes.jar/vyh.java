import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
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

public class vyh
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, zxl<QCircleReportBean>
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private Object jdField_a_of_type_JavaLangObject;
  private vyg jdField_a_of_type_Vyg;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public vyh(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373910));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131373906));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373915));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373912));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131373914));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373908));
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = (RoundCorneredRelativeLayout)paramView.findViewById(2131373911);
    if (localRoundCorneredRelativeLayout != null)
    {
      int i = bgtn.a(10.0F);
      localRoundCorneredRelativeLayout.setRadius(i, i, i, i);
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedShowToast(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new vyi(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new vyj(this));
    paramView.setOnClickListener(new vyk(this));
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
        vrc.a(localStItemInfo.id.get(), 3, 1, 3, 2, this.jdField_b_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), this.jdField_a_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, null, this.c, -1);
        uxo.a(localStItemInfo.id.get(), a().clone().setElementIdStr("card"));
        vrr.a().a(new vrt().a("card").b("click").a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(this.jdField_b_of_type_Int).c(localStItemInfo.id.get()));
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(false);
    localStUser.id.set(paramString);
    localStUser.followState.set(uxx.a(paramBoolean));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData(localStUser);
  }
  
  private boolean a(QQCircleDitto.StItemInfo paramStItemInfo)
  {
    if ((paramStItemInfo != null) && (paramStItemInfo.busiInfo.get() != null)) {
      return uxx.a(paramStItemInfo.busiInfo.get(), "IsVerified").equals("1");
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QCircleReportBean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  }
  
  public QQCircleDitto.StItemInfo a()
  {
    return (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
  }
  
  void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = paramQCircleReportBean;
  }
  
  void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt1;
    boolean bool;
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(((BaseActivity)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getContext()).app, paramObject.id.get());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setIsAuth(a(paramObject));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.name.get());
      if ((paramObject.des.get() != null) && (paramObject.des.size() > 0))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)paramObject.des.get().get(0));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        if (paramObject.buttonInfo.buttonValue.get() != 1) {
          break label307;
        }
        bool = true;
        label155:
        a(bool, paramObject.id.get());
        QLog.d("QCircleRecommendWidget", 4, "style:" + paramInt2);
      }
    }
    else
    {
      switch (paramInt2)
      {
      default: 
        label220:
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
        {
          paramObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.opMask2.get();
          if ((paramObject == null) || (!paramObject.contains(Integer.valueOf(6))) || (uxx.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get()))) {
            break;
          }
        }
        break;
      }
    }
    for (paramInt1 = j;; paramInt1 = 0)
    {
      paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramInt1 != 0) {}
      for (paramInt1 = i;; paramInt1 = 8)
      {
        paramObject.setVisibility(paramInt1);
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
        break;
        label307:
        bool = false;
        break label155;
        if ((paramObject.images.get() == null) || (paramObject.images.get().size() <= 0) || (this.jdField_a_of_type_ComTencentImageURLImageView == null)) {
          break label220;
        }
        uxh.a(((FeedCloudMeta.StImage)paramObject.images.get().get(0)).picUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView, null);
        break label220;
        if ((paramObject.images.get() == null) || (paramObject.images.get().size() <= 0) || (this.jdField_a_of_type_ComTencentImageURLImageView == null)) {
          break label220;
        }
        uxh.a(((FeedCloudMeta.StImage)paramObject.images.get().get(0)).picUrl.get(), this.jdField_a_of_type_ComTencentImageURLImageView, null);
        break label220;
      }
    }
  }
  
  public void a(vyg paramvyg)
  {
    this.jdField_a_of_type_Vyg = paramvyg;
  }
  
  void b(int paramInt)
  {
    this.c = paramInt;
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
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyh
 * JD-Core Version:    0.7.0.1
 */