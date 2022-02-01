package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import oicq.wlogin_sdk.request.WtloginHelper;

public final class tc
  extends td
{
  static tc a;
  public OnlineDeviceResult b;
  
  private tc()
  {
    super("tbl_login_log");
  }
  
  public static tc a()
  {
    if (a == null) {
      a = new tc();
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
    sb localsb = sb.a();
    aad.a(rz.a(RqdApplication.n()).a.GetGuid());
    localsb.a(paramByte, paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tc
 * JD-Core Version:    0.7.0.1
 */