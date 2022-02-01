import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;
import java.util.concurrent.atomic.AtomicLong;

public class aili
  extends BroadcastReceiver
{
  public aili(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = (ResultReceiver)paramIntent.getParcelableExtra("receiver");
    long l = paramIntent.getLongExtra("seq", 0L);
    Bundle localBundle = new Bundle();
    localBundle.putLong("seq", l);
    if (UiApiPlugin.C.get() != -1L) {
      paramContext.send(-1, localBundle);
    }
    String str = paramIntent.getStringExtra("date");
    paramIntent = paramIntent.getStringExtra("id");
    Object localObject = this.this$0.mRuntime.getActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.this$0.mRuntime.getWebView();
      if ((localObject == null) || (((WebView)localObject).getX5WebViewExtension() == null))
      {
        paramContext.send(-2, localBundle);
        return;
      }
      localBundle = new Bundle();
      localBundle.putString("date", str);
      localBundle.putString("id", paramIntent);
      UiApiPlugin.C.set(l);
      UiApiPlugin.r = paramContext;
      ((WebView)localObject).getX5WebViewExtension().invokeMiscMethod("uploadX5CoreLiveLog", localBundle);
      return;
    }
    paramContext.send(-2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aili
 * JD-Core Version:    0.7.0.1
 */