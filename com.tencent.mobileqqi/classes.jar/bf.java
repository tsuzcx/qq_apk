import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

public class bf
  extends FMObserver
{
  public bf(LiteActivity paramLiteActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LiteActivity.a, 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.b.a().a(paramLong2);
    if (paramString1 == null) {
      QLog.e(LiteActivity.a, 1, "OnFileTransferEnd faild, get entity is faild, sessionId[" + String.valueOf(paramLong2) + "]");
    }
    do
    {
      return;
      if (paramBoolean)
      {
        FileManagerUtil.a(paramLong2);
        return;
      }
    } while ((paramString1.nOpType != 4) && (paramString1.nOpType != 6));
    FileManagerUtil.a(paramLong2, paramInt2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bf
 * JD-Core Version:    0.7.0.1
 */