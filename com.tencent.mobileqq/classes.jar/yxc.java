import android.text.TextUtils;
import com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import org.json.JSONException;
import org.json.JSONObject;

final class yxc
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
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramywn = paramVarArgs.optString("process", "com.tencent.mobileqq:mini");
        if (TextUtils.equals(paramywn, "com.tencent.mobileqq"))
        {
          paramywn = PublicFragmentActivity.class;
          GdtInterstitialFragmentForJS.a(paramString, paramywn, paramVarArgs);
          return true;
        }
      }
      catch (JSONException paramywn)
      {
        yxs.d("GdtBannerJsCallHandler", "handleJsCallRequest error", paramywn);
        return true;
      }
      if (TextUtils.equals(paramywn, "com.tencent.mobileqq:tool")) {
        paramywn = PublicFragmentActivityForTool.class;
      } else {
        paramywn = PublicFragmentActivityForMini.class;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxc
 * JD-Core Version:    0.7.0.1
 */