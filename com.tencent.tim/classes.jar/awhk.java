import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;

public class awhk
{
  private static SurfaceView d;
  private static String data = "";
  public static String url = "";
  
  public static void A(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if ((parama == null) || (parama.getWebView() == null) || (parama.getActivity() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parama.getActivity().findViewById(2131382171);
        if ((d != null) && (d.getParent() == localFrameLayout))
        {
          avpw.g(parama.getActivity(), d);
          return;
        }
        url = parama.getWebView().getUrl();
        if (paramVarArgs != null) {
          data = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(data));
      d = avpw.a(parama.getActivity(), data);
    } while (d == null);
    localFrameLayout.addView(d, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void B(WebViewPlugin.a parama, String... paramVarArgs)
  {
    if (parama == null) {}
    do
    {
      do
      {
        return;
        parama = parama.getActivity();
      } while (parama == null);
      paramVarArgs = (FrameLayout)parama.findViewById(2131382171);
      if ((paramVarArgs != null) && (d != null)) {
        paramVarArgs.removeView(d);
      }
      avpw.f(parama, d);
      d = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      avpw.a(parama, avpw.d.a(), paramVarArgs);
      awfb.cK(parama);
      parama.finish();
    } while (!avpw.aLc());
    arxa.a().showToast(avpw.cMK, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhk
 * JD-Core Version:    0.7.0.1
 */