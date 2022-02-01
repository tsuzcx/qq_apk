package com.tencent.litetransfersdk;

class LiteTransferWrapper$7
  implements Runnable
{
  LiteTransferWrapper$7(LiteTransferWrapper paramLiteTransferWrapper, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L) {
      this.this$0.CancelGroupToJNI(LiteTransferWrapper.access$200(this.this$0), this.bCV, this.EN, this.bCW, this.aQr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.7
 * JD-Core Version:    0.7.0.1
 */