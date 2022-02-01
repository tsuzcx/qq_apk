package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import ivc.b;

public class ShareChat$SharePanel$4
  extends ResultReceiver
{
  public ShareChat$SharePanel$4(ivc.b paramb, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_ActivityResultReceiver, resultCode[" + paramInt + "], seq[" + this.kQ + "]");
    this.this$0.C(5, this.atW, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.4
 * JD-Core Version:    0.7.0.1
 */