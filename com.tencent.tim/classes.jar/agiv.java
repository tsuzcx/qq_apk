import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class agiv
  implements aghr.a
{
  agiv(agir.c paramc, String paramString, agir.j paramj) {}
  
  public void cr(int paramInt, String paramString)
  {
    boolean bool3 = false;
    boolean bool4 = true;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2TroopTaskExcuter onFaild retcode[" + paramInt + "] retMsg[" + paramString + "]");
    boolean bool2 = bool3;
    boolean bool1 = bool4;
    if (paramInt != -100001)
    {
      bool2 = bool3;
      bool1 = bool4;
      if (paramInt != -100002)
      {
        if (paramInt != -100003) {
          break label107;
        }
        bool1 = bool4;
        bool2 = bool3;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$c.mFileSize, bool2), bool1);
      return;
      label107:
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        bool1 = false;
        bool2 = bool3;
      }
    }
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "3");
    localBundle.putString("_m_ForwardReceiverUin", this.Lw);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Agir$c.mFileName);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Agir$c.mFileSize + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Agir$c.md5);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Agir$c.bHn);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Agir$c.bHo);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Agir$c.bHn))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Agir$c.bHo)) {
        break label267;
      }
    }
    label267:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Agir$c.bHo))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$c.mFileName + " Buddy2TroopTaskExcuter send success, send feeds");
      }
      agir.b(agir.a(this.jdField_a_of_type_Agir$c.this$0), Long.parseLong(this.Lw), 102, paramString1, this.jdField_a_of_type_Agir$c.mFileSize, 0, i, j, 0, false, localBundle, this.jdField_a_of_type_Agir$j);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Agir$c.bHn);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agiv
 * JD-Core Version:    0.7.0.1
 */