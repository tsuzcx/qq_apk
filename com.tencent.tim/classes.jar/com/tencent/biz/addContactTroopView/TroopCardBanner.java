package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import anot;
import aqcx;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import jnz;
import tencent.im.troop_search_popclassifc.popclassifc.BannerCard;
import tencent.im.troop_search_popclassifc.popclassifc.BannerItem;
import tencent.im.troop_search_popclassifc.popclassifc.RspBody;
import tencent.im.troop_view.troopviewInfo.RspBody;

public class TroopCardBanner
  extends BaseTroopCardView
  implements View.OnClickListener
{
  protected popclassifc.BannerCard a;
  protected LinearLayout jdField_do;
  protected ImageView hh;
  protected ArrayList<ImageView> jj;
  protected ViewPager mViewPager;
  
  public TroopCardBanner(ContactBaseView.a parama)
  {
    super(parama);
  }
  
  private String hG()
  {
    try
    {
      Object localObject = (jnz)this.mApp.getManager(80);
      if ((localObject != null) && (((jnz)localObject).a() != null) && (((jnz)localObject).a().popRsb != null))
      {
        int i = ((jnz)localObject).a().popRsb.uint32_longitude.get();
        int j = ((jnz)localObject).a().popRsb.uint32_latitude.get();
        localObject = ((jnz)localObject).a().popRsb.str_city_id.get();
        localObject = "lon=" + String.valueOf(i) + "&lat=" + String.valueOf(j) + "&city=" + (String)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private void lt(boolean paramBoolean)
  {
    this.jdField_do.removeAllViews();
    this.jj = new ArrayList();
    this.hh = null;
    if (paramBoolean)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size())
      {
        ImageView localImageView = new ImageView(this.mApp.getApplication());
        int j = aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity(), 6.0F);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
        if (i != 0) {
          localLayoutParams.leftMargin = aqcx.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$a.getActivity(), 4.0F);
        }
        localImageView.setLayoutParams(localLayoutParams);
        if (i == 0)
        {
          this.hh = localImageView;
          localImageView.setImageResource(2130838099);
        }
        for (;;)
        {
          this.jj.add(localImageView);
          this.jdField_do.addView(localImageView);
          i += 1;
          break;
          localImageView.setImageResource(2130838100);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = (popclassifc.BannerItem)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.get(i);
      if (localObject1 != null)
      {
        localObject2 = ((popclassifc.BannerItem)localObject1).str_transfer_url.get();
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = hG();
          if (!((String)localObject2).contains("?")) {
            break label164;
          }
        }
      }
    }
    label164:
    for (Object localObject1 = (String)localObject2 + "&" + (String)localObject1;; localObject1 = (String)localObject2 + "?" + (String)localObject1)
    {
      localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.mContext.startActivity((Intent)localObject2);
      anot.a(this.mApp, "P_CliOper", "Grp_find", "", "grptab", "Clk_banner", 0, 0, "", String.valueOf(i), "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
  
  public void setData(popclassifc.BannerCard paramBannerCard)
  {
    boolean bool = true;
    this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard = paramBannerCard;
    if ((this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard != null) && (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() > 0)) {
      if (this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$BannerCard.rpt_banner_items.size() <= 1) {
        break label70;
      }
    }
    for (;;)
    {
      lt(bool);
      this.mViewPager.setAdapter(new CPagerAdapter());
      this.mViewPager.setCurrentItem(0);
      return;
      label70:
      bool = false;
    }
  }
  
  public class CPagerAdapter
    extends PagerAdapter
  {
    protected CPagerAdapter() {}
    
    public void destroyItem(View paramView, int paramInt, Object paramObject)
    {
      ((ViewGroup)paramView).removeView((View)paramObject);
    }
    
    public int getCount()
    {
      if ((TroopCardBanner.this.a != null) && (TroopCardBanner.this.a.rpt_banner_items.get().size() > 0))
      {
        if (1 == TroopCardBanner.this.a.rpt_banner_items.get().size()) {
          return 1;
        }
        return 2147483647;
      }
      return 0;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      paramInt %= TroopCardBanner.this.a.rpt_banner_items.size();
      ImageView localImageView = new ImageView(TroopCardBanner.this.mContext);
      localImageView.setImageDrawable(URLDrawable.getDrawable(((popclassifc.BannerItem)TroopCardBanner.this.a.rpt_banner_items.get(paramInt)).str_pic_url.get(), null));
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramViewGroup.addView(localImageView, -1, -1);
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setContentDescription("banner图片");
      localImageView.setOnClickListener(TroopCardBanner.this);
      return localImageView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardBanner
 * JD-Core Version:    0.7.0.1
 */