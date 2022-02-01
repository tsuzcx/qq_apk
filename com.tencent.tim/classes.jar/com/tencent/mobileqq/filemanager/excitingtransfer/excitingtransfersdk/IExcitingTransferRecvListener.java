package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public abstract interface IExcitingTransferRecvListener
{
  public abstract void OnOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete);
  
  public abstract void OnSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo);
  
  public abstract void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo);
  
  public abstract void onRecvProgress(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void onRecvStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener
 * JD-Core Version:    0.7.0.1
 */