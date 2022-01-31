package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import org.json.JSONException;
import org.json.JSONObject;

class EmojiJsPlugin$4
  implements DialogInterface.OnKeyListener
{
  EmojiJsPlugin$4(EmojiJsPlugin paramEmojiJsPlugin, QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, String paramString) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.val$treeBtnDialog.isShowing()))
    {
      this.val$treeBtnDialog.dismiss();
      paramDialogInterface = new JSONObject();
      try
      {
        paramDialogInterface.put("message", "press");
        this.this$0.onAppResponse(this.val$callbackid, paramDialogInterface.toString());
        return true;
      }
      catch (JSONException paramDialogInterface)
      {
        for (;;)
        {
          paramDialogInterface.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */