import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cloudfile.FileInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody;

class atez
  extends jnm.d
{
  atez(ateh paramateh, MessageForTroopFile paramMessageForTroopFile, atgc paramatgc) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, null, paramBundle);
      return;
    }
    oidb_0x6d9.RspBody localRspBody = new oidb_0x6d9.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.copy_to_rsp.has())
      {
        a(true, localRspBody.copy_to_rsp, paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, localRspBody.copy_to_rsp, paramBundle);
      return;
    }
    a(false, localRspBody.copy_to_rsp, paramBundle);
  }
  
  public void a(boolean paramBoolean, oidb_0x6d9.CopyToRspBody paramCopyToRspBody, Bundle paramBundle)
  {
    Object localObject = "";
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.fileName = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName;
    localFileInfo.fileSize = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.sha1 == null)
    {
      paramBundle = null;
      localFileInfo.fileSha = paramBundle;
      localFileInfo.fileSrcType = 1;
      localFileInfo.width = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width;
      localFileInfo.height = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height;
      localFileInfo.duration = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.duration;
      if ((!paramBoolean) || (paramCopyToRspBody == null)) {
        break label463;
      }
      if (!paramCopyToRspBody.int32_ret_code.has()) {
        break label457;
      }
      i = paramCopyToRspBody.int32_ret_code.get();
      label125:
      if (!paramCopyToRspBody.str_ret_msg.has()) {
        break label451;
      }
      paramBundle = paramCopyToRspBody.str_ret_msg.get();
      label143:
      String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName;
      if ((!paramBoolean) || (i != 0)) {
        break label445;
      }
      if (paramCopyToRspBody.str_file_name.has()) {
        paramCopyToRspBody.str_file_name.get();
      }
      if (!paramCopyToRspBody.str_save_file_path.has()) {
        break label439;
      }
      paramCopyToRspBody = paramCopyToRspBody.str_save_file_path.get();
      label197:
      if (!TextUtils.isEmpty(paramCopyToRspBody)) {
        atgi.a().notifyAirCopySuccess(paramCopyToRspBody.getBytes(), this.jdField_a_of_type_Atgc.aG(), localFileInfo);
      }
    }
    for (;;)
    {
      if ((!paramBoolean) || (i != 0)) {
        QLog.e("CloudFileHandler", 1, "handleCopyFileToCloudC2C fail retCode = " + i + "retMsg = " + paramBundle + "fileName = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName + "peerUin = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "fileSize = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize + "uuid = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.url + "bSend = " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.issend);
      }
      localObject = this.this$0;
      if (i == 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((ateh)localObject).notifyUI(20, paramBoolean, new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, Integer.valueOf(i), paramBundle });
        atgi.a().manualAirCopyReportData(paramCopyToRspBody.getBytes(), this.jdField_a_of_type_Atgc.aG(), localFileInfo, 1, 4, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), i);
        return;
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.sha1.getBytes();
        break;
      }
      label439:
      paramCopyToRspBody = "";
      break label197;
      label445:
      paramCopyToRspBody = (oidb_0x6d9.CopyToRspBody)localObject;
      continue;
      label451:
      paramBundle = "";
      break label143;
      label457:
      i = -1;
      break label125;
      label463:
      i = -1;
      paramBundle = "";
      paramCopyToRspBody = (oidb_0x6d9.CopyToRspBody)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atez
 * JD-Core Version:    0.7.0.1
 */