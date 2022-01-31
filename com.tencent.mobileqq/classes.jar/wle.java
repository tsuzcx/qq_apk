import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class wle
  extends wku
  implements wrz
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeMultiPicHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView;
  
  public wle(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a();
      if ((localStFeed.id.get().equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())) && (localStFeed.title.get().equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get())) && (localStFeed.createTime.get() == this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.createTime.get()) && (localStFeed.images.size() == this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.images.size())) {
        return true;
      }
    }
    return false;
  }
  
  private void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.setData(paramStFeed);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setData(paramStFeed);
      if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.getVisibility() == 4) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(0);
      }
    }
    if ((a() instanceof SubscribeMultiPicFragment)) {
      ((SubscribeMultiPicFragment)a()).a(System.currentTimeMillis());
    }
  }
  
  protected View a()
  {
    if ((a() instanceof SubscribeMultiPicFragment)) {
      return ((SubscribeMultiPicFragment)a()).b();
    }
    return null;
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, woz paramwoz)
  {
    if ((a() instanceof SubscribeMultiPicFragment))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = new SubscribeFollowInfoView(a());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(a());
      paramwoz = new LinearLayout.LayoutParams(-1, ImmersiveUtils.a(29.0F));
      paramwoz.leftMargin = ImmersiveUtils.a(9.0F);
      paramwoz.rightMargin = ImmersiveUtils.a(15.0F);
      paramwoz.gravity = 16;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setLayoutParams(paramwoz);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(4);
      this.jdField_a_of_type_AndroidViewView = ((SubscribeMultiPicFragment)a()).c();
      ((SubscribeMultiPicFragment)a()).a().addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView = new RelativeMultiPicHeadItemView(paramViewGroup.getContext());
    if (this.jdField_a_of_type_Wso != null) {
      this.jdField_a_of_type_Wso.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a());
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView;
  }
  
  protected void a(long paramLong, String paramString)
  {
    super.a(paramLong, paramString);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    e((CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get());
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.getVisibility() == 8)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if ((a() != null) && ((a().getLayoutManager() instanceof StaggeredGridLayoutManager))) {
      ((StaggeredGridLayoutManager)a().getLayoutManager()).scrollToPositionWithOffset(0, 0);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void a(woz paramwoz, int paramInt)
  {
    if ((paramwoz.a() != null) && ("RELATIVE_ADAPTER_UNIQUE_KEY".equals(paramwoz.a()))) {
      ((wlg)paramwoz).a(new wlf(this));
    }
  }
  
  public void a(wpk paramwpk) {}
  
  public void d(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {}
    do
    {
      return;
      xhb.a(paramStFeed.poster.id.get(), "auth_" + wux.a(a()), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (wis.b(paramStFeed.type.get()))
      {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramStFeed);
        b("share_key_subscribe_feeds_update", new wpf(paramStFeed, true));
        return;
      }
      wis.a(a(), paramStFeed);
    } while (a() == null);
    a().finish();
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(0.0F);
    }
  }
  
  public void l()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onTransAnimateInit disableLoading!");
    b();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(0.0F);
    }
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(1.0F);
    }
  }
  
  public void n()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(1.0F);
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!d()) {
      e(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wle
 * JD-Core Version:    0.7.0.1
 */