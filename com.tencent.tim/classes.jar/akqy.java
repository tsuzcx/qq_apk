import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.a;
import com.tencent.qphone.base.util.QLog;

class akqy
  implements adbv.a
{
  akqy(akqx paramakqx, String paramString, AppInterface paramAppInterface) {}
  
  public void b(PromotionConfigInfo paramPromotionConfigInfo)
  {
    boolean bool = false;
    QLog.w(akqx.TAG, 1, "getRes, promotionConfigInfo[" + paramPromotionConfigInfo + "], activityID[" + this.bUf + "], isDestroyed[" + akqx.a(this.c) + "]");
    if (akqx.a(this.c)) {
      return;
    }
    Object localObject = null;
    PromotionConfigInfo.a locala;
    String str;
    if (paramPromotionConfigInfo != null)
    {
      if (this.bUf == null) {
        break label324;
      }
      locala = paramPromotionConfigInfo.getItem(this.bUf);
      str = akqx.a(this.c).getCurrentAccountUin();
      int i = adld.cG(str + "AR_PROMOTION_ENTRY_SHOWONCE");
      int j = aqny.fo(str);
      if ((j != adld.cG(str + "AR_PROMOTION_ENTRY_SERVER_VERSION")) || (j == 0))
      {
        adld.eg(str + "AR_PROMOTION_ENTRY_SERVER_VERSION", j);
        i = 0;
      }
      if ((!paramPromotionConfigInfo.showOnce) || (i == 0)) {
        adld.eg(str + "AR_PROMOTION_ENTRY_SHOWONCE", 0);
      }
      if (!paramPromotionConfigInfo.showOnce) {
        break label333;
      }
      if (i != 0) {}
    }
    label324:
    label333:
    for (bool = true;; bool = true)
    {
      akqx.a(this.c).bP(bool, paramPromotionConfigInfo.showInTopView);
      localObject = locala;
      if (bool)
      {
        localObject = locala;
        if (paramPromotionConfigInfo.showOnce)
        {
          adld.eg(str + "AR_PROMOTION_ENTRY_SHOWONCE", 1);
          localObject = locala;
        }
      }
      akqx.a(this.c, this.b, localObject);
      return;
      locala = paramPromotionConfigInfo.getActivityItem();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akqy
 * JD-Core Version:    0.7.0.1
 */