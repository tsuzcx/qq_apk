import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.a;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.widget.RangeButtonView.a;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class arbt
  extends araz.a
  implements DialogInterface.OnDismissListener, ShareActionSheet.OnItemClickListener, RangeButtonView.a
{
  public static long In = -1L;
  public static final int[] hq = { 95, 100, 107, 115, 127 };
  private arbt.a jdField_a_of_type_Arbt$a;
  public ShareActionSheetBuilder a;
  private ncy jdField_a_of_type_Ncy;
  public String aTX = "";
  public int aXQ = 1;
  private int appId;
  public String awT = "";
  public svi b;
  private int bQX;
  public String bQs = "general_url";
  private long bS = -1L;
  protected Bundle ba;
  public boolean bfA;
  private boolean bfB;
  private boolean bfC;
  public boolean bfD;
  public boolean bfE;
  public boolean bfy;
  public boolean bfz = true;
  public WebViewFragment c;
  private boolean cXE;
  private boolean cXF;
  private boolean cXG = true;
  private boolean cXH = true;
  private boolean cXI;
  private int edX;
  public long gK = 4L;
  boolean isDestroyed = false;
  skj mClient = null;
  private String mUrl;
  public String msgid = "";
  public final ArrayList<String> qo = new ArrayList();
  public ArrayList<PublicAccountJavascriptInterface.a> qp;
  public Activity s;
  public String toUin = "";
  public int uinType;
  private long yF = -1L;
  
  private void T(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(this.b.aHg)) {
      this.b.g(paramString1, 3, true);
    }
    for (;;)
    {
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
      if ((paramString2 != null) && (!"".equals(paramString2))) {
        kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, paramString2, paramString4, paramString3, AccountDetailActivity.dX(paramString3), false);
      }
      arts.a().a("", "", "", "1000", "103", "0", false);
      return;
      if (!TextUtils.isEmpty(this.b.aHj))
      {
        this.b.bBk();
        continue;
      }
      JSONObject localJSONObject;
      if (this.b.a != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("type", 2);
        label159:
        ubu.b(this.b.a, localJSONObject);
        this.b.a(paramString1, 3, true);
      }
      catch (JSONException localJSONException)
      {
        break label159;
      }
    }
  }
  
  private void Wa(String paramString)
  {
    ((ClipboardManager)this.s.getSystemService("clipboard")).setText(paramString);
    rwt.ez(2, 2131692332);
    if ((this.bfC) && (!TextUtils.isEmpty(this.b.aHg))) {
      this.b.bBg();
    }
  }
  
  private void Wb(String paramString)
  {
    if (!TextUtils.isEmpty(this.b.aHg)) {
      this.b.g(paramString, 8, false);
    }
    for (;;)
    {
      String str = this.mUrl;
      if (this.jdField_a_of_type_Araz$b.getWebView() != null) {
        str = this.jdField_a_of_type_Araz$b.getWebView().getUrl();
      }
      paramString = "";
      Object localObject = Uri.parse(str);
      try
      {
        localObject = ((Uri)localObject).getQueryParameter("article_id");
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      kbp.a(null, "", "0X800787A", "0X800787A", 0, 0, (String)localObject, str, "", "");
      ocp.l(1005, str, this.bQX);
      return;
      this.b.a(paramString, 8, false);
    }
  }
  
  private void Wc(String paramString)
  {
    if (!TextUtils.isEmpty(this.b.aHg)) {
      this.b.g(paramString, 4, true);
    }
    for (;;)
    {
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
      arts.a().a("", "", "", "1000", "104", "0", false);
      return;
      if (!TextUtils.isEmpty(this.b.aHk))
      {
        this.b.bBl();
        continue;
      }
      JSONObject localJSONObject;
      if (this.b.a != null) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("type", 3);
        label120:
        ubu.b(this.b.a, localJSONObject);
        this.b.a(paramString, 4, true);
      }
      catch (JSONException localJSONException)
      {
        break label120;
      }
    }
  }
  
  private void Wd(String paramString)
  {
    if (!TextUtils.isEmpty(this.b.aHg)) {
      this.b.g(paramString, 2, false);
    }
    for (;;)
    {
      arts.a().a("", "", "", "1000", "102", "0", false);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.b.aHi))
      {
        this.b.bBj();
        continue;
      }
      if (this.b.a != null) {
        paramString = new JSONObject();
      }
      try
      {
        paramString.put("type", 1);
        label120:
        ubu.b(this.b.a, paramString);
        this.b.No();
      }
      catch (JSONException localJSONException)
      {
        break label120;
      }
    }
  }
  
  private Intent b()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    return localIntent;
  }
  
  private void cbd()
  {
    if (hF(this.b.getShareUrl())) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "is not need load share js..");
      }
    }
    String str;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "loadShareJs");
      }
      fV(System.currentTimeMillis());
      int j = com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[2].intValue();
      int i = j;
      if (j < 0) {
        i = 190;
      }
      str = String.format("function callShare(){\"loading\"==document.readyState?window.addEventListener(\"load\",sharePageInfo(),!1):sharePageInfo()}var readStyleProp=function(a,b){var c,d;return b?(b=b.toLowerCase(),a.style&&a.style[b]?c=a.style[b]:a.currentStyle?(b=b.replace(/\\-([a-z])([a-z]?)/gi,function(a,b,c){return b.toUpperCase()+c.toLowerCase()}),c=a.currentStyle[b]):document.defaultView&&document.defaultView.getComputedStyle&&(d=document.defaultView.getComputedStyle(a,null),c=d.getPropertyValue(b)),-1!=c.indexOf(\"px\")&&(c=c.replace(/(px)/i,\"\")),c):void 0},parsePageInfo=function(){var b,c,d,e,f,g,h,i,j,k,l,a={};for(a[\"shareURL\"]=document.documentURI,b=\"\",c=\"\",d=document.getElementsByTagName(\"meta\"),f=0;f<d.length;f++)e=d[f],!a.title&&e.getAttribute(\"itemprop\")&&\"name\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"title\"]=e.content),a.summary||\"description\"!=e.name||void 0!=e.content&&\"\"!=e.content&&(b=e.content),!a.summary&&e.getAttribute(\"itemprop\")&&\"description\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(c=e.content),!a.image&&e.getAttribute(\"itemprop\")&&\"image\"==e.getAttribute(\"itemprop\").toLowerCase()&&void 0!=e.content&&\"\"!=e.content&&(a[\"image\"]=e.content);if(\"\"!=c?a[\"summary\"]=c:\"\"!=b&&(a[\"summary\"]=b),!a.image)for(g=document.getElementsByTagName(\"img\"),h=%d,i=%d,f=0;f<g.length&&30>f;f++)if(j=g[f],(j.src.startsWith(\"//\")||j.src.startsWith(\"http://\")||j.src.startsWith(\"https://\"))&&(k=j.width,l=j.height,void 0!=j.naturalWidth&&void 0!=j.naturalHeight&&(k=j.naturalWidth,l=j.naturalHeight),k>=h&&10*h>k&&l>=i&&10*i>l&&\"none\"!=readStyleProp(j,\"display\")&&\"hidden\"!=readStyleProp(j,\"visibility\"))){a[\"image\"]=j.src,a.image.startsWith(\"//\")&&(a.image=(document.documentURI.startsWith(\"http:\")?\"http:\":\"https:\")+a.image);break}return a},sharePageInfo=function(){var a,c,d,e;try{a=parsePageInfo()}catch(b){}a||(a=new object),a[\"type\"]=\"share\",a[\"callback\"]=1,c=JSON.stringify(a),d=\"jsbridge://share/setShare?p=\"+encodeURIComponent(c),e=document.createElement(\"iframe\"),e.style.cssText=\"display:none;width:0px;height:0px;\",(document.documentElement||document.body).appendChild(e),e.src=d};callShare();", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
    } while (this.jdField_a_of_type_Araz$b.getWebView() == null);
    this.jdField_a_of_type_Araz$b.getWebView().loadUrl("javascript:" + str + ";");
  }
  
  private void ed(int paramInt, String paramString)
  {
    aqha.a(this.s, gr(paramInt), 2131692910, 2131721897, new arbw(this, paramInt, paramString), new arbx(this, paramInt, paramString)).show();
  }
  
  private void ee(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      Wa(paramString);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        Wd(paramString);
        return;
      }
      if (paramInt == 10)
      {
        Wc(paramString);
        return;
      }
    } while (paramInt != 12);
    Wb(paramString);
  }
  
  private String gr(int paramInt)
  {
    if (paramInt == 1) {
      return this.c.getString(2131720931, new Object[] { this.c.getString(2131692329) });
    }
    if (paramInt == 3) {
      return this.c.getString(2131720931, new Object[] { this.c.getString(2131720185) });
    }
    if (paramInt == 10) {
      return this.c.getString(2131720931, new Object[] { this.c.getString(2131720180) });
    }
    if (paramInt == 12) {
      return this.c.getString(2131720931, new Object[] { this.c.getString(2131698647) });
    }
    return this.c.getString(2131720931, new Object[] { this.c.getString(2131721555) });
  }
  
  public void CC(int paramInt)
  {
    Object localObject1 = getShareUrl();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mUrl;
    }
    localObject1 = "";
    Object localObject3 = Uri.parse((String)localObject2);
    if ((!"article.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost())) && (!"post.mp.qq.com".equalsIgnoreCase(((Uri)localObject3).getHost()))) {
      return;
    }
    try
    {
      localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1001", "");
      return;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    switch (paramInt)
    {
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      return;
    case 1: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, (String)localObject3, (String)localObject2, "1011", "");
      return;
    case 2: 
    case 3: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1002", "");
      return;
    case 9: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1003", "");
      return;
    case 10: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1004", "");
      return;
    case 5: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1005", "");
      return;
    case 4: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1006", "");
      return;
    case 6: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1007", "");
      return;
    case 11: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1008", "");
      return;
    case 8: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1009", "");
      return;
    case 7: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1010", "");
      return;
    case 12: 
      anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1012", "");
      return;
    }
    anot.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8007C04", "0X8007C04", 0, 1, 0, localException, (String)localObject2, "1013", "");
  }
  
  @TargetApi(14)
  public void CD(int paramInt)
  {
    if ((this.jdField_a_of_type_Araz$b.getWebView() == null) || (this.isDestroyed)) {}
    int i;
    do
    {
      return;
      this.aXQ = paramInt;
      i = hq[paramInt];
      this.jdField_a_of_type_Araz$b.getWebView().getSettings().setTextZoom(i);
    } while (this.b == null);
    this.b.eK(paramInt, i);
  }
  
  public void P(int paramInt, Bundle paramBundle)
  {
    super.P(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.isDestroyed = true;
        if (this.jdField_a_of_type_Ncy != null) {
          this.jdField_a_of_type_Ncy.onDestroy();
        }
        if (this.mClient != null) {
          this.mClient.bzk();
        }
        this.qo.clear();
        return;
      } while ((paramBundle == null) || (paramBundle.getInt("state_machine_step", -1) != 1));
      ehb();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.onConfigurationChanged();
      }
    } while ((this.jdField_a_of_type_Ncy == null) || (!this.jdField_a_of_type_Ncy.isShowing()));
    this.jdField_a_of_type_Ncy.dismiss();
    cbe();
  }
  
  public void Tr(boolean paramBoolean)
  {
    this.bfB = paramBoolean;
  }
  
  public void Ts(boolean paramBoolean)
  {
    this.cXE = paramBoolean;
  }
  
  public void Tt(boolean paramBoolean)
  {
    this.bfC = paramBoolean;
  }
  
  public void Tu(boolean paramBoolean)
  {
    this.cXF = paramBoolean;
  }
  
  public void VY(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public void a(arbt.a parama)
  {
    this.jdField_a_of_type_Arbt$a = parama;
  }
  
  public void a(svi paramsvi, long paramLong)
  {
    if (paramsvi == null) {}
    label296:
    do
    {
      for (;;)
      {
        return;
        if ((this.s != null) && (!this.s.isFinishing()))
        {
          Object localObject1 = this.mUrl;
          if (this.c != null) {
            localObject1 = this.c.mRedirect302Url;
          }
          ocp.pk((String)localObject1);
          this.b = paramsvi;
          this.gK = paramLong;
          initParam();
          cbd();
          aGf();
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.s, false, 2);
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setIntentForStartForwardRecentActivity(b());
          }
          paramsvi = null;
          localObject1 = (arbo)this.jdField_a_of_type_Araz$b.c().q(64);
          if (localObject1 != null) {
            paramsvi = ((arbo)localObject1).kH();
          }
          localObject1 = (arbz)this.jdField_a_of_type_Araz$b.c().q(-2);
          if ((this.c != null) && (localObject1 != null))
          {
            if (((arbz)localObject1).cXS)
            {
              paramsvi = "<font color='#777777'>应用由 </font><font color='#00a5e0'>" + this.c.cyP + "</font><font color='#777777'> 提供</font>";
              this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(Html.fromHtml(paramsvi));
              anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "exp_menu", 0, 1, 0, "" + this.c.edX, "" + this.c.appId, "", "");
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListenerV2(this);
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(this);
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
            Object localObject2;
            if ((this.c != null) && (this.c.uinType == 1008))
            {
              paramsvi = getShareUrl();
              localObject1 = paramsvi;
              if (paramsvi == null) {
                localObject1 = this.c.mUrl;
              }
              if (!TextUtils.isEmpty(this.c.awT))
              {
                paramsvi = "";
                localObject2 = Uri.parse((String)localObject1);
              }
            }
            else
            {
              try
              {
                localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
                paramsvi = (svi)localObject2;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                }
              }
              localObject2 = paramsvi;
              if (paramsvi == null) {
                localObject2 = "";
              }
              kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005F78", "0X8005F78", 0, 0, this.c.awT, (String)localObject1, this.c.msgid, (String)localObject2, false);
              if (this.bfE)
              {
                kbp.a(null, "", "0X8008CAA", "0X8008CAA", 0, 0, "", "", "", "", false);
                return;
                if (!TextUtils.isEmpty(paramsvi))
                {
                  this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(paramsvi);
                  break label296;
                }
                this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131720136));
              }
            }
          }
          catch (Exception paramsvi)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramsvi);
              }
            }
          }
        }
      }
    } while (!this.bfD);
    kbp.a(null, "", "0X8008CAB", "0X8008CAB", 0, 0, "", "", "", "", false);
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (arbz)this.jdField_a_of_type_Araz$b.c().q(-2);
    if ((this.c != null) && (localObject1 != null) && (((arbz)localObject1).cXS))
    {
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(15));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(16));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(17));
      localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(18));
      return (List[])new ArrayList[] { localArrayList1 };
    }
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (this.cXE) && (!obw.a(this.qo, "menuItem:share:diandian")) && (!TextUtils.isEmpty(this.b.aHg))) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(34));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:qq")) && ((this.gK & 0x8) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:QZone")) && ((this.gK & 0x10) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
      }
      if (((this.gK & 0x8000000) != 0L) && (awit.aMA()) && (!obw.a(this.qo, "menuItem:share:kandian")) && (localObject1 != null))
      {
        localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
        if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false))) {
          localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(13));
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:appMessage")) && ((this.gK & 0x4000) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:timeline")) && ((this.gK & 0x8000) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
      }
      if ((this.bfB) && (!obw.a(this.qo, "menuItem:share:sinaWeibo"))) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(12));
      }
      if ((!obw.a(this.qo, "menuItem:openWithQQBrowser")) && ((this.gK & 0x200) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(5));
      }
      if ((!obw.a(this.qo, "menuItem:openWithSafari")) && ((this.gK & 0x100) == 0L)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(4));
      }
      Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
      if ((!obw.a(this.qo, "menuItem:share:qiDian")) && ((this.gK & 0x10) == 0L)) {
        asgx.g(this.s, localArrayList1);
      }
      if ((!obw.a(this.qo, "menuItem:share:qiYeQQ")) && ((this.gK & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null)) {
        localArrayList1.add(ShareActionSheetBuilder.ActionSheetItem.build(20));
      }
      ArrayList localArrayList2 = new ArrayList();
      Object localObject3;
      int i;
      if (this.cXG)
      {
        localObject3 = (QQBrowserActivity)this.s;
        localObject2 = ((QQBrowserActivity)localObject3).getOriginalUrl();
        localObject3 = ((QQBrowserActivity)localObject3).getColorNoteController();
        if ((localObject3 != null) && (((aeay)localObject3).shouldDisplayColorNote()) && (((aeay)localObject3).agi()) && (!aebs.lt((String)localObject2)))
        {
          boolean bool = ((aeay)localObject3).isColorNoteExist();
          localObject3 = ShareActionSheetBuilder.ActionSheetItem.build(70);
          localObject2 = BaseApplicationImpl.getApplication();
          if (bool) {
            break label983;
          }
          i = 2131720076;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).label = ((BaseApplicationImpl)localObject2).getString(i);
          if (bool) {
            break label990;
          }
          i = 2130847157;
          label816:
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = i;
          if (auvj.isNightMode())
          {
            if (bool) {
              break label997;
            }
            i = 2130847158;
            label836:
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = i;
          }
          if (bool) {
            break label1004;
          }
          localObject2 = "colornote";
          label851:
          ((ShareActionSheetBuilder.ActionSheetItem)localObject3).reportID = ((String)localObject2);
          localArrayList2.add(localObject3);
        }
      }
      label889:
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.bfD) && (this.qp != null))
      {
        localObject2 = this.qp.iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1039;
          }
          localObject3 = (PublicAccountJavascriptInterface.a)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(30);
          switch (((PublicAccountJavascriptInterface.a)localObject3).itemType)
          {
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.a)localObject3).itemName)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131697409);; localActionSheetItem.label = ((PublicAccountJavascriptInterface.a)localObject3).itemName)
            {
              localArrayList2.add(localActionSheetItem);
              break label889;
              i = 2131691721;
              break;
              i = 2130847166;
              break label816;
              i = 2130847167;
              break label836;
              localObject2 = "colornote_cancel";
              break label851;
            }
          case 2: 
            label983:
            label990:
            label997:
            label1004:
            localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(31));
          }
        }
      }
      label1039:
      if ((this.bfE) && (this.qp != null))
      {
        localObject2 = this.qp.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (PublicAccountJavascriptInterface.a)((Iterator)localObject2).next();
          localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(37);
          switch (((PublicAccountJavascriptInterface.a)localObject3).itemType)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.a)localObject3).itemName)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131697409);; localActionSheetItem.label = ((PublicAccountJavascriptInterface.a)localObject3).itemName)
            {
              localArrayList2.add(localActionSheetItem);
              break;
            }
          case 3: 
            localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(35));
          }
        }
      }
      localObject2 = (arbo)this.jdField_a_of_type_Araz$b.c().q(64);
      if ((localObject2 != null) && (((arbo)localObject2).aGe()) && (!obw.a(this.qo, "menuItem:screenShotShare"))) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(21));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:favorite")) && ((this.gK & 0x2000) == 0L)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(6));
      }
      if (this.cXI) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(129));
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:exportTencentDocs")) && ((((arcd)this.jdField_a_of_type_Araz$b.c().q(2)).a.Ds & 0x4000) == 0L))
      {
        localObject2 = getShareUrl();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.mUrl;
        }
        if (aoag.pL((String)localObject1))
        {
          localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(68));
          aoag.jI(0, 1);
        }
      }
      if ((!obw.a(this.qo, "menuItem:setFont")) && (!this.bfA) && (this.bfy)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(7));
      }
      if ((!obw.a(this.qo, "menuItem:copyUrl")) && ((this.gK & 0x20) == 0L)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(1));
      }
      if (((TextUtils.isEmpty(this.mUrl)) || (!"docs.qq.com".equals(Uri.parse(this.mUrl).getHost()))) && (!obw.a(this.qo, "menuItem:screenLongShotShare")) && ((this.gK & 0x8000) == 0L) && (this.jdField_a_of_type_Araz$b != null) && (this.jdField_a_of_type_Araz$b.getWebView() != null) && (this.jdField_a_of_type_Araz$b.getWebView().getX5WebViewExtension() != null)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(71));
      }
      if ((!obw.a(this.qo, "menuItem:exposeArticle")) && (this.bfz)) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
      }
      return (List[])new ArrayList[] { localArrayList1, localArrayList2 };
    }
  }
  
  public boolean aGf()
  {
    this.bfy = false;
    if (((arcd)this.jdField_a_of_type_Araz$b.c().q(2)).a.cYo) {
      return false;
    }
    if (this.jdField_a_of_type_Araz$b.getWebView() != null)
    {
      this.jdField_a_of_type_Araz$b.getWebView();
      int i = WebView.getTbsCoreVersion(BaseApplicationImpl.getContext());
      if ((i > 0) && (i < 36201))
      {
        this.bfy = false;
        return this.bfy;
      }
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      this.bfy = bool;
      return this.bfy;
    }
  }
  
  public boolean aGg()
  {
    return this.bfB;
  }
  
  public boolean aGh()
  {
    return this.cXE;
  }
  
  public boolean aGi()
  {
    return this.cXF;
  }
  
  public void ah(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      ocp.l(1001, paramString3, this.bQX);
      if (!TextUtils.isEmpty(this.b.aHg)) {
        this.b.g(paramString1, 1, false);
      }
      for (;;)
      {
        arts.a().a("", "", "", "1000", "101", "0", false);
        anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_38", "qq_share", 0, 1, 0, "", "", "", "");
        return;
        if (!TextUtils.isEmpty(this.b.aHh))
        {
          this.b.bBi();
        }
        else
        {
          if (this.b.a != null) {
            paramString2 = new JSONObject();
          }
          try
          {
            paramString2.put("type", 0);
            label138:
            ubu.b(this.b.a, paramString2);
            this.b.a(paramString1, 1, false);
          }
          catch (JSONException paramString3)
          {
            break label138;
          }
        }
      }
      paramString3 = paramString2;
    }
  }
  
  public skj b()
  {
    if (this.mClient == null)
    {
      this.mClient = skj.a();
      this.mClient.bzj();
    }
    return this.mClient;
  }
  
  @TargetApi(12)
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    String str6 = "";
    String str5 = "";
    String str4 = "";
    String str3 = "";
    String str2 = "";
    int j = 0;
    int i = 0;
    String str7 = "";
    if (paramBundle != null)
    {
      str6 = paramBundle.getString("qq", "");
      str5 = paramBundle.getString("public_uin", "");
      str4 = paramBundle.getString("source_public_uin", "");
      str3 = paramBundle.getString("default_url", "");
      str2 = paramBundle.getString("msg_id", "");
      j = paramBundle.getInt("troop_app_id", 0);
      i = paramBundle.getInt("troop_id", 0);
      str7 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
      this.ba = paramBundle;
    }
    Object localObject1 = this.mUrl;
    Object localObject2;
    Object localObject3;
    if (this.c != null)
    {
      localObject2 = this.c.mRedirect302Url;
      localObject3 = this.c.getWebView();
      localObject1 = localObject2;
      if (localObject3 == null) {}
    }
    for (localObject1 = ((WebView)localObject3).getOriginalUrl();; localObject1 = null)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(paramString))) {}
      for (;;)
      {
        try
        {
          localObject3 = Uri.parse((String)localObject1);
          String str9 = ((Uri)localObject3).getHost();
          String str8 = null;
          if (((Uri)localObject3).isHierarchical()) {
            str8 = ((Uri)localObject3).getQueryParameter("_pflag");
          }
          localObject3 = paramString;
          if (!TextUtils.isEmpty(str8)) {
            if (!"post.mp.qq.com".equalsIgnoreCase(str9))
            {
              localObject3 = paramString;
              if (!"url.cn".equalsIgnoreCase(str9)) {}
            }
            else
            {
              int k = Integer.parseInt(str8);
              localObject3 = paramString;
              if ((k >> 3 & 0x1) == 1) {
                localObject3 = localObject1;
              }
            }
          }
          paramString = (String)localObject3;
        }
        catch (Exception localException)
        {
          continue;
          Wa(paramString);
          continue;
          if (paramInt != 11) {
            continue;
          }
          paramBundle = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(paramString);
          i = 0;
          if (!paramBundle.matches()) {
            continue;
          }
          i = 1;
          try
          {
            paramString = URLEncoder.encode(paramString, "UTF-8");
            if (i != 0)
            {
              localObject2 = String.valueOf(NetConnInfoCenter.getServerTime());
              localObject1 = arwv.encodeHexStr(paramString + 200 + (String)localObject2 + "jubao@article@123");
              paramBundle = (Bundle)localObject1;
              if (localObject1 != null)
              {
                paramBundle = (Bundle)localObject1;
                if (!((String)localObject1).isEmpty()) {
                  paramBundle = ((String)localObject1).toLowerCase();
                }
              }
              paramString = "https://post.mp.qq.com/jubao/index?qq=" + str6 + "&mp_uin=" + str5 + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject2 + "&sign=" + paramBundle + "&article_url=" + paramString + "&_wv=3";
              paramBundle = new Intent(this.s, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_more_button", true);
              this.s.startActivity(paramBundle);
              anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
              if ((str4 == null) || ("".equals(str4))) {
                continue;
              }
              kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str4, str2, str3, AccountDetailActivity.dX(str3), false);
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
            }
            paramString = null;
            continue;
            paramString = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str6 + "&_wv=7";
            continue;
          }
          if ((paramInt != 2) && (paramInt != 72) && (paramInt != 73)) {
            continue;
          }
          if (this.jdField_a_of_type_Arbt$a == null) {
            continue;
          }
          this.jdField_a_of_type_Arbt$a.GN(paramString);
          continue;
          if (this.c != null) {
            continue;
          }
          throw new InvalidParameterException("ACTION_REFRESH_FREIEND_VIEW should be handled by QQBrowserActivity!");
          paramBundle = (arbz)this.jdField_a_of_type_Araz$b.c().q(-2);
          if ((TextUtils.isEmpty(this.c.j.getUrl())) || (paramBundle == null)) {
            continue;
          }
          String str1 = this.c.j.getUrl();
          if ((TextUtils.isEmpty(paramBundle.czp)) || ((!paramBundle.czp.equals(str1)) && (!paramBundle.czp.equals(paramString)))) {
            continue;
          }
          boolean bool = true;
          this.b.aNu = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SwiftBrowserShareMenuHandler", 2, new Object[] { "ShareArkFromH5 mShare.isShareArk=", Boolean.valueOf(this.b.aNu), ",\n shareUrl=", jqo.filterKeyForLog(paramString, new String[0]) });
          ah(paramString, (String)localObject2, (String)localObject1);
          continue;
          if (paramInt != 4) {
            continue;
          }
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramBundle = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
          paramBundle.putExtra("normal", true);
          paramBundle.putExtra("big_brother_source_key", "biz_src_jc_ac");
          localObject1 = new WeakReference(this.s);
          try
          {
            JefsClass.getInstance().a(this.s, paramBundle, paramString, new SwiftBrowserShareMenuHandler.1(this, (WeakReference)localObject1, paramBundle));
            anot.a(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, jqo.filterKeyForLog(str3, new String[0]), null, null, null);
            anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
            if ((str4 == null) || ("".equals(str4))) {
              continue;
            }
            kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str4, str2, str3, AccountDetailActivity.dX(str3), false);
          }
          catch (Throwable paramString)
          {
            QLog.e("SwiftBrowserShareMenuHandler", 1, paramString, new Object[0]);
            continue;
          }
          if (paramInt != 5) {
            continue;
          }
          if ((this.c == null) || (this.s == null)) {
            continue;
          }
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramBundle = new HashMap();
          paramBundle.put("KEY_PID", String.valueOf(50079));
          paramBundle.put("KEY_EUSESTAT", String.valueOf(5));
          paramBundle.put("ChannelID", BaseApplicationImpl.getContext().getApplicationInfo().processName);
          paramBundle.put("PosID", Integer.toString(0));
          paramString = MttLoader.getValidQBUrl(BaseApplicationImpl.getContext(), paramString);
          i = MttLoader.loadUrl(BaseApplicationImpl.getContext(), paramString, paramBundle, null);
          if ((4 != i) && (5 != i) && (i == 0)) {
            continue;
          }
          paramString = new Intent(this.s, QQBrowserActivity.class);
          paramString.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
          paramString.putExtra("big_brother_source_key", "biz_src_WEBVIEW");
          this.s.startActivity(paramString);
          anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_46", "qqbrowser_share", 0, 1, 0, "", "", "", "");
          anot.a(null, "P_CliOper", "VIPCOMIC", "", "0X80061A0", "0X80061A0", 1000, 0, jqo.filterKeyForLog(str3, new String[0]), null, null, null);
          if ((str4 == null) || ("".equals(str4))) {
            continue;
          }
          kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1005, 0, str4, str2, str3, AccountDetailActivity.dX(str3), false);
          continue;
          throw new InvalidParameterException("ACTION_OPEN_IN_QQ_BROWSER should be handled by QQBrowserActivity!");
          if (paramInt != 3) {
            continue;
          }
          In = System.currentTimeMillis();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          ocp.l(1002, (String)localObject1, this.bQX);
          if ((this.b.a() == null) || (this.b.a().policy != 0)) {
            continue;
          }
          ed(paramInt, paramString);
          continue;
          Wd(paramString);
          continue;
          if (paramInt != 6) {
            continue;
          }
          if (!this.b.bw(paramString)) {
            continue;
          }
          this.b.a(paramString, 9, false);
          if ((str4 == null) || ("".equals(str4))) {
            continue;
          }
          kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str4, str2, str3, AccountDetailActivity.dX(str3), false);
          continue;
          if (paramInt != 129) {
            continue;
          }
          avja.a(this.s, this.c.mApp.getCurrentAccountUin(), this.bS, this.yF);
          continue;
          if ((paramInt != 9) && (paramInt != 10)) {
            continue;
          }
          i = -1;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          if (paramInt != 9) {
            continue;
          }
          ocp.l(1003, (String)localObject1, this.bQX);
          if (WXShareHelper.a().isWXinstalled()) {
            continue;
          }
          i = 2131721935;
          if (i == -1) {
            continue;
          }
          rwt.ez(0, i);
          continue;
          ocp.l(1004, (String)localObject1, this.bQX);
          continue;
          if (WXShareHelper.a().isWXsupportApi()) {
            continue;
          }
          i = 2131721936;
          continue;
          if (paramInt != 9) {
            continue;
          }
          if (this.b.a() == null) {
            continue;
          }
          this.b.b().show();
          ThreadManager.excute(new SwiftBrowserShareMenuHandler.2(this, paramString, str4, str3, str2), 128, null, false);
          continue;
          T(paramString, str4, str3, str2);
          continue;
          if ((this.b.a() == null) || (this.b.a().policy != 0)) {
            continue;
          }
          ed(paramInt, paramString);
          continue;
          Wc(paramString);
          continue;
          if (paramInt != 13) {
            continue;
          }
          this.b.a(paramString, 5, true);
          continue;
          if (paramInt != 15) {
            continue;
          }
          if (this.c != null) {
            continue;
          }
          throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
          if (aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
            continue;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 2, 2131721287, 0).show(this.c.getTitleBarHeight());
          return;
          b().a(j, new arbu(this));
          anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + i, "" + j, "", "");
          continue;
          if (paramInt != 16) {
            continue;
          }
          paramString = new Intent(this.s, QQBrowserActivity.class);
          paramString.putExtra("url", str7);
          paramString.putExtra("hide_operation_bar", true);
          paramString.putExtra("hide_more_button", true);
          this.s.startActivity(paramString);
          anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + i, "" + j, "", "");
          continue;
          if (paramInt != 17) {
            continue;
          }
          paramString = "";
          if (paramBundle == null) {
            continue;
          }
          paramString = paramBundle.getString("troop_app_share_url", "");
          paramBundle = new Intent(this.s, QQBrowserActivity.class);
          paramBundle.putExtra("url", paramString);
          paramBundle.putExtra("hide_operation_bar", true);
          paramBundle.putExtra("hide_more_button", true);
          this.s.startActivity(paramBundle);
          anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + i, "" + j, "", "");
          continue;
          if (paramInt != 18) {
            continue;
          }
          if (this.c != null) {
            continue;
          }
          throw new InvalidParameterException("ACTION_REFRESH_TROOP_APP_VIEW should be handled by QQBrowserActivity!");
          paramString = (arbz)this.jdField_a_of_type_Araz$b.c().q(-2);
          if ((TextUtils.isEmpty(this.c.j.getUrl())) || (paramString == null)) {
            continue;
          }
          this.c.jdField_a_of_type_Arbz.mPerfFirstLoadTag = false;
          paramString.mTimeBeforeLoadUrl = System.currentTimeMillis();
          this.c.j.reload();
          this.c.j.setOnCustomScrollChangeListener(null);
          paramString.a(this.c.j, this.c.j.getUrl(), 1, 0, 0, 0, 0, null);
          anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "refresh_menu", 0, 1, 0, "" + i, "" + j, "", "");
          continue;
          paramBundle = this.c.getCurrentUrl();
          if ((TextUtils.isEmpty(paramBundle)) || (paramString == null)) {
            continue;
          }
          this.c.jdField_a_of_type_Arbz.mPerfFirstLoadTag = false;
          paramString.mTimeBeforeLoadUrl = System.currentTimeMillis();
          this.c.j.loadUrl(paramBundle);
          paramString.a(this.c.j, paramBundle, 1, 0, 0, 0, 0, null);
          continue;
          if (paramInt != 7) {
            continue;
          }
          cbe();
          continue;
          if ((paramInt != 19) && (paramInt != 20)) {
            continue;
          }
          if (paramInt != 19) {
            continue;
          }
          i = 6;
          if (TextUtils.isEmpty(this.b.aHg)) {
            continue;
          }
          this.b.g(paramString, i, false);
          continue;
          i = 7;
          continue;
          this.b.a(paramString, i, true);
          continue;
          if (paramInt != 21) {
            continue;
          }
          paramString = (arbo)this.jdField_a_of_type_Araz$b.c().q(64);
          if (paramString == null) {
            continue;
          }
          paramString.a(null, null, 2);
          paramString = "";
          paramBundle = Uri.parse(this.mUrl);
          try
          {
            paramBundle = paramBundle.getQueryParameter("article_id");
            paramString = paramBundle;
          }
          catch (Exception paramBundle)
          {
            paramBundle.printStackTrace();
            continue;
          }
          paramBundle = paramString;
          if (paramString != null) {
            continue;
          }
          paramBundle = "";
          kbp.a(null, "", "0X8007071", "0X8007071", 0, 0, paramBundle, "", "", "");
          kbp.d("0X8007071", "", paramBundle, "", "", "");
          continue;
          if (paramInt != 12) {
            continue;
          }
          if ((this.b.a() == null) || (this.b.a().policy != 0)) {
            continue;
          }
          ed(paramInt, paramString);
          continue;
          Wb(paramString);
          continue;
          if (paramInt != 34) {
            continue;
          }
          if (TextUtils.isEmpty(this.b.aHg)) {
            continue;
          }
          this.b.bBf();
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("diandian", 2, "dian dian is here");
          continue;
          if (paramInt != 35) {
            continue;
          }
          long l2 = 0L;
          paramBundle = null;
          long l1 = l2;
          paramString = paramBundle;
          if (this.qp == null) {
            continue;
          }
          localObject1 = this.qp.iterator();
          l1 = l2;
          paramString = paramBundle;
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          paramString = (PublicAccountJavascriptInterface.a)((Iterator)localObject1).next();
          if (paramString.itemType != 3) {
            continue;
          }
          try
          {
            paramString = new JSONObject(paramString.VH);
            l1 = paramString.getLong("uin");
            paramString = paramString.optString("name");
            paramString = AddFriendLogicActivity.a(this.s, 1, l1 + "", null, 3096, 1, paramString, null, null, null, null);
            this.s.startActivity(paramString);
            kbp.a(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (paramInt != 30) {
            continue;
          }
          if ((this.qp == null) || (!this.bfD)) {
            continue;
          }
          paramString = this.qp.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          paramBundle = (PublicAccountJavascriptInterface.a)paramString.next();
          if (paramBundle.itemType != 1) {
            continue;
          }
          try
          {
            l1 = new JSONObject(paramBundle.VH).getLong("uin");
            paramString = new Intent();
            paramBundle = new Bundle();
            paramString.setComponent(new ComponentName(this.s, ChatActivity.class));
            paramBundle.putString("uin", String.valueOf(l1));
            paramBundle.putInt("uintype", 1008);
            paramString.putExtras(paramBundle);
            paramString.putExtra("is_come_from_readinjoy", true);
            paramString.setFlags(67108864);
            this.s.startActivity(paramString);
            kbp.a(null, "", "0X8008C3B", "0X8008C3B", 0, 0, "", "", "", "", false);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if ((paramInt != 37) || (!this.bfE)) {
            continue;
          }
          if (this.qp == null) {
            continue;
          }
          paramString = this.qp.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          paramBundle = (PublicAccountJavascriptInterface.a)paramString.next();
          if (paramBundle.itemType != 1) {
            continue;
          }
          try
          {
            l1 = new JSONObject(paramBundle.VH).getLong("uin");
            paramString = wja.a(new Intent(this.s, SplashActivity.class), null);
            paramString.putExtra("uin", l1 + "");
            paramString.putExtra("uintype", 0);
            this.s.startActivity(paramString);
            kbp.a(null, "", "0X8008C11", "0X8008C11", 0, 0, "", "", "", "", false);
            return;
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (paramInt != 31) {
            continue;
          }
          if (this.qp == null) {
            continue;
          }
          paramString = this.qp.iterator();
          if (!paramString.hasNext()) {
            continue;
          }
          paramBundle = (PublicAccountJavascriptInterface.a)paramString.next();
          if (paramBundle.itemType != 2) {
            continue;
          }
          try
          {
            l1 = new JSONObject(paramBundle.VH).getLong("puin");
            paramString = new Intent(this.s, AccountDetailActivity.class);
            paramString.putExtra("uin", l1 + "");
            paramString.putExtra("from_js", true);
            this.s.startActivity(paramString);
            kbp.a(null, "", "0X8008C47", "0X8008C47", 0, 0, "", "", "", "", false);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            return;
          }
          if (paramInt != 38) {
            continue;
          }
          this.b.bBh();
          continue;
          if (paramInt != 68) {
            continue;
          }
          if (!(this.s instanceof PublicAccountBrowser)) {
            continue;
          }
          i = 0;
          aoag.jI(1, i);
          paramBundle = getShareUrl();
          paramString = paramBundle;
          if (paramBundle != null) {
            continue;
          }
          paramString = this.mUrl;
          if (this.b != null) {
            continue;
          }
          paramBundle = "";
          aoag.bJ(paramString, paramBundle);
          continue;
          i = 1;
          continue;
          paramBundle = this.b.getShareTitle();
          continue;
          if (paramInt != 70) {
            continue;
          }
          paramString = ((QQBrowserActivity)this.s).getColorNoteController();
          if (paramString == null) {
            continue;
          }
          if (paramString.isColorNoteExist()) {
            continue;
          }
          if (!paramString.canAddColorNote()) {
            continue;
          }
          paramString.insertColorNote();
          this.s.finish();
          continue;
          paramString.onCannotAdd();
          continue;
          paramString.deleteColorNote();
          continue;
          if (paramInt != 71) {
            continue;
          }
          anot.a(null, "dc00898", "", "", "0X800A9A4", "0X800A9A4", 0, 0, "1", "", "", "");
          aqez.a(this.jdField_a_of_type_Araz$b.getWebView(), new arbv(this));
          continue;
          l1 = 0L;
          continue;
          l1 = 0L;
          continue;
          l1 = 0L;
          continue;
          localObject1 = localObject2;
          continue;
          localObject1 = localObject2;
          continue;
          bool = false;
          continue;
        }
        if (paramInt == 1) {
          if ((this.b.a() != null) && (this.b.a().policy == 0))
          {
            ed(paramInt, paramString);
            CC(paramInt);
            return;
          }
        }
      }
      localObject2 = localObject1;
    }
  }
  
  public void cbe()
  {
    this.jdField_a_of_type_Ncy = new ncy.a(this.s.getLayoutInflater()).a(this).a(this.aXQ).a().a(this.jdField_a_of_type_Araz$b.getWebView());
  }
  
  public void d(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    String str = getShareUrl();
    Bundle localBundle = new Bundle();
    if (this.c != null)
    {
      localBundle.putString("qq", this.c.uin);
      localBundle.putString("public_uin", this.c.awT);
      localBundle.putString("source_public_uin", this.c.aTX);
      localBundle.putString("default_url", this.c.mUrl);
      localBundle.putString("msg_id", this.c.msgid);
      localBundle.putString("troop_app_info_url", this.c.cyR);
      localBundle.putString("troop_app_share_url", this.c.cyQ);
      localBundle.putInt("troop_id", this.c.edX);
      localBundle.putInt("troop_app_id", this.c.appId);
      localBundle.putInt("uin_type", this.c.uinType);
    }
    if ((paramInt == 72) && (paramActionSheetItem != null))
    {
      localBundle.putString("to_qq", paramActionSheetItem.uin);
      localBundle.putString("to_uin_name", paramActionSheetItem.label);
      localBundle.putInt("to_uin_type", paramActionSheetItem.uinType);
    }
    c(paramInt, str, localBundle);
  }
  
  public void dy(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    CD(paramInt2);
    b().yB(this.aXQ);
  }
  
  public void egS()
  {
    super.egS();
    this.isDestroyed = false;
    this.s = this.jdField_a_of_type_Araz$b.getActivity();
    this.c = this.jdField_a_of_type_Araz$b.b();
    initParam();
  }
  
  public void ehb()
  {
    if (aGf())
    {
      b().i(new arby(this));
      return;
    }
    CD(1);
  }
  
  public void fV(long paramLong)
  {
    ((arbz)this.jdField_a_of_type_Araz$b.c().q(-2)).aup = paramLong;
  }
  
  public String getShareUrl()
  {
    if (this.b == null) {
      return "";
    }
    return this.b.getShareUrl();
  }
  
  public boolean hF(String paramString)
  {
    boolean bool2 = false;
    String str = this.b.getShareUrl();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.b.getShareTitle()))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.b.nr()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          bool1 = bool2;
          if (str.equals(jqo.a(paramString, new String[0]))) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void initParam()
  {
    Object localObject = this.s.getIntent();
    if (this.c != null) {
      localObject = this.c.getIntent();
    }
    this.mUrl = ((Intent)localObject).getStringExtra("url");
    if (this.mUrl == null)
    {
      this.mUrl = ((Intent)localObject).getStringExtra("key_params_qq");
      if (this.mUrl == null) {
        this.mUrl = "";
      }
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject != null)
    {
      this.uinType = ((Bundle)localObject).getInt("uin_type");
      this.awT = ((Bundle)localObject).getString("puin");
      this.msgid = ((Bundle)localObject).getString("msg_id");
      if (this.msgid == null) {
        this.msgid = "";
      }
      this.aTX = ((Bundle)localObject).getString("source_puin");
      if (this.aTX == null) {
        this.aTX = "";
      }
      this.toUin = ((Bundle)localObject).getString("friendUin");
      if (this.toUin == null) {
        this.toUin = "";
      }
      ((Bundle)localObject).getBoolean("isOpeningQunApp");
      this.appId = ((Bundle)localObject).getInt("appid");
      this.edX = ((Bundle)localObject).getInt("troopid");
      if (((Bundle)localObject).getString("extraParams") == null) {}
      this.cXI = ((Bundle)localObject).getBoolean("fromFav");
      if (this.cXI)
      {
        this.bS = ((Bundle)localObject).getLong("favID");
        this.yF = ((Bundle)localObject).getLong("favGroupID");
      }
      this.bQX = ((Bundle)localObject).getInt("articalChannelId", 100);
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (((this.gK & 0x20000) != 0L) && (this.c != null)) {
      this.c.egN();
    }
    if ((this.c != null) && (this.c.jdField_a_of_type_Arcd != null) && ((this.c.getHostActivity() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.c.mUrl)) && (this.c.mUrl.contains("sheet"))) {
      this.c.jdField_a_of_type_Arcd.ehn();
    }
    try
    {
      if ((this.b != null) && (this.b.b() != null)) {
        this.b.b().dismiss();
      }
      if ((this.ba != null) && (QLog.isColorLevel())) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onDismiss() called don't clear mExtraParams for time sequence problems");
      }
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("SwiftBrowserShareMenuHandler", 1, paramDialogInterface, new Object[0]);
      }
    }
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    d(paramActionSheetItem.action, paramActionSheetItem);
  }
  
  public Bundle u()
  {
    return this.ba;
  }
  
  public static abstract interface a
  {
    public abstract void GN(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */