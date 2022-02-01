package com.tencent.mobileqq.app;

import achs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import mqq.app.MobileQQ;

public class MessageRoamManager$6
  implements Runnable
{
  public MessageRoamManager$6(achs paramachs) {}
  
  public void run()
  {
    if (this.this$0.app != null)
    {
      SharedPreferences localSharedPreferences = this.this$0.app.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      String str = Base64.encodeToString(this.this$0.cP, 0);
      localSharedPreferences.edit().putString("vip_message_roam_passwordmd5" + this.this$0.app.getCurrentAccountUin(), str).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.6
 * JD-Core Version:    0.7.0.1
 */