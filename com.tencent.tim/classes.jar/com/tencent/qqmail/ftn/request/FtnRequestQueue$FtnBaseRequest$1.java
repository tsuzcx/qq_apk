package com.tencent.qqmail.ftn.request;

import com.tencent.qqmail.ftn.FtnDefine.FtnCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class FtnRequestQueue$FtnBaseRequest$1
  extends FtnDefine.FtnCallback
{
  FtnRequestQueue$FtnBaseRequest$1(FtnRequestQueue.FtnBaseRequest paramFtnBaseRequest) {}
  
  public void onBeforeSend()
  {
    this.this$1.mQueueHandler.markAlive(this.this$1);
    this.this$1.mCallback.onBeforeSend();
  }
  
  public void onComplete()
  {
    this.this$1.mQueueHandler.completeRequest(this.this$1);
    this.this$1.mCallback.onComplete();
  }
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(5, "FtnRequestQueue", "Request onError: " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramString + ", " + this.this$1.retryCount);
    this.this$1.mCallback.onError(paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void onProcessData(long paramLong1, long paramLong2)
  {
    if (!this.this$1.mAborted)
    {
      this.this$1.mQueueHandler.markAlive(this.this$1);
      this.this$1.mCallback.onProcessData(paramLong1, paramLong2);
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.this$1.mCallback.onSuccess(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.request.FtnRequestQueue.FtnBaseRequest.1
 * JD-Core Version:    0.7.0.1
 */