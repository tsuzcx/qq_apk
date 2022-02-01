import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class tkf
  implements tkm
{
  private GdtDwellTimeStatisticsAfterClick a;
  
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    Activity localActivity = null;
    if (paramtjs != null) {
      localActivity = paramtjs.getActivity();
    }
    GdtHandler.Params localParams = new GdtHandler.Params();
    boolean bool = GdtHandler.a(localParams, paramVarArgs[0]);
    if ((paramtjs == null) || (localActivity == null) || (!bool))
    {
      tkw.e("GdtHandleAdJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    for (;;)
    {
      try
      {
        tkw.i("GdtHandleAdJsCallHandler", new JSONObject(paramVarArgs[0]).toString());
        localParams.processId = 7;
        localParams.activity = new WeakReference(localActivity);
        localParams.appReceiver = new WeakReference(paramtjs.a());
        localParams.n = GdtVideoCeilingFragmentForJS.class;
        localParams.p = GdtCanvasFragmentForJS.class;
        paramVarArgs = paramtjs.getActivity().getIntent();
        if (TextUtils.isEmpty(paramVarArgs.getStringExtra("big_brother_ref_source_key")))
        {
          paramVarArgs = paramVarArgs.getStringExtra("big_brother_source_key");
          localParams.extra = new Bundle();
          localParams.extra.putString("big_brother_ref_source_key", paramVarArgs);
          this.a = new GdtDwellTimeStatisticsAfterClick(localParams.ad, new WeakReference(paramtjs.mRuntime.getWebView()));
          this.a.click();
          GdtHandler.a(localParams);
          paramtjs.callJs(paramString, null);
          return true;
        }
      }
      catch (Throwable paramtjs)
      {
        tkw.e("GdtHandleAdJsCallHandler", "handleJsCallRequest error", paramtjs);
        return true;
      }
      paramVarArgs = paramVarArgs.getStringExtra("big_brother_ref_source_key");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkf
 * JD-Core Version:    0.7.0.1
 */