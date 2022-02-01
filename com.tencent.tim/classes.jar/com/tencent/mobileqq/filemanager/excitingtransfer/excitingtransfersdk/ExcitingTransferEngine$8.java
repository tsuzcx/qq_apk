package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$8
  implements Runnable
{
  ExcitingTransferEngine$8(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong, int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingRecvJobContent localExcitingRecvJobContent = ExcitingTransferEngine.access$200(this.this$0, this.ZN);
    if (localExcitingRecvJobContent == null) {}
    while (localExcitingRecvJobContent.mListener == null) {
      return;
    }
    localExcitingRecvJobContent.mListener.OnOneSlotComplete(this.cYE, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.8
 * JD-Core Version:    0.7.0.1
 */