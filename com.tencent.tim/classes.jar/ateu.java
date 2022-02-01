import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class ateu
  extends atgg
{
  ateu(ateh paramateh, FileManagerEntity paramFileManagerEntity, int paramInt) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    super.a(paramArrayOfByte, paramInt, paramString);
    if (paramInt != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "sendCloudOfflineFile  airCopyToOtherBiz onFailed: errcode[" + paramInt + "], errmsg[" + paramString + "]");
      }
      this.b.status = 0;
      this.b.isReaded = false;
      this.this$0.app.a().dhl();
      this.this$0.app.a().u(this.b);
      this.this$0.app.a().o(this.b.nSessionId, 1005);
      this.this$0.app.a().b(false, 101, new Object[] { Integer.valueOf(17), paramString, Long.valueOf(this.b.nSessionId) });
    }
    do
    {
      return;
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("CloudFileHandler", 2, "sendCloudOfflineFile onSucceed,But uuid is null!!!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "sendCloudOfflineFile onSucceed, Uuid[" + Arrays.toString(paramArrayOfByte) + "]");
    }
    if ((!aqhq.fileExistsAndNotEmpty(this.b.strThumbPath)) && (ahav.getFileType(this.b.fileName) == 2))
    {
      paramString = this.this$0.app.a().a(this.b);
      if (paramString != null) {
        this.b.strThumbPath = paramString;
      }
    }
    this.b.Uuid = new String(paramArrayOfByte);
    this.b.cloudId = null;
    this.b.cloudIdHex = null;
    this.b.pDirKey = null;
    this.b.cloudFile = null;
    this.b.setCloudType(1);
    this.b.status = 1;
    this.b.isReaded = false;
    this.b.bSend = true;
    this.b.setfProgress(0.0F);
    this.this$0.app.a().dhl();
    this.this$0.app.a().u(this.b);
    this.b.status = 2;
    ahav.jR(this.b.nSessionId);
    this.this$0.app.a().a(this.b, 1000, "");
    if (this.bPa == 3000)
    {
      this.this$0.app.a().a(this.b.nSessionId, this.b.peerUin, this.this$0.app.getCurrentAccountUin(), this.b.fileName, this.b.fileSize, this.b.Uuid, this.b.uniseq, this.b.msgUid, new atev(this));
      return;
    }
    paramArrayOfByte = this.b.peerUin.replace("+", "");
    this.this$0.app.a().a(paramArrayOfByte, this.b, new atew(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ateu
 * JD-Core Version:    0.7.0.1
 */