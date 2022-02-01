import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.concurrent.Executor;

class aghy
  implements agil.c
{
  aghy(aghx paramaghx) {}
  
  public void a(boolean paramBoolean, AppDetail paramAppDetail)
  {
    this.a.d.yybApkPackageName = paramAppDetail.packageName;
    this.a.d.yybApkName = paramAppDetail.appName;
    this.a.d.yybApkIconUrl = paramAppDetail.iconUrl;
  }
  
  public void dgp()
  {
    QLog.i("FileManagerEngine<FileAssistant>", 1, "waterTest, onGetAppDetailTimeLimit. apkName[" + this.a.d.yybApkName + "]");
    ahav.a.getExecutor().execute(this.a.val$job);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aghy
 * JD-Core Version:    0.7.0.1
 */