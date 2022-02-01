import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vip.TMSManager.1;
import com.tencent.mobileqq.vip.TMSManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class aqvn
{
  protected static final String[] jdField_if = { "tmsdualcore", "tmsdualcore785", "tmsdualcore790", "tmsdualcore7901" };
  private aqvf a;
  
  public static aqvn.b a()
  {
    return aqvn.c.b();
  }
  
  public static aqvn a()
  {
    if (aqvn.d.b().a == null) {}
    synchronized (aqvn.d.b())
    {
      if (aqvn.d.b().a == null) {
        aqvn.d.b().efR();
      }
      return aqvn.d.b();
    }
  }
  
  private void efR()
  {
    int i = aese.d().cOH;
    QLog.d("KC.TMSManager", 1, "KingCardConfig : " + i);
    switch (i)
    {
    case 0: 
    case 1: 
    default: 
      this.a = new aqvf();
    }
    for (;;)
    {
      if (this.a != null) {
        efS();
      }
      return;
      if (isMainProcess(BaseApplicationImpl.getApplication())) {
        this.a = new aqvg();
      } else if (aqvf.aFH()) {
        this.a = new aqvj();
      }
    }
  }
  
  private void efS()
  {
    if (this.a != null) {
      this.a.ar(new TMSManager.2(this));
    }
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    int i = Process.myPid();
    String str = "";
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid != i) {
        break label88;
      }
      str = localRunningAppProcessInfo.processName;
    }
    label88:
    for (;;)
    {
      break;
      return paramContext.getPackageName().equals(str);
    }
  }
  
  public void S(ViewGroup paramViewGroup)
  {
    if ((this.a != null) && (this.a.isReady())) {
      this.a.S(paramViewGroup);
    }
  }
  
  public void a(aqvn.a parama, boolean paramBoolean)
  {
    if ((this.a != null) && (this.a.isReady())) {
      this.a.a(parama, paramBoolean);
    }
    while (parama == null) {
      return;
    }
    if (paramBoolean)
    {
      ThreadManager.getUIHandler().post(new TMSManager.1(this, parama));
      return;
    }
    parama.b(false, false, 0);
  }
  
  public boolean aFG()
  {
    if ((this.a != null) && (this.a.isReady())) {
      return this.a.aFG();
    }
    return false;
  }
  
  /* Error */
  public boolean aFK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	aqvn:a	Laqvf;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 45	aqvn:a	Laqvf;
    //   13: invokevirtual 175	aqvf:isReady	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	aqvn
    //   16	13	1	bool	boolean
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public boolean pz()
  {
    return aqux.Mv() > 0;
  }
  
  public boolean x(Activity paramActivity)
  {
    if ((this.a != null) && (this.a.isReady())) {
      return this.a.x(paramActivity);
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  }
  
  public static class b
  {
    public void aS(Context paramContext, int paramInt)
    {
      if (paramInt == 0) {}
      for (;;)
      {
        try
        {
          String str = paramContext.getDir("lib", 0).getAbsolutePath();
          paramContext = aqvn.a().bA(paramContext);
          if (aqnl.B(paramContext, str, "kcsdk_4.4.7.3661.jar"))
          {
            QLog.d("KC.TMSManager", 1, "unzip succ");
            aqvn.a(aqvn.a());
            return;
          }
          QLog.e("KC.TMSManager", 1, new Object[] { "unzip error, libDir=" + str, " zipPath=" + paramContext });
          continue;
          QLog.e("KC.TMSManager", 1, "error: " + paramInt);
        }
        finally {}
      }
    }
    
    public String bA(Context paramContext)
    {
      paramContext = paramContext.getFilesDir().getAbsolutePath();
      if (paramContext.endsWith(File.separator)) {
        return paramContext + "libtmsdualcore.zip";
      }
      return paramContext + File.separator + "libtmsdualcore.zip";
    }
    
    public String bB(Context paramContext)
    {
      paramContext = paramContext.getDir("lib", 0).getAbsolutePath();
      if (paramContext.endsWith(File.separator)) {
        return paramContext + "kcsdk_4.4.7.3661.jar";
      }
      return paramContext + File.separator + "kcsdk_4.4.7.3661.jar";
    }
    
    public void efo()
    {
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          ((VasQuickUpdateManager)localAppRuntime.getManager(184)).downloadItem(1004L, "kcsdk_4_4_7_3661", "KC.TMSManager");
        }
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  static class c
  {
    private static final aqvn.b a = new aqvn.b();
  }
  
  static class d
  {
    private static final aqvn a = new aqvn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvn
 * JD-Core Version:    0.7.0.1
 */