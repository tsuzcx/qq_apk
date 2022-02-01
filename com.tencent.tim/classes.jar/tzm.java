import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class tzm
  extends tzg
{
  protected ajcn a;
  private String aKl = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private String aKm;
  private Map<String, Integer> hb = new HashMap();
  private String mPkgName;
  private String mSignature;
  
  public tzm(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(tzl paramtzl)
  {
    Integer localInteger2 = (Integer)this.hb.get(paramtzl.key);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.aKl, 4).getLong(this.mUniqueKey + "_" + paramtzl.key + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.hb.put(paramtzl.key, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(tzl paramtzl, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.aKl, 4).edit().putLong(this.mUniqueKey + "_" + paramtzl.key + "_2", l + 2592000000L).apply();
    }
    this.hb.put(paramtzl.key, Integer.valueOf(paramInt));
  }
  
  protected Map<String, tze> V()
  {
    return ubc.a.a.get();
  }
  
  public void Z(String paramString1, String paramString2, String paramString3)
  {
    this.aKm = paramString1;
    this.mPkgName = paramString2;
    this.mSignature = paramString3;
  }
  
  public ajcn a()
  {
    return this.a;
  }
  
  protected void a(tze paramtze, JSONObject paramJSONObject, tzd paramtzd)
  {
    tzl localtzl;
    Object localObject2;
    Object localObject1;
    switch (paramtze.bDn)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramtze.bDn);
      a(6, paramtze, paramJSONObject, paramtzd);
      return;
    case 0: 
      a(0, paramtze, paramJSONObject, paramtzd);
      return;
    case 1: 
      localtzl = tzr.a().a(paramtze.apiName);
      if (localtzl == null)
      {
        a(1, paramtze, paramJSONObject, paramtzd);
        return;
      }
      int i = a(localtzl);
      if (i == 1)
      {
        a(4, paramtze, paramJSONObject, paramtzd);
        return;
      }
      if (i == 2)
      {
        a(0, paramtze, paramJSONObject, paramtzd);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131696687);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((ajcn)localObject2).iconUrl)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131696686, new Object[] { localObject1 }), localtzl.displayName, BaseApplicationImpl.getApplication().getResources().getString(2131721897), new tzo(this, localtzl, paramtze, paramJSONObject, paramtzd), BaseApplicationImpl.getApplication().getResources().getString(2131721908), new tzp(this, localtzl, paramtze, paramJSONObject, paramtzd), new tzq(this, localtzl, paramtze, paramJSONObject, paramtzd));
        return;
        localObject1 = ((ajcn)localObject2).appName;
        break;
      }
      localObject1 = (uag)a(uag.class, false);
      if ((localObject1 != null) && (((uag)localObject1).isLogin()))
      {
        a(0, paramtze, paramJSONObject, paramtzd);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramtze, paramJSONObject, paramtzd);
      return;
    }
  }
  
  protected void bFd()
  {
    tzr.a().a(this.mUniqueKey, this.bDo, this.mAppid, this.aKm, this.mPkgName, this.mSignature, new tzn(this));
  }
  
  public String oH()
  {
    if (this.mPkgName == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.mPkgName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzm
 * JD-Core Version:    0.7.0.1
 */