import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class uld
{
  public static void a(skq paramskq, Context paramContext, spn paramspn)
  {
    label54:
    int i;
    label123:
    int j;
    if (paramspn.e() == 0L)
    {
      paramskq.jdField_a_of_type_Rpz.d = paramskq.jdField_a_of_type_Rpz.e;
      paramskq.jdField_a_of_type_Rpz.e = ((int)paramspn.b());
      rpz localrpz = paramskq.jdField_a_of_type_Rpz;
      if (paramskq.jdField_a_of_type_Rpz.d != 0) {
        break label294;
      }
      bool = true;
      localrpz.b = bool;
      paramskq.jdField_a_of_type_Rpz.c = true;
      paramskq.jdField_a_of_type_Rpz.h = ((int)paramspn.b());
      localrpz = paramskq.jdField_a_of_type_Rpz;
      AdvertisementInfo localAdvertisementInfo = ois.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localrpz.d;
      int m = localrpz.e;
      if (!localrpz.b) {
        break label300;
      }
      i = 1;
      if (!localrpz.c) {
        break label305;
      }
      j = 1;
      label134:
      JSONObject localJSONObject = ois.a(k, m, i, j, localrpz.f, 1, localrpz.h, 2, 0, localrpz.i, ReportConstants.VideoEndType.NORMAL_COMPLETE, true);
      ois.a(new ufy().a(paramContext).a(6).b(localrpz.g).a(localAdvertisementInfo).a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramspn.m();
      paramskq.jdField_a_of_type_Rpz.d = 0;
      paramskq.jdField_a_of_type_Rpz.e = 0;
      paramContext = paramskq.jdField_a_of_type_Rpz;
      if (paramskq.jdField_a_of_type_Rpz.d != 0) {
        break label311;
      }
    }
    label294:
    label300:
    label305:
    label311:
    for (boolean bool = true;; bool = false)
    {
      paramContext.b = bool;
      paramskq.jdField_a_of_type_Rpz.c = false;
      paramskq.jdField_a_of_type_Rpz.h = 0;
      return;
      paramskq.jdField_a_of_type_Rpz.d = ((int)paramspn.e());
      break;
      bool = false;
      break label54;
      i = 0;
      break label123;
      j = 0;
      break label134;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uld
 * JD-Core Version:    0.7.0.1
 */