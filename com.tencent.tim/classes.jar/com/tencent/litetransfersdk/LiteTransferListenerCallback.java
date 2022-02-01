package com.tencent.litetransfersdk;

public abstract interface LiteTransferListenerCallback
{
  public abstract void OnGroupComplete(int paramInt1, int paramInt2);
  
  public abstract void OnGroupStart(int paramInt);
  
  public abstract void OnSessionComplete(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo);
  
  public abstract void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void OnSessionStart(long paramLong);
  
  public abstract void OnSessionUpdate(int paramInt, long paramLong, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferListenerCallback
 * JD-Core Version:    0.7.0.1
 */