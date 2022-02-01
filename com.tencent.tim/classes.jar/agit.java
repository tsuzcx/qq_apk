import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class agit
  implements aghr.a
{
  agit(agir.a parama, String paramString, agir.j paramj) {}
  
  public void cr(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2BuddyTaskExcuter faild");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.jdField_a_of_type_Agir$a.mFileName + "] faild:" + paramInt);
      }
      this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$a.mFileSize, bool2), bool1);
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
    localBundle.putString("_m_ForwardFileType", "1");
    localBundle.putString("_m_ForwardReceiverUin", this.Lw);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Agir$a.mFileName);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Agir$a.mFileSize + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Agir$a.md5);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Agir$a.bHn);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Agir$a.bHo);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.jdField_a_of_type_Agir$a.mFileName + "] success");
    }
    this.jdField_a_of_type_Agir$j.w(paramString1, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agit
 * JD-Core Version:    0.7.0.1
 */