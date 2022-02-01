package com.tencent.qqmail.view;

import android.graphics.Bitmap;
import com.tencent.androidqqmail.mobileqq.MobileQQEntryActivity;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.utilities.log.QMLog;

class QMAdvertiseView$3
  implements ImageDownloadListener
{
  QMAdvertiseView$3(QMAdvertiseView paramQMAdvertiseView) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject)
  {
    QMLog.log(6, "QMAdvertiseView", "loadPopularizeThumbWithCallBack error:" + paramString);
  }
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    QMLog.log(4, "QMAdvertiseView", "loadPopularizeThumbWithCallBack success:" + paramString1);
    if (QMAdvertiseView.access$300(this.this$0).equals(QMAdvertiseView.ShareType.WE_CHAT_FRIEND.getShareType())) {
      if (QMAdvertiseView.access$500(this.this$0).equals(QMAdvertiseView.ShareMode.URL.getModeName())) {
        this.this$0.shareToWeChat(QMAdvertiseView.access$400(this.this$0).shareUrl, QMAdvertiseView.access$400(this.this$0).title, QMAdvertiseView.access$400(this.this$0).abstracts, paramString1, 0);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.this$0.shareImageToWeChatFriend(paramString2);
          return;
          if (QMAdvertiseView.access$300(this.this$0).equals(QMAdvertiseView.ShareType.WE_CHAT_TIMELINE.getShareType()))
          {
            if (QMAdvertiseView.access$500(this.this$0).equals(QMAdvertiseView.ShareMode.URL.getModeName()))
            {
              this.this$0.shareToWeChat(QMAdvertiseView.access$600(this.this$0).shareUrl, QMAdvertiseView.access$600(this.this$0).title, QMAdvertiseView.access$600(this.this$0).abstracts, paramString1, 1);
              return;
            }
            this.this$0.shareImageToTimeLine(paramString2);
            return;
          }
          if (!QMAdvertiseView.access$300(this.this$0).equals(QMAdvertiseView.ShareType.QQFRIEND.getShareType())) {
            break;
          }
        } while (!QMAdvertiseView.access$500(this.this$0).equals(QMAdvertiseView.ShareMode.IMAGE.getModeName()));
        MobileQQEntryActivity.shareImageToQQ(QMAdvertiseView.access$100(this.this$0), paramString2);
        return;
        if (!QMAdvertiseView.access$300(this.this$0).equals(QMAdvertiseView.ShareType.QQZONE.getShareType())) {
          break;
        }
      } while (!QMAdvertiseView.access$500(this.this$0).equals(QMAdvertiseView.ShareMode.IMAGE.getModeName()));
      MobileQQEntryActivity.shareImageToQQZone(QMAdvertiseView.access$100(this.this$0), paramString2);
      return;
    } while ((!QMAdvertiseView.access$300(this.this$0).equals(QMAdvertiseView.ShareType.MAIL.getShareType())) || (!QMAdvertiseView.access$500(this.this$0).equals(QMAdvertiseView.ShareMode.IMAGE.getModeName())));
    this.this$0.shareImageToMail(QMAdvertiseView.access$900(this.this$0).title, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMAdvertiseView.3
 * JD-Core Version:    0.7.0.1
 */