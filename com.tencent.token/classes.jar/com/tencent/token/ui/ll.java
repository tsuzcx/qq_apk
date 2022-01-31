package com.tencent.token.ui;

import android.os.Message;
import android.widget.EditText;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;

final class ll
  extends bo
{
  ll(GetOtherBarcodeActivity paramGetOtherBarcodeActivity)
  {
    super(paramGetOtherBarcodeActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    String str = GetOtherBarcodeActivity.access$000(this.a).getText().toString();
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    QQUser localQQUser = ax.a().e();
    if (localQQUser != null)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (arrayOfByte != null))
      {
        paramMessage = "https://ssl.ptlogin2.qq.com/jump?keyindex=19&clientuin=" + localQQUser.mRealUin + "&clientkey=" + s.a(arrayOfByte) + "&u1=" + str;
        e.c("skey: url=" + paramMessage);
      }
    }
    for (;;)
    {
      s.a(this.a, paramMessage);
      return;
      paramMessage = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ll
 * JD-Core Version:    0.7.0.1
 */