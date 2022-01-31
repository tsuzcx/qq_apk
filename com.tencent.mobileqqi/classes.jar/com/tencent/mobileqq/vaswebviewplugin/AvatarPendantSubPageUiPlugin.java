package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class AvatarPendantSubPageUiPlugin
  extends VasWebviewUiPlugin
{
  public static final String KEY_SUB_PAGE_TITLE = "key_sub_page_title";
  public static final String KEY_SUB_PAGE_URL = "key_sub_page_url";
  private static final String LOG_TAG = "AvatarPendantSubPageStrategy";
  
  void OnActivityCreate()
  {
    String str1 = getInfoIntent().getStringExtra("key_sub_page_title");
    String str2 = getInfoIntent().getStringExtra("key_sub_page_url");
    if ((str1 == null) || (str2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantSubPageStrategy", 2, "Parameter title or url is null, failed to open sub page");
      }
      return;
    }
    this.activity.setTitle(str1);
    this.activity.I = decodeUrl(this.activity.I);
    webviewLoadUrl(str2);
  }
  
  protected long getPluginBusiness()
  {
    return 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantSubPageUiPlugin
 * JD-Core Version:    0.7.0.1
 */