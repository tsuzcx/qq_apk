package com.tencent.qqmini.minigame.plugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class CustomButtonPlugin$1
  implements View.OnClickListener
{
  CustomButtonPlugin$1(CustomButtonPlugin paramCustomButtonPlugin, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    CustomButtonPlugin.access$000(this.this$0, this.val$jsonObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.CustomButtonPlugin.1
 * JD-Core Version:    0.7.0.1
 */