import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter.2;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.component.extendsadapter.ComponentRvInnerView;
import com.tencent.biz.subscribe.widget.commodity.CommodityItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class wks
  extends wpp
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  
  public wks(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private FrameLayout a()
  {
    FrameLayout localFrameLayout = a(null);
    Object localObject = (FrameLayout.LayoutParams)localFrameLayout.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = -1;
    ((FrameLayout.LayoutParams)localObject).height = -2;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = ImmersiveUtils.a(30.0F);
    ((FrameLayout.LayoutParams)localObject).topMargin = ImmersiveUtils.a(20.0F);
    ((FrameLayout.LayoutParams)localObject).leftMargin = ImmersiveUtils.a(16.0F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = ImmersiveUtils.a(16.0F);
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(a());
    ((ImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(-1, ImmersiveUtils.a(1.0F)));
    ((ImageView)localObject).setBackgroundColor(Color.parseColor("#D8D8D8"));
    localFrameLayout.addView((View)localObject);
    return localFrameLayout;
  }
  
  public int a()
  {
    return 3;
  }
  
  public wpq a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(paramViewGroup.getContext());
    paramViewGroup.setCurrentFeed(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    return new wpq(paramViewGroup);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject1 = paramStFeed.poster;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    Object localObject2;
    if ((((CertifiedAccountMeta.StUser)localObject1).youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)((CertifiedAccountMeta.StUser)localObject1).youZhan.get(0)).goodNum.get() > 0))
    {
      xhb.a(((CertifiedAccountMeta.StUser)localObject1).id.get(), "auth_" + wux.a(a()), "exp_shop", 0, 0, new String[0]);
      localObject2 = a();
      if (!wit.a(((CertifiedAccountMeta.StUser)localObject1).attr.get())) {
        break label241;
      }
    }
    label241:
    for (paramStFeed = ajya.a(2131702221);; paramStFeed = ((CertifiedAccountMeta.StUser)localObject1).nick.get())
    {
      paramStFeed = wow.a((Context)localObject2, 13.5F, "#878B99", String.format("%s的小店", new Object[] { paramStFeed }));
      paramStFeed.setMaxLines(1);
      paramStFeed.setMaxEms(10);
      paramStFeed.setEllipsize(TextUtils.TruncateAt.END);
      paramStFeed.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
      localObject2 = a().getResources().getDrawable(2130839016);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
      paramStFeed.setCompoundDrawables(null, null, (Drawable)localObject2, null);
      paramStFeed.setOnClickListener(new wkt(this, (CertifiedAccountMeta.StUser)localObject1));
      localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).gravity = 21;
      ((FrameLayout.LayoutParams)localObject1).rightMargin = ImmersiveUtils.a(14.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramStFeed, (ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = wow.a(a(), 16.0F, "#222222", ajya.a(2131701486));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    localLayoutParams.leftMargin = ImmersiveUtils.a(14.0F);
    paramBundle.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = a(paramBundle);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!bfmy.a(paramInt, b()))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(b().get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).setExtraTypeInfo(a());
    }
  }
  
  public void a(ComponentRvInnerView paramComponentRvInnerView)
  {
    if (((a().b(0) instanceof wku)) && (((wku)a().b(0)).a() != null)) {
      ((wku)a().b(0)).a().a(paramComponentRvInnerView);
    }
  }
  
  public void a(String paramString, wpf paramwpf)
  {
    super.a(paramString, paramwpf);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramwpf.a != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramwpf.a);
      a().post(new CommodityAdapter.2(this));
    }
  }
  
  public void a(wpk paramwpk) {}
  
  public int b()
  {
    return b().size();
  }
  
  public int getItemCount()
  {
    if (b().size() > 0) {
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
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateViewHolder(paramViewGroup, paramInt);
    case 100000: 
      return new woy(this, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    return new woy(this, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */