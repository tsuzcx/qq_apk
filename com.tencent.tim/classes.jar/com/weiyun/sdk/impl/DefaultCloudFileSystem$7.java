package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.context.SdkContext.IndependentPasswordContext;
import tencent.im.cs.cmd0x31b.Cmd0X31B.QueryPwdRspBody;

class DefaultCloudFileSystem$7
  extends BaseCallbackImpl<Cmd0X31B.QueryPwdRspBody, Boolean>
{
  DefaultCloudFileSystem$7(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<Boolean> paramIWyCallback, Cmd0X31B.QueryPwdRspBody paramQueryPwdRspBody)
  {
    SdkContext.getInstance().getIPContext().setQueried();
    if (paramQueryPwdRspBody.uint32_pwd_open.get() == 1) {
      SdkContext.getInstance().getIPContext().setHasIndependentPassword();
    }
    paramIWyCallback.onSucceed(Boolean.valueOf(SdkContext.getInstance().getIPContext().hasIndependentPassword()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.7
 * JD-Core Version:    0.7.0.1
 */