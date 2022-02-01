package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.widget.AuthDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseJsPluginEngine$8
  implements View.OnClickListener
{
  BaseJsPluginEngine$8(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onClick(View paramView)
  {
    this.this$0.authDialog.setRefuse(true);
    this.this$0.authDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.8
 * JD-Core Version:    0.7.0.1
 */