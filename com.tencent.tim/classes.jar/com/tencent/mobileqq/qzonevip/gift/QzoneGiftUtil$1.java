package com.tencent.mobileqq.qzonevip.gift;

import alsk;
import alsk.a;
import alsl;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public final class QzoneGiftUtil$1
  implements Runnable
{
  private volatile int chj;
  private volatile int chk;
  
  public QzoneGiftUtil$1(alsk.a parama, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.chj = 0;
    this.chk = 0;
    alsl localalsl = new alsl(this);
    if ((!TextUtils.isEmpty(this.bYc)) && (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, this.bYc, "qzone_aio_gift", String.valueOf(this.bYc.hashCode()), -1, localalsl))) {
      this.chj += 1;
    }
    boolean bool1 = QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, this.bYd, "qzone_aio_gift", String.valueOf(this.bYd.hashCode()), -1, localalsl);
    if (bool1) {
      this.chj += 1;
    }
    boolean bool2 = alsk.access$200(this.tO, "qzone_aio_gift");
    if (bool2)
    {
      this.chj += 1;
      if (this.a != null)
      {
        if (this.chj != this.Dg) {
          break label224;
        }
        this.a.onSuccess();
      }
    }
    for (;;)
    {
      QLog.i("QzoneGiftUtil", 1, " isGiftZipFileExist = " + bool1 + " isGiftExist = " + bool2 + " mLoadSuccessTimes = " + this.chj + " mLoadFailTimes = " + this.chk);
      return;
      alsk.a(this.tO, "qzone_aio_gift", localalsl);
      break;
      label224:
      this.a.onLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1
 * JD-Core Version:    0.7.0.1
 */