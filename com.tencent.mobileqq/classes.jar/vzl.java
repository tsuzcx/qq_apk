import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.AvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
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
import feedcloud.FeedCloudMeta.StVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedBusiReqData;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class vzl
  extends vzg
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout;
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private QCircleCommentListView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView;
  private QCirclePushAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private List<uzk> jdField_a_of_type_JavaUtilList;
  private QQCircleFeedBase.StLikeBusiData jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private uyi jdField_a_of_type_Uyi;
  private boolean jdField_a_of_type_Boolean;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public vzl(Context paramContext)
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
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setOnClickHookListener(new vzn(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new vzo(this));
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (paramQCircleCommentUpdateEvent.eventStatus == 5) {
      paramStComment.vecReply.get().add(0, paramQCircleCommentUpdateEvent.reply);
    }
    do
    {
      do
      {
        return;
        while ((paramQCircleCommentUpdateEvent.eventStatus != 6) || (paramStComment.vecReply.size() <= 0)) {}
        paramStComment = paramStComment.vecReply.get().iterator();
      } while (!paramStComment.hasNext());
    } while (!TextUtils.equals(((FeedCloudMeta.StReply)paramStComment.next()).id.get(), paramQCircleCommentUpdateEvent.reply.id.get()));
    paramStComment.remove();
  }
  
  private void a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (c()) {}
    while ((!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_Uzb == null)) {
      return;
    }
    uzc localuzc = new uzc();
    localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
    localuzc.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
    localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    localuzc.jdField_a_of_type_JavaLangString = a().getModuleIdStr();
    if ((paramStComment == null) && (paramStReply == null)) {
      vrc.a(6, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
    }
    for (localuzc.c = 6; (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView != null); localuzc.c = 9)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a(localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, localuzc.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
      return;
      vrc.a(9, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
    }
    this.jdField_a_of_type_Uzb.a("comment_input_window_show", localuzc);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.mergeFrom(paramStFeed.likeInfo.busiData.get().toByteArray());
      ArrayList localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.size() > 3)
      {
        i = 3;
        int j = 0;
        while (j < i)
        {
          QQCircleFeedBase.StPolyLike localStPolyLike = (QQCircleFeedBase.StPolyLike)this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.get(j);
          localArrayList1.add(localStPolyLike.polyIconUrl.get());
          localArrayList2.add(localStPolyLike.polyUnderPicUrl.get());
          j += 1;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      ArrayList localArrayList2;
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        int i = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.size();
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(localInvalidProtocolBufferMicroException, localArrayList2, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramStFeed.likeInfo.count.get() > 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(uxx.d(paramStFeed.likeInfo.count.get()));
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
    f(paramStFeed);
  }
  
  private void a(List<FeedCloudMeta.StUser> paramList, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setBold(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setMaxNum(paramInt2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setOnClickItemListener(new vzp(this));
    String str = anni.a(2131697157) + uxx.a(paramInt2, true) + anni.a(2131697156);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.getContext().getResources().getDrawable(2130844053);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(16.0F), ImmersiveUtils.a(16.0F));
    }
    if (paramInt1 > 0) {}
    for (paramString = String.valueOf(paramInt1);; paramString = "")
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setDataList(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramString, paramList, str);
      return;
    }
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
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131697146));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      paramStFeed = paramStFeed.visitorInfo.viewDesc.get();
      if (!TextUtils.isEmpty(paramStFeed))
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          paramStFeed = " · " + paramStFeed;
        }
        for (localMarginLayoutParams.leftMargin = vtu.a(3.0F);; localMarginLayoutParams.leftMargin = vtu.a(12.0F))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localMarginLayoutParams);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramStFeed);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          return;
        }
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
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
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      localStFeedBusiReqData.mergeFrom(paramStFeed.busiData.get().toByteArray());
      List localList = localStFeedBusiReqData.pushList.vecUser.get();
      if (paramStFeed.opMask2.get().contains(Integer.valueOf(8)))
      {
        i = localStFeedBusiReqData.pushList.totalClickCount.get();
        a(localList, i, localStFeedBusiReqData.pushList.count.get(), a((FeedCloudMeta.StPushList)localStFeedBusiReqData.pushList.get()));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        int i = 0;
      }
    }
  }
  
  private void d(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Uzb != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setAniView(this.jdField_a_of_type_Uzb.a());
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setFeedData(paramStFeed);
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
    }
  }
  
  private void e(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null)
    {
      if (!a()) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 1);
      }
      if (uxx.a(paramStFeed.poster.id.get())) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(0);
  }
  
  private void f(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.vecComment.size() == 0)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (!this.jdField_b_of_type_Boolean) {
        break label161;
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView;
      if (paramStFeed.vecComment.get().size() != 0) {
        break label156;
      }
    }
    label156:
    for (int i = 8;; i = 0)
    {
      ((QCircleCommentListView)localObject).setVisibility(i);
      localObject = new uzc();
      ((uzc)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      ((uzc)localObject).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      ((uzc)localObject).c = 6;
      ((uzc)localObject).b = uzc.d;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.setDataPosInList(a());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.setParentRecyclerView(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.setReportBean(a());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.setFeedData(paramStFeed);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.setData(localObject);
      }
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      break;
    }
    label161:
    Object localObject = new ArrayList();
    Iterator localIterator1 = paramStFeed.vecComment.get().iterator();
    while (localIterator1.hasNext())
    {
      FeedCloudMeta.StComment localStComment = (FeedCloudMeta.StComment)localIterator1.next();
      ((List)localObject).add(new uzk(paramStFeed, localStComment));
      Iterator localIterator2 = localStComment.vecReply.get().iterator();
      while (localIterator2.hasNext()) {
        ((List)localObject).add(new uzk(paramStFeed, localStComment, (FeedCloudMeta.StReply)localIterator2.next()));
      }
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    if (this.jdField_a_of_type_Uyi == null)
    {
      this.jdField_a_of_type_Uyi = new uyi();
      this.jdField_a_of_type_Uyi.a(a());
    }
    if (paramStFeed.commentCount.get() > ((List)localObject).size())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131697147, new Object[] { uxx.a(paramStFeed.commentCount.get(), true) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uyi.a((List)localObject);
      this.jdField_a_of_type_Uyi.a(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Uyi.a(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      this.jdField_a_of_type_Uyi.a(this.jdField_a_of_type_Uzb);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uyi);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public QCircleReportBean a()
  {
    if ((a() != null) && (uxx.a(a().getContext()) != null)) {
      return uxx.a(a().getContext()).a();
    }
    return super.a();
  }
  
  protected String a()
  {
    return "QCircleFeedItemBottomPresenter";
  }
  
  public void a(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a().a().setRecycledViewPool(paramRecycledViewPool);
    }
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setRecycledViewPool(paramRecycledViewPool);
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373819));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373947);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373800));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373803));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373785));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373796));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373795));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373946));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView = ((QCirclePushAsyncTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379829));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380880);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373781));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView = ((QCircleCommentListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373778));
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a()) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      }
      paramViewStub = new vzm(this, this.jdField_a_of_type_AndroidViewView.getContext(), 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramViewStub);
      a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(1);
      zzr.a(this.jdField_b_of_type_AndroidWidgetTextView, false);
    }
  }
  
  public void a(QCircleCommentUpdateEvent paramQCircleCommentUpdateEvent)
  {
    if (this.jdField_b_of_type_Boolean) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while ((paramQCircleCommentUpdateEvent == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (!((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).id.get().equals(paramQCircleCommentUpdateEvent.feedId)));
          switch (paramQCircleCommentUpdateEvent.eventStatus)
          {
          case 2: 
          default: 
            return;
          case 1: 
            ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
            return;
          }
        } while (paramQCircleCommentUpdateEvent.comment == null);
        if ((((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().size() > 0) && (((FeedCloudMeta.StComment)((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().get(0)).typeFlag.get() == 1)) {
          ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get().add(1, paramQCircleCommentUpdateEvent.comment);
        }
        for (;;)
        {
          ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
          f((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
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
      f((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).commentCount.set(paramQCircleCommentUpdateEvent.commentTotalNum);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject, paramQCircleCommentUpdateEvent);
      return;
      localObject = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get();
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.set(uxx.a(paramQCircleCommentUpdateEvent.comment.id.get(), (List)localObject));
      f((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
      localObject = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.get();
    } while ((((List)localObject).size() <= 0) || (((FeedCloudMeta.StComment)((List)localObject).get(0)).typeFlag.get() != 1) || (!((FeedCloudMeta.StComment)((List)localObject).get(0)).id.get().equals(paramQCircleCommentUpdateEvent.comment.id.get())));
    ((FeedCloudMeta.StComment)((List)localObject).get(0)).typeFlag.set(0);
    f((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
  }
  
  public void a(QCircleCommonAnimationEvent paramQCircleCommonAnimationEvent)
  {
    if ((paramQCircleCommonAnimationEvent.mType == QCircleCommonAnimationEvent.TYPE_SPLASH_VIDEO) && (paramQCircleCommonAnimationEvent.mState == QCircleCommonAnimationEvent.STATE_ANIMATION_END) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.getVisibility() == 0))
    {
      uxp.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(QCircleFeedCommentEllipseEvent paramQCircleFeedCommentEllipseEvent)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramQCircleFeedCommentEllipseEvent.mInfo == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {}
    uzk localuzk;
    do
    {
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext()) {
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localuzk = (uzk)localIterator.next();
      } while ((localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (!localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
      if ((localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) && (localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) && (localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) && (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null))
      {
        b();
        return;
      }
    } while ((localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) || (localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!localuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get())));
    b();
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
      if ((paramQCirclePolyPraiseUpdateEvent.mPraisedStatus == 22) || (paramQCirclePolyPraiseUpdateEvent.mPraisedStatus == 21)) {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.rewardstatus.set(1);
      }
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
    if ((paramQCirclePushUpdateEvent == null) || (!TextUtils.equals(localStFeed.id.get(), paramQCirclePushUpdateEvent.mTargetFeedId))) {
      return;
    }
    QQCircleFeedBase.StFeedBusiReqData localStFeedBusiReqData = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      localStFeedBusiReqData.mergeFrom(localStFeed.busiData.get().toByteArray());
      List localList = localStFeedBusiReqData.pushList.vecUser.get();
      if ((localList.size() <= 0) || (!((FeedCloudMeta.StUser)localList.get(0)).id.get().equals(paramQCirclePushUpdateEvent.mCurrentUser.id.get())))
      {
        QLog.d("QCircleFeedItemBottomPresenter", 1, "is not in pushList add user");
        localList.add(0, paramQCirclePushUpdateEvent.mCurrentUser);
        localStFeedBusiReqData.pushList.count.set(localStFeedBusiReqData.pushList.count.get() + 1);
      }
      vtm.a(localStFeedBusiReqData.pushList, paramQCirclePushUpdateEvent.mAllPushTimes);
      localStFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
      if (localStFeed.opMask2.get().contains(Integer.valueOf(8)))
      {
        i = localStFeedBusiReqData.pushList.totalClickCount.get();
        a(localList, i, localStFeedBusiReqData.pushList.count.get(), a((FeedCloudMeta.StPushList)localStFeedBusiReqData.pushList.get()));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        continue;
        int i = 0;
      }
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    super.a(paramQCircleReportBean);
    if (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setReportBean(paramQCircleReportBean);
    }
    a(QCircleReportBean.isFeedDetailPage(a().getPageId()));
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
      f(paramObject);
      d(paramObject);
      a(paramObject);
      b(paramObject);
      c(paramObject);
      e(paramObject);
      if (paramInt == 0)
      {
        if (!uxp.a().a()) {
          break label123;
        }
        uxp.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      }
    }
    return;
    label123:
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 0;
    this.jdField_b_of_type_Boolean = paramBoolean;
    Object localObject;
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
      if (paramBoolean)
      {
        i = 8;
        ((RecyclerView)localObject).setVisibility(i);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label100;
        }
        i = 8;
        label53:
        ((TextView)localObject).setVisibility(i);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView;
        if (!paramBoolean) {
          break label105;
        }
      }
    }
    label100:
    label105:
    for (int i = j;; i = 8)
    {
      ((QCircleCommentListView)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      i = 0;
      break label53;
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
      a(null, null);
      continue;
      if ((!c()) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Uzb != null))
      {
        vrc.a(10, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        Object localObject = new uzc();
        ((uzc)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
        ((uzc)localObject).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
        this.jdField_a_of_type_Uzb.a("comment_panel_show", (uzc)localObject);
        continue;
        if ((this.jdField_a_of_type_Uzb != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
        {
          localObject = new vca();
          ((vca)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          ((vca)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          ((vca)localObject).b = 4;
          this.jdField_a_of_type_Uzb.a((vca)localObject);
          continue;
          if (a() != null) {
            a().a();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzl
 * JD-Core Version:    0.7.0.1
 */