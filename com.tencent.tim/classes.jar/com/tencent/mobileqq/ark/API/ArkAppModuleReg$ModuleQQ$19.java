package com.tencent.mobileqq.ark.API;

import adnq.c;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;
import wyw;

public class ArkAppModuleReg$ModuleQQ$19
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$19(adnq.c paramc, long paramLong, String paramString) {}
  
  public void run()
  {
    if (this.Vq != 0L)
    {
      Object localObject = ark.arkGetContainer(this.Vq);
      if (localObject != null)
      {
        localObject = (wyw)wyw.a((ark.Container)localObject).get();
        if (localObject != null) {
          ((wyw)localObject).aUA = this.val$content;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.19
 * JD-Core Version:    0.7.0.1
 */