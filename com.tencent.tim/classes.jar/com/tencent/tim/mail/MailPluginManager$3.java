package com.tencent.tim.mail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import augo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class MailPluginManager$3
  implements Runnable
{
  public MailPluginManager$3(augo paramaugo) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = augo.a(this.this$0).getApplication().getSharedPreferences("mail_plugin_sp" + augo.a(this.this$0).getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("m_p_add_tab_first", false))
    {
      String str = augo.a(this.this$0).getApplication().getString(2131695633);
      augo.a(this.this$0, new MailPluginRecentMsg("", "", "", str, str));
      augo.a(this.this$0, augo.a(this.this$0), 0);
      localSharedPreferences.edit().putBoolean("m_p_add_tab_first", true);
      localSharedPreferences.edit().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginManager.3
 * JD-Core Version:    0.7.0.1
 */