import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager.1;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class mfo
  implements Manager
{
  public static volatile boolean amn = true;
  protected int aRd = -1;
  private int aRe = -1;
  protected String agz = "";
  protected aqvc c;
  protected HashMap<String, String> ed = new HashMap();
  protected ArrayList<mfo.a> kS = new ArrayList();
  protected AppInterface mApp;
  protected boolean mIsShown;
  protected long mSeq = -1L;
  protected int mSource = -1;
  
  public mfo(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.c = ((aqva)paramAppInterface.getManager(47)).a(1);
  }
  
  public static RefreshData b(Context paramContext, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (mfo)((AppRuntime)localObject).getManager(270);
      if (localObject != null) {
        return ((mfo)localObject).a(paramContext, paramInt);
      }
    }
    return null;
  }
  
  private void c(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    this.aRd = paramInt1;
    this.agz = paramString;
    this.mSeq = paramLong;
    this.mSource = paramInt2;
    mgh.D(this.agz, paramLong);
    paramInt1 = 0;
    while (paramInt1 < this.kS.size())
    {
      ((mfo.a)this.kS.get(paramInt1)).b(this.aRd, this.agz, this.mSeq);
      paramInt1 += 1;
    }
  }
  
  public boolean Dy()
  {
    return (oH() == 1) && (mgh.ph() == 1);
  }
  
  public boolean Dz()
  {
    return this.mIsShown;
  }
  
  public RefreshData a(Context paramContext, int paramInt)
  {
    RefreshData localRefreshData = null;
    paramContext = aqmj.d(paramContext, this.mApp.getCurrentAccountUin(), paramInt);
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext != null) {
          localRefreshData = new RefreshData(paramContext);
        }
        return localRefreshData;
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      paramContext = null;
    }
  }
  
  public void a(mfo.a parama)
  {
    synchronized (this.kS)
    {
      if (!this.kS.contains(parama)) {
        this.kS.add(parama);
      }
      return;
    }
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt)
  {
    return a(paramRefreshData, 0, paramInt);
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt1, int paramInt2)
  {
    Object localObject = paramRefreshData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes start id = " + (String)localObject);
    }
    String str = mgh.eP((String)localObject);
    if (mgh.dU((String)localObject)) {
      return true;
    }
    if (this.ed.get("refresh_" + (String)localObject) != null) {
      return false;
    }
    aqhq.cn(str);
    this.ed.put("refresh_" + (String)localObject, paramRefreshData.url);
    str = str + ".zip";
    File localFile = new File(str);
    Bundle localBundle = new Bundle();
    localBundle.putString("refreshId", (String)localObject);
    localObject = new aquz(paramRefreshData.url, localFile);
    ((aquz)localObject).retryCount = paramInt1;
    ((aquz)localObject).atW = 60L;
    ((aquz)localObject).cWv = true;
    this.c.a((aquz)localObject, new mfp(this, str, paramRefreshData, paramInt2), localBundle);
    return false;
  }
  
  public void b(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      c(paramInt1, paramString, paramLong, paramInt2);
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyRefreshManager.1(this, paramInt1, paramString, paramLong, paramInt2));
  }
  
  public void b(mfo.a parama)
  {
    synchronized (this.kS)
    {
      this.kS.remove(parama);
      return;
    }
  }
  
  public void clearData()
  {
    this.aRd = -1;
  }
  
  public String jL()
  {
    return this.agz;
  }
  
  public void nQ(boolean paramBoolean)
  {
    this.mIsShown = paramBoolean;
  }
  
  public int oH()
  {
    return this.aRd;
  }
  
  public void onDestroy()
  {
    this.kS.clear();
    this.aRd = -1;
    amn = false;
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, String paramString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mfo
 * JD-Core Version:    0.7.0.1
 */