package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import com.tencent.qqmail.card.fragment.ShareLinkToExternal.SharedType;
import com.tencent.qqmail.card.util.CardUtil;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$87$1
  implements Runnable
{
  ComposeMailActivity$87$1(ComposeMailActivity.87 param87, String paramString1, String paramString2) {}
  
  public void run()
  {
    ComposeMailActivity.access$9502(this.this$1.this$0, this.val$cardId);
    ComposeMailActivity.access$9602(this.this$1.this$0, this.val$h5Url + CardUtil.getFromPlatform(ShareLinkToExternal.SharedType.SHARE_TO_MAIL));
    ComposeMailActivity.access$9702(this.this$1.this$0, "http://i.mail.qq.com/cgi-bin/uma_ack_card?" + String.format("cardid=%s", new Object[] { this.val$cardId }) + CardUtil.getFromPlatform(ShareLinkToExternal.SharedType.SHARE_TO_MAIL) + "&email=1");
    if (ComposeMailActivity.access$3700(this.this$1.this$0))
    {
      ComposeMailActivity.access$3900(this.this$1.this$0);
      Object localObject = ComposeMailActivity.access$9800(this.this$1.this$0);
      if (this.this$1.this$0.composeMail.getContent() != null) {
        this.this$1.this$0.composeMail.getContent().setBody((String)localObject);
      }
      this.this$1.this$0.composeMail.setCardSubId(ComposeMailActivity.access$9500(this.this$1.this$0));
      localObject = new Intent();
      this.this$1.this$0.setResult(1002, (Intent)localObject);
    }
    for (;;)
    {
      ComposeMailActivity.access$3702(this.this$1.this$0, false);
      return;
      ComposeMailActivity.access$8100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.87.1
 * JD-Core Version:    0.7.0.1
 */