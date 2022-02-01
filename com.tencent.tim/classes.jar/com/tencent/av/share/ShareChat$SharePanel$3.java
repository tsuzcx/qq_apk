package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import ivc.b;
import ivc.b.a;

public class ShareChat$SharePanel$3
  extends ResultReceiver
{
  public ShareChat$SharePanel$3(ivc.b paramb, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_QRForwardReceiver, resultCode[" + paramInt + "], seq[" + this.kQ + "], mIHandle[" + this.this$0.a + "]");
    int i;
    if (this.this$0.a != null)
    {
      paramBundle = this.this$0.a;
      i = this.atW;
      if (paramInt != -1) {
        break label97;
      }
    }
    label97:
    for (paramInt = 2;; paramInt = 3)
    {
      paramBundle.D(5, i, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.3
 * JD-Core Version:    0.7.0.1
 */