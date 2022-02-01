import android.app.Activity;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public class arei
  extends WebViewPlugin
{
  private RedTouch a;
  private int eeL = 2147483647;
  ColorFilter f = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
  private WebView webview;
  
  public arei()
  {
    this.mPluginNameSpace = "allpeoplevote";
  }
  
  private void n(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i = 0;
    Object localObject = this.mRuntime.getActivity();
    WebViewFragment localWebViewFragment = this.mRuntime.b();
    if (localWebViewFragment != null)
    {
      ImageView localImageView = localWebViewFragment.a.rightViewImg;
      if (this.eeL == 2147483647) {
        this.eeL = localImageView.getPaddingRight();
      }
      if ((!paramBoolean1) || (TextUtils.isEmpty(paramString)))
      {
        localImageView.setVisibility(8);
        localImageView.setPadding(localImageView.getPaddingLeft(), localImageView.getPaddingTop(), this.eeL, localImageView.getPaddingBottom());
        return;
      }
      localImageView.setImageResource(2130845749);
      int k;
      if (localWebViewFragment.a.centerView != null)
      {
        int j = localWebViewFragment.a.centerView.getCurrentTextColor();
        localImageView.setColorFilter(new PorterDuffColorFilter(j, PorterDuff.Mode.SRC_IN));
        if (QLog.isColorLevel()) {
          QLog.i("WholePeoplePlugin", 2, "titleColor:" + j);
        }
        localImageView.setVisibility(0);
        if (!paramBoolean2) {
          break label388;
        }
        if (this.a == null) {
          this.a = new RedTouch((Context)localObject, localImageView).a(53).a();
        }
        localObject = aeai.a().n();
        if (localObject == null) {
          break label371;
        }
        j = ((Bundle)localObject).getInt("redPointCount", 0);
        k = ((Bundle)localObject).getInt("redNumCount", 0);
        if (k > 0) {
          break label350;
        }
        label255:
        localObject = areg.a(k, j);
        this.a.e((BusinessInfoCheckUpdate.AppInfo)localObject);
        j = localImageView.getPaddingLeft();
        k = localImageView.getPaddingTop();
        int m = this.eeL;
        localImageView.setPadding(j, k, wja.dp2px(i, this.webview.getResources()) + m, localImageView.getPaddingBottom());
      }
      label388:
      for (;;)
      {
        localImageView.setOnClickListener(new arej(this, paramString));
        return;
        localImageView.setColorFilter(this.f);
        break;
        label350:
        if (k > 99)
        {
          i = 12;
          break label255;
        }
        i = 10;
        break label255;
        label371:
        if (this.a != null)
        {
          this.a.dGB();
          continue;
          if (this.a != null) {
            this.a.dGB();
          }
        }
      }
    }
    QLog.e("WholePeoplePlugin", 1, "setRightButton, not support " + localObject);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    bool2 = false;
    boolean bool3 = true;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("allpeoplevote")) || (paramString3 == null)) {
      bool1 = false;
    }
    label232:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((this.mRuntime == null) || (this.mRuntime.getActivity() == null)) {
                return false;
              }
              if ((paramString3.equalsIgnoreCase("setRightButton")) && (paramVarArgs.length == 1))
              {
                for (;;)
                {
                  try
                  {
                    paramJsBridgeListener = this.mRuntime.getActivity();
                    bool1 = bool3;
                    if (paramJsBridgeListener == null) {
                      break;
                    }
                    bool1 = bool3;
                    if (paramJsBridgeListener.isFinishing()) {
                      break;
                    }
                    paramString2 = new JSONObject(paramVarArgs[0]);
                    paramJsBridgeListener = paramString2.optString("callback");
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    bool1 = bool3;
                  }
                  try
                  {
                    paramString1 = paramString2.optString("show");
                    paramString2 = paramString2.optString("showRedNum");
                    i = Integer.parseInt(paramString1);
                  }
                  catch (Exception paramString1)
                  {
                    i = 0;
                  }
                  try
                  {
                    j = Integer.parseInt(paramString2);
                    if (!QLog.isColorLevel()) {
                      break label330;
                    }
                    QLog.i("WholePeoplePlugin", 2, "setRightButton show=" + i + " showRedNum=" + j + " callback=" + paramJsBridgeListener);
                  }
                  catch (Exception paramString1)
                  {
                    do
                    {
                      break label232;
                    } while (i != 1);
                    bool1 = true;
                    if (j != 1) {
                      continue;
                    }
                    bool2 = true;
                    continue;
                  }
                  n(bool1, bool2, paramJsBridgeListener);
                  return true;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("WholePeoplePlugin", 2, "setRightButton error", paramJsBridgeListener);
                  return true;
                  j = 0;
                }
                bool1 = false;
                break label339;
              }
              bool1 = bool3;
            } while (!paramString3.equalsIgnoreCase("readRedPoint"));
            paramJsBridgeListener = this.mRuntime.getActivity();
            bool1 = bool3;
          } while (paramJsBridgeListener == null);
          bool1 = bool3;
        } while (paramJsBridgeListener.isFinishing());
        aeai.a().cVt();
        bool1 = bool3;
      } while (this.a == null);
      bool1 = bool3;
    } while (!this.a.aux());
    this.a.dGB();
    return true;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.webview = this.mRuntime.getWebView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arei
 * JD-Core Version:    0.7.0.1
 */