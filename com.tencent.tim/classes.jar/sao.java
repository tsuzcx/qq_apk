import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_COMM.COMM.StCommonExt;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.SubscribeGetFollowRcmdRequest;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class sao
  extends rxq<CertifiedAccountMeta.StFollowRcmd>
{
  public static String TAG = "BlankRecommendFeedsAdapter";
  public static int bvY = ImmersiveUtils.dpToPx(12.0F);
  private boolean aKL = true;
  private boolean aKM = true;
  private boolean avA;
  private int bvZ = ImmersiveUtils.dpToPx(20.0F);
  private int bwa = ImmersiveUtils.dpToPx(12.5F);
  private boolean mIsFirstRequest = true;
  private boolean yy;
  
  public sao(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(List<CertifiedAccountMeta.StFollowRcmd> paramList, COMM.StCommonExt paramStCommonExt, boolean paramBoolean)
  {
    getLoadInfo().setFinish(paramBoolean);
    getLoadInfo().a(paramStCommonExt);
    if ((paramList != null) && (paramList.size() > 0)) {
      setDatas((ArrayList)paramList);
    }
    notifyLoadingComplete(true);
  }
  
  private View h(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(getContext()).inflate(2131558831, paramViewGroup, false);
    URLImageView localURLImageView = (URLImageView)paramViewGroup.findViewById(2131369876);
    if (localURLImageView != null) {
      localURLImageView.setImageURL("https://qzonestyle.gtimg.cn/aoi/sola/20191225193654_3xBYY4zCcy.png");
    }
    if (this.avA)
    {
      localURLImageView.setColorFilter(-1728053248);
      ((TextView)paramViewGroup.findViewById(2131381047)).setTextColor(-10132123);
      paramViewGroup.findViewById(2131365997).setBackgroundColor(-14540254);
      return paramViewGroup;
    }
    localURLImageView.clearColorFilter();
    return paramViewGroup;
  }
  
  private View i(ViewGroup paramViewGroup)
  {
    sqn.d("auth_follow", "exp_more", 0, 0, new String[0]);
    paramViewGroup = LayoutInflater.from(getContext()).inflate(2131558830, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)paramViewGroup.findViewById(2131370719);
    GradientDrawable localGradientDrawable;
    if (localLinearLayout != null)
    {
      localGradientDrawable = (GradientDrawable)localLinearLayout.getBackground();
      if (!this.avA) {
        break label102;
      }
    }
    label102:
    for (int i = -13224394;; i = -460552)
    {
      localGradientDrawable.setColor(i);
      localLinearLayout.setOnClickListener(new saq(this));
      if (this.avA) {
        ((TextView)paramViewGroup.findViewById(2131381046)).setTextColor(-5723992);
      }
      return paramViewGroup;
    }
  }
  
  public void a(sao.a parama)
  {
    if (getBlockMerger() != null)
    {
      this.yy = false;
      SubscribeGetFollowRcmdRequest localSubscribeGetFollowRcmdRequest = new SubscribeGetFollowRcmdRequest(null);
      localSubscribeGetFollowRcmdRequest.setEnableCache(true);
      VSNetworkHelper.a().a(localSubscribeGetFollowRcmdRequest, new sap(this, localSubscribeGetFollowRcmdRequest, parama));
    }
  }
  
  public COMM.StCommonExt b()
  {
    if (getLoadInfo().b() != null) {
      return getLoadInfo().b();
    }
    return null;
  }
  
  public void clearData()
  {
    super.clearData();
    this.yy = false;
  }
  
  public int getItemCount()
  {
    int j = this.mDataList.size();
    if (!this.yy)
    {
      if (j > 0)
      {
        int i = j;
        if (this.aKL) {
          i = j + 1;
        }
        j = i;
        if (this.aKM) {
          j = i + 1;
        }
        return j;
      }
      return 0;
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  protected void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    if ((paramView instanceof BlankRecommendItemView))
    {
      paramRect.top = this.bvZ;
      paramRect.left = bvY;
      paramRect.right = bvY;
      paramRect.bottom = this.bwa;
    }
    while (paramView.getId() != 2131377562) {
      return;
    }
    paramRect.top = ImmersiveUtils.dpToPx(19.5F);
    paramRect.left = 0;
    paramRect.right = 0;
    paramRect.bottom = (-ImmersiveUtils.dpToPx(30.0F));
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
    if (!auqt.b(i, getDataList())) {
      return 100002;
    }
    return 100001;
  }
  
  public int getSpanCount(int paramInt)
  {
    return 1;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean isEnableRefresh()
  {
    return false;
  }
  
  public void loadData(rxt paramrxt) {}
  
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
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)getDataList().get(i);
      ((sao.b)paramViewHolder).a(localStFollowRcmd, i);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 100000) {
      return new sao.b(h(paramViewGroup));
    }
    if (paramInt == 100001) {
      return new sao.b(i(paramViewGroup));
    }
    paramViewGroup = new BlankRecommendItemView(paramViewGroup.getContext());
    paramViewGroup.setIsInNightMode(this.avA);
    return new sao.b(paramViewGroup);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
  }
  
  public void onInitBlock(Bundle paramBundle) {}
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void onError();
  }
  
  class b
    extends RecyclerView.ViewHolder
  {
    public b(View paramView)
    {
      super();
    }
    
    public void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd, int paramInt)
    {
      if ((this.itemView instanceof BlankRecommendItemView))
      {
        ((BlankRecommendItemView)this.itemView).setData(paramStFollowRcmd);
        ((BlankRecommendItemView)this.itemView).setExtraTypeInfo(sao.this.getExtraTypeInfo());
        ((BlankRecommendItemView)this.itemView).setPos(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sao
 * JD-Core Version:    0.7.0.1
 */