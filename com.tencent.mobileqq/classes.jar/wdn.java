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
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
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

public class wdn
  extends wcw
  implements View.OnClickListener, wak
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
  private QCircleFollowView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView;
  private QCircleFeedItemPicPresenter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  private SpannableString a(long paramLong)
  {
    String str = uzg.b(paramLong);
    SpannableString localSpannableString = new SpannableString(str + " " + uzg.c(paramLong));
    localSpannableString.setSpan(new AbsoluteSizeSpan(zft.b(this.jdField_a_of_type_AndroidViewView.getContext(), 4.0F)), str.length(), str.length() + 1, 34);
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
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (TextUtils.isEmpty(paramStFeed.poiInfo.city.get())) {
        break label110;
      }
      localObject1 = ((String)localObject2).replace(paramStFeed.poiInfo.city.get(), paramStFeed.poiInfo.city.get().replace("市", "·"));
    }
    label110:
    do
    {
      return localObject1;
      localObject1 = localObject2;
    } while (((String)localObject2).indexOf("市") == ((String)localObject2).length() - 1);
    return ((String)localObject2).replaceFirst("市", "·");
  }
  
  private void a()
  {
    if (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      QLog.w("QCircleFeedItemHeadPresenter", 1, "[jumpLbsPage] invalid data");
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    QCirclePolymerizationBean localQCirclePolymerizationBean = new QCirclePolymerizationBean();
    QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    localStFeedListBusiReqData.gpsInfo = localStFeed.poiInfo.gps;
    localQCirclePolymerizationBean.setFeedListBusiReqData(localStFeedListBusiReqData);
    localQCirclePolymerizationBean.setFromReportBean(a().clone().setElementIdStr("portrait"));
    localQCirclePolymerizationBean.setPolymerizationType(16);
    localQCirclePolymerizationBean.setExt1From(1);
    localQCirclePolymerizationBean.setPoiInfo(localStFeed.poiInfo);
    uyx.a(this.jdField_a_of_type_AndroidViewView.getContext(), localQCirclePolymerizationBean);
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void a(String paramString)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUin(paramString);
    localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("portrait"));
    uyx.b(this.jdField_a_of_type_AndroidViewView.getContext(), localQCircleInitBean);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      if (((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).isRecomFd.get()) {
        a(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).recomForward.poster.id.get());
      }
    }
    else {
      return;
    }
    a(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).poster.id.get());
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_a_of_type_AndroidViewView.getContext().getResources().getColor(2131167247));
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLImageView.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(uzg.a(paramInt), localURLDrawableOptions));
    }
  }
  
  protected String a()
  {
    return "QCircleFeedItemHeadPresenter";
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = true;
    vbd localvbd;
    Object localObject1;
    label135:
    Object localObject2;
    if ((this.jdField_a_of_type_Var != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      localvbd = new vbd();
      localvbd.jdField_a_of_type_Int = 0;
      localvbd.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      if (uzg.a(localvbd.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed)) {
        break label393;
      }
      bool1 = true;
      localvbd.jdField_b_of_type_Boolean = bool1;
      localvbd.c = false;
      localvbd.jdField_a_of_type_Boolean = uzg.a(localvbd.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
      localObject1 = uzg.a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
      if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 9) || (localObject1 == null) || (!uzg.a(((QCircleInitBean)localObject1).getUser().id.get()))) {
        break label398;
      }
      bool1 = true;
      localvbd.g = bool1;
      localvbd.d = false;
      localObject1 = localvbd.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
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
        localvbd.d = bool1;
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
        if ((uzg.a((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get())) || (!((List)localObject2).contains(Integer.valueOf(1)))) {
          continue;
        }
        bool1 = true;
        localvbd.f = bool1;
        if ((uzg.a((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)localObject1).poster.get())) || (!((List)localObject2).contains(Integer.valueOf(2)))) {
          continue;
        }
        bool1 = bool2;
        localvbd.e = bool1;
        localvbd.h = ((List)localObject2).contains(Integer.valueOf(10));
        localvbd.jdField_b_of_type_Int = paramInt;
      }
      localObject1 = new ReportExtraTypeInfo();
      ((ReportExtraTypeInfo)localObject1).pageType = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType;
      ((ReportExtraTypeInfo)localObject1).sourceType = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType;
      ((ReportExtraTypeInfo)localObject1).mDataPosition = this.jdField_a_of_type_Int;
      localvbd.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)localObject1);
      this.jdField_a_of_type_Var.a(localvbd);
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
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373926));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373937));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369124));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373947));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373934));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373935));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373944));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373929));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373931);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131373932).setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowedDismiss(true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemReportListener(new wdo(this));
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
        break label390;
      }
      paramObject = localStFeed.recomForward.poster;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.recomForward.poster);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localStFeed.recomForward.poster.nick.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(a(localStFeed.recomForward.createTime.get() * 1000L));
      localObject = a(localStFeed);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label356;
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
        if (uzg.c(paramObject))
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          paramObject = localStFeed.opMask2.get();
          if ((paramObject == null) || (!paramObject.contains(Integer.valueOf(9)))) {
            break label840;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          if ((this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8) || (this.c.getVisibility() != 8) || (this.d.getVisibility() != 8)) {
            break label851;
          }
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          return;
          label356:
          this.d.setVisibility(0);
          this.d.setText((CharSequence)localObject);
          vtn.a(92, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
          continue;
          label390:
          FeedCloudMeta.StUser localStUser = localStFeed.poster;
          if ("Q_CIRCLE_LOCAL_ID".equals(localStFeed.id.get()))
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatarUrl(localStFeed.poster.icon.iconUrl.get());
            label435:
            this.jdField_b_of_type_AndroidWidgetTextView.setText(a(localStFeed.createTime.get() * 1000L));
            if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType != 5)) {
              break label700;
            }
            long l = localStFeed.poiInfo.distance.get();
            this.c.setVisibility(0);
            this.c.setText(String.format(anzj.a(2131697215), new Object[] { Float.valueOf((float)l / 1000.0F) }));
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
                paramObject = bhlg.h((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, localStFeed.poster.id.get());
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
            break label435;
            label700:
            paramObject = ((FeedCloudMeta.StRecomInfo)localStFeed.recomInfo.get()).recomReason.get();
            if (TextUtils.isEmpty(paramObject)) {
              this.c.setVisibility(8);
            }
            for (;;)
            {
              paramObject = a(localStFeed);
              if (!TextUtils.isEmpty(paramObject)) {
                break label779;
              }
              this.d.setVisibility(8);
              break;
              this.c.setVisibility(0);
              this.c.setText(paramObject);
            }
            label779:
            this.d.setVisibility(0);
            this.d.setText(paramObject);
            vtn.a(92, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
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
          continue;
          label840:
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        label851:
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
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
        vtn.a(5, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        continue;
        b();
        vtn.a(4, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        continue;
        if (a() != null)
        {
          a().a();
          vtn.a(94, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
          continue;
          a();
          vtn.a(93, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdn
 * JD-Core Version:    0.7.0.1
 */