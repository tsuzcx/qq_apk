import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class aytr
{
  private static aytr jdField_a_of_type_Aytr;
  private aytr.a jdField_a_of_type_Aytr$a = new aytr.a(null);
  private aytr.c jdField_a_of_type_Aytr$c;
  private Handler cn = new Handler(Looper.getMainLooper(), new ayts(this));
  private AppInterface mAppInterface;
  
  private aytr(AppInterface paramAppInterface)
  {
    this.mAppInterface = paramAppInterface;
    if (this.mAppInterface != null) {
      this.mAppInterface.registObserver(this.jdField_a_of_type_Aytr$a);
    }
  }
  
  public static aytr a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_Aytr == null) {
      jdField_a_of_type_Aytr = new aytr(paramAppInterface);
    }
    return jdField_a_of_type_Aytr;
  }
  
  private void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    int i = 4;
    if (this.mAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.mAppInterface.getApp(), ayad.class);
    localNewIntent.putExtra("key_latitude", paramDouble1);
    localNewIntent.putExtra("key_longitude", paramDouble2);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("key_lbs_template_cookie", paramInt);
    switch (aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getBaseContext()))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      localNewIntent.putExtra("key_lbs_template_network_type", i);
      this.mAppInterface.startServlet(localNewIntent);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LBSDetetor", 2, "getLBSTemplateIds. req:" + paramInt + " netType:" + i + " latitude:" + paramDouble1 + " longitude:" + paramDouble2);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 5;
    }
  }
  
  private void b(boolean paramBoolean, ArrayList<String> paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LBSDetetor", 2, "callback. isSuccess: " + paramBoolean + " cookie: " + paramInt);
    }
    this.cn.removeMessages(paramInt);
    if (this.jdField_a_of_type_Aytr$c != null)
    {
      Object localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList(1);
      }
      this.jdField_a_of_type_Aytr$c.c(paramInt, paramBoolean, (ArrayList)localObject);
    }
  }
  
  private void destroy()
  {
    if (this.mAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "destroy");
      }
      this.mAppInterface.unRegistObserver(this.jdField_a_of_type_Aytr$a);
      this.mAppInterface = null;
    }
    this.jdField_a_of_type_Aytr$c = null;
    if (this.cn != null) {
      this.cn.removeCallbacksAndMessages(null);
    }
  }
  
  public static void destroyInstance()
  {
    if (jdField_a_of_type_Aytr != null)
    {
      jdField_a_of_type_Aytr.destroy();
      jdField_a_of_type_Aytr = null;
    }
  }
  
  @TargetApi(19)
  public void Gh(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        Object localObject = BaseApplicationImpl.getApplication().getBaseContext();
        AppOpsManager localAppOpsManager = (AppOpsManager)((Context)localObject).getSystemService("appops");
        localObject = ((Context)localObject).getApplicationInfo();
        int i = localAppOpsManager.checkOpNoThrow("android:fine_location", ((ApplicationInfo)localObject).uid, ((ApplicationInfo)localObject).packageName);
        int j = localAppOpsManager.checkOpNoThrow("android:coarse_location", ((ApplicationInfo)localObject).uid, ((ApplicationInfo)localObject).packageName);
        if ((i == 0) && (j == 0))
        {
          bool1 = true;
          bool2 = bool1;
        }
      }
      catch (Exception localException1)
      {
        boolean bool1 = true;
        boolean bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LBSDetetor", 2, "something wrong:" + localException1.toString());
        bool2 = bool1;
        continue;
        bool2 = true;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("LBSDetetor", 2, "check permission by AppOpsManager:" + bool1);
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LBSDetetor", 2, "startCheckPermissionAndDetetLocation. hasPermission:" + bool2);
        }
        this.cn.removeMessages(paramInt);
        if (bool2)
        {
          this.cn.sendEmptyMessageDelayed(paramInt, 30000L);
          SosoInterface.a(new aytr.b(0, true, true, 30000L, false, false, "NewFlowCameraActivity", paramInt));
        }
        if (this.jdField_a_of_type_Aytr$c != null) {
          this.jdField_a_of_type_Aytr$c.bb(paramInt, bool2);
        }
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool1 = false;
    }
  }
  
  public void a(aytr.c paramc)
  {
    this.jdField_a_of_type_Aytr$c = paramc;
  }
  
  class a
    extends ayac
  {
    private a() {}
    
    public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBSDetetor", 2, "onGetLBSTemplateIds:" + paramBoolean + " req:" + paramInt);
      }
      if ((aytr.a(aytr.this) != null) && (aytr.a(aytr.this).hasMessages(paramInt))) {
        aytr.a(aytr.this, paramBoolean, paramArrayList, paramInt);
      }
    }
  }
  
  class b
    extends SosoInterface.a
  {
    private int ciG = -1;
    
    public b(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, int paramInt2)
    {
      super(paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
      this.ciG = paramInt2;
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        double d1 = paramSosoLbsInfo.a.cd;
        double d2 = paramSosoLbsInfo.a.ce;
        if (QLog.isColorLevel()) {
          QLog.d("LBSDetetor", 2, "onLocationUpdate() latitude=" + d1 + " longitude=" + d2);
        }
        aytr.a(aytr.this, d1, d2, this.ciG);
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("LBSDetetor", 2, "onLocationUpdate() error");
        }
      } while ((aytr.a(aytr.this) == null) || (!aytr.a(aytr.this).hasMessages(this.ciG)));
      aytr.a(aytr.this, false, null, this.ciG);
    }
  }
  
  public static abstract interface c
  {
    public abstract void bb(int paramInt, boolean paramBoolean);
    
    public abstract void c(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytr
 * JD-Core Version:    0.7.0.1
 */