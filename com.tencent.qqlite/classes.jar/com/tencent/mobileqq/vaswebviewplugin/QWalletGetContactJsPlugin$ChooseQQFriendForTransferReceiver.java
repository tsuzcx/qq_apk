package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.widget.QQToast;

public class QWalletGetContactJsPlugin$ChooseQQFriendForTransferReceiver
  extends ResultReceiver
{
  private QWalletGetContactJsPlugin mJsPlugin;
  
  public QWalletGetContactJsPlugin$ChooseQQFriendForTransferReceiver(QWalletGetContactJsPlugin paramQWalletGetContactJsPlugin, Handler paramHandler)
  {
    super(paramHandler);
    this.mJsPlugin = paramQWalletGetContactJsPlugin;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if ((paramInt != 0) || (paramBundle == null))
    {
      this.mJsPlugin.dochooseQQFriendsForTransferResult(null);
      return;
    }
    QQToast.a(QWalletGetContactJsPlugin.access$300(this.mJsPlugin), 2131364497, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletGetContactJsPlugin.ChooseQQFriendForTransferReceiver
 * JD-Core Version:    0.7.0.1
 */