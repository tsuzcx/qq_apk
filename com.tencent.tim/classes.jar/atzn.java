import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atzn
  extends acdl
{
  atzn(atzm paramatzm) {}
  
  protected void a(long paramLong, float paramFloat)
  {
    Object localObject = this.a.c.b();
    if (localObject == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineFileModel", 2, "DataLine onProgress : opType[" + this.a.c.getOpType() + "], uniseq[" + ((FileManagerEntity)localObject).uniseq + "], nSessionId[" + ((FileManagerEntity)localObject).nSessionId + "], peerType[" + this.a.c.DW() + "]");
      }
      int i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.a.mAppInterface.b().a(i).a(((FileManagerEntity)localObject).uniseq);
    } while ((localObject == null) || (paramLong != ((DataLineMsgRecord)localObject).sessionid) || (this.a.a == null));
    this.a.a.aO(paramFloat);
  }
  
  protected void c(boolean paramBoolean, long paramLong, String paramString)
  {
    FileManagerEntity localFileManagerEntity = this.a.c.b();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineFileModel", 2, "DataLine onRecvFile : isSuccess[" + paramBoolean + "], uniseq[" + localFileManagerEntity.uniseq + "], nSessionId[" + localFileManagerEntity.nSessionId + "], peerType[" + this.a.c.DW() + "]");
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.mAppInterface.b().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        String str = localFileManagerEntity.getFilePath();
        if ((paramLong == localDataLineMsgRecord.sessionid) || (str == null) || (str.equals(paramString))) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("DatalineFileModel", 1, "this recv file done is not current visit file");
      return;
    } while (this.a.a == null);
    if (paramBoolean)
    {
      localFileManagerEntity.status = 1;
      this.a.a.djG();
      return;
    }
    localFileManagerEntity.status = 3;
    this.a.a.djH();
  }
  
  protected void d(boolean paramBoolean, long paramLong, String paramString)
  {
    paramString = this.a.c.b();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineFileModel", 2, "DataLine onSendFile : isSuccess[" + paramBoolean + "], uniseq[" + paramString.uniseq + "], nSessionId[" + paramString.nSessionId + "], peerType[" + this.a.c.DW() + "]");
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramString.uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.a.mAppInterface.b().a(i).a(paramString.uniseq);
    if (localDataLineMsgRecord == null) {}
    do
    {
      return;
      if (paramLong != localDataLineMsgRecord.sessionid)
      {
        QLog.i("DatalineFileModel", 1, "this send file done is not current visit file");
        return;
      }
    } while (this.a.a == null);
    if (paramBoolean)
    {
      paramString.status = 1;
      this.a.a.djG();
      this.a.a(this.a.c, 4);
      return;
    }
    this.a.a.djH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzn
 * JD-Core Version:    0.7.0.1
 */