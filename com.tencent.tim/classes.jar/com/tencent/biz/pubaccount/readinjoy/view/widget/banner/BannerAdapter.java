package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import afyi;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.d;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.f;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kwz;
import kxm;
import muj;
import nsi;
import nsj;
import nsn;
import obs;
import rpq;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;
import tlb;
import wja;

public class BannerAdapter
  extends PagerAdapter
  implements RollViewPager.b, nsn
{
  public static int bcg;
  public static int bch = 1;
  private String TAG = "BannerAdapter";
  private TopBannerInfo a;
  private HashSet<Integer> aa = new HashSet();
  private View[] m;
  private final Activity mActivity;
  private int mType;
  
  public BannerAdapter(Activity paramActivity, RollViewPager paramRollViewPager, int paramInt)
  {
    this.mActivity = paramActivity;
    paramRollViewPager.setOnUserFling(this);
    this.mType = paramInt;
  }
  
  private View a(Activity paramActivity, TopBannerInfo.b paramb, View paramView)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramActivity).inflate(2131560174, null);
    }
    paramView = (KanDianUrlRoundCornerImageView)localView.findViewById(2131369560);
    int i = rpq.dip2px(paramActivity, 3.0F);
    paramView.setCorner(i);
    TextView localTextView1 = (TextView)localView.findViewById(2131380958);
    TextView localTextView2 = (TextView)localView.findViewById(2131380976);
    localTextView2.setText(paramb.title);
    if (TextUtils.isEmpty(paramb.title))
    {
      localTextView2.setVisibility(8);
      if ((!TextUtils.isEmpty(paramb.aiz)) && (!TextUtils.isEmpty(paramb.aiy)))
      {
        localTextView1.setText(paramb.aiz);
        localTextView1.setBackgroundDrawable(afyi.a(Utils.parseColor(paramb.aiy), i, 0.0F, i, 0.0F));
      }
      if (this.mType != bch) {
        break label198;
      }
    }
    for (;;)
    {
      try
      {
        kwz.a(paramView, new URL(paramb.imgUrl), paramActivity);
        localView.setTag(paramb);
        return localView;
        localTextView2.setVisibility(0);
      }
      catch (MalformedURLException paramActivity)
      {
        paramActivity.printStackTrace();
        continue;
      }
      label198:
      kwz.a(paramView, obs.a(fb(paramb.imgUrl), 3), paramActivity);
    }
  }
  
  public void baD()
  {
    if (this.m == null) {}
    label61:
    for (;;)
    {
      return;
      View[] arrayOfView = this.m;
      int j = arrayOfView.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label61;
        }
        View localView = arrayOfView[i];
        if (localView == null) {
          break;
        }
        TopBannerInfo.b localb = (TopBannerInfo.b)localView.getTag();
        a(this.mActivity, localb, localView);
        i += 1;
      }
    }
  }
  
  public void baE()
  {
    if (this.mType == bcg) {
      nsj.c("0X8009555", this.a.mChannelId, ju(), false);
    }
  }
  
  public void clearCache()
  {
    this.aa.clear();
  }
  
  public void d(TopBannerInfo paramTopBannerInfo)
  {
    if (this.a == paramTopBannerInfo) {
      return;
    }
    this.a = paramTopBannerInfo;
    if (this.mType == bcg)
    {
      paramTopBannerInfo = paramTopBannerInfo.items.iterator();
      do
      {
        if (!paramTopBannerInfo.hasNext()) {
          break;
        }
      } while (!((TopBannerInfo.b)paramTopBannerInfo.next()).isAD);
    }
    for (boolean bool = true;; bool = false)
    {
      nsj.c("0X8009553", this.a.mChannelId, ju(), bool);
      this.m = new View[getCount()];
      clearCache();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    QLog.d(this.TAG, 2, "destroyItem position : " + paramInt + " object: " + paramObject);
    paramViewGroup.removeView((View)paramObject);
    if (paramInt < this.m.length) {
      this.m[paramInt] = null;
    }
  }
  
  public String fb(String paramString)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = localResources.getDisplayMetrics().widthPixels - wja.dp2px(30.0F, localResources);
    return kxm.c(paramString, i, (int)(i * 0.424242D));
  }
  
  public View getChildAt(int paramInt)
  {
    if (paramInt < this.m.length) {
      return this.m[paramInt];
    }
    return null;
  }
  
  public int getCount()
  {
    int i = ju();
    if (i <= 1) {
      return i;
    }
    return i + 2;
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (TopBannerInfo.b)((View)paramObject).getTag();
    int i = this.a.items.indexOf(paramObject);
    if (i >= 0) {
      return i;
    }
    return -2;
  }
  
  public int getRealPosition(int paramInt)
  {
    int j = 0;
    int k = ju();
    int i = j;
    if (k > 1)
    {
      if (paramInt != 0) {
        break label27;
      }
      i = k - 1;
    }
    label27:
    do
    {
      return i;
      i = j;
    } while (paramInt == k + 1);
    return paramInt - 1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    QLog.d(this.TAG, 2, "instantiateItem " + paramViewGroup + "  " + paramInt);
    int i = ju();
    Object localObject;
    if ((this.mActivity == null) || (i == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "instantiateItem activity is null or data list count is 0");
      }
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      if ((i > 1) && ((paramInt == 1) || (paramInt == i))) {
        if (paramViewGroup == null)
        {
          if (this.m[paramInt] != null) {
            return this.m[paramInt];
          }
        }
        else
        {
          if ((this.m[paramInt] == null) || (this.m[paramInt].getParent() != null)) {
            this.m[paramInt] = ((View)instantiateItem(null, paramInt));
          }
          paramViewGroup.addView(this.m[paramInt]);
          return this.m[paramInt];
        }
      }
      i = getRealPosition(paramInt);
      localObject = (TopBannerInfo.b)this.a.items.get(i);
      localView = a(this.mActivity, (TopBannerInfo.b)localObject, null);
      this.m[paramInt] = localView;
      QLog.d(this.TAG, 2, "childs " + paramInt);
      localView.setOnClickListener(new nsi(this, i));
      localObject = localView;
    } while (paramViewGroup == null);
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public int ju()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.items.size();
  }
  
  public void rr(int paramInt)
  {
    QLog.d(this.TAG, 1, "onItemClick : " + this.a.items.get(paramInt));
    TopBannerInfo.b localb = (TopBannerInfo.b)this.a.items.get(paramInt);
    Object localObject;
    switch (localb.type)
    {
    default: 
      localObject = (TopBannerInfo.d)localb;
      kxm.aJ(this.mActivity, ((TopBannerInfo.d)localObject).jumpUrl);
      if (this.mType == bcg) {
        nsj.a("0X8009556", paramInt, this.a.mChannelId, ju(), localb);
      }
      break;
    }
    for (;;)
    {
      if ((localb.isAD) && (localb.adClickReports != null) && (localb.adClickReports.size() > 0))
      {
        localObject = new qq_ad_get.QQAdGetRsp.AdInfo();
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.trace_info.aid.set(localb.id);
        ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).report_info.thirdparty_monitor_urls.api_click_monitor_url.set(localb.getUrls(localb.adClickReports));
        tlb.a(1, 1, (qq_ad_get.QQAdGetRsp.AdInfo)localObject);
      }
      return;
      localObject = (TopBannerInfo.f)localb;
      muj.a(this.mActivity, null, 19, ((TopBannerInfo.f)localObject).rowKey, ((TopBannerInfo.f)localObject).aDs, ((TopBannerInfo.f)localObject).vid, ((TopBannerInfo.f)localObject).videoWidth, ((TopBannerInfo.f)localObject).videoHeight, ((TopBannerInfo.f)localObject).aTh, ((TopBannerInfo.f)localObject).aiB, "", ((TopBannerInfo.f)localObject).shareUrl, ((TopBannerInfo.f)localObject).accountName, "" + ((TopBannerInfo.f)localObject).vT, 0L, ((TopBannerInfo.f)localObject).DE(), ((TopBannerInfo.f)localObject).feedsId, ((TopBannerInfo.f)localObject).feedsType, null, null, null, null, null);
      break;
      if (this.mType == bch) {
        nsj.a("0X8009B91", ju(), localb);
      }
    }
  }
  
  public void ue(int paramInt)
  {
    TopBannerInfo.b localb;
    if (!this.aa.contains(Integer.valueOf(paramInt)))
    {
      this.aa.add(Integer.valueOf(paramInt));
      localb = (TopBannerInfo.b)this.a.items.get(paramInt);
      if (this.mType != bcg) {
        break label151;
      }
      nsj.a("0X8009554", paramInt, this.a.mChannelId, ju(), localb);
    }
    for (;;)
    {
      if ((localb.isAD) && (localb.adExposureReports != null) && (localb.adExposureReports.size() > 0))
      {
        qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        localAdInfo.report_info.trace_info.aid.set(localb.id);
        localAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(localb.getUrls(localb.adExposureReports));
        tlb.a(0, 1, localAdInfo);
      }
      return;
      label151:
      if (this.mType == bch) {
        nsj.a("0X8009B90", ju(), localb);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */