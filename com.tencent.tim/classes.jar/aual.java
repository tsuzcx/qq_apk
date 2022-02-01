import android.app.Activity;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.2.1;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.2.2;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.2.3;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.2.4;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.2.5;
import java.util.Arrays;

public class aual
  extends CloudFileCallbackCenter
{
  aual(auaj paramauaj, QQAppInterface paramQQAppInterface) {}
  
  public void onDownloadComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    if (!auaj.a(this.this$0, paramArrayOfByte2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TIMCloudFileModel", 2, "cloud file onDownloadComplete");
    }
    if (paramInt != 0)
    {
      this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.2.4(this, paramString2));
      return;
    }
    paramArrayOfByte1 = this.this$0.c.b();
    if (paramArrayOfByte1.cloudFile.aioRecentFileExt != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramArrayOfByte1.setFilePath(paramString1);
      paramArrayOfByte1.status = 1;
      if (paramArrayOfByte1.cloudFile != null)
      {
        paramArrayOfByte1.cloudFile.downloadStatus = 5;
        paramArrayOfByte1.cloudFile.finalPath = paramString1;
      }
      atgi.a().a(paramArrayOfByte1, paramString1, bool);
      this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.2.5(this));
      this.this$0.a(this.this$0.c, 4);
      return;
    }
  }
  
  public void onDownloadProgress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3)
  {
    FileManagerEntity localFileManagerEntity1 = ((atgc)this.val$app.getManager(373)).b(this.this$0.c.b());
    FileManagerEntity localFileManagerEntity2 = this.this$0.c.b();
    if ((localFileManagerEntity1 != null) && (localFileManagerEntity1.nFileType != 2)) {
      if ((localFileManagerEntity1.pDirKey != null) && (localFileManagerEntity1.cloudId != null) && (paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (Arrays.equals(localFileManagerEntity1.pDirKey, paramArrayOfByte1)) && (Arrays.equals(localFileManagerEntity1.cloudId, paramArrayOfByte2))) {}
    }
    while (!auaj.a(this.this$0, paramArrayOfByte2))
    {
      do
      {
        return;
        float f2 = (float)paramLong2 / (float)paramLong3;
        f1 = f2;
        if (f2 == 0.0F) {
          f1 = localFileManagerEntity1.getfProgress();
        }
        localFileManagerEntity2.setfProgress(f1);
        localFileManagerEntity2.status = 2;
      } while (this.this$0.a == null);
      localFileManagerEntity1.setfProgress((float)paramLong2 / (float)paramLong3);
      this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.2.2(this, f1));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TIMCloudFileModel", 2, new Object[] { "cloud file onDownloadProgress:", Long.valueOf(paramLong2), ", max:", Long.valueOf(paramLong3) });
    }
    float f1 = (float)paramLong2 / (float)paramLong3;
    localFileManagerEntity2.setfProgress(f1);
    localFileManagerEntity2.status = 2;
    this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.2.3(this, f1));
  }
  
  public void onStartDownLoad(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    if (!auaj.a(this.this$0, paramArrayOfByte2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TIMCloudFileModel", 2, "cloud file onStartDownLoad");
    }
    this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.2.1(this));
  }
  
  public void onStopDownload(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    if (!auaj.a(this.this$0, paramArrayOfByte2)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TIMCloudFileModel", 2, "cloud file onStopDownload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aual
 * JD-Core Version:    0.7.0.1
 */