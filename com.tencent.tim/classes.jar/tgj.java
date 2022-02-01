import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class tgj
  implements tgc.a
{
  public tgj(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(tgc paramtgc)
  {
    if ((paramtgc != com.tencent.gdtad.api.GdtAd.access$100(this.this$0)) || (!this.this$0.isValid()))
    {
      tkw.e("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.this$0, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.this$0, new tgk(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramtgc == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramtgc = null;
    }
    tgk localtgk;
    for (;;)
    {
      i = this.this$0.getErrorCode(paramtgc, k, j, i);
      localtgk = new tgk(i);
      tkw.i("GdtAd", localtgk.getErrorMessage());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.this$0, 2);
      this.this$0.getParams().c.ad = paramtgc;
      com.tencent.gdtad.api.GdtAd.access$402(this.this$0, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.this$0);
      return;
      if (paramtgc.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramtgc = null;
      }
      else
      {
        long l = paramtgc.a().timeMillis;
        i = paramtgc.a().httpResponseCode;
        if (paramtgc.a().a == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramtgc = null;
        }
        else
        {
          j = paramtgc.a().a.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramtgc = null;
          }
          else if (paramtgc.a().a.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramtgc = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.a().a.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramtgc = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.a().a.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramtgc = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramtgc = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramtgc.a().a.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.this$0, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.this$0, localtgk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgj
 * JD-Core Version:    0.7.0.1
 */