package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWySender;
import com.weiyun.sdk.IWySender.IWySenderCallback;

public class WeiYunLogicCenter$WySender
  implements IWySender
{
  private long jdField_a_of_type_Long = 1L;
  IWySender.IWySenderCallback jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback;
  
  public WeiYunLogicCenter$WySender(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt2 == 1002) {}
    for (this.jdField_a_of_type_Long += 1L;; this.jdField_a_of_type_Long = 1L)
    {
      this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback.onRespond(paramInt1, paramInt2, paramArrayOfByte);
      return;
    }
  }
  
  public void cancelCallback()
  {
    this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback = null;
  }
  
  public void sendRequest(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendRequest : seq[" + paramInt + "], strCmd is empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "sendRequest : seq[" + paramInt + "], strCmd[" + paramString + "]");
    }
    long l = (30000.0D * Math.pow(this.jdField_a_of_type_Long, 0.15D));
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a(), paramString);
    localToServiceMsg.extraData.putInt("Sequence", paramInt);
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.setTimeout(Math.min(60000L, l));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreWeiYunLogicCenter.a.a().a(localToServiceMsg, true);
  }
  
  public void setCallback(IWySender.IWySenderCallback paramIWySenderCallback)
  {
    this.jdField_a_of_type_ComWeiyunSdkIWySender$IWySenderCallback = paramIWySenderCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter.WySender
 * JD-Core Version:    0.7.0.1
 */