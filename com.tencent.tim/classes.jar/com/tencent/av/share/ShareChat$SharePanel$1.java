package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import ivc.b;

public class ShareChat$SharePanel$1
  extends ResultReceiver
{
  public ShareChat$SharePanel$1(ivc.b paramb, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "shareToQzone.onReceiveResult, resultCode[" + paramInt + "], seq[" + this.kQ + "]");
    paramBundle = this.this$0;
    int i = this.atW;
    if (paramInt == -1) {}
    for (paramInt = 2;; paramInt = 3)
    {
      paramBundle.C(1, i, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.1
 * JD-Core Version:    0.7.0.1
 */