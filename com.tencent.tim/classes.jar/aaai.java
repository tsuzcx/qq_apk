import Wallet.ReqWalletConfig;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aaai
  implements Manager
{
  private volatile long LJ = -1L;
  private final QWalletConfig a;
  private int cfQ = -1;
  private final QQAppInterface mApp;
  
  public aaai(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "QWalletConfigManager init");
    }
    this.mApp = paramQQAppInterface;
    this.a = QWalletConfig.readConfig(paramQQAppInterface);
  }
  
  private void a(long paramLong, aaai.a parama, String paramString, Map<String, String> paramMap)
  {
    if (isVersionUpdate())
    {
      this.a.seriesNo = 0L;
      QLog.i("QWalletConfigManager", 2, "replace install:" + AppSetting.getAppId());
    }
    long l1;
    if (paramLong == 0L)
    {
      l1 = this.a.seriesNo;
      if (this.mApp == null) {
        break label191;
      }
    }
    label191:
    for (long l2 = this.mApp.getLongAccountUin();; l2 = 0L)
    {
      ReqWalletConfig localReqWalletConfig = ReqWalletConfig.createReq(paramLong, l2, l1, paramString, paramMap);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "realGetConfig:" + paramLong + "|" + parama + "|" + paramString + "|" + paramMap + "|" + localReqWalletConfig);
      }
      zyb.a(localReqWalletConfig, new aaaj(this, paramLong, parama, new WeakReference(this)), this.mApp);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public void FK(int paramInt)
  {
    int i = this.a.getValidReqOcca(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigManager", 2, "tryGetConfig:" + paramInt + "|" + i + "|" + this.a);
    }
    if (i != -1)
    {
      if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.LJ) <= 60000L) {
        break label90;
      }
      FL(i);
    }
    label90:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QWalletConfigManager", 2, "tryGetConfig too frequently to req");
  }
  
  public void FL(int paramInt)
  {
    this.cfQ = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("req_when", paramInt + "");
    try
    {
      String str = ((aadk)this.mApp.getManager(273)).getNotShowListStr();
      if (!TextUtils.isEmpty(str)) {
        localHashMap.put("redPoint", str);
      }
      a(0L, null, null, localHashMap);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void Y(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfigManager", 2, "setConfig params is null");
      }
    }
    do
    {
      return;
      paramMap = ReqWalletConfig.createReq(0L, this.mApp.getLongAccountUin(), this.a.seriesNo, null, paramMap);
      zyb.a(paramMap, 1, new aaak(this));
    } while (!QLog.isColorLevel());
    QLog.d("QWalletConfigManager", 2, "setConfig:" + paramMap);
  }
  
  public int a(String paramString, int paramInt, String... paramVarArgs)
  {
    return aaag.a(p(paramString), paramInt, paramVarArgs);
  }
  
  public String a(String paramString1, String paramString2, String... paramVarArgs)
  {
    return aaag.a(p(paramString1), paramString2, paramVarArgs);
  }
  
  public JSONArray a(String paramString, String... paramVarArgs)
  {
    return aaag.a(p(paramString), paramVarArgs);
  }
  
  public JSONObject a(String paramString, String... paramVarArgs)
  {
    return aaag.a(p(paramString), paramVarArgs);
  }
  
  public void a(String paramString, aaai.b paramb)
  {
    this.a.addUpdateListener(paramString, paramb);
  }
  
  public String aC(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = getConfig(paramString1);
    paramString1 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      paramString1 = localObject1;
      if (localObject2 != null)
      {
        paramString1 = localObject1;
        if (((JSONObject)localObject2).has(paramString2)) {
          paramString1 = ((JSONObject)localObject2).optString(paramString2);
        }
      }
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public void b(String paramString, aaai.b paramb)
  {
    this.a.removeUpdateListener(paramString, paramb);
  }
  
  public void ctg()
  {
    ThreadManager.executeOnSubThread(new QWalletConfigManager.1(this, new WeakReference(this)));
  }
  
  public String getConfig(String paramString)
  {
    return this.a.getConfig(paramString);
  }
  
  public QWalletConfig.a getConfigInfo(String paramString)
  {
    return this.a.getConfigInfo(paramString);
  }
  
  public long getLastReqTime()
  {
    return this.a.lastReqTime;
  }
  
  public boolean iH(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = aC("pub_acc", "pay_puin_list");
      bool1 = bool2;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      bool1 = bool2;
      int i;
      if (localObject != null) {
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < ((JSONArray)localObject).length())
        {
          bool1 = paramString.equals("" + ((JSONArray)localObject).get(i));
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean isVersionUpdate()
  {
    return this.a.isVersionUpdate();
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
  
  public JSONObject p(String paramString)
  {
    paramString = this.a.getParsedConfig(paramString);
    if ((paramString instanceof JSONObject)) {
      return (JSONObject)paramString;
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void g(String paramString, Map<String, String> paramMap);
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString1, String paramString2, QWalletConfig.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaai
 * JD-Core Version:    0.7.0.1
 */