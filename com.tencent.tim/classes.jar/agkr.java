import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;

class agkr
  implements awqd.c
{
  agkr(agkl paramagkl, FileManagerEntity paramFileManagerEntity) {}
  
  public void IJ(String paramString) {}
  
  public void a(String paramString, long paramLong, awqb.a parama, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (parama.state == 2) {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted");
        }
      }
      do
      {
        return;
        if (parama.state == 5)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
          }
          paramString = new Bundle();
          paramString.putString("taskId", this.b.miniAppDownloadId);
          paramString.putInt("errorCode", parama.errorCode);
          paramString.putString("errorMsg", parama.errorMsg);
          QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", paramString, null);
          this.this$0.c.status = 0;
          this.this$0.c.isReaded = false;
          this.this$0.app.a().dhl();
          this.this$0.app.a().u(this.this$0.c);
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 36, null, parama.errorCode, parama.errorMsg);
          return;
        }
      } while (parama.state != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
      }
      paramString = new Bundle();
      paramString.putString("taskId", this.b.miniAppDownloadId);
      paramString.putString("filePath", parama.filePath);
      QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramString, null);
      this.this$0.c.setFilePath(parama.filePath);
      this.this$0.c.fProgress = 1.0F;
      this.this$0.c.isReaded = false;
      this.this$0.c.setCloudType(3);
      this.this$0.c.status = 1;
      this.this$0.c.fileName = ahav.getFileName(this.this$0.c.getFilePath());
      this.this$0.app.a().u(this.this$0.c);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 35, null, 0, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
    }
    paramString = new Bundle();
    paramString.putString("taskId", this.b.miniAppDownloadId);
    paramString.putInt("progress", (int)((float)parama.currSize / (float)parama.totalSize * 100.0F));
    paramString.putLong("currSize", parama.currSize);
    paramString.putLong("totalSize", parama.totalSize);
    QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", paramString, null);
    this.this$0.c.fProgress = ((float)this.this$0.YD / (float)this.this$0.nFileSize);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkr
 * JD-Core Version:    0.7.0.1
 */