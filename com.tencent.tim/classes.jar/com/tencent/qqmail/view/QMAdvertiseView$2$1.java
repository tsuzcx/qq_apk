package com.tencent.qqmail.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.androidqqmail.mobileqq.MobileQQEntryActivity;
import java.util.ArrayList;

class QMAdvertiseView$2$1
  implements DialogInterface.OnDismissListener
{
  QMAdvertiseView$2$1(QMAdvertiseView.2 param2, View paramView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$itemView.getTag().equals(this.this$1.this$0.getContext().getString(2131697505)))
    {
      this.this$1.this$0.logEvent("Event_Pulldown_Webview_Pulldown_Share_Wechat_Friends");
      QMAdvertiseView.access$302(this.this$1.this$0, QMAdvertiseView.ShareType.WE_CHAT_FRIEND.getShareType());
      if (!QMAdvertiseView.access$400(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.URL.getModeName())) {}
    }
    label122:
    do
    {
      do
      {
        do
        {
          do
          {
            QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.URL.getModeName());
            break label122;
            break label122;
            for (;;)
            {
              this.this$1.this$0.loadBitmapFromWeb(QMAdvertiseView.access$400(this.this$1.this$0).imageUrl);
              return;
              if (QMAdvertiseView.access$400(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.IMAGE.getModeName())) {
                QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.IMAGE.getModeName());
              }
            }
            if (this.val$itemView.getTag().equals(this.this$1.this$0.getContext().getString(2131697504)))
            {
              this.this$1.this$0.logEvent("Event_Pulldown_Webview_Pulldown_Share_Wechat_Timeline");
              QMAdvertiseView.access$302(this.this$1.this$0, QMAdvertiseView.ShareType.WE_CHAT_TIMELINE.getShareType());
              if (QMAdvertiseView.access$600(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.URL.getModeName())) {
                QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.URL.getModeName());
              }
              for (;;)
              {
                this.this$1.this$0.loadBitmapFromWeb(QMAdvertiseView.access$600(this.this$1.this$0).imageUrl);
                return;
                if (QMAdvertiseView.access$600(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.IMAGE.getModeName())) {
                  QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.IMAGE.getModeName());
                }
              }
            }
            if (!this.val$itemView.getTag().equals(this.this$1.this$0.getContext().getString(2131697502))) {
              break;
            }
            this.this$1.this$0.logEvent("Event_Pulldown_Webview_Pulldown_Share_QQ_Friends");
            QMAdvertiseView.access$302(this.this$1.this$0, QMAdvertiseView.ShareType.QQFRIEND.getShareType());
            if (QMAdvertiseView.access$700(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.URL.getModeName()))
            {
              QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.URL.getModeName());
              MobileQQEntryActivity.shareLinkToQQ(QMAdvertiseView.access$700(this.this$1.this$0).shareUrl, QMAdvertiseView.access$700(this.this$1.this$0).title, QMAdvertiseView.access$700(this.this$1.this$0).abstracts, QMAdvertiseView.access$700(this.this$1.this$0).imageUrl, QMAdvertiseView.access$100(this.this$1.this$0));
              return;
            }
          } while (!QMAdvertiseView.access$700(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.IMAGE.getModeName()));
          QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.IMAGE.getModeName());
          this.this$1.this$0.loadBitmapFromWeb(QMAdvertiseView.access$700(this.this$1.this$0).imageUrl);
          return;
          if (!this.val$itemView.getTag().equals(this.this$1.this$0.getContext().getString(2131697503))) {
            break;
          }
          this.this$1.this$0.logEvent("Event_Pulldown_Webview_Pulldown_Share_QZone");
          QMAdvertiseView.access$302(this.this$1.this$0, QMAdvertiseView.ShareType.QQZONE.getShareType());
          if (QMAdvertiseView.access$800(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.URL.getModeName()))
          {
            paramDialogInterface = new ArrayList();
            paramDialogInterface.add(QMAdvertiseView.access$800(this.this$1.this$0).imageUrl);
            QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.URL.getModeName());
            MobileQQEntryActivity.shareLinkToQQZone(QMAdvertiseView.access$800(this.this$1.this$0).shareUrl, QMAdvertiseView.access$800(this.this$1.this$0).title, QMAdvertiseView.access$800(this.this$1.this$0).abstracts, paramDialogInterface, QMAdvertiseView.access$100(this.this$1.this$0));
            return;
          }
        } while (!QMAdvertiseView.access$800(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.IMAGE.getModeName()));
        QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.IMAGE.getModeName());
        this.this$1.this$0.loadBitmapFromWeb(QMAdvertiseView.access$800(this.this$1.this$0).imageUrl);
        return;
      } while (!this.val$itemView.getTag().equals(this.this$1.this$0.getContext().getString(2131697501)));
      this.this$1.this$0.logEvent("Event_Pulldown_Webview_Pulldown_Share_Mail");
      QMAdvertiseView.access$302(this.this$1.this$0, QMAdvertiseView.ShareType.MAIL.getShareType());
      if (QMAdvertiseView.access$900(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.URL.getModeName()))
      {
        QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.URL.getModeName());
        this.this$1.this$0.shareUrlToMail(QMAdvertiseView.access$900(this.this$1.this$0).title, QMAdvertiseView.access$900(this.this$1.this$0).shareUrl);
        return;
      }
    } while (!QMAdvertiseView.access$900(this.this$1.this$0).mode.equals(QMAdvertiseView.ShareMode.IMAGE.getModeName()));
    QMAdvertiseView.access$502(this.this$1.this$0, QMAdvertiseView.ShareMode.IMAGE.getModeName());
    this.this$1.this$0.loadBitmapFromWeb(QMAdvertiseView.access$900(this.this$1.this$0).imageUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMAdvertiseView.2.1
 * JD-Core Version:    0.7.0.1
 */