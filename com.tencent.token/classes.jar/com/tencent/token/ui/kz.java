package com.tencent.token.ui;

import android.os.Message;
import android.widget.EditText;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class kz
  extends cb
{
  kz(GetOtherBarcodeActivity paramGetOtherBarcodeActivity)
  {
    super(paramGetOtherBarcodeActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = GetOtherBarcodeActivity.access$000(this.a).getText().toString();
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    QQUser localQQUser = do.a().e();
    if (localQQUser != null)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (arrayOfByte != null))
      {
        paramMessage = "https://ssl.ptlogin2.qq.com/jump?keyindex=19&clientuin=" + localQQUser.mRealUin + "&clientkey=" + w.a(arrayOfByte) + "&u1=" + str;
        h.c("skey: url=" + paramMessage);
      }
    }
    for (;;)
    {
      w.a(this.a, paramMessage);
      return;
      paramMessage = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kz
 * JD-Core Version:    0.7.0.1
 */