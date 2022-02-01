import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class txg
{
  public static void a(ryo paramryo, Context paramContext, sdj paramsdj)
  {
    boolean bool2 = true;
    label57:
    int i;
    label114:
    int j;
    if (paramsdj.e() == 0L)
    {
      paramryo.jdField_a_of_type_Rds.d = paramryo.jdField_a_of_type_Rds.e;
      paramryo.jdField_a_of_type_Rds.e = ((int)paramsdj.b());
      rds localrds = paramryo.jdField_a_of_type_Rds;
      if (paramryo.jdField_a_of_type_Rds.d != 0) {
        break label268;
      }
      bool1 = true;
      localrds.b = bool1;
      paramryo.jdField_a_of_type_Rds.c = true;
      localrds = paramryo.jdField_a_of_type_Rds;
      AdvertisementInfo localAdvertisementInfo = obb.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      int k = localrds.d;
      int m = localrds.e;
      if (!localrds.b) {
        break label274;
      }
      i = 1;
      if (!localrds.c) {
        break label279;
      }
      j = 1;
      label125:
      JSONObject localJSONObject = obb.a(k, m, i, j, localrds.f, 1, 0, obb.aP, 0);
      obb.a(new trn().a(paramContext).a(obb.f).b(localrds.g).a(localAdvertisementInfo).a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject).a());
      paramsdj.m();
      paramryo.jdField_a_of_type_Rds.d = 0;
      paramryo.jdField_a_of_type_Rds.e = 0;
      paramContext = paramryo.jdField_a_of_type_Rds;
      if (paramryo.jdField_a_of_type_Rds.d != 0) {
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
      paramryo.jdField_a_of_type_Rds.c = false;
      return;
      paramryo.jdField_a_of_type_Rds.d = ((int)paramsdj.e());
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
 * Qualified Name:     txg
 * JD-Core Version:    0.7.0.1
 */