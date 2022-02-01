import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fillPatchParams", "", "adRequestData", "Lcom/tencent/biz/pubaccount/NativeAd/data/AdRequestData;", "json", "Lorg/json/JSONObject;", "adPosType", "", "fillSocialParams", "fillSuperMaskParams", "channelID", "fillTimeLoadParams", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class trz
{
  public static final void a(@Nullable oaa paramoaa, @Nullable JSONObject paramJSONObject)
  {
    if ((paramoaa != null) && (paramoaa.h == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("reqTimeVideoAdload", paramoaa.h);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("videoSceneId", paramoaa.i);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("videoTimeAdLoadLastAdPos", paramoaa.j);
      }
      twp.a("AdDataLink", "request time load ad");
    }
  }
  
  public static final void a(@Nullable oaa paramoaa, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramoaa != null) && (paramoaa.d == 1) && (paramInt == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("videoPatchAdFlag", paramoaa.d);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("prePatchAdCount", paramoaa.e);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("postPatchAdCount", paramoaa.f);
      }
      twp.a("AdDataLink", "request patch ad");
    }
  }
  
  public static final void a(@Nullable oaa paramoaa, @Nullable JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramoaa != null)
    {
      if ((paramoaa.a) && (paramInt2 == 1))
      {
        if (tvs.a.a("[REQUEST]", new tvc[] { (tvc)new tvm(), (tvc)new tvj(), (tvc)new tvr(paramInt1) })) {}
      }
      else {
        if ((tvd.a.a() != 1) || (!paramoaa.a)) {
          break label275;
        }
      }
      if (tvh.a.a())
      {
        paramoaa = tvh.a.a();
        if (((Map)paramoaa).isEmpty()) {
          break label198;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0) {
        for (;;)
        {
          if (paramInt1 == 0) {
            break label276;
          }
          JSONArray localJSONArray = new JSONArray();
          try
          {
            paramoaa = ((Map)paramoaa).entrySet().iterator();
            while (paramoaa.hasNext()) {
              localJSONArray.put(new JSONObject((Map)((Map.Entry)paramoaa.next()).getValue()));
            }
            paramoaa = tvh.a.b();
          }
          catch (Exception paramoaa)
          {
            label198:
            paramoaa.printStackTrace();
            if (paramJSONObject == null) {
              break label220;
            }
            paramJSONObject.put("superMaskType", 2);
            if (paramJSONObject == null) {
              break label233;
            }
            paramJSONObject.put("reqList", localJSONArray);
            tvg.a.a("requestMask");
            QLog.d("ReadInJoySuperMaskAd", 1, "[REQUEST]" + " : add superMask params : " + localJSONArray.toString());
          }
        }
      }
    }
    for (;;)
    {
      label220:
      label233:
      return;
      label275:
      label276:
      twp.a("ReadInJoySuperMaskAd", "[REQUEST] : getLocalResList is empty");
    }
  }
  
  public static final void b(@Nullable oaa paramoaa, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramoaa != null) && (paramoaa.g == 1) && (paramInt == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("social_card_flag", paramoaa.g);
      }
      twp.a("AdDataLink", "request social small ad");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trz
 * JD-Core Version:    0.7.0.1
 */