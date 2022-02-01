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

public class oft
{
  private static volatile oft jdField_a_of_type_Oft;
  private static int beJ;
  private tzg jdField_a_of_type_Tzg;
  private volatile boolean awS;
  private Map<Long, oft.a> mCache = new HashMap();
  
  private oft()
  {
    bem();
  }
  
  private boolean GH()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        long l1 = opn.dt();
        Object localObject1 = this.mCache.get(Long.valueOf(l1));
        if (localObject1 != null) {
          return bool;
        }
        long l2 = System.currentTimeMillis();
        long l3 = LocalMultiProcConfig.getLong4Uin("key_qq_connect_auth_time", 0L, l1);
        ooz.bY("WSQQConnectAuthManager", "now qq connect auth time diff (sec) = " + (l2 - l3) / 1000L);
        if (l2 - l3 > 1728000000L)
        {
          bool = false;
        }
        else
        {
          localObject1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_open_id", "", l1);
          String str1 = LocalMultiProcConfig.getString4Uin("key_qq_connect_access_token", "", l1);
          String str2 = auro.decode((String)localObject1, opn.lL());
          String str3 = auro.decode(str1, opn.lL());
          ooz.bZ("weishi-828", "use sp openId and accessToken encrypted:" + (String)localObject1 + " , " + str1 + ", decrypt:" + str2 + " , " + str3);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            this.mCache.put(Long.valueOf(opn.dt()), new oft.a(str2, str3));
          } else {
            bool = false;
          }
        }
      }
      finally {}
    }
  }
  
  private oft.a a()
  {
    if (this.mCache != null) {
      return (oft.a)this.mCache.get(Long.valueOf(opn.dt()));
    }
    return null;
  }
  
  public static oft a()
  {
    if (jdField_a_of_type_Oft == null) {}
    try
    {
      if (jdField_a_of_type_Oft == null) {
        jdField_a_of_type_Oft = new oft();
      }
      return jdField_a_of_type_Oft;
    }
    finally {}
  }
  
  private void aj(JSONObject paramJSONObject)
  {
    beJ = 0;
    String str = paramJSONObject.optString("openid");
    paramJSONObject = paramJSONObject.optString("access_token");
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramJSONObject))) {
      this.mCache.put(Long.valueOf(opn.dt()), new oft.a(str, paramJSONObject));
    }
    str = auro.encode(str, opn.lL());
    paramJSONObject = auro.encode(paramJSONObject, opn.lL());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_open_id", str, opn.dt());
    LocalMultiProcConfig.putString4Uin("key_qq_connect_access_token", paramJSONObject, opn.dt());
    LocalMultiProcConfig.putLong4Uin("key_qq_connect_auth_time", System.currentTimeMillis(), opn.dt());
  }
  
  private void ben()
  {
    if (!this.awS)
    {
      this.awS = true;
      tzk.prepare();
      this.jdField_a_of_type_Tzg = tzk.a(l(), 6, String.valueOf(1101083114));
      if (this.jdField_a_of_type_Tzg != null) {
        this.jdField_a_of_type_Tzg.a("loginSilent", null, new ofu(this));
      }
    }
  }
  
  private void bep()
  {
    beJ += 1;
    ooz.ca("WSQQConnectAuthManager", "authRetry: " + beJ);
    if (beJ >= 3)
    {
      beJ = 0;
      return;
    }
    ben();
  }
  
  private Activity l()
  {
    Activity localActivity = null;
    if (SplashActivity.dO != null) {
      localActivity = (Activity)SplashActivity.dO.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  @NotNull
  public stAuth a(String paramString1, String paramString2)
  {
    oft.a locala = a();
    if (locala != null)
    {
      ooz.bZ("weishi-828", "use memory openId and accessToken" + locala.openId + " , " + locala.accessToken);
      return new stAuth(1, locala.openId, locala.accessToken);
    }
    if (GH())
    {
      locala = a();
      if (locala != null)
      {
        ooz.bZ("weishi-828", "use memory openId and accessToken" + locala.openId + " , " + locala.accessToken);
        return new stAuth(1, locala.openId, locala.accessToken);
      }
    }
    ooz.ca("weishi-828", "未获取到openId和accessToken，使用了兜底方案");
    ben();
    return new stAuth(2, paramString1, paramString2);
  }
  
  public void bem()
  {
    if (!GH()) {
      ben();
    }
  }
  
  public void beo()
  {
    this.awS = false;
    ben();
  }
  
  public static class a
  {
    public String accessToken;
    public String openId;
    
    public a(String paramString1, String paramString2)
    {
      this.openId = paramString1;
      this.accessToken = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oft
 * JD-Core Version:    0.7.0.1
 */