package com.tencent.token;

import android.os.Handler;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.l;

public class ct
  extends cu
{
  static ct a;
  public OnlineDeviceResult b;
  
  private ct()
  {
    super("tbl_login_log");
  }
  
  public static ct a()
  {
    if (a == null) {
      a = new ct();
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
    cb.a().a(0L, paramByte, 0, l.a(bz.a(RqdApplication.l()).b()), 523005419, 1, "com.tencent.token", paramString, paramHandler);
  }
  
  public void c()
  {
    a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ct
 * JD-Core Version:    0.7.0.1
 */