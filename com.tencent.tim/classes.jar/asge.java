import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qg.loader.QGDownloader.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class asge
{
  private Map<String, List<asge.a>> mCallbackMap;
  public int mStatus;
  
  @NonNull
  static asge a()
  {
    return new asgi();
  }
  
  private void dH(String paramString, boolean paramBoolean)
  {
    paramString = (List)this.mCallbackMap.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        asge.a locala = (asge.a)paramString.next();
        if (paramBoolean) {
          locala.onSuccess();
        } else {
          locala.bbs();
        }
      }
    }
  }
  
  public final void a(String paramString, boolean paramBoolean, asge.a parama)
  {
    if (this.mCallbackMap == null) {
      this.mCallbackMap = new ConcurrentHashMap();
    }
    if (parama != null)
    {
      List localList = (List)this.mCallbackMap.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList(1);
      }
      parama.startTime = System.currentTimeMillis();
      ((List)localObject).add(parama);
      this.mCallbackMap.put(paramString, localObject);
    }
    dE(paramString, paramBoolean);
  }
  
  protected abstract void dE(String paramString, boolean paramBoolean);
  
  protected void dF(String paramString, boolean paramBoolean)
  {
    boolean bool = asgf.isSoLoaded.get();
    if (QLog.isColorLevel()) {
      QLog.d("QGDownloader", 2, new Object[] { "onSuccess. loadSo=", Boolean.valueOf(paramBoolean), ", soLoaded=", Boolean.valueOf(bool) });
    }
    this.mStatus = 0;
    dG(paramString, true);
    if (!paramBoolean)
    {
      dH(paramString, true);
      return;
    }
    if (!bool)
    {
      ThreadManagerV2.excute(new QGDownloader.1(this, paramString), 16, null, true);
      return;
    }
    dH(paramString, false);
  }
  
  protected void dG(String paramString, boolean paramBoolean)
  {
    paramString = (List)this.mCallbackMap.get(paramString);
    if ((paramString != null) && (!paramString.isEmpty())) {
      paramString = (asge.a)paramString.get(0);
    }
    for (long l = System.currentTimeMillis() - paramString.startTime;; l = 0L)
    {
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "0")
      {
        rar.b("video_game_tech", "qg_so_download", 0, 0, new String[] { String.valueOf(l), paramString });
        return;
      }
    }
  }
  
  protected void onFail(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGDownloader", 2, "onFail.");
    }
    this.mStatus = 1;
    dG(paramString, false);
    dH(paramString, false);
  }
  
  protected void onProgress(String paramString, int paramInt) {}
  
  public static abstract class a
  {
    long startTime;
    
    public abstract void bbs();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asge
 * JD-Core Version:    0.7.0.1
 */