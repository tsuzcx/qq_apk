import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.1;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.2;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.3;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class tzg
{
  private ubp a;
  public int bDo;
  protected int bDp = 0;
  private int bDq = -1;
  protected final Object bI = new Object();
  protected Map<String, tze> gZ;
  protected Map<Class<? extends tzh>, tzh> ha = new HashMap();
  private WeakReference<Activity> mActivityRef;
  public String mAppid;
  protected boolean mReleased;
  public String mUniqueKey;
  protected List<Object[]> qd = new ArrayList();
  
  public tzg(Activity paramActivity, int paramInt, String paramString)
  {
    this.mActivityRef = new WeakReference(paramActivity);
    this.bDo = paramInt;
    this.mAppid = paramString;
    this.mUniqueKey = (paramInt + "_" + paramString);
  }
  
  @UiThread
  private void b(String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    while (this.bDp != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "call api=" + paramString + ", param=" + paramJSONObject + ", cb=" + paramtzd);
    }
    if (!gY(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "app has no permission");
      }
      ubu.a(paramtzd, 3);
      return;
    }
    tze localtze = (tze)this.gZ.get(paramString);
    if (localtze == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "no such api");
      }
      ubu.a(paramtzd, 1);
      return;
    }
    if (!ubi.a().b(this.mUniqueKey, this.bDo, this.mAppid, paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.apiMgr", 2, "frequence restricted");
      }
      ubu.a(paramtzd, 8);
      return;
    }
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    a(localtze, paramString, paramtzd);
  }
  
  @UiThread
  private void b(tze paramtze, JSONObject paramJSONObject, tzd paramtzd)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {}
    tzh localtzh;
    do
    {
      return;
      localtzh = a(paramtze.q, true);
      if (localtzh == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.apiMgr", 2, "module load failed");
        }
        ubu.a(paramtzd, 2);
        return;
      }
      ubi.a().f(this.mUniqueKey, this.bDo, this.mAppid, paramtze.apiName);
    } while (localtzh.a(paramtze.bDm, paramtze.apiName, paramJSONObject, paramtzd));
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "module not handled this api");
    }
    ubu.a(paramtzd, 1);
  }
  
  private void bFc()
  {
    Iterator localIterator = this.ha.values().iterator();
    while (localIterator.hasNext()) {
      ((tzh)localIterator.next()).destroy();
    }
  }
  
  protected boolean Oy()
  {
    if (this.bDq == -1) {
      this.bDq = 0;
    }
    return this.bDq == 1;
  }
  
  protected abstract Map<String, tze> V();
  
  public abstract ajcn a();
  
  public <T extends tzh> T a(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject = (tzh)this.ha.get(paramClass);
    if ((localObject == null) && (paramBoolean) && (!this.mReleased)) {
      try
      {
        if (!this.mReleased)
        {
          tzh localtzh = (tzh)this.ha.get(paramClass);
          localObject = localtzh;
          if (localtzh == null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "create module " + paramClass.getSimpleName());
            }
            localtzh = tzi.a(paramClass, this);
            localObject = localtzh;
            if (localtzh != null)
            {
              this.ha.put(paramClass, localtzh);
              localObject = localtzh;
            }
          }
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  protected void a(int paramInt, tze paramtze, JSONObject paramJSONObject, tzd paramtzd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.apiMgr", 2, "onHandleAPIAuthorize " + paramInt);
    }
    if (paramInt == 0)
    {
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        b(paramtze, paramJSONObject, paramtzd);
        return;
      }
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.4(this, paramtze, paramJSONObject, paramtzd));
      return;
    }
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "auth not pass " + paramInt);
    ubu.a(paramtzd, paramInt);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, View.OnClickListener paramOnClickListener1, String paramString6, View.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramString3 = (Activity)this.mActivityRef.get();
    if ((paramString3 == null) || (paramString3.isFinishing()))
    {
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "showDialog activity is not valid");
      return;
    }
    this.a = new ubp(paramString3);
    this.a.uK(acfp.m(2131705217));
    this.a.setAppName(paramString1);
    this.a.uL(paramString4);
    this.a.uN(paramString6);
    this.a.uM(paramString5);
    this.a.s(paramOnClickListener1);
    this.a.t(paramOnClickListener2);
    this.a.setCancelListener(paramOnCancelListener);
    this.a.mm(paramString2);
    this.a.show();
    anot.a(null, "dc00898", "", "", "0X8009F79", "0X8009F79", 0, 0, "", "", "", "");
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    if (this.bDp != 2) {
      synchronized (this.bI)
      {
        if (this.bDp != 2)
        {
          if ((this.bDp == 3) || (this.bDp == 4))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DoraemonOpenAPI.apiMgr", 2, "appinfo error and can not retry");
            }
            ubu.a(paramtzd, ubu.eG(this.bDp));
            return;
          }
          this.qd.add(new Object[] { paramString, paramJSONObject, paramtzd });
          if (QLog.isColorLevel()) {
            QLog.i("DoraemonOpenAPI.apiMgr", 2, "permission not ready, add to queue api=" + paramString);
          }
          if (this.bDp != 1)
          {
            this.bDp = 1;
            QLog.i("DoraemonOpenAPI.apiMgr", 1, "retry loadAppInfo");
            bFd();
          }
          return;
        }
      }
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramString, paramJSONObject, paramtzd);
      return;
    }
    ThreadManager.getUIHandler().post(new DoraemonAPIManager.3(this, paramString, paramJSONObject, paramtzd));
  }
  
  protected abstract void a(tze paramtze, JSONObject paramJSONObject, tzd paramtzd);
  
  public void bF()
  {
    this.a.bFi();
  }
  
  protected abstract void bFd();
  
  protected boolean gY(String paramString)
  {
    boolean bool2 = a().cH.contains(paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (Oy())
      {
        Toast.makeText(BaseApplicationImpl.getContext(), acfp.m(2131705209) + paramString + acfp.m(2131705207), 0).show();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Activity getActivity()
  {
    return (Activity)this.mActivityRef.get();
  }
  
  public void init()
  {
    this.gZ = V();
    synchronized (this.bI)
    {
      this.bDp = 1;
      bFd();
      ubi.a().B(this.mUniqueKey, this.bDo, this.mAppid);
      if (BaseApplicationImpl.sProcessId != 1) {
        skj.a().bzj();
      }
      return;
    }
  }
  
  public void release()
  {
    for (;;)
    {
      try
      {
        this.mReleased = true;
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          bFc();
          if (BaseApplicationImpl.sProcessId != 1) {
            skj.a().bzk();
          }
          return;
        }
      }
      finally {}
      ThreadManager.getUIHandler().post(new DoraemonAPIManager.1(this));
    }
  }
  
  protected void zE(int paramInt)
  {
    QLog.i("DoraemonOpenAPI.apiMgr", 1, "onLoadAppInfo " + paramInt);
    for (;;)
    {
      synchronized (this.bI)
      {
        this.bDp = paramInt;
        ArrayList localArrayList = new ArrayList(this.qd);
        this.qd.clear();
        if (localArrayList.size() > 0)
        {
          if (paramInt == 2) {
            ThreadManager.getUIHandler().post(new DoraemonAPIManager.2(this, localArrayList));
          }
        }
        else {
          return;
        }
      }
      ??? = localObject2.iterator();
      while (((Iterator)???).hasNext())
      {
        Object[] arrayOfObject = (Object[])((Iterator)???).next();
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "load app info error, api=" + arrayOfObject[0]);
        ubu.a((tzd)arrayOfObject[2], ubu.eG(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tzg
 * JD-Core Version:    0.7.0.1
 */