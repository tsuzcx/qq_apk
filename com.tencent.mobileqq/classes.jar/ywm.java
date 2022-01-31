import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class ywm
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    if (paramywk != null) {}
    for (paramString = paramywk.a(); (paramywk == null) || (paramString == null); paramString = null)
    {
      yxp.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramywk)
    {
      yxp.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramywk);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywm
 * JD-Core Version:    0.7.0.1
 */