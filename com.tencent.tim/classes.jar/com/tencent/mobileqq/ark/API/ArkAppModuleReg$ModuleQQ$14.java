package com.tencent.mobileqq.ark.API;

import adnq.c;
import adrm;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import java.lang.ref.WeakReference;
import wyw;

public class ArkAppModuleReg$ModuleQQ$14
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$14(adnq.c paramc, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.Vo);
    if (localObject == null) {}
    do
    {
      return;
      localObject = wyw.a((ark.Container)localObject);
    } while ((localObject == null) || ((wyw)((WeakReference)localObject).get() == null));
    adrm.a().hideTips();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.14
 * JD-Core Version:    0.7.0.1
 */