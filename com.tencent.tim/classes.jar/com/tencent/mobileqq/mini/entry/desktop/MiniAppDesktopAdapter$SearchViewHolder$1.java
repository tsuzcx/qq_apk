package com.tencent.mobileqq.mini.entry.desktop;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$SearchViewHolder$1
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$SearchViewHolder$1(MiniAppDesktopAdapter.SearchViewHolder paramSearchViewHolder, WeakReference paramWeakReference) {}
  
  public void onClick(View paramView)
  {
    int i;
    Object localObject;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "SearchUseNative", 1) == 1)
    {
      i = 1;
      if (i == 0) {
        break label252;
      }
      localObject = new Intent();
      if ((MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0) != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo.firstPage != null))
      {
        String str = Uri.decode(MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo.firstPage.pagePath);
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject).putExtra("recommend_word", Uri.parse(str).getQueryParameter("w"));
        }
      }
      PublicFragmentActivity.start((Context)this.val$activity.get(), (Intent)localObject, MiniAppSearchFragment.class);
    }
    for (;;)
    {
      localObject = acfp.m(2131708371);
      if (MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).getText() != null) {
        localObject = MiniAppDesktopAdapter.SearchViewHolder.access$2900(this.this$0).getText().toString();
      }
      MiniProgramLpReportDC04239.reportAsync("desktop", "search", "click_search", (String)localObject);
      if ((MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0) != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo != null) && (MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo.tianshuAdId > 0)) {
        MiniAppUtils.miniAppTianShuReport("tianshu.78", "tianshu.78", String.valueOf(MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo.tianshuAdId), 102);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label252:
      if ((MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0) == null) || (MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo == null)) {
        QLog.e("MiniAppDesktopAdapter", 1, "click search bar searchInfo is null");
      }
      localObject = new LaunchParam();
      ((LaunchParam)localObject).scene = 3006;
      try
      {
        MiniAppController.launchMiniAppByAppInfo((Activity)this.val$activity.get(), MiniAppDesktopAdapter.SearchViewHolder.access$2800(this.this$0).mAppInfo, (LaunchParam)localObject);
      }
      catch (Exception localException)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "click search bar exception: " + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.SearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */