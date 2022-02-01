package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import aobw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import jnp;
import jnq;
import jnv;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchHandler$2$1
  implements Runnable
{
  public TroopRedTouchHandler$2$1(jnq paramjnq, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopRedTouchHandler", 2, "getRedPointInfo onReceive :" + this.val$isSuccess);
    }
    Object localObject;
    int j;
    int i;
    if ((this.val$isSuccess) && (this.val$bundle != null))
    {
      localObject = this.val$bundle.getByteArray("data");
      if ((!this.a.fH.contains(Integer.valueOf(46))) || (!aobw.bK(this.a.this$0.app))) {
        break label309;
      }
      j = 1;
      if (j == 0) {
        break label345;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((jnv)this.a.this$0.app.getManager(70)).a(46, false);
      if ((localRedDotInfo == null) || (!localRedDotInfo.uint32_last_time.has())) {
        break label314;
      }
      i = localRedDotInfo.uint32_last_time.get();
    }
    for (;;)
    {
      label151:
      if ((localObject != null) && (jnp.b(this.a.this$0.app, new ArrayList(this.a.fH), (byte[])localObject)))
      {
        this.a.this$0.aCo = 1;
        if (QLog.isColorLevel()) {
          QLog.i("storyRedDotDebug", 2, "getRedPointAsync");
        }
        this.a.this$0.notifyUI(105, true, null);
        if (j != 0)
        {
          localObject = ((jnv)this.a.this$0.app.getManager(70)).a(46, false);
          if ((localObject != null) && (QLog.isColorLevel())) {
            QLog.d("TroopRedTouchHandlerQ.qqstory.redPoint", 2, "getRedPointInfoAsync enableTencentDocsAssistant:" + jnv.a((oidb_0x791.RedDotInfo)localObject));
          }
          jnp.a(this.a.this$0.app, (oidb_0x791.RedDotInfo)localObject, i, false);
        }
      }
      label309:
      label314:
      do
      {
        return;
        j = 0;
        break;
        i = 0;
        break label151;
        this.a.this$0.aCo = 2;
      } while (!QLog.isColorLevel());
      QLog.e("TroopRedTouchHandler", 2, "getRedPointInfo success data is null");
      return;
      label345:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.2.1
 * JD-Core Version:    0.7.0.1
 */