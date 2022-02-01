import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class agiz
  implements aghr.a
{
  agiz(agir.f paramf, String paramString, agir.j paramj) {}
  
  public void cr(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2DiscTaskExcuter onFaild：");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$f.mFileName + " Disc2DiscTaskExcuter send faild:" + paramInt);
      }
      this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$f.mFileSize, bool2), bool1);
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
    paramString2 = new Bundle();
    paramString2.putString("_m_ForwardFileType", "2");
    paramString2.putString("_m_ForwardReceiverUin", this.Lw);
    paramString2.putString("_m_ForwardFileName", this.jdField_a_of_type_Agir$f.mFileName);
    paramString2.putString("_m_ForwardSize", this.jdField_a_of_type_Agir$f.mFileSize + "");
    paramString2.putString("_m_ForwardMd5", this.jdField_a_of_type_Agir$f.md5);
    paramString2.putString("_m_ForwardDeadTime", "0");
    paramString2.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Agir$f.bHn);
    paramString2.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Agir$f.bHo);
    paramString2.putString("_m_ForwardUuid", paramString1);
    if (QLog.isColorLevel()) {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$f.mFileName + " Disc2DiscTaskExcuter send success");
    }
    this.jdField_a_of_type_Agir$j.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agiz
 * JD-Core Version:    0.7.0.1
 */