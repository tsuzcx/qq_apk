package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.PreviewAdderss;
import tencent.im.cs.cmd0x31b.Cmd0X31B.StoreFilePreviewRspBody;

class DefaultCloudFileSystem$9
  extends BaseCallbackImpl<Cmd0X31B.StoreFilePreviewRspBody, IWyFileSystem.PreviewAdderss>
{
  DefaultCloudFileSystem$9(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<IWyFileSystem.PreviewAdderss> paramIWyCallback, Cmd0X31B.StoreFilePreviewRspBody paramStoreFilePreviewRspBody)
  {
    if (paramStoreFilePreviewRspBody.filesha.has()) {}
    for (byte[] arrayOfByte1 = paramStoreFilePreviewRspBody.filesha.get().toByteArray();; arrayOfByte1 = null)
    {
      if (paramStoreFilePreviewRspBody.downloadkey.has()) {}
      for (byte[] arrayOfByte2 = paramStoreFilePreviewRspBody.downloadkey.get().toByteArray();; arrayOfByte2 = null)
      {
        paramIWyCallback.onSucceed(new IWyFileSystem.PreviewAdderss(paramStoreFilePreviewRspBody.downloadip.get(), paramStoreFilePreviewRspBody.downloaddns.get(), paramStoreFilePreviewRspBody.downloadport.get(), arrayOfByte1, arrayOfByte2, paramStoreFilePreviewRspBody.cookie.get()));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.9
 * JD-Core Version:    0.7.0.1
 */