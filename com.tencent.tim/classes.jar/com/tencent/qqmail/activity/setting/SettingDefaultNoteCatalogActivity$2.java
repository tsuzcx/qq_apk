package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.movenote.AddNoteCatalogActivity;
import moai.oss.KvHelper;

class SettingDefaultNoteCatalogActivity$2
  implements View.OnClickListener
{
  SettingDefaultNoteCatalogActivity$2(SettingDefaultNoteCatalogActivity paramSettingDefaultNoteCatalogActivity) {}
  
  public void onClick(View paramView)
  {
    KvHelper.eventAddNoteCategoryFromSetting(new double[0]);
    Intent localIntent = AddNoteCatalogActivity.createIntent();
    this.this$0.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingDefaultNoteCatalogActivity.2
 * JD-Core Version:    0.7.0.1
 */