import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.widgets.AvatarListView;
import com.tencent.biz.qqcircle.widgets.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class php
  extends phl
  implements View.OnClickListener
{
  private ovh a;
  private boolean aAd;
  private QCirclePushAsyncTextView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView;
  private QCircleRecommendImageView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private QQCircleFeedBase.StLikeBusiData jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private AvatarListView jdField_c_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private QCirclePolyLikeFrameLayout jdField_c_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout;
  private Drawable cY;
  private List<ovx> lK;
  private RecyclerView m;
  private Activity mActivity;
  private ImageView mq;
  private TextView wO;
  private TextView wP;
  
  public php(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      this.mActivity = ((Activity)paramContext);
    }
  }
  
  private String a(FeedCloudMeta.StPushList paramStPushList)
  {
    if (paramStPushList != null) {
      return paramStPushList.jumpUrl.get().replace("{id}", paramStPushList.id.get());
    }
    QLog.e("QCircleFeedItemBottomPresenter", 1, "getPushListUrl failed,return empty");
    return "";
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (paramQCircleCommentUpdateEvent.eventStatus == 3) {
      paramStComment.vecReply.get().add(0, paramQCircleCommentUpdateEvent.reply);
    }
    do
    {
      do
      {
        return;
        while ((paramQCircleCommentUpdateEvent.eventStatus != 4) || (paramStComment.vecReply.size() <= 0)) {}
        paramStComment = paramStComment.vecReply.get().iterator();
      } while (!paramStComment.hasNext());
    } while (!TextUtils.equals(((FeedCloudMeta.StReply)paramStComment.next()).id.get(), paramQCircleCommentUpdateEvent.reply.id.get()));
    paramStComment.remove();
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if ((paramStFeed == null) || (paramQCircleCommentUpdateEvent == null) || (paramQCircleCommentUpdateEvent.comment == null) || (paramQCircleCommentUpdateEvent.reply == null)) {
      return;
    }
    List localList = paramStFeed.vecComment.get();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator.next();
      if (TextUtils.equals(localStComment.id.get(), paramQCircleCommentUpdateEvent.comment.id.get())) {
        a(localStComment, paramQCircleCommentUpdateEvent);
      }
    }
    paramStFeed.vecComment.set(localList);
    this.mData = paramStFeed;
    p(paramStFeed);
  }
  
  private void a(List<FeedCloudMeta.StUser> paramList, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setBold(true);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setMaxNum(paramInt);
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setOnClickItemListener(new pht(this, paramString));
    paramString = acfp.m(2131700098) + ovd.e(paramInt, true) + acfp.m(2131700097);
    if (this.cY == null)
    {
      this.cY = this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.getContext().getResources().getDrawable(2130844804);
      this.cY.setBounds(0, 0, ImmersiveUtils.dpToPx(18.0F), ImmersiveUtils.dpToPx(15.0F));
    }
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setDataList(this.cY, paramList, paramString);
  }
  
  private void a(QQCircleFeedBase.StPolyLike paramStPolyLike, List<QQCircleFeedBase.StPolyLike> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        paramStPolyLike.count.set(1);
        Iterator localIterator = paramList.iterator();
        localStPolyLike = paramStPolyLike;
        if (!localIterator.hasNext()) {
          break label227;
        }
        localStPolyLike = (QQCircleFeedBase.StPolyLike)localIterator.next();
        if (!TextUtils.equals(localStPolyLike.polyLikeID.get(), paramStPolyLike.polyLikeID.get())) {
          continue;
        }
        localStPolyLike.count.set(localStPolyLike.count.get() + 1);
        localIterator.remove();
      }
      catch (Exception paramStPolyLike)
      {
        QQCircleFeedBase.StPolyLike localStPolyLike;
        paramStPolyLike.printStackTrace();
        return;
      }
      if (i < paramList.size())
      {
        if (localStPolyLike.count.get() <= ((QQCircleFeedBase.StPolyLike)paramList.get(i)).count.get())
        {
          if ((localStPolyLike.count.get() != ((QQCircleFeedBase.StPolyLike)paramList.get(i)).count.get()) || (Integer.parseInt(localStPolyLike.polyLikeID.get()) > Integer.parseInt(((QQCircleFeedBase.StPolyLike)paramList.get(i)).polyLikeID.get()))) {
            break label238;
          }
          break label232;
          if (j != 0)
          {
            paramList.add(i, localStPolyLike);
            return;
          }
          paramList.add(localStPolyLike);
        }
      }
      else
      {
        j = 0;
        continue;
        label227:
        i = 0;
        continue;
      }
      label232:
      int j = 1;
      continue;
      label238:
      i += 1;
    }
  }
  
  private void b(QQCircleFeedBase.StPolyLike paramStPolyLike, List<QQCircleFeedBase.StPolyLike> paramList)
  {
    QQCircleFeedBase.StPolyLike localStPolyLike;
    int i;
    try
    {
      Iterator localIterator = paramList.iterator();
      do
      {
        localStPolyLike = paramStPolyLike;
        if (!localIterator.hasNext()) {
          break;
        }
        localStPolyLike = (QQCircleFeedBase.StPolyLike)localIterator.next();
      } while (!TextUtils.equals(localStPolyLike.polyLikeID.get(), paramStPolyLike.polyLikeID.get()));
      localStPolyLike.count.set(localStPolyLike.count.get() - 1);
      localIterator.remove();
      if (localStPolyLike.count.get() != 0) {
        break label235;
      }
      return;
    }
    catch (Exception paramStPolyLike)
    {
      paramStPolyLike.printStackTrace();
      return;
    }
    if (i < paramList.size())
    {
      if (localStPolyLike.count.get() > ((QQCircleFeedBase.StPolyLike)paramList.get(i)).count.get()) {
        break label240;
      }
      if ((localStPolyLike.count.get() == ((QQCircleFeedBase.StPolyLike)paramList.get(i)).count.get()) && (Integer.parseInt(localStPolyLike.polyLikeID.get()) <= Integer.parseInt(((QQCircleFeedBase.StPolyLike)paramList.get(i)).polyLikeID.get()))) {
        break label240;
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        paramList.add(i, localStPolyLike);
        return;
        i += 1;
        break;
      }
      paramList.add(localStPolyLike);
      return;
      int j = 0;
      continue;
      label235:
      i = 0;
      break;
      label240:
      j = 1;
    }
  }
  
  private void blb()
  {
    this.mq.setOnClickListener(this);
    this.wO.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setOnClickListener(this);
    this.wP.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setOnClickHookListener(new phr(this));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new phs(this));
  }
  
  private void blc()
  {
    if ((this.wO != null) && (this.wO.getVisibility() == 8))
    {
      this.wO.setText(this.wO.getResources().getString(2131700088));
      this.wO.setVisibility(0);
    }
  }
  
  private void e(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (HW()) {}
    while ((!(this.mData instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_Ovv == null) || (this.jdField_a_of_type_Ovv.a() == null)) {
      return;
    }
    this.jdField_a_of_type_Ovv.a().setFeedData((FeedCloudMeta.StFeed)this.mData);
    this.jdField_a_of_type_Ovv.a().setExtraTypeInfo(this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    this.jdField_a_of_type_Ovv.a().setAniView(this.jdField_a_of_type_Ovv.a());
    this.jdField_a_of_type_Ovv.a().e(paramStComment, paramStReply);
    if ((paramStComment == null) && (paramStReply == null))
    {
      pcl.a(6, 2, this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      return;
    }
    pcl.a(9, 2, this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    this.jdField_a_of_type_Ovv.a().vj(9);
  }
  
  private void l(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    try
    {
      this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.size() > 3)
      {
        i = 3;
        int j = 0;
        while (j < i)
        {
          localArrayList.add(((QQCircleFeedBase.StPolyLike)this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get(j)).polyIconUrl.get());
          j += 1;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        int i = this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.size();
      }
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(localInvalidProtocolBufferMicroException, true);
      this.wP.setVisibility(8);
      if (paramStFeed.likeInfo.count.get() > 0)
      {
        this.wP.setVisibility(0);
        this.wP.setText(ovd.aD(paramStFeed.likeInfo.count.get()));
      }
    }
  }
  
  private void m(FeedCloudMeta.StFeed paramStFeed)
  {
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      a(localStFeedBusiReqData.pushList.vecUser.get(), localStFeedBusiReqData.pushList.count.get(), a((FeedCloudMeta.StPushList)localStFeedBusiReqData.pushList.get()));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStFeed)
    {
      for (;;)
      {
        paramStFeed.printStackTrace();
      }
    }
  }
  
  private void n(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Ovv != null)
    {
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setAniView(this.jdField_a_of_type_Ovv.a());
      this.mExtraTypeInfo.mDataPosition = this.mPos;
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setFeedData(paramStFeed);
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout.setExtraTypeInfo(this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    }
  }
  
  private void o(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 1);
      if (ovd.eL(paramStFeed.poster.id.get())) {
        this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(0);
  }
  
  private void p(FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramStFeed.vecComment.get().iterator();
    while (localIterator1.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator1.next();
      localArrayList.add(new ovx(paramStFeed, localStComment));
      Iterator localIterator2 = localStComment.vecReply.get().iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add(new ovx(paramStFeed, localStComment, (FeedCloudMeta.StReply)localIterator2.next()));
      }
    }
    if (this.jdField_a_of_type_Ovh == null) {
      this.jdField_a_of_type_Ovh = new ovh();
    }
    this.lK = localArrayList;
    if (paramStFeed.commentCount.get() > localArrayList.size())
    {
      this.wO.setText(this.wO.getResources().getString(2131700089, new Object[] { ovd.e(paramStFeed.commentCount.get(), true) }));
      this.wO.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ovh.bF(localArrayList);
      this.jdField_a_of_type_Ovh.setExtraTypeInfo(this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      this.jdField_a_of_type_Ovh.setInteractor(this.jdField_a_of_type_Ovv);
      this.m.setAdapter(this.jdField_a_of_type_Ovh);
      return;
      this.wO.setVisibility(8);
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)this.mContainer.findViewById(2131374534));
      this.mq = ((ImageView)this.mContainer.findViewById(2131374516));
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)this.mContainer.findViewById(2131374520));
      this.wO = ((TextView)this.mContainer.findViewById(2131374507));
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)this.mContainer.findViewById(2131374512));
      this.wP = ((TextView)this.mContainer.findViewById(2131374511));
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView = ((QCirclePushAsyncTextView)this.mContainer.findViewById(2131380860));
      this.m = ((RecyclerView)this.mContainer.findViewById(2131374504));
      paramViewStub = new phq(this, this.mContainer.getContext(), 1, false);
      this.m.setLayoutManager(paramViewStub);
      blb();
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(1);
    }
  }
  
  public void a(QCircleCommonAnimationEvent paramQCircleCommonAnimationEvent)
  {
    if ((paramQCircleCommonAnimationEvent.mType == QCircleCommonAnimationEvent.TYPE_SPLASH_VIDEO) && (paramQCircleCommonAnimationEvent.mState == QCircleCommonAnimationEvent.STATE_ANIMATION_END) && (this.aAd) && (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null) && (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.getVisibility() == 0))
    {
      ouy.a().f(this.mActivity, this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      this.aAd = false;
    }
  }
  
  public void a(QCircleFeedCommentEllipseEvent paramQCircleFeedCommentEllipseEvent)
  {
    if ((this.lK == null) || (paramQCircleFeedCommentEllipseEvent.mInfo == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.mFeed == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {}
    ovx localovx;
    do
    {
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext()) {
          localIterator = this.lK.iterator();
        }
        localovx = (ovx)localIterator.next();
      } while ((localovx.mFeed == null) || (!localovx.mFeed.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.mFeed.id.get())));
      if ((localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) && (localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) && (localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) && (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null))
      {
        blc();
        return;
      }
    } while ((localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) || (localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!localovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get())));
    blc();
  }
  
  public void a(QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent)
  {
    if ((paramQCirclePolyPraiseUpdateEvent == null) || (this.mData == null) || (this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData == null)) {}
    FeedCloudMeta.StFeed localStFeed;
    do
    {
      return;
      localStFeed = (FeedCloudMeta.StFeed)this.mData;
    } while (!TextUtils.equals(localStFeed.id.get(), paramQCirclePolyPraiseUpdateEvent.mTargetFeedId));
    List localList = this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get();
    switch (paramQCirclePolyPraiseUpdateEvent.mPraisedStatus)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.set(localList);
      localStFeed.likeInfo.count.set(paramQCirclePolyPraiseUpdateEvent.mPraisedNum);
      localStFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.toByteArray()));
      this.mData = localStFeed;
      l(localStFeed);
      return;
      a(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike, localList);
      continue;
      b(paramQCirclePolyPraiseUpdateEvent.moldStPolyLike, localList);
      continue;
      b(paramQCirclePolyPraiseUpdateEvent.moldStPolyLike, localList);
      a(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike, localList);
    }
  }
  
  public void a(QCirclePushUpdateEvent paramQCirclePushUpdateEvent)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mData;
    if ((paramQCirclePushUpdateEvent == null) || (!TextUtils.equals(localStFeed.id.get(), paramQCirclePushUpdateEvent.mTargetFeedId))) {}
    for (;;)
    {
      return;
      QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
      try
      {
        localStFeedBusiReqData.mergeFrom(localStFeed.busiData.get().toByteArray());
        if (localStFeedBusiReqData.pushList.status.get() == 1) {
          continue;
        }
        List localList = localStFeedBusiReqData.pushList.vecUser.get();
        localList.add(0, paramQCirclePushUpdateEvent.mCurrentUser);
        localStFeedBusiReqData.pushList.count.set(localStFeedBusiReqData.pushList.count.get() + 1);
        localStFeedBusiReqData.pushList.status.set(1);
        localStFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
        a(localList, localStFeedBusiReqData.pushList.count.get(), a((FeedCloudMeta.StPushList)localStFeedBusiReqData.pushList.get()));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.mPos;
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      paramObject = (FeedCloudMeta.StFeed)this.mData;
      p(paramObject);
      n(paramObject);
      l(paramObject);
      m(paramObject);
      o(paramObject);
      if (paramInt == 0)
      {
        if (!ouy.a().isEnable()) {
          break label118;
        }
        ouy.a().f(this.mActivity, this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      }
    }
    return;
    label118:
    this.aAd = true;
  }
  
  public void c(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if ((paramQCircleCommentUpdateEvent != null) && ((this.mData instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.mData).id.get().equals(paramQCircleCommentUpdateEvent.feedId))) {
      switch (paramQCircleCommentUpdateEvent.eventStatus)
      {
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramQCircleCommentUpdateEvent.comment == null);
        if ((((FeedCloudMeta.StFeed)this.mData).vecComment.get().size() > 0) && (((FeedCloudMeta.StComment)((FeedCloudMeta.StFeed)this.mData).vecComment.get().get(0)).typeFlag.get() == 1)) {
          ((FeedCloudMeta.StFeed)this.mData).vecComment.get().add(1, paramQCircleCommentUpdateEvent.comment);
        }
        for (;;)
        {
          ((FeedCloudMeta.StFeed)this.mData).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
          p((FeedCloudMeta.StFeed)this.mData);
          return;
          ((FeedCloudMeta.StFeed)this.mData).vecComment.get().add(0, paramQCircleCommentUpdateEvent.comment);
        }
      } while (paramQCircleCommentUpdateEvent.comment == null);
      localObject = ((FeedCloudMeta.StFeed)this.mData).vecComment.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((FeedCloudMeta.StComment)((Iterator)localObject).next()).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())) {
          ((Iterator)localObject).remove();
        }
      }
      ((FeedCloudMeta.StFeed)this.mData).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      p((FeedCloudMeta.StFeed)this.mData);
      return;
      ((FeedCloudMeta.StFeed)this.mData).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      return;
      ((FeedCloudMeta.StFeed)this.mData).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      a((FeedCloudMeta.StFeed)this.mData, paramQCircleCommentUpdateEvent);
      return;
      localObject = ((FeedCloudMeta.StFeed)this.mData).vecComment.get();
      ((FeedCloudMeta.StFeed)this.mData).vecComment.set(ovd.b(paramQCircleCommentUpdateEvent.comment.id.get(), (List)localObject));
      p((FeedCloudMeta.StFeed)this.mData);
      return;
      localObject = ((FeedCloudMeta.StFeed)this.mData).vecComment.get();
    } while ((((List)localObject).size() <= 0) || (((FeedCloudMeta.StComment)((List)localObject).get(0)).typeFlag.get() != 1) || (!((FeedCloudMeta.StComment)((List)localObject).get(0)).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())));
    ((FeedCloudMeta.StComment)((List)localObject).get(0)).typeFlag.set(0);
    p((FeedCloudMeta.StFeed)this.mData);
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
      e(null, null);
      continue;
      if ((!HW()) && ((this.mData instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Ovv != null) && (this.jdField_a_of_type_Ovv.a() != null))
      {
        this.jdField_a_of_type_Ovv.a().setFeedData((FeedCloudMeta.StFeed)this.mData);
        pcl.a(10, 2, this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
        this.jdField_a_of_type_Ovv.a().setAniView(this.jdField_a_of_type_Ovv.a());
        this.jdField_a_of_type_Ovv.a().beM();
        this.jdField_a_of_type_Ovv.a().setExtraTypeInfo(this.jdField_b_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
        continue;
        if ((this.jdField_a_of_type_Ovv != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
        {
          oww.c localc = new oww.c();
          localc.mFeed = ((FeedCloudMeta.StFeed)this.mData);
          localc.mPos = this.mPos;
          this.jdField_a_of_type_Ovv.a(localc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     php
 * JD-Core Version:    0.7.0.1
 */