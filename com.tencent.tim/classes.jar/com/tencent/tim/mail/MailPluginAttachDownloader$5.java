package com.tencent.tim.mail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import auge;
import java.util.ArrayList;

public class MailPluginAttachDownloader$5
  implements Runnable
{
  public MailPluginAttachDownloader$5(auge paramauge, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((auge.a(this.this$0) != null) && (auge.a(this.this$0).isShowing())) {
      auge.a(this.this$0).dismiss();
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("reslut_select_file_info_list", this.Ca);
    localIntent.putExtra("key_mail_attach_select_finish", true);
    auge.a(this.this$0).setResult(-1, localIntent);
    auge.a(this.this$0).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginAttachDownloader.5
 * JD-Core Version:    0.7.0.1
 */