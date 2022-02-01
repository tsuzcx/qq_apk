import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class apqx
  implements Manager
{
  QQAppInterface app;
  public int dVq;
  public String description;
  Runnable hK = new ChangeMachineManager.2(this);
  public String jumpUrl;
  protected Handler mHandler;
  public String title;
  
  public apqx(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper());
    paramQQAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("ChangeMachine", 0);
    this.title = paramQQAppInterface.getString("title", null);
    this.description = paramQQAppInterface.getString("desc", null);
    this.dVq = paramQQAppInterface.getInt("resIconId", 0);
    this.jumpUrl = paramQQAppInterface.getString("url", null);
  }
  
  private void ebt()
  {
    acxw localacxw = this.app.a().a();
    Object localObject1 = localacxw.b(acbn.blB, 7440);
    if (localObject1 == null)
    {
      localObject1 = new RecentUser(acbn.blB, 7440);
      ((RecentUser)localObject1).lastmsgtime = (System.currentTimeMillis() / 1000L);
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("isRead", false);
        ((RecentUser)localObject1).msg = ((JSONObject)localObject2).toString();
        ((RecentUser)localObject1).msgData = ((JSONObject)localObject2).toString().getBytes();
        ((RecentUser)localObject1).msgType = 1;
        localObject2 = BaseApplicationImpl.getContext().getResources().getString(2131699504);
        if (!TextUtils.isEmpty(this.title)) {
          localObject2 = this.title;
        }
        ((RecentUser)localObject1).displayName = ((String)localObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      localacxw.e((RecentUser)localObject1);
      localObject1 = this.app.getHandler(Conversation.class);
      if (localObject1 != null) {
        ((MqqHandler)localObject1).sendEmptyMessage(1009);
      }
      anot.a(this.app, "dc00899", "huanjibao", "", "feeds", "view", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      return;
    }
  }
  
  private void ebu()
  {
    acxw localacxw = this.app.a().a();
    RecentUser localRecentUser = localacxw.b(acbn.blB, 7440);
    if (localRecentUser == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isRead", true);
      localRecentUser.msg = localJSONObject.toString();
      localacxw.e(localRecentUser);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void ebx()
  {
    BaseApplicationImpl.getContext().getSharedPreferences("ChangeMachine", 0).edit().putString("title", this.title).putString("desc", this.description).putInt("resIconId", this.dVq).putString("url", this.jumpUrl).commit();
  }
  
  public void Tz(String paramString)
  {
    int i = 1;
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("showMode");
      this.title = paramString.optString("title");
      this.description = paramString.optString("desc");
      this.dVq = paramString.optInt("icon");
      this.jumpUrl = paramString.optString("url");
      if (j == -2) {}
      while (i != 0)
      {
        ebv();
        anot.a(this.app, "dc00899", "huanjibao", "", "new_mobile", "request", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        return;
        if (j >= 0)
        {
          boolean bool = this.app.getCurrentAccountUin().endsWith(String.valueOf(j));
          if (bool) {}
        }
        else
        {
          i = 0;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.change_machine", 2, "parseSevletConfigContent JSONException", paramString);
      }
    }
  }
  
  public void ebv()
  {
    String str = getQimei();
    if (str == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putString("qimei", str);
    localBundle.putString("id", "13");
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", this.app.getApp().getApplicationContext());
    new aprc("https://innovate.qq.com/GetNewMachine", "GET", new apqy(this), 10001, null).J(localHashMap);
  }
  
  public void ebw()
  {
    this.mHandler.postDelayed(this.hK, 2000L);
  }
  
  public void fr(Context paramContext)
  {
    Object localObject2 = this.jumpUrl;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://qzs.qq.com/open/yyb/switch_phone/html/qq_cooperation.html";
    }
    localObject1 = aurr.addParameter(aurr.addParameter((String)localObject1, "qqnum", this.app.getCurrentAccountUin()), "qimei", getQimei());
    localObject2 = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    paramContext.startActivity((Intent)localObject2);
    ebu();
    anot.a(this.app, "dc00899", "huanjibao", "", "feeds", "click", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  protected String getQimei()
  {
    Object localObject = "";
    try
    {
      String str = UserAction.getQIMEI();
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.e(".troop.change_machine", 2, "get QIMI error");
    }
    return localObject;
    return "";
  }
  
  public int getResId()
  {
    switch (this.dVq)
    {
    default: 
      return 2130844632;
    case 2: 
      return 2130844633;
    case 3: 
      return 2130844634;
    }
    return 2130844635;
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null) {
      this.mHandler.removeCallbacks(this.hK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqx
 * JD-Core Version:    0.7.0.1
 */