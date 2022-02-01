import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import java.util.HashMap;
import java.util.Map;

public class atrr
  extends acdl
{
  private Map<Long, FileManagerEntity> kx = new HashMap();
  
  public atrr(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  FileManagerEntity a(long paramLong)
  {
    if (this.kx.containsKey(Long.valueOf(paramLong))) {
      return (FileManagerEntity)this.kx.get(Long.valueOf(paramLong));
    }
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.e(this.this$0).a().a(paramLong, acbn.bkw, 6000, -1L);
    this.kx.put(Long.valueOf(paramLong), localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  protected void a(long paramLong, float paramFloat)
  {
    super.a(paramLong, paramFloat);
    FileManagerEntity localFileManagerEntity = a(paramLong);
    if (localFileManagerEntity == null) {
      return;
    }
    localFileManagerEntity.setfProgress(paramFloat);
    QfileBaseRecentFileTabView.l(this.this$0).a().a(localFileManagerEntity.uniseq, localFileManagerEntity.nSessionId, acbn.bkw, 6000, 16, null, 0, null);
  }
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramString = a(paramLong1);
    if (paramString == null) {
      return;
    }
    paramString.status = 2;
    QfileBaseRecentFileTabView.f(this.this$0).a().a(paramString.uniseq, paramString.nSessionId, acbn.bkw, 6000, 10, null, 0, null);
  }
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    super.a(paramLong1, paramString, paramInt, paramBoolean1, paramBoolean2, paramLong2);
    paramString = a(paramLong1);
    if (paramString == null) {
      return;
    }
    paramString.status = 2;
    QfileBaseRecentFileTabView.g(this.this$0).a().a(paramString.uniseq, paramString.nSessionId, acbn.bkw, 6000, 10, null, 0, null);
  }
  
  protected void c(boolean paramBoolean, long paramLong, String paramString)
  {
    super.c(paramBoolean, paramLong, paramString);
    Object localObject = a(paramLong);
    if (localObject == null) {
      return;
    }
    long l;
    if (paramBoolean)
    {
      ((FileManagerEntity)localObject).status = 1;
      QfileBaseRecentFileTabView.j(this.this$0).a().u((FileManagerEntity)localObject);
      QLog.e(QfileBaseRecentFileTabView.TAG, 2, "FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onRecvFile,entity.cloudtype:" + ((FileManagerEntity)localObject).cloudType + ",filepath:" + ((FileManagerEntity)localObject).strFilePath);
      paramString = QfileBaseRecentFileTabView.k(this.this$0).a();
      paramLong = ((FileManagerEntity)localObject).uniseq;
      l = ((FileManagerEntity)localObject).nSessionId;
      localObject = acbn.bkw;
      if (!paramBoolean) {
        break label155;
      }
    }
    label155:
    for (int i = 11;; i = 12)
    {
      paramString.a(paramLong, l, (String)localObject, 6000, i, null, 0, null);
      return;
      ((FileManagerEntity)localObject).status = 0;
      break;
    }
  }
  
  protected void d(boolean paramBoolean, long paramLong, String paramString)
  {
    super.d(paramBoolean, paramLong, paramString);
    super.c(paramBoolean, paramLong, paramString);
    Object localObject = a(paramLong);
    if (localObject == null) {
      return;
    }
    long l;
    if (paramBoolean)
    {
      ((FileManagerEntity)localObject).status = 1;
      QfileBaseRecentFileTabView.h(this.this$0).a().u((FileManagerEntity)localObject);
      QLog.e(QfileBaseRecentFileTabView.TAG, 2, "FMConstants.TYPE_FILE_RECVFILE_SUCCESS in onSendFile,entity.cloudtype:" + ((FileManagerEntity)localObject).cloudType + ",filepath:" + ((FileManagerEntity)localObject).strFilePath);
      paramString = QfileBaseRecentFileTabView.i(this.this$0).a();
      paramLong = ((FileManagerEntity)localObject).uniseq;
      l = ((FileManagerEntity)localObject).nSessionId;
      localObject = acbn.bkw;
      if (!paramBoolean) {
        break label163;
      }
    }
    label163:
    for (int i = 11;; i = 12)
    {
      paramString.a(paramLong, l, (String)localObject, 6000, i, null, 0, null);
      return;
      ((FileManagerEntity)localObject).status = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrr
 * JD-Core Version:    0.7.0.1
 */