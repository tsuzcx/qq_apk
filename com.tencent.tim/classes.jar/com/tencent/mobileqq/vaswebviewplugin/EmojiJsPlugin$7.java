package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import aqkf;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class EmojiJsPlugin$7
  implements DialogInterface.OnKeyListener
{
  EmojiJsPlugin$7(EmojiJsPlugin paramEmojiJsPlugin, aqkf paramaqkf, String paramString) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.val$treeBtnDialog.isShowing()))
    {
      this.val$treeBtnDialog.dismiss();
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("result", 2);
        paramDialogInterface.put("message", this.this$0.mRuntime.getActivity().getString(2131693095));
        if (QLog.isColorLevel()) {
          QLog.i(EmojiJsPlugin.TAG, 2, "startDownloadEmoji resp to js:" + paramDialogInterface.toString());
        }
        this.this$0.onAppResponse(this.val$callbackid, paramDialogInterface.toString());
      }
      catch (JSONException paramDialogInterface)
      {
        for (;;)
        {
          paramDialogInterface.printStackTrace();
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */