package com.etrump.mixlayout;

import aqnl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import eipc.EIPCResult;
import java.io.File;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import ld;

public class VasFontIPCModule$1
  implements Runnable
{
  public VasFontIPCModule$1(ld paramld, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    if (new File(aqnl.getSoDir() + "libvipfont808.so").exists())
    {
      localObject = EIPCResult.createResult(0, null);
      this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject);
    }
    do
    {
      do
      {
        return;
        ld.a(this.this$0).add(Integer.valueOf(this.val$callbackId));
      } while (!ld.a(this.this$0).compareAndSet(false, true));
      localObject = (VasQuickUpdateManager)this.val$app.getManager(184);
    } while (localObject == null);
    ((VasQuickUpdateManager)localObject).downloadItem(1004L, "libVipFont_808", "VasFontIPCModule");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.VasFontIPCModule.1
 * JD-Core Version:    0.7.0.1
 */