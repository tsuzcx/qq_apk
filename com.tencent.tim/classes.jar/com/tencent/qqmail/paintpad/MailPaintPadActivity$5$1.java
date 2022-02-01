package com.tencent.qqmail.paintpad;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.qqmail.protocol.DataCollector;

class MailPaintPadActivity$5$1
  implements DialogInterface.OnDismissListener
{
  MailPaintPadActivity$5$1(MailPaintPadActivity.5 param5, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719238)))
    {
      DataCollector.logEvent("Event_Screenshot_Tag_Share_Wechat_Friend");
      this.this$1.this$0.shareToWeChatFriend(MailPaintPadActivity.access$000(this.this$1.this$0));
    }
    do
    {
      return;
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719229)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Share_Wechat_Timeline");
        this.this$1.this$0.shareToTimeLine(MailPaintPadActivity.access$000(this.this$1.this$0));
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719233)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Share_Qq");
        this.this$1.this$0.shareImageToQQ(MailPaintPadActivity.access$000(this.this$1.this$0));
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719236)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Share_RTX_Friend");
        this.this$1.this$0.shareImageToRTX(MailPaintPadActivity.access$000(this.this$1.this$0));
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719237)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Save_To_Album");
        this.this$1.this$0.saveToGallery();
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719231)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Share_Others");
        this.this$1.this$0.shareToOtherApp(MailPaintPadActivity.access$000(this.this$1.this$0));
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719230)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Compose_Mail");
        this.this$1.this$0.newMail();
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719234)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Reply_Mail");
        this.this$1.this$0.reply();
        return;
      }
      if (this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719235)))
      {
        DataCollector.logEvent("Event_Screenshot_Tag_Reply_Mail_all");
        this.this$1.this$0.replyAll();
        return;
      }
    } while (!this.val$itemView.getTag().equals(this.this$1.this$0.getString(2131719228)));
    DataCollector.logEvent("Event_Screenshot_Tag_Forware_Mail");
    this.this$1.this$0.forward();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.5.1
 * JD-Core Version:    0.7.0.1
 */