package com.tencent.qidian;

import com.tencent.image.URLImageView;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$10
  implements Runnable
{
  QidianProfileCardActivity$10(QidianProfileCardActivity paramQidianProfileCardActivity, QidianProfileCardActivity.QidianCompoundProfileItem paramQidianCompoundProfileItem, URLImageView paramURLImageView) {}
  
  public void run()
  {
    if (this.a.type == 1) {}
    for (String str = this.a.faceUrl;; str = this.a.uin)
    {
      this.this$0.jC.put(this.a.uin, new QidianProfileCardActivity.b(this.ce, this.a.type, str));
      this.this$0.a(this.a.type, this.ce, str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.10
 * JD-Core Version:    0.7.0.1
 */