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
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

public class zsj
  extends zpl
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  
  public zsj(Bundle paramBundle)
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
  
  public zpm a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new CommodityItemView(paramViewGroup.getContext());
    paramViewGroup.setCurrentFeed(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
    return new zpm(paramViewGroup);
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    Object localObject2 = paramStFeed.poster;
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    LinearLayout localLinearLayout;
    zsk localzsk;
    Object localObject1;
    if ((((CertifiedAccountMeta.StUser)localObject2).youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)((CertifiedAccountMeta.StUser)localObject2).youZhan.get(0)).goodNum.get() > 0))
    {
      paramStFeed = new FrameLayout.LayoutParams(-2, -2);
      paramStFeed.gravity = 21;
      paramStFeed.rightMargin = ImmersiveUtils.a(14.0F);
      localLinearLayout = new LinearLayout(a());
      localLinearLayout.setOrientation(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localLinearLayout, paramStFeed);
      localzsk = new zsk(this, (CertifiedAccountMeta.StUser)localObject2);
      aanb.a(((CertifiedAccountMeta.StUser)localObject2).id.get(), "auth_" + aaba.a(a()), "exp_shop", 0, 0, new String[0]);
      localObject1 = a();
      if (!zqn.a(((CertifiedAccountMeta.StUser)localObject2).attr.get())) {
        break label337;
      }
    }
    label337:
    for (paramStFeed = anvx.a(2131701718);; paramStFeed = ((CertifiedAccountMeta.StUser)localObject2).nick.get())
    {
      paramStFeed = zom.a((Context)localObject1, 13.5F, "#878B99", String.format("%s", new Object[] { paramStFeed }));
      paramStFeed.setMaxLines(1);
      paramStFeed.setMaxWidth(ImmersiveUtils.a(150.0F));
      paramStFeed.setGravity(5);
      paramStFeed.setEllipsize(TextUtils.TruncateAt.END);
      paramStFeed.setOnClickListener(localzsk);
      localLinearLayout.addView(paramStFeed, new LinearLayout.LayoutParams(-2, -2));
      paramStFeed = zom.a(a(), 13.5F, "#878B99", "的小店");
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      paramStFeed.setCompoundDrawablePadding(ImmersiveUtils.a(2.0F));
      localObject2 = a().getResources().getDrawable(2130839337);
      ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
      paramStFeed.setCompoundDrawables(null, null, (Drawable)localObject2, null);
      paramStFeed.setOnClickListener(localzsk);
      localLinearLayout.addView(paramStFeed, (ViewGroup.LayoutParams)localObject1);
      return;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = zom.a(a(), 16.0F, "#222222", anvx.a(2131700984));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 3;
    localLayoutParams.leftMargin = ImmersiveUtils.a(14.0F);
    paramBundle.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = a(paramBundle);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!ArrayUtils.isOutOfArrayIndex(paramInt, a()))
    {
      ((CommodityItemView)paramViewHolder.itemView).setData(a().get(paramInt));
      ((CommodityItemView)paramViewHolder.itemView).setExtraTypeInfo(a());
    }
  }
  
  public void a(HorizontalRvInnerView paramHorizontalRvInnerView)
  {
    if (((a().a(0) instanceof zsl)) && (((zsl)a().a(0)).a() != null)) {
      ((zsl)a().a(0)).a().a(paramHorizontalRvInnerView);
    }
  }
  
  public void a(String paramString, zos paramzos)
  {
    super.a(paramString, paramzos);
    if ((paramString.equals("share_key_subscribe_feeds_update")) && (paramzos.a != null))
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)paramzos.a);
      if (a() != null) {
        a().post(new CommodityAdapter.2(this));
      }
    }
  }
  
  public void a(zoz paramzoz) {}
  
  public int c()
  {
    return a().size();
  }
  
  public int getItemCount()
  {
    if (a().size() > 0) {
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
      return new zoy(this, this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    return new zoy(this, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsj
 * JD-Core Version:    0.7.0.1
 */