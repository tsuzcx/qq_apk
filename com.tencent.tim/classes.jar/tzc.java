import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mm.hardcoder.HardCoderManager.1;
import com.tencent.mm.hardcoder.HardCoderManager.2;
import com.tencent.mm.hardcoder.HardCoderManager.3;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class tzc
  implements Handler.Callback
{
  private static Bundle V;
  private static Bundle W;
  private static tzc a;
  private static final String aKk;
  private static Random f;
  public static final boolean sDebug;
  private boolean aQN;
  private ConcurrentHashMap<Integer, Integer> cR = new ConcurrentHashMap();
  private HashMap<Integer, Boolean> gv = new HashMap();
  private Handler mHandler;
  private SharedPreferences mPref = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hardcoder", 4);
  private int state = 0;
  
  static
  {
    if ((QLog.isColorLevel()) && (new File("/sdcard/debug_hc").exists())) {}
    for (boolean bool = true;; bool = false)
    {
      sDebug = bool;
      aKk = AppSetting.getRevision() + "key_crash_cnt";
      V = new Bundle(8);
      W = new Bundle(2);
      f = new Random();
      return;
    }
  }
  
  public static tzc a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new tzc();
        new HardCoderManager.1().start();
      }
      return a;
    }
    finally {}
  }
  
  private void init()
  {
    if ((sDebug) && (new File("/sdcard/disable_hc").exists()))
    {
      QLog.d("HardCoder.QQManager", 1, "disable by file cfg");
      this.state = 2;
      return;
    }
    int i = this.mPref.getInt("key_cfg_flag", 0);
    if (i == 2)
    {
      QLog.d("HardCoder.QQManager", 1, "disable by server cfg");
      this.state = 3;
      return;
    }
    Object localObject = Build.MANUFACTURER;
    if ((localObject != null) && (((String)localObject).toUpperCase().contains("VIVO")))
    {
      QLog.d("HardCoder.QQManager", 1, "disable vivo");
      this.state = 3;
      return;
    }
    int j;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      j = this.mPref.getInt(aKk, 0);
      if (j > 2)
      {
        this.state = 9;
        localObject = this.mPref.edit();
        ((SharedPreferences.Editor)localObject).putInt("key_state", this.state);
        if (this.state != 10) {
          break label307;
        }
        ((SharedPreferences.Editor)localObject).putInt(aKk, j + 1);
        ThreadManager.getSubThreadHandler().postDelayed(new HardCoderManager.2(this), 10000L);
        label196:
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    for (;;)
    {
      QLog.d("HardCoder.QQManager", 1, "hc init " + this.state);
      return;
      this.mPref.edit().putInt(aKk, j + 1).commit();
      this.state = tzb.a().init();
      if ((this.state != 10) || (i != 1) || (Math.random() >= 0.5D)) {
        break;
      }
      this.state = 8;
      tzb.a().uninit();
      break;
      label307:
      ((SharedPreferences.Editor)localObject).putInt(aKk, j);
      break label196;
      this.state = this.mPref.getInt("key_state", 1);
      if (this.state == 10) {
        this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString, true);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString, boolean paramBoolean)
  {
    if (this.state != 10) {
      return 0;
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      return tzb.a().a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    }
    Message localMessage = this.mHandler.obtainMessage(0);
    tzb.a locala = (tzb.a)tzb.a.obtain(tzb.a.class);
    locala.delay = paramInt1;
    locala.bDg = paramInt2;
    locala.bDh = paramInt3;
    locala.bDi = paramInt4;
    locala.timeout = paramInt5;
    locala.scene = paramInt6;
    locala.EW = paramLong;
    locala.tag = paramString;
    localMessage.obj = locala;
    localMessage.sendToTarget();
    if (paramBoolean)
    {
      paramInt1 = f.nextInt();
      localMessage.arg1 = paramInt1;
      this.cR.put(Integer.valueOf(paramInt1), Integer.valueOf(0));
    }
    for (;;)
    {
      return localMessage.arg1;
      localMessage.arg1 = 0;
    }
  }
  
  public void aG(QQAppInterface paramQQAppInterface)
  {
    if (this.aQN) {}
    for (;;)
    {
      return;
      this.aQN = true;
      Object localObject;
      if (this.state != 1)
      {
        localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.batteryCfg.name());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("#");
          if (localObject.length >= 4)
          {
            localObject = localObject[3];
            QLog.d("HardCoder.QQManager", 1, "hcConfig = " + (String)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localObject = localObject.split("\\|")[0];
            }
          }
        }
      }
      try
      {
        this.mPref.edit().putInt("key_cfg_flag", Integer.valueOf((String)localObject).intValue()).commit();
        QLog.d("HardCoder.QQManager", 1, "svc flag = " + (String)localObject);
        if (this.state != 4) {
          continue;
        }
        long l = this.mPref.getLong("key_last_down_time", 0L);
        if ((Math.abs(System.currentTimeMillis() - l) <= 86400000L) || (!aqiw.isWifiConnected(BaseApplicationImpl.getContext()))) {
          continue;
        }
        this.mPref.edit().putLong("key_last_down_time", System.currentTimeMillis()).apply();
        paramQQAppInterface.execute(new HardCoderManager.3(this, paramQQAppInterface));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HardCoder.QQManager", 1, "", localException);
        }
      }
    }
  }
  
  public void ax(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {}
    do
    {
      do
      {
        return;
        if (BaseApplicationImpl.sProcessId == 1)
        {
          tzb.a().fT(paramInt);
          return;
        }
      } while (this.mHandler == null);
      if (this.cR.containsKey(Integer.valueOf(paramInt)))
      {
        localMessage = this.mHandler.obtainMessage(1);
        localMessage.arg1 = ((Integer)this.cR.remove(Integer.valueOf(paramInt))).intValue();
        localMessage.sendToTarget();
        return;
      }
    } while (!paramBoolean);
    Message localMessage = this.mHandler.obtainMessage(1);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void bFa()
  {
    if (this.state == 10)
    {
      this.state = 1;
      QLog.d("HardCoder.QQManager", 1, "onDisconnect");
      this.mPref.edit().putInt("key_state", this.state).commit();
      tzb.a().uninit();
    }
  }
  
  public void bFb()
  {
    QLog.d("HardCoder.QQManager", 1, "crash count = " + this.mPref.getInt(aKk, 0));
    this.mPref.edit().putInt(aKk, 0).commit();
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      Object localObject = (tzb.a)paramMessage.obj;
      V.putInt("key_delay", ((tzb.a)localObject).delay);
      V.putInt("key_cpu", ((tzb.a)localObject).bDg);
      V.putInt("key_io", ((tzb.a)localObject).bDh);
      V.putInt("key_bind", ((tzb.a)localObject).bDi);
      V.putInt("key_timeout", ((tzb.a)localObject).timeout);
      V.putInt("key_scene", ((tzb.a)localObject).scene);
      V.putLong("key_action", ((tzb.a)localObject).EW);
      V.putString("key_tag", ((tzb.a)localObject).tag);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "start", V);
      if ((paramMessage.arg1 != 0) && (localObject != null) && (((EIPCResult)localObject).code != 0)) {
        this.cR.put(Integer.valueOf(paramMessage.arg1), Integer.valueOf(((EIPCResult)localObject).code));
      }
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 1)
      {
        W.putInt("key_code", paramMessage.arg1);
        QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "stop", W);
      }
    }
  }
  
  public boolean isSupported()
  {
    return (this.state == 10) || (this.state == 8);
  }
  
  public void stop(int paramInt)
  {
    ax(paramInt, false);
  }
  
  public static class a
    extends QIPCModule
  {
    private static a a;
    
    public a(String paramString)
    {
      super();
    }
    
    public static a a()
    {
      if (a == null) {}
      try
      {
        a = new a("HardCoderModule");
        return a;
      }
      finally {}
    }
    
    public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
    {
      EIPCResult localEIPCResult = null;
      if (QLog.isColorLevel()) {
        QLog.d("HardCoder.QQManager", 2, "onCall action = " + paramString);
      }
      if (paramString.equals("start"))
      {
        paramInt = paramBundle.getInt("key_delay");
        i = paramBundle.getInt("key_cpu");
        j = paramBundle.getInt("key_io");
        k = paramBundle.getInt("key_bind");
        m = paramBundle.getInt("key_timeout");
        n = paramBundle.getInt("key_scene");
        l = paramBundle.getLong("key_action");
        paramString = paramBundle.getString("key_tag");
        localEIPCResult = EIPCResult.createResult(tzb.a().a(paramInt, i, j, k, m, n, l, Process.myTid(), paramString), null);
      }
      while (!paramString.equals("stop"))
      {
        int i;
        int j;
        int k;
        int m;
        int n;
        long l;
        return localEIPCResult;
      }
      paramInt = paramBundle.getInt("key_code");
      tzb.a().fT(paramInt);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzc
 * JD-Core Version:    0.7.0.1
 */