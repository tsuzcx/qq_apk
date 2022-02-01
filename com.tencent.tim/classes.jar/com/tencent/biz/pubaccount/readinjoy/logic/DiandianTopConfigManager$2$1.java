package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.qphone.base.util.QLog;
import lcc;
import lgp;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class DiandianTopConfigManager$2$1
  implements Runnable
{
  DiandianTopConfigManager$2$1(DiandianTopConfigManager.2 param2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.val$data == null)
    {
      lcc.a().i(false, null);
      return;
    }
    oidb_0xb7e.RspBody localRspBody = new oidb_0xb7e.RspBody();
    try
    {
      localRspBody.mergeFrom(this.val$data);
      lgp.a(this.a.this$0, localRspBody);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(lgp.TAG, 2, "loadDiandianTopConfig, e = " + localException);
      }
      lcc.a().i(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.DiandianTopConfigManager.2.1
 * JD-Core Version:    0.7.0.1
 */