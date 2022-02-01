import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileviewer.troopfile.TroopFileViewerActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class ftq
  extends FMObserver
{
  public ftq(TroopFileViewerActivity paramTroopFileViewerActivity) {}
  
  protected void a()
  {
    this.a.f();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.a.b.a().a(paramLong1, paramString, paramInt, paramLong2);
    if (paramString == null) {}
    while (paramLong2 != paramString.nSessionId) {
      return;
    }
    QLog.i("<FileAssistant>TroopFileViewerActivity", 1, "<FileAssistant>TroopFileViewerActivity OnFileTransferStart: mEntity[" + FileManagerUtil.a(this.a.a) + "]");
    this.a.f();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if ((paramLong2 != this.a.a.nSessionId) && (paramLong2 != this.a.a.nRelatedSessionId)) {
      return;
    }
    this.a.f();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QLog.d("<FileAssistant>TroopFileViewerActivity", 1, "<FileAssistant>TroopFileViewerActivityOnFileTransferEnd, isSuccess[" + paramBoolean + "] uniseq[" + paramLong1 + "] nSessionId[" + paramLong2 + "] errCode[" + paramInt2 + "] retMsg[" + paramString2 + "] mEntify:" + FileManagerUtil.a(this.a.a));
    if (this.a.b.a().a(paramLong2) == null) {
      QLog.e("<FileAssistant>TroopFileViewerActivity", 1, "queryEntity is null,nSessionId[" + paramLong2 + "]");
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        FileManagerUtil.a(paramLong2);
      }
      while (paramLong2 == this.a.a.nSessionId)
      {
        this.a.f();
        return;
        FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      }
    }
  }
  
  protected void b()
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ftq
 * JD-Core Version:    0.7.0.1
 */