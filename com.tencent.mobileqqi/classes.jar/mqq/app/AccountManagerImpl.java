package mqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.AccountManager;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;

public class AccountManagerImpl
  implements AccountManager
{
  private final AppRuntime app;
  
  public AccountManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void changeToken(HashMap<String, Object> paramHashMap, AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1032);
    localNewIntent.putExtra("mapSt", paramHashMap);
    localNewIntent.setObserver(paramAccountObserver);
    this.app.startServlet(localNewIntent);
  }
  
  public void deleteAccount(String paramString, AccountObserver paramAccountObserver)
  {
    MsfSdkUtils.delSimpleAccount(paramString);
    this.app.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    Object localObject = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    ((NewIntent)localObject).putExtra("action", 1007);
    ((NewIntent)localObject).putExtra("uin", paramString);
    ((NewIntent)localObject).setObserver(paramAccountObserver);
    ((NewIntent)localObject).runNow = true;
    ((NewIntent)localObject).withouLogin = true;
    this.app.startServlet((NewIntent)localObject);
    paramAccountObserver = this.app.getApplication().sortAccountList.iterator();
    while (paramAccountObserver.hasNext())
    {
      localObject = (SimpleAccount)paramAccountObserver.next();
      if (((SimpleAccount)localObject).getUin().equals(paramString)) {
        this.app.getApplication().sortAccountList.remove(localObject);
      }
    }
  }
  
  public void getKey(AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1030);
    localNewIntent.setObserver(paramAccountObserver);
    this.app.startServlet(localNewIntent);
  }
  
  public void onDestroy() {}
  
  public void queryUpSmsStat(AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1022);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
  
  public void sendRegistByPhoneNumber(byte paramByte, String paramString1, String paramString2, Long paramLong, AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1003);
    localNewIntent.putExtra("countryCode", paramString1);
    localNewIntent.putExtra("phoneNumber", paramString2);
    localNewIntent.putExtra("language", paramByte);
    localNewIntent.putExtra("appid", paramLong);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramAccountObserver);
    this.app.startServlet(localNewIntent);
  }
  
  public void sendRegistByResendSms(AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1020);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramAccountObserver);
    this.app.startServlet(localNewIntent);
  }
  
  public void sendRegisterByCommitSmsVerifycode(String paramString, AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1004);
    localNewIntent.putExtra("code", paramString);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
  
  public void sendRegisterBySetPass(String paramString1, String paramString2, String paramString3, AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1005);
    localNewIntent.putExtra("password", paramString1);
    localNewIntent.putExtra("nick", paramString2);
    localNewIntent.putExtra("code", paramString3);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.withouLogin = true;
    this.app.startServlet(localNewIntent);
  }
  
  public void sendRegisterQueryMobile(String paramString1, String paramString2, AccountObserver paramAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1041);
    localNewIntent.putExtra("countryCode", paramString1);
    localNewIntent.putExtra("phoneNumber", paramString2);
    localNewIntent.withouLogin = true;
    localNewIntent.setObserver(paramAccountObserver);
    this.app.startServlet(localNewIntent);
  }
  
  public void updateSKey(AccountObserver paramAccountObserver)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.app != null)
    {
      TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
      localObject1 = localObject2;
      if (localTicketManager != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.app.getAccount())) {
          localObject1 = localTicketManager.getSkey(this.app.getAccount());
        }
      }
    }
    if (paramAccountObserver != null) {
      paramAccountObserver.onUpdateSKey((String)localObject1, "");
    }
  }
  
  public void updateSTwxWeb(AccountObserver paramAccountObserver)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.app != null)
    {
      TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
      localObject1 = localObject2;
      if (localTicketManager != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.app.getAccount())) {
          localObject1 = localTicketManager.getStweb(this.app.getAccount());
        }
      }
    }
    if (paramAccountObserver != null) {
      paramAccountObserver.onUpdateSTwxWeb((String)localObject1);
    }
  }
  
  public void updateSid(AccountObserver paramAccountObserver)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.app != null)
    {
      TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
      localObject1 = localObject2;
      if (localTicketManager != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.app.getAccount())) {
          localObject1 = localTicketManager.getSid(this.app.getAccount());
        }
      }
    }
    if (paramAccountObserver != null) {
      paramAccountObserver.onUpdateSid((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.AccountManagerImpl
 * JD-Core Version:    0.7.0.1
 */