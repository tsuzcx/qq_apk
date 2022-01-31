import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class zap
  implements DialogInterface.OnClickListener
{
  public zap(ApolloStoreActivity paramApolloStoreActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!TextUtils.isEmpty(ApolloConstant.X)) {}
    for (String str = ApolloConstant.X;; str = ApolloConstant.M)
    {
      long l1 = DeviceInfoUtil.k();
      long l2 = DeviceInfoUtil.j();
      str = str + "&screenWidth=" + (int)((float)l2 / ApolloStoreActivity.a(this.a)) + "&screenHeight=" + (int)((float)l1 / ApolloStoreActivity.a(this.a)) + "&tab=mall&view=role";
      WebViewFragment localWebViewFragment = this.a.b();
      if ((localWebViewFragment != null) && (localWebViewFragment.a != null)) {
        localWebViewFragment.a.loadUrl(str);
      }
      paramDialogInterface.dismiss();
      VipUtils.a(null, "cmshow", "Apollo", "AI_alert_mall", 0, 0, new String[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zap
 * JD-Core Version:    0.7.0.1
 */