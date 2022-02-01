import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

final class agis
  extends smq.n
{
  agis(String paramString, agir.j paramj, long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult return failed fileid " + this.val$filePath);
      this.a.ch(agir.j(this.val$fileSize, false), true);
      return;
    }
    paramBundle.putString("_m_ForwardBusType", String.valueOf(paramInt2));
    paramBundle.putString("_m_ForwardDeadTime", String.valueOf(paramInt3));
    if (paramInt1 == 0)
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult success fileid " + this.val$filePath);
      this.a.w(this.val$filePath, paramBundle);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult return[" + paramInt1 + "] fileid " + this.val$filePath);
    this.a.ch(agir.j(this.val$fileSize, false), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agis
 * JD-Core Version:    0.7.0.1
 */