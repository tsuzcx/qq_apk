import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zug
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
        localHashMap.putAll(zuf.a());
        localHashMap.put("config", new zru("config", 3, 0, zub.class));
        localHashMap.put("setShareInfo", new zru("setShareInfo", 25, 0, zuc.class));
        localHashMap.put("closeWebview", new zru("closeWebview", 2, 0, zuc.class));
        localHashMap.put("refreshTitle", new zru("refreshTitle", 22, 0, zuc.class));
        localHashMap.put("setShareListener", new zru("setShareListener", 26, 0, zuc.class));
        localHashMap.put("lightappGetSDKVersion", new zru("lightappGetSDKVersion", 13, 0, algb.class));
        localHashMap.put("lightappShareCallback", new zru("lightappShareCallback", 15, 0, algb.class));
        localHashMap.put("lightappShareMessage", new zru("lightappShareMessage", 16, 0, algb.class));
        localHashMap.put("lightappOpenApp", new zru("lightappOpenApp", 14, 0, algb.class));
        localHashMap.put("lightappDisableLongPress", new zru("lightappDisableLongPress", 11, 0, algb.class));
        localHashMap.put("lightappDisableWebViewLongPress", new zru("lightappDisableWebViewLongPress", 12, 0, algb.class));
        a = Collections.unmodifiableMap(localHashMap);
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zug
 * JD-Core Version:    0.7.0.1
 */