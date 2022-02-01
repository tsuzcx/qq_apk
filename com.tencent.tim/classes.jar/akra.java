import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.qphone.base.util.QLog;

class akra
  implements adby.a
{
  akra(akqx paramakqx, AppInterface paramAppInterface) {}
  
  public void aj(String paramString, int paramInt1, int paramInt2)
  {
    PromotionConfigInfo.a locala = this.c.b();
    if ((locala == null) || (!TextUtils.equals(paramString, locala.id))) {
      return;
    }
    if (paramInt1 < this.c.mj.length) {
      this.c.mj[paramInt1] = paramInt2;
    }
    if ((paramInt2 >= 0) && (paramInt2 <= 99))
    {
      akqx.a(this.c, "onDownloadProgress", true);
      return;
    }
    QLog.w(akqx.TAG, 1, "onDownloadProgress, index[" + paramInt1 + "], progress[" + paramInt2 + "]");
    if ((paramInt2 == 100) && (paramInt1 == 0)) {
      akqx.a(this.c, "onDownloadProgress", this.b);
    }
    akqx.a(this.c, "onDownloadProgress2", this.b, false);
  }
  
  public void cPW() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akra
 * JD-Core Version:    0.7.0.1
 */