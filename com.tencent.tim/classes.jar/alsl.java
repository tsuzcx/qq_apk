import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

public class alsl
  implements QzoneZipCacheHelperCallBack
{
  public alsl(QzoneGiftUtil.1 param1) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QzoneGiftUtil.1.a(this.a);
      QLog.i("QzoneGiftUtil", 1, "downloadGiftZip onResult mLoadSuccessTimes = " + QzoneGiftUtil.1.c(this.a) + " mLoadFailTimes = " + QzoneGiftUtil.1.d(this.a));
      if (this.a.a != null)
      {
        if (QzoneGiftUtil.1.c(this.a) != this.a.Dg) {
          break label109;
        }
        this.a.a.onSuccess();
      }
    }
    label109:
    while (QzoneGiftUtil.1.c(this.a) + QzoneGiftUtil.1.d(this.a) != this.a.Dg)
    {
      return;
      QzoneGiftUtil.1.b(this.a);
      break;
    }
    this.a.a.bbs();
  }
  
  public void onResultOfNativeRequest(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsl
 * JD-Core Version:    0.7.0.1
 */