import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class tjt
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    if (paramtjs != null) {}
    for (paramString = paramtjs.getActivity(); (paramtjs == null) || (paramString == null); paramString = null)
    {
      tkw.e("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramtjs)
    {
      tkw.e("GdtBannerJsCallHandler", "handleJsCallRequest error", paramtjs);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjt
 * JD-Core Version:    0.7.0.1
 */