import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.2.1;

public class awge
  implements DialogInterface.OnClickListener
{
  public awge(QzoneQunFeedJsPlugin.2.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.a.this$0.f.mRuntime.a().getAccount();
    Intent localIntent = new Intent();
    String str = this.a.a.this$0.f.mRuntime.getActivity().getResources().getString(2131717765);
    QzonePluginProxyActivity.x(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", "jhan_plxz");
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.a(this.a.a.this$0.f.mRuntime.getActivity(), paramDialogInterface, localIntent, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awge
 * JD-Core Version:    0.7.0.1
 */