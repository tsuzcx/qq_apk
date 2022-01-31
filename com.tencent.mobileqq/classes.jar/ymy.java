import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class ymy
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    if (paramymw != null) {}
    for (paramString = paramymw.a(); (paramymw == null) || (paramString == null); paramString = null)
    {
      yny.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramymw)
    {
      yny.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramymw);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ymy
 * JD-Core Version:    0.7.0.1
 */