package com.tencent.mobileqq.minigame.jsapi.manager;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.jsapi.callbacks.PluginResultCallback;
import com.tencent.mobileqq.minigame.jsapi.widgets.KeyboardLayout;
import com.tencent.mobileqq.minigame.utils.GameLog;
import org.json.JSONException;
import org.json.JSONObject;

class KeyboardHandler$2
  implements TextView.OnEditorActionListener
{
  KeyboardHandler$2(KeyboardHandler paramKeyboardHandler, EditText paramEditText, PluginResultCallback paramPluginResultCallback, KeyboardLayout paramKeyboardLayout, Context paramContext) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    try
    {
      paramTextView = this.val$currentET.getText().toString();
      paramKeyEvent = new JSONObject();
      paramKeyEvent.put("value", paramTextView);
      this.val$pluginResultCallback.subscribeCallback("onKeyboardConfirm", paramKeyEvent.toString());
      if (this.val$keyboardLayout.getVisibility() != 8) {
        this.val$keyboardLayout.setVisibility(8);
      }
      this.this$0.hideSoftInput(this.val$context, this.val$currentET);
      this.val$pluginResultCallback.subscribeCallback("onKeyboardComplete", paramKeyEvent.toString());
      if ((this.val$context instanceof Activity)) {
        DisplayUtil.setActivityFullScreen((Activity)this.val$context);
      }
    }
    catch (JSONException paramTextView)
    {
      for (;;)
      {
        GameLog.getInstance().e("KeyboardHandler", "onEditorAction callback exception", paramTextView);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler.2
 * JD-Core Version:    0.7.0.1
 */