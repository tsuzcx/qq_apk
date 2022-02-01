import com.tencent.mobileqq.activity.history.ChatHistoryC2CMediaFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zfw
  extends aghq
{
  public zfw(ChatHistoryC2CMediaFragment paramChatHistoryC2CMediaFragment) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.mApp.a().b(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6) && (awou.nP(paramInt2)) && (this.a.uiHandler != null)) {
      this.a.uiHandler.sendEmptyMessage(102);
    }
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((awou.nP(paramInt)) && (this.a.uiHandler != null)) {
      this.a.uiHandler.sendEmptyMessage(102);
    }
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    if ((awou.nP(paramInt)) && (this.a.uiHandler != null)) {
      this.a.uiHandler.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zfw
 * JD-Core Version:    0.7.0.1
 */