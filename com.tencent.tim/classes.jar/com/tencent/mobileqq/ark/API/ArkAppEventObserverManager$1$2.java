package com.tencent.mobileqq.ark.API;

import adno;
import adno.h;
import adnp;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class ArkAppEventObserverManager$1$2
  implements Runnable
{
  public ArkAppEventObserverManager$1$2(adnp paramadnp) {}
  
  public void run()
  {
    if (adno.a(this.a.this$0) != null) {
      adno.a(this.a.this$0).b(false, 0.0D, 0.0D);
    }
    SosoInterface.c(adno.a(this.a.this$0));
    adno.a(this.a.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.2
 * JD-Core Version:    0.7.0.1
 */