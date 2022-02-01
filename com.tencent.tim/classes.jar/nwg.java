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
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class nwg
{
  public static String TAG = "QShareUtils";
  private String Qt;
  private WXShareHelper.a a;
  private arhz m;
  
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
  
  private void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
    throws JSONException
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
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131698632, new Object[] { str1 }));
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
        break label771;
      }
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    long l;
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
      l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break label811;
      }
      paramJSONObject = (AppInterface)kxm.getAppRuntime();
      if (paramJSONObject != null)
      {
        aT(paramActivity);
        if (!this.m.isShowing())
        {
          this.m.setMessage(2131695695);
          this.m.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        svi.a(paramJSONObject, paramActivity, paramJSONObject.getAccount(), l, 3000L, new nwi(this, localIntent, paramActivity));
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
      break;
      label771:
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    label811:
    aT(paramActivity);
    if ((this.m != null) && (this.m.isShowing()))
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "dialog dimiss time :" + l);
      }
      this.m.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    label1032:
    label1071:
    label1081:
    label1091:
    label1748:
    label1761:
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = (AppInterface)kxm.getAppRuntime();
        paramString2 = paramString2.getEntityManagerFactory(paramString2.getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.find(AccountDetail.class, paramString1);
        paramString2.close();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1790;
          }
        }
      }
      label1653:
      label1783:
      label1790:
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
          if (paramString2.equalsIgnoreCase(paramActivity.getString(2131701894)))
          {
            paramBoolean = paramString2.equalsIgnoreCase(paramActivity.getString(2131701894));
            if (paramBoolean)
            {
              paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!paramBoolean) {
                break label1293;
              }
              paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!paramBoolean) {
                break label1301;
              }
              paramString5 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString3);
              localIntent.putExtra("struct_share_key_source_icon", paramString5);
              localIntent.putExtra("app_name", paramString2);
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1748;
              }
              localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
            }
          }
          for (;;)
          {
            paramJSONObject = anre.a(localIntent.getExtras());
            if (paramJSONObject != null) {
              break label1761;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(TAG, 2, "build struct msg fail");
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
              break label1783;
            }
            paramString2 = paramString1;
            break label1032;
            paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label1071;
            paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label1081;
            paramString5 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label1091;
            paramString3 = paramJSONObject.optString("src_iconUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            paramString6 = paramJSONObject.optString("src_a_actionData", "");
            str1 = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(str1)))))
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
              paramString1 = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramString1)) {
                break label1653;
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
                if (!TextUtils.isEmpty(paramString6)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                }
                if (!TextUtils.isEmpty(str1)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", str1);
                }
              }
            }
            localIntent.putExtra("struct_share_key_source_icon", paramString1);
            break label1166;
            if (paramJSONObject.has("source_name"))
            {
              paramString1 = paramJSONObject.optString("source_name");
              localIntent.putExtra("app_name", paramString1);
              if ((!"手Q阅读".equals(paramString1)) || (!paramJSONObject.has("srcIconUrl"))) {
                break label1166;
              }
              localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              break label1166;
            }
            localIntent.putExtra("app_name", paramActivity.getString(2131698649));
            break label1166;
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
          }
          localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
          paramActivity.startActivityForResult(localIntent, 21);
          return;
          paramString2 = paramString3;
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, int paramInt, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap(1);
    int i = -1;
    if ((paramInt != 9) || (!WXShareHelper.a().isWXinstalled())) {
      i = 2131721935;
    }
    while (i != -1)
    {
      rwt.ez(0, i);
      return;
      if (!WXShareHelper.a().isWXsupportApi()) {
        i = 2131721936;
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
      bbE();
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
  
  private void aT(Activity paramActivity)
  {
    if (this.m == null) {
      this.m = new arhz(paramActivity);
    }
  }
  
  private void bbE()
  {
    if (this.a != null) {
      return;
    }
    this.a = new nwh(this);
    WXShareHelper.a().a(this.a);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, Activity paramActivity, String paramString1, int paramInt2, String paramString2)
  {
    AppInterface localAppInterface = (AppInterface)kxm.getAppRuntime();
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
          break label875;
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
          break label887;
        }
        if (i != 0) {
          break label881;
        }
        bool = true;
        label178:
        a(paramActivity, paramJSONObject, str4, str5, str2, str1, "news", str7, j, bool);
        return;
      }
      catch (Exception paramJSONObject)
      {
        label202:
        paramJSONObject.printStackTrace();
        return;
      }
      a(paramActivity, paramJSONObject, str4, str5, str3, str1, "news", str7, j, bool);
      return;
      label232:
      bool = false;
    }
    if ((paramInt1 == 2) || (paramInt1 == 73))
    {
      if ((str2 == null) || (!str2.contains("kandianshare.html5.qq.com"))) {
        break label904;
      }
      if (i == 0)
      {
        bool = true;
        label273:
        a(paramActivity, paramJSONObject, str4, str5, str2, str1, "news", str7, j, bool);
        return;
        label297:
        a(paramActivity, paramJSONObject, str4, str5, str3, str1, "news", str7, j, bool);
      }
    }
    else
    {
      if (paramInt1 != 3) {
        break label921;
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
        paramString1.putLong("share_begin_time", arbt.In);
        if (avqq.a(localAppInterface, paramActivity, paramString1, null, 125)) {
          break;
        }
        rwt.ez(1, 2131689537);
        return;
        paramString1.putString("detail_url", str3);
      }
    }
    label904:
    label921:
    for (;;)
    {
      label491:
      a(paramJSONObject, paramInt1, localAppInterface, str4, str5, a(paramJSONObject, str3, paramInt1), str1, str8, str9);
      return;
      label875:
      label881:
      label887:
      do
      {
        if (paramInt1 == 12)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shareMsgToSina start!");
          }
          if ((TextUtils.isEmpty(str4)) || (TextUtils.isEmpty(str3)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "shareMsgToSina empty title or share_url");
            }
            QQToast.a(BaseActivity.sTopActivity, 0, 2131720152, 0).show(BaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131299627));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "shareMsgToSina installSinaWeibo:false");
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
              QLog.d(TAG, 2, "shareMsgToSina start webview!");
            }
          }
          catch (Exception paramJSONObject)
          {
            for (;;)
            {
              QQToast.a(BaseApplication.getContext(), 0, 2131720152, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
              paramJSONObject.printStackTrace();
            }
          }
          if (QLog.isColorLevel())
          {
            QLog.d(TAG, 2, "shareMsgToSina end!");
            return;
          }
        }
        return;
        i = 0;
        break;
        bool = false;
        break label178;
        if (i != 0) {
          break label232;
        }
        bool = true;
        break label202;
        bool = false;
        break label273;
        if (i == 0)
        {
          bool = true;
          break label297;
        }
        bool = false;
        break label297;
        if (paramInt1 == 9) {
          break label491;
        }
      } while (paramInt1 != 10);
    }
  }
  
  public int dG(int paramInt)
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
  
  public void destroy()
  {
    WXShareHelper.a().b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwg
 * JD-Core Version:    0.7.0.1
 */