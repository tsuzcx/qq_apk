package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.CommonFtnFile;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import tencent.im.cs.cmd0x31b.Cmd0X31B.QCloud2FtnRspBody;

class DefaultCloudFileSystem$6
  extends BaseCallbackImpl<Cmd0X31B.QCloud2FtnRspBody, IWyFileSystem.CommonFtnFile>
{
  DefaultCloudFileSystem$6(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<IWyFileSystem.CommonFtnFile> paramIWyCallback, Cmd0X31B.QCloud2FtnRspBody paramQCloud2FtnRspBody)
  {
    paramIWyCallback.onSucceed(new IWyFileSystem.CommonFtnFile(paramQCloud2FtnRspBody.str_file_path.get(), paramQCloud2FtnRspBody.uint32_safe_level.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.6
 * JD-Core Version:    0.7.0.1
 */