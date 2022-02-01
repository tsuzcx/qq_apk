package com.tencent.biz.qqcircle.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ankt;
import aoop;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import oum;
import ous;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;
import rwv;
import rwx;

public class QCirclePolyLikeFrameLayout
  extends FrameLayout
  implements View.OnClickListener, rwx
{
  private URLImageView T;
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout$a;
  private QCirclePolymorphicLikePopWindow jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow;
  private QQCircleFeedBase.StLikeBusiData jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private QQCircleFeedBase.StPolyLike jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike;
  private FrameLayout aB;
  private boolean azU;
  private ReportExtraTypeInfo jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  private QCirclePolymorphicAniView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private int biw = 2130844799;
  private int bix = 2130844808;
  private FeedCloudMeta.StFeed l = new FeedCloudMeta.StFeed();
  private List<QQCircleFeedBase.StPolyLike> ls;
  private ImageView mh;
  
  public QCirclePolyLikeFrameLayout(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public QCirclePolyLikeFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public QCirclePolyLikeFrameLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData;
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (paramStPolyLike != null) && (!this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get().equals(paramStPolyLike.polyLikeID.get())))
    {
      localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      localStLikeBusiData.curPolyLikeInfo.set(paramStPolyLike);
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(this.l.likeInfo.busiData.get().toByteArray());
      localStLikeBusiData.polyLikeInfo.set(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get());
      this.l.likeInfo.busiData.set(ByteStringMicro.copyFrom(localStLikeBusiData.toByteArray()));
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike = paramStPolyLike;
      if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get())))
      {
        paramStPolyLike = URLDrawable.URLDrawableOptions.obtain();
        paramStPolyLike.mLoadingDrawable = aoop.TRANSPARENT;
        paramStPolyLike.mRequestWidth = this.T.getWidth();
        paramStPolyLike.mRequestHeight = this.T.getHeight();
        ous.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyIconUrl.get(), this.T, paramStPolyLike, false);
        this.aB.setVisibility(0);
        this.mh.setVisibility(4);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      this.mh.setVisibility(0);
      this.aB.setVisibility(4);
    }
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131560933, this, true);
    if (localView != null)
    {
      this.aB = ((FrameLayout)localView.findViewById(2131374560));
      this.T = ((URLImageView)localView.findViewById(2131374574));
      this.mh = ((ImageView)localView.findViewById(2131374577));
      setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow = new QCirclePolymorphicLikePopWindow((Activity)getContext());
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike.polyLikeID.get())))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(this.mh, this.T, this.azU, this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView, this.l, this.ls, this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, true);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(this.l, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ry(true);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    ThreadManager.getUIHandler().post(new QCirclePolyLikeFrameLayout.1(this, paramSimpleBaseEvent));
  }
  
  public void ry(boolean paramBoolean)
  {
    this.ls = oum.br();
    if (this.ls.isEmpty()) {}
    do
    {
      QQToast.a(getContext(), 0, 2131700172, 0);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.isShowing());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(this.mh, this.T, this.azU, this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView, this.l, this.ls, this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, paramBoolean);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.bkF();
    } while (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout$a == null);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout$a.rj(paramBoolean);
  }
  
  public void setAniView(QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
  }
  
  public void setExtraTypeInfo(ReportExtraTypeInfo paramReportExtraTypeInfo)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = paramReportExtraTypeInfo;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.likeInfo.get() != null)) {
      this.l = paramStFeed;
    }
    try
    {
      paramStFeed = (FeedCloudMeta.StLike)paramStFeed.likeInfo.get();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      this.aB.setBackgroundDrawable(getResources().getDrawable(this.biw));
      this.mh.setImageDrawable(getResources().getDrawable(this.bix));
      a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.curPolyLikeInfo);
      return;
    }
    catch (Exception paramStFeed) {}
  }
  
  public void setIsContentDetail(boolean paramBoolean)
  {
    this.azU = paramBoolean;
    int i;
    int j;
    if (this.azU)
    {
      i = ankt.dip2px(30.0F);
      j = ankt.dip2px(19.0F);
      this.mh.getLayoutParams().width = i;
      this.mh.getLayoutParams().height = i;
      this.mh.setLayoutParams(this.mh.getLayoutParams());
      this.aB.getLayoutParams().width = i;
      this.aB.getLayoutParams().height = i;
      this.aB.setLayoutParams(this.aB.getLayoutParams());
      this.T.getLayoutParams().width = j;
      this.T.getLayoutParams().height = j;
      this.T.setLayoutParams(this.T.getLayoutParams());
    }
    for (;;)
    {
      this.aB.setBackgroundDrawable(getResources().getDrawable(this.biw));
      this.mh.setImageDrawable(getResources().getDrawable(this.bix));
      return;
      i = ankt.dip2px(45.0F);
      j = ankt.dip2px(19.0F);
      this.mh.getLayoutParams().width = i;
      this.mh.getLayoutParams().height = i;
      this.mh.setLayoutParams(this.mh.getLayoutParams());
      this.aB.getLayoutParams().width = i;
      this.aB.getLayoutParams().height = i;
      this.aB.setLayoutParams(this.aB.getLayoutParams());
      this.T.getLayoutParams().width = j;
      this.T.getLayoutParams().height = j;
      this.T.setLayoutParams(this.T.getLayoutParams());
    }
  }
  
  public void setOnClickHookListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout$a = parama;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(parama);
    }
  }
  
  public void setPraisedDrawable(int paramInt)
  {
    this.biw = paramInt;
  }
  
  public void setUnPraiseDrawable(int paramInt)
  {
    this.bix = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void biF();
    
    public abstract void rj(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePolyLikeFrameLayout
 * JD-Core Version:    0.7.0.1
 */