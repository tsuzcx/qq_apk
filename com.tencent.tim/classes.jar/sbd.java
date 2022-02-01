import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.SubscribeFollowInfoView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class sbd
  extends sat
  implements sgl
{
  private long CL;
  private SubscribeFollowInfoView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView;
  private RelativeMultiPicHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView;
  private View pG;
  
  public sbd(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private boolean Mv()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.getData() != null)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.getData();
      if ((localStFeed.id.get().equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.id.get())) && (localStFeed.title.get().equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.title.get())) && (localStFeed.createTime.get() == this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.createTime.get()) && (localStFeed.images.size() == this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.images.size())) {
        return true;
      }
    }
    return false;
  }
  
  private void f(CertifiedAccountMeta.StFeed paramStFeed)
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
    if ((getParentFragment() instanceof SubscribeMultiPicFragment)) {
      ((SubscribeMultiPicFragment)getParentFragment()).fr(System.currentTimeMillis());
    }
  }
  
  protected void G(long paramLong, String paramString)
  {
    super.G(paramLong, paramString);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(8);
    }
    if (this.pG != null) {
      this.pG.setVisibility(8);
    }
  }
  
  protected BaseWidgetView a(ViewGroup paramViewGroup, rxq paramrxq)
  {
    if ((getParentFragment() instanceof SubscribeMultiPicFragment))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView = new SubscribeFollowInfoView(getContext());
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setExtraTypeInfo(getExtraTypeInfo());
      paramrxq = new LinearLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(29.0F));
      paramrxq.leftMargin = ImmersiveUtils.dpToPx(9.0F);
      paramrxq.rightMargin = ImmersiveUtils.dpToPx(15.0F);
      paramrxq.gravity = 16;
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setLayoutParams(paramrxq);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(4);
      this.pG = ((SubscribeMultiPicFragment)getParentFragment()).aG();
      ((SubscribeMultiPicFragment)getParentFragment()).i().addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView = new RelativeMultiPicHeadItemView(paramViewGroup.getContext());
    if (this.jdField_a_of_type_Sgy != null) {
      this.jdField_a_of_type_Sgy.ed(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a());
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView;
  }
  
  protected void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean)
  {
    f((CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get());
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.getVisibility() == 8)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeFollowInfoView.setVisibility(0);
    }
    if ((this.pG != null) && (this.pG.getVisibility() == 8)) {
      this.pG.setVisibility(0);
    }
    if ((getParentRecyclerView() != null) && ((getParentRecyclerView().getLayoutManager() instanceof StaggeredGridLayoutManager))) {
      ((StaggeredGridLayoutManager)getParentRecyclerView().getLayoutManager()).scrollToPositionWithOffset(0, 0);
    }
  }
  
  protected View aC()
  {
    if ((getParentFragment() instanceof SubscribeMultiPicFragment)) {
      return ((SubscribeMultiPicFragment)getParentFragment()).aF();
    }
    return null;
  }
  
  public void bjg()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(0.0F);
    }
  }
  
  public void bjh()
  {
    QLog.d(TAG, 1, "onTransAnimateInit disableLoading!");
    bxJ();
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(0.0F);
    }
  }
  
  public void bji()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(1.0F);
    }
  }
  
  public void bjj()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a() != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.a().setAlpha(1.0F);
    }
  }
  
  public void e(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (System.currentTimeMillis() - this.CL < 500L) {}
    do
    {
      return;
      sqn.b(paramStFeed.poster.id.get(), "auth_" + siu.b(getExtraTypeInfo()), "clk_recom", 0, 0, new String[] { "", "", paramStFeed.id.get(), paramStFeed.title.get() });
      this.CL = System.currentTimeMillis();
      if (rzd.ff(paramStFeed.type.get()))
      {
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.l(paramStFeed);
        setShareData("share_key_subscribe_feeds_update", new rxn.b(paramStFeed, true));
        return;
      }
      rzd.a(getActivity(), paramStFeed);
    } while (getActivity() == null);
    getActivity().finish();
  }
  
  public void handleBlockChange(rxq paramrxq, int paramInt)
  {
    if ((paramrxq.getUniqueKey() != null) && ("RELATIVE_ADAPTER_UNIQUE_KEY".equals(paramrxq.getUniqueKey()))) {
      ((sbf)paramrxq).a(new sbe(this));
    }
  }
  
  public void loadData(rxt paramrxt) {}
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!Mv()) {
      f(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeMultiPicHeadItemView.destroy();
    }
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    super.onInitBlock(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbd
 * JD-Core Version:    0.7.0.1
 */