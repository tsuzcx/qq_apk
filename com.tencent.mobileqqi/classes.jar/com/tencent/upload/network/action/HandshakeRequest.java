package com.tencent.upload.network.action;

import FileUpload.FileUploadHandShakeReq;
import FileUpload.SvcRequestHead;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadLog;
import com.tencent.upload.protocol.utils.ProtocolUtil;
import java.io.File;

public class HandshakeRequest
  implements IActionRequest
{
  private final int mActionSequence;
  private final int mRedirect;
  private final SvcRequestHead mRequestHead;
  private final int mRequestSequence;
  
  public HandshakeRequest(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRedirect = paramInt3;
    this.mActionSequence = paramInt1;
    this.mRequestSequence = paramInt2;
    this.mRequestHead = new SvcRequestHead();
    this.mRequestHead.seq = ProtocolUtil.toProtocolSequence(paramInt1, paramInt2);
  }
  
  public byte[] encode()
  {
    Object localObject2 = new FileUploadHandShakeReq();
    ((FileUploadHandShakeReq)localObject2).iRedirect = this.mRedirect;
    Object localObject1 = null;
    try
    {
      localObject2 = ProtocolUtil.pack(localObject2.getClass().getSimpleName(), localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        UploadLog.w(HandshakeRequest.class.getSimpleName(), localException1);
      }
      this.mRequestHead.iVersionId = 3;
      this.mRequestHead.iCmdID = 1000;
      this.mRequestHead.iUin = UploadConfiguration.getCurrentUin();
      this.mRequestHead.vLoginData = new byte[0];
      this.mRequestHead.vLoginKey = new byte[0];
      localObject3 = null;
    }
    if (localObject1 == null) {}
    do
    {
      return null;
      try
      {
        arrayOfByte = ProtocolUtil.pack(this.mRequestHead.getClass().getSimpleName(), this.mRequestHead);
        localObject3 = arrayOfByte;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          byte[] arrayOfByte;
          UploadLog.w(HandshakeRequest.class.getSimpleName(), localException2);
        }
      }
    } while (localObject3 == null);
    arrayOfByte = new byte[localObject1.length + localObject3.length];
    System.arraycopy(localObject3, 0, arrayOfByte, 0, localObject3.length);
    System.arraycopy(localObject1, 0, arrayOfByte, localObject3.length, localObject1.length);
    return arrayOfByte;
  }
  
  public int getActionSequence()
  {
    return this.mActionSequence;
  }
  
  public int getCommandId()
  {
    return 1000;
  }
  
  public File getFile()
  {
    return null;
  }
  
  public int getFileOffset()
  {
    return 0;
  }
  
  public int getFileSendLenght()
  {
    return 0;
  }
  
  public SvcRequestHead getRequestHead()
  {
    return this.mRequestHead;
  }
  
  public int getRequestSequence()
  {
    return this.mRequestSequence;
  }
  
  public boolean isPartFileMode()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.network.action.HandshakeRequest
 * JD-Core Version:    0.7.0.1
 */