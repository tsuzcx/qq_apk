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
public final class ugk
{
  public static final void a(@Nullable oha paramoha, @Nullable JSONObject paramJSONObject)
  {
    if ((paramoha != null) && (paramoha.h == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("reqTimeVideoAdload", paramoha.h);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("videoSceneId", paramoha.i);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("videoTimeAdLoadLastAdPos", paramoha.j);
      }
      ukq.a("AdDataLink", "request time load ad");
    }
  }
  
  public static final void a(@Nullable oha paramoha, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramoha != null) && (paramoha.d == 1) && (paramInt == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("videoPatchAdFlag", paramoha.d);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("prePatchAdCount", paramoha.e);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("postPatchAdCount", paramoha.f);
      }
      ukq.a("AdDataLink", "request patch ad");
    }
  }
  
  public static final void a(@Nullable oha paramoha, @Nullable JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramoha != null)
    {
      if ((paramoha.b) && (paramInt2 == 1))
      {
        if (ujt.a.a("[REQUEST]", new ujc[] { (ujc)new ujn(), (ujc)new ujk(), (ujc)new ujs(paramInt1) })) {}
      }
      else {
        if ((ujd.a.a() != 1) || (!paramoha.b)) {
          break label278;
        }
      }
      if (ujh.a.a())
      {
        paramoha = ujh.a.a();
        if (((Map)paramoha).isEmpty()) {
          break label198;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0) {
        for (;;)
        {
          if (paramInt1 == 0) {
            break label279;
          }
          JSONArray localJSONArray = new JSONArray();
          try
          {
            paramoha = ((Map)paramoha).entrySet().iterator();
            while (paramoha.hasNext()) {
              localJSONArray.put(new JSONObject((Map)((Map.Entry)paramoha.next()).getValue()));
            }
            paramoha = ujh.a.b();
          }
          catch (Exception paramoha)
          {
            label198:
            paramoha.printStackTrace();
            if (paramJSONObject == null) {
              break label220;
            }
            paramJSONObject.put("superMaskType", 2);
            if (paramJSONObject == null) {
              break label233;
            }
            paramJSONObject.put("reqList", localJSONArray);
            ujg.a(ujg.a, "requestMask", null, 2, null);
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
      label278:
      label279:
      ukq.a("ReadInJoySuperMaskAd", "[REQUEST] : getLocalResList is empty");
    }
  }
  
  public static final void b(@Nullable oha paramoha, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramoha != null) && (paramoha.g == 1) && (paramInt == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("social_card_flag", paramoha.g);
      }
      ukq.a("AdDataLink", "request social small ad");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugk
 * JD-Core Version:    0.7.0.1
 */