package com.tencent.mobileqq.apollo.process;

import abmm;
import absk;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class CmGameServerQIPCModule$3
  implements Runnable
{
  public CmGameServerQIPCModule$3(abmm paramabmm, IPCSpriteContext paramIPCSpriteContext, int paramInt) {}
  
  public void run()
  {
    Object localObject = absk.a(this.a);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("IPCSpriteContext", this.a);
    localBundle.putString("js_content", (String)localObject);
    localObject = EIPCResult.createSuccessResult(localBundle);
    this.this$0.callbackResult(this.val$callbackId, (EIPCResult)localObject);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow_receive initAvatar ipc req");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */