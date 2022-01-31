package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONException;
import org.json.JSONObject;

class EmojiJsPlugin$1
  implements DialogInterface.OnClickListener
{
  EmojiJsPlugin$1(EmojiJsPlugin paramEmojiJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new JSONObject();
    try
    {
      paramDialogInterface.put("result", 0);
      paramDialogInterface.put("message", "btn0 press");
      this.this$0.onAppResponse(this.val$callbackid, paramDialogInterface.toString());
      return;
    }
    catch (JSONException paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */