import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialFragment;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import org.json.JSONObject;

class tkl
  implements tkm
{
  private int ey(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 8;
    }
    return -2147483648;
  }
  
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    Activity localActivity = null;
    if (paramtjs != null) {
      localActivity = paramtjs.getActivity();
    }
    GdtHandler.Options localOptions = new GdtHandler.Options();
    boolean bool = GdtHandler.a(localOptions, paramVarArgs[0]);
    if ((paramtjs == null) || (localActivity == null) || (!bool))
    {
      tkw.e("GdtInterstitialJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        tkw.i("GdtInterstitialJsCallHandler", paramVarArgs.toString());
        int i = ey(paramVarArgs.getJSONObject("options").optInt("orientation"));
        paramVarArgs = paramtjs.getActivity().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localOptions.extra = new Bundle();
          localOptions.extra.putString("big_brother_ref_source_key", paramVarArgs);
          tkw.i("GdtInterstitialJsCallHandler", String.format("handleJsCallRequest Source.KEY_REF_ID:%s", new Object[] { paramVarArgs }));
          paramVarArgs = new GdtInterstitialParams();
          paramVarArgs.a = localOptions;
          paramVarArgs.orientation = i;
          paramVarArgs.aOZ = true;
          GdtInterstitialFragment.a(localActivity, paramVarArgs);
          paramtjs.callJs(paramString, null);
          return true;
        }
      }
      catch (Throwable paramtjs)
      {
        tkw.e("GdtInterstitialJsCallHandler", "handleJsCallRequest error", paramtjs);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkl
 * JD-Core Version:    0.7.0.1
 */