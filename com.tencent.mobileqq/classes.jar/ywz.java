import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class ywz
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
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramywk = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramywk, "com.tencent.mobileqq"))
        {
          paramywk = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramywk, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramywk)
      {
        yxp.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramywk);
        return true;
      }
      if (TextUtils.equals(paramywk, "com.tencent.mobileqq:tool")) {
        paramywk = PublicFragmentActivityForTool.class;
      } else {
        paramywk = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */