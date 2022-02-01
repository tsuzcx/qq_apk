package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import jtw;
import juh;
import jzs;
import jzs.a;
import wja;

public class AccountDetailBannerViewWrapper
  extends juh
{
  public AccountDetailBannerViewWrapper(Context paramContext, ArrayList<jzs.a> paramArrayList, jtw paramjtw, String paramString1, String paramString2)
  {
    super(paramContext, paramArrayList, paramjtw, paramString1, paramString2);
  }
  
  public static View a(Context paramContext, View paramView, ViewGroup paramViewGroup, jzs paramjzs, int paramInt, jtw paramjtw, String paramString1, String paramString2)
  {
    paramViewGroup = a(paramjzs, paramInt);
    if (paramViewGroup.isEmpty())
    {
      paramContext = paramView;
      if (QLog.isDevelopLevel())
      {
        QLog.d("AccountDetailBannerViewWrapper", 2, "createView return convertView!");
        paramContext = paramView;
      }
    }
    do
    {
      return paramContext;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break;
      }
      paramView = (RelativeLayout)paramView;
      paramjzs = paramView.getTag();
      if ((paramjzs == null) || (!(paramjzs instanceof AccountDetailBannerViewWrapper)) || (!((AccountDetailBannerViewWrapper)paramjzs).q(paramViewGroup))) {
        break;
      }
      paramContext = paramView;
    } while (!QLog.isDevelopLevel());
    QLog.d("AccountDetailBannerViewWrapper", 2, "createView reuse!");
    return paramView;
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBannerViewWrapper", 2, "createView new create!");
    }
    paramContext = new AccountDetailBannerViewWrapper(paramContext, paramViewGroup, paramjtw, paramString1, paramString2);
    paramView = paramContext.c();
    paramView.setTag(paramContext);
    return paramView;
  }
  
  private RelativeLayout c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBannerViewWrapper", 2, "buildView!");
    }
    Resources localResources = this.mContext.getResources();
    int i = wja.dp2px(160.0F, localResources);
    int j = wja.dp2px(20.0F, localResources);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, i + j));
    localRelativeLayout.setPadding(0, j, 0, 0);
    AccountDetailBannerViewPager localAccountDetailBannerViewPager = new AccountDetailBannerViewPager(this.mContext);
    localAccountDetailBannerViewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localRelativeLayout.addView(localAccountDetailBannerViewPager);
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jt.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(g((jzs.a)((Iterator)localObject).next()));
    }
    localObject = new ViewPagerAdapter();
    ((ViewPagerAdapter)localObject).setData(localArrayList);
    localAccountDetailBannerViewPager.setAdapter((PagerAdapter)localObject);
    localObject = new AccountDetailBannerIndicator(this.mContext, localArrayList.size());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14, -1);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.setMargins(0, 0, 0, wja.dp2px(10.0F, localResources));
    ((AccountDetailBannerIndicator)localObject).setLayoutParams(localLayoutParams);
    localRelativeLayout.addView((View)localObject);
    localAccountDetailBannerViewPager.setIndicator((AccountDetailBannerIndicator)localObject);
    localAccountDetailBannerViewPager.setCurrentItem(1073741823 - 1073741823 % localArrayList.size());
    localRelativeLayout.setClickable(false);
    localRelativeLayout.setOnClickListener(null);
    return localRelativeLayout;
  }
  
  private View g(jzs.a parama)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    URLImageView localURLImageView = new URLImageView(this.mContext);
    localURLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localURLImageView.setBackgroundDrawable(URLDrawable.getDrawable(parama.pic_url, null, null, true));
    localURLImageView.setImageDrawable(new ColorDrawable(Color.parseColor("#33000000")));
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRelativeLayout.addView(localURLImageView);
    localRelativeLayout.setTag(parama);
    localRelativeLayout.setOnClickListener(this.x);
    return localRelativeLayout;
  }
  
  public static class ViewPagerAdapter
    extends PagerAdapter
  {
    protected ArrayList<View> js = new ArrayList();
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {}
    
    public int getCount()
    {
      if (this.js.size() <= 1) {
        return this.js.size();
      }
      return 2147483647;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      int j = this.js.size();
      if (j > 1) {}
      for (int i = paramInt % j;; i = paramInt)
      {
        if (paramInt < 0) {
          i += j;
        }
        for (;;)
        {
          paramViewGroup.removeView((View)this.js.get(i));
          paramViewGroup.addView((View)this.js.get(i));
          if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBannerViewWrapper", 2, "instantiateItem->pos:" + paramInt + ", newPos:" + i);
          }
          return this.js.get(i);
        }
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == (View)paramObject;
    }
    
    public void setData(ArrayList<View> paramArrayList)
    {
      this.js = paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewWrapper
 * JD-Core Version:    0.7.0.1
 */