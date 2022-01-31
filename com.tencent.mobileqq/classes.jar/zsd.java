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

public class zsd
  extends zrw
{
  protected armr a;
  private String jdField_c_of_type_JavaLangString = "doraemon_user_permission_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
  private Map<String, Integer> jdField_c_of_type_JavaUtilMap = new HashMap();
  private String d;
  private String e;
  private String f;
  
  public zsd(Activity paramActivity, int paramInt, String paramString)
  {
    super(paramActivity, paramInt, paramString);
  }
  
  private int a(zsc paramzsc)
  {
    Integer localInteger2 = (Integer)this.jdField_c_of_type_JavaUtilMap.get(paramzsc.jdField_a_of_type_JavaLangString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      if (BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).getLong(this.b + "_" + paramzsc.jdField_a_of_type_JavaLangString + "_2", 0L) <= NetConnInfoCenter.getServerTimeMillis()) {
        break label106;
      }
    }
    label106:
    for (localInteger1 = Integer.valueOf(2);; localInteger1 = Integer.valueOf(0))
    {
      this.jdField_c_of_type_JavaUtilMap.put(paramzsc.jdField_a_of_type_JavaLangString, localInteger1);
      return localInteger1.intValue();
    }
  }
  
  private void a(zsc paramzsc, int paramInt)
  {
    if (2 == paramInt)
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_c_of_type_JavaLangString, 4).edit().putLong(this.b + "_" + paramzsc.jdField_a_of_type_JavaLangString + "_2", l + 2592000000L).apply();
    }
    this.jdField_c_of_type_JavaUtilMap.put(paramzsc.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
  }
  
  public armr a()
  {
    return this.jdField_a_of_type_Armr;
  }
  
  public String a()
  {
    if (this.e == null) {
      return MobileQQ.getContext().getPackageName();
    }
    return this.e;
  }
  
  protected Map<String, zru> a()
  {
    return zuf.a();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
  }
  
  protected void a(zru paramzru, JSONObject paramJSONObject, zrt paramzrt)
  {
    zsc localzsc;
    Object localObject2;
    Object localObject1;
    switch (paramzru.b)
    {
    default: 
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "unsupport auth type " + paramzru.b);
      a(6, paramzru, paramJSONObject, paramzrt);
      return;
    case 0: 
      a(0, paramzru, paramJSONObject, paramzrt);
      return;
    case 1: 
      localzsc = zsi.a().a(paramzru.jdField_a_of_type_JavaLangString);
      if (localzsc == null)
      {
        a(1, paramzru, paramJSONObject, paramzrt);
        return;
      }
      int i = a(localzsc);
      if (i == 1)
      {
        a(4, paramzru, paramJSONObject, paramzrt);
        return;
      }
      if (i == 2)
      {
        a(0, paramzru, paramJSONObject, paramzrt);
        return;
      }
      localObject2 = a();
      if (localObject2 == null)
      {
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = BaseApplicationImpl.getApplication().getResources().getString(2131629247);
      }
      break;
    }
    label352:
    for (;;)
    {
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((armr)localObject2).jdField_c_of_type_JavaLangString)
      {
        a((String)localObject1, (String)localObject2, BaseApplicationImpl.getApplication().getResources().getString(2131629246, new Object[] { localObject1 }), localzsc.b, BaseApplicationImpl.getApplication().getResources().getString(2131654987), new zsf(this, localzsc, paramzru, paramJSONObject, paramzrt), BaseApplicationImpl.getApplication().getResources().getString(2131654990), new zsg(this, localzsc, paramzru, paramJSONObject, paramzrt), new zsh(this, localzsc, paramzru, paramJSONObject, paramzrt));
        return;
        localObject1 = ((armr)localObject2).b;
        break;
      }
      localObject1 = (ztd)a(ztd.class, false);
      if ((localObject1 != null) && (((ztd)localObject1).a()))
      {
        a(0, paramzru, paramJSONObject, paramzrt);
        return;
      }
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "not login");
      a(5, paramzru, paramJSONObject, paramzrt);
      return;
    }
  }
  
  protected void c()
  {
    zsi.a().a(this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.d, this.e, this.f, new zse(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zsd
 * JD-Core Version:    0.7.0.1
 */