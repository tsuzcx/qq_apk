package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.s;

public final class bb
  extends bc
{
  static bb a = null;
  public OnlineDeviceResult b;
  
  private bb()
  {
    super("tbl_login_log");
  }
  
  public static bb a()
  {
    if (a == null) {
      a = new bb();
    }
    return a;
  }
  
  public static void b()
  {
    a = null;
  }
  
  public final void a(byte paramByte, String paramString, Handler paramHandler)
  {
    f();
    af.a().a(0L, paramByte, s.a(x.a(RqdApplication.i()).c()), "com.tencent.token", paramString, paramHandler);
  }
  
  public final void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bb
 * JD-Core Version:    0.7.0.1
 */