import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class agjd
  implements agir.j
{
  agjd(agir.i parami, agir paramagir, MessageRecord paramMessageRecord) {}
  
  public void ch(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask fail, multiUniseq[ " + this.a.bHt + "] fileMrUniseq[" + this.x.uniseq + "] canResume[" + paramBoolean + "] retMsg[" + paramString + "]");
    }
    if (paramBoolean) {}
    for (this.a.status = 4;; this.a.status = 3)
    {
      agir.b(this.a.this$0, this.a.bHt);
      return;
      String str = acfp.m(2131711108) + this.x.getExtInfoFromExtStr("_m_ForwardFileName");
      paramString = str + "\n" + paramString;
      this.x.saveExtInfoToExtStr("_m_ForwardFaildReason", paramString);
      this.x.saveExtInfoToExtStr("_m_ForwardFileStatus", "2");
    }
  }
  
  public void w(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask success, multiUniseq[ " + this.a.bHt + "] uuid[" + paramString + "] fileMrUniseq[" + this.x.uniseq + "]");
    }
    this.a.status = 2;
    agir.a(this.a.this$0, this.x, paramBundle);
    agir.b(this.a.this$0, this.a.bHt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjd
 * JD-Core Version:    0.7.0.1
 */