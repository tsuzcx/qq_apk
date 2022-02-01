import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

class agix
  implements agii.a
{
  agix(agiw paramagiw, ByteStringMicro paramByteStringMicro, String paramString) {}
  
  public void IZ(boolean paramBoolean)
  {
    agir.a(this.a.a.jdField_a_of_type_Agir$d.this$0).a().jp(agir.d.a(this.a.a.jdField_a_of_type_Agir$d));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.a.a.jdField_a_of_type_Agir$d.mFileName + " sendLocalFileToBuddyBySHA uploadFile success");
      }
      this.a.c.a(this.a.a.Lw, this.d.toByteArray(), 5000, 3, null);
      agir.d.a(this.a.a.jdField_a_of_type_Agir$d).putString("_m_ForwardUuid", this.bHr);
      this.a.a.jdField_a_of_type_Agir$j.w(this.bHr, agir.d.a(this.a.a.jdField_a_of_type_Agir$d));
      return;
    }
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.a.a.jdField_a_of_type_Agir$d.mFileName + " BuddyUploadTaskExcuter faild");
    this.a.a.jdField_a_of_type_Agir$j.ch(agir.j(this.a.a.jdField_a_of_type_Agir$d.mFileSize, false), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agix
 * JD-Core Version:    0.7.0.1
 */