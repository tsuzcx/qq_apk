package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.w;

public class ds
  extends dt
{
  static ds a = null;
  public OnlineDeviceResult b;
  
  private ds()
  {
    super("tbl_login_log");
  }
  
  public static ds a()
  {
    if (a == null) {
      a = new ds();
    }
    return a;
  }
  
  public static void b()
  {
    a = null;
  }
  
  public void a(byte paramByte, String paramString, Handler paramHandler)
  {
    c();
    cw.a().a(0L, paramByte, 0, w.a(cp.a(RqdApplication.l()).b()), 523005419, 1, "com.tencent.token", paramString, paramHandler);
  }
  
  public void c()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ds
 * JD-Core Version:    0.7.0.1
 */