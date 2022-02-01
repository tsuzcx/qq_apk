package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

class ExcitingTransferEngine$1
  implements Runnable
{
  ExcitingTransferEngine$1(ExcitingTransferEngine paramExcitingTransferEngine, long paramLong) {}
  
  public void run()
  {
    ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = ExcitingTransferEngine.access$000(this.this$0, this.ZL);
    if (localExcitingSendJobContent == null) {}
    while (localExcitingSendJobContent.mListener == null) {
      return;
    }
    localExcitingSendJobContent.mListener.onExcitingSendStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.1
 * JD-Core Version:    0.7.0.1
 */