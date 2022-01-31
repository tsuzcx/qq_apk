import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

public class ugl
  extends uga
  implements View.OnClickListener, udx
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private TextView b;
  private TextView c;
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      if (((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).isRecomFd.get()) {
        tqs.a(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).recomForward.poster.id.get());
      }
    }
    else {
      return;
    }
    tqs.a(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).poster.id.get());
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void b()
  {
    boolean bool2 = true;
    trz localtrz;
    Object localObject;
    if ((this.jdField_a_of_type_Trw != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      localtrz = new trz();
      localtrz.jdField_a_of_type_Int = 0;
      localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      if (tra.a(localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed)) {
        break label197;
      }
      bool1 = true;
      localtrz.c = bool1;
      localtrz.b = tra.a(localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      localtrz.d = false;
      if (localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
      {
        localObject = localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.opMask2.get();
        if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(3)))) {
          if (tra.a((FeedCloudMeta.StUser)localtrz.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get())) {
            break label202;
          }
        }
      }
    }
    label197:
    label202:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localtrz.d = bool1;
      localObject = new ReportExtraTypeInfo();
      ((ReportExtraTypeInfo)localObject).pageType = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      ((ReportExtraTypeInfo)localObject).sourceType = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType;
      ((ReportExtraTypeInfo)localObject).mDataPosition = this.jdField_a_of_type_Int;
      localtrz.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)localObject);
      this.jdField_a_of_type_Trw.a(localtrz);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((BaseActivity)paramViewStub.getContext()).app;
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373163));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373172));
      this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373180));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373171));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373177));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373166));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new ugm(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    FeedCloudMeta.StFeed localStFeed;
    Object localObject;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getLayoutParams().width = azkz.a(34.0F);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getLayoutParams().height = azkz.a(34.0F);
      if (localStFeed.isRecomFd.get())
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.recomForward.poster);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStFeed.recomForward.poster.nick.get());
        this.b.setText(tra.a(localStFeed.recomForward.createTime.get() * 1000L));
        localObject = localStFeed.poiInfo.defaultName.get();
        paramObject = localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramObject = localStFeed.poiInfo.address.get();
        }
        this.c.setText(paramObject);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localStFeed.recomForward.poster.get());
        a(localStFeed.recomForward.poster);
      }
    }
    else
    {
      return;
    }
    if ("Q_CIRCLE_LOCAL_ID".equals(localStFeed.id.get()))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatarUrl(localStFeed.poster.icon.iconUrl.get());
      this.b.setText(tra.a(localStFeed.createTime.get() * 1000L));
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType != 5)) {
        break label532;
      }
      long l = localStFeed.poiInfo.distance.get();
      this.c.setText(String.format(alud.a(2131698303), new Object[] { Float.valueOf((float)l / 1000.0F) }));
    }
    for (;;)
    {
      localObject = localStFeed.poster.nick.get();
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramObject = localObject;
        if (a())
        {
          paramObject = bdgc.h((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.poster.id.get());
          QLog.d("QCircleFeedItemHeadPresenter", 1, "fake feed nick is empty ,get from native");
        }
      }
      localObject = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject = localStFeed.poster.id.get();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localStFeed.poster.get());
      a((FeedCloudMeta.StUser)localStFeed.poster.get());
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.poster);
      break;
      label532:
      localObject = ((FeedCloudMeta.StRecomInfo)localStFeed.recomInfo.get()).recomReason.get();
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramObject = localStFeed.poiInfo.name.get();
      }
      localObject = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject = localStFeed.poiInfo.defaultName.get();
      }
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramObject = localStFeed.poiInfo.address.get();
      }
      this.c.setText(paramObject);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).poster.id.get().equals(paramString2))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
  }
  
  public void a(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131373177: 
      do
      {
        return;
      } while (c());
      b();
      return;
    case 2131373172: 
      if (!c()) {
        a();
      }
      tzs.a(5, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      return;
    }
    if (!c()) {
      a();
    }
    tzs.a(4, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugl
 * JD-Core Version:    0.7.0.1
 */