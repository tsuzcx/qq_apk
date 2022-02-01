import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter.2;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class sar
  extends ryg
{
  private FrameLayout aK;
  private CertifiedAccountMeta.StFeed mFeed;
  
  public sar(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private FrameLayout f()
  {
    FrameLayout localFrameLayout = getCommonHeaderFooterWrapper(null);
    Object localObject = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = -1;
    ((FrameLayout.LayoutParams)localObject).height = -2;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = ImmersiveUtils.dpToPx(30.0F);
    ((FrameLayout.LayoutParams)localObject).topMargin = ImmersiveUtils.dpToPx(20.0F);
    ((FrameLayout.LayoutParams)localObject).leftMargin = ImmersiveUtils.dpToPx(16.0F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = ImmersiveUtils.dpToPx(16.0F);
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(getContext());
    ((ImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(1.0F)));
    ((ImageView)localObject).setBackgroundColor(Color.parseColor("#D8D8D8"));
    localFrameLayout.addView((View)localObject);
    return localFrameLayout;
  }
  
  public ryg.a a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(paramViewGroup.getContext());
    paramViewGroup.setCurrentFeed(this.mFeed);
    return new ryg.a(paramViewGroup);
  }
  
  public void a(HorizontalRvInnerView paramHorizontalRvInnerView)
  {
    if (((getBlockMerger().a(0) instanceof sat)) && (((sat)getBlockMerger().a(0)).a() != null)) {
      ((sat)getBlockMerger().a(0)).a().ed(paramHorizontalRvInnerView);
    }
  }
  
  public void e(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!auqt.b(paramInt, getDataList()))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(getDataList().get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).setExtraTypeInfo(getExtraTypeInfo());
    }
  }
  
  public int getItemCount()
  {
    if (getDataList().size() > 0) {
      return 3;
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 100001;
    case 0: 
      return 100000;
    }
    return 100002;
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
      this.mFeed = ((CertifiedAccountMeta.StFeed)paramb.by);
      if (getMainHandler() != null) {
        getMainHandler().post(new CommodityAdapter.2(this));
      }
    }
  }
  
  public void loadData(rxt paramrxt) {}
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    case 100000: 
      return new rxs.a(this, this.aK);
    }
    return new rxs.a(this, f());
  }
  
  public void onInitBlock(Bundle paramBundle)
  {
    paramBundle = rxm.a(getContext(), 16.0F, "#222222", acfp.m(2131703537));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    localLayoutParams.leftMargin = ImmersiveUtils.dpToPx(14.0F);
    paramBundle.setLayoutParams(localLayoutParams);
    this.aK = getCommonHeaderFooterWrapper(paramBundle);
  }
  
  public void setShopData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject2 = paramStFeed.poster;
    this.mFeed = paramStFeed;
    LinearLayout localLinearLayout;
    sas localsas;
    Object localObject1;
    if ((((CertifiedAccountMeta.StUser)localObject2).youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)((CertifiedAccountMeta.StUser)localObject2).youZhan.get(0)).goodNum.get() > 0))
    {
      paramStFeed = new FrameLayout.LayoutParams(-2, -2);
      paramStFeed.gravity = 21;
      paramStFeed.rightMargin = ImmersiveUtils.dpToPx(14.0F);
      localLinearLayout = new LinearLayout(getContext());
      localLinearLayout.setOrientation(0);
      this.aK.addView(localLinearLayout, paramStFeed);
      localsas = new sas(this, (CertifiedAccountMeta.StUser)localObject2);
      sqn.b(((CertifiedAccountMeta.StUser)localObject2).id.get(), "auth_" + siu.b(getExtraTypeInfo()), "exp_shop", 0, 0, new String[0]);
      localObject1 = getActivity();
      if (!rze.bg(((CertifiedAccountMeta.StUser)localObject2).attr.get())) {
        break label346;
      }
    }
    label346:
    for (paramStFeed = acfp.m(2131704216);; paramStFeed = ((CertifiedAccountMeta.StUser)localObject2).nick.get())
    {
      paramStFeed = rxm.a((Context)localObject1, 13.5F, "#878B99", String.format("%s", new Object[] { paramStFeed }));
      paramStFeed.setMaxLines(1);
      paramStFeed.setMaxWidth(ImmersiveUtils.dpToPx(150.0F));
      paramStFeed.setGravity(5);
      paramStFeed.setEllipsize(TextUtils.TruncateAt.END);
      paramStFeed.setOnClickListener(localsas);
      localLinearLayout.addView(paramStFeed, new LinearLayout.LayoutParams(-2, -2));
      paramStFeed = rxm.a(getActivity(), 13.5F, "#878B99", "的小店");
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      paramStFeed.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(2.0F));
      localObject2 = getActivity().getResources().getDrawable(2130839512);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
      paramStFeed.setCompoundDrawables(null, null, (Drawable)localObject2, null);
      paramStFeed.setOnClickListener(localsas);
      localLinearLayout.addView(paramStFeed, (ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public int ug()
  {
    return getDataList().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sar
 * JD-Core Version:    0.7.0.1
 */