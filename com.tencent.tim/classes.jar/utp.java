import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.e;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class utp
  implements DialogInterface.OnClickListener
{
  public utp(Conversation.e parame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramDialogInterface.dismiss();
        this.a.this$0.I = null;
        return;
      }
      catch (Exception paramDialogInterface) {}
      if (SettingCloneUtil.readValue(this.a.this$0.app.getApplication(), this.a.this$0.app.getAccount(), null, "pcactive_config", false)) {
        this.a.this$0.app.startPCActivePolling(this.a.this$0.app.getAccount(), "logout");
      }
      this.a.this$0.a(this.a.this$0.a(), this.a.this$0.app);
      continue;
      if (Conversation.e.a(this.a).startsWith("http")) {}
      for (;;)
      {
        try
        {
          Intent localIntent = new Intent(this.a.this$0.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", Conversation.e.a(this.a));
          this.a.this$0.a().startActivity(localIntent);
          anot.a(this.a.this$0.app, "dc00898", "", "", "0X8008273", "0X8008273", 0, 0, "", "", "", "");
        }
        catch (Exception localException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        if (Conversation.e.a(this.a).startsWith("mqqapi:")) {
          aqik.c(this.a.this$0.app, this.a.this$0.a(), Conversation.e.a(this.a)).ace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     utp
 * JD-Core Version:    0.7.0.1
 */