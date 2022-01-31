package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class ChatFontUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ChatFontUiPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.I = decodeUrl(this.activity.I);
    if (QLog.isColorLevel()) {
      QLog.d("ChatFontUiPlugin", 2, this.activity.I);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 4096L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin
 * JD-Core Version:    0.7.0.1
 */