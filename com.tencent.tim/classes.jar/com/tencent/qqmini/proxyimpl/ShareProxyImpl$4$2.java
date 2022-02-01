package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import aqha;
import aqju;
import aswq;
import asws;
import com.tencent.mobileqq.widget.QQToast;

public class ShareProxyImpl$4$2
  implements Runnable
{
  public ShareProxyImpl$4$2(aswq paramaswq, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.val$finalErrCode == -100070004L) || (this.val$finalErrCode == -1000710003L))
    {
      aqha.a(this.a.val$activity, 233, this.a.val$activity.getString(2131720156), this.val$finalErrMsg, new asws(this), null).show();
      return;
    }
    QQToast.a(this.a.val$activity, 1, 2131695940, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.2
 * JD-Core Version:    0.7.0.1
 */