import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class agjf
  implements apfx.c
{
  agjf(agir.n paramn) {}
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, apfx.b paramb)
  {
    if (agir.n.a(this.a))
    {
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone but has been stopped WorkerId[" + agir.n.a(this.a) + "] filename " + agir.n.a(this.a));
      return;
    }
    if (!paramBoolean)
    {
      paramBoolean = paramb.aAY();
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone failed canResume[" + paramBoolean + "] errCode[" + paramInt + "] WorkerId[" + agir.n.a(this.a) + "] filename " + agir.n.a(this.a));
      agir.n.a(this.a).ch(agir.j(agir.n.a(this.a), false), paramBoolean);
      return;
    }
    paramUUID = paramb.Bi();
    String str1 = paramb.Bj();
    paramInt = paramb.Lp();
    String str2 = paramb.Bh();
    agir.n.a(this.a, paramb.getFileSize());
    int i = paramb.getImgWidth();
    int j = paramb.getImgHeight();
    int k = paramb.getVideoDuration();
    agir.n.a(this.a).putString("_m_ForwardMd5", paramUUID);
    agir.n.a(this.a).putString("_m_ForwardSha", str1);
    agir.n.a(this.a).putString("_m_ForwardBusType", String.valueOf(paramInt));
    agir.n.a(this.a).putString("_m_ForwardUuid", str2);
    agir.n.a(this.a).putString("_m_ForwardSize", String.valueOf(agir.n.a(this.a)));
    if (i != 0) {
      agir.n.a(this.a).putString("_m_ForwardImgWidth", String.valueOf(i));
    }
    if (j != 0) {
      agir.n.a(this.a).putString("_m_ForwardImgHeight", String.valueOf(j));
    }
    if (k != 0) {
      agir.n.a(this.a).putString("_m_ForwardDuration", String.valueOf(k));
    }
    agir.n.a(this.a).putString("_m_ForwardFileType", String.valueOf(3));
    if (agir.a(this.a.this$0) == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone mApp is null WorkerId[" + agir.n.a(this.a) + "] filename " + agir.n.a(this.a));
      agir.n.a(this.a).ch(agir.j(agir.n.a(this.a), false), false);
      return;
    }
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + agir.n.a(this.a) + "] filename " + agir.n.a(this.a));
    agir.b(agir.a(this.a.this$0), agir.n.b(this.a), paramInt, str2, agir.n.a(this.a), 0, i, j, k, false, agir.n.a(this.a), agir.n.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjf
 * JD-Core Version:    0.7.0.1
 */