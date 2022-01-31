import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class yjy
  implements yjn
{
  public yjy(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(yjm paramyjm)
  {
    if ((paramyjm != com.tencent.gdtad.api.GdtAd.access$100(this.a)) || (!this.a.isValid()))
    {
      yny.d("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.a, new yjz(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramyjm == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramyjm = null;
    }
    yjz localyjz;
    for (;;)
    {
      i = this.a.getErrorCode(paramyjm, k, j, i);
      localyjz = new yjz(i);
      yny.b("GdtAd", localyjz.a());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 2);
      this.a.getParams().a.a = paramyjm;
      com.tencent.gdtad.api.GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.a);
      return;
      if (paramyjm.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramyjm = null;
      }
      else
      {
        long l = paramyjm.a().jdField_a_of_type_Long;
        i = paramyjm.a().jdField_a_of_type_Int;
        if (paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramyjm = null;
        }
        else
        {
          j = paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramyjm = null;
          }
          else if (paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramyjm = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramyjm = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramyjm = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramyjm = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramyjm.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.a, localyjz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yjy
 * JD-Core Version:    0.7.0.1
 */