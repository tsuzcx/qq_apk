package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import cooperation.vip.pb.TianShuAccess.AdItem;

final class MiniGameAdBannerPopup$3
  implements Runnable
{
  MiniGameAdBannerPopup$3(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, TianShuAccess.AdItem paramAdItem) {}
  
  public void run()
  {
    try
    {
      MiniGameAdBannerPopup.access$200(this.val$context, this.val$finalType, this.val$finalText, this.val$finalPic, this.val$finalUrl, this.val$finalTianShuAdItem);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniGameAdBannerPopup", "showAdBannerPopupWindow exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.MiniGameAdBannerPopup.3
 * JD-Core Version:    0.7.0.1
 */