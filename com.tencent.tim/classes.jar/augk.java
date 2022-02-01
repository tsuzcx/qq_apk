import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

class augk
  extends CloudFileCallbackCenter
{
  augk(auge paramauge) {}
  
  public void onDownloadComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    if (!auge.a(this.this$0, paramArrayOfByte2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "cloud file onDownloadComplete " + paramString1);
    }
    auge.a(this.this$0, auge.c(this.this$0), 100);
    if ((auge.a(this.this$0) != null) && (auge.a(this.this$0).second != null)) {
      ((auge.a)auge.a(this.this$0).second).filePath = paramString1;
    }
    auge.c(this.this$0);
  }
  
  public void onDownloadProgress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3)
  {
    if (!auge.a(this.this$0, paramArrayOfByte2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MailPluginAttachDownloader", 2, "cloud file onDownloadProgress " + paramLong2);
    }
    auge.a(this.this$0, auge.c(this.this$0), (int)(100L * paramLong2 / paramLong3));
  }
  
  public void onStartDownLoad(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    if (!auge.a(this.this$0, paramArrayOfByte2)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MailPluginAttachDownloader", 2, "cloud file onStartDownLoad");
  }
  
  public void onStopDownload(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    if (!auge.a(this.this$0, paramArrayOfByte2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MailPluginAttachDownloader", 2, "cloud file onStopDownload errCode=" + paramInt + ", errMsg=" + paramString);
      }
    } while (paramInt == 0);
    auge.b(this.this$0);
    if ((auge.a(this.this$0) != null) && (auge.a(this.this$0).first != null)) {
      auge.a(this.this$0, ((FileManagerEntity)auge.a(this.this$0).first).fileName);
    }
    auge.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augk
 * JD-Core Version:    0.7.0.1
 */