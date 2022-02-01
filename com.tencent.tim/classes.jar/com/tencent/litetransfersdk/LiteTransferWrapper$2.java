package com.tencent.litetransfersdk;

import com.tencent.qphone.base.util.QLog;

class LiteTransferWrapper$2
  implements Runnable
{
  LiteTransferWrapper$2(LiteTransferWrapper paramLiteTransferWrapper, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (LiteTransferWrapper.access$200(this.this$0) != 0L)
      {
        QLog.i("dataline.LiteTTransferWrapper", 1, "destryOperator mLiteTransferOperator:" + LiteTransferWrapper.access$200(this.this$0) + " threadId:" + Thread.currentThread().getId());
        long l = LiteTransferWrapper.access$200(this.this$0);
        LiteTransferWrapper.access$202(this.this$0, 0L);
        this.this$0.destryOperator(l, this.aQm);
      }
      LiteTransferWrapper.access$002(this.this$0, null);
      LiteTransferWrapper.access$102(this.this$0, null);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("dataline.LiteTTransferWrapper", 2, "cannot endLiteTransfer, load litetranfer library error?" + QLog.getStackTraceString(localUnsatisfiedLinkError));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.2
 * JD-Core Version:    0.7.0.1
 */