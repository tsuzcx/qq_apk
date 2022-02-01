package com.tencent.qqmini.sdk.plugins.engine;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.widget.AuthDialog;

class BaseJsPluginEngine$10
  implements View.OnClickListener
{
  BaseJsPluginEngine$10(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.authDialog != null)
    {
      this.this$0.authDialog.setRefuse(true);
      this.this$0.authDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.10
 * JD-Core Version:    0.7.0.1
 */