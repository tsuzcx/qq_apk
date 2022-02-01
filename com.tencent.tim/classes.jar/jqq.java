import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

public class jqq
  extends WebViewPlugin
{
  public jqq()
  {
    this.mPluginNameSpace = "coupon";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("coupon".equals(paramString2))
    {
      if (("goToCouponHomePage".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        lg(paramVarArgs[0]);
        paramJsBridgeListener.onComplete(null);
      }
      return true;
    }
    return false;
  }
  
  public void lg(String paramString)
  {
    Activity localActivity = this.mRuntime.getActivity();
    int i;
    if ((localActivity instanceof CouponActivity))
    {
      localObject = (CouponActivity)localActivity;
      i = ((CouponActivity)localObject).from;
      if ((i & 0x8) != 0)
      {
        paramString = new Intent();
        paramString.putExtra("toPage", 2);
        ((CouponActivity)localObject).setResult(-1, paramString);
        ((CouponActivity)localObject).superFinish();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent(localActivity, CouponActivity.class);
    ((Intent)localObject).putExtra("from", (i | 0xA) & 0xE);
    if (!TextUtils.isEmpty(paramString)) {
      ((Intent)localObject).putExtra("jsonParams", paramString);
    }
    localActivity.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqq
 * JD-Core Version:    0.7.0.1
 */