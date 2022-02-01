import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class agkq
  implements awqd.c
{
  agkq(agkl paramagkl) {}
  
  public void IJ(String paramString) {}
  
  public void a(String paramString, long paramLong, awqb.a parama, boolean paramBoolean)
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
        if (parama.state == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onStarted[" + this.this$0.nSessionId + "]");
          }
          this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
          return;
        }
        if (parama.state == 5)
        {
          if (parama.errorCode == 1810002)
          {
            if (QLog.isColorLevel()) {
              QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is canceled[" + this.this$0.nSessionId + "],set trafficData size[" + this.this$0.YD + "]");
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
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onFailed[" + this.this$0.nSessionId + "],set trafficData size[" + this.this$0.YD + "]");
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
            this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 36, null, parama.errorCode, parama.errorMsg);
            return;
            paramString = new String[3];
            paramString[0] = "param_XGFileFlow";
            paramString[1] = "param_XGFlow";
            paramString[2] = "param_Flow";
          }
        }
      } while (parama.state != 4);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "WeiYun download is onSucceed[" + this.this$0.nSessionId + "],set trafficData size[" + this.this$0.YD + "]");
      }
      this.this$0.c.setFilePath(parama.filePath);
      this.this$0.c.fProgress = 1.0F;
      this.this$0.c.isReaded = false;
      this.this$0.c.setCloudType(3);
      this.this$0.c.status = 1;
      this.this$0.c.fileName = ahav.getFileName(this.this$0.c.getFilePath());
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
        this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 35, null, 0, null);
        paramString = new ahau.a();
        paramString.bJE = "rece_file_suc";
        paramString.cYX = 1;
        ahau.a(this.this$0.app.getCurrentAccountUin(), paramString);
        return;
        paramString = new String[3];
        paramString[0] = "param_XGFileFlow";
        paramString[1] = "param_XGFlow";
        paramString[2] = "param_Flow";
      }
      paramLong = System.currentTimeMillis();
      this.this$0.YD = parama.currSize;
    } while (paramLong - this.this$0.HO < 1000L);
    this.this$0.HO = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.this$0.nSessionId + "]WeiYun download is onProgressChange mtransferedSize[" + this.this$0.YD + "/" + this.this$0.nFileSize + "]");
    }
    this.this$0.c.fProgress = ((float)this.this$0.YD / (float)this.this$0.nFileSize);
    this.this$0.app.a().a(this.this$0.uniseq, this.this$0.nSessionId, this.this$0.strUin, this.this$0.peerType, 16, null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkq
 * JD-Core Version:    0.7.0.1
 */