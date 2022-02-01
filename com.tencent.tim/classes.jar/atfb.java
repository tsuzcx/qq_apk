import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

class atfb
  extends CloudFileCallbackCenter
{
  atfb(ateh paramateh) {}
  
  public void onDownloadComplete(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = (atgc)this.this$0.app.getManager(373);
    if ((localObject != null) && (paramArrayOfByte1 != null) && (Arrays.equals(paramArrayOfByte1, ((atgc)localObject).aF()))) {
      atgi.a().getCloudItemById(paramArrayOfByte2, new atfd(this, paramString1, paramInt, paramArrayOfByte1, paramArrayOfByte2, paramString2));
    }
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 2, Arrays.toString(paramArrayOfByte2) + " DownloadComplete");
    }
    FileManagerEntity localFileManagerEntity;
    if (localObject != null)
    {
      localFileManagerEntity = ((atgc)localObject).a(paramArrayOfByte1, paramArrayOfByte2);
      if (localFileManagerEntity != null)
      {
        if (paramInt == 0) {
          break label230;
        }
        localFileManagerEntity.status = 0;
        if (ateh.a(this.this$0) != null) {
          ateh.a(this.this$0).onDownloadFailed(paramInt, paramString2);
        }
        if (ateh.a(this.this$0) != null) {
          ateh.a(this.this$0).a(localFileManagerEntity, true, paramString1);
        }
      }
      localObject = this.this$0;
      if (paramInt != 0) {
        break label268;
      }
    }
    label268:
    for (boolean bool = true;; bool = false)
    {
      ((ateh)localObject).notifyUI(24, bool, new Object[] { paramArrayOfByte1, paramArrayOfByte2, paramString1, Integer.valueOf(paramInt), paramString2 });
      return;
      label230:
      localFileManagerEntity.setFilePath(paramString1);
      localFileManagerEntity.status = 1;
      localFileManagerEntity.strFilePath = paramString1;
      atgi.a().a(localFileManagerEntity, paramString1, true);
      ((atgc)localObject).T(localFileManagerEntity);
      break;
    }
  }
  
  public void onDownloadProgress(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 2, " onDownloadProgress:");
    }
    atgc localatgc = (atgc)this.this$0.app.getManager(373);
    if (localatgc != null)
    {
      FileManagerEntity localFileManagerEntity = localatgc.a(paramArrayOfByte1, paramArrayOfByte2);
      if (localFileManagerEntity != null)
      {
        localFileManagerEntity.status = 2;
        localFileManagerEntity.setfProgress((float)paramLong2 / (float)paramLong3);
        QLog.i("CloudFileHandler", 2, "filename is " + localFileManagerEntity.fileName);
        if (ateh.a(this.this$0) != null) {
          ateh.a(this.this$0).a(localFileManagerEntity, false, null);
        }
      }
      this.this$0.notifyUI(23, true, new Object[] { paramArrayOfByte1, paramArrayOfByte2, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
    }
    if ((localatgc != null) && (paramArrayOfByte1 != null) && (Arrays.equals(paramArrayOfByte1, localatgc.aF()))) {
      atgi.a().getCloudItemById(paramArrayOfByte2, new atfc(this, paramLong2, paramLong3, paramArrayOfByte1, paramArrayOfByte2, paramLong1));
    }
  }
  
  public void onRecursiveRefreshFinished(int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "onRecursiveRefreshFinished errorCode:" + paramInt);
    }
    atgc localatgc = (atgc)this.this$0.app.getManager(373);
    if (localatgc != null)
    {
      if (paramInt == 0) {}
      for (;;)
      {
        localatgc.Vx(bool);
        return;
        bool = false;
      }
    }
    QLog.d("CloudFileHandler", 1, "cloudFileManager is null");
  }
  
  public void onStartDownLoad(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 2, Arrays.toString(paramArrayOfByte2) + " StartDownload");
    }
    Object localObject = (atgc)this.this$0.app.getManager(373);
    if (localObject != null)
    {
      localObject = ((atgc)localObject).a(paramArrayOfByte1, paramArrayOfByte2);
      if (localObject != null)
      {
        ((FileManagerEntity)localObject).status = 2;
        if (ateh.a(this.this$0) != null) {
          ateh.a(this.this$0).a((FileManagerEntity)localObject, false, null);
        }
      }
      this.this$0.notifyUI(21, true, new Object[] { paramArrayOfByte1, paramArrayOfByte2, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    }
  }
  
  public void onStopDownload(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 2, Arrays.toString(paramArrayOfByte2) + " StopDownload");
    }
    Object localObject = (atgc)this.this$0.app.getManager(373);
    FileManagerEntity localFileManagerEntity;
    if (localObject != null)
    {
      localFileManagerEntity = ((atgc)localObject).a(paramArrayOfByte1, paramArrayOfByte2);
      if (localFileManagerEntity == null) {
        break label165;
      }
      if (paramInt != 0) {
        break label108;
      }
      if (localFileManagerEntity.status != 2) {
        break label91;
      }
      localFileManagerEntity.status = 3;
    }
    label91:
    while (localFileManagerEntity.status != 1) {
      return;
    }
    ((atgc)localObject).T(localFileManagerEntity);
    return;
    label108:
    localFileManagerEntity.status = 0;
    if (ateh.a(this.this$0) != null) {
      ateh.a(this.this$0).onDownloadFailed(paramInt, paramString);
    }
    if (ateh.a(this.this$0) != null) {
      ateh.a(this.this$0).a(localFileManagerEntity, false, null);
    }
    label165:
    localObject = this.this$0;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ateh)localObject).notifyUI(22, bool, new Object[] { paramArrayOfByte1, paramArrayOfByte2, Integer.valueOf(paramInt), paramString });
      return;
    }
  }
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, " onUploadComplete errorCode:" + paramInt2 + " upload type：" + paramInt1 + " errMsg:" + paramString + " taskId:" + paramLong);
    }
    Object localObject = (atgc)this.this$0.app.getManager(373);
    if ((localObject != null) && (((atgc)localObject).aG() != null) && (Arrays.equals(paramArrayOfByte, ((atgc)localObject).aG())) && (aqmj.cc(this.this$0.app)) && (!aqmj.cb(this.this$0.app)) && (!auen.dn(paramLong)))
    {
      aqmj.ag(this.this$0.app, true);
      aqmj.ah(this.this$0.app, false);
    }
    localObject = this.this$0;
    if (paramInt2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ateh)localObject).notifyUI(5, bool, new Object[] { paramArrayOfByte, athu.a(paramCloudUploadFile.fileInfo), Integer.valueOf(paramInt2), paramString, Long.valueOf(paramLong) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfb
 * JD-Core Version:    0.7.0.1
 */