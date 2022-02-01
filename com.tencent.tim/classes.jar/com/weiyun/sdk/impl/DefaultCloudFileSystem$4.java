package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.PBStringField;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import tencent.im.cs.cmd0x31b.Cmd0X31B.FilePreviewRspBody;

class DefaultCloudFileSystem$4
  extends BaseCallbackImpl<Cmd0X31B.FilePreviewRspBody, String>
{
  DefaultCloudFileSystem$4(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<String> paramIWyCallback, Cmd0X31B.FilePreviewRspBody paramFilePreviewRspBody)
  {
    paramIWyCallback.onSucceed(paramFilePreviewRspBody.str_url.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.4
 * JD-Core Version:    0.7.0.1
 */