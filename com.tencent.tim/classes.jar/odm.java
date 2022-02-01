import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.a;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.3;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.5;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.6;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class odm
  implements odg.c
{
  public String Qt;
  ardm.c jdField_a_of_type_Ardm$c = null;
  ardm.o jdField_a_of_type_Ardm$o = null;
  public CustomWebView a;
  public WxShareHelperFromReadInjoy.a a;
  private odm.b jdField_a_of_type_Odm$b;
  private String apP;
  private ljr b;
  private long bS = -1L;
  public skj c;
  private List<oaq> kU;
  private List<oaq> kV;
  arhz m;
  private Activity mActivity;
  private String mData;
  private WebViewPlugin.a mRuntime;
  private odg mShareHelper;
  private long yF = -1L;
  
  public odm(ljr paramljr, skj paramskj)
  {
    this.b = paramljr;
    this.mRuntime = paramljr.mRuntime;
    this.c = paramskj;
    this.mActivity = getActivity();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = this.mRuntime.getWebView();
    paramljr = this.mRuntime.a(this.mRuntime.getActivity());
    if ((paramljr != null) && ((paramljr instanceof ardm.o))) {
      this.jdField_a_of_type_Ardm$o = ((ardm.o)paramljr);
    }
    paramljr = this.mRuntime.a(this.mRuntime.getActivity());
    if ((paramljr != null) && ((paramljr instanceof ardm.c))) {
      this.jdField_a_of_type_Ardm$c = ((ardm.c)paramljr);
    }
  }
  
  private void Sa()
  {
    if (this.m == null) {
      this.m = new arhz(this.mActivity, this.mActivity.getResources().getDimensionPixelSize(2131299627));
    }
    if (!this.m.isShowing())
    {
      this.m.setMessage(2131695695);
      this.m.show();
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((!paramBoolean) && (paramString4 != null) && (paramString4.length() > 140) && (!"3".equals(paramString1))) {
      localHashMap.put("share_url", paramString4);
    }
    if ((paramString5 != null) && (paramString5.length() > 80) && (!"2".equals(paramString1)) && (!"3".equals(paramString1)) && (!"4".equals(paramString1))) {
      localHashMap.put("image_url", paramString5);
    }
    Sa();
    ThreadManager.post(new ReadInjoyWebShareHelper.3(this, localHashMap, paramString4, paramString5, paramJSONObject, paramString2, paramString3, paramString6), 8, null, true);
  }
  
  private void ao(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (this.apP != null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("action", paramString);
        if (!paramBoolean) {
          continue;
        }
        paramString = "0";
        localJSONObject.put("retCode", paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.apP, new String[] { localJSONObject.toString() });
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      odg.d.a.nV(paramBoolean);
      return;
      paramString = "1";
    }
  }
  
  private void bF()
  {
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
  }
  
  private void bdF()
  {
    this.bS = -1L;
    this.yF = -1L;
    Intent localIntent = this.mActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("fromFav", false)))
    {
      this.bS = localIntent.getLongExtra("favID", -1L);
      this.yF = localIntent.getLongExtra("favGroupID", -1L);
    }
    if (this.bS != -1L) {
      this.kV.add(2, new oaq("fav_move_group", 39, false));
    }
  }
  
  private void bdG()
  {
    String str1 = this.jdField_a_of_type_Odm$b.title;
    String str2 = this.jdField_a_of_type_Odm$b.desc;
    String str3 = this.jdField_a_of_type_Odm$b.image_url;
    String str4 = this.mRuntime.b().uin;
    String str5 = this.jdField_a_of_type_Odm$b.nick_name;
    aviz.a(0, str1, this.jdField_a_of_type_Odm$b.share_url, str5, str2, str3, null, null, false, -1L).a("lCategory", 8L).c(str4).b(this.mRuntime.getActivity(), str4);
  }
  
  private void bdH()
  {
    Object localObject1 = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(this.jdField_a_of_type_Odm$b.share_url);
    int i = 0;
    if (((Matcher)localObject1).matches()) {
      i = 1;
    }
    Object localObject3 = null;
    try
    {
      localObject1 = URLEncoder.encode(this.jdField_a_of_type_Odm$b.share_url, "UTF-8");
      str2 = this.mRuntime.b().uin;
      if (i != 0)
      {
        String str3 = String.valueOf(NetConnInfoCenter.getServerTime());
        String str1 = arwv.encodeHexStr((String)localObject1 + 200 + str3 + "jubao@article@123");
        localObject3 = str1;
        if (str1 != null)
        {
          localObject3 = str1;
          if (!str1.isEmpty()) {
            localObject3 = str1.toLowerCase();
          }
        }
        str1 = this.mRuntime.b().awT;
        localObject1 = "https://post.mp.qq.com/jubao/index?qq=" + str2 + "&mp_uin=" + str1 + "&scene=200&sub_appname=article_webview&timestamp=" + str3 + "&sign=" + (String)localObject3 + "&article_url=" + (String)localObject1 + "&_wv=3";
        localObject3 = new Intent(this.mActivity, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        this.mActivity.startActivity((Intent)localObject3);
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2;
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("WebShareHelper", 2, "encode shareUrl failed, because UTF-8 is unknown");
          localObject2 = localObject3;
          continue;
          localObject2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + (String)localObject2 + "&qq=" + str2 + "&_wv=7";
        }
      }
    }
  }
  
  private void d(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.mData);
      String str6 = localJSONObject.optString("share_type", "0");
      String str2 = localJSONObject.optString("title");
      String str3 = localJSONObject.optString("desc");
      String str4 = localJSONObject.optString("share_url");
      String str5 = localJSONObject.optString("image_url");
      String str7 = localJSONObject.optString("shareElement");
      String str1 = localJSONObject.optString("weibo_title");
      boolean bool = localJSONObject.optBoolean("keepShareUrl", false);
      switch (paramActionSheetItem.action)
      {
      case 72: 
        localJSONObject.put("toUin", paramActionSheetItem.uin);
        localJSONObject.put("uinType", paramActionSheetItem.uinType);
        localJSONObject.put("uinname", paramActionSheetItem.label);
      case 2: 
      case 73: 
        a(localJSONObject, str6, str2, str3, str4, str5, str7, 13, bool);
        return;
      case 3: 
        a(localJSONObject, str6, str2, str3, str4, str5);
        return;
      case 9: 
        a(localJSONObject, true, str2, str3, str4, str5, str7);
        return;
      case 10: 
        a(localJSONObject, false, str2, str3, str4, str5, str7);
        return;
      case 12: 
        paramActionSheetItem = str2;
        if (!TextUtils.isEmpty(str1)) {
          paramActionSheetItem = str1;
        }
        k(paramActionSheetItem, str3, str4, str5);
        return;
      }
      return;
    }
    catch (Exception paramActionSheetItem) {}
  }
  
  private List<Integer>[] d()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.kU.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.add(Integer.valueOf(((oaq)((Iterator)localObject).next()).action));
    }
    ArrayList localArrayList2 = new ArrayList();
    localObject = this.kV.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add(Integer.valueOf(((oaq)((Iterator)localObject).next()).action));
    }
    if (localArrayList2.contains(Integer.valueOf(68)))
    {
      if (this.jdField_a_of_type_Odm$b != null) {
        break label152;
      }
      localObject = null;
      if (!aoag.pL((String)localObject)) {
        break label163;
      }
      aoag.jI(0, 3);
    }
    for (;;)
    {
      return new List[] { localArrayList1, localArrayList2 };
      label152:
      localObject = this.jdField_a_of_type_Odm$b.share_url;
      break;
      label163:
      localArrayList2.remove(Integer.valueOf(68));
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = 2;
    bF();
    paramString1 = new Bundle();
    paramString1.putString("title", paramString2);
    paramString1.putString("desc", paramString3);
    paramString1.putString("detail_url", paramString4);
    paramString1.putString("from", "qq");
    if (paramJSONObject != null) {
      paramString1.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    paramString1.putStringArrayList("image_url", paramJSONObject);
    paramString1.putLong("req_share_id", 0L);
    paramString1.putInt("iUrlInfoFrm", 1);
    paramString1.putLong("share_begin_time", arbt.In);
    if (this.jdField_a_of_type_Ardm$o != null)
    {
      paramString1.putString("struct_url", this.jdField_a_of_type_Ardm$o.getCurrentUrl());
      paramString1.putBoolean("from_web", true);
    }
    if (this.jdField_a_of_type_Ardm$c != null) {
      i = this.jdField_a_of_type_Ardm$c.a(this.b, (byte)2, true);
    }
    avqq.a(this.mRuntime.a(), this.mActivity, paramString1, null, i);
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
    throws JSONException
  {
    this.mRuntime.getActivity();
    Intent localIntent = new Intent();
    paramString5 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str1 = paramJSONObject.optString("uinname");
    if ((paramString5 != null) && (paramString5.length() >= 5))
    {
      localIntent.setClass(this.mActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString5);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str1);
    }
    for (;;)
    {
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString5 = paramString1;
      if (paramString1 != null)
      {
        paramString5 = paramString1;
        if (paramString1.length() > 45) {
          paramString5 = paramString1.substring(0, 45) + "…";
        }
      }
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() > 60) {
          paramString1 = paramString2.substring(0, 60) + "…";
        }
      }
      i = paramInt;
      if (paramInt <= 0) {
        i = 13;
      }
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", paramString5);
      localIntent.putExtra("desc", paramString1);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", i);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131698632, new Object[] { paramString5 }));
      localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
      if (paramJSONObject.has("contentAction")) {
        localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
      }
      if (paramJSONObject.has("actionData")) {
        localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
      }
      if (paramJSONObject.has("sourceAction")) {
        localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
      }
      if (paramJSONObject.has("isShareFlag")) {
        localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
      }
      if (paramJSONObject.has("srcActionData")) {
        localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
      }
      if (paramJSONObject.has("appName")) {
        localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
      }
      localIntent.putExtra("req_type", 144);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      localIntent.putExtra("k_back", paramJSONObject.optBoolean("back", false));
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      if (paramJSONObject.has("serviceID"))
      {
        paramInt = paramJSONObject.getInt("serviceID");
        if ((paramInt == 116) || (paramInt == 123)) {
          localIntent.putExtra("compatible_text", aegu.bxf);
        }
      }
      long l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break;
      }
      paramJSONObject = this.mRuntime.a();
      if (paramJSONObject != null)
      {
        Sa();
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        svi.a(paramJSONObject, this.mActivity, paramJSONObject.getAccount(), l, 3000L, new odo(this, localIntent));
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.mActivity, ForwardRecentActivity.class);
    }
    bF();
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
        paramString2.close();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1599;
          }
        }
      }
      label940:
      label950:
      label1593:
      label1599:
      for (paramString2 = paramString5.name;; paramString2 = null)
      {
        paramString3 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString2;
          if (paramJSONObject.has("sourceName")) {
            paramString3 = paramJSONObject.optString("sourceName");
          }
        }
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString2 = paramString1;
        }
        for (;;)
        {
          if (paramString2.equalsIgnoreCase(this.mActivity.getString(2131701894)))
          {
            boolean bool = paramString2.equalsIgnoreCase(this.mActivity.getString(2131701894));
            if (bool)
            {
              paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1128;
              }
              paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1136;
              }
              paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              label960:
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_icon", paramString4);
              localIntent.putExtra("app_name", paramString2);
            }
          }
          for (;;)
          {
            localIntent.putExtra("stuctmsg_bytes", anre.a(localIntent.getExtras()).getBytes());
            this.b.startActivityForResult(localIntent, (byte)1);
            return;
            if (paramJSONObject.has("sourceName")) {
              paramString2 = paramJSONObject.optString("sourceName");
            }
            paramString3 = paramString2;
            if (TextUtils.isEmpty(paramString2))
            {
              paramString3 = paramString2;
              if (paramString5 != null) {
                paramString3 = paramString5.name;
              }
            }
            if (!TextUtils.isEmpty(paramString3)) {
              break label1593;
            }
            paramString2 = paramString1;
            break;
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label940;
            label1128:
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label950;
            label1136:
            paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label960;
            paramString3 = paramJSONObject.optString("src_webActionUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            str1 = paramJSONObject.optString("src_a_actionData", "");
            String str2 = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))))
            {
              paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
              paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
            }
            for (;;)
            {
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("app_name", paramString2);
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1491;
              }
              localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
              break;
              localIntent.putExtra("struct_share_key_source_action", paramString4);
              if ("web".equals(paramString4))
              {
                localIntent.putExtra("struct_share_key_source_url", paramString3);
                localIntent.putExtra("source_url", paramString3);
              }
              else
              {
                if (!TextUtils.isEmpty(paramString5)) {
                  localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                }
                if (!TextUtils.isEmpty(str1)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", str1);
                }
                if (!TextUtils.isEmpty(str2)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", str2);
                }
              }
            }
            label1491:
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
            continue;
            if (paramJSONObject.has("sourceName"))
            {
              paramString1 = paramJSONObject.optString("sourceName");
              localIntent.putExtra("app_name", paramString1);
              if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              }
            }
            else
            {
              localIntent.putExtra("app_name", this.mActivity.getString(2131698649));
            }
          }
          paramString2 = paramString3;
        }
      }
    }
  }
  
  void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mRuntime.getActivity();
    int i = -1;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    while (i != -1)
    {
      rwt.ez(0, i);
      bF();
      return;
      if (!WXShareHelper.a().isWXsupportApi()) {
        i = 2131721936;
      }
    }
    if (paramJSONObject.optInt("WXShareToMiniProgram") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString5 = paramJSONObject.optString("WXSharePath");
      paramJSONObject = new HashMap(1);
      paramString1 = new ReadInjoyWebShareHelper.4(this, paramBoolean, paramJSONObject, bool, paramString1, paramString2, paramString3, paramString5);
      Sa();
      ThreadManager.post(new ReadInjoyWebShareHelper.5(this, paramString4, bool, paramJSONObject, paramString1, paramBoolean, paramString3), 8, null, false);
      return;
    }
  }
  
  void bV(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString2);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  Activity getActivity()
  {
    for (Activity localActivity = this.mRuntime.getActivity(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public void i(int paramInt, float paramFloat)
  {
    this.mRuntime.getWebView().getSettings().setTextZoom(arbt.hq[paramInt]);
    this.c.yB(paramInt);
  }
  
  void k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina start!");
    }
    try
    {
      localObject = Uri.parse(paramString3);
      if (localObject != null)
      {
        localObject = ((Uri)localObject).getHost();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("article.mp.qq.com".equalsIgnoreCase((String)localObject)) || ("post.mp.qq.com".equalsIgnoreCase((String)localObject))))
        {
          m(paramString1, paramString2, paramString3, paramString4);
          return;
        }
      }
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString2 = this.mRuntime.getActivity();
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "shareMsgToSina empty title or share_url");
          }
          bF();
          QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          return;
        }
        Object localObject = BaseApplicationImpl.getContext().getPackageManager();
        try
        {
          localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
          }
          ThreadManager.executeOnSubThread(new ReadInjoyWebShareHelper.6(this, paramString4, paramString1, paramString3, (ApplicationInfo)localObject, paramString2));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label234;
            }
            QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
            try
            {
              paramString1 = URLEncoder.encode(paramString1, "UTF-8");
              paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
              paramString3 = URLEncoder.encode(paramString3, "UTF-8");
              paramString1 = paramString1 + "&url=" + paramString3;
              paramString3 = URLEncoder.encode(paramString4, "UTF-8");
              paramString1 = paramString1 + "&pic=" + paramString3;
              paramString1 = paramString1 + "&_wv=3";
              paramString3 = new Intent(paramString2, QQBrowserActivity.class);
              paramString3.putExtra("url", paramString1);
              paramString2.startActivity(paramString3);
              if (!QLog.isColorLevel()) {
                break label399;
              }
              QLog.d("WebShareHelper", 2, "shareMsgToSina start webview!");
              bF();
            }
            catch (Exception paramString1)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
              paramString1.printStackTrace();
              bF();
            }
            finally
            {
              bF();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("WebShareHelper", 2, "shareMsgToSina end!");
      return;
    }
  }
  
  void m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = this.mRuntime.getActivity();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      bF();
      QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("WebShareHelper", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          paramString1.printStackTrace();
          bF();
        }
      }
      finally
      {
        bF();
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebShareHelper", 2, "shareMsgToSina end!");
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    boolean bool;
    if (paramInt == -1)
    {
      bool = true;
      if (paramByte != 1) {
        break label29;
      }
      ao("qq_friend", bool);
    }
    label29:
    while (paramByte != 2)
    {
      return;
      bool = false;
      break;
    }
    ao("qzone", bool);
  }
  
  public void onDestroy()
  {
    bF();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a != null) {
      WxShareHelperFromReadInjoy.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a);
    }
  }
  
  public void pt(String paramString)
  {
    if (this.mShareHelper == null) {
      this.mShareHelper = new odg(this.mActivity, this.mRuntime.a(), new odm.a());
    }
    this.mShareHelper.a().setActionSheetTitle("biu出去让更多好友看到");
    this.mShareHelper.a().setCancelListener(new odn(this));
    for (;;)
    {
      try
      {
        this.mData = paramString;
        paramString = new JSONObject(this.mData);
        JSONArray localJSONArray1 = paramString.optJSONArray("upline");
        JSONArray localJSONArray2 = paramString.optJSONArray("belowline");
        if (localJSONArray1 == null)
        {
          this.kU = odg.bm();
          if (localJSONArray2 == null)
          {
            this.kV = odg.bn();
            bdF();
            this.jdField_a_of_type_Odm$b = new odm.b(null);
            this.jdField_a_of_type_Odm$b.share_url = paramString.optString("share_url");
            this.jdField_a_of_type_Odm$b.desc = paramString.optString("desc");
            this.jdField_a_of_type_Odm$b.title = paramString.optString("title");
            this.jdField_a_of_type_Odm$b.image_url = paramString.optString("image_url");
            this.jdField_a_of_type_Odm$b.puin = paramString.optString("puin");
            this.jdField_a_of_type_Odm$b.nick_name = paramString.optString("nick_name");
            if (TextUtils.isEmpty(this.jdField_a_of_type_Odm$b.nick_name)) {
              this.jdField_a_of_type_Odm$b.nick_name = paramString.optString("sourceName");
            }
            this.apP = paramString.optString("callback");
            int i = paramString.optInt("report_from");
            this.mShareHelper.a(d(), i);
          }
        }
        else
        {
          this.kU = odg.b(localJSONArray1, null);
          continue;
        }
        this.kV = odg.b(localJSONArray2, null);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  void pu(String paramString)
  {
    if (this.apP != null) {
      bV(this.apP, paramString);
    }
  }
  
  class a
    extends odg.a
  {
    a() {}
    
    public boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
    {
      oaq localoaq = odm.a(odm.this).a(odm.a(odm.this), odm.b(odm.this), paramInt);
      if (localoaq == null) {
        return false;
      }
      if (localoaq.avZ)
      {
        odm.this.pu(localoaq.name);
        return true;
      }
      switch (paramInt)
      {
      default: 
        odm.this.pu(localoaq.name);
      }
      for (;;)
      {
        return super.b(paramInt, paramActionSheetItem);
        odm.this.pu(localoaq.name);
        continue;
        odm.a(odm.this, paramActionSheetItem);
        continue;
        odm.a(odm.this).po(odm.a(odm.this).share_url);
        odm.a(odm.this, localoaq.name, true);
        continue;
        odm.a(odm.this).pp(odm.a(odm.this).share_url);
        odm.a(odm.this, localoaq.name, true);
        continue;
        odm.a(odm.this).bdE();
        odm.a(odm.this, localoaq.name, true);
        continue;
        odm.a(odm.this).a(odm.this);
        odm.a(odm.this, localoaq.name, true);
        continue;
        odm.a(odm.this);
        odm.a(odm.this, localoaq.name, true);
        continue;
        if (!TextUtils.isEmpty(odm.a(odm.this).share_url))
        {
          aoag.jI(1, 3);
          aoag.bJ(odm.a(odm.this).share_url, odm.a(odm.this).title);
          odm.a(odm.this, localoaq.name, true);
          continue;
          if (!TextUtils.isEmpty(odm.a(odm.this).share_url))
          {
            odm.this.c.d(odm.a(odm.this).share_url, new odr(this, localoaq));
            continue;
            odm.a(odm.this).pq(odm.a(odm.this).share_url);
            odm.a(odm.this, localoaq.name, true);
            continue;
            odm.b(odm.this);
            odm.a(odm.this, localoaq.name, true);
            continue;
            odm.this.pu("not_care");
            continue;
            Intent localIntent;
            if (!TextUtils.isEmpty(odm.a(odm.this).puin))
            {
              localIntent = AddFriendLogicActivity.a(odm.this.getActivity(), 1, odm.a(odm.this).puin + "", null, 3096, 1, odm.a(odm.this).nick_name, null, null, null, null);
              odm.this.getActivity().startActivity(localIntent);
            }
            odm.a(odm.this, localoaq.name, true);
            continue;
            if (!TextUtils.isEmpty(odm.a(odm.this).puin))
            {
              localIntent = wja.a(new Intent(odm.this.getActivity(), SplashActivity.class), null);
              localIntent.putExtra("uin", odm.a(odm.this).puin);
              localIntent.putExtra("uintype", 0);
              odm.this.getActivity().startActivity(localIntent);
              odm.a(odm.this, localoaq.name, true);
              continue;
              if (!TextUtils.isEmpty(odm.a(odm.this).puin))
              {
                localIntent = new Intent(odm.this.getActivity(), AccountDetailActivity.class);
                localIntent.putExtra("uin", odm.a(odm.this).puin);
                localIntent.putExtra("from_js", true);
                odm.this.getActivity().startActivity(localIntent);
                odm.a(odm.this, localoaq.name, true);
                continue;
                odm.this.pu("unfollow");
              }
            }
          }
        }
      }
    }
  }
  
  static class b
  {
    String desc;
    String image_url;
    String nick_name;
    String puin;
    String share_url;
    String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     odm
 * JD-Core Version:    0.7.0.1
 */