import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.a;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

public class phw
  extends phl
  implements View.OnClickListener, QCircleFollowView.a
{
  private QCircleAvatarView e;
  private QCircleFollowView f;
  private AppInterface mApp;
  private ImageView mr;
  private TextView wQ;
  private TextView wR;
  private TextView wS;
  
  private void bld()
  {
    if ((this.mData instanceof FeedCloudMeta.StFeed))
    {
      if (((FeedCloudMeta.StFeed)this.mData).isRecomFd.get()) {
        oux.qm(((FeedCloudMeta.StFeed)this.mData).recomForward.poster.id.get());
      }
    }
    else {
      return;
    }
    oux.qm(((FeedCloudMeta.StFeed)this.mData).poster.id.get());
  }
  
  private void doShare()
  {
    boolean bool2 = true;
    ovz localovz;
    Object localObject;
    if ((this.a != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      localovz = new ovz();
      localovz.type = 0;
      localovz.feed = ((FeedCloudMeta.StFeed)this.mData);
      if (ovd.a(localovz.feed)) {
        break label197;
      }
      bool1 = true;
      localovz.ayK = bool1;
      localovz.ayJ = ovd.a(localovz.feed);
      localovz.ayL = false;
      if (localovz.feed != null)
      {
        localObject = localovz.feed.opMask2.get();
        if ((localObject != null) && (((List)localObject).contains(Integer.valueOf(3)))) {
          if (ovd.a((FeedCloudMeta.StUser)localovz.feed.poster.get())) {
            break label202;
          }
        }
      }
    }
    label197:
    label202:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localovz.ayL = bool1;
      localObject = new ReportExtraTypeInfo();
      ((ReportExtraTypeInfo)localObject).pageType = this.mExtraTypeInfo.pageType;
      ((ReportExtraTypeInfo)localObject).sourceType = this.mExtraTypeInfo.sourceType;
      ((ReportExtraTypeInfo)localObject).mDataPosition = this.mPos;
      localovz.a = ((ExtraTypeInfo)localObject);
      this.a.ae(localovz);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void f(FeedCloudMeta.StUser paramStUser)
  {
    this.mr.setVisibility(0);
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mApp = ((BaseActivity)paramViewStub.getContext()).app;
      this.mContainer = paramViewStub.inflate();
      this.e = ((QCircleAvatarView)this.mContainer.findViewById(2131374515));
      this.wQ = ((TextView)this.mContainer.findViewById(2131374524));
      this.wR = ((TextView)this.mContainer.findViewById(2131374532));
      this.wS = ((TextView)this.mContainer.findViewById(2131374523));
      this.mr = ((ImageView)this.mContainer.findViewById(2131374529));
      this.f = ((QCircleFollowView)this.mContainer.findViewById(2131374518));
      this.e.setOnClickListener(this);
      this.mr.setOnClickListener(this);
      this.e.setOnClickListener(this);
      this.f.setFollowedDismiss(true);
      this.f.setFollowStateChangeListener(this);
      this.f.setItemReportListener(new phx(this));
      this.wQ.setOnClickListener(this);
    }
  }
  
  public void a(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    this.mr.setVisibility(0);
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    FeedCloudMeta.StFeed localStFeed;
    Object localObject;
    if ((this.mData != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      this.b.mDataPosition = this.mPos;
      this.b.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.b.mPlayScene = 1;
      localStFeed = (FeedCloudMeta.StFeed)this.mData;
      this.e.getLayoutParams().width = ankt.dip2px(34.0F);
      this.e.getLayoutParams().height = ankt.dip2px(34.0F);
      if (localStFeed.isRecomFd.get())
      {
        this.e.setUser(this.mApp, localStFeed.recomForward.poster);
        this.wQ.setText(localStFeed.recomForward.poster.nick.get());
        this.wR.setText(ovd.aC(localStFeed.recomForward.createTime.get() * 1000L));
        localObject = localStFeed.poiInfo.defaultName.get();
        paramObject = localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramObject = localStFeed.poiInfo.address.get();
        }
        this.wS.setText(paramObject);
        this.f.setUserData((FeedCloudMeta.StUser)localStFeed.recomForward.poster.get());
        f(localStFeed.recomForward.poster);
      }
    }
    else
    {
      return;
    }
    if ("Q_CIRCLE_LOCAL_ID".equals(localStFeed.id.get()))
    {
      this.e.setAvatarUrl(localStFeed.poster.icon.iconUrl.get());
      this.wR.setText(ovd.aC(localStFeed.createTime.get() * 1000L));
      if ((this.mExtraTypeInfo == null) || (this.mExtraTypeInfo.sourceType != 5)) {
        break label534;
      }
      long l = localStFeed.poiInfo.distance.get();
      this.wS.setText(String.format(acfp.m(2131700093), new Object[] { Float.valueOf((float)l / 1000.0F) }));
    }
    for (;;)
    {
      localObject = localStFeed.poster.nick.get();
      paramObject = localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramObject = localObject;
        if (isFakeFeed())
        {
          paramObject = aqgv.n((QQAppInterface)this.mApp, localStFeed.poster.id.get());
          QLog.d("QCircleFeedItemHeadPresenter", 1, "fake feed nick is empty ,get from native");
        }
      }
      localObject = paramObject;
      if (TextUtils.isEmpty(paramObject)) {
        localObject = localStFeed.poster.id.get();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.wQ.setText((CharSequence)localObject);
      }
      this.f.setUserData((FeedCloudMeta.StUser)localStFeed.poster.get());
      f((FeedCloudMeta.StUser)localStFeed.poster.get());
      return;
      this.e.setUser(this.mApp, localStFeed.poster);
      break;
      label534:
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
      this.wS.setText(paramObject);
    }
  }
  
  public void cj(String paramString1, String paramString2)
  {
    if (((this.mData instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.mData).poster.id.get().equals(paramString2))) {
      this.wQ.setText(paramString1);
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
      if (!HW())
      {
        doShare();
        continue;
        if (!HW()) {
          bld();
        }
        pcl.a(5, 2, this.b);
        continue;
        if (!HW()) {
          bld();
        }
        pcl.a(4, 2, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phw
 * JD-Core Version:    0.7.0.1
 */