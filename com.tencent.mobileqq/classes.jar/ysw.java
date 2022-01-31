import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class ysw
  implements yso
{
  public ysw(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(ysn paramysn)
  {
    if ((paramysn != com.tencent.gdtad.api.GdtAd.access$100(this.a)) || (!this.a.isValid()))
    {
      yxp.d("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.a, new ysx(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramysn == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramysn = null;
    }
    ysx localysx;
    for (;;)
    {
      i = this.a.getErrorCode(paramysn, k, j, i);
      localysx = new ysx(i);
      yxp.b("GdtAd", localysx.a());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 2);
      this.a.getParams().a.a = paramysn;
      com.tencent.gdtad.api.GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.a);
      return;
      if (paramysn.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramysn = null;
      }
      else
      {
        long l = paramysn.a().jdField_a_of_type_Long;
        i = paramysn.a().jdField_a_of_type_Int;
        if (paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramysn = null;
        }
        else
        {
          j = paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramysn = null;
          }
          else if (paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramysn = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramysn = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramysn = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramysn = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramysn.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.a, localysx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ysw
 * JD-Core Version:    0.7.0.1
 */