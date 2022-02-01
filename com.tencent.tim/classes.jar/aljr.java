import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class aljr
  extends aopm
{
  aljr(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "ctrl realCancel");
  }
  
  protected void realStart()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "downloadPicAGifAVideoRes adid" + this.lt);
    aljs.Ol(this.val$path + ".splashtemp");
    Object localObject = new HashMap();
    ((HashMap)localObject).put("qbossSplashresAppid", this.lt);
    aljq.m("qbossSplashrequest", (HashMap)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("QSplash@QbossSplashDownloadManager", 2, "qboss_ad_res_png realStart, key  " + this.lt + "_" + this.val$path);
    }
    localObject = new aoll();
    ((aoll)localObject).f = new aljq.a(this.app, this.lt, this.val$contentType, this.val$path + ".splashtemp", this.bWJ, this.val$downloadUrl);
    ((aoll)localObject).bZ = this.val$downloadUrl;
    ((aoll)localObject).mHttpMethod = 0;
    ((aoll)localObject).atY = (this.val$path + ".splashtemp");
    ((aomj)this.app.getNetEngine(0)).a((aomg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljr
 * JD-Core Version:    0.7.0.1
 */