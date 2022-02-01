import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class tjz
{
  public static String a;
  private bhht jdField_a_of_type_Bhht;
  private WXShareHelper.WXShareListener jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QShareUtils";
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str2 = paramJSONObject.optString("puin", null);
    String str1 = str2;
    if (str2 == null) {
      str1 = paramJSONObject.optString("oaUin");
    }
    return str1;
  }
  
  private String a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    String str;
    if ((!TextUtils.isEmpty(paramJSONObject.optString("wx_share_url"))) && (paramInt == 9)) {
      str = paramJSONObject.optString("wx_share_url");
    }
    do
    {
      do
      {
        return str;
        str = paramString;
      } while (TextUtils.isEmpty(paramJSONObject.optString("wx_circle_share_url")));
      str = paramString;
    } while (paramInt != 10);
    return paramJSONObject.optString("wx_circle_share_url");
  }
  
  private String a(JSONObject paramJSONObject, String paramString1, AccountDetail paramAccountDetail, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramAccountDetail != null) {
        paramString3 = paramAccountDetail.name;
      }
      paramAccountDetail = paramString3;
      if (TextUtils.isEmpty(paramString3))
      {
        paramAccountDetail = paramString3;
        if (paramJSONObject.has("sourceName")) {
          paramAccountDetail = paramJSONObject.optString("sourceName");
        }
      }
      paramJSONObject = paramAccountDetail;
      if (!TextUtils.isEmpty(paramAccountDetail)) {}
    }
    else
    {
      do
      {
        return paramString1;
        if (paramJSONObject.has("sourceName")) {
          paramString3 = paramJSONObject.optString("sourceName");
        }
        paramJSONObject = paramString3;
        if (TextUtils.isEmpty(paramString3))
        {
          paramJSONObject = paramString3;
          if (paramAccountDetail != null) {
            paramJSONObject = paramAccountDetail.name;
          }
        }
      } while (TextUtils.isEmpty(paramJSONObject));
    }
    return paramJSONObject;
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bhht == null) {
      this.jdField_a_of_type_Bhht = new bhht(paramActivity);
    }
  }
  
  private void a(Activity paramActivity, Intent paramIntent, long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)pay.a();
    if (localAppInterface != null)
    {
      a(paramActivity);
      if (!this.jdField_a_of_type_Bhht.isShowing())
      {
        this.jdField_a_of_type_Bhht.c(2131693585);
        this.jdField_a_of_type_Bhht.show();
      }
      paramIntent.putExtra("struct_share_key_source_name", Long.toString(paramLong));
      aadf.a(localAppInterface, paramActivity, localAppInterface.getAccount(), paramLong, 3000L, new tkb(this, paramIntent, paramActivity));
    }
  }
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, Intent paramIntent)
  {
    a(paramActivity);
    c();
    String str2 = a(paramJSONObject);
    Object localObject1;
    Object localObject2;
    String str3;
    label135:
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      localObject1 = (AppInterface)pay.a();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory(((AppInterface)localObject1).getAccount()).createEntityManager();
      localObject2 = (AccountDetail)((EntityManager)localObject1).find(AccountDetail.class, str2);
      ((EntityManager)localObject1).close();
      localObject1 = paramJSONObject.optString("src_action", "");
      str3 = a(paramJSONObject, str2, (AccountDetail)localObject2, (String)localObject1, null);
      if (str3.equalsIgnoreCase(paramActivity.getString(2131698803)))
      {
        boolean bool = str3.equalsIgnoreCase(paramActivity.getString(2131698803));
        if (bool)
        {
          localObject1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          if (!bool) {
            break label267;
          }
          localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          if (!bool) {
            break label274;
          }
          str1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          label144:
          paramIntent.putExtra("source_puin", str2);
          paramIntent.putExtra("struct_share_key_source_action", "plugin");
          paramIntent.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
          paramIntent.putExtra("struct_share_key_content_a_action_DATA", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_icon", str1);
          paramIntent.putExtra("app_name", str3);
          label207:
          paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
          if (!TextUtils.isEmpty(paramJSONObject)) {
            break label681;
          }
          paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
        }
      }
    }
    for (;;)
    {
      paramJSONObject = bchh.a(paramIntent.getExtras());
      if (paramJSONObject != null) {
        break label692;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
      }
      return;
      localObject1 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
      break;
      label267:
      localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
      break label135;
      label274:
      str1 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
      break label144;
      localObject2 = paramJSONObject.optString("src_iconUrl", "");
      str1 = paramJSONObject.optString("src_actionData", "");
      String str4 = paramJSONObject.optString("src_a_actionData", "");
      String str5 = paramJSONObject.optString("src_i_actionData", "");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (("web".equals(localObject1)) && ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).contains("webcard.mp.qq.com")))) || ((!"web".equals(localObject1)) && (TextUtils.isEmpty(str1)) && ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str5)))))
      {
        localObject1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { str2 });
        localObject2 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { str2 });
        paramIntent.putExtra("struct_share_key_source_action", "plugin");
        paramIntent.putExtra("struct_share_key_source_a_action_data", (String)localObject1);
        paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
      }
      for (;;)
      {
        paramIntent.putExtra("source_puin", str2);
        paramIntent.putExtra("app_name", str3);
        localObject1 = paramJSONObject.optString("src_iconUrl", "");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label592;
        }
        paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
        break;
        paramIntent.putExtra("struct_share_key_source_action", (String)localObject1);
        if ("web".equals(localObject1))
        {
          paramIntent.putExtra("struct_share_key_source_url", (String)localObject2);
          paramIntent.putExtra("source_url", (String)localObject2);
        }
        else
        {
          if (!TextUtils.isEmpty(str1)) {
            paramIntent.putExtra("struct_share_key_source_action_data", str1);
          }
          if (!TextUtils.isEmpty(str4)) {
            paramIntent.putExtra("struct_share_key_source_a_action_data", str4);
          }
          if (!TextUtils.isEmpty(str5)) {
            paramIntent.putExtra("struct_share_key_source_i_action_data", str5);
          }
        }
      }
      label592:
      paramIntent.putExtra("struct_share_key_source_icon", (String)localObject1);
      break label207;
      if (paramJSONObject.has("source_name"))
      {
        localObject1 = paramJSONObject.optString("source_name");
        paramIntent.putExtra("app_name", (String)localObject1);
        if ((!"手Q阅读".equals(localObject1)) || (!paramJSONObject.has("srcIconUrl"))) {
          break label207;
        }
        paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        break label207;
      }
      paramIntent.putExtra("app_name", paramActivity.getString(2131695896));
      break label207;
      label681:
      paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
    }
    label692:
    paramIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
    paramActivity.startActivityForResult(paramIntent, 21);
  }
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    String str1 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str2 = paramJSONObject.optString("friendName");
    if ((str1 != null) && (str1.length() >= 5))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", str1);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str2);
      localIntent.putExtra("key_flag_from_plugin", true);
      str1 = paramString1;
      if (paramString1 != null)
      {
        str1 = paramString1;
        if (paramString1.length() > 45) {
          str1 = paramString1.substring(0, 45) + "…";
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
      localIntent.putExtra("title", str1);
      localIntent.putExtra("desc", paramString1);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", i);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("app_id", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131695880, new Object[] { str1 }));
      localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
      localIntent.putExtra("is_need_show_toast", paramBoolean);
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
      if (paramJSONObject.has("source_name")) {
        localIntent.putExtra("app_name", paramJSONObject.getString("source_name"));
      }
      if (paramJSONObject.has("sourceName")) {
        localIntent.putExtra("app_name", paramJSONObject.getString("sourceName"));
      }
      if (!"audio".equals(paramString5)) {
        break label752;
      }
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    for (;;)
    {
      localIntent.putExtra("req_type", paramInt);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramBoolean = paramJSONObject.optBoolean("back", true);
      if (paramJSONObject.has("k_back")) {
        paramBoolean = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", paramBoolean);
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      long l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break label795;
      }
      a(paramActivity, localIntent, l);
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
      break;
      label752:
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    label795:
    a(paramActivity, paramJSONObject, localIntent);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap(1);
    int i = -1;
    if ((paramInt != 9) || (!WXShareHelper.getInstance().isWXinstalled())) {
      i = 2131719722;
    }
    while (i != -1)
    {
      yyi.a(0, i);
      return;
      if (!WXShareHelper.getInstance().isWXsupportApi()) {
        i = 2131719723;
      }
    }
    boolean bool;
    String str;
    if ((paramJSONObject.optInt("WXShareToMiniProgram") == 1) && (paramInt == 9))
    {
      bool = true;
      str = paramJSONObject.optString("WXSharePath");
      if (!TextUtils.isEmpty(paramJSONObject.optString("WXShareMiniProgramSourceID"))) {
        break label161;
      }
    }
    label161:
    for (paramJSONObject = "gh_eaa1f0b1626b";; paramJSONObject = paramJSONObject.optString("WXShareMiniProgramSourceID"))
    {
      b();
      paramJSONObject = new QShareUtils.1(this, localHashMap, bool, paramString1, paramString2, paramString3, str, paramJSONObject, paramInt, paramString6, paramString5);
      if (!TextUtils.isEmpty(paramString4)) {
        break label172;
      }
      paramJSONObject.run();
      return;
      bool = false;
      break;
    }
    label172:
    ThreadManager.post(new QShareUtils.2(this, paramString4, localHashMap, paramAppInterface, paramJSONObject), 8, null, false);
  }
  
  public static List<Integer>[] a(boolean paramBoolean, Set<String> paramSet)
  {
    if (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    if ((!paramSet.contains("menuItem:share:kandian")) && (!paramSet.contains("menuItem:share:diandian")) && (paramBoolean)) {
      localArrayList1.add(Integer.valueOf(13));
    }
    if (!paramSet.contains("menuItem:share:qq")) {
      localArrayList1.add(Integer.valueOf(2));
    }
    if (!paramSet.contains("menuItem:share:QZone")) {
      localArrayList1.add(Integer.valueOf(3));
    }
    if (!paramSet.contains("menuItem:share:appMessage")) {
      localArrayList1.add(Integer.valueOf(9));
    }
    if (!paramSet.contains("menuItem:share:timeline")) {
      localArrayList1.add(Integer.valueOf(10));
    }
    if (!paramSet.contains("menuItem:share:sinaWeibo")) {
      localArrayList1.add(Integer.valueOf(12));
    }
    if (!paramSet.contains("menuItem:openWithQQBrowser")) {
      localArrayList1.add(Integer.valueOf(5));
    }
    if (!paramSet.contains("menuItem:openWithSafari")) {
      localArrayList1.add(Integer.valueOf(4));
    }
    ArrayList localArrayList2 = new ArrayList();
    if (!paramSet.contains("menuItem:screenShotShare")) {
      localArrayList2.add(Integer.valueOf(21));
    }
    if (!paramSet.contains("menuItem:copyUrl")) {
      localArrayList2.add(Integer.valueOf(1));
    }
    if (!paramSet.contains("menuItem:exposeArticle")) {
      localArrayList2.add(Integer.valueOf(11));
    }
    Collections.sort(localArrayList2);
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new tka(this);
    WXShareHelper.getInstance().addObserver(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing()))
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      }
      this.jdField_a_of_type_Bhht.dismiss();
    }
  }
  
  int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    default: 
      return -1;
    case 2: 
      return 0;
    case 3: 
      return 1;
    case 9: 
      return 2;
    case 10: 
      return 3;
    case 12: 
      return 4;
    case 13: 
      return 7;
    }
    return 8;
  }
  
  public void a()
  {
    WXShareHelper.getInstance().removeObserver(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, Activity paramActivity, String paramString1, int paramInt2, String paramString2)
  {
    AppInterface localAppInterface = (AppInterface)pay.a();
    String str4;
    String str5;
    String str3;
    String str2;
    String str6;
    String str1;
    String str7;
    String str8;
    String str9;
    int i;
    int j;
    boolean bool;
    for (;;)
    {
      try
      {
        paramJSONObject.optString("source_name", "QQ浏览器");
        str4 = paramJSONObject.optString("title");
        str5 = paramJSONObject.optString("desc");
        str3 = paramJSONObject.optString("share_url");
        str2 = paramJSONObject.optString("aio_share_url");
        str6 = paramJSONObject.optString("qzone_share_url");
        str1 = paramJSONObject.optString("image_url");
        str7 = paramJSONObject.optString("flash_url");
        str8 = paramJSONObject.optString("shareText");
        str9 = paramJSONObject.optString("shouldSharePlainTextChannel");
        if (paramJSONObject.optInt("hideSuccessToast") != 1) {
          break label886;
        }
        i = 1;
        j = paramJSONObject.optInt("shareQQType", 13);
        if (paramInt1 != 72) {
          break;
        }
        paramJSONObject.put("toUin", paramString1);
        paramJSONObject.put("uinType", paramInt2);
        paramJSONObject.put("friendName", paramString2);
        if ((str2 == null) || (!str2.contains("kandianshare.html5.qq.com"))) {
          break label898;
        }
        if (i != 0) {
          break label892;
        }
        bool = true;
        label184:
        a(paramActivity, paramJSONObject, str4, str5, str2, str1, "news", str7, j, bool);
        return;
      }
      catch (Exception paramJSONObject)
      {
        label208:
        paramJSONObject.printStackTrace();
        return;
      }
      a(paramActivity, paramJSONObject, str4, str5, str3, str1, "news", str7, j, bool);
      return;
      label238:
      bool = false;
    }
    if ((paramInt1 == 2) || (paramInt1 == 73))
    {
      if ((str2 == null) || (!str2.contains("kandianshare.html5.qq.com"))) {
        break label915;
      }
      if (i == 0)
      {
        bool = true;
        label279:
        a(paramActivity, paramJSONObject, str4, str5, str2, str1, "news", str7, j, bool);
        return;
        label303:
        a(paramActivity, paramJSONObject, str4, str5, str3, str1, "news", str7, j, bool);
      }
    }
    else
    {
      if (paramInt1 != 3) {
        break label932;
      }
      paramString1 = new Bundle();
      paramString1.putString("title", str4);
      paramString1.putString("desc", str5);
      if ((str6 != null) && (str6.contains("kandianshare.html5.qq.com"))) {
        paramString1.putString("detail_url", str6);
      }
      for (;;)
      {
        paramString1.putString("from", "qq");
        paramString1.putString("default_text", paramJSONObject.optString("default_text"));
        paramJSONObject = new ArrayList(1);
        paramJSONObject.add(str1);
        paramString1.putStringArrayList("image_url", paramJSONObject);
        paramString1.putLong("req_share_id", 0L);
        paramString1.putInt("iUrlInfoFrm", 1);
        paramString1.putLong("share_begin_time", bgww.b);
        if (QZoneShareManager.jumpToQzoneShare(localAppInterface, paramActivity, paramString1, null, 125)) {
          break;
        }
        yyi.a(1, 2131689486);
        return;
        paramString1.putString("detail_url", str3);
      }
    }
    label898:
    label915:
    label932:
    for (;;)
    {
      label502:
      a(paramJSONObject, paramInt1, localAppInterface, str4, str5, a(paramJSONObject, str3, paramInt1), str1, str8, str9);
      return;
      label886:
      label892:
      do
      {
        if (paramInt1 == 12)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
          }
          if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str3)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
            }
            QQToast.a(BaseActivity.sTopActivity, 0, 2131718380, 0).b(BaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131299076));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
          }
          try
          {
            paramJSONObject = URLEncoder.encode(str4, "UTF-8");
            paramString2 = "https://v.t.sina.com.cn/share/share.php?" + "title=" + paramJSONObject;
            paramString1 = URLEncoder.encode(str3, "UTF-8");
            paramJSONObject = paramString1;
            if (str2 != null)
            {
              paramJSONObject = paramString1;
              if (str2.contains("kandianshare.html5.qq.com")) {
                paramJSONObject = URLEncoder.encode(str2, "UTF-8");
              }
            }
            paramJSONObject = paramString2 + "&url=" + paramJSONObject;
            paramString1 = URLEncoder.encode(str1, "UTF-8");
            paramJSONObject = paramJSONObject + "&pic=" + paramString1;
            paramJSONObject = paramJSONObject + "&_wv=3";
            paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
            paramString1.putExtra("url", paramJSONObject);
            paramActivity.startActivity(paramString1);
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
            }
          }
          catch (Exception paramJSONObject)
          {
            for (;;)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131718380, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299076));
              paramJSONObject.printStackTrace();
            }
          }
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
            return;
          }
        }
        return;
        i = 0;
        break;
        bool = false;
        break label184;
        if (i != 0) {
          break label238;
        }
        bool = true;
        break label208;
        bool = false;
        break label279;
        if (i == 0)
        {
          bool = true;
          break label303;
        }
        bool = false;
        break label303;
        if (paramInt1 == 9) {
          break label502;
        }
      } while (paramInt1 != 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tjz
 * JD-Core Version:    0.7.0.1
 */