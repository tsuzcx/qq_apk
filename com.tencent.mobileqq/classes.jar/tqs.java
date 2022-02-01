import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class tqs
{
  public static void a(rrm paramrrm, Context paramContext, rwf paramrwf)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramrwf.e() == 0L)
    {
      paramrrm.jdField_a_of_type_Qwu.d = paramrrm.jdField_a_of_type_Qwu.e;
      paramrrm.jdField_a_of_type_Qwu.e = ((int)paramrwf.b());
      qwu localqwu = paramrrm.jdField_a_of_type_Qwu;
      if (paramrrm.jdField_a_of_type_Qwu.d != 0) {
        break label268;
      }
      bool1 = true;
      localqwu.b = bool1;
      paramrrm.jdField_a_of_type_Qwu.c = true;
      localqwu = paramrrm.jdField_a_of_type_Qwu;
      AdvertisementInfo localAdvertisementInfo = nzq.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localqwu.d;
      int m = localqwu.e;
      if (!localqwu.b) {
        break label274;
      }
      i = 1;
      if (!localqwu.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = nzq.a(k, m, i, j, localqwu.f, 1, 0, nzq.aO, 0);
      nzq.a(new tlx().a(paramContext).a(nzq.f).b(localqwu.g).a(localAdvertisementInfo).a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramrwf.m();
      paramrrm.jdField_a_of_type_Qwu.d = 0;
      paramrrm.jdField_a_of_type_Qwu.e = 0;
      paramContext = paramrrm.jdField_a_of_type_Qwu;
      if (paramrrm.jdField_a_of_type_Qwu.d != 0) {
        break label285;
      }
    }
    label268:
    label274:
    label279:
    label285:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramContext.b = bool1;
      paramrrm.jdField_a_of_type_Qwu.c = false;
      return;
      paramrrm.jdField_a_of_type_Qwu.d = ((int)paramrwf.e());
      break;
      bool1 = false;
      break label57;
      i = 0;
      break label114;
      j = 0;
      break label125;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqs
 * JD-Core Version:    0.7.0.1
 */