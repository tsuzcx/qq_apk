package com.weiyun.sdk.impl;

import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.protocol.BaseCallback;
import com.weiyun.sdk.util.Utils;

public abstract class BaseCallbackImpl<T, Y>
  extends BaseCallback<T>
{
  private final WyCommandImpl<Y> mCommand;
  
  public BaseCallbackImpl(WyCommandImpl<Y> paramWyCommandImpl)
  {
    this.mCommand = paramWyCommandImpl;
  }
  
  public void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, T paramT)
  {
    IWyFileSystem.IWyCallback localIWyCallback = this.mCommand.getCallback();
    if (localIWyCallback == null) {
      return;
    }
    if (paramWyErrorStatus.errorCode != 0)
    {
      if (Utils.isEmptyString(paramWyErrorStatus.errorMsg)) {
        paramWyErrorStatus.errorMsg = "出现错误，请重试!";
      }
      localIWyCallback.onFailed(paramWyErrorStatus);
      return;
    }
    handleSuccess(localIWyCallback, paramT);
  }
  
  protected abstract void handleSuccess(IWyFileSystem.IWyCallback<Y> paramIWyCallback, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.BaseCallbackImpl
 * JD-Core Version:    0.7.0.1
 */