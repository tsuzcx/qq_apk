import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class zye
  implements tgc.a
{
  zye(zyd paramzyd, long paramLong, BaseChatPie paramBaseChatPie) {}
  
  public void onResponse(tgc paramtgc)
  {
    try
    {
      zyd.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse :" + paramtgc + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.val$startTime));
      }
      if ((paramtgc == null) || (paramtgc.a() == null) || (paramtgc.a().a == null) || (!paramtgc.a().a.ret.has()) || (paramtgc.a().a.ret.get() != 0))
      {
        zyd.a(this.this$0, paramtgc);
        zyd.a(this.this$0);
        return;
      }
      paramtgc = paramtgc.a().a;
      if ((!paramtgc.pos_ads_info.has()) || (paramtgc.pos_ads_info.size() <= 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.pos_ads_info.get(0)).ret.has()) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.pos_ads_info.get(0)).ret.get() != 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.pos_ads_info.get(0)).ads_info.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : getAdInfo is null");
        }
        zyd.a(this.this$0);
        return;
      }
    }
    catch (Throwable paramtgc)
    {
      QLog.e("QWalletGdtAdManager", 1, paramtgc, new Object[0]);
      return;
    }
    if ((!zyd.a(this.this$0)) && (zyd.a(this.this$0) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
      }
      zyd.a(this.this$0);
      return;
    }
    zyd.a(this.this$0, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.pos_ads_info.get(0)).ads_info.get(0)));
    zyd.a(this.this$0, this.d);
    if (zyd.b(this.this$0)) {
      tgh.a().a(zyd.a(this.this$0));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : notifyDataSetChanged,mHasTailMsg:" + zyd.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zye
 * JD-Core Version:    0.7.0.1
 */