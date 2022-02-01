import NS_KING_PUBLIC.stAuth;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class ukd
{
  private static int jdField_a_of_type_Int;
  private static volatile ukd jdField_a_of_type_Ukd;
  private acju jdField_a_of_type_Acju;
  private Map<Long, ukf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private ukd()
  {
    a();
  }
  
  private Activity a()
  {
    Activity localActivity = null;
    if (SplashActivity.a != null) {
      localActivity = (Activity)SplashActivity.a.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  public static ukd a()
  {
    if (jdField_a_of_type_Ukd == null) {}
    try
    {
      if (jdField_a_of_type_Ukd == null) {
        jdField_a_of_type_Ukd = new ukd();
      }
      return jdField_a_of_type_Ukd;
    }
    finally {}
  }
  
  private ukf a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (ukf)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(uyo.a()));
    }
    return null;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    jdField_a_of_type_Int = 0;
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(uyo.a()), new ukf(str, paramJSONObject));
    }
    str = bjmz.a(str, uyo.a());
    paramJSONObject = bjmz.a(paramJSONObject, uyo.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", str, uyo.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", paramJSONObject, uyo.a());
    LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), uyo.a());
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        long l1 = uyo.a();
        Object localObject1 = this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
        if (localObject1 != null) {
          return bool;
        }
        long l2 = System.currentTimeMillis();
        long l3 = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, l1);
        uya.e("WSQQConnectAuthManager", "now qq connect auth time diff (sec) = " + (l2 - l3) / 1000L);
        if (l2 - l3 > 1728000000L)
        {
          bool = false;
        }
        else
        {
          localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l1);
          String str1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l1);
          String str2 = bjmz.b((String)localObject1, uyo.a());
          String str3 = bjmz.b(str1, uyo.a());
          uya.f("weishi-828", "use sp openId and accessToken encrypted:" + (String)localObject1 + " , " + str1 + ", decrypt:" + str2 + " , " + str3);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(uyo.a()), new ukf(str2, str3));
          } else {
            bool = false;
          }
        }
      }
      finally {}
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      acjz.a();
      this.jdField_a_of_type_Acju = acjz.a(a(), 6, String.valueOf(1101083114));
      if (this.jdField_a_of_type_Acju != null) {
        this.jdField_a_of_type_Acju.a("loginSilent", null, new uke(this));
      }
    }
  }
  
  private void d()
  {
    jdField_a_of_type_Int += 1;
    uya.g("WSQQConnectAuthManager", "authRetry: " + jdField_a_of_type_Int);
    if (jdField_a_of_type_Int >= 3)
    {
      jdField_a_of_type_Int = 0;
      return;
    }
    c();
  }
  
  @NotNull
  public stAuth a(String paramString1, String paramString2)
  {
    ukf localukf = a();
    if (localukf != null)
    {
      uya.f("weishi-828", "use memory openId and accessToken" + localukf.a + " , " + localukf.b);
      return new stAuth(1, localukf.a, localukf.b);
    }
    if (a())
    {
      localukf = a();
      if (localukf != null)
      {
        uya.f("weishi-828", "use memory openId and accessToken" + localukf.a + " , " + localukf.b);
        return new stAuth(1, localukf.a, localukf.b);
      }
    }
    uya.g("weishi-828", "未获取到openId和accessToken，使用了兜底方案");
    c();
    return new stAuth(2, paramString1, paramString2);
  }
  
  public void a()
  {
    if (!a()) {
      c();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */