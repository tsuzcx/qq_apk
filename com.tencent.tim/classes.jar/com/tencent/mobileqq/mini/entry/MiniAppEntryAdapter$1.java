package com.tencent.mobileqq.mini.entry;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniAppEntryAdapter$1
  implements View.OnClickListener
{
  MiniAppEntryAdapter$1(MiniAppEntryAdapter paramMiniAppEntryAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppEntryAdapter", 2, "onClick. obj = " + localObject);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    localObject = ((MiniAppEntryAdapter.MicroAppViewHolder)((RecyclerView)paramView.getParent()).getChildViewHolder(paramView)).miniAppInfo;
    int i;
    if (MiniAppEntryAdapter.access$000(this.this$0) == 0) {
      i = 1001;
    }
    for (;;)
    {
      try
      {
        QLog.i("MiniAppEntryAdapter", 1, "--- click appid:" + ((MiniAppInfo)localObject).appId);
        MiniAppController.launchMiniAppByAppInfo(MiniAppEntryAdapter.access$100(this.this$0), (MiniAppInfo)localObject, i);
        int j = MiniAppEntryAdapter.access$200(this.this$0, ((MiniAppInfo)localObject).appId);
        localObject = new MiniAppConfig((MiniAppInfo)localObject);
        LaunchParam localLaunchParam = new LaunchParam();
        localLaunchParam.scene = i;
        ((MiniAppConfig)localObject).launchParam = localLaunchParam;
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "page_view", "click_scene", null, String.valueOf(j));
      }
      catch (MiniAppException localMiniAppException)
      {
        localMiniAppException.printStackTrace();
      }
      break;
      if (MiniAppEntryAdapter.access$000(this.this$0) == 1) {
        i = 2006;
      } else if (MiniAppEntryAdapter.access$000(this.this$0) == 2) {
        i = 2007;
      } else {
        i = 1001;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.1
 * JD-Core Version:    0.7.0.1
 */