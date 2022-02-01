import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import qqcircle.QQCircleBase.StUserBusiData;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class vzx
  extends vzg
  implements View.OnClickListener, vxd
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private QCircleFeedItemPicPresenter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  private SpannableString a(long paramLong)
  {
    String str = uxx.b(paramLong);
    SpannableString localSpannableString = new SpannableString(str + " " + uxx.c(paramLong));
    localSpannableString.setSpan(new AbsoluteSizeSpan(zby.b(this.jdField_a_of_type_AndroidViewView.getContext(), 4.0F)), str.length(), str.length() + 1, 34);
    return localSpannableString;
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject2 = paramStFeed.poiInfo.defaultName.get();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramStFeed.poiInfo.name.get();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramStFeed.poiInfo.address.get();
    }
    return localObject2;
  }
  
  private void a()
  {
    if (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      QLog.w("QCircleFeedItemHeadPresenter", 1, "[jumpLbsPage] invalid data");
      return;
    }
    Object localObject = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    uxk localuxk = new uxk();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.gpsInfo = ((FeedCloudMeta.StFeed)localObject).poiInfo.gps;
    localuxk.a(localStFeedListBusiReqData);
    localuxk.a(a().clone().setElementIdStr("portrait"));
    localuxk.a(12);
    localuxk.a(((FeedCloudMeta.StFeed)localObject).poiInfo);
    localObject = localuxk.a();
    uxo.a(this.jdField_a_of_type_AndroidViewView.getContext(), (QCircleInitBean)localObject, null);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      if (((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).isRecomFd.get()) {
        uxo.a(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).recomForward.poster.id.get(), a().clone().setElementIdStr("portrait"));
      }
    }
    else {
      return;
    }
    uxo.a(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).poster.id.get(), a().clone().setElementIdStr("portrait"));
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getColor(2131167224));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(uxx.a(paramInt), localURLDrawableOptions));
    }
  }
  
  protected String a()
  {
    return "QCircleFeedItemHeadPresenter";
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    uzn localuzn;
    Object localObject1;
    label135:
    Object localObject2;
    if ((this.jdField_a_of_type_Uzb != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      localuzn = new uzn();
      localuzn.jdField_a_of_type_Int = 0;
      localuzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      if (uxx.a(localuzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed)) {
        break label393;
      }
      bool1 = true;
      localuzn.jdField_b_of_type_Boolean = bool1;
      localuzn.c = false;
      localuzn.jdField_a_of_type_Boolean = uxx.a(localuzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      localObject1 = uxx.a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 9) || (localObject1 == null) || (!uxx.a(((QCircleInitBean)localObject1).getUser().id.get()))) {
        break label398;
      }
      bool1 = true;
      localuzn.g = bool1;
      localuzn.d = false;
      localObject1 = localuzn.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
      if (localObject1 != null) {
        localObject2 = new QQCircleFeedBase.StFeedBusiReqData();
      }
    }
    for (;;)
    {
      try
      {
        ((QQCircleFeedBase.StFeedBusiReqData)localObject2).mergeFrom(((FeedCloudMeta.StFeed)localObject1).busiData.get().toByteArray());
        localObject2 = ((QQCircleFeedBase.StFeedBusiReqData)localObject2).uninterest_buttons.get();
        if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
          continue;
        }
        bool1 = true;
        localuzn.d = bool1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        label393:
        label398:
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
      }
      localObject2 = ((FeedCloudMeta.StFeed)localObject1).opMask2.get();
      if (localObject2 != null)
      {
        if ((uxx.a((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get())) || (!((List)localObject2).contains(Integer.valueOf(1)))) {
          continue;
        }
        bool1 = true;
        localuzn.f = bool1;
        if ((uxx.a((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get())) || (!((List)localObject2).contains(Integer.valueOf(2)))) {
          continue;
        }
        bool1 = bool2;
        localuzn.e = bool1;
        localuzn.h = ((List)localObject2).contains(Integer.valueOf(10));
        localuzn.jdField_b_of_type_Int = paramInt;
      }
      localObject1 = new ReportExtraTypeInfo();
      ((ReportExtraTypeInfo)localObject1).pageType = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      ((ReportExtraTypeInfo)localObject1).sourceType = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType;
      ((ReportExtraTypeInfo)localObject1).mDataPosition = this.jdField_a_of_type_Int;
      localuzn.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)localObject1);
      this.jdField_a_of_type_Uzb.a(localuzn);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label135;
      bool1 = false;
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((BaseActivity)paramViewStub.getContext()).app;
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373799));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373809));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369030));
      this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373817));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373807));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373808));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373814));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373802));
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373805).setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new vzy(this));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  public void a(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter = paramQCircleFeedItemPicPresenter;
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
      if (!localStFeed.isRecomFd.get()) {
        break label355;
      }
      paramObject = localStFeed.recomForward.poster;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.recomForward.poster);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStFeed.recomForward.poster.nick.get());
      this.b.setText(a(localStFeed.recomForward.createTime.get() * 1000L));
      this.c.setText("");
      localObject = a(localStFeed);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label321;
      }
      this.d.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localStFeed.recomForward.poster.get(), localStFeed.id.get());
      a(localStFeed.recomForward.poster);
      if (paramObject != null) {
        localObject = new QQCircleBase.StUserBusiData();
      }
      try
      {
        ((QQCircleBase.StUserBusiData)localObject).mergeFrom(paramObject.busiData.get().toByteArray());
        b(((QQCircleBase.StUserBusiData)localObject).talentLevel.get());
        if (uxx.c(paramObject))
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          paramObject = localStFeed.opMask2.get();
          if ((paramObject == null) || (!paramObject.contains(Integer.valueOf(9)))) {
            break label770;
          }
          this.b.setVisibility(8);
          return;
          label321:
          this.d.setVisibility(0);
          this.d.setText((CharSequence)localObject);
          vrc.a(92, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
          continue;
          label355:
          FeedCloudMeta.StUser localStUser = localStFeed.poster;
          if ("Q_CIRCLE_LOCAL_ID".equals(localStFeed.id.get()))
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatarUrl(localStFeed.poster.icon.iconUrl.get());
            label400:
            this.b.setText(a(localStFeed.createTime.get() * 1000L));
            if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType != 5)) {
              break label657;
            }
            long l = localStFeed.poiInfo.distance.get();
            this.c.setText(String.format(anni.a(2131697154), new Object[] { Float.valueOf((float)l / 1000.0F) }));
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
                paramObject = bglf.h((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.poster.id.get());
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
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localStFeed.poster.get(), localStFeed.id.get());
            a((FeedCloudMeta.StUser)localStFeed.poster.get());
            paramObject = localStUser;
            break;
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.poster);
            break label400;
            label657:
            paramObject = ((FeedCloudMeta.StRecomInfo)localStFeed.recomInfo.get()).recomReason.get();
            this.c.setText(paramObject);
            paramObject = a(localStFeed);
            if (TextUtils.isEmpty(paramObject))
            {
              this.d.setVisibility(8);
            }
            else
            {
              this.d.setVisibility(0);
              this.d.setText(paramObject);
              vrc.a(92, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.d("QCircleFeedItemHeadPresenter", 1, "parse busiData error!", localInvalidProtocolBufferMicroException);
          continue;
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
        label770:
        this.b.setVisibility(0);
      }
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null)
      {
        a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.c());
      }
      else
      {
        a(0);
        continue;
        b();
        vrc.a(5, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        continue;
        b();
        vrc.a(4, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        continue;
        if (a() != null)
        {
          a().a();
          continue;
          a();
          vrc.a(93, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzx
 * JD-Core Version:    0.7.0.1
 */