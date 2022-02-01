import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class advm
{
  private static File aj;
  public long VF;
  public int cKp;
  private ConcurrentHashMap<String, aomg> eM = new ConcurrentHashMap();
  private AppInterface mApp;
  private ArrayList<WeakReference<advm.a>> uP = new ArrayList();
  
  static
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(acbn.bmC);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      aj = new File(localFile, "_dynamic");
      return;
    }
  }
  
  public advm(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    cUF();
  }
  
  private boolean afE()
  {
    long l = System.currentTimeMillis();
    if ((l - this.VF > 86400000L) || (l - this.VF < 0L)) {
      return true;
    }
    if (this.mApp != null)
    {
      advl localadvl = ((advr)this.mApp.getManager(180)).a();
      if (this.cKp + 1 > localadvl.cKm)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "isLoadCountSatisfy not satisfy.");
        }
        return false;
      }
      return true;
    }
    return true;
  }
  
  private void cUF()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).getString("dynamic_load_count_one_day", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("#");
      if ((localObject == null) || (localObject.length != 2)) {}
    }
    try
    {
      this.VF = Long.valueOf(localObject[0]).longValue();
      this.cKp = Integer.valueOf(localObject[1]).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void cUG()
  {
    this.cKp += 1;
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.VF >= 86400000L)
    {
      this.VF = System.currentTimeMillis();
      this.cKp = 0;
    }
    ThreadManager.executeOnFileThread(new DynamicAvatarDownloadManager.2(this, l));
  }
  
  public static File h(String paramString)
  {
    paramString = jY(paramString);
    return new File(aj, paramString);
  }
  
  public static String jY(String paramString)
  {
    return "cache_" + Utils.Crc64String(paramString) + ".mp4";
  }
  
  public static String jZ(String paramString)
  {
    return h(paramString).getAbsolutePath();
  }
  
  public static boolean lj(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = h(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        return true;
      }
    }
    return false;
  }
  
  public void a(advm.a parama)
  {
    for (;;)
    {
      synchronized (this.uP)
      {
        Iterator localIterator = this.uP.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (localWeakReference.get() != parama)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.uP.add(new WeakReference(parama));
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void b(advm.a parama)
  {
    synchronized (this.uP)
    {
      Iterator localIterator = this.uP.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == parama)) {
          localIterator.remove();
        }
      }
      return;
    }
  }
  
  public final void cUE()
  {
    Object localObject = this.eM.values();
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aomg localaomg = (aomg)((Iterator)localObject).next();
      if ((localaomg != null) && (this.mApp != null)) {
        this.mApp.getNetEngine(0).b(localaomg);
      }
    }
    this.eM.clear();
  }
  
  public final void dY(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (this.eM.containsKey(str))
        {
          aomg localaomg = (aomg)this.eM.get(str);
          if ((localaomg != null) && (this.mApp != null)) {
            this.mApp.getNetEngine(0).b(localaomg);
          }
          this.eM.remove(str);
        }
      }
    }
  }
  
  public boolean li(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    ??? = h(paramString);
    Iterator localIterator;
    WeakReference localWeakReference;
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile()))
    {
      synchronized (this.uP)
      {
        if (!this.uP.isEmpty())
        {
          localIterator = this.uP.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((advm.a)localWeakReference.get()).j(paramString, true, true);
            }
          }
        }
      }
      return true;
    }
    if ((!aqiw.isWifiConnected(BaseApplicationImpl.getContext())) && (!afE()))
    {
      synchronized (this.uP)
      {
        if (!this.uP.isEmpty())
        {
          localIterator = this.uP.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((advm.a)localWeakReference.get()).j(paramString, false, false);
            }
          }
        }
      }
      return false;
    }
    if (this.eM.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "url:" + paramString + " has contains");
      }
      return false;
    }
    ??? = new aoll();
    ((aoll)???).f = new advn(this);
    ((aoll)???).bZ = paramString;
    ((aoll)???).mHttpMethod = 0;
    ((aoll)???).atY = h(paramString).getPath();
    ((aoll)???).mContinuErrorLimit = 1;
    if (this.mApp != null)
    {
      this.mApp.getNetEngine(0).a((aomg)???);
      this.eM.put(paramString, ???);
      QLog.i("Q.dynamicAvatar", 2, "startDownloadDynamicAvatar, url: " + paramString + ", uin:" + this.mApp.getCurrentAccountUin());
    }
    return false;
  }
  
  public void onDestory()
  {
    cUE();
    this.uP.clear();
    this.mApp = null;
  }
  
  public static abstract interface a
  {
    public abstract void ei(String paramString, int paramInt);
    
    public abstract void j(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     advm
 * JD-Core Version:    0.7.0.1
 */