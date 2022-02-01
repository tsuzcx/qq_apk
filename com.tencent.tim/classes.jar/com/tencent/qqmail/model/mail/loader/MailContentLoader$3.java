package com.tencent.qqmail.model.mail.loader;

import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.log.QMLog;

class MailContentLoader$3
  implements Runnable
{
  MailContentLoader$3(MailContentLoader paramMailContentLoader, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    QMLog.log(4, MailContentLoader.TAG, "download success to compress:" + this.val$src + " from:" + this.val$localPath);
    String str = new String(this.val$src);
    ImageCompresser.getInstance().compressImage(SendMailHelper.removeInlineImgCid(str), this.val$localPath, "", 1, new MailContentLoader.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.3
 * JD-Core Version:    0.7.0.1
 */