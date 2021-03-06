package com.tencent.mobileqq.minigame.jsapi.manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.jsapi.callbacks.PluginResultCallback;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

class KeyboardHandler$3
  implements View.OnClickListener
{
  KeyboardHandler$3(KeyboardHandler paramKeyboardHandler, EditText paramEditText, PluginResultCallback paramPluginResultCallback, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    try
    {
      String str = this.val$currentET.getText().toString();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", str);
      this.val$pluginResultCallback.subscribeCallback("onKeyboardConfirm", localJSONObject.toString());
      if (!this.val$keyboardLayout.isConfirmHold())
      {
        if (this.val$keyboardLayout.getVisibility() != 8) {
          this.val$keyboardLayout.setVisibility(8);
        }
        this.this$0.hideSoftInput(this.val$context, this.val$currentET);
      }
      this.val$pluginResultCallback.subscribeCallback("onKeyboardComplete", localJSONObject.toString());
      if ((this.val$context instanceof Activity)) {
        DisplayUtil.setActivityFullScreen((Activity)this.val$context);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        GameLog.getInstance().e("KeyboardHandler", "confirm button click callback exception", localJSONException);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler.3
 * JD-Core Version:    0.7.0.1
 */