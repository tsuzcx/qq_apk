import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.IWyTaskManager.TaskListener;
import com.weiyun.sdk.IWyTaskManager.UploadTask;

class atts
  implements IWyTaskManager.TaskListener
{
  atts(attm paramattm) {}
  
  public void onCanceled(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is canceled[" + String.valueOf(this.this$0.nSessionId) + "],set trafficData size[" + String.valueOf(this.this$0.YD) + "]");
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
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onFailed[" + String.valueOf(this.this$0.nSessionId) + "],set trafficData size[" + String.valueOf(this.this$0.YD) + "]");
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
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 38, null, paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg);
      audx.a(this.this$0.app, this.this$0.c.nSessionId, this.this$0.aBA, 0L, "", "", "", "", paramWyErrorStatus.errorCode, "", 0L, 0L, this.this$0.c.fileSize, "", "", 0, "errCode[" + String.valueOf(paramWyErrorStatus.errorCode) + "]errMsg[" + paramWyErrorStatus.errorMsg + "]", null);
      return;
      paramTask = new String[3];
      paramTask[0] = "param_XGFileFlow";
      paramTask[1] = "param_XGFlow";
      paramTask[2] = "param_Flow";
    }
  }
  
  public void onProgressChange(IWyTaskManager.Task paramTask, Object paramObject, long paramLong1, long paramLong2)
  {
    long l = System.currentTimeMillis();
    this.this$0.YD = paramLong1;
    this.this$0.nFileSize = paramLong2;
    if (l - this.this$0.HO < 1000L) {
      return;
    }
    this.this$0.HO = l;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.this$0.nSessionId) + "]WeiYun upload is onProgressChange mtransferedSize[" + String.valueOf(this.this$0.YD) + "/" + String.valueOf(this.this$0.nFileSize) + "]");
    }
    this.this$0.c.setfProgress((float)this.this$0.YD / (float)this.this$0.nFileSize);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
  
  public void onStarted(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onStarted[" + String.valueOf(this.this$0.nSessionId) + "]");
    }
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
  
  public void onSucceed(IWyTaskManager.Task paramTask, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onSucceed[" + String.valueOf(this.this$0.nSessionId) + "],set trafficData size[" + String.valueOf(this.this$0.nFileSize) + "]");
    }
    paramTask = (IWyTaskManager.UploadTask)this.this$0.a;
    this.this$0.c.WeiYunFileId = paramTask.getFileId();
    this.this$0.c.setfProgress(1.0F);
    this.this$0.c.setCloudType(2);
    this.this$0.c.status = 1;
    this.this$0.c.isReaded = false;
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
      this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 37, null, 0, null);
      paramTask = new audw.b();
      paramTask.bJE = "send_file_suc";
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
 * Qualified Name:     atts
 * JD-Core Version:    0.7.0.1
 */