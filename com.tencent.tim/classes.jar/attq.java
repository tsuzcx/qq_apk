import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.IWyTaskManager.DownloadTask;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.IWyTaskManager.TaskListener;

class attq
  implements IWyTaskManager.TaskListener
{
  attq(attm paramattm) {}
  
  public void onCanceled(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is canceled[" + String.valueOf(this.this$0.nSessionId) + "],set trafficData size[" + String.valueOf(this.this$0.YD) + "]");
    }
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
    {
      paramTask = new String[3];
      paramTask[0] = "param_WIFIFileFlow";
      paramTask[1] = "param_WIFIFlow";
      paramTask[2] = "param_Flow";
    }
    for (;;)
    {
      this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), paramTask, this.this$0.YD);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 3, null, 0, null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
  
  public void onFailed(IWyTaskManager.Task paramTask, Object paramObject, IWyFileSystem.WyErrorStatus paramWyErrorStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onFailed[" + String.valueOf(this.this$0.nSessionId) + "],set trafficData size[" + String.valueOf(this.this$0.YD) + "]");
    }
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
    {
      paramTask = new String[3];
      paramTask[0] = "param_WIFIFileFlow";
      paramTask[1] = "param_WIFIFlow";
      paramTask[2] = "param_Flow";
    }
    for (;;)
    {
      this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), paramTask, this.this$0.YD);
      this.this$0.c.status = 0;
      this.this$0.c.isReaded = false;
      this.this$0.app.a().dhl();
      this.this$0.app.a().u(this.this$0.c);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 36, null, paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg);
      audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.startTime, "", "", "", "", paramWyErrorStatus.errorCode, "", this.this$0.YF, this.this$0.YD, this.this$0.c.fileSize, "", "", 0, "errCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "]errmsg[" + paramWyErrorStatus.errorMsg + "]", null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
  
  public void onProgressChange(IWyTaskManager.Task paramTask, Object paramObject, long paramLong1, long paramLong2)
  {
    paramLong2 = System.currentTimeMillis();
    this.this$0.YD = paramLong1;
    if (paramLong2 - this.this$0.HO < 1000L) {
      return;
    }
    this.this$0.HO = paramLong2;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.this$0.nSessionId) + "]WeiYun download is onProgressChange mtransferedSize[" + String.valueOf(this.this$0.YD) + "/" + String.valueOf(this.this$0.nFileSize) + "]");
    }
    this.this$0.c.setfProgress((float)this.this$0.YD / (float)this.this$0.nFileSize);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
  
  public void onStarted(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted[" + String.valueOf(this.this$0.nSessionId) + "]");
    }
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
  
  public void onSucceed(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed[" + String.valueOf(this.this$0.nSessionId) + "],set trafficData size[" + String.valueOf(this.this$0.YD) + "]");
    }
    paramTask = (IWyTaskManager.DownloadTask)this.this$0.a;
    this.this$0.c.setFilePath(paramTask.getFilePath());
    this.this$0.c.setfProgress(1.0F);
    this.this$0.c.isReaded = false;
    this.this$0.c.setCloudType(3);
    this.this$0.c.status = 1;
    this.this$0.c.fileName = audx.getFileName(this.this$0.c.getFilePath());
    this.this$0.endTime = System.currentTimeMillis();
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
    {
      paramTask = new String[3];
      paramTask[0] = "param_WIFIFileFlow";
      paramTask[1] = "param_WIFIFlow";
      paramTask[2] = "param_Flow";
    }
    for (;;)
    {
      this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), paramTask, this.this$0.YD);
      this.this$0.app.a().u(this.this$0.c);
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 35, null, 0, null);
      paramTask = new audw.b();
      paramTask.bJE = "rece_file_suc";
      paramTask.cYX = 1;
      audw.a(this.this$0.app.getCurrentAccountUin(), paramTask);
      audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, this.this$0.endTime - this.this$0.startTime, "", "", "", "", this.this$0.YF, this.this$0.YD, this.this$0.nFileSize, 0, null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attq
 * JD-Core Version:    0.7.0.1
 */