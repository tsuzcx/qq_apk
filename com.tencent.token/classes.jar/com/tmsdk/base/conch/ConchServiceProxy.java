package com.tmsdk.base.conch;

import btmsdkobf.bk;
import btmsdkobf.z;
import java.util.List;

public class ConchServiceProxy
  implements ConchService
{
  private static volatile ConchServiceProxy u = null;
  private long t;
  
  private ConchServiceProxy(long paramLong)
  {
    this.t = paramLong;
  }
  
  public static ConchServiceProxy getInstance()
  {
    if (u == null) {}
    try
    {
      if (u == null) {
        u = new ConchServiceProxy(4294967296L);
      }
      return u;
    }
    finally {}
  }
  
  public void pullConch(int paramInt)
  {
    bk.G().b(this.t, paramInt);
  }
  
  public void registerConchPush(int paramInt, ConchService.IConchPushListener paramIConchPushListener)
  {
    bk.G().a(this.t, paramInt, paramIConchPushListener);
  }
  
  public void registerConchPush(List<Integer> paramList, ConchService.IConchPushListener paramIConchPushListener)
  {
    bk.G().a(this.t, paramList, paramIConchPushListener);
  }
  
  public void registerSharkPush()
  {
    bk.G().registerSharkPush();
  }
  
  public void reportConchResult(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bk.G().a(this.t, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void reportConchResult(ConchService.ConchPushInfo paramConchPushInfo, int paramInt1, int paramInt2)
  {
    bk.G().a(this.t, paramConchPushInfo.mTaskId, paramConchPushInfo.mTaskSeqno, paramConchPushInfo.mConch.cmdId, paramConchPushInfo.mConch.ba, paramInt1, paramInt2);
  }
  
  public void unRegisterConchPush(int paramInt)
  {
    bk.G().a(this.t, paramInt);
  }
  
  public void unRegisterConchPush(List<Integer> paramList)
  {
    bk.G().a(this.t, paramList);
  }
  
  public void unRegisterSharkPush()
  {
    bk.G().unRegisterSharkPush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.conch.ConchServiceProxy
 * JD-Core Version:    0.7.0.1
 */