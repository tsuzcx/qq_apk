import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.a;
import com.tencent.widget.RangeButtonView.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class wqw
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener, RangeButtonView.a
{
  public static long In = -1L;
  public static final int[] hq = { 95, 100, 107, 115, 127 };
  public ShareActionSheetBuilder a;
  private wqw.a a;
  public String aTX = "";
  public int aXQ = 1;
  public String awT = "";
  public svi b;
  private int bQX;
  public boolean bfA;
  private boolean bfB;
  private boolean bfC;
  public boolean bfD;
  public boolean bfE;
  public boolean bfy;
  public boolean bfz;
  public WebViewFragment c;
  private String currentUrl = "";
  public PopupWindow f;
  public long gK = 4L;
  boolean isDestroyed = false;
  skj mClient = null;
  private String mUrl;
  private WebView mWebView;
  public String msgid = "";
  public final ArrayList<String> qo = new ArrayList();
  public ArrayList<PublicAccountJavascriptInterface.a> qp;
  public Activity s;
  public String toUin = "";
  
  public wqw(Activity paramActivity, WebView paramWebView)
  {
    this.s = paramActivity;
    this.mWebView = paramWebView;
    initParam();
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
    } while (this.mWebView == null);
    this.mWebView.loadUrl("javascript:" + str + ";");
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
    if ((this.mWebView == null) || (this.isDestroyed)) {
      return;
    }
    this.aXQ = paramInt;
    paramInt = hq[paramInt];
    this.mWebView.getSettings().setTextZoom(paramInt);
  }
  
  public void a(svi paramsvi)
  {
    if (paramsvi == null) {}
    do
    {
      do
      {
        return;
      } while ((this.s == null) || (this.s.isFinishing()));
      String str = this.mUrl;
      if (this.c != null) {
        str = this.c.mRedirect302Url;
      }
      ocp.pk(str);
      this.b = paramsvi;
      this.gK = this.jdField_a_of_type_Wqw$a.gK;
      initParam();
      cbd();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.s);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(BaseApplicationImpl.getApplication().getString(2131720177));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setOnDismissListener(this);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
      catch (Exception paramsvi) {}
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserShareMenuHandler", 2, "actionSheet.show exception=" + paramsvi);
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.getApplication().getRuntime() != null) {}
    for (Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:qq")) && ((this.gK & 0x8) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698630);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839252;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 2;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:QZone")) && ((this.gK & 0x10) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698643);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839253;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 3;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      if (((this.gK & 0x8000000) != 0L) && (awit.aMA()) && (!obw.a(this.qo, "menuItem:share:kandian")) && (localObject1 != null))
      {
        localObject2 = "readinjoy_" + ((AppRuntime)localObject1).getAccount() + "_" + 1;
        localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject2, 4);
        if ((localObject2 != null) && (((SharedPreferences)localObject2).getBoolean("share_to_news", false)))
        {
          localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698644);
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839250;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 13;
          ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
          localArrayList.add(localObject2);
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:appMessage")) && ((this.gK & 0x4000) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698652);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839256;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 9;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:share:timeline")) && ((this.gK & 0x8000) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698633);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839249;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 10;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      if ((this.bfB) && (!obw.a(this.qo, "menuItem:share:sinaWeibo")))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698647);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130839255;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 12;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      if ((!obw.a(this.qo, "menuItem:openWithQQBrowser")) && ((this.gK & 0x200) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698626);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843493;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 5;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      if ((!obw.a(this.qo, "menuItem:openWithSafari")) && ((this.gK & 0x100) == 0L))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698627);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130843489;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 4;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      Object localObject2 = BaseApplicationImpl.getApplication().getPackageManager();
      if ((!obw.a(this.qo, "menuItem:share:qiDian")) && ((this.gK & 0x10) == 0L)) {
        asgx.g(this.s, localArrayList);
      }
      if ((!obw.a(this.qo, "menuItem:share:qiYeQQ")) && ((this.gK & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject2) != null))
      {
        localObject2 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).label = BaseApplicationImpl.getApplication().getString(2131698641);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).icon = 2130845292;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).action = 20;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject2).argus = "";
        localArrayList.add(localObject2);
      }
      localObject2 = new ArrayList();
      Iterator localIterator;
      Object localObject3;
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem;
      if ((this.bfD) && (this.qp != null))
      {
        localIterator = this.qp.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (PublicAccountJavascriptInterface.a)localIterator.next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((PublicAccountJavascriptInterface.a)localObject3).itemType)
          {
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.a)localObject3).itemName)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131697409);; localActionSheetItem.label = ((PublicAccountJavascriptInterface.a)localObject3).itemName)
            {
              localActionSheetItem.icon = 2130843495;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 30;
              localActionSheetItem.argus = "";
              ((ArrayList)localObject2).add(localActionSheetItem);
              break;
            }
          case 2: 
            localObject3 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).label = BaseApplicationImpl.getApplication().getString(2131697470);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = 2130843487;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).action = 31;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).argus = "";
            ((ArrayList)localObject2).add(localObject3);
          }
        }
      }
      if ((this.bfE) && (this.qp != null))
      {
        localIterator = this.qp.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (PublicAccountJavascriptInterface.a)localIterator.next();
          localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
          switch (((PublicAccountJavascriptInterface.a)localObject3).itemType)
          {
          case 2: 
          default: 
            break;
          case 1: 
            if (TextUtils.isEmpty(((PublicAccountJavascriptInterface.a)localObject3).itemName)) {}
            for (localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131697409);; localActionSheetItem.label = ((PublicAccountJavascriptInterface.a)localObject3).itemName)
            {
              localActionSheetItem.icon = 2130843495;
              localActionSheetItem.iconNeedBg = true;
              localActionSheetItem.action = 37;
              localActionSheetItem.argus = "";
              ((ArrayList)localObject2).add(localActionSheetItem);
              break;
            }
          case 3: 
            localObject3 = new ShareActionSheetBuilder.ActionSheetItem();
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).label = BaseApplicationImpl.getApplication().getString(2131698631);
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).icon = 2130843496;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).iconNeedBg = true;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).action = 35;
            ((ShareActionSheetBuilder.ActionSheetItem)localObject3).argus = "";
            ((ArrayList)localObject2).add(localObject3);
          }
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppRuntime)localObject1).getAccount())) && (!obw.a(this.qo, "menuItem:favorite")) && ((this.gK & 0x2000) == 0L))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698616);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130845044;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 6;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!obw.a(this.qo, "menuItem:setFont")) && (!this.bfA) && (this.bfy))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698625);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843491;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 7;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!obw.a(this.qo, "menuItem:copyUrl")) && ((this.gK & 0x20) == 0L))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698622);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130839246;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 1;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      if ((!obw.a(this.qo, "menuItem:exposeArticle")) && (this.bfz))
      {
        localObject1 = new ShareActionSheetBuilder.ActionSheetItem();
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).label = BaseApplicationImpl.getApplication().getString(2131698628);
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).icon = 2130843479;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).iconNeedBg = true;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).action = 11;
        ((ShareActionSheetBuilder.ActionSheetItem)localObject1).argus = "";
        ((ArrayList)localObject2).add(localObject1);
      }
      return (List[])new ArrayList[] { localArrayList, localObject2 };
    }
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
        if (!TextUtils.isEmpty(this.b.aHh)) {
          this.b.bBi();
        } else {
          this.b.a(paramString1, 1, false);
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
    String str5;
    String str4;
    String str3;
    String str2;
    String str1;
    int j;
    int i;
    if (paramBundle != null)
    {
      str5 = paramBundle.getString("qq", "");
      str4 = paramBundle.getString("public_uin", "");
      str3 = paramBundle.getString("source_public_uin", "");
      str2 = paramBundle.getString("default_url", "");
      str1 = paramBundle.getString("msg_id", "");
      j = paramBundle.getInt("troop_app_id", 0);
      i = paramBundle.getInt("troop_id", 0);
      str6 = paramBundle.getString("troop_app_info_url", "");
      paramBundle.getInt("uin_type", 0);
    }
    for (;;)
    {
      Object localObject3 = this.mUrl;
      Object localObject4 = null;
      Object localObject1 = localObject4;
      String str8;
      Object localObject5;
      if (this.c != null)
      {
        str8 = this.c.mRedirect302Url;
        localObject5 = this.c.getWebView();
        localObject1 = localObject4;
        localObject3 = str8;
        if (localObject5 != null)
        {
          localObject1 = ((WebView)localObject5).getOriginalUrl();
          localObject3 = str8;
        }
      }
      localObject4 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject4 = paramString;
        if (((String)localObject1).equals(paramString)) {}
      }
      try
      {
        localObject4 = Uri.parse((String)localObject1);
        localObject5 = ((Uri)localObject4).getHost();
        str8 = null;
        if (((Uri)localObject4).isHierarchical()) {
          str8 = ((Uri)localObject4).getQueryParameter("_pflag");
        }
        localObject4 = paramString;
        if (!TextUtils.isEmpty(str8)) {
          if (!"post.mp.qq.com".equalsIgnoreCase((String)localObject5))
          {
            localObject4 = paramString;
            if (!"url.cn".equalsIgnoreCase((String)localObject5)) {}
          }
          else
          {
            int k = Integer.parseInt(str8);
            localObject4 = paramString;
            if ((k >> 3 & 0x1) == 1) {
              localObject4 = localObject1;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label824:
          label1362:
          label1379:
          label2148:
          String str7 = paramString;
          label1290:
          label1619:
          continue;
          long l1 = 0L;
          continue;
          label3085:
          l1 = 0L;
          continue;
          label3091:
          l1 = 0L;
          continue;
          label3097:
          Object localObject2 = localObject3;
          continue;
          label3104:
          localObject2 = localObject3;
        }
      }
      if (paramInt == 1)
      {
        ((ClipboardManager)this.s.getSystemService("clipboard")).setText((CharSequence)localObject4);
        rwt.ez(2, 2131692332);
        if ((this.bfC) && (!TextUtils.isEmpty(this.b.aHg))) {
          this.b.bBg();
        }
      }
      for (;;)
      {
        CC(paramInt);
        return;
        if (paramInt == 11)
        {
          paramString = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher((CharSequence)localObject4);
          i = 0;
          if (paramString.matches()) {
            i = 1;
          }
          paramBundle = null;
          try
          {
            paramString = URLEncoder.encode((String)localObject4, "UTF-8");
            if (i != 0)
            {
              localObject3 = String.valueOf(NetConnInfoCenter.getServerTime());
              localObject1 = arwv.encodeHexStr(paramString + 200 + (String)localObject3 + "jubao@article@123");
              paramBundle = (Bundle)localObject1;
              if (localObject1 != null)
              {
                paramBundle = (Bundle)localObject1;
                if (!((String)localObject1).isEmpty()) {
                  paramBundle = ((String)localObject1).toLowerCase();
                }
              }
              paramString = "https://post.mp.qq.com/jubao/index?qq=" + str5 + "&mp_uin=" + str4 + "&scene=200&sub_appname=article_webview&timestamp=" + (String)localObject3 + "&sign=" + paramBundle + "&article_url=" + paramString + "&_wv=3";
              paramBundle = new Intent(this.s, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_more_button", true);
              this.s.startActivity(paramBundle);
              anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_67", "jvbao_click", 0, 1, 0, "", "", "", "");
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1008, 0, str3, str1, str2, AccountDetailActivity.dX(str2), false);
            }
          }
          catch (UnsupportedEncodingException paramString)
          {
            for (;;)
            {
              paramString = paramBundle;
              if (QLog.isColorLevel())
              {
                QLog.d("SwiftBrowserShareMenuHandler", 2, "encode shareUrl failed, because UTF-8 is unknown");
                paramString = paramBundle;
                continue;
                paramString = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + paramString + "&qq=" + str5 + "&_wv=7";
              }
            }
          }
        }
        else
        {
          if (paramInt == 2)
          {
            boolean bool2 = false;
            if (this.c == null) {}
            boolean bool1 = bool2;
            if (!TextUtils.isEmpty(this.mWebView.getUrl()))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(this.currentUrl))
              {
                bool1 = bool2;
                if (!TextUtils.isEmpty(this.currentUrl))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                    break label824;
                  }
                  bool1 = bool2;
                  if (((String)localObject4).equals(this.currentUrl)) {
                    bool1 = true;
                  }
                }
              }
            }
            for (;;)
            {
              this.b.aNu = bool1;
              ah((String)localObject4, (String)localObject3, (String)localObject1);
              break;
              bool1 = bool2;
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                bool1 = bool2;
                if (((String)localObject1).equals(this.currentUrl)) {
                  bool1 = true;
                }
              }
            }
          }
          if (paramInt == 4)
          {
            paramString = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject4));
            paramString.putExtra("normal", true);
            try
            {
              this.s.startActivity(paramString);
              anot.a(null, "P_CliOper", "VIPCOMIC", "", "0X800619F", "0X800619F", 1000, 0, jqo.filterKeyForLog(str2, new String[0]), null, null, null);
              anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_48", "browser_share", 0, 1, 0, "", "", "", "");
              if ((str3 == null) || ("".equals(str3))) {
                continue;
              }
              kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1006, 0, str3, str1, str2, AccountDetailActivity.dX(str2), false);
            }
            catch (ActivityNotFoundException paramString)
            {
              for (;;)
              {
                rwt.ez(1, 2131697436);
              }
            }
          }
          else if (paramInt != 5)
          {
            if (paramInt == 3)
            {
              In = System.currentTimeMillis();
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label3104;
              }
              ocp.l(1002, (String)localObject1, this.bQX);
              if (!TextUtils.isEmpty(this.b.aHg)) {
                this.b.g((String)localObject4, 2, false);
              }
              for (;;)
              {
                arts.a().a("", "", "", "1000", "102", "0", false);
                anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_44", "qzone_share", 0, 1, 0, "", "", "", "");
                break;
                if (!TextUtils.isEmpty(this.b.aHi)) {
                  this.b.bBj();
                } else {
                  this.b.No();
                }
              }
            }
            if (paramInt == 6)
            {
              if (this.b.bw((String)localObject4)) {
                this.b.a((String)localObject4, 9, false);
              }
              if ((str3 != null) && (!"".equals(str3))) {
                kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1007, 0, str3, str1, str2, AccountDetailActivity.dX(str2), false);
              }
            }
            else if ((paramInt == 9) || (paramInt == 10))
            {
              i = -1;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label3097;
              }
              if (paramInt == 9)
              {
                ocp.l(1003, (String)localObject1, this.bQX);
                if (WXShareHelper.a().isWXinstalled()) {
                  break label1362;
                }
                i = 2131721935;
              }
              for (;;)
              {
                if (i == -1) {
                  break label1379;
                }
                rwt.ez(0, i);
                if (paramInt != 9) {
                  break label1619;
                }
                arts.a().a("", "", "", "1000", "103", "0", false);
                break;
                ocp.l(1004, (String)localObject1, this.bQX);
                break label1290;
                if (!WXShareHelper.a().isWXsupportApi()) {
                  i = 2131721936;
                }
              }
              if (paramInt == 9)
              {
                if (!TextUtils.isEmpty(this.b.aHg)) {
                  this.b.g((String)localObject4, 3, true);
                }
                for (;;)
                {
                  anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_40", "weixin_share", 0, 1, 0, "", "", "", "");
                  if ((str3 == null) || ("".equals(str3))) {
                    break;
                  }
                  kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", 1003, 0, str3, str1, str2, AccountDetailActivity.dX(str2), false);
                  break;
                  if (!TextUtils.isEmpty(this.b.aHj)) {
                    this.b.bBk();
                  } else {
                    this.b.a((String)localObject4, 3, true);
                  }
                }
              }
              if (!TextUtils.isEmpty(this.b.aHg)) {
                this.b.g((String)localObject4, 4, true);
              }
              for (;;)
              {
                anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_webview_42", "pengyouquan_share", 0, 1, 0, "", "", "", "");
                break;
                if (!TextUtils.isEmpty(this.b.aHk)) {
                  this.b.bBl();
                } else {
                  this.b.a((String)localObject4, 4, true);
                }
              }
              if (paramInt == 10) {
                arts.a().a("", "", "", "1000", "104", "0", false);
              }
            }
            else if (paramInt == 13)
            {
              this.b.a((String)localObject4, 5, true);
            }
            else if (paramInt == 15)
            {
              if (this.c == null) {
                throw new InvalidParameterException("ACTION_ADD_TROOP_APP should be handled by QQBrowserActivity!");
              }
              if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
              {
                QQToast.a(BaseApplicationImpl.getContext(), 2, 2131721287, 0).show(this.c.getTitleBarHeight());
                return;
              }
              b().a(j, new wqx(this));
              anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "add_menu", 0, 1, 0, "" + i, "" + j, "", "");
            }
            else if (paramInt == 16)
            {
              paramString = new Intent(this.s, QQBrowserActivity.class);
              paramString.putExtra("url", str6);
              paramString.putExtra("hide_operation_bar", true);
              paramString.putExtra("hide_more_button", true);
              this.s.startActivity(paramString);
              anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "detail_menu", 0, 1, 0, "" + i, "" + j, "", "");
            }
            else if (paramInt == 17)
            {
              paramString = "";
              if (paramBundle != null) {
                paramString = paramBundle.getString("troop_app_share_url", "");
              }
              paramBundle = new Intent(this.s, QQBrowserActivity.class);
              paramBundle.putExtra("url", paramString);
              paramBundle.putExtra("hide_operation_bar", true);
              paramBundle.putExtra("hide_more_button", true);
              this.s.startActivity(paramBundle);
              anot.b(null, "P_CliOper", "Grp_open", "", "third_app", "share_menu", 0, 1, 0, "" + i, "" + j, "", "");
            }
            else if (paramInt == 7)
            {
              cbe();
            }
            else if ((paramInt == 19) || (paramInt == 20))
            {
              if (paramInt == 19) {}
              for (i = 6;; i = 7)
              {
                if (TextUtils.isEmpty(this.b.aHg)) {
                  break label2148;
                }
                this.b.g((String)localObject4, i, false);
                break;
              }
              this.b.a((String)localObject4, i, true);
            }
            else
            {
              if (paramInt == 12)
              {
                if (!TextUtils.isEmpty(this.b.aHg)) {
                  this.b.g((String)localObject4, 8, false);
                }
                for (;;)
                {
                  paramBundle = this.mUrl;
                  if (this.mWebView != null) {
                    paramBundle = this.mWebView.getUrl();
                  }
                  paramString = "";
                  localObject1 = Uri.parse(paramBundle);
                  try
                  {
                    localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
                    paramString = (String)localObject1;
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      localException1.printStackTrace();
                    }
                  }
                  localObject1 = paramString;
                  if (paramString == null) {
                    localObject1 = "";
                  }
                  kbp.a(null, "", "0X800787A", "0X800787A", 0, 0, (String)localObject1, paramBundle, "", "");
                  ocp.l(1005, paramBundle, this.bQX);
                  break;
                  this.b.a((String)localObject4, 8, false);
                }
              }
              if (paramInt == 34)
              {
                if (!TextUtils.isEmpty(this.b.aHg)) {
                  this.b.bBf();
                } else if (QLog.isColorLevel()) {
                  QLog.d("diandian", 2, "dian dian is here");
                }
              }
              else if (paramInt == 35)
              {
                long l2 = 0L;
                paramBundle = null;
                l1 = l2;
                paramString = paramBundle;
                if (this.qp != null)
                {
                  localObject2 = this.qp.iterator();
                  do
                  {
                    l1 = l2;
                    paramString = paramBundle;
                    if (!((Iterator)localObject2).hasNext()) {
                      break;
                    }
                    paramString = (PublicAccountJavascriptInterface.a)((Iterator)localObject2).next();
                  } while (paramString.itemType != 3);
                }
                try
                {
                  paramString = new JSONObject(paramString.VH);
                  l1 = paramString.getLong("uin");
                  paramString = paramString.optString("name");
                  paramString = AddFriendLogicActivity.a(this.s, 1, l1 + "", null, 3001, 3999, paramString, null, null, null, null);
                  this.s.startActivity(paramString);
                  kbp.a(null, "", "0X8008C0F", "0X8008C0F", 0, 0, "", "", "", "", false);
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                  return;
                }
              }
              else if (paramInt == 30)
              {
                if ((this.qp == null) || (!this.bfD)) {
                  break label3091;
                }
                paramString = this.qp.iterator();
                do
                {
                  if (!paramString.hasNext()) {
                    break;
                  }
                  paramBundle = (PublicAccountJavascriptInterface.a)paramString.next();
                } while (paramBundle.itemType != 1);
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
              }
              else
              {
                if ((paramInt == 37) && (this.bfE))
                {
                  if (this.qp == null) {
                    break label3085;
                  }
                  paramString = this.qp.iterator();
                  do
                  {
                    if (!paramString.hasNext()) {
                      break;
                    }
                    paramBundle = (PublicAccountJavascriptInterface.a)paramString.next();
                  } while (paramBundle.itemType != 1);
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
                }
                if (paramInt == 31)
                {
                  if (this.qp == null) {
                    break;
                  }
                  paramString = this.qp.iterator();
                  do
                  {
                    if (!paramString.hasNext()) {
                      break;
                    }
                    paramBundle = (PublicAccountJavascriptInterface.a)paramString.next();
                  } while (paramBundle.itemType != 2);
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
                }
                else if (paramInt == 38)
                {
                  this.b.bBh();
                }
              }
            }
          }
        }
      }
      i = 0;
      j = 0;
      str1 = "";
      str2 = "";
      str3 = "";
      str4 = "";
      str5 = "";
    }
  }
  
  public void cbe()
  {
    Object localObject = this.s.getLayoutInflater().inflate(2131559312, null);
    this.f = new PopupWindow((View)localObject, -1, -2);
    this.f.setBackgroundDrawable(new BitmapDrawable());
    this.f.setOutsideTouchable(true);
    localObject = (RangeButtonView)((View)localObject).findViewById(2131367439);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.e(acfp.m(2131704317), TypedValue.applyDimension(1, 15.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e(acfp.m(2131704321), TypedValue.applyDimension(1, 16.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e("", TypedValue.applyDimension(1, 17.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e("", TypedValue.applyDimension(1, 17.0F, acej.k)));
    localArrayList.add(new RangeButtonView.e(acfp.m(2131704320), TypedValue.applyDimension(1, 18.0F, acej.k)));
    ((RangeButtonView)localObject).setTitleData(localArrayList);
    ((RangeButtonView)localObject).setOnChangerListener(this);
    ((RangeButtonView)localObject).setThumbPosition(this.aXQ);
    localArrayList = new ArrayList();
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131692122));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131692123));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131692124));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131692125));
    localArrayList.add(BaseApplicationImpl.getApplication().getString(2131692126));
    ((RangeButtonView)localObject).setContentDescList(localArrayList);
    this.f.showAtLocation(this.mWebView, 83, 0, 0);
  }
  
  public void dy(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    CD(paramInt2);
    b().yB(this.aXQ);
  }
  
  public void fV(long paramLong) {}
  
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
    Intent localIntent = this.s.getIntent();
    this.mUrl = localIntent.getStringExtra("url");
    if (this.mUrl == null)
    {
      this.mUrl = localIntent.getStringExtra("key_params_qq");
      if (this.mUrl == null) {
        this.mUrl = "";
      }
    }
    this.currentUrl = this.mUrl;
    xF(this.mUrl);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (((this.gK & 0x20000) != 0L) && (this.c != null)) {
      this.c.egN();
    }
    if ((this.c != null) && (this.c.a != null) && ((this.c.getHostActivity() instanceof TeamWorkDocEditBrowserActivity)) && (!TextUtils.isEmpty(this.c.mUrl)) && (this.c.mUrl.contains("sheet"))) {
      this.c.a.ehn();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onItemClick, tag = ");
      if (localObject1 != null)
      {
        bool = true;
        QLog.d("SwiftBrowserShareMenuHandler", 2, bool);
      }
    }
    else
    {
      if (localObject1 != null) {
        break label74;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      bool = false;
      break;
      label74:
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      int i = ((ShareActionSheetBuilder.b)localObject1).b.action;
      localObject1 = getShareUrl();
      localObject2 = new Bundle();
      if (this.c != null)
      {
        ((Bundle)localObject2).putString("qq", this.c.uin);
        ((Bundle)localObject2).putString("public_uin", this.c.awT);
        ((Bundle)localObject2).putString("source_public_uin", this.c.aTX);
        ((Bundle)localObject2).putString("default_url", this.c.mUrl);
        ((Bundle)localObject2).putString("msg_id", this.c.msgid);
        ((Bundle)localObject2).putString("troop_app_info_url", this.c.cyR);
        ((Bundle)localObject2).putString("troop_app_share_url", this.c.cyQ);
        ((Bundle)localObject2).putInt("troop_id", this.c.edX);
        ((Bundle)localObject2).putInt("troop_app_id", this.c.appId);
        ((Bundle)localObject2).putInt("uin_type", this.c.uinType);
      }
      c(i, (String)localObject1, (Bundle)localObject2);
    }
  }
  
  public void xF(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Wqw$a = new wqw.a();
      paramString = Uri.parse(paramString);
      if (!paramString.isHierarchical()) {
        continue;
      }
      String str = paramString.getQueryParameter("_wv");
      if (str != null) {}
      try
      {
        this.jdField_a_of_type_Wqw$a.gK = Long.parseLong(str, 10);
        str = paramString.getQueryParameter("_fv");
        if (str == null) {}
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          this.jdField_a_of_type_Wqw$a.Dr = Long.parseLong(str, 10);
          str = paramString.getQueryParameter("_wwv");
          if (str == null) {}
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            for (;;)
            {
              this.jdField_a_of_type_Wqw$a.Ds = Long.parseLong(str, 10);
              paramString = paramString.getQueryParameter("_cwv");
              if (paramString == null) {
                break;
              }
              try
              {
                this.jdField_a_of_type_Wqw$a.Io = Long.parseLong(paramString, 10);
                return;
              }
              catch (NumberFormatException paramString)
              {
                QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _cwv param(" + str + ") error:" + paramString.getMessage());
                return;
              }
              localNumberFormatException1 = localNumberFormatException1;
              QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _wv param(" + str + ") error:" + localNumberFormatException1.getMessage());
            }
            localNumberFormatException2 = localNumberFormatException2;
            QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _fv param(" + str + ") error:" + localNumberFormatException2.getMessage());
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            for (;;)
            {
              QLog.e("SwiftBrowserShareMenuHandler", 1, "parser _wwv param(" + str + ") error:" + localNumberFormatException3.getMessage());
            }
          }
        }
      }
    }
  }
  
  public static class a
  {
    long Dr;
    long Ds;
    long Io;
    long gK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqw
 * JD-Core Version:    0.7.0.1
 */