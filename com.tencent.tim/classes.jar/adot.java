import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class adot
  extends QIPCModule
{
  private static volatile adot a;
  private final HashMap<String, Class<? extends adot.g>> jF = new HashMap();
  
  private adot(String paramString)
  {
    super(paramString);
    register();
  }
  
  private adot.g a(String paramString)
  {
    Class localClass = (Class)this.jF.get(paramString);
    if (localClass == null)
    {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "createHandler fail, action=" + paramString);
      return null;
    }
    try
    {
      paramString = (adot.g)localClass.newInstance();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static adot a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new adot("ArkQQAPIIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  private static QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String getNickname(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new adow(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String getPSKey(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new adoz(paramString, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String getSKey()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new adoy(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private void register()
  {
    this.jF.put("QQ.GetUin", adot.e.class);
    this.jF.put("QQ.GetNickname", adot.b.class);
    this.jF.put("QQ.GetNicknameByView", adot.a.class);
    this.jF.put("QQ.GetSKey", adot.d.class);
    this.jF.put("QQ.GetPSKey", adot.c.class);
  }
  
  public static String sI()
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new adov(localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public static String u(String paramString, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    a().a(new adox(paramString, paramLong, localArrayList));
    if (localArrayList.size() > 0) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  public void a(adot.f paramf)
  {
    boolean bool = true;
    if (paramf == null)
    {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, method is null");
      return;
    }
    Object localObject = a(paramf.getMethod());
    if (localObject == null)
    {
      QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call, handler not found, method=" + paramf.getMethod());
      return;
    }
    if (((adot.g)localObject).afn())
    {
      localObject = QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramf.getMethod(), paramf.getArguments());
      if (((EIPCResult)localObject).code != 0) {
        QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "call.sync, method=" + paramf.getMethod() + " result=" + localObject);
      }
      if (((EIPCResult)localObject).code == 0) {}
      for (;;)
      {
        paramf.I(bool, ((EIPCResult)localObject).data);
        return;
        bool = false;
      }
    }
    QIPCClientHelper.getInstance().callServer("ArkQQAPIIPCModule", paramf.getMethod(), paramf.getArguments(), new adou(this, paramf));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    adot.g localg = a(paramString);
    if (localg != null)
    {
      paramString = localg.a(paramBundle);
      if (localg.afn()) {
        return paramString;
      }
      callbackResult(paramInt, paramString);
      return null;
    }
    QLog.i("ArkApp.ArkQQAPIIPCModule", 1, "onCall, invalid action, " + paramString);
    return null;
  }
  
  public static class a
    implements adot.g
  {
    private String h(QQAppInterface paramQQAppInterface, String paramString)
    {
      Object localObject = null;
      String str = null;
      SessionInfo localSessionInfo = adnq.b();
      if (!TextUtils.isEmpty(paramString))
      {
        if (localSessionInfo != null) {
          str = aqgv.a(paramQQAppInterface, localSessionInfo, paramString.equals(paramQQAppInterface.getCurrentUin()), paramString);
        }
        if (str != null)
        {
          localObject = str;
          if (!TextUtils.equals(str, paramString)) {}
        }
        else
        {
          str = aqgv.G(paramQQAppInterface, paramString);
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            localObject = aqgv.d(paramQQAppInterface, paramString, 0);
          }
        }
      }
      return localObject;
    }
    
    public EIPCResult a(Bundle paramBundle)
    {
      Object localObject = adot.c();
      if (localObject == null)
      {
        QLog.e("ArkApp.GetNicknameByViewHandler", 1, "Handler_GetNickName.onCall, qq app is null");
        return EIPCResult.createResult(-102, new Bundle());
      }
      paramBundle = h((QQAppInterface)localObject, paramBundle.getString("Uin", ((QQAppInterface)localObject).getCurrentAccountUin()));
      localObject = new Bundle();
      if (TextUtils.isEmpty(paramBundle))
      {
        QLog.e("ArkApp.GetNicknameByViewHandler", 1, "Handler_GetNickName.onCall, nickname is empty");
        ((Bundle)localObject).putString("Nickname", "");
      }
      for (;;)
      {
        return EIPCResult.createResult(0, (Bundle)localObject);
        ((Bundle)localObject).putString("Nickname", paramBundle);
      }
    }
    
    public boolean afn()
    {
      return true;
    }
  }
  
  public static class b
    implements adot.g
  {
    public EIPCResult a(Bundle paramBundle)
    {
      QQAppInterface localQQAppInterface = adot.c();
      if (localQQAppInterface == null)
      {
        QLog.e("ArkApp.GetNicknameHandler", 1, "Handler_GetNickName.onCall, qq app is null");
        return EIPCResult.createResult(-102, new Bundle());
      }
      String str = paramBundle.getString("Uin", localQQAppInterface.getCurrentAccountUin());
      Object localObject = null;
      if (!TextUtils.isEmpty(wyw.mTroopUin)) {
        localObject = aqgv.h(localQQAppInterface, wyw.mTroopUin, str);
      }
      if (localObject != null)
      {
        paramBundle = (Bundle)localObject;
        if (!TextUtils.equals((CharSequence)localObject, str)) {}
      }
      else
      {
        localObject = aqgv.G(localQQAppInterface, str);
        paramBundle = (Bundle)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramBundle = aqgv.d(localQQAppInterface, str, 0);
        }
      }
      localObject = new Bundle();
      if (TextUtils.isEmpty(paramBundle))
      {
        QLog.i("ArkApp.GetNicknameHandler", 1, "GetNicknameHandler.onCall, nickname is empty");
        ((Bundle)localObject).putString("Nickname", "");
      }
      for (;;)
      {
        return EIPCResult.createResult(0, (Bundle)localObject);
        ((Bundle)localObject).putString("Nickname", paramBundle);
      }
    }
    
    public boolean afn()
    {
      return true;
    }
  }
  
  public static class c
    implements adot.g
  {
    public EIPCResult a(Bundle paramBundle)
    {
      Object localObject = adot.c();
      if (localObject == null)
      {
        QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, qq app is null");
        return EIPCResult.createResult(-102, new Bundle());
      }
      paramBundle = paramBundle.getString("Domain", "");
      localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getPskey(((QQAppInterface)localObject).getCurrentAccountUin(), paramBundle);
      Bundle localBundle = new Bundle();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("ArkApp.GetPSKeyHandler", 1, "GetPSKeyHandler.onCall, pskey is empty, domain=" + paramBundle);
        localBundle.putString("PSKey", "");
      }
      for (;;)
      {
        return EIPCResult.createResult(0, localBundle);
        localBundle.putString("PSKey", (String)localObject);
      }
    }
    
    public boolean afn()
    {
      return true;
    }
  }
  
  public static class d
    implements adot.g
  {
    public EIPCResult a(Bundle paramBundle)
    {
      paramBundle = adot.c();
      if (paramBundle == null)
      {
        QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, qq app is null");
        return EIPCResult.createResult(-102, new Bundle());
      }
      paramBundle = ((TicketManager)paramBundle.getManager(2)).getSkey(paramBundle.getCurrentAccountUin());
      Bundle localBundle = new Bundle();
      if (TextUtils.isEmpty(paramBundle))
      {
        QLog.e("ArkApp.GetSKeyHandler", 1, "GetSKeyHandler.onCall, skey is empty");
        localBundle.putString("SKey", "");
      }
      for (;;)
      {
        return EIPCResult.createResult(0, localBundle);
        localBundle.putString("SKey", paramBundle);
      }
    }
    
    public boolean afn()
    {
      return true;
    }
  }
  
  public static class e
    implements adot.g
  {
    public EIPCResult a(Bundle paramBundle)
    {
      paramBundle = adot.c();
      if (paramBundle == null)
      {
        QLog.e("ArkApp.GetUinHandler", 1, "Handler_GetNickName.onCall, qq app is null");
        return EIPCResult.createResult(-102, new Bundle());
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("Uin", paramBundle.getCurrentAccountUin());
      return EIPCResult.createResult(0, localBundle);
    }
    
    public boolean afn()
    {
      return true;
    }
  }
  
  public static abstract interface f
  {
    public abstract void I(boolean paramBoolean, Bundle paramBundle);
    
    public abstract Bundle getArguments();
    
    public abstract String getMethod();
  }
  
  public static abstract interface g
  {
    public abstract EIPCResult a(Bundle paramBundle);
    
    public abstract boolean afn();
  }
  
  public static abstract class h
    implements adot.f
  {
    private final String mUin;
    
    public h(String paramString)
    {
      this.mUin = paramString;
    }
    
    public Bundle getArguments()
    {
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(this.mUin)) {
        localBundle.putString("Uin", this.mUin);
      }
      return localBundle;
    }
    
    public String getMethod()
    {
      return "QQ.GetNickname";
    }
  }
  
  public static abstract class i
    implements adot.f
  {
    private final long Vx;
    private final String mUin;
    
    public i(String paramString, long paramLong)
    {
      this.mUin = paramString;
      this.Vx = paramLong;
    }
    
    public Bundle getArguments()
    {
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(this.mUin)) {
        localBundle.putString("Uin", this.mUin);
      }
      localBundle.putLong("ViewHandle", this.Vx);
      return localBundle;
    }
    
    public String getMethod()
    {
      return "QQ.GetNickname";
    }
  }
  
  public static abstract class j
    implements adot.f
  {
    private final String mDomain;
    
    public j(String paramString)
    {
      this.mDomain = paramString;
    }
    
    public Bundle getArguments()
    {
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(this.mDomain)) {
        localBundle.putString("Domain", this.mDomain);
      }
      return localBundle;
    }
    
    public String getMethod()
    {
      return "QQ.GetPSKey";
    }
  }
  
  public static abstract class k
    implements adot.f
  {
    public Bundle getArguments()
    {
      return new Bundle();
    }
    
    public String getMethod()
    {
      return "QQ.GetSKey";
    }
  }
  
  public static abstract class l
    implements adot.f
  {
    public Bundle getArguments()
    {
      return new Bundle();
    }
    
    public String getMethod()
    {
      return "QQ.GetUin";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adot
 * JD-Core Version:    0.7.0.1
 */