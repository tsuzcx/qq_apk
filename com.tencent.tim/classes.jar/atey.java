import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class atey
  extends atgg
{
  atey(ateh paramateh, FileManagerEntity paramFileManagerEntity, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (!paramBoolean)
    {
      QLog.d("CloudFileHandler", 1, "copyFileToCloudDisc not exist in AIORecentFolder, so copy to cloud");
      if ((this.b.cloudType != 9) && ((this.b.cloudId == null) || (this.b.pDirKey == null)) && (this.b.srvTime + 604800000L > NetConnInfoCenter.getServerTimeMillis())) {
        ateh.b(this.this$0, this.b, this.dht);
      }
      return;
    }
    QLog.d("CloudFileHandler", 1, "copyFileToCloudDisc exist in AIORecentFolder, so not need to copy");
    this.b.setCloudType(9);
    this.b.pDirKey = paramArrayOfByte1;
    this.b.cloudId = paramArrayOfByte2;
    this.b.cloudIdHex = aqhs.bytes2HexStr(paramArrayOfByte2);
    this.this$0.app.a().u(this.b);
    this.this$0.notifyUI(29, true, new Object[] { this.b, Boolean.valueOf(this.dht), Integer.valueOf(255), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atey
 * JD-Core Version:    0.7.0.1
 */