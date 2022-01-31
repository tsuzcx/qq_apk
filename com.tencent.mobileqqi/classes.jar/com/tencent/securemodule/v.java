package com.tencent.securemodule;

import android.content.Intent;
import com.tencent.securemodule.impl.SecureService;

public final class v
  implements Runnable
{
  public v(SecureService paramSecureService, Intent paramIntent) {}
  
  public final void run()
  {
    try
    {
      if ("1000010".equals(this.b.getAction()))
      {
        SecureService.a(this.a);
        SecureService.b(this.a);
      }
      while ((!SecureService.c(this.a)) && (SecureService.d(this.a) == 0))
      {
        this.a.stopSelf();
        SecureService localSecureService = this.a;
        SecureService.a();
        return;
        if ("1000011".equals(this.b.getAction())) {
          SecureService.b(this.a, "http://fwd.3g.qq.com:8080/forward.jsp?bid=882");
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.v
 * JD-Core Version:    0.7.0.1
 */