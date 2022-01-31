import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class ysz
  implements ysr
{
  public ysz(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(ysq paramysq)
  {
    if ((paramysq != com.tencent.gdtad.api.GdtAd.access$100(this.a)) || (!this.a.isValid()))
    {
      yxs.d("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.a, new yta(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramysq == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramysq = null;
    }
    yta localyta;
    for (;;)
    {
      i = this.a.getErrorCode(paramysq, k, j, i);
      localyta = new yta(i);
      yxs.b("GdtAd", localyta.a());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 2);
      this.a.getParams().a.a = paramysq;
      com.tencent.gdtad.api.GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.a);
      return;
      if (paramysq.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramysq = null;
      }
      else
      {
        long l = paramysq.a().jdField_a_of_type_Long;
        i = paramysq.a().jdField_a_of_type_Int;
        if (paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramysq = null;
        }
        else
        {
          j = paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramysq = null;
          }
          else if (paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramysq = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramysq = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramysq = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramysq = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramysq.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.a, localyta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */