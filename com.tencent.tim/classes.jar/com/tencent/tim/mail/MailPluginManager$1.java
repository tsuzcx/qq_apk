package com.tencent.tim.mail;

import android.os.Handler;
import android.text.TextUtils;
import aqmj;
import augo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class MailPluginManager$1
  implements Runnable
{
  public MailPluginManager$1(augo paramaugo) {}
  
  public void run()
  {
    try
    {
      augo.a(this.this$0, (MailPluginRecentMsg)augo.a(this.this$0).find(MailPluginRecentMsg.class, null, null));
      Object localObject = aqmj.n(augo.a(this.this$0).getApp(), augo.a(this.this$0).getCurrentUin(), "sync_email_timing");
      augo localaugo;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).has("android_type"))
        {
          localaugo = this.this$0;
          if (((JSONObject)localObject).getInt("android_type") == 0) {
            break label228;
          }
        }
      }
      label228:
      for (boolean bool = true;; bool = false)
      {
        augo.a(localaugo, Boolean.valueOf(bool));
        if (((JSONObject)localObject).has("android_timing")) {
          augo.a(this.this$0, ((JSONObject)localObject).getInt("android_timing") * 60 * 1000);
        }
        if ((augo.a(this.this$0).booleanValue()) && (augo.a(this.this$0) > 0)) {
          augo.a(this.this$0).sendEmptyMessageDelayed(111, augo.a(this.this$0));
        }
        if (QLog.isColorLevel()) {
          QLog.d("MailPluginManager", 2, "init auto sync: mAutoSyncOn=" + augo.a(this.this$0) + ", mAutoSyncTime=" + augo.a(this.this$0));
        }
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginManager.1
 * JD-Core Version:    0.7.0.1
 */