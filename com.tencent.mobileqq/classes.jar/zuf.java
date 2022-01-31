import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zuf
{
  private static Map<String, zru> a;
  
  public static Map<String, zru> a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("getLocation", new zru("getLocation", 7, 1, zsx.class));
        localHashMap.put("getCity", new zru("getCity", 6, 1, zsx.class));
        localHashMap.put("login", new zru("login", 17, 0, ztd.class));
        localHashMap.put("loginSilent", new zru("loginSilent", 18, 0, ztd.class));
        localHashMap.put("getUserInfo", new zru("getUserInfo", 10, 2, ztd.class));
        localHashMap.put("getAppFriends", new zru("getAppFriends", 5, 2, ztd.class));
        localHashMap.put("getRankingList", new zru("getRankingList", 8, 2, zsu.class));
        localHashMap.put("reportScore", new zru("reportScore", 24, 2, zsu.class));
        localHashMap.put("showShareMenu", new zru("showShareMenu", 30, 0, ztb.class));
        localHashMap.put("shareMessage", new zru("shareMessage", 27, 0, ztb.class));
        localHashMap.put("showActionSheet", new zru("showActionSheet", 28, 0, ztn.class));
        localHashMap.put("showDialog", new zru("showDialog", 29, 0, ztn.class));
        localHashMap.put("getSkey", new zru("getSkey", 9, 0, zts.class));
        localHashMap.put("openWebView", new zru("openWebView", 21, 0, ztt.class));
        localHashMap.put("openPlatoView", new zru("openPlatoView", 20, 0, ztt.class));
        localHashMap.put("openNativeView", new zru("openNativeView", 19, 0, ztt.class));
        localHashMap.put("addEventListener", new zru("addEventListener", 1, 0, ztq.class));
        localHashMap.put("removeEventListener", new zru("removeEventListener", 23, 0, ztq.class));
        localHashMap.put("dispatchEvent", new zru("dispatchEvent", 4, 0, ztq.class));
        localHashMap.put("sdk_dynamic_avatar_edit", new zru("sdk_dynamic_avatar_edit", 31, 0, ztu.class));
        localHashMap.put("sdk_face_collection", new zru("sdk_face_collection", 32, 0, ztu.class));
        localHashMap.put("sdk_avatar_edit", new zru("sdk_avatar_edit", 33, 0, ztu.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zuf
 * JD-Core Version:    0.7.0.1
 */