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
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
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
import java.util.concurrent.atomic.AtomicBoolean;
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
  public volatile String autoLoginUin;
  private Runnable doExit = new Runnable()
  {
    public void run()
    {
      MobileQQ.this.closeAllActivitys();
      if ((MobileQQ.this.activitys.isEmpty()) && (MobileQQ.this.appActivities.isEmpty()))
      {
        MobileQQ.this.delStateFile();
        localObject1 = new Intent("mqql.intent.action.EXIT_" + MobileQQ.processName);
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
              MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.qqlite:MSF");
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
      MobileQQ.this.mHandler.postDelayed(this, 50L);
    }
  };
  private boolean isCrashed;
  public boolean isPCActive = false;
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
        MobileQQ.this.dispatchAccountEvent(null, i, bool, (String)paramAnonymousMessage.obj);
        return;
        bool = false;
      }
    }
  };
  private volatile AtomicInteger mRuntimeState = new AtomicInteger(1);
  private MainService mService;
  public volatile AtomicBoolean needAutoLogin = new AtomicBoolean(false);
  private final Properties properties = new Properties();
  private Bundle savedInstanceState;
  List<SimpleAccount> sortAccountList = null;
  private boolean stopMSF = false;
  
  private void exit(final boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    Object localObject;
    if (getProcessName().endsWith(":video"))
    {
      localObject = this.mService.msfSub;
      if (paramBoolean1) {
        break label71;
      }
    }
    label71:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((MsfServiceSdk)localObject).unRegisterMsfService(Boolean.valueOf(paramBoolean2));
      localObject = new Runnable()
      {
        public void run()
        {
          try
          {
            if (MobileQQ.this.mAppRuntime == null) {
              MobileQQ.this.waitAppRuntime(null);
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
              Intent localIntent = new Intent("mqql.intent.action.EXIT_" + MobileQQ.processName);
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
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
      this.mHandler.postAtFrontOfQueue((Runnable)localObject);
      return;
    }
    ((Runnable)localObject).run();
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
    //   1: ldc_w 308
    //   4: invokevirtual 312	mqq/app/MobileQQ:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 317	java/io/File:exists	()Z
    //   12: ifeq +77 -> 89
    //   15: aconst_null
    //   16: astore_1
    //   17: aconst_null
    //   18: astore_3
    //   19: new 319	java/io/FileInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 326	java/io/FileInputStream:available	()I
    //   32: newarray byte
    //   34: astore_1
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 330	java/io/FileInputStream:read	([B)I
    //   40: pop
    //   41: invokestatic 336	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   44: astore_3
    //   45: aload_3
    //   46: aload_1
    //   47: iconst_0
    //   48: aload_1
    //   49: arraylength
    //   50: invokevirtual 340	android/os/Parcel:unmarshall	([BII)V
    //   53: aload_3
    //   54: iconst_0
    //   55: invokevirtual 343	android/os/Parcel:setDataPosition	(I)V
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 347	android/os/Parcel:readBundle	()Landroid/os/Bundle;
    //   63: putfield 145	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   66: aload_3
    //   67: invokevirtual 350	android/os/Parcel:recycle	()V
    //   70: aload_0
    //   71: getfield 145	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   74: ldc_w 352
    //   77: invokevirtual 357	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   80: pop
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 358	java/io/FileInputStream:close	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   95: return
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 359	java/lang/Throwable:printStackTrace	()V
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: new 354	android/os/Bundle
    //   113: dup
    //   114: invokespecial 360	android/os/Bundle:<init>	()V
    //   117: putfield 145	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   120: aload_2
    //   121: ifnull -32 -> 89
    //   124: aload_2
    //   125: invokevirtual 358	java/io/FileInputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   134: return
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 358	java/io/FileInputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 285	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_3
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: goto -23 -> 136
    //   162: astore_3
    //   163: goto -62 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	MobileQQ
    //   16	33	1	arrayOfByte	byte[]
    //   90	2	1	localIOException1	IOException
    //   96	4	1	localThrowable1	Throwable
    //   102	7	1	localObject1	Object
    //   129	12	1	localIOException2	IOException
    //   146	2	1	localIOException3	IOException
    //   156	1	1	localObject2	Object
    //   7	118	2	localObject3	Object
    //   135	21	2	localObject4	Object
    //   158	1	2	localObject5	Object
    //   18	86	3	localObject6	Object
    //   154	4	3	localObject7	Object
    //   162	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   85	89	90	java/io/IOException
    //   19	28	96	java/lang/Throwable
    //   124	128	129	java/io/IOException
    //   19	28	135	finally
    //   103	107	135	finally
    //   109	120	135	finally
    //   140	144	146	java/io/IOException
    //   28	81	154	finally
    //   28	81	162	java/lang/Throwable
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
        } else {
          this.activitys.remove(i);
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
        label135:
        if (localObject != null) {
          break label160;
        }
        this.appActivities.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject = null;
        break label135;
        label160:
        if (!((Activity)localObject).isFinishing()) {
          ((Activity)localObject).finish();
        } else {
          this.appActivities.remove(i);
        }
      }
    }
  }
  
  public void crashed()
  {
    this.isCrashed = true;
  }
  
  void createNewRuntime(final SimpleAccount paramSimpleAccount, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt, final String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MobileQQ", 2, "createNewRuntime CNR needSaveLoginTime = " + paramBoolean2 + "; forLogin = " + paramBoolean1 + ";cnrType = " + paramInt + "; process = " + paramString);
    }
    paramSimpleAccount = new Runnable()
    {
      public void run()
      {
        if (MobileQQ.this.mAppRuntime == null) {}
        Object localObject1;
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
              break label916;
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
            localException.printStackTrace();
            l1 = l2;
            continue;
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
          if (Build.VERSION.SDK_INT > 10)
          {
            j = 4;
            localObject3 = ((MobileQQ)localObject3).getSharedPreferences("Last_Login", j);
            if (!((SharedPreferences)localObject3).getString("uin", "").equals(localObject2)) {
              ((SharedPreferences)localObject3).edit().putString("uin", (String)localObject2).commit();
            }
            if (QLog.isColorLevel()) {
              QLog.i("QQWIFI", 2, "remove exituin");
            }
            ((SharedPreferences)localObject3).edit().remove("exitUin").commit();
          }
        }
        else
        {
          MobileQQ.this.setProperty(((AppRuntime)localObject1).getAccount() + Constants.Key._logintime, String.valueOf(l1));
          ((AppRuntime)localObject1).onCreate(MobileQQ.this.savedInstanceState);
          MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
          label717:
          localObject1 = MobileQQ.this.mHandler.obtainMessage(1);
          if (i == 0) {
            break label951;
          }
        }
        label916:
        label951:
        for (i = 1;; i = 0)
        {
          ((Message)localObject1).arg2 = i;
          ((Message)localObject1).arg1 = paramInt;
          ((Message)localObject1).obj = paramString;
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break label956;
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
          if (MobileQQ.this.mAppRuntime != null) {
            break label717;
          }
          ((AppRuntime)localObject1).onCreate(MobileQQ.this.savedInstanceState);
          MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
          break label717;
        }
        label956:
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
  
  void dispatchAccountEvent(Constants.LogoutReason paramLogoutReason, int paramInt, boolean paramBoolean, String paramString)
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
        break label473;
      }
    }
    label473:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramLogoutReason.isBackground_Stop = bool1;
      if (getPackageName().equals(getProcessName()))
      {
        if (i != 0) {
          break label479;
        }
        if (this.accountChanged)
        {
          paramLogoutReason = new Intent("mqql.intent.action.ACCOUNT_CHANGED");
          paramLogoutReason.putExtra("account", this.mAppRuntime.getAccount());
          paramLogoutReason.putExtra("type", paramInt);
          sendBroadcast(paramLogoutReason);
          if (!paramBoolean)
          {
            paramLogoutReason = new Intent("mqql.intent.action.EXIT_" + getMobileQQ().getPackageName());
            paramLogoutReason.putExtra("K_EXCEP", paramString);
            sendBroadcast(paramLogoutReason);
          }
        }
      }
      return;
      bool1 = false;
      break;
    }
    label479:
    sendBroadcast(new Intent("mqql.intent.action.LOGOUT"));
  }
  
  public final void doInit(boolean paramBoolean)
  {
    if (!this.mRuntimeState.compareAndSet(1, 2)) {
      return;
    }
    try
    {
      boolean bool = isNeedMSF(processName);
      QLog.d("mqq", 1, String.format("doInit begin with Application(%s) lanuched.isNeedMSF=%s", new Object[] { processName, Boolean.valueOf(bool) }));
      Object localObject4;
      String str;
      if ((!processName.endsWith(":MSF")) && (bool))
      {
        loadProperites();
        if ((!processName.endsWith(":qzone")) && (!processName.endsWith(":video")) && (!processName.endsWith(":web")) && (!processName.endsWith(":openSdk")))
        {
          restoreBundle();
          QLog.d("mqq", 1, "doinit restoreBundle");
        }
        this.mService = new MainService(this, getAppId(processName), getBootBroadcastName(processName), paramBoolean);
        if (!getProcessName().endsWith(":video")) {
          this.mService.msfSub.initMsfService();
        }
        ??? = null;
        localObject4 = ???;
        if (this.savedInstanceState != null)
        {
          str = this.savedInstanceState.getString(Constants.Key.currentAccount.toString());
          localObject4 = ???;
          if (str != null)
          {
            localObject4 = SimpleAccount.parseSimpleAccount(str);
            QLog.d("mqq", 1, "savedInstanceState != null getdata from killdata shit");
          }
        }
        ??? = localObject4;
        if (localObject4 == null)
        {
          QLog.d("mqq", 1, "doinit last == null goto getAllAccounts....");
          ??? = getAllAccounts();
          if (??? == null) {
            break label532;
          }
          localObject4 = (SimpleAccount)((List)???).get(0);
        }
      }
      for (;;)
      {
        ??? = localObject4;
        if (localObject4 == null)
        {
          QLog.d("mqq", 1, "doinit last == null goto to sharedPreferences....");
          SharedPreferences localSharedPreferences = getSharedPreferences("share", 0);
          ??? = localObject4;
          if (localSharedPreferences != null)
          {
            str = localSharedPreferences.getString("currentAccount", null);
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 1, "doinit last == null goto to sharedPreferences....uin = " + str);
            }
            ??? = localObject4;
            if (str != null)
            {
              localSharedPreferences.edit().remove("currentAccount").commit();
              ??? = new SimpleAccount();
              ((SimpleAccount)???).setUin(str);
              ((SimpleAccount)???).isLogined();
              ((SimpleAccount)???).setAttribute("_isLogined", String.valueOf(true));
            }
          }
        }
        paramBoolean = false;
        if (processName.equals("com.tencent.qqlite")) {
          paramBoolean = true;
        }
        createNewRuntime((SimpleAccount)???, false, paramBoolean, 5, null);
        sendBroadcast(new Intent("mqql.intent.action.LAUNCH_" + processName));
        synchronized (this.mRuntimeState)
        {
          this.mRuntimeState.set(3);
          this.mRuntimeState.notifyAll();
          QLog.d("mqq", 1, "doInit finished");
          monitor.setProcessName(processName);
          try
          {
            monitor.start();
            return;
          }
          catch (Throwable localThrowable1)
          {
            QLog.d("mqq", 1, "", localThrowable1);
            return;
          }
          label532:
          localObject4 = null;
        }
      }
      try
      {
        monitor.start();
        throw localObject2;
        localObject3 = finally;
        throw localObject3;
      }
      catch (Throwable localThrowable3)
      {
        for (;;)
        {
          QLog.d("mqq", 1, "", localThrowable3);
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("mqq", 1, "doInit failed", localThrowable2);
      throw new RuntimeException(localThrowable2);
    }
    finally
    {
      synchronized (this.mRuntimeState)
      {
        this.mRuntimeState.set(3);
        this.mRuntimeState.notifyAll();
        QLog.d("mqq", 1, "doInit finished");
        monitor.setProcessName(processName);
      }
    }
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
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
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
  
  public void reportPCActive(String paramString, int paramInt) {}
  
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
      if (i == 1)
      {
        QLog.e("mqq", 1, "waitInit when empty: ", new RuntimeException(""));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     mqq.app.MobileQQ
 * JD-Core Version:    0.7.0.1
 */