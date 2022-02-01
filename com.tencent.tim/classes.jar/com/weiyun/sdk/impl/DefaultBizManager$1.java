package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.PBBoolField;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import tencent.im.cs.cmd0x31b.Cmd0X31B.AlbumStatusReportRspBody;

class DefaultBizManager$1
  extends BaseCallbackImpl<Cmd0X31B.AlbumStatusReportRspBody, Boolean>
{
  DefaultBizManager$1(DefaultBizManager paramDefaultBizManager, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<Boolean> paramIWyCallback, Cmd0X31B.AlbumStatusReportRspBody paramAlbumStatusReportRspBody)
  {
    paramIWyCallback.onSucceed(Boolean.valueOf(paramAlbumStatusReportRspBody.bool_need_red_touch.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultBizManager.1
 * JD-Core Version:    0.7.0.1
 */