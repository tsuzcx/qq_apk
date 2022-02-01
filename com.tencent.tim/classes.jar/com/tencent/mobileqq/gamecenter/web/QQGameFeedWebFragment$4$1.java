package com.tencent.mobileqq.gamecenter.web;

import ahuz;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import cooperation.qwallet.plugin.QWalletPicHelper;

public class QQGameFeedWebFragment$4$1
  implements Runnable
{
  public QQGameFeedWebFragment$4$1(ahuz paramahuz, int paramInt, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    if ((this.val$resCode == 0) && (!TextUtils.isEmpty(this.val$pathRes.filePath)))
    {
      Drawable localDrawable = QWalletPicHelper.getDrawableForWallet(this.val$pathRes.filePath, null);
      if (localDrawable != null)
      {
        ((ImageView)this.a.val$rootView.findViewById(2131369020)).setImageDrawable(localDrawable);
        return;
      }
      QQGameFeedWebFragment.a(this.a.this$0);
      return;
    }
    QQGameFeedWebFragment.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.4.1
 * JD-Core Version:    0.7.0.1
 */