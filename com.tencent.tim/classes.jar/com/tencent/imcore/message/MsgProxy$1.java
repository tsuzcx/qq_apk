package com.tencent.imcore.message;

import akwh;
import com.tencent.qphone.base.util.QLog;
import ton;

public class MsgProxy$1
  implements Runnable
{
  public MsgProxy$1(ton paramton, akwh paramakwh, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.a != null) {
        this.a.a(this.this$0.getTableName(this.aJG, this.ael), null, null);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.MsgProxy", 1, "delete slowtable excep :", localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.MsgProxy.1
 * JD-Core Version:    0.7.0.1
 */