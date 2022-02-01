import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class skd
{
  protected static skd a;
  protected HashMap<String, skd.a> fL = new HashMap();
  protected SessionInfo mSessionInfo;
  
  public static skd a()
  {
    if (a == null) {
      a = new skd();
    }
    return a;
  }
  
  public static void i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    anot.c(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_app", paramString2, 0, 0, paramString1, paramString3, paramString4, paramString5);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, SessionInfo paramSessionInfo)
  {
    skd.a locala = (skd.a)this.fL.get(paramString1);
    if (locala == null) {
      return;
    }
    this.mSessionInfo = paramSessionInfo;
    if (!skc.b(paramContext, locala.aEq, paramString1, "android.intent.action.VIEW", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"))
    {
      if (!skc.b(paramContext, locala.aEr, paramString1, "android.intent.action.VIEW", "com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"))
      {
        paramSessionInfo = new Intent(paramContext, QQBrowserActivity.class);
        if ((locala != null) && (!TextUtils.isEmpty(locala.downloadUrl))) {
          paramSessionInfo.putExtra("url", locala.downloadUrl);
        }
        for (;;)
        {
          paramContext.startActivity(paramSessionInfo);
          i(paramString1, "app_click_ver", "2", "", "");
          return;
          paramSessionInfo.putExtra("url", paramString2);
        }
      }
      i(paramString1, "app_click_ver", "0", "", "");
      return;
    }
    i(paramString1, "app_click_ver", "1", "", "");
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
      } while (!((skd)localObject).fX(String.valueOf(localLong)));
      paramIntent.putExtra("share_from_aio", true);
      paramIntent.putExtra("forward_type", 11);
      paramIntent.putExtra("req_type", 1);
      if (!paramIntent.hasExtra("pkg_name")) {
        paramIntent.putExtra("pkg_name", "");
      }
      paramIntent.putExtra("refuse_show_share_result_dialog", true);
      localObject = ((skd)localObject).mSessionInfo;
      bool1 = bool2;
    } while (localObject == null);
    paramIntent = ahix.a(paramIntent, paramQQAppInterface, paramActivity);
    paramActivity = new Bundle();
    paramActivity.putString("uin", ((SessionInfo)localObject).aTl);
    paramActivity.putInt("uintype", ((SessionInfo)localObject).cZ);
    paramActivity.putString("troop_uin", ((SessionInfo)localObject).troopUin);
    paramActivity.putString("uinname", ((SessionInfo)localObject).aTn);
    paramIntent.H(ahgg.a.R.intValue(), paramActivity);
    i(String.valueOf(localLong), "app_share_view", "", "", "");
    return true;
  }
  
  public boolean fX(String paramString)
  {
    return this.fL.containsKey(paramString);
  }
  
  public void release()
  {
    this.mSessionInfo = null;
  }
  
  public class a
  {
    public String aEq;
    public String aEr;
    public String downloadUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skd
 * JD-Core Version:    0.7.0.1
 */