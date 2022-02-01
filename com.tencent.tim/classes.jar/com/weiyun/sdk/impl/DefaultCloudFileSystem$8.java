package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.context.SdkContext.IndependentPasswordContext;
import com.weiyun.sdk.util.UtilsMisc;
import tencent.im.cs.cmd0x31b.Cmd0X31B.VerifyPwdRspBody;

class DefaultCloudFileSystem$8
  extends BaseCallbackImpl<Cmd0X31B.VerifyPwdRspBody, String>
{
  DefaultCloudFileSystem$8(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<String> paramIWyCallback, Cmd0X31B.VerifyPwdRspBody paramVerifyPwdRspBody)
  {
    SdkContext.getInstance().getIPContext().setVerifySuccess();
    paramVerifyPwdRspBody = paramVerifyPwdRspBody.bytes_cs_sig.get().toByteArray();
    paramIWyCallback.onSucceed(UtilsMisc.byteArrayToHexString(paramVerifyPwdRspBody, paramVerifyPwdRspBody.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.8
 * JD-Core Version:    0.7.0.1
 */