package com.weiyun.sdk.channel;

import com.weiyun.sdk.IWySender;
import com.weiyun.sdk.IWySender.IWySenderCallback;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SenderHelper
  implements ISender, IWySender.IWySenderCallback
{
  private ConcurrentHashMap<Integer, ISender.ICallback> mReqContext = new ConcurrentHashMap();
  private volatile IWySender mSender;
  private AtomicInteger mSeq = new AtomicInteger(0);
  
  public SenderHelper(IWySender paramIWySender)
  {
    this.mSender = paramIWySender;
    paramIWySender.setCallback(this);
  }
  
  public void onRespond(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ISender.ICallback localICallback = (ISender.ICallback)this.mReqContext.remove(Integer.valueOf(paramInt1));
    if (localICallback != null) {
      localICallback.onRespond(paramInt2, paramArrayOfByte);
    }
  }
  
  public void releaseSender()
  {
    IWySender localIWySender = this.mSender;
    if (localIWySender != null)
    {
      localIWySender.cancelCallback();
      this.mReqContext.clear();
    }
    this.mSender = null;
  }
  
  public boolean sendRequest(String paramString, byte[] paramArrayOfByte, ISender.ICallback paramICallback)
  {
    int i = this.mSeq.incrementAndGet();
    IWySender localIWySender = this.mSender;
    if (localIWySender != null)
    {
      this.mReqContext.put(Integer.valueOf(i), paramICallback);
      localIWySender.sendRequest(i, paramString, paramArrayOfByte);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.channel.SenderHelper
 * JD-Core Version:    0.7.0.1
 */