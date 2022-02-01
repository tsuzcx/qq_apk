package cooperation.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.util.QLog;
import ibu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QZoneShareManager
{
  public static final int a = 9;
  public static final String a = "qzone_uin";
  private static ConcurrentHashMap a = new ConcurrentHashMap();
  public static final int b = 55555;
  public static final String b = "share_data";
  public static final int c = 55556;
  public static final String c = "key_share_is_third_party";
  public static final int d = 55557;
  public static final int e = 55558;
  public static final int f = 30;
  public static final int g = 40;
  public static final int h = -1;
  public static final int i = -11210;
  public static final int j = -11207;
  public static final int k = -11215;
  public static final int l = -2;
  public static final int m = 15790320;
  
  public static final long a(Intent paramIntent)
  {
    long l1 = 0L;
    paramIntent = paramIntent.getBundleExtra("share_data");
    if (paramIntent != null) {
      l1 = paramIntent.getLong("req_share_id", 0L);
    }
    return l1;
  }
  
  public static final Bundle a(Bundle paramBundle)
  {
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if (localArrayList != null)
    {
      int n = localArrayList.size() - 1;
      while (n >= 0)
      {
        String str = (String)localArrayList.get(n);
        if ((!HttpUtil.a(str)) && (!FileUtil.a(str))) {
          localArrayList.remove(n);
        }
        n -= 1;
      }
      while (localArrayList.size() > 9) {
        localArrayList.remove(9);
      }
      if (localArrayList.size() > 0)
      {
        if (HttpUtil.a((String)localArrayList.get(0)))
        {
          n = localArrayList.size() - 1;
          while (n >= 0)
          {
            if (!HttpUtil.a((String)localArrayList.get(n))) {
              localArrayList.remove(n);
            }
            n -= 1;
          }
        }
        n = localArrayList.size() - 1;
        while (n >= 0)
        {
          if (n != 0) {
            localArrayList.remove(n);
          }
          n -= 1;
        }
      }
      paramBundle.putStringArrayList("image_url", localArrayList);
    }
    return paramBundle;
  }
  
  public static OpenID a(AppRuntime paramAppRuntime, String paramString, BusinessObserver paramBusinessObserver)
  {
    Object localObject = (OpenID)a.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("openid", 2, "get openid key = " + paramString);
    }
    paramAppRuntime = (AccountManager)paramAppRuntime.getManager(0);
    localObject = new HashMap();
    RequestCustomSig localRequestCustomSig = new RequestCustomSig();
    localRequestCustomSig.ulCustumFlag = 8192L;
    localRequestCustomSig.ulSType = 1L;
    localRequestCustomSig.reserved = new byte[0];
    ((HashMap)localObject).put("RequestCustomSig", localRequestCustomSig);
    ((HashMap)localObject).put("OpenAppid", paramString);
    paramAppRuntime.changeToken((HashMap)localObject, new ibu(paramString, paramBusinessObserver));
    return null;
  }
  
  public static final ArrayList a(ArrayList paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return paramArrayList;
      int n = 0;
      while (n < paramArrayList.size())
      {
        Object localObject = (String)paramArrayList.get(n);
        if (FileUtil.a((String)localObject))
        {
          HashMap localHashMap1 = new HashMap();
          localHashMap1.put("Connection", "keep-alive");
          localHashMap1.put("Referer", "http://www.qq.com");
          HashMap localHashMap2 = new HashMap();
          localHashMap2.put("type", paramString3);
          HashMap localHashMap3 = new HashMap();
          localHashMap3.put("share_image", localObject);
          localObject = HttpUtil.a("http://cgi.connect.qq.com/qqconnectopen/upload_share_image", paramString1, paramString2, localHashMap2, localHashMap3, localHashMap1);
          if (localObject == null) {}
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).getInt("retcode") == 0)
          {
            localObject = ((JSONObject)localObject).getJSONObject("result");
            if (localObject != null) {
              paramArrayList.set(n, ((JSONObject)localObject).getString("url"));
            }
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("zivonchen", 4, localJSONException.getMessage());
            }
          }
        }
        n += 1;
      }
    }
  }
  
  public static final boolean a(AppInterface paramAppInterface, Context paramContext, Bundle paramBundle, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (paramBundle == null) {
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("qzone_uin", paramAppInterface.getAccount());
    localIntent.putExtra("sid", paramAppInterface.getSid());
    localIntent.putExtra("key_share_is_third_party", true);
    localIntent.putExtra("share_data", paramBundle);
    localIntent.addFlags(67108864);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    com.tencent.mobileqq.app.PhoneContactManagerImp.c = true;
    try
    {
      paramBundle = QZoneHelper.UserInfo.a();
      paramBundle.a = paramAppInterface.a();
      paramBundle.c = paramAppInterface.getSid();
      QZoneHelper.a((Activity)paramContext, paramBundle, localIntent, -1, paramOnDismissListener);
      return true;
    }
    catch (Exception paramAppInterface)
    {
      for (;;)
      {
        paramAppInterface = new Intent(paramContext, TranslucentActivity.class);
        paramAppInterface.addFlags(268435456);
        paramAppInterface.putExtras(localIntent);
        paramContext.startActivity(paramAppInterface);
      }
    }
  }
  
  public static final Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("desc");
    ArrayList localArrayList = paramBundle.getStringArrayList("image_url");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (localArrayList != null) && (!localArrayList.isEmpty())) {
      paramBundle.remove("detail_url");
    }
    a(paramBundle);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneShareManager
 * JD-Core Version:    0.7.0.1
 */