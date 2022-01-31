import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ylr
{
  protected static ylr a;
  protected SessionInfo a;
  protected HashMap<String, yls> a;
  
  public ylr()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static ylr a()
  {
    if (jdField_a_of_type_Ylr == null) {
      jdField_a_of_type_Ylr = new ylr();
    }
    return jdField_a_of_type_Ylr;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    azmj.a(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_app", paramString2, 0, 0, paramString1, paramString3, paramString4, paramString5);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    yls localyls = (yls)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localyls == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    if (!ylq.b(paramContext, localyls.b, paramString1, "android.intent.action.VIEW", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"))
    {
      if (!ylq.b(paramContext, localyls.c, paramString1, "android.intent.action.VIEW", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"))
      {
        paramSessionInfo = new Intent(paramContext, QQBrowserActivity.class);
        if ((localyls != null) && (!TextUtils.isEmpty(localyls.jdField_a_of_type_JavaLangString))) {
          paramSessionInfo.putExtra("url", localyls.jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          paramContext.startActivity(paramSessionInfo);
          a(paramString1, "app_click_ver", "2", "", "");
          return;
          paramSessionInfo.putExtra("url", paramString2);
        }
      }
      a(paramString1, "app_click_ver", "0", "", "");
      return;
    }
    a(paramString1, "app_click_ver", "1", "", "");
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!"thridapp".equals(paramIntent.getStringExtra("share_from"))) {
      bool1 = false;
    }
    Object localObject;
    Long localLong;
    do
    {
      do
      {
        return bool1;
        paramIntent.removeExtra("share_from");
        localObject = a();
        localLong = Long.valueOf(paramIntent.getLongExtra("req_share_id", 0L));
        bool1 = bool2;
      } while (!((ylr)localObject).a(String.valueOf(localLong)));
      paramIntent.putExtra("share_from_aio", true);
      paramIntent.putExtra("forward_type", 11);
      paramIntent.putExtra("req_type", 1);
      if (!paramIntent.hasExtra("pkg_name")) {
        paramIntent.putExtra("pkg_name", "");
      }
      paramIntent.putExtra("refuse_show_share_result_dialog", true);
      localObject = ((ylr)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      bool1 = bool2;
    } while (localObject == null);
    paramIntent = arwu.a(paramIntent, paramQQAppInterface, paramActivity);
    paramActivity = new Bundle();
    paramActivity.putString("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
    paramActivity.putInt("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
    paramActivity.putString("troop_uin", ((SessionInfo)localObject).b);
    paramActivity.putString("uinname", ((SessionInfo)localObject).d);
    paramIntent.a(aruc.a.intValue(), paramActivity);
    a(String.valueOf(localLong), "app_share_view", "", "", "");
    return true;
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    Object localObject2 = myl.a().a("aio_pluginApp", "");
    Object localObject1 = null;
    try
    {
      localObject2 = new JSONArray((String)localObject2);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        try
        {
          localObject2 = localObject1.getJSONObject(i);
          str = ((JSONObject)localObject2).optString("appid");
          localyls = new yls(this);
          localyls.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("downloadLink");
          localyls.b = String.format("tencent%s.provider://", new Object[] { str });
          localyls.c = ((JSONObject)localObject2).optString("defaultScheme_a");
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localyls);
          i += 1;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("show3rdApp", 2, "get JsonObject error!");
        }
        localJSONException2 = localJSONException2;
        localJSONException2.printStackTrace();
      }
    }
    if ((localObject1 != null) && (localObject1.length() > 0))
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      j = localObject1.length();
      i = 0;
      if (i >= j) {}
    }
    while (!QLog.isColorLevel())
    {
      int j;
      int i;
      String str;
      yls localyls;
      return;
    }
    QLog.d("show3rdApp", 2, "config is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ylr
 * JD-Core Version:    0.7.0.1
 */