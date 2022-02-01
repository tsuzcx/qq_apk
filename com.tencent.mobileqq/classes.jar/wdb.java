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
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentListView;
import com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
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

public class wdb
  extends wcw
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout;
  private QCircleAvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView;
  private QCircleCommentListView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView;
  private QCirclePushAsyncTextView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private List<vba> jdField_a_of_type_JavaUtilList;
  private QQCircleFeedBase.StLikeBusiData jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData;
  private uzr jdField_a_of_type_Uzr;
  private boolean jdField_a_of_type_Boolean;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public wdb(Context paramContext)
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
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setOnClickHookListener(new wdd(this));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new wde(this));
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
    do
    {
      return;
      if (!vvw.a())
      {
        vvw.a(this.jdField_a_of_type_AndroidAppActivity, 2);
        return;
      }
    } while ((!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_Var == null));
    vas localvas = new vas();
    localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
    localvas.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
    localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = paramStComment;
    localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = paramStReply;
    localvas.jdField_a_of_type_JavaLangString = a().getModuleIdStr();
    if ((paramStComment == null) && (paramStReply == null)) {
      vtn.a(6, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
    }
    for (localvas.c = 6; (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView != null); localvas.c = 9)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView.a(localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, localvas.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
      return;
      vtn.a(9, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
    }
    this.jdField_a_of_type_Var.a("comment_input_window_show", localvas);
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
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.setData(localInvalidProtocolBufferMicroException, localArrayList2, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      aadv.a(this.jdField_b_of_type_AndroidWidgetTextView, false);
      if (paramStFeed.likeInfo.count.get() > 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(uzg.d(paramStFeed.likeInfo.count.get()));
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
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setBold(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setMaxNum(paramInt2);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.setOnClickItemListener(new wdf(this));
    String str = anzj.a(2131697218) + uzg.a(paramInt2, true) + anzj.a(2131697217);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView.getContext().getResources().getDrawable(2130844071);
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
          break label182;
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
        if (localStPolyLike.articleType.get() != 1)
        {
          if ((localStPolyLike.articleType.get() != 0) || (((QQCircleFeedBase.StPolyLike)paramList.get(i)).articleType.get() != 0)) {
            break label193;
          }
          break label187;
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
        label182:
        i = 0;
        continue;
      }
      label187:
      int j = 1;
      continue;
      label193:
      i += 1;
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131697207));
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
        if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
          paramStFeed = " · " + paramStFeed;
        }
        for (localMarginLayoutParams.leftMargin = vwt.a(-7.0F);; localMarginLayoutParams.leftMargin = vwt.a(12.0F))
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
      vqt.a().a(paramStFeed.id.get(), localStFeedBusiReqData.pushList);
      paramStFeed.busiData.set(ByteStringMicro.copyFrom(localStFeedBusiReqData.toByteArray()));
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
    if (this.jdField_a_of_type_Var != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setAniView(this.jdField_a_of_type_Var.a());
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
      if (uzg.a(paramStFeed.poster.id.get())) {
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
      localObject = new vas();
      ((vas)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
      ((vas)localObject).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
      ((vas)localObject).c = 6;
      ((vas)localObject).b = vas.d;
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
      ((List)localObject).add(new vba(paramStFeed, localStComment));
      Iterator localIterator2 = localStComment.vecReply.get().iterator();
      while (localIterator2.hasNext()) {
        ((List)localObject).add(new vba(paramStFeed, localStComment, (FeedCloudMeta.StReply)localIterator2.next()));
      }
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    if (this.jdField_a_of_type_Uzr == null)
    {
      this.jdField_a_of_type_Uzr = new uzr();
      this.jdField_a_of_type_Uzr.a(a());
    }
    if (paramStFeed.commentCount.get() > ((List)localObject).size())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidWidgetTextView.getResources().getString(2131697208, new Object[] { uzg.a(paramStFeed.commentCount.get(), true) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Uzr.a((List)localObject);
      this.jdField_a_of_type_Uzr.a(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView);
      this.jdField_a_of_type_Uzr.a(this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      this.jdField_a_of_type_Uzr.a(this.jdField_a_of_type_Var);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uzr);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public QCircleReportBean a()
  {
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
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373949));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374086);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373927));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373930));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373910));
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373923);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarListView = ((QCircleAvatarListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373922));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373921));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374085));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushAsyncTextView = ((QCirclePushAsyncTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380009));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380084));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381060);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373906));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentListView = ((QCircleCommentListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373903));
      paramViewStub = new wdc(this, this.jdField_a_of_type_AndroidViewView.getContext(), 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramViewStub);
      a();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setPageType(1);
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
      ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).vecComment.set(uzg.a(paramQCircleCommentUpdateEvent.comment.id.get(), (List)localObject));
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
      uyy.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(QCircleFeedCommentEllipseEvent paramQCircleFeedCommentEllipseEvent)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramQCircleFeedCommentEllipseEvent.mInfo == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null)) {}
    vba localvba;
    do
    {
      do
      {
        return;
        Iterator localIterator;
        while (!localIterator.hasNext()) {
          localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        }
        localvba = (vba)localIterator.next();
      } while ((localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null) || (!localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get())));
      if ((localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) && (localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) && (localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) && (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null))
      {
        b();
        return;
      }
    } while ((localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment == null) || (!localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.id.get())) || (localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply == null) || (!localvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get().equals(paramQCircleFeedCommentEllipseEvent.mInfo.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.id.get())));
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
      a(paramQCirclePolyPraiseUpdateEvent, localStFeed, localList);
      return;
      a(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike, localList);
      continue;
      b(paramQCirclePolyPraiseUpdateEvent.moldStPolyLike, localList);
    }
  }
  
  public void a(QCirclePolyPraiseUpdateEvent paramQCirclePolyPraiseUpdateEvent, FeedCloudMeta.StFeed paramStFeed, List<QQCircleFeedBase.StPolyLike> paramList)
  {
    this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.polyLikeInfo.set(paramList);
    if (paramQCirclePolyPraiseUpdateEvent.mPraisedStatus == 21) {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.rewardstatus.set(1);
    }
    if (!this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.likeIDs.get().contains(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike.polyLikeID.get())) {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.likeIDs.get().add(paramQCirclePolyPraiseUpdateEvent.mNewStPolyLike.polyLikeID.get());
    }
    paramStFeed.likeInfo.count.set(paramQCirclePolyPraiseUpdateEvent.mPraisedNum);
    paramStFeed.likeInfo.busiData.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StLikeBusiData.toByteArray()));
    this.jdField_a_of_type_JavaLangObject = paramStFeed;
    a(paramStFeed);
    c(paramStFeed);
  }
  
  public void a(QCirclePushUpdateEvent paramQCirclePushUpdateEvent)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    if ((paramQCirclePushUpdateEvent == null) || (!TextUtils.equals(localStFeed.id.get(), paramQCirclePushUpdateEvent.mTargetFeedId))) {
      return;
    }
    QLog.d("QCircleFeedItemBottomPresenter", 1, "updatePushUserList feedId" + paramQCirclePushUpdateEvent.mTargetFeedId + " allPushTimes:" + paramQCirclePushUpdateEvent.mAllPushTimes);
    paramQCirclePushUpdateEvent = new QQCircleFeedBase.StFeedBusiReqData();
    try
    {
      paramQCirclePushUpdateEvent.mergeFrom(localStFeed.busiData.get().toByteArray());
      vqt.a().a(localStFeed.id.get(), paramQCirclePushUpdateEvent.pushList);
      localStFeed.busiData.set(ByteStringMicro.copyFrom(paramQCirclePushUpdateEvent.toByteArray()));
      List localList = paramQCirclePushUpdateEvent.pushList.vecUser.get();
      if (localStFeed.opMask2.get().contains(Integer.valueOf(8)))
      {
        i = paramQCirclePushUpdateEvent.pushList.totalClickCount.get();
        a(localList, i, paramQCirclePushUpdateEvent.pushList.count.get(), a((FeedCloudMeta.StPushList)paramQCirclePushUpdateEvent.pushList.get()));
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
        if (!uyy.a().a()) {
          break label123;
        }
        uyy.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView);
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
      if ((!c()) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Var != null))
      {
        vtn.a(10, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        Object localObject = new vas();
        ((vas)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
        ((vas)localObject).jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
        this.jdField_a_of_type_Var.a("comment_panel_show", (vas)localObject);
        continue;
        if ((this.jdField_a_of_type_Var != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
        {
          localObject = new vdq();
          ((vdq)localObject).jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          ((vdq)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          ((vdq)localObject).b = 4;
          this.jdField_a_of_type_Var.a((vdq)localObject);
          continue;
          if (a() != null)
          {
            a().a();
            vtn.a(94, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdb
 * JD-Core Version:    0.7.0.1
 */