package com.tencent.qqmail.model.mail.loader;

import com.tencent.qqmail.utilities.log.QMLog;

class MailContentLoader$3$1$1
  implements Runnable
{
  MailContentLoader$3$1$1(MailContentLoader.3.1 param1, String paramString) {}
  
  public void run()
  {
    if (this.this$2.this$1.this$0.mCallback != null)
    {
      QMLog.log(4, MailContentLoader.TAG, "compressImage success:" + this.this$2.this$1.val$src + " -> " + this.val$compressPath);
      this.this$2.this$1.this$0.mCallback.onSuccess(this.this$2.this$1.val$originSrc, this.val$compressPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.3.1.1
 * JD-Core Version:    0.7.0.1
 */