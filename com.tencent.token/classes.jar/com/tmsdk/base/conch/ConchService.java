package com.tmsdk.base.conch;

import java.util.List;

public abstract interface ConchService
{
  public abstract void pullConch(int paramInt);
  
  public abstract void registerConchPush(int paramInt, ConchService.IConchPushListener paramIConchPushListener);
  
  public abstract void registerConchPush(List paramList, ConchService.IConchPushListener paramIConchPushListener);
  
  public abstract void registerSharkPush();
  
  public abstract void reportConchResult(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void reportConchResult(ConchService.ConchPushInfo paramConchPushInfo, int paramInt1, int paramInt2);
  
  public abstract void unRegisterConchPush(int paramInt);
  
  public abstract void unRegisterConchPush(List paramList);
  
  public abstract void unRegisterSharkPush();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.conch.ConchService
 * JD-Core Version:    0.7.0.1
 */