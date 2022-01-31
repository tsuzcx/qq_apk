import com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS;
import org.json.JSONException;
import org.json.JSONObject;

public class ywp
  implements yxh
{
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    if (paramywn != null) {}
    for (paramString = paramywn.a(); (paramywn == null) || (paramString == null); paramString = null)
    {
      yxs.d("GdtBannerJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    try
    {
      GdtBannerFragmentForJS.a(paramString, new JSONObject(paramVarArgs[0]), GdtBannerFragmentForJS.class);
      return true;
    }
    catch (JSONException paramywn)
    {
      yxs.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramywn);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywp
 * JD-Core Version:    0.7.0.1
 */