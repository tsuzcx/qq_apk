import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.11;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.12;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.events.QCircleAtUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean.QCircleActionBean;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.utils.QCircleSlidBottomView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class vbr
  extends vbm
  implements aaam, aakb, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aabg<QCircleReportBean> jdField_a_of_type_Aabg;
  private aakf jdField_a_of_type_Aakf;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleBlockContainer jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCirclePolyLikeFrameLayout jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout;
  private QCircleSlidBottomView jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView;
  private QCircleRecommendImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView;
  private QCircleRocketView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private FeedCloudMeta.StComment jdField_a_of_type_FeedcloudFeedCloudMeta$StComment;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private FeedCloudMeta.StReply jdField_a_of_type_FeedcloudFeedCloudMeta$StReply;
  private List<FeedCloudMeta.StComment> jdField_a_of_type_JavaUtilList;
  private uzl jdField_a_of_type_Uzl;
  private vas jdField_a_of_type_Vas;
  private vwd jdField_a_of_type_Vwd;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  private int a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null)) {
      return -1;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildCount())
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildAt(i);
      if ((localObject instanceof QCircleCommentItemView))
      {
        localObject = (QCircleCommentItemView)localObject;
        if ((((QCircleCommentItemView)localObject).a() != null) && (((QCircleCommentItemView)localObject).a().id.get().equals(paramString)))
        {
          paramString = ((QCircleCommentItemView)localObject).a();
          if (paramString == null) {
            break;
          }
          return paramString.getHeight();
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private QCircleInitBean a()
  {
    return (QCircleInitBean)((Activity)a()).getIntent().getSerializableExtra("key_bundle_common_init_bean");
  }
  
  private FeedCloudMeta.StFeed a()
  {
    if ((this.jdField_a_of_type_Vas == null) || (this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed == null)) {
      return new FeedCloudMeta.StFeed();
    }
    return this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  }
  
  private vjy a()
  {
    return vjy.a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setReportListener(new vbs(this));
    aaak.a().a(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(FeedCloudMeta.StUser paramStUser)
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setUser(paramStUser);
    localQCircleInitBean.setFromReportBean(a().clone().setElementIdStr("portrait"));
    uyx.b(a(), localQCircleInitBean);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a().a(a().hashCode(), 0, a(), true, false);
      QLog.d("QCircleCommentPanelPart", 1, "requestCommentList  loadMore  feedId : " + a().id.get());
      return;
    }
    if (a() != null)
    {
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = a();
      a().a(a().hashCode(), a(), localStBusiInfoCommentListData);
      QLog.d("QCircleCommentPanelPart", 1, "requestCommentList  refresh(have BusiInfo) feedId : " + a().id.get());
      return;
    }
    a().a(a().hashCode(), 0, a(), false, false);
    QLog.d("QCircleCommentPanelPart", 1, "requestCommentList  refresh  feedId : " + a().id.get());
  }
  
  private boolean a(FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    if (!vvw.a())
    {
      vvw.a(a(), 2);
      return false;
    }
    paramStReply = new vba(a(), paramStComment, paramStReply);
    this.jdField_a_of_type_Vwd = new vbt(this, paramStComment);
    vvz.a().a(a(), paramStReply, this.jdField_a_of_type_Vwd, b());
    return true;
  }
  
  private void b()
  {
    vbx localvbx = new vbx(this);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setOnClickListener(localvbx);
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.setStatusListener(new vby(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localvbx);
  }
  
  private void b(int paramInt)
  {
    if (b())
    {
      vtr.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, a());
      return;
    }
    vtn.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo, b());
  }
  
  private void b(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView != null)
      {
        if (!uzg.a(paramStFeed.poster.id.get())) {
          break label75;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setFeedData(paramStFeed, 3);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView.setFeedId(paramStFeed.id.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView.setPageType(3);
      }
      return;
      label75:
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView.setVisibility(0);
    }
  }
  
  private boolean b()
  {
    return QCircleReportBean.isContentDetailPage(b());
  }
  
  private String c()
  {
    String str2 = a().id.get();
    String str1 = str2;
    if (a() != null) {
      str1 = str2 + a().comment.id.get() + a().reply.id.get();
    }
    return str1;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setAniView(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView);
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setOnClickHookListener(new vbz(this));
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setReportBean(this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setReportBeanAgent(this.jdField_a_of_type_Aabg);
    }
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setModuleIdStr("commentlist_like");
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (paramInt > 0)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(uzg.d(paramInt));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().a(1);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setEnableRefresh(false);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setParentFragment(a());
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setNestedScrollingEnabled(true);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setPadding(ImmersiveUtils.a(17.0F), 0, 0, 0);
    paramView = new ArrayList();
    this.jdField_a_of_type_Uzl = new uzl(null);
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      this.jdField_a_of_type_Uzl.a(this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      this.jdField_a_of_type_Uzl.a(this.jdField_a_of_type_Aabg);
    }
    paramView.add(this.jdField_a_of_type_Uzl);
    this.jdField_a_of_type_Uzl.setOnLoadDataDelegate(new vbv(this));
    this.jdField_a_of_type_Uzl.addOnScrollListener(new vbw(this));
    this.jdField_a_of_type_Uzl.a(this);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().setItemAnimator(new zzl());
    ((SimpleItemAnimator)this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getItemAnimator()).setSupportsChangeAnimations(false);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a(paramView);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.c();
  }
  
  private void d()
  {
    Object localObject = a();
    if ((localObject != null) && (((QCircleInitBean)localObject).getActionBean() != null) && (((QCircleInitBean)localObject).getActionBean().mShowInputKeyboard) && (!this.jdField_a_of_type_Boolean))
    {
      localObject = a();
      if ((localObject != null) && (a(((QQCircleFeedBase.StBusiInfoCommentListData)localObject).comment, ((QQCircleFeedBase.StBusiInfoCommentListData)localObject).reply))) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildCount() <= 0)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildAt(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().getChildCount() - 1);
    } while ((localView == null) || (!(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().findContainingViewHolder(localView) instanceof aabz)));
    localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), paramInt);
    QLog.i("QCircleCommentPanelPart", 1, "changeMarginToFooterHolder   paddingTop: " + paramInt);
  }
  
  private void d(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView != null) && (this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.c();
      ThreadManager.getUIHandler().postDelayed(new QCircleCommentPanelPart.11(this, paramView), 1500L);
      return;
    }
    e(paramView);
  }
  
  private void e()
  {
    String str = c();
    this.jdField_a_of_type_JavaUtilList = a().a(str);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = a().vecComment.get();
      if (this.jdField_a_of_type_Uzl != null) {
        this.jdField_a_of_type_Uzl.a(a(), this.jdField_a_of_type_JavaUtilList);
      }
      QLog.d("QCircleCommentPanelPart", 1, "refreshPanelView commentBusiness no commentList  commentList.size : " + this.jdField_a_of_type_JavaUtilList.size());
    }
    for (;;)
    {
      c(a().a(a().id.get()));
      f();
      return;
      QLog.d("QCircleCommentPanelPart", 1, "refreshPanelView use commentBusiness commentList  commentList.size : " + this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_Uzl != null) {
        this.jdField_a_of_type_Uzl.a(a(), this.jdField_a_of_type_JavaUtilList);
      }
    }
  }
  
  private void e(View paramView)
  {
    if (paramView == null) {}
    int[] arrayOfInt;
    int i;
    do
    {
      return;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      arrayOfInt[1] += paramView.getHeight();
      i = vvz.a().a();
    } while ((arrayOfInt[1] <= i) || (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().scrollBy(0, arrayOfInt[1] - i);
    QLog.i("QCircleCommentPanelPart", 1, "scrollItemToVisble  scrollBy: " + (arrayOfInt[1] - i));
    d(arrayOfInt[1] - i);
    ThreadManager.getUIHandler().postDelayed(new QCircleCommentPanelPart.12(this, paramView, arrayOfInt, i), 1L);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    do
    {
      TextView localTextView;
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer != null) {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setVisibility(0);
        }
        localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131371445);
      } while ((localTextView == null) || (this.jdField_a_of_type_Uzl == null) || (this.jdField_a_of_type_Uzl.getItemCount() != 0));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localTextView.setText(2131693261);
    } while (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer == null);
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setVisibility(8);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Aakf = new aakf(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_Aakf.a(new vbu(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Aakf != null)
    {
      this.jdField_a_of_type_Aakf.a();
      this.jdField_a_of_type_Aakf = null;
    }
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getParentPageId("QCircleCommentPanelPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean).clone().setModuleIdStr(b());
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getReportBean("QCircleCommentPanelPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean()).clone().setModuleIdStr(b());
    }
    return new QCircleReportBean();
  }
  
  public String a()
  {
    return "QCircleCommentPanelPart";
  }
  
  public QQCircleFeedBase.StBusiInfoCommentListData a()
  {
    try
    {
      QCircleInitBean localQCircleInitBean = a();
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      localStBusiInfoCommentListData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStBusiInfoCommentListData.setHasFlag(true);
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment = ((FeedCloudMeta.StComment)localStBusiInfoCommentListData.comment.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply = ((FeedCloudMeta.StReply)localStBusiInfoCommentListData.reply.get());
      return localStBusiInfoCommentListData;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleCommentPanelPart", 1, "getInfoError");
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (37858 == paramInt1) {
      aaak.a().a(new QCircleAtUpdateEvent(paramIntent));
    }
  }
  
  public void a(aabg<QCircleReportBean> paramaabg)
  {
    this.jdField_a_of_type_Aabg = paramaabg;
  }
  
  protected void a(View paramView)
  {
    b(paramView);
    a();
    c();
    b();
    c(paramView);
    g();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    QLog.d("QCircleCommentPanelPart", 1, "onClick, pageId: " + b() + "  parentPageId: " + a());
    switch (paramInt1)
    {
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 12: 
    default: 
    case 2: 
    case 1: 
    case 4: 
    case 13: 
    case 7: 
    case 10: 
    case 11: 
      do
      {
        do
        {
          return;
          if ((paramObject instanceof FeedCloudMeta.StUser))
          {
            QLog.d("QCircleCommentPanelPart", 1, "onClick nickName, feedId: " + a().id.get() + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
            a((FeedCloudMeta.StUser)paramObject);
          }
          b(15);
          return;
          if ((paramObject instanceof FeedCloudMeta.StUser))
          {
            QLog.d("QCircleCommentPanelPart", 1, "onClick avatar, feedId: " + a().id.get() + " userId: " + ((FeedCloudMeta.StUser)paramObject).id.get());
            a((FeedCloudMeta.StUser)paramObject);
          }
          b(14);
          return;
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramObject = (FeedCloudMeta.StComment)paramObject;
            QLog.d("QCircleCommentPanelPart", 1, "onClick comment, feedId: " + a().id.get() + " commentId: " + paramObject.id.get());
            if (a(paramObject, null)) {
              d(paramView);
            }
          }
          b(11);
          this.jdField_a_of_type_Int = 11;
          return;
          if ((paramObject instanceof FeedCloudMeta.StComment))
          {
            paramObject = (FeedCloudMeta.StComment)paramObject;
            QLog.d("QCircleCommentPanelPart", 1, "onClick replyTextButton, feedId: " + a().id.get() + " commentId: " + paramObject.id.get());
            if (a(paramObject, null)) {
              d(paramView);
            }
          }
          b(13);
          this.jdField_a_of_type_Int = 13;
          return;
          if ((paramObject instanceof Object[]))
          {
            localObject = (Object[])paramObject;
            if ((localObject.length > 1) && (localObject[0] != null) && (localObject[1] != null) && ((localObject[0] instanceof FeedCloudMeta.StComment)) && ((localObject[1] instanceof FeedCloudMeta.StReply)))
            {
              paramObject = (FeedCloudMeta.StComment)localObject[0];
              localObject = (FeedCloudMeta.StReply)localObject[1];
              QLog.d("QCircleCommentPanelPart", 1, "onClick reply, feedId: " + a().id.get() + " commentId: " + paramObject.id.get() + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
              if (a(paramObject, (FeedCloudMeta.StReply)localObject)) {
                d(paramView);
              }
            }
          }
          b(12);
          this.jdField_a_of_type_Int = 12;
          return;
          if ((paramObject instanceof Object[]))
          {
            paramObject = (Object[])paramObject;
            if ((paramObject.length > 1) && ((paramObject[0] instanceof FeedCloudMeta.StComment)) && ((paramObject[1] instanceof Integer)))
            {
              paramView = (FeedCloudMeta.StComment)paramObject[0];
              paramObject = (Integer)paramObject[1];
              this.jdField_a_of_type_Uzl.a(paramInt2, paramObject.intValue());
              QLog.d("QCircleCommentPanelPart", 1, "onClick more reply, feedId: " + a().id.get() + " commentId: " + paramView.id.get());
            }
          }
          b(52);
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while ((paramObject.length <= 1) || (!(paramObject[0] instanceof FeedCloudMeta.StComment)) || (!(paramObject[1] instanceof Integer)));
      paramView = (FeedCloudMeta.StComment)paramObject[0];
      paramObject = (Integer)paramObject[1];
      this.jdField_a_of_type_Uzl.b(paramInt2, paramObject.intValue());
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().scrollToPosition(paramInt2);
      QLog.d("QCircleCommentPanelPart", 1, "onClick less reply, feedId: " + a().id.get() + " commentId: " + paramView.id.get());
      return;
    case 14: 
      b(50);
      localObject = "";
      if ((paramObject instanceof FeedCloudMeta.StComment)) {
        paramView = ((FeedCloudMeta.StComment)paramObject).postUser.id.get();
      }
      for (;;)
      {
        vud.a().a(new vuf().a("likecommentbutton").b("likecomment").a(this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(c()).c(paramView));
        return;
        paramView = (View)localObject;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          paramView = (View)localObject;
          if (paramObject.length > 1)
          {
            paramView = (View)localObject;
            if (paramObject[1] != null)
            {
              paramView = (View)localObject;
              if ((paramObject[1] instanceof FeedCloudMeta.StReply)) {
                paramView = ((FeedCloudMeta.StReply)paramObject[1]).postUser.id.get();
              }
            }
          }
        }
      }
    }
    b(51);
    Object localObject = "";
    if ((paramObject instanceof FeedCloudMeta.StComment)) {
      paramView = ((FeedCloudMeta.StComment)paramObject).postUser.id.get();
    }
    for (;;)
    {
      vud.a().a(new vuf().a("likecommentbutton").b("unlikecomment").a(this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(c()).c(paramView));
      return;
      paramView = (View)localObject;
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        paramView = (View)localObject;
        if (paramObject.length > 1)
        {
          paramView = (View)localObject;
          if (paramObject[1] != null)
          {
            paramView = (View)localObject;
            if ((paramObject[1] instanceof FeedCloudMeta.StReply)) {
              paramView = ((FeedCloudMeta.StReply)paramObject[1]).postUser.id.get();
            }
          }
        }
      }
    }
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
    if ((this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null) && ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo instanceof ReportExtraTypeInfo))) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setExtraTypeInfo((ReportExtraTypeInfo)this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      a().a(paramStFeed.id.get(), paramStFeed.commentCount.get());
    }
    if (this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout.setFeedData(a());
    }
    b(paramStFeed);
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("comment_panel_show"))
    {
      if ((paramObject instanceof vas))
      {
        this.jdField_a_of_type_Vas = ((vas)paramObject);
        this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().e();
        a(this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
        a(this.jdField_a_of_type_Vas.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
        if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null) && (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), a().id.get())) && (this.jdField_a_of_type_Uzl.getItemCount() > 0))
        {
          this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.a().scrollToPosition(0);
          this.jdField_a_of_type_Uzl.clearData();
        }
        a(false);
        e();
        a(this.jdField_a_of_type_Vas.c);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_a_of_type_Vas.b == vas.d) {
          this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.a();
        }
        this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.a(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = a();
      }
      aaak.a().a(new QCircleDanmakuEvent(7, true));
    }
    do
    {
      do
      {
        return;
        if (!paramString.equals("comment_panel_dismiss")) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0);
      this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.d();
      return;
    } while ((!paramString.equals("comment_input_window_show")) || (!(paramObject instanceof vas)));
    this.jdField_a_of_type_Vas = ((vas)paramObject);
    a(this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed);
    a(this.jdField_a_of_type_Vas.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    a(this.jdField_a_of_type_Vas.c);
    a(this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_Vas.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView.d();
      aaak.a().a(new QCircleDanmakuEvent(8, false));
      return true;
    }
    return super.a();
  }
  
  protected int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
    }
    if (this.jdField_a_of_type_Aabg != null) {
      return QCircleReportBean.getPageId("QCircleCommentPanelPart", (QCircleReportBean)this.jdField_a_of_type_Aabg.getReportBean());
    }
    return 0;
  }
  
  protected String b()
  {
    return "commentlist";
  }
  
  protected void b(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364846));
    this.jdField_a_of_type_ComTencentBizQqcircleUtilsQCircleSlidBottomView = ((QCircleSlidBottomView)paramView.findViewById(2131373907));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer = ((QCircleBlockContainer)paramView.findViewById(2131373905));
    this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.setPadding(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.getPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.getPaddingTop(), this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCircleBlockContainer.getPaddingRight(), ImmersiveUtils.a(27.0F));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373908));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373904));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364834));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378684));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeFrameLayout = ((QCirclePolyLikeFrameLayout)paramView.findViewById(2131369451));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369177));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendImageView = ((QCircleRecommendImageView)paramView.findViewById(2131369326));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRocketView = ((QCircleRocketView)paramView.findViewById(2131364845));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131374004));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364815));
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    QLog.d("QCircleCommentPanelPart", 1, "onLongClick, pageId: " + b() + "  parentPageId: " + a());
    vca localvca = new vca(this);
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof FeedCloudMeta.StComment));
        b(45);
        paramObject = (FeedCloudMeta.StComment)paramObject;
        QLog.d("QCircleCommentPanelPart", 1, "onLongClick comment, feedId: " + a().id.get() + " commentId: " + paramObject.id.get());
        uyy.a().a(paramView, a(), paramObject, new vcb(this, paramObject), localvca);
        return;
      } while (!(paramObject instanceof Object[]));
      localObject = (Object[])paramObject;
    } while ((localObject.length <= 1) || (localObject[0] == null) || (localObject[1] == null) || (!(localObject[0] instanceof FeedCloudMeta.StComment)) || (!(localObject[1] instanceof FeedCloudMeta.StReply)));
    paramObject = (FeedCloudMeta.StComment)localObject[0];
    Object localObject = (FeedCloudMeta.StReply)localObject[1];
    QLog.d("QCircleCommentPanelPart", 1, "onLongClick reply, feedId: " + a().id.get() + " commentId: " + paramObject.id.get() + " replyId: " + ((FeedCloudMeta.StReply)localObject).id.get());
    uyy.a().a(paramView, a(), (FeedCloudMeta.StReply)localObject, new vci(this, (FeedCloudMeta.StReply)localObject, paramObject), localvca);
  }
  
  protected int c()
  {
    if ((this.jdField_a_of_type_Vas != null) && (this.jdField_a_of_type_Vas.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null)) {
      return this.jdField_a_of_type_Vas.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.mDataPosition;
    }
    return 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    aaak.a().b(this);
    h();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QLog.d("QCircleCommentPanelPart", 1, "onClick, pageId: " + b() + "  parentPageId: " + a());
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
      b(60);
      this.jdField_a_of_type_Int = 60;
      QLog.d("QCircleCommentPanelPart", 1, "onClick text_input, feedId: " + a().id.get());
      continue;
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply);
      b(61);
      this.jdField_a_of_type_Int = 61;
      QLog.d("QCircleCommentPanelPart", 1, "onClick iv_comment, feedId: " + a().id.get());
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent))
    {
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      switch (paramSimpleBaseEvent.eventStatus)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                        } while (!paramSimpleBaseEvent.feedId.equals(c()));
                        if (paramSimpleBaseEvent.needShowCommentPanel) {
                          d();
                        }
                        e();
                      } while (this.jdField_a_of_type_Uzl == null);
                      paramSimpleBaseEvent = this.jdField_a_of_type_Uzl.getLoadInfo();
                      if (a().a(a().id.get()) == null) {
                        bool1 = true;
                      }
                      paramSimpleBaseEvent.a(bool1);
                      this.jdField_a_of_type_Uzl.notifyLoadingComplete(true);
                      return;
                    } while ((!paramSimpleBaseEvent.feedId.equals(c())) || (this.jdField_a_of_type_Uzl == null) || (paramSimpleBaseEvent.commentList == null));
                    this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.commentList);
                    paramSimpleBaseEvent = this.jdField_a_of_type_Uzl.getLoadInfo();
                    bool1 = bool2;
                    if (a().a(a().id.get()) == null) {
                      bool1 = true;
                    }
                    paramSimpleBaseEvent.a(bool1);
                    this.jdField_a_of_type_Uzl.notifyLoadingComplete(true);
                    return;
                  } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
                  if ((this.jdField_a_of_type_Uzl != null) && (paramSimpleBaseEvent.comment != null)) {
                    this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.fakeCommentId, paramSimpleBaseEvent.comment);
                  }
                  c(paramSimpleBaseEvent.commentTotalNum);
                  return;
                } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
                if ((this.jdField_a_of_type_Uzl != null) && (paramSimpleBaseEvent.comment != null)) {
                  this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.comment.id.get());
                }
                c(paramSimpleBaseEvent.commentTotalNum);
                f();
                return;
              } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
              if ((this.jdField_a_of_type_Uzl != null) && (paramSimpleBaseEvent.comment != null) && (paramSimpleBaseEvent.reply != null)) {
                this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.fakeReplyId, paramSimpleBaseEvent.reply);
              }
              c(paramSimpleBaseEvent.commentTotalNum);
              return;
            } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
            if ((this.jdField_a_of_type_Uzl != null) && (paramSimpleBaseEvent.comment != null) && (paramSimpleBaseEvent.reply != null)) {
              this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.reply.id.get());
            }
            c(paramSimpleBaseEvent.commentTotalNum);
            return;
          } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
          if ((this.jdField_a_of_type_Uzl != null) && (paramSimpleBaseEvent.comment != null)) {
            this.jdField_a_of_type_Uzl.c(paramSimpleBaseEvent.comment.id.get());
          }
          c(paramSimpleBaseEvent.commentTotalNum);
          return;
        } while (!paramSimpleBaseEvent.feedId.equals(a().id.get()));
        if ((this.jdField_a_of_type_Uzl != null) && (paramSimpleBaseEvent.comment != null)) {
          this.jdField_a_of_type_Uzl.b(paramSimpleBaseEvent.comment.id.get());
        }
        c(paramSimpleBaseEvent.commentTotalNum);
        return;
      } while ((!paramSimpleBaseEvent.feedId.equals(a().id.get())) || (this.jdField_a_of_type_Uzl == null));
      this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.comment.id.get());
      return;
    } while ((!paramSimpleBaseEvent.feedId.equals(a().id.get())) || (this.jdField_a_of_type_Uzl == null));
    this.jdField_a_of_type_Uzl.a(paramSimpleBaseEvent.comment.id.get(), paramSimpleBaseEvent.reply.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbr
 * JD-Core Version:    0.7.0.1
 */