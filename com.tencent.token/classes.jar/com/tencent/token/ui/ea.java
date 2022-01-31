package com.tencent.token.ui;

import android.os.Message;
import android.webkit.WebView;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;

final class ea
  extends bo
{
  ea(FacePKActivity paramFacePKActivity)
  {
    super(paramFacePKActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      this.a.mWebView.loadUrl(FacePKActivity.access$000(this.a));
      return;
    }
    QQUser localQQUser = ax.a().e();
    if (localQQUser != null)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (arrayOfByte != null))
      {
        FacePKActivity.access$002(this.a, "https://ssl.ptlogin2.qq.com/jump?keyindex=19&clientuin=" + localQQUser.mRealUin + "&clientkey=" + s.a(arrayOfByte) + "&u1=" + FacePKActivity.access$000(this.a));
        e.c("skey: url=" + FacePKActivity.access$000(this.a));
      }
    }
    this.a.mWebView.loadUrl(FacePKActivity.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ea
 * JD-Core Version:    0.7.0.1
 */