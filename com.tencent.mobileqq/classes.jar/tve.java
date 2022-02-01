import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.impl.SuperMaskDataMgr.receiveAd.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/impl/SuperMaskDataMgr;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/ISuperMaskData;", "()V", "adData", "", "getAdData", "()Ljava/lang/Object;", "setAdData", "(Ljava/lang/Object;)V", "adResData", "Lorg/json/JSONObject;", "getAdResData", "()Lorg/json/JSONObject;", "setAdResData", "(Lorg/json/JSONObject;)V", "resCheckInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "getResCheckInfo", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "setResCheckInfo", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;)V", "receiveAd", "", "adInfo", "resetDataMgr", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tve
{
  @Nullable
  private static volatile Object jdField_a_of_type_JavaLangObject;
  @Nullable
  private static volatile JSONObject jdField_a_of_type_OrgJsonJSONObject;
  public static final tve a;
  @Nullable
  private static volatile tvp jdField_a_of_type_Tvp;
  
  static
  {
    jdField_a_of_type_Tve = new tve();
  }
  
  @Nullable
  public Object a()
  {
    return jdField_a_of_type_JavaLangObject;
  }
  
  @Nullable
  public JSONObject a()
  {
    return jdField_a_of_type_OrgJsonJSONObject;
  }
  
  @Nullable
  public tvp a()
  {
    return jdField_a_of_type_Tvp;
  }
  
  public final void a()
  {
    a(null);
    a((JSONObject)null);
    a((tvp)null);
    QLog.d("ReadInJoySuperMaskAd", 1, "resetDataMgr");
  }
  
  public void a(@Nullable Object paramObject)
  {
    jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(@Nullable JSONObject paramJSONObject)
  {
    jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public void a(@Nullable tvp paramtvp)
  {
    jdField_a_of_type_Tvp = paramtvp;
  }
  
  public void b(@Nullable Object paramObject)
  {
    if (((paramObject instanceof AdvertisementInfo)) && (twr.l((AdvertisementInfo)paramObject)))
    {
      QLog.d("ReadInJoySuperMaskAd", 1, "receiveAd");
      tvi.a.a(tuz.a.b());
      tvg.a.b();
      a(paramObject);
      tvg.a.a("recviceMask");
      ThreadManagerV2.post((Runnable)new SuperMaskDataMgr.receiveAd.1(paramObject), 10, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tve
 * JD-Core Version:    0.7.0.1
 */