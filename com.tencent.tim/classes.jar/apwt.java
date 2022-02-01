import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;

public class apwt
  extends apwr
{
  protected String ajA;
  private ITransactionCallback b;
  protected Transaction c;
  protected boolean cSU;
  
  public apwt(apwo paramapwo, int paramInt)
  {
    super(paramapwo, paramInt);
    this.jdField_b_of_type_ComTencentMobileqqHighwayApiITransactionCallback = new apwu(this);
  }
  
  public void ecw()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
    if (this.c != null) {
      this.c.cancelTransaction();
    }
  }
  
  public void ecx()
  {
    String str1 = this.a.cover;
    String str2 = this.a.filePath;
    boolean bool2 = rc(str1);
    boolean bool1 = false;
    if (bool2) {
      bool1 = rd(str2);
    }
    if ((bool2) && (bool1)) {
      return;
    }
    onFailed();
  }
  
  public void ecy()
  {
    if ((this.cST) && (this.cSU)) {
      ecz();
    }
  }
  
  public void ecz()
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("isVideo", 1);
    if ((this.picUrl != null) && (this.ajA != null))
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.picUrl);
      localBundle.putString("vid", this.ajA);
    }
    for (;;)
    {
      apwp.a().b(bool, this.callbackId, localBundle);
      return;
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
      bool = false;
    }
  }
  
  protected boolean rd(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "uploadVideo path= " + paramString);
    }
    ITransactionCallback localITransactionCallback = this.jdField_b_of_type_ComTencentMobileqqHighwayApiITransactionCallback;
    QQAppInterface localQQAppInterface = getAppInterface();
    String str = localQQAppInterface.getCurrentUin();
    byte[] arrayOfByte;
    File localFile;
    if (localQQAppInterface != null)
    {
      arrayOfByte = adgp.t(paramString);
      localFile = new File(paramString);
      if (arrayOfByte != null) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "uploadVideo md5 null ");
      }
    }
    label93:
    int i;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 1, "uploadVideo,file length " + new File(paramString).length());
      }
      PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
      localPttShortVideoUploadReq.setHasFlag(true);
      localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(str));
      localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(str));
      localPttShortVideoUploadReq.uint32_chat_type.set(1);
      localPttShortVideoUploadReq.uint32_client_type.set(1);
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(str));
      localPttShortVideoUploadReq.uint32_agent_type.set(0);
      localPttShortVideoUploadReq.uint32_business_type.set(3001);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(localFile.getName());
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(arrayOfByte));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(arrayOfByte));
      localPttShortVideoFileInfo.uint64_file_size.set(localFile.length());
      localPttShortVideoFileInfo.uint32_file_res_length.set(0);
      localPttShortVideoFileInfo.uint32_file_res_width.set(0);
      localPttShortVideoFileInfo.uint32_file_format.set(3);
      localPttShortVideoFileInfo.uint32_file_time.set((int)this.a.videoDuration);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(0L);
      localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      paramString = new Transaction(str, 74, paramString, 0, arrayOfByte, localITransactionCallback, localPttShortVideoUploadReq.toByteArray(), false);
      i = localQQAppInterface.getHwEngine().submitTransactionTask(paramString);
      if (i == 0)
      {
        this.c = paramString;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "uploadVideo submitTransactionTask  retCode= " + i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwt
 * JD-Core Version:    0.7.0.1
 */