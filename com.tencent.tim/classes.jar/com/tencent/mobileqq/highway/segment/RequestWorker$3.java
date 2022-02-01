package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.transaction.Transaction;

class RequestWorker$3
  implements Runnable
{
  RequestWorker$3(RequestWorker paramRequestWorker, Transaction paramTransaction, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    this.this$0.sendFinishQueryRequest(this.val$trans, this.val$sentBitmap, this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.segment.RequestWorker.3
 * JD-Core Version:    0.7.0.1
 */