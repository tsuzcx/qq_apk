package com.tencent.litetransfersdk;

class LiteTransferWrapper$4
  implements Runnable
{
  LiteTransferWrapper$4(LiteTransferWrapper paramLiteTransferWrapper, Session[] paramArrayOfSession) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L) {
      this.this$0.SyncGroupToJNI(LiteTransferWrapper.access$200(this.this$0), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.4
 * JD-Core Version:    0.7.0.1
 */