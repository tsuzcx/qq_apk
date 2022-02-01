import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class tkg
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
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramtjs = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramtjs, "com.tencent.mobileqq"))
        {
          paramtjs = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramtjs, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramtjs)
      {
        tkw.e("GdtBannerJsCallHandler", "handleJsCallRequest error", paramtjs);
        return true;
      }
      if (TextUtils.equals(paramtjs, "com.tencent.mobileqq:tool")) {
        paramtjs = PublicFragmentActivityForTool.class;
      } else {
        paramtjs = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkg
 * JD-Core Version:    0.7.0.1
 */