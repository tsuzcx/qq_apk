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
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.widgets.AvatarListView;
import com.tencent.biz.qqcircle.widgets.QCirclePolyParseFrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
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

public class udf
  extends ucz
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private QCirclePolyParseFrameLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout;
  private QCirclePushAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private QQCircleFeedBase.StLikeBusiData jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private trd jdField_a_of_type_Trd;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  
  public udf(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
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
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setOnClickHookListener(new udh(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new udi(this));
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
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (c()) {}
    while ((!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_Trr == null) || (this.jdField_a_of_type_Trr.a() == null)) {
      return;
    }
    this.jdField_a_of_type_Trr.a().a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_Trr.a().a(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    this.jdField_a_of_type_Trr.a().a(this.jdField_a_of_type_Trr.a());
    this.jdField_a_of_type_Trr.a().a(paramStComment, paramStReply);
    if ((paramStComment == null) && (paramStReply == null))
    {
      tyg.a(6, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      return;
    }
    tyg.a(9, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    this.jdField_a_of_type_Trr.a().a(9);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.size() > 3)
      {
        i = 3;
        int j = 0;
        while (j < i)
        {
          localArrayList.add(((QQCircleFeedBase.StPolyLike)this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get(j)).polyIconUrl.get());
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
        int i = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.size();
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(localInvalidProtocolBufferMicroException, true);
      this.b.setVisibility(8);
      if (paramStFeed.likeInfo.count.get() > 0)
      {
        this.b.setVisibility(0);
        this.b.setText(tra.b(paramStFeed.likeInfo.count.get()));
      }
    }
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
    this.jdField_a_of_type_JavaLangObject = paramStFeed;
    e(paramStFeed);
  }
  
  private void a(List<FeedCloudMeta.StUser> paramList, int paramInt, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setBold(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setMaxNum(paramInt);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setOnClickItemListener(new udj(this, paramString));
    paramString = alpo.a(2131698305) + tra.a(paramInt, true) + alpo.a(2131698304);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.getContext().getResources().getDrawable(2130843570);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(18.0F), ImmersiveUtils.a(15.0F));
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setDataList(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramList, paramString);
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
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
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
  
  private void c(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Trr != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setAniView(this.jdField_a_of_type_Trr.a());
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setFeedData(paramStFeed);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    }
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 1);
      if (tra.a(paramStFeed.poster.id.get())) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(0);
  }
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramStFeed.vecComment.get().iterator();
    while (localIterator1.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator1.next();
      localArrayList.add(new trs(paramStFeed, localStComment));
      Iterator localIterator2 = localStComment.vecReply.get().iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add(new trs(paramStFeed, localStComment, (FeedCloudMeta.StReply)localIterator2.next()));
      }
    }
    if (this.jdField_a_of_type_Trd == null) {
      this.jdField_a_of_type_Trd = new trd();
    }
    this.jdField_a_of_type_Trd.a(localArrayList);
    this.jdField_a_of_type_Trd.a(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    this.jdField_a_of_type_Trd.a(this.jdField_a_of_type_Trr);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Trd);
    if (paramStFeed.commentCount.get() > localArrayList.size())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131698296, new Object[] { tra.a(paramStFeed.commentCount.get(), true) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout = ((QCirclePolyParseFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373153));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373135));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373139));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373129));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373131));
      this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373130));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView = ((QCirclePushAsyncTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378880));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373126));
      paramViewStub = new udg(this, this.jdField_a_of_type_AndroidViewView.getContext(), 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramViewStub);
      a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(1);
    }
  }
  
  public void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if ((paramQCircleCommentUpdateEvent != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).id.get().equals(paramQCircleCommentUpdateEvent.feedId))) {
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
        if ((((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().size() > 0) && (((FeedCloudMeta.StComment)((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().get(0)).typeFlag.get() == 1)) {
          ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().add(1, paramQCircleCommentUpdateEvent.comment);
        }
        for (;;)
        {
          ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
          e((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          return;
          ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().add(0, paramQCircleCommentUpdateEvent.comment);
        }
      } while (paramQCircleCommentUpdateEvent.comment == null);
      localObject = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((FeedCloudMeta.StComment)((Iterator)localObject).next()).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())) {
          ((Iterator)localObject).remove();
        }
      }
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      e((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      return;
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject, paramQCircleCommentUpdateEvent);
      return;
      localObject = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get();
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.set(tra.a(paramQCircleCommentUpdateEvent.comment.id.get(), (List)localObject));
      e((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
      localObject = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get();
    } while ((((List)localObject).size() <= 0) || (((FeedCloudMeta.StComment)((List)localObject).get(0)).typeFlag.get() != 1) || (!((FeedCloudMeta.StComment)((List)localObject).get(0)).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())));
    ((FeedCloudMeta.StComment)((List)localObject).get(0)).typeFlag.set(0);
    e((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
  }
  
  public void a(QCircleCommonAnimationEvent paramQCircleCommonAnimationEvent)
  {
    if ((paramQCircleCommonAnimationEvent.mType == QCircleCommonAnimationEvent.TYPE_SPLASH_VIDEO) && (paramQCircleCommonAnimationEvent.mState == QCircleCommonAnimationEvent.STATE_ANIMATION_END) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.getVisibility() == 0))
    {
      tqt.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent)
  {
    if ((paramQCirclePolyPraiseUpdateEvent == null) || (this.jdField_a_of_type_JavaLangObject == null) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData == null)) {}
    FeedCloudMeta.StFeed localStFeed;
    do
    {
      return;
      localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    } while (!TextUtils.equals(localStFeed.id.get(), paramQCirclePolyPraiseUpdateEvent.mTargetFeedId));
    List localList = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get();
    switch (paramQCirclePolyPraiseUpdateEvent.mPraisedStatus)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.set(localList);
      localStFeed.likeInfo.count.set(paramQCirclePolyPraiseUpdateEvent.mPraisedNum);
      localStFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.toByteArray()));
      this.jdField_a_of_type_JavaLangObject = localStFeed;
      a(localStFeed);
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
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
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
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      paramObject = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      e(paramObject);
      c(paramObject);
      a(paramObject);
      b(paramObject);
      d(paramObject);
      if (paramInt == 0)
      {
        if (!tqt.a().a()) {
          break label118;
        }
        tqt.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      }
    }
    return;
    label118:
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        a(null, null);
        return;
      } while ((c()) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_Trr == null) || (this.jdField_a_of_type_Trr.a() == null));
      this.jdField_a_of_type_Trr.a().a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      tyg.a(10, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      this.jdField_a_of_type_Trr.a().a(this.jdField_a_of_type_Trr.a());
      this.jdField_a_of_type_Trr.a().f();
      this.jdField_a_of_type_Trr.a().a(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout == null);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolyParseFrameLayout.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udf
 * JD-Core Version:    0.7.0.1
 */