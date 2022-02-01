package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import oicq.wlogin_sdk.request.WtloginHelper;

public final class tb
  extends tc
{
  static tb a;
  public OnlineDeviceResult b;
  
  private tb()
  {
    super("tbl_login_log");
  }
  
  public static tb a()
  {
    if (a == null) {
      a = new tb();
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
    sa localsa = sa.a();
    aac.a(ry.a(RqdApplication.n()).a.GetGuid());
    localsa.a(paramByte, paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tb
 * JD-Core Version:    0.7.0.1
 */