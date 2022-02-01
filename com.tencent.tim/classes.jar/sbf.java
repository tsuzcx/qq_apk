import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.network.GetSubscribeFeedListRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView.a;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class sbf
  extends sbc
  implements RelativeAdFeedItemView.a, rwx
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private sbf.a jdField_a_of_type_Sbf$a;
  private boolean aKL = true;
  private boolean aKS = true;
  private boolean avA;
  private int bwc = ImmersiveUtils.dpToPx(4.0F);
  private int bwd = ImmersiveUtils.dpToPx(16.0F);
  private int bwe = ImmersiveUtils.dpToPx(13.0F);
  private int bwf = ImmersiveUtils.dpToPx(3.0F);
  private int bwg;
  private int bwh = -1;
  
  public sbf(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  @NotNull
  private FrameLayout a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new TextView(paramViewGroup.getContext());
    FrameLayout localFrameLayout = getCommonHeaderFooterWrapper(paramViewGroup);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    paramViewGroup.setLayoutParams(localLayoutParams);
    paramViewGroup.setTextSize(1, 16.0F);
    paramViewGroup.setMaxLines(1);
    paramViewGroup.setTextColor(Color.parseColor("#222222"));
    paramViewGroup.getPaint().setFakeBoldText(true);
    localLayoutParams.leftMargin = ImmersiveUtils.dpToPx(16.0F);
    localLayoutParams.rightMargin = ImmersiveUtils.dpToPx(16.0F);
    paramViewGroup.setText(acfp.m(2131703559));
    return localFrameLayout;
  }
  
  private void h(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    sqn.c(paramStFeed.poster.id.get(), "auth_follow", "press", 0, 0, new String[0]);
    shk.b(getContext(), paramStFeed.poster.id.get(), new sbh(this, paramStFeed));
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, sgs.b paramb, sgs.a parama)
  {
    if (paramStFeed == null) {
      return;
    }
    sgs.a(getContext(), paramStFeed, paramb, parama);
  }
  
  public void a(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    this.bwg = -1;
    reloadFakeFeeds();
    getLoadInfo().setFinish(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    getLoadInfo().sQ(paramString);
    setDatas((ArrayList)paramList);
    notifyLoadingComplete(true);
  }
  
  public void a(sbf.a parama)
  {
    this.jdField_a_of_type_Sbf$a = parama;
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    a(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void b(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean, String paramString)
  {
    getLoadInfo().setFinish(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    getLoadInfo().sQ(paramString);
    if ((paramList != null) && (paramList.size() > 0)) {
      addAll(paramList);
    }
    notifyLoadingComplete(true);
  }
  
  public CertifiedAccountMeta.StFeed c()
  {
    if ((getDataList() == null) || (getDataList().size() == 0)) {
      return null;
    }
    int i = this.bwg + 1;
    while (i < getDataList().size())
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
      if ((localStFeed != null) && (rzd.fe(localStFeed.type.get())))
      {
        this.bwg = i;
        return localStFeed;
      }
      i += 1;
    }
    return null;
  }
  
  public void c(List<CertifiedAccountMeta.StFeed> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    b(paramList, paramStCommonExt, paramBoolean, null);
  }
  
  public void g(CertifiedAccountMeta.StFeed paramStFeed)
  {
    d(paramStFeed);
  }
  
  public int getItemCount()
  {
    int i;
    if (!this.mHasInitialized) {
      i = 4;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = this.mDataList.size();
        i = j;
      } while (j <= 0);
      i = j;
    } while (!this.aKL);
    return j + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRecyclerView = (StaggeredGridLayoutManager.LayoutParams)paramView.getLayoutParams();
    int i = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    if ((this.aKL) && ((i == 0) || (i == 1)))
    {
      paramRect.bottom = this.bwe;
      return;
    }
    if (paramRecyclerView.getSpanIndex() % 2 == 0) {
      paramRect.left = this.bwc;
    }
    for (paramRect.right = (this.bwf / 2);; paramRect.right = this.bwc)
    {
      paramRect.bottom = this.bwd;
      return;
      paramRect.left = (this.bwf / 2);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = paramInt;
    if (this.aKL) {
      i = paramInt - 1;
    }
    if (i == -1) {
      return 100000;
    }
    if ((!auqt.b(i, getDataList())) && (((CertifiedAccountMeta.StFeed)getDataList().get(i)).type.get() == 4)) {
      return 1;
    }
    return 100002;
  }
  
  public int getSpanCount(int paramInt)
  {
    if (getItemViewType(paramInt) == 100000) {
      return 1;
    }
    return 2;
  }
  
  public String getUniqueKey()
  {
    return "RELATIVE_ADAPTER_UNIQUE_KEY";
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void handleShareDataChange(String paramString, rxn.b paramb)
  {
    super.handleShareDataChange(paramString, paramb);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramb.by != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramb.by);
      if (paramb.aKs) {
        onRefreshData();
      }
    }
  }
  
  public void i(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((getDataList() == null) || (getDataList().size() == 0) || (this.bwg > getDataList().size())) {
      return;
    }
    int i = this.bwg;
    while (i >= 0)
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
      if ((localStFeed != null) && (rzd.fe(localStFeed.type.get())) && (localStFeed.id.get().equals(paramStFeed.id.get())))
      {
        this.bwg = i;
        return;
      }
      i -= 1;
    }
    this.bwg = -1;
  }
  
  public void loadData(rxt paramrxt)
  {
    GetSubscribeFeedListRequest localGetSubscribeFeedListRequest = null;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed, 1, getLoadInfo().c(), getLoadInfo().nn());
    }
    if (this.bwh != -1) {
      localGetSubscribeFeedListRequest = new GetSubscribeFeedListRequest(this.bwh, getLoadInfo().c(), getLoadInfo().nn());
    }
    if (localGetSubscribeFeedListRequest == null) {
      return;
    }
    VSNetworkHelper.a().a(localGetSubscribeFeedListRequest, new sbg(this, paramrxt));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramInt;
    if (this.aKL) {
      i = paramInt - 1;
    }
    if (auqt.b(i, getDataList())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, i, getItemId(i));
      return;
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)getDataList().get(i);
      ((sbf.b)paramViewHolder).a(localStFeed, getExtraTypeInfo());
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new sbf.b(a(paramViewGroup));
    }
    if (paramInt == 1) {
      return new sbf.b(new RelativeAdFeedItemView(paramViewGroup.getContext(), this));
    }
    return new sbf.b(new RelativeFeedItemView(paramViewGroup.getContext()));
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    getParentRecyclerView().addOnScrollListener(new sbi(this));
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public void uv(boolean paramBoolean)
  {
    this.aKL = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void ym(int paramInt)
  {
    this.bwh = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, CertifiedAccountMeta.StFeed paramStFeed);
  }
  
  public class b
    extends RecyclerView.ViewHolder
  {
    public b(View paramView)
    {
      super();
    }
    
    private boolean b(CertifiedAccountMeta.StFeed paramStFeed)
    {
      if ((this.itemView instanceof BaseWidgetView))
      {
        CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((BaseWidgetView)this.itemView).getData();
        if ((localStFeed != null) && (paramStFeed != null) && (!TextUtils.isEmpty(localStFeed.id.get())) && (!TextUtils.isEmpty(localStFeed.id.get()))) {
          return (localStFeed.id.get().equals(paramStFeed.id.get())) && (localStFeed.likeInfo.count.get() == paramStFeed.likeInfo.count.get());
        }
      }
      return false;
    }
    
    public void a(CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
    {
      if (b(paramStFeed)) {
        return;
      }
      if ((this.itemView instanceof RelativeFeedItemView))
      {
        ((RelativeFeedItemView)this.itemView).setIsInNightMode(sbf.a(sbf.this));
        ((RelativeFeedItemView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
        ((RelativeFeedItemView)this.itemView).setData(paramStFeed);
        ((RelativeFeedItemView)this.itemView).setDataPosInList(getAdapterPosition());
      }
      for (;;)
      {
        if (sbf.a(sbf.this) != null) {
          this.itemView.setOnClickListener(new sbj(this, paramStFeed));
        }
        this.itemView.setOnLongClickListener(new sbk(this, paramExtraTypeInfo, paramStFeed));
        return;
        if ((this.itemView instanceof RelativeAdFeedItemView))
        {
          ((RelativeAdFeedItemView)this.itemView).setIsInNightMode(sbf.a(sbf.this));
          ((RelativeAdFeedItemView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
          ((RelativeAdFeedItemView)this.itemView).setData(paramStFeed);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbf
 * JD-Core Version:    0.7.0.1
 */