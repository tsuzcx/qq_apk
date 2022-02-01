package com.tencent.mobileqq.loginwelcome;

import aczc;
import aczc.b;
import ajrb;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import yuw;

public class LoginUserGuideHelper
{
  private static String a(boolean paramBoolean, LoginWelcomeManager.b paramb, a parama)
  {
    int k = 1;
    int j = 0;
    StringBuilder localStringBuilder1 = new StringBuilder(200);
    localStringBuilder1.append(paramb.url);
    StringBuilder localStringBuilder2 = localStringBuilder1.append("&ab_auth=");
    String str;
    int i;
    if (paramBoolean)
    {
      str = "1";
      localStringBuilder2.append(str);
      if (paramb.dfr != -1) {
        localStringBuilder1.append("&friends_recommend_flag=").append(paramb.dfr);
      }
      if (paramb.dfs != -1) {
        localStringBuilder1.append("&groups_recommend_flag=").append(paramb.dfs);
      }
      if ((parama == null) || (!parama.cma)) {
        break label196;
      }
      i = parama.latitude;
      j = parama.longitude;
    }
    for (;;)
    {
      if (k != 0) {
        localStringBuilder1.append("&lat=").append(i).append("&lng=").append(j);
      }
      if (QLog.isColorLevel()) {
        QLog.i("LoginUserGuideHelper", 2, "makeUrl: " + localStringBuilder1.toString());
      }
      return localStringBuilder1.toString();
      str = "0";
      break;
      label196:
      paramb = aczc.a("Login.Guide");
      if ((paramb != null) && (paramb.a != null))
      {
        j = (int)(paramb.a.cd * 1000000.0D);
        i = (int)(paramb.a.ce * 1000000.0D);
      }
      else
      {
        i = 0;
        k = 0;
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, a parama)
  {
    yuw.a(paramActivity, paramQQAppInterface, new GuideRunnable(paramActivity, paramQQAppInterface, true, parama), new GuideRunnable(paramActivity, paramQQAppInterface, false, parama));
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, a parama)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "openWebGuide hasAuth: " + paramBoolean);
    }
    paramQQAppInterface = a(paramBoolean, LoginWelcomeManager.a(paramQQAppInterface).a(), parama);
    parama = new Intent(paramActivity, QQBrowserActivity.class);
    parama.putExtra("is_wrap_content", true);
    parama.putExtra("url", paramQQAppInterface);
    parama.putExtra("hide_more_button", true);
    parama.putExtra("webStyle", "noBottomBar");
    parama.putExtra("isScreenOrientationPortrait", true);
    parama.addFlags(603979776);
    paramActivity.startActivity(parama);
  }
  
  public static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, a parama)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, "goWithoutFindFriend");
    }
    a(paramActivity, paramQQAppInterface, false, parama);
  }
  
  public static void e(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    yuw.a(paramActivity, paramQQAppInterface, new LoginUserGuideHelper.1(paramQQAppInterface), new DenyRunnable(paramActivity, new DenyRunnable.a(paramQQAppInterface)));
  }
  
  public static void p(String paramString, JSONObject paramJSONObject)
  {
    ajrb.a("upload_for_new_guide", paramString, 4).edit().putString("upload_for_new_guide", paramJSONObject.toString()).commit();
  }
  
  public static class GuideRunnable
    implements Runnable
  {
    private final LoginUserGuideHelper.a a;
    private final WeakReference<Activity> aG;
    private final boolean clZ;
    private final WeakReference<QQAppInterface> mAppRef;
    
    public GuideRunnable(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, LoginUserGuideHelper.a parama)
    {
      this.aG = new WeakReference(paramActivity);
      this.mAppRef = new WeakReference(paramQQAppInterface);
      this.clZ = paramBoolean;
      this.a = parama;
    }
    
    public void run()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.mAppRef.get();
      Activity localActivity = (Activity)this.aG.get();
      if ((localQQAppInterface == null) || (localActivity == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("LoginUserGuideHelper", 2, "GuideRunnable : " + this.clZ);
      }
      if (this.clZ) {
        ThreadManager.excute(new LoginUserGuideHelper.GuideRunnable.1(this, localQQAppInterface), 16, null, false);
      }
      LoginUserGuideHelper.a(localActivity, localQQAppInterface, this.clZ, this.a);
    }
  }
  
  public static class a
    extends aczc.b
  {
    public boolean cma;
    public int latitude;
    public int longitude;
    
    public a(String paramString)
    {
      super();
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        this.cma = true;
        this.longitude = ((int)(paramSosoLbsInfo.a.ce * 1000000.0D));
        this.latitude = ((int)(paramSosoLbsInfo.a.cd * 1000000.0D));
      }
      if (QLog.isColorLevel()) {
        QLog.i("LoginUserGuideHelper", 2, String.format("onLocationFinish [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.longitude), Integer.valueOf(this.latitude) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper
 * JD-Core Version:    0.7.0.1
 */