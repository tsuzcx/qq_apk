package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$7
  implements Runnable
{
  ExcitingTransferEngine$7(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong1, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingRecvJobContent localExcitingRecvJobContent = ExcitingTransferEngine.access$200(this.this$0, this.ZN);
    if (localExcitingRecvJobContent == null) {}
    while (localExcitingRecvJobContent.mListener == null) {
      return;
    }
    localExcitingRecvJobContent.mListener.onRecvProgress(this.ZO, this.ZP, this.ZQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.7
 * JD-Core Version:    0.7.0.1
 */