package com.tencent.mobileqq.apollo.view;

import altq;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$35
  implements Runnable
{
  ApolloPanel$35(ApolloPanel paramApolloPanel, BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.mBaseChatPie != null) && (this.this$0.mBaseChatPie.app != null))
    {
      this.this$0.H.e(this.b);
      ((altq)this.this$0.mBaseChatPie.app.getManager(36)).i(this.b);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ApolloPanel.a(this.this$0);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ApolloPanel.a(this.this$0);
      localObject = URLDrawable.getDrawable(this.val$iconUrl, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "[parseShopRedTouchManager] shopDrawable not ready");
        }
        ((URLDrawable)localObject).startDownload();
      }
      if (this.this$0.aR != null) {
        this.this$0.aR.setImageDrawable((Drawable)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.35
 * JD-Core Version:    0.7.0.1
 */