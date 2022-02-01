package com.tencent.qqmail.model.mail.loader;

class MailContentLoader$4
  implements Runnable
{
  MailContentLoader$4(MailContentLoader paramMailContentLoader, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.this$0.mCallback != null) {
      this.this$0.mCallback.onSuccess(this.val$originSrc, this.val$localPath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.4
 * JD-Core Version:    0.7.0.1
 */