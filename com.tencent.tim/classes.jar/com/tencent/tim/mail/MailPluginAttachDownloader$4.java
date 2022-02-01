package com.tencent.tim.mail;

import android.app.Dialog;
import android.text.TextUtils;
import aqha;
import aqju;
import auge;
import augi;
import augj;

public class MailPluginAttachDownloader$4
  implements Runnable
{
  public MailPluginAttachDownloader$4(auge paramauge) {}
  
  public void run()
  {
    if ((auge.a(this.this$0) != null) && (auge.a(this.this$0).isShowing())) {
      auge.a(this.this$0).dismiss();
    }
    String str1 = "";
    if (!TextUtils.isEmpty(auge.a(this.this$0))) {
      str1 = "" + "\"" + auge.a(this.this$0) + "\"";
    }
    String str2 = str1;
    if (auge.a(this.this$0) > 1) {
      str2 = str1 + "等" + auge.a(this.this$0) + "个文件";
    }
    str1 = str2 + "添加失败，点击重新添加。";
    aqha.a(auge.a(this.this$0), 230, null, str1, 2131721058, 2131718318, new augi(this), new augj(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginAttachDownloader.4
 * JD-Core Version:    0.7.0.1
 */