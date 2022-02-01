package com.tencent.biz.qqcircle.download;

import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import mqq.app.AppRuntime;
import ozq;
import ozr;

public class QCircleResourceDownloadManager$2
  implements Runnable
{
  public QCircleResourceDownloadManager$2(ozq paramozq, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    aoll localaoll = new aoll();
    localaoll.f = new ozr(this);
    localaoll.bZ = this.val$downloadUrl;
    localaoll.mHttpMethod = 0;
    localaoll.atY = this.arM;
    localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      QLog.i("DownLoadZipFile", 1, "startDownloadZipFile, url: " + this.val$downloadUrl);
      if (!ozq.a(this.this$0).contains(this.val$downloadUrl))
      {
        ozq.a(this.this$0).add(this.val$downloadUrl);
        ((QQAppInterface)localAppRuntime).getNetEngine(0).a(localaoll);
      }
      return;
    }
    QLog.e(ozq.TAG, 1, "error Runtime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleResourceDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */