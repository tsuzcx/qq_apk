package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import oicq.wlogin_sdk.request.WtloginHelper;

public final class tj
  extends tk
{
  static tj a;
  public OnlineDeviceResult b;
  
  private tj()
  {
    super("tbl_login_log");
  }
  
  public static tj a()
  {
    if (a == null) {
      a = new tj();
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
    si localsi = si.a();
    aao.a(sg.a(RqdApplication.p()).a.GetGuid());
    localsi.a(paramByte, paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tj
 * JD-Core Version:    0.7.0.1
 */