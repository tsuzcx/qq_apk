package com.weiyun.sdk.impl;

import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DeleteFileRspBody;

class DefaultCloudFileSystem$5
  extends BaseCallbackImpl<Cmd0X31B.DeleteFileRspBody, Void>
{
  DefaultCloudFileSystem$5(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<Void> paramIWyCallback, Cmd0X31B.DeleteFileRspBody paramDeleteFileRspBody)
  {
    paramIWyCallback.onSucceed(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.5
 * JD-Core Version:    0.7.0.1
 */