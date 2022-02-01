package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BannerAdapter
  extends BannerView.BannerViewAdapter<DiscoveryBannerInfo, LinearLayout>
  implements View.OnClickListener
{
  private static final String TAG = BannerAdapter.class.getSimpleName();
  private a a;
  private int aWE;
  private int aWF;
  private Context mContext;
  
  private void a(LinearLayout paramLinearLayout, int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    if ((paramDiscoveryBannerInfo == null) || (paramLinearLayout == null)) {}
    do
    {
      Object localObject;
      do
      {
        return;
        paramLinearLayout = (KandianUrlImageView)paramLinearLayout.findViewById(2131365956);
        localObject = paramLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.aWE;
        ((ViewGroup.LayoutParams)localObject).height = this.aWF;
        paramLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramLinearLayout.setTag(paramDiscoveryBannerInfo);
        paramLinearLayout.setOnClickListener(this);
        try
        {
          localObject = new ColorDrawable(Color.parseColor("#E8E8E7"));
          if (TextUtils.isEmpty(paramDiscoveryBannerInfo.coverUrl)) {
            break;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = this.aWE;
          localURLDrawableOptions.mRequestHeight = this.aWF;
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
          paramLinearLayout.setImageDrawable(URLDrawable.getDrawable(paramDiscoveryBannerInfo.coverUrl, localURLDrawableOptions));
          return;
        }
        catch (Exception paramLinearLayout) {}
      } while (!QLog.isColorLevel());
      QLog.d(TAG, 2, "轮播图的url格式有问题, " + paramDiscoveryBannerInfo.toString() + ", " + paramLinearLayout.getMessage());
      return;
      paramLinearLayout.setImageDrawable((Drawable)localObject);
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "banner cover url is null, banner info: " + paramDiscoveryBannerInfo.toString());
  }
  
  public LinearLayout a(int paramInt, DiscoveryBannerInfo paramDiscoveryBannerInfo)
  {
    LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(this.mContext).inflate(2131560509, null);
    a(localLinearLayout, paramInt, paramDiscoveryBannerInfo);
    return localLinearLayout;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = paramView.getTag();
      if ((localObject != null) && ((localObject instanceof DiscoveryBannerInfo)) && (this.a != null)) {
        this.a.a(paramView, (DiscoveryBannerInfo)localObject);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, DiscoveryBannerInfo paramDiscoveryBannerInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */