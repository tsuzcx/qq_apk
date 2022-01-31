package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public abstract class MobileQQ
  extends BaseApplication
{
  public static final String KEY_UIN = "uin";
  static final int MSG_ACCOUNT = 1;
  private static final String PREF_KEY = "currentAccount";
  public static final String PREF_LAST_LOGIN = "last";
  private static final String PREF_SHARE = "share";
  private static final String PROPERTY_NAME = "Properties";
  public static final int STATE_EMPTY = 1;
  public static final int STATE_INITING = 2;
  public static final int STATE_READY = 3;
  public static String processName;
  public static MobileQQ sMobileQQ;
  private boolean accountChanged;
  private final List<WeakReference<BaseActivity>> activitys = new ArrayList();
  protected final ArrayList<WeakReference<AppActivity>> appActivities = new ArrayList();
  private Runnable doExit = new Runnable()
  {
    public void run()
    {
      MobileQQ.this.closeAllActivitys();
      if ((MobileQQ.this.activitys.isEmpty()) && (MobileQQ.this.appActivities.isEmpty()))
      {
        MobileQQ.this.delStateFile();
        localObject1 = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
        MobileQQ.this.sendBroadcast((Intent)localObject1);
        if (MobileQQ.this.getProcessName().endsWith(":video"))
        {
          MobileQQ.this.mService.msfSub.unbindMsfService();
          MobileQQ.this.mAppRuntime.onDestroy();
        }
        MobileQQ.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            if (MobileQQ.this.stopMSF)
            {
              MobileQQ.this.mService.msfSub.stopMsfService();
              MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqqi:MSF");
            }
            if (QLog.isColorLevel())
            {
              QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
              QLog.i("mqq", 2, "===========================================================");
            }
            System.exit(0);
          }
        }, 300L);
        return;
      }
      Object localObject1 = new StringBuffer();
      Iterator localIterator = MobileQQ.this.activitys.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (BaseActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      localIterator = MobileQQ.this.appActivities.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (AppActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, "do exit ->" + ((StringBuffer)localObject1).toString());
      }
      ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
      MobileQQ.this.mHandler.postDelayed(this, 150L);
    }
  };
  private boolean isCrashed;
  private AppRuntime mAppRuntime;
  final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      boolean bool = true;
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      int i = paramAnonymousMessage.arg1;
      if (paramAnonymousMessage.arg2 == 1) {}
      for (;;)
      {
        MobileQQ.this.dispatchAccountEvent(null, i, bool);
        return;
        bool = false;
      }
    }
  };
  private volatile AtomicInteger mRuntimeState = new AtomicInteger(1);
  private MainService mService;
  private final Properties properties = new Properties();
  private Bundle savedInstanceState;
  List<SimpleAccount> sortAccountList = null;
  private boolean stopMSF = false;
  
  private void exit(final boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    MsfServiceSdk localMsfServiceSdk;
    if (getProcessName().endsWith(":video"))
    {
      localMsfServiceSdk = this.mService.msfSub;
      if (paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localMsfServiceSdk.unRegisterMsfService(Boolean.valueOf(paramBoolean2));
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          try
          {
            if (MobileQQ.this.mAppRuntime == null) {
              MobileQQ.this.waitAppRuntime(null);
            }
            if (MobileQQ.this.getProcessName().equals(MobileQQ.this.getPackageName())) {
              MobileQQ.this.mAppRuntime.onAppGuardModeChange(true, 0, 0);
            }
            if (!MobileQQ.this.getProcessName().endsWith(":video"))
            {
              MobileQQ.this.mAppRuntime.onDestroy();
              if (!paramBoolean1) {
                MobileQQ.this.mService.msfSub.unRegisterMsfService();
              }
              MobileQQ.this.mService.msfSub.unbindMsfService();
            }
            if (MobileQQ.this.isCrashed)
            {
              MobileQQ.this.delStateFile();
              Intent localIntent = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
              MobileQQ.this.sendBroadcast(localIntent);
              if (QLog.isColorLevel())
              {
                QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
                QLog.i("mqq", 2, "===========================================================");
              }
              if (MobileQQ.this.getProcessName().endsWith(":video")) {
                MobileQQ.this.mAppRuntime.onDestroy();
              }
              System.exit(0);
              return;
            }
            MobileQQ.this.doExit.run();
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "exit" + localException.getMessage());
            }
          }
        }
      });
      return;
    }
  }
  
  public static MobileQQ getMobileQQ()
  {
    return sMobileQQ;
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!localRunningAppProcessInfo.processName.equals(paramString));
    Process.killProcess(localRunningAppProcessInfo.pid);
    return true;
  }
  
  private void loadProperites()
  {
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject6 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = openFileInput("Properties");
        localObject6 = localFileInputStream;
        localObject7 = localFileInputStream;
        localObject8 = localFileInputStream;
        localObject1 = localFileInputStream;
        this.properties.load(localFileInputStream);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        FileInputStream localFileInputStream;
        Object localObject2 = localObject6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject6;
        QLog.d("mqq", 2, "can not loadProperites => file not found");
        localObject2 = localObject6;
        localFileNotFoundException.printStackTrace();
        if (localObject6 == null) {
          continue;
        }
        try
        {
          localObject6.close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (IOException localIOException6)
      {
        Object localObject3 = localObject7;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localObject7;
        QLog.d("mqq", 2, "can not loadProperites => IOException");
        localObject3 = localObject7;
        localIOException6.printStackTrace();
        if (localObject7 == null) {
          continue;
        }
        try
        {
          localObject7.close();
          return;
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject4 = localObject8;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject4 = localObject8;
        QLog.d("mqq", 2, "can not loadProperites ");
        localObject4 = localObject8;
        localException.printStackTrace();
        if (localObject8 == null) {
          continue;
        }
        try
        {
          localObject8.close();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localIOException4 == null) {
          break label195;
        }
      }
      try
      {
        localFileInputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return;
      }
    }
    try
    {
      localIOException4.close();
      label195:
      throw localObject5;
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
  
  /* Error */
  private void restoreBundle()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 273
    //   4: invokevirtual 277	mqq/app/MobileQQ:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 282	java/io/File:exists	()Z
    //   12: ifeq +66 -> 78
    //   15: aconst_null
    //   16: astore_1
    //   17: aconst_null
    //   18: astore_3
    //   19: new 284	java/io/FileInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 287	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 291	java/io/FileInputStream:available	()I
    //   32: newarray byte
    //   34: astore_1
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 295	java/io/FileInputStream:read	([B)I
    //   40: pop
    //   41: invokestatic 301	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   44: astore_3
    //   45: aload_3
    //   46: aload_1
    //   47: iconst_0
    //   48: aload_1
    //   49: arraylength
    //   50: invokevirtual 305	android/os/Parcel:unmarshall	([BII)V
    //   53: aload_3
    //   54: iconst_0
    //   55: invokevirtual 308	android/os/Parcel:setDataPosition	(I)V
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 312	android/os/Parcel:readBundle	()Landroid/os/Bundle;
    //   63: putfield 132	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   66: aload_3
    //   67: invokevirtual 315	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 316	java/io/FileInputStream:close	()V
    //   78: return
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   84: return
    //   85: astore_1
    //   86: aload_3
    //   87: astore_2
    //   88: aload_1
    //   89: astore_3
    //   90: aload_2
    //   91: astore_1
    //   92: aload_3
    //   93: invokevirtual 271	java/lang/Exception:printStackTrace	()V
    //   96: aload_2
    //   97: ifnull -19 -> 78
    //   100: aload_2
    //   101: invokevirtual 316	java/io/FileInputStream:close	()V
    //   104: return
    //   105: astore_1
    //   106: aload_1
    //   107: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   110: return
    //   111: astore_2
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 316	java/io/FileInputStream:close	()V
    //   120: aload_2
    //   121: athrow
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 252	java/io/IOException:printStackTrace	()V
    //   127: goto -7 -> 120
    //   130: astore_3
    //   131: aload_2
    //   132: astore_1
    //   133: aload_3
    //   134: astore_2
    //   135: goto -23 -> 112
    //   138: astore_3
    //   139: goto -49 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	MobileQQ
    //   16	33	1	arrayOfByte	byte[]
    //   79	2	1	localIOException1	IOException
    //   85	4	1	localException1	Exception
    //   91	1	1	localObject1	Object
    //   105	12	1	localIOException2	IOException
    //   122	2	1	localIOException3	IOException
    //   132	1	1	localObject2	Object
    //   7	94	2	localObject3	Object
    //   111	21	2	localObject4	Object
    //   134	1	2	localObject5	Object
    //   18	75	3	localObject6	Object
    //   130	4	3	localObject7	Object
    //   138	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   74	78	79	java/io/IOException
    //   19	28	85	java/lang/Exception
    //   100	104	105	java/io/IOException
    //   19	28	111	finally
    //   92	96	111	finally
    //   116	120	122	java/io/IOException
    //   28	70	130	finally
    //   28	70	138	java/lang/Exception
  }
  
  public void QQProcessExit(boolean paramBoolean)
  {
    exit(false, paramBoolean);
  }
  
  void addActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.add(0, new WeakReference(paramBaseActivity));
  }
  
  void closeAllActivitys()
  {
    int i = this.activitys.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (WeakReference)this.activitys.get(i);
      if (localObject != null)
      {
        localObject = (BaseActivity)((WeakReference)localObject).get();
        label42:
        if (localObject != null) {
          break label69;
        }
        this.activitys.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject = null;
        break label42;
        label69:
        if (!((Activity)localObject).isFinishing()) {
          ((Activity)localObject).finish();
        }
      }
    }
    i = this.appActivities.size() - 1;
    if (i >= 0)
    {
      localObject = (WeakReference)this.appActivities.get(i);
      if (localObject != null)
      {
        localObject = (AppActivity)((WeakReference)localObject).get();
        label121:
        if (localObject != null) {
          break label146;
        }
        this.appActivities.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject = null;
        break label121;
        label146:
        if (!((Activity)localObject).isFinishing()) {
          ((Activity)localObject).finish();
        }
      }
    }
  }
  
  public void crashed()
  {
    this.isCrashed = true;
  }
  
  void createNewRuntime(final SimpleAccount paramSimpleAccount, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileQQ", 2, "createNewRuntime CNR needSaveLoginTime = " + paramBoolean2 + "; forLogin = " + paramBoolean1 + ";cnrType = " + paramInt);
    }
    paramSimpleAccount = new Runnable()
    {
      public void run()
      {
        if (MobileQQ.this.mAppRuntime == null) {}
        for (int i = 1;; i = 0)
        {
          localObject1 = MobileQQ.this.createRuntime(MobileQQ.processName);
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, MobileQQ.processName + " needn't AppRuntime!");
          }
          return;
        }
        ((AppRuntime)localObject1).init(MobileQQ.this, MobileQQ.this.mService, paramSimpleAccount);
        if (!MobileQQ.this.getProcessName().endsWith(":video")) {
          ((AppRuntime)localObject1).getService().msfSub.registerMsfService();
        }
        boolean bool1;
        long l3;
        long l1;
        long l2;
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          bool1 = true;
          if (paramInt != 2) {
            bool1 = ((AppRuntime)localObject1).canAutoLogin(paramSimpleAccount.getUin());
          }
          if (MobileQQ.this.savedInstanceState != null)
          {
            boolean bool2 = true;
            if (paramInt != 2) {
              bool2 = MobileQQ.this.savedInstanceState.getBoolean("isLogin");
            }
            if (QLog.isColorLevel()) {
              QLog.d("MobileQQ", 1, "CNR savedInstanceState != null isLogin = " + bool2 + "; forLogin = " + paramBoolean1 + ";account.getUin() = " + paramSimpleAccount.getUin());
            }
            if (((bool2) && (bool1)) || (paramBoolean1)) {
              ((AppRuntime)localObject1).setLogined();
            }
            MobileQQ.access$702(MobileQQ.this, ((AppRuntime)localObject1).isLogin());
            QLog.d("MobileQQ", 1, "CNR accountChanged =" + MobileQQ.this.accountChanged);
            if (!((AppRuntime)localObject1).isLogin()) {
              break label870;
            }
            if (MobileQQ.this.mAppRuntime != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("mqq", 2, "kickPC in mobileqq mAppRuntime != null do logout");
              }
              MobileQQ.this.mAppRuntime.logout(Constants.LogoutReason.switchAccount, true);
              MobileQQ.this.mAppRuntime.onDestroy();
            }
            if (paramBoolean2)
            {
              localObject2 = MobileQQ.this.getFirstSimpleAccount();
              l3 = System.currentTimeMillis();
              l1 = l3;
              if (localObject2 != null) {
                l2 = l3;
              }
            }
          }
        }
        try
        {
          long l4 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = l4 + 1L;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error..shit");
              l1 = l3;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject3;
            label680:
            localException.printStackTrace();
            l1 = l2;
            continue;
            label865:
            int j = 0;
          }
        }
        Object localObject2 = ((AppRuntime)localObject1).getAccount();
        if ((localObject2 != null) && (MobileQQ.this.getProcessName().equals(MobileQQ.this.getPackageName())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MobileQQ", 2, "save lastLogin..." + (String)localObject2);
          }
          localObject3 = MobileQQ.this;
          if (Build.VERSION.SDK_INT <= 10) {
            break label865;
          }
          j = 4;
          localObject3 = ((MobileQQ)localObject3).getSharedPreferences("Last_Login", j);
          if (!((SharedPreferences)localObject3).getString("uin", "").equals(localObject2)) {
            ((SharedPreferences)localObject3).edit().putString("uin", (String)localObject2).commit();
          }
        }
        MobileQQ.this.setProperty(((AppRuntime)localObject1).getAccount() + Constants.Key._logintime, String.valueOf(l1));
        ((AppRuntime)localObject1).onCreate(MobileQQ.this.savedInstanceState);
        MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
        Object localObject1 = MobileQQ.this.mHandler.obtainMessage(1);
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          ((Message)localObject1).arg2 = i;
          ((Message)localObject1).arg1 = paramInt;
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break label910;
          }
          MobileQQ.this.mHandler.handleMessage((Message)localObject1);
          return;
          if ((paramBoolean1) || (bool1))
          {
            ((AppRuntime)localObject1).setLogined();
            break;
          }
          QLog.d("MobileQQ", 1, "CNR forLogin = " + paramBoolean1 + ";canAutoOK = " + bool1);
          break;
          if (paramSimpleAccount != null)
          {
            QLog.d("MobileQQ", 1, "CNR account != null and account.isLogined =" + paramSimpleAccount.isLogined());
            break;
          }
          QLog.d("MobileQQ", 1, "CNR account == null");
          break;
          label870:
          if (MobileQQ.this.mAppRuntime != null) {
            break label680;
          }
          ((AppRuntime)localObject1).onCreate(MobileQQ.this.savedInstanceState);
          MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
          break label680;
        }
        label910:
        MobileQQ.this.mHandler.sendMessage((Message)localObject1);
      }
    };
    if (this.mAppRuntime == null)
    {
      paramSimpleAccount.run();
      return;
    }
    this.mHandler.post(paramSimpleAccount);
  }
  
  public abstract AppRuntime createRuntime(String paramString);
  
  void delStateFile()
  {
    this.savedInstanceState = null;
    File localFile = getFileStreamPath("savedInstanceState");
    if (localFile.exists())
    {
      if (!localFile.delete()) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, "delete file " + localFile.getPath() + " success.");
      }
    }
    label70:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("mqq", 2, "delete file " + localFile.getPath() + " failed.");
  }
  
  void dispatchAccountEvent(Constants.LogoutReason paramLogoutReason, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = this.activitys.size();
    int i;
    label27:
    Object localObject;
    if (paramLogoutReason != null)
    {
      i = 1;
      j -= 1;
      if (j < 0) {
        break label162;
      }
      localObject = (BaseActivity)((WeakReference)this.activitys.get(j)).get();
      if (localObject != null) {
        break label86;
      }
      this.activitys.remove(j);
    }
    for (;;)
    {
      j -= 1;
      break label27;
      i = 0;
      break;
      label86:
      if (i == 0)
      {
        ((BaseActivity)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
          ((BaseActivity)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
          ((BaseActivity)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
        ((BaseActivity)localObject).onLogout(paramLogoutReason);
      }
    }
    label162:
    j = this.appActivities.size() - 1;
    if (j >= 0)
    {
      localObject = (AppActivity)((WeakReference)this.appActivities.get(j)).get();
      if (localObject == null) {
        this.appActivities.remove(j);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (i == 0)
        {
          ((AppActivity)localObject).setAppRuntime(this.mAppRuntime);
          if (this.accountChanged)
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
            ((AppActivity)localObject).onAccountChanged();
          }
          else
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
            ((AppActivity)localObject).onAccoutChangeFailed();
          }
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
          ((AppActivity)localObject).onLogout(paramLogoutReason);
        }
      }
    }
    paramLogoutReason = this.mAppRuntime;
    if ((AppActivity.sResumeCount <= 0) && (BaseActivity.sResumeCount <= 0))
    {
      bool1 = true;
      paramLogoutReason.isBackground_Pause = bool1;
      paramLogoutReason = this.mAppRuntime;
      if (ApplicationLifeController.getController().getVisibleActivityCount() > 0) {
        break label461;
      }
    }
    label461:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramLogoutReason.isBackground_Stop = bool1;
      if (getPackageName().equals(getProcessName()))
      {
        if (i != 0) {
          break label467;
        }
        if (this.accountChanged)
        {
          paramLogoutReason = new Intent("mqq.intent.action.ACCOUNT_CHANGED");
          paramLogoutReason.putExtra("account", this.mAppRuntime.getAccount());
          paramLogoutReason.putExtra("type", paramInt);
          sendBroadcast(paramLogoutReason);
          if (!paramBoolean) {
            sendBroadcast(new Intent("mqq.intent.action.EXIT_" + getMobileQQ().getPackageName()));
          }
        }
      }
      return;
      bool1 = false;
      break;
    }
    label467:
    sendBroadcast(new Intent("mqq.i.intent.action.LOGOUT"));
  }
  
  /* Error */
  public final void doInit(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_1
    //   5: iconst_2
    //   6: invokevirtual 504	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   17: invokevirtual 508	mqq/app/MobileQQ:isNeedMSF	(Ljava/lang/String;)Z
    //   20: istore_2
    //   21: ldc_w 259
    //   24: iconst_1
    //   25: ldc_w 510
    //   28: iconst_2
    //   29: anewarray 512	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: iload_2
    //   41: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   44: aastore
    //   45: invokestatic 516	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   54: ldc_w 518
    //   57: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   60: ifne +375 -> 435
    //   63: iload_2
    //   64: ifeq +371 -> 435
    //   67: aload_0
    //   68: invokespecial 520	mqq/app/MobileQQ:loadProperites	()V
    //   71: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   74: ldc_w 522
    //   77: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   80: ifne +52 -> 132
    //   83: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   86: ldc 145
    //   88: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   91: ifne +41 -> 132
    //   94: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   97: ldc_w 524
    //   100: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   103: ifne +29 -> 132
    //   106: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   109: ldc_w 526
    //   112: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   115: ifne +17 -> 132
    //   118: aload_0
    //   119: invokespecial 528	mqq/app/MobileQQ:restoreBundle	()V
    //   122: ldc_w 259
    //   125: iconst_1
    //   126: ldc_w 530
    //   129: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_0
    //   133: new 153	mqq/app/MainService
    //   136: dup
    //   137: aload_0
    //   138: aload_0
    //   139: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   142: invokevirtual 534	mqq/app/MobileQQ:getAppId	(Ljava/lang/String;)I
    //   145: aload_0
    //   146: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   149: invokevirtual 538	mqq/app/MobileQQ:getBootBroadcastName	(Ljava/lang/String;)Ljava/lang/String;
    //   152: iload_1
    //   153: invokespecial 541	mqq/app/MainService:<init>	(Lmqq/app/MobileQQ;ILjava/lang/String;Z)V
    //   156: putfield 119	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   159: aload_0
    //   160: invokevirtual 143	mqq/app/MobileQQ:getProcessName	()Ljava/lang/String;
    //   163: ldc 145
    //   165: invokevirtual 151	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   168: ifne +13 -> 181
    //   171: aload_0
    //   172: getfield 119	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   175: getfield 157	mqq/app/MainService:msfSub	Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   178: invokevirtual 544	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:initMsfService	()V
    //   181: aconst_null
    //   182: astore_3
    //   183: aload_3
    //   184: astore 4
    //   186: aload_0
    //   187: getfield 132	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   190: ifnull +43 -> 233
    //   193: aload_0
    //   194: getfield 132	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   197: getstatic 549	mqq/app/Constants$Key:currentAccount	Lmqq/app/Constants$Key;
    //   200: invokevirtual 550	mqq/app/Constants$Key:toString	()Ljava/lang/String;
    //   203: invokevirtual 555	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 5
    //   208: aload_3
    //   209: astore 4
    //   211: aload 5
    //   213: ifnull +20 -> 233
    //   216: aload 5
    //   218: invokestatic 561	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   221: astore 4
    //   223: ldc_w 259
    //   226: iconst_1
    //   227: ldc_w 563
    //   230: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload 4
    //   235: astore_3
    //   236: aload 4
    //   238: ifnonnull +173 -> 411
    //   241: ldc_w 259
    //   244: iconst_1
    //   245: ldc_w 565
    //   248: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: invokevirtual 568	mqq/app/MobileQQ:getAllAccounts	()Ljava/util/List;
    //   255: astore_3
    //   256: aload_3
    //   257: ifnull +252 -> 509
    //   260: aload_3
    //   261: iconst_0
    //   262: invokeinterface 339 2 0
    //   267: checkcast 557	com/tencent/qphone/base/remote/SimpleAccount
    //   270: astore 4
    //   272: aload 4
    //   274: astore_3
    //   275: aload 4
    //   277: ifnonnull +134 -> 411
    //   280: ldc_w 259
    //   283: iconst_1
    //   284: ldc_w 570
    //   287: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: ldc 36
    //   293: iconst_0
    //   294: invokevirtual 574	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   297: astore 6
    //   299: aload 4
    //   301: astore_3
    //   302: aload 6
    //   304: ifnull +107 -> 411
    //   307: aload 6
    //   309: ldc 30
    //   311: aconst_null
    //   312: invokeinterface 579 3 0
    //   317: astore 5
    //   319: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +31 -> 353
    //   325: ldc_w 259
    //   328: iconst_1
    //   329: new 366	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 581
    //   339: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 5
    //   344: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 386	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload 4
    //   355: astore_3
    //   356: aload 5
    //   358: ifnull +53 -> 411
    //   361: aload 6
    //   363: invokeinterface 585 1 0
    //   368: ldc 30
    //   370: invokeinterface 590 2 0
    //   375: invokeinterface 593 1 0
    //   380: pop
    //   381: new 557	com/tencent/qphone/base/remote/SimpleAccount
    //   384: dup
    //   385: invokespecial 594	com/tencent/qphone/base/remote/SimpleAccount:<init>	()V
    //   388: astore_3
    //   389: aload_3
    //   390: aload 5
    //   392: invokevirtual 597	com/tencent/qphone/base/remote/SimpleAccount:setUin	(Ljava/lang/String;)V
    //   395: aload_3
    //   396: invokevirtual 600	com/tencent/qphone/base/remote/SimpleAccount:isLogined	()Z
    //   399: pop
    //   400: aload_3
    //   401: ldc_w 602
    //   404: iconst_1
    //   405: invokestatic 605	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   408: invokevirtual 609	com/tencent/qphone/base/remote/SimpleAccount:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: iconst_0
    //   412: istore_1
    //   413: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   416: ldc_w 611
    //   419: invokevirtual 222	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifeq +5 -> 427
    //   425: iconst_1
    //   426: istore_1
    //   427: aload_0
    //   428: aload_3
    //   429: iconst_0
    //   430: iload_1
    //   431: iconst_5
    //   432: invokevirtual 613	mqq/app/MobileQQ:createNewRuntime	(Lcom/tencent/qphone/base/remote/SimpleAccount;ZZI)V
    //   435: aload_0
    //   436: new 468	android/content/Intent
    //   439: dup
    //   440: new 366	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 615
    //   450: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: getstatic 505	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   456: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 386	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokespecial 473	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   465: invokevirtual 491	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   468: aload_0
    //   469: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   472: astore_3
    //   473: aload_3
    //   474: monitorenter
    //   475: aload_0
    //   476: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   479: iconst_3
    //   480: invokevirtual 618	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   483: aload_0
    //   484: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   487: invokevirtual 621	java/lang/Object:notifyAll	()V
    //   490: aload_3
    //   491: monitorexit
    //   492: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq -483 -> 12
    //   498: ldc_w 259
    //   501: iconst_2
    //   502: ldc_w 623
    //   505: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: return
    //   509: aconst_null
    //   510: astore 4
    //   512: goto -240 -> 272
    //   515: astore 4
    //   517: aload_3
    //   518: monitorexit
    //   519: aload 4
    //   521: athrow
    //   522: astore_3
    //   523: ldc_w 259
    //   526: iconst_1
    //   527: ldc_w 625
    //   530: aload_3
    //   531: invokestatic 629	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   534: new 631	java/lang/RuntimeException
    //   537: dup
    //   538: aload_3
    //   539: invokespecial 634	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   542: athrow
    //   543: astore 4
    //   545: aload_0
    //   546: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   549: astore_3
    //   550: aload_3
    //   551: monitorenter
    //   552: aload_0
    //   553: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   556: iconst_3
    //   557: invokevirtual 618	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   560: aload_0
    //   561: getfield 96	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   564: invokevirtual 621	java/lang/Object:notifyAll	()V
    //   567: aload_3
    //   568: monitorexit
    //   569: invokestatic 257	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +13 -> 585
    //   575: ldc_w 259
    //   578: iconst_2
    //   579: ldc_w 623
    //   582: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: aload 4
    //   587: athrow
    //   588: astore 4
    //   590: aload_3
    //   591: monitorexit
    //   592: aload 4
    //   594: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	MobileQQ
    //   0	595	1	paramBoolean	boolean
    //   20	44	2	bool	boolean
    //   522	17	3	localThrowable	java.lang.Throwable
    //   184	327	4	localObject2	Object
    //   515	5	4	localObject3	Object
    //   543	43	4	localObject4	Object
    //   588	5	4	localObject5	Object
    //   206	185	5	str	String
    //   297	65	6	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   475	492	515	finally
    //   517	519	515	finally
    //   13	63	522	java/lang/Throwable
    //   67	132	522	java/lang/Throwable
    //   132	181	522	java/lang/Throwable
    //   186	208	522	java/lang/Throwable
    //   216	233	522	java/lang/Throwable
    //   241	256	522	java/lang/Throwable
    //   260	272	522	java/lang/Throwable
    //   280	299	522	java/lang/Throwable
    //   307	353	522	java/lang/Throwable
    //   361	411	522	java/lang/Throwable
    //   413	425	522	java/lang/Throwable
    //   427	435	522	java/lang/Throwable
    //   435	468	522	java/lang/Throwable
    //   13	63	543	finally
    //   67	132	543	finally
    //   132	181	543	finally
    //   186	208	543	finally
    //   216	233	543	finally
    //   241	256	543	finally
    //   260	272	543	finally
    //   280	299	543	finally
    //   307	353	543	finally
    //   361	411	543	finally
    //   413	425	543	finally
    //   427	435	543	finally
    //   435	468	543	finally
    //   523	543	543	finally
    //   552	569	588	finally
    //   590	592	588	finally
  }
  
  public List<SimpleAccount> getAllAccounts()
  {
    if (this.sortAccountList == null)
    {
      ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.sortAccountList = localArrayList;
      }
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l1 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          long l2 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime));
          if ((paramAnonymousSimpleAccount1 != null) && (QLog.isColorLevel())) {
            QLog.d("mqq", 2, "a1.getUin() = " + paramAnonymousSimpleAccount1.getUin() + ";key.time = " + l1);
          }
          if ((paramAnonymousSimpleAccount2 != null) && (QLog.isColorLevel())) {
            QLog.d("mqq", 2, "a2.getUin() = " + paramAnonymousSimpleAccount2.getUin() + ";key.time = " + l2);
          }
          if (l2 > l1) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.w("mqq", 2, "Account list is NULL!");
    }
    return null;
  }
  
  public List<SimpleAccount> getAllNotSynAccountList()
  {
    return this.sortAccountList;
  }
  
  public abstract int getAppId(String paramString);
  
  public AppRuntime getAppRuntime(String paramString)
    throws AccountNotMatchException
  {
    AppRuntime localAppRuntime = waitAppRuntime(null);
    if ((paramString != null) && (paramString.equals(localAppRuntime.getAccount()))) {}
    while (paramString == localAppRuntime.getAccount()) {
      return localAppRuntime;
    }
    throw new AccountNotMatchException(localAppRuntime.getAccount(), paramString);
  }
  
  public abstract String getBootBroadcastName(String paramString);
  
  public SimpleAccount getFirstSimpleAccount()
  {
    List localList = getAllAccounts();
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (SimpleAccount)localList.get(0);
  }
  
  public String getProcessName()
  {
    if (processName == null)
    {
      Object localObject = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == Process.myPid()) {
            processName = localRunningAppProcessInfo.processName;
          }
        }
      }
      if (processName == null) {
        processName = getApplicationInfo().name;
      }
    }
    return processName;
  }
  
  public String getProperty(String paramString)
  {
    return this.properties.getProperty(paramString);
  }
  
  public int getVisibleActivityCount()
  {
    return ApplicationLifeController.getController().getVisibleActivityCount();
  }
  
  public abstract boolean isNeedMSF(String paramString);
  
  public boolean isRuntimeReady()
  {
    return this.mRuntimeState.get() == 3;
  }
  
  public boolean onActivityCreate(AppActivity paramAppActivity, Intent paramIntent)
  {
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean) {}
  
  public void onCreate()
  {
    sMobileQQ = this;
    ApplicationLifeController.getController();
    super.onCreate();
  }
  
  public void otherProcessExit(boolean paramBoolean)
  {
    exit(paramBoolean, false);
  }
  
  public List<SimpleAccount> refreAccountList()
  {
    ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.sortAccountList = localArrayList;
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "refreAccountList Account list is NULL!");
    }
    return this.sortAccountList;
  }
  
  void removeActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.remove(new WeakReference(paramBaseActivity));
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if ((this.mAppRuntime != null) && (this.mAppRuntime.getAccount() != null) && (this.mAppRuntime.getAccount().length() > 0)) {
      this.mAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setProperty(String paramString1, String paramString2)
  {
    this.properties.setProperty(paramString1, paramString2);
    paramString2 = null;
    paramString1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = openFileOutput("Properties", 0);
        paramString1 = localFileOutputStream;
        paramString2 = localFileOutputStream;
        this.properties.store(localFileOutputStream, null);
        paramString1 = localFileOutputStream;
        paramString2 = localFileOutputStream;
        localFileOutputStream.flush();
      }
      catch (Exception localException)
      {
        FileOutputStream localFileOutputStream;
        paramString2 = paramString1;
        localException.printStackTrace();
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.close();
          return;
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
      }
      finally
      {
        if (paramString2 == null) {
          break label89;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    try
    {
      paramString2.close();
      label89:
      throw paramString1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void setSortAccountList(List<SimpleAccount> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      this.sortAccountList = paramList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "sort AccountList" + this.sortAccountList);
    }
  }
  
  public void startService()
  {
    if (this.mService != null) {
      this.mService.start();
    }
  }
  
  public long string2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long number is empty");
      }
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long catch exception");
      }
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public AppRuntime waitAppRuntime(BaseActivity arg1)
  {
    int i = this.mRuntimeState.get();
    if (i != 3) {
      if (i == 1) {
        doInit(true);
      }
    }
    synchronized (this.mRuntimeState)
    {
      i = this.mRuntimeState.get();
      if (i == 2) {}
      try
      {
        this.mRuntimeState.wait();
        return this.mAppRuntime;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          QLog.e("mqq", 1, "waitInit failed", localInterruptedException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.MobileQQ
 * JD-Core Version:    0.7.0.1
 */