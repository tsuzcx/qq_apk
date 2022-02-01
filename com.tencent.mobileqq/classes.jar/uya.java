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

public class uya
{
  private static int jdField_a_of_type_Int;
  private static volatile uya jdField_a_of_type_Uya;
  private adad jdField_a_of_type_Adad;
  private Map<Long, uyc> jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private uya()
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
  
  public static uya a()
  {
    if (jdField_a_of_type_Uya == null) {}
    try
    {
      if (jdField_a_of_type_Uya == null) {
        jdField_a_of_type_Uya = new uya();
      }
      return jdField_a_of_type_Uya;
    }
    finally {}
  }
  
  private uyc a()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return (uyc)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(vnd.a()));
    }
    return null;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    jdField_a_of_type_Int = 0;
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(vnd.a()), new uyc(str, paramJSONObject));
    }
    str = bkyl.a(str, vnd.a());
    paramJSONObject = bkyl.a(paramJSONObject, vnd.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", str, vnd.a());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", paramJSONObject, vnd.a());
    LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), vnd.a());
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        long l1 = vnd.a();
        Object localObject1 = this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l1));
        if (localObject1 != null) {
          return bool;
        }
        long l2 = System.currentTimeMillis();
        long l3 = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, l1);
        vmp.e("WSQQConnectAuthManager", "now qq connect auth time diff (sec) = " + (l2 - l3) / 1000L);
        if (l2 - l3 > 1728000000L)
        {
          bool = false;
        }
        else
        {
          localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l1);
          String str1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l1);
          String str2 = bkyl.b((String)localObject1, vnd.a());
          String str3 = bkyl.b(str1, vnd.a());
          vmp.f("weishi-828", "use sp openId and accessToken encrypted:" + (String)localObject1 + " , " + str1 + ", decrypt:" + str2 + " , " + str3);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(vnd.a()), new uyc(str2, str3));
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
      adai.a();
      this.jdField_a_of_type_Adad = adai.a(a(), 6, String.valueOf(1101083114));
      if (this.jdField_a_of_type_Adad != null) {
        this.jdField_a_of_type_Adad.a("loginSilent", null, new uyb(this));
      }
    }
  }
  
  private void d()
  {
    jdField_a_of_type_Int += 1;
    vmp.g("WSQQConnectAuthManager", "authRetry: " + jdField_a_of_type_Int);
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
    uyc localuyc = a();
    if (localuyc != null)
    {
      vmp.f("weishi-828", "use memory openId and accessToken" + localuyc.a + " , " + localuyc.b);
      return new stAuth(1, localuyc.a, localuyc.b);
    }
    if (a())
    {
      localuyc = a();
      if (localuyc != null)
      {
        vmp.f("weishi-828", "use memory openId and accessToken" + localuyc.a + " , " + localuyc.b);
        return new stAuth(1, localuyc.a, localuyc.b);
      }
    }
    vmp.g("weishi-828", "未获取到openId和accessToken，使用了兜底方案");
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
 * Qualified Name:     uya
 * JD-Core Version:    0.7.0.1
 */