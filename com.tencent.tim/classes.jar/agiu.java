import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class agiu
  implements aghr.a
{
  agiu(agir.b paramb, String paramString, agir.j paramj) {}
  
  public void cr(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2DiscTaskExcuter faild");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$b.mFileName + " Buddy2DiscTaskExcuter faild:" + paramInt);
      }
      this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$b.mFileSize, bool2), bool1);
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "2");
    localBundle.putString("_m_ForwardReceiverUin", this.Lw);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Agir$b.mFileName);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Agir$b.mFileSize + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Agir$b.md5);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Agir$b.bHn);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Agir$b.bHo);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    if (QLog.isColorLevel()) {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$b.mFileName + " Buddy2DiscTaskExcuter success");
    }
    this.jdField_a_of_type_Agir$j.w(paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agiu
 * JD-Core Version:    0.7.0.1
 */