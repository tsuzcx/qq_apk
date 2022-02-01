import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

class agks
  implements UploadManager.IUploadStatusListener
{
  agks(agkl paramagkl) {}
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    if (this.this$0.a == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (paramStatusInfo.state == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onStarted[" + this.this$0.nSessionId + "]");
          }
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
          return;
        }
        if (paramStatusInfo.state == 6)
        {
          if (paramStatusInfo.errorCode == 1810002)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is canceled[" + this.this$0.nSessionId + "],set trafficData size[" + this.this$0.YD + "]");
            }
            if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
            {
              paramString = new String[3];
              paramString[0] = "param_WIFIFileFlow";
              paramString[1] = "param_WIFIFlow";
              paramString[2] = "param_Flow";
            }
            for (;;)
            {
              this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), paramString, this.this$0.YD);
              this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 3, null, 0, null);
              return;
              paramString = new String[3];
              paramString[0] = "param_XGFileFlow";
              paramString[1] = "param_XGFlow";
              paramString[2] = "param_Flow";
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onFailed[" + this.this$0.nSessionId + "],set trafficData size[" + this.this$0.YD + "]");
          }
          if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
          {
            paramString = new String[3];
            paramString[0] = "param_WIFIFileFlow";
            paramString[1] = "param_WIFIFlow";
            paramString[2] = "param_Flow";
          }
          for (;;)
          {
            this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), paramString, this.this$0.YD);
            this.this$0.c.status = 0;
            this.this$0.c.isReaded = false;
            this.this$0.app.a().dhl();
            this.this$0.app.a().u(this.this$0.c);
            this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 38, null, paramStatusInfo.errorCode, paramStatusInfo.errorMsg);
            return;
            paramString = new String[3];
            paramString[0] = "param_XGFileFlow";
            paramString[1] = "param_XGFlow";
            paramString[2] = "param_Flow";
          }
        }
      } while (paramStatusInfo.state != 5);
      this.this$0.a.setFileId(paramStatusInfo.fileId);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun upload is onSucceed[" + this.this$0.nSessionId + "],set trafficData size[" + this.this$0.nFileSize + "]");
      }
      this.this$0.c.WeiYunFileId = paramStatusInfo.fileId;
      if (paramStatusInfo.jobContext != null)
      {
        this.this$0.c.WeiYunDirKey = paramStatusInfo.jobContext.file().pDirKey;
        this.this$0.c.strFileSHA = paramStatusInfo.jobContext.file().sha;
        if (!TextUtils.isEmpty(paramStatusInfo.jobContext.file().thumbUrl)) {
          this.this$0.c.strLargeThumPath = paramStatusInfo.jobContext.file().thumbUrl;
        }
      }
      this.this$0.c.fProgress = 1.0F;
      this.this$0.c.setCloudType(2);
      this.this$0.c.status = 1;
      this.this$0.c.isReaded = false;
      this.this$0.endTime = System.currentTimeMillis();
      if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
      {
        paramString = new String[3];
        paramString[0] = "param_WIFIFileFlow";
        paramString[1] = "param_WIFIFlow";
        paramString[2] = "param_Flow";
      }
      for (;;)
      {
        this.this$0.app.sendAppDataIncerment(this.this$0.app.getAccount(), paramString, this.this$0.YD);
        this.this$0.app.a().u(this.this$0.c);
        this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 37, null, 0, null);
        paramString = new ahau.a();
        paramString.bJE = "send_file_suc";
        paramString.cYX = 1;
        ahau.a(this.this$0.app.getCurrentAccountUin(), paramString);
        return;
        paramString = new String[3];
        paramString[0] = "param_XGFileFlow";
        paramString[1] = "param_XGFlow";
        paramString[2] = "param_Flow";
      }
      paramLong = System.currentTimeMillis();
      this.this$0.YD = paramStatusInfo.currSize;
      this.this$0.nFileSize = paramStatusInfo.totalSize;
    } while (paramLong - this.this$0.HO < 1000L);
    this.this$0.HO = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.this$0.nSessionId + "]WeiYun upload is onProgressChange mtransferedSize[" + this.this$0.YD + "/" + this.this$0.nFileSize + "]");
    }
    this.this$0.c.fProgress = ((float)this.this$0.YD / (float)this.this$0.nFileSize);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agks
 * JD-Core Version:    0.7.0.1
 */