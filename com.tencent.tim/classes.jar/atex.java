import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class atex
  extends atgg
{
  atex(ateh paramateh, FileManagerEntity paramFileManagerEntity, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 2, "copyFileToCloudC2C peerType:" + this.k.peerType + " uuid:" + this.k.Uuid + "name:" + this.k.fileName + "isExist:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      if ((this.k.cloudType != 9) && ((this.k.cloudId == null) || (this.k.pDirKey == null)) && (this.k.srvTime + 604800000L > NetConnInfoCenter.getServerTimeMillis())) {
        ateh.a(this.this$0, this.k, this.dht);
      }
      return;
    }
    this.k.setCloudType(9);
    this.k.pDirKey = paramArrayOfByte1;
    this.k.cloudId = paramArrayOfByte2;
    this.k.cloudIdHex = aqhs.bytes2HexStr(paramArrayOfByte2);
    this.this$0.app.a().u(this.k);
    this.this$0.notifyUI(28, true, new Object[] { this.k, Boolean.valueOf(this.dht), Integer.valueOf(255), "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atex
 * JD-Core Version:    0.7.0.1
 */