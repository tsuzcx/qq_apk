import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.1;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.2;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.3;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.4;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin.5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ardn
  extends WebViewPlugin
{
  public static final String PLUGIN_NAMESPACE = ardn.class.getSimpleName();
  QQAppInterface app = null;
  private boolean cZh;
  private boolean cZi;
  private boolean mActive = true;
  WebView webview;
  
  public ardn()
  {
    this.mPluginNameSpace = PLUGIN_NAMESPACE;
  }
  
  private void Wq(String paramString)
  {
    Object localObject = this.mRuntime.getActivity();
    if (localObject == null) {}
    do
    {
      return;
      ((Activity)localObject).finish();
      if (rwt.fK(paramString))
      {
        localObject = new Intent((Context)localObject, JoinDiscussionActivity.class);
        ((Intent)localObject).putExtra("innerSig", paramString);
        startActivity((Intent)localObject);
        return;
      }
      paramString = aqik.c(this.app, (Context)localObject, paramString);
    } while (paramString == null);
    paramString.ace();
  }
  
  private void Ws(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if ((paramString.startsWith("mqqapi://armap_entry/map?src_type=web&version=1&from_type=0&service_id=1")) || (paramString.startsWith("mqqapi://personal_tag/tag_list"))) {}
      for (int i = 1; i != 0; i = 0)
      {
        new Handler().postDelayed(new WebViewJumpPlugin.5(this), 2000L);
        return;
      }
    }
  }
  
  private Activity r()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void reportUrl(String paramString)
  {
    if (((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) && (this.webview != null))
    {
      String str = this.webview.getUrl();
      ThreadManager.getSubThreadHandler().post(new WebViewJumpPlugin.4(this, str, paramString));
    }
  }
  
  private void startActivity(Intent paramIntent)
  {
    if (this.mRuntime == null) {}
    do
    {
      return;
      if (this.mRuntime.getActivity() != null)
      {
        this.mRuntime.getActivity().startActivity(paramIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebViewJumpPlugin", 2, "Activity is null");
  }
  
  protected boolean K(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      paramBoolean = false;
      return paramBoolean;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("KEY_PID", String.valueOf(50079));
    localHashMap.put("KEY_EUSESTAT", String.valueOf(5));
    paramString = MttLoader.getValidQBUrl(this.mRuntime.getActivity(), paramString);
    int i = MttLoader.loadUrl(this.mRuntime.getActivity(), paramString, localHashMap, null);
    if (paramBoolean)
    {
      if ((this.webview == null) && (QLog.isColorLevel()))
      {
        QLog.d("WebViewJumpPlugin", 2, "webview is null");
        return true;
      }
      if (4 != i) {
        break label125;
      }
      this.webview.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
    }
    for (;;)
    {
      paramBoolean = bool;
      if (i == 0) {
        break;
      }
      return false;
      label125:
      if (5 == i) {
        this.webview.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      } else if (i != 0) {
        this.webview.loadUrl("https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=50079");
      }
    }
  }
  
  public void Wr(String paramString)
  {
    paramString = aqik.c(this.app, this.mRuntime.getActivity(), paramString);
    if (paramString != null) {
      paramString.ace();
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 2L) {
      this.mActive = true;
    }
    for (;;)
    {
      return false;
      if (paramLong == 8589934597L) {
        this.mActive = false;
      } else if (paramLong == 8589934601L)
      {
        if ((!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")))
        {
          if ((paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.getActivity() != null))
          {
            if (!(this.mRuntime.getActivity() instanceof IphoneTitleBarActivity)) {
              break label178;
            }
            ((IphoneTitleBarActivity)this.mRuntime.getActivity()).setLeftViewName(2131720734);
          }
          while ((this.mRuntime != null) && (this.mRuntime.getWebView() != null) && (this.mRuntime.getWebView().canGoBack()))
          {
            this.mRuntime.getWebView().goBack();
            return true;
            label178:
            if (((this.mRuntime.getActivity() instanceof aqzs)) && (!arcp.aGj()))
            {
              paramString = this.mRuntime.b();
              if ((paramString != null) && (paramString.a.leftView != null)) {
                paramString.a.leftView.setText(2131720734);
              }
            }
          }
        }
      }
      else if ((paramLong == 8589934594L) && (!TextUtils.isEmpty(paramString)) && ((paramString.contains("chatplay/hall")) || (paramString.contains("avwithstranger/avchathall")) || (paramString.contains("chatplay/avchathall"))) && (paramString.endsWith("#child")) && (paramString.contains("adtag=client.tab")) && (this.mRuntime != null) && (this.mRuntime.getActivity() != null)) {
        if ((this.mRuntime.getActivity() instanceof IphoneTitleBarActivity))
        {
          ((IphoneTitleBarActivity)this.mRuntime.getActivity()).setLeftViewName(2131691039);
        }
        else if (((this.mRuntime.getActivity() instanceof aqzs)) && (!arcp.aGj()))
        {
          paramString = this.mRuntime.b();
          if ((paramString != null) && (paramString.a.leftView != null)) {
            paramString.a.leftView.setText(2131691039);
          }
        }
      }
    }
  }
  
  public boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleSchemaRequest-->url:" + paramString1 + ",scheme:" + paramString2 + "mActive=" + this.mActive);
    }
    boolean bool1;
    if (!this.mActive) {
      bool1 = false;
    }
    Object localObject1;
    Object localObject2;
    int i;
    long l1;
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
                        do
                        {
                          do
                          {
                            do
                            {
                              return bool1;
                              if ((rwt.fI(paramString1)) && (rvx.fH(paramString1))) {
                                return false;
                              }
                              localObject1 = null;
                              localObject2 = r();
                              paramString2 = (String)localObject1;
                              if (localObject2 != null)
                              {
                                localObject2 = ((Activity)localObject2).getIntent();
                                paramString2 = (String)localObject1;
                                if (localObject2 != null) {
                                  paramString2 = ((Intent)localObject2).getStringExtra("big_brother_source_key");
                                }
                              }
                              if (paramString1.startsWith("tel:"))
                              {
                                paramString1 = new Intent("android.intent.action.DIAL", Uri.parse(paramString1));
                                paramString1.putExtra("big_brother_source_key", paramString2);
                                if ((!aqoq.cVe) && (aqoo.a().aFs())) {
                                  aqoo.a().k(paramString1);
                                }
                                startActivity(paramString1);
                                return true;
                              }
                              if (paramString1.startsWith("sms:"))
                              {
                                paramString2 = new Intent("android.intent.action.VIEW");
                                int j = paramString1.indexOf("?");
                                i = j;
                                if (j == -1) {
                                  i = paramString1.length();
                                }
                                paramString2.putExtra("address", paramString1.substring(paramString1.indexOf(":") + 1, i));
                                j = paramString1.indexOf("=");
                                i = j;
                                if (j == -1) {
                                  i = paramString1.length() - 1;
                                }
                                paramString2.putExtra("sms_body", paramString1.substring(i + 1, paramString1.length()));
                                paramString2.setType("vnd.android-dir/mms-sms");
                                startActivity(paramString2);
                                return true;
                              }
                              if (paramString1.startsWith("mqqapi://avatar/update?"))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d(this.TAG, 2, "enter WebViewJumpPlugin classicHeadActivity url=" + paramString1);
                                }
                                localObject2 = paramString1.split("&");
                                if ((localObject2 == null) || (localObject2.length < 5)) {
                                  break label1520;
                                }
                                localObject1 = localObject2[2].split("=");
                                paramString2 = localObject2[3].split("=");
                                localObject2 = localObject2[4].split("=");
                                if ((localObject1 == null) || (localObject1.length != 2) || (paramString2 == null) || (paramString2.length != 2) || (localObject2 == null) || (localObject2.length != 2)) {
                                  break label1520;
                                }
                                paramString1 = localObject1[1];
                                l1 = Long.parseLong(localObject2[1]);
                                long l2 = Long.parseLong(paramString2[1]);
                                paramString2 = new Intent("com.tencent.qqhead.refreshheadreq");
                                paramString2.setPackage(this.mRuntime.getActivity().getPackageName());
                                paramString2.putExtra("faceType", 1);
                                paramString2.putExtra("uin", paramString1);
                                paramString2.putExtra("headSystemId", l2);
                                paramString2.putExtra("faceFlag", l1);
                                this.mRuntime.getActivity().sendBroadcast(paramString2);
                                return true;
                              }
                              if (!paramString1.startsWith("mqqapi://tenpay/pay?")) {
                                break;
                              }
                              i = getRequestCode((byte)3);
                              bool1 = bool2;
                            } while (i == -1);
                            bool1 = bool2;
                          } while (this.cZi);
                          this.cZi = true;
                          paramString1 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
                          bool1 = bool2;
                        } while (paramString1 == null);
                        paramString1.setFrom("webview");
                        paramString1.fj("k_requestcode", String.valueOf(i));
                        paramString1.fj("url_app_info", QWalletPayJsPlugin.getPayAppInfo());
                        paramString1.ace();
                        this.cZh = true;
                        this.cZi = false;
                        return true;
                        if ((!rwt.fI(paramString1)) && (!paramString1.startsWith("mqqopensdkapi:"))) {
                          break;
                        }
                        paramString2 = this.mRuntime.getActivity();
                        bool1 = bool2;
                      } while (paramString2 == null);
                      paramString2 = aqik.c(this.app, paramString2, paramString1);
                      if (paramString2 != null)
                      {
                        paramString2.setFrom("webview");
                        paramString2.ace();
                      }
                      if (paramString1.startsWith("http:")) {
                        break;
                      }
                      bool1 = bool2;
                    } while (!paramString1.startsWith("https:"));
                    new Handler().postDelayed(new WebViewJumpPlugin.1(this), 2000L);
                    return true;
                    if (!paramString1.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard")) {
                      break;
                    }
                    paramString1 = Uri.parse(paramString1).getQueryParameter("xq_uin");
                    if (TextUtils.isEmpty(paramString1)) {
                      return false;
                    }
                    paramString1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramString1;
                    paramString2 = this.mRuntime.getActivity();
                    bool1 = bool2;
                  } while (paramString2 == null);
                  paramString1 = aqik.c(this.app, paramString2, paramString1);
                  if (paramString1 != null)
                  {
                    paramString1.setFrom("webview");
                    paramString1.ace();
                  }
                  new Handler().postDelayed(new WebViewJumpPlugin.2(this), 2000L);
                  return true;
                  if (paramString1.startsWith("http://clientui.3g.qq.com/mqqapi/"))
                  {
                    if ((this.webview == null) && (QLog.isColorLevel()))
                    {
                      QLog.d("WebViewJumpPlugin", 2, "webview is null");
                      return true;
                    }
                    localObject1 = this.webview.getUrl();
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      paramString2 = jqo.filterKeyForLog(paramString1, new String[0]);
                      paramString1 = paramString2;
                      if (paramString2.length() > 512) {
                        paramString1 = paramString2.substring(0, 512);
                      }
                      anot.b(null, "P_CliOper", "BizTechReport", "", "webview_jump", "http_jumpaction", 0, 1, 0, jqo.filterKeyForLog((String)localObject1, new String[0]), paramString1, "", "");
                    }
                    return false;
                  }
                  if (!paramString1.startsWith("mqqapi://readinjoy")) {
                    break;
                  }
                  paramString1 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
                  bool1 = bool2;
                } while (paramString1 == null);
                paramString1.setFrom("webview");
                paramString1.ace();
                return true;
                if (!paramString1.startsWith("mqqapi://now/playmedia")) {
                  break;
                }
                paramString1 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
                bool1 = bool2;
              } while (paramString1 == null);
              paramString1.setFrom("webview");
              paramString1.ace();
              return true;
              if (!paramString1.startsWith("mqqapi://now/playmedia")) {
                break;
              }
              paramString1 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
              bool1 = bool2;
            } while (paramString1 == null);
            paramString1.setFrom("webview");
            paramString1.setAppInterface(this.mRuntime.a());
            paramString1.ace();
            return true;
            if (!paramString1.startsWith("mqqapi://now/openSmallVideoRecord")) {
              break;
            }
            paramString1 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
            bool1 = bool2;
          } while (paramString1 == null);
          paramString1.setFrom("webview");
          paramString1.setAppInterface(this.mRuntime.a());
          paramString1.ace();
          return true;
          if ((paramString1.startsWith("mqqapi://")) || (paramString1.startsWith("qqfav://operation/")) || (paramString1.startsWith("nowmqqapi://now/openroom")))
          {
            localObject1 = new Intent(this.mRuntime.getActivity(), JumpActivity.class);
            ((Intent)localObject1).setData(Uri.parse(paramString1));
            ((Intent)localObject1).putExtra("from", "webview");
            if (!TextUtils.isEmpty(paramString2)) {
              ((Intent)localObject1).putExtra("big_brother_source_key", paramString2);
            }
            startActivity((Intent)localObject1);
            Ws(paramString1);
            return true;
          }
          if (!paramString1.startsWith("qb")) {
            break;
          }
          bool1 = bool2;
        } while (K(paramString1, false));
        bool1 = bool2;
      } while (this.mRuntime == null);
      bool1 = bool2;
    } while (this.mRuntime.getActivity() == null);
    paramString1 = MttLoader.getValidQBUrl(this.mRuntime.getActivity(), paramString1);
    if ((this.webview == null) && (QLog.isColorLevel()))
    {
      QLog.d("WebViewJumpPlugin", 2, "webview is null");
      return true;
    }
    this.webview.loadUrl(paramString1);
    return true;
    if ((paramString1.startsWith("mqqflyticket://")) || (rwt.fJ(paramString1)))
    {
      Wq(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqwpa://im"))
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.addFlags(268435456);
      paramString1.putExtra("from", "webview");
      startActivity(paramString1);
      return true;
    }
    if (paramString1.startsWith("mqqapi://pay_for_emosm_success"))
    {
      paramString2 = this.mRuntime.getActivity();
      if (paramString2 != null)
      {
        paramString2.setResult(8213);
        paramString2.finish();
      }
    }
    for (;;)
    {
      label1520:
      reportUrl(paramString1);
      return false;
      if (paramString1.startsWith("mqqapi://od"))
      {
        Wr(paramString1);
      }
      else
      {
        if (paramString1.startsWith("https://mp.qzone.qq.com/u/"))
        {
          paramString2 = aurr.getArgumentsFromURL(paramString1);
          if (paramString2.containsKey("uin")) {
            paramString2 = (String)paramString2.get("uin");
          }
          for (;;)
          {
            try
            {
              l1 = Long.parseLong(paramString2);
              paramString2 = avpw.b.Gd();
              if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "handleJumpToFamousSpace-->famous uin:" + l1 + ",actionUrl:" + paramString2);
              }
              localObject1 = this.mRuntime.getActivity();
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("qqid", l1);
              ((Intent)localObject2).putExtra("refer", "famous");
              ((Intent)localObject2).putExtra("famous_space_webview_url", paramString2);
              QzonePluginProxyActivity.x((Intent)localObject2, "com.qzone.homepage.ui.activity.QZoneFamousSpaceHomePageActivity");
              QzonePluginProxyActivity.a((Context)localObject1, this.mRuntime.a().getAccount(), (Intent)localObject2, 0);
              new Handler().postDelayed(new WebViewJumpPlugin.3(this), 2000L);
              return true;
            }
            catch (NumberFormatException paramString2)
            {
              paramString2.printStackTrace();
            }
            break;
            i = paramString1.lastIndexOf('?');
            if (i != -1) {
              paramString2 = paramString1.substring("https://mp.qzone.qq.com/u/".length(), i);
            } else {
              paramString2 = paramString1.substring("https://mp.qzone.qq.com/u/".length());
            }
          }
        }
        if (paramString1.startsWith("mqqconferenceflyticket://"))
        {
          if (this.mRuntime.getActivity() == null) {}
        }
        else if (paramString1.startsWith("mqqapi://groupvideo"))
        {
          paramString2 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
          if (paramString2 != null) {
            paramString2.ace();
          }
        }
        else if (paramString1.startsWith("mqqapi://stickynote"))
        {
          paramString2 = aqik.c(this.app, this.mRuntime.getActivity(), paramString1);
          if (paramString2 != null) {
            paramString2.ace();
          }
        }
      }
    }
  }
  
  public void onActivityReady()
  {
    if ((this.mRuntime.a() instanceof QQAppInterface)) {
      this.app = ((QQAppInterface)this.mRuntime.a());
    }
    this.webview = this.mRuntime.getWebView();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 3)
    {
      if (paramInt != -1) {
        break label129;
      }
      if ((this.cZh) && (paramIntent != null) && (this.webview != null))
      {
        str = paramIntent.getStringExtra("callback_type");
        if (!"javascript".equals(str)) {
          break label79;
        }
        callJs(paramIntent.getStringExtra("callback_name"), new String[] { paramIntent.getStringExtra("callback_data") });
      }
    }
    label79:
    while (paramInt != 0)
    {
      String str;
      for (;;)
      {
        this.cZh = false;
        return;
        if ("url".equals(str))
        {
          if ((this.webview == null) && (QLog.isColorLevel()))
          {
            QLog.d("WebViewJumpPlugin", 2, "webview is null");
            return;
          }
          this.webview.loadUrl(paramIntent.getStringExtra("callback_url"));
        }
      }
    }
    label129:
    this.cZh = false;
  }
  
  public void onCreate()
  {
    skj.a().bzj();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    skj.a().bzk();
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.webview = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardn
 * JD-Core Version:    0.7.0.1
 */