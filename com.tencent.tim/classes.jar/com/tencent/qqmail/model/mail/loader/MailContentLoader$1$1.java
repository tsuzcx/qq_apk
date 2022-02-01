package com.tencent.qqmail.model.mail.loader;

class MailContentLoader$1$1
  implements Runnable
{
  MailContentLoader$1$1(MailContentLoader.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.this$1.this$0.mCallback != null) {
      this.this$1.this$0.mCallback.onError(MailContentLoader.access$000(this.this$1.this$0, this.val$src), this.val$errMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader.1.1
 * JD-Core Version:    0.7.0.1
 */