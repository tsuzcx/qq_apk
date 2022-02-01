import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atfe
  extends atsn
{
  atfe(ateh paramateh) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FMObserver<FileAssistant>", 2, paramLong2 + " OnFileTransferProgress");
    }
    paramString = ((atgc)this.this$0.app.getManager(373)).f(paramLong2);
    if (paramString == null) {}
    do
    {
      return;
      if (paramString.status != 3) {
        paramString.status = 2;
      }
    } while (ateh.a(this.this$0) == null);
    ateh.a(this.this$0).a(paramString, false, null);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FMObserver<FileAssistant>", 2, paramLong2 + " OnFileTransferEnd");
    }
    paramString1 = (atgc)this.this$0.app.getManager(373);
    FileManagerEntity localFileManagerEntity = paramString1.f(paramLong2);
    if (localFileManagerEntity == null) {}
    do
    {
      do
      {
        return;
        if (paramInt2 != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FMObserver<FileAssistant>", 2, "setDownloadStatus");
        }
        localFileManagerEntity.status = 1;
        atgi.a().a(localFileManagerEntity, localFileManagerEntity.strFilePath, true);
        paramString1.T(localFileManagerEntity);
      } while (ateh.a(this.this$0) == null);
      ateh.a(this.this$0).a(localFileManagerEntity, true, localFileManagerEntity.strFilePath);
      return;
      localFileManagerEntity.status = 0;
    } while (ateh.a(this.this$0) == null);
    ateh.a(this.this$0).onDownloadFailed(paramInt2, paramString2);
  }
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FMObserver<FileAssistant>", 2, paramLong2 + " OnFileTransferStart");
    }
    paramString = ((atgc)this.this$0.app.getManager(373)).f(paramLong2);
    if (paramString == null) {}
    do
    {
      return;
      paramString.status = 2;
    } while (ateh.a(this.this$0) == null);
    ateh.a(this.this$0).a(paramString, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfe
 * JD-Core Version:    0.7.0.1
 */