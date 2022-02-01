import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class agja
  implements aghr.a
{
  agja(agir.g paramg, String paramString, agir.j paramj) {}
  
  public void cr(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2TroopTaskExcuter onFaild：");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$g.mFileName + " Disc2TroopTaskExcuter send faild:" + paramInt);
      }
      this.jdField_a_of_type_Agir$j.ch(agir.j(this.jdField_a_of_type_Agir$g.mFileSize, bool2), bool1);
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
    paramString2.putString("_m_ForwardFileType", "3");
    paramString2.putString("_m_ForwardReceiverUin", this.Lw);
    paramString2.putString("_m_ForwardFileName", this.jdField_a_of_type_Agir$g.mFileName);
    paramString2.putString("_m_ForwardSize", this.jdField_a_of_type_Agir$g.mFileSize + "");
    paramString2.putString("_m_ForwardMd5", this.jdField_a_of_type_Agir$g.md5);
    paramString2.putString("_m_ForwardDeadTime", "0");
    paramString2.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Agir$g.bHn);
    paramString2.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Agir$g.bHo);
    paramString2.putString("_m_ForwardUuid", paramString1);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Agir$g.bHn))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Agir$g.bHo)) {
        break label248;
      }
    }
    label248:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Agir$g.bHo))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Agir$g.mFileName + " Disc2TroopTaskExcuter send success send feeds");
      }
      agir.b(agir.a(this.jdField_a_of_type_Agir$g.this$0), Long.parseLong(this.Lw), 102, paramString1, this.jdField_a_of_type_Agir$g.mFileSize, 0, i, j, 0, false, paramString2, this.jdField_a_of_type_Agir$j);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Agir$g.bHn);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agja
 * JD-Core Version:    0.7.0.1
 */