package com.tencent.qqmail.ftn;

import com.tencent.qqmail.ftn.callback.FtnQueryExpireCallback;
import com.tencent.qqmail.ftn.model.FtnExpireInfo;

class FtnManager$1$1
  implements FtnQueryExpireCallback
{
  FtnManager$1$1(FtnManager.1 param1) {}
  
  public void onComplete(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    FtnExpireInfo localFtnExpireInfo = FtnManager.access$100(this.this$1.this$0).readFtnExpireInfo(paramLong);
    boolean bool2;
    int i;
    if (localFtnExpireInfo != null)
    {
      bool2 = false;
      i = localFtnExpireInfo.getLstExpireCnt();
      if (localFtnExpireInfo.getAccountId() == -2L)
      {
        localFtnExpireInfo.setAccountId(paramLong);
        localFtnExpireInfo.setLstExpireCnt(paramInt1);
        localFtnExpireInfo.setLstTotalCnt(paramInt2);
        localFtnExpireInfo.setLstUpdateTime(System.currentTimeMillis());
        this.this$1.this$0.insertFtnExpireInfo(localFtnExpireInfo);
        this.this$1.this$0.getList();
      }
    }
    else
    {
      return;
    }
    boolean bool1;
    if (i == paramInt1)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.equals(localFtnExpireInfo.getLstExpHashId())) {}
      }
    }
    else
    {
      bool1 = true;
      localFtnExpireInfo.setAccountId(paramLong);
      localFtnExpireInfo.setLstExpireCnt(paramInt1);
      localFtnExpireInfo.setLstTotalCnt(paramInt2);
      localFtnExpireInfo.setLstUpdateTime(System.currentTimeMillis());
      this.this$1.this$0.insertFtnExpireInfo(localFtnExpireInfo);
    }
    this.this$1.this$0.triggerFtnQueryExpireUnreadSuccess(paramLong, localFtnExpireInfo, bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.1.1
 * JD-Core Version:    0.7.0.1
 */