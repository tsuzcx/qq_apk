import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

class auij
  extends atgd
{
  auij(auif paramauif) {}
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, List<atkw> paramList, int paramInt3, String paramString)
  {
    QLog.e("FileRecentListPresenter", 1, "onRecentFileListQuery. load recent database file finish. opType[" + paramInt2 + "] errCode[" + paramInt3 + "] errMsg[" + paramString + "]");
    Message localMessage = this.this$0.q.obtainMessage(8);
    auif.a locala = new auif.a(this.this$0);
    Collections.sort(paramList, this.this$0.ao);
    locala.fileType = paramInt1;
    locala.diU = paramBoolean;
    locala.operateType = paramInt2;
    locala.KW = paramList;
    locala.errMsg = paramString;
    localMessage.obj = locala;
    this.this$0.q.sendMessage(localMessage);
  }
  
  public void gM(String paramString, int paramInt)
  {
    Message localMessage = this.this$0.q.obtainMessage(10);
    localMessage.obj = paramString;
    localMessage.arg1 = 1;
    this.this$0.q.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auij
 * JD-Core Version:    0.7.0.1
 */