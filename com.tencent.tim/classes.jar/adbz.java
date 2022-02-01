import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.b;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class adbz
  implements aduq.b
{
  int bAa = 0;
  long lastNotifyTime = System.currentTimeMillis();
  final long seq = AudioHelper.hG();
  
  adbz(adby paramadby, AppInterface paramAppInterface, String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    int i;
    if ((paramObject instanceof PromotionConfigInfo.b))
    {
      paramString1 = (PromotionConfigInfo.b)paramObject;
      paramString1.RY = System.currentTimeMillis();
      paramObject = this.b.getAccount();
      boolean bool = false;
      if (paramInt == 0) {
        bool = adby.a(paramString1);
      }
      QLog.w(this.this$0.TAG, 1, "onDownloadFinish, md5[" + paramString2 + "], errCode[" + paramInt + "], check[" + bool + "], path[" + paramString3 + "], id[" + paramString1.id + "], request[" + paramString1.RW + "], Begin[" + paramString1.RX + "], End[" + paramString1.RY + "], 调度耗时[" + (paramString1.RX - paramString1.RW) + "], 下载耗时[" + (paramString1.RY - paramString1.RX) + "], fromPreCover[" + paramString1.cCb + "], seq[" + this.seq + "], Uin[" + paramObject + "], zipItem[" + paramString1 + "]");
      if (paramString1.a == this) {
        paramString1.a = null;
      }
      i = paramInt;
      if (paramInt == 0)
      {
        i = paramInt;
        if (!bool) {
          i = -5;
        }
      }
      if (i != 0) {
        break label339;
      }
      paramString1.setDownloadType(2);
      aqny.h(paramObject, paramString1.id, paramString1.index, paramString1.md5);
      this.this$0.ah(paramString1.id, paramString1.index, 100);
      paramString1.cCb = -1;
    }
    for (;;)
    {
      this.this$0.a(this.b, paramString1.bLi, paramString1.id, paramString1.index + 1);
      return;
      label339:
      if (i == 100)
      {
        paramString1.setDownloadType(2);
        this.this$0.ah(paramString1.id, paramString1.index, 100);
      }
      else
      {
        paramString1.setDownloadType(-1);
        this.this$0.ah(paramString1.id, paramString1.index, -1);
      }
    }
  }
  
  public void f(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt == 100) || (paramInt == 0) || (Math.abs(paramInt - this.bAa) >= 10)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      long l = System.currentTimeMillis();
      if (l - this.lastNotifyTime >= 1000L) {
        bool2 = true;
      }
      if ((QLog.isDevelopLevel()) && ((bool2) || (bool1))) {
        QLog.w(this.this$0.TAG, 1, "onDownloadUpdate, md5[" + paramString2 + "], activityid[" + this.brO + "], index[" + this.val$index + "], curPercent[" + paramInt + "], lastPercent[" + this.bAa + "], needNotify[" + bool1 + "], needNotify2[" + bool2 + "]");
      }
      if (bool1) {
        this.bAa = paramInt;
      }
      if (bool2) {
        this.lastNotifyTime = l;
      }
      if ((bool1) || (bool2)) {
        this.this$0.ah(this.brO, this.val$index, paramInt);
      }
      return;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    QLog.w(this.this$0.TAG, 1, "ZipItem.finalize, activityid[" + this.brO + "], index[" + this.val$index + "], seq[" + this.seq + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbz
 * JD-Core Version:    0.7.0.1
 */