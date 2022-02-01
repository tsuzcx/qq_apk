import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aljo
  extends aopm
{
  aljo(aljn paramaljn, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    QLog.i("QbossPreDownloadManager", 1, "ctrl realCancel");
  }
  
  protected void realStart()
  {
    QLog.i("QbossPreDownloadManager", 1, "downloadRes realStart packagename:" + this.val$packageName + ",path" + this.val$filePath);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("Qboss_PreDownload_PackageName", this.val$packageName);
    aljn.l("Qboss_PreDownload_Start", (HashMap)localObject);
    localObject = new aoll();
    ((aoll)localObject).f = new aljn.a(this.app, this.val$packageName, this.val$filePath, this.val$downloadUrl, this.zG);
    ((aoll)localObject).bZ = this.val$downloadUrl;
    ((aoll)localObject).mHttpMethod = 0;
    ((aoll)localObject).atY = this.val$filePath;
    ((aomj)this.app.getNetEngine(0)).a((aomg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljo
 * JD-Core Version:    0.7.0.1
 */