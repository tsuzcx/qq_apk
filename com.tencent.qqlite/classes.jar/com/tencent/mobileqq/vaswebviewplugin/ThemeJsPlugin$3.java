package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ThemeJsPlugin$3
  extends QQCustomDialog
{
  ThemeJsPlugin$3(ThemeJsPlugin paramThemeJsPlugin, Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "back button clicked");
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 2);
      localJSONObject.put("message", "user cancel download theme in not wifi network");
      this.this$0.callJs(this.val$callbackId + "(" + localJSONObject.toString() + ");");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      super.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */