package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleForwardEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import ovd;
import ovv;
import oyg;
import oyu;
import pcp;
import pcr;
import pfy;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import rwv;
import rwx;

public class QCircleCommentBottomBar
  extends BaseWidgetView<FeedCloudMeta.StFeed>
  implements View.OnClickListener, rwx
{
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout;
  private QCirclePraiseTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private pfy jdField_a_of_type_Pfy;
  private FeedCloudMeta.StComment b;
  private FeedCloudMeta.StReply c;
  private View.OnClickListener cD;
  private LinearLayout eD;
  private ImageView lW;
  private Activity mActivity;
  private ExtraTypeInfo mExtraTypeInfo;
  private FeedCloudMeta.StFeed mFeed;
  private TextView vY;
  private TextView vZ;
  private TextView wa;
  
  public QCircleCommentBottomBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleCommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleCommentBottomBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (paramStReply != null)
    {
      if (paramStReply.postUser == null) {
        break label108;
      }
      paramStComment = "";
      if ("".length() > 10)
      {
        paramStComment = "".substring(0, 10);
        paramStComment = paramStComment + "...";
      }
    }
    do
    {
      return paramStComment;
      if ((paramStComment == null) || (paramStComment.postUser == null)) {
        break;
      }
      paramStComment = "";
    } while ("".length() <= 10);
    paramStComment = "".substring(0, 10);
    return paramStComment + "...";
    label108:
    return null;
  }
  
  private void aAz()
  {
    rwv.a().a(this);
    this.lW.setOnClickListener(this);
    this.vY.setOnClickListener(this);
  }
  
  private void biA()
  {
    this.b = null;
    this.c = null;
    qv(getContext().getString(2131700080));
  }
  
  public QCirclePolymorphicAniView b()
  {
    if ((getInteractor() instanceof ovv)) {
      return ((ovv)getInteractor()).a();
    }
    return null;
  }
  
  public oyu b()
  {
    if ((getInteractor() instanceof ovv)) {
      return ((ovv)getInteractor()).a();
    }
    return null;
  }
  
  protected void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {}
    for (;;)
    {
      return;
      this.mFeed = paramStFeed;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setAniView(b());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setFeedData(paramStFeed);
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView.setFeedData(paramStFeed);
      }
      el(paramStFeed.commentCount.get());
      if (this.eD != null)
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 2);
        }
        if (!ovd.eL(paramStFeed.poster.id.get())) {
          break label146;
        }
        this.eD.setVisibility(8);
      }
      while ((b() != null) && (b().a() != null))
      {
        b().setFeedData(this.mFeed);
        b().beM();
        return;
        label146:
        this.eD.setVisibility(0);
        setPushData(paramStFeed);
      }
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.eD = ((LinearLayout)findViewById(2131370639));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)findViewById(2131369841));
    this.vY = ((TextView)findViewById(2131380547));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)findViewById(2131369760));
    this.lW = ((ImageView)findViewById(2131369714));
    this.vZ = ((TextView)findViewById(2131369713));
    this.wa = ((TextView)findViewById(2131369761));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView = ((QCirclePraiseTextView)findViewById(2131369843));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setUnPraiseDrawable(2130844790);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setPraisedDrawable(2130844779);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setIsContentDetail(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setBackgroundDrawable(getResources().getDrawable(2130844779));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new oyg(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseTextView.setEmptyText(getResources().getString(2131700156));
    aAz();
  }
  
  public void el(int paramInt)
  {
    if (this.vZ == null) {}
    for (;;)
    {
      return;
      if (paramInt > 0) {
        this.vZ.setText(ovd.aD(paramInt));
      }
      while (this.mFeed != null)
      {
        this.mFeed.commentCount.set(paramInt);
        return;
        this.vZ.setText(getResources().getString(2131700073));
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCircleForwardEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    return localArrayList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  public int getLayoutId()
  {
    return 2131560887;
  }
  
  public boolean onBackPressed()
  {
    if (b() != null) {
      return b().onBackPress();
    }
    return false;
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
      if (b() != null)
      {
        if (pcr.a().ez(57)) {
          pcp.b(6, 2, this.mExtraTypeInfo);
        }
        b().setAniView(b());
        b().setFeedData(this.mFeed);
        b().beM();
        b().vj(6);
        continue;
        if (this.jdField_a_of_type_Pfy == null) {
          this.jdField_a_of_type_Pfy = new pfy(this.mActivity);
        }
        this.jdField_a_of_type_Pfy.setFeedData(this.mFeed);
        this.jdField_a_of_type_Pfy.show(false);
        continue;
        if (b() != null)
        {
          if (pcr.a().ez(57)) {
            pcp.b(7, 2, this.mExtraTypeInfo);
          }
          b().setAniView(b());
          b().setFeedData(this.mFeed);
          b().e(this.b, this.c);
          b().vj(7);
          biA();
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) && (this.mFeed != null) && (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).feedId.equals(this.mFeed.id.get()))) {
      switch (((QCircleCommentUpdateEvent)paramSimpleBaseEvent).eventStatus)
      {
      }
    }
    for (;;)
    {
      QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
      if ((paramSimpleBaseEvent instanceof QCirclePushUpdateEvent))
      {
        paramSimpleBaseEvent = (QCirclePushUpdateEvent)paramSimpleBaseEvent;
        if ((this.mFeed != null) && (paramSimpleBaseEvent.mTargetFeedId.equals(this.mFeed.id.get()))) {
          localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
        }
      }
      try
      {
        localStFeedBusiReqData.mergeFrom(this.mFeed.busiData.get().toByteArray());
        if (localStFeedBusiReqData.pushList != null)
        {
          int j = localStFeedBusiReqData.pushList.count.get();
          int i = j;
          if (localStFeedBusiReqData.pushList.hasClickCount.get() == 0)
          {
            i = j;
            if (paramSimpleBaseEvent.mAllPushTimes > 0) {
              i = j + 1;
            }
          }
          localStFeedBusiReqData.pushList.hasClickCount.set(paramSimpleBaseEvent.mAllPushTimes);
          localStFeedBusiReqData.pushList.count.set(i);
          vi(i);
          this.mFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramSimpleBaseEvent)
      {
        paramSimpleBaseEvent.printStackTrace();
        return;
      }
      catch (Exception paramSimpleBaseEvent)
      {
        QLog.e("QCircleCommentBottomBar", 1, "receiveEvent error" + paramSimpleBaseEvent.getMessage());
        paramSimpleBaseEvent.printStackTrace();
      }
      el(((QCircleCommentUpdateEvent)paramSimpleBaseEvent).commentTotalNum);
    }
  }
  
  public void qv(String paramString)
  {
    if (this.vY == null) {
      return;
    }
    this.vY.setText(paramString);
  }
  
  public void release()
  {
    if (b() != null) {
      b().recycle();
    }
    rwv.a().b(this);
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
    if (b() != null) {
      b().setExtraTypeInfo(paramExtraTypeInfo);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout != null) && ((paramExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)paramExtraTypeInfo);
    }
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void setPushData(FeedCloudMeta.StFeed paramStFeed)
  {
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData;
    if ((paramStFeed != null) && (paramStFeed.busiData.get() != null)) {
      localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    }
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      paramStFeed = localStFeedBusiReqData.pushList;
      if (paramStFeed != null) {
        vi(paramStFeed.count.get());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
  }
  
  public void setShareClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cD = paramOnClickListener;
  }
  
  public void setTargetCommentAndReply(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.b = paramStComment;
    this.c = paramStReply;
    paramStComment = a(paramStComment, paramStReply);
    if (!TextUtils.isEmpty(paramStComment)) {
      qv(paramStComment);
    }
  }
  
  public void vi(int paramInt)
  {
    if (this.wa == null) {
      return;
    }
    if (paramInt > 0)
    {
      this.wa.setText(ovd.aD(paramInt));
      return;
    }
    this.wa.setText(getResources().getString(2131700161));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBottomBar
 * JD-Core Version:    0.7.0.1
 */