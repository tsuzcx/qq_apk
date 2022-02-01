package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

class Leba$25
  implements Runnable
{
  Leba$25(Leba paramLeba, String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("web_process_preload_file", 4);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int i = localSharedPreferences.getInt("key_web_plugin_click_num" + this.val$pluginId + this.this$0.app.getCurrentAccountUin(), 0);
    localEditor.putInt("key_web_plugin_click_num" + this.val$pluginId + this.this$0.app.getCurrentAccountUin(), i + 1);
    if (this.b.iNewFlag.get() != 0)
    {
      i = localSharedPreferences.getInt("key_web_plugin_click_red_num" + this.val$pluginId + this.this$0.app.getCurrentAccountUin(), 0);
      localEditor.putInt("key_web_plugin_click_red_num" + this.val$pluginId + this.this$0.app.getCurrentAccountUin(), i + 1);
    }
    localEditor.putLong("key_come_webview_time" + this.this$0.app.getCurrentAccountUin(), System.currentTimeMillis());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.25
 * JD-Core Version:    0.7.0.1
 */