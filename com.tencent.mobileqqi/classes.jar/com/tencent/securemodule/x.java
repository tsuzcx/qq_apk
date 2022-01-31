package com.tencent.securemodule;

import android.os.Handler;
import android.os.Message;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.impl.SecureService.a;
import com.tencent.securemodule.ui.TransparentActivity;
import com.tencent.securemodule.ui.TransparentActivity.a;

public final class x
  implements Runnable
{
  public x(SecureService.a parama, String paramString, ad paramad) {}
  
  public final void run()
  {
    int i = SecureService.a(SecureService.a.a(this.a), this.b);
    ad localad;
    if (this.c != null)
    {
      localad = this.c;
      if (i != 0) {
        break label88;
      }
      Message localMessage = TransparentActivity.c(TransparentActivity.a.b(localad.a)).obtainMessage(2);
      localMessage.arg1 = 1;
      TransparentActivity.c(TransparentActivity.a.b(localad.a)).sendMessage(localMessage);
    }
    for (;;)
    {
      SecureService.a.a(this.a).stopSelf();
      SecureService.a.a(this.a);
      SecureService.a();
      return;
      label88:
      TransparentActivity.a.a(localad.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.x
 * JD-Core Version:    0.7.0.1
 */