import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.IWyTaskManager.DownloadTask;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.IWyTaskManager.TaskListener;

class attr
  implements IWyTaskManager.TaskListener
{
  attr(attm paramattm, FileManagerEntity paramFileManagerEntity) {}
  
  public void onCanceled(IWyTaskManager.Task paramTask, Object paramObject) {}
  
  public void onFailed(IWyTaskManager.Task paramTask, Object paramObject, IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is fail");
    }
    paramTask = new Bundle();
    paramTask.putString("taskId", this.b.miniAppDownloadId);
    paramTask.putInt("errorCode", paramWyErrorStatus.errorCode);
    paramTask.putString("errorMsg", paramWyErrorStatus.errorMsg);
    QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Fail", paramTask, null);
    this.this$0.c.status = 0;
    this.this$0.c.isReaded = false;
    this.this$0.app.a().dhl();
    this.this$0.app.a().u(this.this$0.c);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 36, null, paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg);
  }
  
  public void onProgressChange(IWyTaskManager.Task paramTask, Object paramObject, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is process");
    }
    paramTask = new Bundle();
    paramTask.putString("taskId", this.b.miniAppDownloadId);
    paramTask.putInt("progress", (int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    paramTask.putLong("currSize", paramLong1);
    paramTask.putLong("totalSize", paramLong2);
    QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Progress", paramTask, null);
    this.this$0.c.fProgress = ((float)this.this$0.YD / (float)this.this$0.nFileSize);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
  
  public void onStarted(IWyTaskManager.Task paramTask, Object paramObject) {}
  
  public void onSucceed(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed");
    }
    paramTask = (IWyTaskManager.DownloadTask)this.this$0.a;
    paramObject = new Bundle();
    paramObject.putString("taskId", this.b.miniAppDownloadId);
    paramObject.putString("filePath", paramTask.getFilePath());
    QIPCServerHelper.getInstance().callClient(agmu.bIh, "Module_WeiyunDownloadClient", "WeiyunDownloadClientIPC_Action__Suc", paramObject, null);
    this.this$0.c.setFilePath(paramTask.getFilePath());
    this.this$0.c.fProgress = 1.0F;
    this.this$0.c.isReaded = false;
    this.this$0.c.setCloudType(3);
    this.this$0.c.status = 1;
    this.this$0.c.fileName = audx.getFileName(this.this$0.c.getFilePath());
    this.this$0.app.a().u(this.this$0.c);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 35, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attr
 * JD-Core Version:    0.7.0.1
 */