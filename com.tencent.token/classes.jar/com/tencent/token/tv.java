package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import oicq.wlogin_sdk.request.WtloginHelper;

public final class tv
  extends tw
{
  static tv a;
  public OnlineDeviceResult b;
  
  private tv()
  {
    super("tbl_login_log");
  }
  
  public static tv a()
  {
    if (a == null) {
      a = new tv();
    }
    return a;
  }
  
  public static void b()
  {
    a = null;
  }
  
  public final void a(byte paramByte, Handler paramHandler)
  {
    d();
    su localsu = su.a();
    aay.a(ss.a(RqdApplication.n()).a.GetGuid());
    localsu.a(paramByte, paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tv
 * JD-Core Version:    0.7.0.1
 */