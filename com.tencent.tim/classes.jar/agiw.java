import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;

public class agiw
  extends agij.c
{
  public agiw(QFileMsgForwardManager.BuddyUploadTaskExcuter.1 param1, agik paramagik, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean, int paramInt, cmd0x346.ApplyUploadRspV3 paramApplyUploadRspV3)
  {
    if ((paramInt == -100001) || (paramInt == -100002))
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild，retCode[" + paramInt + "]" + this.a.jdField_a_of_type_Agir$d.mFileName);
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), true);
    }
    while (paramApplyUploadRspV3 == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild，retCode[" + paramInt + "], but rspV3 is null" + this.a.jdField_a_of_type_Agir$d.mFileName);
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), false);
      return;
      if (paramInt == -100003)
      {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild，retCode[" + paramInt + "]" + this.a.jdField_a_of_type_Agir$d.mFileName);
        this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), false);
        return;
      }
    }
    if (!paramApplyUploadRspV3.int32_ret_code.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild not has int32_ret_code" + this.a.jdField_a_of_type_Agir$d.mFileName);
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), false);
      return;
    }
    if (paramApplyUploadRspV3.int32_ret_code.get() != 0)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " BuddyUploadTaskExcuter faild，retcode:" + paramApplyUploadRspV3.int32_ret_code.get());
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), false);
      return;
    }
    if ((paramApplyUploadRspV3.bool_file_exist.has()) && (paramApplyUploadRspV3.bytes_uuid.has()))
    {
      paramApplyUploadRspV3 = paramApplyUploadRspV3.bytes_uuid.get().toByteArray();
      if ((paramApplyUploadRspV3 != null) && (paramApplyUploadRspV3.length > 0))
      {
        str1 = new String(paramApplyUploadRspV3);
        agir.d.a(this.a.jdField_a_of_type_Agir$d).putString("_m_ForwardUuid", str1);
        this.c.a(this.a.Lw, paramApplyUploadRspV3, 5000, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start sendLocalFileToBuddyBySHA cs hit:" + this.a.jdField_a_of_type_Agir$d.mFileName);
        }
        this.a.jdField_a_of_type_Agir$j.w(str1, agir.d.a(this.a.jdField_a_of_type_Agir$d));
        return;
      }
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " BuddyUploadTaskExcuter faild，file exist bug uuid is null");
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), true);
      return;
    }
    if (!paramApplyUploadRspV3.bytes_upload_key.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " BuddyUploadTaskExcuter faild，uploadkey is null");
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), true);
      return;
    }
    if (!paramApplyUploadRspV3.bytes_uuid.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " BuddyUploadTaskExcuter faild，uuid is null");
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), true);
      return;
    }
    if (!paramApplyUploadRspV3.str_upload_https_domain.has())
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " BuddyUploadTaskExcuter faild，https domain is null");
      this.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.jdField_a_of_type_Agir$d.mFileSize, false), true);
      return;
    }
    String str1 = paramApplyUploadRspV3.str_upload_https_domain.get();
    paramBoolean = agmx.aE(agir.a(this.a.jdField_a_of_type_Agir$d.this$0));
    ByteStringMicro localByteStringMicro = paramApplyUploadRspV3.bytes_uuid.get();
    String str2 = new String(localByteStringMicro.toByteArray());
    String str3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(paramApplyUploadRspV3.bytes_upload_key.get().toByteArray());
    paramApplyUploadRspV3 = paramApplyUploadRspV3.str_upload_ip.get();
    if (paramBoolean) {}
    for (paramApplyUploadRspV3 = "https://" + paramApplyUploadRspV3 + "/ftn_handler";; paramApplyUploadRspV3 = "http://" + paramApplyUploadRspV3 + "/ftn_handler")
    {
      String str4 = com.qq.taf.jce.HexUtil.bytes2HexStr(this.dN);
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " sendLocalFileToBuddyBySHA cs nohit, start uploadFile");
      }
      paramApplyUploadRspV3 = new agii(agir.a(this.a.jdField_a_of_type_Agir$d.this$0), this.a.jdField_a_of_type_Agir$d.mFilePath, this.a.jdField_a_of_type_Agir$d.mFileSize, str3, str4, paramApplyUploadRspV3, paramBoolean, str1, new agix(this, localByteStringMicro, str2));
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.a.jdField_a_of_type_Agir$d.mFileName + " add to rsCenter");
      }
      agir.d.a(this.a.jdField_a_of_type_Agir$d, ahav.d().longValue());
      agir.a(this.a.jdField_a_of_type_Agir$d.this$0).a().a(agir.d.a(this.a.jdField_a_of_type_Agir$d), paramApplyUploadRspV3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agiw
 * JD-Core Version:    0.7.0.1
 */