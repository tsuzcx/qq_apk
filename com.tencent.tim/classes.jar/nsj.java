import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.d;
import org.json.JSONException;
import org.json.JSONObject;

public class nsj
{
  public static kxm.b a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    localb = p(paramInt);
    try
    {
      paramString1 = localb.b(paramString1).a("URL", paramString2);
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramString1 = paramString1.a("ad_page", paramInt);
        return paramString1;
      }
      return localb;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, TopBannerInfo.b paramb)
  {
    if ((paramb instanceof TopBannerInfo.d)) {}
    for (String str = ((TopBannerInfo.d)paramb).jumpUrl;; str = "0")
    {
      kbp.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt3), String.valueOf(paramInt1), String.valueOf(paramb.type), a(paramInt2, paramb.rowKey, str, paramb.isAD).build(), false);
      return;
    }
  }
  
  public static void a(String paramString, int paramInt, TopBannerInfo.b paramb)
  {
    if ((paramb instanceof TopBannerInfo.d)) {}
    for (paramb = ((TopBannerInfo.d)paramb).jumpUrl;; paramb = "0")
    {
      kbp.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt), "", "", l(paramInt, paramb), false);
      return;
    }
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    kxm.b localb = p(paramInt1);
    if (paramBoolean) {
      paramInt1 = 1;
    }
    try
    {
      for (;;)
      {
        localb.a("ad_page_include", paramInt1);
        kbp.a(null, "", paramString, paramString, 0, 0, String.valueOf(paramInt2), "", "", localb.build(), false);
        return;
        paramInt1 = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static String l(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramString);
      localJSONObject.put("num", paramInt);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static kxm.b p(int paramInt)
  {
    return new kxm.b().c().a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsj
 * JD-Core Version:    0.7.0.1
 */