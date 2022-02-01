package com.tencent.tim.mail;

import android.app.Dialog;
import android.widget.ProgressBar;
import android.widget.TextView;
import athu;
import auge;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.util.Pair;

public class MailPluginAttachDownloader$6
  implements Runnable
{
  public MailPluginAttachDownloader$6(auge paramauge, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if ((auge.a(this.this$0) == null) || (auge.a(this.this$0))) {}
    for (;;)
    {
      return;
      if (!auge.a(this.this$0).isShowing()) {
        auge.a(this.this$0).show();
      }
      String str1;
      if (auge.a(this.this$0) != null)
      {
        str1 = "第" + (this.val$index + 1) + "个";
        if ((auge.a(this.this$0) == null) || (auge.a(this.this$0).first == null)) {
          break label231;
        }
        String str2 = athu.c((float)(((FileManagerEntity)auge.a(this.this$0).first).fileSize * this.val$progress / 100L));
        String str3 = athu.c((float)((FileManagerEntity)auge.a(this.this$0).first).fileSize);
        auge.a(this.this$0).setText(str1 + "(" + str2 + "/" + str3 + ")");
      }
      while (auge.a(this.this$0) != null)
      {
        auge.a(this.this$0).setProgress(this.val$progress);
        return;
        label231:
        auge.a(this.this$0).setText(str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginAttachDownloader.6
 * JD-Core Version:    0.7.0.1
 */