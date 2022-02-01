import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class wzl
{
  private SosoInterface.a c;
  protected String mQueueKey;
  private final ArrayList<wzl.b> qv = new ArrayList();
  private final ArrayList<wzl.b> qw = new ArrayList();
  private final ArrayList<wzl.a> qx = new ArrayList();
  
  public wzl(String paramString, long paramLong)
  {
    this.mQueueKey = paramString;
    this.c = new wzm(this, 3, true, true, paramLong, true, true, "ArkAppLocationManager");
  }
  
  public static boolean Sv()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1 = bool2;
    if (localBaseActivity != null)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23) {
        if ((localBaseActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) || (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
          break label68;
        }
      }
    }
    label68:
    for (bool1 = bool2;; bool1 = false)
    {
      ArkAppCenter.r("GetArkLocPermission", "CheckPermission is = " + bool1);
      return bool1;
    }
  }
  
  public void Destruct()
  {
    synchronized (this.qv)
    {
      this.qv.clear();
    }
    synchronized (this.qw)
    {
      this.qw.clear();
      SosoInterface.c(this.c);
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(wzl.a parama, boolean paramBoolean)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.qx)
    {
      this.qx.add(parama);
      if (paramBoolean)
      {
        cdz();
        return;
      }
    }
    SosoInterface.a(this.c);
  }
  
  public void a(wzl.b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.qv)
    {
      this.qv.add(paramb);
      cdz();
      return;
    }
  }
  
  public void b(wzl.b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.qw)
    {
      this.qw.add(paramb);
      cdz();
      return;
    }
  }
  
  public void cdy()
  {
    if ((this.qw.size() == 0) && (this.qx.size() == 0)) {
      SosoInterface.c(this.c);
    }
    synchronized (this.qv)
    {
      ArrayList localArrayList = new ArrayList(this.qv);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((wzl.b)((Iterator)???).next()).cdA();
      }
    }
    synchronized (this.qv)
    {
      this.qv.clear();
      return;
    }
  }
  
  protected void cdz()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (!Sv())
    {
      localBaseActivity.requestPermissions(new wzn(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    grant();
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    SosoInterface.a(this.c);
    ArkAppCenter.r("GetArkLocPermission", "CheckPermission location is denied");
  }
  
  @QQPermissionGrant(1)
  @TargetApi(23)
  public void grant()
  {
    SosoInterface.a(this.c);
    ArkAppCenter.r("GetArkLocPermission", "CheckPermission location is granted ");
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean, double paramDouble1, double paramDouble2);
    
    public abstract void cdA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wzl
 * JD-Core Version:    0.7.0.1
 */